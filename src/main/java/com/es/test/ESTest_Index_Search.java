package com.es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

import java.io.IOException;

/**
 * ClassName:  <br/>
 * Description: <br/>
 * Date: 2021-06-15 10:25 上午 <br/>
 *
 * @author wanghaiqing <br/>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         />
 * @version 1.0.0
 */
public class ESTest_Index_Search {

    public static void main(String[] args) throws IOException {
        // 创建ES客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http")));
        try{
            GetIndexRequest indexRequest = new GetIndexRequest();
            GetIndexRequest indexRequest1 = new GetIndexRequest("user");

            GetIndexResponse getIndexResponse = esClient.indices().get(indexRequest1, RequestOptions.DEFAULT);

            // 响应状态
            System.out.println("索引操作" + getIndexResponse.getAliases());
            System.out.println("索引操作" + getIndexResponse.getMappings());
            System.out.println("索引操作" + getIndexResponse.getSettings());
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        } finally {
            // 关闭ES客户端
            esClient.close();
        }
    }
}
