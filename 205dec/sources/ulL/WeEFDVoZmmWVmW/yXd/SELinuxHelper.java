package ulL.WeEFDVoZmmWVmW.yXd;

import ulL.WeEFDVoZmmWVmW.yXd.services.BaseService;
import ulL.WeEFDVoZmmWVmW.yXd.services.DirectAccessService;

/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class SELinuxHelper {
    private static final BaseService sServiceAppDataFile = new DirectAccessService();

    private SELinuxHelper() {
    }

    public static BaseService getAppDataFileService() {
        return sServiceAppDataFile;
    }

    public static String getContext() {
        return null;
    }

    public static boolean isSELinuxEnabled() {
        return true;
    }

    public static boolean isSELinuxEnforced() {
        return true;
    }
}
