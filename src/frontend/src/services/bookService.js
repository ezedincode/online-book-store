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
export const registerApi = (registerForm) => {
    return api.post(`/auth/register`,registerForm);
}
export const addBookApi = (newBook)=> {
    return api.post(`/admin/addBook`,newBook);
}
export const editBookApi = (editedBook) => {
    return api.put(`/admin/editBook`,editedBook);
}
export const deleteBookApi = (bookid) => {
    return api.delete(`/admin/removeBook`, {
        data: {'id': bookid}
    })
}