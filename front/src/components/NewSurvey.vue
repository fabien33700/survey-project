<template>

  <b-modal id="modal2" title="Créer un nouveau sondage" @ok="submit" @shown="clear">
    <div class="new-modal">
      <form >

          <b-form-fieldset
             label="Nom"
             :label-size="1"
             >
             <b-form-input v-model="survey.name"></b-form-input>
         </b-form-fieldset>

         <b-form-fieldset
            label="Question"
            :label-size="1"
            >
            <b-form-input v-model="survey.question" textarea :rows="2" placeholder="Votre question"></b-form-input>

          </b-form-fieldset>


          <b-form-fieldset
             label="Réponses"
             :label-size="1"
             >

             <div v-for="(prop, index) in survey.proposals" class="prop-span">

                    <b-form-input v-model="survey.proposals[index]" class="prop" :value="prop"></b-form-input>
                    <el-button type="primary"size="mini" icon="minus" @click="removeProposition(index)" class="remove-prop"></el-button>
                </br>
             </div>

             <!-- <icon name="plus-square" @click="addProposition" ></icon> -->
             <el-button type="primary" size="mini" @click="addProposition" icon="plus"></el-button>

           </b-form-fieldset>

           <b-form-fieldset
              label="Date"
              :label-size="1"
              >

              <div class="block">
                <span>Du</span>
                <el-date-picker
                  v-model="survey.dateStart"
                  type="date"
                  format="dd/MM/yyyy"
                  placeholder="Pick a day">
                </el-date-picker>

                <span>au</span>
                <el-date-picker
                  v-model="survey.dateEnd"
                  type="date"
                  format="dd/MM/yyyy"
                  placeholder="Pick a day">
                </el-date-picker>
              </div>

            </b-form-fieldset>
      </form>
    </div>
  </b-modal>

</template>


<script>
import SurveyDao from '@/services/surveys.js'
import Hub from '@/events/EventBus.js'
import VertxEventBus from '@/vertx/eventBus.js'
import moment from 'moment'
import _ from 'lodash'

const surveyCreated = {
  title: 'Success',
  message: 'Nouveau sondage crée.',
  type: 'success'
}

const surveyTmp = {
  name: '',
  question: '',
  author: '',
  proposals: ['', ''],
  dateStart: '',
  dateEnd: ''
}

export default {
  name: 'new-survey',
  data () {
    return {
      survey: {}
    }
  },

  methods: {
    submit () {
      this.survey.dateEnd = formatDate(this.survey.dateEnd)
      this.survey.dateStart = formatDate(this.survey.dateStart)
      // this.$notify(surveyCreated)
      // Hub.$emit('survey-created', this.survey)
      SurveyDao.postNewSurvey(this.survey).then(function (response) {
        this.$notify(surveyCreated)
        Hub.$emit('survey-created', this.survey)
        Hub.$emit('debug', 'Hello')
      }).catch(function (error) {
        console.log(error)
      })

      // Envoi du sondage au server vertx
      VertxEventBus.send('survey.create', this.survey)
    },
    addProposition () {
      if (this.survey.proposals.length < 9) {
        this.survey.proposals.push('')
      }
    },
    removeProposition (idx) {
      this.survey.proposals.splice(idx, 1)
    },

    clear () {
      console.log('into clear method')
      this.survey = _.cloneDeep(surveyTmp)
    }
  }
}

function formatDate (date) {
  return moment(date).format('DD/MM/YYYY')
}

</script>

<style scoped>

.prop-span {
  display: flex;
  flex-direction: row;
}

.remove-prop {
  align-self: center;
}

.prop {
  margin-right: 10px;
  margin-bottom: 10px;
}
</style>
