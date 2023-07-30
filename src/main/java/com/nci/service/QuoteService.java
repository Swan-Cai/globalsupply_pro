package com.nci.service;

import com.nci.pojo.Quote;

import java.util.List;

public interface QuoteService {
    void add(Quote quote);

    List<Quote> list();
}
