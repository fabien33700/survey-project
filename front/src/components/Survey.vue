<template>
  <b-card
        img="http://placeskull.com/200/200/4FC08D/-1/0"
        class="mb-2"
        :title="survey.name"
        show-footer>
        {{ survey.question }} 
        <div v-for="prop in survey.proposals">
          <b-form-checkbox v-model="reponse" :value="prop">
            {{ item.value }}
          </b-form-checkbox>
       </div>
       <big slot="footer" class="text-muted">
         <b-button variant="primary" href="" @click="postSurveyAnswer">Voter !</b-button>
      </big>
    </b-card>
</template>

<script>
import SurveyDao from '@/services/surveys.js'
import moment from 'moment'

export default {
  name: 'survey',
  props: ['id'],

  data () {
    return {
      survey: {},
      reponse: {}
    }
  },

  methods: {
    postSurveyAnswer: function () {
      var surveyAnswer = buildSurveyAnswer(this.survey, this.reponse)
      SurveyDao.postSurveyAnswers(surveyAnswer)
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

function buildSurveyAnswer (survey, response) {
  return {
    sondage: {
      id: survey.id
    },
    reponses: [
      { id: response.id } ],
    utilisateur: {
      id: 1
    },
    dateReponse: moment().format('DD/MM/YYYY')
  }
}

</script>
<style scoped>
</style>
