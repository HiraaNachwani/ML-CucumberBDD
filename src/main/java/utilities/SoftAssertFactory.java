package utilities;

import org.testng.asserts.SoftAssert;

public class SoftAssertFactory {

    private static ThreadLocal<SoftAssert> softAssertThreadLocal = ThreadLocal.withInitial(SoftAssert::new);

    public static SoftAssert getSoftAssert() {
        return softAssertThreadLocal.get();
    }

    public static void removeSoftAssert() {
        softAssertThreadLocal.remove();
    }
}
