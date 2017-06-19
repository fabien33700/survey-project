import Vue from 'vue'
import Router from 'vue-router'

import Hello from '@/components/Hello'
import Login from '@/components/Login'
import Survey from '@/components/Survey'
import Stats from '@/components/Stats'
import UsersList from '@/components/UsersList'

import authService from '@/services/auth'

authService.init()

Vue.use(Router)

var router = new Router({
  routes: [
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
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
      path: '/stats/:id',
      props: true,
      name: 'Stats',
      component: Stats,
      children: [
        {
          // UserProfile will be rendered inside User's <router-view>
          // when /user/:id/profile is matched
          // name: 'UsersList',
          path: 'users',
          component: UsersList
        }
      ]
    }
  ]
})

router.beforeEach(authService.navigationRedirecter())

export default router
