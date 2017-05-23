import Vue from 'vue'
import Router from 'vue-router'
import Hello from '@/components/Hello'
import Survey from '@/components/Survey'

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
    }
  ]
})
