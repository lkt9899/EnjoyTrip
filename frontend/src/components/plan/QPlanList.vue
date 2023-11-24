<script setup>
const props = defineProps({
    isPlan: Boolean,
});
</script>

<template>
    <q-scroll-area class="fit">
        <q-list v-if="!isPlan">
            <template v-for="item in items" :key="item.contentId">
                <q-item @click="$emit('viewAttraction', item)" clickable v-ripple>
                    <q-attraction-card @addPlan="this.$emit('addPlan', item)" :attraction="item" />
                </q-item>
            </template>
        </q-list>

        <q-list v-else>
            <q-plan-form :planList="planDetailList" />
            <hr />
            <plan-item-list />
        </q-list>
    </q-scroll-area>
</template>

<style scoped></style>