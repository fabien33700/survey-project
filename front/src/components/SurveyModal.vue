<template>
  <b-modal id="modal1" title="Submit your name" @shown="init()">

    <!-- <form @submit.stop.prevent="submit">
      <b-form-input type="text" placeholder="Enter your name" v-model="name"></b-form-input>
    </form> -->

  </b-modal>
</template>


<script>
export default {
  name: 'survey-modal',
  // props: ['data']

  methods: {
    init: function () {
      console.log('here')
    }
  }
}
</script>

<style scoped>
</style>
