<template>

  <div class="admin-view">

  <el-menu default-active="2" class="vertical-menu" @open="handleOpen" @close="handleClose">
    <el-submenu index="1">
      <template slot="title"><i class="el-icon-message"></i>Gérer les utilisateurs</template>
      <el-menu-item-group title="Group One">
        <router-link :to="{ name: 'MyPageUsers'}">
          <el-menu-item index="1.2">Liste des utilisateurs</el-menu-item>
        </router-link>
      </el-menu-item-group>
    </el-submenu>
    <router-link :to="{ name: 'MyPageSurveys' }">
      <el-menu-item index="2"><i class="el-icon-menu"></i>Gérer les sondages</el-menu-item>
    </router-link>
    <router-link :to="{ name: 'MyPageStats' }">
      <el-menu-item index="3"><i class="el-icon-setting"></i>Mes statistiques</el-menu-item>
    </router-link>
  </el-menu>

  <router-view class="my-page-view"></router-view>
  <new-user></new-user>
  <edit-user></edit-user>
</div>

</template>

<script>

import NewUser from '@/components/NewUser'
import EditUser from '@/components/EditUser'
import Stats from '@/components/Stats'
// import EditSurvey from '@/components/EditSurvey'
// import Vertx from '../services/vertx.js'

export default {
  name: 'my-page',
  props: ['id'],
  components: { NewUser, EditUser, Stats },

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
.admin-view {
  display: flex;
  height: 100%;
}
.vertical-menu {
  width: 220px;
  height: calc(100vh - 56px);
}

.my-page-view {
  width: calc(100vw - 220px);
  height: calc(100vh - 56px);
}
</style>
