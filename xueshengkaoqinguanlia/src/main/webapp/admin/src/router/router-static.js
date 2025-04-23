import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

     import users from '@/views/modules/users/list'
    import dictionary from '@/views/modules/dictionary/list'
    import fudaoyuan from '@/views/modules/fudaoyuan/list'
    import jiaoshi from '@/views/modules/jiaoshi/list'
    import kaoqin from '@/views/modules/kaoqin/list'
    import kaoqinguanli from '@/views/modules/kaoqinguanli/list'
    import kaoqinxiangqing from '@/views/modules/kaoqinxiangqing/list'
    import kecheng from '@/views/modules/kecheng/list'
    import news from '@/views/modules/news/list'
    import xueshengqingjia from '@/views/modules/xueshengqingjia/list'
    import yonghu from '@/views/modules/yonghu/list'
    import dictionaryKaoqinxiangqingStatus from '@/views/modules/dictionaryKaoqinxiangqingStatus/list'
    import dictionaryKecheng from '@/views/modules/dictionaryKecheng/list'
    import dictionaryNews from '@/views/modules/dictionaryNews/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryXueshengqingjia from '@/views/modules/dictionaryXueshengqingjia/list'
    import dictionaryXueshengqingjiaYesno from '@/views/modules/dictionaryXueshengqingjiaYesno/list'
    import dictionaryZhuanye from '@/views/modules/dictionaryZhuanye/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryKaoqinxiangqingStatus',
        name: '考勤状态',
        component: dictionaryKaoqinxiangqingStatus
    }
    ,{
        path: '/dictionaryKecheng',
        name: '课程类型',
        component: dictionaryKecheng
    }
    ,{
        path: '/dictionaryNews',
        name: '公告类型',
        component: dictionaryNews
    }
    ,{
        path: '/dictionarySex',
        name: '性别',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryXueshengqingjia',
        name: '请假类型',
        component: dictionaryXueshengqingjia
    }
    ,{
        path: '/dictionaryXueshengqingjiaYesno',
        name: '审核结果',
        component: dictionaryXueshengqingjiaYesno
    }
    ,{
        path: '/dictionaryZhuanye',
        name: '专业',
        component: dictionaryZhuanye
    }


    ,{
        path: '/dictionary',
        name: '字典表',
        component: dictionary
      }
    ,{
        path: '/fudaoyuan',
        name: '辅导员',
        component: fudaoyuan
      }
    ,{
        path: '/jiaoshi',
        name: '教师',
        component: jiaoshi
      }
    ,{
        path: '/kaoqin',
        name: '考勤通知',
        component: kaoqin
      }
    ,{
        path: '/kaoqinguanli',
        name: '院系考勤管理',
        component: kaoqinguanli
      }
    ,{
        path: '/kaoqinxiangqing',
        name: '考勤详情',
        component: kaoqinxiangqing
      }
    ,{
        path: '/kecheng',
        name: '课程信息',
        component: kecheng
      }
    ,{
        path: '/news',
        name: '公告信息',
        component: news
      }
    ,{
        path: '/xueshengqingjia',
        name: '学生请假',
        component: xueshengqingjia
      }
    ,{
        path: '/yonghu',
        name: '学生',
        component: yonghu
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
