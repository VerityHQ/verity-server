package io.swagger.persistence.service;

import site.verity.persistence.dao.common.IOperations;

import java.util.List;

import org.springframework.data.domain.Pageable;

import io.swagger.model.Community;

public interface ICommunityService extends IOperations<Community>{

	List<Community> findByParentId(String parentid, Pageable pageable);

	Community getParentCommunity(String uuid);

}
