package com.danikula.videocache;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.Closeable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import org.slf4j.InterfaceC15424c;
import org.slf4j.LoggerFactory;

/* compiled from: ProxyCacheUtils.java */
/* renamed from: com.danikula.videocache.p */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6571p {

    /* renamed from: a */
    private static final InterfaceC15424c f23145a = LoggerFactory.m2655j("ProxyCacheUtils");

    /* renamed from: b */
    static final int f23146b = 8192;

    /* renamed from: c */
    static final int f23147c = 16;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m35841a(byte[] bArr, long j, int i) {
        C6567n.m35857e(bArr, "Buffer must be not null!");
        boolean z = true;
        C6567n.m35859c(j >= 0, "Data offset must be positive!");
        C6567n.m35859c((i < 0 || i > bArr.length) ? false : false, "Length must be in range [0..buffer.length]");
    }

    /* renamed from: b */
    private static String m35840b(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(bArr[i])));
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static void m35839c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                f23145a.error("Error closing resource", (Throwable) e);
            }
        }
    }

    /* renamed from: d */
    public static String m35838d(String str) {
        try {
            return m35840b(MessageDigest.getInstance("MD5").digest(str.getBytes()));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public static String m35837e(String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Error decoding url", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public static String m35836f(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Error encoding url", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public static String m35835g(String str) {
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (TextUtils.isEmpty(fileExtensionFromUrl)) {
            return null;
        }
        return singleton.getMimeTypeFromExtension(fileExtensionFromUrl);
    }

    /* renamed from: h */
    static String m35834h(byte[] bArr, int i) {
        int min = Math.min(16, Math.max(i, 0));
        String arrays = Arrays.toString(Arrays.copyOfRange(bArr, 0, min));
        if (min < i) {
            return arrays.substring(0, arrays.length() - 1) + ", ...]";
        }
        return arrays;
    }
}
