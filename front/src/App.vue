<template>
  <div>
    <!--Nav Bar  -->
    <b-navbar toggleable type="inverse" class="toolbar">
      <b-nav-toggle target="nav_collapse"></b-nav-toggle>
      <b-link class="navbar-brand" to="/">
        <span>IMIE Survey</span>
      </b-link>
      <b-collapse is-nav id="nav_collapse">
      <!-- <b-nav is-nav-bar>
        <b-nav-item>Docs</b-nav-item>
        <b-nav-item>Contact Us</b-nav-item>
      </b-nav> -->
      <b-nav is-nav-bar class="ml-auto">
        <!-- Navbar dropdowns -->
        <!-- <b-nav-item-dropdown text="Lang" right-alignment>
          <b-dropdown-item to="#">EN</b-dropdown-item>
          <b-dropdown-item to="#">ES</b-dropdown-item>
          <b-dropdown-item to="#">RU</b-dropdown-item>
          <b-dropdown-item to="#">FA</b-dropdown-item>
        </b-nav-item-dropdown> -->
        <b-nav-item-dropdown right-alignment>
          <!-- Using text slot -->
          <template slot="text">
            <span style="font-weight: bold;">User</span>
          </template>
          <b-dropdown-item :to="{ name: 'MyPage', params: { id: 1 }}">Ma Page</b-dropdown-item>
          <b-dropdown-item to="#">Profile</b-dropdown-item>
          <b-dropdown-item to="#">Signout</b-dropdown-item>
        </b-nav-item-dropdown>
      </b-nav>
    </b-collapse>
  </b-navbar>

  <router-view></router-view>
  <survey-modal></survey-modal>
  <new-survey></new-survey>
  <edit-survey></edit-survey>
  <login ref="login"></login>

</div>
</template>

<script>

import NewSurvey from '@/components/NewSurvey'
import SurveyModal from '@/components/SurveyModal'
import Login from '@/components/Login'
import EditSurvey from '@/components/EditSurvey'
import Hub from '@/events/EventBus.js'
import authService from '@/services/auth.js'

export default {
  name: 'app',
  components: { NewSurvey, SurveyModal, Login, EditSurvey },
  mounted () {
    if (!authService.authenticated) {
      openLoginModal(this)
    }
    Hub.$on('openLoginModal', () => {
      openLoginModal(this)
    })
  }
}

function openLoginModal (vm) {
  vm.$root.$emit('show::modal', 'modal3')
}

</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  /*text-align: center;*/
  color: #2c3e50;
  /*margin-top: 60px;*/
}

body {
  overflow: hidden;
}

.toolbar {
  background-color: #324157;
}
</style>
