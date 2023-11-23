<script setup>
import { ref } from 'vue'

const leftDrawerOpen = ref(false)

const toggleLeftDrawer = () => {
    leftDrawerOpen.value = !leftDrawerOpen.value
}

</script>

<template>
    <div>

        <div class="container q-pa-md">
            <q-parallax :height="200" :speed="0.5">
                <template v-slot:media>
                    <img src="https://cdn.quasar.dev/img/parallax1.jpg">
                </template>

                <h4 class="text-white">자유게시판에서 다른 사용자들과 기록물을 공유해보세요.</h4>
            </q-parallax>
        </div>
        <board-list></board-list>

    </div>
</template>