<script setup>
import { ref, onMounted } from 'vue';
import { statistics } from '@/api/util.js'

const datas = ref([]);

onMounted(() => {
    getStatistics();
});

const getStatistics = () => {
    console.log("서버에 통계값 요청");
    statistics(
        ({ data }) => {
            // console.log(data)
            datas.value = data;
        },
        (error) => {
            console.log(error);
        }
    )
};

</script>

<template>
    <div class="container justify-content-center">
        <div class="m-5">
            <h1 class="text-center">ENJOY TRIP</h1>
        </div>
        <div class="mx-5">
            <div class="d-flex flex-row justify-content-between">
                <div class="text-center mx-5">
                    <div class="data-number">
                        <h3>{{ datas.countOfAttraction }}</h3>
                    </div>
                    <div class="data-name">
                        <h6>등록된 관광지</h6>
                    </div>
                </div>
                <div class="text-center mx-5">
                    <div class="data-number">
                        <h3>{{ datas.countOfMember }}</h3>
                    </div>
                    <div class="data-name">
                        <h6>등록된 사용자</h6>
                    </div>
                </div>
                <div class="text-center mx-5">
                    <div class="data-number">
                        <h3>{{ datas.countOfPost }}</h3>
                    </div>
                    <div class="data-name">
                        <h6>등록된 게시글</h6>
                    </div>
                </div>
                <!-- <div class="text-center mx-5" v-for="data in datas" :key="data.name">
                    <div class="data-number">
                        <h3>{{ data.data }}</h3>
                    </div>
                    <div class="data-name">
                        <h6>등록된 {{ data.name }}</h6>
                    </div>
                </div> -->
            </div>
        </div>
    </div>
</template>

<style scoped></style>