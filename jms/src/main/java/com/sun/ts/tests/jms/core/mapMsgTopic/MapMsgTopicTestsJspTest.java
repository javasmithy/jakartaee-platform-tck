package com.sun.ts.tests.jms.core.mapMsgTopic;

import com.sun.ts.tests.jms.core.mapMsgTopic.MapMsgTopicTests;
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
@Tag("tck-javatest")

@TestMethodOrder(MethodOrderer.MethodName.class)
public class MapMsgTopicTestsJspTest extends com.sun.ts.tests.jms.core.mapMsgTopic.MapMsgTopicTests {
    static final String VEHICLE_ARCHIVE = "mapMsgTopic_jsp_vehicle";

        /**
        EE10 Deployment Descriptors:
        mapMsgTopic_appclient_vehicle: 
        mapMsgTopic_appclient_vehicle_client: META-INF/application-client.xml,jar.sun-application-client.xml
        mapMsgTopic_ejb_vehicle: 
        mapMsgTopic_ejb_vehicle_client: META-INF/application-client.xml,jar.sun-application-client.xml
        mapMsgTopic_ejb_vehicle_ejb: META-INF/ejb-jar.xml,jar.sun-ejb-jar.xml
        mapMsgTopic_jsp_vehicle: 
        mapMsgTopic_jsp_vehicle_web: WEB-INF/web.xml,war.sun-web.xml
        mapMsgTopic_servlet_vehicle: 
        mapMsgTopic_servlet_vehicle_web: WEB-INF/web.xml,war.sun-web.xml

        Found Descriptors:
        War:

        /com/sun/ts/tests/jms/core/mapMsgTopic/jsp_vehicle_web.xml
        /com/sun/ts/tests/common/vehicle/jsp/jsp_vehicle_web.xml
        Ear:

        */
        @TargetsContainer("tck-javatest")
        @OverProtocol("javatest")
        @Deployment(name = VEHICLE_ARCHIVE, order = 2)
        public static EnterpriseArchive createDeploymentVehicle(@ArquillianResource TestArchiveProcessor archiveProcessor) {
        // War
            // the war with the correct archive name
            WebArchive mapMsgTopic_jsp_vehicle_web = ShrinkWrap.create(WebArchive.class, "mapMsgTopic_jsp_vehicle_web.war");
            // The class files
            mapMsgTopic_jsp_vehicle_web.addClasses(
            com.sun.ts.tests.jms.common.JmsTool.class,
            com.sun.ts.tests.common.vehicle.VehicleRunnable.class,
            com.sun.ts.tests.common.vehicle.VehicleRunnerFactory.class,
            com.sun.ts.lib.harness.EETest.Fault.class,
            com.sun.ts.tests.jms.core.mapMsgTopic.MapMsgTopicTests.class,
            com.sun.ts.lib.harness.EETest.class,
            com.sun.ts.lib.harness.ServiceEETest.class,
            com.sun.ts.lib.harness.EETest.SetupException.class,
            com.sun.ts.tests.common.vehicle.VehicleClient.class
            );
            // The web.xml descriptor
            URL warResURL = MapMsgTopicTests.class.getResource("/com/sun/ts/tests/common/vehicle/jsp/jsp_vehicle_web.xml");
            if(warResURL != null) {
              mapMsgTopic_jsp_vehicle_web.addAsWebInfResource(warResURL, "web.xml");
            }
            // The sun-web.xml descriptor
            warResURL = MapMsgTopicTests.class.getResource("//com/sun/ts/tests/common/vehicle/jsp/jsp_vehicle_web.war.sun-web.xml");
            if(warResURL != null) {
              mapMsgTopic_jsp_vehicle_web.addAsWebInfResource(warResURL, "sun-web.xml");
            }

            // Any libraries added to the war

            // Web content
            warResURL = MapMsgTopicTests.class.getResource("/com/sun/ts/tests/common/vehicle/jsp/jsp_vehicle_web.xml");
            if(warResURL != null) {
              mapMsgTopic_jsp_vehicle_web.addAsWebResource(warResURL, "/WEB-INF/jsp_vehicle_web.xml");
            }
            warResURL = MapMsgTopicTests.class.getResource("/com/sun/ts/tests/jms/core/mapMsgTopic/jsp_vehicle_web.xml");
            if(warResURL != null) {
              mapMsgTopic_jsp_vehicle_web.addAsWebResource(warResURL, "/WEB-INF/jsp_vehicle_web.xml");
            }
            warResURL = MapMsgTopicTests.class.getResource("/com/sun/ts/tests/common/vehicle/jsp/contentRoot/client.html");
            if(warResURL != null) {
              mapMsgTopic_jsp_vehicle_web.addAsWebResource(warResURL, "/client.html");
            }
            warResURL = MapMsgTopicTests.class.getResource("/com/sun/ts/tests/common/vehicle/jsp/contentRoot/jsp_vehicle.jsp");
            if(warResURL != null) {
              mapMsgTopic_jsp_vehicle_web.addAsWebResource(warResURL, "/jsp_vehicle.jsp");
            }

           // Call the archive processor
           archiveProcessor.processWebArchive(mapMsgTopic_jsp_vehicle_web, MapMsgTopicTests.class, warResURL);

        // Ear
            EnterpriseArchive mapMsgTopic_jsp_vehicle_ear = ShrinkWrap.create(EnterpriseArchive.class, "mapMsgTopic_jsp_vehicle.ear");

            // Any libraries added to the ear

            // The component jars built by the package target
            mapMsgTopic_jsp_vehicle_ear.addAsModule(mapMsgTopic_jsp_vehicle_web);



            // The application.xml descriptor
            URL earResURL = null;
            // The sun-application.xml descriptor
            earResURL = MapMsgTopicTests.class.getResource("/.ear.sun-application.xml");
            if(earResURL != null) {
              mapMsgTopic_jsp_vehicle_ear.addAsManifestResource(earResURL, "sun-application.xml");
            }
            // Call the archive processor
            archiveProcessor.processEarArchive(mapMsgTopic_jsp_vehicle_ear, MapMsgTopicTests.class, earResURL);
        return mapMsgTopic_jsp_vehicle_ear;
        }

