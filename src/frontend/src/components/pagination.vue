<script setup>
import { useAuthStore } from '@/stores/auth';

const authStore = useAuthStore();
function decrementPage(){
    console.log(authStore.page)
    if(authStore.page === 1){
        return;
    }
    authStore.page--;
}
function incrementPage(){
    authStore.page++;
}
function setPageAndSize(page){
    authStore.page = page;
    console.log(authStore.page)
}
</script>

<template>
    <div class="flex flex-wrap gap-2 mb-16 items-center justify-center mt-10 px-4">

        <button 
            @click="decrementPage()" 
            :disabled="Number(authStore.page) <= 1"
            class="w-12 h-12 flex justify-center items-center rounded-2xl border-2 border-slate-100 bg-white text-slate-400 hover:border-[#ed553b] hover:text-[#ed553b] disabled:opacity-30 disabled:cursor-not-allowed transition-all duration-300 shadow-sm group"
            title="Previous Page"
        >
            <svg class="w-5 h-5 group-hover:-translate-x-0.5 transition-transform" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M15 19l-7-7 7-7" />
            </svg>
        </button>

             <button 
            v-for="i in 5" 
            :key="i"
            @click="setPageAndSize(i)" 
            class="w-12 h-12 flex items-center justify-center rounded-2xl border-2 font-bold transition-all duration-300 shadow-sm"
            :class="Number(authStore.page) === i 
                ? 'bg-[#173f5f] border-[#ed173f5f553b] text-white shadow-lg shadow-[#ed553b]/20 scale-110 z-10' 
                : 'bg-white border-slate-100 text-slate-600 hover:border-[#173f5f] hover:text-[#173f5f] hover:shadow-md'"
        >
            {{ i }}
        </button>

        <div class="w-8 h-12 flex items-center justify-center text-slate-300 font-bold">...</div>

        <button 
            @click="incrementPage()" 
            class="w-12 h-12 flex justify-center items-center rounded-2xl border-2 border-slate-100 bg-white text-slate-400 hover:border-[#ed553b] hover:text-[#ed553b] transition-all duration-300 shadow-sm group"
            title="Next Page"
        >
            <svg class="w-5 h-5 group-hover:translate-x-0.5 transition-transform" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M9 5l7 7-7 7" />
            </svg>
        </button>
    </div>
</template>
