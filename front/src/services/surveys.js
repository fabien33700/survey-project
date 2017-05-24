import axios from 'axios'

var survey = {}

survey.getAllSurveys = function () {
  return axios.get('http://localhost:8080/api/surveys')
}

survey.getSurveyFromId = function (id) {
  return axios.get('http://localhost:8080/api/surveys/' + id)
}

survey.postSurveyAnswers = function (response) {
  return axios.post('http://localhost:8080/api/surveysanswers/', response)
}

survey.postNewSurvey = function (newSurvey) {
  return axios.post('http://localhost:8080/api/surveys/', newSurvey)
}
export default survey
