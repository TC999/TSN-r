package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.bo;
import com.umeng.analytics.pro.br;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.by;
import com.umeng.analytics.pro.cd;
import com.umeng.analytics.pro.ce;
import com.umeng.analytics.pro.cg;
import com.umeng.analytics.pro.ci;
import com.umeng.analytics.pro.ck;
import com.umeng.analytics.pro.cl;
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
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: Imprint.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class d implements br<d, e>, Serializable, Cloneable {

    /* renamed from: d  reason: collision with root package name */
    public static final Map<e, cd> f53728d;

    /* renamed from: e  reason: collision with root package name */
    private static final long f53729e = 2846460275012375038L;

    /* renamed from: f  reason: collision with root package name */
    private static final cv f53730f = new cv("Imprint");

    /* renamed from: g  reason: collision with root package name */
    private static final cl f53731g = new cl("property", (byte) 13, 1);

    /* renamed from: h  reason: collision with root package name */
    private static final cl f53732h = new cl("version", (byte) 8, 2);

    /* renamed from: i  reason: collision with root package name */
    private static final cl f53733i = new cl("checksum", (byte) 11, 3);

    /* renamed from: j  reason: collision with root package name */
    private static final Map<Class<? extends cy>, cz> f53734j;

    /* renamed from: k  reason: collision with root package name */
    private static final int f53735k = 0;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, com.umeng.commonsdk.statistics.proto.e> f53736a;

    /* renamed from: b  reason: collision with root package name */
    public int f53737b;

    /* renamed from: c  reason: collision with root package name */
    public String f53738c;

    /* renamed from: l  reason: collision with root package name */
    private byte f53739l;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: Imprint.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class a extends da<d> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: a */
        public void b(cq cqVar, d dVar) throws bx {
            cqVar.j();
            while (true) {
                cl l4 = cqVar.l();
                byte b4 = l4.f52815b;
                if (b4 == 0) {
                    break;
                }
                short s3 = l4.f52816c;
                if (s3 != 1) {
                    if (s3 != 2) {
                        if (s3 != 3) {
                            ct.a(cqVar, b4);
                        } else if (b4 == 11) {
                            dVar.f53738c = cqVar.z();
                            dVar.c(true);
                        } else {
                            ct.a(cqVar, b4);
                        }
                    } else if (b4 == 8) {
                        dVar.f53737b = cqVar.w();
                        dVar.b(true);
                    } else {
                        ct.a(cqVar, b4);
                    }
                } else if (b4 == 13) {
                    cn n4 = cqVar.n();
                    dVar.f53736a = new HashMap(n4.f52821c * 2);
                    for (int i4 = 0; i4 < n4.f52821c; i4++) {
                        String z3 = cqVar.z();
                        com.umeng.commonsdk.statistics.proto.e eVar = new com.umeng.commonsdk.statistics.proto.e();
                        eVar.read(cqVar);
                        dVar.f53736a.put(z3, eVar);
                    }
                    cqVar.o();
                    dVar.a(true);
                } else {
                    ct.a(cqVar, b4);
                }
                cqVar.m();
            }
            cqVar.k();
            if (dVar.h()) {
                dVar.l();
                return;
            }
            throw new cr("Required field 'version' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: b */
        public void a(cq cqVar, d dVar) throws bx {
            dVar.l();
            cqVar.a(d.f53730f);
            if (dVar.f53736a != null) {
                cqVar.a(d.f53731g);
                cqVar.a(new cn((byte) 11, (byte) 12, dVar.f53736a.size()));
                for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.f53736a.entrySet()) {
                    cqVar.a(entry.getKey());
                    entry.getValue().write(cqVar);
                }
                cqVar.e();
                cqVar.c();
            }
            cqVar.a(d.f53732h);
            cqVar.a(dVar.f53737b);
            cqVar.c();
            if (dVar.f53738c != null) {
                cqVar.a(d.f53733i);
                cqVar.a(dVar.f53738c);
                cqVar.c();
            }
            cqVar.d();
            cqVar.b();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: Imprint.java */
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
    /* compiled from: Imprint.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class c extends db<d> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cy
        public void a(cq cqVar, d dVar) throws bx {
            cw cwVar = (cw) cqVar;
            cwVar.a(dVar.f53736a.size());
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.f53736a.entrySet()) {
                cwVar.a(entry.getKey());
                entry.getValue().write(cwVar);
            }
            cwVar.a(dVar.f53737b);
            cwVar.a(dVar.f53738c);
        }

        @Override // com.umeng.analytics.pro.cy
        public void b(cq cqVar, d dVar) throws bx {
            cw cwVar = (cw) cqVar;
            cn cnVar = new cn((byte) 11, (byte) 12, cwVar.w());
            dVar.f53736a = new HashMap(cnVar.f52821c * 2);
            for (int i4 = 0; i4 < cnVar.f52821c; i4++) {
                String z3 = cwVar.z();
                com.umeng.commonsdk.statistics.proto.e eVar = new com.umeng.commonsdk.statistics.proto.e();
                eVar.read(cwVar);
                dVar.f53736a.put(z3, eVar);
            }
            dVar.a(true);
            dVar.f53737b = cwVar.w();
            dVar.b(true);
            dVar.f53738c = cwVar.z();
            dVar.c(true);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: Imprint.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.d$d  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static class C1065d implements cz {
        private C1065d() {
        }

        @Override // com.umeng.analytics.pro.cz
        /* renamed from: a */
        public c b() {
            return new c();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f53734j = hashMap;
        hashMap.put(da.class, new b());
        hashMap.put(db.class, new C1065d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.PROPERTY, (e) new cd("property", (byte) 1, new cg((byte) 13, new ce((byte) 11), new ci((byte) 12, com.umeng.commonsdk.statistics.proto.e.class))));
        enumMap.put((EnumMap) e.VERSION, (e) new cd("version", (byte) 1, new ce((byte) 8)));
        enumMap.put((EnumMap) e.CHECKSUM, (e) new cd("checksum", (byte) 1, new ce((byte) 11)));
        Map<e, cd> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f53728d = unmodifiableMap;
        cd.a(d.class, unmodifiableMap);
    }

    public d() {
        this.f53739l = (byte) 0;
    }

    @Override // com.umeng.analytics.pro.br
    /* renamed from: a */
    public d deepCopy() {
        return new d(this);
    }

    public int b() {
        Map<String, com.umeng.commonsdk.statistics.proto.e> map = this.f53736a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    public Map<String, com.umeng.commonsdk.statistics.proto.e> c() {
        return this.f53736a;
    }

    @Override // com.umeng.analytics.pro.br
    public void clear() {
        this.f53736a = null;
        b(false);
        this.f53737b = 0;
        this.f53738c = null;
    }

    public void d() {
        this.f53736a = null;
    }

    public boolean e() {
        return this.f53736a != null;
    }

    public int f() {
        return this.f53737b;
    }

    public void g() {
        this.f53739l = bo.b(this.f53739l, 0);
    }

    public boolean h() {
        return bo.a(this.f53739l, 0);
    }

    public String i() {
        return this.f53738c;
    }

    public void j() {
        this.f53738c = null;
    }

    public boolean k() {
        return this.f53738c != null;
    }

    public void l() throws bx {
        if (this.f53736a != null) {
            if (this.f53738c != null) {
                return;
            }
            throw new cr("Required field 'checksum' was not present! Struct: " + toString());
        }
        throw new cr("Required field 'property' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.br
    public void read(cq cqVar) throws bx {
        f53734j.get(cqVar.D()).b().b(cqVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Imprint(");
        sb.append("property:");
        Map<String, com.umeng.commonsdk.statistics.proto.e> map = this.f53736a;
        if (map == null) {
            sb.append("null");
        } else {
            sb.append(map);
        }
        sb.append(", ");
        sb.append("version:");
        sb.append(this.f53737b);
        sb.append(", ");
        sb.append("checksum:");
        String str = this.f53738c;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.br
    public void write(cq cqVar) throws bx {
        f53734j.get(cqVar.D()).b().a(cqVar, this);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: Imprint.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public enum e implements by {
        PROPERTY(1, "property"),
        VERSION(2, "version"),
        CHECKSUM(3, "checksum");
        

        /* renamed from: d  reason: collision with root package name */
        private static final Map<String, e> f53743d = new HashMap();

        /* renamed from: e  reason: collision with root package name */
        private final short f53745e;

        /* renamed from: f  reason: collision with root package name */
        private final String f53746f;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f53743d.put(eVar.b(), eVar);
            }
        }

        e(short s3, String str) {
            this.f53745e = s3;
            this.f53746f = str;
        }

        public static e a(int i4) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        return null;
                    }
                    return CHECKSUM;
                }
                return VERSION;
            }
            return PROPERTY;
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
            return this.f53746f;
        }

        public static e a(String str) {
            return f53743d.get(str);
        }

        @Override // com.umeng.analytics.pro.by
        public short a() {
            return this.f53745e;
        }
    }

    public void a(String str, com.umeng.commonsdk.statistics.proto.e eVar) {
        if (this.f53736a == null) {
            this.f53736a = new HashMap();
        }
        this.f53736a.put(str, eVar);
    }

    public void b(boolean z3) {
        this.f53739l = bo.a(this.f53739l, 0, z3);
    }

    public void c(boolean z3) {
        if (z3) {
            return;
        }
        this.f53738c = null;
    }

    public d(Map<String, com.umeng.commonsdk.statistics.proto.e> map, int i4, String str) {
        this();
        this.f53736a = map;
        this.f53737b = i4;
        b(true);
        this.f53738c = str;
    }

    @Override // com.umeng.analytics.pro.br
    /* renamed from: b */
    public e fieldForId(int i4) {
        return e.a(i4);
    }

    public d a(Map<String, com.umeng.commonsdk.statistics.proto.e> map) {
        this.f53736a = map;
        return this;
    }

    public void a(boolean z3) {
        if (z3) {
            return;
        }
        this.f53736a = null;
    }

    public d a(int i4) {
        this.f53737b = i4;
        b(true);
        return this;
    }

    public d(d dVar) {
        this.f53739l = (byte) 0;
        this.f53739l = dVar.f53739l;
        if (dVar.e()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, com.umeng.commonsdk.statistics.proto.e> entry : dVar.f53736a.entrySet()) {
                hashMap.put(entry.getKey(), new com.umeng.commonsdk.statistics.proto.e(entry.getValue()));
            }
            this.f53736a = hashMap;
        }
        this.f53737b = dVar.f53737b;
        if (dVar.k()) {
            this.f53738c = dVar.f53738c;
        }
    }

    public d a(String str) {
        this.f53738c = str;
        return this;
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
            this.f53739l = (byte) 0;
            read(new ck(new dc(objectInputStream)));
        } catch (bx e4) {
            throw new IOException(e4.getMessage());
        }
    }
}
