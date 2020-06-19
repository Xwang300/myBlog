package com.cass.elasticsearch.repository;

import com.cass.elasticsearch.domain.BlogModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * @Author: Xin Wang
 * @Date 2020/6/10 16:08
 */

@Component
public interface BlogRepository extends ElasticsearchRepository<BlogModel,Integer> {
}
