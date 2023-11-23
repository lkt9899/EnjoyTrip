<script setup>
import { ref } from 'vue';
import { useMemberStore } from "../stores/member";

const memberStore = useMemberStore();
const { userLogin } = memberStore;

const form = ref({
  id: '',
  password: '',
});

const onSubmit = () => {
  // alert(JSON.stringify(form));
  callLoginMember();
};

function callLoginMember() {
  userLogin(form.value);
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

