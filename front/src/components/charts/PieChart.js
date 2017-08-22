import { Pie } from 'vue-chartjs'

export default Pie.extend({
  props: ['data', 'option'],
  mounted () {
    this.renderChart(this.data)
  }
})
