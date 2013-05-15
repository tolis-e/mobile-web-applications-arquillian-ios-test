# Kitchensink HTML5 Mobile iOS Functional Test
This project contains the functional tests for the [Kitchensink HTML5 Mobile Demo](https://github.com/jboss-jdf/jboss-as-quickstart/tree/master/kitchensink-html5-mobile) project on iOS. The purpose of the project is to demonstrate how to test a mobile web application on iOS using the [Arquillian](http://arquillian.org/) testing platform.

The [Arquillian](http://arquillian.org/) testing platform is used to enable the testing automation. Arquillian integrates transparently with the testing framework which is JUnit in this case.

## Functional Test Content
The Kitchensink HTML5 Mobile iOS Functional Test defines the three core aspects needed for the execution of an [Arquillian](http://arquillian.org/) test case:

- container — the runtime environment
- deployment — the process of dispatching an artifact to a container
- archive — a packaged assembly of code, configuration and resources

The container's configuration resides in the [Arquillian XML](https://github.com/tolis-e/mobile-web-applications-arquillian-ios-test/blob/master/src/test/resources/arquillian.xml) configuration file while the deployment and the archive are defined in the [Deployments](https://github.com/tolis-e/mobile-web-applications-arquillian-ios-test/blob/master/src/test/java/org/jboss/as/quickstarts/test/kitchensink/html5/mobile/demo/Deployments.java) file.

The test case is dispatched to the container's environment through coordination with ShrinkWrap, which is used to declaratively define a custom Java EE archive that encapsulates the test class and its dependent resources. Arquillian packages the ShrinkWrap defined archive at runtime and deploys it to the target container. It then negotiates the execution of the test methods and captures the test results using remote communication with the server. Finally, Arquillian undeploys the test archive.

The [POM](https://github.com/tolis-e/mobile-web-applications-arquillian-ios-test/blob/master/pom.xml) file contains two profiles:

* arq-jboss-managed — managed container 
* arq-jboss-remote — remote container

By default the arq-jboss-managed (managed container) profile is active. An Arquillian maanged container is a container whose lifecycle is managed by Arquillian. In order to use the remote container profile, activate the corresponding profile in the [POM](https://github.com/tolis-e/mobile-web-applications-arquillian-ios-test/blob/master/pom.xml) file and set the default="true" flag on the jboss-remote configuration in the [Arquillian XML](https://github.com/tolis-e/mobile-web-applications-arquillian-ios-test/blob/master/src/test/resources/arquillian.xml) file. Set the flag to false for the jboss-managed configuration as well.

For convenience reasons, the mobile application's WAR is included in the project. You can find it inside the src/test/resources/assets folder. 

This example has been tested on Mac OS X version 10.8.2.

## Development approach/methodologies
The development approach is driven from the desire to decouple the testing algorithmic steps / scenarios from the implementation which is tied to a specific DOM structure. For that reason the Page Objects and Page Fragments patterns are used. The Page Objects pattern is used to encapsulate the tested page's structure into one class which contains all the page's parts together with all methods which you will find useful while testing it. The Page Fragments pattern encapsulates parts of the tested page into reusable pieces across all your tests.

## Functional Test Execution

Before executing the functional test you have to install the [Arquillian iOS Extension](https://github.com/arquillian/arquillian-extension-ios). Since this artifact is not available from the Maven Central Repository yet, you have to install it in your Maven repository manually.

Clone the [repository](https://github.com/arquillian/arquillian-extension-ios.git) and execute:

    mvn install

The execution of the functional test is done through maven:

    mvn test    
    
## Important Notes
As mentioned in the [Arquillian iOS Extension README](https://github.com/arquillian/arquillian-extension-ios/blob/master/README.md) file, the configuration inside the Arquillian XML might change in the future.

## Documentation

* [Arquillian Guides](http://arquillian.org/guides/)
