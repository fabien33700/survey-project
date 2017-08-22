'use strict'

import axios from 'axios'

var survey = {

  getAllSurveys: function () {
    return axios.get('http://localhost:8080/api/surveys')
  },

  getSurveysFromUser: function (userId) {
    return axios.get('http://localhost:8080/api/surveys/user/' + userId)
  },

  getSurveyFromId: function (id) {
    return axios.get('http://localhost:8080/api/surveys/' + id)
  },

  postSurveyAnswers: function (response) {
    return axios.post('http://localhost:8080/api/answers/', response)
  },

  postNewSurvey: function (newSurvey) {
    return axios.post('http://localhost:8080/api/surveys/', newSurvey)
  },

  editSurvey: function (editedSurvey) {
    return axios.put('http://localhost:8080/api/surveys/', editedSurvey)
  },

  getSurveyAnswers: function (id) {
    return axios.get('http://localhost:8080/api/answers/' + id)
  }
}

export default survey
