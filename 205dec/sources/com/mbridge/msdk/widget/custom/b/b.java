package com.mbridge.msdk.widget.custom.b;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.widget.custom.DownloadMessageDialog;
import com.mbridge.msdk.widget.custom.baseview.MBImageView;
import java.lang.reflect.Array;

/* compiled from: FastBlurUtil.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static String f41177a = "FastBlurUtil";

    /* renamed from: b  reason: collision with root package name */
    public static int f41178b = 2048;

    /* compiled from: FastBlurUtil.java */
    /* renamed from: com.mbridge.msdk.widget.custom.b.b$2  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    final class AnonymousClass2 implements com.mbridge.msdk.foundation.same.c.c {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MBImageView f41183a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f41184b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f41185c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ImageView f41186d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ DownloadMessageDialog f41187e;

        AnonymousClass2(MBImageView mBImageView, int i4, int i5, ImageView imageView, DownloadMessageDialog downloadMessageDialog) {
            this.f41183a = mBImageView;
            this.f41184b = i4;
            this.f41185c = i5;
            this.f41186d = imageView;
            this.f41187e = downloadMessageDialog;
        }

        @Override // com.mbridge.msdk.foundation.same.c.c
        public final void onFailedLoad(String str, String str2) {
            this.f41183a.post(new Runnable() { // from class: com.mbridge.msdk.widget.custom.b.b.2.2
                @Override // java.lang.Runnable
                public final void run() {
                    ImageView imageView = AnonymousClass2.this.f41186d;
                    if (imageView != null) {
                        imageView.setBackgroundColor(Color.parseColor("#e6e6e6"));
                    }
                }
            });
        }

        @Override // com.mbridge.msdk.foundation.same.c.c
        public final void onSuccessLoad(final Bitmap bitmap, String str) {
            this.f41183a.post(new Runnable() { // from class: com.mbridge.msdk.widget.custom.b.b.2.1
                @Override // java.lang.Runnable
                public final void run() {
                    Bitmap bitmap2 = bitmap;
                    if (bitmap2 == null || bitmap2.isRecycled()) {
                        return;
                    }
                    if (bitmap.getWidth() >= bitmap.getHeight()) {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        int i4 = anonymousClass2.f41184b;
                        int i5 = anonymousClass2.f41185c;
                        if (i4 >= i5) {
                            b.a(bitmap, anonymousClass2.f41183a, i4, anonymousClass2.f41186d);
                        } else {
                            b.b(bitmap, anonymousClass2.f41183a, i5, anonymousClass2.f41186d);
                        }
                        AnonymousClass2.this.f41187e.registerOrientationListener(new DownloadMessageDialog.a() { // from class: com.mbridge.msdk.widget.custom.b.b.2.1.1
                            @Override // com.mbridge.msdk.widget.custom.DownloadMessageDialog.a
                            public final void a(int i6) {
                                if (i6 == 1) {
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    Bitmap bitmap3 = bitmap;
                                    AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                                    b.a(bitmap3, anonymousClass22.f41183a, anonymousClass22.f41184b, anonymousClass22.f41186d);
                                    return;
                                }
                                AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                                Bitmap bitmap4 = bitmap;
                                AnonymousClass2 anonymousClass23 = AnonymousClass2.this;
                                b.b(bitmap4, anonymousClass23.f41183a, anonymousClass23.f41185c, anonymousClass23.f41186d);
                            }
                        });
                        return;
                    }
                    Bitmap bitmap3 = bitmap;
                    AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                    b.c(bitmap3, anonymousClass22.f41183a, anonymousClass22.f41184b, anonymousClass22.f41186d);
                }
            });
        }
    }

    public static Bitmap a(Bitmap bitmap, int i4) {
        int[] iArr;
        int i5 = i4 <= 0 ? 10 : i4;
        int width = bitmap.getWidth() / i5;
        int height = bitmap.getHeight() / i5;
        int i6 = 0;
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, width, height, false);
        int width2 = createScaledBitmap.getWidth();
        int height2 = createScaledBitmap.getHeight();
        int i7 = width2 * height2;
        int[] iArr2 = new int[i7];
        createScaledBitmap.getPixels(iArr2, 0, width2, 0, 0, width2, height2);
        int i8 = width2 - 1;
        int i9 = height2 - 1;
        int[] iArr3 = new int[i7];
        int[] iArr4 = new int[i7];
        int[] iArr5 = new int[i7];
        int[] iArr6 = new int[Math.max(width2, height2)];
        int[] iArr7 = new int[20736];
        for (int i10 = 0; i10 < 20736; i10++) {
            iArr7[i10] = i10 / 81;
        }
        int[][] iArr8 = (int[][]) Array.newInstance(int.class, 17, 3);
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (true) {
            if (i11 >= height2) {
                break;
            }
            int i14 = -8;
            int i15 = 0;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            for (int i24 = 8; i14 <= i24; i24 = 8) {
                int i25 = iArr2[i12 + Math.min(i8, Math.max(i14, i6))];
                int[] iArr9 = iArr8[i14 + 8];
                iArr9[i6] = (i25 & 16711680) >> 16;
                iArr9[1] = (i25 & 65280) >> 8;
                iArr9[2] = i25 & 255;
                int abs = 9 - Math.abs(i14);
                i15 += iArr9[i6] * abs;
                i16 += iArr9[1] * abs;
                i17 += iArr9[2] * abs;
                if (i14 > 0) {
                    i21 += iArr9[i6];
                    i22 += iArr9[1];
                    i23 += iArr9[2];
                } else {
                    i18 += iArr9[i6];
                    i19 += iArr9[1];
                    i20 += iArr9[2];
                }
                i14++;
            }
            int i26 = 8;
            int i27 = 0;
            while (i27 < width2) {
                iArr3[i12] = iArr7[i15];
                iArr4[i12] = iArr7[i16];
                iArr5[i12] = iArr7[i17];
                int i28 = i15 - i18;
                int i29 = i16 - i19;
                int i30 = i17 - i20;
                int[] iArr10 = iArr8[((i26 - 8) + 17) % 17];
                int i31 = i18 - iArr10[i6];
                int i32 = i19 - iArr10[1];
                int i33 = i20 - iArr10[2];
                if (i11 == 0) {
                    iArr6[i27] = Math.min(i27 + 8 + 1, i8);
                }
                int i34 = iArr2[i13 + iArr6[i27]];
                iArr10[0] = (i34 & 16711680) >> 16;
                iArr10[1] = (i34 & 65280) >> 8;
                iArr10[2] = i34 & 255;
                int i35 = i21 + iArr10[0];
                int i36 = i22 + iArr10[1];
                int i37 = i23 + iArr10[2];
                i15 = i28 + i35;
                i16 = i29 + i36;
                i17 = i30 + i37;
                i26 = (i26 + 1) % 17;
                int[] iArr11 = iArr8[i26 % 17];
                i18 = i31 + iArr11[0];
                i19 = i32 + iArr11[1];
                i20 = i33 + iArr11[2];
                i21 = i35 - iArr11[0];
                i22 = i36 - iArr11[1];
                i23 = i37 - iArr11[2];
                i12++;
                i27++;
                i6 = 0;
            }
            i13 += width2;
            i11++;
            i6 = 0;
        }
        int i38 = 0;
        while (i38 < width2) {
            int i39 = (-8) * width2;
            Bitmap bitmap2 = createScaledBitmap;
            int[] iArr12 = iArr6;
            int i40 = -8;
            int i41 = 0;
            int i42 = 0;
            int i43 = 0;
            int i44 = 0;
            int i45 = 0;
            int i46 = 0;
            int i47 = 0;
            int i48 = 0;
            int i49 = 0;
            for (int i50 = 8; i40 <= i50; i50 = 8) {
                int max = Math.max(0, i39) + i38;
                int[] iArr13 = iArr8[i40 + 8];
                iArr13[0] = iArr3[max];
                iArr13[1] = iArr4[max];
                iArr13[2] = iArr5[max];
                int abs2 = 9 - Math.abs(i40);
                i41 += iArr3[max] * abs2;
                i42 += iArr4[max] * abs2;
                i43 += iArr5[max] * abs2;
                if (i40 > 0) {
                    i47 += iArr13[0];
                    i48 += iArr13[1];
                    i49 += iArr13[2];
                } else {
                    i44 += iArr13[0];
                    i45 += iArr13[1];
                    i46 += iArr13[2];
                }
                if (i40 < i9) {
                    i39 += width2;
                }
                i40++;
            }
            int i51 = i38;
            int i52 = 0;
            int i53 = 8;
            while (i52 < height2) {
                iArr2[i51] = (iArr2[i51] & (-16777216)) | (iArr7[i41] << 16) | (iArr7[i42] << 8) | iArr7[i43];
                int i54 = i41 - i44;
                int i55 = i42 - i45;
                int i56 = i43 - i46;
                int[] iArr14 = iArr8[((i53 - 8) + 17) % 17];
                int i57 = i44 - iArr14[0];
                int i58 = i45 - iArr14[1];
                int i59 = i46 - iArr14[2];
                if (i38 == 0) {
                    iArr = iArr7;
                    iArr12[i52] = Math.min(i52 + 9, i9) * width2;
                } else {
                    iArr = iArr7;
                }
                int i60 = iArr12[i52] + i38;
                iArr14[0] = iArr3[i60];
                iArr14[1] = iArr4[i60];
                iArr14[2] = iArr5[i60];
                int i61 = i47 + iArr14[0];
                int i62 = i48 + iArr14[1];
                int i63 = i49 + iArr14[2];
                i41 = i54 + i61;
                i42 = i55 + i62;
                i43 = i56 + i63;
                i53 = (i53 + 1) % 17;
                int[] iArr15 = iArr8[i53];
                i44 = i57 + iArr15[0];
                i45 = i58 + iArr15[1];
                i46 = i59 + iArr15[2];
                i47 = i61 - iArr15[0];
                i48 = i62 - iArr15[1];
                i49 = i63 - iArr15[2];
                i51 += width2;
                i52++;
                iArr7 = iArr;
            }
            i38++;
            createScaledBitmap = bitmap2;
            iArr6 = iArr12;
        }
        Bitmap bitmap3 = createScaledBitmap;
        bitmap3.setPixels(iArr2, 0, width2, 0, 0, width2, height2);
        return bitmap3;
    }

    public static void b(Bitmap bitmap, ImageView imageView, int i4, ImageView imageView2) {
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    imageView.setImageBitmap(bitmap);
                }
            } catch (Throwable th) {
                x.d(f41177a, th.getMessage());
                return;
            }
        }
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        double d4 = i4;
        Double.isNaN(d4);
        double d5 = d4 * 0.5d;
        double c4 = com.mbridge.msdk.widget.custom.a.b.a().c("20dp");
        Double.isNaN(c4);
        int i5 = (int) (d5 - c4);
        int i6 = (int) (i5 * 0.5225f);
        if (imageView2 != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView2.getLayoutParams();
            layoutParams.width = i5;
            layoutParams.height = i6;
            imageView2.setLayoutParams(layoutParams);
            a(imageView2, bitmap);
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams2.width = i5;
        layoutParams2.height = i6;
        layoutParams2.setMargins(com.mbridge.msdk.widget.custom.a.b.a().c("1dp"), com.mbridge.msdk.widget.custom.a.b.a().c("15dp"), com.mbridge.msdk.widget.custom.a.b.a().c("1dp"), com.mbridge.msdk.widget.custom.a.b.a().c("15dp"));
        layoutParams2.addRule(9, -1);
        layoutParams2.addRule(11, -1);
        imageView.setLayoutParams(layoutParams2);
    }

    public static void c(Bitmap bitmap, ImageView imageView, int i4, ImageView imageView2) {
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    imageView.setImageBitmap(bitmap);
                }
            } catch (Throwable th) {
                x.d(f41177a, th.getMessage());
                return;
            }
        }
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        int c4 = i4 - com.mbridge.msdk.widget.custom.a.b.a().c("20dp");
        int i5 = (int) (c4 * 0.5225f);
        if (imageView2 != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView2.getLayoutParams();
            layoutParams.width = c4;
            layoutParams.height = i5;
            imageView2.setLayoutParams(layoutParams);
            a(imageView2, bitmap);
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams2.height = i5;
        layoutParams2.addRule(10, -1);
        layoutParams2.addRule(12, -1);
        imageView.setLayoutParams(layoutParams2);
    }

    public static void a(final MBImageView mBImageView, String str) {
        com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.a.f().j()).a(str, new com.mbridge.msdk.foundation.same.c.c() { // from class: com.mbridge.msdk.widget.custom.b.b.1
            @Override // com.mbridge.msdk.foundation.same.c.c
            public final void onFailedLoad(String str2, String str3) {
                MBImageView.this.post(new Runnable() { // from class: com.mbridge.msdk.widget.custom.b.b.1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        MBImageView.this.setBackgroundColor(Color.parseColor("#e6e6e6"));
                    }
                });
            }

            @Override // com.mbridge.msdk.foundation.same.c.c
            public final void onSuccessLoad(final Bitmap bitmap, String str2) {
                MBImageView.this.post(new Runnable() { // from class: com.mbridge.msdk.widget.custom.b.b.1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        Bitmap bitmap2;
                        if (MBImageView.this == null || (bitmap2 = bitmap) == null || bitmap2.isRecycled()) {
                            return;
                        }
                        MBImageView.this.setImageBitmap(bitmap);
                    }
                });
            }
        });
    }

    public static void a(MBImageView mBImageView, ImageView imageView, String str, int i4, int i5, DownloadMessageDialog downloadMessageDialog) {
        com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.a.f().j()).a(str, new AnonymousClass2(mBImageView, i4, i5, imageView, downloadMessageDialog));
    }

    private static void a(ImageView imageView, Bitmap bitmap) {
        if (bitmap != null) {
            try {
                if (bitmap.isRecycled()) {
                    return;
                }
                Bitmap a4 = a(bitmap, 5);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setImageBitmap(a4);
            } catch (Throwable th) {
                x.d(f41177a, th.getMessage());
            }
        }
    }

    public static void a(Bitmap bitmap, ImageView imageView, int i4, ImageView imageView2) {
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    imageView.setImageBitmap(bitmap);
                }
            } catch (Throwable th) {
                x.d(f41177a, th.getMessage());
                return;
            }
        }
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        int c4 = i4 - com.mbridge.msdk.widget.custom.a.b.a().c("20dp");
        int i5 = (int) (c4 * 0.5225f);
        if (imageView2 != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView2.getLayoutParams();
            layoutParams.width = c4;
            layoutParams.height = i5;
            imageView2.setLayoutParams(layoutParams);
            a(imageView2, bitmap);
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams2.width = c4;
        layoutParams2.height = i5;
        layoutParams2.setMargins(com.mbridge.msdk.widget.custom.a.b.a().c("1dp"), com.mbridge.msdk.widget.custom.a.b.a().c("15dp"), com.mbridge.msdk.widget.custom.a.b.a().c("1dp"), com.mbridge.msdk.widget.custom.a.b.a().c("15dp"));
        layoutParams2.addRule(9, -1);
        layoutParams2.addRule(11, -1);
        imageView.setLayoutParams(layoutParams2);
    }
}
