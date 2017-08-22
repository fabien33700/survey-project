<template>

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
       label="Nom">
       <template scope="scope">
         <router-link :to="{ name: 'MyPageStatsSurvey', params: { surveyId: scope.row.id }}">
           <el-button>{{ scope.row.name }}</el-button>
         </router-link>
       </template>
     </el-table-column>
     <el-table-column
       prop="question"
       label="Question"
       width="280">
     </el-table-column>
     <el-table-column
       label="Date début">
       <template scope="scope">
         <el-icon name="time"></el-icon>
         <span style="margin-left: 10px">{{ scope.row.dateStart }}</span>
       </template>
     </el-table-column>
     <el-table-column
       label="Date fin">
       <template scope="scope">
         <el-icon name="time"></el-icon>
         <span style="margin-left: 10px">{{ scope.row.dateEnd }}</span>
       </template>
     </el-table-column>
     <el-table-column
       label="Auteur">
       <template scope="scope">
         <div>{{ scope.row.author.pseudo }}</div>
      </template>
     </el-table-column>
     <el-table-column
      label="Propositions">
     <template scope="scope">
        <ul v-for="item in scope.row.proposals">
          <li>{{ item.value }}</li>
        </ul>
      </template>
     </el-table-column>
     <!-- <el-table-column
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
    </el-table-column> -->
   </el-table>
 </div>

</template>

<script>

// import surveyService from '@/services/surveys.js'
import SurveyItemDetails from '@/components/SurveyItemDetails'

const surveyData = [
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
  name: 'table-survey',
  components: { SurveyItemDetails },
  prop: ['user'],
  data () {
    return {
      surveys: []
    }
  },

  methods: {
    handleSelectionChange (val) {
      this.multipleSelection = val
    }
  },

  mounted () {
    this.surveys = surveyData

    // if(user) {
    //   surveyService.getSurveysFromUser(user.id)
    //     .then((response) => this.surveys = response.data)
    //     .catch((err) => console.log(err))
    // } else {
    //   surveyService.getAllSurveys()
    //     .then((response) => this.surveys = response.data)
    //     .catch((err) => console.log(err))
    // }
  }
}

</script>


<style scoped>

</style>
