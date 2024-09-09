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
/* compiled from: ImprintValue.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class e implements br<e, EnumC1066e>, Serializable, Cloneable {

    /* renamed from: d  reason: collision with root package name */
    public static final Map<EnumC1066e, cd> f53747d;

    /* renamed from: e  reason: collision with root package name */
    private static final long f53748e = 7501688097813630241L;

    /* renamed from: f  reason: collision with root package name */
    private static final cv f53749f = new cv("ImprintValue");

    /* renamed from: g  reason: collision with root package name */
    private static final cl f53750g = new cl("value", (byte) 11, 1);

    /* renamed from: h  reason: collision with root package name */
    private static final cl f53751h = new cl("ts", (byte) 10, 2);

    /* renamed from: i  reason: collision with root package name */
    private static final cl f53752i = new cl("guid", (byte) 11, 3);

    /* renamed from: j  reason: collision with root package name */
    private static final Map<Class<? extends cy>, cz> f53753j;

    /* renamed from: k  reason: collision with root package name */
    private static final int f53754k = 0;

    /* renamed from: a  reason: collision with root package name */
    public String f53755a;

    /* renamed from: b  reason: collision with root package name */
    public long f53756b;

    /* renamed from: c  reason: collision with root package name */
    public String f53757c;

    /* renamed from: l  reason: collision with root package name */
    private byte f53758l;

    /* renamed from: m  reason: collision with root package name */
    private EnumC1066e[] f53759m;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: ImprintValue.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class a extends da<e> {
        private a() {
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: a */
        public void b(cq cqVar, e eVar) throws bx {
            cqVar.j();
            while (true) {
                cl l4 = cqVar.l();
                byte b4 = l4.f52815b;
                if (b4 == 0) {
                    cqVar.k();
                    eVar.k();
                    return;
                }
                short s3 = l4.f52816c;
                if (s3 != 1) {
                    if (s3 != 2) {
                        if (s3 != 3) {
                            ct.a(cqVar, b4);
                        } else if (b4 == 11) {
                            eVar.f53757c = cqVar.z();
                            eVar.c(true);
                        } else {
                            ct.a(cqVar, b4);
                        }
                    } else if (b4 == 10) {
                        eVar.f53756b = cqVar.x();
                        eVar.b(true);
                    } else {
                        ct.a(cqVar, b4);
                    }
                } else if (b4 == 11) {
                    eVar.f53755a = cqVar.z();
                    eVar.a(true);
                } else {
                    ct.a(cqVar, b4);
                }
                cqVar.m();
            }
        }

        @Override // com.umeng.analytics.pro.cy
        /* renamed from: b */
        public void a(cq cqVar, e eVar) throws bx {
            eVar.k();
            cqVar.a(e.f53749f);
            if (eVar.f53755a != null && eVar.d()) {
                cqVar.a(e.f53750g);
                cqVar.a(eVar.f53755a);
                cqVar.c();
            }
            if (eVar.g()) {
                cqVar.a(e.f53751h);
                cqVar.a(eVar.f53756b);
                cqVar.c();
            }
            if (eVar.f53757c != null && eVar.j()) {
                cqVar.a(e.f53752i);
                cqVar.a(eVar.f53757c);
                cqVar.c();
            }
            cqVar.d();
            cqVar.b();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: ImprintValue.java */
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
    /* compiled from: ImprintValue.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class c extends db<e> {
        private c() {
        }

        @Override // com.umeng.analytics.pro.cy
        public void a(cq cqVar, e eVar) throws bx {
            cw cwVar = (cw) cqVar;
            BitSet bitSet = new BitSet();
            if (eVar.d()) {
                bitSet.set(0);
            }
            if (eVar.g()) {
                bitSet.set(1);
            }
            if (eVar.j()) {
                bitSet.set(2);
            }
            cwVar.a(bitSet, 3);
            if (eVar.d()) {
                cwVar.a(eVar.f53755a);
            }
            if (eVar.g()) {
                cwVar.a(eVar.f53756b);
            }
            if (eVar.j()) {
                cwVar.a(eVar.f53757c);
            }
        }

        @Override // com.umeng.analytics.pro.cy
        public void b(cq cqVar, e eVar) throws bx {
            cw cwVar = (cw) cqVar;
            BitSet b4 = cwVar.b(3);
            if (b4.get(0)) {
                eVar.f53755a = cwVar.z();
                eVar.a(true);
            }
            if (b4.get(1)) {
                eVar.f53756b = cwVar.x();
                eVar.b(true);
            }
            if (b4.get(2)) {
                eVar.f53757c = cwVar.z();
                eVar.c(true);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: ImprintValue.java */
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
        f53753j = hashMap;
        hashMap.put(da.class, new b());
        hashMap.put(db.class, new d());
        EnumMap enumMap = new EnumMap(EnumC1066e.class);
        enumMap.put((EnumMap) EnumC1066e.VALUE, (EnumC1066e) new cd("value", (byte) 2, new ce((byte) 11)));
        enumMap.put((EnumMap) EnumC1066e.TS, (EnumC1066e) new cd("ts", (byte) 2, new ce((byte) 10)));
        enumMap.put((EnumMap) EnumC1066e.GUID, (EnumC1066e) new cd("guid", (byte) 2, new ce((byte) 11)));
        Map<EnumC1066e, cd> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f53747d = unmodifiableMap;
        cd.a(e.class, unmodifiableMap);
    }

    public e() {
        this.f53758l = (byte) 0;
        this.f53759m = new EnumC1066e[]{EnumC1066e.VALUE, EnumC1066e.TS, EnumC1066e.GUID};
    }

    @Override // com.umeng.analytics.pro.br
    /* renamed from: a */
    public e deepCopy() {
        return new e(this);
    }

    public String b() {
        return this.f53755a;
    }

    public void c() {
        this.f53755a = null;
    }

    @Override // com.umeng.analytics.pro.br
    public void clear() {
        this.f53755a = null;
        b(false);
        this.f53756b = 0L;
        this.f53757c = null;
    }

    public boolean d() {
        return this.f53755a != null;
    }

    public long e() {
        return this.f53756b;
    }

    public void f() {
        this.f53758l = bo.b(this.f53758l, 0);
    }

    public boolean g() {
        return bo.a(this.f53758l, 0);
    }

    public String h() {
        return this.f53757c;
    }

    public void i() {
        this.f53757c = null;
    }

    public boolean j() {
        return this.f53757c != null;
    }

    public void k() throws bx {
    }

    @Override // com.umeng.analytics.pro.br
    public void read(cq cqVar) throws bx {
        f53753j.get(cqVar.D()).b().b(cqVar, this);
    }

    public String toString() {
        boolean z3;
        StringBuilder sb = new StringBuilder("ImprintValue(");
        if (d()) {
            sb.append("value:");
            String str = this.f53755a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z3 = false;
        } else {
            z3 = true;
        }
        if (!z3) {
            sb.append(", ");
        }
        sb.append("ts:");
        sb.append(this.f53756b);
        sb.append(", ");
        sb.append("guid:");
        String str2 = this.f53757c;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.br
    public void write(cq cqVar) throws bx {
        f53753j.get(cqVar.D()).b().a(cqVar, this);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: ImprintValue.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.e$e  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public enum EnumC1066e implements by {
        VALUE(1, "value"),
        TS(2, "ts"),
        GUID(3, "guid");
        

        /* renamed from: d  reason: collision with root package name */
        private static final Map<String, EnumC1066e> f53763d = new HashMap();

        /* renamed from: e  reason: collision with root package name */
        private final short f53765e;

        /* renamed from: f  reason: collision with root package name */
        private final String f53766f;

        static {
            Iterator it = EnumSet.allOf(EnumC1066e.class).iterator();
            while (it.hasNext()) {
                EnumC1066e enumC1066e = (EnumC1066e) it.next();
                f53763d.put(enumC1066e.b(), enumC1066e);
            }
        }

        EnumC1066e(short s3, String str) {
            this.f53765e = s3;
            this.f53766f = str;
        }

        public static EnumC1066e a(int i4) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        return null;
                    }
                    return GUID;
                }
                return TS;
            }
            return VALUE;
        }

        public static EnumC1066e b(int i4) {
            EnumC1066e a4 = a(i4);
            if (a4 != null) {
                return a4;
            }
            throw new IllegalArgumentException("Field " + i4 + " doesn't exist!");
        }

        @Override // com.umeng.analytics.pro.by
        public String b() {
            return this.f53766f;
        }

        public static EnumC1066e a(String str) {
            return f53763d.get(str);
        }

        @Override // com.umeng.analytics.pro.by
        public short a() {
            return this.f53765e;
        }
    }

    public e a(String str) {
        this.f53755a = str;
        return this;
    }

    public void b(boolean z3) {
        this.f53758l = bo.a(this.f53758l, 0, z3);
    }

    public void c(boolean z3) {
        if (z3) {
            return;
        }
        this.f53757c = null;
    }

    public void a(boolean z3) {
        if (z3) {
            return;
        }
        this.f53755a = null;
    }

    public e b(String str) {
        this.f53757c = str;
        return this;
    }

    public e(long j4, String str) {
        this();
        this.f53756b = j4;
        b(true);
        this.f53757c = str;
    }

    public e a(long j4) {
        this.f53756b = j4;
        b(true);
        return this;
    }

    @Override // com.umeng.analytics.pro.br
    /* renamed from: a */
    public EnumC1066e fieldForId(int i4) {
        return EnumC1066e.a(i4);
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new ck(new dc(objectOutputStream)));
        } catch (bx e4) {
            throw new IOException(e4.getMessage());
        }
    }

    public e(e eVar) {
        this.f53758l = (byte) 0;
        this.f53759m = new EnumC1066e[]{EnumC1066e.VALUE, EnumC1066e.TS, EnumC1066e.GUID};
        this.f53758l = eVar.f53758l;
        if (eVar.d()) {
            this.f53755a = eVar.f53755a;
        }
        this.f53756b = eVar.f53756b;
        if (eVar.j()) {
            this.f53757c = eVar.f53757c;
        }
    }

    private void a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f53758l = (byte) 0;
            read(new ck(new dc(objectInputStream)));
        } catch (bx e4) {
            throw new IOException(e4.getMessage());
        }
    }
}
