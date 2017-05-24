// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'

// Bootstrap-vue
import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

// Element Ui
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-default/index.css'
import locale from 'element-ui/lib/locale/lang/en'

// Vue-awesome
import 'vue-awesome/icons'

import VeeValidate from 'vee-validate'
import Icon from 'vue-awesome/components/Icon'

Vue.config.productionTip = false

Vue.use(BootstrapVue)
Vue.use(VeeValidate)
Vue.use(ElementUI, { locale })
Vue.component('icon', Icon)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  template: '<App/>',
  components: { App }
})
