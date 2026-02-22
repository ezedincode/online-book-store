import api from './api';

export const fetchBookApi = (keyword, page, size) => {
    if (!keyword || keyword === '') {
        return api.get(`/home/bookList`, {
            params: { page, size }
        });
    }
    return api.post(`/home/search`,
        { keyword },
        {
            params: { page, size }
        }
    );
}

export const loginApi = (loginForm) => {
    return api.post(`/auth/authenticate`, loginForm);
}
export const registerApi = (registerForm) => {
    return api.post(`/auth/register`, registerForm);
}
export const addBookApi = (newBook) => {
    return api.post(`/admin/addBook`, newBook);
}
export const editBookApi = (editedBook) => {
    return api.put(`/admin/editBook`, editedBook);
}
export const deleteBookApi = (bookid) => {
    return api.delete(`/admin/removeBook`, {
        data: { 'id': bookid }
    })
}

export const searchByTypeApi = (type, page, size) => {
    return api.post(`/home/type`, type, {
        headers: {
            'Content-Type': 'application/json'
        },
        params: { page, size }
    });
};
export const searchbyTitleAndKeywordApi = (searchBody, page, size) => {

    return api.post(`/home/searchByTypeAndKeyword`, searchBody, {
        params: {
            page,
            size
        }
    })

}
export const uploadBookApi = (file) => {

    return api.post(`/admin/books/upload`, file,
        { headers: { "Content-Type": "multipart/form-data" } }
    )
};

export const downloadUrlApi = (filename) => {
    return api.post(`/home/download`, { filename });
}

export const uploadThumbnailApi = (file) => {

    return api.post(`/admin/thumbnail/upload`, file,
        { headers: { "Content-Type": "multipart/form-data" } }
    )
};

export const fetchGlobalStatisticsApi = () => {
    return api.get(`/admin/global-statistics`);
};

export const fetchDailyDownloadsApi = () => {
    return api.get(`/admin/daily-downloads`);
};

