package com.umeng.commonsdk.statistics.proto;

import com.baidu.idl.face.platform.common.ConstantHelper;
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
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.umeng.commonsdk.statistics.proto.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class IdSnapshot implements TBase<IdSnapshot, EnumC13278e>, Serializable, Cloneable {

    /* renamed from: d */
    public static final Map<EnumC13278e, FieldMetaData> f39055d;

    /* renamed from: e */
    private static final long f39056e = -6496538196005191531L;

    /* renamed from: f */
    private static final TStruct f39057f = new TStruct("IdSnapshot");

    /* renamed from: g */
    private static final TField f39058g = new TField("identity", (byte) 11, 1);

    /* renamed from: h */
    private static final TField f39059h = new TField("ts", (byte) 10, 2);

    /* renamed from: i */
    private static final TField f39060i = new TField(ConstantHelper.LOG_VS, (byte) 8, 3);

    /* renamed from: j */
    private static final Map<Class<? extends IScheme>, SchemeFactory> f39061j;

    /* renamed from: k */
    private static final int f39062k = 0;

    /* renamed from: l */
    private static final int f39063l = 1;

    /* renamed from: a */
    public String f39064a;

    /* renamed from: b */
    public long f39065b;

    /* renamed from: c */
    public int f39066c;

    /* renamed from: m */
    private byte f39067m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: IdSnapshot.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.b$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C13274a extends StandardScheme<IdSnapshot> {
        private C13274a() {
        }

        @Override // com.umeng.analytics.pro.IScheme
        /* renamed from: a */
        public void mo13485b(TProtocol tProtocol, IdSnapshot idSnapshot) throws TException {
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
                            TProtocolUtil.m14397a(tProtocol, b);
                        } else if (b == 8) {
                            idSnapshot.f39066c = tProtocol.mo14403w();
                            idSnapshot.m13609c(true);
                        } else {
                            TProtocolUtil.m14397a(tProtocol, b);
                        }
                    } else if (b == 10) {
                        idSnapshot.f39065b = tProtocol.mo14402x();
                        idSnapshot.m13611b(true);
                    } else {
                        TProtocolUtil.m14397a(tProtocol, b);
                    }
                } else if (b == 11) {
                    idSnapshot.f39064a = tProtocol.mo14400z();
                    idSnapshot.m13614a(true);
                } else {
                    TProtocolUtil.m14397a(tProtocol, b);
                }
                tProtocol.mo14413m();
            }
            tProtocol.mo14415k();
            if (idSnapshot.m13605g()) {
                if (idSnapshot.m13602j()) {
                    idSnapshot.m13601k();
                    return;
                }
                throw new TProtocolException("Required field 'version' was not found in serialized data! Struct: " + toString());
            }
            throw new TProtocolException("Required field 'ts' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.IScheme
        /* renamed from: b */
        public void mo13487a(TProtocol tProtocol, IdSnapshot idSnapshot) throws TException {
            idSnapshot.m13601k();
            tProtocol.mo14429a(IdSnapshot.f39057f);
            if (idSnapshot.f39064a != null) {
                tProtocol.mo14434a(IdSnapshot.f39058g);
                tProtocol.mo14428a(idSnapshot.f39064a);
                tProtocol.mo14423c();
            }
            tProtocol.mo14434a(IdSnapshot.f39059h);
            tProtocol.mo14435a(idSnapshot.f39065b);
            tProtocol.mo14423c();
            tProtocol.mo14434a(IdSnapshot.f39060i);
            tProtocol.mo14436a(idSnapshot.f39066c);
            tProtocol.mo14423c();
            tProtocol.mo14422d();
            tProtocol.mo14424b();
        }
    }

    /* compiled from: IdSnapshot.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.b$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class C13275b implements SchemeFactory {
        private C13275b() {
        }

        @Override // com.umeng.analytics.pro.SchemeFactory
        /* renamed from: a */
        public C13274a mo13482b() {
            return new C13274a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: IdSnapshot.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.b$c */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C13276c extends TupleScheme<IdSnapshot> {
        private C13276c() {
        }

        @Override // com.umeng.analytics.pro.IScheme
        /* renamed from: a */
        public void mo13487a(TProtocol tProtocol, IdSnapshot idSnapshot) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol) tProtocol;
            tTupleProtocol.mo14428a(idSnapshot.f39064a);
            tTupleProtocol.mo14435a(idSnapshot.f39065b);
            tTupleProtocol.mo14436a(idSnapshot.f39066c);
        }

        @Override // com.umeng.analytics.pro.IScheme
        /* renamed from: b */
        public void mo13485b(TProtocol tProtocol, IdSnapshot idSnapshot) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol) tProtocol;
            idSnapshot.f39064a = tTupleProtocol.mo14400z();
            idSnapshot.m13614a(true);
            idSnapshot.f39065b = tTupleProtocol.mo14402x();
            idSnapshot.m13611b(true);
            idSnapshot.f39066c = tTupleProtocol.mo14403w();
            idSnapshot.m13609c(true);
        }
    }

    /* compiled from: IdSnapshot.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.b$d */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class C13277d implements SchemeFactory {
        private C13277d() {
        }

        @Override // com.umeng.analytics.pro.SchemeFactory
        /* renamed from: a */
        public C13276c mo13482b() {
            return new C13276c();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f39061j = hashMap;
        hashMap.put(StandardScheme.class, new C13275b());
        hashMap.put(TupleScheme.class, new C13277d());
        EnumMap enumMap = new EnumMap(EnumC13278e.class);
        enumMap.put((EnumMap) EnumC13278e.IDENTITY, (EnumC13278e) new FieldMetaData("identity", (byte) 1, new FieldValueMetaData((byte) 11)));
        enumMap.put((EnumMap) EnumC13278e.TS, (EnumC13278e) new FieldMetaData("ts", (byte) 1, new FieldValueMetaData((byte) 10)));
        enumMap.put((EnumMap) EnumC13278e.VERSION, (EnumC13278e) new FieldMetaData(ConstantHelper.LOG_VS, (byte) 1, new FieldValueMetaData((byte) 8)));
        Map<EnumC13278e, FieldMetaData> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f39055d = unmodifiableMap;
        FieldMetaData.m14474a(IdSnapshot.class, unmodifiableMap);
    }

    public IdSnapshot() {
        this.f39067m = (byte) 0;
    }

    @Override // com.umeng.analytics.pro.TBase
    /* renamed from: a */
    public IdSnapshot deepCopy() {
        return new IdSnapshot(this);
    }

    /* renamed from: b */
    public String m13613b() {
        return this.f39064a;
    }

    /* renamed from: c */
    public void m13610c() {
        this.f39064a = null;
    }

    @Override // com.umeng.analytics.pro.TBase
    public void clear() {
        this.f39064a = null;
        m13611b(false);
        this.f39065b = 0L;
        m13609c(false);
        this.f39066c = 0;
    }

    /* renamed from: d */
    public boolean m13608d() {
        return this.f39064a != null;
    }

    /* renamed from: e */
    public long m13607e() {
        return this.f39065b;
    }

    /* renamed from: f */
    public void m13606f() {
        this.f39067m = EncodingUtils.m14556b(this.f39067m, 0);
    }

    /* renamed from: g */
    public boolean m13605g() {
        return EncodingUtils.m14568a(this.f39067m, 0);
    }

    /* renamed from: h */
    public int m13604h() {
        return this.f39066c;
    }

    /* renamed from: i */
    public void m13603i() {
        this.f39067m = EncodingUtils.m14556b(this.f39067m, 1);
    }

    /* renamed from: j */
    public boolean m13602j() {
        return EncodingUtils.m14568a(this.f39067m, 1);
    }

    /* renamed from: k */
    public void m13601k() throws TException {
        if (this.f39064a != null) {
            return;
        }
        throw new TProtocolException("Required field 'identity' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.TBase
    public void read(TProtocol tProtocol) throws TException {
        f39061j.get(tProtocol.mo14394D()).mo13482b().mo13485b(tProtocol, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdSnapshot(");
        sb.append("identity:");
        String str = this.f39064a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.f39065b);
        sb.append(", ");
        sb.append("version:");
        sb.append(this.f39066c);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.TBase
    public void write(TProtocol tProtocol) throws TException {
        f39061j.get(tProtocol.mo14394D()).mo13482b().mo13487a(tProtocol, this);
    }

    /* compiled from: IdSnapshot.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.b$e */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public enum EnumC13278e implements TFieldIdEnum {
        IDENTITY(1, "identity"),
        TS(2, "ts"),
        VERSION(3, ConstantHelper.LOG_VS);
        

        /* renamed from: d */
        private static final Map<String, EnumC13278e> f39071d = new HashMap();

        /* renamed from: e */
        private final short f39073e;

        /* renamed from: f */
        private final String f39074f;

        static {
            Iterator it = EnumSet.allOf(EnumC13278e.class).iterator();
            while (it.hasNext()) {
                EnumC13278e enumC13278e = (EnumC13278e) it.next();
                f39071d.put(enumC13278e.mo13478b(), enumC13278e);
            }
        }

        EnumC13278e(short s, String str) {
            this.f39073e = s;
            this.f39074f = str;
        }

        /* renamed from: a */
        public static EnumC13278e m13590a(int i) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return VERSION;
                }
                return TS;
            }
            return IDENTITY;
        }

        /* renamed from: b */
        public static EnumC13278e m13588b(int i) {
            EnumC13278e m13590a = m13590a(i);
            if (m13590a != null) {
                return m13590a;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        @Override // com.umeng.analytics.pro.TFieldIdEnum
        /* renamed from: b */
        public String mo13478b() {
            return this.f39074f;
        }

        /* renamed from: a */
        public static EnumC13278e m13589a(String str) {
            return f39071d.get(str);
        }

        @Override // com.umeng.analytics.pro.TFieldIdEnum
        /* renamed from: a */
        public short mo13481a() {
            return this.f39073e;
        }
    }

    /* renamed from: a */
    public IdSnapshot m13615a(String str) {
        this.f39064a = str;
        return this;
    }

    /* renamed from: b */
    public void m13611b(boolean z) {
        this.f39067m = EncodingUtils.m14567a(this.f39067m, 0, z);
    }

    /* renamed from: c */
    public void m13609c(boolean z) {
        this.f39067m = EncodingUtils.m14567a(this.f39067m, 1, z);
    }

    public IdSnapshot(String str, long j, int i) {
        this();
        this.f39064a = str;
        this.f39065b = j;
        m13611b(true);
        this.f39066c = i;
        m13609c(true);
    }

    /* renamed from: a */
    public void m13614a(boolean z) {
        if (z) {
            return;
        }
        this.f39064a = null;
    }

    @Override // com.umeng.analytics.pro.TBase
    /* renamed from: b */
    public EnumC13278e fieldForId(int i) {
        return EnumC13278e.m13590a(i);
    }

    /* renamed from: a */
    public IdSnapshot m13618a(long j) {
        this.f39065b = j;
        m13611b(true);
        return this;
    }

    /* renamed from: a */
    public IdSnapshot m13619a(int i) {
        this.f39066c = i;
        m13609c(true);
        return this;
    }

    /* renamed from: a */
    private void m13616a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new TCompactProtocol(new TIOStreamTransport(objectOutputStream)));
        } catch (TException e) {
            throw new IOException(e.getMessage());
        }
    }

    public IdSnapshot(IdSnapshot idSnapshot) {
        this.f39067m = (byte) 0;
        this.f39067m = idSnapshot.f39067m;
        if (idSnapshot.m13608d()) {
            this.f39064a = idSnapshot.f39064a;
        }
        this.f39065b = idSnapshot.f39065b;
        this.f39066c = idSnapshot.f39066c;
    }

    /* renamed from: a */
    private void m13617a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f39067m = (byte) 0;
            read(new TCompactProtocol(new TIOStreamTransport(objectInputStream)));
        } catch (TException e) {
            throw new IOException(e.getMessage());
        }
    }
}
