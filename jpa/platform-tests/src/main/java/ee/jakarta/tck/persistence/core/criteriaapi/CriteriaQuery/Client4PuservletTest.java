package ee.jakarta.tck.persistence.core.criteriaapi.CriteriaQuery;

import ee.jakarta.tck.persistence.core.criteriaapi.CriteriaQuery.Client4;
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

public class Client4PuservletTest extends ee.jakarta.tck.persistence.core.criteriaapi.CriteriaQuery.Client4 {
    static final String VEHICLE_ARCHIVE = "jpa_core_criteriaapi_CriteriaQuery_puservlet_vehicle";

        /**
        EE10 Deployment Descriptors:
        jpa_core_criteriaapi_CriteriaQuery: META-INF/persistence.xml
        jpa_core_criteriaapi_CriteriaQuery_appmanaged_vehicle_client: META-INF/application-client.xml
        jpa_core_criteriaapi_CriteriaQuery_appmanaged_vehicle_ejb: jar.sun-ejb-jar.xml
        jpa_core_criteriaapi_CriteriaQuery_appmanagedNoTx_vehicle_client: META-INF/application-client.xml
        jpa_core_criteriaapi_CriteriaQuery_appmanagedNoTx_vehicle_ejb: jar.sun-ejb-jar.xml
        jpa_core_criteriaapi_CriteriaQuery_pmservlet_vehicle_web: WEB-INF/web.xml
        jpa_core_criteriaapi_CriteriaQuery_puservlet_vehicle_web: WEB-INF/web.xml
        jpa_core_criteriaapi_CriteriaQuery_stateful3_vehicle_client: META-INF/application-client.xml
        jpa_core_criteriaapi_CriteriaQuery_stateful3_vehicle_ejb: jar.sun-ejb-jar.xml
        jpa_core_criteriaapi_CriteriaQuery_stateless3_vehicle_client: META-INF/application-client.xml
        jpa_core_criteriaapi_CriteriaQuery_stateless3_vehicle_ejb: jar.sun-ejb-jar.xml
        jpa_core_criteriaapi_CriteriaQuery_vehicles: 

        Found Descriptors:
        War:

        /com/sun/ts/tests/common/vehicle/puservlet/puservlet_vehicle_web.xml
        Ear:

        */
        @TargetsContainer("tck-javatest")
        @OverProtocol("javatest")
        @Deployment(name = VEHICLE_ARCHIVE, order = 2)
        public static EnterpriseArchive createDeploymentVehicle(@ArquillianResource TestArchiveProcessor archiveProcessor) {
        // War
            // the war with the correct archive name
            WebArchive jpa_core_criteriaapi_CriteriaQuery_puservlet_vehicle_web = ShrinkWrap.create(WebArchive.class, "jpa_core_criteriaapi_CriteriaQuery_puservlet_vehicle_web.war");
            // The class files
            jpa_core_criteriaapi_CriteriaQuery_puservlet_vehicle_web.addClasses(
            com.sun.ts.tests.common.vehicle.ejb3share.EJB3ShareBaseBean.class,
            com.sun.ts.tests.common.vehicle.VehicleRunnerFactory.class,
            com.sun.ts.tests.common.vehicle.ejb3share.UseEntityManager.class,
            com.sun.ts.tests.common.vehicle.ejb3share.EJB3ShareIF.class,
            com.sun.ts.tests.common.vehicle.puservlet.PUServletVehicle.class,
            com.sun.ts.lib.harness.EETest.Fault.class,
            com.sun.ts.tests.common.vehicle.ejb3share.UseEntityManagerFactory.class,
            ee.jakarta.tck.persistence.common.PMClientBase.class,
            com.sun.ts.tests.common.vehicle.servlet.ServletVehicle.class,
            ee.jakarta.tck.persistence.common.schema30.Util.class,
            com.sun.ts.tests.common.vehicle.VehicleRunnable.class,
            com.sun.ts.tests.common.vehicle.ejb3share.UserTransactionWrapper.class,
            ee.jakarta.tck.persistence.core.criteriaapi.CriteriaQuery.Client4.class,
            com.sun.ts.lib.harness.EETest.class,
            com.sun.ts.lib.harness.ServiceEETest.class,
            com.sun.ts.tests.common.vehicle.ejb3share.EntityTransactionWrapper.class,
            com.sun.ts.lib.harness.EETest.SetupException.class,
            com.sun.ts.tests.common.vehicle.VehicleClient.class,
            com.sun.ts.tests.common.vehicle.ejb3share.NoopTransactionWrapper.class
            );
            // The web.xml descriptor
            URL warResURL = Client4.class.getResource("/com/sun/ts/tests/common/vehicle/puservlet/puservlet_vehicle_web.xml");
            if(warResURL != null) {
              jpa_core_criteriaapi_CriteriaQuery_puservlet_vehicle_web.addAsWebInfResource(warResURL, "web.xml");
            }
            // The sun-web.xml descriptor
            warResURL = Client4.class.getResource("//com/sun/ts/tests/common/vehicle/puservlet/puservlet_vehicle_web.war.sun-web.xml");
            if(warResURL != null) {
              jpa_core_criteriaapi_CriteriaQuery_puservlet_vehicle_web.addAsWebInfResource(warResURL, "sun-web.xml");
            }
            // Web content
           archiveProcessor.processWebArchive(jpa_core_criteriaapi_CriteriaQuery_puservlet_vehicle_web, Client4.class, warResURL);

        // Par
            // the jar with the correct archive name
            JavaArchive jpa_core_criteriaapi_CriteriaQuery = ShrinkWrap.create(JavaArchive.class, "jpa_core_criteriaapi_CriteriaQuery.jar");
            // The class files
            jpa_core_criteriaapi_CriteriaQuery.addClasses(
                ee.jakarta.tck.persistence.common.schema30.Department.class,
                ee.jakarta.tck.persistence.common.schema30.Address_.class,
                ee.jakarta.tck.persistence.common.schema30.Department_.class,
                ee.jakarta.tck.persistence.common.schema30.CreditCard.class,
                ee.jakarta.tck.persistence.common.schema30.Info.class,
                ee.jakarta.tck.persistence.common.schema30.LineItem_.class,
                ee.jakarta.tck.persistence.common.schema30.Phone.class,
                ee.jakarta.tck.persistence.common.schema30.Customer_.class,
                ee.jakarta.tck.persistence.common.schema30.Employee_.class,
                ee.jakarta.tck.persistence.common.schema30.Trim_.class,
                ee.jakarta.tck.persistence.common.schema30.Order_.class,
                ee.jakarta.tck.persistence.common.schema30.ShelfLife_.class,
                ee.jakarta.tck.persistence.common.schema30.ShelfLife.class,
                ee.jakarta.tck.persistence.common.schema30.Phone_.class,
                ee.jakarta.tck.persistence.common.schema30.Address.class,
                ee.jakarta.tck.persistence.common.schema30.Info_.class,
                ee.jakarta.tck.persistence.common.schema30.HardwareProduct.class,
                ee.jakarta.tck.persistence.common.schema30.Country_.class,
                ee.jakarta.tck.persistence.common.schema30.Alias_.class,
                ee.jakarta.tck.persistence.common.schema30.Trim.class,
                ee.jakarta.tck.persistence.common.schema30.HardwareProduct_.class,
                ee.jakarta.tck.persistence.core.criteriaapi.CriteriaQuery.A.class,
                ee.jakarta.tck.persistence.common.schema30.CreditCard_.class,
                ee.jakarta.tck.persistence.common.schema30.SoftwareProduct.class,
                ee.jakarta.tck.persistence.common.schema30.Product.class,
                ee.jakarta.tck.persistence.common.schema30.Spouse.class,
                ee.jakarta.tck.persistence.common.schema30.SoftwareProduct_.class,
                ee.jakarta.tck.persistence.common.schema30.Spouse_.class,
                ee.jakarta.tck.persistence.common.schema30.LineItem.class,
                ee.jakarta.tck.persistence.common.schema30.Employee.class,
                ee.jakarta.tck.persistence.common.schema30.Product_.class,
                ee.jakarta.tck.persistence.common.schema30.Customer.class,
                ee.jakarta.tck.persistence.common.schema30.Alias.class,
                ee.jakarta.tck.persistence.common.schema30.Order.class,
                ee.jakarta.tck.persistence.common.schema30.LineItemException.class,
                ee.jakarta.tck.persistence.common.schema30.Country.class
            );
            // The persistence.xml descriptor
            URL parURL = Client4.class.getResource("persistence.xml");
            if(parURL != null) {
              jpa_core_criteriaapi_CriteriaQuery.addAsManifestResource(parURL, "persistence.xml");
            }
            archiveProcessor.processParArchive(jpa_core_criteriaapi_CriteriaQuery, Client4.class, parURL);
            // The orm.xml file
            parURL = Client4.class.getResource("orm.xml");
            if(parURL != null) {
              jpa_core_criteriaapi_CriteriaQuery.addAsManifestResource(parURL, "orm.xml");
            }

        // Ear
            EnterpriseArchive jpa_core_criteriaapi_CriteriaQuery_vehicles_ear = ShrinkWrap.create(EnterpriseArchive.class, "jpa_core_criteriaapi_CriteriaQuery_vehicles.ear");

            // Any libraries added to the ear

            // The component jars built by the package target
            jpa_core_criteriaapi_CriteriaQuery_vehicles_ear.addAsModule(jpa_core_criteriaapi_CriteriaQuery_puservlet_vehicle_web);

            jpa_core_criteriaapi_CriteriaQuery_vehicles_ear.addAsLibrary(jpa_core_criteriaapi_CriteriaQuery);



            // The application.xml descriptor
            URL earResURL = Client4.class.getResource("/com/sun/ts/tests/jpa/core/criteriaapi/CriteriaQuery/");
            if(earResURL != null) {
              jpa_core_criteriaapi_CriteriaQuery_vehicles_ear.addAsManifestResource(earResURL, "application.xml");
            }
            // The sun-application.xml descriptor
            earResURL = Client4.class.getResource("/com/sun/ts/tests/jpa/core/criteriaapi/CriteriaQuery/.ear.sun-application.xml");
            if(earResURL != null) {
              jpa_core_criteriaapi_CriteriaQuery_vehicles_ear.addAsManifestResource(earResURL, "sun-application.xml");
            }
            archiveProcessor.processEarArchive(jpa_core_criteriaapi_CriteriaQuery_vehicles_ear, Client4.class, earResURL);
        return jpa_core_criteriaapi_CriteriaQuery_vehicles_ear;
        }

        @Test
        @Override
        @TargetVehicle("puservlet")
        public void fromGetStringIllegalStateExceptionTest() throws java.lang.Exception {
            super.fromGetStringIllegalStateExceptionTest();
        }

        @Test
        @Override
        @TargetVehicle("puservlet")
        public void pathGetStringIllegalStateExceptionTest() throws java.lang.Exception {
            super.pathGetStringIllegalStateExceptionTest();
        }

        @Test
        @Override
        @TargetVehicle("puservlet")
        public void fromGetStringIllegalArgumentExceptionTest() throws java.lang.Exception {
            super.fromGetStringIllegalArgumentExceptionTest();
        }

        @Test
        @Override
        @TargetVehicle("puservlet")
        public void fromGetModelTest() throws java.lang.Exception {
            super.fromGetModelTest();
        }

        @Test
        @Override
        @TargetVehicle("puservlet")
        public void pathGetIllegalArgumentException() throws java.lang.Exception {
            super.pathGetIllegalArgumentException();
        }

        @Test
        @Override
        @TargetVehicle("puservlet")
        public void executeUpdateIllegalStateException1Test() throws java.lang.Exception {
            super.executeUpdateIllegalStateException1Test();
        }


}