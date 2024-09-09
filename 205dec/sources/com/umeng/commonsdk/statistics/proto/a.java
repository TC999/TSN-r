package com.umeng.commonsdk.statistics.proto;

import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
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
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: IdJournal.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a implements br<a, e>, Serializable, Cloneable {

    /* renamed from: e  reason: collision with root package name */
    public static final Map<e, cd> f53667e;

    /* renamed from: f  reason: collision with root package name */
    private static final long f53668f = 9132678615281394583L;

    /* renamed from: g  reason: collision with root package name */
    private static final cv f53669g = new cv("IdJournal");

    /* renamed from: h  reason: collision with root package name */
    private static final cl f53670h = new cl(DomainCampaignEx.LOOPBACK_DOMAIN, (byte) 11, 1);

    /* renamed from: i  reason: collision with root package name */
    private static final cl f53671i = new cl("old_id", (byte) 11, 2);

    /* renamed from: j  reason: collision with root package name */
    private static final cl f53672j = new cl("new_id", (byte) 11, 3);

    /* renamed from: k  reason: collision with root package name */
    private static final cl f53673k = new cl("ts", (byte) 10, 4);

    /* renamed from: l  reason: collision with root package name */
    private static final Map<Class<? extends cy>, cz> f53674l;

    /* renamed from: m  reason: collision with root package name */
    private static final int f53675m = 0;

    /* renamed from: a  reason: collision with root package name */
    public String f53676a;

    /* renamed from: b  reason: collision with root package name */
    public String f53677b;

    /* renamed from: c  reason: collision with root package name */
    public String f53678c;

    /* renamed from: d  reason: collision with root package name */
    public long f53679d;

    /* renamed from: n  reason: collision with root package name */
    private byte f53680n;

    /* renamed from: o  reason: collision with root package name */
    private e[] f53681o;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: IdJournal.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class C1062a extends da<a> {
        private C1062a() {
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: a */
        public void b(cq cqVar, a aVar) throws bx {
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
                            if (s3 != 4) {
                                ct.a(cqVar, b4);
                            } else if (b4 == 10) {
                                aVar.f53679d = cqVar.x();
                                aVar.d(true);
                            } else {
                                ct.a(cqVar, b4);
                            }
                        } else if (b4 == 11) {
                            aVar.f53678c = cqVar.z();
                            aVar.c(true);
                        } else {
                            ct.a(cqVar, b4);
                        }
                    } else if (b4 == 11) {
                        aVar.f53677b = cqVar.z();
                        aVar.b(true);
                    } else {
                        ct.a(cqVar, b4);
                    }
                } else if (b4 == 11) {
                    aVar.f53676a = cqVar.z();
                    aVar.a(true);
                } else {
                    ct.a(cqVar, b4);
                }
                cqVar.m();
            }
            cqVar.k();
            if (aVar.m()) {
                aVar.n();
                return;
            }
            throw new cr("Required field 'ts' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: b */
        public void a(cq cqVar, a aVar) throws bx {
            aVar.n();
            cqVar.a(a.f53669g);
            if (aVar.f53676a != null) {
                cqVar.a(a.f53670h);
                cqVar.a(aVar.f53676a);
                cqVar.c();
            }
            if (aVar.f53677b != null && aVar.g()) {
                cqVar.a(a.f53671i);
                cqVar.a(aVar.f53677b);
                cqVar.c();
            }
            if (aVar.f53678c != null) {
                cqVar.a(a.f53672j);
                cqVar.a(aVar.f53678c);
                cqVar.c();
            }
            cqVar.a(a.f53673k);
            cqVar.a(aVar.f53679d);
            cqVar.c();
            cqVar.d();
            cqVar.b();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: IdJournal.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static class b implements cz {
        private b() {
        }

        @Override // com.umeng.analytics.pro.cz
        /* renamed from: a */
        public C1062a b() {
            return new C1062a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: IdJournal.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class c extends db<a> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cy
        public void a(cq cqVar, a aVar) throws bx {
            cw cwVar = (cw) cqVar;
            cwVar.a(aVar.f53676a);
            cwVar.a(aVar.f53678c);
            cwVar.a(aVar.f53679d);
            BitSet bitSet = new BitSet();
            if (aVar.g()) {
                bitSet.set(0);
            }
            cwVar.a(bitSet, 1);
            if (aVar.g()) {
                cwVar.a(aVar.f53677b);
            }
        }

        @Override // com.umeng.analytics.pro.cy
        public void b(cq cqVar, a aVar) throws bx {
            cw cwVar = (cw) cqVar;
            aVar.f53676a = cwVar.z();
            aVar.a(true);
            aVar.f53678c = cwVar.z();
            aVar.c(true);
            aVar.f53679d = cwVar.x();
            aVar.d(true);
            if (cwVar.b(1).get(0)) {
                aVar.f53677b = cwVar.z();
                aVar.b(true);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: IdJournal.java */
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
        f53674l = hashMap;
        hashMap.put(da.class, new b());
        hashMap.put(db.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.DOMAIN, (e) new cd(DomainCampaignEx.LOOPBACK_DOMAIN, (byte) 1, new ce((byte) 11)));
        enumMap.put((EnumMap) e.OLD_ID, (e) new cd("old_id", (byte) 2, new ce((byte) 11)));
        enumMap.put((EnumMap) e.NEW_ID, (e) new cd("new_id", (byte) 1, new ce((byte) 11)));
        enumMap.put((EnumMap) e.TS, (e) new cd("ts", (byte) 1, new ce((byte) 10)));
        Map<e, cd> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f53667e = unmodifiableMap;
        cd.a(a.class, unmodifiableMap);
    }

    public a() {
        this.f53680n = (byte) 0;
        this.f53681o = new e[]{e.OLD_ID};
    }

    @Override // com.umeng.analytics.pro.br
    /* renamed from: a */
    public a deepCopy() {
        return new a(this);
    }

    public String b() {
        return this.f53676a;
    }

    public void c() {
        this.f53676a = null;
    }

    @Override // com.umeng.analytics.pro.br
    public void clear() {
        this.f53676a = null;
        this.f53677b = null;
        this.f53678c = null;
        d(false);
        this.f53679d = 0L;
    }

    public boolean d() {
        return this.f53676a != null;
    }

    public String e() {
        return this.f53677b;
    }

    public void f() {
        this.f53677b = null;
    }

    public boolean g() {
        return this.f53677b != null;
    }

    public String h() {
        return this.f53678c;
    }

    public void i() {
        this.f53678c = null;
    }

    public boolean j() {
        return this.f53678c != null;
    }

    public long k() {
        return this.f53679d;
    }

    public void l() {
        this.f53680n = bo.b(this.f53680n, 0);
    }

    public boolean m() {
        return bo.a(this.f53680n, 0);
    }

    public void n() throws bx {
        if (this.f53676a != null) {
            if (this.f53678c != null) {
                return;
            }
            throw new cr("Required field 'new_id' was not present! Struct: " + toString());
        }
        throw new cr("Required field 'domain' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.br
    public void read(cq cqVar) throws bx {
        f53674l.get(cqVar.D()).b().b(cqVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdJournal(");
        sb.append("domain:");
        String str = this.f53676a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (g()) {
            sb.append(", ");
            sb.append("old_id:");
            String str2 = this.f53677b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("new_id:");
        String str3 = this.f53678c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.f53679d);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.br
    public void write(cq cqVar) throws bx {
        f53674l.get(cqVar.D()).b().a(cqVar, this);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: IdJournal.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public enum e implements by {
        DOMAIN(1, DomainCampaignEx.LOOPBACK_DOMAIN),
        OLD_ID(2, "old_id"),
        NEW_ID(3, "new_id"),
        TS(4, "ts");
        

        /* renamed from: e  reason: collision with root package name */
        private static final Map<String, e> f53686e = new HashMap();

        /* renamed from: f  reason: collision with root package name */
        private final short f53688f;

        /* renamed from: g  reason: collision with root package name */
        private final String f53689g;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f53686e.put(eVar.b(), eVar);
            }
        }

        e(short s3, String str) {
            this.f53688f = s3;
            this.f53689g = str;
        }

        public static e a(int i4) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 != 4) {
                            return null;
                        }
                        return TS;
                    }
                    return NEW_ID;
                }
                return OLD_ID;
            }
            return DOMAIN;
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
            return this.f53689g;
        }

        public static e a(String str) {
            return f53686e.get(str);
        }

        @Override // com.umeng.analytics.pro.by
        public short a() {
            return this.f53688f;
        }
    }

    public a a(String str) {
        this.f53676a = str;
        return this;
    }

    public a b(String str) {
        this.f53677b = str;
        return this;
    }

    public a c(String str) {
        this.f53678c = str;
        return this;
    }

    public void d(boolean z3) {
        this.f53680n = bo.a(this.f53680n, 0, z3);
    }

    public void a(boolean z3) {
        if (z3) {
            return;
        }
        this.f53676a = null;
    }

    public void b(boolean z3) {
        if (z3) {
            return;
        }
        this.f53677b = null;
    }

    public void c(boolean z3) {
        if (z3) {
            return;
        }
        this.f53678c = null;
    }

    public a(String str, String str2, long j4) {
        this();
        this.f53676a = str;
        this.f53678c = str2;
        this.f53679d = j4;
        d(true);
    }

    public a a(long j4) {
        this.f53679d = j4;
        d(true);
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

    public a(a aVar) {
        this.f53680n = (byte) 0;
        this.f53681o = new e[]{e.OLD_ID};
        this.f53680n = aVar.f53680n;
        if (aVar.d()) {
            this.f53676a = aVar.f53676a;
        }
        if (aVar.g()) {
            this.f53677b = aVar.f53677b;
        }
        if (aVar.j()) {
            this.f53678c = aVar.f53678c;
        }
        this.f53679d = aVar.f53679d;
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f53680n = (byte) 0;
            read(new ck(new dc(objectInputStream)));
        } catch (bx e4) {
            throw new IOException(e4.getMessage());
        }
    }
}
