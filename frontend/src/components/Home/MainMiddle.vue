<script setup>
import { ref, onMounted, onUnmounted } from "vue";
import { getList } from "@/api/attraction";

const items = ref([]);
const scrollComponent = ref(null)
const isInitCall = ref(true)

const requestParams = {
  searchCondition: {
    sidoCode: 1,
    gugunCode: 1,
    contentTypeId: 12,
    keyword: ""
  },
  pagingInfo: {
    lastItemId: 0,
    count: 5  // Adjust as needed
  }
};


const getAttractionList = () => {
  console.log("서버에서 itmes 얻어오자!!!");
  const lastItem = items.value[items.value.length - 1];
  const lastContentId = lastItem ? lastItem.contentId : 0;
  requestParams.pagingInfo.lastItemId = lastContentId;

  getList(requestParams,
    ({ data }) => {
      console.log(data)
      items.value = [...items.value, ...data];

    },
    (error) => {
      console.log(error)
    });
};


const loadMoreAttractions = () => {
  getAttractionList();
}

const debounce = (func, delay) => {
  let timeoutId;
  return (...args) => {
    clearTimeout(timeoutId);
    timeoutId = setTimeout(() => {
      func(...args);
    }, delay);
  };
};

const handleScroll = debounce(() => {

  isInitCall.value = false;

  let element = scrollComponent.value;
  const rect = element.getBoundingClientRect();
  const isAtBottom = rect.bottom <= window.innerHeight + 5;

  if (isAtBottom) {
    console.log("Scrolled to the bottom!");
    loadMoreAttractions();
  }
}, 200);

onMounted(() => {
  console.log("isInitCall" + isInitCall.value);
  if (isInitCall.value) getAttractionList(); // params 정보로 attrationList를 가져온다.

  window.addEventListener("scroll", handleScroll)
});

onUnmounted(() => {
  window.removeEventListener("scroll", handleScroll)
})


</script>

<template>
  <div class="container">
    <div class="row">
      <div class="searchbar">
        <search-bar></search-bar>
      </div>
    </div>
    <div class="row" ref="scrollComponent">
      <q-card-component v-for="attraction in items" :key="attraction.contentId" :item="attraction" :type="'at'"
        :alt-img="'images'" />
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

.searchbar,
.card {
  margin: 5px;

}

.card {
  flex: 1 0 21%;
  flex-basis: 21%;
  /* 카드의 기본 너비를 설정하여 사이즈가 일정하게 보이도록 설정 */
  max-width: 240px;
}
</style>