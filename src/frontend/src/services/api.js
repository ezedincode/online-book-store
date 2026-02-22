import axios from 'axios';
import {useRouter} from 'vue-router';

const router = useRouter();
const api = axios.create({
    baseURL: 'http://localhost:8080/api',
    timeout:10000,
});

export default api;


api.interceptors.request.use(
  (config) => {
    const token = localStorage.getItem("token");

    const excludedPaths = [
      "/auth/authenticate",
      "/auth/register"
    ];

    const isExcluded = excludedPaths.some(path =>
      config.url.includes(path)
    );

    if (token && !isExcluded) {
      config.headers.Authorization = `Bearer ${token}`;
    }

    return config;
  },
  (error) => Promise.reject(error)
);

api.interceptors.response.use(
    (response) => response,
    (error) => {
        if(error.response && error.response.status === 401 ){
            // localStorage.removeItem('token');
            router.push('/')
        }
        return Promise.reject(error);
    }
);