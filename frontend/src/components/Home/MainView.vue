<script setup>
import MainData from "./MainData.vue";
import MainMiddle from './MainMiddle.vue';
import 'vue-lite-youtube-embed/style.css'
</script>

<template>
    <div class="container-fluid px-0">
        
        <div style="padding-top: 0px; margin-top: 0px;"  >
            <video autoplay loop muted class="video-element" style="width:1280px; height: 680px;">
                <source  src="@/assets/palace.mp4" type="video/mp4" style="width: 100%;"/>
            </video>
        </div>
        <MainData />
        <MainMiddle />
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