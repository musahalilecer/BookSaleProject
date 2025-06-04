package com.musahalilecer.booksaleproject.dto.request;

public class CountryRequest {

    private String countryName;
    private String flag;
    private Integer bookId;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }


}
