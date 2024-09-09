package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: NinePatchTool.java */
/* renamed from: com.amap.api.col.3l.p2  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class p2 {
    private static int a(byte[] bArr, int i4) {
        byte b4 = bArr[i4 + 0];
        byte b5 = bArr[i4 + 1];
        byte b6 = bArr[i4 + 2];
        return (bArr[i4 + 3] << 24) | (b4 & 255) | (b5 << 8) | (b6 << 16);
    }

    private static Bitmap b(InputStream inputStream) throws Exception {
        Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
        byte[] h4 = h(decodeStream);
        if (NinePatch.isNinePatchChunk(h4)) {
            Bitmap createBitmap = Bitmap.createBitmap(decodeStream, 1, 1, decodeStream.getWidth() - 2, decodeStream.getHeight() - 2);
            a3.B(decodeStream);
            if (Build.VERSION.SDK_INT >= 28) {
                Method declaredMethod = createBitmap.getClass().getDeclaredMethod("setNinePatchChunk", byte[].class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(createBitmap, h4);
            } else {
                Field declaredField = createBitmap.getClass().getDeclaredField("mNinePatchChunk");
                declaredField.setAccessible(true);
                declaredField.set(createBitmap, h4);
            }
            return createBitmap;
        }
        return decodeStream;
    }

    public static Drawable c(Context context, String str) throws Exception {
        Bitmap i4 = i(context, str);
        if (i4.getNinePatchChunk() == null) {
            return new BitmapDrawable(context.getResources(), i4);
        }
        Rect rect = new Rect();
        g(i4.getNinePatchChunk(), rect);
        return new NinePatchDrawable(context.getResources(), i4, i4.getNinePatchChunk(), rect, null);
    }

    private static void d(Bitmap bitmap, byte[] bArr) {
        int width = bitmap.getWidth() - 2;
        int[] iArr = new int[width];
        bitmap.getPixels(iArr, 0, width, 1, bitmap.getHeight() - 1, width, 1);
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i5 >= width) {
                break;
            } else if (-16777216 == iArr[i5]) {
                f(bArr, 12, i5);
                break;
            } else {
                i5++;
            }
        }
        int i6 = width - 1;
        while (true) {
            if (i6 < 0) {
                break;
            } else if (-16777216 == iArr[i6]) {
                f(bArr, 16, (width - i6) - 2);
                break;
            } else {
                i6--;
            }
        }
        int height = bitmap.getHeight() - 2;
        int[] iArr2 = new int[height];
        bitmap.getPixels(iArr2, 0, 1, bitmap.getWidth() - 1, 0, 1, height);
        while (true) {
            if (i4 >= height) {
                break;
            } else if (-16777216 == iArr2[i4]) {
                f(bArr, 20, i4);
                break;
            } else {
                i4++;
            }
        }
        for (int i7 = height - 1; i7 >= 0; i7--) {
            if (-16777216 == iArr2[i7]) {
                f(bArr, 24, (height - i7) - 2);
                return;
            }
        }
    }

    private static void e(OutputStream outputStream, int i4) throws IOException {
        outputStream.write((i4 >> 0) & 255);
        outputStream.write((i4 >> 8) & 255);
        outputStream.write((i4 >> 16) & 255);
        outputStream.write((i4 >> 24) & 255);
    }

    private static void f(byte[] bArr, int i4, int i5) {
        bArr[i4 + 0] = (byte) (i5 >> 0);
        bArr[i4 + 1] = (byte) (i5 >> 8);
        bArr[i4 + 2] = (byte) (i5 >> 16);
        bArr[i4 + 3] = (byte) (i5 >> 24);
    }

    private static void g(byte[] bArr, Rect rect) {
        rect.left = a(bArr, 12);
        rect.right = a(bArr, 16);
        rect.top = a(bArr, 20);
        rect.bottom = a(bArr, 24);
    }

    private static byte[] h(Bitmap bitmap) throws IOException {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i4 = 0; i4 < 32; i4++) {
            byteArrayOutputStream.write(0);
        }
        int i5 = width - 2;
        int[] iArr = new int[i5];
        bitmap.getPixels(iArr, 0, width, 1, 0, i5, 1);
        boolean z3 = iArr[0] == -16777216;
        boolean z4 = iArr[i5 + (-1)] == -16777216;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < i5; i8++) {
            if (i6 != iArr[i8]) {
                i7++;
                e(byteArrayOutputStream, i8);
                i6 = iArr[i8];
            }
        }
        if (z4) {
            i7++;
            e(byteArrayOutputStream, i5);
        }
        int i9 = i7 + 1;
        if (z3) {
            i9--;
        }
        if (z4) {
            i9--;
        }
        int i10 = height - 2;
        int[] iArr2 = new int[i10];
        bitmap.getPixels(iArr2, 0, 1, 0, 1, 1, i10);
        boolean z5 = iArr2[0] == -16777216;
        boolean z6 = iArr2[i10 + (-1)] == -16777216;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < i10; i13++) {
            if (i11 != iArr2[i13]) {
                i12++;
                e(byteArrayOutputStream, i13);
                i11 = iArr2[i13];
            }
        }
        if (z6) {
            i12++;
            e(byteArrayOutputStream, i10);
        }
        int i14 = i12 + 1;
        if (z5) {
            i14--;
        }
        if (z6) {
            i14--;
        }
        int i15 = 0;
        while (true) {
            int i16 = i9 * i14;
            if (i15 < i16) {
                e(byteArrayOutputStream, 1);
                i15++;
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArray[0] = 1;
                byteArray[1] = (byte) i7;
                byteArray[2] = (byte) i12;
                byteArray[3] = (byte) i16;
                d(bitmap, byteArray);
                return byteArray;
            }
        }
    }

    private static Bitmap i(Context context, String str) throws Exception {
        InputStream open = u2.b(context).open(str);
        Bitmap b4 = b(open);
        open.close();
        return b4;
    }
}
