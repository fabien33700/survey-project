<template>

  <div class="user-table">

    <div class="menu-action">
      <el-button type="primary" v-b-modal.modal4>Ajouter un utilisateur</el-button>
      <el-button>Supprimer</el-button>
    </div>


    <div class="table">
      <el-table ref="multipleTable" :data="users" border style="width: 100%" @selection-change="handleSelectionChange">
       <el-table-column
        type="selection"
        width="65">
        </el-table-column>
        <el-table-column
          type="index"
          width="65">
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
         prop="age"
         label="Age"
         width="180">
       </el-table-column>
       <el-table-column label="Sondages">
         <template scope="scope">
           <div class="survey-column">
            <div v-for="item in scope.row.surveys" class="survey-item">
              <el-button> {{ item.name }}</el-button>
            </div>
          </div>
        </template>
       </el-table-column>
       <el-table-column
        label="Operations">
        <template scope="scope">
          <el-button
            size="small"
            @click="handleEdit(scope.$index, scope.row)">Edit</el-button>
          <el-button
            size="small"
            type="danger"
            @click="handleDelete(scope.$index, scope.row)">Delete</el-button>
        </template>
      </el-table-column>
     </el-table>
   </div>
 </div>

</template>


<script>

import UserDao from '@/services/users.js'
import Hub from '@/events/EventBus.js'

export default {
  name: 'users-list',
  data () {
    return {
      users: [
        {
          pseudo: 'anne',
          role: 'ADMIN',
          surveys: [
            {
              id: 1,
              name: 'Sondage_1'
            },
            {
              id: 2,
              name: 'Sondage_2'
            }
          ],
          age: 29
        }
      ]
    }
  },

  methods: {
    handleSelectionChange (val) {
      this.multipleSelection = val
    },
    handleEdit (index, row) {
      this.$root.$emit('show::modal', 'modal5')
      Hub.$emit('set-edit-user-data', row)
      console.log(index, row)
    },
    handleDelete (index, row) {
      console.log(index, row)
    }
  },

  created () {
    Hub.$on('newUser', (user) => {
      this.users.push(user)
    })
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

.user-table {
  display: block;
  padding: 24px;
  height: 100%;
}

.survey-item {
  padding: 10px;
}

.survey-column {
  display: flex;
  flex-direction: row;
}

.menu-action {
  display: flex;
  justify-content: flex-end;
}

.table {
  padding-top: 24px;
}
</style>
