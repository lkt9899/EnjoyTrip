<script setup>
defineProps({
    item: Object,
    altImg: String
});
</script>

<template>
    <q-card class="my-card px-1">
        <q-card-section class="p-1 my-1">
            <q-img v-if="item.firstImage != ''" :src="item.firstImage" />
            <q-img v-else src="@/assets/noImage.jpg" />
        </q-card-section>
        <q-card-section>
            <div class="text-h6">{{ item.title }}</div>
            <div class="text-subtitle2">{{ item.addr1 }}</div>
        </q-card-section>
    </q-card>
</template>

<style scoped>
.my-card {
    width: 100%;
    max-width: 250px;
}
</style>