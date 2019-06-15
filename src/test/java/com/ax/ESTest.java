package com.ax;

import com.ax.domain.Article;
import com.ax.es.service.ArticleService;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.net.InetAddress;
import java.util.Date;
import java.util.List;

//安照jpa的标准来
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:application.xml")
public class ESTest {

//    @Test
//    public void testAdd()throws Exception{
//        TransportClient client =
//                new PreBuiltTransportClient(Settings.EMPTY)
//                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("127.0.0.1"),9300));
//      /*  GetResponse getResponse = client.prepareGet("blog", "article", "1").get();
//        String sourceAsString = getResponse.getSourceAsString();
//        System.out.println(sourceAsString);*/
//        XContentBuilder builder = XContentFactory.jsonBuilder().startObject()
//                .field("id", 1)
//                .field("title", "ElasticSearch是一个基于Lucene的搜索服务器。")
//                .field("content", "它提供了一个分布式多用户能力的全文搜索引擎，基于RESTful web接口。Elasticsearch是用Java开发的，并作为Apache许可条款下的开放源码发布，" +
//                        "是当前流行的企业级搜索引擎。设计用于云计算中，能够达到实时搜索，稳定，可靠，快速，安装使用方便。")
//                .endObject();
//        //创建索引、创建文档类型、设置唯一主键。同时创建文档
//        client.prepareIndex("blog1","article","1").setSource(builder).get();
//
//        client.close();
//
//    }
    @Autowired
    private ArticleService articleService;




    @Test
    public void saveArticle(){
        Article article = new Article();
        article.setId(11);
        article.setTitle("测试SpringData1 ElasticSearch");
        article.setContent("Spring Data1 ElasticSearch 基于 spring data API 简化 elasticSearch操作，将原始操作elasticSearch的客户端API 进行封装 \n" +
                "    Spring Data为Elasticsearch Elasticsearch项目提供集成搜索引擎更新了");
        article.setCreateTime(new Date());
        articleService.saveOne(article);
    }
@Test
public void deleteArticle(){
        articleService.deleteById(300);
}


@Test
    public void pageSearch(){
    Pageable page = PageRequest.of(0,4,new Sort(Sort.Direction.DESC,"createTime"));
       Page<Article> pages= articleService.findByTitle("测试",page);
    System.out.println("总页数:"+pages.getTotalPages());
    List<Article> content = pages.getContent();
    for (int i = 0; i < content.size(); i++) {
        System.out.println(content.get(i));
    }

}




}
