/*
 * Copyright (C) 2007-2014 Crafter Software Corporation.
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
package org.craftercms.commons.cache;

import org.ehcache.Cache;
import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Required;

import javax.annotation.PostConstruct;

/**
 * Spring {@link org.springframework.beans.factory.FactoryBean} used to create EhCache caches as beans.
 * @deprecated {@link org.springframework.cache.ehcache.EhCacheFactoryBean}
 * @author avasquez
 */
@Deprecated(since = "3.0.16",forRemoval = true)
public class EhCacheFactoryBean implements FactoryBean<Cache> {

    private CacheConfiguration configuration;
    private Cache cache;

    @Required
    public void setConfiguration(CacheConfiguration configuration) {
        this.configuration = configuration;
    }

    @PostConstruct
    public void init() {
       cache = CacheManagerBuilder.newCacheManagerBuilder().build().createCache(configuration.toString(), configuration);
    }

    @Override
    public Cache getObject() throws Exception {
        return cache;
    }

    @Override
    public Class<?> getObjectType() {
        return Cache.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

}
