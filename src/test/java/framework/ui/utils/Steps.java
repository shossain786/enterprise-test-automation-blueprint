package framework.ui.utils;

import com.utem.reporter.testng.UtemSteps;

/**
 * Thin wrapper around UtemSteps that silently no-ops in CI environments
 * where the UTEM JAR is excluded from the test classpath.
 */
public final class Steps {

    private Steps() {}

    public static void step(String description) {
        try {
            UtemSteps.step(description);
        } catch (NoClassDefFoundError ignored) {
            // UTEM JAR not on classpath (CI environment) — skip step reporting
        }
    }
}