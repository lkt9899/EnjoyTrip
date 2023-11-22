<script setup>
import { ref, onMounted } from 'vue';
import { getList } from '@/api/attraction';
import { listSido, listGugun, listContent } from "@/api/map";

import VSelect from '@/components/common/VSelect.vue';
import VKakaoMap from "@/components/common/VKakaoMap.vue";

const menuList = [
    {
        icon: 'inbox',
        label: 'Inbox',
        separator: true
    },
    {
        icon: 'send',
        label: 'Outbox',
        separator: false
    },
    {
        icon: 'delete',
        label: 'Trash',
        separator: false
    },
    {
        icon: 'error',
        label: 'Spam',
        separator: true
    },
    {
        icon: 'settings',
        label: 'Settings',
        separator: false
    },
    {
        icon: 'feedback',
        label: 'Send Feedback',
        separator: false
    },
    {
        icon: 'help',
        iconColor: 'primary',
        label: 'Help',
        separator: false
    }
];

const drawer = ref(false);

const sidoList = ref([]);
const gugunList = ref([]);
const contentTypeList = ref([]);

const attractions = ref([]);
const selectAttraction = ref({});

const param = ref({
    searchCondition: {
        "sidoCode": 1,
        "gugunCode": 1,
        "contentTypeId": 12
    },

    pagingInfo: {
        "lastItemId": 0,
        "count": -1
    }
});

onMounted(() => {
    getSidoList();
    getContentTypeList();
});

const getContentTypeList = () => {
    listContent(
        ({ data }) => {
            let options = [];
            options.push({ text: "유형 선택", value: "" });
            data.forEach((content) => {
                options.push({ text: content.contentTypeName, value: content.contentTypeId });
            });
            contentTypeList.value = options;
        },
        (err) => {
            console.log(err);
        }
    )
}

const getSidoList = () => {
    listSido(
        ({ data }) => {
            let options = [];
            options.push({ text: "시도 선택", value: "" });
            data.forEach((sido) => {
                options.push({ text: sido.sidoName, value: sido.sidoCode });
            });
            sidoList.value = options;
        },
        (err) => {
            console.log(err);
        }
    );
};

const onChangeSido = (val) => {
    param.value.searchCondition.sidoCode = val;
    listGugun(
        { sidoCode: val },
        ({ data }) => {
            let options = [];
            options.push({ text: "구군 선택", value: "" });
            data.forEach((gugun) => {
                options.push({ text: gugun.gugunName, value: gugun.gugunCode });
            });
            gugunList.value = options;
        },
        (err) => {
            console.log(err);
        }
    );
};

const onChangeGugun = (val) => {
    param.value.searchCondition.gugunCode = val;
    param.value.zscode = val;
};

const onChangeContentType = (val) => {
    param.value.searchCondition.contentTypeId = val;
    getAttractions();
}

const getAttractions = () => {
    getList(
        param.value,
        ({ data }) => {
            attractions.value = data;
        },
        (err) => {
            console.log(err);
        }
    );
};

const viewAttraction = (attraction) => {
    selectAttraction.value = attraction;
};

</script>

<template>
    <q-layout view="hHh Lpr lff" container style="height: 730px" class="shadow-2 rounded-borders">
        <q-drawer v-model="drawer" show-if-above :width="200" :breakpoint="500" bordered
            :class="$q.dark.isActive ? 'bg-grey-9' : 'bg-grey-3'">
            <q-scroll-area class="fit">
                <q-list>
                    <template v-for="attraction in attractions" :key="attraction.contentId">
                        <q-item @click="viewAttraction(attraction)" clickable v-ripple>
                            <q-item-section avatar>
                                <q-img :src="attraction.firstImage" width="200" />
                            </q-item-section>
                            <q-item-section>
                                {{ attraction.title }}
                            </q-item-section>
                        </q-item>
                        <q-separator />
                    </template>
                </q-list>
            </q-scroll-area>
        </q-drawer>

        <q-page-container>
            <div class="d-flex flex-row mb-2 justify-content-start">
                <div class="col-2">
                    <VSelect :selectOption="sidoList" @onKeySelect="onChangeSido" />
                </div>
                <div class="col-2">
                    <VSelect :selectOption="gugunList" @onKeySelect="onChangeGugun" />
                </div>
                <div class="col-2">
                    <VSelect :select-option="contentTypeList" @on-key-select="onChangeContentType" />
                </div>
            </div>
            <q-page padding>
                <VKakaoMap :attractions="attractions" :selectAttraction="selectAttraction" />
            </q-page>
        </q-page-container>
    </q-layout>
</template>

<style scoped></style>