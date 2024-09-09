package master.flame.danmaku.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import master.flame.danmaku.danmaku.model.android.DanmakuContext;
import master.flame.danmaku.danmaku.model.m;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: DanmakuFilters.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class b {

    /* renamed from: f  reason: collision with root package name */
    public static final int f60887f = 1;

    /* renamed from: g  reason: collision with root package name */
    public static final int f60888g = 2;

    /* renamed from: h  reason: collision with root package name */
    public static final int f60889h = 4;

    /* renamed from: i  reason: collision with root package name */
    public static final int f60890i = 8;

    /* renamed from: j  reason: collision with root package name */
    public static final int f60891j = 16;

    /* renamed from: k  reason: collision with root package name */
    public static final int f60892k = 32;

    /* renamed from: l  reason: collision with root package name */
    public static final int f60893l = 64;

    /* renamed from: m  reason: collision with root package name */
    public static final int f60894m = 128;

    /* renamed from: n  reason: collision with root package name */
    public static final int f60895n = 256;

    /* renamed from: o  reason: collision with root package name */
    public static final int f60896o = 512;

    /* renamed from: p  reason: collision with root package name */
    public static final String f60897p = "1010_Filter";

    /* renamed from: q  reason: collision with root package name */
    public static final String f60898q = "1011_Filter";

    /* renamed from: r  reason: collision with root package name */
    public static final String f60899r = "1012_Filter";

    /* renamed from: s  reason: collision with root package name */
    public static final String f60900s = "1013_Filter";

    /* renamed from: t  reason: collision with root package name */
    public static final String f60901t = "1014_Filter";

    /* renamed from: u  reason: collision with root package name */
    public static final String f60902u = "1015_Filter";

    /* renamed from: v  reason: collision with root package name */
    public static final String f60903v = "1016_Filter";

    /* renamed from: w  reason: collision with root package name */
    public static final String f60904w = "1017_Filter";

    /* renamed from: x  reason: collision with root package name */
    public static final String f60905x = "1018_Filter";

    /* renamed from: y  reason: collision with root package name */
    public static final String f60906y = "1019_Filter";

    /* renamed from: a  reason: collision with root package name */
    public final Exception f60907a = new Exception("not suuport this filter tag");

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, e<?>> f60908b = Collections.synchronizedSortedMap(new TreeMap());

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, e<?>> f60909c = Collections.synchronizedSortedMap(new TreeMap());

    /* renamed from: d  reason: collision with root package name */
    e<?>[] f60910d = new e[0];

    /* renamed from: e  reason: collision with root package name */
    e<?>[] f60911e = new e[0];

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: DanmakuFilters.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static abstract class a<T> implements e<T> {
        @Override // master.flame.danmaku.controller.b.e
        public void clear() {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: DanmakuFilters.java */
    /* renamed from: master.flame.danmaku.controller.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class C1236b extends a<Void> {

        /* renamed from: a  reason: collision with root package name */
        protected final master.flame.danmaku.danmaku.model.m f60912a = new master.flame.danmaku.danmaku.model.android.e(4);

        /* renamed from: b  reason: collision with root package name */
        protected final LinkedHashMap<String, master.flame.danmaku.danmaku.model.d> f60913b = new LinkedHashMap<>();

        /* renamed from: c  reason: collision with root package name */
        private final master.flame.danmaku.danmaku.model.m f60914c = new master.flame.danmaku.danmaku.model.android.e(4);

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: DanmakuFilters.java */
        /* renamed from: master.flame.danmaku.controller.b$b$a */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class a extends m.c<master.flame.danmaku.danmaku.model.d> {

            /* renamed from: e  reason: collision with root package name */
            long f60915e = g3.c.b();

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ long f60916f;

            a(long j4) {
                this.f60916f = j4;
            }

            @Override // master.flame.danmaku.danmaku.model.m.b
            /* renamed from: e */
            public int a(master.flame.danmaku.danmaku.model.d dVar) {
                if (g3.c.b() - this.f60915e > this.f60916f) {
                    return 1;
                }
                return dVar.w() ? 2 : 1;
            }
        }

        private void d(LinkedHashMap<String, master.flame.danmaku.danmaku.model.d> linkedHashMap, int i4) {
            Iterator<Map.Entry<String, master.flame.danmaku.danmaku.model.d>> it = linkedHashMap.entrySet().iterator();
            long b4 = g3.c.b();
            while (it.hasNext()) {
                try {
                    if (!it.next().getValue().w()) {
                        return;
                    }
                    it.remove();
                    if (g3.c.b() - b4 > i4) {
                        return;
                    }
                } catch (Exception unused) {
                    return;
                }
            }
        }

        private final void e(master.flame.danmaku.danmaku.model.m mVar, long j4) {
            mVar.a(new a(j4));
        }

        @Override // master.flame.danmaku.controller.b.e
        public boolean b(master.flame.danmaku.danmaku.model.d dVar, int i4, int i5, master.flame.danmaku.danmaku.model.f fVar, boolean z3, DanmakuContext danmakuContext) {
            boolean c4 = c(dVar, i4, i5, fVar, z3);
            if (c4) {
                dVar.G |= 128;
            }
            return c4;
        }

        public synchronized boolean c(master.flame.danmaku.danmaku.model.d dVar, int i4, int i5, master.flame.danmaku.danmaku.model.f fVar, boolean z3) {
            e(this.f60912a, 2L);
            e(this.f60914c, 2L);
            d(this.f60913b, 3);
            if (!this.f60912a.j(dVar) || dVar.s()) {
                if (this.f60914c.j(dVar)) {
                    return false;
                }
                if (this.f60913b.containsKey(dVar.f61148c)) {
                    this.f60913b.put(String.valueOf(dVar.f61148c), dVar);
                    this.f60912a.g(dVar);
                    this.f60912a.i(dVar);
                    return true;
                }
                this.f60913b.put(String.valueOf(dVar.f61148c), dVar);
                this.f60914c.i(dVar);
                return false;
            }
            return true;
        }

        @Override // master.flame.danmaku.controller.b.a, master.flame.danmaku.controller.b.e
        public void clear() {
            reset();
        }

        @Override // master.flame.danmaku.controller.b.e
        /* renamed from: f */
        public void a(Void r12) {
        }

        @Override // master.flame.danmaku.controller.b.e
        public synchronized void reset() {
            this.f60914c.clear();
            this.f60912a.clear();
            this.f60913b.clear();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: DanmakuFilters.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class c extends a<Object> {

        /* renamed from: a  reason: collision with root package name */
        long f60918a = 20;

        private synchronized boolean c(master.flame.danmaku.danmaku.model.d dVar, int i4, int i5, master.flame.danmaku.danmaku.model.f fVar, boolean z3) {
            if (fVar != null) {
                if (dVar.s()) {
                    return g3.c.b() - fVar.f61172a >= this.f60918a;
                }
            }
            return false;
        }

        @Override // master.flame.danmaku.controller.b.e
        public void a(Object obj) {
            reset();
        }

        @Override // master.flame.danmaku.controller.b.e
        public boolean b(master.flame.danmaku.danmaku.model.d dVar, int i4, int i5, master.flame.danmaku.danmaku.model.f fVar, boolean z3, DanmakuContext danmakuContext) {
            boolean c4 = c(dVar, i4, i5, fVar, z3);
            if (c4) {
                dVar.G |= 4;
            }
            return c4;
        }

        @Override // master.flame.danmaku.controller.b.a, master.flame.danmaku.controller.b.e
        public void clear() {
            reset();
        }

        @Override // master.flame.danmaku.controller.b.e
        public synchronized void reset() {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: DanmakuFilters.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class d extends a<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        private Boolean f60919a = Boolean.FALSE;

        @Override // master.flame.danmaku.controller.b.e
        public boolean b(master.flame.danmaku.danmaku.model.d dVar, int i4, int i5, master.flame.danmaku.danmaku.model.f fVar, boolean z3, DanmakuContext danmakuContext) {
            boolean z4 = this.f60919a.booleanValue() && dVar.D;
            if (z4) {
                dVar.G |= 64;
            }
            return z4;
        }

        @Override // master.flame.danmaku.controller.b.e
        /* renamed from: c */
        public void a(Boolean bool) {
            this.f60919a = bool;
        }

        @Override // master.flame.danmaku.controller.b.e
        public void reset() {
            this.f60919a = Boolean.FALSE;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: DanmakuFilters.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface e<T> {
        void a(T t3);

        boolean b(master.flame.danmaku.danmaku.model.d dVar, int i4, int i5, master.flame.danmaku.danmaku.model.f fVar, boolean z3, DanmakuContext danmakuContext);

        void clear();

        void reset();
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: DanmakuFilters.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class f extends a<Map<Integer, Integer>> {

        /* renamed from: a  reason: collision with root package name */
        private Map<Integer, Integer> f60920a;

        @Override // master.flame.danmaku.controller.b.e
        public boolean b(master.flame.danmaku.danmaku.model.d dVar, int i4, int i5, master.flame.danmaku.danmaku.model.f fVar, boolean z3, DanmakuContext danmakuContext) {
            Map<Integer, Integer> map = this.f60920a;
            boolean z4 = false;
            if (map != null) {
                Integer num = map.get(Integer.valueOf(dVar.getType()));
                if (num != null && i4 >= num.intValue()) {
                    z4 = true;
                }
                if (z4) {
                    dVar.G |= 256;
                }
            }
            return z4;
        }

        @Override // master.flame.danmaku.controller.b.e
        /* renamed from: c */
        public void a(Map<Integer, Integer> map) {
            this.f60920a = map;
        }

        @Override // master.flame.danmaku.controller.b.e
        public void reset() {
            this.f60920a = null;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: DanmakuFilters.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class g extends a<Map<Integer, Boolean>> {

        /* renamed from: a  reason: collision with root package name */
        private Map<Integer, Boolean> f60921a;

        @Override // master.flame.danmaku.controller.b.e
        public boolean b(master.flame.danmaku.danmaku.model.d dVar, int i4, int i5, master.flame.danmaku.danmaku.model.f fVar, boolean z3, DanmakuContext danmakuContext) {
            Map<Integer, Boolean> map = this.f60921a;
            boolean z4 = false;
            if (map != null) {
                Boolean bool = map.get(Integer.valueOf(dVar.getType()));
                if (bool != null && bool.booleanValue() && z3) {
                    z4 = true;
                }
                if (z4) {
                    dVar.G |= 512;
                }
            }
            return z4;
        }

        @Override // master.flame.danmaku.controller.b.e
        /* renamed from: c */
        public void a(Map<Integer, Boolean> map) {
            this.f60921a = map;
        }

        @Override // master.flame.danmaku.controller.b.e
        public void reset() {
            this.f60921a = null;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: DanmakuFilters.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class h extends a<Integer> {

        /* renamed from: a  reason: collision with root package name */
        protected int f60922a = -1;

        /* renamed from: b  reason: collision with root package name */
        protected master.flame.danmaku.danmaku.model.d f60923b = null;

        /* renamed from: c  reason: collision with root package name */
        private float f60924c = 1.0f;

        private boolean c(master.flame.danmaku.danmaku.model.d dVar, int i4, int i5, master.flame.danmaku.danmaku.model.f fVar, boolean z3, DanmakuContext danmakuContext) {
            if (this.f60922a > 0 && dVar.getType() == 1) {
                master.flame.danmaku.danmaku.model.d dVar2 = this.f60923b;
                if (dVar2 != null && !dVar2.w()) {
                    long b4 = dVar.b() - this.f60923b.b();
                    master.flame.danmaku.danmaku.model.g gVar = danmakuContext.D.f61101f;
                    if ((b4 < 0 || gVar == null || ((float) b4) >= ((float) gVar.f61176c) * this.f60924c) && i4 <= this.f60922a) {
                        this.f60923b = dVar;
                        return false;
                    }
                    return true;
                }
                this.f60923b = dVar;
            }
            return false;
        }

        @Override // master.flame.danmaku.controller.b.e
        public synchronized boolean b(master.flame.danmaku.danmaku.model.d dVar, int i4, int i5, master.flame.danmaku.danmaku.model.f fVar, boolean z3, DanmakuContext danmakuContext) {
            boolean c4;
            c4 = c(dVar, i4, i5, fVar, z3, danmakuContext);
            if (c4) {
                dVar.G |= 2;
            }
            return c4;
        }

        @Override // master.flame.danmaku.controller.b.a, master.flame.danmaku.controller.b.e
        public void clear() {
            reset();
        }

        @Override // master.flame.danmaku.controller.b.e
        /* renamed from: d */
        public void a(Integer num) {
            reset();
            if (num == null || num.intValue() == this.f60922a) {
                return;
            }
            int intValue = num.intValue() + (num.intValue() / 5);
            this.f60922a = intValue;
            this.f60924c = 1.0f / intValue;
        }

        @Override // master.flame.danmaku.controller.b.e
        public synchronized void reset() {
            this.f60923b = null;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: DanmakuFilters.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class i extends a<List<Integer>> {

        /* renamed from: a  reason: collision with root package name */
        public List<Integer> f60925a = new ArrayList();

        private void c(Integer num) {
            if (this.f60925a.contains(num)) {
                return;
            }
            this.f60925a.add(num);
        }

        @Override // master.flame.danmaku.controller.b.e
        public boolean b(master.flame.danmaku.danmaku.model.d dVar, int i4, int i5, master.flame.danmaku.danmaku.model.f fVar, boolean z3, DanmakuContext danmakuContext) {
            boolean z4 = (dVar == null || this.f60925a.contains(Integer.valueOf(dVar.f61152g))) ? false : true;
            if (z4) {
                dVar.G |= 8;
            }
            return z4;
        }

        @Override // master.flame.danmaku.controller.b.e
        /* renamed from: d */
        public void a(List<Integer> list) {
            reset();
            if (list != null) {
                for (Integer num : list) {
                    c(num);
                }
            }
        }

        @Override // master.flame.danmaku.controller.b.e
        public void reset() {
            this.f60925a.clear();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: DanmakuFilters.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class j extends a<List<Integer>> {

        /* renamed from: a  reason: collision with root package name */
        final List<Integer> f60926a = Collections.synchronizedList(new ArrayList());

        @Override // master.flame.danmaku.controller.b.e
        public boolean b(master.flame.danmaku.danmaku.model.d dVar, int i4, int i5, master.flame.danmaku.danmaku.model.f fVar, boolean z3, DanmakuContext danmakuContext) {
            boolean z4 = dVar != null && this.f60926a.contains(Integer.valueOf(dVar.getType()));
            if (z4) {
                dVar.G = 1 | dVar.G;
            }
            return z4;
        }

        public void c(Integer num) {
            if (this.f60926a.contains(num)) {
                this.f60926a.remove(num);
            }
        }

        public void d(Integer num) {
            if (this.f60926a.contains(num)) {
                return;
            }
            this.f60926a.add(num);
        }

        @Override // master.flame.danmaku.controller.b.e
        /* renamed from: e */
        public void a(List<Integer> list) {
            reset();
            if (list != null) {
                for (Integer num : list) {
                    d(num);
                }
            }
        }

        @Override // master.flame.danmaku.controller.b.e
        public void reset() {
            this.f60926a.clear();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: DanmakuFilters.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static abstract class k<T> extends a<List<T>> {

        /* renamed from: a  reason: collision with root package name */
        public List<T> f60927a = new ArrayList();

        private void c(T t3) {
            if (this.f60927a.contains(t3)) {
                return;
            }
            this.f60927a.add(t3);
        }

        @Override // master.flame.danmaku.controller.b.e
        public abstract boolean b(master.flame.danmaku.danmaku.model.d dVar, int i4, int i5, master.flame.danmaku.danmaku.model.f fVar, boolean z3, DanmakuContext danmakuContext);

        @Override // master.flame.danmaku.controller.b.e
        /* renamed from: d */
        public void a(List<T> list) {
            reset();
            if (list != null) {
                for (T t3 : list) {
                    c(t3);
                }
            }
        }

        @Override // master.flame.danmaku.controller.b.e
        public void reset() {
            this.f60927a.clear();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: DanmakuFilters.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class l extends k<String> {
        @Override // master.flame.danmaku.controller.b.k, master.flame.danmaku.controller.b.e
        public boolean b(master.flame.danmaku.danmaku.model.d dVar, int i4, int i5, master.flame.danmaku.danmaku.model.f fVar, boolean z3, DanmakuContext danmakuContext) {
            boolean z4 = dVar != null && this.f60927a.contains(dVar.C);
            if (z4) {
                dVar.G |= 32;
            }
            return z4;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: DanmakuFilters.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class m extends k<Integer> {
        @Override // master.flame.danmaku.controller.b.k, master.flame.danmaku.controller.b.e
        public boolean b(master.flame.danmaku.danmaku.model.d dVar, int i4, int i5, master.flame.danmaku.danmaku.model.f fVar, boolean z3, DanmakuContext danmakuContext) {
            boolean z4 = dVar != null && this.f60927a.contains(Integer.valueOf(dVar.B));
            if (z4) {
                dVar.G |= 16;
            }
            return z4;
        }
    }

    private void j() {
        try {
            throw this.f60907a;
        } catch (Exception unused) {
        }
    }

    public void a() {
        e<?>[] eVarArr;
        e<?>[] eVarArr2;
        for (e<?> eVar : this.f60910d) {
            if (eVar != null) {
                eVar.clear();
            }
        }
        for (e<?> eVar2 : this.f60911e) {
            if (eVar2 != null) {
                eVar2.clear();
            }
        }
    }

    public void b(master.flame.danmaku.danmaku.model.d dVar, int i4, int i5, master.flame.danmaku.danmaku.model.f fVar, boolean z3, DanmakuContext danmakuContext) {
        e<?>[] eVarArr;
        for (e<?> eVar : this.f60910d) {
            if (eVar != null) {
                boolean b4 = eVar.b(dVar, i4, i5, fVar, z3, danmakuContext);
                dVar.H = danmakuContext.B.f61181c;
                if (b4) {
                    return;
                }
            }
        }
    }

    public boolean c(master.flame.danmaku.danmaku.model.d dVar, int i4, int i5, master.flame.danmaku.danmaku.model.f fVar, boolean z3, DanmakuContext danmakuContext) {
        e<?>[] eVarArr;
        for (e<?> eVar : this.f60911e) {
            if (eVar != null) {
                boolean b4 = eVar.b(dVar, i4, i5, fVar, z3, danmakuContext);
                dVar.H = danmakuContext.B.f61181c;
                if (b4) {
                    return true;
                }
            }
        }
        return false;
    }

    public e<?> d(String str) {
        return e(str, true);
    }

    public e<?> e(String str, boolean z3) {
        e<?> eVar = (z3 ? this.f60908b : this.f60909c).get(str);
        return eVar == null ? g(str, z3) : eVar;
    }

    public e<?> f(String str) {
        return g(str, true);
    }

    public e<?> g(String str, boolean z3) {
        if (str == null) {
            j();
            return null;
        }
        e<?> eVar = this.f60908b.get(str);
        if (eVar == null) {
            if ("1010_Filter".equals(str)) {
                eVar = new j();
            } else if ("1011_Filter".equals(str)) {
                eVar = new h();
            } else if ("1012_Filter".equals(str)) {
                eVar = new c();
            } else if ("1013_Filter".equals(str)) {
                eVar = new i();
            } else if ("1014_Filter".equals(str)) {
                eVar = new m();
            } else if ("1015_Filter".equals(str)) {
                eVar = new l();
            } else if ("1016_Filter".equals(str)) {
                eVar = new d();
            } else if ("1017_Filter".equals(str)) {
                eVar = new C1236b();
            } else if ("1018_Filter".equals(str)) {
                eVar = new f();
            } else if ("1019_Filter".equals(str)) {
                eVar = new g();
            }
        }
        if (eVar == null) {
            j();
            return null;
        }
        eVar.a(null);
        if (z3) {
            this.f60908b.put(str, eVar);
            this.f60910d = (e[]) this.f60908b.values().toArray(this.f60910d);
        } else {
            this.f60909c.put(str, eVar);
            this.f60911e = (e[]) this.f60909c.values().toArray(this.f60911e);
        }
        return eVar;
    }

    public void h() {
        a();
        this.f60908b.clear();
        this.f60910d = new e[0];
        this.f60909c.clear();
        this.f60911e = new e[0];
    }

    public void i() {
        e<?>[] eVarArr;
        e<?>[] eVarArr2;
        for (e<?> eVar : this.f60910d) {
            if (eVar != null) {
                eVar.reset();
            }
        }
        for (e<?> eVar2 : this.f60911e) {
            if (eVar2 != null) {
                eVar2.reset();
            }
        }
    }

    public void k(String str) {
        l(str, true);
    }

    public void l(String str, boolean z3) {
        e<?> remove = (z3 ? this.f60908b : this.f60909c).remove(str);
        if (remove != null) {
            remove.clear();
            if (z3) {
                this.f60910d = (e[]) this.f60908b.values().toArray(this.f60910d);
            } else {
                this.f60911e = (e[]) this.f60909c.values().toArray(this.f60911e);
            }
        }
    }
}
