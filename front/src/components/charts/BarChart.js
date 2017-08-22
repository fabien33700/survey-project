import { Bar } from 'vue-chartjs'

export default Bar.extend({
  props: ['data', 'option'],
  mounted () {
    // Overwriting base render method with actual data.
    this.renderChart(this.data, {responsive: true})
  }
})
