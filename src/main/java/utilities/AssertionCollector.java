package utilities;

import java.util.ArrayList;
import java.util.List;

public class AssertionCollector {
    private static List<String> assertions = new ArrayList<>();
    private static boolean hasFailed = false;

    public static void collectAssertion(String assertion) {
        assertions.add(assertion);
    }

    public static List<String> getAssertions() {
        return assertions;
    }

    public static void clearAssertions() {
        assertions.clear();
        hasFailed = false;
    }

    public static boolean hasFailed() {
        return hasFailed;
    }

    public static void setFailed(boolean failed) {
        hasFailed = failed;
    }
}
