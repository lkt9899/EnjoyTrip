<script setup>
defineProps({
    attraction: Object,
});
</script>

<template>
    <q-card class="my-card px-1">
        <q-card-section class="p-1 my-1">
            <q-img v-if="attraction.firstImage != ''" :src="attraction.firstImage" />
            <q-img v-else src="@/assets/noImage.jpg" />
        </q-card-section>
        <q-card-section>
            <div class="row">
                <div class="text-h6 col-10 my-auto">{{ attraction.title }}</div>
            </div>
            <div class="row">
                <div class="text-subtitle2 col-10 my-auto">{{ attraction.addr1 }}</div>
                <q-btn @click="$emit('addPlan', attraction)" class="col-2" flat round color="white" text-color="primary"
                    icon="add" />
            </div>
        </q-card-section>
    </q-card>
</template>

<style scoped>
.my-card {
    width: 280px
}
</style>