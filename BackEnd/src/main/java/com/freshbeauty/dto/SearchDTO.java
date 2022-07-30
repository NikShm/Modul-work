package com.freshbeauty.dto;

import com.freshbeauty.enums.CategoryType;
import com.freshbeauty.enums.SortDirection;

import java.math.BigDecimal;

/*
@author Микола
@project FreshBeauty
@class SearchDTO
@version 1.0.0
@since 13.07.2022 - 19.34
*/
public class SearchDTO {
    private String name;
    private String brand;
    private BigDecimal priceFrom;
    private BigDecimal priceTo;
    private String sortField;
    private SortDirection sortDirection;
    private int page;
    private int pageSize;
    private CategoryType categoryType;

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BigDecimal getPriceFrom() {
        return priceFrom;
    }

    public void setPriceFrom(BigDecimal priceFrom) {
        this.priceFrom = priceFrom;
    }

    public BigDecimal getPriceTo() {
        return priceTo;
    }

    public void setPriceTo(BigDecimal priceTo) {
        this.priceTo = priceTo;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public SortDirection getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(SortDirection sortDirection) {
        this.sortDirection = sortDirection;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "SearchDTO{" +
                "name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", priceFrom=" + priceFrom +
                ", priceTo=" + priceTo +
                ", sortField='" + sortField + '\'' +
                ", sortDirection=" + sortDirection +
                ", page=" + page +
                ", pageSize=" + pageSize +
                ", categoryType=" + categoryType +
                '}';
    }
}
