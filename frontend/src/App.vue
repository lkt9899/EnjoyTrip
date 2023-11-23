<script setup>
import NavBar from "@/components/layout/NavBar.vue";
import { RouterView } from 'vue-router'
import MyFooter from "@/components/layout/MyFooter.vue";
</script>

<template>
  <!-- <div class="container"> -->
    <NavBar />
    <RouterView />
    <MyFooter />
  <!-- </div> -->
</template>

<style scoped></style>
