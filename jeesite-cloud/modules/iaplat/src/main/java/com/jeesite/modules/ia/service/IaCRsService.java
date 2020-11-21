package com.jeesite.modules.ia.service;

import com.jeesite.common.service.CrudService;
import com.jeesite.modules.ia.dao.IaCRsDao;
import com.jeesite.modules.ia.entity.IaCRs;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly=true)
public class IaCRsService
        extends CrudService<IaCRsDao, IaCRs>
{}
