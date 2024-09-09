package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.br;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.by;
import com.umeng.analytics.pro.cd;
import com.umeng.analytics.pro.ce;
import com.umeng.analytics.pro.cf;
import com.umeng.analytics.pro.cg;
import com.umeng.analytics.pro.ci;
import com.umeng.analytics.pro.ck;
import com.umeng.analytics.pro.cl;
import com.umeng.analytics.pro.cm;
import com.umeng.analytics.pro.cn;
import com.umeng.analytics.pro.cq;
import com.umeng.analytics.pro.cr;
import com.umeng.analytics.pro.ct;
import com.umeng.analytics.pro.cv;
import com.umeng.analytics.pro.cw;
import com.umeng.analytics.pro.cy;
import com.umeng.analytics.pro.cz;
import com.umeng.analytics.pro.da;
import com.umeng.analytics.pro.db;
import com.umeng.analytics.pro.dc;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: IdTracking.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class c implements br<c, e>, Serializable, Cloneable {

    /* renamed from: d  reason: collision with root package name */
    public static final Map<e, cd> f53710d;

    /* renamed from: e  reason: collision with root package name */
    private static final long f53711e = -5764118265293965743L;

    /* renamed from: f  reason: collision with root package name */
    private static final cv f53712f = new cv("IdTracking");

    /* renamed from: g  reason: collision with root package name */
    private static final cl f53713g = new cl("snapshots", (byte) 13, 1);

    /* renamed from: h  reason: collision with root package name */
    private static final cl f53714h = new cl("journals", (byte) 15, 2);

    /* renamed from: i  reason: collision with root package name */
    private static final cl f53715i = new cl("checksum", (byte) 11, 3);

    /* renamed from: j  reason: collision with root package name */
    private static final Map<Class<? extends cy>, cz> f53716j;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, com.umeng.commonsdk.statistics.proto.b> f53717a;

    /* renamed from: b  reason: collision with root package name */
    public List<com.umeng.commonsdk.statistics.proto.a> f53718b;

    /* renamed from: c  reason: collision with root package name */
    public String f53719c;

    /* renamed from: k  reason: collision with root package name */
    private e[] f53720k;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: IdTracking.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class a extends da<c> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: a */
        public void b(cq cqVar, c cVar) throws bx {
            cqVar.j();
            while (true) {
                cl l4 = cqVar.l();
                byte b4 = l4.f52815b;
                if (b4 == 0) {
                    cqVar.k();
                    cVar.n();
                    return;
                }
                short s3 = l4.f52816c;
                int i4 = 0;
                if (s3 != 1) {
                    if (s3 != 2) {
                        if (s3 != 3) {
                            ct.a(cqVar, b4);
                        } else if (b4 == 11) {
                            cVar.f53719c = cqVar.z();
                            cVar.c(true);
                        } else {
                            ct.a(cqVar, b4);
                        }
                    } else if (b4 == 15) {
                        cm p3 = cqVar.p();
                        cVar.f53718b = new ArrayList(p3.f52818b);
                        while (i4 < p3.f52818b) {
                            com.umeng.commonsdk.statistics.proto.a aVar = new com.umeng.commonsdk.statistics.proto.a();
                            aVar.read(cqVar);
                            cVar.f53718b.add(aVar);
                            i4++;
                        }
                        cqVar.q();
                        cVar.b(true);
                    } else {
                        ct.a(cqVar, b4);
                    }
                } else if (b4 == 13) {
                    cn n4 = cqVar.n();
                    cVar.f53717a = new HashMap(n4.f52821c * 2);
                    while (i4 < n4.f52821c) {
                        String z3 = cqVar.z();
                        com.umeng.commonsdk.statistics.proto.b bVar = new com.umeng.commonsdk.statistics.proto.b();
                        bVar.read(cqVar);
                        cVar.f53717a.put(z3, bVar);
                        i4++;
                    }
                    cqVar.o();
                    cVar.a(true);
                } else {
                    ct.a(cqVar, b4);
                }
                cqVar.m();
            }
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: b */
        public void a(cq cqVar, c cVar) throws bx {
            cVar.n();
            cqVar.a(c.f53712f);
            if (cVar.f53717a != null) {
                cqVar.a(c.f53713g);
                cqVar.a(new cn((byte) 11, (byte) 12, cVar.f53717a.size()));
                for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.f53717a.entrySet()) {
                    cqVar.a(entry.getKey());
                    entry.getValue().write(cqVar);
                }
                cqVar.e();
                cqVar.c();
            }
            if (cVar.f53718b != null && cVar.j()) {
                cqVar.a(c.f53714h);
                cqVar.a(new cm((byte) 12, cVar.f53718b.size()));
                for (com.umeng.commonsdk.statistics.proto.a aVar : cVar.f53718b) {
                    aVar.write(cqVar);
                }
                cqVar.f();
                cqVar.c();
            }
            if (cVar.f53719c != null && cVar.m()) {
                cqVar.a(c.f53715i);
                cqVar.a(cVar.f53719c);
                cqVar.c();
            }
            cqVar.d();
            cqVar.b();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: IdTracking.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static class b implements cz {
        private b() {
        }

        @Override // com.umeng.analytics.pro.cz
        /* renamed from: a */
        public a b() {
            return new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: IdTracking.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class C1064c extends db<c> {
        private C1064c() {
        }

        @Override // com.umeng.analytics.pro.cy
        public void a(cq cqVar, c cVar) throws bx {
            cw cwVar = (cw) cqVar;
            cwVar.a(cVar.f53717a.size());
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.f53717a.entrySet()) {
                cwVar.a(entry.getKey());
                entry.getValue().write(cwVar);
            }
            BitSet bitSet = new BitSet();
            if (cVar.j()) {
                bitSet.set(0);
            }
            if (cVar.m()) {
                bitSet.set(1);
            }
            cwVar.a(bitSet, 2);
            if (cVar.j()) {
                cwVar.a(cVar.f53718b.size());
                for (com.umeng.commonsdk.statistics.proto.a aVar : cVar.f53718b) {
                    aVar.write(cwVar);
                }
            }
            if (cVar.m()) {
                cwVar.a(cVar.f53719c);
            }
        }

        @Override // com.umeng.analytics.pro.cy
        public void b(cq cqVar, c cVar) throws bx {
            cw cwVar = (cw) cqVar;
            cn cnVar = new cn((byte) 11, (byte) 12, cwVar.w());
            cVar.f53717a = new HashMap(cnVar.f52821c * 2);
            for (int i4 = 0; i4 < cnVar.f52821c; i4++) {
                String z3 = cwVar.z();
                com.umeng.commonsdk.statistics.proto.b bVar = new com.umeng.commonsdk.statistics.proto.b();
                bVar.read(cwVar);
                cVar.f53717a.put(z3, bVar);
            }
            cVar.a(true);
            BitSet b4 = cwVar.b(2);
            if (b4.get(0)) {
                cm cmVar = new cm((byte) 12, cwVar.w());
                cVar.f53718b = new ArrayList(cmVar.f52818b);
                for (int i5 = 0; i5 < cmVar.f52818b; i5++) {
                    com.umeng.commonsdk.statistics.proto.a aVar = new com.umeng.commonsdk.statistics.proto.a();
                    aVar.read(cwVar);
                    cVar.f53718b.add(aVar);
                }
                cVar.b(true);
            }
            if (b4.get(1)) {
                cVar.f53719c = cwVar.z();
                cVar.c(true);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: IdTracking.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static class d implements cz {
        private d() {
        }

        @Override // com.umeng.analytics.pro.cz
        /* renamed from: a */
        public C1064c b() {
            return new C1064c();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f53716j = hashMap;
        hashMap.put(da.class, new b());
        hashMap.put(db.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.SNAPSHOTS, (e) new cd("snapshots", (byte) 1, new cg((byte) 13, new ce((byte) 11), new ci((byte) 12, com.umeng.commonsdk.statistics.proto.b.class))));
        enumMap.put((EnumMap) e.JOURNALS, (e) new cd("journals", (byte) 2, new cf((byte) 15, new ci((byte) 12, com.umeng.commonsdk.statistics.proto.a.class))));
        enumMap.put((EnumMap) e.CHECKSUM, (e) new cd("checksum", (byte) 2, new ce((byte) 11)));
        Map<e, cd> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f53710d = unmodifiableMap;
        cd.a(c.class, unmodifiableMap);
    }

    public c() {
        this.f53720k = new e[]{e.JOURNALS, e.CHECKSUM};
    }

    @Override // com.umeng.analytics.pro.br
    /* renamed from: a */
    public c deepCopy() {
        return new c(this);
    }

    public int b() {
        Map<String, com.umeng.commonsdk.statistics.proto.b> map = this.f53717a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public Map<String, com.umeng.commonsdk.statistics.proto.b> c() {
        return this.f53717a;
    }

    @Override // com.umeng.analytics.pro.br
    public void clear() {
        this.f53717a = null;
        this.f53718b = null;
        this.f53719c = null;
    }

    public void d() {
        this.f53717a = null;
    }

    public boolean e() {
        return this.f53717a != null;
    }

    public int f() {
        List<com.umeng.commonsdk.statistics.proto.a> list = this.f53718b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public Iterator<com.umeng.commonsdk.statistics.proto.a> g() {
        List<com.umeng.commonsdk.statistics.proto.a> list = this.f53718b;
        if (list == null) {
            return null;
        }
        return list.iterator();
    }

    public List<com.umeng.commonsdk.statistics.proto.a> h() {
        return this.f53718b;
    }

    public void i() {
        this.f53718b = null;
    }

    public boolean j() {
        return this.f53718b != null;
    }

    public String k() {
        return this.f53719c;
    }

    public void l() {
        this.f53719c = null;
    }

    public boolean m() {
        return this.f53719c != null;
    }

    public void n() throws bx {
        if (this.f53717a != null) {
            return;
        }
        throw new cr("Required field 'snapshots' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.br
    public void read(cq cqVar) throws bx {
        f53716j.get(cqVar.D()).b().b(cqVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdTracking(");
        sb.append("snapshots:");
        Map<String, com.umeng.commonsdk.statistics.proto.b> map = this.f53717a;
        if (map == null) {
            sb.append("null");
        } else {
            sb.append(map);
        }
        if (j()) {
            sb.append(", ");
            sb.append("journals:");
            List<com.umeng.commonsdk.statistics.proto.a> list = this.f53718b;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        if (m()) {
            sb.append(", ");
            sb.append("checksum:");
            String str = this.f53719c;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.br
    public void write(cq cqVar) throws bx {
        f53716j.get(cqVar.D()).b().a(cqVar, this);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: IdTracking.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public enum e implements by {
        SNAPSHOTS(1, "snapshots"),
        JOURNALS(2, "journals"),
        CHECKSUM(3, "checksum");
        

        /* renamed from: d  reason: collision with root package name */
        private static final Map<String, e> f53724d = new HashMap();

        /* renamed from: e  reason: collision with root package name */
        private final short f53726e;

        /* renamed from: f  reason: collision with root package name */
        private final String f53727f;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f53724d.put(eVar.b(), eVar);
            }
        }

        e(short s3, String str) {
            this.f53726e = s3;
            this.f53727f = str;
        }

        public static e a(int i4) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        return null;
                    }
                    return CHECKSUM;
                }
                return JOURNALS;
            }
            return SNAPSHOTS;
        }

        public static e b(int i4) {
            e a4 = a(i4);
            if (a4 != null) {
                return a4;
            }
            throw new IllegalArgumentException("Field " + i4 + " doesn't exist!");
        }

        @Override // com.umeng.analytics.pro.by
        public String b() {
            return this.f53727f;
        }

        public static e a(String str) {
            return f53724d.get(str);
        }

        @Override // com.umeng.analytics.pro.by
        public short a() {
            return this.f53726e;
        }
    }

    public void a(String str, com.umeng.commonsdk.statistics.proto.b bVar) {
        if (this.f53717a == null) {
            this.f53717a = new HashMap();
        }
        this.f53717a.put(str, bVar);
    }

    public void b(boolean z3) {
        if (z3) {
            return;
        }
        this.f53718b = null;
    }

    public void c(boolean z3) {
        if (z3) {
            return;
        }
        this.f53719c = null;
    }

    public c(Map<String, com.umeng.commonsdk.statistics.proto.b> map) {
        this();
        this.f53717a = map;
    }

    public c(c cVar) {
        this.f53720k = new e[]{e.JOURNALS, e.CHECKSUM};
        if (cVar.e()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.b> entry : cVar.f53717a.entrySet()) {
                hashMap.put(entry.getKey(), new com.umeng.commonsdk.statistics.proto.b(entry.getValue()));
            }
            this.f53717a = hashMap;
        }
        if (cVar.j()) {
            ArrayList arrayList = new ArrayList();
            for (com.umeng.commonsdk.statistics.proto.a aVar : cVar.f53718b) {
                arrayList.add(new com.umeng.commonsdk.statistics.proto.a(aVar));
            }
            this.f53718b = arrayList;
        }
        if (cVar.m()) {
            this.f53719c = cVar.f53719c;
        }
    }

    public c a(Map<String, com.umeng.commonsdk.statistics.proto.b> map) {
        this.f53717a = map;
        return this;
    }

    public void a(boolean z3) {
        if (z3) {
            return;
        }
        this.f53717a = null;
    }

    public void a(com.umeng.commonsdk.statistics.proto.a aVar) {
        if (this.f53718b == null) {
            this.f53718b = new ArrayList();
        }
        this.f53718b.add(aVar);
    }

    public c a(List<com.umeng.commonsdk.statistics.proto.a> list) {
        this.f53718b = list;
        return this;
    }

    public c a(String str) {
        this.f53719c = str;
        return this;
    }

    @Override // com.umeng.analytics.pro.br
    /* renamed from: a */
    public e fieldForId(int i4) {
        return e.a(i4);
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new ck(new dc(objectOutputStream)));
        } catch (bx e4) {
            throw new IOException(e4.getMessage());
        }
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            read(new ck(new dc(objectInputStream)));
        } catch (bx e4) {
            throw new IOException(e4.getMessage());
        }
    }
}
