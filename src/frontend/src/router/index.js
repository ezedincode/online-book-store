import { createRouter, createWebHistory } from 'vue-router'
import Home from '@/components/Home.vue'
import signUp from '@/components/signUp.vue'
import Book from '@/components/Book.vue'
import BookItem from '@/components/BookItem.vue'
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
    }
  ],
})

export default router
