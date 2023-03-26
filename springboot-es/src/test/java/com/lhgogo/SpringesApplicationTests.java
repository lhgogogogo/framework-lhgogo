package com.lhgogo;

import com.lhgogo.entity.Goods;
import com.lhgogo.entity.Products;
import com.lhgogo.service.GoodsEsRepository;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.mapping.IndexCoordinates;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;

import javax.annotation.Resource;
import java.util.*;
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

    /**
     * 批量保存
     */
    @Test
    public void test1() {
        Products products = new Products(2, 12.5, "土豆片炒肉", new Date(), "其实土豆片炒肉也是不错的。挺好吃的");
        Products products1 = new Products(3, 13.5, "鱼香肉丝盖饭", new Date(), "鱼香肉丝盖饭这个可是真好吃");
        Products products2 = new Products(4, 14.5, "西红柿鸡蛋盖饭", new Date(), "这个盖饭其实一般。真的。我不怎么点这个。西红柿多。鸡蛋少");
        Products products3 = new Products(5, 15.5, "过油肉盖饭", new Date(), "这个盖饭其实是不错的，真的");
        Products products4 = new Products(6, 16.5, "麻辣豆腐盖饭", new Date(), "我吃不了辣。所以不怎么吃这个盖饭");
        Products products5 = new Products(7, 17.5, "尖椒炒肉", new Date(), "这个盖饭也是有点辣。所以我也不喜欢吃");
        Products products6 = new Products(8, 18.5, "海底捞火锅", new Date(), "这个地方的火锅。我感觉也一般吧，上次在家里面自己整了一次，那是真的香。全是肉");
        Products products7 = new Products(9, 19.5, "麻辣香锅", new Date(), "这个东西也是挺好吃的。我和前...吃过很多次。挺不错的。可以带朋友一起去");
        Products products8 = new Products(10, 20.5, "宫保鸡丁盖饭", new Date(), "这个也不错，也是挺好吃的。我喜欢");
        Products products9 = new Products(11, 22.5, "豆角焖面", new Date(), "山西的一种面食吧。挺好吃的。多放点醋。我是挺喜欢吃的");
        ArrayList<Products> objects = new ArrayList<>();
        objects.add(products);
        objects.add(products1);
        objects.add(products2);
        objects.add(products3);
        objects.add(products4);
        objects.add(products5);
        objects.add(products6);
        objects.add(products7);
        objects.add(products8);
        objects.add(products9);
        elasticsearchRestTemplate.save(objects);
    }

    /**
     * 插入
     */
    @Test
    public void insert(){
        Products products=new Products(12,500.5,"土豆片炒肉",new Date(),"其实土豆片炒肉也是不错的。挺好吃的");
        Products products1=new Products(13,500.5,"鱼香肉丝盖饭",new Date(),"鱼香肉丝盖饭这个可是真好吃");
        Products products2=new Products(14,500.5,"西红柿鸡蛋盖饭",new Date(),"这个盖饭其实一般。真的。我不怎么点这个。西红柿多。鸡蛋少");
        Products products3=new Products(15,500.5,"过油肉盖饭",new Date(),"这个盖饭其实是不错的，真的");
        Products products4=new Products(16,500.5,"麻辣豆腐盖饭",new Date(),"我吃不了辣。所以不怎么吃这个盖饭");
        Products products5=new Products(17,500.5,"尖椒炒肉",new Date(),"这个盖饭也是有点辣。所以我也不喜欢吃");
        Products products6=new Products(18,500.5,"海底捞火锅",new Date(),"这个地方的火锅。我感觉也一般吧，上次在家里面自己整了一次，那是真的香。全是肉");
        Products products7=new Products(19,500.5,"麻辣香锅",new Date(),"这个东西也是挺好吃的。我和前...吃过很多次。挺不错的。可以带朋友一起去");
        Products products8=new Products(20,500.5,"宫保鸡丁盖饭",new Date(),"这个也不错，也是挺好吃的。我喜欢");
        Products products9=new Products(21,500.5,"豆角焖面",new Date(),"山西的一种面食吧。挺好吃的。多放点醋。我是挺喜欢吃的");
        ArrayList<Products> objects = new ArrayList<>();
        objects.add(products);objects.add(products1);objects.add(products2);objects.add(products3);objects.add(products4);
        objects.add(products5);objects.add(products6);objects.add(products7);objects.add(products8);objects.add(products9);
        elasticsearchRestTemplate.save(objects);
    }

    /**
     * 按照指定条件进行查询 这个是按照team进行查询的。也就是精确匹配的，他对于搜索词是不会进行拆分的
     */
    @Test
    public void team(){
        TermQueryBuilder baseTermQueryBuilder = new TermQueryBuilder("title", "肉");
        NativeSearchQuery nativeSearchQuery=new NativeSearchQuery(baseTermQueryBuilder);
        SearchHits<Products> goods = elasticsearchRestTemplate.search( nativeSearchQuery, Products.class, IndexCoordinates.of("products"));
        System.out.println("查询的商品信息有"+goods.getSearchHits());
    }

    /**
     * 进行模糊匹配，他的查询语句是match的。他对于搜索词是会进行拆分开的，这个也是自动带了分页，可以在query里面自己加分页条数
     */
    @Test
    public void match(){
//        MatchQuery matchQuery = QueryBuilders.matchQuery("description", "盖饭", co.elastic.clients.elasticsearch._types.query_dsl.Operator.And, 1.0f);
        MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder("description", "盖");
        //从这里可以看出我们要使用的QueryBuilders有3个类下面都有，我们这里用的是org.elasticsearch.index.query这个包下面的东西。
        MatchQueryBuilder matchQueryBuilder1 = QueryBuilders.matchQuery("description", "盖饭");
        NativeSearchQuery nativeSearchQuery = new NativeSearchQuery(matchQueryBuilder1);
        nativeSearchQuery.addSort(Sort.by(Sort.Direction.ASC,"id"));
        SearchHits<Products> products = elasticsearchRestTemplate.search(nativeSearchQuery, Products.class, IndexCoordinates.of("products"));
        System.out.println("搜索结果："+products.getSearchHits());
    }

    /**
     * matchPhrase 对搜索条件不分词进行搜索
     */
    @Test
    public void matchPhrase(){
        NativeSearchQuery nativeSearchQuery = new NativeSearchQuery(QueryBuilders.matchPhraseQuery("description","我吃不了辣"));
        nativeSearchQuery.addSort(Sort.by(Sort.Direction.ASC,"id"));
        SearchHits<Products> products = elasticsearchRestTemplate.search(nativeSearchQuery, Products.class, IndexCoordinates.of("products"));
        getObjectList(products).forEach(item->{
            System.out.println(item.toString());
        });
    }

    /**
     * 查询所有,自己带分页了
     */
    @Test
    public void matchAll(){
        //会进行默认的分页，就在这个query对象里面，我们可以通过构建query这个对象来进行分页查询
        Query query = elasticsearchRestTemplate.matchAllQuery();
        //这个查询的也是一样的
        Query all = Query.findAll();
        //下面这个条件就是构建分页的
        query.setPageable(PageRequest.of(1,3, Sort.by(Sort.Direction.DESC,"id")));

        SearchHits<Products> products = elasticsearchRestTemplate.search(all, Products.class, IndexCoordinates.of("products"));
        getObjectList(products).forEach(item->{
            System.out.println(item.toString());
        });
    }

    /**
     * es中的范围查询range
     */
    @Test
    public void range(){
        NativeSearchQuery nativeSearchQuery = new NativeSearchQuery(QueryBuilders.rangeQuery("price").gte(500.0).lte(800.0));
        nativeSearchQuery.setPageable(PageRequest.of(1,3));
        SearchHits<Products> products = elasticsearchRestTemplate.search(nativeSearchQuery, Products.class, IndexCoordinates.of("products"));
        getObjectList(products).forEach(item->{
            System.out.println(item.toString());
        });
    }

    /**
     * 多条件查询  must should
     * lg：满足pirce >=500 和pirce <=800 或者id=1
     */
    @Test
    public void mustShould(){
        // 这个是逻辑或
        List<QueryBuilder> orQueryBuilderList =new ArrayList<>();
        orQueryBuilderList.add(QueryBuilders.rangeQuery("price").gte(500.0).lte(800.0));
        orQueryBuilderList.add(QueryBuilders.termQuery("id",1));
        BoolQueryBuilder orBoolQueryBuilder = QueryBuilders.boolQuery();
        orBoolQueryBuilder.should().addAll(orQueryBuilderList);
        //下面是逻辑与
        ArrayList<QueryBuilder> andQueryBuildList = new ArrayList<>();
        andQueryBuildList.add(QueryBuilders.matchPhraseQuery("title","腊肉饭"));
        andQueryBuildList.add(QueryBuilders.matchQuery("id","1"));
        BoolQueryBuilder andBoolQueryBuilder= QueryBuilders.boolQuery();
        andBoolQueryBuilder.must().addAll(andQueryBuildList);
//        NativeSearchQuery nativeSearchQuery = new NativeSearchQuery(orBoolQueryBuilder);
        NativeSearchQuery nativeSearchQuery = new NativeSearchQuery(andBoolQueryBuilder);

        nativeSearchQuery.setPageable(PageRequest.of(0,300));
        nativeSearchQuery.addSort(Sort.by(Sort.Direction.ASC,"id"));
        SearchHits<Products> products = elasticsearchRestTemplate.search(nativeSearchQuery, Products.class, IndexCoordinates.of("products"));
        getObjectList(products).forEach(item->{
            System.out.println(item.toString());
        });
    }

    /**
     * 高亮查询
     */
    @Test
    public void highlight(){
        HighlightBuilder.Field questionContentField = new HighlightBuilder.Field("description")
                .preTags("<span class=\"highlight\">")
                .postTags("</span>");
        NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchQuery("description","盖饭"))
                .withHighlightFields(questionContentField).build();

        nativeSearchQuery.setPageable(PageRequest.of(0,300));
        nativeSearchQuery.addSort(Sort.by(Sort.Direction.ASC,"id"));
        SearchHits<Products> products = elasticsearchRestTemplate.search(nativeSearchQuery, Products.class, IndexCoordinates.of("products"));
        products.getSearchHits().forEach(item->{
            Products content = item.getContent();
            System.out.println("数据："+content.toString());
            Map<String, List<String>> highlightFields = item.getHighlightFields();
            System.out.println("高亮："+ Arrays.toString(highlightFields.values().toArray()));
        });
        System.out.println();
    }

}
