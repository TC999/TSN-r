package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.kwad.sdk.utils.C11023ap;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/* renamed from: com.kwad.sdk.core.videocache.l */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10580l {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static void m25397b(byte[] bArr, long j, int i) {
        C11023ap.m24087g(bArr, "Buffer must be not null!");
        boolean z = true;
        C11023ap.checkArgument(j >= 0, "Data offset must be positive!");
        C11023ap.checkArgument((i < 0 || i > bArr.length) ? false : false, "Length must be in range [0..buffer.length]");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String decode(String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Error decoding url", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: eH */
    public static String m25396eH(String str) {
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (TextUtils.isEmpty(fileExtensionFromUrl)) {
            return null;
        }
        return singleton.getMimeTypeFromExtension(fileExtensionFromUrl);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String encode(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("Error encoding url", e);
        }
    }
}
