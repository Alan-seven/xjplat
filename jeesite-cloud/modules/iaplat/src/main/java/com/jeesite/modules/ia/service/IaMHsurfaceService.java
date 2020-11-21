package com.jeesite.modules.ia.service;

import com.jeesite.common.service.CrudService;
import com.jeesite.modules.ia.dao.IaMHsurfaceDao;
import com.jeesite.modules.ia.entity.IaMHsurface;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly=true)
public class IaMHsurfaceService
        extends CrudService<IaMHsurfaceDao, IaMHsurface>
{}
