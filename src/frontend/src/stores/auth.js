import { defineStore } from 'pinia';
import { ref, watch } from 'vue';

export const useAuthStore = defineStore('auth', () => {
  const API_URL = import.meta.env.VITE_API_URL;
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

  const resetForm = () => {
    registerForm.value = { username: '', password: '', email: '' };
    error.value = null;
  };
  const resetLoginForm = () => {
    LoginForm.value = { username: '', password: '' };
  };
  const login = async () => {
    try {
      const response = await fetch(`${API_URL}/auth/authenticate`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(LoginForm.value)
      });
      const data = await response.json();
      if (!response.ok) {
        throw new Error(data.message || 'Registration failed');
      }

      resetLoginForm();
      localStorage.setItem('token', data.token);
      return data;
    } catch (err) {
      throw err
    } finally {
    }
  };

  const books = ref([]);
  const page = ref('1');
  const size = ref('10');

  watch(keyword, () => {
  page.value = '1'
});

  watch([keyword,page] ,async([newKeyword,newPage]) =>{
   
    books.value = null;
    const token = localStorage.getItem('token');
    if (!token) {
      error.value = "Please login to search";
      return;
    }
    console.log(token);
    let response = null;
    try {
      
      if(newKeyword == ''){
        response = await fetch(`${API_URL}/home/bookList?page=${newPage}&size=${size.value}`, {
          
        method: 'GET',
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${token}`
        }
      });
        }
         else{
       response = await fetch(`${API_URL}/home/search?page=${newPage}&size=${size.value}`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${token}`
        },
        body: JSON.stringify({ keyword: newKeyword })
      });
      }
       books.value = await response.json();
      if (!response.ok) {
        books.value = null;

      }

     

    } catch (err) {
      error.value = err.message;
      throw err
      console.error('Registration error:', err);
    } finally {
      isLoading.value = false;
    }
  },
{immediate:true})
  

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

    updateRegisterField,
    resetForm,
    register,
    login,

  };
});