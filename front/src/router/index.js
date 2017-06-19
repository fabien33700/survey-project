import Vue from 'vue'
import Router from 'vue-router'
import Hello from '@/components/Hello'
import Survey from '@/components/Survey'
import Stats from '@/components/Stats'
import UsersList from '@/components/UsersList'

Vue.use(Router)

export default new Router({
  routes: [
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
