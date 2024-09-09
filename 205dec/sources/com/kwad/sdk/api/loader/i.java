package com.kwad.sdk.api.loader;

import android.content.Context;
import com.kwad.sdk.api.core.TLSConnectionUtils;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class i {

    /* renamed from: com.kwad.sdk.api.loader.i$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    final class AnonymousClass1 extends com.kwad.sdk.api.a.b {
        final /* synthetic */ String anI;
        final /* synthetic */ Context gq;

        AnonymousClass1(Context context, String str) {
            this.gq = context;
            this.anI = str;
        }

        public final void doTask() {
            try {
                File[] listFiles = i.t(this.gq, this.anI).getParentFile().listFiles();
                if (listFiles == null || listFiles.length <= 0) {
                    return;
                }
                for (File file : listFiles) {
                    if (h.K(this.anI, file.getName().substring(file.getName().indexOf("-") + 1))) {
                        i.h(file);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0051  */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.io.Closeable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void c(java.lang.String r6, java.io.File r7) {
        /*
            r0 = 0
            boolean r1 = r7.exists()     // Catch: java.lang.Throwable -> L46
            if (r1 == 0) goto La
            com.kwad.sdk.api.loader.h.j(r7)     // Catch: java.lang.Throwable -> L46
        La:
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L46
            r2 = 0
            r1.<init>(r7, r2)     // Catch: java.lang.Throwable -> L46
            java.net.HttpURLConnection r6 = cc(r6)     // Catch: java.lang.Throwable -> L42
            java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L3b
            java.io.InputStream r3 = r6.getInputStream()     // Catch: java.lang.Throwable -> L3b
            r7.<init>(r3)     // Catch: java.lang.Throwable -> L3b
            r0 = 10240(0x2800, float:1.4349E-41)
            byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> L36
        L21:
            int r3 = r7.read(r0)     // Catch: java.lang.Throwable -> L36
            r4 = -1
            if (r3 == r4) goto L2c
            r1.write(r0, r2, r3)     // Catch: java.lang.Throwable -> L36
            goto L21
        L2c:
            closeQuietly(r1)
            closeQuietly(r7)
            r6.disconnect()
            return
        L36:
            r0 = move-exception
            r5 = r1
            r1 = r6
            r6 = r0
            goto L40
        L3b:
            r7 = move-exception
            r5 = r1
            r1 = r6
            r6 = r7
            r7 = r0
        L40:
            r0 = r5
            goto L49
        L42:
            r6 = move-exception
            r7 = r0
            r0 = r1
            goto L48
        L46:
            r6 = move-exception
            r7 = r0
        L48:
            r1 = r7
        L49:
            closeQuietly(r0)
            closeQuietly(r7)
            if (r1 == 0) goto L54
            r1.disconnect()
        L54:
            goto L56
        L55:
            throw r6
        L56:
            goto L55
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.api.loader.i.c(java.lang.String, java.io.File):void");
    }

    private static HttpURLConnection cc(String str) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        TLSConnectionUtils.wrapHttpURLConnection(httpURLConnection);
        httpURLConnection.setRequestProperty("Accept-Language", "zh-CN");
        httpURLConnection.setConnectTimeout(10000);
        httpURLConnection.setReadTimeout(120000);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestProperty("Connection", "keep-alive");
        httpURLConnection.setRequestProperty("Charset", "UTF-8");
        return httpURLConnection;
    }

    private static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
