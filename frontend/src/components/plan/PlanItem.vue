<script setup>
defineProps({
    items: Array
});
</script>

<template>
    <q-list>
        <template v-for="(item, idx) in items" :key="item.contentId">
            <q-item @click="$emit('selectAttraction', item)" clickable v-ripple>
                <div class="row">
                    <div class="col">{{ idx + 1 }}</div>
                    <div class="col-9 text-h6">{{ item.title }}</div>
                </div>
            </q-item>
        </template>
    </q-list>
</template>

<style scoped></style>