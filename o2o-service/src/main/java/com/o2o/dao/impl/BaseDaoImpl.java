package com.o2o.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanMap;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.o2o.ao.QueryInfo;
import com.o2o.ao.WXResultSet;
import com.o2o.dao.BaseDao;
import com.o2o.dto.BaseEntity;
import com.o2o.util.O2OBeanUtils;

/**
 * @author wulei
 * @param <T>
 * @param <ID>
 * @date 2016年4月20日
 * @version 1.0
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public abstract class BaseDaoImpl<T extends BaseEntity, ID extends Serializable> extends SqlSessionDaoSupport implements
		BaseDao<T, ID> {
	public static final String LIMIT_STARD = "limitStart";
	public static final String LIMIT_END = "limitEnd";
	public static final String QUERY_INFO = "queryInfo";

	@Override
	public Long generateLocalId(Long companyId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("companyId", companyId);
		params.put("sysName", "WX");
		params.put("clsName", getMapperNamespace());
		return getSqlSession().selectOne("com.qjyt.erp.po.ErpIdSeedMapper.selectLocalSeqNum", params);
	}

	@Override
	public Long generateId() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("sysName", "WX");
		params.put("clsName", getMapperNamespace());
		System.out.println(getMapperNamespace());
		return getSqlSession().selectOne("com.qjyt.erp.po.ErpIdSeedMapper.selectSeqNum", params);
	}

	@Override
	public Long generateId(String ns) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("sysName", "WX");
		params.put("clsName", ns);
		return getSqlSession().selectOne("com.qjyt.erp.po.ErpIdSeedMapper.selectSeqNum", params);
	}
	@Override
	public Long generateId(Class clz) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("sysName", "WX");
		params.put("clsName", clz.getName() + "Mapper");
		return getSqlSession().selectOne("com.qjyt.erp.po.ErpIdSeedMapper.selectSeqNum", params);
	}

	@Override
	public int save(T entity) {
		// TODO Auto-generated method stub
		if (entity.getId() == null) {
			entity.setId(generateId());
		}
		return getSqlSession().insert(getMapperNamespace() + ".insert", entity);
	}

	@Override
	public int save(Collection<T> entities) {
		// TODO Auto-generated method stub
		if (entities == null || entities.size() == 0)
			return 0;
		for (T entity : entities) {
			if (entity.getId() == null) {
				entity.setId(generateId());
			}
		}
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("list", entities);

		return getSqlSession().insert(getMapperNamespace() + ".insertBatch", param);
	}

	@Override
	public int saveSelective(T entity) {
		// TODO Auto-generated method stub
		if (entity.getId() == null) {
			entity.setId(generateId());
		}
		return getSqlSession().insert(getMapperNamespace() + ".insertSelective", entity);
	}

	@Override
	public int saveSelective(Collection<T> entities) {
		// TODO Auto-generated method stub
		if (entities == null || entities.size() == 0)
			return 0;
		for (T entity : entities) {
			if (entity.getId() == null) {
				entity.setId(generateId());
			}
		}
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("list", entities);

		return getSqlSession().insert(getMapperNamespace() + ".insertSelectiveBatch", param);
	}

	@Override
	public int update(T entity) {
		// TODO Auto-generated method stub
		return getSqlSession().update(getMapperNamespace() + ".updateById", entity);
	}

	@Override
	public int updateSelective(T entity) {
		// TODO Auto-generated method stub
		return getSqlSession().update(getMapperNamespace() + ".updateByIdSelective", entity);
	}

	@Override
	public int updateByExample(T entity, T example) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("entity", entity);
		params.put("example", example);

		return getSqlSession().update(getMapperNamespace() + ".updateByExample", params);
	}

	@Override
	public int updateByExampleSelective(T entity, T example) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("entity", entity);
		params.put("example", example);

		return getSqlSession().update(getMapperNamespace() + ".updateByExampleSelective", params);
	}

	@Override
	public int saveOrUpdate(T entity) {
		// TODO Auto-generated method stub
		BaseEntity base = (BaseEntity) entity;
		if (base.getId() == null) {
			return save(entity);
		} else {
			return update(entity);
		}
	}

	@Override
	public int saveOrUpdateSelective(T entity) {
		// TODO Auto-generated method stub
		BaseEntity base = (BaseEntity) entity;
		if (base.getId() == null) {
			return saveSelective(entity);
		} else {
			return updateSelective(entity);
		}
	}

	@Override
	public int delete(ID id) {
		// TODO Auto-generated method stub
		return getSqlSession().delete(getMapperNamespace() + ".deleteById", id);
	}

	@Override
	public int delete(ID[] ids) {
		// TODO Auto-generated method stub
		int rows = 0;
		for (ID id : ids) {
			rows += delete(id);
		}
		return rows;
	}

	@Override
	public int deleteByExample(T example) {
		// TODO Auto-generated method stub
		return getSqlSession().delete(getMapperNamespace() + ".deleteByExample", example);
	}

	@Override
	public T findById(ID id) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne(getMapperNamespace() + ".selectById", id);
	}

	@Override
	public List<T> findById(ID[] ids) {
		// TODO Auto-generated method stub
		List<T> list = new ArrayList<T>(0);
		for (ID id : ids) {
			list.add(findById(id));
		}
		return list;
	}

	@Override
	public List<T> findByExample(T entity) {
		// TODO Auto-generated method stub
		BeanMap beanMap = new BeanMap(entity);
		return getSqlSession().selectList(getMapperNamespace() + ".selectByExample", beanMap);
	}

	@Override
	public WXResultSet<T> findPageByExample(QueryInfo queryInfo, T entity) {
		// TODO Auto-generated method stub
		Map beanMap = new HashMap();
		beanMap.put(LIMIT_STARD, queryInfo.getStart());
		beanMap.put(LIMIT_END, queryInfo.getEnd());
		try {
			beanMap.putAll(O2OBeanUtils.convertBean(entity));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long rows = getSqlSession().selectOne(getMapperNamespace() + ".countByExample", beanMap);
		List<T> result = getSqlSession().selectList(getMapperNamespace() + ".selectByExample", beanMap);

		return new WXResultSet<T>(rows, result);
	}

	@Override
	public long countByExample(T entity) {
		// TODO Auto-generated method stub
		Map beanMap = new HashMap();
		try {
			beanMap.putAll(O2OBeanUtils.convertBean(entity));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getSqlSession().selectOne(getMapperNamespace() + ".countByExample", beanMap);
	}

	@Override
	public List<T> findSuperByExample(T entity) {
		Map beanMap = new HashMap();
		try {
			beanMap.putAll(O2OBeanUtils.convertBean(entity));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getSqlSession().selectList(getMapperNamespace() + ".selectSuperByUserDefined", beanMap);
	}

	@Override
	public long countSuperByExample(T entity) {
		Map beanMap = new HashMap();
		try {
			beanMap.putAll(O2OBeanUtils.convertBean(entity));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return getSqlSession().selectOne(getMapperNamespace() + ".countSuperByUserDefined", beanMap);
	}

	@Override
	public WXResultSet<T> findSuperPageByExample(QueryInfo queryInfo, T entity) {
		Map beanMap = new HashMap();
		if (queryInfo != null) {
			beanMap.put(LIMIT_STARD, queryInfo.getStart());
			beanMap.put(LIMIT_END, queryInfo.getEnd());
		}
		try {
			beanMap.putAll(O2OBeanUtils.convertBean(entity));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		long rows = getSqlSession().selectOne(getMapperNamespace() + ".countSuperByUserDefined", beanMap);
		List<T> result = getSqlSession().selectList(getMapperNamespace() + ".selectSuperByUserDefined", beanMap);

		return new WXResultSet<T>(rows, result);
	}

	public abstract String getMapperNamespace();
}
