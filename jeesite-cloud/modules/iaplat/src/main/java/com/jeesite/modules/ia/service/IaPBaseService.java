package com.jeesite.modules.ia.service;

import com.jeesite.common.service.CrudService;
import com.jeesite.modules.ia.dao.IaPBaseDao;
import com.jeesite.modules.ia.entity.IaPBase;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly=true)
public class IaPBaseService extends CrudService<IaPBaseDao, IaPBase>{

}
