package com.nobutnk.sonar.plugin;

import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

public class MethodInvocationCustomCheckTest {
    @Test
    public void test() {
        JavaCheckVerifier.verify(
                "src/test/files/MethodInvocationCustomCheck.java",
                new MethodInvocationCustomCheck());
        
    }
}
