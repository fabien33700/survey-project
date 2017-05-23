<template>
    <div>
      <router-link :to="{ name: 'Survey', params: { id: survey.id }}">
        <b-card
              img="http://placeskull.com/200/200/4FC08D/-1/0"
              class="mb-2"
              :title="survey.name"
              showFooter >
              {{ survey.question }}
          <small slot="footer" class="text-muted">
               Date de fin : {{ survey.dateFin }}
          </small>
      </b-card>
    </router-link>
  </div>
</template>
<script>

export default {
  name: 'survey-item',
  props: ['survey'],
  data () {
  }
}
</script>

<style scoped>
</style>
