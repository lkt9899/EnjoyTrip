<script setup/>
<template>
  <nav class="layout_navbar">
    <div class="layout_container">
      <div class="navbar-left">
        <img src="@/assets/ssafy_logo.png" alt="Logo" class="logo" />
        <a href="#" class="navbar-link">공지사항</a>
        <a href="#" class="navbar-link">여행지검색</a>
        <a href="#" class="navbar-link">핫플레이스</a>
        <a href="#" class="navbar-link">게시판</a>
      </div>
      <div class="navbar-right">
        <a href="#" class="navbar-link">로그인</a>
        <a href="#" class="navbar-link">회원가입</a>
      </div>
    </div>
  </nav>
</template>

<style>
.layout_navbar {
  display: flex;
  align-items: center;
  background-color: white;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  height: 72px; /* 기존 높이의 1.2배로 설정 */
}

.layout_container {
  max-width: 1200px;
  margin: 0 auto;
  padding: 0 20px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  height: 100%; /* 부모인 .layout_navbar의 높이를 상속받기 위해 100%로 설정 */
  width: 100%;
}

.navbar-left {
  flex: none;
  display: flex;
  align-items: center;
  height: 100%; /* 부모인 .layout_container의 높이를 상속받기 위해 100%로 설정 */
}

.logo {
  width: 40px;
  height: 40px;
  margin-right: 10px;
}

.title {
  font-size: 20px;
  font-weight: bold;
  color: #0078d4;
}

.navbar-right {
  display: flex;
  height: 100%; /* 부모인 .layout_container의 높이를 상속받기 위해 100%로 설정 */
  align-items: center;
  margin-left: auto;
}

.navbar-link {
  margin-left: 20px;
  font-size: 16px;
  color: #333;
  text-decoration: none;
}

.navbar-link:hover {
  color: #0078d4;
}
</style>
