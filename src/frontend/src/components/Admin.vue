<script setup>
import { useAuthStore } from '@/stores/auth';
import { ref} from 'vue';
import BookItem from './BookItem.vue';
import Pagination from './pagination.vue';

const authStore = useAuthStore();
const selector = ref("bookList");

async function addBook(){
    try {
        await authStore.addBook();
        alert('Book added successfully!');
    } catch (err) {
        alert('Error adding book: ' + err.message);
    }
}
function addBookSelector(){
    selector.value = 'addBook';
}
function listBookSelector(){
     selector.value = 'bookList';
}
function removeBookSelector(){
    selector.value = 'removeBook';
}
function deleteBook(id) {
    console.log(id)
    authStore.bookid = id;
    authStore.deleteBook();
}
</script>

<template>
    <div class="flex flex-col gap-5" >
        <div class="flex h-12 bg-[#173f5f] justify-between items-center">
            <div class="text-[20px] text-white">
                ADMIN PAGE
            </div>
            <div class="flex gap-5 mr-2 [&>div]:cursor-pointer">
            <div @click="addBookSelector()" class="text-[10px] text-white">
                ADD BOOK
            </div>
            <div @click="removeBookSelector()" class="text-[10px] text-white">
                REMOVE BOOK
            </div>
            <div @click="listBookSelector()" class="text-[10px] text-white">
                LIST BOOK
            </div>
            </div>

        </div>
        <div class="flex flex-col gap-5 " v-if="selector==='bookList'">
              <div class="  [&>*]:rounded-[10px] [&>*]:border [&>*]:border-[#7954bd] " v-for="book in authStore.books" > 

    <BookItem @delete="deleteBook" @edit="editBook" :id="book.id" :role="'Admin'" :description="book.description" :title="book.title" :author="book.author" :image="book.image" :published-date="book.publishedDate" :type="book.type" ></BookItem>
   
</div>
<Pagination></Pagination>
        </div >
        <div v-else-if="selector === 'editBook'">

        </div>
        <div class="flex items-center ml-12 flex-col gap-3 [&>input]:w-1/2 [&>input]:border [&>input]:h-12 [&>input]:rounded-lg [&>input]:pl-6" v-else-if="selector === 'addBook'">
            <input v-model="authStore.newBook.title" type="text" placeholder="Title">
            <input v-model="authStore.newBook.author" type="text" placeholder="Author">
            <input v-model="authStore.newBook.image" type="text" placeholder="Image URL">
            <input v-model="authStore.newBook.publishedDate" type="text" placeholder="Published Date (YYYY-MM-DD)">
            <select v-model="authStore.newBook.type" class="w-1/2 border h-12 rounded-lg pl-6">
                <option value="" disabled selected>Select Type</option>
                <option value="Academic">Academic</option>
                <option value="Biography">Biography</option>
                <option value="Children">Children</option>
                <option value="Fiction">Fiction</option>
                <option value="Technology">Technology</option>
                <option value="Art">Art</option>
                <option value="NonFiction">NonFiction</option>
            </select>
            <input v-model.number="authStore.newBook.bookDetail.rating" type="number" placeholder="Rating (0-5)" min="0" max="5">
            <input v-model="authStore.newBook.bookDetail.description" type="text" placeholder="Description">
            <button @click="addBook()" class="border bg-green-600 text-white w-32 h-12 rounded-lg mt-5 hover:bg-green-700 transition" >ADD BOOK</button>
        </div>
        
    </div>
</template>