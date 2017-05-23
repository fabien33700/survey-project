import axios from 'axios'

var survey = {}

survey.getAllSurveys = function () {
  return axios.get('http://localhost:8080/surveys')
}

survey.getSurveyFromId = function (id) {
  return axios.get('http://localhost:8080/surveys/',
    {
      params: {
        surveyId: id
      }
    })
}

export default survey
