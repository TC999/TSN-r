package com.umeng.commonsdk.statistics.proto;

import com.baidu.idl.face.platform.common.ConstantHelper;
import com.umeng.analytics.pro.EncodingUtils;
import com.umeng.analytics.pro.FieldMetaData;
import com.umeng.analytics.pro.FieldValueMetaData;
import com.umeng.analytics.pro.IScheme;
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
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.umeng.commonsdk.statistics.proto.d */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class Imprint implements TBase<Imprint, EnumC13290e>, Serializable, Cloneable {

    /* renamed from: d */
    public static final Map<EnumC13290e, FieldMetaData> f39093d;

    /* renamed from: e */
    private static final long f39094e = 2846460275012375038L;

    /* renamed from: f */
    private static final TStruct f39095f = new TStruct("Imprint");

    /* renamed from: g */
    private static final TField f39096g = new TField("property", (byte) 13, 1);

    /* renamed from: h */
    private static final TField f39097h = new TField(ConstantHelper.LOG_VS, (byte) 8, 2);

    /* renamed from: i */
    private static final TField f39098i = new TField("checksum", (byte) 11, 3);

    /* renamed from: j */
    private static final Map<Class<? extends IScheme>, SchemeFactory> f39099j;

    /* renamed from: k */
    private static final int f39100k = 0;

    /* renamed from: a */
    public Map<String, ImprintValue> f39101a;

    /* renamed from: b */
    public int f39102b;

    /* renamed from: c */
    public String f39103c;

    /* renamed from: l */
    private byte f39104l;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Imprint.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.d$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C13286a extends StandardScheme<Imprint> {
        private C13286a() {
        }

        @Override // com.umeng.analytics.pro.IScheme
        /* renamed from: a */
        public void mo13485b(TProtocol tProtocol, Imprint imprint) throws TException {
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
                        } else if (b == 11) {
                            imprint.f39103c = tProtocol.mo14400z();
                            imprint.m13537c(true);
                        } else {
                            TProtocolUtil.m14397a(tProtocol, b);
                        }
                    } else if (b == 8) {
                        imprint.f39102b = tProtocol.mo14403w();
                        imprint.m13539b(true);
                    } else {
                        TProtocolUtil.m14397a(tProtocol, b);
                    }
                } else if (b == 13) {
                    TMap mo14412n = tProtocol.mo14412n();
                    imprint.f39101a = new HashMap(mo14412n.f38035c * 2);
                    for (int i = 0; i < mo14412n.f38035c; i++) {
                        String mo14400z = tProtocol.mo14400z();
                        ImprintValue imprintValue = new ImprintValue();
                        imprintValue.read(tProtocol);
                        imprint.f39101a.put(mo14400z, imprintValue);
                    }
                    tProtocol.mo14411o();
                    imprint.m13542a(true);
                } else {
                    TProtocolUtil.m14397a(tProtocol, b);
                }
                tProtocol.mo14413m();
            }
            tProtocol.mo14415k();
            if (imprint.m13532h()) {
                imprint.m13528l();
                return;
            }
            throw new TProtocolException("Required field 'version' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.IScheme
        /* renamed from: b */
        public void mo13487a(TProtocol tProtocol, Imprint imprint) throws TException {
            imprint.m13528l();
            tProtocol.mo14429a(Imprint.f39095f);
            if (imprint.f39101a != null) {
                tProtocol.mo14434a(Imprint.f39096g);
                tProtocol.mo14432a(new TMap((byte) 11, (byte) 12, imprint.f39101a.size()));
                for (Map.Entry<String, ImprintValue> entry : imprint.f39101a.entrySet()) {
                    tProtocol.mo14428a(entry.getKey());
                    entry.getValue().write(tProtocol);
                }
                tProtocol.mo14421e();
                tProtocol.mo14423c();
            }
            tProtocol.mo14434a(Imprint.f39097h);
            tProtocol.mo14436a(imprint.f39102b);
            tProtocol.mo14423c();
            if (imprint.f39103c != null) {
                tProtocol.mo14434a(Imprint.f39098i);
                tProtocol.mo14428a(imprint.f39103c);
                tProtocol.mo14423c();
            }
            tProtocol.mo14422d();
            tProtocol.mo14424b();
        }
    }

    /* compiled from: Imprint.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.d$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class C13287b implements SchemeFactory {
        private C13287b() {
        }

        @Override // com.umeng.analytics.pro.SchemeFactory
        /* renamed from: a */
        public C13286a mo13482b() {
            return new C13286a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Imprint.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.d$c */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C13288c extends TupleScheme<Imprint> {
        private C13288c() {
        }

        @Override // com.umeng.analytics.pro.IScheme
        /* renamed from: a */
        public void mo13487a(TProtocol tProtocol, Imprint imprint) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol) tProtocol;
            tTupleProtocol.mo14436a(imprint.f39101a.size());
            for (Map.Entry<String, ImprintValue> entry : imprint.f39101a.entrySet()) {
                tTupleProtocol.mo14428a(entry.getKey());
                entry.getValue().write(tTupleProtocol);
            }
            tTupleProtocol.mo14436a(imprint.f39102b);
            tTupleProtocol.mo14428a(imprint.f39103c);
        }

        @Override // com.umeng.analytics.pro.IScheme
        /* renamed from: b */
        public void mo13485b(TProtocol tProtocol, Imprint imprint) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol) tProtocol;
            TMap tMap = new TMap((byte) 11, (byte) 12, tTupleProtocol.mo14403w());
            imprint.f39101a = new HashMap(tMap.f38035c * 2);
            for (int i = 0; i < tMap.f38035c; i++) {
                String mo14400z = tTupleProtocol.mo14400z();
                ImprintValue imprintValue = new ImprintValue();
                imprintValue.read(tTupleProtocol);
                imprint.f39101a.put(mo14400z, imprintValue);
            }
            imprint.m13542a(true);
            imprint.f39102b = tTupleProtocol.mo14403w();
            imprint.m13539b(true);
            imprint.f39103c = tTupleProtocol.mo14400z();
            imprint.m13537c(true);
        }
    }

    /* compiled from: Imprint.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.d$d */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class C13289d implements SchemeFactory {
        private C13289d() {
        }

        @Override // com.umeng.analytics.pro.SchemeFactory
        /* renamed from: a */
        public C13288c mo13482b() {
            return new C13288c();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f39099j = hashMap;
        hashMap.put(StandardScheme.class, new C13287b());
        hashMap.put(TupleScheme.class, new C13289d());
        EnumMap enumMap = new EnumMap(EnumC13290e.class);
        enumMap.put((EnumMap) EnumC13290e.PROPERTY, (EnumC13290e) new FieldMetaData("property", (byte) 1, new MapMetaData((byte) 13, new FieldValueMetaData((byte) 11), new StructMetaData((byte) 12, ImprintValue.class))));
        enumMap.put((EnumMap) EnumC13290e.VERSION, (EnumC13290e) new FieldMetaData(ConstantHelper.LOG_VS, (byte) 1, new FieldValueMetaData((byte) 8)));
        enumMap.put((EnumMap) EnumC13290e.CHECKSUM, (EnumC13290e) new FieldMetaData("checksum", (byte) 1, new FieldValueMetaData((byte) 11)));
        Map<EnumC13290e, FieldMetaData> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f39093d = unmodifiableMap;
        FieldMetaData.m14474a(Imprint.class, unmodifiableMap);
    }

    public Imprint() {
        this.f39104l = (byte) 0;
    }

    @Override // com.umeng.analytics.pro.TBase
    /* renamed from: a */
    public Imprint deepCopy() {
        return new Imprint(this);
    }

    /* renamed from: b */
    public int m13541b() {
        Map<String, ImprintValue> map = this.f39101a;
        if (map == null) {
            return 0;
        }
        return map.size();
    }

    /* renamed from: c */
    public Map<String, ImprintValue> m13538c() {
        return this.f39101a;
    }

    @Override // com.umeng.analytics.pro.TBase
    public void clear() {
        this.f39101a = null;
        m13539b(false);
        this.f39102b = 0;
        this.f39103c = null;
    }

    /* renamed from: d */
    public void m13536d() {
        this.f39101a = null;
    }

    /* renamed from: e */
    public boolean m13535e() {
        return this.f39101a != null;
    }

    /* renamed from: f */
    public int m13534f() {
        return this.f39102b;
    }

    /* renamed from: g */
    public void m13533g() {
        this.f39104l = EncodingUtils.m14556b(this.f39104l, 0);
    }

    /* renamed from: h */
    public boolean m13532h() {
        return EncodingUtils.m14568a(this.f39104l, 0);
    }

    /* renamed from: i */
    public String m13531i() {
        return this.f39103c;
    }

    /* renamed from: j */
    public void m13530j() {
        this.f39103c = null;
    }

    /* renamed from: k */
    public boolean m13529k() {
        return this.f39103c != null;
    }

    /* renamed from: l */
    public void m13528l() throws TException {
        if (this.f39101a != null) {
            if (this.f39103c != null) {
                return;
            }
            throw new TProtocolException("Required field 'checksum' was not present! Struct: " + toString());
        }
        throw new TProtocolException("Required field 'property' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.TBase
    public void read(TProtocol tProtocol) throws TException {
        f39099j.get(tProtocol.mo14394D()).mo13482b().mo13485b(tProtocol, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Imprint(");
        sb.append("property:");
        Map<String, ImprintValue> map = this.f39101a;
        if (map == null) {
            sb.append("null");
        } else {
            sb.append(map);
        }
        sb.append(", ");
        sb.append("version:");
        sb.append(this.f39102b);
        sb.append(", ");
        sb.append("checksum:");
        String str = this.f39103c;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(")");
        return sb.toString();
    }

    @Override // com.umeng.analytics.pro.TBase
    public void write(TProtocol tProtocol) throws TException {
        f39099j.get(tProtocol.mo14394D()).mo13482b().mo13487a(tProtocol, this);
    }

    /* compiled from: Imprint.java */
    /* renamed from: com.umeng.commonsdk.statistics.proto.d$e */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public enum EnumC13290e implements TFieldIdEnum {
        PROPERTY(1, "property"),
        VERSION(2, ConstantHelper.LOG_VS),
        CHECKSUM(3, "checksum");
        

        /* renamed from: d */
        private static final Map<String, EnumC13290e> f39108d = new HashMap();

        /* renamed from: e */
        private final short f39110e;

        /* renamed from: f */
        private final String f39111f;

        static {
            Iterator it = EnumSet.allOf(EnumC13290e.class).iterator();
            while (it.hasNext()) {
                EnumC13290e enumC13290e = (EnumC13290e) it.next();
                f39108d.put(enumC13290e.mo13478b(), enumC13290e);
            }
        }

        EnumC13290e(short s, String str) {
            this.f39110e = s;
            this.f39111f = str;
        }

        /* renamed from: a */
        public static EnumC13290e m13517a(int i) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return CHECKSUM;
                }
                return VERSION;
            }
            return PROPERTY;
        }

        /* renamed from: b */
        public static EnumC13290e m13515b(int i) {
            EnumC13290e m13517a = m13517a(i);
            if (m13517a != null) {
                return m13517a;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        @Override // com.umeng.analytics.pro.TFieldIdEnum
        /* renamed from: b */
        public String mo13478b() {
            return this.f39111f;
        }

        /* renamed from: a */
        public static EnumC13290e m13516a(String str) {
            return f39108d.get(str);
        }

        @Override // com.umeng.analytics.pro.TFieldIdEnum
        /* renamed from: a */
        public short mo13481a() {
            return this.f39110e;
        }
    }

    /* renamed from: a */
    public void m13544a(String str, ImprintValue imprintValue) {
        if (this.f39101a == null) {
            this.f39101a = new HashMap();
        }
        this.f39101a.put(str, imprintValue);
    }

    /* renamed from: b */
    public void m13539b(boolean z) {
        this.f39104l = EncodingUtils.m14567a(this.f39104l, 0, z);
    }

    /* renamed from: c */
    public void m13537c(boolean z) {
        if (z) {
            return;
        }
        this.f39103c = null;
    }

    public Imprint(Map<String, ImprintValue> map, int i, String str) {
        this();
        this.f39101a = map;
        this.f39102b = i;
        m13539b(true);
        this.f39103c = str;
    }

    @Override // com.umeng.analytics.pro.TBase
    /* renamed from: b */
    public EnumC13290e fieldForId(int i) {
        return EnumC13290e.m13517a(i);
    }

    /* renamed from: a */
    public Imprint m13543a(Map<String, ImprintValue> map) {
        this.f39101a = map;
        return this;
    }

    /* renamed from: a */
    public void m13542a(boolean z) {
        if (z) {
            return;
        }
        this.f39101a = null;
    }

    /* renamed from: a */
    public Imprint m13548a(int i) {
        this.f39102b = i;
        m13539b(true);
        return this;
    }

    public Imprint(Imprint imprint) {
        this.f39104l = (byte) 0;
        this.f39104l = imprint.f39104l;
        if (imprint.m13535e()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, ImprintValue> entry : imprint.f39101a.entrySet()) {
                hashMap.put(entry.getKey(), new ImprintValue(entry.getValue()));
            }
            this.f39101a = hashMap;
        }
        this.f39102b = imprint.f39102b;
        if (imprint.m13529k()) {
            this.f39103c = imprint.f39103c;
        }
    }

    /* renamed from: a */
    public Imprint m13545a(String str) {
        this.f39103c = str;
        return this;
    }

    /* renamed from: a */
    private void m13546a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new TCompactProtocol(new TIOStreamTransport(objectOutputStream)));
        } catch (TException e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: a */
    private void m13547a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f39104l = (byte) 0;
            read(new TCompactProtocol(new TIOStreamTransport(objectInputStream)));
        } catch (TException e) {
            throw new IOException(e.getMessage());
        }
    }
}
