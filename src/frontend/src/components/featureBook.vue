<script setup>
const source = 5;
</script>

<template>
    <div class="h-[596px]  flex mt-24 ml-12 ">
        <div class="w-[402px]">
            <img class=" h-[402px] " src="\src\assets\book8.jpg" alt="">
        </div>
        <div class="w-[600px]">
            <p class="text-[#a9a6a6] mt-7">Feature Book of the week</p>
            <h1 class="text-[25px] text-[#173f5f]">The Art of war</h1>
            <div class="flex mt-4">
                <img class=" w-[20px] h-20px" v-for="i in source" :key="i" src="\src\assets\icons8-star-48.png" alt="">
            </div>
            <p class="text-[#a9a6a6] mt-4">Sun Tzu's The Art of War is an ancient military classic emphasizing strategy over brute force. It teaches victory through deception, adaptability, and psychological insight. Its principles apply beyond warfare to business, politics, and life.</p>
            <button class=" mt-10 gap-2 justify-center items-center rounded-[10px] flex border w-[197px] h-[61px] border-[#173f5f]">VIEW MORE <img class="h-[13px] w-[15px]" src="\src\assets\icons8-arrow-right-24.png" alt=""></button>
        </div>

    </div>
</template>