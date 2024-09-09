package com.bumptech.glide.util;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: Util.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class k {

    /* renamed from: a  reason: collision with root package name */
    private static final int f18080a = 31;

    /* renamed from: b  reason: collision with root package name */
    private static final int f18081b = 17;

    /* renamed from: c  reason: collision with root package name */
    private static final char[] f18082c = "0123456789abcdef".toCharArray();

    /* renamed from: d  reason: collision with root package name */
    private static final char[] f18083d = new char[64];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: Util.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f18084a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f18084a = iArr;
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f18084a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f18084a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f18084a[Bitmap.Config.RGBA_F16.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f18084a[Bitmap.Config.ARGB_8888.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private k() {
    }

    public static void a() {
        if (!s()) {
            throw new IllegalArgumentException("You must call this method on a background thread");
        }
    }

    public static void b() {
        if (!t()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static boolean c(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null) {
            return obj2 == null;
        } else if (obj instanceof com.bumptech.glide.load.model.l) {
            return ((com.bumptech.glide.load.model.l) obj).a(obj2);
        } else {
            return obj.equals(obj2);
        }
    }

    public static boolean d(@Nullable Object obj, @Nullable Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    @NonNull
    private static String e(@NonNull byte[] bArr, @NonNull char[] cArr) {
        for (int i4 = 0; i4 < bArr.length; i4++) {
            int i5 = bArr[i4] & 255;
            int i6 = i4 * 2;
            char[] cArr2 = f18082c;
            cArr[i6] = cArr2[i5 >>> 4];
            cArr[i6 + 1] = cArr2[i5 & 15];
        }
        return new String(cArr);
    }

    @NonNull
    public static <T> Queue<T> f(int i4) {
        return new ArrayDeque(i4);
    }

    public static int g(int i4, int i5, @Nullable Bitmap.Config config) {
        return i4 * i5 * i(config);
    }

    @TargetApi(19)
    public static int h(@NonNull Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            if (Build.VERSION.SDK_INT >= 19) {
                try {
                    return bitmap.getAllocationByteCount();
                } catch (NullPointerException unused) {
                }
            }
            return bitmap.getHeight() * bitmap.getRowBytes();
        }
        throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig());
    }

    private static int i(@Nullable Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i4 = a.f18084a[config.ordinal()];
        if (i4 != 1) {
            if (i4 == 2 || i4 == 3) {
                return 2;
            }
            return i4 != 4 ? 4 : 8;
        }
        return 1;
    }

    @Deprecated
    public static int j(@NonNull Bitmap bitmap) {
        return h(bitmap);
    }

    @NonNull
    public static <T> List<T> k(@NonNull Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (T t3 : collection) {
            if (t3 != null) {
                arrayList.add(t3);
            }
        }
        return arrayList;
    }

    public static int l(float f4) {
        return m(f4, 17);
    }

    public static int m(float f4, int i4) {
        return o(Float.floatToIntBits(f4), i4);
    }

    public static int n(int i4) {
        return o(i4, 17);
    }

    public static int o(int i4, int i5) {
        return (i5 * 31) + i4;
    }

    public static int p(@Nullable Object obj, int i4) {
        return o(obj == null ? 0 : obj.hashCode(), i4);
    }

    public static int q(boolean z3) {
        return r(z3, 17);
    }

    public static int r(boolean z3, int i4) {
        return o(z3 ? 1 : 0, i4);
    }

    public static boolean s() {
        return !t();
    }

    public static boolean t() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    private static boolean u(int i4) {
        return i4 > 0 || i4 == Integer.MIN_VALUE;
    }

    public static boolean v(int i4, int i5) {
        return u(i4) && u(i5);
    }

    @NonNull
    public static String w(@NonNull byte[] bArr) {
        String e4;
        char[] cArr = f18083d;
        synchronized (cArr) {
            e4 = e(bArr, cArr);
        }
        return e4;
    }
}
