package com.lhgogo.entity;

/**
 * @author ：linhui
 * @description ：
 * @date ：2023-03-19 15:35
 * @version:
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * indexName 索引名称
 * createIndex 是否自动创建索引id
 */
@Document(indexName = "products",createIndex = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Products {
    @Id //将放入对象的id放入到_id中
    public Integer id;
    @Field(type = FieldType.Double)
    public Double price;
    @Field(type = FieldType.Keyword)
    public String title;
    @Field(type = FieldType.Date)
    public Date create_at;
    @Field(type = FieldType.Text ,analyzer = "ik_max_word")
    public String description;
}

