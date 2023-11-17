<script setup>
import { ref, nextTick } from 'vue';
import { loginMember } from "@/api/member";
import router from '@/router';


const form = ref({
  id: '',
  password:'',
});
const show = ref(true);

const onSubmit = (event) => {
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
  
  <BForm @submit="onSubmit" @reset="onReset" v-if="show" method = "post">

    <!--아이디-->
    <BFormGroup
      id="input-group-1"
      label="아이디:"
      label-for="register-id"
    >
      <BFormInput
        id="register-id"
        name = "id"
        v-model="form.id"
        type="text"
        placeholder="아이디를 입력하세요."
        required
      />
    </BFormGroup>

    <!--비밀번호-->
    <BFormGroup 
      id="input-group-2"
      label="비밀번호:" 
      label-for="register-password">
      <BFormInput 
        id="register-password" 
        name = "password"
        v-model="form.password" 
        placeholder="비밀번호를 입력하세요." 
        required />
    </BFormGroup>

    <BButton type="submit" variant="primary">로그인</BButton>
  </BForm>
</template>
  
<style scoped></style>

