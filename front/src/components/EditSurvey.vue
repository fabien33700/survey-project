<template>

  <b-modal id="modal6" title="Modifier un sondage" @ok="submit">
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
                    <b-form-input v-model="survey.proposals[index].value" class="prop" :value="prop.value"></b-form-input>
                    <el-button type="primary"size="mini" icon="minus" @click="removeProposition(index)" class="remove-prop"></el-button>
                </br>
             </div>

             <el-button type="primary" size="mini" @click="addProposition" icon="plus"></el-button>

           </b-form-fieldset>

           <b-form-fieldset
              label="Date"
              :label-size="1"
              >

              <div class="block">
                <span>Du</span>
                <el-date-picker
                  v-model="formateDatePickerStart"
                  type="date"
                  format="dd/MM/yyyy"
                  placeholder="Pick a day">
                </el-date-picker>

                <span>au</span>
                <el-date-picker
                  v-model="formateDatePickerEnd"
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

import Hub from '@/events/EventBus.js'
import surveyService from '@/services/surveys.js'

import moment from 'moment'

const DATE_FORMATTER = 'DD/MM/YYYY'

const SUVEY_EDITED = {
  title: 'Success',
  message: 'Sondage mis à jour avec succes',
  type: 'Success'
}

export default {
  name: 'edit-survey',
  data () {
    return {
      survey: {}
    }
  },

  methods: {
    submit () {
      // this.survey.dateEnd = formateDate(this.survey.dateEnd)
      // this.survey.dateStart = formateDate(this.survey.dateStart)
      // this.$notify(surveyCreated)
      // Hub.$emit('survey-created', this.survey)
      surveyService.editSurvey(this.survey)
        .then((response) => {
          this.$notify(SUVEY_EDITED)
          // Hub.$emit('survey-created', this.survey)
        })
        .catch((err) => { console.log(err) })
    },
    addProposition () {
      if (this.survey.proposals.length < 9) {
        this.survey.proposals.push({ id: this.survey.proposals.length, value: '' })
      }
    },
    removeProposition (idx) {
      this.survey.proposals.splice(idx, 1)
    }
  },

  computed: {
    formateDatePickerStart: {
      // getter
      get: function () {
        return getFormatedDatePicker(this.survey.dateStart)
      },
      // setter
      set: function (newValue) {
        this.survey.dateStart = formateDate(newValue)
      }
    },
    formateDatePickerEnd: {
      // getter
      get: function () {
        return getFormatedDatePicker(this.survey.dateEnd)
      },
      // setter
      set: function (newValue) {
        this.survey.dateEnd = formateDate(newValue)
        // return newDate
      }
    }
  },

  created () {
    Hub.$on('set-edit-survey-data', (surv) => {
      console.log('survey : ', surv)
      this.survey = surv
    })
  }
}

function getFormatedDatePicker (date) {
  return moment(date, DATE_FORMATTER)
}

function formateDate (date) {
  return moment(date).format(DATE_FORMATTER)
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
