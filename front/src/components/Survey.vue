<template>



</template>


<script>
import SurveyDao from '../services/surveys.js'

export default {
  name: 'survey',
  props: ['id'],

  mounted () {
    SurveyDao.getSurveyFromId()
      .then((response) => {
        console.log('data : ', response.data)
        this.surveys = response.data
      }).catch(function (error) {
        console.log(error)
      })
  }
}
</script>

<style scoped>
</style>
