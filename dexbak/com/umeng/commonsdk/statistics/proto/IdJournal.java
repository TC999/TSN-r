package com.umeng.commonsdk.statistics.proto;

import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.umeng.analytics.pro.EncodingUtils;
import com.umeng.analytics.pro.FieldMetaData;
import com.umeng.analytics.pro.FieldValueMetaData;
import com.umeng.analytics.pro.IScheme;
import com.umeng.analytics.pro.SchemeFactory;
import com.umeng.analytics.pro.StandardScheme;
import com.umeng.analytics.pro.TBase;
import com.umeng.analytics.pro.TCompactProtocol;
import com.umeng.analytics.pro.TException;
import com.umeng.analytics.pro.TField;
import com.umeng.analytics.pro.TFieldIdEnum;
import com.umeng.analytics.pro.TIOStreamTransport;
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
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.umeng.commonsdk.statistics.proto.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class IdJournal implements TBase<IdJournal, EnumC13272e>, Serializable, Cloneable {

    /* renamed from: e */
    public static final Map<EnumC13272e, FieldMetaData> f39032e;

    /* renamed from: f */
    private static final long f39033f = 9132678615281394583L;

    /* renamed from: g */
    private static final TStruct f39034g = new TStruct("IdJournal");

    /* renamed from: h */
    private static final TField f39035h = new TField(DomainCampaignEx.LOOPBACK_DOMAIN, (byte) 11, 1);

    /* renamed from: i */
    private static final TField f39036i = new TField("old_id", (byte) 11, 2);

    /* renamed from: j */
    private static final TField f39037j = new TField("new_id", (byte) 11, 3);

    /* renamed from: k */
    private static final TField f39038k = new TField("ts", (byte) 10, 4);

    /* renamed from: l */
    private static final Map<Class<? extends IScheme>, SchemeFactory> f39039l;

    /* renamed from: m */
    private static final int f39040m = 0;

    /* renamed from: a */
    public String f39041a;

    /* renamed from: b */
    public String f39042b;

    /* renamed from: c */
    public String f39043c;

    /* renamed from: d */
    public long f39044d;

    /* renamed from: n */
    private byte f39045n;

    /* renamed from: o */
    private EnumC13272e[] f39046o;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: IdJournal.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.a$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C13268a extends StandardScheme<IdJournal> {
        private C13268a() {
        }

        @Override // com.umeng.analytics.pro.IScheme
        /* renamed from: a */
        public void mo13485b(TProtocol tProtocol, IdJournal idJournal) throws TException {
            tProtocol.mo14416j();
            while (true) {
                TField mo14414l = tProtocol.mo14414l();
                byte b = mo14414l.f38029b;
                if (b == 0) {
                    break;
                }
                short s = mo14414l.f38030c;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            if (s != 4) {
                                TProtocolUtil.m14397a(tProtocol, b);
                            } else if (b == 10) {
                                idJournal.f39044d = tProtocol.mo14402x();
                                idJournal.m13645d(true);
                            } else {
                                TProtocolUtil.m14397a(tProtocol, b);
                            }
                        } else if (b == 11) {
                            idJournal.f39043c = tProtocol.mo14400z();
                            idJournal.m13647c(true);
                        } else {
                            TProtocolUtil.m14397a(tProtocol, b);
                        }
                    } else if (b == 11) {
                        idJournal.f39042b = tProtocol.mo14400z();
                        idJournal.m13650b(true);
                    } else {
                        TProtocolUtil.m14397a(tProtocol, b);
                    }
                } else if (b == 11) {
                    idJournal.f39041a = tProtocol.mo14400z();
                    idJournal.m13653a(true);
                } else {
                    TProtocolUtil.m14397a(tProtocol, b);
                }
                tProtocol.mo14413m();
            }
            tProtocol.mo14415k();
            if (idJournal.m13636m()) {
                idJournal.m13635n();
                return;
            }
            throw new TProtocolException("Required field 'ts' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.IScheme
        /* renamed from: b */
        public void mo13487a(TProtocol tProtocol, IdJournal idJournal) throws TException {
            idJournal.m13635n();
            tProtocol.mo14429a(IdJournal.f39034g);
            if (idJournal.f39041a != null) {
                tProtocol.mo14434a(IdJournal.f39035h);
                tProtocol.mo14428a(idJournal.f39041a);
                tProtocol.mo14423c();
            }
            if (idJournal.f39042b != null && idJournal.m13642g()) {
                tProtocol.mo14434a(IdJournal.f39036i);
                tProtocol.mo14428a(idJournal.f39042b);
                tProtocol.mo14423c();
            }
            if (idJournal.f39043c != null) {
                tProtocol.mo14434a(IdJournal.f39037j);
                tProtocol.mo14428a(idJournal.f39043c);
                tProtocol.mo14423c();
            }
            tProtocol.mo14434a(IdJournal.f39038k);
            tProtocol.mo14435a(idJournal.f39044d);
            tProtocol.mo14423c();
            tProtocol.mo14422d();
            tProtocol.mo14424b();
        }
    }

    /* compiled from: IdJournal.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.a$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class C13269b implements SchemeFactory {
        private C13269b() {
        }

        @Override // com.umeng.analytics.pro.SchemeFactory
        /* renamed from: a */
        public C13268a mo13482b() {
            return new C13268a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: IdJournal.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.a$c */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C13270c extends TupleScheme<IdJournal> {
        private C13270c() {
        }

        @Override // com.umeng.analytics.pro.IScheme
        /* renamed from: a */
        public void mo13487a(TProtocol tProtocol, IdJournal idJournal) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol) tProtocol;
            tTupleProtocol.mo14428a(idJournal.f39041a);
            tTupleProtocol.mo14428a(idJournal.f39043c);
            tTupleProtocol.mo14435a(idJournal.f39044d);
            BitSet bitSet = new BitSet();
            if (idJournal.m13642g()) {
                bitSet.set(0);
            }
            tTupleProtocol.m14393a(bitSet, 1);
            if (idJournal.m13642g()) {
                tTupleProtocol.mo14428a(idJournal.f39042b);
            }
        }

        @Override // com.umeng.analytics.pro.IScheme
        /* renamed from: b */
        public void mo13485b(TProtocol tProtocol, IdJournal idJournal) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol) tProtocol;
            idJournal.f39041a = tTupleProtocol.mo14400z();
            idJournal.m13653a(true);
            idJournal.f39043c = tTupleProtocol.mo14400z();
            idJournal.m13647c(true);
            idJournal.f39044d = tTupleProtocol.mo14402x();
            idJournal.m13645d(true);
            if (tTupleProtocol.m14391b(1).get(0)) {
                idJournal.f39042b = tTupleProtocol.mo14400z();
                idJournal.m13650b(true);
            }
        }
    }

    /* compiled from: IdJournal.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.a$d */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class C13271d implements SchemeFactory {
        private C13271d() {
        }

        @Override // com.umeng.analytics.pro.SchemeFactory
        /* renamed from: a */
        public C13270c mo13482b() {
            return new C13270c();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f39039l = hashMap;
        hashMap.put(StandardScheme.class, new C13269b());
        hashMap.put(TupleScheme.class, new C13271d());
        EnumMap enumMap = new EnumMap(EnumC13272e.class);
        enumMap.put((EnumMap) EnumC13272e.DOMAIN, (EnumC13272e) new FieldMetaData(DomainCampaignEx.LOOPBACK_DOMAIN, (byte) 1, new FieldValueMetaData((byte) 11)));
        enumMap.put((EnumMap) EnumC13272e.OLD_ID, (EnumC13272e) new FieldMetaData("old_id", (byte) 2, new FieldValueMetaData((byte) 11)));
        enumMap.put((EnumMap) EnumC13272e.NEW_ID, (EnumC13272e) new FieldMetaData("new_id", (byte) 1, new FieldValueMetaData((byte) 11)));
        enumMap.put((EnumMap) EnumC13272e.TS, (EnumC13272e) new FieldMetaData("ts", (byte) 1, new FieldValueMetaData((byte) 10)));
        Map<EnumC13272e, FieldMetaData> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f39032e = unmodifiableMap;
        FieldMetaData.m14474a(IdJournal.class, unmodifiableMap);
    }

    public IdJournal() {
        this.f39045n = (byte) 0;
        this.f39046o = new EnumC13272e[]{EnumC13272e.OLD_ID};
    }

    @Override // com.umeng.analytics.pro.TBase
    /* renamed from: a */
    public IdJournal deepCopy() {
        return new IdJournal(this);
    }

    /* renamed from: b */
    public String m13652b() {
        return this.f39041a;
    }

    /* renamed from: c */
    public void m13649c() {
        this.f39041a = null;
    }

    @Override // com.umeng.analytics.pro.TBase
    public void clear() {
        this.f39041a = null;
        this.f39042b = null;
        this.f39043c = null;
        m13645d(false);
        this.f39044d = 0L;
    }

    /* renamed from: d */
    public boolean m13646d() {
        return this.f39041a != null;
    }

    /* renamed from: e */
    public String m13644e() {
        return this.f39042b;
    }

    /* renamed from: f */
    public void m13643f() {
        this.f39042b = null;
    }

    /* renamed from: g */
    public boolean m13642g() {
        return this.f39042b != null;
    }

    /* renamed from: h */
    public String m13641h() {
        return this.f39043c;
    }

    /* renamed from: i */
    public void m13640i() {
        this.f39043c = null;
    }

    /* renamed from: j */
    public boolean m13639j() {
        return this.f39043c != null;
    }

    /* renamed from: k */
    public long m13638k() {
        return this.f39044d;
    }

    /* renamed from: l */
    public void m13637l() {
        this.f39045n = EncodingUtils.m14556b(this.f39045n, 0);
    }

    /* renamed from: m */
    public boolean m13636m() {
        return EncodingUtils.m14568a(this.f39045n, 0);
    }

    /* renamed from: n */
    public void m13635n() throws TException {
        if (this.f39041a != null) {
            if (this.f39043c != null) {
                return;
            }
            throw new TProtocolException("Required field 'new_id' was not present! Struct: " + toString());
        }
        throw new TProtocolException("Required field 'domain' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.TBase
    public void read(TProtocol tProtocol) throws TException {
        f39039l.get(tProtocol.mo14394D()).mo13482b().mo13485b(tProtocol, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdJournal(");
        sb.append("domain:");
        String str = this.f39041a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (m13642g()) {
            sb.append(", ");
            sb.append("old_id:");
            String str2 = this.f39042b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        sb.append(", ");
        sb.append("new_id:");
        String str3 = this.f39043c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.f39044d);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.TBase
    public void write(TProtocol tProtocol) throws TException {
        f39039l.get(tProtocol.mo14394D()).mo13482b().mo13487a(tProtocol, this);
    }

    /* compiled from: IdJournal.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.a$e */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public enum EnumC13272e implements TFieldIdEnum {
        DOMAIN(1, DomainCampaignEx.LOOPBACK_DOMAIN),
        OLD_ID(2, "old_id"),
        NEW_ID(3, "new_id"),
        TS(4, "ts");
        

        /* renamed from: e */
        private static final Map<String, EnumC13272e> f39051e = new HashMap();

        /* renamed from: f */
        private final short f39053f;

        /* renamed from: g */
        private final String f39054g;

        static {
            Iterator it = EnumSet.allOf(EnumC13272e.class).iterator();
            while (it.hasNext()) {
                EnumC13272e enumC13272e = (EnumC13272e) it.next();
                f39051e.put(enumC13272e.mo13478b(), enumC13272e);
            }
        }

        EnumC13272e(short s, String str) {
            this.f39053f = s;
            this.f39054g = str;
        }

        /* renamed from: a */
        public static EnumC13272e m13623a(int i) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
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

        /* renamed from: b */
        public static EnumC13272e m13621b(int i) {
            EnumC13272e m13623a = m13623a(i);
            if (m13623a != null) {
                return m13623a;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        @Override // com.umeng.analytics.pro.TFieldIdEnum
        /* renamed from: b */
        public String mo13478b() {
            return this.f39054g;
        }

        /* renamed from: a */
        public static EnumC13272e m13622a(String str) {
            return f39051e.get(str);
        }

        @Override // com.umeng.analytics.pro.TFieldIdEnum
        /* renamed from: a */
        public short mo13481a() {
            return this.f39053f;
        }
    }

    /* renamed from: a */
    public IdJournal m13654a(String str) {
        this.f39041a = str;
        return this;
    }

    /* renamed from: b */
    public IdJournal m13651b(String str) {
        this.f39042b = str;
        return this;
    }

    /* renamed from: c */
    public IdJournal m13648c(String str) {
        this.f39043c = str;
        return this;
    }

    /* renamed from: d */
    public void m13645d(boolean z) {
        this.f39045n = EncodingUtils.m14567a(this.f39045n, 0, z);
    }

    /* renamed from: a */
    public void m13653a(boolean z) {
        if (z) {
            return;
        }
        this.f39041a = null;
    }

    /* renamed from: b */
    public void m13650b(boolean z) {
        if (z) {
            return;
        }
        this.f39042b = null;
    }

    /* renamed from: c */
    public void m13647c(boolean z) {
        if (z) {
            return;
        }
        this.f39043c = null;
    }

    public IdJournal(String str, String str2, long j) {
        this();
        this.f39041a = str;
        this.f39043c = str2;
        this.f39044d = j;
        m13645d(true);
    }

    /* renamed from: a */
    public IdJournal m13657a(long j) {
        this.f39044d = j;
        m13645d(true);
        return this;
    }

    @Override // com.umeng.analytics.pro.TBase
    /* renamed from: a */
    public EnumC13272e fieldForId(int i) {
        return EnumC13272e.m13623a(i);
    }

    /* renamed from: a */
    private void m13655a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new TCompactProtocol(new TIOStreamTransport(objectOutputStream)));
        } catch (TException e) {
            throw new IOException(e.getMessage());
        }
    }

    public IdJournal(IdJournal idJournal) {
        this.f39045n = (byte) 0;
        this.f39046o = new EnumC13272e[]{EnumC13272e.OLD_ID};
        this.f39045n = idJournal.f39045n;
        if (idJournal.m13646d()) {
            this.f39041a = idJournal.f39041a;
        }
        if (idJournal.m13642g()) {
            this.f39042b = idJournal.f39042b;
        }
        if (idJournal.m13639j()) {
            this.f39043c = idJournal.f39043c;
        }
        this.f39044d = idJournal.f39044d;
    }

    /* renamed from: a */
    private void m13656a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f39045n = (byte) 0;
            read(new TCompactProtocol(new TIOStreamTransport(objectInputStream)));
        } catch (TException e) {
            throw new IOException(e.getMessage());
        }
    }
}
