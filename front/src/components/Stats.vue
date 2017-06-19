<template>

  <div class="admin-view">

  <el-menu default-active="2" router="true" class="vertical-menu" @open="handleOpen" @close="handleClose">
    <el-submenu index="1">
      <template slot="title"><i class="el-icon-message"></i>Gérer les utilisateurs</template>
      <el-menu-item-group title="Group One">
        <el-menu-item index="1/users">Liste des utilisateurs</el-menu-item>
        <!-- <el-menu-item index="1-2">item one</el-menu-item> -->
      <!-- </el-menu-item-group>
      <el-menu-item-group title="Group Two">
        <el-menu-item index="1-3">item three</el-menu-item> -->
      </el-menu-item-group>
      <!-- <el-submenu index="1-4">
        <template slot="title">item four</template>
        <el-menu-item index="1-4-1">item one</el-menu-item>
      </el-submenu> -->
    </el-submenu>
    <el-menu-item index="2"><i class="el-icon-menu"></i>Gérer les sondages</el-menu-item>
    <el-menu-item index="3"><i class="el-icon-setting"></i>Navigator Three</el-menu-item>
  </el-menu>

  <router-view></router-view>

</div>

</template>

<script>

// import Vertx from '../services/vertx.js'

export default {
  name: 'Stats',
  props: ['id'],

  methods: {
    handleOpen (key, keyPath) {
      console.log(key, keyPath)
    },
    handleClose (key, keyPath) {
      console.log(key, keyPath)
    }
  }
}

</script>


<style scoped>
.vertical-menu {
  width: 220px;
  height: calc(100vh - 56px);
}

.container-fluid {
  padding: 0 !important;
}

.admin-view {
  display: flex;
}
</style>
