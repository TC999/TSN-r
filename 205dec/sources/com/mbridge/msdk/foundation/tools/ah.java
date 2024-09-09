package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.MBridgeConstans;

/* compiled from: TargetAdaptionUtils.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class ah {

    /* renamed from: a  reason: collision with root package name */
    public static int f39769a = -1;

    /* renamed from: b  reason: collision with root package name */
    public static String f39770b = "";

    /* renamed from: c  reason: collision with root package name */
    public static int f39771c = -1;

    /* renamed from: d  reason: collision with root package name */
    public static String f39772d = "";

    /* renamed from: e  reason: collision with root package name */
    public static int f39773e = -1;

    /* renamed from: f  reason: collision with root package name */
    public static int f39774f = -1;

    /* renamed from: g  reason: collision with root package name */
    public static String f39775g = "";

    /* renamed from: h  reason: collision with root package name */
    public static String f39776h = "";

    /* renamed from: i  reason: collision with root package name */
    public static int f39777i = -1;

    /* renamed from: j  reason: collision with root package name */
    public static String f39778j = "";

    public static boolean a(Context context) {
        int i4 = f39777i;
        if (i4 == 1) {
            return true;
        }
        if (i4 == 0) {
            return false;
        }
        try {
            if (context == null) {
                f39777i = -1;
                f39778j = "content is null";
                return false;
            } else if (t.w(context) < 26 || Build.VERSION.SDK_INT < 26) {
                return true;
            } else {
                new NotificationCompat.Builder(context, "download");
                f39778j = "ok";
                f39777i = 1;
                return true;
            }
        } catch (Exception e4) {
            f39778j = e4.getMessage();
            f39777i = -1;
            return false;
        } catch (NoSuchMethodError e5) {
            f39778j = e5.getMessage();
            f39777i = 0;
            return false;
        } catch (Throwable th) {
            f39778j = th.getMessage();
            f39777i = -1;
            return false;
        }
    }

    public static boolean b(Context context) {
        int i4 = f39773e;
        boolean z3 = true;
        if (i4 == 1) {
            return true;
        }
        if (i4 == 0) {
            return false;
        }
        try {
            if (context == null) {
                f39773e = -1;
                f39775g = "context is null";
                return false;
            }
            if (t.w(context) >= 26 && Build.VERSION.SDK_INT >= 26) {
                String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
                if (strArr == null) {
                    f39773e = -1;
                    f39775g = "permissions is null";
                    return false;
                } else if (strArr.length == 0) {
                    f39773e = 0;
                    f39775g = "permissions is zero";
                    return false;
                } else {
                    int length = strArr.length;
                    int i5 = 0;
                    boolean z4 = true;
                    while (true) {
                        if (i5 >= length) {
                            z3 = z4;
                            break;
                        } else if (strArr[i5].equals("android.permission.REQUEST_INSTALL_PACKAGES")) {
                            f39773e = 1;
                            f39775g = "ok";
                            break;
                        } else {
                            f39775g = "can't find permission";
                            f39773e = 0;
                            i5++;
                            z4 = false;
                        }
                    }
                }
            }
            return z3;
        } catch (Exception e4) {
            f39775g = e4.getMessage();
            f39773e = -1;
            return false;
        } catch (Throwable th) {
            f39775g = th.getMessage();
            f39773e = -1;
            return false;
        }
    }

    public static boolean c(Context context) {
        int i4 = f39771c;
        boolean z3 = true;
        if (i4 == 1) {
            return true;
        }
        if (i4 == 0) {
            return false;
        }
        try {
            if (context == null) {
                f39771c = -1;
                f39772d = "context is null";
                return false;
            }
            ServiceInfo[] serviceInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4).services;
            if (serviceInfoArr == null) {
                f39771c = -1;
                f39772d = "serviceinfo is null";
                return false;
            } else if (serviceInfoArr.length == 0) {
                f39771c = 0;
                f39772d = "serviceinfos is zero";
                return false;
            } else {
                int length = serviceInfoArr.length;
                int i5 = 0;
                boolean z4 = true;
                while (true) {
                    if (i5 >= length) {
                        z3 = z4;
                        break;
                    } else if (serviceInfoArr[i5].name.equals("com.mbridge.msdk.shell.MBService")) {
                        f39771c = 1;
                        f39772d = "ok";
                        break;
                    } else {
                        f39772d = "can't find service";
                        f39771c = 0;
                        i5++;
                        z4 = false;
                    }
                }
                return z3;
            }
        } catch (Exception e4) {
            f39772d = e4.getMessage();
            f39771c = -1;
            return false;
        } catch (Throwable th) {
            f39772d = th.getMessage();
            f39771c = -1;
            return false;
        }
    }

    public static boolean d(Context context) {
        int i4 = f39774f;
        boolean z3 = true;
        if (i4 == 1) {
            return true;
        }
        if (i4 == 0) {
            return false;
        }
        try {
            if (context == null) {
                f39774f = -1;
                f39776h = "context is null";
                return false;
            }
            ProviderInfo[] providerInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 8).providers;
            if (providerInfoArr == null) {
                f39774f = -1;
                f39776h = "providerInfos is null";
                return false;
            } else if (providerInfoArr.length == 0) {
                f39776h = "providerInfos is zero";
                f39774f = 0;
                return false;
            } else {
                int length = providerInfoArr.length;
                int i5 = 0;
                boolean z4 = true;
                while (i5 < length) {
                    ProviderInfo providerInfo = providerInfoArr[i5];
                    if (!providerInfo.name.equals("com.mbridge.msdk.foundation.tools.MBFileProvider") && (TextUtils.isEmpty(MBridgeConstans.FILE_PROVIDE_CUSTOM_PATH) || !providerInfo.name.equals(MBridgeConstans.FILE_PROVIDE_CUSTOM_PATH))) {
                        f39774f = 0;
                        f39776h = "providerInfos can't find";
                        i5++;
                        z4 = false;
                    }
                    f39774f = 1;
                    f39776h = "ok";
                    break;
                }
                z3 = z4;
                return z3;
            }
        } catch (Exception e4) {
            f39774f = -1;
            f39776h = e4.getMessage();
            return false;
        } catch (Throwable th) {
            f39776h = th.getMessage();
            f39774f = -1;
            return false;
        }
    }

    public static boolean e(Context context) {
        try {
            if (t.w(context) >= 24) {
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
