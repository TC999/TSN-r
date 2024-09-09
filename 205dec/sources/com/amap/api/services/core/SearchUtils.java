package com.amap.api.services.core;

import android.content.Context;
import com.amap.api.col.s.j4;
import com.stub.StubApp;
import java.security.MessageDigest;
import java.util.Locale;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class SearchUtils {
    public static String getPkgName(Context context) {
        try {
            return StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName();
        } catch (Throwable th) {
            j4.i(th, "SearchUtils", "getPkgName");
            return null;
        }
    }

    public static String getSHA1(Context context) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b4 : digest) {
                String upperCase = Integer.toHexString(b4 & 255).toUpperCase(Locale.US);
                if (upperCase.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(upperCase);
                stringBuffer.append(":");
            }
            return stringBuffer.toString();
        } catch (Throwable th) {
            j4.i(th, "SearchUtils", "getSHA1");
            return null;
        }
    }

    public static String getVersion() {
        return "9.7.0";
    }
}
