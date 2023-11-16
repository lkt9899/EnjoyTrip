<script setup>
import { ref, onMounted, onUnmounted } from "vue";
import { getList } from "@/api/attraction";

import CardComponent from './CardComponent.vue';
import SearchBar from './SearchBar.vue';


const items = ref([]);

const requestParams = {
  searchCondition: {
    sidoCode: 1,
    gugunCode: 1,
    contentTypeId: 12
  },
  pagingInfo: {
    offset: 1,
    count: 5  // Adjust as needed
  }
};


const getAttractionList = () => {
  console.log("서버에서 itmes 얻어오자!!!");
  const lastItem = items.value[items.value.length - 1];
  const lastContentId = lastItem ? lastItem.contentId : 0;
  requestParams.pagingInfo.offset = lastContentId;
   
  getList(requestParams,
    ({data}) => {
       console.log(data)
      items.value = [...items.value, ...data];
   
   }, 
   (error) => {
    console.log(error)
   });
};

const scrollComponent = ref(null)

const loadMoreAttractions = () => {
  getAttractionList()
}

onMounted(() => {
  getAttractionList(); // params 정보로 attrationList를 가져온다.
  window.addEventListener("scroll", handleScroll)
});

onUnmounted(() => {
  window.removeEventListener("scroll", handleScroll)
})

const handleScroll = (e) => {

  let element = scrollComponent.value;
  const rect = element.getBoundingClientRect();
  const isAtBottom = rect.bottom <= window.innerHeight + 50;

  if (isAtBottom) {
    console.log("Scrolled to the bottom!");
    loadMoreAttractions()
  }
}


</script>

<template>
 <div class="container">
    <div class="row">
      <div class="searchbar">
        <search-bar></search-bar>
      </div>
    </div>
    <div class="row" ref="scrollComponent">
        <card-component 
        v-for="(item, index) in items"
         :item = "item"
         :index = "index"
         :key="item.contentId">
        </card-component>
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