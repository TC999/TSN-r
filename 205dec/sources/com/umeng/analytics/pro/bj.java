package com.umeng.analytics.pro;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
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
/* compiled from: UMEnvelope.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class bj implements br<bj, e>, Serializable, Cloneable {
    private static final int A = 2;
    private static final int B = 3;

    /* renamed from: k  reason: collision with root package name */
    public static final Map<e, cd> f52658k;

    /* renamed from: l  reason: collision with root package name */
    private static final long f52659l = 420342210744516016L;

    /* renamed from: m  reason: collision with root package name */
    private static final cv f52660m = new cv("UMEnvelope");

    /* renamed from: n  reason: collision with root package name */
    private static final cl f52661n = new cl("version", (byte) 11, 1);

    /* renamed from: o  reason: collision with root package name */
    private static final cl f52662o = new cl("address", (byte) 11, 2);

    /* renamed from: p  reason: collision with root package name */
    private static final cl f52663p = new cl("signature", (byte) 11, 3);

    /* renamed from: q  reason: collision with root package name */
    private static final cl f52664q = new cl("serial_num", (byte) 8, 4);

    /* renamed from: r  reason: collision with root package name */
    private static final cl f52665r = new cl("ts_secs", (byte) 8, 5);

    /* renamed from: s  reason: collision with root package name */
    private static final cl f52666s = new cl("length", (byte) 8, 6);

    /* renamed from: t  reason: collision with root package name */
    private static final cl f52667t = new cl("entity", (byte) 11, 7);

    /* renamed from: u  reason: collision with root package name */
    private static final cl f52668u = new cl("guid", (byte) 11, 8);

    /* renamed from: v  reason: collision with root package name */
    private static final cl f52669v = new cl("checksum", (byte) 11, 9);

    /* renamed from: w  reason: collision with root package name */
    private static final cl f52670w = new cl("codex", (byte) 8, 10);

    /* renamed from: x  reason: collision with root package name */
    private static final Map<Class<? extends cy>, cz> f52671x;

    /* renamed from: y  reason: collision with root package name */
    private static final int f52672y = 0;

    /* renamed from: z  reason: collision with root package name */
    private static final int f52673z = 1;
    private byte C;
    private e[] D;

    /* renamed from: a  reason: collision with root package name */
    public String f52674a;

    /* renamed from: b  reason: collision with root package name */
    public String f52675b;

    /* renamed from: c  reason: collision with root package name */
    public String f52676c;

    /* renamed from: d  reason: collision with root package name */
    public int f52677d;

    /* renamed from: e  reason: collision with root package name */
    public int f52678e;

    /* renamed from: f  reason: collision with root package name */
    public int f52679f;

    /* renamed from: g  reason: collision with root package name */
    public ByteBuffer f52680g;

    /* renamed from: h  reason: collision with root package name */
    public String f52681h;

    /* renamed from: i  reason: collision with root package name */
    public String f52682i;

    /* renamed from: j  reason: collision with root package name */
    public int f52683j;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: UMEnvelope.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class a extends da<bj> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: a */
        public void b(cq cqVar, bj bjVar) throws bx {
            cqVar.j();
            while (true) {
                cl l4 = cqVar.l();
                byte b4 = l4.f52815b;
                if (b4 == 0) {
                    cqVar.k();
                    if (bjVar.m()) {
                        if (bjVar.p()) {
                            if (bjVar.s()) {
                                bjVar.G();
                                return;
                            }
                            throw new cr("Required field 'length' was not found in serialized data! Struct: " + toString());
                        }
                        throw new cr("Required field 'ts_secs' was not found in serialized data! Struct: " + toString());
                    }
                    throw new cr("Required field 'serial_num' was not found in serialized data! Struct: " + toString());
                }
                switch (l4.f52816c) {
                    case 1:
                        if (b4 == 11) {
                            bjVar.f52674a = cqVar.z();
                            bjVar.a(true);
                            break;
                        } else {
                            ct.a(cqVar, b4);
                            break;
                        }
                    case 2:
                        if (b4 == 11) {
                            bjVar.f52675b = cqVar.z();
                            bjVar.b(true);
                            break;
                        } else {
                            ct.a(cqVar, b4);
                            break;
                        }
                    case 3:
                        if (b4 == 11) {
                            bjVar.f52676c = cqVar.z();
                            bjVar.c(true);
                            break;
                        } else {
                            ct.a(cqVar, b4);
                            break;
                        }
                    case 4:
                        if (b4 == 8) {
                            bjVar.f52677d = cqVar.w();
                            bjVar.d(true);
                            break;
                        } else {
                            ct.a(cqVar, b4);
                            break;
                        }
                    case 5:
                        if (b4 == 8) {
                            bjVar.f52678e = cqVar.w();
                            bjVar.e(true);
                            break;
                        } else {
                            ct.a(cqVar, b4);
                            break;
                        }
                    case 6:
                        if (b4 == 8) {
                            bjVar.f52679f = cqVar.w();
                            bjVar.f(true);
                            break;
                        } else {
                            ct.a(cqVar, b4);
                            break;
                        }
                    case 7:
                        if (b4 == 11) {
                            bjVar.f52680g = cqVar.A();
                            bjVar.g(true);
                            break;
                        } else {
                            ct.a(cqVar, b4);
                            break;
                        }
                    case 8:
                        if (b4 == 11) {
                            bjVar.f52681h = cqVar.z();
                            bjVar.h(true);
                            break;
                        } else {
                            ct.a(cqVar, b4);
                            break;
                        }
                    case 9:
                        if (b4 == 11) {
                            bjVar.f52682i = cqVar.z();
                            bjVar.i(true);
                            break;
                        } else {
                            ct.a(cqVar, b4);
                            break;
                        }
                    case 10:
                        if (b4 == 8) {
                            bjVar.f52683j = cqVar.w();
                            bjVar.j(true);
                            break;
                        } else {
                            ct.a(cqVar, b4);
                            break;
                        }
                    default:
                        ct.a(cqVar, b4);
                        break;
                }
                cqVar.m();
            }
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: b */
        public void a(cq cqVar, bj bjVar) throws bx {
            bjVar.G();
            cqVar.a(bj.f52660m);
            if (bjVar.f52674a != null) {
                cqVar.a(bj.f52661n);
                cqVar.a(bjVar.f52674a);
                cqVar.c();
            }
            if (bjVar.f52675b != null) {
                cqVar.a(bj.f52662o);
                cqVar.a(bjVar.f52675b);
                cqVar.c();
            }
            if (bjVar.f52676c != null) {
                cqVar.a(bj.f52663p);
                cqVar.a(bjVar.f52676c);
                cqVar.c();
            }
            cqVar.a(bj.f52664q);
            cqVar.a(bjVar.f52677d);
            cqVar.c();
            cqVar.a(bj.f52665r);
            cqVar.a(bjVar.f52678e);
            cqVar.c();
            cqVar.a(bj.f52666s);
            cqVar.a(bjVar.f52679f);
            cqVar.c();
            if (bjVar.f52680g != null) {
                cqVar.a(bj.f52667t);
                cqVar.a(bjVar.f52680g);
                cqVar.c();
            }
            if (bjVar.f52681h != null) {
                cqVar.a(bj.f52668u);
                cqVar.a(bjVar.f52681h);
                cqVar.c();
            }
            if (bjVar.f52682i != null) {
                cqVar.a(bj.f52669v);
                cqVar.a(bjVar.f52682i);
                cqVar.c();
            }
            if (bjVar.F()) {
                cqVar.a(bj.f52670w);
                cqVar.a(bjVar.f52683j);
                cqVar.c();
            }
            cqVar.d();
            cqVar.b();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: UMEnvelope.java */
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
    /* compiled from: UMEnvelope.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class c extends db<bj> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cy
        public void a(cq cqVar, bj bjVar) throws bx {
            cw cwVar = (cw) cqVar;
            cwVar.a(bjVar.f52674a);
            cwVar.a(bjVar.f52675b);
            cwVar.a(bjVar.f52676c);
            cwVar.a(bjVar.f52677d);
            cwVar.a(bjVar.f52678e);
            cwVar.a(bjVar.f52679f);
            cwVar.a(bjVar.f52680g);
            cwVar.a(bjVar.f52681h);
            cwVar.a(bjVar.f52682i);
            BitSet bitSet = new BitSet();
            if (bjVar.F()) {
                bitSet.set(0);
            }
            cwVar.a(bitSet, 1);
            if (bjVar.F()) {
                cwVar.a(bjVar.f52683j);
            }
        }

        @Override // com.umeng.analytics.pro.cy
        public void b(cq cqVar, bj bjVar) throws bx {
            cw cwVar = (cw) cqVar;
            bjVar.f52674a = cwVar.z();
            bjVar.a(true);
            bjVar.f52675b = cwVar.z();
            bjVar.b(true);
            bjVar.f52676c = cwVar.z();
            bjVar.c(true);
            bjVar.f52677d = cwVar.w();
            bjVar.d(true);
            bjVar.f52678e = cwVar.w();
            bjVar.e(true);
            bjVar.f52679f = cwVar.w();
            bjVar.f(true);
            bjVar.f52680g = cwVar.A();
            bjVar.g(true);
            bjVar.f52681h = cwVar.z();
            bjVar.h(true);
            bjVar.f52682i = cwVar.z();
            bjVar.i(true);
            if (cwVar.b(1).get(0)) {
                bjVar.f52683j = cwVar.w();
                bjVar.j(true);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: UMEnvelope.java */
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
        f52671x = hashMap;
        hashMap.put(da.class, new b());
        hashMap.put(db.class, new d());
        EnumMap enumMap = new EnumMap(e.class);
        enumMap.put((EnumMap) e.VERSION, (e) new cd("version", (byte) 1, new ce((byte) 11)));
        enumMap.put((EnumMap) e.ADDRESS, (e) new cd("address", (byte) 1, new ce((byte) 11)));
        enumMap.put((EnumMap) e.SIGNATURE, (e) new cd("signature", (byte) 1, new ce((byte) 11)));
        enumMap.put((EnumMap) e.SERIAL_NUM, (e) new cd("serial_num", (byte) 1, new ce((byte) 8)));
        enumMap.put((EnumMap) e.TS_SECS, (e) new cd("ts_secs", (byte) 1, new ce((byte) 8)));
        enumMap.put((EnumMap) e.LENGTH, (e) new cd("length", (byte) 1, new ce((byte) 8)));
        enumMap.put((EnumMap) e.ENTITY, (e) new cd("entity", (byte) 1, new ce((byte) 11, true)));
        enumMap.put((EnumMap) e.GUID, (e) new cd("guid", (byte) 1, new ce((byte) 11)));
        enumMap.put((EnumMap) e.CHECKSUM, (e) new cd("checksum", (byte) 1, new ce((byte) 11)));
        enumMap.put((EnumMap) e.CODEX, (e) new cd("codex", (byte) 2, new ce((byte) 8)));
        Map<e, cd> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f52658k = unmodifiableMap;
        cd.a(bj.class, unmodifiableMap);
    }

    public bj() {
        this.C = (byte) 0;
        this.D = new e[]{e.CODEX};
    }

    public String A() {
        return this.f52682i;
    }

    public void B() {
        this.f52682i = null;
    }

    public boolean C() {
        return this.f52682i != null;
    }

    public int D() {
        return this.f52683j;
    }

    public void E() {
        this.C = bo.b(this.C, 3);
    }

    public boolean F() {
        return bo.a(this.C, 3);
    }

    public void G() throws bx {
        if (this.f52674a != null) {
            if (this.f52675b != null) {
                if (this.f52676c != null) {
                    if (this.f52680g != null) {
                        if (this.f52681h != null) {
                            if (this.f52682i != null) {
                                return;
                            }
                            throw new cr("Required field 'checksum' was not present! Struct: " + toString());
                        }
                        throw new cr("Required field 'guid' was not present! Struct: " + toString());
                    }
                    throw new cr("Required field 'entity' was not present! Struct: " + toString());
                }
                throw new cr("Required field 'signature' was not present! Struct: " + toString());
            }
            throw new cr("Required field 'address' was not present! Struct: " + toString());
        }
        throw new cr("Required field 'version' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.br
    /* renamed from: a */
    public bj deepCopy() {
        return new bj(this);
    }

    public String b() {
        return this.f52674a;
    }

    public void c() {
        this.f52674a = null;
    }

    @Override // com.umeng.analytics.pro.br
    public void clear() {
        this.f52674a = null;
        this.f52675b = null;
        this.f52676c = null;
        d(false);
        this.f52677d = 0;
        e(false);
        this.f52678e = 0;
        f(false);
        this.f52679f = 0;
        this.f52680g = null;
        this.f52681h = null;
        this.f52682i = null;
        j(false);
        this.f52683j = 0;
    }

    public boolean d() {
        return this.f52674a != null;
    }

    public String e() {
        return this.f52675b;
    }

    public void f() {
        this.f52675b = null;
    }

    public boolean g() {
        return this.f52675b != null;
    }

    public String h() {
        return this.f52676c;
    }

    public void i() {
        this.f52676c = null;
    }

    public boolean j() {
        return this.f52676c != null;
    }

    public int k() {
        return this.f52677d;
    }

    public void l() {
        this.C = bo.b(this.C, 0);
    }

    public boolean m() {
        return bo.a(this.C, 0);
    }

    public int n() {
        return this.f52678e;
    }

    public void o() {
        this.C = bo.b(this.C, 1);
    }

    public boolean p() {
        return bo.a(this.C, 1);
    }

    public int q() {
        return this.f52679f;
    }

    public void r() {
        this.C = bo.b(this.C, 2);
    }

    @Override // com.umeng.analytics.pro.br
    public void read(cq cqVar) throws bx {
        f52671x.get(cqVar.D()).b().b(cqVar, this);
    }

    public boolean s() {
        return bo.a(this.C, 2);
    }

    public byte[] t() {
        a(bs.c(this.f52680g));
        ByteBuffer byteBuffer = this.f52680g;
        if (byteBuffer == null) {
            return null;
        }
        return byteBuffer.array();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UMEnvelope(");
        sb.append("version:");
        String str = this.f52674a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("address:");
        String str2 = this.f52675b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("signature:");
        String str3 = this.f52676c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("serial_num:");
        sb.append(this.f52677d);
        sb.append(", ");
        sb.append("ts_secs:");
        sb.append(this.f52678e);
        sb.append(", ");
        sb.append("length:");
        sb.append(this.f52679f);
        sb.append(", ");
        sb.append("entity:");
        ByteBuffer byteBuffer = this.f52680g;
        if (byteBuffer == null) {
            sb.append("null");
        } else {
            bs.a(byteBuffer, sb);
        }
        sb.append(", ");
        sb.append("guid:");
        String str4 = this.f52681h;
        if (str4 == null) {
            sb.append("null");
        } else {
            sb.append(str4);
        }
        sb.append(", ");
        sb.append("checksum:");
        String str5 = this.f52682i;
        if (str5 == null) {
            sb.append("null");
        } else {
            sb.append(str5);
        }
        if (F()) {
            sb.append(", ");
            sb.append("codex:");
            sb.append(this.f52683j);
        }
        sb.append(")");
        return sb.toString();
    }

    public ByteBuffer u() {
        return this.f52680g;
    }

    public void v() {
        this.f52680g = null;
    }

    public boolean w() {
        return this.f52680g != null;
    }

    @Override // com.umeng.analytics.pro.br
    public void write(cq cqVar) throws bx {
        f52671x.get(cqVar.D()).b().a(cqVar, this);
    }

    public String x() {
        return this.f52681h;
    }

    public void y() {
        this.f52681h = null;
    }

    public boolean z() {
        return this.f52681h != null;
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: UMEnvelope.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public enum e implements by {
        VERSION(1, "version"),
        ADDRESS(2, "address"),
        SIGNATURE(3, "signature"),
        SERIAL_NUM(4, "serial_num"),
        TS_SECS(5, "ts_secs"),
        LENGTH(6, "length"),
        ENTITY(7, "entity"),
        GUID(8, "guid"),
        CHECKSUM(9, "checksum"),
        CODEX(10, "codex");
        

        /* renamed from: k  reason: collision with root package name */
        private static final Map<String, e> f52694k = new HashMap();

        /* renamed from: l  reason: collision with root package name */
        private final short f52696l;

        /* renamed from: m  reason: collision with root package name */
        private final String f52697m;

        static {
            Iterator it = EnumSet.allOf(e.class).iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                f52694k.put(eVar.b(), eVar);
            }
        }

        e(short s3, String str) {
            this.f52696l = s3;
            this.f52697m = str;
        }

        public static e a(int i4) {
            switch (i4) {
                case 1:
                    return VERSION;
                case 2:
                    return ADDRESS;
                case 3:
                    return SIGNATURE;
                case 4:
                    return SERIAL_NUM;
                case 5:
                    return TS_SECS;
                case 6:
                    return LENGTH;
                case 7:
                    return ENTITY;
                case 8:
                    return GUID;
                case 9:
                    return CHECKSUM;
                case 10:
                    return CODEX;
                default:
                    return null;
            }
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
            return this.f52697m;
        }

        public static e a(String str) {
            return f52694k.get(str);
        }

        @Override // com.umeng.analytics.pro.by
        public short a() {
            return this.f52696l;
        }
    }

    public bj a(String str) {
        this.f52674a = str;
        return this;
    }

    public bj b(String str) {
        this.f52675b = str;
        return this;
    }

    public bj c(String str) {
        this.f52676c = str;
        return this;
    }

    public void d(boolean z3) {
        this.C = bo.a(this.C, 0, z3);
    }

    public void e(boolean z3) {
        this.C = bo.a(this.C, 1, z3);
    }

    public void f(boolean z3) {
        this.C = bo.a(this.C, 2, z3);
    }

    public void g(boolean z3) {
        if (z3) {
            return;
        }
        this.f52680g = null;
    }

    public void h(boolean z3) {
        if (z3) {
            return;
        }
        this.f52681h = null;
    }

    public void i(boolean z3) {
        if (z3) {
            return;
        }
        this.f52682i = null;
    }

    public void j(boolean z3) {
        this.C = bo.a(this.C, 3, z3);
    }

    public void a(boolean z3) {
        if (z3) {
            return;
        }
        this.f52674a = null;
    }

    public void b(boolean z3) {
        if (z3) {
            return;
        }
        this.f52675b = null;
    }

    public void c(boolean z3) {
        if (z3) {
            return;
        }
        this.f52676c = null;
    }

    public bj d(String str) {
        this.f52681h = str;
        return this;
    }

    public bj e(String str) {
        this.f52682i = str;
        return this;
    }

    public bj(String str, String str2, String str3, int i4, int i5, int i6, ByteBuffer byteBuffer, String str4, String str5) {
        this();
        this.f52674a = str;
        this.f52675b = str2;
        this.f52676c = str3;
        this.f52677d = i4;
        d(true);
        this.f52678e = i5;
        e(true);
        this.f52679f = i6;
        f(true);
        this.f52680g = byteBuffer;
        this.f52681h = str4;
        this.f52682i = str5;
    }

    public bj a(int i4) {
        this.f52677d = i4;
        d(true);
        return this;
    }

    public bj b(int i4) {
        this.f52678e = i4;
        e(true);
        return this;
    }

    public bj c(int i4) {
        this.f52679f = i4;
        f(true);
        return this;
    }

    public bj d(int i4) {
        this.f52683j = i4;
        j(true);
        return this;
    }

    @Override // com.umeng.analytics.pro.br
    /* renamed from: e */
    public e fieldForId(int i4) {
        return e.a(i4);
    }

    public bj a(byte[] bArr) {
        a(bArr == null ? null : ByteBuffer.wrap(bArr));
        return this;
    }

    public bj a(ByteBuffer byteBuffer) {
        this.f52680g = byteBuffer;
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
            this.C = (byte) 0;
            read(new ck(new dc(objectInputStream)));
        } catch (bx e4) {
            throw new IOException(e4.getMessage());
        }
    }

    public bj(bj bjVar) {
        this.C = (byte) 0;
        this.D = new e[]{e.CODEX};
        this.C = bjVar.C;
        if (bjVar.d()) {
            this.f52674a = bjVar.f52674a;
        }
        if (bjVar.g()) {
            this.f52675b = bjVar.f52675b;
        }
        if (bjVar.j()) {
            this.f52676c = bjVar.f52676c;
        }
        this.f52677d = bjVar.f52677d;
        this.f52678e = bjVar.f52678e;
        this.f52679f = bjVar.f52679f;
        if (bjVar.w()) {
            this.f52680g = bs.d(bjVar.f52680g);
        }
        if (bjVar.z()) {
            this.f52681h = bjVar.f52681h;
        }
        if (bjVar.C()) {
            this.f52682i = bjVar.f52682i;
        }
        this.f52683j = bjVar.f52683j;
    }
}
