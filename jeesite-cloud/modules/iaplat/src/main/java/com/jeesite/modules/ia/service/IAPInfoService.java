package com.jeesite.modules.ia.service;

import com.jeesite.common.service.CrudService;
import com.jeesite.modules.ia.dao.IAPInfoDao;
import com.jeesite.modules.ia.entity.IAPInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly=true)
public class IAPInfoService
        extends CrudService<IAPInfoDao, IAPInfo>
{}
