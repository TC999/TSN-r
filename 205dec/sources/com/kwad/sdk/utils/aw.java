package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import java.io.File;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class aw {
    private static String aPH;
    private static File aPI;

    /* renamed from: com.kwad.sdk.utils.aw$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    final class AnonymousClass1 implements com.kwad.sdk.e.c {
        final /* synthetic */ Context gq;

        AnonymousClass1(Context context) {
            this.gq = context;
        }

        public final String IR() {
            com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getIMEI:" + aw.j(this.gq, true));
            return aw.j(this.gq, true);
        }

        public final String IS() {
            com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getAndroidID:" + aw.k(this.gq, true));
            return aw.k(this.gq, true);
        }

        public final String IT() {
            com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getMac:" + aw.l(this.gq, true));
            return aw.l(this.gq, true);
        }

        public final String IU() {
            com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getIMEI2:" + aw.m(this.gq, true));
            return aw.m(this.gq, true);
        }

        public final String IV() {
            String n4 = aw.n(this.gq, true);
            com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getIMEI2:" + n4);
            return n4;
        }

        public final String IW() {
            com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getIMSI:" + aw.o(this.gq, true));
            return aw.o(this.gq, true);
        }

        public final String IX() {
            com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getSimCardPhoneCount:" + aw.q(this.gq, true));
            return aw.q(this.gq, true);
        }

        public final String IY() {
            String bW = aw.bW(true);
            com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getSimCardActivePhoneCount:" + bW);
            return bW;
        }

        public final String IZ() {
            String bX = aw.bX(true);
            com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getBaseStationInfo:" + bX);
            return bX;
        }

        public final String Ja() {
            String r3 = aw.r(this.gq, true);
            com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getWifiList:" + r3);
            return r3;
        }

        public final String Jb() {
            String t3 = aw.t(this.gq, true);
            com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getAppList:" + t3);
            return t3;
        }

        public final String Jc() {
            String ca = aw.ca(true);
            com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getSdkType:" + ca);
            return ca;
        }

        public final String getAppId() {
            String cc = aw.cc(true);
            com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getAppId:" + cc);
            return cc;
        }

        public final String getDeviceId() {
            String bY = aw.bY(true);
            com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getDeviceId:" + bY);
            return bY;
        }

        public final String getIccId() {
            com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getIccId:" + aw.p(this.gq, true));
            return aw.p(this.gq, true);
        }

        public final String getIp() {
            String bZ = aw.bZ(true);
            com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getIp:" + bZ);
            return bZ;
        }

        public final String getLocation() {
            String s3 = aw.s(this.gq, true);
            com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getLocation:" + s3);
            return s3;
        }

        public final String getOaid() {
            com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getOaid:" + aw.bV(true));
            return aw.bV(true);
        }

        public final String getSdkVersion() {
            String cb = aw.cb(true);
            com.kwad.sdk.core.e.c.d("SDKPrivateSafetyDataUtil", "getSdkVersion:" + cb);
            return cb;
        }
    }

    private static boolean Mz() {
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                return true;
            }
            return !Environment.isExternalStorageRemovable();
        } catch (Throwable th) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(th);
            return false;
        }
    }

    private static String cJ(Context context) {
        if (!TextUtils.isEmpty(aPH)) {
            return aPH;
        }
        String str = null;
        if (Mz()) {
            try {
                File externalFilesDir = context.getExternalFilesDir(null);
                if (externalFilesDir != null) {
                    str = externalFilesDir.getPath();
                }
            } catch (Exception e4) {
                com.kwad.sdk.core.e.c.printStackTrace(e4);
            }
        }
        if (TextUtils.isEmpty(str)) {
            str = context.getFilesDir().getPath();
        }
        String str2 = str + File.separator + "ksadsdk";
        aPH = str2;
        return str2;
    }

    public static File cK(Context context) {
        File file = aPI;
        if (file != null) {
            return file;
        }
        String str = null;
        if (Mz()) {
            try {
                File externalCacheDir = context.getExternalCacheDir();
                if (externalCacheDir != null) {
                    str = externalCacheDir.getPath();
                }
            } catch (Exception e4) {
                com.kwad.sdk.core.e.c.printStackTrace(e4);
            }
        }
        if (TextUtils.isEmpty(str)) {
            str = context.getCacheDir().getPath();
        }
        File file2 = new File(str + File.separator + "ksadsdk");
        aPI = file2;
        if (!file2.exists()) {
            aPI.mkdirs();
        }
        return aPI;
    }

    public static File cL(Context context) {
        String cJ = cJ(context);
        File file = new File(cJ + File.separator + "Download");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File cM(Context context) {
        String cJ = cJ(context);
        File file = new File(cJ + File.separator + "downloadFileSync/.temp");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File cN(Context context) {
        String str;
        if (com.kwad.framework.a.a.md.booleanValue()) {
            str = cJ(context);
        } else {
            str = context.getFilesDir().getAbsolutePath() + File.separator + "ksadsdk";
        }
        return new File(str + File.separator + "ksadlog");
    }

    public static String cO(Context context) {
        if (context == null) {
            return "";
        }
        String path = context.getFilesDir().getPath();
        return path + File.separator + "ksadsdk";
    }

    public static String cP(Context context) {
        return cK(context).getPath() + "/cookie";
    }

    public static String getTkJsFileDir(Context context, String str) {
        if (context == null) {
            return "";
        }
        String cO = cO(context);
        StringBuilder sb = new StringBuilder();
        sb.append(cO);
        String str2 = File.separator;
        sb.append(str2);
        sb.append("ksad/download/js");
        sb.append(str2);
        sb.append(str);
        return sb.toString();
    }

    public static String getTkJsRootDir(Context context) {
        if (context == null) {
            return "";
        }
        String cO = cO(context);
        return cO + File.separator + "ksad/download/js";
    }
}
