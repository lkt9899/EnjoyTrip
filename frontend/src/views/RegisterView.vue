<script setup>
import { ref } from 'vue';
import { registerMember } from "@/api/member";
import { useRouter } from "vue-router";


const router = useRouter();

const form = ref({
  id: '',
  password: '',
  name: '',
  age: '',
  phoneNumber: '',
  //food: null,
  gender: '', // 성별
});
const show = ref(true);

const onReset = () => {
  // event.preventDefault();
  form.value.email = '';
  form.value.name = '';
  form.value.age = '';
  form.value.phoneNumber = '';
  form.value.gender = '';
  // Trick to reset/clear native browser form validation state
  // show.value = false;
  // nextTick(() => {
  //   show.value = true;
  // });
};

const onSubmit = () => {
  // event.preventDefault();
  // alert(JSON.stringify(form));
  callRegisterMember();
};

function callRegisterMember() {
  registerMember(
    form.value,
    (response) => {
      let msg = "회원 가입 처리시 문제 발생했습니다.";
      if (response.status == 201) msg = "회원가입이 완료되었습니다.";
      alert(msg);
      moveMain();
    },
    (error) => console.log(error)
  );
}

function moveMain() {
  router.push({ name: "home" });
}
</script>

<template>
  <div class="d-flex container" style="height: 1000px">
    <BForm @submit="onSubmit" @reset="onReset" v-if="show" method="post">
      <!--이름-->
      <BFormGroup id="input-group-1" label="이름:" label-for="register-name">
        <BFormInput id="register-name" name="name" v-model="form.name" type="text" placeholder="이름을 입력하세요." required />
      </BFormGroup>
      <!--나이 -->
      <BFormGroup id="input-group-1" label="나이:" label-for="register-age">
        <BFormInput id="register-age" name="age" v-model="form.age" type="text" placeholder="숫자를 입력하세요." required />
      </BFormGroup>
      <!--성별-->
      <BFormGroup id="input-group-4" label="성별을 선택하세요.">
        <BFormRadioGroup v-model="form.gender" id="register-gender" name="gender">
          <BFormRadio value="M">남성</BFormRadio>
          <BFormRadio value="F">여성</BFormRadio>
        </BFormRadioGroup>
      </BFormGroup>
      <!--전화번호-->
      <BFormGroup id="input-group-1" label="전화번호:" label-for="register-phoneNumber">
        <BFormInput id="register-phoneNumber" name="phoneNumber" v-model="form.phoneNumber" type="text"
          placeholder="-를 포함하지 않도록 입력해주세요 ex)01011112222" required />
      </BFormGroup>

      <!--아이디-->
      <BFormGroup id="input-group-1" label="아이디:" label-for="register-id">
        <BFormInput id="register-id" name="id" v-model="form.id" type="text" placeholder="아이디를 입력하세요." required />
      </BFormGroup>

      <!--비밀번호-->
      <BFormGroup id="input-group-2" label="비밀번호:" label-for="register-password">
        <BFormInput type="password" id="register-password" name="password" v-model="form.password"
          placeholder="비밀번호를 입력하세요." required />
      </BFormGroup>

      <BFormGroup id="input-group-2" label="비밀번호 확인:" label-for="register-password-check">
        <BFormInput type="password" id="register-password-check" v-model="form.passwordCheck"
          placeholder="비밀번호를 다시 입력하세요." required />
      </BFormGroup>

      <!--<BFormGroup 
        id="input-group-3"
        label="Food:" 
        label-for="input-3">
        <BFormSelect id="input-3" v-model="form.food" :options="foods" required />
      </BFormGroup>-->


      <BButton type="submit" variant="primary">Submit</BButton>
      <BButton type="reset" variant="danger">Reset</BButton>
    </BForm>
  </div>
</template>
  
<style scoped>
.d-flex {
  justify-content: space-evenly;
}
</style>

