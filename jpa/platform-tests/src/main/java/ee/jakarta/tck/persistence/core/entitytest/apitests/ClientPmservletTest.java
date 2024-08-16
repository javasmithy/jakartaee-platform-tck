package ee.jakarta.tck.persistence.core.entitytest.apitests;

import ee.jakarta.tck.persistence.core.entitytest.apitests.Client;
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
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import tck.arquillian.porting.lib.spi.TestArchiveProcessor;
import tck.arquillian.protocol.common.TargetVehicle;



@ExtendWith(ArquillianExtension.class)
@Tag("persistence")
@Tag("platform")
@Tag("web")
@Tag("tck-javatest")

public class ClientPmservletTest extends ee.jakarta.tck.persistence.core.entitytest.apitests.Client {
    static final String VEHICLE_ARCHIVE = "jpa_core_entitytest_apitests_pmservlet_vehicle";

        /**
        EE10 Deployment Descriptors:
        jpa_core_entitytest_apitests: myMappingFile.xml,META-INF/orm.xml,META-INF/persistence.xml
        jpa_core_entitytest_apitests_appmanaged_vehicle_client: META-INF/application-client.xml
        jpa_core_entitytest_apitests_appmanaged_vehicle_ejb: jar.sun-ejb-jar.xml
        jpa_core_entitytest_apitests_appmanagedNoTx_vehicle_client: META-INF/application-client.xml
        jpa_core_entitytest_apitests_appmanagedNoTx_vehicle_ejb: jar.sun-ejb-jar.xml
        jpa_core_entitytest_apitests_pmservlet_vehicle_web: WEB-INF/web.xml
        jpa_core_entitytest_apitests_puservlet_vehicle_web: WEB-INF/web.xml
        jpa_core_entitytest_apitests_stateful3_vehicle_client: META-INF/application-client.xml
        jpa_core_entitytest_apitests_stateful3_vehicle_ejb: jar.sun-ejb-jar.xml
        jpa_core_entitytest_apitests_stateless3_vehicle_client: META-INF/application-client.xml
        jpa_core_entitytest_apitests_stateless3_vehicle_ejb: jar.sun-ejb-jar.xml
        jpa_core_entitytest_apitests_vehicles: 

        Found Descriptors:
        War:

        /com/sun/ts/tests/common/vehicle/pmservlet/pmservlet_vehicle_web.xml
        Ear:

        */
        @TargetsContainer("tck-javatest")
        @OverProtocol("javatest")
        @Deployment(name = VEHICLE_ARCHIVE, order = 2)
        public static EnterpriseArchive createDeploymentVehicle(@ArquillianResource TestArchiveProcessor archiveProcessor) {
        // War
            // the war with the correct archive name
            WebArchive jpa_core_entitytest_apitests_pmservlet_vehicle_web = ShrinkWrap.create(WebArchive.class, "jpa_core_entitytest_apitests_pmservlet_vehicle_web.war");
            // The class files
            jpa_core_entitytest_apitests_pmservlet_vehicle_web.addClasses(
            com.sun.ts.tests.common.vehicle.ejb3share.EJB3ShareBaseBean.class,
            com.sun.ts.tests.common.vehicle.VehicleRunnerFactory.class,
            com.sun.ts.tests.common.vehicle.ejb3share.UseEntityManager.class,
            com.sun.ts.tests.common.vehicle.ejb3share.EJB3ShareIF.class,
            ee.jakarta.tck.persistence.core.entitytest.apitests.Client.class,
            com.sun.ts.lib.harness.EETest.Fault.class,
            com.sun.ts.tests.common.vehicle.ejb3share.UseEntityManagerFactory.class,
            ee.jakarta.tck.persistence.common.PMClientBase.class,
            com.sun.ts.tests.common.vehicle.servlet.ServletVehicle.class,
            com.sun.ts.tests.common.vehicle.VehicleRunnable.class,
            com.sun.ts.tests.common.vehicle.ejb3share.UserTransactionWrapper.class,
            com.sun.ts.lib.harness.EETest.class,
            com.sun.ts.lib.harness.ServiceEETest.class,
            com.sun.ts.tests.common.vehicle.ejb3share.EntityTransactionWrapper.class,
            com.sun.ts.tests.common.vehicle.pmservlet.PMServletVehicle.class,
            com.sun.ts.lib.harness.EETest.SetupException.class,
            com.sun.ts.tests.common.vehicle.VehicleClient.class,
            com.sun.ts.tests.common.vehicle.ejb3share.NoopTransactionWrapper.class
            );
            // The web.xml descriptor
            URL warResURL = Client.class.getResource("/com/sun/ts/tests/common/vehicle/pmservlet/pmservlet_vehicle_web.xml");
            if(warResURL != null) {
              jpa_core_entitytest_apitests_pmservlet_vehicle_web.addAsWebInfResource(warResURL, "web.xml");
            }
            // The sun-web.xml descriptor
            warResURL = Client.class.getResource("//com/sun/ts/tests/common/vehicle/pmservlet/pmservlet_vehicle_web.war.sun-web.xml");
            if(warResURL != null) {
              jpa_core_entitytest_apitests_pmservlet_vehicle_web.addAsWebInfResource(warResURL, "sun-web.xml");
            }
            // Web content
            warResURL = Client.class.getResource("/com/sun/ts/tests/jpa/core/entitytest/apitests/jpa_core_entitytest_apitests.jar");
            if(warResURL != null) {
              jpa_core_entitytest_apitests_pmservlet_vehicle_web.addAsWebResource(warResURL, "/WEB-INF/lib/jpa_core_entitytest_apitests.jar");
            }
            warResURL = Client.class.getResource("/com/sun/ts/tests/common/vehicle/pmservlet/pmservlet_vehicle_web.xml");
            if(warResURL != null) {
              jpa_core_entitytest_apitests_pmservlet_vehicle_web.addAsWebResource(warResURL, "/WEB-INF/pmservlet_vehicle_web.xml");
            }

           // Call the archive processor
           archiveProcessor.processWebArchive(jpa_core_entitytest_apitests_pmservlet_vehicle_web, Client.class, warResURL);

        // Par
            // the jar with the correct archive name
            JavaArchive jpa_core_entitytest_apitests = ShrinkWrap.create(JavaArchive.class, "jpa_core_entitytest_apitests.jar");
            // The class files
            jpa_core_entitytest_apitests.addClasses(
                ee.jakarta.tck.persistence.core.entitytest.apitests.Coffee.class,
                ee.jakarta.tck.persistence.core.entitytest.apitests.Foo.class,
                ee.jakarta.tck.persistence.core.entitytest.apitests.Bar.class,
                ee.jakarta.tck.persistence.core.entitytest.apitests.CoffeeMappedSC.class
            );
            // The persistence.xml descriptor
            URL parURL = Client.class.getResource("persistence.xml");
            if(parURL != null) {
              jpa_core_entitytest_apitests.addAsManifestResource(parURL, "persistence.xml");
            }
            // Call the archive processor
            archiveProcessor.processParArchive(jpa_core_entitytest_apitests, Client.class, parURL);
            // The orm.xml file
            parURL = Client.class.getResource("orm.xml");
            if(parURL != null) {
              jpa_core_entitytest_apitests.addAsManifestResource(parURL, "orm.xml");
            }

        // Ear
            EnterpriseArchive jpa_core_entitytest_apitests_vehicles_ear = ShrinkWrap.create(EnterpriseArchive.class, "jpa_core_entitytest_apitests_vehicles.ear");

            // Any libraries added to the ear

            // The component jars built by the package target
            jpa_core_entitytest_apitests_vehicles_ear.addAsModule(jpa_core_entitytest_apitests_pmservlet_vehicle_web);

            jpa_core_entitytest_apitests_vehicles_ear.addAsLibrary(jpa_core_entitytest_apitests);



            // The application.xml descriptor
            URL earResURL = Client.class.getResource("/com/sun/ts/tests/jpa/core/entitytest/apitests/");
            if(earResURL != null) {
              jpa_core_entitytest_apitests_vehicles_ear.addAsManifestResource(earResURL, "application.xml");
            }
            // The sun-application.xml descriptor
            earResURL = Client.class.getResource("/com/sun/ts/tests/jpa/core/entitytest/apitests/.ear.sun-application.xml");
            if(earResURL != null) {
              jpa_core_entitytest_apitests_vehicles_ear.addAsManifestResource(earResURL, "sun-application.xml");
            }
            // Call the archive processor
            archiveProcessor.processEarArchive(jpa_core_entitytest_apitests_vehicles_ear, Client.class, earResURL);
        return jpa_core_entitytest_apitests_vehicles_ear;
        }

