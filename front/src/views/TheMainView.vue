<script setup>
import MainTop from '@/components/main/MainTop.vue';
import MainMiddle from '@/components/main/MainMiddle.vue';
</script>

<template>
  <div class="container text-center mt-3">
    <router-view>
      <main-top></main-top>
      <main-middle></main-middle>
    </router-view>
  </div>
</template>

<style scoped></style>
