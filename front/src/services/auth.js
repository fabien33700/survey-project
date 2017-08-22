'use strict'

import axios from 'axios'
// import Hub from '@/events/EventBus.js'

const BASE_URI = 'http://localhost:8080/'
const LOGIN_URI = 'login/'
const JWT_KEY = 'id_token'

var authService = {
  authenticated: true,

  init: function () {
    this.checkAuthentication()
    axios.defaults.baseURL = BASE_URI
    axios.defaults.headers.common['Authorization'] = this.getAuthHeader()
    axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded'
  },

  login: function (creds) {
    return axios.post(LOGIN_URI, creds)
    .then(function (response) {
      localStorage.setItem(JWT_KEY, response.headers.id_token)
      this.authenticated = true
    })
  },

  checkAuthentication: function () {
    // this.authenticated = !!(localStorage.getItem(JWT_KEY))
  },

  getAuthHeader: function () {
    return 'Bearer ' + localStorage.getItem(JWT_KEY)
  },

  showLoginPage: function (to, from) {
    // if (!(localStorage.getItem(JWT_KEY))) {
    //   Hub.$emit('openLoginModal')
    // }
  }

  // navigationRedirecter: function () {
  //   return (to, from, next) => {
  //     if (this.authenticated || to.name === 'Login') {
  //       next()
  //     } else {
  //       next('/login')
  //     }
  //   }
  // }
}

export default authService
