//package com.nci.controller;
//
//import com.nci.pojo.Quote;
//import com.nci.pojo.Result;
//import com.nci.service.QuoteService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@Slf4j
//@RequestMapping("/quotes")
//@RestController
//public class QuoteController {
//
//    @Autowired
//    private QuoteService quoteService;
//
//    public Result list(){
//        log.info("require all the quote data");
//        List<Quote> quoteList = quoteService.list();
//        return Result.success(quoteList);
//    }
//
//    /**
//     * add new quote
//     * @param quote
//     * @return
//     */
//    @PostMapping
//    public Result add(@RequestBody Quote quote){
//        log.info("add quote:{}", quote);
//        quoteService.add(quote);
//        return Result.success();
//
//    }
//}
