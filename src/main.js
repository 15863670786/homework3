import Vue from 'vue'
import App from './App.vue'
import axios from "axios";
import ElementUI from "element-ui";
import router from "@/router";
import 'element-ui/lib/theme-chalk/index.css';


Vue.use(ElementUI);
Vue.config.productionTip = false
Vue.prototype.$http=axios
axios.defaults.baseURL="http://localhost:8080"

new Vue({
  router,
  render: h => h(App),
}).$mount('#app')
