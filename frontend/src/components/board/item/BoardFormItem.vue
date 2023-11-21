<script setup>
import { ref, watch } from "vue";
import { useRoute, useRouter } from "vue-router";
import { writePost, getUpdatePost, updatePost } from "@/api/board";

const router = useRouter();
const route = useRoute();

const props = defineProps({ type: String });

const isUseId = ref(false);

const post = ref({
  regDate: "",
  modDate: "",
  postId: 0,
  authorId: 0,
  title: "",
  content: "",
  hit: 0
});

if (props.type === "modify") {
  const { postId } = route.params;
  console.log(postId + "번글 얻어와서 수정할거야");
  getUpdatePost(
    postId,
    ({ data }) => {
      console.log("수정할 정보 조회 data : "+ data)
      post.value = data;
      isUseId.value = true;
    },
    (error) => {
      console.error(error);
    }
  );
  isUseId.value = true;
}

const subjectErrMsg = ref("");
const contentErrMsg = ref("");
watch(
  () => post.value.title,
  (value) => {
    let len = value.length;
    if (len == 0 || len > 30) {
      subjectErrMsg.value = "제목을 확인해 주세요.(0~30자)";
    } else subjectErrMsg.value = "";
  },
  { immediate: true }
);
watch(
  () => post.value.content,
  (value) => {
    let len = value.length;
    if (len == 0 || len > 500) {
      contentErrMsg.value = "내용을 올바르게 입력해주세요.(0~500자)";
    } else contentErrMsg.value = "";
  },
  { immediate: true }
);

function onSubmit() {
  // event.preventDefault();

  if (subjectErrMsg.value) {
    alert(subjectErrMsg.value);
  } else if (contentErrMsg.value) {
    alert(contentErrMsg.value);
  } else {
    props.type === "regist" ? doWritePost() : doUpdatePost();
  }
}

function doWritePost() {
  console.log("글등록하자!!", post.value);
  writePost(
    post.value,
    (response) => {
      let msg = "글등록 처리시 문제 발생했습니다.";
      if (response.status == 201) msg = "글등록이 완료되었습니다.";
      alert(msg);
      moveList();
    },
    (error) => console.error(error)
  );
}

function doUpdatePost() {
  console.log(post.value.postId + "번글 수정하자!!", post.value);
  updatePost(
    post.value,
    (response) => {
      let msg = "글수정 처리시 문제 발생했습니다.";
      if (response.status == 200) msg = "글정보 수정이 완료되었습니다.";
      alert(msg);
      moveList();
      // router.push({ name: "article-view" });
      // router.push(`/board/view/${article.value.articleNo}`);
    },
    (error) => console.log(error)
  );
}

function moveList() {
  router.push({ name: "board" });
}
</script>

<template>
  <form @submit.prevent="onSubmit">
    <div class="mb-3">
      <label for="userid" class="form-label">작성자 ID : </label>
      <input
        type="text"
        class="form-control"
        name = "postId"
        v-model="post.postId"
        :disabled="isUseId"
        placeholder="작성자ID..."
      />
    </div>
    <div class="mb-3">
      <label for="subject" class="form-label" >제목 : </label>
      <input type="text" class="form-control" name = "title" v-model="post.title" placeholder="제목..." />
    </div>
    <div class="mb-3">
      <label for="content" class="form-label">내용 : </label>
      <textarea class="form-control" name = "content" v-model="post.content" rows="10"></textarea>
    </div>
    <div class="col-auto text-center">
      <p> {{ post }}</p>
      <button type="submit" class="btn btn-outline-primary mb-3" v-if="type === 'regist'">
        글작성
      </button>
      <button type="submit" class="btn btn-outline-success mb-3" v-else>글수정</button>
      <button type="button" class="btn btn-outline-danger mb-3 ms-1" @click="moveList">
        목록으로이동...
      </button>
    </div>
  </form>
</template>

<style scoped></style>
