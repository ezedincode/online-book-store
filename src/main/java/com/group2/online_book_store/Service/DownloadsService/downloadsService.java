package com.group2.online_book_store.Service.DownloadsService;


import com.group2.online_book_store.Entity.downloads.Downloads;

import java.util.List;

public interface downloadsService {
    List<Downloads> getAllDownloads();

    Downloads getDownloadById(Integer id);

    Downloads getDownloadByUserId(Integer UserId);

    void deleteDownloadById(Integer id);

    void deleteDownloadByUserId(Integer UserId);
    void saveDownload(Integer id, Integer user_id );


}
