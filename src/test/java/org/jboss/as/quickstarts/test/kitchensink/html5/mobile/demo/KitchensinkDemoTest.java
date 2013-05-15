/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc., and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jboss.as.quickstarts.test.kitchensink.html5.mobile.demo;

import java.net.URL;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.drone.api.annotation.Drone;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * A test skeleton which uses the Arquillian controller as a test controller.
 * 
 * @author <a href="mailto:aemmanou@redhat.com">Tolis Emmanouilidis</a>
 * 
 */
@RunWith(Arquillian.class)
public abstract class KitchensinkDemoTest {

    /**
     * The context root.
     */
    @ArquillianResource
    protected URL contextRoot;

    /**
     * The browser instance.
     */
    @Drone
    protected WebDriver driver;

    /**
     * Deploys the {@link Archive} on the AS.
     * 
     * @return An {@link Archive}.
     */
    @Deployment(testable = false)
    public static Archive<?> createTestArchive() {
        return Deployments.createDeployment();
    }

    /**
     * Initializes the page url.
     */
    public void initializePageUrl() {
        try {
            driver.get(new URL(contextRoot, getPagePath()).toExternalForm());
        } catch (final Exception ignore) {
        }
    }

    /**
     * Navigates to page.
     */
    public void navigateToURL(String page) {
        try {
            driver.get(new URL(contextRoot, page).toExternalForm());
        } catch (final Exception ignore) {
        }
    }

    /**
     * The abstract method whose implementation defines which page will be initialized in the initializePageUrl method.
     * 
     * @return A string which specifies the path.
     */
    protected abstract String getPagePath();
}