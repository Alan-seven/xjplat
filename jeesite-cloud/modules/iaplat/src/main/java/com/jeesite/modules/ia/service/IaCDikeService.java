package com.jeesite.modules.ia.service;

import com.jeesite.common.service.CrudService;
import com.jeesite.modules.ia.dao.IaCDikeDao;
import com.jeesite.modules.ia.entity.IaCDike;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly=true)
public class IaCDikeService
        extends CrudService<IaCDikeDao, IaCDike>
{}
