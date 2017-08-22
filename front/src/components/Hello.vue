<template>
  <div id="app" class="container-fluid">

    <!-- Nav Bar  -->
    <div class="filter-bar">
      <!-- <b-button-toolbar>
        <b-button-group>
          <b-button>Left</b-button>
          <b-button>Middle</b-button>
          <b-button>Right</b-button>
        </b-button-group>
      </b-button-toolbar> -->
      <el-button type="primary" v-b-modal.modal2>Créer un sondage</el-button>
        <el-input
          placeholder="Search..."
          @input="filter('filterByText')"
          class="search-survey"
          icon="search"
          v-model="search" >
        </el-input>
  </div>
    <!-- <b-navbar toggleable variant="secondary" class="no-margin">
      <b-nav-toggle target="nav_collapse"></b-nav-toggle>
      <b-button variant="primary" v-b-modal.modal2>
        <span>Créer un sondage</span>
      </b-button>
      <b-collapse is-nav id="nav_collapse">
    </b-collapse>
  </b-navbar> -->

  <isotope ref="cpt" :options='option' :list="surveys" @filter="filterOption=arguments[0]" @sort="sortOption=arguments[0]"
           :item-selector="'element-item'" @layout="currentLayout=arguments[0]"
           class="row">
      <div v-for="item in surveys" class="col-4" :key="item.id">
        <survey-item :survey="item" ></survey-item>
      </div>
  </isotope>

    <!-- <div class="row">
      <div v-for="(item, index) in surveys" class="col-4">
        <survey-item :survey="item" ></survey-item>
      </div>
   </div> -->

   <!-- <b-button variant="primary" class="rounded-circle fab-button" v-b-modal.modal2>
     <icon name="plus" scale="2" label="Créer un sondage"></icon>
   </b-button> -->

 </div>
</template>

<script>

import SurveyDao from '@/services/surveys.js'
import SurveyItem from '@/components/SurveyItem'
import Isotope from 'vueisotope'

export default {
  name: 'hello',

  components: { SurveyItem, Isotope },

  data () {
    return {
      search: '',
      surveys: [],
      selected: null,
      sortOption: null,
      filterOption: null,
      option: {
        itemSelector: '.element-item',
        getFilterData: {
          isEven: function (el) {
            return el.id % 2 === 0
          },
          isOdd: function (el) {
            return el.id % 2 !== 0
          },
          filterByText: function (el) {
            return el.name.toLowerCase().includes(this.$parent.search.toLowerCase()) ||
                   el.author.toLowerCase().includes(this.$parent.search.toLowerCase()) ||
                   el.question.toLowerCase().includes(this.$parent.search.toLowerCase())
          }
        },
        getSortData: {
          name: 'name',
          id: 'id'
        }
      }
    }
  },

  methods: {
    // sort: function(key) {
    // this.$refs.cpt.sort(key)
    // },
    // filter: function(key) {
    // this.$refs.cpt.filter(key)
    // },
    // changeLayout: function(key) {
    // this.$refs.cpt.layout(key)
    // },
    filter: function (key) {
      this.$refs.cpt.filter(key)
    }
  },

  computed: {
    filterText: function () {
      return this.search
    }
  },

  mounted () {
    SurveyDao.getAllSurveys()
      .then((response) => {
        this.surveys = response.data
      }).catch(function (error) {
        console.log(error)
      })
  }
}

</script>

<!-- Add 'scoped' attribute to limit CSS to this component only -->
<style scoped>

.filter-bar {
  padding-top: 15px;
  padding-bottom: 15px;
  display: flex;
  justify-content: space-between;
}

.fab-button{
  /*border-radius: 50%;*/
  height: 70px;
  width: 70px;
  position: fixed;
  z-index: 10;
  bottom: 0;
  right: 0;
  margin-bottom: 15px;
  margin-right: 15px;
  display: flex;
  justify-content: center;
}

.search-survey {
  width:200px;
}
</style>
