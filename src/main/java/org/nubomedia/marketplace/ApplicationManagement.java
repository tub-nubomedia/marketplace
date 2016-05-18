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

import javassist.NotFoundException;
import org.nubomedia.marketplace.catalogue.Application;
import org.nubomedia.marketplace.repository.ApplicationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by mpa on 17.05.16.
 */
@Service
@Scope
public class ApplicationManagement {

    protected Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ApplicationRepository applicationRepository;

    public Application add(Application application) {
        log.debug("Adding new Application: " + application);
        application = applicationRepository.save(application);
        log.info("Added new Application: " + application);
        return application;
    }

    public void delete(String id) throws NotFoundException {
        log.debug("Deleting Application: " + id);
        Application application = applicationRepository.findOne(id);
        if (application == null) {
            throw new NotFoundException("Not found Application with ID: " + id);
        }
        applicationRepository.delete(id);
        log.info("Deleted Application: " + id);
    }

    public Application get(String id) throws NotFoundException {
        log.debug("Getting Application: " + id);
        Application application = applicationRepository.findOne(id);
        if (application == null) {
            throw new NotFoundException("Not found Application with ID: " + id);
        }
        log.info("Got Application: " + application);
        return application;
    }

    public Set<Application> get() {
        log.debug("Listing Applications...");
        Iterable<Application> application = applicationRepository.findAll();
        log.info("Listed Applications: " + application);
        return fromIterbaleToSet(application);
    }

    public Application update(String id, Application application) throws NotFoundException {
        log.debug("Updating Application: " + id);
        Application applicationToUpdate = applicationRepository.findOne(id);
        if (applicationToUpdate == null) {
            throw new NotFoundException("Not found Application with ID: " + id);
        }
        application.setId(applicationToUpdate.getId());
        application.setHb_version(applicationToUpdate.getHb_version());
        applicationToUpdate = application;
        applicationToUpdate = applicationRepository.save(applicationToUpdate);
        log.info("Updated Application: " + applicationToUpdate);
        return applicationToUpdate;
    }

    private Set fromIterbaleToSet(Iterable iterable) {
        Set set = new HashSet();
        Iterator iterator = iterable.iterator();
        while (iterator.hasNext()) {
            set.add(iterator.next());
        }
        return set;
    }
}
