<script setup>
import MainData from "./MainData.vue";
</script>

<template>
    <div class="container-fluid px-0">
        <div class="bg-image">
            <img class="bg-img" src="@/assets/background.jpg" alt="back">
        </div>
        <MainData />
    </div>
</template>

<style scoped>
.bg-img {
    height: 75vh;
    width: 100%;

    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
}
</style>