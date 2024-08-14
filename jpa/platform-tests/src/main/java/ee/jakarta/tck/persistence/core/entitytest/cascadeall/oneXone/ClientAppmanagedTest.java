package ee.jakarta.tck.persistence.core.entitytest.cascadeall.oneXone;

import ee.jakarta.tck.persistence.core.entitytest.cascadeall.oneXone.Client;
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
@Tag("jpa")
@Tag("javaee")
@Tag("javaee_web_profile")

public class ClientAppmanagedTest extends ee.jakarta.tck.persistence.core.entitytest.cascadeall.oneXone.Client {
    static final String VEHICLE_ARCHIVE = "jpa_core_et_cascadeall_oneXone_appmanaged_vehicle";

        /**
        EE10 Deployment Descriptors:
        jpa_core_et_cascadeall_oneXone: META-INF/persistence.xml
        jpa_core_et_cascadeall_oneXone_appmanaged_vehicle_client: META-INF/application-client.xml
        jpa_core_et_cascadeall_oneXone_appmanaged_vehicle_ejb: jar.sun-ejb-jar.xml
        jpa_core_et_cascadeall_oneXone_appmanagedNoTx_vehicle_client: META-INF/application-client.xml
        jpa_core_et_cascadeall_oneXone_appmanagedNoTx_vehicle_ejb: jar.sun-ejb-jar.xml
        jpa_core_et_cascadeall_oneXone_pmservlet_vehicle_web: WEB-INF/web.xml
        jpa_core_et_cascadeall_oneXone_puservlet_vehicle_web: WEB-INF/web.xml
        jpa_core_et_cascadeall_oneXone_stateful3_vehicle_client: META-INF/application-client.xml
        jpa_core_et_cascadeall_oneXone_stateful3_vehicle_ejb: jar.sun-ejb-jar.xml
        jpa_core_et_cascadeall_oneXone_stateless3_vehicle_client: META-INF/application-client.xml
        jpa_core_et_cascadeall_oneXone_stateless3_vehicle_ejb: jar.sun-ejb-jar.xml
        jpa_core_et_cascadeall_oneXone_vehicles: 

        Found Descriptors:
        Client:

        /com/sun/ts/tests/common/vehicle/appmanaged/appmanaged_vehicle_client.xml
        Ejb:

        Ear:

        */
        @TargetsContainer("tck-appclient")
        @OverProtocol("appclient")
        @Deployment(name = VEHICLE_ARCHIVE, order = 2)
        public static EnterpriseArchive createDeploymentVehicle(@ArquillianResource TestArchiveProcessor archiveProcessor) {
        // Client
            // the jar with the correct archive name
            JavaArchive jpa_core_et_cascadeall_oneXone_appmanaged_vehicle_client = ShrinkWrap.create(JavaArchive.class, "jpa_core_et_cascadeall_oneXone_appmanaged_vehicle_client.jar");
            // The class files
            jpa_core_et_cascadeall_oneXone_appmanaged_vehicle_client.addClasses(
            com.sun.ts.tests.common.vehicle.VehicleRunnerFactory.class,
            com.sun.ts.tests.common.vehicle.ejb3share.UseEntityManager.class,
            com.sun.ts.tests.common.vehicle.ejb3share.EJB3ShareIF.class,
            com.sun.ts.lib.harness.EETest.Fault.class,
            com.sun.ts.tests.common.vehicle.appmanaged.AppManagedVehicleIF.class,
            com.sun.ts.tests.common.vehicle.ejb3share.UseEntityManagerFactory.class,
            com.sun.ts.tests.common.vehicle.EmptyVehicleRunner.class,
            ee.jakarta.tck.persistence.common.PMClientBase.class,
            com.sun.ts.tests.common.vehicle.VehicleRunnable.class,
            com.sun.ts.tests.common.vehicle.appmanaged.AppManagedVehicleRunner.class,
            com.sun.ts.tests.common.vehicle.ejb3share.UserTransactionWrapper.class,
            com.sun.ts.lib.harness.EETest.class,
            com.sun.ts.lib.harness.ServiceEETest.class,
            com.sun.ts.tests.common.vehicle.ejb3share.EntityTransactionWrapper.class,
            com.sun.ts.lib.harness.EETest.SetupException.class,
            com.sun.ts.tests.common.vehicle.VehicleClient.class,
            com.sun.ts.tests.common.vehicle.ejb3share.NoopTransactionWrapper.class
            );
            // The application-client.xml descriptor
            URL resURL = Client.class.getResource("/com/sun/ts/tests/common/vehicle/appmanaged/appmanaged_vehicle_client.xml");
            if(resURL != null) {
              jpa_core_et_cascadeall_oneXone_appmanaged_vehicle_client.addAsManifestResource(resURL, "application-client.xml");
            }
            // The sun-application-client.xml file need to be added or should this be in in the vendor Arquillian extension?
            resURL = Client.class.getResource("//com/sun/ts/tests/common/vehicle/appmanaged/appmanaged_vehicle_client.jar.sun-application-client.xml");
            if(resURL != null) {
              jpa_core_et_cascadeall_oneXone_appmanaged_vehicle_client.addAsManifestResource(resURL, "application-client.xml");
            }
            jpa_core_et_cascadeall_oneXone_appmanaged_vehicle_client.addAsManifestResource(new StringAsset("Main-Class: " + Client.class.getName() + "\n"), "MANIFEST.MF");
            archiveProcessor.processClientArchive(jpa_core_et_cascadeall_oneXone_appmanaged_vehicle_client, Client.class, resURL);


        // Ejb
            // the jar with the correct archive name
            JavaArchive jpa_core_et_cascadeall_oneXone_appmanaged_vehicle_ejb = ShrinkWrap.create(JavaArchive.class, "jpa_core_et_cascadeall_oneXone_appmanaged_vehicle_ejb.jar");
            // The class files
            jpa_core_et_cascadeall_oneXone_appmanaged_vehicle_ejb.addClasses(
                com.sun.ts.tests.common.vehicle.ejb3share.EJB3ShareBaseBean.class,
                com.sun.ts.tests.common.vehicle.VehicleRunnerFactory.class,
                com.sun.ts.tests.common.vehicle.ejb3share.UseEntityManager.class,
                com.sun.ts.tests.common.vehicle.ejb3share.EJB3ShareIF.class,
                com.sun.ts.lib.harness.EETest.Fault.class,
                com.sun.ts.tests.common.vehicle.appmanaged.AppManagedVehicleIF.class,
                ee.jakarta.tck.persistence.core.entitytest.cascadeall.oneXone.Client.class,
                com.sun.ts.tests.common.vehicle.ejb3share.UseEntityManagerFactory.class,
                ee.jakarta.tck.persistence.common.PMClientBase.class,
                com.sun.ts.tests.common.vehicle.VehicleRunnable.class,
                com.sun.ts.tests.common.vehicle.appmanaged.AppManagedVehicleBean.class,
                com.sun.ts.tests.common.vehicle.ejb3share.UserTransactionWrapper.class,
                com.sun.ts.lib.harness.EETest.class,
                com.sun.ts.lib.harness.ServiceEETest.class,
                com.sun.ts.tests.common.vehicle.ejb3share.EntityTransactionWrapper.class,
                com.sun.ts.lib.harness.EETest.SetupException.class,
                com.sun.ts.tests.common.vehicle.VehicleClient.class,
                com.sun.ts.tests.common.vehicle.ejb3share.NoopTransactionWrapper.class
            );
            // The ejb-jar.xml descriptor
            URL ejbResURL = Client.class.getResource("//vehicle/appmanaged/appmanaged_vehicle_ejb.xml");
            if(ejbResURL != null) {
              jpa_core_et_cascadeall_oneXone_appmanaged_vehicle_ejb.addAsManifestResource(ejbResURL, "ejb-jar.xml");
            }
            // The sun-ejb-jar.xml file
            ejbResURL = Client.class.getResource("//vehicle/appmanaged/appmanaged_vehicle_ejb.jar.sun-ejb-jar.xml");
            if(ejbResURL != null) {
              jpa_core_et_cascadeall_oneXone_appmanaged_vehicle_ejb.addAsManifestResource(ejbResURL, "sun-ejb-jar.xml");
            }
            archiveProcessor.processEjbArchive(jpa_core_et_cascadeall_oneXone_appmanaged_vehicle_ejb, Client.class, ejbResURL);

        // Par
            // the jar with the correct archive name
            JavaArchive jpa_core_et_cascadeall_oneXone = ShrinkWrap.create(JavaArchive.class, "jpa_core_et_cascadeall_oneXone.jar");
            // The class files
            jpa_core_et_cascadeall_oneXone.addClasses(
                ee.jakarta.tck.persistence.core.entitytest.cascadeall.oneXone.A.class,
                ee.jakarta.tck.persistence.core.entitytest.cascadeall.oneXone.B.class
            );
            // The persistence.xml descriptor
            URL parURL = Client.class.getResource("persistence.xml");
            if(parURL != null) {
              jpa_core_et_cascadeall_oneXone.addAsManifestResource(parURL, "persistence.xml");
            }
            archiveProcessor.processParArchive(jpa_core_et_cascadeall_oneXone, Client.class, parURL);
            // The orm.xml file
            parURL = Client.class.getResource("orm.xml");
            if(parURL != null) {
              jpa_core_et_cascadeall_oneXone.addAsManifestResource(parURL, "orm.xml");
            }

        // Ear
            EnterpriseArchive jpa_core_et_cascadeall_oneXone_vehicles_ear = ShrinkWrap.create(EnterpriseArchive.class, "jpa_core_et_cascadeall_oneXone_vehicles.ear");

            // Any libraries added to the ear

            // The component jars built by the package target
            jpa_core_et_cascadeall_oneXone_vehicles_ear.addAsModule(jpa_core_et_cascadeall_oneXone_appmanaged_vehicle_ejb);
            jpa_core_et_cascadeall_oneXone_vehicles_ear.addAsModule(jpa_core_et_cascadeall_oneXone_appmanaged_vehicle_client);

            jpa_core_et_cascadeall_oneXone_vehicles_ear.addAsLibrary(jpa_core_et_cascadeall_oneXone);



            // The application.xml descriptor
            URL earResURL = Client.class.getResource("/com/sun/ts/tests/jpa/core/entitytest/cascadeall/oneXone/");
            if(earResURL != null) {
              jpa_core_et_cascadeall_oneXone_vehicles_ear.addAsManifestResource(earResURL, "application.xml");
            }
            // The sun-application.xml descriptor
            earResURL = Client.class.getResource("/com/sun/ts/tests/jpa/core/entitytest/cascadeall/oneXone/.ear.sun-application.xml");
            if(earResURL != null) {
              jpa_core_et_cascadeall_oneXone_vehicles_ear.addAsManifestResource(earResURL, "sun-application.xml");
            }
            archiveProcessor.processEarArchive(jpa_core_et_cascadeall_oneXone_vehicles_ear, Client.class, earResURL);
        return jpa_core_et_cascadeall_oneXone_vehicles_ear;
        }

