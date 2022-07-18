package com.freshbeauty.dto;

import java.util.List;

/*
@author Микола
@project FreshBeauty
@class PageDTO
@version 1.0.0
@since 13.07.2022 - 19.28
*/
public class PageDTO<T> {
    List<T> content;
    int pageCount;
    int page;
    int pageSize;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
