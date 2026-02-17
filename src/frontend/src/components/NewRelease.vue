<template>
  <div class="min-h-screen bg-slate-50 pt-32 pb-20 px-4">
    <div class="max-w-6xl mx-auto">
      <div class="flex flex-col md:flex-row justify-between items-end mb-12 gap-6">
        <div>
          <h1 class="text-5xl font-serif font-bold text-slate-800 mb-2">New Releases</h1>
          <p class="text-xl text-slate-500">Fresh off the press and ready for your collection</p>
        </div>
        <button @click="router.push('/books')" class="px-6 py-3 bg-[#173f5f] text-white rounded-xl font-bold hover:shadow-lg hover:-translate-y-1 transition-all">
          Explore All Books
        </button>
      </div>

      <div class="grid md:grid-cols-2 lg:grid-cols-4 gap-8">
        <div v-for="i in 8" :key="i" class="bg-white p-6 rounded-3xl shadow-sm border border-slate-100 hover:border-indigo-200 transition-colors group">
          <div class="aspect-[2/3] bg-slate-100 rounded-2xl mb-6 shadow-md overflow-hidden relative">
            <div class="absolute inset-0 flex items-center justify-center text-slate-400 font-bold">Book Cover</div>
            <div class="p-2 absolute top-0 right-0">
               <span class="bg-emerald-500 text-white text-[10px] uppercase font-bold px-2 py-1 rounded-md">New</span>
            </div>
          </div>
          <h3 class="text-lg font-bold text-slate-800 mb-1 truncate">Shadow of the Digital</h3>
          <p class="text-slate-500 text-sm mb-4">By Author Name</p>
          <div class="flex items-center justify-between">
            <span class="text-indigo-600 font-bold">$24.99</span>
            <button class="p-2 rounded-lg bg-slate-50 text-[#173f5f] hover:bg-indigo-50 transition-colors">
              <svg class="w-5 h-5" fill="none" stroke="currentColor" viewBox="0 0 24 24"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 4v16m8-8H4"/></svg>
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { useRouter } from 'vue-router';
const router = useRouter();
</script>
