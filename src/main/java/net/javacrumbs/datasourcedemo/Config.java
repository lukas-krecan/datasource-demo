/**
 * Copyright 2009-2019 the original author or authors.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.javacrumbs.datasourcedemo;


import org.springframework.aop.framework.AbstractAdvisingBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class Config {
    /**
     * If this bean is used, schema.sql is not executed and the application fails.
     */
    @Bean
    public AdvisingBeanPostProcessor proxyScheduledLockAopBeanPostProcessor(DataSource dataSource) {
        return new AdvisingBeanPostProcessor(dataSource);
    }

    /**
     * If this bean is used, schema.sql is executed and the application starts.
     */
//    @Bean
//    public AdvisingBeanPostProcessor proxyScheduledLockAopBeanPostProcessor() {
//        return new AdvisingBeanPostProcessor(null);
//    }

    /**
     * Configures AOP proxy (not needed for the example)
     */
    static class AdvisingBeanPostProcessor extends AbstractAdvisingBeanPostProcessor {
        public AdvisingBeanPostProcessor(DataSource dataSource) {

        }
    }
}
