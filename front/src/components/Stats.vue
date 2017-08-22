<template>

  <dashboard :content="dashboardContent"></dashboard>

</template>

<script>

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
    width: 'small'
  },
  {
    id: 1,
    type: 'kpi',
    data: {
      number: 10,
      description: 'Nombre de sondages crées'
    },
    height: 'medium',
    width: 'big'
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
    type: 'kpi',
    data: {
      number: 500,
      description: 'blfthfhh a bla bla'
    },
    height: 'medium',
    width: 'big'
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
  },
  {
    height: 'big',
    width: 'max',
    type: 'table-survey',
    data: {
      user: {
        id: 1,
        pseudo: 'anne',
        role: 'ADMIN'
      }
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

<style>
</style>
