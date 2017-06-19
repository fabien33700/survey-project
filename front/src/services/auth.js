'use strict'

import axios from 'axios'

const BASE_URI = 'http://localhost:8080/'
const LOGIN_URI = 'login/'
const JWT_KEY = 'id_token'

var authService = {
  authenticated: false,

  init: function () {
    this.checkAuthentication()
    axios.defaults.baseURL = BASE_URI
    axios.defaults.headers.common['Authorization'] = this.getAuthHeader()
    axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded'
  },

  login: function (context, creds) {
    axios.post(LOGIN_URI, creds, (data) => {
      localStorage.setItem(JWT_KEY, data.id_token)
      this.authenticated = true
    }).error((err) => console.error(err))
  },

  checkAuthentication: function () {
    this.authenticated = !!(localStorage.getItem(JWT_KEY))
  },

  getAuthHeader: function () {
    return 'Bearer ' + localStorage.getItem(JWT_KEY)
  },

  navigationRedirecter: function () {
    return (to, from, next) => {
      if (this.authenticated || to.name === 'Login') {
        next()
      } else {
        next('/login')
      }
    }
  }
}

export default authService
