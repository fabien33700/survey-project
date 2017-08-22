<template>
  <dashboard :content="dashboardContent"></dashboard>
</template>

<script>

// TODO: Récupérer les données du serveur

import Dashboard from '@/components/dashboard/Dashboard'

const kpis = [
  {
    id: 0,
    type: 'kpi',
    data: {
      number: 50,
      description: 'Nombre de participations'
    },
    height: 'small',
    width: 'medium'
  },
  {
    id: 1,
    type: 'kpi',
    data: {
      number: 10,
      description: 'Nombre de sondages crées'
    },
    height: 'small',
    width: 'medium'
  },
  {
    id: 2,
    type: 'kpi',
    data: {
      number: 100,
      description: 'bla bla bla'
    },
    height: 'small',
    width: 'medium'

  },
  {
    id: 3,
    height: 'big',
    width: 'big',
    type: 'bar',
    chartHeight: 0,
    chartWidth: 0,
    data: {
      labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'],
      datasets: [
        {
          label: 'GitHub Commits',
          backgroundColor: '#f87979',
          data: [40, 20, 12, 39, 10, 40, 39, 80, 40, 20, 12, 11]
        }
      ]
    }
  },
  {
    height: 'big',
    width: 'max',
    type: 'table-answer',
    data: {
      surveyId: 1
    }
  }
]

export default {
  name: 'stats',
  components: { Dashboard },
  data () {
    return {
      dashboardContent: kpis
    }
  }
}

</script>

<style scoped>
</style>
