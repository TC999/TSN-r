package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.C3771k;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

@RequiresApi(19)
/* renamed from: com.bumptech.glide.load.engine.bitmap_recycle.o */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class SizeConfigStrategy implements LruPoolStrategy {

    /* renamed from: d */
    private static final int f13595d = 8;

    /* renamed from: e */
    private static final Bitmap.Config[] f13596e;

    /* renamed from: f */
    private static final Bitmap.Config[] f13597f;

    /* renamed from: g */
    private static final Bitmap.Config[] f13598g;

    /* renamed from: h */
    private static final Bitmap.Config[] f13599h;

    /* renamed from: i */
    private static final Bitmap.Config[] f13600i;

    /* renamed from: a */
    private final C3589c f13601a = new C3589c();

    /* renamed from: b */
    private final GroupedLinkedMap<C3588b, Bitmap> f13602b = new GroupedLinkedMap<>();

    /* renamed from: c */
    private final Map<Bitmap.Config, NavigableMap<Integer, Integer>> f13603c = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SizeConfigStrategy.java */
    /* renamed from: com.bumptech.glide.load.engine.bitmap_recycle.o$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static /* synthetic */ class C3587a {

        /* renamed from: a */
        static final /* synthetic */ int[] f13604a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f13604a = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13604a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13604a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f13604a[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SizeConfigStrategy.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.engine.bitmap_recycle.o$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C3589c extends BaseKeyPool<C3588b> {
        C3589c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.engine.bitmap_recycle.BaseKeyPool
        /* renamed from: d */
        public C3588b mo45340a() {
            return new C3588b(this);
        }

        /* renamed from: e */
        public C3588b m45351e(int i, Bitmap.Config config) {
            C3588b m45414b = m45414b();
            m45414b.m45353b(i, config);
            return m45414b;
        }
    }

    static {
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        }
        f13596e = configArr;
        f13597f = configArr;
        f13598g = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        f13599h = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        f13600i = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    /* renamed from: f */
    private void m45358f(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> m45354j = m45354j(bitmap.getConfig());
        Integer num2 = (Integer) m45354j.get(num);
        if (num2 != null) {
            if (num2.intValue() == 1) {
                m45354j.remove(num);
                return;
            } else {
                m45354j.put(num, Integer.valueOf(num2.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + mo45350a(bitmap) + ", this: " + this);
    }

    /* renamed from: g */
    private C3588b m45357g(int i, Bitmap.Config config) {
        Bitmap.Config[] m45355i;
        C3588b m45351e = this.f13601a.m45351e(i, config);
        for (Bitmap.Config config2 : m45355i(config)) {
            Integer ceilingKey = m45354j(config2).ceilingKey(Integer.valueOf(i));
            if (ceilingKey != null && ceilingKey.intValue() <= i * 8) {
                if (ceilingKey.intValue() == i) {
                    if (config2 == null) {
                        if (config == null) {
                            return m45351e;
                        }
                    } else if (config2.equals(config)) {
                        return m45351e;
                    }
                }
                this.f13601a.m45413c(m45351e);
                return this.f13601a.m45351e(ceilingKey.intValue(), config2);
            }
        }
        return m45351e;
    }

    /* renamed from: h */
    static String m45356h(int i, Bitmap.Config config) {
        return "[" + i + "](" + config + ")";
    }

    /* renamed from: i */
    private static Bitmap.Config[] m45355i(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && Bitmap.Config.RGBA_F16.equals(config)) {
            return f13597f;
        }
        int i = C3587a.f13604a[config.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return i != 4 ? new Bitmap.Config[]{config} : f13600i;
                }
                return f13599h;
            }
            return f13598g;
        }
        return f13596e;
    }

    /* renamed from: j */
    private NavigableMap<Integer, Integer> m45354j(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.f13603c.get(config);
        if (navigableMap == null) {
            TreeMap treeMap = new TreeMap();
            this.f13603c.put(config, treeMap);
            return treeMap;
        }
        return navigableMap;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    /* renamed from: a */
    public String mo45350a(Bitmap bitmap) {
        return m45356h(C3771k.m44383h(bitmap), bitmap.getConfig());
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    /* renamed from: b */
    public String mo45349b(int i, int i2, Bitmap.Config config) {
        return m45356h(C3771k.m44384g(i, i2, config), config);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    /* renamed from: c */
    public int mo45348c(Bitmap bitmap) {
        return C3771k.m44383h(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    /* renamed from: d */
    public void mo45347d(Bitmap bitmap) {
        C3588b m45351e = this.f13601a.m45351e(C3771k.m44383h(bitmap), bitmap.getConfig());
        this.f13602b.m45407d(m45351e, bitmap);
        NavigableMap<Integer, Integer> m45354j = m45354j(bitmap.getConfig());
        Integer num = (Integer) m45354j.get(Integer.valueOf(m45351e.f13606b));
        m45354j.put(Integer.valueOf(m45351e.f13606b), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    @Nullable
    /* renamed from: e */
    public Bitmap mo45346e(int i, int i2, Bitmap.Config config) {
        C3588b m45357g = m45357g(C3771k.m44384g(i, i2, config), config);
        Bitmap m45410a = this.f13602b.m45410a(m45357g);
        if (m45410a != null) {
            m45358f(Integer.valueOf(m45357g.f13606b), m45410a);
            m45410a.reconfigure(i, i2, config);
        }
        return m45410a;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.LruPoolStrategy
    @Nullable
    public Bitmap removeLast() {
        Bitmap m45405f = this.f13602b.m45405f();
        if (m45405f != null) {
            m45358f(Integer.valueOf(C3771k.m44383h(m45405f)), m45405f);
        }
        return m45405f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SizeConfigStrategy{groupedMap=");
        sb.append(this.f13602b);
        sb.append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.f13603c.entrySet()) {
            sb.append(entry.getKey());
            sb.append('[');
            sb.append(entry.getValue());
            sb.append("], ");
        }
        if (!this.f13603c.isEmpty()) {
            sb.replace(sb.length() - 2, sb.length(), "");
        }
        sb.append(")}");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SizeConfigStrategy.java */
    @VisibleForTesting
    /* renamed from: com.bumptech.glide.load.engine.bitmap_recycle.o$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C3588b implements Poolable {

        /* renamed from: a */
        private final C3589c f13605a;

        /* renamed from: b */
        int f13606b;

        /* renamed from: c */
        private Bitmap.Config f13607c;

        public C3588b(C3589c c3589c) {
            this.f13605a = c3589c;
        }

        @Override // com.bumptech.glide.load.engine.bitmap_recycle.Poolable
        /* renamed from: a */
        public void mo45342a() {
            this.f13605a.m45413c(this);
        }

        /* renamed from: b */
        public void m45353b(int i, Bitmap.Config config) {
            this.f13606b = i;
            this.f13607c = config;
        }

        public boolean equals(Object obj) {
            if (obj instanceof C3588b) {
                C3588b c3588b = (C3588b) obj;
                return this.f13606b == c3588b.f13606b && C3771k.m44387d(this.f13607c, c3588b.f13607c);
            }
            return false;
        }

        public int hashCode() {
            int i = this.f13606b * 31;
            Bitmap.Config config = this.f13607c;
            return i + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return SizeConfigStrategy.m45356h(this.f13606b, this.f13607c);
        }

        @VisibleForTesting
        C3588b(C3589c c3589c, int i, Bitmap.Config config) {
            this(c3589c);
            m45353b(i, config);
        }
    }
}
