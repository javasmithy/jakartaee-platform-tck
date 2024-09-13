package com.sun.ts.tests.ejb30.sec.stateful.secrunaspropagation;

import com.sun.ts.tests.ejb30.sec.stateful.secrunaspropagation.Client;
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
@Tag("ejb_3x_remote_optional")
@Tag("web_optional")
@Tag("tck-appclient")

@TestMethodOrder(MethodOrderer.MethodName.class)
public class ClientTest extends com.sun.ts.tests.ejb30.sec.stateful.secrunaspropagation.Client {
    /**
        EE10 Deployment Descriptors:
        ejb3_sec_stateful_secrunaspropagation: ear.sun-application.xml
        ejb3_sec_stateful_secrunaspropagation_client: META-INF/application-client.xml,jar.sun-application-client.xml
        ejb3_sec_stateful_secrunaspropagation_ejb: META-INF/ejb-jar.xml,jar.sun-ejb-jar.xml

        Found Descriptors:
        Client:

        /com/sun/ts/tests/ejb30/sec/stateful/secrunaspropagation/ejb3_sec_stateful_secrunaspropagation_client.xml
        /com/sun/ts/tests/ejb30/sec/stateful/secrunaspropagation/ejb3_sec_stateful_secrunaspropagation_client.jar.sun-application-client.xml
        Ejb:

        /com/sun/ts/tests/ejb30/sec/stateful/secrunaspropagation/ejb3_sec_stateful_secrunaspropagation_ejb.xml
        /com/sun/ts/tests/ejb30/sec/stateful/secrunaspropagation/ejb3_sec_stateful_secrunaspropagation_ejb.jar.sun-ejb-jar.xml
        Ear:

        /com/sun/ts/tests/ejb30/sec/stateful/secrunaspropagation/ejb3_sec_stateful_secrunaspropagation.ear.sun-application.xml
        /com/sun/ts/tests/ejb30/sec/stateful/secrunaspropagation/ejb3_sec_stateful_secrunaspropagation.ear.sun-application.xml
        */
        @TargetsContainer("tck-appclient")
        @OverProtocol("appclient")
        @Deployment(name = "ejb3_sec_stateful_secrunaspropagation", order = 2)
        public static EnterpriseArchive createDeployment(@ArquillianResource TestArchiveProcessor archiveProcessor) {
        // Client
            // the jar with the correct archive name
            JavaArchive ejb3_sec_stateful_secrunaspropagation_client = ShrinkWrap.create(JavaArchive.class, "ejb3_sec_stateful_secrunaspropagation_client.jar");
            // The class files
            ejb3_sec_stateful_secrunaspropagation_client.addClasses(
            com.sun.ts.lib.harness.EETest.Fault.class,
            com.sun.ts.tests.ejb30.sec.stateful.secrunaspropagation.Client.class,
            com.sun.ts.tests.ejb30.sec.stateful.common.Test.class,
            com.sun.ts.tests.ejb30.sec.stateful.common.SecTest.class,
            com.sun.ts.lib.harness.EETest.class,
            com.sun.ts.lib.harness.EETest.SetupException.class,
            com.sun.ts.tests.ejb30.sec.stateful.common.SecTestRoleRef.class
            );
            // The application-client.xml descriptor
            URL resURL = Client.class.getResource("com/sun/ts/tests/ejb30/sec/stateful/secrunaspropagation/ejb3_sec_stateful_secrunaspropagation_client.xml");
            if(resURL != null) {
              ejb3_sec_stateful_secrunaspropagation_client.addAsManifestResource(resURL, "application-client.xml");
            }
            // The sun-application-client.xml file need to be added or should this be in in the vendor Arquillian extension?
            resURL = Client.class.getResource("/com/sun/ts/tests/ejb30/sec/stateful/secrunaspropagation/ejb3_sec_stateful_secrunaspropagation_client.jar.sun-application-client.xml");
            if(resURL != null) {
              ejb3_sec_stateful_secrunaspropagation_client.addAsManifestResource(resURL, "application-client.xml");
            }
            ejb3_sec_stateful_secrunaspropagation_client.addAsManifestResource(new StringAsset("Main-Class: " + Client.class.getName() + "\n"), "MANIFEST.MF");
            // Call the archive processor
            archiveProcessor.processClientArchive(ejb3_sec_stateful_secrunaspropagation_client, Client.class, resURL);

        // Ejb
            // the jar with the correct archive name
            JavaArchive ejb3_sec_stateful_secrunaspropagation_ejb = ShrinkWrap.create(JavaArchive.class, "ejb3_sec_stateful_secrunaspropagation_ejb.jar");
            // The class files
            ejb3_sec_stateful_secrunaspropagation_ejb.addClasses(
                com.sun.ts.tests.ejb30.sec.stateful.secrunaspropagation.TestEJB.class,
                com.sun.ts.tests.ejb30.sec.stateful.secrunaspropagation.SecTestEJB.class,
                com.sun.ts.tests.ejb30.sec.stateful.common.SecTestRoleRefLocal.class,
                com.sun.ts.tests.ejb30.sec.stateful.common.Test.class,
                com.sun.ts.tests.ejb30.sec.stateful.common.SecTest.class,
                com.sun.ts.tests.ejb30.sec.stateful.common.SecTestLocal.class,
                com.sun.ts.tests.ejb30.sec.stateful.common.SecTestRoleRefEJB.class,
                com.sun.ts.tests.ejb30.sec.stateful.common.SecTestRoleRef.class
            );
            // The ejb-jar.xml descriptor
            URL ejbResURL = Client.class.getResource("/com/sun/ts/tests/ejb30/sec/stateful/secrunaspropagation/ejb3_sec_stateful_secrunaspropagation_ejb.xml");
            if(ejbResURL != null) {
              ejb3_sec_stateful_secrunaspropagation_ejb.addAsManifestResource(ejbResURL, "ejb-jar.xml");
            }
            // The sun-ejb-jar.xml file
            ejbResURL = Client.class.getResource("/com/sun/ts/tests/ejb30/sec/stateful/secrunaspropagation/ejb3_sec_stateful_secrunaspropagation_ejb.jar.sun-ejb-jar.xml");
            if(ejbResURL != null) {
              ejb3_sec_stateful_secrunaspropagation_ejb.addAsManifestResource(ejbResURL, "sun-ejb-jar.xml");
            }
            // Call the archive processor
            archiveProcessor.processEjbArchive(ejb3_sec_stateful_secrunaspropagation_ejb, Client.class, ejbResURL);

        // Ear
            EnterpriseArchive ejb3_sec_stateful_secrunaspropagation_ear = ShrinkWrap.create(EnterpriseArchive.class, "ejb3_sec_stateful_secrunaspropagation.ear");

            // Any libraries added to the ear

            // The component jars built by the package target
            ejb3_sec_stateful_secrunaspropagation_ear.addAsModule(ejb3_sec_stateful_secrunaspropagation_ejb);
            ejb3_sec_stateful_secrunaspropagation_ear.addAsModule(ejb3_sec_stateful_secrunaspropagation_client);



            // The application.xml descriptor
            URL earResURL = Client.class.getResource("/com/sun/ts/tests/ejb30/sec/stateful/secrunaspropagation/application.xml");
            if(earResURL != null) {
              ejb3_sec_stateful_secrunaspropagation_ear.addAsManifestResource(earResURL, "application.xml");
            }
            // The sun-application.xml descriptor
            earResURL = Client.class.getResource("/com/sun/ts/tests/ejb30/sec/stateful/secrunaspropagation/application.ear.sun-application.xml");
            if(earResURL != null) {
              ejb3_sec_stateful_secrunaspropagation_ear.addAsManifestResource(earResURL, "sun-application.xml");
            }
            // Call the archive processor
            archiveProcessor.processEarArchive(ejb3_sec_stateful_secrunaspropagation_ear, Client.class, earResURL);
        return ejb3_sec_stateful_secrunaspropagation_ear;
        }

        @Test
        @Override
        public void test1() throws java.lang.Exception {
            super.test1();
        }

        @Test
        @Override
        public void test2() throws java.lang.Exception {
            super.test2();
        }

        @Test
        @Override
        public void test3() throws java.lang.Exception {
            super.test3();
        }

        @Test
        @Override
        public void test4() throws java.lang.Exception {
            super.test4();
        }

        @Test
        @Override
        public void test5() throws java.lang.Exception {
            super.test5();
        }

        @Test
        @Override
        public void test6() throws java.lang.Exception {
            super.test6();
        }

        @Test
        @Override
        public void test7() throws java.lang.Exception {
            super.test7();
        }

        @Test
        @Override
        public void test8() throws java.lang.Exception {
            super.test8();
        }

        @Test
        @Override
        public void test9() throws java.lang.Exception {
            super.test9();
        }

        @Test
        @Override
        public void test10() throws java.lang.Exception {
            super.test10();
        }

        @Test
        @Override
        public void test11() throws java.lang.Exception {
            super.test11();
        }


}