package com.bumptech.glide.util;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.model.Model;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
import kotlin.UByte;

/* compiled from: Util.java */
/* renamed from: com.bumptech.glide.util.k */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C3771k {

    /* renamed from: a */
    private static final int f14562a = 31;

    /* renamed from: b */
    private static final int f14563b = 17;

    /* renamed from: c */
    private static final char[] f14564c = "0123456789abcdef".toCharArray();

    /* renamed from: d */
    private static final char[] f14565d = new char[64];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Util.java */
    /* renamed from: com.bumptech.glide.util.k$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static /* synthetic */ class C3772a {

        /* renamed from: a */
        static final /* synthetic */ int[] f14566a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f14566a = iArr;
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14566a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14566a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14566a[Bitmap.Config.RGBA_F16.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f14566a[Bitmap.Config.ARGB_8888.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private C3771k() {
    }

    /* renamed from: a */
    public static void m44390a() {
        if (!m44372s()) {
            throw new IllegalArgumentException("You must call this method on a background thread");
        }
    }

    /* renamed from: b */
    public static void m44389b() {
        if (!m44371t()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    /* renamed from: c */
    public static boolean m44388c(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null) {
            return obj2 == null;
        } else if (obj instanceof Model) {
            return ((Model) obj).m45073a(obj2);
        } else {
            return obj.equals(obj2);
        }
    }

    /* renamed from: d */
    public static boolean m44387d(@Nullable Object obj, @Nullable Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    @NonNull
    /* renamed from: e */
    private static String m44386e(@NonNull byte[] bArr, @NonNull char[] cArr) {
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & UByte.f41242c;
            int i3 = i * 2;
            char[] cArr2 = f14564c;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }

    @NonNull
    /* renamed from: f */
    public static <T> Queue<T> m44385f(int i) {
        return new ArrayDeque(i);
    }

    /* renamed from: g */
    public static int m44384g(int i, int i2, @Nullable Bitmap.Config config) {
        return i * i2 * m44382i(config);
    }

    @TargetApi(19)
    /* renamed from: h */
    public static int m44383h(@NonNull Bitmap bitmap) {
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

    /* renamed from: i */
    private static int m44382i(@Nullable Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i = C3772a.f14566a[config.ordinal()];
        if (i != 1) {
            if (i == 2 || i == 3) {
                return 2;
            }
            return i != 4 ? 4 : 8;
        }
        return 1;
    }

    @Deprecated
    /* renamed from: j */
    public static int m44381j(@NonNull Bitmap bitmap) {
        return m44383h(bitmap);
    }

    @NonNull
    /* renamed from: k */
    public static <T> List<T> m44380k(@NonNull Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (T t : collection) {
            if (t != null) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    /* renamed from: l */
    public static int m44379l(float f) {
        return m44378m(f, 17);
    }

    /* renamed from: m */
    public static int m44378m(float f, int i) {
        return m44376o(Float.floatToIntBits(f), i);
    }

    /* renamed from: n */
    public static int m44377n(int i) {
        return m44376o(i, 17);
    }

    /* renamed from: o */
    public static int m44376o(int i, int i2) {
        return (i2 * 31) + i;
    }

    /* renamed from: p */
    public static int m44375p(@Nullable Object obj, int i) {
        return m44376o(obj == null ? 0 : obj.hashCode(), i);
    }

    /* renamed from: q */
    public static int m44374q(boolean z) {
        return m44373r(z, 17);
    }

    /* renamed from: r */
    public static int m44373r(boolean z, int i) {
        return m44376o(z ? 1 : 0, i);
    }

    /* renamed from: s */
    public static boolean m44372s() {
        return !m44371t();
    }

    /* renamed from: t */
    public static boolean m44371t() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    /* renamed from: u */
    private static boolean m44370u(int i) {
        return i > 0 || i == Integer.MIN_VALUE;
    }

    /* renamed from: v */
    public static boolean m44369v(int i, int i2) {
        return m44370u(i) && m44370u(i2);
    }

    @NonNull
    /* renamed from: w */
    public static String m44368w(@NonNull byte[] bArr) {
        String m44386e;
        char[] cArr = f14565d;
        synchronized (cArr) {
            m44386e = m44386e(bArr, cArr);
        }
        return m44386e;
    }
}
