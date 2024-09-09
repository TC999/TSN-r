package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.bo;
import com.umeng.analytics.pro.br;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.by;
import com.umeng.analytics.pro.cd;
import com.umeng.analytics.pro.ce;
import com.umeng.analytics.pro.ck;
import com.umeng.analytics.pro.cl;
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
/* compiled from: IdSnapshot.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class b implements br<b, e>, Serializable, Cloneable {

    /* renamed from: d  reason: collision with root package name */
    public static final Map<e, cd> f53690d;

    /* renamed from: e  reason: collision with root package name */
    private static final long f53691e = -6496538196005191531L;

    /* renamed from: f  reason: collision with root package name */
    private static final cv f53692f = new cv("IdSnapshot");

    /* renamed from: g  reason: collision with root package name */
    private static final cl f53693g = new cl("identity", (byte) 11, 1);

    /* renamed from: h  reason: collision with root package name */
    private static final cl f53694h = new cl("ts", (byte) 10, 2);

    /* renamed from: i  reason: collision with root package name */
    private static final cl f53695i = new cl("version", (byte) 8, 3);

    /* renamed from: j  reason: collision with root package name */
    private static final Map<Class<? extends cy>, cz> f53696j;

    /* renamed from: k  reason: collision with root package name */
    private static final int f53697k = 0;

    /* renamed from: l  reason: collision with root package name */
    private static final int f53698l = 1;

    /* renamed from: a  reason: collision with root package name */
    public String f53699a;

    /* renamed from: b  reason: collision with root package name */
    public long f53700b;

    /* renamed from: c  reason: collision with root package name */
    public int f53701c;

    /* renamed from: m  reason: collision with root package name */
    private byte f53702m;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: IdSnapshot.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class a extends da<b> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: a */
        public void b(cq cqVar, b bVar) throws bx {
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
                        } else if (b4 == 8) {
                            bVar.f53701c = cqVar.w();
                            bVar.c(true);
                        } else {
                            ct.a(cqVar, b4);
                        }
                    } else if (b4 == 10) {
                        bVar.f53700b = cqVar.x();
                        bVar.b(true);
                    } else {
                        ct.a(cqVar, b4);
                    }
                } else if (b4 == 11) {
                    bVar.f53699a = cqVar.z();
                    bVar.a(true);
                } else {
                    ct.a(cqVar, b4);
                }
                cqVar.m();
            }
            cqVar.k();
            if (bVar.g()) {
                if (bVar.j()) {
                    bVar.k();
                    return;
                }
                throw new cr("Required field 'version' was not found in serialized data! Struct: " + toString());
            }
            throw new cr("Required field 'ts' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: b */
        public void a(cq cqVar, b bVar) throws bx {
            bVar.k();
            cqVar.a(b.f53692f);
            if (bVar.f53699a != null) {
                cqVar.a(b.f53693g);
                cqVar.a(bVar.f53699a);
                cqVar.c();
            }
            cqVar.a(b.f53694h);
            cqVar.a(bVar.f53700b);
            cqVar.c();
            cqVar.a(b.f53695i);
            cqVar.a(bVar.f53701c);
            cqVar.c();
            cqVar.d();
            cqVar.b();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: IdSnapshot.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static class C1063b implements cz {
        private C1063b() {
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
    /* compiled from: IdSnapshot.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class c extends db<b> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cy
        public void a(cq cqVar, b bVar) throws bx {
            cw cwVar = (cw) cqVar;
            cwVar.a(bVar.f53699a);
            cwVar.a(bVar.f53700b);
            cwVar.a(bVar.f53701c);
        }

        @Override // com.umeng.analytics.pro.cy
        public void b(cq cqVar, b bVar) throws bx {
            cw cwVar = (cw) cqVar;
            bVar.f53699a = cwVar.z();
            bVar.a(true);
            bVar.f53700b = cwVar.x();
            bVar.b(true);
            bVar.f53701c = cwVar.w();
            bVar.c(true);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: IdSnapshot.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static class d implements cz {
        private d() {
        }

        @Override // com.umeng.analytics.pro.cz
        /* renamed from: a */
        public c b() {
            return new c();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f53696j = hashMap;
        hashMap.put(da.class, new C1063b());
        hashMap.put(db.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.IDENTITY, (e) new cd("identity", (byte) 1, new ce((byte) 11)));
        enumMap.put((EnumMap) e.TS, (e) new cd("ts", (byte) 1, new ce((byte) 10)));
        enumMap.put((EnumMap) e.VERSION, (e) new cd("version", (byte) 1, new ce((byte) 8)));
        Map<e, cd> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f53690d = unmodifiableMap;
        cd.a(b.class, unmodifiableMap);
    }

    public b() {
        this.f53702m = (byte) 0;
    }

    @Override // com.umeng.analytics.pro.br
    /* renamed from: a */
    public b deepCopy() {
        return new b(this);
    }

    public String b() {
        return this.f53699a;
    }

    public void c() {
        this.f53699a = null;
    }

    @Override // com.umeng.analytics.pro.br
    public void clear() {
        this.f53699a = null;
        b(false);
        this.f53700b = 0L;
        c(false);
        this.f53701c = 0;
    }

    public boolean d() {
        return this.f53699a != null;
    }

    public long e() {
        return this.f53700b;
    }

    public void f() {
        this.f53702m = bo.b(this.f53702m, 0);
    }

    public boolean g() {
        return bo.a(this.f53702m, 0);
    }

    public int h() {
        return this.f53701c;
    }

    public void i() {
        this.f53702m = bo.b(this.f53702m, 1);
    }

    public boolean j() {
        return bo.a(this.f53702m, 1);
    }

    public void k() throws bx {
        if (this.f53699a != null) {
            return;
        }
        throw new cr("Required field 'identity' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.br
    public void read(cq cqVar) throws bx {
        f53696j.get(cqVar.D()).b().b(cqVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdSnapshot(");
        sb.append("identity:");
        String str = this.f53699a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.f53700b);
        sb.append(", ");
        sb.append("version:");
        sb.append(this.f53701c);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.br
    public void write(cq cqVar) throws bx {
        f53696j.get(cqVar.D()).b().a(cqVar, this);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: IdSnapshot.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public enum e implements by {
        IDENTITY(1, "identity"),
        TS(2, "ts"),
        VERSION(3, "version");
        

        /* renamed from: d  reason: collision with root package name */
        private static final Map<String, e> f53706d = new HashMap();

        /* renamed from: e  reason: collision with root package name */
        private final short f53708e;

        /* renamed from: f  reason: collision with root package name */
        private final String f53709f;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f53706d.put(eVar.b(), eVar);
            }
        }

        e(short s3, String str) {
            this.f53708e = s3;
            this.f53709f = str;
        }

        public static e a(int i4) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        return null;
                    }
                    return VERSION;
                }
                return TS;
            }
            return IDENTITY;
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
            return this.f53709f;
        }

        public static e a(String str) {
            return f53706d.get(str);
        }

        @Override // com.umeng.analytics.pro.by
        public short a() {
            return this.f53708e;
        }
    }

    public b a(String str) {
        this.f53699a = str;
        return this;
    }

    public void b(boolean z3) {
        this.f53702m = bo.a(this.f53702m, 0, z3);
    }

    public void c(boolean z3) {
        this.f53702m = bo.a(this.f53702m, 1, z3);
    }

    public b(String str, long j4, int i4) {
        this();
        this.f53699a = str;
        this.f53700b = j4;
        b(true);
        this.f53701c = i4;
        c(true);
    }

    public void a(boolean z3) {
        if (z3) {
            return;
        }
        this.f53699a = null;
    }

    @Override // com.umeng.analytics.pro.br
    /* renamed from: b */
    public e fieldForId(int i4) {
        return e.a(i4);
    }

    public b a(long j4) {
        this.f53700b = j4;
        b(true);
        return this;
    }

    public b a(int i4) {
        this.f53701c = i4;
        c(true);
        return this;
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new ck(new dc(objectOutputStream)));
        } catch (bx e4) {
            throw new IOException(e4.getMessage());
        }
    }

    public b(b bVar) {
        this.f53702m = (byte) 0;
        this.f53702m = bVar.f53702m;
        if (bVar.d()) {
            this.f53699a = bVar.f53699a;
        }
        this.f53700b = bVar.f53700b;
        this.f53701c = bVar.f53701c;
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f53702m = (byte) 0;
            read(new ck(new dc(objectInputStream)));
        } catch (bx e4) {
            throw new IOException(e4.getMessage());
        }
    }
}
