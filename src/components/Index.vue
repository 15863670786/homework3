<template>
  <div class="background"> <!-- 确保使用了背景类 -->
    <h1 style="text-align: center;">个人通讯录系统</h1>
    <el-table
      :data="tableData"
      border
      style="width: 100%; background-color: rgba(249, 249, 249, 0.8);">
      <el-table-column
        prop="name"
        label="姓名"
        width="180"
        style="background-color: rgba(255, 255, 255, 0.8); color: #333;">
      </el-table-column>
      <el-table-column
        prop="number"
        label="电话"
        width="180"
        style="background-color: rgba(255, 255, 255, 0.8); color: #333;">
      </el-table-column>
      <el-table-column
        prop="address"
        label="地址"
        style="background-color: rgba(255, 255, 255, 0.8); color: #333;">
      </el-table-column>
      <el-table-column
        label="操作"
        style="background-color: rgba(255, 255, 255, 0.8);">
        <template v-slot="{row}">
          <el-button type="success" :plain="true" style="background-color: #409EFF; color: #fff;" @click="add()">添加</el-button>
          <el-button type="primary" :plain="true" style="background-color: #67C23A; color: #fff;" @click="update(row)">修改</el-button>
          <el-button type="danger" :plain="true" style="background-color: #F56C6C; color: #fff;" @click="deleteById(row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<style scoped>
body, html {
  height: 100%;          /* 使整个页面的高度为100% */
  margin: 0;            /* 去掉默认的 margin */
}

.background {
  background-image: url('https://img2.baidu.com/it/u=1884190276,2072646686&fm=253&fmt=auto&app=120&f=JPEG?w=1721&h=800'); /* 替换为你的背景图片 */
  background-size: cover; /* 使背景图片覆盖整个区域 */
  background-repeat: no-repeat; /* 不重复背景图 */
  background-position: center; /* 背景图居中 */
  height: 100vh; /* 设置高度为视口高度的100% */
  display: flex; /* 使用 flexbox 来居中内容 */
  flex-direction: column; /* 使内容在纵向上排列 */
  justify-content: center; /* 垂直居中内容 */
  align-items: center; /* 水平居中内容 */
}
</style>

<script>
export default({
  name: 'Index',
  mounted(){
    this.show();
  },
  methods:{
    show(){
      this.$http({
        method:"post",
        url:'phone/show',
      }).then(res=>{
        if (res.data.code===200){
          this.tableData=res.data.data
        }
      })
    },
    add(){
      this.$router.push({path:"Add"})
    },
    update(row){
      this.$router.push({path:'Update',query:{row:row}})
    },
    deleteById(id){
      this.$http({
        method:'post',
        url:'phone/delete',
        params:{
          id:id,
        }
      }).then(res=>{
        if (res.data.code===200){
          this.show()
          this.$message({
            showClose: true,
            message: '删除成功',
            type: 'success'
          })
        }
      })
    }
  },
  data() {
    return {
      tableData: []
    }
  }
})
</script>
