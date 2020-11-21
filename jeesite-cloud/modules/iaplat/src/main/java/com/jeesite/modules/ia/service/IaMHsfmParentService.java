package com.jeesite.modules.ia.service;

import com.jeesite.common.service.CrudService;
import com.jeesite.modules.ia.dao.IaMHsfmParentDao;
import com.jeesite.modules.ia.entity.IaMHsfmParent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly=true)
public class IaMHsfmParentService
        extends CrudService<IaMHsfmParentDao, IaMHsfmParent>
{}
