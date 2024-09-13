package com.sun.ts.tests.jms.core.closedTopicSubscriber;

import com.sun.ts.tests.jms.core.closedTopicSubscriber.ClosedTopicSubscriberTests;
import java.net.URL;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.OperateOnDeployment;
import org.jboss.arquillian.container.test.api.OverProtocol;
import org.jboss.arquillian.container.test.api.TargetsContainer;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.jboss.shrinkwrap.api.exporter.ZipExporter;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import tck.arquillian.porting.lib.spi.TestArchiveProcessor;
import tck.arquillian.protocol.common.TargetVehicle;



@ExtendWith(ArquillianExtension.class)
@Tag("jms")
@Tag("platform")
@Tag("jms_web")
@Tag("web_optional")
@Tag("tck-appclient")

@TestMethodOrder(MethodOrderer.MethodName.class)
public class ClosedTopicSubscriberTestsEjbTest extends com.sun.ts.tests.jms.core.closedTopicSubscriber.ClosedTopicSubscriberTests {
    static final String VEHICLE_ARCHIVE = "closedTopicSubscriber_ejb_vehicle";

        /**
        EE10 Deployment Descriptors:
        closedTopicSubscriber_appclient_vehicle: 
        closedTopicSubscriber_appclient_vehicle_client: META-INF/application-client.xml,jar.sun-application-client.xml
        closedTopicSubscriber_ejb_vehicle: 
        closedTopicSubscriber_ejb_vehicle_client: META-INF/application-client.xml,jar.sun-application-client.xml
        closedTopicSubscriber_ejb_vehicle_ejb: META-INF/ejb-jar.xml,jar.sun-ejb-jar.xml
        closedTopicSubscriber_jsp_vehicle: 
        closedTopicSubscriber_jsp_vehicle_web: WEB-INF/web.xml,war.sun-web.xml
        closedTopicSubscriber_servlet_vehicle: 
        closedTopicSubscriber_servlet_vehicle_web: WEB-INF/web.xml,war.sun-web.xml

        Found Descriptors:
        Client:

        /com/sun/ts/tests/common/vehicle/ejb/ejb_vehicle_client.xml
        Ejb:

        /com/sun/ts/tests/jms/core/closedTopicSubscriber/ejb_vehicle_ejb.xml
        /com/sun/ts/tests/common/vehicle/ejb/ejb_vehicle_ejb.jar.sun-ejb-jar.xml
        /com/sun/ts/tests/common/vehicle/ejb/ejb_vehicle_ejb.xml
        Ear:

        */
        @TargetsContainer("tck-appclient")
        @OverProtocol("appclient")
        @Deployment(name = VEHICLE_ARCHIVE, order = 2)
        public static EnterpriseArchive createDeploymentVehicle(@ArquillianResource TestArchiveProcessor archiveProcessor) {
        // Client
            // the jar with the correct archive name
            JavaArchive closedTopicSubscriber_ejb_vehicle_client = ShrinkWrap.create(JavaArchive.class, "closedTopicSubscriber_ejb_vehicle_client.jar");
            // The class files
            closedTopicSubscriber_ejb_vehicle_client.addClasses(
            com.sun.ts.tests.jms.common.JmsTool.class,
            com.sun.ts.tests.common.vehicle.VehicleRunnable.class,
            com.sun.ts.tests.common.vehicle.VehicleRunnerFactory.class,
            com.sun.ts.tests.common.vehicle.ejb.EJBVehicleRemote.class,
            com.sun.ts.lib.harness.EETest.Fault.class,
            com.sun.ts.tests.common.vehicle.EmptyVehicleRunner.class,
            com.sun.ts.tests.common.vehicle.ejb.EJBVehicleRunner.class,
            com.sun.ts.lib.harness.EETest.class,
            com.sun.ts.lib.harness.ServiceEETest.class,
            com.sun.ts.lib.harness.EETest.SetupException.class,
            com.sun.ts.tests.common.vehicle.VehicleClient.class
            );
            // The application-client.xml descriptor
            URL resURL = ClosedTopicSubscriberTests.class.getResource("/com/sun/ts/tests/common/vehicle/ejb/ejb_vehicle_client.xml");
            if(resURL != null) {
              closedTopicSubscriber_ejb_vehicle_client.addAsManifestResource(resURL, "application-client.xml");
            }
            // The sun-application-client.xml file need to be added or should this be in in the vendor Arquillian extension?
            resURL = ClosedTopicSubscriberTests.class.getResource("//com/sun/ts/tests/common/vehicle/ejb/ejb_vehicle_client.jar.sun-application-client.xml");
            if(resURL != null) {
              closedTopicSubscriber_ejb_vehicle_client.addAsManifestResource(resURL, "application-client.xml");
            }
            closedTopicSubscriber_ejb_vehicle_client.addAsManifestResource(new StringAsset("Main-Class: " + ClosedTopicSubscriberTests.class.getName() + "\n"), "MANIFEST.MF");
            // Call the archive processor
            archiveProcessor.processClientArchive(closedTopicSubscriber_ejb_vehicle_client, ClosedTopicSubscriberTests.class, resURL);

        // Ejb
            // the jar with the correct archive name
            JavaArchive closedTopicSubscriber_ejb_vehicle_ejb = ShrinkWrap.create(JavaArchive.class, "closedTopicSubscriber_ejb_vehicle_ejb.jar");
            // The class files
            closedTopicSubscriber_ejb_vehicle_ejb.addClasses(
                com.sun.ts.tests.jms.common.JmsTool.class,
                com.sun.ts.tests.common.vehicle.VehicleRunnable.class,
                com.sun.ts.tests.common.vehicle.VehicleRunnerFactory.class,
                com.sun.ts.tests.common.vehicle.ejb.EJBVehicleRemote.class,
                com.sun.ts.lib.harness.EETest.Fault.class,
                com.sun.ts.tests.jms.core.closedTopicSubscriber.ClosedTopicSubscriberTests.class,
                com.sun.ts.lib.harness.EETest.class,
                com.sun.ts.lib.harness.ServiceEETest.class,
                com.sun.ts.lib.harness.EETest.SetupException.class,
                com.sun.ts.tests.common.vehicle.VehicleClient.class,
                com.sun.ts.tests.common.vehicle.ejb.EJBVehicle.class
            );
            // The ejb-jar.xml descriptor
            URL ejbResURL = ClosedTopicSubscriberTests.class.getResource("//com/sun/ts/tests/common/vehicle/ejb/ejb_vehicle_ejb.xml");
            if(ejbResURL != null) {
              closedTopicSubscriber_ejb_vehicle_ejb.addAsManifestResource(ejbResURL, "ejb-jar.xml");
            }
            // The sun-ejb-jar.xml file
            ejbResURL = ClosedTopicSubscriberTests.class.getResource("//com/sun/ts/tests/common/vehicle/ejb/ejb_vehicle_ejb.jar.sun-ejb-jar.xml");
            if(ejbResURL != null) {
              closedTopicSubscriber_ejb_vehicle_ejb.addAsManifestResource(ejbResURL, "sun-ejb-jar.xml");
            }
            // Call the archive processor
            archiveProcessor.processEjbArchive(closedTopicSubscriber_ejb_vehicle_ejb, ClosedTopicSubscriberTests.class, ejbResURL);

        // Ear
            EnterpriseArchive closedTopicSubscriber_ejb_vehicle_ear = ShrinkWrap.create(EnterpriseArchive.class, "closedTopicSubscriber_ejb_vehicle.ear");

            // Any libraries added to the ear

            // The component jars built by the package target
            closedTopicSubscriber_ejb_vehicle_ear.addAsModule(closedTopicSubscriber_ejb_vehicle_ejb);
            closedTopicSubscriber_ejb_vehicle_ear.addAsModule(closedTopicSubscriber_ejb_vehicle_client);



            // The application.xml descriptor
            URL earResURL = null;
            // The sun-application.xml descriptor
            earResURL = ClosedTopicSubscriberTests.class.getResource("/.ear.sun-application.xml");
            if(earResURL != null) {
              closedTopicSubscriber_ejb_vehicle_ear.addAsManifestResource(earResURL, "sun-application.xml");
            }
            // Call the archive processor
            archiveProcessor.processEarArchive(closedTopicSubscriber_ejb_vehicle_ear, ClosedTopicSubscriberTests.class, earResURL);
        return closedTopicSubscriber_ejb_vehicle_ear;
        }