        @Test
        @Override
        @TargetVehicle("pmservlet")
        public void entityAPITest1() throws java.lang.Exception {
            super.entityAPITest1();
        }

        @Test
        @Override
        @TargetVehicle("pmservlet")
        public void entityAPITest2() throws java.lang.Exception {
            super.entityAPITest2();
        }

        @Test
        @Override
        @TargetVehicle("pmservlet")
        public void entityAPITest3() throws java.lang.Exception {
            super.entityAPITest3();
        }

        @Test
        @Override
        @TargetVehicle("pmservlet")
        public void entityAPITest4() throws java.lang.Exception {
            super.entityAPITest4();
        }

        @Test
        @Override
        @TargetVehicle("pmservlet")
        public void getReferenceExceptionsTest() throws java.lang.Exception {
            super.getReferenceExceptionsTest();
        }

        @Test
        @Override
        @TargetVehicle("pmservlet")
        public void getReferenceTest() throws java.lang.Exception {
            super.getReferenceTest();
        }

        @Test
        @Override
        @TargetVehicle("pmservlet")
        public void entityAPITest8() throws java.lang.Exception {
            super.entityAPITest8();
        }

        @Test
        @Override
        @TargetVehicle("pmservlet")
        public void entityAPITest10() throws java.lang.Exception {
            super.entityAPITest10();
        }

