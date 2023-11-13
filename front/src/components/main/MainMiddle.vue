<script setup>
import { ref, onMounted } from "vue";
import { getList } from "@/api/attraction";

import CardComponent from './CardComponent.vue';
import SearchBar from './SearchBar.vue';

const items = ref([]);

const getArticleList = () => {
  console.log("서버에서 itmes 얻어오자!!!");
  // API 호출
   
  getList( 
    ({data}) => {
       console.log(data)
       items.value = data;
   
   }, 
   (error) => {
    console.log(error)
   });
};

onMounted(() => {
  getArticleList();
});


</script>

<template>
 <div class="container">
    <div class="row">
      <div class="searchbar">
        <search-bar></search-bar>
      </div>
    </div>
    <div class="row">
      <!-- <div class="card"> -->
        <card-component 
        v-for="(item, index) in items"
         :item = "item"
         :index = "index"
         :key="item.contentId">
        </card-component>
      <!-- </div> -->
    </div>
  </div>
</template>

<style scoped>
.container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

.row {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  /* justify-content: space-around; */
}

.searchbar, .card {
  margin: 5px;
  
}

.card{
    flex: 1 0 21%;
    flex-basis: 21%; /* 카드의 기본 너비를 설정하여 사이즈가 일정하게 보이도록 설정 */
    max-width: 240px;
}
</style>