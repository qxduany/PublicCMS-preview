package com.publiccms.views.directive.tools;

// Generated 2015-5-10 17:54:56 by com.publiccms.common.source.SourceGenerator

import java.io.IOException;

import com.publiccms.common.base.AbstractTemplateDirective;
import com.publiccms.common.constants.CommonConstants;
import com.publiccms.logic.component.site.FileComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.publiccms.common.handler.RenderHandler;

/**
 *
 * TaskTemplateListDirective
 * 
 */
@Component
public class TaskTemplateListDirective extends AbstractTemplateDirective {

    @Override
    public void execute(RenderHandler handler) throws IOException, Exception {
        String path = handler.getString("path", CommonConstants.SEPARATOR);
        handler.put("list", fileComponent.getFileList(siteComponent.getTaskTemplateFilePath(getSite(handler), path)))
                .render();
    }

    @Override
    public boolean needAppToken() {
        return true;
    }

    @Autowired
    private FileComponent fileComponent;
}