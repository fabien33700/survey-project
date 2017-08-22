<template>

  <div class='dashboard'>
      <grid-layout
              class='dashboard-grid'
              :layout='layout'
              :col-num='12'
              :row-height='65'
              :is-draggable='true'
              :is-resizable='true'
              :vertical-compact='true'
              :margin='[10, 10]'
              :use-css-transforms='true'
      >
          <grid-item v-for='(item, index) in layout'
                     :key='stats[index].id'
                     class='dashboard-tile'
                     :x='item.x'
                     :y='item.y'
                     :w='item.w'
                     :h='item.h'
                     :i='item.i'
                     @resize='resizeEvent'>
              <b-card class='tile'
                show-header
                show-footer>
                <div slot='header' class='tile-header'>
                  <div class='header-actions'>
                    <div size='small' class='tile-header-button'>
                      <icon name='thumb-tack'></icon>
                    </div>
                    <div size='small' class='tile-header-button'>
                      <icon name='trash-o'></icon>
                    </div>
                  </div>
                </div>
                <bar-chart ref="barchart" class="dashboard-chart" v-if="isChartType(item.i, 'bar')" :data="tileContent(index)" :height='calcHeight(item.y)' :width='calcWidth(item.w)'></bar-chart>
                <kpi-tile v-if="isChartType(item.i, 'kpi')" :content="tileContent(index)"></kpi-tile>
                <survey-answers-table v-if="isChartType(item.i, 'table-answer')" :id="tileContent(index)"></survey-answers-table>
                <table-survey v-if="isChartType(item.i, 'table-survey')" :id="tileContent(index)"></table-survey>
                <small slot='footer' class='tile-footer'></small>
              </b-card>
          </grid-item>
      </grid-layout>
  </div>
</template>

<script>

import KpiTile from '@/components/dashboard/KpiTile'
import VueGridLayout from 'vue-grid-layout'
import BarChart from '@/components/charts/BarChart.js'
import Vuetable from 'vuetable-2'
import SurveyAnswersTable from '@/components/tables/SurveyAnswersTable'
import TableSurvey from '@/components/tables/TableSurvey'

import _ from 'lodash'
import $ from 'jquery'

const SIZE = {
  small: 2,
  medium: 4,
  big: 6,
  max: 12
}

var dashboardColSize

var GridLayout = VueGridLayout.GridLayout
var GridItem = VueGridLayout.GridItem

export default {
  name: 'stats',
  props: ['content'],
  components: { KpiTile, GridLayout, GridItem, BarChart, Vuetable, SurveyAnswersTable, TableSurvey },
  data () {
    return {
      layout: [],
      stats: this.content
    }
  },

  methods: {
    tileContent (idx) {
      return this.stats[idx].data
    },
    calcHeight (nbRows) {
      return calculateHeight(nbRows)
    },
    calcWidth (nbCols) {
      return calculateWidth(nbCols)
    },
    isChartType (item, type) {
      return item.startsWith(type)
    },
    resizeEvent (i, newH, newW) {
      calculateChartNewSize(i, newH, newW, this)
    }
  },

  mounted () {
    // Initialisation de la grille
    this.layout = initGrid(this.content)
    dashboardColSize = calcColSize()
  }
}

function initGrid (data) {
  let startX = 0
  let currentRowIndex = 0
  return _.map(data, function (item, idx) {
    let nbWidth = size(item.width)
    let nbHeight = size(item.height)
    let elem = {
      x: startX,
      y: rowIdx(startX, currentRowIndex, nbWidth),
      w: nbWidth,
      h: nbHeight,
      i: item.type + '_' + idx
    }
    if (currentRowIndex !== elem.y) {
      startX = 0
      elem.x = 0
    }
    startX += elem.w
    currentRowIndex = elem.y
    return elem
  })
}

function rowIdx (startX, idx, width) {
  return width > (12 - startX) ? idx + 1 : idx
}

function size (size) {
  switch (size) {
    case 'small':
      return SIZE.small
    case 'big':
      return SIZE.big
    case 'max':
      return SIZE.max
    case 'medium':
    default:
      return SIZE.medium
  }
}

function calcColSize () {
  return $('.dashboard')[0].clientWidth / 12
}

function calculateHeight (nbRows) {
  return nbRows * 95
}

function calculateWidth (nbCols) {
  return (nbCols * dashboardColSize) - 50
}

function calculateChartNewSize (i, newH, newW, vm) {}

</script>

<style>
.tile .card-header {
  opacity: 0;
  position: absolute;
  z-index: 10;
  width: 100%;
  background: rgba(0, 0, 0, 0.05);
  border: none;
}

.tile .card-header:hover {
  opacity: 1
}

.header-actions {
  display: flex;
  justify-content: flex-end;
}

.tile-header-button {
  display: inline-block;
  line-height: 1;
  white-space: nowrap;
  cursor: pointer;
  margin: 0;
  padding: 7px 9px;
  font-size: 12px;
  border-radius: 4px;
  box-sizing: border-box;
  outline: 0;
  text-align: center;
}

.tile-header-button+.tile-header-button {
    margin-left: 10px;
}

.tile {
  display: block;
  height: 100%;
  width: 100%;
  position: relative;
}

.tile .card-block {
  overflow: auto;
}

.tile-footer {
  height:
}

.charts {
  height: 100%;
}

.dashboard {
  overflow: auto;
  background-color: #757575;
}
.dashboard-chart {
  position: relative;
  height: 100%;
}
</style>
