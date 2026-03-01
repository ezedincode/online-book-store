<script setup>
import { useRouter } from 'vue-router';
import { useAuthStore } from '@/stores/auth';

const router = useRouter();
const authStore = useAuthStore();

function selectCategory(type) {
  authStore.type = type;
  router.push('/books');
}
</script>
<template>
    <div>
        <div class="min-h-[400px] md:h-[732px] m-4 sm:m-6 md:m-12 grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 grid-rows-auto md:grid-rows-2 gap-4 sm:gap-6 [&>*>*]:rounded-[10px] [&>*>*>h2]:z-10">
            <div @click="selectCategory('Fiction')" class="relative cursor-pointer group min-h-[180px] sm:min-h-[200px]">
                <img class="object-cover w-full h-full rounded-[10px] transition-transform duration-500 group-hover:scale-110" src="\src\assets\fiction_category.png" alt="">
                <div class="absolute inset-0 flex justify-center items-end bg-black/40 group-hover:bg-black/20 transition-all duration-300 rounded-[10px]">
                    <h2 class="text-white text-3xl font-bold mb-6">Fiction</h2>
                </div>
            </div>
            
            <div class="border rounded-[10px] flex items-center justify-center border-[#969191] p-6 min-h-[200px] sm:min-h-0">
                <div class="flex flex-col justify-center text-center items-center">
                    <h2 class="text-[#173f5f] text-2xl sm:text-3xl md:text-[35px] font-bold mb-4 sm:mb-6">Explore Our Top Categories</h2>
                    <button @click="selectCategory('All')" class="h-12 sm:h-16 w-32 sm:w-40 bg-[#ed553b] text-white text-lg sm:text-[25px] font-bold rounded-[10px] hover:bg-[#d4432d] shadow-lg transition-all"> View All</button>    
                </div>
            </div>

            <div @click="selectCategory('Academic')" class="relative cursor-pointer group min-h-[180px] sm:min-h-[200px]">
                <img class="object-cover w-full h-full rounded-[10px] transition-transform duration-500 group-hover:scale-110" src="\src\assets\academic_category.png" alt="">
                <div class="absolute inset-0 flex justify-center items-end bg-black/40 group-hover:bg-black/20 transition-all duration-300 rounded-[10px]">
                    <h2 class="text-white text-3xl font-bold mb-6">Academic</h2>
                </div>
            </div>

            <div @click="selectCategory('Technology')" class="relative cursor-pointer group min-h-[180px] sm:min-h-[200px]">
                <img class="object-cover w-full h-full rounded-[10px] transition-transform duration-500 group-hover:scale-110" src="\src\assets\technology_category.png" alt="">
                <div class="absolute inset-0 flex justify-center items-end bg-black/40 group-hover:bg-black/20 transition-all duration-300 rounded-[10px]">
                    <h2 class="text-white text-3xl font-bold mb-6 z-10">Technology</h2>
                </div>
            </div>

            <div @click="selectCategory('Biography')" class="relative cursor-pointer group min-h-[180px] sm:min-h-[200px]">
                <img class="object-cover w-full h-full rounded-[10px] transition-transform duration-500 group-hover:scale-110" src="\src\assets\biography_category.png" alt="">
                <div class="absolute inset-0 flex justify-center items-end bg-black/40 group-hover:bg-black/20 transition-all duration-300 rounded-[10px]">
                    <h2 class="text-white text-3xl font-bold mb-6">Biography</h2>
                </div>
            </div>

            <div @click="selectCategory('Children')" class="relative cursor-pointer group min-h-[180px] sm:min-h-[200px]">
                <img class="object-cover w-full h-full rounded-[10px] transition-transform duration-500 group-hover:scale-110" src="\src\assets\children_category.png" alt="">
                <div class="absolute inset-0 flex justify-center items-end bg-black/40 group-hover:bg-black/20 transition-all duration-300 rounded-[10px]">
                    <h2 class="text-white text-3xl font-bold mb-6">Children</h2>
                </div>
            </div>
        </div>
    </div>
</template>
