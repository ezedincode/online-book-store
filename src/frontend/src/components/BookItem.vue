<script setup>
import { defineEmits } from 'vue';
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
        type:String
    },
    id:{
        type:Number
    },
    role: {
        type:String
    }
})
const emit = defineEmits(['delete','edit']);
function emitEdit(id){
    emit('edit',id);
}
function emitDelete(id){
    console.log(id)
    emit('delete',id);
}
</script>

<template>
    <div class=" flex h-[40vh] ml-12 overflow-hidden mr-12">
        <div class="w-[402px] h-full">
            <img class="h-full rounded-lg" :src="props.image">
        </div>
        <div class="w-[600px] h-full flex justify-between">
            <div>
            <h1 class="text-[25px] text-[#173f5f]">{{ props.title }}</h1>
            <p>by {{ props.author }}</p>
            <p>published Date: {{ props.publishedDate }}</p>
            <p class="line-clamp-3 text-[#a9a6a6] mt-4">description :{{ props.description }}</p>
            <button class=" mt-10 gap-2 justify-center items-center rounded-[10px] h-12 flex border w-[197px] border-[#173f5f]">VIEW MORE <img class="h-[13px] w-[15px]" src="\src\assets\icons8-arrow-right-24.png" alt=""></button>
            </div>
            <div v-if="props.role==='Admin'" class="flex flex-col gap-5 justify-center items-end">
                <div @click="emitDelete(props.id)" class="border-[2px] border-red-600 w-32 hover:cursor-pointer h-10 flex items-center justify-center gap-2">
                    <svg fill="#000000" width="20px" height="20px" viewBox="0 0 1024 1024" xmlns="http://www.w3.org/2000/svg"><path d="M831.24 280.772c5.657 0 10.24-4.583 10.24-10.24v-83.528c0-5.657-4.583-10.24-10.24-10.24H194.558a10.238 10.238 0 00-10.24 10.24v83.528c0 5.657 4.583 10.24 10.24 10.24H831.24zm0 40.96H194.558c-28.278 0-51.2-22.922-51.2-51.2v-83.528c0-28.278 22.922-51.2 51.2-51.2H831.24c28.278 0 51.2 22.922 51.2 51.2v83.528c0 28.278-22.922 51.2-51.2 51.2z"/><path d="M806.809 304.688l-58.245 666.45c-.544 6.246-6.714 11.9-12.99 11.9H290.226c-6.276 0-12.447-5.654-12.99-11.893L218.99 304.688c-.985-11.268-10.917-19.604-22.185-18.619s-19.604 10.917-18.619 22.185l58.245 666.45c2.385 27.401 26.278 49.294 53.795 49.294h445.348c27.517 0 51.41-21.893 53.796-49.301l58.244-666.443c.985-11.268-7.351-21.201-18.619-22.185s-21.201 7.351-22.185 18.619zM422.02 155.082V51.3c0-5.726 4.601-10.342 10.24-10.342h161.28c5.639 0 10.24 4.617 10.24 10.342v103.782c0 11.311 9.169 20.48 20.48 20.48s20.48-9.169 20.48-20.48V51.3c0-28.316-22.908-51.302-51.2-51.302H432.26c-28.292 0-51.2 22.987-51.2 51.302v103.782c0 11.311 9.169 20.48 20.48 20.48s20.48-9.169 20.48-20.48z"/><path d="M496.004 410.821v460.964c0 11.311 9.169 20.48 20.48 20.48s20.48-9.169 20.48-20.48V410.821c0-11.311-9.169-20.48-20.48-20.48s-20.48 9.169-20.48 20.48zm-192.435 1.767l39.936 460.964c.976 11.269 10.903 19.612 22.171 18.636s19.612-10.903 18.636-22.171l-39.936-460.964c-.976-11.269-10.903-19.612-22.171-18.636s-19.612 10.903-18.636 22.171zm377.856-3.535l-39.936 460.964c-.976 11.269 7.367 21.195 18.636 22.171s21.195-7.367 22.171-18.636l39.936-460.964c.976-11.269-7.367-21.195-18.636-22.171s-21.195 7.367-22.171 18.636z"/></svg>
                    <p>DELETE</p>
                </div>
                <div  @click="emitEdit(props.id)" class="border-[2px] hover:cursor-pointer border-green-600 w-32 h-10 flex items-center justify-center gap-2">
                    
                    <svg width="20px" height="20px" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
                    <g id="Edit / Edit_Pencil_02">
                    <path id="Vector" d="M4 16.0001V20.0001L8 20.0001L18.8686 9.13146L18.8695 9.13061C19.265 8.73516 19.4628 8.53736 19.5369 8.3092C19.6021 8.10835 19.6022 7.89201 19.5369 7.69117C19.4627 7.46284 19.2646 7.26474 18.8686 6.86872L17.1288 5.12892C16.7345 4.7346 16.5369 4.53704 16.3091 4.46301C16.1082 4.39775 15.8919 4.39775 15.691 4.46301C15.463 4.53709 15.2652 4.73488 14.8704 5.12976L14.8686 5.13146L4 16.0001Z" stroke="#000000" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"/>
                    </g>
                </svg>
                <P>EDIT</P>
            </div>
            </div>
        </div>

    </div>
  
</template>