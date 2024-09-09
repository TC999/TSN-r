package xyz.adscope.common.info.deviceinfo.cn.oa.helpers;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.acse.ottn.f3;
import com.ss.android.download.api.constant.BaseConstants;
import xyz.adscope.common.constants.CommonConstants;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class DevicesIDsHelper {

    /* renamed from: a  reason: collision with root package name */
    public AppIdsUpdater f64675a;

    /* loaded from: E:\TSN-r\205dec\1574464.dex */
    public interface AppIdsUpdater {
        void OnIdsValid(String str);
    }

    public DevicesIDsHelper(AppIdsUpdater appIdsUpdater) {
        this.f64675a = appIdsUpdater;
    }

    public static boolean isHuawei() {
        if (!Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase("HUAWEI") && !str.equalsIgnoreCase("HONOR")) {
                return false;
            }
        }
        return true;
    }

    public static boolean isOppo() {
        if (!Build.MANUFACTURER.equalsIgnoreCase(BaseConstants.ROM_OPPO_UPPER_CONSTANT)) {
            String str = Build.BRAND;
            if (!str.equalsIgnoreCase(BaseConstants.ROM_OPPO_UPPER_CONSTANT) && !str.equalsIgnoreCase("REALME") && TextUtils.isEmpty(sysProperty("ro.build.version.opporom", ""))) {
                return false;
            }
        }
        return true;
    }

    public static String sysProperty(String str, String str2) {
        String str3;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            str3 = (String) cls.getMethod(f3.f5657f, String.class, String.class).invoke(cls, str, str2);
        } catch (Exception e4) {
            LogUtil.e(CommonConstants.TAG, "System property invoke error: " + e4);
            str3 = null;
        }
        return str3 == null ? "" : str3;
    }

    public final String a() {
        return Build.MANUFACTURER.toUpperCase();
    }

    public final String a(String str) {
        if (str == null) {
            return null;
        }
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(f3.f5657f, String.class, String.class).invoke(cls, str, "unknown");
        } catch (Exception unused) {
            return null;
        }
    }

    public final void a(Context context) {
        ZTEDeviceIDHelper zTEDeviceIDHelper;
        if (context == null) {
            return;
        }
        try {
            if ("ASUS".equalsIgnoreCase(a())) {
                new ASUSDeviceIDHelper(context).getID(this.f64675a);
            } else if (isHuawei()) {
                new HWDeviceIDHelper(context).getHWID(this.f64675a);
            } else if (isOppo()) {
                new OppoDeviceIDHelper(context).getID(this.f64675a);
            } else if ("ONEPLUS".equalsIgnoreCase(a())) {
                new OnePlusDeviceIDHelper(context).getID(this.f64675a);
            } else {
                if ("ZTE".equalsIgnoreCase(a())) {
                    zTEDeviceIDHelper = new ZTEDeviceIDHelper(context);
                } else {
                    if (!"FERRMEOS".equalsIgnoreCase(a()) && !isFreeMeOS()) {
                        if (!"SSUI".equalsIgnoreCase(a()) && !isSSUIOS()) {
                            if ("SAMSUNG".equalsIgnoreCase(a())) {
                                new SamsungDeviceIDHelper(context).getSumsungID(this.f64675a);
                                return;
                            }
                            return;
                        }
                        zTEDeviceIDHelper = new ZTEDeviceIDHelper(context);
                    }
                    zTEDeviceIDHelper = new ZTEDeviceIDHelper(context);
                }
                zTEDeviceIDHelper.getID(this.f64675a);
            }
        } catch (Throwable unused) {
            LogUtil.e(CommonConstants.TAG, "getIDFromNewThead exception");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x011c, code lost:
        if (isSSUIOS() != false) goto L6;
     */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0126 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:66:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void getOAID(android.content.Context r4) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: xyz.adscope.common.info.deviceinfo.cn.oa.helpers.DevicesIDsHelper.getOAID(android.content.Context):void");
    }

    public boolean isFreeMeOS() {
        String a4 = a("ro.build.freeme.label");
        return !TextUtils.isEmpty(a4) && a4.equalsIgnoreCase("FREEMEOS");
    }

    public boolean isSSUIOS() {
        String a4 = a("ro.ssui.product");
        return (TextUtils.isEmpty(a4) || a4.equalsIgnoreCase("unknown")) ? false : true;
    }
}
