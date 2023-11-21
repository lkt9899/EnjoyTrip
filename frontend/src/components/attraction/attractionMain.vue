<script setup>
import { ref, onMounted } from "vue";
import { getList } from '@/api/attraction';
import { listSido, listGugun } from "@/api/map";

import VKakaoMap from "@/components/common/VKakaoMap.vue";
import VSelect from '@/components/common/VSelect.vue';

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
        "offset": 0,
        "count": 10
    }
});

onMounted(() => {
    getSidoList();
});

const getContentTypeList = () => {
    
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
    getAttractions();
};

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
    <div>
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
        <VKakaoMap :attractions="attractions" :selectAttraction="selectAttraction" />
        <table class="table table-hover">
            <thead>
                <tr class="text-center">
                    <th scope="col">관광지 명</th>
                    <th scope="col">이미지</th>
                    <th scope="col">위치</th>
                    <th scope="col">위도</th>
                    <th scope="col">경도</th>
                </tr>
            </thead>
            <tbody>
                <tr class="text-center" v-for="attraction in attractions" :key="attraction.contentId"
                    @click="viewAttraction(attraction)">
                    <th>{{ attraction.title }}</th>
                    <td><img :src="attraction.firstImage" alt="" width="300"></td>
                    <td>{{ attraction.addr1 }}</td>
                    <td>{{ attraction.latitude }}</td>
                    <td>{{ attraction.longitude }}</td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<style scoped></style>