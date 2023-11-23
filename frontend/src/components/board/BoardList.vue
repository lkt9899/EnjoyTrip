<script setup>
import { ref, onMounted } from "vue";
// import { onBeforeRouteUpdate } from 'vue-router'
import { useRouter } from "vue-router";
import { PostList } from "@/api/board.js";
// import VSelect from "@/components/common/VSelect.vue";
import BoardListItem from "@/components/board/item/BoardListItem.vue";

import { useMemberStore } from "../../stores/member";

const memberStore = useMemberStore();
const { userInfo, isLogin } = memberStore;

const router = useRouter();

// const selectOption = ref([
//   { text: "검색조건", value: "" },
//   { text: "글번호", value: "article_no" },
//   { text: "제목", value: "subject" },
//   { text: "작성자아이디", value: "user_id" },
// ]);

const posts = ref([]);
const hasNext = ref(null);
const hasPrev = ref(null);

// const { VITE_ARTICLE_LIST_SIZE } = import.meta.env;

const param = ref({
  // firstItemId : 7
  lastItemId: 0,
  //   key: "",
  //   word: "",
});


// const changeKey = (val) => {
//   console.log("BoarList에서 선택한 조건 : " + val);
//   param.value.key = val;
// };
onMounted(() => {
  getPostList();
});

const getPostList = () => {
  console.log("서버에서 글목록 얻어오자!!!", param.value);
  PostList(
    param.value,
    ({ data }) => {
      posts.value = data.list;
      hasNext.value = data.hasNext;
      hasPrev.value = data.hasPrev;
    },
    (error) => {
      console.log(error);
    }
  )
};

const goNextPage = () => {
  console.log("서버에서 next 버튼 데이터 얻어오자!!!");
  const lastItem = posts.value[posts.value.length - 1];
  const lastItemId = lastItem ? lastItem.postId : 0;
  param.value.lastItemId = lastItemId;
  console.log(lastItem.postId)
  param.value.firstItemId = -1;
  getPostList();
}

const goPrevPage = () => {
  console.log("서버에서 prev 버튼 데이터 얻어오자!!!");
  param.value.firstItemId = posts.value[0].postId;
  param.value.lastItemId = -1;
  getPostList();
}

// const onPageChange = (val) => {
//   console.log(val + "번 페이지로 이동 준비 끝!!!");
//   currentPage.value = val;
//   param.value.pgno = val;
//   getArticleList();
// };

const moveWrite = () => {
  if (!isLogin) {
    alert("로그인이 필요한 페이지 입니다 !");
    router.push({ name: "login" });
  } else {
    router.push({ name: "board-write" });
  }
};
</script>

<template>
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-lg-10">
        <div class="row align-self-center mb-2">
          <div class="col-md-2 text-start">
            <button type="button" class="btn btn-outline-primary btn-sm" @click="moveWrite">
              글쓰기
            </button>
          </div>
          <!-- <div class="col-md-5 offset-5">
            <form class="d-flex">
              <VSelect :selectOption="selectOption" @onKeySelect="changeKey" />
              <div class="input-group input-group-sm ms-1">
                <input
                  type="text"
                  class="form-control"
                  v-model="param.word"
                  placeholder="검색어..."
                />
                <button class="btn btn-dark" type="button" @click="getArticleList">검색</button>
              </div>
            </form>
          </div> -->
        </div>
        <table class="table table-hover">
          <thead>
            <tr class="text-center">
              <th scope="col">글번호</th>
              <th scope="col">제목</th>
              <th scope="col">작성자</th>
              <th scope="col">조회수</th>
            </tr>
          </thead>
          <tbody>
            <BoardListItem v-for="post in posts" :key="post.postId" :post="post"></BoardListItem>
          </tbody>
        </table>
      </div>
      <div class="row">
        <ul class="pagination justify-content-center">
          <li class="page-item">
            <a class="page-link" @click="goPrevPage()" :class="{ 'disabled': !hasPrev }" :aria-disabled="!hasPrev">이전</a>
          </li>
          <li class="page-item">
            <a class="page-link" @click="goNextPage()" :class="{ 'disabled': !hasNext }" :aria-disabled="!hasNext">다음</a>
          </li>
        </ul>
      </div>
    </div>
  </div>
</template>

<style scoped></style>
