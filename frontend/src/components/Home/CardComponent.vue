<script setup>
defineProps({
  item: Object
});
</script>

<template>
  <div class="card">
    <img :src="item.firstImage" alt="image description" />
    <div class="card-content">
      <h4>{{ item.title }}</h4>
      <p>Card Description</p>
    </div>
  </div>
</template>

<style scoped>
.card {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  border: 1px solid #000;
  padding: 10px;
  margin: 10px;
}

.card-content {
  width: 100%;
}

.card img {
  width: 100%;
  height: auto;
}
</style>