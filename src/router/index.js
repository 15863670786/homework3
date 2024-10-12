import Vue from "vue";
import Index from "@/components/Index.vue";
import Router from 'vue-router';
import Add from "@/components/Add.vue";
import Update from "@/components/Update.vue";

Vue.use(Router)

export default new Router({
  routes:[
    {
      path:'/',name:'Index',component:Index,
    },
    {
      path:'/Add',name:'Add',component:Add,
    },
    {
      path:'/Update',name:'Update',component:Update,
    }
  ]
})
