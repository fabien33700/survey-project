'use strict'

import axios from 'axios'
import authService from '@/services/auth'

var getRequestConfig = function () {
  return {'headers': {'Authorization': authService.getAuthHeader()}}
}

var survey = {

  getAllSurveys: function () {
    return axios.get('http://localhost:8080/api/surveys', getRequestConfig())
  },

  getSurveysFromUser: function (userId) {
    return axios.get('http://localhost:8080/api/surveys/user/' + userId, getRequestConfig())
  },

  getSurveyFromId: function (id) {
    return axios.get('http://localhost:8080/api/surveys/' + id, getRequestConfig())
  },

  postSurveyAnswers: function (response) {
    return axios.post('http://localhost:8080/api/answers/', response, getRequestConfig())
  },

  postNewSurvey: function (newSurvey) {
    return axios.post('http://localhost:8080/api/surveys/', newSurvey, getRequestConfig())
  },

  editSurvey: function (editedSurvey) {
    return axios.put('http://localhost:8080/api/surveys/', editedSurvey, getRequestConfig())
  },

  getSurveyAnswers: function (id) {
    return axios.get('http://localhost:8080/api/answers/' + id, getRequestConfig())
  }
}

export default survey
