<template>
  <div class="table">
    <el-table ref="multipleTable" :data="answers" border style="width: 100%" @selection-change="handleSelectionChange">
     <el-table-column
      type="selection"
      width="65">
      </el-table-column>
      <el-table-column
        type="index"
        width="65">
      </el-table-column>
      <el-table-column
        label="Auteur">
        <template scope="scope">
          <div>{{ scope.row.user.pseudo }}</div>
       </template>
      </el-table-column>
      <el-table-column
       label="Réponses">
      <template scope="scope">
         <ul v-for="item in scope.row.proposals">
           <li>{{ item.value }}</li>
         </ul>
       </template>
      </el-table-column>
      <el-table-column
       label="Date réponse">
       <template scope="scope">
         <el-icon name="time"></el-icon>
         <span style="margin-left: 10px">{{ scope.row.dateAnswer }}</span>
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

// import surveyService from '@services/surveys.js'

const answerDatas = [
  {
    survey: {
      name: 'Survey1'
    },
    proposals: [
      {
        value: 'Blue'
      }
    ],
    user: {
      id: '1',
      pseudo: 'anne'
    },
    dateAnswer: '21/06/2017'
  },
  {
    survey: {
      name: 'Survey1'
    },
    proposals: [
      {
        value: 'Blue'
      }
    ],
    user: {
      id: '1',
      pseudo: 'anne'
    },
    dateAnswer: '21/06/2017'
  },
  {
    survey: {
      name: 'Survey1'
    },
    proposals: [
      {
        value: 'Blue'
      }
    ],
    user: {
      id: '1',
      pseudo: 'anne'
    },
    dateAnswer: '21/06/2017'
  },
  {
    survey: {
      name: 'Survey1'
    },
    proposals: [
      {
        value: 'Blue'
      }
    ],
    user: {
      id: '1',
      pseudo: 'anne'
    },
    dateAnswer: '21/06/2017'
  },
  {
    survey: {
      name: 'Survey1'
    },
    proposals: [
      {
        value: 'Blue'
      }
    ],
    user: {
      id: '1',
      pseudo: 'anne'
    },
    dateAnswer: '21/06/2017'
  }
]

export default {
  name: 'survey-answers-table',
  props: ['id'],
  data () {
    return {
      answers: answerDatas
    }
  },

  methods: {
    handleSelectionChange (val) {
      this.multipleSelection = val
    }
  }

  // mounted () {
  //   surveyService.getSurveyAnswers(this.id)
  //     .then((response) => this.answer = repsonse.data)
  //     .catch((err) => { console.log(err) })
  // }
}

</script>

<style scoped>


</style>
