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

package org.nubomedia.marketplace.api;

import javassist.NotFoundException;
import org.nubomedia.marketplace.ApplicationManagement;
import org.nubomedia.marketplace.catalogue.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.NoResultException;
import javax.validation.Valid;
import java.util.Set;

/**
 * Created by mpa on 17.05.16.
 */
@RestController
@RequestMapping("/api/v1/app")
public class RestApplication {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ApplicationManagement applicationManagement;

    /**
     * Adds a new Application to the marketplace
     *
     * @param application
     * @return Application
     */
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Application create(@RequestBody @Valid Application application) {
        log.trace("Incoming request for adding a new Application: " + application);
        application.setId(null);
        application = applicationManagement.add(application);
        log.trace("Incoming request served for adding a new Application: " + application);
        return application;

    }

    /**
     * Deletes an Application from the marketplace
     *
     * @param id
     */
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") String id) throws NotFoundException {
        log.trace("Incoming request for deleting Application: " + id);
        applicationManagement.delete(id);
        log.trace("Incoming request served by deleting Application: " + id);
    }

    /**
     * Returns an Application with the given ID from the marketplace
     *
     * @param id
     * @return Application
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Application get(@PathVariable("id") String id) throws NotFoundException {
        log.trace("Incoming request for getting Application: " + id);
        Application application = applicationManagement.get(id);
        log.trace("Incoming request served by returning Application: " + id);
        return application;
    }

    /**
     * Lists all Applications of the marketplace
     *
     * @return List<Application>
     */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Set<Application> get() {
        log.trace("Incoming request for listing Applications...");
        Set<Application> applications = applicationManagement.get();
        log.trace("Incoming request served by lsting all Applications: " + applications);
        return applications;
    }

    /**
     * Updates the Application with the given ID of the marketplace
     *
     * @param id
     * @param application
     * @return Application
     */
    @RequestMapping(value = "{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Application update(@PathVariable("id") String id, @RequestBody @Valid Application application) throws NotFoundException {
        log.trace("Incoming request for updating Application: " + id + " with: " + application);
        application = applicationManagement.update(id, application);
        log.trace("Incoming request served by updating Application: " + application);
        return application;

    }

}
