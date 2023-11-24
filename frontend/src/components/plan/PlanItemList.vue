<script setup>
import { ref } from 'vue';
defineProps({
    items: Array
});

const visible = ref(0);
</script>

<template>
    <template v-for="(item, idx) in items" :key="item.planId">
        <q-item v-ripple clickable>
            <div class="row">
                <div class="col">{{ idx + 1 }}</div>
                <div class="col-9 text-h6" @click="() => {
                    visible = visible == item.planId ? 0 : item.planId;
                    $emit('setAttractions', item.attractionList);
                }">{{ item.title }}
                </div>
                <q-slide-transition>
                    <plan-item v-show="visible == item.planId" :items="item.attractionList" @selectAttraction="(res) => {
                        $emit('selectAttraction', res);
                    }" />
                </q-slide-transition>
            </div>
        </q-item>
    </template>
</template>

<style scoped></style>