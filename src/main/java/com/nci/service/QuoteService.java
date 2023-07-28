package com.nci.service;

import com.nci.pojo.Dept;
import com.nci.pojo.Quote;

import java.util.List;

public interface QuoteService {
    void add(Quote quote);

    List<Dept> list();
}
