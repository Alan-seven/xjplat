package com.jeesite.modules.ia.service;

import com.jeesite.common.service.CrudService;
import com.jeesite.modules.ia.dao.IaCSluiceDao;
import com.jeesite.modules.ia.entity.IaCSluice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly=true)
public class IaCSluiceService
        extends CrudService<IaCSluiceDao, IaCSluice>
{}
