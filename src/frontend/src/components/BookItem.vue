<script setup>
const props = defineProps({
    title:{
        type:String
    },
    author:{
        type:String
    },
    image:{
        type:String
    },
    publishedDate:{
        type:Date
    },
    type:{
        type:String
    },
    description:{
        
    }
})
</script>

<template>
    <div class=" flex h-[40vh] ml-12 overflow-hidden">
        <div class="w-[402px] h-full">
            <img class="h-full rounded-lg" :src="props.image">
        </div>
        <div class="w-[600px] h-full">
            <h1 class="text-[25px] text-[#173f5f]">{{ props.title }}</h1>
            <p>by {{ props.author }}</p>
            <p>published Date: {{ props.publishedDate }}</p>
            <p class="line-clamp-3 text-[#a9a6a6] mt-4">description :{{ props.description }}</p>
            <button class=" mt-10 gap-2 justify-center items-center rounded-[10px] h-12 flex border w-[197px] border-[#173f5f]">VIEW MORE <img class="h-[13px] w-[15px]" src="\src\assets\icons8-arrow-right-24.png" alt=""></button>
        </div>

    </div>
  
</template>