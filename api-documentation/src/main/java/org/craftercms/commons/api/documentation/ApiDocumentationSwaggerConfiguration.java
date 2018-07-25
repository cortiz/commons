/*
 * Copyright (C) 2007-2013 Crafter Software Corporation.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.craftercms.commons.api.documentation;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.ordering.ResourceListingPositionalOrdering;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Swagger configuration class.
 *
 * @author Dejan Brkic
 */
@Configuration
@EnableSwagger
public class ApiDocumentationSwaggerConfiguration {

    private SpringSwaggerConfig springSwaggerConfig;

    /**
     * Required to autowire SpringSwaggerConfig
     */
    @Autowired
    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
        this.springSwaggerConfig = springSwaggerConfig;
    }
    @Value("#{'${swaggerSpringMvcPlugin.includePatterns}'.split(',')}")
    private List<String> includePatterns;

    @Value("${swagger.apiTitle}")
    private String apiTitle;

    @Value("${swagger.apiDescription}")
    private String apiDescription;

    @Value("${swagger.apiTermsOfServiceUrl}")
    private String apiTermsOfServiceUrl;

    @Value("${swagger.apiContactEmail}")
    private String apiContactEmail;

    @Value("${swagger.apiLicenceType}")
    private String apiLicenceType;

    @Value("${swagger.apiLicenceUrl}")
    private String apiLicenceUrl;

    @Value("${swagger.enablePositionalOrdering}")
    private boolean enablePositionalOrdering;


    @Bean
    public SwaggerSpringMvcPlugin customSwaggerSpringMvcPlugin(){
        SwaggerSpringMvcPlugin plugin = new SwaggerSpringMvcPlugin(this.springSwaggerConfig);
        plugin = plugin.apiInfo(apiInfo());
        plugin = plugin.includePatterns(includePatterns.toArray(new String[includePatterns.size()]));
        if (enablePositionalOrdering) {
            plugin = plugin.apiListingReferenceOrdering(new ResourceListingPositionalOrdering());
        }
        plugin = plugin.build();
        return plugin;
    }

    private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(apiTitle, apiDescription, apiTermsOfServiceUrl, apiContactEmail,
                apiLicenceType, apiLicenceUrl);
        return apiInfo;
    }
}
