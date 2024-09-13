package com.sun.ts.tests.ejb30.lite.singleton.dependson.graph;

import com.sun.ts.tests.ejb30.lite.singleton.dependson.graph.Client;
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
@Tag("platform")
@Tag("ejb_web")
@Tag("web")
@Tag("tck-javatest")

@TestMethodOrder(MethodOrderer.MethodName.class)
public class ClientEjbliteservletTest extends com.sun.ts.tests.ejb30.lite.singleton.dependson.graph.Client {
    static final String VEHICLE_ARCHIVE = "ejblite_singleton_dependson_graph_ejbliteservlet_vehicle";

        /**
        EE10 Deployment Descriptors:
        ejblite_singleton_dependson_graph_ejblitejsf_vehicle_web: WEB-INF/beans.xml,WEB-INF/faces-config.xml,WEB-INF/web.xml
        ejblite_singleton_dependson_graph_ejblitejsp_vehicle_web: 
        ejblite_singleton_dependson_graph_ejbliteservlet_vehicle_web: WEB-INF/web.xml
        ejblite_singleton_dependson_graph_ejbliteservlet2_vehicle_web: WEB-INF/web.xml

        Found Descriptors:
        War:

        /com/sun/ts/tests/common/vehicle/ejbliteservlet/ejbliteservlet_vehicle_web.xml
        */
        @TargetsContainer("tck-javatest")
        @OverProtocol("javatest")
        @Deployment(name = VEHICLE_ARCHIVE, order = 2)
        public static WebArchive createDeploymentVehicle(@ArquillianResource TestArchiveProcessor archiveProcessor) {

        // War
            // the war with the correct archive name
            WebArchive ejblite_singleton_dependson_graph_ejbliteservlet_vehicle_web = ShrinkWrap.create(WebArchive.class, "ejblite_singleton_dependson_graph_ejbliteservlet_vehicle_web.war");
            // The class files
            ejblite_singleton_dependson_graph_ejbliteservlet_vehicle_web.addClasses(
            com.sun.ts.lib.harness.EETest.Fault.class,
            com.sun.ts.tests.ejb30.lite.singleton.dependson.graph.SevenBean.class,
            com.sun.ts.tests.ejb30.lite.singleton.dependson.graph.EightBean.class,
            com.sun.ts.tests.ejb30.lite.singleton.dependson.graph.NineBean.class,
            com.sun.ts.tests.common.vehicle.VehicleRunnable.class,
            com.sun.ts.tests.ejb30.lite.singleton.dependson.graph.ElevenBean.class,
            com.sun.ts.tests.ejb30.common.helper.Helper.class,
            com.sun.ts.tests.ejb30.common.lite.EJBLiteClientBase.class,
            com.sun.ts.tests.ejb30.lite.singleton.dependson.graph.ThreeBean.class,
            com.sun.ts.tests.ejb30.lite.singleton.dependson.graph.Client.class,
            com.sun.ts.lib.harness.EETest.class,
            com.sun.ts.lib.harness.ServiceEETest.class,
            com.sun.ts.tests.ejb30.lite.singleton.dependson.graph.JsfClient.class,
            com.sun.ts.tests.common.vehicle.VehicleClient.class,
            com.sun.ts.tests.ejb30.common.lite.NumberIF.class,
            com.sun.ts.tests.common.vehicle.ejbliteshare.EJBLiteClientIF.class,
            com.sun.ts.tests.common.vehicle.VehicleRunnerFactory.class,
            com.sun.ts.tests.ejb30.lite.singleton.dependson.common.HistoryBean.class,
            com.sun.ts.tests.ejb30.lite.singleton.dependson.graph.TwoBean.class,
            com.sun.ts.tests.common.vehicle.ejbliteshare.ReasonableStatus.class,
            com.sun.ts.tests.ejb30.lite.singleton.dependson.graph.HttpServletDelegate.class,
            com.sun.ts.tests.ejb30.lite.singleton.dependson.graph.FiveBean.class,
            com.sun.ts.tests.ejb30.common.lite.NumberEnum.class,
            com.sun.ts.tests.ejb30.lite.singleton.dependson.graph.TenBean.class,
            com.sun.ts.tests.ejb30.lite.singleton.dependson.graph.EJBLiteServletVehicle.class,
            com.sun.ts.tests.ejb30.common.lite.EJBLiteJsfClientBase.class,
            com.sun.ts.lib.harness.EETest.SetupException.class,
            com.sun.ts.tests.ejb30.lite.singleton.dependson.common.BeanBase.class
            );
            // The web.xml descriptor
            URL warResURL = Client.class.getResource("ejbliteservlet_vehicle_web.xml");
            if(warResURL != null) {
              ejblite_singleton_dependson_graph_ejbliteservlet_vehicle_web.addAsWebInfResource(warResURL, "web.xml");
            }
            // The sun-web.xml descriptor
            warResURL = Client.class.getResource("/ejbliteservlet_vehicle_web.war.sun-web.xml");
            if(warResURL != null) {
              ejblite_singleton_dependson_graph_ejbliteservlet_vehicle_web.addAsWebInfResource(warResURL, "sun-web.xml");
            }

            // Any libraries added to the war

            // Web content
            warResURL = Client.class.getResource("/com/sun/ts/tests/common/vehicle/ejbliteservlet/ejbliteservlet_vehicle_web.xml");
            if(warResURL != null) {
              ejblite_singleton_dependson_graph_ejbliteservlet_vehicle_web.addAsWebResource(warResURL, "/WEB-INF/ejbliteservlet_vehicle_web.xml");
            }

           // Call the archive processor
           archiveProcessor.processWebArchive(ejblite_singleton_dependson_graph_ejbliteservlet_vehicle_web, Client.class, warResURL);

        return ejblite_singleton_dependson_graph_ejbliteservlet_vehicle_web;
        }

        @Test
        @Override
        @TargetVehicle("ejbliteservlet")
        public void graph() {
            super.graph();
        }

        @Test
        @Override
        @TargetVehicle("ejbliteservlet")
        public void numOfInstances() {
            super.numOfInstances();
        }


}