        @Test
        @Override
        @TargetVehicle("pmservlet")
        public void entityAPITest12() throws java.lang.Exception {
            super.entityAPITest12();
        }

        @Test
        @Override
        @TargetVehicle("pmservlet")
        public void entityAPITest13() throws java.lang.Exception {
            super.entityAPITest13();
        }

        @Test
        @Override
        @TargetVehicle("pmservlet")
        public void entityAPITest14() throws java.lang.Exception {
            super.entityAPITest14();
        }

        @Test
        @Override
        @TargetVehicle("pmservlet")
        public void entityAPITest15() throws java.lang.Exception {
            super.entityAPITest15();
        }

        @Test
        @Override
        @TargetVehicle("pmservlet")
        public void entityAPITest16() throws java.lang.Exception {
            super.entityAPITest16();
        }

        @Test
        @Override
        @TargetVehicle("pmservlet")
        public void entityAPITest17() throws java.lang.Exception {
            super.entityAPITest17();
        }

        @Test
        @Override
        @TargetVehicle("pmservlet")
        public void entityAPITest18() throws java.lang.Exception {
            super.entityAPITest18();
        }

        @Test
        @Override
        @TargetVehicle("pmservlet")
        public void xmlOverridesNamedNativeQueryTest() throws java.lang.Exception {
            super.xmlOverridesNamedNativeQueryTest();
        }

        @Test
        @Override
        @TargetVehicle("pmservlet")
        public void xmlNamedNativeQueryTest() throws java.lang.Exception {
            super.xmlNamedNativeQueryTest();
        }

        @Test
        @Override
        @TargetVehicle("pmservlet")
        public void xmlOverridesNamedQueryTest() throws java.lang.Exception {
            super.xmlOverridesNamedQueryTest();
        }

        @Test
        @Override
        @TargetVehicle("pmservlet")
        public void xmlNamedQueryTest() throws java.lang.Exception {
            super.xmlNamedQueryTest();
        }

        @Test
        @Override
        @TargetVehicle("pmservlet")
        public void namedNativeQueryInMappedSuperClass() throws java.lang.Exception {
            super.namedNativeQueryInMappedSuperClass();
        }

        @Test
        @Override
        @TargetVehicle("pmservlet")
        public void namedQueryInMappedSuperClass() throws java.lang.Exception {
            super.namedQueryInMappedSuperClass();
        }


}