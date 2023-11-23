<script setup>
import { ref, onMounted } from 'vue';
import { listSido } from '@/api/map';
import { listHotPlaces } from '@/api/hotplace';

const activeMenu = ref("전체");

const sidoList = ref([]);
const hotplaces = ref([]);

onMounted(async () => {
    getHotPlaces({ text: "전체", value: -1 });
    await getSidoList();
})

const getSidoList = () => {
    listSido(
        ({ data }) => {
            let options = [];
            options.push({ text: "전체", value: -1 });
            data.forEach((sido) => {
                options.push({ text: sido.sidoName, value: sido.sidoCode });
            });
            sidoList.value = options;
        },
        (err) => {
            console.log(err);
        }
    );
}

const getHotPlaces = (sido) => {
    activeMenu.value = sido.text;
    listHotPlaces(
        sido.value,
        ({ data }) => {
            hotplaces.value = data;
        },
        (err) => {
            console.log(err);
        }
    );
}

</script>

<template>
    <q-layout view="hHh Lpr lff" container style="height: 730px" class="shadow-2 rounded-borders">
        <q-drawer show-if-above :width="200" :breakpoint="500" bordered
            :class="$q.dark.isActive ? 'bg-grey-9' : 'bg-grey-3'">
            <q-scroll-area class="fit">
                <q-list>
                    <template v-for="sido in sidoList" :key="sido.value">
                        <q-item @click="getHotPlaces(sido)" :active="activeMenu === sido.text"
                            active-class="text-white bg-primary" clickable v-ripple>
                            <q-item-section>
                                {{ sido.text }}
                            </q-item-section>
                        </q-item>
                        <q-separator />
                    </template>
                </q-list>
            </q-scroll-area>
        </q-drawer>

        <q-page-container>
            <q-page padding>
                <div class="d-flex flex-row">
                    <template v-for="hotplace in hotplaces" :key="hotplace.hotPlaceId">
                        <q-item class="mx-1" @click="viewHotPlace(hotplace)" clickable v-ripple>
                            <q-card-component :item="hotplace" :type="'hp'" />
                        </q-item>
                    </template>
                </div>
            </q-page>
        </q-page-container>
    </q-layout>
</template>

<style scoped></style>