        @Test
        @Override
        @TargetVehicle("ejb")
        public void closedTopicSubscriberCloseTest() throws java.lang.Exception {
            super.closedTopicSubscriberCloseTest();
        }

        @Test
        @Override
        @TargetVehicle("ejb")
        public void closedTopicSubscriberGetMessageSelectorTest() throws java.lang.Exception {
            super.closedTopicSubscriberGetMessageSelectorTest();
        }

        @Test
        @Override
        @TargetVehicle("ejb")
        public void closedTopicSubscriberReceiveTest() throws java.lang.Exception {
            super.closedTopicSubscriberReceiveTest();
        }

        @Test
        @Override
        @TargetVehicle("ejb")
        public void closedTopicSubscriberReceiveTimeoutTest() throws java.lang.Exception {
            super.closedTopicSubscriberReceiveTimeoutTest();
        }

        @Test
        @Override
        @TargetVehicle("ejb")
        public void closedTopicSubscriberReceiveNoWaitTest() throws java.lang.Exception {
            super.closedTopicSubscriberReceiveNoWaitTest();
        }

        @Test
        @Override
        @TargetVehicle("ejb")
        public void closedTopicSubscriberGetNoLocalTest() throws java.lang.Exception {
            super.closedTopicSubscriberGetNoLocalTest();
        }

        @Test
        @Override
        @TargetVehicle("ejb")
        public void closedTopicSubscriberGetTopicTest() throws java.lang.Exception {
            super.closedTopicSubscriberGetTopicTest();
        }


}