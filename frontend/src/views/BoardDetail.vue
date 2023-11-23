<script setup>
import { ref, onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";
import { detailPost, deletePost } from "@/api/board";
import { useMemberStore } from "../stores/member";

const memberStore = useMemberStore();
const { userInfo, isLogin } = memberStore;

const route = useRoute();
const router = useRouter();

// const articleno = ref(route.params.articleno);
const { postId } = route.params;

const post = ref({});

onMounted(() => {
  getPost();
});

const getPost = () => {
  // const { articleno } = route.params;
  console.log(postId + "번글 얻으러 가자!!!");
  detailPost(
    postId,
    ({ data }) => {
      post.value = data;
    },
    (error) => {
      console.error(error);
    }
  );
};

function moveList() {
  router.push({ name: "board" });
}

function moveModify() {
  router.push({ name: "board-modify", params: { postId } });
}

function onDeletePost() {
  // const { articleno } = route.params;
  console.log(postId + "번글 삭제하러 가자!!!");
  deletePost(
    postId,
    (response) => {
      if (response.status == 200) moveList();
    },
    (error) => {
      console.error(error);
    }
  );
}
</script>

<template>
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-lg-10">
        <h2 class="my-3 py-3 shadow-sm bg-light text-center">
          <mark class="sky">글보기</mark>
        </h2>
      </div>
      <div class="col-lg-10 text-start">
        <div class="row">
          <h2 class="text-secondary">{{ post.title }}</h2>
        </div>
        <div class="clearfix align-content-center">
          <span>
            {{ post.authorName }}
            <img class="avatar me-2 float-md-start bg-light p-2"
              src="https://raw.githubusercontent.com/twbs/icons/main/icons/person-fill.svg" />
          </span>
          <q-space />
          <span class="text-secondary fw-light">
            {{ post.registerTime }}조회수 : {{ post.hit }}
          </span>
        </div>
        <hr />
        <div class="row">
          <div class="divider mb-3"></div>
          <div class="text-secondary">
            {{ post.content }}
          </div>
          <div class="divider mt-3 mb-3"></div>
          <div class="d-flex justify-content-end">
            <button type="button" class="btn btn-outline-primary mb-3" @click="moveList">
              글목록
            </button>
            <button v-show="isLogin && post.authorId == userInfo.memberId" type="button"
              class="btn btn-outline-success mb-3 ms-1" @click="moveModify">
              글수정
            </button>
            <button v-show="isLogin && post.authorId == userInfo.memberId" type="button"
              class="btn btn-outline-danger mb-3 ms-1" @click="onDeletePost">
              글삭제
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped></style>
