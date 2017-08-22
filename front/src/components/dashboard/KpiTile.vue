<template>
  <!-- <b-card class="tile"> -->
    <div class="kpi-core">
      <div class="adjust-font">
        {{ content.number }}
      </div>
      <div class="adjust-font">
        {{ content.description }}
      </div>
    </div>
  <!-- </b-card> -->
</template>

<script>
export default {
  name: 'kpi-tile',
  props: ['content']
}

</script>

<style scoped>
/*.tile {
  display: block;
  height: 100%;
  width: 100%;
}*/

.kpi-core {
  display: block;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  box-sizing: border-box;
}

.adjust-font {
  text-align: center;
  display: block;
}
</style>
