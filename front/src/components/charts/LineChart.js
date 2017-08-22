import { Line } from 'vue-chartjs'

export default Line.extend({
  props: ['data', 'option'],
  mounted () {
    this.renderChart(this.data)
  }
})
