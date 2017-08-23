<template>

  <b-card class="survey-item-detail"
      img="http://placeskull.com/200/200/4FC08D/-1/0">
      {{ survey.question }} 
      <div v-for="item in survey.proposals">
        <b-form-checkbox :value=item >
          {{ item.value }}
        </b-form-checkbox>
     </div>
  </b-card>

</template>



<script>
export default {
  name: 'survey-item-details',
  props: ['survey'],

  data () {
    return {

    }
  },

  mounted () {
    console.log(this.survey)
  }
}

</script>

<style scoped>

.survey-item-detail{
  max-width: 550px;
}

</style>
