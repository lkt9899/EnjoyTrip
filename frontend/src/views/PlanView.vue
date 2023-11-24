<script setup>
import { ref, onMounted } from 'vue';
import { useRouter } from 'vue-router';
import { getList } from '@/api/plan';
import { useMemberStore } from "../stores/member";

import VKakaoMap from "@/components/common/VKakaoMap.vue";

const router = useRouter();

const memberStore = useMemberStore();
const { isLogin, userInfo } = memberStore;

const drawer = ref(true);

const plans = ref([]);
const attractions = ref([]);
const selectAttraction = ref({});

onMounted(() => {
    if (!isLogin) {
        alert("로그인이 필요한 페이지 입니다 !");
        router.push({ name: "login" });
    } else {
        getPlanList();
    }
});

const getPlanList = () => {
    getList(
        userInfo.memberId,
        ({ data }) => {
            plans.value = data;
        },
        (err) => {
            console.log(err);
        }
    );
};

const viewAttraction = (data) => {
    selectAttraction.value = data;
};

const setAttractions = (data) => {
    attractions.value = data;
}

</script>

<template>
    <q-layout view="hHh Lpr lff" container style="height: 730px" class="shadow-2 rounded-borders">
        <q-drawer v-model="drawer" :width="350" :breakpoint="500" bordered
            :class="$q.dark.isActive ? 'bg-grey-9' : 'bg-grey-3'">
            <plan-item-list :items="plans" @selectAttraction="viewAttraction" @setAttractions="setAttractions" />
        </q-drawer>

        <q-page-container>
            <q-page padding>
                <VKakaoMap :attractions="attractions" :selectAttraction="selectAttraction" />
            </q-page>
        </q-page-container>
    </q-layout>
</template>

<style scoped></style>