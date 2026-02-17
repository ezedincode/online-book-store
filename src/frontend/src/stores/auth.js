import { defineStore } from 'pinia';
import { ref, watch } from 'vue';
import { jwtDecode } from 'jwt-decode';
import { fetchBookApi, searchbyTitleAndKeywordApi, deleteBookApi, loginApi, registerApi, addBookApi, editBookApi, searchByTypeApi } from '@/services/bookService';

export const useAuthStore = defineStore('auth', () => {
  const API_URL = import.meta.env.VITE_API_URL;
  const role = ref();
  const registerForm = ref({
    username: '',
    password: '',
    email: ''
  });
  const keyword = ref('');
  const type = ref('All');
  const LoginForm = ref({
    username: '',
    password: ''
  });

  const isLoading = ref(false);
  const error = ref(null);
  const isRegistered = ref(false);

  const updateRegisterField = (field, value) => {
    registerForm.value[field] = value;
  };
  const initialize = () => {
    const token = localStorage.getItem('token')

    if (!token) {
      role.value = null
      return
    }

    try {
      const decoded = jwtDecode(token)
      role.value = decoded.role || null
    } catch (err) {
      console.error('Invalid token')
      localStorage.removeItem('token')
      role.value = null
    }
  }

  const resetForm = () => {
    registerForm.value = { username: '', password: '', email: '' };
    error.value = null;
  };
  const resetLoginForm = () => {
    LoginForm.value = { username: '', password: '' };
  };
  const login = async () => {
    try {
      const response = await loginApi(
        LoginForm.value
      )
      const { token } = response.data;
      setToken(token)
      resetLoginForm();
      console.log(role.value)
      return role
    } catch (err) {
      throw err.response?.data?.message || err.message;
    }
  };
  const setToken = (token) => {
    localStorage.setItem('token', token);
    const decoded = jwtDecode(token);
    role.value = decoded.role;
  };
  const books = ref([]);
  // const booktype = ref('All');
  const page = ref('1');
  const size = ref('10');
  const fetchBooks = async () => {
    books.value = null;
    error.value = null;
    isLoading.value = true;

    try {
      const response = await fetchBookApi(
        keyword.value,
        page.value,
        size.value
      );
      // if(booktype.value === 'All'){
      books.value = response.data;
      //    console.log(books.value[0].type);
      // }
      // else{
      //   books.value = response.data;
      //   console.log(booktype.value);
      //   console.log(books);

      //   // books.value = books.value.filter(book => book.type === booktype.value)

      // }


    } catch (err) {
      error.value = err.response?.data?.message || err.message;
      books.value = null;
    } finally {
      isLoading.value = false;
    }
  };


  watch(keyword, () => {
    page.value = '1'
  });


  watch([keyword, page, type], async () => {
    if (type.value === 'All') {
      await fetchBooks();
    } else {
      if (keyword.value && keyword.value !== '') {
        await searchbyTitleAndKeyword();
      } else {
        await searchBy();
      }
    }
  }, { immediate: true })

  const searchbyTitleAndKeyword = async () => {
    try {
      const response = await searchbyTitleAndKeywordApi({
        type: type.value,
        keyword: keyword.value
      }, page.value, size.value)
      books.value = response.data;
    } catch (error) {
      console.error("Search failed", error);
    }
  };

  const register = async () => {
    isLoading.value = true;
    error.value = null;
    try {
      const response = await registerApi(registerForm.value);
      const { token } = response.data;
      setToken(token);
      isRegistered.value = true;
      resetForm();
      return role;
    } catch (err) {
      throw err.response?.data?.message || err.message;
    }
  };

  const newBook = ref({
    title: '',
    author: '',
    image: '',
    type: 'Fiction',
    publishedDate: '',
    bookDetail: {
      rating: 0,
      description: ''
    },
    downloads: []
  })
  const resetNewBook = () => {
    newBook.value = {
      title: '',
      author: '',
      image: '',
      type: 'Fiction',
      publishedDate: '',
      bookDetail: {
        rating: 0,
        description: ''
      },
      downloads: []
    }
  }

  const addBook = async () => {
    try {
      const response = await addBookApi(newBook.value);
      resetNewBook();
      await fetchBooks();
    } catch (err) {
      throw err.response?.data?.message || err.message;
    }
  };
  const editedBook = ref({
    id: 0,
    title: '',
    author: '',
    image: '',
    type: 'Fiction',
    publishedDate: '',
    bookDetail: {
      rating: 0,
      description: ''
    },
    downloads: []
  })
  const editBook = async () => {
    try {
      await editBookApi(editedBook.value);
      await fetchBooks();
    } catch (err) {
      throw err.response?.data?.message || err.message;
    }
  };
  const bookid = ref(0);
  const deleteBook = async () => {
    try {
      const response = await deleteBookApi(bookid.value);
      await fetchBooks();
    } catch (err) {
      throw err.response?.data?.message || err.message;
    }
  };
  watch(type, async () => {
    page.value = '1';
  });
  const searchBy = async () => {
    try {
      if (type.value === 'All') {
        await fetchBooks();
      }
      const response = await searchByTypeApi(type.value, page.value, size.value);
      books.value = response.data;
    } catch (err) {
      error.value = err.response?.data?.message || err.message;
    }
  }




  return {

    registerForm,
    LoginForm,
    isLoading,
    error,
    isRegistered,
    keyword,
    books,
    page,
    size,
    newBook,
    role,
    bookid,
    editedBook,
    // booktype,
    type,

    editBook,
    updateRegisterField,
    searchbyTitleAndKeyword,
    deleteBook,
    initialize,
    resetForm,
    resetNewBook,
    register,
    login,
    searchBy,
    addBook
  };
});