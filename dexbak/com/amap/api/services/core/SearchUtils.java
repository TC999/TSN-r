package com.amap.api.services.core;

import android.content.Context;
import com.amap.api.col.p047s.C2082j4;
import com.stub.StubApp;
import java.security.MessageDigest;
import java.util.Locale;
import kotlin.UByte;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class SearchUtils {
    public static String getPkgName(Context context) {
        try {
            return StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageName();
        } catch (Throwable th) {
            C2082j4.m52825i(th, "SearchUtils", "getPkgName");
            return null;
        }
    }

    public static String getSHA1(Context context) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(StubApp.getOrigApplicationContext(context.getApplicationContext()).getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                String upperCase = Integer.toHexString(b & UByte.f41242c).toUpperCase(Locale.US);
                if (upperCase.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(upperCase);
                stringBuffer.append(":");
            }
            return stringBuffer.toString();
        } catch (Throwable th) {
            C2082j4.m52825i(th, "SearchUtils", "getSHA1");
            return null;
        }
    }

    public static String getVersion() {
        return "9.7.0";
    }
}
