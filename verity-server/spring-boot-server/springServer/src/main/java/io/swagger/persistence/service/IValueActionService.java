package io.swagger.persistence.service;

import org.baeldung.persistence.dao.common.IOperations;
import io.swagger.model.Valueaction;

public interface IValueActionService extends IOperations<Valueaction>{

	void setArchiveBit(String uuid);

}
