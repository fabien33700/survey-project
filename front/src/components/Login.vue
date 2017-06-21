<template>
  <div id="app" class="container-fluid">
    Login : <input type="text" v-model="username" />
    Password : <input type="password" v-model="password" />
  </div>
</template>

<script>

export default {
  name: 'Login',

  data () {
    return {
      username: '',
      password: ''
    }
  }
}

</script>

<!-- Add 'scoped' attribute to limit CSS to this component only -->
<style scoped>


</style>