        @Test
        @Override
        @TargetVehicle("appmanaged")
        public void cascadeAll1X1Test1() throws java.lang.Exception {
            super.cascadeAll1X1Test1();
        }

        @Test
        @Override
        @TargetVehicle("appmanaged")
        public void cascadeAll1X1Test2() throws java.lang.Exception {
            super.cascadeAll1X1Test2();
        }

        @Test
        @Override
        @TargetVehicle("appmanaged")
        public void cascadeAll1X1Test3() throws java.lang.Exception {
            super.cascadeAll1X1Test3();
        }

        @Test
        @Override
        @TargetVehicle("appmanaged")
        public void cascadeAll1X1Test4() throws java.lang.Exception {
            super.cascadeAll1X1Test4();
        }

        @Test
        @Override
        @TargetVehicle("appmanaged")
        public void cascadeAll1X1Test5() throws java.lang.Exception {
            super.cascadeAll1X1Test5();
        }

        @Test
        @Override
        @TargetVehicle("appmanaged")
        public void cascadeAll1X1Test6() throws java.lang.Exception {
            super.cascadeAll1X1Test6();
        }

        @Test
        @Override
        @TargetVehicle("appmanaged")
        public void cascadeAll1X1Test7() throws java.lang.Exception {
            super.cascadeAll1X1Test7();
        }

        @Test
        @Override
        @TargetVehicle("appmanaged")
        public void cascadeAll1X1Test8() throws java.lang.Exception {
            super.cascadeAll1X1Test8();
        }

        @Test
        @Override
        @TargetVehicle("appmanaged")
        public void cascadeAll1X1Test9() throws java.lang.Exception {
            super.cascadeAll1X1Test9();
        }

        @Test
        @Override
        @TargetVehicle("appmanaged")
        public void cascadeAll1X1Test10() throws java.lang.Exception {
            super.cascadeAll1X1Test10();
        }


}