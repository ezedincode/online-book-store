import { defineStore } from 'pinia';
import { ref } from 'vue';

export const useAuthStore = defineStore('auth', () => {
    const API_URL = import.meta.env.VITE_API_URL;
  const registerForm = ref({
    username: '',
    password: '',
    email: ''
  });
  const LoginForm = ref({
    username:'',
    password:''
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
    LoginForm.value = { username: '', password: ''};
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
      localStorage.setItem('token',data.token);
      return data;
    }catch (err) {
      throw err
    } finally {
    }
  };

  const searchBooks = async () => {
    const token = localStorage.getItem('token');
    try{
      const response = await fetch(`${API_URL}/auth/home/search`,{
        method: 'GET',
        header: {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${token}` 
        }
      });
      const data = await response.json();
       if (!response.ok) {
        throw new Error(data.message || 'Registration failed');
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
    searchBooks,

    updateRegisterField,
    resetForm,
    register,
    login
  };
});