package com.jeesite.modules.ia.service;

import com.jeesite.common.service.CrudService;
import com.jeesite.modules.ia.dao.IaZFloodDao;
import com.jeesite.modules.ia.entity.IaZFlood;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly=true)
public class IaZFloodService
        extends CrudService<IaZFloodDao, IaZFlood>
{}
