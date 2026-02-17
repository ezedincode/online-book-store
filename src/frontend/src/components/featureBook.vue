<script setup>
import { useRouter } from 'vue-router';
import { useAuthStore } from '@/stores/auth';

const router = useRouter();
const authStore = useAuthStore();

const source = 5;

function viewFeaturedBook() {
  // Pre-fill search for "The Art of war"
  authStore.keyword = "The Art of War";
  authStore.type = "All";
  router.push('/books');
}
</script>

<template>
    <div class="h-auto flex flex-col lg:flex-row mt-12 md:mt-24 px-6 md:px-12 items-center gap-10 lg:gap-16 py-10">
        <div class="w-full max-w-[402px] lg:w-[402px] shrink-0">
            <img class="w-full h-auto lg:h-[402px] rounded-2xl shadow-2xl transition-transform hover:scale-105 duration-500" src="\src\assets\book8.jpg" alt="Featured Book">
        </div>
        <div class="w-full lg:w-[600px] flex flex-col items-center lg:items-start text-center lg:text-left">
            <div class="inline-flex items-center px-4 py-1.5 rounded-full bg-indigo-50 text-indigo-600 font-bold text-xs uppercase tracking-widest mb-6">
                Featured Book of the week
            </div>
            <h1 class="text-4xl md:text-5xl font-serif font-black text-[#173f5f] mb-6 tracking-tight">The Art of War</h1>
            <div class="flex gap-1 mb-8">
                <svg v-for="i in source" :key="i" class="w-5 h-5 md:w-6 md:h-6 text-amber-400 fill-current" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20">
                    <path d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z" />
                </svg>
            </div>
            <p class="text-slate-500 text-base md:text-lg leading-relaxed mb-10 font-serif italic border-l-4 border-indigo-100 pl-6 max-w-2xl">
                "Sun Tzu's The Art of War is an ancient military classic emphasizing strategy over brute force. It teaches victory through deception, adaptability, and psychological insight."
            </p>
            <button @click="viewFeaturedBook" class="group flex items-center gap-3 px-8 py-4 bg-[#173f5f] text-white rounded-2xl hover:bg-indigo-600 transition-all duration-300 shadow-xl shadow-indigo-100 font-bold tracking-wider active:scale-95">
                DISCOVER MORE 
                <svg class="w-5 h-5 group-hover:translate-x-1 transition-transform" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                  <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M17 8l4 4m0 0l-4 4m4-4H3" />
                </svg>
            </button>
        </div>
    </div>
</template>