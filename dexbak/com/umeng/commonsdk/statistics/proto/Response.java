package com.umeng.commonsdk.statistics.proto;

import com.umeng.analytics.pro.EncodingUtils;
import com.umeng.analytics.pro.FieldMetaData;
import com.umeng.analytics.pro.FieldValueMetaData;
import com.umeng.analytics.pro.IScheme;
import com.umeng.analytics.pro.SchemeFactory;
import com.umeng.analytics.pro.StandardScheme;
import com.umeng.analytics.pro.StructMetaData;
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
import com.umeng.analytics.pro.UMCommonContent;
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

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class Response implements TBase<Response, EnumC13266e>, Serializable, Cloneable {
    private static final int __RESP_CODE_ISSET_ID = 0;
    public static final Map<EnumC13266e, FieldMetaData> metaDataMap;
    private static final Map<Class<? extends IScheme>, SchemeFactory> schemes;
    private static final long serialVersionUID = -4549277923241195391L;
    private byte __isset_bitfield;
    public Imprint imprint;
    public String msg;
    private EnumC13266e[] optionals;
    public int resp_code;
    private static final TStruct STRUCT_DESC = new TStruct("Response");
    private static final TField RESP_CODE_FIELD_DESC = new TField("resp_code", (byte) 8, 1);
    private static final TField MSG_FIELD_DESC = new TField("msg", (byte) 11, 2);
    private static final TField IMPRINT_FIELD_DESC = new TField(UMCommonContent.f37767X, (byte) 12, 3);

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.umeng.commonsdk.statistics.proto.Response$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C13262a extends StandardScheme<Response> {
        private C13262a() {
        }

        @Override // com.umeng.analytics.pro.IScheme
        /* renamed from: a */
        public void mo13485b(TProtocol tProtocol, Response response) throws TException {
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
                        } else if (b == 12) {
                            Imprint imprint = new Imprint();
                            response.imprint = imprint;
                            imprint.read(tProtocol);
                            response.setImprintIsSet(true);
                        } else {
                            TProtocolUtil.m14397a(tProtocol, b);
                        }
                    } else if (b == 11) {
                        response.msg = tProtocol.mo14400z();
                        response.setMsgIsSet(true);
                    } else {
                        TProtocolUtil.m14397a(tProtocol, b);
                    }
                } else if (b == 8) {
                    response.resp_code = tProtocol.mo14403w();
                    response.setResp_codeIsSet(true);
                } else {
                    TProtocolUtil.m14397a(tProtocol, b);
                }
                tProtocol.mo14413m();
            }
            tProtocol.mo14415k();
            if (response.isSetResp_code()) {
                response.validate();
                return;
            }
            throw new TProtocolException("Required field 'resp_code' was not found in serialized data! Struct: " + toString());
        }

        @Override // com.umeng.analytics.pro.IScheme
        /* renamed from: b */
        public void mo13487a(TProtocol tProtocol, Response response) throws TException {
            response.validate();
            tProtocol.mo14429a(Response.STRUCT_DESC);
            tProtocol.mo14434a(Response.RESP_CODE_FIELD_DESC);
            tProtocol.mo14436a(response.resp_code);
            tProtocol.mo14423c();
            if (response.msg != null && response.isSetMsg()) {
                tProtocol.mo14434a(Response.MSG_FIELD_DESC);
                tProtocol.mo14428a(response.msg);
                tProtocol.mo14423c();
            }
            if (response.imprint != null && response.isSetImprint()) {
                tProtocol.mo14434a(Response.IMPRINT_FIELD_DESC);
                response.imprint.write(tProtocol);
                tProtocol.mo14423c();
            }
            tProtocol.mo14422d();
            tProtocol.mo14424b();
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.Response$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class C13263b implements SchemeFactory {
        private C13263b() {
        }

        @Override // com.umeng.analytics.pro.SchemeFactory
        /* renamed from: a */
        public C13262a mo13482b() {
            return new C13262a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.umeng.commonsdk.statistics.proto.Response$c */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C13264c extends TupleScheme<Response> {
        private C13264c() {
        }

        @Override // com.umeng.analytics.pro.IScheme
        /* renamed from: a */
        public void mo13487a(TProtocol tProtocol, Response response) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol) tProtocol;
            tTupleProtocol.mo14436a(response.resp_code);
            BitSet bitSet = new BitSet();
            if (response.isSetMsg()) {
                bitSet.set(0);
            }
            if (response.isSetImprint()) {
                bitSet.set(1);
            }
            tTupleProtocol.m14393a(bitSet, 2);
            if (response.isSetMsg()) {
                tTupleProtocol.mo14428a(response.msg);
            }
            if (response.isSetImprint()) {
                response.imprint.write(tTupleProtocol);
            }
        }

        @Override // com.umeng.analytics.pro.IScheme
        /* renamed from: b */
        public void mo13485b(TProtocol tProtocol, Response response) throws TException {
            TTupleProtocol tTupleProtocol = (TTupleProtocol) tProtocol;
            response.resp_code = tTupleProtocol.mo14403w();
            response.setResp_codeIsSet(true);
            BitSet m14391b = tTupleProtocol.m14391b(2);
            if (m14391b.get(0)) {
                response.msg = tTupleProtocol.mo14400z();
                response.setMsgIsSet(true);
            }
            if (m14391b.get(1)) {
                Imprint imprint = new Imprint();
                response.imprint = imprint;
                imprint.read(tTupleProtocol);
                response.setImprintIsSet(true);
            }
        }
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.Response$d */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class C13265d implements SchemeFactory {
        private C13265d() {
        }

        @Override // com.umeng.analytics.pro.SchemeFactory
        /* renamed from: a */
        public C13264c mo13482b() {
            return new C13264c();
        }
    }

    static {
        HashMap hashMap = new HashMap();
        schemes = hashMap;
        hashMap.put(StandardScheme.class, new C13263b());
        hashMap.put(TupleScheme.class, new C13265d());
        EnumMap enumMap = new EnumMap(EnumC13266e.class);
        enumMap.put((EnumMap) EnumC13266e.RESP_CODE, (EnumC13266e) new FieldMetaData("resp_code", (byte) 1, new FieldValueMetaData((byte) 8)));
        enumMap.put((EnumMap) EnumC13266e.MSG, (EnumC13266e) new FieldMetaData("msg", (byte) 2, new FieldValueMetaData((byte) 11)));
        enumMap.put((EnumMap) EnumC13266e.IMPRINT, (EnumC13266e) new FieldMetaData(UMCommonContent.f37767X, (byte) 2, new StructMetaData((byte) 12, Imprint.class)));
        Map<EnumC13266e, FieldMetaData> unmodifiableMap = Collections.unmodifiableMap(enumMap);
        metaDataMap = unmodifiableMap;
        FieldMetaData.m14474a(Response.class, unmodifiableMap);
    }

    public Response() {
        this.__isset_bitfield = (byte) 0;
        this.optionals = new EnumC13266e[]{EnumC13266e.MSG, EnumC13266e.IMPRINT};
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        try {
            this.__isset_bitfield = (byte) 0;
            read(new TCompactProtocol(new TIOStreamTransport(objectInputStream)));
        } catch (TException e) {
            throw new IOException(e.getMessage());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        try {
            write(new TCompactProtocol(new TIOStreamTransport(objectOutputStream)));
        } catch (TException e) {
            throw new IOException(e.getMessage());
        }
    }

    @Override // com.umeng.analytics.pro.TBase
    public void clear() {
        setResp_codeIsSet(false);
        this.resp_code = 0;
        this.msg = null;
        this.imprint = null;
    }

    public Imprint getImprint() {
        return this.imprint;
    }

    public String getMsg() {
        return this.msg;
    }

    public int getResp_code() {
        return this.resp_code;
    }

    public boolean isSetImprint() {
        return this.imprint != null;
    }

    public boolean isSetMsg() {
        return this.msg != null;
    }

    public boolean isSetResp_code() {
        return EncodingUtils.m14568a(this.__isset_bitfield, 0);
    }

    @Override // com.umeng.analytics.pro.TBase
    public void read(TProtocol tProtocol) throws TException {
        schemes.get(tProtocol.mo14394D()).mo13482b().mo13485b(tProtocol, this);
    }

    public Response setImprint(Imprint imprint) {
        this.imprint = imprint;
        return this;
    }

    public void setImprintIsSet(boolean z) {
        if (z) {
            return;
        }
        this.imprint = null;
    }

    public Response setMsg(String str) {
        this.msg = str;
        return this;
    }

    public void setMsgIsSet(boolean z) {
        if (z) {
            return;
        }
        this.msg = null;
    }

    public Response setResp_code(int i) {
        this.resp_code = i;
        setResp_codeIsSet(true);
        return this;
    }

    public void setResp_codeIsSet(boolean z) {
        this.__isset_bitfield = EncodingUtils.m14567a(this.__isset_bitfield, 0, z);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Response(");
        sb.append("resp_code:");
        sb.append(this.resp_code);
        if (isSetMsg()) {
            sb.append(", ");
            sb.append("msg:");
            String str = this.msg;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
        }
        if (isSetImprint()) {
            sb.append(", ");
            sb.append("imprint:");
            Imprint imprint = this.imprint;
            if (imprint == null) {
                sb.append("null");
            } else {
                sb.append(imprint);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public void unsetImprint() {
        this.imprint = null;
    }

    public void unsetMsg() {
        this.msg = null;
    }

    public void unsetResp_code() {
        this.__isset_bitfield = EncodingUtils.m14556b(this.__isset_bitfield, 0);
    }

    public void validate() throws TException {
        Imprint imprint = this.imprint;
        if (imprint != null) {
            imprint.m13528l();
        }
    }

    @Override // com.umeng.analytics.pro.TBase
    public void write(TProtocol tProtocol) throws TException {
        schemes.get(tProtocol.mo14394D()).mo13482b().mo13487a(tProtocol, this);
    }

    /* renamed from: com.umeng.commonsdk.statistics.proto.Response$e */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public enum EnumC13266e implements TFieldIdEnum {
        RESP_CODE(1, "resp_code"),
        MSG(2, "msg"),
        IMPRINT(3, UMCommonContent.f37767X);
        

        /* renamed from: d */
        private static final Map<String, EnumC13266e> f39028d = new HashMap();

        /* renamed from: e */
        private final short f39030e;

        /* renamed from: f */
        private final String f39031f;

        static {
            Iterator it = EnumSet.allOf(EnumC13266e.class).iterator();
            while (it.hasNext()) {
                EnumC13266e enumC13266e = (EnumC13266e) it.next();
                f39028d.put(enumC13266e.mo13478b(), enumC13266e);
            }
        }

        EnumC13266e(short s, String str) {
            this.f39030e = s;
            this.f39031f = str;
        }

        /* renamed from: a */
        public static EnumC13266e m13662a(int i) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return IMPRINT;
                }
                return MSG;
            }
            return RESP_CODE;
        }

        /* renamed from: b */
        public static EnumC13266e m13660b(int i) {
            EnumC13266e m13662a = m13662a(i);
            if (m13662a != null) {
                return m13662a;
            }
            throw new IllegalArgumentException("Field " + i + " doesn't exist!");
        }

        @Override // com.umeng.analytics.pro.TFieldIdEnum
        /* renamed from: b */
        public String mo13478b() {
            return this.f39031f;
        }

        /* renamed from: a */
        public static EnumC13266e m13661a(String str) {
            return f39028d.get(str);
        }

        @Override // com.umeng.analytics.pro.TFieldIdEnum
        /* renamed from: a */
        public short mo13481a() {
            return this.f39030e;
        }
    }

    @Override // com.umeng.analytics.pro.TBase
    public TBase<Response, EnumC13266e> deepCopy() {
        return new Response(this);
    }

    @Override // com.umeng.analytics.pro.TBase
    public EnumC13266e fieldForId(int i) {
        return EnumC13266e.m13662a(i);
    }

    public Response(int i) {
        this();
        this.resp_code = i;
        setResp_codeIsSet(true);
    }

    public Response(Response response) {
        this.__isset_bitfield = (byte) 0;
        this.optionals = new EnumC13266e[]{EnumC13266e.MSG, EnumC13266e.IMPRINT};
        this.__isset_bitfield = response.__isset_bitfield;
        this.resp_code = response.resp_code;
        if (response.isSetMsg()) {
            this.msg = response.msg;
        }
        if (response.isSetImprint()) {
            this.imprint = new Imprint(response.imprint);
        }
    }
}
