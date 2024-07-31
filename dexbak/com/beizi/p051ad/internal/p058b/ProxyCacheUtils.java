package com.beizi.p051ad.internal.p058b;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.beizi.p051ad.internal.utilities.HaoboLog;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.beizi.ad.internal.b.n */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class ProxyCacheUtils {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static String m49551a(String str) {
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (TextUtils.isEmpty(fileExtensionFromUrl)) {
            return null;
        }
        return singleton.getMimeTypeFromExtension(fileExtensionFromUrl);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static String m49548b(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Error encoding url", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static String m49547c(String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Error decoding url", e);
        }
    }

    /* renamed from: d */
    public static String m49546d(String str) {
        try {
            return m49550a(MessageDigest.getInstance("MD5").digest(str.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m49549a(byte[] bArr, long j, int i) {
        Preconditions.m49571a(bArr, "Buffer must be not null!");
        boolean z = true;
        Preconditions.m49569a(j >= 0, "Data offset must be positive!");
        Preconditions.m49569a((i < 0 || i > bArr.length) ? false : false, "Length must be in range [0..buffer.length]");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m49552a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                HaoboLog.m49289e(HaoboLog.proxyCacheUtilsLogTag, "Error closing resource", e);
            }
        }
    }

    /* renamed from: a */
    private static String m49550a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(bArr[i])));
        }
        return stringBuffer.toString();
    }
}
