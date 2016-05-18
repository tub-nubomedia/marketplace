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

package org.nubomedia.marketplace.catalogue;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.nubomedia.marketplace.catalogue.utils.IdGenerator;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Version;

/**
 * Created by maa on 09.11.15.
 */
@Entity
public class NubomediaPort {

    @JsonIgnore
    @Id
    private String id;

    @JsonIgnore
    @Version
    private int hb_version = 0;

    private int targetPort;

    private String protocol;

    private int port;

    @PrePersist
    public void ensureId(){
        id = IdGenerator.createUUID();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getTargetPort() {
        return targetPort;
    }

    public void setTargetPort(int targetPort) {
        this.targetPort = targetPort;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "NubomediaPort{" +
                "targetPort=" + targetPort +
                ", protocol='" + protocol + '\'' +
                ", port=" + port +
                '}';
    }
}

