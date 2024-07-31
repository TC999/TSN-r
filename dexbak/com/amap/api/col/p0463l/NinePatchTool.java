package com.amap.api.col.p0463l;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.UByte;

/* renamed from: com.amap.api.col.3l.p2 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class NinePatchTool {
    /* renamed from: a */
    private static int m54220a(byte[] bArr, int i) {
        byte b = bArr[i + 0];
        byte b2 = bArr[i + 1];
        byte b3 = bArr[i + 2];
        return (bArr[i + 3] << BinaryMemcacheOpcodes.FLUSHQ) | (b & UByte.f41242c) | (b2 << 8) | (b3 << 16);
    }

    /* renamed from: b */
    private static Bitmap m54219b(InputStream inputStream) throws Exception {
        Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
        byte[] m54213h = m54213h(decodeStream);
        if (NinePatch.isNinePatchChunk(m54213h)) {
            Bitmap createBitmap = Bitmap.createBitmap(decodeStream, 1, 1, decodeStream.getWidth() - 2, decodeStream.getHeight() - 2);
            C1732a3.m55743B(decodeStream);
            if (Build.VERSION.SDK_INT >= 28) {
                Method declaredMethod = createBitmap.getClass().getDeclaredMethod("setNinePatchChunk", byte[].class);
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(createBitmap, m54213h);
            } else {
                Field declaredField = createBitmap.getClass().getDeclaredField("mNinePatchChunk");
                declaredField.setAccessible(true);
                declaredField.set(createBitmap, m54213h);
            }
            return createBitmap;
        }
        return decodeStream;
    }

    /* renamed from: c */
    public static Drawable m54218c(Context context, String str) throws Exception {
        Bitmap m54212i = m54212i(context, str);
        if (m54212i.getNinePatchChunk() == null) {
            return new BitmapDrawable(context.getResources(), m54212i);
        }
        Rect rect = new Rect();
        m54214g(m54212i.getNinePatchChunk(), rect);
        return new NinePatchDrawable(context.getResources(), m54212i, m54212i.getNinePatchChunk(), rect, null);
    }

    /* renamed from: d */
    private static void m54217d(Bitmap bitmap, byte[] bArr) {
        int width = bitmap.getWidth() - 2;
        int[] iArr = new int[width];
        bitmap.getPixels(iArr, 0, width, 1, bitmap.getHeight() - 1, width, 1);
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= width) {
                break;
            } else if (-16777216 == iArr[i2]) {
                m54215f(bArr, 12, i2);
                break;
            } else {
                i2++;
            }
        }
        int i3 = width - 1;
        while (true) {
            if (i3 < 0) {
                break;
            } else if (-16777216 == iArr[i3]) {
                m54215f(bArr, 16, (width - i3) - 2);
                break;
            } else {
                i3--;
            }
        }
        int height = bitmap.getHeight() - 2;
        int[] iArr2 = new int[height];
        bitmap.getPixels(iArr2, 0, 1, bitmap.getWidth() - 1, 0, 1, height);
        while (true) {
            if (i >= height) {
                break;
            } else if (-16777216 == iArr2[i]) {
                m54215f(bArr, 20, i);
                break;
            } else {
                i++;
            }
        }
        for (int i4 = height - 1; i4 >= 0; i4--) {
            if (-16777216 == iArr2[i4]) {
                m54215f(bArr, 24, (height - i4) - 2);
                return;
            }
        }
    }

    /* renamed from: e */
    private static void m54216e(OutputStream outputStream, int i) throws IOException {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    /* renamed from: f */
    private static void m54215f(byte[] bArr, int i, int i2) {
        bArr[i + 0] = (byte) (i2 >> 0);
        bArr[i + 1] = (byte) (i2 >> 8);
        bArr[i + 2] = (byte) (i2 >> 16);
        bArr[i + 3] = (byte) (i2 >> 24);
    }

    /* renamed from: g */
    private static void m54214g(byte[] bArr, Rect rect) {
        rect.left = m54220a(bArr, 12);
        rect.right = m54220a(bArr, 16);
        rect.top = m54220a(bArr, 20);
        rect.bottom = m54220a(bArr, 24);
    }

    /* renamed from: h */
    private static byte[] m54213h(Bitmap bitmap) throws IOException {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i = 0; i < 32; i++) {
            byteArrayOutputStream.write(0);
        }
        int i2 = width - 2;
        int[] iArr = new int[i2];
        bitmap.getPixels(iArr, 0, width, 1, 0, i2, 1);
        boolean z = iArr[0] == -16777216;
        boolean z2 = iArr[i2 + (-1)] == -16777216;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            if (i3 != iArr[i5]) {
                i4++;
                m54216e(byteArrayOutputStream, i5);
                i3 = iArr[i5];
            }
        }
        if (z2) {
            i4++;
            m54216e(byteArrayOutputStream, i2);
        }
        int i6 = i4 + 1;
        if (z) {
            i6--;
        }
        if (z2) {
            i6--;
        }
        int i7 = height - 2;
        int[] iArr2 = new int[i7];
        bitmap.getPixels(iArr2, 0, 1, 0, 1, 1, i7);
        boolean z3 = iArr2[0] == -16777216;
        boolean z4 = iArr2[i7 + (-1)] == -16777216;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 0; i10 < i7; i10++) {
            if (i8 != iArr2[i10]) {
                i9++;
                m54216e(byteArrayOutputStream, i10);
                i8 = iArr2[i10];
            }
        }
        if (z4) {
            i9++;
            m54216e(byteArrayOutputStream, i7);
        }
        int i11 = i9 + 1;
        if (z3) {
            i11--;
        }
        if (z4) {
            i11--;
        }
        int i12 = 0;
        while (true) {
            int i13 = i6 * i11;
            if (i12 < i13) {
                m54216e(byteArrayOutputStream, 1);
                i12++;
            } else {
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byteArray[0] = 1;
                byteArray[1] = (byte) i4;
                byteArray[2] = (byte) i9;
                byteArray[3] = (byte) i13;
                m54217d(bitmap, byteArray);
                return byteArray;
            }
        }
    }

    /* renamed from: i */
    private static Bitmap m54212i(Context context, String str) throws Exception {
        InputStream open = ResourcesUtil.m53805b(context).open(str);
        Bitmap m54219b = m54219b(open);
        open.close();
        return m54219b;
    }
}
