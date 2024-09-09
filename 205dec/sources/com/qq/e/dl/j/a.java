package com.qq.e.dl.j;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static RectF f46992a = new RectF();

    /* renamed from: b  reason: collision with root package name */
    private static Path f46993b = new Path();

    public static void a(Canvas canvas, Paint paint, int i4, int i5, int i6, int[] iArr) {
        if (canvas == null || paint == null) {
            return;
        }
        if (i6 == 0 && (iArr == null || iArr.length < 4)) {
            canvas.drawPaint(paint);
        } else if (iArr != null && iArr.length >= 4) {
            a(canvas, paint, i4, i5, i6, iArr[0], iArr[1], iArr[3], iArr[2]);
        } else {
            a(canvas, paint, i4, i5, i6, 0.0f, 0.0f, 0.0f, 0.0f);
        }
    }

    public static void b(Canvas canvas, Paint paint, int i4, int i5, int i6, int[] iArr) {
        int i7;
        int i8;
        int i9;
        int i10;
        if (i6 == 0) {
            return;
        }
        int i11 = 0;
        if (iArr == null || iArr.length < 4) {
            i7 = i4;
            i8 = 0;
            i9 = 0;
            i10 = 0;
        } else {
            int i12 = iArr[0];
            i9 = iArr[1];
            int i13 = iArr[2];
            i8 = iArr[3];
            i7 = i4;
            i10 = i12;
            i11 = i13;
        }
        b(canvas, paint, i7, i5, i6, i10, i9, i8, i11);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(android.graphics.Canvas r13, android.graphics.Paint r14, float r15, float r16, float r17, float r18, float r19, float r20, float r21) {
        /*
            Method dump skipped, instructions count: 308
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.dl.j.a.b(android.graphics.Canvas, android.graphics.Paint, float, float, float, float, float, float, float):void");
    }

    public static void a(Canvas canvas, Paint paint, float f4, float f5, float f6, float f7, float f8, float f9, float f10) {
        if (canvas == null || paint == null) {
            return;
        }
        if (f7 < 0.0f) {
            f7 = 0.0f;
        }
        if (f8 < 0.0f) {
            f8 = 0.0f;
        }
        if (f9 < 0.0f) {
            f9 = 0.0f;
        }
        if (f10 < 0.0f) {
            f10 = 0.0f;
        }
        if (f6 > 0.0f) {
            f6 -= 1.0f;
        }
        f46993b.reset();
        f46993b.moveTo(f7, f6);
        f46993b.lineTo(f4 - f8, f6);
        if (f8 > 0.0f) {
            float f11 = (f8 - f6) * 2.0f;
            f46992a.set(f4 - f11, 0.0f, f4, f11);
            f46992a.offset(-f6, f6);
            f46993b.arcTo(f46992a, 270.0f, 90.0f);
        }
        f46993b.lineTo(f4 - f6, f5 - f10);
        if (f10 > 0.0f) {
            float f12 = (f10 - f6) * 2.0f;
            f46992a.set(f4 - f12, f5 - f12, f4, f5);
            float f13 = -f6;
            f46992a.offset(f13, f13);
            f46993b.arcTo(f46992a, 0.0f, 90.0f);
        }
        f46993b.lineTo(f9, f5 - f6);
        if (f9 > 0.0f) {
            float f14 = (f9 - f6) * 2.0f;
            f46992a.set(0.0f, f5 - f14, f14, f5);
            f46992a.offset(f6, -f6);
            f46993b.arcTo(f46992a, 90.0f, 90.0f);
        }
        f46993b.lineTo(f6, f7);
        if (f7 > 0.0f) {
            float f15 = (f7 - f6) * 2.0f;
            f46992a.set(0.0f, 0.0f, f15, f15);
            f46992a.offset(f6, f6);
            f46993b.arcTo(f46992a, 180.0f, 90.0f);
        }
        canvas.drawPath(f46993b, paint);
    }

    public static void a(Canvas canvas, int i4, int i5, int i6, int[] iArr) {
        if (iArr == null || iArr.length < 4) {
            return;
        }
        a(canvas, i4, i5, i6, iArr[0], iArr[1], iArr[3], iArr[2]);
    }

    public static void a(Canvas canvas, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        if (canvas == null) {
            return;
        }
        if (i7 < 0) {
            i7 = 0;
        }
        if (i8 < 0) {
            i8 = 0;
        }
        if (i9 < 0) {
            i9 = 0;
        }
        if (i10 < 0) {
            i10 = 0;
        }
        if (i7 == 0 && i8 == 0 && i9 == 0 && i10 == 0) {
            return;
        }
        f46993b.reset();
        float f4 = i7;
        f46993b.moveTo(f4, 0.0f);
        f46993b.lineTo(i4 - i8, 0.0f);
        if (i8 > 0) {
            float f5 = i8 * 2;
            float f6 = i4;
            f46992a.set(f6 - f5, 0.0f, f6, f5);
            f46993b.arcTo(f46992a, 270.0f, 90.0f);
        }
        float f7 = i4;
        f46993b.lineTo(f7, i5 - i10);
        if (i10 > 0) {
            float f8 = i10 * 2;
            float f9 = i5;
            f46992a.set(f7 - f8, f9 - f8, f7, f9);
            f46993b.arcTo(f46992a, 0.0f, 90.0f);
        }
        float f10 = i5;
        f46993b.lineTo(i9, f10);
        if (i9 > 0) {
            float f11 = i9 * 2;
            f46992a.set(0.0f, f10 - f11, f11, f10);
            f46993b.arcTo(f46992a, 90.0f, 90.0f);
        }
        f46993b.lineTo(0.0f, f4);
        if (i7 > 0) {
            float f12 = i7 * 2;
            f46992a.set(0.0f, 0.0f, f12, f12);
            f46993b.arcTo(f46992a, 180.0f, 90.0f);
        }
        canvas.clipPath(f46993b);
    }
}
