package com.jeesite.modules.ia.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.ia.entity.IaCBridge;

@MyBatisDao
public abstract interface IaCBridgeDao
        extends CrudDao<IaCBridge>
{}