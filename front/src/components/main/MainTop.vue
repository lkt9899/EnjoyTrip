<script setup>
import { ref, onMounted } from "vue";
// import { useRouter } from "vue-router";
</script>

<template>
    <div class="container">
        <div class="top_container">
            <img src="@\assets\background1.png" >
        </div>
        <div class="middle-container">
            <div class="vertical-item">
                <h1>쎄게 일주</h1>
            </div>
            <div class="vertical-item">
                <div class="horizontal-container">
                    
                    <div class="horizontal-item">
                        <div class="statistics-container">
                            <div class="number">
                                <h3>12,000</h3>
                            </div>
                            <div class="number-detail">
                                <h6>등록된 관광지</h6>
                            </div>
                        </div>
                    </div>
                    <div class="horizontal-item">
                        <div class="statistics-container">
                            <div class="number">
                                <h3>12,000</h3>
                            </div>
                            <div class="number-detail">
                                <h6>등록된 관광지</h6>
                            </div>
                        </div>
                    </div>
                    <div class="horizontal-item">
                        <div class="statistics-container">
                            <div class="number">
                                <h3>12,000</h3>
                            </div>
                            <div class="number-detail">
                                <h6>등록된 관광지</h6>
                            </div>
                        </div>
                    </div>
                    <div class="horizontal-item">
                        <div class="statistics-container">
                            <div class="number">
                                <h3>12,000</h3>
                            </div>
                            <div class="number-detail">
                                <h6>등록된 관광지</h6>
                            </div>
                        </div>
                    </div>
                    <div class="horizontal-item">
                        <div class="statistics-container">
                            <div class="number">
                                <h3>12,000</h3>
                            </div>
                            <div class="number-detail">
                                <h6>등록된 관광지</h6>
                            </div>
                        </div>
                    </div>
                </div>
                <!--horizontal-container end-->
            </div>
        </div>
    </div>
</template>

<style scoped>
.container{
    display: flex;
    flex-direction: column;
    width: 100%;
    /* height: 150px; */
    flex-shrink: 0;
    height: auto; 

}
.container img {
            width: 100%; /* 이미지의 최대 너비를 부모 요소의 100%로 설정 */
            height: auto; /* 높이를 자동으로 조정하여 원래의 가로세로 비율 유지 */
            display: block; /* 이미지 간의 여백 제거 */
        }
.middle-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

.vertical-item {
  /* margin: 50px; */
  margin: 20px 0; /* 수정된 부분 */
}

.horizontal-container {
  display: flex;
  flex-direction: row;
  justify-content: space-around;
}

.horizontal-item {
  margin: 10px;
}  
.statistics-container{
    margin-right: 20px;
}     
</style>