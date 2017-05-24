<template>
  <b-card
        img="http://placeskull.com/200/200/4FC08D/-1/0"
        class="mb-2"
        :title="survey.name"
        show-footer>
        {{ survey.question }}
        <div v-for="item in survey.propositions">
          <b-form-checkbox v-model="response" :value=item >
            {{ item }}
          </b-form-checkbox>
       </div>
       <big slot="footer" class="text-muted">
         <b-button :variant="primary" href="">Voter !</b-button>
      </big>
    </b-card>
</template>

<script>
import SurveyDao from '@/services/surveys.js'

export default {
  name: 'survey',
  props: ['id'],

  data () {
    return {
      survey: {},
      response: ''
    }
  },

  mounted () {
    SurveyDao.getSurveyFromId(this.id)
      .then((response) => {
        this.survey = response.data
      }).catch(function (error) {
        console.log(error)
      })
  }
}

</script>
<style scoped>
</style>
