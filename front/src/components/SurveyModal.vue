<template>
  <b-modal id="modal1" class="survey-modal" :title="modalTitle" @ok="postSurveyAnswer" @shown="init" ok-title="Voter !">
    <b-card
          img="http://placeskull.com/200/200/4FC08D/-1/0">
          {{ survey.question }}
          <div v-for="item in survey.propositions">
            <b-form-checkbox v-model="reponse" :value=item >
              {{ item.value }}
            </b-form-checkbox>
         </div>
      </b-card>
  </b-modal>
</template>


<script>

import Hub from '../events/EventBus.js'
import SurveyDao from '@/services/surveys.js'
import VertxEventBus from '@/vertx/eventBus.js'
import moment from 'moment'

export default {
  name: 'survey-modal',
  data () {
    return {
      modalConf: {
        title: 'Répondre au sondage '
      },
      survey: {},
      reponse: {}
    }
  },
  // props: ['data']
  created () {
    Hub.$on('set-modal-data', (surv) => (this.survey = surv))
  },

  methods: {
    init: function () {
      console.log('here')
    },

    postSurveyAnswer: function () {
      var surveyAnswer = buildSurveyAnswer(this.survey, this.reponse)
      SurveyDao.postSurveyAnswers(surveyAnswer)

      // Envoi de la réponse au server vertx
      VertxEventBus.send('survey.submit', this.survey)
    }
  },

  computed: {
    // a computed getter
    modalTitle: function () {
      return this.modalConf.title + this.survey.name
    }
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

<style>
.survey-modal .modal-body {
  padding: 0 !important;
}

.survey-modal .card {
  border: none !important;
}

</style>
