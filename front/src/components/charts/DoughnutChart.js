import { Doughnut } from 'vue-chartjs'

export default Doughnut.extend({
  props: ['data', 'option'],
  mounted () {
    this.renderChart(this.data)
  }
})
