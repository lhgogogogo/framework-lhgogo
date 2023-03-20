package com.lhgogo.service;

import com.lhgogo.entity.Goods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * @author ：linhui
 * @description ：
 * @date ：2023-03-19 15:46
 * @version:
 */

public interface GoodsEsRepository extends PagingAndSortingRepository<Goods,Long> {

    //这个是where title like '%#{title}%'  因为这里的title的属性为text类型的。已经分词了
    List<Goods> findByTitle(String title);
    //
    Page<Goods> findDistinctCategoryByTitleOrCategory(String title, String brand, Pageable pageable );

}
