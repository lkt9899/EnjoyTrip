<script setup>
import { computed } from 'vue';

const props = defineProps({
    items: Array,
    isPlan: Boolean
});

const planDetailList = computed(() => {
    let options = [];
    props.items.forEach((item) => {
        options.push({ contentId: item.contentId });
    });
    return options;
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
            <template v-for="(item, idx) in items" :key="item.contentId">
                <q-item clickable v-ripple>
                    <div class="row">
                        <div class="col">{{ idx + 1 }}</div>
                        <div class="col-9 text-h6">{{ item.title }}</div>
                        <q-btn @click="$emit('removePlan', idx)" class="col q-ml-md" flat round color="white"
                            text-color="danger" icon="remove" />
                    </div>
                </q-item>
            </template>
        </q-list>
    </q-scroll-area>
</template>

<style scoped></style>