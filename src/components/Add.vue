<template>
  <div style="background-image: url('https://q1.itc.cn/q_70/images03/20240128/a96446f9bf9a4c118951c31843337370.jpeg'); background-size: cover; background-repeat: no-repeat; background-position: center;">
    <el-form ref="form" :model="form" label-width="80px" style="background-color: rgba(85, 85, 85, 0.8); padding: 20px; border-radius: 8px;">
      <el-form-item style="margin-bottom: 15px;">
        <span style="color: #ff9900;">姓名</span>
        <el-input v-model="form.name" style="background-color: #444444; border: 1px solid #777777; border-radius: 4px; padding: 8px 12px; color: #ffffff; width: 700px;">
        </el-input>
      </el-form-item>
      <el-form-item style="margin-bottom: 15px;">
        <span style="color: #00ccff;">电话</span>
        <el-input v-model="form.number" style="background-color: #444444; border: 1px solid #777777; border-radius: 4px; padding: 8px 12px; color: #ffffff; width: 700px;">
        </el-input>
      </el-form-item>
      <el-form-item style="margin-bottom: 15px;">
        <span style="color: #99ff99;">地址</span>
        <el-input type="textarea" v-model="form.address" style="background-color: #444444; border: 1px solid #777777; border-radius: 4px; padding: 8px 12px; color: #ffffff; width: 700px; height: 80px;">
        </el-input>
      </el-form-item>
      <el-form-item style="margin-top: 100px;">
        <el-button type="primary" @click="onSubmit" style="background-color: #009966; border-color: #009966; color: #ffffff;">添加</el-button>
        <el-button @click="forback" style="margin-left: 10px; background-color: #666666; border-color: #777777; color: #cccccc;">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<style scoped>

</style>

<script>
export default {
  name: 'Add',
  methods: {
    onSubmit() {
      this.$http({
        method: 'post',
        url: 'phone/add',
        data: {
          name: this.form.name,
          number: this.form.number,
          address: this.form.address
        }
      }).then(res => {
        if (res.data.code === 200) {
          this.$message({
            showClose: true,
            message: '添加成功',
            type: 'success',
          })
          this.$router.push({ path: '/' })
        }
      })
    },
    forback() {
      this.$router.push({ path: '/' })
    }
  },
  data() {
    return {
      form: {
        name: '',
        number: '',
        address: '',
      }
    }
  },
}
</script>
