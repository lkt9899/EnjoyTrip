<script setup>
    
</script>

<template>
    <div class="container">
        <div @click="changeToggle" class="searchTitle">
            <input type="text" class="searchTitle-text" placeholder="검색 조건을 설정해주세요 "/>
            <div class="searchTitle-icon">
                <img src="@/assets/search_icon.png"/>
            <!-- <v-icon icon="mdi-triangle-down" size="18px" color="white"></v-icon> -->
            </div>
        </div>
    </div>
    
<!-- <div class="searchbar">
    <input type="text" placeholder="Search..." />
  </div> -->
</template>

<style scoped>
.container{
    height: 100%;
    width: 100%;
    min-width: 400px;
    display: flex;

}
.searchTitle {
  height: 30px;
  width: 100%;
  display: flex;
  align-items: center;
  border: 1px solid var(--primary);
  border-radius: 5px;
  background-color: #DBEEFF;
  color: black;
}
.searchTitle:hover {
  background-color: #BBDDFD;
  color: black;
}
.searchTitle-text {
  width: 90%;
  height: 100%;
  display: flex;
  padding: 10px;
  justify-content: flex-start;
  align-items: center;
  font-size: 13px;
  font-weight: normal;
  color: #838383;
}
.searchTitle-icon {
  width: 15%;
  height: 100%;
  border-top-right-radius: 3px;
  border-bottom-right-radius: 3px;
  display: flex;
  justify-content: center;
  align-items: center;
}
.searchTitle-icon img{
    width: 50%;
    height: 80%;
}

.searchbar {
  display: flex;
  justify-content: center;
  margin: 10px;
}

.searchbar input {
  width: 100%;
  padding: 10px;
  font-size: 16px;
}
</style>