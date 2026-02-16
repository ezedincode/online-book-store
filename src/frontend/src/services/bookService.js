import api from './api';

export const fetchBookApi = (keyword,page,size) => {
    if(!keyword || keyword === ''){
        return api.get(`/home/bookList`,{
            params: { page,size}
        });
    }
    return api.post(`/home/search`,
        {keyword },
        {
            params: {page,size}
        }
    );
}

export const loginApi = (loginForm) => {
        return api.post(`/auth/authenticate`,loginForm);
}