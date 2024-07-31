package com.umeng.analytics.pro;

import com.baidu.idl.face.platform.common.ConstantHelper;
import com.tencent.open.SocialOperation;
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

/* renamed from: com.umeng.analytics.pro.bj */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class UMEnvelope implements TBase<UMEnvelope, EnumC13130e>, Serializable, Cloneable {

    /* renamed from: A */
    private static final int f37868A = 2;

    /* renamed from: B */
    private static final int f37869B = 3;

    /* renamed from: k */
    public static final Map<EnumC13130e, FieldMetaData> f37870k;

    /* renamed from: l */
    private static final long f37871l = 420342210744516016L;

    /* renamed from: m */
    private static final TStruct f37872m = new TStruct("UMEnvelope");

    /* renamed from: n */
    private static final TField f37873n = new TField(ConstantHelper.LOG_VS, (byte) 11, 1);

    /* renamed from: o */
    private static final TField f37874o = new TField("address", (byte) 11, 2);

    /* renamed from: p */
    private static final TField f37875p = new TField(SocialOperation.GAME_SIGNATURE, (byte) 11, 3);

    /* renamed from: q */
    private static final TField f37876q = new TField("serial_num", (byte) 8, 4);

    /* renamed from: r */
    private static final TField f37877r = new TField("ts_secs", (byte) 8, 5);

    /* renamed from: s */
    private static final TField f37878s = new TField("length", (byte) 8, 6);

    /* renamed from: t */
    private static final TField f37879t = new TField("entity", (byte) 11, 7);

    /* renamed from: u */
    private static final TField f37880u = new TField("guid", (byte) 11, 8);

    /* renamed from: v */
    private static final TField f37881v = new TField("checksum", (byte) 11, 9);

    /* renamed from: w */
    private static final TField f37882w = new TField("codex", (byte) 8, 10);

    /* renamed from: x */
    private static final Map<Class<? extends IScheme>, SchemeFactory> f37883x;

    /* renamed from: y */
    private static final int f37884y = 0;

    /* renamed from: z */
    private static final int f37885z = 1;

    /* renamed from: C */
    private byte f37886C;

    /* renamed from: D */
    private EnumC13130e[] f37887D;

    /* renamed from: a */
    public String f37888a;

    /* renamed from: b */
    public String f37889b;

    /* renamed from: c */
    public String f37890c;

    /* renamed from: d */
    public int f37891d;

    /* renamed from: e */
    public int f37892e;

    /* renamed from: f */
    public int f37893f;

    /* renamed from: g */
    public ByteBuffer f37894g;

    /* renamed from: h */
    public String f37895h;

    /* renamed from: i */
    public String f37896i;

    /* renamed from: j */
    public int f37897j;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UMEnvelope.java */
    /* renamed from: com.umeng.analytics.pro.bj$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C13126a extends StandardScheme<UMEnvelope> {
        private C13126a() {
        }

        @Override // com.umeng.analytics.pro.IScheme
        /* renamed from: a */
        public void mo13485b(TProtocol tProtocol, UMEnvelope uMEnvelope) throws TException {
            tProtocol.mo14416j();
            while (true) {
                TField mo14414l = tProtocol.mo14414l();
                byte b = mo14414l.f38029b;
                if (b == 0) {
                    tProtocol.mo14415k();
                    if (uMEnvelope.m14604m()) {
                        if (uMEnvelope.m14601p()) {
                            if (uMEnvelope.m14598s()) {
                                uMEnvelope.m14652G();
                                return;
                            }
                            throw new TProtocolException("Required field 'length' was not found in serialized data! Struct: " + toString());
                        }
                        throw new TProtocolException("Required field 'ts_secs' was not found in serialized data! Struct: " + toString());
                    }
                    throw new TProtocolException("Required field 'serial_num' was not found in serialized data! Struct: " + toString());
                }
                switch (mo14414l.f38030c) {
                    case 1:
                        if (b == 11) {
                            uMEnvelope.f37888a = tProtocol.mo14400z();
                            uMEnvelope.m14634a(true);
                            break;
                        } else {
                            TProtocolUtil.m14397a(tProtocol, b);
                            break;
                        }
                    case 2:
                        if (b == 11) {
                            uMEnvelope.f37889b = tProtocol.mo14400z();
                            uMEnvelope.m14629b(true);
                            break;
                        } else {
                            TProtocolUtil.m14397a(tProtocol, b);
                            break;
                        }
                    case 3:
                        if (b == 11) {
                            uMEnvelope.f37890c = tProtocol.mo14400z();
                            uMEnvelope.m14625c(true);
                            break;
                        } else {
                            TProtocolUtil.m14397a(tProtocol, b);
                            break;
                        }
                    case 4:
                        if (b == 8) {
                            uMEnvelope.f37891d = tProtocol.mo14403w();
                            uMEnvelope.m14621d(true);
                            break;
                        } else {
                            TProtocolUtil.m14397a(tProtocol, b);
                            break;
                        }
                    case 5:
                        if (b == 8) {
                            uMEnvelope.f37892e = tProtocol.mo14403w();
                            uMEnvelope.m14617e(true);
                            break;
                        } else {
                            TProtocolUtil.m14397a(tProtocol, b);
                            break;
                        }
                    case 6:
                        if (b == 8) {
                            uMEnvelope.f37893f = tProtocol.mo14403w();
                            uMEnvelope.m14615f(true);
                            break;
                        } else {
                            TProtocolUtil.m14397a(tProtocol, b);
                            break;
                        }
                    case 7:
                        if (b == 11) {
                            uMEnvelope.f37894g = tProtocol.mo14442A();
                            uMEnvelope.m14613g(true);
                            break;
                        } else {
                            TProtocolUtil.m14397a(tProtocol, b);
                            break;
                        }
                    case 8:
                        if (b == 11) {
                            uMEnvelope.f37895h = tProtocol.mo14400z();
                            uMEnvelope.m14611h(true);
                            break;
                        } else {
                            TProtocolUtil.m14397a(tProtocol, b);
                            break;
                        }
                    case 9:
                        if (b == 11) {
                            uMEnvelope.f37896i = tProtocol.mo14400z();
                            uMEnvelope.m14609i(true);
                            break;
                        } else {
                            TProtocolUtil.m14397a(tProtocol, b);
                            break;
                        }
                    case 10:
                        if (b == 8) {
                            uMEnvelope.f37897j = tProtocol.mo14403w();
                            uMEnvelope.m14607j(true);
                            break;
                        } else {
                            TProtocolUtil.m14397a(tProtocol, b);
                            break;
                        }
                    default:
                        TProtocolUtil.m14397a(tProtocol, b);
                        break;
                }
                tProtocol.mo14413m();
            }
        }

        @Override // com.umeng.analytics.pro.IScheme
        /* renamed from: b */
        public void mo13487a(TProtocol tProtocol, UMEnvelope uMEnvelope) throws TException {
            uMEnvelope.m14652G();
            tProtocol.mo14429a(UMEnvelope.f37872m);
            if (uMEnvelope.f37888a != null) {
                tProtocol.mo14434a(UMEnvelope.f37873n);
                tProtocol.mo14428a(uMEnvelope.f37888a);
                tProtocol.mo14423c();
            }
            if (uMEnvelope.f37889b != null) {
                tProtocol.mo14434a(UMEnvelope.f37874o);
                tProtocol.mo14428a(uMEnvelope.f37889b);
                tProtocol.mo14423c();
            }
            if (uMEnvelope.f37890c != null) {
                tProtocol.mo14434a(UMEnvelope.f37875p);
                tProtocol.mo14428a(uMEnvelope.f37890c);
                tProtocol.mo14423c();
            }
            tProtocol.mo14434a(UMEnvelope.f37876q);
            tProtocol.mo14436a(uMEnvelope.f37891d);
            tProtocol.mo14423c();
            tProtocol.mo14434a(UMEnvelope.f37877r);
            tProtocol.mo14436a(uMEnvelope.f37892e);
            tProtocol.mo14423c();
            tProtocol.mo14434a(UMEnvelope.f37878s);
            tProtocol.mo14436a(uMEnvelope.f37893f);
            tProtocol.mo14423c();
            if (uMEnvelope.f37894g != null) {
                tProtocol.mo14434a(UMEnvelope.f37879t);
                tProtocol.mo14427a(uMEnvelope.f37894g);
                tProtocol.mo14423c();
            }
            if (uMEnvelope.f37895h != null) {
                tProtocol.mo14434a(UMEnvelope.f37880u);
                tProtocol.mo14428a(uMEnvelope.f37895h);
                tProtocol.mo14423c();
            }
            if (uMEnvelope.f37896i != null) {
                tProtocol.mo14434a(UMEnvelope.f37881v);
                tProtocol.mo14428a(uMEnvelope.f37896i);
                tProtocol.mo14423c();
            }
            if (uMEnvelope.m14653F()) {
                tProtocol.mo14434a(UMEnvelope.f37882w);
                tProtocol.mo14436a(uMEnvelope.f37897j);
                tProtocol.mo14423c();
            }
            tProtocol.mo14422d();
            tProtocol.mo14424b();
        }
    }

    /* compiled from: UMEnvelope.java */
    /* renamed from: com.umeng.analytics.pro.bj$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class C13127b implements SchemeFactory {
        private C13127b() {
        }

        @Override // com.umeng.analytics.pro.SchemeFactory
        /* renamed from: a */
        public C13126a mo13482b() {
            return new C13126a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: UMEnvelope.java */
    /* renamed from: com.umeng.analytics.pro.bj$c */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C13128c extends TupleScheme<UMEnvelope> {
        private C13128c() {
        }

        @Override // com.umeng.analytics.pro.IScheme
        /* renamed from: a */
        public void mo13487a(TProtocol tProtocol, UMEnvelope uMEnvelope) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol) tProtocol;
            tTupleProtocol.mo14428a(uMEnvelope.f37888a);
            tTupleProtocol.mo14428a(uMEnvelope.f37889b);
            tTupleProtocol.mo14428a(uMEnvelope.f37890c);
            tTupleProtocol.mo14436a(uMEnvelope.f37891d);
            tTupleProtocol.mo14436a(uMEnvelope.f37892e);
            tTupleProtocol.mo14436a(uMEnvelope.f37893f);
            tTupleProtocol.mo14427a(uMEnvelope.f37894g);
            tTupleProtocol.mo14428a(uMEnvelope.f37895h);
            tTupleProtocol.mo14428a(uMEnvelope.f37896i);
            BitSet bitSet = new BitSet();
            if (uMEnvelope.m14653F()) {
                bitSet.set(0);
            }
            tTupleProtocol.m14393a(bitSet, 1);
            if (uMEnvelope.m14653F()) {
                tTupleProtocol.mo14436a(uMEnvelope.f37897j);
            }
        }

        @Override // com.umeng.analytics.pro.IScheme
        /* renamed from: b */
        public void mo13485b(TProtocol tProtocol, UMEnvelope uMEnvelope) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol) tProtocol;
            uMEnvelope.f37888a = tTupleProtocol.mo14400z();
            uMEnvelope.m14634a(true);
            uMEnvelope.f37889b = tTupleProtocol.mo14400z();
            uMEnvelope.m14629b(true);
            uMEnvelope.f37890c = tTupleProtocol.mo14400z();
            uMEnvelope.m14625c(true);
            uMEnvelope.f37891d = tTupleProtocol.mo14403w();
            uMEnvelope.m14621d(true);
            uMEnvelope.f37892e = tTupleProtocol.mo14403w();
            uMEnvelope.m14617e(true);
            uMEnvelope.f37893f = tTupleProtocol.mo14403w();
            uMEnvelope.m14615f(true);
            uMEnvelope.f37894g = tTupleProtocol.mo14442A();
            uMEnvelope.m14613g(true);
            uMEnvelope.f37895h = tTupleProtocol.mo14400z();
            uMEnvelope.m14611h(true);
            uMEnvelope.f37896i = tTupleProtocol.mo14400z();
            uMEnvelope.m14609i(true);
            if (tTupleProtocol.m14391b(1).get(0)) {
                uMEnvelope.f37897j = tTupleProtocol.mo14403w();
                uMEnvelope.m14607j(true);
            }
        }
    }

    /* compiled from: UMEnvelope.java */
    /* renamed from: com.umeng.analytics.pro.bj$d */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class C13129d implements SchemeFactory {
        private C13129d() {
        }

        @Override // com.umeng.analytics.pro.SchemeFactory
        /* renamed from: a */
        public C13128c mo13482b() {
            return new C13128c();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f37883x = hashMap;
        hashMap.put(StandardScheme.class, new C13127b());
        hashMap.put(TupleScheme.class, new C13129d());
        EnumMap enumMap = new EnumMap(EnumC13130e.class);
        enumMap.put((EnumMap) EnumC13130e.VERSION, (EnumC13130e) new FieldMetaData(ConstantHelper.LOG_VS, (byte) 1, new FieldValueMetaData((byte) 11)));
        enumMap.put((EnumMap) EnumC13130e.ADDRESS, (EnumC13130e) new FieldMetaData("address", (byte) 1, new FieldValueMetaData((byte) 11)));
        enumMap.put((EnumMap) EnumC13130e.SIGNATURE, (EnumC13130e) new FieldMetaData(SocialOperation.GAME_SIGNATURE, (byte) 1, new FieldValueMetaData((byte) 11)));
        enumMap.put((EnumMap) EnumC13130e.SERIAL_NUM, (EnumC13130e) new FieldMetaData("serial_num", (byte) 1, new FieldValueMetaData((byte) 8)));
        enumMap.put((EnumMap) EnumC13130e.TS_SECS, (EnumC13130e) new FieldMetaData("ts_secs", (byte) 1, new FieldValueMetaData((byte) 8)));
        enumMap.put((EnumMap) EnumC13130e.LENGTH, (EnumC13130e) new FieldMetaData("length", (byte) 1, new FieldValueMetaData((byte) 8)));
        enumMap.put((EnumMap) EnumC13130e.ENTITY, (EnumC13130e) new FieldMetaData("entity", (byte) 1, new FieldValueMetaData((byte) 11, true)));
        enumMap.put((EnumMap) EnumC13130e.GUID, (EnumC13130e) new FieldMetaData("guid", (byte) 1, new FieldValueMetaData((byte) 11)));
        enumMap.put((EnumMap) EnumC13130e.CHECKSUM, (EnumC13130e) new FieldMetaData("checksum", (byte) 1, new FieldValueMetaData((byte) 11)));
        enumMap.put((EnumMap) EnumC13130e.CODEX, (EnumC13130e) new FieldMetaData("codex", (byte) 2, new FieldValueMetaData((byte) 8)));
        Map<EnumC13130e, FieldMetaData> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        f37870k = unmodifiableMap;
        FieldMetaData.m14474a(UMEnvelope.class, unmodifiableMap);
    }

    public UMEnvelope() {
        this.f37886C = (byte) 0;
        this.f37887D = new EnumC13130e[]{EnumC13130e.CODEX};
    }

    /* renamed from: A */
    public String m14658A() {
        return this.f37896i;
    }

    /* renamed from: B */
    public void m14657B() {
        this.f37896i = null;
    }

    /* renamed from: C */
    public boolean m14656C() {
        return this.f37896i != null;
    }

    /* renamed from: D */
    public int m14655D() {
        return this.f37897j;
    }

    /* renamed from: E */
    public void m14654E() {
        this.f37886C = EncodingUtils.m14556b(this.f37886C, 3);
    }

    /* renamed from: F */
    public boolean m14653F() {
        return EncodingUtils.m14568a(this.f37886C, 3);
    }

    /* renamed from: G */
    public void m14652G() throws TException {
        if (this.f37888a != null) {
            if (this.f37889b != null) {
                if (this.f37890c != null) {
                    if (this.f37894g != null) {
                        if (this.f37895h != null) {
                            if (this.f37896i != null) {
                                return;
                            }
                            throw new TProtocolException("Required field 'checksum' was not present! Struct: " + toString());
                        }
                        throw new TProtocolException("Required field 'guid' was not present! Struct: " + toString());
                    }
                    throw new TProtocolException("Required field 'entity' was not present! Struct: " + toString());
                }
                throw new TProtocolException("Required field 'signature' was not present! Struct: " + toString());
            }
            throw new TProtocolException("Required field 'address' was not present! Struct: " + toString());
        }
        throw new TProtocolException("Required field 'version' was not present! Struct: " + toString());
    }

    @Override // com.umeng.analytics.pro.TBase
    /* renamed from: a */
    public UMEnvelope deepCopy() {
        return new UMEnvelope(this);
    }

    /* renamed from: b */
    public String m14632b() {
        return this.f37888a;
    }

    /* renamed from: c */
    public void m14628c() {
        this.f37888a = null;
    }

    @Override // com.umeng.analytics.pro.TBase
    public void clear() {
        this.f37888a = null;
        this.f37889b = null;
        this.f37890c = null;
        m14621d(false);
        this.f37891d = 0;
        m14617e(false);
        this.f37892e = 0;
        m14615f(false);
        this.f37893f = 0;
        this.f37894g = null;
        this.f37895h = null;
        this.f37896i = null;
        m14607j(false);
        this.f37897j = 0;
    }

    /* renamed from: d */
    public boolean m14624d() {
        return this.f37888a != null;
    }

    /* renamed from: e */
    public String m14620e() {
        return this.f37889b;
    }

    /* renamed from: f */
    public void m14616f() {
        this.f37889b = null;
    }

    /* renamed from: g */
    public boolean m14614g() {
        return this.f37889b != null;
    }

    /* renamed from: h */
    public String m14612h() {
        return this.f37890c;
    }

    /* renamed from: i */
    public void m14610i() {
        this.f37890c = null;
    }

    /* renamed from: j */
    public boolean m14608j() {
        return this.f37890c != null;
    }

    /* renamed from: k */
    public int m14606k() {
        return this.f37891d;
    }

    /* renamed from: l */
    public void m14605l() {
        this.f37886C = EncodingUtils.m14556b(this.f37886C, 0);
    }

    /* renamed from: m */
    public boolean m14604m() {
        return EncodingUtils.m14568a(this.f37886C, 0);
    }

    /* renamed from: n */
    public int m14603n() {
        return this.f37892e;
    }

    /* renamed from: o */
    public void m14602o() {
        this.f37886C = EncodingUtils.m14556b(this.f37886C, 1);
    }

    /* renamed from: p */
    public boolean m14601p() {
        return EncodingUtils.m14568a(this.f37886C, 1);
    }

    /* renamed from: q */
    public int m14600q() {
        return this.f37893f;
    }

    /* renamed from: r */
    public void m14599r() {
        this.f37886C = EncodingUtils.m14556b(this.f37886C, 2);
    }

    @Override // com.umeng.analytics.pro.TBase
    public void read(TProtocol tProtocol) throws TException {
        f37883x.get(tProtocol.mo14394D()).mo13482b().mo13485b(tProtocol, this);
    }

    /* renamed from: s */
    public boolean m14598s() {
        return EncodingUtils.m14568a(this.f37886C, 2);
    }

    /* renamed from: t */
    public byte[] m14597t() {
        m14635a(TBaseHelper.m14525c(this.f37894g));
        ByteBuffer byteBuffer = this.f37894g;
        if (byteBuffer == null) {
            return null;
        }
        return byteBuffer.array();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UMEnvelope(");
        sb.append("version:");
        String str = this.f37888a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(", ");
        sb.append("address:");
        String str2 = this.f37889b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(", ");
        sb.append("signature:");
        String str3 = this.f37890c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(", ");
        sb.append("serial_num:");
        sb.append(this.f37891d);
        sb.append(", ");
        sb.append("ts_secs:");
        sb.append(this.f37892e);
        sb.append(", ");
        sb.append("length:");
        sb.append(this.f37893f);
        sb.append(", ");
        sb.append("entity:");
        ByteBuffer byteBuffer = this.f37894g;
        if (byteBuffer == null) {
            sb.append("null");
        } else {
            TBaseHelper.m14535a(byteBuffer, sb);
        }
        sb.append(", ");
        sb.append("guid:");
        String str4 = this.f37895h;
        if (str4 == null) {
            sb.append("null");
        } else {
            sb.append(str4);
        }
        sb.append(", ");
        sb.append("checksum:");
        String str5 = this.f37896i;
        if (str5 == null) {
            sb.append("null");
        } else {
            sb.append(str5);
        }
        if (m14653F()) {
            sb.append(", ");
            sb.append("codex:");
            sb.append(this.f37897j);
        }
        sb.append(")");
        return sb.toString();
    }

    /* renamed from: u */
    public ByteBuffer m14596u() {
        return this.f37894g;
    }

    /* renamed from: v */
    public void m14595v() {
        this.f37894g = null;
    }

    /* renamed from: w */
    public boolean m14594w() {
        return this.f37894g != null;
    }

    @Override // com.umeng.analytics.pro.TBase
    public void write(TProtocol tProtocol) throws TException {
        f37883x.get(tProtocol.mo14394D()).mo13482b().mo13487a(tProtocol, this);
    }

    /* renamed from: x */
    public String m14593x() {
        return this.f37895h;
    }

    /* renamed from: y */
    public void m14592y() {
        this.f37895h = null;
    }

    /* renamed from: z */
    public boolean m14591z() {
        return this.f37895h != null;
    }

    /* compiled from: UMEnvelope.java */
    /* renamed from: com.umeng.analytics.pro.bj$e */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public enum EnumC13130e implements TFieldIdEnum {
        VERSION(1, ConstantHelper.LOG_VS),
        ADDRESS(2, "address"),
        SIGNATURE(3, SocialOperation.GAME_SIGNATURE),
        SERIAL_NUM(4, "serial_num"),
        TS_SECS(5, "ts_secs"),
        LENGTH(6, "length"),
        ENTITY(7, "entity"),
        GUID(8, "guid"),
        CHECKSUM(9, "checksum"),
        CODEX(10, "codex");
        

        /* renamed from: k */
        private static final Map<String, EnumC13130e> f37908k = new HashMap();

        /* renamed from: l */
        private final short f37910l;

        /* renamed from: m */
        private final String f37911m;

        static {
            Iterator it = EnumSet.allOf(EnumC13130e.class).iterator();
            while (it.hasNext()) {
                EnumC13130e enumC13130e = (EnumC13130e) it.next();
                f37908k.put(enumC13130e.mo13478b(), enumC13130e);
            }
        }

        EnumC13130e(short s, String str) {
            this.f37910l = s;
            this.f37911m = str;
        }

        /* renamed from: a */
        public static EnumC13130e m14584a(int i) {
            switch (i) {
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

        /* renamed from: b */
        public static EnumC13130e m14582b(int i) {
            EnumC13130e m14584a = m14584a(i);
            if (m14584a != null) {
                return m14584a;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        @Override // com.umeng.analytics.pro.TFieldIdEnum
        /* renamed from: b */
        public String mo13478b() {
            return this.f37911m;
        }

        /* renamed from: a */
        public static EnumC13130e m14583a(String str) {
            return f37908k.get(str);
        }

        @Override // com.umeng.analytics.pro.TFieldIdEnum
        /* renamed from: a */
        public short mo13481a() {
            return this.f37910l;
        }
    }

    /* renamed from: a */
    public UMEnvelope m14636a(String str) {
        this.f37888a = str;
        return this;
    }

    /* renamed from: b */
    public UMEnvelope m14630b(String str) {
        this.f37889b = str;
        return this;
    }

    /* renamed from: c */
    public UMEnvelope m14626c(String str) {
        this.f37890c = str;
        return this;
    }

    /* renamed from: d */
    public void m14621d(boolean z) {
        this.f37886C = EncodingUtils.m14567a(this.f37886C, 0, z);
    }

    /* renamed from: e */
    public void m14617e(boolean z) {
        this.f37886C = EncodingUtils.m14567a(this.f37886C, 1, z);
    }

    /* renamed from: f */
    public void m14615f(boolean z) {
        this.f37886C = EncodingUtils.m14567a(this.f37886C, 2, z);
    }

    /* renamed from: g */
    public void m14613g(boolean z) {
        if (z) {
            return;
        }
        this.f37894g = null;
    }

    /* renamed from: h */
    public void m14611h(boolean z) {
        if (z) {
            return;
        }
        this.f37895h = null;
    }

    /* renamed from: i */
    public void m14609i(boolean z) {
        if (z) {
            return;
        }
        this.f37896i = null;
    }

    /* renamed from: j */
    public void m14607j(boolean z) {
        this.f37886C = EncodingUtils.m14567a(this.f37886C, 3, z);
    }

    /* renamed from: a */
    public void m14634a(boolean z) {
        if (z) {
            return;
        }
        this.f37888a = null;
    }

    /* renamed from: b */
    public void m14629b(boolean z) {
        if (z) {
            return;
        }
        this.f37889b = null;
    }

    /* renamed from: c */
    public void m14625c(boolean z) {
        if (z) {
            return;
        }
        this.f37890c = null;
    }

    /* renamed from: d */
    public UMEnvelope m14622d(String str) {
        this.f37895h = str;
        return this;
    }

    /* renamed from: e */
    public UMEnvelope m14618e(String str) {
        this.f37896i = str;
        return this;
    }

    public UMEnvelope(String str, String str2, String str3, int i, int i2, int i3, ByteBuffer byteBuffer, String str4, String str5) {
        this();
        this.f37888a = str;
        this.f37889b = str2;
        this.f37890c = str3;
        this.f37891d = i;
        m14621d(true);
        this.f37892e = i2;
        m14617e(true);
        this.f37893f = i3;
        m14615f(true);
        this.f37894g = byteBuffer;
        this.f37895h = str4;
        this.f37896i = str5;
    }

    /* renamed from: a */
    public UMEnvelope m14639a(int i) {
        this.f37891d = i;
        m14621d(true);
        return this;
    }

    /* renamed from: b */
    public UMEnvelope m14631b(int i) {
        this.f37892e = i;
        m14617e(true);
        return this;
    }

    /* renamed from: c */
    public UMEnvelope m14627c(int i) {
        this.f37893f = i;
        m14615f(true);
        return this;
    }

    /* renamed from: d */
    public UMEnvelope m14623d(int i) {
        this.f37897j = i;
        m14607j(true);
        return this;
    }

    @Override // com.umeng.analytics.pro.TBase
    /* renamed from: e */
    public EnumC13130e fieldForId(int i) {
        return EnumC13130e.m14584a(i);
    }

    /* renamed from: a */
    public UMEnvelope m14633a(byte[] bArr) {
        m14635a(bArr == null ? null : ByteBuffer.wrap(bArr));
        return this;
    }

    /* renamed from: a */
    public UMEnvelope m14635a(ByteBuffer byteBuffer) {
        this.f37894g = byteBuffer;
        return this;
    }

    /* renamed from: a */
    private void m14637a(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new TCompactProtocol(new TIOStreamTransport(objectOutputStream)));
        } catch (TException e) {
            throw new IOException(e.getMessage());
        }
    }

    /* renamed from: a */
    private void m14638a(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.f37886C = (byte) 0;
            read(new TCompactProtocol(new TIOStreamTransport(objectInputStream)));
        } catch (TException e) {
            throw new IOException(e.getMessage());
        }
    }

    public UMEnvelope(UMEnvelope uMEnvelope) {
        this.f37886C = (byte) 0;
        this.f37887D = new EnumC13130e[]{EnumC13130e.CODEX};
        this.f37886C = uMEnvelope.f37886C;
        if (uMEnvelope.m14624d()) {
            this.f37888a = uMEnvelope.f37888a;
        }
        if (uMEnvelope.m14614g()) {
            this.f37889b = uMEnvelope.f37889b;
        }
        if (uMEnvelope.m14608j()) {
            this.f37890c = uMEnvelope.f37890c;
        }
        this.f37891d = uMEnvelope.f37891d;
        this.f37892e = uMEnvelope.f37892e;
        this.f37893f = uMEnvelope.f37893f;
        if (uMEnvelope.m14594w()) {
            this.f37894g = TBaseHelper.m14524d(uMEnvelope.f37894g);
        }
        if (uMEnvelope.m14591z()) {
            this.f37895h = uMEnvelope.f37895h;
        }
        if (uMEnvelope.m14656C()) {
            this.f37896i = uMEnvelope.f37896i;
        }
        this.f37897j = uMEnvelope.f37897j;
    }
}
