import { defineStore } from 'pinia';
import { ref, watch } from 'vue';
import { jwtDecode } from 'jwt-decode';
import { fetchBookApi ,loginApi} from '@/services/bookService';

export const useAuthStore = defineStore('auth', () => {
  const API_URL = import.meta.env.VITE_API_URL;
  const role = ref();
  const registerForm = ref({
    username: '',
    password: '',
    email: ''
  });
  const keyword = ref('');
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
      const {token}  = response.data;
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

    books.value = response.data;

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

  watch([keyword, page], async () => {
    await fetchBooks();
  }, { immediate: true })


  const register = async () => {
    isLoading.value = true;
    error.value = null;
    try {
      const response = await fetch(`${API_URL}/auth/register`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(registerForm.value)
      });

      const data = await response.json();

      if (!response.ok) {
        throw new Error(data.message || 'Registration failed');
      }

      isRegistered.value = true;
      resetForm();
      if (data.token) {
        localStorage.setItem('token', data.token);
      }

      return data;

    } catch (err) {
      error.value = err.message;
      throw err
      console.error('Registration error:', err);
    } finally {
      isLoading.value = false;
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
    const token = localStorage.getItem('token');
    if (!token) {
      error.value = "Please login as admin";
      return;
    }
    try {
      const response = await fetch(`${API_URL}/admin/addBook`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${token}`
        },
        body: JSON.stringify(newBook.value)
      });

      const contentType = response.headers.get("content-type");
      if (contentType && contentType.includes("application/json")) {
        const data = await response.json();
        if (!response.ok) {
          throw new Error(data.message || 'Failed to add book');
        }
        resetNewBook();
        await fetchBooks();
        return data;
      } else {
        const text = await response.text();
        console.error("Server Error Response:", text);
        throw new Error(`Server returned error ${response.status}. See console for details.`);
      }

    } catch (err) {
      error.value = err.message;
      throw err
    } finally {
      isLoading.value = false;
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
    const token = localStorage.getItem('token');
    if (!token) {
      error.value = "Please login as admin";
      return;
    }
    try {
      const response = await fetch(`${API_URL}/admin/editBook`, {
        method: 'PUT',
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${token}`
        },
        body: JSON.stringify(editedBook.value)
      });

      const contentType = response.headers.get("content-type");
      if (contentType && contentType.includes("application/json")) {
        const data = await response.json();
        if (!response.ok) {
          throw new Error(data.message || 'Failed to edit book');
        }
        await fetchBooks();
        return data;
      } else {
        const text = await response.text();
        if (!response.ok) throw new Error(text || 'Failed to edit book');
        await fetchBooks();
        return text;
      }

    } catch (err) {
      error.value = err.message;
      throw err
    } finally {
      isLoading.value = false;
    }
  };
  const bookid = ref(0);
  const deleteBook = async () => {
    const token = localStorage.getItem('token');
    if (!token) {
      error.value = "Please login as admin";
      return;
    }
    try {
      const response = await fetch(`${API_URL}/admin/removeBook`, {
        method: 'DELETE',
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${token}`
        },
        body: JSON.stringify({ 'id': bookid.value })
      });
      const data = await response.json();
      if (!response.ok) {
        throw new Error(data.message || 'Failed to delete book');
      }
      await fetchBooks();
      return data;
    } catch (err) {
      error.value = err.message;
      throw err
    } finally {
      isLoading.value = false;
    }
  };

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

    editBook,
    updateRegisterField,
    deleteBook,
    initialize,
    resetForm,
    resetNewBook,
    register,
    login,
    addBook
  };
});