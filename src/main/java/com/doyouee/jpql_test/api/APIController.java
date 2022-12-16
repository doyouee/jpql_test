package com.doyouee.jpql_test.api;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.doyouee.jpql_test.entity.BookEntity;
import com.doyouee.jpql_test.entity.CategoryEntity;
import com.doyouee.jpql_test.repository.BookRepository;
import com.doyouee.jpql_test.repository.CategoryRepository;

@RestController
@RequestMapping("/api")
public class APIController {
    @Autowired CategoryRepository cateRepo;
    @Autowired BookRepository bookRepo;

    // GET http://localhost:9999/api/category
    @GetMapping("/category") // 카테고리 리스트 바로 내보내기
    public Map<String, Object> selectCategories() {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        List<CategoryEntity> list = cateRepo.findAll();
        resultMap.put("total", list.size());
        resultMap.put("list", list);
        return resultMap;
    }
    
    // PUT http://localhost:9999/api/category?name=카테고리이름
    @PutMapping("/category") // 카테고리 저장하기 (seq 말고 이름이 전부)
    public Map<String, Object> insertCategory(@RequestParam String name) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        CategoryEntity cate = new CategoryEntity(); // 새로운 CategoryEntity 객체를 만들고
        cate.setCiName(name); // 이름 세팅하고
        cateRepo.save(cate); // 바로 저장해버림 (즉, seq값 설정안해뒀는데 save될때 자동으로 seq값이 찍힘) - 연계된 데이터값이 있다고 하면 필요하다(?)
        resultMap.put("status", true);
        resultMap.put("message", "카테고리를 추가했습니다.");
        resultMap.put("category", cate);
        return resultMap;
    }


    // http://localhost:9999/api/book/list  -> 모든 정보가 다 나옴(대신 page 1인 첫번째 페이지, 즉, 10개만 나옴)
    // http://localhost:9999/api/book/list?page=2  -> 두번째 페이지 정보들이 다 나옴
    // http://localhost:9999/api/book/list?keyword=아  -> '아' 가 포함된 정보들만 나옴
    @GetMapping("/book/list")
    public Map<String, Object> getBookList(@RequestParam @Nullable String keyword, @RequestParam @Nullable Integer page) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        if(keyword == null)     keyword = "";
        if(page == null)        page = 1;
        resultMap.put("totalPage", bookRepo.getBookPageCount(keyword));
        resultMap.put("currentPage", page);
        resultMap.put("keyword", keyword);
        List<BookEntity> list = bookRepo.searchBookTitle(keyword, (page-1)*10);
        resultMap.put("totalCount", list.size());
        resultMap.put("list", list);
        return resultMap;
    }
}
