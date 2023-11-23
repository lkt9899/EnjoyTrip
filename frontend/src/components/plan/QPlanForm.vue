<script setup>
import { ref } from 'vue';
import { useMemberStore } from "../../stores/member";
import { writePlan } from '@/api/plan';
import { useRouter } from 'vue-router';

const router = useRouter();
const memberStore = useMemberStore();
const { userInfo } = memberStore;

const props = defineProps({
    planList: Array
});

const planRequest = ref({
    title: "",
    memberId: "",
    planDetailList: ""
});

const onSubmit = () => {
    planRequest.value.planDetailList = props.planList;
    planRequest.value.memberId = userInfo.memberId;
    console.log(JSON.stringify(planRequest.value));
    writePlan(
        planRequest.value,
        () => {
            alert("등록 성공!!");
            router.push({ name: 'home' });
        },
        (err) => {
            console.log(err);
        }
    )
}
</script>

<template>
    <q-form @submit="onSubmit" @reset="onReset" class="w-75 m-auto">
        <q-input class="ms-0 mt-2" filled v-model="planRequest.title" label="제목" hint="title" lazy-rules
            :rules="[val => val && val.length > 0 || 'Please type something']" />

        <span class="d-flex justify-content-end my-buttons mt-2">
            <q-btn label="등록" type="submit" color="primary" />
        </span>
    </q-form>
</template>

<style scoped>
.my-buttons {
    padding-right: 12px;
}
</style>