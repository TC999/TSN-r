package master.flame.danmaku.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import master.flame.danmaku.danmaku.model.BaseDanmaku;
import master.flame.danmaku.danmaku.model.C15347g;
import master.flame.danmaku.danmaku.model.DanmakuTimer;
import master.flame.danmaku.danmaku.model.IDanmakus;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.android.Danmakus;
import p025b2.SystemClock;

/* renamed from: master.flame.danmaku.controller.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class DanmakuFilters {

    /* renamed from: f */
    public static final int f43555f = 1;

    /* renamed from: g */
    public static final int f43556g = 2;

    /* renamed from: h */
    public static final int f43557h = 4;

    /* renamed from: i */
    public static final int f43558i = 8;

    /* renamed from: j */
    public static final int f43559j = 16;

    /* renamed from: k */
    public static final int f43560k = 32;

    /* renamed from: l */
    public static final int f43561l = 64;

    /* renamed from: m */
    public static final int f43562m = 128;

    /* renamed from: n */
    public static final int f43563n = 256;

    /* renamed from: o */
    public static final int f43564o = 512;

    /* renamed from: p */
    public static final String f43565p = "1010_Filter";

    /* renamed from: q */
    public static final String f43566q = "1011_Filter";

    /* renamed from: r */
    public static final String f43567r = "1012_Filter";

    /* renamed from: s */
    public static final String f43568s = "1013_Filter";

    /* renamed from: t */
    public static final String f43569t = "1014_Filter";

    /* renamed from: u */
    public static final String f43570u = "1015_Filter";

    /* renamed from: v */
    public static final String f43571v = "1016_Filter";

    /* renamed from: w */
    public static final String f43572w = "1017_Filter";

    /* renamed from: x */
    public static final String f43573x = "1018_Filter";

    /* renamed from: y */
    public static final String f43574y = "1019_Filter";

    /* renamed from: a */
    public final Exception f43575a = new Exception("not suuport this filter tag");

    /* renamed from: b */
    private final Map<String, InterfaceC15319e<?>> f43576b = Collections.synchronizedSortedMap(new TreeMap());

    /* renamed from: c */
    private final Map<String, InterfaceC15319e<?>> f43577c = Collections.synchronizedSortedMap(new TreeMap());

    /* renamed from: d */
    InterfaceC15319e<?>[] f43578d = new InterfaceC15319e[0];

    /* renamed from: e */
    InterfaceC15319e<?>[] f43579e = new InterfaceC15319e[0];

    /* compiled from: DanmakuFilters.java */
    /* renamed from: master.flame.danmaku.controller.b$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static abstract class AbstractC15314a<T> implements InterfaceC15319e<T> {
        @Override // master.flame.danmaku.controller.DanmakuFilters.InterfaceC15319e
        public void clear() {
        }
    }

    /* compiled from: DanmakuFilters.java */
    /* renamed from: master.flame.danmaku.controller.b$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15315b extends AbstractC15314a<Void> {

        /* renamed from: a */
        protected final IDanmakus f43580a = new Danmakus(4);

        /* renamed from: b */
        protected final LinkedHashMap<String, BaseDanmaku> f43581b = new LinkedHashMap<>();

        /* renamed from: c */
        private final IDanmakus f43582c = new Danmakus(4);

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: DanmakuFilters.java */
        /* renamed from: master.flame.danmaku.controller.b$b$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15316a extends IDanmakus.AbstractC15350c<BaseDanmaku> {

            /* renamed from: e */
            long f43583e = SystemClock.m59951b();

            /* renamed from: f */
            final /* synthetic */ long f43584f;

            C15316a(long j) {
                this.f43584f = j;
            }

            @Override // master.flame.danmaku.danmaku.model.IDanmakus.AbstractC15349b
            /* renamed from: e */
            public int mo2892a(BaseDanmaku baseDanmaku) {
                if (SystemClock.m59951b() - this.f43583e > this.f43584f) {
                    return 1;
                }
                return baseDanmaku.m3073w() ? 2 : 1;
            }
        }

        /* renamed from: d */
        private void m3380d(LinkedHashMap<String, BaseDanmaku> linkedHashMap, int i) {
            Iterator<Map.Entry<String, BaseDanmaku>> it = linkedHashMap.entrySet().iterator();
            long m59951b = SystemClock.m59951b();
            while (it.hasNext()) {
                try {
                    if (!it.next().getValue().m3073w()) {
                        return;
                    }
                    it.remove();
                    if (SystemClock.m59951b() - m59951b > i) {
                        return;
                    }
                } catch (Exception unused) {
                    return;
                }
            }
        }

        /* renamed from: e */
        private final void m3379e(IDanmakus iDanmakus, long j) {
            iDanmakus.mo3057a(new C15316a(j));
        }

        @Override // master.flame.danmaku.controller.DanmakuFilters.InterfaceC15319e
        /* renamed from: b */
        public boolean mo3362b(BaseDanmaku baseDanmaku, int i, int i2, DanmakuTimer danmakuTimer, boolean z, DanmakuContext danmakuContext) {
            boolean m3381c = m3381c(baseDanmaku, i, i2, danmakuTimer, z);
            if (m3381c) {
                baseDanmaku.f43854G |= 128;
            }
            return m3381c;
        }

        /* renamed from: c */
        public synchronized boolean m3381c(BaseDanmaku baseDanmaku, int i, int i2, DanmakuTimer danmakuTimer, boolean z) {
            m3379e(this.f43580a, 2L);
            m3379e(this.f43582c, 2L);
            m3380d(this.f43581b, 3);
            if (!this.f43580a.mo3048j(baseDanmaku) || baseDanmaku.m3076s()) {
                if (this.f43582c.mo3048j(baseDanmaku)) {
                    return false;
                }
                if (this.f43581b.containsKey(baseDanmaku.f43861c)) {
                    this.f43581b.put(String.valueOf(baseDanmaku.f43861c), baseDanmaku);
                    this.f43580a.mo3051g(baseDanmaku);
                    this.f43580a.mo3049i(baseDanmaku);
                    return true;
                }
                this.f43581b.put(String.valueOf(baseDanmaku.f43861c), baseDanmaku);
                this.f43582c.mo3049i(baseDanmaku);
                return false;
            }
            return true;
        }

        @Override // master.flame.danmaku.controller.DanmakuFilters.AbstractC15314a, master.flame.danmaku.controller.DanmakuFilters.InterfaceC15319e
        public void clear() {
            reset();
        }

        @Override // master.flame.danmaku.controller.DanmakuFilters.InterfaceC15319e
        /* renamed from: f */
        public void mo3365a(Void r1) {
        }

        @Override // master.flame.danmaku.controller.DanmakuFilters.InterfaceC15319e
        public synchronized void reset() {
            this.f43582c.clear();
            this.f43580a.clear();
            this.f43581b.clear();
        }
    }

    /* compiled from: DanmakuFilters.java */
    /* renamed from: master.flame.danmaku.controller.b$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15317c extends AbstractC15314a<Object> {

        /* renamed from: a */
        long f43586a = 20;

        /* renamed from: c */
        private synchronized boolean m3376c(BaseDanmaku baseDanmaku, int i, int i2, DanmakuTimer danmakuTimer, boolean z) {
            if (danmakuTimer != null) {
                if (baseDanmaku.m3076s()) {
                    return SystemClock.m59951b() - danmakuTimer.f43885a >= this.f43586a;
                }
            }
            return false;
        }

        @Override // master.flame.danmaku.controller.DanmakuFilters.InterfaceC15319e
        /* renamed from: a */
        public void mo3365a(Object obj) {
            reset();
        }

        @Override // master.flame.danmaku.controller.DanmakuFilters.InterfaceC15319e
        /* renamed from: b */
        public boolean mo3362b(BaseDanmaku baseDanmaku, int i, int i2, DanmakuTimer danmakuTimer, boolean z, DanmakuContext danmakuContext) {
            boolean m3376c = m3376c(baseDanmaku, i, i2, danmakuTimer, z);
            if (m3376c) {
                baseDanmaku.f43854G |= 4;
            }
            return m3376c;
        }

        @Override // master.flame.danmaku.controller.DanmakuFilters.AbstractC15314a, master.flame.danmaku.controller.DanmakuFilters.InterfaceC15319e
        public void clear() {
            reset();
        }

        @Override // master.flame.danmaku.controller.DanmakuFilters.InterfaceC15319e
        public synchronized void reset() {
        }
    }

    /* compiled from: DanmakuFilters.java */
    /* renamed from: master.flame.danmaku.controller.b$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15318d extends AbstractC15314a<Boolean> {

        /* renamed from: a */
        private Boolean f43587a = Boolean.FALSE;

        @Override // master.flame.danmaku.controller.DanmakuFilters.InterfaceC15319e
        /* renamed from: b */
        public boolean mo3362b(BaseDanmaku baseDanmaku, int i, int i2, DanmakuTimer danmakuTimer, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = this.f43587a.booleanValue() && baseDanmaku.f43851D;
            if (z2) {
                baseDanmaku.f43854G |= 64;
            }
            return z2;
        }

        @Override // master.flame.danmaku.controller.DanmakuFilters.InterfaceC15319e
        /* renamed from: c */
        public void mo3365a(Boolean bool) {
            this.f43587a = bool;
        }

        @Override // master.flame.danmaku.controller.DanmakuFilters.InterfaceC15319e
        public void reset() {
            this.f43587a = Boolean.FALSE;
        }
    }

    /* compiled from: DanmakuFilters.java */
    /* renamed from: master.flame.danmaku.controller.b$e */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public interface InterfaceC15319e<T> {
        /* renamed from: a */
        void mo3365a(T t);

        /* renamed from: b */
        boolean mo3362b(BaseDanmaku baseDanmaku, int i, int i2, DanmakuTimer danmakuTimer, boolean z, DanmakuContext danmakuContext);

        void clear();

        void reset();
    }

    /* compiled from: DanmakuFilters.java */
    /* renamed from: master.flame.danmaku.controller.b$f */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15320f extends AbstractC15314a<Map<Integer, Integer>> {

        /* renamed from: a */
        private Map<Integer, Integer> f43588a;

        @Override // master.flame.danmaku.controller.DanmakuFilters.InterfaceC15319e
        /* renamed from: b */
        public boolean mo3362b(BaseDanmaku baseDanmaku, int i, int i2, DanmakuTimer danmakuTimer, boolean z, DanmakuContext danmakuContext) {
            Map<Integer, Integer> map = this.f43588a;
            boolean z2 = false;
            if (map != null) {
                Integer num = map.get(Integer.valueOf(baseDanmaku.getType()));
                if (num != null && i >= num.intValue()) {
                    z2 = true;
                }
                if (z2) {
                    baseDanmaku.f43854G |= 256;
                }
            }
            return z2;
        }

        @Override // master.flame.danmaku.controller.DanmakuFilters.InterfaceC15319e
        /* renamed from: c */
        public void mo3365a(Map<Integer, Integer> map) {
            this.f43588a = map;
        }

        @Override // master.flame.danmaku.controller.DanmakuFilters.InterfaceC15319e
        public void reset() {
            this.f43588a = null;
        }
    }

    /* compiled from: DanmakuFilters.java */
    /* renamed from: master.flame.danmaku.controller.b$g */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15321g extends AbstractC15314a<Map<Integer, Boolean>> {

        /* renamed from: a */
        private Map<Integer, Boolean> f43589a;

        @Override // master.flame.danmaku.controller.DanmakuFilters.InterfaceC15319e
        /* renamed from: b */
        public boolean mo3362b(BaseDanmaku baseDanmaku, int i, int i2, DanmakuTimer danmakuTimer, boolean z, DanmakuContext danmakuContext) {
            Map<Integer, Boolean> map = this.f43589a;
            boolean z2 = false;
            if (map != null) {
                Boolean bool = map.get(Integer.valueOf(baseDanmaku.getType()));
                if (bool != null && bool.booleanValue() && z) {
                    z2 = true;
                }
                if (z2) {
                    baseDanmaku.f43854G |= 512;
                }
            }
            return z2;
        }

        @Override // master.flame.danmaku.controller.DanmakuFilters.InterfaceC15319e
        /* renamed from: c */
        public void mo3365a(Map<Integer, Boolean> map) {
            this.f43589a = map;
        }

        @Override // master.flame.danmaku.controller.DanmakuFilters.InterfaceC15319e
        public void reset() {
            this.f43589a = null;
        }
    }

    /* compiled from: DanmakuFilters.java */
    /* renamed from: master.flame.danmaku.controller.b$h */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15322h extends AbstractC15314a<Integer> {

        /* renamed from: a */
        protected int f43590a = -1;

        /* renamed from: b */
        protected BaseDanmaku f43591b = null;

        /* renamed from: c */
        private float f43592c = 1.0f;

        /* renamed from: c */
        private boolean m3372c(BaseDanmaku baseDanmaku, int i, int i2, DanmakuTimer danmakuTimer, boolean z, DanmakuContext danmakuContext) {
            if (this.f43590a > 0 && baseDanmaku.getType() == 1) {
                BaseDanmaku baseDanmaku2 = this.f43591b;
                if (baseDanmaku2 != null && !baseDanmaku2.m3073w()) {
                    long m3088b = baseDanmaku.m3088b() - this.f43591b.m3088b();
                    C15347g c15347g = danmakuContext.f43693D.f43793f;
                    if ((m3088b < 0 || c15347g == null || ((float) m3088b) >= ((float) c15347g.f43889c) * this.f43592c) && i <= this.f43590a) {
                        this.f43591b = baseDanmaku;
                        return false;
                    }
                    return true;
                }
                this.f43591b = baseDanmaku;
            }
            return false;
        }

        @Override // master.flame.danmaku.controller.DanmakuFilters.InterfaceC15319e
        /* renamed from: b */
        public synchronized boolean mo3362b(BaseDanmaku baseDanmaku, int i, int i2, DanmakuTimer danmakuTimer, boolean z, DanmakuContext danmakuContext) {
            boolean m3372c;
            m3372c = m3372c(baseDanmaku, i, i2, danmakuTimer, z, danmakuContext);
            if (m3372c) {
                baseDanmaku.f43854G |= 2;
            }
            return m3372c;
        }

        @Override // master.flame.danmaku.controller.DanmakuFilters.AbstractC15314a, master.flame.danmaku.controller.DanmakuFilters.InterfaceC15319e
        public void clear() {
            reset();
        }

        @Override // master.flame.danmaku.controller.DanmakuFilters.InterfaceC15319e
        /* renamed from: d */
        public void mo3365a(Integer num) {
            reset();
            if (num == null || num.intValue() == this.f43590a) {
                return;
            }
            int intValue = num.intValue() + (num.intValue() / 5);
            this.f43590a = intValue;
            this.f43592c = 1.0f / intValue;
        }

        @Override // master.flame.danmaku.controller.DanmakuFilters.InterfaceC15319e
        public synchronized void reset() {
            this.f43591b = null;
        }
    }

    /* compiled from: DanmakuFilters.java */
    /* renamed from: master.flame.danmaku.controller.b$i */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15323i extends AbstractC15314a<List<Integer>> {

        /* renamed from: a */
        public List<Integer> f43593a = new ArrayList();

        /* renamed from: c */
        private void m3370c(Integer num) {
            if (this.f43593a.contains(num)) {
                return;
            }
            this.f43593a.add(num);
        }

        @Override // master.flame.danmaku.controller.DanmakuFilters.InterfaceC15319e
        /* renamed from: b */
        public boolean mo3362b(BaseDanmaku baseDanmaku, int i, int i2, DanmakuTimer danmakuTimer, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = (baseDanmaku == null || this.f43593a.contains(Integer.valueOf(baseDanmaku.f43865g))) ? false : true;
            if (z2) {
                baseDanmaku.f43854G |= 8;
            }
            return z2;
        }

        @Override // master.flame.danmaku.controller.DanmakuFilters.InterfaceC15319e
        /* renamed from: d */
        public void mo3365a(List<Integer> list) {
            reset();
            if (list != null) {
                for (Integer num : list) {
                    m3370c(num);
                }
            }
        }

        @Override // master.flame.danmaku.controller.DanmakuFilters.InterfaceC15319e
        public void reset() {
            this.f43593a.clear();
        }
    }

    /* compiled from: DanmakuFilters.java */
    /* renamed from: master.flame.danmaku.controller.b$j */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15324j extends AbstractC15314a<List<Integer>> {

        /* renamed from: a */
        final List<Integer> f43594a = Collections.synchronizedList(new ArrayList());

        @Override // master.flame.danmaku.controller.DanmakuFilters.InterfaceC15319e
        /* renamed from: b */
        public boolean mo3362b(BaseDanmaku baseDanmaku, int i, int i2, DanmakuTimer danmakuTimer, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = baseDanmaku != null && this.f43594a.contains(Integer.valueOf(baseDanmaku.getType()));
            if (z2) {
                baseDanmaku.f43854G = 1 | baseDanmaku.f43854G;
            }
            return z2;
        }

        /* renamed from: c */
        public void m3368c(Integer num) {
            if (this.f43594a.contains(num)) {
                this.f43594a.remove(num);
            }
        }

        /* renamed from: d */
        public void m3367d(Integer num) {
            if (this.f43594a.contains(num)) {
                return;
            }
            this.f43594a.add(num);
        }

        @Override // master.flame.danmaku.controller.DanmakuFilters.InterfaceC15319e
        /* renamed from: e */
        public void mo3365a(List<Integer> list) {
            reset();
            if (list != null) {
                for (Integer num : list) {
                    m3367d(num);
                }
            }
        }

        @Override // master.flame.danmaku.controller.DanmakuFilters.InterfaceC15319e
        public void reset() {
            this.f43594a.clear();
        }
    }

    /* compiled from: DanmakuFilters.java */
    /* renamed from: master.flame.danmaku.controller.b$k */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static abstract class AbstractC15325k<T> extends AbstractC15314a<List<T>> {

        /* renamed from: a */
        public List<T> f43595a = new ArrayList();

        /* renamed from: c */
        private void m3364c(T t) {
            if (this.f43595a.contains(t)) {
                return;
            }
            this.f43595a.add(t);
        }

        @Override // master.flame.danmaku.controller.DanmakuFilters.InterfaceC15319e
        /* renamed from: b */
        public abstract boolean mo3362b(BaseDanmaku baseDanmaku, int i, int i2, DanmakuTimer danmakuTimer, boolean z, DanmakuContext danmakuContext);

        @Override // master.flame.danmaku.controller.DanmakuFilters.InterfaceC15319e
        /* renamed from: d */
        public void mo3365a(List<T> list) {
            reset();
            if (list != null) {
                for (T t : list) {
                    m3364c(t);
                }
            }
        }

        @Override // master.flame.danmaku.controller.DanmakuFilters.InterfaceC15319e
        public void reset() {
            this.f43595a.clear();
        }
    }

    /* compiled from: DanmakuFilters.java */
    /* renamed from: master.flame.danmaku.controller.b$l */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15326l extends AbstractC15325k<String> {
        @Override // master.flame.danmaku.controller.DanmakuFilters.AbstractC15325k, master.flame.danmaku.controller.DanmakuFilters.InterfaceC15319e
        /* renamed from: b */
        public boolean mo3362b(BaseDanmaku baseDanmaku, int i, int i2, DanmakuTimer danmakuTimer, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = baseDanmaku != null && this.f43595a.contains(baseDanmaku.f43850C);
            if (z2) {
                baseDanmaku.f43854G |= 32;
            }
            return z2;
        }
    }

    /* compiled from: DanmakuFilters.java */
    /* renamed from: master.flame.danmaku.controller.b$m */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15327m extends AbstractC15325k<Integer> {
        @Override // master.flame.danmaku.controller.DanmakuFilters.AbstractC15325k, master.flame.danmaku.controller.DanmakuFilters.InterfaceC15319e
        /* renamed from: b */
        public boolean mo3362b(BaseDanmaku baseDanmaku, int i, int i2, DanmakuTimer danmakuTimer, boolean z, DanmakuContext danmakuContext) {
            boolean z2 = baseDanmaku != null && this.f43595a.contains(Integer.valueOf(baseDanmaku.f43849B));
            if (z2) {
                baseDanmaku.f43854G |= 16;
            }
            return z2;
        }
    }

    /* renamed from: j */
    private void m3384j() {
        try {
            throw this.f43575a;
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public void m3393a() {
        InterfaceC15319e<?>[] interfaceC15319eArr;
        InterfaceC15319e<?>[] interfaceC15319eArr2;
        for (InterfaceC15319e<?> interfaceC15319e : this.f43578d) {
            if (interfaceC15319e != null) {
                interfaceC15319e.clear();
            }
        }
        for (InterfaceC15319e<?> interfaceC15319e2 : this.f43579e) {
            if (interfaceC15319e2 != null) {
                interfaceC15319e2.clear();
            }
        }
    }

    /* renamed from: b */
    public void m3392b(BaseDanmaku baseDanmaku, int i, int i2, DanmakuTimer danmakuTimer, boolean z, DanmakuContext danmakuContext) {
        InterfaceC15319e<?>[] interfaceC15319eArr;
        for (InterfaceC15319e<?> interfaceC15319e : this.f43578d) {
            if (interfaceC15319e != null) {
                boolean mo3362b = interfaceC15319e.mo3362b(baseDanmaku, i, i2, danmakuTimer, z, danmakuContext);
                baseDanmaku.f43855H = danmakuContext.f43691B.f43898c;
                if (mo3362b) {
                    return;
                }
            }
        }
    }

    /* renamed from: c */
    public boolean m3391c(BaseDanmaku baseDanmaku, int i, int i2, DanmakuTimer danmakuTimer, boolean z, DanmakuContext danmakuContext) {
        InterfaceC15319e<?>[] interfaceC15319eArr;
        for (InterfaceC15319e<?> interfaceC15319e : this.f43579e) {
            if (interfaceC15319e != null) {
                boolean mo3362b = interfaceC15319e.mo3362b(baseDanmaku, i, i2, danmakuTimer, z, danmakuContext);
                baseDanmaku.f43855H = danmakuContext.f43691B.f43898c;
                if (mo3362b) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: d */
    public InterfaceC15319e<?> m3390d(String str) {
        return m3389e(str, true);
    }

    /* renamed from: e */
    public InterfaceC15319e<?> m3389e(String str, boolean z) {
        InterfaceC15319e<?> interfaceC15319e = (z ? this.f43576b : this.f43577c).get(str);
        return interfaceC15319e == null ? m3387g(str, z) : interfaceC15319e;
    }

    /* renamed from: f */
    public InterfaceC15319e<?> m3388f(String str) {
        return m3387g(str, true);
    }

    /* renamed from: g */
    public InterfaceC15319e<?> m3387g(String str, boolean z) {
        if (str == null) {
            m3384j();
            return null;
        }
        InterfaceC15319e<?> interfaceC15319e = this.f43576b.get(str);
        if (interfaceC15319e == null) {
            if (f43565p.equals(str)) {
                interfaceC15319e = new C15324j();
            } else if (f43566q.equals(str)) {
                interfaceC15319e = new C15322h();
            } else if (f43567r.equals(str)) {
                interfaceC15319e = new C15317c();
            } else if (f43568s.equals(str)) {
                interfaceC15319e = new C15323i();
            } else if (f43569t.equals(str)) {
                interfaceC15319e = new C15327m();
            } else if (f43570u.equals(str)) {
                interfaceC15319e = new C15326l();
            } else if (f43571v.equals(str)) {
                interfaceC15319e = new C15318d();
            } else if (f43572w.equals(str)) {
                interfaceC15319e = new C15315b();
            } else if (f43573x.equals(str)) {
                interfaceC15319e = new C15320f();
            } else if (f43574y.equals(str)) {
                interfaceC15319e = new C15321g();
            }
        }
        if (interfaceC15319e == null) {
            m3384j();
            return null;
        }
        interfaceC15319e.mo3365a(null);
        if (z) {
            this.f43576b.put(str, interfaceC15319e);
            this.f43578d = (InterfaceC15319e[]) this.f43576b.values().toArray(this.f43578d);
        } else {
            this.f43577c.put(str, interfaceC15319e);
            this.f43579e = (InterfaceC15319e[]) this.f43577c.values().toArray(this.f43579e);
        }
        return interfaceC15319e;
    }

    /* renamed from: h */
    public void m3386h() {
        m3393a();
        this.f43576b.clear();
        this.f43578d = new InterfaceC15319e[0];
        this.f43577c.clear();
        this.f43579e = new InterfaceC15319e[0];
    }

    /* renamed from: i */
    public void m3385i() {
        InterfaceC15319e<?>[] interfaceC15319eArr;
        InterfaceC15319e<?>[] interfaceC15319eArr2;
        for (InterfaceC15319e<?> interfaceC15319e : this.f43578d) {
            if (interfaceC15319e != null) {
                interfaceC15319e.reset();
            }
        }
        for (InterfaceC15319e<?> interfaceC15319e2 : this.f43579e) {
            if (interfaceC15319e2 != null) {
                interfaceC15319e2.reset();
            }
        }
    }

    /* renamed from: k */
    public void m3383k(String str) {
        m3382l(str, true);
    }

    /* renamed from: l */
    public void m3382l(String str, boolean z) {
        InterfaceC15319e<?> remove = (z ? this.f43576b : this.f43577c).remove(str);
        if (remove != null) {
            remove.clear();
            if (z) {
                this.f43578d = (InterfaceC15319e[]) this.f43576b.values().toArray(this.f43578d);
            } else {
                this.f43579e = (InterfaceC15319e[]) this.f43577c.values().toArray(this.f43579e);
            }
        }
    }
}
