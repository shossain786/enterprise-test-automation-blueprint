package framework.ui.utils;

import java.lang.reflect.Method;

/**
 * Wrapper around UtemSteps that uses reflection so the UTEM class name
 * is a plain String constant in the bytecode — the JVM has nothing to
 * eagerly resolve at class-load time, and CI runs skip silently.
 */
public final class Steps {

    private static final String UTEM_STEPS_CLASS = "com.utem.reporter.testng.UtemSteps";

    private Steps() {}

    public static void step(String description) {
        try {
            Class<?> cls = Class.forName(UTEM_STEPS_CLASS);
            Method m = cls.getMethod("step", String.class);
            m.invoke(null, description);
        } catch (Exception ignored) {
            // UTEM JAR not on classpath (CI environment) — skip step reporting
        }
    }
}