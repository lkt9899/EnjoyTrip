<script setup>
import { ref } from 'vue';
const isLogin = ref(false);

</script>

<template>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid px-0 shadow-sm">
      <router-link to="/" class="navbar-brand px-2" id="jmt-logo">
        <img src="@/assets/logo.png" alt="logo" class="logo">
        <span class="text-align-center fs-1">ENJOY TRIP</span>
      </router-link>

      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#nav-collapse"
        aria-controls="nav-collapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="nav-collapse">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <router-link to="/notice" class="nav-link">공지 사항</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/board" class="nav-link">게시판</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/attraction" class="nav-link">관광지 검색</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/plan" class="nav-link">여행 계획</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/hotplace" class="nav-link">핫 플레이스</router-link>
          </li>
        </ul>

        <ul v-if="!isLogin" class="navbar-nav ms-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <router-link to="/register" class="nav-link">회원 가입</router-link>
          </li>
          <li class="nav-item">
            <!-- <button class="nav-link" @click="isLogin = !isLogin">로그인</button> -->
            <router-link to="/login" class="nav-link">로그인</router-link>
          </li>
        </ul>

        <ul v-else class="navbar-nav ms-auto mb-2 mb-lg-0">
          <li class="nav-item dropdown">
            <a class="nav-link dropdwon-toggle" role="button" id="user" data-bs-toggle="dropdown"
              aria-expanded="false">이경태</a>
            <ul class="dropdown-menu" aria-labelledby="user">
              <li>
                <router-link to="/info" class="nav-link">내 정보</router-link>
              </li>
              <li>
                <button class="nav-link" @click="isLogin = !isLogin">로그 아웃</button>
              </li>
            </ul>
          </li>
        </ul>
      </div>
    </div>
  </nav>
</template>

<style scoped>
.logo {
  height: 40px;
}

ul li {
  margin: 0 5px;
}

ul .nav-link {
  border-radius: 10px;
}

.nav-link:hover {
  background: grey;
}

ul li a.router-link-exact-active {
  color: white;
  background-color: black;
  font-weight: bold;
}
</style>