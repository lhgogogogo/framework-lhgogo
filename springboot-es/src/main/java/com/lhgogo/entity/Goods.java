package com.lhgogo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author ：linhui
 * @description ：
 * @date ：2023-03-19 15:34
 * @version:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
//集群时可以设置 ： shards:分片数量(默认值：5),replicas:副本数量(默认值：1)
@Document(indexName = "goods")
public class Goods {


    /**
     * 必须有id,这里的id是全局唯一的标识,等同于es中的“_id”
     */
    @Id
    private Long id;

    /**
     * 标题
     * type: 字段数据类型
     * analyzer: 分词器类型
     * index: 是否索引(默认值：true)
     * store: 是否存储(默认值：false)
     */
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String title;

    /**
     * 分类
     */
    @Field(type = FieldType.Keyword)
    private String category;

    /**
     *    品牌
     */
    @Field(type = FieldType.Keyword)
    private String brand;

    /**
     *  价格
     */
    @Field(type = FieldType.Double)
    private Double price;

    /**
     * 图片地址
     */
    @Field(type = FieldType.Keyword,index = false)
    private String images;
}

