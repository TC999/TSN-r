package com.tencent.turingfd.sdk.ams.au;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.Locale;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Cherry {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int f51967a = 0;

    static {
        new SecureRandom();
    }

    public static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer(bArr.length);
        for (byte b4 : bArr) {
            String hexString = Integer.toHexString(b4 & 255);
            if (hexString.length() < 2) {
                stringBuffer.append(0);
            }
            stringBuffer.append(hexString.toUpperCase(Locale.getDefault()));
        }
        return stringBuffer.toString();
    }

    public static String a(String str, String str2, String str3) {
        return !TextUtils.isEmpty(str3) ? str3.replace(str, str2) : str3;
    }

    public static String a(byte[] bArr, String str) {
        try {
            if (str == null) {
                return new String(bArr);
            }
            return new String(bArr, str);
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }
}
