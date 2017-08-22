<template>
  <b-modal id="modal4" title="Créer un nouvel utilisateur"
    @ok="onSubmit"
    @shown="clear"
    ok-title="Créer">

  <div class="user-modal">
    <form >

        <b-form-fieldset
           label="Pseudo"
           :label-size="1"
           >
           <b-form-input v-model="user.pseudo"></b-form-input>
       </b-form-fieldset>

       <b-form-fieldset
          label="Password"
          :label-size="1"
          >
          <b-form-input v-model="user.password"></b-form-input>

        </b-form-fieldset>

        <b-form-fieldset
           label="Confirmez password"
           :label-size="1"
           >
           <b-form-input v-model="user.passwordConfirm"></b-form-input>

         </b-form-fieldset>


        <b-form-fieldset
           label="Age"
           :label-size="1"
           >

           <b-form-input type="number" v-model="user.age"></b-form-input>

          </b-form-fieldset>

          <b-form-fieldset
             label="Role"
             :label-size="1"
             >

             <b-form-select
              v-model="user.role"
              :options="options"
              calss="mb-3">

             </b-form-select>

            </b-form-fieldset>

        </form>
    </div>
  </b-modal>
</template>


<script>

import _ from 'lodash'
import Hub from '@/events/EventBus.js'
import UserService from '@/services/users.js'

const roleOptions = [
  { text: 'VIEWER', value: 'VIEWER' },
  { text: 'ADMIN', value: 'ADMIN' },
  { text: 'WRITTER', value: 'WRITTER' }
]

const userTmp = {
  pseudo: '',
  password: '',
  passwordConfirm: '',
  age: 0,
  role: roleOptions[0]
}

const successToast = {
  title: 'Success',
  message: 'Utilisateur crée.',
  type: 'success'
}

const errorToast = {
  title: 'Error',
  message: 'Echec de la création de l\'utilisateur.',
  type: 'error'
}

export default {
  name: 'new-user',
  data () {
    return {
      user: {},
      options: roleOptions
    }
  },

  methods: {
    onSubmit () {
      UserService.addUser(this.user)
        .then((response) => {
          this.$notify(successToast)
          Hub.$emit('newUser', this.user)
        })
        .catch(() => {
          this.$notify(errorToast)
        })
    },

    clear () {
      this.user = _.cloneDeep(userTmp)
    }
  }
}
</script>



<style scoped>


</style>
