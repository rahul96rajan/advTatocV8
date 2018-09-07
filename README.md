### Test Automation Suite Documentation
---
#### Summary:

Automated Test Suite for T.A.T.O.C. This uses Selenium Testing Tool for automated testing of the Project.

#### System Requirement:

* JDK 1.6 or above
* Maven 3.1
* Eclipse or IDE of choice in case there is need to update the script. (optional)

#### Script Execution

Open terminal and navigate to the root directory of the scripts. Root directory contains pom.xml file

    mvn clean integration-test //for complete test-suite
    mvn clean integration-test -Dtest=<<TestScriptName>> //for single test script

#### Result Files:	
The Test Execution Results will be stored in the following directory once the test has completed

    ./target/test-output/Tatoc_Advanced_Test_suite/TestSuite.html (for complete test suite)
