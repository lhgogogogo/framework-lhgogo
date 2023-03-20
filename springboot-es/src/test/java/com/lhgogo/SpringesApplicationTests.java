package com.lhgogo;

import com.lhgogo.entity.Goods;
import com.lhgogo.entity.Products;
import com.lhgogo.service.GoodsEsRepository;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：linhui
 * @description ：
 * @date ：2023-03-19 15:50
 * @version:
 */

@SpringBootTest
public class SpringesApplicationTests {

    @Resource
    public GoodsEsRepository goodsEsRepository;
    @Resource
    public ElasticsearchRestTemplate elasticsearchRestTemplate;

    /**
     *
     * @param obj 参数
     * @param <T> SearchHits对象的泛型
     * @return  返回List<T>
     */
    public static <T> List<T> getObjectList(SearchHits<T> obj){
        return obj.getSearchHits().stream().map(SearchHit::getContent).collect(Collectors.toList());

    }

    /**
     * 创建并保存映射和文档，如果已经存在则会对该文档进行修改
     */
    @Test
    public void sava(){
        Products products=new Products();
        products.setId(1);
        products.setTitle("腊肉饭");
        products.setCreate_at(new Date());
        products.setPrice(12.5);
        products.setDescription("腊肉饭是来自于四川的一种地道的美食");
        elasticsearchRestTemplate.save(products);
        Goods goods=new Goods();
        goods.setId(1l);
        goods.setTitle("手机");
        goods.setBrand("华为手机");
        goods.setCategory("手机");
        goods.setImages("http://xiaomi.com");
        goods.setPrice(1999.0);
        elasticsearchRestTemplate.save(goods);
    }


}
