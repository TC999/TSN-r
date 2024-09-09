package com.bytedance.sdk.component.ux.xv.w;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    public static final ImageView.ScaleType f30314c = ImageView.ScaleType.CENTER_INSIDE;

    /* renamed from: w  reason: collision with root package name */
    public static final Bitmap.Config f30315w = Bitmap.Config.ARGB_4444;
    private final ImageView.ScaleType ev;

    /* renamed from: f  reason: collision with root package name */
    private final int f30316f;
    private final int gd = 3840;

    /* renamed from: p  reason: collision with root package name */
    private final int f30317p = 104857600;

    /* renamed from: r  reason: collision with root package name */
    private final int f30318r;
    private int sr;
    private int ux;
    private final Bitmap.Config xv;

    public c(int i4, int i5, ImageView.ScaleType scaleType, Bitmap.Config config, int i6, int i7) {
        this.xv = config;
        this.sr = i4;
        this.ux = i5;
        this.ev = scaleType;
        this.f30316f = i6;
        this.f30318r = i7;
        c(i4, i5);
    }

    static int c(int i4, int i5, int i6, int i7, int i8, int i9) {
        double d4 = i4;
        double d5 = i6;
        Double.isNaN(d4);
        Double.isNaN(d5);
        double d6 = d4 / d5;
        double d7 = i5;
        double d8 = i7;
        Double.isNaN(d7);
        Double.isNaN(d8);
        double min = Math.min(d6, d7 / d8);
        if (i8 > 0 && i9 > 0) {
            double max = Math.max(i4, i5);
            double max2 = Math.max(i8, i9);
            Double.isNaN(max);
            Double.isNaN(max2);
            double min2 = Math.min(i4, i5);
            double min3 = Math.min(i8, i9);
            Double.isNaN(min2);
            Double.isNaN(min3);
            min = Math.max(min, Math.min(max / max2, min2 / min3));
        }
        float f4 = 1.0f;
        while (true) {
            float f5 = 2.0f * f4;
            if (f5 > min) {
                return (int) f4;
            }
            f4 = f5;
        }
    }

    private static int c(int i4, int i5, int i6, int i7, ImageView.ScaleType scaleType) {
        if (i4 == 0 && i5 == 0) {
            return i6;
        }
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            return i4 == 0 ? i6 : i4;
        } else if (i4 == 0) {
            double d4 = i5;
            double d5 = i7;
            Double.isNaN(d4);
            Double.isNaN(d5);
            double d6 = i6;
            Double.isNaN(d6);
            return (int) (d6 * (d4 / d5));
        } else if (i5 == 0) {
            return i4;
        } else {
            double d7 = i7;
            double d8 = i6;
            Double.isNaN(d7);
            Double.isNaN(d8);
            double d9 = d7 / d8;
            if (scaleType == ImageView.ScaleType.CENTER_CROP) {
                double d10 = i4;
                Double.isNaN(d10);
                double d11 = i5;
                if (d10 * d9 < d11) {
                    Double.isNaN(d11);
                    return (int) (d11 / d9);
                }
                return i4;
            }
            double d12 = i4;
            Double.isNaN(d12);
            double d13 = i5;
            if (d12 * d9 > d13) {
                Double.isNaN(d13);
                return (int) (d13 / d9);
            }
            return i4;
        }
    }

    public Bitmap c(byte[] bArr) {
        Bitmap decodeByteArray;
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.sr == 0 && this.ux == 0) {
            options.inPreferredConfig = this.xv;
            decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i4 = options.outWidth;
            int i5 = options.outHeight;
            int c4 = c(this.sr, this.ux, i4, i5, this.ev);
            int c5 = c(this.ux, this.sr, i5, i4, this.ev);
            options.inJustDecodeBounds = false;
            options.inSampleSize = c(i4, i5, c4, c5, this.f30316f, this.f30318r);
            decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (decodeByteArray != null && (decodeByteArray.getWidth() > c4 || decodeByteArray.getHeight() > c5)) {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeByteArray, c4, c5, true);
                if (createScaledBitmap != decodeByteArray) {
                    decodeByteArray.recycle();
                }
                decodeByteArray = createScaledBitmap;
            }
        }
        if (decodeByteArray != null && decodeByteArray.getByteCount() > 104857600) {
            int width = decodeByteArray.getWidth() / 2;
            int height = decodeByteArray.getHeight() / 2;
            if (width > 0 && height > 0) {
                Bitmap createScaledBitmap2 = Bitmap.createScaledBitmap(decodeByteArray, width, height, true);
                if (createScaledBitmap2 != decodeByteArray) {
                    decodeByteArray.recycle();
                }
                return createScaledBitmap2;
            }
        }
        return decodeByteArray;
    }

    private void c(int i4, int i5) {
        if (i4 > 3840 && i5 > 3840) {
            if (i4 > i5) {
                this.sr = 3840;
                this.ux = (i5 * 3840) / i4;
                return;
            }
            this.sr = (i4 * 3840) / i5;
            this.ux = 3840;
        } else if (i4 > 3840) {
            this.sr = 3840;
            this.ux = (i5 * 3840) / i4;
        } else if (i5 > 3840) {
            this.sr = (i4 * 3840) / i5;
            this.ux = 3840;
        }
    }
}
