package com.jeesite.modules.ia.service;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.ia.dao.IACPrevadDao;
import com.jeesite.modules.ia.entity.IACPrevad;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly=true)
public class IACPrevadService extends CrudService<IACPrevadDao, IACPrevad>{

}
