package com.mbridge.msdk.widget.custom.p517b;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.same.p476c.CommonImageLoader;
import com.mbridge.msdk.foundation.same.p476c.CommonImageLoaderListener;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.widget.custom.DownloadMessageDialog;
import com.mbridge.msdk.widget.custom.baseview.MBImageView;
import com.mbridge.msdk.widget.custom.p516a.MBResource;
import java.lang.reflect.Array;

/* renamed from: com.mbridge.msdk.widget.custom.b.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class FastBlurUtil {

    /* renamed from: a */
    public static String f32488a = "FastBlurUtil";

    /* renamed from: b */
    public static int f32489b = 2048;

    /* compiled from: FastBlurUtil.java */
    /* renamed from: com.mbridge.msdk.widget.custom.b.b$2 */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    final class C117502 implements CommonImageLoaderListener {

        /* renamed from: a */
        final /* synthetic */ MBImageView f32494a;

        /* renamed from: b */
        final /* synthetic */ int f32495b;

        /* renamed from: c */
        final /* synthetic */ int f32496c;

        /* renamed from: d */
        final /* synthetic */ ImageView f32497d;

        /* renamed from: e */
        final /* synthetic */ DownloadMessageDialog f32498e;

        C117502(MBImageView mBImageView, int i, int i2, ImageView imageView, DownloadMessageDialog downloadMessageDialog) {
            this.f32494a = mBImageView;
            this.f32495b = i;
            this.f32496c = i2;
            this.f32497d = imageView;
            this.f32498e = downloadMessageDialog;
        }

        @Override // com.mbridge.msdk.foundation.same.p476c.CommonImageLoaderListener
        public final void onFailedLoad(String str, String str2) {
            this.f32494a.post(new Runnable() { // from class: com.mbridge.msdk.widget.custom.b.b.2.2
                @Override // java.lang.Runnable
                public final void run() {
                    ImageView imageView = C117502.this.f32497d;
                    if (imageView != null) {
                        imageView.setBackgroundColor(Color.parseColor("#e6e6e6"));
                    }
                }
            });
        }

        @Override // com.mbridge.msdk.foundation.same.p476c.CommonImageLoaderListener
        public final void onSuccessLoad(final Bitmap bitmap, String str) {
            this.f32494a.post(new Runnable() { // from class: com.mbridge.msdk.widget.custom.b.b.2.1
                @Override // java.lang.Runnable
                public final void run() {
                    Bitmap bitmap2 = bitmap;
                    if (bitmap2 == null || bitmap2.isRecycled()) {
                        return;
                    }
                    if (bitmap.getWidth() >= bitmap.getHeight()) {
                        C117502 c117502 = C117502.this;
                        int i = c117502.f32495b;
                        int i2 = c117502.f32496c;
                        if (i >= i2) {
                            FastBlurUtil.m20575a(bitmap, c117502.f32494a, i, c117502.f32497d);
                        } else {
                            FastBlurUtil.m20571b(bitmap, c117502.f32494a, i2, c117502.f32497d);
                        }
                        C117502.this.f32498e.registerOrientationListener(new DownloadMessageDialog.InterfaceC11738a() { // from class: com.mbridge.msdk.widget.custom.b.b.2.1.1
                            @Override // com.mbridge.msdk.widget.custom.DownloadMessageDialog.InterfaceC11738a
                            /* renamed from: a */
                            public final void mo20569a(int i3) {
                                if (i3 == 1) {
                                    RunnableC117511 runnableC117511 = RunnableC117511.this;
                                    Bitmap bitmap3 = bitmap;
                                    C117502 c1175022 = C117502.this;
                                    FastBlurUtil.m20575a(bitmap3, c1175022.f32494a, c1175022.f32495b, c1175022.f32497d);
                                    return;
                                }
                                RunnableC117511 runnableC1175112 = RunnableC117511.this;
                                Bitmap bitmap4 = bitmap;
                                C117502 c1175023 = C117502.this;
                                FastBlurUtil.m20571b(bitmap4, c1175023.f32494a, c1175023.f32496c, c1175023.f32497d);
                            }
                        });
                        return;
                    }
                    Bitmap bitmap3 = bitmap;
                    C117502 c1175022 = C117502.this;
                    FastBlurUtil.m20570c(bitmap3, c1175022.f32494a, c1175022.f32495b, c1175022.f32497d);
                }
            });
        }
    }

    /* renamed from: a */
    public static Bitmap m20576a(Bitmap bitmap, int i) {
        int[] iArr;
        int i2 = i <= 0 ? 10 : i;
        int width = bitmap.getWidth() / i2;
        int height = bitmap.getHeight() / i2;
        int i3 = 0;
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, width, height, false);
        int width2 = createScaledBitmap.getWidth();
        int height2 = createScaledBitmap.getHeight();
        int i4 = width2 * height2;
        int[] iArr2 = new int[i4];
        createScaledBitmap.getPixels(iArr2, 0, width2, 0, 0, width2, height2);
        int i5 = width2 - 1;
        int i6 = height2 - 1;
        int[] iArr3 = new int[i4];
        int[] iArr4 = new int[i4];
        int[] iArr5 = new int[i4];
        int[] iArr6 = new int[Math.max(width2, height2)];
        int[] iArr7 = new int[20736];
        for (int i7 = 0; i7 < 20736; i7++) {
            iArr7[i7] = i7 / 81;
        }
        int[][] iArr8 = (int[][]) Array.newInstance(int.class, 17, 3);
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (true) {
            if (i8 >= height2) {
                break;
            }
            int i11 = -8;
            int i12 = 0;
            int i13 = 0;
            int i14 = 0;
            int i15 = 0;
            int i16 = 0;
            int i17 = 0;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            for (int i21 = 8; i11 <= i21; i21 = 8) {
                int i22 = iArr2[i9 + Math.min(i5, Math.max(i11, i3))];
                int[] iArr9 = iArr8[i11 + 8];
                iArr9[i3] = (i22 & 16711680) >> 16;
                iArr9[1] = (i22 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr9[2] = i22 & 255;
                int abs = 9 - Math.abs(i11);
                i12 += iArr9[i3] * abs;
                i13 += iArr9[1] * abs;
                i14 += iArr9[2] * abs;
                if (i11 > 0) {
                    i18 += iArr9[i3];
                    i19 += iArr9[1];
                    i20 += iArr9[2];
                } else {
                    i15 += iArr9[i3];
                    i16 += iArr9[1];
                    i17 += iArr9[2];
                }
                i11++;
            }
            int i23 = 8;
            int i24 = 0;
            while (i24 < width2) {
                iArr3[i9] = iArr7[i12];
                iArr4[i9] = iArr7[i13];
                iArr5[i9] = iArr7[i14];
                int i25 = i12 - i15;
                int i26 = i13 - i16;
                int i27 = i14 - i17;
                int[] iArr10 = iArr8[((i23 - 8) + 17) % 17];
                int i28 = i15 - iArr10[i3];
                int i29 = i16 - iArr10[1];
                int i30 = i17 - iArr10[2];
                if (i8 == 0) {
                    iArr6[i24] = Math.min(i24 + 8 + 1, i5);
                }
                int i31 = iArr2[i10 + iArr6[i24]];
                iArr10[0] = (i31 & 16711680) >> 16;
                iArr10[1] = (i31 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr10[2] = i31 & 255;
                int i32 = i18 + iArr10[0];
                int i33 = i19 + iArr10[1];
                int i34 = i20 + iArr10[2];
                i12 = i25 + i32;
                i13 = i26 + i33;
                i14 = i27 + i34;
                i23 = (i23 + 1) % 17;
                int[] iArr11 = iArr8[i23 % 17];
                i15 = i28 + iArr11[0];
                i16 = i29 + iArr11[1];
                i17 = i30 + iArr11[2];
                i18 = i32 - iArr11[0];
                i19 = i33 - iArr11[1];
                i20 = i34 - iArr11[2];
                i9++;
                i24++;
                i3 = 0;
            }
            i10 += width2;
            i8++;
            i3 = 0;
        }
        int i35 = 0;
        while (i35 < width2) {
            int i36 = (-8) * width2;
            Bitmap bitmap2 = createScaledBitmap;
            int[] iArr12 = iArr6;
            int i37 = -8;
            int i38 = 0;
            int i39 = 0;
            int i40 = 0;
            int i41 = 0;
            int i42 = 0;
            int i43 = 0;
            int i44 = 0;
            int i45 = 0;
            int i46 = 0;
            for (int i47 = 8; i37 <= i47; i47 = 8) {
                int max = Math.max(0, i36) + i35;
                int[] iArr13 = iArr8[i37 + 8];
                iArr13[0] = iArr3[max];
                iArr13[1] = iArr4[max];
                iArr13[2] = iArr5[max];
                int abs2 = 9 - Math.abs(i37);
                i38 += iArr3[max] * abs2;
                i39 += iArr4[max] * abs2;
                i40 += iArr5[max] * abs2;
                if (i37 > 0) {
                    i44 += iArr13[0];
                    i45 += iArr13[1];
                    i46 += iArr13[2];
                } else {
                    i41 += iArr13[0];
                    i42 += iArr13[1];
                    i43 += iArr13[2];
                }
                if (i37 < i6) {
                    i36 += width2;
                }
                i37++;
            }
            int i48 = i35;
            int i49 = 0;
            int i50 = 8;
            while (i49 < height2) {
                iArr2[i48] = (iArr2[i48] & ViewCompat.MEASURED_STATE_MASK) | (iArr7[i38] << 16) | (iArr7[i39] << 8) | iArr7[i40];
                int i51 = i38 - i41;
                int i52 = i39 - i42;
                int i53 = i40 - i43;
                int[] iArr14 = iArr8[((i50 - 8) + 17) % 17];
                int i54 = i41 - iArr14[0];
                int i55 = i42 - iArr14[1];
                int i56 = i43 - iArr14[2];
                if (i35 == 0) {
                    iArr = iArr7;
                    iArr12[i49] = Math.min(i49 + 9, i6) * width2;
                } else {
                    iArr = iArr7;
                }
                int i57 = iArr12[i49] + i35;
                iArr14[0] = iArr3[i57];
                iArr14[1] = iArr4[i57];
                iArr14[2] = iArr5[i57];
                int i58 = i44 + iArr14[0];
                int i59 = i45 + iArr14[1];
                int i60 = i46 + iArr14[2];
                i38 = i51 + i58;
                i39 = i52 + i59;
                i40 = i53 + i60;
                i50 = (i50 + 1) % 17;
                int[] iArr15 = iArr8[i50];
                i41 = i54 + iArr15[0];
                i42 = i55 + iArr15[1];
                i43 = i56 + iArr15[2];
                i44 = i58 - iArr15[0];
                i45 = i59 - iArr15[1];
                i46 = i60 - iArr15[2];
                i48 += width2;
                i49++;
                iArr7 = iArr;
            }
            i35++;
            createScaledBitmap = bitmap2;
            iArr6 = iArr12;
        }
        Bitmap bitmap3 = createScaledBitmap;
        bitmap3.setPixels(iArr2, 0, width2, 0, 0, width2, height2);
        return bitmap3;
    }

    /* renamed from: b */
    public static void m20571b(Bitmap bitmap, ImageView imageView, int i, ImageView imageView2) {
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    imageView.setImageBitmap(bitmap);
                }
            } catch (Throwable th) {
                SameLogTool.m21733d(f32488a, th.getMessage());
                return;
            }
        }
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        double d = i;
        Double.isNaN(d);
        double d2 = d * 0.5d;
        double m20594c = MBResource.m20600a().m20594c("20dp");
        Double.isNaN(m20594c);
        int i2 = (int) (d2 - m20594c);
        int i3 = (int) (i2 * 0.5225f);
        if (imageView2 != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView2.getLayoutParams();
            layoutParams.width = i2;
            layoutParams.height = i3;
            imageView2.setLayoutParams(layoutParams);
            m20574a(imageView2, bitmap);
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams2.width = i2;
        layoutParams2.height = i3;
        layoutParams2.setMargins(MBResource.m20600a().m20594c("1dp"), MBResource.m20600a().m20594c("15dp"), MBResource.m20600a().m20594c("1dp"), MBResource.m20600a().m20594c("15dp"));
        layoutParams2.addRule(9, -1);
        layoutParams2.addRule(11, -1);
        imageView.setLayoutParams(layoutParams2);
    }

    /* renamed from: c */
    public static void m20570c(Bitmap bitmap, ImageView imageView, int i, ImageView imageView2) {
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    imageView.setImageBitmap(bitmap);
                }
            } catch (Throwable th) {
                SameLogTool.m21733d(f32488a, th.getMessage());
                return;
            }
        }
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        int m20594c = i - MBResource.m20600a().m20594c("20dp");
        int i2 = (int) (m20594c * 0.5225f);
        if (imageView2 != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView2.getLayoutParams();
            layoutParams.width = m20594c;
            layoutParams.height = i2;
            imageView2.setLayoutParams(layoutParams);
            m20574a(imageView2, bitmap);
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams2.height = i2;
        layoutParams2.addRule(10, -1);
        layoutParams2.addRule(12, -1);
        imageView.setLayoutParams(layoutParams2);
    }

    /* renamed from: a */
    public static void m20572a(final MBImageView mBImageView, String str) {
        CommonImageLoader.m22343a(MBSDKContext.m22865f().m22861j()).m22339a(str, new CommonImageLoaderListener() { // from class: com.mbridge.msdk.widget.custom.b.b.1
            @Override // com.mbridge.msdk.foundation.same.p476c.CommonImageLoaderListener
            public final void onFailedLoad(String str2, String str3) {
                MBImageView.this.post(new Runnable() { // from class: com.mbridge.msdk.widget.custom.b.b.1.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        MBImageView.this.setBackgroundColor(Color.parseColor("#e6e6e6"));
                    }
                });
            }

            @Override // com.mbridge.msdk.foundation.same.p476c.CommonImageLoaderListener
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

    /* renamed from: a */
    public static void m20573a(MBImageView mBImageView, ImageView imageView, String str, int i, int i2, DownloadMessageDialog downloadMessageDialog) {
        CommonImageLoader.m22343a(MBSDKContext.m22865f().m22861j()).m22339a(str, new C117502(mBImageView, i, i2, imageView, downloadMessageDialog));
    }

    /* renamed from: a */
    private static void m20574a(ImageView imageView, Bitmap bitmap) {
        if (bitmap != null) {
            try {
                if (bitmap.isRecycled()) {
                    return;
                }
                Bitmap m20576a = m20576a(bitmap, 5);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setImageBitmap(m20576a);
            } catch (Throwable th) {
                SameLogTool.m21733d(f32488a, th.getMessage());
            }
        }
    }

    /* renamed from: a */
    public static void m20575a(Bitmap bitmap, ImageView imageView, int i, ImageView imageView2) {
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    imageView.setImageBitmap(bitmap);
                }
            } catch (Throwable th) {
                SameLogTool.m21733d(f32488a, th.getMessage());
                return;
            }
        }
        imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        int m20594c = i - MBResource.m20600a().m20594c("20dp");
        int i2 = (int) (m20594c * 0.5225f);
        if (imageView2 != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) imageView2.getLayoutParams();
            layoutParams.width = m20594c;
            layoutParams.height = i2;
            imageView2.setLayoutParams(layoutParams);
            m20574a(imageView2, bitmap);
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams2.width = m20594c;
        layoutParams2.height = i2;
        layoutParams2.setMargins(MBResource.m20600a().m20594c("1dp"), MBResource.m20600a().m20594c("15dp"), MBResource.m20600a().m20594c("1dp"), MBResource.m20600a().m20594c("15dp"));
        layoutParams2.addRule(9, -1);
        layoutParams2.addRule(11, -1);
        imageView.setLayoutParams(layoutParams2);
    }
}
