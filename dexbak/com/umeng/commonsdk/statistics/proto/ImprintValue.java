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

/* renamed from: com.umeng.commonsdk.statistics.proto.e */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ImprintValue implements TBase<ImprintValue, EnumC13296e>, Serializable, Cloneable {

    /* renamed from: d */
    public static final Map<EnumC13296e, FieldMetaData> f39112d;

    /* renamed from: e */
    private static final long f39113e = 7501688097813630241L;

    /* renamed from: f */
    private static final TStruct f39114f = new TStruct("ImprintValue");

    /* renamed from: g */
    private static final TField f39115g = new TField(DomainCampaignEx.LOOPBACK_VALUE, (byte) 11, 1);

    /* renamed from: h */
    private static final TField f39116h = new TField("ts", (byte) 10, 2);

    /* renamed from: i */
    private static final TField f39117i = new TField("guid", (byte) 11, 3);

    /* renamed from: j */
    private static final Map<Class<? extends IScheme>, SchemeFactory> f39118j;

    /* renamed from: k */
    private static final int f39119k = 0;

    /* renamed from: a */
    public String f39120a;

    /* renamed from: b */
    public long f39121b;

    /* renamed from: c */
    public String f39122c;

    /* renamed from: l */
    private byte f39123l;

    /* renamed from: m */
    private EnumC13296e[] f39124m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ImprintValue.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.e$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C13292a extends StandardScheme<ImprintValue> {
        private C13292a() {
        }

        @Override // com.umeng.analytics.pro.IScheme
        /* renamed from: a */
        public void mo13485b(TProtocol tProtocol, ImprintValue imprintValue) throws TException {
            tProtocol.mo14416j();
            while (true) {
                TField mo14414l = tProtocol.mo14414l();
                byte b = mo14414l.f38029b;
                if (b == 0) {
                    tProtocol.mo14415k();
                    imprintValue.m13495k();
                    return;
                }
                short s = mo14414l.f38030c;
                if (s != 1) {
                    if (s != 2) {
                        if (s != 3) {
                            TProtocolUtil.m14397a(tProtocol, b);
                        } else if (b == 11) {
                            imprintValue.f39122c = tProtocol.mo14400z();
                            imprintValue.m13503c(true);
                        } else {
                            TProtocolUtil.m14397a(tProtocol, b);
                        }
                    } else if (b == 10) {
                        imprintValue.f39121b = tProtocol.mo14402x();
                        imprintValue.m13505b(true);
                    } else {
                        TProtocolUtil.m14397a(tProtocol, b);
                    }
                } else if (b == 11) {
                    imprintValue.f39120a = tProtocol.mo14400z();
                    imprintValue.m13508a(true);
                } else {
                    TProtocolUtil.m14397a(tProtocol, b);
                }
                tProtocol.mo14413m();
            }
        }

        @Override // com.umeng.analytics.pro.IScheme
        /* renamed from: b */
        public void mo13487a(TProtocol tProtocol, ImprintValue imprintValue) throws TException {
            imprintValue.m13495k();
            tProtocol.mo14429a(ImprintValue.f39114f);
            if (imprintValue.f39120a != null && imprintValue.m13502d()) {
                tProtocol.mo14434a(ImprintValue.f39115g);
                tProtocol.mo14428a(imprintValue.f39120a);
                tProtocol.mo14423c();
            }
            if (imprintValue.m13499g()) {
                tProtocol.mo14434a(ImprintValue.f39116h);
                tProtocol.mo14435a(imprintValue.f39121b);
                tProtocol.mo14423c();
            }
            if (imprintValue.f39122c != null && imprintValue.m13496j()) {
                tProtocol.mo14434a(ImprintValue.f39117i);
                tProtocol.mo14428a(imprintValue.f39122c);
                tProtocol.mo14423c();
            }
            tProtocol.mo14422d();
            tProtocol.mo14424b();
        }
    }

    /* compiled from: ImprintValue.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.e$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class C13293b implements SchemeFactory {
        private C13293b() {
        }

        @Override // com.umeng.analytics.pro.SchemeFactory
        /* renamed from: a */
        public C13292a mo13482b() {
            return new C13292a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ImprintValue.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.e$c */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C13294c extends TupleScheme<ImprintValue> {
        private C13294c() {
        }

        @Override // com.umeng.analytics.pro.IScheme
        /* renamed from: a */
        public void mo13487a(TProtocol tProtocol, ImprintValue imprintValue) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol) tProtocol;
            BitSet bitSet = new BitSet();
            if (imprintValue.m13502d()) {
                bitSet.set(0);
            }
            if (imprintValue.m13499g()) {
                bitSet.set(1);
            }
            if (imprintValue.m13496j()) {
                bitSet.set(2);
            }
            tTupleProtocol.m14393a(bitSet, 3);
            if (imprintValue.m13502d()) {
                tTupleProtocol.mo14428a(imprintValue.f39120a);
            }
            if (imprintValue.m13499g()) {
                tTupleProtocol.mo14435a(imprintValue.f39121b);
            }
            if (imprintValue.m13496j()) {
                tTupleProtocol.mo14428a(imprintValue.f39122c);
            }
        }

        @Override // com.umeng.analytics.pro.IScheme
        /* renamed from: b */
        public void mo13485b(TProtocol tProtocol, ImprintValue imprintValue) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol) tProtocol;
            BitSet m14391b = tTupleProtocol.m14391b(3);
            if (m14391b.get(0)) {
                imprintValue.f39120a = tTupleProtocol.mo14400z();
                imprintValue.m13508a(true);
            }
            if (m14391b.get(1)) {
                imprintValue.f39121b = tTupleProtocol.mo14402x();
                imprintValue.m13505b(true);
            }
            if (m14391b.get(2)) {
                imprintValue.f39122c = tTupleProtocol.mo14400z();
                imprintValue.m13503c(true);
            }
        }
    }

    /* compiled from: ImprintValue.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.e$d */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class C13295d implements SchemeFactory {
        private C13295d() {
        }

        @Override // com.umeng.analytics.pro.SchemeFactory
        /* renamed from: a */
        public C13294c mo13482b() {
            return new C13294c();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f39118j = hashMap;
        hashMap.put(StandardScheme.class, new C13293b());
        hashMap.put(TupleScheme.class, new C13295d());
        EnumMap enumMap = new EnumMap(EnumC13296e.class);
        enumMap.put((EnumMap) EnumC13296e.VALUE, (EnumC13296e) new FieldMetaData(DomainCampaignEx.LOOPBACK_VALUE, (byte) 2, new FieldValueMetaData((byte) 11)));
        enumMap.put((EnumMap) EnumC13296e.TS, (EnumC13296e) new FieldMetaData("ts", (byte) 2, new FieldValueMetaData((byte) 10)));
        enumMap.put((EnumMap) EnumC13296e.GUID, (EnumC13296e) new FieldMetaData("guid", (byte) 2, new FieldValueMetaData((byte) 11)));
        Map<EnumC13296e, FieldMetaData> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f39112d = unmodifiableMap;
        FieldMetaData.m14474a(ImprintValue.class, unmodifiableMap);
    }

    public ImprintValue() {
        this.f39123l = (byte) 0;
        this.f39124m = new EnumC13296e[]{EnumC13296e.VALUE, EnumC13296e.TS, EnumC13296e.GUID};
    }

    @Override // com.umeng.analytics.pro.TBase
    /* renamed from: a */
    public ImprintValue deepCopy() {
        return new ImprintValue(this);
    }

    /* renamed from: b */
    public String m13507b() {
        return this.f39120a;
    }

    /* renamed from: c */
    public void m13504c() {
        this.f39120a = null;
    }

    @Override // com.umeng.analytics.pro.TBase
    public void clear() {
        this.f39120a = null;
        m13505b(false);
        this.f39121b = 0L;
        this.f39122c = null;
    }

    /* renamed from: d */
    public boolean m13502d() {
        return this.f39120a != null;
    }

    /* renamed from: e */
    public long m13501e() {
        return this.f39121b;
    }

    /* renamed from: f */
    public void m13500f() {
        this.f39123l = EncodingUtils.m14556b(this.f39123l, 0);
    }

    /* renamed from: g */
    public boolean m13499g() {
        return EncodingUtils.m14568a(this.f39123l, 0);
    }

    /* renamed from: h */
    public String m13498h() {
        return this.f39122c;
    }

    /* renamed from: i */
    public void m13497i() {
        this.f39122c = null;
    }

    /* renamed from: j */
    public boolean m13496j() {
        return this.f39122c != null;
    }

    /* renamed from: k */
    public void m13495k() throws TException {
    }

    @Override // com.umeng.analytics.pro.TBase
    public void read(TProtocol tProtocol) throws TException {
        f39118j.get(tProtocol.mo14394D()).mo13482b().mo13485b(tProtocol, this);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("ImprintValue(");
        if (m13502d()) {
            sb.append("value:");
            String str = this.f39120a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("ts:");
        sb.append(this.f39121b);
        sb.append(", ");
        sb.append("guid:");
        String str2 = this.f39122c;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.TBase
    public void write(TProtocol tProtocol) throws TException {
        f39118j.get(tProtocol.mo14394D()).mo13482b().mo13487a(tProtocol, this);
    }

    /* compiled from: ImprintValue.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.e$e */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public enum EnumC13296e implements TFieldIdEnum {
        VALUE(1, DomainCampaignEx.LOOPBACK_VALUE),
        TS(2, "ts"),
        GUID(3, "guid");
        

        /* renamed from: d */
        private static final Map<String, EnumC13296e> f39128d = new HashMap();

        /* renamed from: e */
        private final short f39130e;

        /* renamed from: f */
        private final String f39131f;

        static {
            Iterator it = EnumSet.allOf(EnumC13296e.class).iterator();
            while (it.hasNext()) {
                EnumC13296e enumC13296e = (EnumC13296e) it.next();
                f39128d.put(enumC13296e.mo13478b(), enumC13296e);
            }
        }

        EnumC13296e(short s, String str) {
            this.f39130e = s;
            this.f39131f = str;
        }

        /* renamed from: a */
        public static EnumC13296e m13480a(int i) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return GUID;
                }
                return TS;
            }
            return VALUE;
        }

        /* renamed from: b */
        public static EnumC13296e m13477b(int i) {
            EnumC13296e m13480a = m13480a(i);
            if (m13480a != null) {
                return m13480a;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        @Override // com.umeng.analytics.pro.TFieldIdEnum
        /* renamed from: b */
        public String mo13478b() {
            return this.f39131f;
        }

        /* renamed from: a */
        public static EnumC13296e m13479a(String str) {
            return f39128d.get(str);
        }

        @Override // com.umeng.analytics.pro.TFieldIdEnum
        /* renamed from: a */
        public short mo13481a() {
            return this.f39130e;
        }
    }

    /* renamed from: a */
    public ImprintValue m13509a(String str) {
        this.f39120a = str;
        return this;
    }

    /* renamed from: b */
    public void m13505b(boolean z) {
        this.f39123l = EncodingUtils.m14567a(this.f39123l, 0, z);
    }

    /* renamed from: c */
    public void m13503c(boolean z) {
        if (z) {
            return;
        }
        this.f39122c = null;
    }

    /* renamed from: a */
    public void m13508a(boolean z) {
        if (z) {
            return;
        }
        this.f39120a = null;
    }

    /* renamed from: b */
    public ImprintValue m13506b(String str) {
        this.f39122c = str;
        return this;
    }

    public ImprintValue(long j, String str) {
        this();
        this.f39121b = j;
        m13505b(true);
        this.f39122c = str;
    }

    /* renamed from: a */
    public ImprintValue m13512a(long j) {
        this.f39121b = j;
        m13505b(true);
        return this;
    }

    @Override // com.umeng.analytics.pro.TBase
    /* renamed from: a */
    public EnumC13296e fieldForId(int i) {
        return EnumC13296e.m13480a(i);
    }

    /* renamed from: a */
    private void m13510a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new TCompactProtocol(new TIOStreamTransport(objectOutputStream)));
        } catch (TException e) {
            throw new IOException(e.getMessage());
        }
    }

    public ImprintValue(ImprintValue imprintValue) {
        this.f39123l = (byte) 0;
        this.f39124m = new EnumC13296e[]{EnumC13296e.VALUE, EnumC13296e.TS, EnumC13296e.GUID};
        this.f39123l = imprintValue.f39123l;
        if (imprintValue.m13502d()) {
            this.f39120a = imprintValue.f39120a;
        }
        this.f39121b = imprintValue.f39121b;
        if (imprintValue.m13496j()) {
            this.f39122c = imprintValue.f39122c;
        }
    }

    /* renamed from: a */
    private void m13511a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f39123l = (byte) 0;
            read(new TCompactProtocol(new TIOStreamTransport(objectInputStream)));
        } catch (TException e) {
            throw new IOException(e.getMessage());
        }
    }
}
