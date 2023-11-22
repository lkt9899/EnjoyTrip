<script setup>
defineProps({ post: Object });
</script>

<template>
  <tr class="text-center">
    <th scope="row">{{ post.postId }}</th>
    <td class="text-start">
      <router-link
        :to="{ name: 'board-detail', params: { postId: post.postId } }"
        class="article-title link-dark"
      >
        {{ post.title }}
      </router-link>
    </td>
    <td>{{ post.authorName }}</td>
    <td>{{ post.hit }}</td>
  </tr>
</template>

<style scoped>
a {
  text-decoration: none;
}
</style>
