<script setup>
import { ref } from 'vue';

const datas = ref([
    {
        name: "관광지",
        data: 12000
    },
    {
        name: "사용자",
        data: 5948
    },
    {
        name: "게시글",
        data: 3786
    }
]);

</script>

<template>
    <div class="container justify-content-center">
        <div class="m-5">
            <h1 class="text-center">ENJOY TRIP</h1>
        </div>
        <div class="mx-5">
            <div class="d-flex flex-row justify-content-between">
                <div class="text-center mx-5" v-for="data in datas" :key="data.name">
                    <div class="data-number">
                        <h3>{{ data.data }}</h3>
                    </div>
                    <div class="data-name">
                        <h6>등록된 {{ data.name }}</h6>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<style scoped></style>