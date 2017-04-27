/*
 * Copyright (C) 2016-Present Pivotal Software, Inc. All rights reserved.
 * <p>
 * This program and the accompanying materials are made available under
 * the terms of the under the Apache License, Version 2.0 (the "License”);
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

package io.pivotal.ecosystem.simple;

import io.pivotal.ecosystem.servicebroker.model.ServiceBinding;
import io.pivotal.ecosystem.servicebroker.model.ServiceInstance;
import io.pivotal.ecosystem.servicebroker.service.DefaultServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.servicebroker.exception.ServiceBrokerException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
class Broker extends DefaultServiceImpl {

    private String weatherHost;
    private String weatherPort;

    public Broker(String weatherHost, String weatherPort) {
        super();
        this.weatherHost = weatherHost;
        this.weatherPort = weatherPort;
    }

    @Override
    public void createInstance(ServiceInstance instance) throws ServiceBrokerException {
        log.info("creating instance...");
    }

    @Override
    public void deleteInstance(ServiceInstance instance) {
        log.info("deleting instance...");
    }

    @Override
    public void updateInstance(ServiceInstance instance) {
        log.info("updating instance...");
    }

    @Override
    public void createBinding(ServiceInstance instance, ServiceBinding binding) {
        log.info("binding...");
    }

    @Override
    public void deleteBinding(ServiceInstance instance, ServiceBinding binding) {
        log.info("unbinding...");
    }

    @Override
    public Map<String, Object> getCredentials(ServiceInstance instance, ServiceBinding binding) {
        log.info("returning credentials.");

        Map<String, Object> m = new HashMap<>();
        m.put("uri", "https://" + weatherHost + ":" + weatherPort);

        return m;
    }

    @Override
    public boolean isAsync() {
        return false;
    }
}