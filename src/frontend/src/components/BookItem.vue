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
    <div class="flex flex-col md:flex-row bg-white rounded-2xl shadow-sm border border-gray-100 overflow-hidden hover:shadow-md transition-all duration-300 group mb-8 mx-4 md:mx-12 md:h-72">

        <div class="w-full md:w-48 lg:w-56 h-64 md:h-full flex-shrink-0 overflow-hidden relative bg-gray-50">
            <img 
                :src="props.image" 
                :alt="props.title"
                class="w-full h-full object-cover group-hover:scale-105 transition-transform duration-500"
            >
            <div class="absolute top-3 right-3 px-3 py-1 bg-white/90 backdrop-blur-sm rounded-full text-xs font-semibold text-indigo-600 shadow-sm border border-indigo-50">
                {{ props.type }}
            </div>
        </div>

        <div class="p-6 md:p-8 flex flex-col flex-1 min-w-0 justify-between">
            <div class="space-y-3">
                <div class="flex justify-between items-start gap-4">
                    <h2 class="text-xl md:text-2xl font-bold text-slate-800 leading-tight group-hover:text-indigo-600 transition-colors truncate">
                        {{ props.title }}
                    </h2>
                </div>
                
                <div class="flex flex-col gap-1">
                    <p class="text-indigo-600 font-medium">
                        by <span class="font-semibold">{{ props.author }}</span>
                    </p>
                    <div class="flex items-center gap-2 text-sm text-slate-500">
                        <svg class="w-4 h-4 opacity-70" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M8 7V3m8 4V3m-9 8h10M5 21h14a2 2 0 002-2V7a2 2 0 00-2-2H5a2 2 0 00-2 2v12a2 2 0 002 2z" />
                        </svg>
                        <span>{{ props.publishedDate }}</span>
                    </div>
                </div>

                <p class="text-slate-600 line-clamp-3 text-sm leading-relaxed py-2 border-l-2 border-indigo-100 pl-4 italic">
                    {{ props.description }}
                </p>
            </div>

            <!-- Actions Section -->
            <div class="flex items-center justify-between mt-6 pt-4 border-t border-slate-50">
                <div v-if="props.role === 'Admin'" class="flex gap-4 w-full justify-end">
                    <button 
                        @click="emitEdit(props.id)"
                        class="flex items-center gap-2 px-4 py-2 bg-emerald-50 text-emerald-600 rounded-xl hover:bg-emerald-100 active:scale-95 transition-all font-semibold text-sm border border-emerald-100 shadow-sm"
                    >
                        <svg class="w-4 h-4" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M11 5H6a2 2 0 00-2 2v11a2 2 0 002 2h11a2 2 0 002-2v-5m-1.414-9.414a2 2 0 112.828 2.828L11.828 15H9v-2.828l8.586-8.586z" />
                        </svg>
                        Edit
                    </button>
                    <button 
                        @click="emitDelete(props.id)"
                        class="flex items-center gap-2 px-4 py-2 bg-rose-50 text-rose-600 rounded-xl hover:bg-rose-100 active:scale-95 transition-all font-semibold text-sm border border-rose-100 shadow-sm"
                    >
                        <svg class="w-4 h-4" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M19 7l-.867 12.142A2 2 0 0116.138 21H7.862a2 2 0 01-1.995-1.858L5 7m5 4v6m4-6v6m1-10V4a1 1 0 00-1-1h-4a1 1 0 00-1 1v3M4 7h16" />
                        </svg>
                        Delete
                    </button>
                </div>
            </div>
        </div>
    </div>
</template>