package com.jeesite.modules.ia.service;

import com.jeesite.common.service.CrudService;
import com.jeesite.modules.ia.dao.IaCDaminfoDao;
import com.jeesite.modules.ia.entity.IaCDaminfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly=true)
public class IaCDaminfoService
        extends CrudService<IaCDaminfoDao, IaCDaminfo>
{}
