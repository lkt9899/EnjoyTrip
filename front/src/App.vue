<script setup>
import { RouterView } from "vue-router";
import NavbarVue from './layout/Navbar.vue';
// import MainTop from './components/main/MainTop.vue';
// import MainMiddle from './components/main/MainMiddle.vue';
</script>


<template>


  <v-app>
    <navbar-vue></navbar-vue>
    
    <!-- <main-top></main-top>
    <main-middle></main-middle> -->
    <router-view></router-view>
  </v-app>

</template>

<style scoped>

</style>
