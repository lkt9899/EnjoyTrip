<script setup>
import { ref } from "vue";
import { getList } from '@/api/attraction';

const drawerCards = ref(false);
const drawerPlan = ref(false);
const attractions = ref([]);
const plans = ref([]);
const selectAttraction = ref({});

const param = ref({
    searchCondition: {
        "sidoCode": 1,
        "gugunCode": 1,
        "contentTypeId": 12
    },

    pagingInfo: {
        "lastItemId": 0,
        "count": -1
    }
});

const setAttraction = (data) => {
    param.value = data;
    getAttractions();
    drawerCards.value = true;
}

const getAttractions = () => {
    getList(
        param.value,
        ({ data }) => {
            attractions.value = data;
        },
        (err) => {
            console.log(err);
        }
    );
};

const viewAttraction = (item) => {
    selectAttraction.value = item;
};

const addPlan = (item) => {
    drawerPlan.value = true;
    plans.value.push(item);
    console.log(plans.value.length);
}

const removePlan = (idx) => {
    plans.value.splice(idx, 1);
    if (plans.value.length == 0)
        drawerPlan.value = false;
};
</script>

<template>
    <q-layout view="hHh LpR fff" container style="height: 730px" class="shadow-2 rounded-borders">
        <q-drawer v-model="drawerCards" :width="300" :breakpoint="500" bordered
            :class="$q.dark.isActive ? 'bg-grey-9' : 'bg-grey-3'">
            <q-side-list :items="attractions" :isPlan="false" @viewAttraction="viewAttraction" @addPlan="addPlan" />
        </q-drawer>

        <q-page-container>
            <q-page class="p-2">
                <search-location @updateAttraction="setAttraction" />
                <v-kakao-map :attractions="attractions" :selectAttraction="selectAttraction" />
            </q-page>
        </q-page-container>

        <q-drawer v-model="drawerPlan" :width="300" side="right" :breakpoint="500" bordered
            :class="$q.dark.isActive ? 'bg-grey-9' : 'bg-grey-3'">
            <q-side-list :items="plans" :isPlan="true" @removePlan="removePlan" />
        </q-drawer>
    </q-layout>
</template>

<style scoped></style>