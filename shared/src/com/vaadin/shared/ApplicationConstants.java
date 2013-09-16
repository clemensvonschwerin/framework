/*
 * Copyright 2000-2013 Vaadin Ltd.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.vaadin.shared;

import java.io.Serializable;

public class ApplicationConstants implements Serializable {

    // This indicates the whole page is generated by us (not embedded)
    public static final String GENERATED_BODY_CLASSNAME = "v-generated-body";

    public static final String APP_PATH = "APP";

    public static final String UIDL_PATH = "UIDL";

    public static final String HEARTBEAT_PATH = "HEARTBEAT";

    public static final String PUSH_PATH = "PUSH";

    public static final String PUBLISHED_FILE_PATH = APP_PATH + '/'
            + "PUBLISHED";

    public static final String APP_PROTOCOL_PREFIX = "app://";
    public static final String VAADIN_PROTOCOL_PREFIX = "vaadin://";
    public static final String PUBLISHED_PROTOCOL_NAME = "published";
    public static final String PUBLISHED_PROTOCOL_PREFIX = PUBLISHED_PROTOCOL_NAME
            + "://";
    public static final String UIDL_SECURITY_TOKEN_ID = "Vaadin-Security-Key";

    @Deprecated
    public static final String UPDATE_VARIABLE_INTERFACE = "v";
    @Deprecated
    public static final String UPDATE_VARIABLE_METHOD = "v";

    public static final String SERVICE_URL = "serviceUrl";

    public static final String SERVICE_URL_PATH_AS_PARAMETER = "usePathParameter";

    // Javadocs in ApplicationConfiguration should be updated if this is changed
    public static final String V_RESOURCE_PATH = "v-resourcePath";

    @Deprecated
    public static final String DRAG_AND_DROP_CONNECTOR_ID = "DD";

    /**
     * URL parameter used in UIDL requests to indicate that the full server-side
     * state should be returned to the client, i.e. without any incremental
     * changes.
     */
    public static final String URL_PARAMETER_REPAINT_ALL = "repaintAll";

    /**
     * Configuration parameter giving the (in some cases relative) URL to the
     * VAADIN folder from where themes and widgetsets are loaded.
     * <p>
     * <b>Refactor warning:</b> This value is also hardcoded in
     * vaadinBootstrap.js.
     * </p>
     */
    public static final String VAADIN_DIR_URL = "vaadinDir";

    /**
     * The name of the javascript containing push support. The file is located
     * in the VAADIN directory.
     */
    public static final String VAADIN_PUSH_JS = "vaadinPush.js";

    /**
     * The name of the debug version of the javascript containing push support.
     * The file is located in the VAADIN directory.
     * 
     * @since 7.1.6
     */
    public static final String VAADIN_PUSH_DEBUG_JS = "vaadinPush.debug.js";

    /**
     * Name of the parameter used to transmit the CSRF token.
     */
    public static final String CSRF_TOKEN_PARAMETER = "v-csrfToken";
}
