<script setup>
import { useRouter } from 'vue-router';
import BookItem from './BookItem.vue';
import book8 from '@/assets/book8.jpg'
import { useAuthStore } from '@/stores/auth';
import {ref,onMounted,onUnmounted} from 'vue';
import pagination from './pagination.vue';
import Pagination from './pagination.vue';

const authStore = useAuthStore();

const showHeader = ref(true)
let lastScrollY = window.scrollY
console.log(showHeader.value)
const onScroll =() => {
    const currentScrollY = window.scrollY
    if(currentScrollY > lastScrollY && currentScrollY > 50){
        showHeader.value = false;
        }
        else{
            showHeader.value = true 
        }
        lastScrollY = currentScrollY
    }
onMounted( () => {
    window.addEventListener('scroll',onScroll)
})
onUnmounted(() => {
    window.removeEventListener('scroll',onScroll)
})
const router = useRouter();

function navigateHome () {
    router.push('/')
}



</script>
<template>
    <div class="flex flex-col">
        <div class="fixed bg-white  transition-transform duration-300 top-0 left-0 w-full z-50  flex flex-col" :class="showHeader ? 'translate-y-0' : '-translate-y-full'">
        <div class="flex justify-between ml-7 mt-8 mr-7 items-center">
            <div @click="navigateHome" class="cursor-pointer ml-5">
                <svg width="20px" height="20px" viewBox="0 0 16 16" fill="#00008B" xmlns="http://www.w3.org/2000/svg">
                <path d="M1 6V15H6V11C6 9.89543 6.89543 9 8 9C9.10457 9 10 9.89543 10 11V15H15V6L8 0L1 6Z" fill="#00008B"/>
                </svg>
            </div>
            <div class="flex"> 
                <input v-model="authStore.keyword" type="text" class="pl-10 w-[40vw] outline-none rounded-r-[0px] py-2 border rounded-[20px] bg-[#ededf0]" placeholder="Search Book">
                <select v-model="authStore.type" class=" border text-white [&>*]:bg-white [&>*]:text-[#00008B] h-12 rounded-lg pl-6 bg-[#00008B] rounded-l-[0px]">
                <option value="All" >All</option>
                <option value="Academic">Academic</option>
                <option value="Biography">Biography</option>
                <option value="Children">Children</option>
                <option value="Fiction">Fiction</option>
                <option value="Technology">Technology</option>
                <option value="Art">Art</option>
                <option value="NonFiction">NonFiction</option>
            </select>
            </div>
            <div class="flex gap-5 ">
        <p class="text-[13px] font-bold flex gap-2 text-[#00008B] border-r border-[#a9a9b2] h-5 pr-2">
            <span class="mt-0.5"><svg fill="#00008B" width="17px" height="17px" viewBox="0 0 32 32" id="Outlined" xmlns="http://www.w3.org/2000/svg"><title/> <g id="Fill"> <path d="M24,17H8a5,5,0,0,0-5,5v7H5V22a3,3,0,0,1,3-3H24a3,3,0,0,1,3,3v7h2V22A5,5,0,0,0,24,17Z"/> <path d="M16,15a6,6,0,1,0-6-6A6,6,0,0,0,16,15ZM16,5a4,4,0,1,1-4,4A4,4,0,0,1,16,5Z"/> </g>
            </svg></span> ACCOUNT</p>
        <p class="text-[13px] font-bold flex gap-2 text-[#00008B] border-r border-[#a9a9b2] h-5 pr-2">
            <span class="mt-0.5"><svg width="17px" height="17px" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
            <path d="M3.74181 20.5545C4.94143 22 7.17414 22 11.6395 22H12.3607C16.8261 22 19.0589 22 20.2585 20.5545M3.74181 20.5545C2.54219 19.1091 2.95365 16.9146 3.77657 12.5257C4.36179 9.40452 4.65441 7.84393 5.7653 6.92196M3.74181 20.5545C3.74181 20.5545 3.74181 20.5545 3.74181 20.5545ZM20.2585 20.5545C21.4581 19.1091 21.0466 16.9146 20.2237 12.5257C19.6385 9.40452 19.3459 7.84393 18.235 6.92196M20.2585 20.5545C20.2585 20.5545 20.2585 20.5545 20.2585 20.5545ZM18.235 6.92196C17.1241 6 15.5363 6 12.3607 6H11.6395C8.46398 6 6.8762 6 5.7653 6.92196M18.235 6.92196C18.235 6.92196 18.235 6.92196 18.235 6.92196ZM5.7653 6.92196C5.7653 6.92196 5.7653 6.92196 5.7653 6.92196Z" stroke="#1C274C" stroke-width="1.5"/>
            <path d="M9 6V5C9 3.34315 10.3431 2 12 2C13.6569 2 15 3.34315 15 5V6" stroke="#1C274C" stroke-width="1.5" stroke-linecap="round"/>
            </svg></span>
            CART:(0$)</p>
        <p class="text-[13px] font-bold flex gap-1 text-[#00008B] h-5 pr-2">
            <span class="mt-0.5">
                <svg width="17px" height="17px" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
            <path d="M15.7 4C18.87 4 21 6.98 21 9.76C21 15.39 12.16 20 12 20C11.84 20 3 15.39 3 9.76C3 6.98 5.13 4 8.3 4C10.12 4 11.31 4.91 12 5.71C12.69 4.91 13.88 4 15.7 4Z" stroke="#000000" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
            </svg>
            </span>
            WISHLIST</p>
    </div>
     
        </div>
    <div class="h-12 bg-[#173f5f] mt-5 flex justify-center gap-10 text-white items-center">
      <router-link to="/" class="font-bold border-r h-6 pr-[50px] hover:text-indigo-200 transition-colors">HOME</router-link>
      <router-link to="/about" class="border-r h-6 pr-14 hover:text-indigo-200 transition-colors uppercase">About Us</router-link>
      <router-link to="/books" class="border-r h-6 pr-14 hover:text-indigo-200 transition-colors uppercase">Books</router-link>
      <router-link to="/new-release" class="border-r h-6 pr-14 hover:text-indigo-200 transition-colors uppercase">New Release</router-link>
      <router-link to="/contact" class="border-r h-6 pr-14 hover:text-indigo-200 transition-colors uppercase">Contact Us</router-link>
      <router-link to="/blog" class="hover:text-indigo-200 transition-colors uppercase">Blog</router-link>
    </div>
  </div>
  <div class="pt-[140px] px-6 md:px-12 flex flex-col gap-3 min-h-[400px]">
    <!-- Books List -->
    <template v-if="authStore.books && authStore.books.length > 0">
      <div class="mt-3 [&>*]:rounded-[10px]" v-for="book in authStore.books" :key="book.id"> 
        <BookItem 
          :id="book.id"
          :description="book.description" 
          :title="book.title" 
          :author="book.author" 
          :image="book.image" 
          :published-date="book.publishedDate" 
          :type="book.type"
          :role="authStore.role"
          :storage-url="book.storageUrl"
        ></BookItem>
      </div>
      <Pagination></Pagination>
    </template>

    <!-- Empty State -->
    <div v-else-if="!authStore.isLoading" class="flex flex-col items-center justify-center py-20 px-4 text-center bg-slate-50 rounded-3xl border-2 border-dashed border-slate-200 mt-8">
      <div class="w-20 h-20 bg-white rounded-full flex items-center justify-center shadow-sm mb-6">
        <svg class="w-10 h-10 text-slate-300" fill="none" stroke="currentColor" viewBox="0 0 24 24">
          <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 6.253v13m0-13C10.832 5.477 9.246 5 7.5 5S4.168 5.477 3 6.253v13C4.168 18.477 5.754 18 7.5 18s3.332.477 4.5 1.253m0-13C13.168 5.477 14.754 5 16.5 5c1.747 0 3.332.477 4.5 1.253v13C19.832 18 18.247 18 16.5 18c-1.746 0-3.332.477-4.5 1.253"></path>
        </svg>
      </div>
      <h3 class="text-2xl font-serif font-bold text-slate-800 mb-2">No books found</h3>
      <p class="text-slate-500 max-w-md mx-auto leading-relaxed">
        We couldn't find any volumes matching your current selection. <br>
        Try adjusting your keywords or exploring a different category.
      </p>
      <button @click="authStore.keyword = ''; authStore.type = 'All'" class="mt-8 px-6 py-2 bg-[#173f5f] text-white rounded-xl font-bold hover:bg-indigo-600 transition-colors">
        Clear all filters
      </button>
    </div>

    <!-- Loading State (Optional, but good for UX) -->
    <div v-else class="flex justify-center py-20">
      <div class="animate-spin rounded-full h-12 w-12 border-4 border-indigo-500 border-t-transparent"></div>
    </div>
  </div>
  
    </div>
</template>