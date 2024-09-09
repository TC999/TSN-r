package com.kwad.sdk.core.videocache;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.kwad.sdk.utils.ap;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class l {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(byte[] bArr, long j4, int i4) {
        ap.g(bArr, "Buffer must be not null!");
        boolean z3 = true;
        ap.checkArgument(j4 >= 0, "Data offset must be positive!");
        ap.checkArgument((i4 < 0 || i4 > bArr.length) ? false : false, "Length must be in range [0..buffer.length]");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String decode(String str) {
        try {
            return URLDecoder.decode(str, "utf-8");
        } catch (UnsupportedEncodingException e4) {
            throw new RuntimeException("Error decoding url", e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String eH(String str) {
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
        } catch (UnsupportedEncodingException e4) {
            throw new RuntimeException("Error encoding url", e4);
        }
    }
}
