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
        selector.value = 'bookList';
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
async function deleteBook(id) {
    console.log(id)
    authStore.bookid = id;
        await authStore.deleteBook();
        alert('Book deleted successfully!');
}
const editID = ref(0);
function editBookselector(id){
    selector.value = 'editBook';
    editID.value=id;
}
async function editBook() {
  try {
        authStore.editedBook.id = editID.value;
        console.log(authStore.editedBook.id)
        await authStore.editBook();
        alert('Book edited successfully!');
        selector.value = 'bookList';
    } catch (err) {
        alert('Error editing book: ' + err.message);
    }
}
function handleFileUpload(event) {
    authStore.file = event.target.files[0];
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

    <BookItem @delete="deleteBook" @edit="editBookselector" :id="book.id" :role="'Admin'" :description="book.description" :title="book.title" :author="book.author" :image="book.image" :published-date="book.publishedDate" :type="book.type" :storage-url="book.storageUrl" ></BookItem>
   
</div>
<Pagination></Pagination>
        </div >
        <div class="flex items-center ml-12 flex-col gap-3 [&>input]:w-1/2 [&>input]:border [&>input]:h-12 [&>input]:rounded-lg [&>input]:pl-6" v-else-if="selector === 'addBook'">
            <input  v-model="authStore.newBook.title" type="text" placeholder="Title">
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
            <div class="w-1/2 border-2 border-dashed border-gray-300 rounded-xl p-8 flex flex-col items-center justify-center gap-4 bg-gray-50 hover:bg-white hover:border-[#173f5f] transition-all cursor-pointer group relative">
                <input @change="handleFileUpload" type="file" class="absolute inset-0 opacity-0 cursor-pointer z-10">
                <div class="p-4 bg-blue-50 rounded-full group-hover:bg-[#173f5f]/10 transition-colors">
                    <svg xmlns="http://www.w3.org/2000/svg" class="h-10 w-10 text-[#173f5f]" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M7 16a4 4 0 01-.88-7.903A5 5 0 1115.9 6L16 6a5 5 0 011 9.9M15 13l-3-3m0 0l-3 3m3-3v12" />
                    </svg>
                </div>
                <div class="text-center">
                    <p class="text-sm font-semibold text-[#173f5f] mb-1">
                        {{ authStore.file ? authStore.file.name : 'Click or drag to upload book file' }}
                    </p>
                    <p class="text-xs text-gray-400">
                        {{ authStore.file ? 'File selected' : 'DOC, PDF, or EPUB (Max 10MB)' }}
                    </p>
                </div>
                <div class="px-4 py-2 bg-[#173f5f] text-white text-xs font-medium rounded-lg group-hover:bg-[#0d2a42] transition-colors">
                    {{ authStore.file ? 'Change File' : 'Select File' }}
                </div>
            </div>
            <button @click="addBook()" class="border bg-green-600 text-white w-32 h-12 rounded-lg mt-5 hover:bg-green-700 transition" >ADD BOOK</button>
           
        </div>
        <div class="flex items-center ml-12 flex-col gap-3 [&>input]:w-1/2 [&>input]:border [&>input]:h-12 [&>input]:rounded-lg [&>input]:pl-6" v-else-if="selector === 'editBook'">
            <input  v-model="authStore.editedBook.title" type="text" placeholder="Title">
            <input v-model="authStore.editedBook.author" type="text" placeholder="Author">
            <input v-model="authStore.editedBook.image" type="text" placeholder="Image URL">
            <input v-model="authStore.editedBook.publishedDate" type="text" placeholder="Published Date (YYYY-MM-DD)">
            <select v-model="authStore.editedBook.type" class="w-1/2 border h-12 rounded-lg pl-6">
                <option value="" disabled selected>Select Type</option>
                <option value="Academic">Academic</option>
                <option value="Biography">Biography</option>
                <option value="Children">Children</option>
                <option value="Fiction">Fiction</option>
                <option value="Technology">Technology</option>
                <option value="Art">Art</option>
                <option value="NonFiction">NonFiction</option>
            </select>
            <input v-model.number="authStore.editedBook.bookDetail.rating" type="number" placeholder="Rating (0-5)" min="0" max="5">
            <input v-model="authStore.editedBook.bookDetail.description" type="text" placeholder="Description">
           
            <button  @click="editBook()" class="border bg-green-600 text-white w-32 h-12 rounded-lg mt-5 hover:bg-green-700 transition" >EDIT BOOK</button>
        </div>
        </div>
        

</template>