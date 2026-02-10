<script setup>
import {ref} from 'vue';
import { useAuthStore } from '@/stores/auth';
import { useRouter } from 'vue-router';

const router = useRouter();
const authStore = useAuthStore();

async function login(){
    try{
        const data = await authStore.login();
        console.log()
        router.push('/signup');
    }catch (e) {
        console.log("error login")
    }
}

</script>

<template>
    <div class=" h-[553px]   ml-12 mr-12 flex ">
        <div class="bg-gradient-to-r from-[#fceded] to-[#f9f9f9] w-1/2">
        <div class="ml-14 mt-20 ">
            <div class="flex items-center justify-start ">
                <svg width="30" height="2">
                    <line x1="0" y1="1" x2="25" y2="1" stroke="#ed553b" stroke-width="2"/>
                    </svg>
                    <p class="text-[#ed553b]">ebook</p>
            </div>
            <div class=""><p class="text-[35px] text-[#173f5f] font-bold">Access, Read ,Practice & Engage with Digital Content (eBook)</p></div>
            <p class="leading-7 mt-6 text-[#7a7777]">Unlock digital eBooks anytime, anywhere with instant access.
            Read interactively, practice with embedded exercises, and track progress.</p>
                <div class="flex  mt-8 items-center">
                <input v-model="authStore.LoginForm.username" class="w-3/4 rounded-[10px] outline-none px-8 rounded-r-[0px] placeholder:pl-5 h-14" type="text" placeholder="Enter Your user name Address">
                </div>
            <div class="flex  mt-8 items-center">
                <input v-model="authStore.LoginForm.password" class="w-3/4 rounded-[10px] outline-none px-8 rounded-r-[0px] placeholder:pl-5 h-14" type="text" placeholder="Enter Your Passwor ">
                <button @click="login" class="h-14 w-1/4 rounded-[10px] rounded-l-[0px] bg-[#ed553b] font-bold text-[20px] text-white">Login</button>
            </div>
        </div>
        </div>
        <div class="">
            <img class="w-full h-full" src="\src\assets\olia-gozha-J4kK8b9Fgj8-unsplash.jpg" alt="">
        </div>
        
    </div>
</template>