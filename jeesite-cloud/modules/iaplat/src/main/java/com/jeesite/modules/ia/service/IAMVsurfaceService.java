package com.jeesite.modules.ia.service;

import com.jeesite.common.service.CrudService;
import com.jeesite.modules.ia.dao.IAMVsurfaceDao;
import com.jeesite.modules.ia.entity.IAMVsurface;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly=true)
public class IAMVsurfaceService
        extends CrudService<IAMVsurfaceDao, IAMVsurface>
{}
