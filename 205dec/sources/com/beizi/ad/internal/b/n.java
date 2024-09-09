package com.beizi.ad.internal.b;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.beizi.ad.internal.utilities.HaoboLog;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: ProxyCacheUtils.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class n {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str) {
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (TextUtils.isEmpty(fileExtensionFromUrl)) {
            return null;
        }
        return singleton.getMimeTypeFromExtension(fileExtensionFromUrl);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e4) {
            throw new RuntimeException("Error encoding url", e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e4) {
            throw new RuntimeException("Error decoding url", e4);
        }
    }

    public static String d(String str) {
        try {
            return a(MessageDigest.getInstance("MD5").digest(str.getBytes()));
        } catch (NoSuchAlgorithmException e4) {
            throw new IllegalStateException(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(byte[] bArr, long j4, int i4) {
        k.a(bArr, "Buffer must be not null!");
        boolean z3 = true;
        k.a(j4 >= 0, "Data offset must be positive!");
        k.a((i4 < 0 || i4 > bArr.length) ? false : false, "Length must be in range [0..buffer.length]");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e4) {
                HaoboLog.e(HaoboLog.proxyCacheUtilsLogTag, "Error closing resource", e4);
            }
        }
    }

    private static String a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(bArr[i4])));
        }
        return stringBuffer.toString();
    }
}
