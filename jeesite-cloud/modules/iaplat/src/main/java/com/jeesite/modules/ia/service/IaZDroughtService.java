package com.jeesite.modules.ia.service;

import com.jeesite.common.service.CrudService;
import com.jeesite.modules.ia.dao.IaZDroughtDao;
import com.jeesite.modules.ia.entity.IaZDrought;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly=true)
public class IaZDroughtService extends CrudService<IaZDroughtDao, IaZDrought>{

}
