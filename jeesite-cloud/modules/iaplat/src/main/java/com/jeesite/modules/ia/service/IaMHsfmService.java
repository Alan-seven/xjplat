package com.jeesite.modules.ia.service;

import com.jeesite.common.service.CrudService;
import com.jeesite.modules.ia.dao.IaMHsfmDao;
import com.jeesite.modules.ia.entity.IaMHsfm;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly=true)
public class IaMHsfmService
        extends CrudService<IaMHsfmDao, IaMHsfm>
{}
