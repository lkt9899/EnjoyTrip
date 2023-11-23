<script setup>
import { ref, onMounted } from 'vue';
import { listSido, listGugun, listContent } from "@/api/map";

const sidoList = ref([]);
const gugunList = ref([]);
const contentTypeList = ref([]);

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
}
</script>

<template>
    <div class="d-flex flex-row mb-2 justify-content-start my-inputs">
        <div class="d-flex col-2 mx-2">
            <VSelect :selectOption="sidoList" @onKeySelect="onChangeSido" />
        </div>
        <div class="d-flex col-2 mx-2">
            <VSelect :selectOption="gugunList" @onKeySelect="onChangeGugun" />
        </div>
        <div class="d-flex col-2 mx-2">
            <VSelect :select-option="contentTypeList" @on-key-select="onChangeContentType" />
        </div>
        <div class="d-flex col-2 mx-2">
            <input v-model="param.searchCondition.keyword" type="text" class="w-100">
        </div>
        <div class="col-2 mx-2">
            <q-btn flat :icon="'search'" @click="$emit('updateAttraction', param)"></q-btn>
        </div>
    </div>
</template>

<style scoped>
.my-inputs {
    height: 30px;
}
</style>