
<script setup>
import { ref } from 'vue'
import BoardList from '../components/board/BoardList.vue';

const leftDrawerOpen = ref(false)

const toggleLeftDrawer = () =>  {
    leftDrawerOpen.value = !leftDrawerOpen.value
}

</script>

<template>
    <div>
        
        <div class="q-pa-md">
            <q-parallax :height="200" :speed="0.5">
            <template v-slot:media>
                <img src="https://cdn.quasar.dev/img/parallax1.jpg">
            </template>

            <h9 class="text-white">자유게시판에서 다른 사용자들과 기록물을 공유해보세요.</h9>
            </q-parallax>
        </div>

        <BoardList></BoardList>
    </div>
</template>