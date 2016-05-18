/*
 *
 *  *  Copyright (c) 2015 Technische Universität Berlin
 *  *   Licensed under the Apache License, Version 2.0 (the "License");
 *  *   you may not use this file except in compliance with the License.
 *  *   You may obtain a copy of the License at
 *  *
 *  *          http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  *   Unless required by applicable law or agreed to in writing, software
 *  *   distributed under the License is distributed on an "AS IS" BASIS,
 *  *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *   See the License for the specific language governing permissions and
 *  *   limitations under the License.
 *
 */

package org.nubomedia.marketplace;

import org.nubomedia.marketplace.repository.ApplicationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by mpa on 13.05.16.
 */
@SpringBootApplication
@EntityScan("org.nubomedia.marketplace.catalogue")
@ComponentScan({"org.nubomedia.marketplace", "org.nubomedia.marketplace.api"})
@EnableJpaRepositories("org.nubomedia.marketplace.repository")
//@ContextConfiguration
public class Marketplace {

    protected Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ApplicationManagement applicationManagement;

}
