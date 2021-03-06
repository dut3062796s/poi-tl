/*
 * Copyright 2014-2020 Sayi
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.deepoove.poi.render.processor;

import java.util.List;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.render.compute.RenderDataCompute;
import com.deepoove.poi.template.InlineIterableTemplate;
import com.deepoove.poi.template.IterableTemplate;
import com.deepoove.poi.template.MetaTemplate;
import com.deepoove.poi.template.run.RunTemplate;

public abstract class DefaultTemplateProcessor implements Visitor {

    protected XWPFTemplate template;
    protected RenderDataCompute renderDataCompute;

    public DefaultTemplateProcessor(XWPFTemplate template, RenderDataCompute renderDataCompute) {
        this.template = template;
        this.renderDataCompute = renderDataCompute;
    }

    protected void visitOther(MetaTemplate template) {
        // no-op
    }

    public void process(List<MetaTemplate> templates) {
        // process in order( or sort first)
        templates.forEach(template -> template.accept(this));
    }

    @Override
    public void visit(InlineIterableTemplate iterableTemplate) {
        visitOther(iterableTemplate);
    }

    @Override
    public void visit(RunTemplate runTemplate) {
        visitOther(runTemplate);
    }

    @Override
    public void visit(IterableTemplate iterableTemplate) {
        visitOther(iterableTemplate);
    }

}
