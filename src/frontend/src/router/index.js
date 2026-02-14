import { createRouter, createWebHistory } from 'vue-router'
import Home from '@/components/Home.vue'
import signUp from '@/components/signUp.vue'
import Book from '@/components/Book.vue'
import BookItem from '@/components/BookItem.vue'
import Admin from '@/components/Admin.vue'
import unauthorized from '@/components/unauthorized.vue'
import { useAuthStore } from '@/stores/auth'
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    { path: '/',
      name: 'Home',
      component: Home
    },
    {
      path:'/signup',
      name: 'signup',
      component: signUp
    },
    {
      path:'/books',
      name: 'books',
      component: Book
    },
    {
      path:'/bookitem',
      name: 'bookitem',
      component: BookItem
    },
    {
      path:'/admin',
      name: 'admin',
      component: Admin,
      meta: {role: 'Admin'}
    },
    {
      path : '/unauthorized',
      name : 'unauthorized',
      component : unauthorized
    }
  ],
})
router.beforeEach((to, from, next) => {
  const authStore = useAuthStore()
  console.log(authStore.role)
  if(!authStore.role){
    authStore.initialize();
  }
  if (to.meta.role && to.meta.role !== authStore.role) {
    return next('/unauthorized')
  }

  next()
})


export default router
