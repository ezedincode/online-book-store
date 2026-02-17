<script setup>
import {ref} from 'vue';
import { useAuthStore } from '@/stores/auth';
import { useRouter } from 'vue-router';

const router = useRouter();
const authStore = useAuthStore();

async function login(){
    try{
        const data = await authStore.login();
        console.log(data.value);

        if(data.value == "Admin"){
            router.push('/admin')
        }
        else if (data.value == 'User'){router.push('/books');}
        
    }catch (e) {
        console.log("error login")
    }
}
function routetoSignUp() {
    router.push('signup');
}



</script>

<template>
    <div class="min-h-[600px] flex flex-col md:flex-row mx-4 md:mx-12 my-8 md:my-12 bg-white rounded-3xl shadow-xl overflow-hidden border border-slate-100">
        <div class="bg-gradient-to-br from-[#fceded] to-[#f9f9f9] w-full md:w-1/2 p-8 md:p-14 flex flex-col justify-center">
            <div class="max-w-md mx-auto w-full">
                <div class="flex items-center justify-start gap-2 mb-4">
                    <div class="w-8 h-0.5 bg-[#ed553b]"></div>
                    <p class="text-[#ed553b] font-bold text-sm uppercase tracking-widest">ebook</p>
                </div>
                <h1 class="text-3xl md:text-[35px] text-[#173f5f] font-bold leading-tight mb-6">
                    Access, Read, Practice & Engage with Digital Content
                </h1>
                <p class="leading-relaxed text-[#7a7777] mb-8 text-sm md:text-base">
                    Unlock digital eBooks anytime, anywhere with instant access.
                    Read interactively, practice with embedded exercises, and track progress.
                </p>

                <div class="space-y-4">
                    <div class="flex relative items-center group">
                        <span class="absolute left-4 text-slate-400 group-focus-within:text-[#ed553b] transition-colors">
                            <svg class="w-5 h-5" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M16 7a4 4 0 11-8 0 4 4 0 018 0zM12 14a7 7 0 00-7 7h14a7 7 0 00-7-7z" />
                            </svg>
                        </span>
                        <input v-model="authStore.LoginForm.username" class="w-full rounded-xl border-2 border-slate-100 outline-none pl-12 pr-8 focus:border-[#ed553b] focus:ring-4 focus:ring-[#ed553b]/10 transition-all placeholder:text-slate-300 h-14 bg-white" type="text" placeholder="Username">
                    </div>

                    <div class="flex relative items-center group">
                        <span class="absolute left-4 text-slate-400 group-focus-within:text-[#ed553b] transition-colors">
                            <svg class="w-5 h-5" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 15v2m-6 4h12a2 2 0 002-2v-6a2 2 0 00-2-2H6a2 2 0 00-2 2v6a2 2 0 00-2 2zm10-10V7a4 4 0 00-8 0v4h8z" />
                            </svg>
                        </span>
                        <input v-model="authStore.LoginForm.password" class="w-full rounded-xl border-2 border-slate-100 outline-none pl-12 pr-8 focus:border-[#ed553b] focus:ring-4 focus:ring-[#ed553b]/10 transition-all placeholder:text-slate-300 h-14 bg-white" type="password" placeholder="Password">
                    </div>

                    <button @click="login" class="w-full h-14 rounded-xl bg-[#ed553b] hover:bg-[#d4432d] active:scale-[0.98] transition-all font-bold text-lg text-white shadow-lg shadow-[#ed553b]/20">
                        Login to Account
                    </button>
                </div>

                <div class="flex flex-col sm:flex-row justify-between items-center mt-8 gap-4 px-2">
                    <p @click="routetoSignUp()" class="text-sm font-semibold text-slate-500 hover:text-[#ed553b] cursor-pointer transition-colors flex items-center gap-2 group">
                        New here? 
                        <span class="text-[#ed553b] group-hover:underline decoration-2 underline-offset-4">Create an account</span>
                    </p>
                    <p class="text-xs text-slate-400 hover:text-slate-600 cursor-pointer transition-colors">Forgot password?</p>
                </div>
            </div>
        </div>
        <div class="w-full md:w-1/2 h-64 md:h-auto">
            <img class="w-full h-full object-cover" src="\src\assets\olia-gozha-J4kK8b9Fgj8-unsplash.jpg" alt="Login Branding">
        </div>
    </div>
</template>