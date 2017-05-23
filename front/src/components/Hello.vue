<template>
  <div>
    <!-- Nav Bar  -->
    <b-navbar toggleable type="inverse" variant="success" class="no-margin">
      <b-nav-toggle target="nav_collapse"></b-nav-toggle>
      <b-link class="navbar-brand" to="#">
        <span>BootstrapVue</span>
      </b-link>
      <b-collapse is-nav id="nav_collapse">
      <b-nav is-nav-bar>
        <b-nav-item>Support</b-nav-item>
        <b-nav-item>Docs</b-nav-item>
        <b-nav-item>Contact Us</b-nav-item>
      </b-nav>
      <b-nav is-nav-bar class="ml-auto">
        <!-- Navbar dropdowns -->
        <b-nav-item-dropdown text="Lang" right-alignment>
          <b-dropdown-item to="#">EN</b-dropdown-item>
          <b-dropdown-item to="#">ES</b-dropdown-item>
          <b-dropdown-item to="#">RU</b-dropdown-item>
          <b-dropdown-item to="#">FA</b-dropdown-item>
        </b-nav-item-dropdown>
        <b-nav-item-dropdown right-alignment>
          <!-- Using text slot -->
          <template slot="text">
            <span style="font-weight: bold;">User</span>
          </template>
          <b-dropdown-item to="#">Profile</b-dropdown-item>
          <b-dropdown-item to="#">Signout</b-dropdown-item>
        </b-nav-item-dropdown>
      </b-nav>
    </b-collapse>
  </b-navbar>
  <!--  All surveys -->
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
// import 'axios'

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
