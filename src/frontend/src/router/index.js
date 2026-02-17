import { createRouter, createWebHistory } from 'vue-router'
import Home from '@/components/Home.vue'
import signUp from '@/components/signUp.vue'
import Book from '@/components/Book.vue'
import BookItem from '@/components/BookItem.vue'
import Admin from '@/components/Admin.vue'
import unauthorized from '@/components/unauthorized.vue'
import AboutUs from '@/components/AboutUs.vue'
import ContactUs from '@/components/ContactUs.vue'
import Blog from '@/components/Blog.vue'
import NewRelease from '@/components/NewRelease.vue'
import { useAuthStore } from '@/stores/auth'
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home,
      meta: { requiresAuth: false }
    },
    {
      path: '/signup',
      name: 'signup',
      component: signUp,
      meta: { requiresAuth: false }
    },
    {
      path: '/books',
      name: 'books',
      component: Book,
      meta: { requiresAuth: true, role: ['User', 'Admin'] }
    },
    {
      path: '/bookitem',
      name: 'bookitem',
      component: BookItem
    },
    {
      path: '/admin',
      name: 'admin',
      component: Admin,
      meta: { requiresAuth: true, role: ['Admin'] }
    },
    {
      path: '/about',
      name: 'about',
      component: AboutUs
    },
    {
      path: '/contact',
      name: 'contact',
      component: ContactUs
    },
    {
      path: '/blog',
      name: 'blog',
      component: Blog
    },
    {
      path: '/new-release',
      name: 'new-release',
      component: NewRelease
    },
    {
      path: '/unauthorized',
      name: 'unauthorized',
      component: unauthorized
    }
  ],
})
router.beforeEach((to, from, next) => {
  const authStore = useAuthStore();
  if (!authStore.role) {
    authStore.initialize();
  }
  if (!to.meta.requiresAuth) {
    return next()
  }
  if (to.meta.role && !to.meta.role.includes(authStore.role)) {
    return next('/unauthorized')
  }
  console.log(authStore.role)



  next()
})


export default router
