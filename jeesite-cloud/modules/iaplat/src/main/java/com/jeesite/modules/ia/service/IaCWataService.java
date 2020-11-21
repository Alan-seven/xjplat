package com.jeesite.modules.ia.service;

import com.jeesite.common.service.CrudService;
import com.jeesite.modules.ia.dao.IaCWataDao;
import com.jeesite.modules.ia.entity.IaCWata;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly=true)
public class IaCWataService
        extends CrudService<IaCWataDao, IaCWata>
{}
