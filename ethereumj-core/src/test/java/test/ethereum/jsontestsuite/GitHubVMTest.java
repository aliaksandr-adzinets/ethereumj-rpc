package test.ethereum.jsontestsuite;

import org.ethereum.jsontestsuite.JSONReader;

import org.json.simple.parser.ParseException;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashSet;
import java.util.Set;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GitHubVMTest {


    @Test
    public void runSingle() throws ParseException {

        String json = JSONReader.loadJSON("VMTests/vmArithmeticTest.json");
        GitHubJSONTestSuite.runGitHubJsonVMTest(json, "");
    }


    @Test
    public void testArithmeticFromGitHub() throws ParseException {

        Set<String> excluded = new HashSet<>();
        excluded.add("addmod2");
        excluded.add("addmod3"); // implement mod by negative for BigInt
        excluded.add("addmod2_1"); // [?]
        excluded.add("mulmoddivByZero2"); // [?]
        excluded.add("addmodDivByZero"); // [?]
        excluded.add("addmodDivByZero1"); // [?]
        excluded.add("mulmoddivByZero1"); // [?]
        excluded.add("mulmoddivByZero"); // [?]
        excluded.add("addmod3_0"); // [?]

        String json = JSONReader.loadJSON("VMTests/vmArithmeticTest.json");
        GitHubJSONTestSuite.runGitHubJsonVMTest(json, excluded);
    }

    @Ignore
    @Test // testing full suite
    public void testBitwiseLogicOperationFromGitHub() throws ParseException {

        Set<String> excluded = new HashSet<>();
        String json = JSONReader.loadJSON("VMTests/vmBitwiseLogicOperationTest.json");
        GitHubJSONTestSuite.runGitHubJsonVMTest(json, excluded);
    }

    @Ignore
    @Test // testing full suite
    public void testBlockInfoFromGitHub() throws ParseException {

        Set<String> excluded = new HashSet<>();
        String json = JSONReader.loadJSON("VMTests/vmBlockInfoTest.json");
        GitHubJSONTestSuite.runGitHubJsonVMTest(json, excluded);
    }

    @Ignore
    @Test // testing full suite
    public void testEnvironmentalInfoFromGitHub() throws ParseException {

        Set<String> excluded = new HashSet<>();
        String json = JSONReader.loadJSON("VMTests/vmEnvironmentalInfoTest.json");
        GitHubJSONTestSuite.runGitHubJsonVMTest(json, excluded);
    }

    @Ignore
    @Test // testing full suite
    public void testIOandFlowOperationsFromGitHub() throws ParseException {

        Set<String> excluded = new HashSet<>();
        String json = JSONReader.loadJSON("VMTests/vmIOandFlowOperationsTest.json");
        GitHubJSONTestSuite.runGitHubJsonVMTest(json, excluded);
    }

    @Ignore
    @Test // testing full suite
    public void testPushDupSwapFromGitHub() throws ParseException {

        Set<String> excluded = new HashSet<>();
        String json = JSONReader.loadJSON("VMTests/vmPushDupSwapTest.json");
        GitHubJSONTestSuite.runGitHubJsonVMTest(json, excluded);
    }

    @Ignore
    @Test // testing full suite
    public void testShaFromGitHub() throws ParseException {

        Set<String> excluded = new HashSet<>();
        String json = JSONReader.loadJSON("VMTests/vmSha3Test.json");
        GitHubJSONTestSuite.runGitHubJsonVMTest(json, excluded);
    }

    @Ignore
    @Test // testing full suite
    public void testVMGitHub() throws ParseException {

        Set<String> excluded = new HashSet<>();
        String json = JSONReader.loadJSON("VMTests/vmtests.json");
        GitHubJSONTestSuite.runGitHubJsonVMTest(json, excluded);
    }

    @Ignore
    @Test // testing full suite
    public void testVMLogGitHub() throws ParseException {

        Set<String> excluded = new HashSet<>();
        String json = JSONReader.loadJSON("VMTests/vmLogTest.json");
        GitHubJSONTestSuite.runGitHubJsonVMTest(json, excluded);
    }
}