        @Test
        @Override
        @TargetVehicle("jsp")
        public void mapMessageFullMsgTopicTest() throws java.lang.Exception {
            super.mapMessageFullMsgTopicTest();
        }

        @Test
        @Override
        @TargetVehicle("jsp")
        public void MapMessageConversionTopicTestsBoolean() throws java.lang.Exception {
            super.MapMessageConversionTopicTestsBoolean();
        }

        @Test
        @Override
        @TargetVehicle("jsp")
        public void MapMessageConversionTopicTestsByte() throws java.lang.Exception {
            super.MapMessageConversionTopicTestsByte();
        }

        @Test
        @Override
        @TargetVehicle("jsp")
        public void MapMessageConversionTopicTestsShort() throws java.lang.Exception {
            super.MapMessageConversionTopicTestsShort();
        }

        @Test
        @Override
        @TargetVehicle("jsp")
        public void MapMessageConversionTopicTestsChar() throws java.lang.Exception {
            super.MapMessageConversionTopicTestsChar();
        }

        @Test
        @Override
        @TargetVehicle("jsp")
        public void MapMessageConversionTopicTestsInt() throws java.lang.Exception {
            super.MapMessageConversionTopicTestsInt();
        }

        @Test
        @Override
        @TargetVehicle("jsp")
        public void MapMessageConversionTopicTestsLong() throws java.lang.Exception {
            super.MapMessageConversionTopicTestsLong();
        }

        @Test
        @Override
        @TargetVehicle("jsp")
        public void MapMessageConversionTopicTestsFloat() throws java.lang.Exception {
            super.MapMessageConversionTopicTestsFloat();
        }

        @Test
        @Override
        @TargetVehicle("jsp")
        public void MapMessageConversionTopicTestsDouble() throws java.lang.Exception {
            super.MapMessageConversionTopicTestsDouble();
        }

        @Test
        @Override
        @TargetVehicle("jsp")
        public void MapMessageConversionTopicTestsString() throws java.lang.Exception {
            super.MapMessageConversionTopicTestsString();
        }

        @Test
        @Override
        @TargetVehicle("jsp")
        public void MapMessageConversionTopicTestsBytes() throws java.lang.Exception {
            super.MapMessageConversionTopicTestsBytes();
        }

        @Test
        @Override
        @TargetVehicle("jsp")
        public void MapMessageConversionTopicTestsInvFormatString() throws java.lang.Exception {
            super.MapMessageConversionTopicTestsInvFormatString();
        }

        @Test
        @Override
        @TargetVehicle("jsp")
        public void mapMessageTNotWritable() throws java.lang.Exception {
            super.mapMessageTNotWritable();
        }

        @Test
        @Override
        @TargetVehicle("jsp")
        public void mapMessageTIllegalarg() throws java.lang.Exception {
            super.mapMessageTIllegalarg();
        }


}