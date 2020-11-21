package com.jeesite.modules.ia.service;

import com.jeesite.common.service.CrudService;
import com.jeesite.modules.ia.dao.IaCCulvertDao;
import com.jeesite.modules.ia.entity.IaCCulvert;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly=true)
public class IaCCulvertService
        extends CrudService<IaCCulvertDao, IaCCulvert>
{}
