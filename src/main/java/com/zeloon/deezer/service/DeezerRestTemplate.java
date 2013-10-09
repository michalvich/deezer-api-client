/*
 * Copyright 2002-2013 the original author or authors.
 *
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
 */
package com.zeloon.deezer.service;

import com.zeloon.deezer.io.ResourceConnection;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class DeezerRestTemplate {

    private static final String DEEZER_URI = "http://api.deezer.com/";

    private ResourceConnection resourceConnection;

    public DeezerRestTemplate(ResourceConnection resourceConnection) {
        this.resourceConnection = resourceConnection;
    }

    public <T> T get(final String prefix, Class<T> targetClass) {
        return getData(prefix, targetClass);
    }

    public  <T> T get(final String prefix, final Long id, Class<T> targetClass) {
        final String requestedUri = prefix + "/" + id;
        return getData(requestedUri, targetClass);
    }

    public <T> T get(final String prefix, final Long id, final String postfix, Class<T> targetClass) {
        final String requestedUri = prefix + "/" + id + "/" + postfix;
        return getData(requestedUri, targetClass);
    }

    private <T> T getData(final String uri, Class<T> targetClass) {
        final String requestedUrl = DEEZER_URI + uri;
        try {
            final String response = resourceConnection.getData(requestedUrl);
            if (containsError(response)) {
                throw new RestClientException("Error " + response);
            } else {
                return convertJson(resourceConnection.getData(requestedUrl), targetClass);
            }
        } catch (IOException ex) {
            throw new RestClientException("There is an exception for url " + requestedUrl, ex);
        }
    }

    private <T> T convertJson(final String content, Class<T> targetClass) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(content, targetClass);
    }

    private Boolean containsError(final String response) {
        return response.startsWith("{\"error");
    }

}
