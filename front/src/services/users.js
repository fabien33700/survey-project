'use strict'

import axios from 'axios'

var user = {

  getAllUsers: function () {
    return axios.get('http://localhost:8080/api/users')
  },

  addUser: function (newUser) {
    return axios.get('http://localhost:8080/api/users', newUser)
  },

  editUser: function (editedUser) {
    return axios.put('http://localhost:8080/api/users', editedUser)
  }
}

export default user
