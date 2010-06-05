/*
 * Licensed to Elastic Search and Shay Banon under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. Elastic Search licenses this
 * file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.search.facets;

import org.elasticsearch.ElasticSearchIllegalArgumentException;

/**
 * A search facet.
 *
 * @author kimchy (shay.banon)
 */
public interface Facet {

    enum Type {
        TERMS(0),
        QUERY(1),
        STATISTICAL(2);

        int id;

        Type(int id) {
            this.id = id;
        }

        public int id() {
            return id;
        }

        public static Type fromId(int id) {
            if (id == 0) {
                return TERMS;
            } else if (id == 1) {
                return QUERY;
            } else if (id == 2) {
                return STATISTICAL;
            } else {
                throw new ElasticSearchIllegalArgumentException("No match for id [" + id + "]");
            }
        }
    }

    /**
     * The "logical" name of the search facet.
     */
    String name();

    /**
     * The "logical" name of the search facet.
     */
    String getName();

    /**
     * The type of the facet.
     */
    Type type();

    /**
     * The type of the facet.
     */
    Type getType();
}
