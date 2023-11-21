<script setup>
import BoardList from '../components/board/BoardList.vue';
</script>

<template>
  <div class="container text-center mt-3">
    <div class="alert alert-info" role="alert">자유롭게 글쓰는 공간이당</div>
    <BoardList></BoardList>
  </div>
  
</template>

<style>
mark.sky {
  background: linear-gradient(to top, #54fff9 20%, transparent 30%);
}
</style>
