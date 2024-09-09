package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: SizeConfigStrategy.java */
@RequiresApi(19)
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class o implements l {

    /* renamed from: d  reason: collision with root package name */
    private static final int f16918d = 8;

    /* renamed from: e  reason: collision with root package name */
    private static final Bitmap.Config[] f16919e;

    /* renamed from: f  reason: collision with root package name */
    private static final Bitmap.Config[] f16920f;

    /* renamed from: g  reason: collision with root package name */
    private static final Bitmap.Config[] f16921g;

    /* renamed from: h  reason: collision with root package name */
    private static final Bitmap.Config[] f16922h;

    /* renamed from: i  reason: collision with root package name */
    private static final Bitmap.Config[] f16923i;

    /* renamed from: a  reason: collision with root package name */
    private final c f16924a = new c();

    /* renamed from: b  reason: collision with root package name */
    private final h<b, Bitmap> f16925b = new h<>();

    /* renamed from: c  reason: collision with root package name */
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> f16926c = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SizeConfigStrategy.java */
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f16927a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f16927a = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16927a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16927a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f16927a[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SizeConfigStrategy.java */
    @VisibleForTesting
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static class c extends d<b> {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.d
        /* renamed from: d */
        public b a() {
            return new b(this);
        }

        public b e(int i4, Bitmap.Config config) {
            b b4 = b();
            b4.b(i4, config);
            return b4;
        }
    }

    static {
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        }
        f16919e = configArr;
        f16920f = configArr;
        f16921g = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        f16922h = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        f16923i = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    private void f(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> j4 = j(bitmap.getConfig());
        Integer num2 = (Integer) j4.get(num);
        if (num2 != null) {
            if (num2.intValue() == 1) {
                j4.remove(num);
                return;
            } else {
                j4.put(num, Integer.valueOf(num2.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + a(bitmap) + ", this: " + this);
    }

    private b g(int i4, Bitmap.Config config) {
        Bitmap.Config[] i5;
        b e4 = this.f16924a.e(i4, config);
        for (Bitmap.Config config2 : i(config)) {
            Integer ceilingKey = j(config2).ceilingKey(Integer.valueOf(i4));
            if (ceilingKey != null && ceilingKey.intValue() <= i4 * 8) {
                if (ceilingKey.intValue() == i4) {
                    if (config2 == null) {
                        if (config == null) {
                            return e4;
                        }
                    } else if (config2.equals(config)) {
                        return e4;
                    }
                }
                this.f16924a.c(e4);
                return this.f16924a.e(ceilingKey.intValue(), config2);
            }
        }
        return e4;
    }

    static String h(int i4, Bitmap.Config config) {
        return "[" + i4 + "](" + config + ")";
    }

    private static Bitmap.Config[] i(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16.equals(config)) {
            return f16920f;
        }
        int i4 = a.f16927a[config.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    return i4 != 4 ? new Bitmap.Config[]{config} : f16923i;
                }
                return f16922h;
            }
            return f16921g;
        }
        return f16919e;
    }

    private NavigableMap<Integer, Integer> j(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.f16926c.get(config);
        if (navigableMap == null) {
            TreeMap treeMap = new TreeMap();
            this.f16926c.put(config, treeMap);
            return treeMap;
        }
        return navigableMap;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.l
    public String a(Bitmap bitmap) {
        return h(com.bumptech.glide.util.k.h(bitmap), bitmap.getConfig());
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.l
    public String b(int i4, int i5, Bitmap.Config config) {
        return h(com.bumptech.glide.util.k.g(i4, i5, config), config);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.l
    public int c(Bitmap bitmap) {
        return com.bumptech.glide.util.k.h(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.l
    public void d(Bitmap bitmap) {
        b e4 = this.f16924a.e(com.bumptech.glide.util.k.h(bitmap), bitmap.getConfig());
        this.f16925b.d(e4, bitmap);
        NavigableMap<Integer, Integer> j4 = j(bitmap.getConfig());
        Integer num = (Integer) j4.get(Integer.valueOf(e4.f16929b));
        j4.put(Integer.valueOf(e4.f16929b), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.l
    @Nullable
    public Bitmap e(int i4, int i5, Bitmap.Config config) {
        b g4 = g(com.bumptech.glide.util.k.g(i4, i5, config), config);
        Bitmap a4 = this.f16925b.a(g4);
        if (a4 != null) {
            f(Integer.valueOf(g4.f16929b), a4);
            a4.reconfigure(i4, i5, config);
        }
        return a4;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.l
    @Nullable
    public Bitmap removeLast() {
        Bitmap f4 = this.f16925b.f();
        if (f4 != null) {
            f(Integer.valueOf(com.bumptech.glide.util.k.h(f4)), f4);
        }
        return f4;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SizeConfigStrategy{groupedMap=");
        sb.append(this.f16925b);
        sb.append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.f16926c.entrySet()) {
            sb.append(entry.getKey());
            sb.append('[');
            sb.append(entry.getValue());
            sb.append("], ");
        }
        if (!this.f16926c.isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(")}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* compiled from: SizeConfigStrategy.java */
    @VisibleForTesting
    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static final class b implements m {

        /* renamed from: a  reason: collision with root package name */
        private final c f16928a;

        /* renamed from: b  reason: collision with root package name */
        int f16929b;

        /* renamed from: c  reason: collision with root package name */
        private Bitmap.Config f16930c;

        public b(c cVar) {
            this.f16928a = cVar;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.m
        public void a() {
            this.f16928a.c(this);
        }

        public void b(int i4, Bitmap.Config config) {
            this.f16929b = i4;
            this.f16930c = config;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                return this.f16929b == bVar.f16929b && com.bumptech.glide.util.k.d(this.f16930c, bVar.f16930c);
            }
            return false;
        }

        public int hashCode() {
            int i4 = this.f16929b * 31;
            Bitmap.Config config = this.f16930c;
            return i4 + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return o.h(this.f16929b, this.f16930c);
        }

        @VisibleForTesting
        b(c cVar, int i4, Bitmap.Config config) {
            this(cVar);
            b(i4, config);
        }
    }
}
