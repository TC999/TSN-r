package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.MBridgeConstans;

/* renamed from: com.mbridge.msdk.foundation.tools.ah */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class TargetAdaptionUtils {

    /* renamed from: a */
    public static int f30996a = -1;

    /* renamed from: b */
    public static String f30997b = "";

    /* renamed from: c */
    public static int f30998c = -1;

    /* renamed from: d */
    public static String f30999d = "";

    /* renamed from: e */
    public static int f31000e = -1;

    /* renamed from: f */
    public static int f31001f = -1;

    /* renamed from: g */
    public static String f31002g = "";

    /* renamed from: h */
    public static String f31003h = "";

    /* renamed from: i */
    public static int f31004i = -1;

    /* renamed from: j */
    public static String f31005j = "";

    /* renamed from: a */
    public static boolean m21955a(Context context) {
        int i = f31004i;
        if (i == 1) {
            return true;
        }
        if (i == 0) {
            return false;
        }
        try {
            if (context == null) {
                f31004i = -1;
                f31005j = "content is null";
                return false;
            } else if (SameDiTool.m21767w(context) < 26 || Build.VERSION.SDK_INT < 26) {
                return true;
            } else {
                new NotificationCompat.Builder(context, "download");
                f31005j = "ok";
                f31004i = 1;
                return true;
            }
        } catch (Exception e) {
            f31005j = e.getMessage();
            f31004i = -1;
            return false;
        } catch (NoSuchMethodError e2) {
            f31005j = e2.getMessage();
            f31004i = 0;
            return false;
        } catch (Throwable th) {
            f31005j = th.getMessage();
            f31004i = -1;
            return false;
        }
    }

    /* renamed from: b */
    public static boolean m21954b(Context context) {
        int i = f31000e;
        boolean z = true;
        if (i == 1) {
            return true;
        }
        if (i == 0) {
            return false;
        }
        try {
            if (context == null) {
                f31000e = -1;
                f31002g = "context is null";
                return false;
            }
            if (SameDiTool.m21767w(context) >= 26 && Build.VERSION.SDK_INT >= 26) {
                String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
                if (strArr == null) {
                    f31000e = -1;
                    f31002g = "permissions is null";
                    return false;
                } else if (strArr.length == 0) {
                    f31000e = 0;
                    f31002g = "permissions is zero";
                    return false;
                } else {
                    int length = strArr.length;
                    int i2 = 0;
                    boolean z2 = true;
                    while (true) {
                        if (i2 >= length) {
                            z = z2;
                            break;
                        } else if (strArr[i2].equals("android.permission.REQUEST_INSTALL_PACKAGES")) {
                            f31000e = 1;
                            f31002g = "ok";
                            break;
                        } else {
                            f31002g = "can't find permission";
                            f31000e = 0;
                            i2++;
                            z2 = false;
                        }
                    }
                }
            }
            return z;
        } catch (Exception e) {
            f31002g = e.getMessage();
            f31000e = -1;
            return false;
        } catch (Throwable th) {
            f31002g = th.getMessage();
            f31000e = -1;
            return false;
        }
    }

    /* renamed from: c */
    public static boolean m21953c(Context context) {
        int i = f30998c;
        boolean z = true;
        if (i == 1) {
            return true;
        }
        if (i == 0) {
            return false;
        }
        try {
            if (context == null) {
                f30998c = -1;
                f30999d = "context is null";
                return false;
            }
            ServiceInfo[] serviceInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4).services;
            if (serviceInfoArr == null) {
                f30998c = -1;
                f30999d = "serviceinfo is null";
                return false;
            } else if (serviceInfoArr.length == 0) {
                f30998c = 0;
                f30999d = "serviceinfos is zero";
                return false;
            } else {
                int length = serviceInfoArr.length;
                int i2 = 0;
                boolean z2 = true;
                while (true) {
                    if (i2 >= length) {
                        z = z2;
                        break;
                    } else if (serviceInfoArr[i2].name.equals("com.mbridge.msdk.shell.MBService")) {
                        f30998c = 1;
                        f30999d = "ok";
                        break;
                    } else {
                        f30999d = "can't find service";
                        f30998c = 0;
                        i2++;
                        z2 = false;
                    }
                }
                return z;
            }
        } catch (Exception e) {
            f30999d = e.getMessage();
            f30998c = -1;
            return false;
        } catch (Throwable th) {
            f30999d = th.getMessage();
            f30998c = -1;
            return false;
        }
    }

    /* renamed from: d */
    public static boolean m21952d(Context context) {
        int i = f31001f;
        boolean z = true;
        if (i == 1) {
            return true;
        }
        if (i == 0) {
            return false;
        }
        try {
            if (context == null) {
                f31001f = -1;
                f31003h = "context is null";
                return false;
            }
            ProviderInfo[] providerInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 8).providers;
            if (providerInfoArr == null) {
                f31001f = -1;
                f31003h = "providerInfos is null";
                return false;
            } else if (providerInfoArr.length == 0) {
                f31003h = "providerInfos is zero";
                f31001f = 0;
                return false;
            } else {
                int length = providerInfoArr.length;
                int i2 = 0;
                boolean z2 = true;
                while (i2 < length) {
                    ProviderInfo providerInfo = providerInfoArr[i2];
                    if (!providerInfo.name.equals("com.mbridge.msdk.foundation.tools.MBFileProvider") && (TextUtils.isEmpty(MBridgeConstans.FILE_PROVIDE_CUSTOM_PATH) || !providerInfo.name.equals(MBridgeConstans.FILE_PROVIDE_CUSTOM_PATH))) {
                        f31001f = 0;
                        f31003h = "providerInfos can't find";
                        i2++;
                        z2 = false;
                    }
                    f31001f = 1;
                    f31003h = "ok";
                    break;
                }
                z = z2;
                return z;
            }
        } catch (Exception e) {
            f31001f = -1;
            f31003h = e.getMessage();
            return false;
        } catch (Throwable th) {
            f31003h = th.getMessage();
            f31001f = -1;
            return false;
        }
    }

    /* renamed from: e */
    public static boolean m21951e(Context context) {
        try {
            if (SameDiTool.m21767w(context) >= 24) {
                return Build.VERSION.SDK_INT >= 24;
            }
            return false;
        } catch (Throwable th) {
            if (MBridgeConstans.DEBUG) {
                th.printStackTrace();
                return false;
            }
            return false;
        }
    }
}
