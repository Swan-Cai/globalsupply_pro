package com.nci.service;

import com.nci.mapper.QuoteMapper;
import com.nci.pojo.Quote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class QuoteServiceImpl implements QuoteService{
    @Autowired
    private QuoteMapper quoteMapper;

    @Override
    public List<Quote> list() {
        return quoteMapper.list();
    }

    @Override
    public void add(Quote quote) {
        quote.setSubmittime(LocalDateTime.now());
        quote.setProcessingtime(LocalDateTime.now());

        quoteMapper.insert(quote);

    }


}
