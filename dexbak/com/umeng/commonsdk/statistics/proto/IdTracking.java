package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.FieldMetaData;
import com.umeng.analytics.pro.FieldValueMetaData;
import com.umeng.analytics.pro.IScheme;
import com.umeng.analytics.pro.ListMetaData;
import com.umeng.analytics.pro.MapMetaData;
import com.umeng.analytics.pro.SchemeFactory;
import com.umeng.analytics.pro.StandardScheme;
import com.umeng.analytics.pro.StructMetaData;
import com.umeng.analytics.pro.TBase;
import com.umeng.analytics.pro.TCompactProtocol;
import com.umeng.analytics.pro.TException;
import com.umeng.analytics.pro.TField;
import com.umeng.analytics.pro.TFieldIdEnum;
import com.umeng.analytics.pro.TIOStreamTransport;
import com.umeng.analytics.pro.TList;
import com.umeng.analytics.pro.TMap;
import com.umeng.analytics.pro.TProtocol;
import com.umeng.analytics.pro.TProtocolException;
import com.umeng.analytics.pro.TProtocolUtil;
import com.umeng.analytics.pro.TStruct;
import com.umeng.analytics.pro.TTupleProtocol;
import com.umeng.analytics.pro.TupleScheme;
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

/* renamed from: com.umeng.commonsdk.statistics.proto.c */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class IdTracking implements TBase<IdTracking, EnumC13284e>, Serializable, Cloneable {

    /* renamed from: d */
    public static final Map<EnumC13284e, FieldMetaData> f39075d;

    /* renamed from: e */
    private static final long f39076e = -5764118265293965743L;

    /* renamed from: f */
    private static final TStruct f39077f = new TStruct("IdTracking");

    /* renamed from: g */
    private static final TField f39078g = new TField("snapshots", (byte) 13, 1);

    /* renamed from: h */
    private static final TField f39079h = new TField("journals", (byte) 15, 2);

    /* renamed from: i */
    private static final TField f39080i = new TField("checksum", (byte) 11, 3);

    /* renamed from: j */
    private static final Map<Class<? extends IScheme>, SchemeFactory> f39081j;

    /* renamed from: a */
    public Map<String, IdSnapshot> f39082a;

    /* renamed from: b */
    public List<IdJournal> f39083b;

    /* renamed from: c */
    public String f39084c;

    /* renamed from: k */
    private EnumC13284e[] f39085k;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: IdTracking.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.c$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C13280a extends StandardScheme<IdTracking> {
        private C13280a() {
        }

        @Override // com.umeng.analytics.pro.IScheme
        /* renamed from: a */
        public void mo13485b(TProtocol tProtocol, IdTracking idTracking) throws TException {
            tProtocol.mo14416j();
            while (true) {
                TField mo14414l = tProtocol.mo14414l();
                byte b = mo14414l.f38029b;
                if (b == 0) {
                    tProtocol.mo14415k();
                    idTracking.m13563n();
                    return;
                }
                short s = mo14414l.f38030c;
                int i = 0;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            TProtocolUtil.m14397a(tProtocol, b);
                        } else if (b == 11) {
                            idTracking.f39084c = tProtocol.mo14400z();
                            idTracking.m13574c(true);
                        } else {
                            TProtocolUtil.m14397a(tProtocol, b);
                        }
                    } else if (b == 15) {
                        TList mo14410p = tProtocol.mo14410p();
                        idTracking.f39083b = new ArrayList(mo14410p.f38032b);
                        while (i < mo14410p.f38032b) {
                            IdJournal idJournal = new IdJournal();
                            idJournal.read(tProtocol);
                            idTracking.f39083b.add(idJournal);
                            i++;
                        }
                        tProtocol.mo14409q();
                        idTracking.m13576b(true);
                    } else {
                        TProtocolUtil.m14397a(tProtocol, b);
                    }
                } else if (b == 13) {
                    TMap mo14412n = tProtocol.mo14412n();
                    idTracking.f39082a = new HashMap(mo14412n.f38035c * 2);
                    while (i < mo14412n.f38035c) {
                        String mo14400z = tProtocol.mo14400z();
                        IdSnapshot idSnapshot = new IdSnapshot();
                        idSnapshot.read(tProtocol);
                        idTracking.f39082a.put(mo14400z, idSnapshot);
                        i++;
                    }
                    tProtocol.mo14411o();
                    idTracking.m13578a(true);
                } else {
                    TProtocolUtil.m14397a(tProtocol, b);
                }
                tProtocol.mo14413m();
            }
        }

        @Override // com.umeng.analytics.pro.IScheme
        /* renamed from: b */
        public void mo13487a(TProtocol tProtocol, IdTracking idTracking) throws TException {
            idTracking.m13563n();
            tProtocol.mo14429a(IdTracking.f39077f);
            if (idTracking.f39082a != null) {
                tProtocol.mo14434a(IdTracking.f39078g);
                tProtocol.mo14432a(new TMap((byte) 11, (byte) 12, idTracking.f39082a.size()));
                for (Map.Entry<String, IdSnapshot> entry : idTracking.f39082a.entrySet()) {
                    tProtocol.mo14428a(entry.getKey());
                    entry.getValue().write(tProtocol);
                }
                tProtocol.mo14421e();
                tProtocol.mo14423c();
            }
            if (idTracking.f39083b != null && idTracking.m13567j()) {
                tProtocol.mo14434a(IdTracking.f39079h);
                tProtocol.mo14433a(new TList((byte) 12, idTracking.f39083b.size()));
                for (IdJournal idJournal : idTracking.f39083b) {
                    idJournal.write(tProtocol);
                }
                tProtocol.mo14420f();
                tProtocol.mo14423c();
            }
            if (idTracking.f39084c != null && idTracking.m13564m()) {
                tProtocol.mo14434a(IdTracking.f39080i);
                tProtocol.mo14428a(idTracking.f39084c);
                tProtocol.mo14423c();
            }
            tProtocol.mo14422d();
            tProtocol.mo14424b();
        }
    }

    /* compiled from: IdTracking.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.c$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class C13281b implements SchemeFactory {
        private C13281b() {
        }

        @Override // com.umeng.analytics.pro.SchemeFactory
        /* renamed from: a */
        public C13280a mo13482b() {
            return new C13280a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: IdTracking.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.c$c */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C13282c extends TupleScheme<IdTracking> {
        private C13282c() {
        }

        @Override // com.umeng.analytics.pro.IScheme
        /* renamed from: a */
        public void mo13487a(TProtocol tProtocol, IdTracking idTracking) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol) tProtocol;
            tTupleProtocol.mo14436a(idTracking.f39082a.size());
            for (Map.Entry<String, IdSnapshot> entry : idTracking.f39082a.entrySet()) {
                tTupleProtocol.mo14428a(entry.getKey());
                entry.getValue().write(tTupleProtocol);
            }
            BitSet bitSet = new BitSet();
            if (idTracking.m13567j()) {
                bitSet.set(0);
            }
            if (idTracking.m13564m()) {
                bitSet.set(1);
            }
            tTupleProtocol.m14393a(bitSet, 2);
            if (idTracking.m13567j()) {
                tTupleProtocol.mo14436a(idTracking.f39083b.size());
                for (IdJournal idJournal : idTracking.f39083b) {
                    idJournal.write(tTupleProtocol);
                }
            }
            if (idTracking.m13564m()) {
                tTupleProtocol.mo14428a(idTracking.f39084c);
            }
        }

        @Override // com.umeng.analytics.pro.IScheme
        /* renamed from: b */
        public void mo13485b(TProtocol tProtocol, IdTracking idTracking) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol) tProtocol;
            TMap tMap = new TMap((byte) 11, (byte) 12, tTupleProtocol.mo14403w());
            idTracking.f39082a = new HashMap(tMap.f38035c * 2);
            for (int i = 0; i < tMap.f38035c; i++) {
                String mo14400z = tTupleProtocol.mo14400z();
                IdSnapshot idSnapshot = new IdSnapshot();
                idSnapshot.read(tTupleProtocol);
                idTracking.f39082a.put(mo14400z, idSnapshot);
            }
            idTracking.m13578a(true);
            BitSet m14391b = tTupleProtocol.m14391b(2);
            if (m14391b.get(0)) {
                TList tList = new TList((byte) 12, tTupleProtocol.mo14403w());
                idTracking.f39083b = new ArrayList(tList.f38032b);
                for (int i2 = 0; i2 < tList.f38032b; i2++) {
                    IdJournal idJournal = new IdJournal();
                    idJournal.read(tTupleProtocol);
                    idTracking.f39083b.add(idJournal);
                }
                idTracking.m13576b(true);
            }
            if (m14391b.get(1)) {
                idTracking.f39084c = tTupleProtocol.mo14400z();
                idTracking.m13574c(true);
            }
        }
    }

    /* compiled from: IdTracking.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.c$d */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class C13283d implements SchemeFactory {
        private C13283d() {
        }

        @Override // com.umeng.analytics.pro.SchemeFactory
        /* renamed from: a */
        public C13282c mo13482b() {
            return new C13282c();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f39081j = hashMap;
        hashMap.put(StandardScheme.class, new C13281b());
        hashMap.put(TupleScheme.class, new C13283d());
        EnumMap enumMap = new EnumMap(EnumC13284e.class);
        enumMap.put((EnumMap) EnumC13284e.SNAPSHOTS, (EnumC13284e) new FieldMetaData("snapshots", (byte) 1, new MapMetaData((byte) 13, new FieldValueMetaData((byte) 11), new StructMetaData((byte) 12, IdSnapshot.class))));
        enumMap.put((EnumMap) EnumC13284e.JOURNALS, (EnumC13284e) new FieldMetaData("journals", (byte) 2, new ListMetaData((byte) 15, new StructMetaData((byte) 12, IdJournal.class))));
        enumMap.put((EnumMap) EnumC13284e.CHECKSUM, (EnumC13284e) new FieldMetaData("checksum", (byte) 2, new FieldValueMetaData((byte) 11)));
        Map<EnumC13284e, FieldMetaData> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f39075d = unmodifiableMap;
        FieldMetaData.m14474a(IdTracking.class, unmodifiableMap);
    }

    public IdTracking() {
        this.f39085k = new EnumC13284e[]{EnumC13284e.JOURNALS, EnumC13284e.CHECKSUM};
    }

    @Override // com.umeng.analytics.pro.TBase
    /* renamed from: a */
    public IdTracking deepCopy() {
        return new IdTracking(this);
    }

    /* renamed from: b */
    public int m13577b() {
        Map<String, IdSnapshot> map = this.f39082a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    /* renamed from: c */
    public Map<String, IdSnapshot> m13575c() {
        return this.f39082a;
    }

    @Override // com.umeng.analytics.pro.TBase
    public void clear() {
        this.f39082a = null;
        this.f39083b = null;
        this.f39084c = null;
    }

    /* renamed from: d */
    public void m13573d() {
        this.f39082a = null;
    }

    /* renamed from: e */
    public boolean m13572e() {
        return this.f39082a != null;
    }

    /* renamed from: f */
    public int m13571f() {
        List<IdJournal> list = this.f39083b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* renamed from: g */
    public Iterator<IdJournal> m13570g() {
        List<IdJournal> list = this.f39083b;
        if (list == null) {
            return null;
        }
        return list.iterator();
    }

    /* renamed from: h */
    public List<IdJournal> m13569h() {
        return this.f39083b;
    }

    /* renamed from: i */
    public void m13568i() {
        this.f39083b = null;
    }

    /* renamed from: j */
    public boolean m13567j() {
        return this.f39083b != null;
    }

    /* renamed from: k */
    public String m13566k() {
        return this.f39084c;
    }

    /* renamed from: l */
    public void m13565l() {
        this.f39084c = null;
    }

    /* renamed from: m */
    public boolean m13564m() {
        return this.f39084c != null;
    }

    /* renamed from: n */
    public void m13563n() throws TException {
        if (this.f39082a != null) {
            return;
        }
        throw new TProtocolException("Required field 'snapshots' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.TBase
    public void read(TProtocol tProtocol) throws TException {
        f39081j.get(tProtocol.mo14394D()).mo13482b().mo13485b(tProtocol, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdTracking(");
        sb.append("snapshots:");
        Map<String, IdSnapshot> map = this.f39082a;
        if (map == null) {
            sb.append("null");
        } else {
            sb.append(map);
        }
        if (m13567j()) {
            sb.append(", ");
            sb.append("journals:");
            List<IdJournal> list = this.f39083b;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        if (m13564m()) {
            sb.append(", ");
            sb.append("checksum:");
            String str = this.f39084c;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.TBase
    public void write(TProtocol tProtocol) throws TException {
        f39081j.get(tProtocol.mo14394D()).mo13482b().mo13487a(tProtocol, this);
    }

    /* compiled from: IdTracking.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.c$e */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public enum EnumC13284e implements TFieldIdEnum {
        SNAPSHOTS(1, "snapshots"),
        JOURNALS(2, "journals"),
        CHECKSUM(3, "checksum");
        

        /* renamed from: d */
        private static final Map<String, EnumC13284e> f39089d = new HashMap();

        /* renamed from: e */
        private final short f39091e;

        /* renamed from: f */
        private final String f39092f;

        static {
            Iterator it = EnumSet.allOf(EnumC13284e.class).iterator();
            while (it.hasNext()) {
                EnumC13284e enumC13284e = (EnumC13284e) it.next();
                f39089d.put(enumC13284e.mo13478b(), enumC13284e);
            }
        }

        EnumC13284e(short s, String str) {
            this.f39091e = s;
            this.f39092f = str;
        }

        /* renamed from: a */
        public static EnumC13284e m13552a(int i) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return CHECKSUM;
                }
                return JOURNALS;
            }
            return SNAPSHOTS;
        }

        /* renamed from: b */
        public static EnumC13284e m13550b(int i) {
            EnumC13284e m13552a = m13552a(i);
            if (m13552a != null) {
                return m13552a;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        @Override // com.umeng.analytics.pro.TFieldIdEnum
        /* renamed from: b */
        public String mo13478b() {
            return this.f39092f;
        }

        /* renamed from: a */
        public static EnumC13284e m13551a(String str) {
            return f39089d.get(str);
        }

        @Override // com.umeng.analytics.pro.TFieldIdEnum
        /* renamed from: a */
        public short mo13481a() {
            return this.f39091e;
        }
    }

    /* renamed from: a */
    public void m13581a(String str, IdSnapshot idSnapshot) {
        if (this.f39082a == null) {
            this.f39082a = new HashMap();
        }
        this.f39082a.put(str, idSnapshot);
    }

    /* renamed from: b */
    public void m13576b(boolean z) {
        if (z) {
            return;
        }
        this.f39083b = null;
    }

    /* renamed from: c */
    public void m13574c(boolean z) {
        if (z) {
            return;
        }
        this.f39084c = null;
    }

    public IdTracking(Map<String, IdSnapshot> map) {
        this();
        this.f39082a = map;
    }

    public IdTracking(IdTracking idTracking) {
        this.f39085k = new EnumC13284e[]{EnumC13284e.JOURNALS, EnumC13284e.CHECKSUM};
        if (idTracking.m13572e()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, IdSnapshot> entry : idTracking.f39082a.entrySet()) {
                hashMap.put(entry.getKey(), new IdSnapshot(entry.getValue()));
            }
            this.f39082a = hashMap;
        }
        if (idTracking.m13567j()) {
            ArrayList arrayList = new ArrayList();
            for (IdJournal idJournal : idTracking.f39083b) {
                arrayList.add(new IdJournal(idJournal));
            }
            this.f39083b = arrayList;
        }
        if (idTracking.m13564m()) {
            this.f39084c = idTracking.f39084c;
        }
    }

    /* renamed from: a */
    public IdTracking m13579a(Map<String, IdSnapshot> map) {
        this.f39082a = map;
        return this;
    }

    /* renamed from: a */
    public void m13578a(boolean z) {
        if (z) {
            return;
        }
        this.f39082a = null;
    }

    /* renamed from: a */
    public void m13585a(IdJournal idJournal) {
        if (this.f39083b == null) {
            this.f39083b = new ArrayList();
        }
        this.f39083b.add(idJournal);
    }

    /* renamed from: a */
    public IdTracking m13580a(List<IdJournal> list) {
        this.f39083b = list;
        return this;
    }

    /* renamed from: a */
    public IdTracking m13582a(String str) {
        this.f39084c = str;
        return this;
    }

    @Override // com.umeng.analytics.pro.TBase
    /* renamed from: a */
    public EnumC13284e fieldForId(int i) {
        return EnumC13284e.m13552a(i);
    }

    /* renamed from: a */
    private void m13583a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new TCompactProtocol(new TIOStreamTransport(objectOutputStream)));
        } catch (TException e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: a */
    private void m13584a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            read(new TCompactProtocol(new TIOStreamTransport(objectInputStream)));
        } catch (TException e) {
            throw new IOException(e.getMessage());
        }
    }
}
