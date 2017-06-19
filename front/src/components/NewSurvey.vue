<template>

  <b-modal id="modal2" title="Créer un nouveau sondage" @ok="submit">
    <div class="new-modal">
      <form @submit.stop.prevent="submit" >

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
            <!-- <el-input
              type="textarea"
              :rows="2"
              placeholder="Please input"
              v-model="survey.question">
            </el-input> -->

          </b-form-fieldset>


          <b-form-fieldset
             label="Réponses"
             :label-size="1"
             >

             <div v-for="(prop, index) in survey.propositions" class="prop-span">

                    <b-form-input v-model="survey.propositions[index]" class="prop"></b-form-input>
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
                  v-model="survey.dateDebut"
                  type="date"
                  format="dd/MM/yyyy"
                  placeholder="Pick a day">
                </el-date-picker>

                <span>au</span>
                <el-date-picker
                  v-model="survey.dateFin"
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
import moment from 'moment'

export default {

  name: 'new-survey',

  data () {
    return {

      survey: {
        name: '',
        question: '',
        propositions: ['', ''],
        author: {
          id: 0
        },
        dateDebut: '',
        dateFin: ''
      }

    }
  },

  methods: {
    submit () {
      this.survey.dateFin = formateDate(this.survey.dateFin)
      this.survey.dateDebut = formateDate(this.survey.dateDebut)
      console.log(this.survey)
      SurveyDao.postNewSurvey(this.survey).then(function (response) {
        alert('New Survey created')
      }).catch(function (error) {
        console.log(error)
      })
    },
    addProposition () {
      if (this.survey.propositions.length < 9) {
        this.survey.propositions.push('')
      }
    },
    removeProposition (idx) {
      this.survey.propositions.splice(idx, 1)
    }
  }
}

function formateDate (date) {
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
