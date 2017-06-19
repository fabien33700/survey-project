<template>
      <div @click="open()">
      <!-- <router-link :to="{ name: 'Survey', params: { id: survey.id }}"> -->
        <b-card
              img="http://placeskull.com/200/200/4FC08D/-1/0"
              class="mb-2"
              :title="survey.name"
              show-footer
        >
              {{ survey.question }}

              <small slot="footer" class="text-muted survey-footer">
                   <span>{{ nbParticipants }} participants</span>
                   <span>{{ daysBeforeSurveyEnd }}</span>
              </small>
    </b-card>
    <!-- </router-link> -->
  </div>

</template>
<script>

import Hub from '../events/EventBus.js'
import moment from 'moment'

export default {

  name: 'survey-item',
  props: ['survey'],

  data () {
    return {
      nbParticipants: 0
    }
  },

  methods: {
    open () {
      this.$root.$emit('show::modal', 'modal1')
      // Hub.$emit('open-modal')
      Hub.$emit('set-modal-data', this.survey)
    }
  },

  // created () {
  //   Hub.$on('add-survey-answered', () => )
  // }

  computed: {
    daysBeforeSurveyEnd: function () {
      var dateFin = moment(this.survey.dateFin, 'DD-MM-YYYY')
      return dateFin.toNow(true)
    }
  }
}
</script>

<style scoped>

.survey-footer {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}
</style>
