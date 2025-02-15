package com.group2.online_book_store.Service.DownloadsService;

import com.group2.online_book_store.Entity.downloads.Downloads;
import com.group2.online_book_store.Entity.user.User;

import java.util.List;

public interface downloadsService {
    public List<Downloads> getAllDownloads();

    public Downloads getDownloadById(Integer id);

    public Downloads getDownloadByUserId(Integer UserId);

    public void deleteDownloadById(Integer id);

    public void deleteDownloadByUserId(Integer UserId);
    public void saveDownload(Integer id, Integer user_id );


}
