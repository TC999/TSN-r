package com.github.barteksc.pdfviewer.util;

import android.content.Context;
import android.util.TypedValue;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: Util.java */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final int f37324a = 4096;

    public static int a(Context context, int i4) {
        return (int) TypedValue.applyDimension(1, i4, context.getResources().getDisplayMetrics());
    }

    public static byte[] b(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[4096];
        while (true) {
            int read = inputStream.read(bArr);
            if (-1 != read) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }
}
