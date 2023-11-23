<script setup>
import { ref } from 'vue';
import { loginMember } from "@/api/member";
import router from '@/router';


const form = ref({
  id: '',
  password: '',
});

const onSubmit = () => {
  // alert(JSON.stringify(form));
  callLoginMember();
};

function callLoginMember() {
  loginMember(
    form.value,
    (response) => {
      let msg = "로그인에 실패했습니다.";
      if (response.status == 200) msg = "로그인 성공.";
      alert(msg);
      moveMain();
    },
    (error) => {
      console.log(error)
    }
  );
}

function moveMain() {
  router.push({ name: "home" });
}
</script>

<template>
  <div class="d-flex container" style="height: 600px">
    <div class="d-flex w-50 h-50 m-auto border border-3">
      <q-form @submit="onSubmit" @reset="onReset" class="w-75 m-auto">
        <q-input class="ms-0" filled v-model="form.id" label="아이디" hint="Name and surname" lazy-rules
          :rules="[val => val && val.length > 0 || 'Please type something']" />
        <q-input class="ms-0" filled type="password" v-model="form.password" label="비밀번호" />

        <div class="d-flex justify-content-end my-buttons mt-2">
          <q-btn label="Submit" type="submit" color="primary" />
          <q-btn label="Reset" type="reset" color="primary" flat class="q-ml-sm" />
        </div>
      </q-form>
    </div>
  </div>
</template>
  
<style scoped>
.my-buttons {
  padding-right: 12px;
}

i {
  justify-content: end;
}
</style>

