<template>
  <b-modal id="modal5" title="Modifier un utilisateur"
    @ok="onSubmit"
    ok-title="Modifier">

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

import Hub from '@/events/EventBus.js'
import userService from '@/services/users.js'

const roleOptions = [
  { text: 'VIEWER', value: 'VIEWER' },
  { text: 'ADMIN', value: 'ADMIN' },
  { text: 'WRITTER', value: 'WRITTER' }
]

const userEdited = {
  title: 'Success',
  message: 'Utilisateur modifié avec succès.',
  type: 'success'
}

// const userTmp = {
//   pseudo: '',
//   password: '',
//   passwordConfirm: '',
//   age: 0,
//   role: roleOptions[0]
// }

export default {
  name: 'edit-user',

  data () {
    return {
      user: {},
      options: roleOptions
    }
  },

  created () {
    Hub.$on('set-edit-user-data', (surv) => (this.user = surv))
  },

  methods: {
    onSubmit () {
      userService.editUser(this.user)
        .then((response) => {
          this.$notify(userEdited)
        })
        .catch((err) => { console.log(err) })
    }
  }
}

</script>

<style scoped>

</style>
