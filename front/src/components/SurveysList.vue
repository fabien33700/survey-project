<template>

  <div class="survey-table">

    <div class="menu-action">
      <el-button type="primary" v-b-modal.modal2>Créer un sondage</el-button>
      <el-button>Supprimer</el-button>
    </div>

    <div class="table">
      <el-table ref="multipleTable" :data="surveys" border style="width: 100%" @selection-change="handleSelectionChange">
       <el-table-column
        type="selection"
        width="65">
        </el-table-column>
        <el-table-column
          type="expand">
          <template scope="props">
            <survey-item-details :survey="props.row" class="survey-preview"></survey-item-details>
          </template>
        </el-table-column>
        <el-table-column
          type="index"
          width="65">
        </el-table-column>
       <el-table-column
         prop="name"
         label="Nom"
         width="180">
       </el-table-column>
       <el-table-column
         prop="question"
         label="Question"
         width="280">
       </el-table-column>
       <el-table-column
         label="Date début"
         width="180">
         <template scope="scope">
           <el-icon name="time"></el-icon>
           <span style="margin-left: 10px">{{ scope.row.dateStart }}</span>
         </template>
       </el-table-column>
       <el-table-column
         label="Date fin"
         width="180">
         <template scope="scope">
           <el-icon name="time"></el-icon>
           <span style="margin-left: 10px">{{ scope.row.dateEnd }}</span>
         </template>
       </el-table-column>
       <el-table-column
         label="Auteur"
         width="180">
         <template scope="scope">
           <div>{{ scope.row.author.pseudo }}</div>
        </template>
       </el-table-column>
       <el-table-column
        label="Propositions"
        width="280">
       <template scope="scope">
          <ul v-for="item in scope.row.proposals">
            <li>{{ item.value }}</li>
          </ul>
        </template>
       </el-table-column>
       <el-table-column
        fixed="right"
        width="280"
        label="Operations">
        <template scope="scope">
          <el-button
            size="small"
            @click="handleEdit(scope.$index, scope.row)">Edit</el-button>
          <el-button
            size="small"
            type="danger"
            @click="handleDelete(scope.$index, scope.row)">Delete</el-button>
        </template>
      </el-table-column>
     </el-table>
   </div>
 </div>

</template>

<script>
import surveyService from '@/services/surveys.js'
import SurveyItemDetails from '@/components/SurveyItemDetails'
import Hub from '@/events/EventBus.js'
// import moment from 'moment'

const surveysTest = [
  {
    id: 1,
    name: 'Survey1',
    dateStart: '22/06/2017',
    dateEnd: '01/07/2017',
    question: 'Quelle est ta couleur préférée ?',
    proposals: [
      { id: 1, value: 'Bleu' },
      { id: 2, value: 'Rouge' }
    ],
    author: {
      id: 1,
      pseudo: 'anne',
      role: 'ADMIN'
    }
  }
]

export default {
  name: 'survey-list',
  components: { SurveyItemDetails },
  data () {
    return {
      // surveys: []
      surveys: surveysTest
    }
  },

  methods: {
    handleSelectionChange (val) {
      this.multipleSelection = val
    },
    handleEdit (index, row) {
      this.$root.$emit('show::modal', 'modal6')
      Hub.$emit('set-edit-survey-data', row)
    },
    handleDelete (index, row) {
      console.log(index, row)
    }
  },

  mounted () {
    surveyService.getAllSurveys()
     .then((response) => {
       this.surveys = response.data
     })
     .catch((err) => { console.log(err) })
  },

  created () {
    Hub.$on('survey-created', (surv) => {
      console.log('the new survey : ', surv)
      this.surveys.push(surv)
    })
    Hub.$on('debug', console.log)
  }
}

</script>


<style scoped>
.survey-table {
  display: block;
  padding: 24px;
  height: 100%;
}

.survey-item {
  padding: 10px;
}

.survey-column {
  display: flex;
  flex-direction: row;
}

.menu-action {
  display: flex;
  justify-content: flex-end;
}

.table {
  padding-top: 24px;
}

.survey-preview {
  width: calc(100% - 390px);
}
</style>
