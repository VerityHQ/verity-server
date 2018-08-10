package io.swagger.persistence.service.impl;


import site.verity.persistence.dao.common.IOperations;
import site.verity.persistence.service.common.AbstractService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.swagger.model.Community;
import io.swagger.persistence.dao.ICommunityDao;
import io.swagger.persistence.service.ICommunityService;

@Service
public class CommunityService extends AbstractService<Community> implements ICommunityService {

    @Autowired
    private ICommunityDao dao;

    public CommunityService() {
        super();
    }

    // API
    @Override
    protected IOperations<Community> getDao() {
        return dao;
    }

	@Override
	public List<Community> findByParentId(String parentid, Pageable pageable) {
		List<String> uuids = this.findByUuid(parentid).getSubCommunities();
		return this.findAllByUuids(uuids, pageable);
	}

	@Override
	public Community getParentCommunity(String uuid) {
		String id = this.findByUuid(uuid).getParentCommunityId();
		return this.findByUuid(id);
	}
}
