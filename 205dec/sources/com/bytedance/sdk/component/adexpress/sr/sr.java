package com.bytedance.sdk.component.adexpress.sr;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.adsdk.c.c.a;
import com.bytedance.sdk.component.adexpress.widget.GifView;
import com.bytedance.sdk.component.utils.gd;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr {

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f29395c = c("VP8X");

    private static byte[] c(String str) {
        try {
            return str.getBytes("ASCII");
        } catch (UnsupportedEncodingException unused) {
            return new byte[1];
        }
    }

    private static void sr(ImageView imageView, byte[] bArr, int i4, int i5) {
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                Drawable decodeDrawable = ImageDecoder.decodeDrawable(ImageDecoder.createSource(wrap));
                if (decodeDrawable instanceof AnimatedImageDrawable) {
                    ((AnimatedImageDrawable) decodeDrawable).start();
                }
                imageView.setImageDrawable(decodeDrawable);
                return;
            } catch (IOException e4) {
                e4.printStackTrace();
                return;
            }
        }
        xv(imageView, bArr, i4, i5);
    }

    private static void w(ImageView imageView, byte[] bArr, int i4, int i5) {
        if (c(bArr)) {
            imageView.setImageDrawable(a.i(ByteBuffer.wrap(bArr)));
        } else {
            xv(imageView, bArr, i4, i5);
        }
    }

    private static void xv(ImageView imageView, byte[] bArr, int i4, int i5) {
        Bitmap c4 = new com.bytedance.sdk.component.ux.xv.w.c(i4, i5, imageView.getScaleType(), Bitmap.Config.RGB_565, i4, i5).c(bArr);
        if (c4 != null) {
            imageView.setImageBitmap(c4);
        }
    }

    public static boolean c(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return false;
        }
        String str = new String(bArr);
        return str.substring(0, str.indexOf("IDAT")).indexOf("acTL") > 0;
    }

    public static void c(ImageView imageView, byte[] bArr, int i4, int i5) {
        try {
            if (imageView instanceof GifView) {
                ((GifView) imageView).c(bArr, false);
            } else if (TextUtils.equals("png", gd.c(Arrays.copyOfRange(bArr, 0, gd.c())))) {
                w(imageView, bArr, i4, i5);
            } else if (c(bArr, 0)) {
                sr(imageView, bArr, i4, i5);
            } else {
                xv(imageView, bArr, i4, i5);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.a.w("ImageLoadUtils", th.getMessage());
        }
    }

    public static boolean c(byte[] bArr, int i4) {
        try {
            boolean c4 = c(bArr, i4 + 12, f29395c);
            int i5 = i4 + 20;
            if (bArr.length <= i5) {
                return false;
            }
            return c4 && ((bArr[i5] & 2) == 2);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    private static boolean c(byte[] bArr, int i4, byte[] bArr2) {
        if (bArr2 == null || bArr == null || bArr2.length + i4 > bArr.length) {
            return false;
        }
        for (int i5 = 0; i5 < bArr2.length; i5++) {
            if (bArr[i5 + i4] != bArr2[i5]) {
                return false;
            }
        }
        return true;
    }
}
