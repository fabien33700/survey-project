<template>
  <div>
    <div class="row">
      <div v-for="(item, index) in surveys" class="col-4">
        <survey-item :survey="item" ></survey-item>
      </div>
   </div>
 </div>
</template>

<script>

import SurveyDao from '../services/surveys.js'
import SurveyItem from './SurveyItem'

export default {
  name: 'hello',

  components: { SurveyItem },

  data () {
    return {
      surveys: []
    }
  },

  mounted () {
    SurveyDao.getAllSurveys()
      .then((response) => {
        console.log('data : ', response.data)
        this.surveys = response.data
      }).catch(function (error) {
        console.log(error)
      })
  }
}

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
