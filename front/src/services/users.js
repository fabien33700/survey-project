import axios from 'axios'

var user = {}

user.getAllUsers = function () {
  return axios.get('http://localhost:8080/api/users')
}

export default user
