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
    <div class="flex gap-2 mb-12 items-center justify-center text-center  mt-6">
<span @click="decrementPage()" class="w-12 flex justify-center items-center h-5 border border-[#413e3e] cursor-pointer  hover:border-2 hover:border-blue-600"><-</span>
<span  @click="setPageAndSize(index+1)" v-for="(value,index) in Array(10)" class="w-12 flex h-5 border hover:border-2 hover:border-blue-600  border-[#413e3e] cursor-pointer items-center justify-center">
    {{ index + 1 }}
</span>
<span @click="incrementPage()" class="w-12 h-5 flex items-center justify-center border border-[#413e3e] cursor-pointer  hover:border-2 hover:border-blue-600">-></span>
</div>
</template>
