<template>
  <div>

    <!-- Nav Bar  -->
    <!-- <b-navbar toggleable variant="secondary" class="no-margin">
      <b-nav-toggle target="nav_collapse"></b-nav-toggle>
      <b-button variant="primary" v-b-modal.modal2>
        <span>Créer un sondage</span>
      </b-button>
      <b-collapse is-nav id="nav_collapse">
    </b-collapse>
  </b-navbar> -->

    <div class="row">
      <div v-for="(item, index) in surveys" class="col-4">
        <survey-item :survey="item" ></survey-item>
      </div>
   </div>

   <b-button variant="primary" class="rounded-circle fab-button" v-b-modal.modal2>
     <icon name="plus" scale="2" label="Créer un sondage"></icon>
   </b-button>

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

.fab-button{
  /*border-radius: 50%;*/
  height: 70px;
  width: 70px;
  position: fixed;
  z-index: 10;
  bottom: 0;
  right: 0;
  margin-bottom: 15px;
  margin-right: 15px;
  display: flex;
  justify-content: center;
}
</style>
