/*
 * Copyright (c) 2002-2014, Mairie de Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.portal.service.template;

import fr.paris.lutece.util.html.HtmlTemplate;

import java.util.Locale;


/**
 *
 * IFreeMarkerTemplateService
 *
 */
public interface IFreeMarkerTemplateService
{
    /**
     * Get the absolute path from relative path
     * @param strPath the path
     * @return the absolute path from relative path
     */
    String getAbsolutePathFromRelativePath( String strPath );

    /**
     * Get the default date pattern
     * @param locale the locale
     * @return the default date pattern
     */
    String getDefaultPattern( Locale locale );

    /**
     * Set the template update delay
     * @param nTemplateUpdateDelay the template update delay
     */
    void setTemplateUpdateDelay( int nTemplateUpdateDelay );

    /**
     * Adds a macro file (like the main commons.html) brought by a plugin. This file will be included for every template (autoinclude).
     * @param strFileName the filename
     */
    void addPluginMacros( String strFileName );
    
    /**
     * Add a shared variable into every template
     * @param name name of the shared variable
     * @param obj value
     */
    void setSharedVariable( String name, Object obj);

    /**
     * Initializes the service with the templates's path
     * @param strTemplatePath The template path
     */
    void init( String strTemplatePath );

    /**
     * Load a template
     * @param strPath the root path
     * @param strTemplate the path of the template from the root path
     * @return the html template
     */
    HtmlTemplate loadTemplate( String strPath, String strTemplate );

    /**
     * Load a template and process a model
     * @param strPath the root path
     * @param strTemplate the path of the template from the root path
     * @param locale The locale
     * @param rootMap the model root
     * @return the processed html template
     */
    HtmlTemplate loadTemplate( String strPath, String strTemplate, Locale locale, Object rootMap );

    /**
     * Load a template from a String and process a model
     * WARNING : This method must not be used in front office (no cache management available).
     *
     * <br /><b>Deprecated</b> Using Freemarker without cache is huge CPU consuming
     *
     * @param strTemplateData The template as a string
     * @param locale The {@link Locale}
     * @param rootMap the model root
     * @return the processed html template
     */
    @Deprecated
    HtmlTemplate loadTemplate( String strTemplateData, Locale locale, Object rootMap );

    /**
     * Clears the configuration cache
     */
    void resetConfiguration(  );

    /**
     * Reset the cache
     */
    void resetCache(  );
}
