<template>

  <el-table
   ref="multipleTable"
   :data="users"
   height="250"
   border
   style="width: 100%"
   @selection-change="handleSelectionChange">
   <el-table-column
    type="selection"
    width="55">
    </el-table-column>
    <el-table-column
      type="index"
      width="50">
    </el-table-column>
   <el-table-column
     prop="pseudo"
     label="Login"
     width="180">
   </el-table-column>
   <el-table-column
     prop="role"
     label="Role"
     width="180">
   </el-table-column>
   <el-table-column
     prop="sondages"
     label="Sondages">
   </el-table-column>
 </el-table>

</template>


<script>
import UserDao from '@/services/users.js'

export default {
  name: 'users-list',
  data () {
    return {
      users: {}
    }
  },

  methods: {
    handleSelectionChange (val) {
      this.multipleSelection = val
    }
  },

  mounted () {
    UserDao.getAllUsers()
    .then((response) => {
      this.users = response.data
    }).catch(function (error) {
      console.log(error)
    })
  }
}

</script>

<style scoped>

</style>
