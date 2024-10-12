<template>
  <div style="background-image: url('https://img1.baidu.com/it/u=1360347520,1922694507&fm=253&fmt=auto?w=889&h=500'); background-size: cover; background-repeat: no-repeat; background-position: center;">
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
        <el-button type="primary" @click="onSubmit" style="background-color: #409EFF; border-color: #409EFF; color: #ffffff;">修改</el-button>
        <el-button @click="forback()" style="margin-left: 10px; background-color: #ffffff; border-color: #dcdfe6; color: #606266;">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<style scoped>

</style>

<script>
export default {
  name: 'Update',
  mounted() {
    this.init();
  },
  methods: {
    init() {
      this.form = this.$route.query.row;
    },
    onSubmit() {
      this.$http({
        method: 'post',
        url: 'phone/update',
        data: {
          id: this.form.id,
          name: this.form.name,
          number: this.form.number,
          address: this.form.address
        }
      }).then(res => {
        if (res.data.code === 200) {
          this.$message({
            showClose: true,
            message: '修改成功',
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
        id: '',
        name: '',
        number: '',
        address: '',
      }
    }
  }
}
</script>
