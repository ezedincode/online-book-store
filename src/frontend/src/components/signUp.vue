<script setup>
    import { ref} from 'vue'
    import { EyeIcon, EyeSlashIcon } from '@heroicons/vue/24/outline'
    import { useAuthStore } from '@/stores/auth';
    import { useRouter } from 'vue-router';

    const route = useRouter();
    const authStore =useAuthStore();
    const showPassword = ref(false);
    const is_registered = ref(true);
    async function submit(){
        await authStore.register();
       if(authStore.role === 'Admin'){
        route.push('/admin');
       }
       else{
        route.push('/books')
       }
    }
</script>

<template>
    <div class="grid grid-cols-[2fr_3fr] gap-3 min-h-screen w-full">
        <div class="flex flex-col gap-3 ml-20 mt-8">
            <div class="text-red-700" v-if="authStore.error">user Name already taken</div>
            <h1 class="text-[35px] font-bold font-sans">Sign Up</h1>
            <p class="text-[17px]  mb-2 text-[#999797]">Sign up to enjoy the feature of e-book</p>
            <div class="flex flex-col gap-4">
                <!-- <div class="relative">
                    <input v-model="authStore.registerForm.username" type="text" placeholder="" class="w-5/6 px-4 py-3 border-2 border-gray-200 rounded-lg focus:outline-none focues:border-blue">
                <span class="absolute -top-3 left-4 bg-white px-2 text-gray-500 text-sm">Your Name</span>
                </div> -->
                <div class="relative">
                    <input  v-model="authStore.registerForm.username" type="text" placeholder="" class="w-5/6 px-4 py-3 border-2 border-gray-200 rounded-lg focus:outline-none focues:border-blue">
                <span class="absolute -top-3 left-4 bg-white px-2 text-gray-500 text-sm">User Name</span>
                </div>
                <div class="relative">
                    <input v-model="authStore.registerForm.email" type="text" placeholder="" class="w-5/6 px-4 py-3 border-2 border-gray-200 rounded-lg focus:outline-none focues:border-blue">
                <span class="absolute -top-3 left-4 bg-white px-2 text-gray-500 text-sm">Email</span>
                </div>
                <div class="relative">
                    <input v-model="authStore.registerForm.password" type="text" placeholder="Password" class=" w-5/6 px-4 py-3 border-2 border-gray-200 rounded-lg focus:outline-none placeholder:text-gray-500 absolute focues:border-blue">
                    <button type="button" @click="showPassword = !showPassword" class=" top-3 right-18">
                        <EyeIcon v-if="!showPassword" class="w-5 h-5 text-gray-500"/>
                        <EyeSlashIcon v-if="showPassword" class="w-5 h-5 text-gray-500" />
                    </button>
                </div>
            </div>
            <div>
                
            </div>
            <button @click="submit" class="w-5/6 mt-8 h-12 rounded-lg text-white font-bold text-[17px] bg-blue-600"> Sign Up</button>
            <span class="text-blue-800  w-5/6 underline text-center underline-offset-auto cursor-pointer">Forget password?</span>
            <div class="relative w-5/6">
            <hr class=" mt-3 border-[#a7a4a4]">
            <span class="absolute w-5 h-5 px-1 bg-white -top-0.5 left-1/2">or</span>
            </div>
            
            <div class="flex justify-center w-5/6 mt-3">
                <p class="text-[#918e8e]">Already have an account?? <span class="text-blue-800 underline underline-offset-auto cursor-pointer">Sign in</span></p>
            </div>
        </div>
        <div class="h-full">
            <img class="h-full" src="\src\assets\stockof_books.jpg" alt="">
        </div>
            
    </div>
</template>