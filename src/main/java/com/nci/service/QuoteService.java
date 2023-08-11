package com.nci.service;

import com.nci.pojo.Quote;

import java.util.List;

public interface QuoteService {

    List<Quote> list();

    void add(Quote quote);

    void delete(Integer id);

}
