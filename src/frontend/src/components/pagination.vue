<script setup>
import { useAuthStore } from '@/stores/auth';
import { computed } from 'vue';

const authStore = useAuthStore();

const visiblePages = computed(() => {
    const total = authStore.totalPages;
    const current = Number(authStore.page);
    const range = 2; // Show 2 pages before and after the current page
    
    let start = Math.max(1, current - range);
    let end = Math.min(total, current + range);
    
    // Adjust if near the start
    if (current <= range) {
        end = Math.min(total, 1 + (range * 2));
    }
    
    // Adjust if near the end
    if (current > total - range) {
        start = Math.max(1, total - (range * 2));
    }

    const pages = [];
    for (let i = start; i <= end; i++) {
        pages.push(i);
    }
    return pages;
});

const showTrailingDots = computed(() => {
    const total = authStore.totalPages;
    const current = Number(authStore.page);
    return total > 5 && (current + 2) < total;
});

const showLastPage = computed(() => {
    const total = authStore.totalPages;
    const current = Number(authStore.page);
    return total > 5 && (current + 2) < total;
})

function decrementPage(){
    console.log(authStore.page)
    if(Number(authStore.page) === 1){
        return;
    }
    authStore.page--;
}
function incrementPage(){
    if(Number(authStore.page) >= authStore.totalPages){
        return;
    }
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
            v-for="page in visiblePages" 
            :key="page"
            @click="setPageAndSize(page)" 
            class="w-12 h-12 flex items-center justify-center rounded-2xl border-2 font-bold transition-all duration-300 shadow-sm"
            :class="Number(authStore.page) === page 
                ? 'bg-[#173f5f] border-[#173f5f] text-white shadow-lg shadow-[#173f5f]/20 scale-110 z-10' 
                : 'bg-white border-slate-100 text-slate-600 hover:border-[#173f5f] hover:text-[#173f5f] hover:shadow-md'"
        >
            {{ page }}
        </button>

        <div v-if="showTrailingDots" class="w-8 h-12 flex items-center justify-center text-slate-300 font-bold">...</div>

        <button 
            v-if="showLastPage"
            @click="setPageAndSize(authStore.totalPages)" 
            class="w-12 h-12 flex items-center justify-center rounded-2xl border-2 font-bold transition-all duration-300 shadow-sm bg-white border-slate-100 text-slate-600 hover:border-[#173f5f] hover:text-[#173f5f] hover:shadow-md"
        >
            {{ authStore.totalPages }}
        </button>

        <button 
            @click="incrementPage()" 
            :disabled="Number(authStore.page) >= authStore.totalPages"
            class="w-12 h-12 flex justify-center items-center rounded-2xl border-2 border-slate-100 bg-white text-slate-400 hover:border-[#173f5f] hover:text-[#173f5f] disabled:opacity-30 disabled:cursor-not-allowed transition-all duration-300 shadow-sm group"
            title="Next Page"
        >
            <svg class="w-5 h-5 group-hover:translate-x-0.5 transition-transform" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M9 5l7 7-7 7" />
            </svg>
        </button>
    </div>
</template>
