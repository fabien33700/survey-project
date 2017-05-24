<template>
  
  <!-- <div @click="$root.$emit('show::modal', 'modal1')"> -->
      <router-link :to="{ name: 'Survey', params: { id: survey.id }}">
        <b-card
              img="http://placeskull.com/200/200/4FC08D/-1/0"
              class="mb-2"
              :title="survey.name"
              show-footer
        >
              {{ survey.question }}

              <small slot="footer" class="text-muted">
                   Date de fin : {{ survey.dateFin }}
              </small>

    </b-card>
    </router-link>

</template>
<script>

// import Hub from '../events/EventBus.js'

export default {

  name: 'survey-item',
  props: ['survey']

  // methods: {
  //   open () {
  //     Hub.$emit('open-modal')
  //     Hub.$emit('set-modal-data', this.survey, 'Component Title')
  //   }
  // }
}
</script>

<style scoped>
</style>
