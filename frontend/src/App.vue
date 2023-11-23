<script setup>
import NavBar from "@/components/layout/NavBar.vue";
import { RouterView } from 'vue-router'
import MyFooter from "@/components/layout/MyFooter.vue";
</script>

<template>
  <div class="container-fluid px-0">
    <NavBar />
    <RouterView />
    <MyFooter />
  </div>
</template>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Hi+Melody&display=swap');

* {
  font-family: 'Hi Melody', cursive;
}
</style>
