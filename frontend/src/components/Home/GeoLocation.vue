<script setup>
import { ref, onMounted } from 'vue';

const location = ref(null);
const locationError = ref(null);

onMounted(() => {
  if ('geolocation' in navigator) {
    navigator.geolocation.getCurrentPosition(handleSuccess, handleError);
  } else {
    locationError.value = '브라우저가 Geolocation API를 지원하지 않습니다.';
  }
});

const handleSuccess = (position) => {
  location.value = {
    latitude: position.coords.latitude,
    longitude: position.coords.longitude,
  };
};

const handleError = (error) => {
  locationError.value = `위치 정보를 받아오는데 실패했습니다. 오류 메시지: ${error.message}`;
};
</script>

<template>
  <div>
    <p v-if="locationError">{{ locationError }}</p>
    <p v-else>
      <template v-if="location">
        Latitude: {{ location.latitude }}, Longitude: {{ location.longitude }}
      </template>
      <template v-else>
        위치 정보를 불러오는 중...
      </template>
    </p>
  </div>
</template>

