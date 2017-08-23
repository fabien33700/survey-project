import Vue from 'vue'
import Router from 'vue-router'

import Hello from '@/components/Hello'
// import Login from '@/components/Login'
import Survey from '@/components/Survey'
import MyPage from '@/components/MyPage'
import UsersList from '@/components/UsersList'
import SurveysList from '@/components/SurveysList'
import Stats from '@/components/Stats'
import StatsSurvey from '@/components/StatsSurvey'

import authService from '@/services/auth'

authService.init()

Vue.use(Router)

var router = new Router({
  routes: [
    // {
    //   path: '/login',
    //   name: 'Login',
    //   component: Login
    // },
    {
      path: '/',
      name: 'Hello',
      component: Hello
    },
    {
      path: '/surveys/:id',
      props: true,
      name: 'Survey',
      component: Survey
    },
    {
      path: '/mypage/:id',
      props: true,
      name: 'MyPage',
      component: MyPage,
      children: [
        {
          name: 'MyPageUsers',
          path: 'users',
          component: UsersList
        },
        {
          name: 'MyPageSurveys',
          path: 'surveys',
          component: SurveysList
        },
        {
          name: 'MyPageStats',
          path: 'stats',
          component: Stats
        },
        {
          name: 'MyPageStatsSurvey',
          path: 'survey/:surveyId',
          component: StatsSurvey
        }
      ]
    }
  ]
})

// router.beforeEach(authService.showLoginPage)

router.afterEach(authService.showLoginPage)

export default router
