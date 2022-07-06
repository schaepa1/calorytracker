import { createRouter, createWebHistory } from '@ionic/vue-router';
import { RouteRecordRaw } from 'vue-router';
import Tabs from '../views/Tabs.vue'
import Login from '../views/Login.vue'

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    redirect: '/login'
  },
  {
    path: '/login',
    component: Login,
  },
  {
    path: '/tabs/',
    component: Tabs,
    children: [
      {
        path: '',
        redirect: '/tabs/tab1'
      },
      {
        path: 'dailyConsumption',
        component: () => import('@/views/DailyConsumption.vue')
      },
      {
        path: 'newProduct',
        component: () => import('@/views/NewProduct.vue')
      },
      {
        path: 'scan',
        component: () => import('@/views/Scan.vue')
      },
      {
        path: 'demandCalculator',
        component: () => import('@/views/DemandCalculator.vue')
      },
      {
        path: 'demandResults',
        component: () => import('@/views/DemandResults.vue')
      },
    ]
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
