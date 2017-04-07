package io.swagger.persistence.service;

import site.verity.persistence.dao.common.IOperations;
import io.swagger.model.ValueAction;

public interface IValueActionService extends IOperations<ValueAction>{

	void setArchiveBit(String uuid);

}
