package com.publiccms.logic.dao.cms;

import static com.publiccms.common.tools.CommonUtils.empty;
import static com.publiccms.common.tools.CommonUtils.notEmpty;

// Generated 2016-1-19 11:41:45 by com.publiccms.common.source.SourceGenerator

import org.springframework.stereotype.Repository;

import com.publiccms.common.base.BaseDao;
import com.publiccms.common.handler.PageHandler;
import com.publiccms.common.handler.QueryHandler;
import com.publiccms.entities.cms.CmsCategory;
import com.publiccms.views.pojo.query.CmsCategoryQuery;

/**
 *
 * CmsCategoryDao
 * 
 */
@Repository
public class CmsCategoryDao extends BaseDao<CmsCategory> {
    /**
     * @param queryEntity
     * @param pageIndex
     * @param pageSize
     * @return results page
     */
    public PageHandler getPage(CmsCategoryQuery queryEntity, Integer pageIndex, Integer pageSize) {
        QueryHandler queryHandler = getQueryHandler("from CmsCategory bean");
        if (notEmpty(queryEntity.getSiteId())) {
            queryHandler.condition("bean.siteId = :siteId").setParameter("siteId", queryEntity.getSiteId());
        }
        if (notEmpty(queryEntity.getParentId())) {
            queryHandler.condition("bean.parentId = :parentId").setParameter("parentId", queryEntity.getParentId());
        } else if (null == queryEntity.getQueryAll() || !queryEntity.getQueryAll()) {
            queryHandler.condition("bean.parentId is null");
        }
        if (notEmpty(queryEntity.getTypeId())) {
            queryHandler.condition("bean.typeId = :typeId").setParameter("typeId", queryEntity.getTypeId());
        }
        if (null != queryEntity.getAllowContribute()) {
            queryHandler.condition("bean.allowContribute = :allowContribute").setParameter("allowContribute",
                    queryEntity.getAllowContribute());
        }
        if (null != queryEntity.getHidden()) {
            queryHandler.condition("bean.hidden = :hidden").setParameter("hidden", queryEntity.getHidden());
        }
        if (null != queryEntity.getDisabled()) {
            queryHandler.condition("bean.disabled = :disabled").setParameter("disabled", queryEntity.getDisabled());
        }
        queryHandler.order("bean.sort asc,bean.id asc");
        return getPage(queryHandler, pageIndex, pageSize);
    }

    @Override
    protected CmsCategory init(CmsCategory entity) {
        if (empty(entity.getChildIds())) {
            entity.setChildIds(null);
        }
        return entity;
    }

}