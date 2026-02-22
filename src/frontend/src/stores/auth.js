import { defineStore } from 'pinia';
import { ref, watch } from 'vue';
import { jwtDecode } from 'jwt-decode';
import { fetchBookApi, uploadThumbnailApi, uploadBookApi, downloadUrlApi, searchbyTitleAndKeywordApi, deleteBookApi, loginApi, registerApi, addBookApi, editBookApi, searchByTypeApi, fetchGlobalStatisticsApi, fetchDailyDownloadsApi } from '@/services/bookService';

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
  const page = ref('1');
  const size = ref('10');
  const totalPages = ref(0);
  const globalStatistics = ref({
    totalBooks: 0,
    totalDownloads: 0,
    totalViews: 0
  });
  const dailyDownloads = ref([]);

  const fetchGlobalStatistics = async () => {
    try {
      const response = await fetchGlobalStatisticsApi();
      globalStatistics.value = response.data;
    } catch (err) {
      console.error('Failed to fetch global statistics:', err);
    }
  };

  const fetchDailyDownloads = async () => {
    try {
      const response = await fetchDailyDownloadsApi();
      dailyDownloads.value = response.data;
    } catch (err) {
      console.error('Failed to fetch daily downloads:', err);
    }
  };

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
      books.value = response.data.content;
      totalPages.value = response.data.totalPages;

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
      books.value = response.data.content;
      totalPages.value = response.data.totalPages;
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
    storageUrl: '',
    downloads: []
  })
  const resetNewBook = () => {
    newBook.value = {
      title: '',
      author: '',
      image: '',
      storageUrl: '',
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
      if (file.value) {
        const path = await upload();
        newBook.value.storageUrl = path;
        console.log(path);
        const thumbnail = await uploadThumbnail();
        console.log(thumbnail);
        newBook.value.image = thumbnail;
        console.log(newBook.value.image);
      }
      console.log("here")
      const response = await addBookApi(newBook.value);
      resetNewBook();
      file.value = null;
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
    storageUrl: '',
    downloads: []
  })
  const editBook = async () => {
    try {
      if (file.value) {
        const path = await upload();
        editedBook.value.storageUrl = path;
      }
      await editBookApi(editedBook.value);
      file.value = null;
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
      books.value = response.data.content;
      totalPages.value = response.data.totalPages;
    } catch (err) {
      error.value = err.response?.data?.message || err.message;
    }
  }
  const file = ref(null);

  const upload = async () => {
    const formData = new FormData();
    formData.append("file", file.value);
    const response = await uploadBookApi(formData);
    return response.data;
  }
  const uploadThumbnail = async () => {
    const formDatathumb = new FormData();
    formDatathumb.append("file", file.value);
    const response = await uploadThumbnailApi(formDatathumb);
    return response.data;
  }
  const filename = ref('');
  const download = async () => {
    try {
      const response = await downloadUrlApi(filename.value);
      const signedUrl = response.data.url;
      const link = document.createElement("a");
      link.href = signedUrl;
      link.setAttribute("download", filename.value);
      document.body.appendChild(link);
      link.click();
      document.body.removeChild(link);
    } catch (err) {
      console.error("Download failed:", err);
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
    filename,
    size,
    totalPages,
    newBook,
    role,
    bookid,
    editedBook,
    file,
    type,
    globalStatistics,

    editBook,
    updateRegisterField,
    searchbyTitleAndKeyword,
    deleteBook,
    download,
    initialize,
    resetForm,
    resetNewBook,
    register,
    login,
    searchBy,
    addBook,
    fetchGlobalStatistics,
    fetchDailyDownloads,
    dailyDownloads
  };
});