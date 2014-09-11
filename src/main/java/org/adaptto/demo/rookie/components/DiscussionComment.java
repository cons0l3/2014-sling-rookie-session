/*
 * #%L
 * adaptTo()
 * %%
 * Copyright (C) 2014 adaptTo() Conference
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package org.adaptto.demo.rookie.components;

import java.io.IOException;
import java.io.Writer;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.ServletException;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.felix.scr.annotations.sling.SlingServlet;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;

/**
 * Servlet example comment for social comment entry
 */
@SlingServlet(resourceTypes="/apps/rookiedemo/components/social/comment")
public class DiscussionComment extends SlingSafeMethodsServlet {
  private static final long serialVersionUID = -6549518176129073294L;

  @Override
  protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
    Writer out = response.getWriter();

    // read properties via Sling API
    ValueMap props = request.getResource().getValueMap();
    String author = props.get("author", "Anonymous");
    Date created = props.get("jcr:created", Date.class);
    String text = props.get("text", "");

    // output comment as HTML
    out.write("<p>");
    out.write("<em>" + StringEscapeUtils.escapeHtml(author)
        + " (" + DateFormat.getDateTimeInstance().format(created) + ")</em><br/>");
    out.write(StringEscapeUtils.escapeHtml(text));
    out.write("</p>");

  }

}
