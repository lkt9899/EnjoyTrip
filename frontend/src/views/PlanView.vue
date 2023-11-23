<script setup>
import { ref } from 'vue';
import { getList } from '@/api/attraction';

import VKakaoMap from "@/components/common/VKakaoMap.vue";

const drawer = ref(false);

const attractions = ref([]);
const selectAttraction = ref({});

const param = ref({
    searchCondition: {
        "sidoCode": "",
        "gugunCode": "",
        "contentTypeId": "",
        "keyword": ""
    },

    pagingInfo: {
        "lastItemId": 0,
        "count": 30
    }
});

const setAttraction = (data) => {
    param.value = data;
    getAttractions();
    drawer.value = true;
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
        <q-drawer v-model="drawer" :width="200" :breakpoint="500" bordered
            :class="$q.dark.isActive ? 'bg-grey-9' : 'bg-grey-3'">
            <q-scroll-area class="fit">
                <q-list>
                    <template v-for="attraction in attractions" :key="attraction.contentId">
                        <q-item @click="viewAttraction(attraction)" clickable v-ripple>
                            <q-card-component :item="attraction" />
                        </q-item>
                    </template>
                </q-list>
            </q-scroll-area>
        </q-drawer>

        <q-page-container>
            <q-page padding>
                <search-location @updateAttraction="setAttraction" />
                <VKakaoMap :attractions="attractions" :selectAttraction="selectAttraction" />
            </q-page>
        </q-page-container>
    </q-layout>
</template>

<style scoped></style>