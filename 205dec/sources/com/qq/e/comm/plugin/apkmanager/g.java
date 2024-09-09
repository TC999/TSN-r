package com.qq.e.comm.plugin.apkmanager;

import android.graphics.Bitmap;
import android.text.TextUtils;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class g implements Callable<Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private String f41786a;

    /* renamed from: b  reason: collision with root package name */
    private int f41787b;

    /* renamed from: c  reason: collision with root package name */
    private int f41788c;

    public g(String str) {
        this(str, 0, 0);
    }

    private Bitmap a(Bitmap bitmap) {
        int i4;
        int i5 = this.f41787b;
        return (i5 <= 0 || (i4 = this.f41788c) <= 0) ? bitmap : Bitmap.createScaledBitmap(bitmap, i5, i4, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0049, code lost:
        if (r1 != null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.graphics.Bitmap c() {
        /*
            r5 = this;
            java.io.File r0 = com.qq.e.comm.plugin.util.b1.h()
            r1 = 0
            if (r0 == 0) goto L8e
            r0.mkdirs()
            java.lang.String r2 = r5.f41786a
            java.lang.String r2 = com.qq.e.comm.plugin.util.s0.a(r2)
            java.io.File r3 = new java.io.File
            r3.<init>(r0, r2)
            boolean r0 = r3.exists()
            if (r0 != 0) goto L5d
            java.net.HttpURLConnection r1 = r5.a()     // Catch: java.lang.Throwable -> L4c
            java.net.HttpURLConnection r1 = com.qq.e.comm.plugin.util.v0.a(r1)     // Catch: java.lang.Throwable -> L4c
            int r0 = r1.getResponseCode()     // Catch: java.lang.Throwable -> L4c
            r2 = 200(0xc8, float:2.8E-43)
            if (r0 != r2) goto L49
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4c
            r2.<init>()     // Catch: java.lang.Throwable -> L4c
            java.lang.String r4 = "Icon url resp code"
            r2.append(r4)     // Catch: java.lang.Throwable -> L4c
            r2.append(r0)     // Catch: java.lang.Throwable -> L4c
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L4c
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L4c
            com.qq.e.comm.plugin.util.d1.a(r0, r2)     // Catch: java.lang.Throwable -> L4c
            java.io.InputStream r0 = r1.getInputStream()     // Catch: java.lang.Throwable -> L4c
            com.qq.e.comm.plugin.util.b1.a(r0, r3)     // Catch: java.lang.Throwable -> L4c
        L49:
            if (r1 == 0) goto L5d
            goto L52
        L4c:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L56
            if (r1 == 0) goto L5d
        L52:
            r1.disconnect()
            goto L5d
        L56:
            r0 = move-exception
            if (r1 == 0) goto L5c
            r1.disconnect()
        L5c:
            throw r0
        L5d:
            java.lang.String r0 = r3.getAbsolutePath()
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeFile(r0)
            if (r0 != 0) goto L89
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "DecodeIconImageFail\turl:"
            r1.append(r2)
            java.lang.String r2 = r5.f41786a
            r1.append(r2)
            java.lang.String r2 = "\tfilemd5:"
            r1.append(r2)
            java.lang.String r2 = com.qq.e.comm.plugin.util.s0.a(r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.qq.e.comm.plugin.util.d1.a(r1)
        L89:
            android.graphics.Bitmap r0 = r5.a(r0)
            return r0
        L8e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.apkmanager.g.c():android.graphics.Bitmap");
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: b */
    public Bitmap call() throws Exception {
        if (TextUtils.isEmpty(this.f41786a)) {
            return null;
        }
        return c();
    }

    public g(String str, int i4, int i5) {
        this.f41786a = "";
        this.f41786a = str;
        this.f41787b = i4;
        this.f41788c = i5;
    }

    private HttpURLConnection a() throws IOException {
        this.f41786a = com.qq.e.comm.plugin.i0.e.a(this.f41786a, 3);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f41786a).openConnection();
        httpURLConnection.setRequestProperty(com.qq.e.comm.plugin.i0.k.b(), com.qq.e.comm.plugin.i0.k.a());
        httpURLConnection.setConnectTimeout(5000);
        httpURLConnection.setReadTimeout(5000);
        return httpURLConnection;
    }
}
