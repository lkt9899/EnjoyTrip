<script setup>
defineProps({ post: Object });
</script>

<template>
  <tr class="text-center">
    <th scope="row">{{ post.postId }}</th>
    <td class="text-start">
      {{ post.title }}
      <!-- <router-link
        :to="{ name: 'article-view', params: { articleno: article.articleNo } }"
        class="article-title link-dark"
      >
        {{ post.title }}
      </router-link> -->
    </td>
    <td>{{ post.authorId }}</td>
    <td>{{ post.hit }}</td>
  </tr>
</template>

<style scoped>
a {
  text-decoration: none;
}
</style>
