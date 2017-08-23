<template>
    <b-modal id="modal3" ref="modal3" title="Authentification" @ok="onSubmit"
             ok-title="Valider"
             :ok-only=options.okOnly
             :hide-header-close=options.hideHeaderClose
             :close-on-backdrop=options.closeOnEsc
             :close-on-esc=options.closOnBackDrop
             @cancel="save">

        <b-form-fieldset
         label="Login"
         :state="stateLogin"
         :label-size="1">

         <b-form-input v-model="authentication.username"></b-form-input>

       </b-form-fieldset>
       <b-form-fieldset
        label="Password"
        :state="statePassword"
        :label-size="1">

        <b-form-input type="password" v-model="authentication.password"></b-form-input>

      </b-form-fieldset>
      <!-- <el-form ref="form">
        <el-form-item>
          <el-input placeholder="Login" v-model="authentication.username"></el-input>
        </el-form-item>
        <el-form-item>
          <el-input type="password" placeholder="Password" v-model="authentication.password"></el-input>
        </el-form-item>
      </el-form> -->
      <el-alert
        v-if="error"
        title="Echec de l'authentification"
        description="Mot de passe ou login incorrect."
        type="error"
        @close="resetAlert"
        show-icon>
      </el-alert>
    </b-modal>
</template>

<script>
import authService from '@/services/auth'
import Hub from '@/events/EventBus.js'

export default {
  name: 'Login',

  data () {
    return {
      authentication: {
        username: '',
        password: ''
      },
      options: {
        closeOnEsc: false,
        closOnBackDrop: false,
        okOnly: true,
        hideHeaderClose: true
      },
      saved: false,
      error: false
    }
  },

  methods: {
    onSubmit: function (e) {
      authService.login(this.authentication)
      .then(() => {
        Hub.$emit('update-surveys')
        this.$refs.modal3.hide()
      })
      .catch(() => {
        this.error = true
      })
    },

    save (e) {
      e.cancel()
      this.username = ''
      this.password = ''
    },

    resetAlert: function () {
      this.error = false
    }
  },

  computed: {
    stateLogin () {
      return this.authentication.username.length ? 'success' : ''
    },

    statePassword () {
      return this.authentication.password.length ? 'success' : ''
    }
  }
}
</script>

<!-- Add 'scoped' attribute to limit CSS to this component only -->
<style scoped>
.modal { display: block; }
</style>
