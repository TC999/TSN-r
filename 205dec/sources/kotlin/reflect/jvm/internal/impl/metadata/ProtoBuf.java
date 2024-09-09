package kotlin.reflect.jvm.internal.impl.metadata;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.d;
import kotlin.reflect.jvm.internal.impl.protobuf.h;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class ProtoBuf {

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class Annotation extends GeneratedMessageLite implements c {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<Annotation> PARSER = new a();
        private static final Annotation defaultInstance;
        private List<Argument> argument_;
        private int bitField0_;
        private int id_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class Argument extends GeneratedMessageLite implements kotlin.reflect.jvm.internal.impl.metadata.b {
            public static kotlin.reflect.jvm.internal.impl.protobuf.p<Argument> PARSER = new a();
            private static final Argument defaultInstance;
            private int bitField0_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private int nameId_;
            private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;
            private Value value_;

            /* loaded from: E:\TSN-r\205dec\7343912.dex */
            public static final class Value extends GeneratedMessageLite implements kotlin.reflect.jvm.internal.impl.metadata.a {
                public static kotlin.reflect.jvm.internal.impl.protobuf.p<Value> PARSER = new a();
                private static final Value defaultInstance;
                private Annotation annotation_;
                private int arrayDimensionCount_;
                private List<Value> arrayElement_;
                private int bitField0_;
                private int classId_;
                private double doubleValue_;
                private int enumValueId_;
                private int flags_;
                private float floatValue_;
                private long intValue_;
                private byte memoizedIsInitialized;
                private int memoizedSerializedSize;
                private int stringValue_;
                private Type type_;
                private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

                /* loaded from: E:\TSN-r\205dec\7343912.dex */
                public enum Type implements h.a {
                    BYTE(0, 0),
                    CHAR(1, 1),
                    SHORT(2, 2),
                    INT(3, 3),
                    LONG(4, 4),
                    FLOAT(5, 5),
                    DOUBLE(6, 6),
                    BOOLEAN(7, 7),
                    STRING(8, 8),
                    CLASS(9, 9),
                    ENUM(10, 10),
                    ANNOTATION(11, 11),
                    ARRAY(12, 12);
                    
                    private static h.b<Type> internalValueMap = new a();
                    private final int value;

                    /* loaded from: E:\TSN-r\205dec\7343912.dex */
                    static class a implements h.b<Type> {
                        a() {
                        }

                        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
                        /* renamed from: b */
                        public Type a(int i4) {
                            return Type.valueOf(i4);
                        }
                    }

                    Type(int i4, int i5) {
                        this.value = i5;
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.a
                    public final int getNumber() {
                        return this.value;
                    }

                    public static Type valueOf(int i4) {
                        switch (i4) {
                            case 0:
                                return BYTE;
                            case 1:
                                return CHAR;
                            case 2:
                                return SHORT;
                            case 3:
                                return INT;
                            case 4:
                                return LONG;
                            case 5:
                                return FLOAT;
                            case 6:
                                return DOUBLE;
                            case 7:
                                return BOOLEAN;
                            case 8:
                                return STRING;
                            case 9:
                                return CLASS;
                            case 10:
                                return ENUM;
                            case 11:
                                return ANNOTATION;
                            case 12:
                                return ARRAY;
                            default:
                                return null;
                        }
                    }
                }

                /* loaded from: E:\TSN-r\205dec\7343912.dex */
                static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<Value> {
                    a() {
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
                    /* renamed from: m */
                    public Value c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                        return new Value(eVar, fVar);
                    }
                }

                /* loaded from: E:\TSN-r\205dec\7343912.dex */
                public static final class b extends GeneratedMessageLite.b<Value, b> implements kotlin.reflect.jvm.internal.impl.metadata.a {

                    /* renamed from: b  reason: collision with root package name */
                    private int f57285b;

                    /* renamed from: d  reason: collision with root package name */
                    private long f57287d;

                    /* renamed from: e  reason: collision with root package name */
                    private float f57288e;

                    /* renamed from: f  reason: collision with root package name */
                    private double f57289f;

                    /* renamed from: g  reason: collision with root package name */
                    private int f57290g;

                    /* renamed from: h  reason: collision with root package name */
                    private int f57291h;

                    /* renamed from: i  reason: collision with root package name */
                    private int f57292i;

                    /* renamed from: l  reason: collision with root package name */
                    private int f57295l;

                    /* renamed from: m  reason: collision with root package name */
                    private int f57296m;

                    /* renamed from: c  reason: collision with root package name */
                    private Type f57286c = Type.BYTE;

                    /* renamed from: j  reason: collision with root package name */
                    private Annotation f57293j = Annotation.getDefaultInstance();

                    /* renamed from: k  reason: collision with root package name */
                    private List<Value> f57294k = Collections.emptyList();

                    private b() {
                        u();
                    }

                    static /* synthetic */ b j() {
                        return n();
                    }

                    private static b n() {
                        return new b();
                    }

                    private void o() {
                        if ((this.f57285b & 256) != 256) {
                            this.f57294k = new ArrayList(this.f57294k);
                            this.f57285b |= 256;
                        }
                    }

                    private void u() {
                    }

                    public b A(double d4) {
                        this.f57285b |= 8;
                        this.f57289f = d4;
                        return this;
                    }

                    public b B(int i4) {
                        this.f57285b |= 64;
                        this.f57292i = i4;
                        return this;
                    }

                    public b C(int i4) {
                        this.f57285b |= 1024;
                        this.f57296m = i4;
                        return this;
                    }

                    public b D(float f4) {
                        this.f57285b |= 4;
                        this.f57288e = f4;
                        return this;
                    }

                    public b E(long j4) {
                        this.f57285b |= 2;
                        this.f57287d = j4;
                        return this;
                    }

                    public b F(int i4) {
                        this.f57285b |= 16;
                        this.f57290g = i4;
                        return this;
                    }

                    public b G(Type type) {
                        type.getClass();
                        this.f57285b |= 1;
                        this.f57286c = type;
                        return this;
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
                    public final boolean isInitialized() {
                        if (!t() || p().isInitialized()) {
                            for (int i4 = 0; i4 < r(); i4++) {
                                if (!q(i4).isInitialized()) {
                                    return false;
                                }
                            }
                            return true;
                        }
                        return false;
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
                    /* renamed from: k */
                    public Value build() {
                        Value l4 = l();
                        if (l4.isInitialized()) {
                            return l4;
                        }
                        throw a.AbstractC1158a.c(l4);
                    }

                    public Value l() {
                        Value value = new Value(this);
                        int i4 = this.f57285b;
                        int i5 = (i4 & 1) != 1 ? 0 : 1;
                        value.type_ = this.f57286c;
                        if ((i4 & 2) == 2) {
                            i5 |= 2;
                        }
                        value.intValue_ = this.f57287d;
                        if ((i4 & 4) == 4) {
                            i5 |= 4;
                        }
                        value.floatValue_ = this.f57288e;
                        if ((i4 & 8) == 8) {
                            i5 |= 8;
                        }
                        value.doubleValue_ = this.f57289f;
                        if ((i4 & 16) == 16) {
                            i5 |= 16;
                        }
                        value.stringValue_ = this.f57290g;
                        if ((i4 & 32) == 32) {
                            i5 |= 32;
                        }
                        value.classId_ = this.f57291h;
                        if ((i4 & 64) == 64) {
                            i5 |= 64;
                        }
                        value.enumValueId_ = this.f57292i;
                        if ((i4 & 128) == 128) {
                            i5 |= 128;
                        }
                        value.annotation_ = this.f57293j;
                        if ((this.f57285b & 256) == 256) {
                            this.f57294k = Collections.unmodifiableList(this.f57294k);
                            this.f57285b &= -257;
                        }
                        value.arrayElement_ = this.f57294k;
                        if ((i4 & 512) == 512) {
                            i5 |= 256;
                        }
                        value.arrayDimensionCount_ = this.f57295l;
                        if ((i4 & 1024) == 1024) {
                            i5 |= 512;
                        }
                        value.flags_ = this.f57296m;
                        value.bitField0_ = i5;
                        return value;
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
                    /* renamed from: m */
                    public b d() {
                        return n().h(l());
                    }

                    public Annotation p() {
                        return this.f57293j;
                    }

                    public Value q(int i4) {
                        return this.f57294k.get(i4);
                    }

                    public int r() {
                        return this.f57294k.size();
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, kotlin.reflect.jvm.internal.impl.protobuf.o
                    /* renamed from: s */
                    public Value getDefaultInstanceForType() {
                        return Value.getDefaultInstance();
                    }

                    public boolean t() {
                        return (this.f57285b & 128) == 128;
                    }

                    public b v(Annotation annotation) {
                        if ((this.f57285b & 128) == 128 && this.f57293j != Annotation.getDefaultInstance()) {
                            this.f57293j = Annotation.newBuilder(this.f57293j).h(annotation).l();
                        } else {
                            this.f57293j = annotation;
                        }
                        this.f57285b |= 128;
                        return this;
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
                    /* renamed from: w */
                    public b h(Value value) {
                        if (value == Value.getDefaultInstance()) {
                            return this;
                        }
                        if (value.hasType()) {
                            G(value.getType());
                        }
                        if (value.hasIntValue()) {
                            E(value.getIntValue());
                        }
                        if (value.hasFloatValue()) {
                            D(value.getFloatValue());
                        }
                        if (value.hasDoubleValue()) {
                            A(value.getDoubleValue());
                        }
                        if (value.hasStringValue()) {
                            F(value.getStringValue());
                        }
                        if (value.hasClassId()) {
                            z(value.getClassId());
                        }
                        if (value.hasEnumValueId()) {
                            B(value.getEnumValueId());
                        }
                        if (value.hasAnnotation()) {
                            v(value.getAnnotation());
                        }
                        if (!value.arrayElement_.isEmpty()) {
                            if (this.f57294k.isEmpty()) {
                                this.f57294k = value.arrayElement_;
                                this.f57285b &= -257;
                            } else {
                                o();
                                this.f57294k.addAll(value.arrayElement_);
                            }
                        }
                        if (value.hasArrayDimensionCount()) {
                            y(value.getArrayDimensionCount());
                        }
                        if (value.hasFlags()) {
                            C(value.getFlags());
                        }
                        i(f().c(value.unknownFields));
                        return this;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC1158a, kotlin.reflect.jvm.internal.impl.protobuf.n.a
                    /* renamed from: x */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct code enable 'Show inconsistent code' option in preferences
                    */
                    public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.b g(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                        /*
                            r2 = this;
                            r0 = 0
                            kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument$Value> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                            java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument$Value r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                            if (r3 == 0) goto Le
                            r2.h(r3)
                        Le:
                            return r2
                        Lf:
                            r3 = move-exception
                            goto L1b
                        L11:
                            r3 = move-exception
                            kotlin.reflect.jvm.internal.impl.protobuf.n r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> Lf
                            kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument$Value r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value) r4     // Catch: java.lang.Throwable -> Lf
                            throw r3     // Catch: java.lang.Throwable -> L19
                        L19:
                            r3 = move-exception
                            r0 = r4
                        L1b:
                            if (r0 == 0) goto L20
                            r2.h(r0)
                        L20:
                            throw r3
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.Value.b.g(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument$Value$b");
                    }

                    public b y(int i4) {
                        this.f57285b |= 512;
                        this.f57295l = i4;
                        return this;
                    }

                    public b z(int i4) {
                        this.f57285b |= 32;
                        this.f57291h = i4;
                        return this;
                    }
                }

                static {
                    Value value = new Value(true);
                    defaultInstance = value;
                    value.initFields();
                }

                public static Value getDefaultInstance() {
                    return defaultInstance;
                }

                private void initFields() {
                    this.type_ = Type.BYTE;
                    this.intValue_ = 0L;
                    this.floatValue_ = 0.0f;
                    this.doubleValue_ = 0.0d;
                    this.stringValue_ = 0;
                    this.classId_ = 0;
                    this.enumValueId_ = 0;
                    this.annotation_ = Annotation.getDefaultInstance();
                    this.arrayElement_ = Collections.emptyList();
                    this.arrayDimensionCount_ = 0;
                    this.flags_ = 0;
                }

                public static b newBuilder() {
                    return b.j();
                }

                public Annotation getAnnotation() {
                    return this.annotation_;
                }

                public int getArrayDimensionCount() {
                    return this.arrayDimensionCount_;
                }

                public Value getArrayElement(int i4) {
                    return this.arrayElement_.get(i4);
                }

                public int getArrayElementCount() {
                    return this.arrayElement_.size();
                }

                public List<Value> getArrayElementList() {
                    return this.arrayElement_;
                }

                public int getClassId() {
                    return this.classId_;
                }

                public double getDoubleValue() {
                    return this.doubleValue_;
                }

                public int getEnumValueId() {
                    return this.enumValueId_;
                }

                public int getFlags() {
                    return this.flags_;
                }

                public float getFloatValue() {
                    return this.floatValue_;
                }

                public long getIntValue() {
                    return this.intValue_;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
                public kotlin.reflect.jvm.internal.impl.protobuf.p<Value> getParserForType() {
                    return PARSER;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
                public int getSerializedSize() {
                    int i4 = this.memoizedSerializedSize;
                    if (i4 != -1) {
                        return i4;
                    }
                    int h4 = (this.bitField0_ & 1) == 1 ? CodedOutputStream.h(1, this.type_.getNumber()) + 0 : 0;
                    if ((this.bitField0_ & 2) == 2) {
                        h4 += CodedOutputStream.A(2, this.intValue_);
                    }
                    if ((this.bitField0_ & 4) == 4) {
                        h4 += CodedOutputStream.l(3, this.floatValue_);
                    }
                    if ((this.bitField0_ & 8) == 8) {
                        h4 += CodedOutputStream.f(4, this.doubleValue_);
                    }
                    if ((this.bitField0_ & 16) == 16) {
                        h4 += CodedOutputStream.o(5, this.stringValue_);
                    }
                    if ((this.bitField0_ & 32) == 32) {
                        h4 += CodedOutputStream.o(6, this.classId_);
                    }
                    if ((this.bitField0_ & 64) == 64) {
                        h4 += CodedOutputStream.o(7, this.enumValueId_);
                    }
                    if ((this.bitField0_ & 128) == 128) {
                        h4 += CodedOutputStream.s(8, this.annotation_);
                    }
                    for (int i5 = 0; i5 < this.arrayElement_.size(); i5++) {
                        h4 += CodedOutputStream.s(9, this.arrayElement_.get(i5));
                    }
                    if ((this.bitField0_ & 512) == 512) {
                        h4 += CodedOutputStream.o(10, this.flags_);
                    }
                    if ((this.bitField0_ & 256) == 256) {
                        h4 += CodedOutputStream.o(11, this.arrayDimensionCount_);
                    }
                    int size = h4 + this.unknownFields.size();
                    this.memoizedSerializedSize = size;
                    return size;
                }

                public int getStringValue() {
                    return this.stringValue_;
                }

                public Type getType() {
                    return this.type_;
                }

                public boolean hasAnnotation() {
                    return (this.bitField0_ & 128) == 128;
                }

                public boolean hasArrayDimensionCount() {
                    return (this.bitField0_ & 256) == 256;
                }

                public boolean hasClassId() {
                    return (this.bitField0_ & 32) == 32;
                }

                public boolean hasDoubleValue() {
                    return (this.bitField0_ & 8) == 8;
                }

                public boolean hasEnumValueId() {
                    return (this.bitField0_ & 64) == 64;
                }

                public boolean hasFlags() {
                    return (this.bitField0_ & 512) == 512;
                }

                public boolean hasFloatValue() {
                    return (this.bitField0_ & 4) == 4;
                }

                public boolean hasIntValue() {
                    return (this.bitField0_ & 2) == 2;
                }

                public boolean hasStringValue() {
                    return (this.bitField0_ & 16) == 16;
                }

                public boolean hasType() {
                    return (this.bitField0_ & 1) == 1;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
                public final boolean isInitialized() {
                    byte b4 = this.memoizedIsInitialized;
                    if (b4 == 1) {
                        return true;
                    }
                    if (b4 == 0) {
                        return false;
                    }
                    if (hasAnnotation() && !getAnnotation().isInitialized()) {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                    for (int i4 = 0; i4 < getArrayElementCount(); i4++) {
                        if (!getArrayElement(i4).isInitialized()) {
                            this.memoizedIsInitialized = (byte) 0;
                            return false;
                        }
                    }
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
                public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                    getSerializedSize();
                    if ((this.bitField0_ & 1) == 1) {
                        codedOutputStream.S(1, this.type_.getNumber());
                    }
                    if ((this.bitField0_ & 2) == 2) {
                        codedOutputStream.t0(2, this.intValue_);
                    }
                    if ((this.bitField0_ & 4) == 4) {
                        codedOutputStream.W(3, this.floatValue_);
                    }
                    if ((this.bitField0_ & 8) == 8) {
                        codedOutputStream.Q(4, this.doubleValue_);
                    }
                    if ((this.bitField0_ & 16) == 16) {
                        codedOutputStream.a0(5, this.stringValue_);
                    }
                    if ((this.bitField0_ & 32) == 32) {
                        codedOutputStream.a0(6, this.classId_);
                    }
                    if ((this.bitField0_ & 64) == 64) {
                        codedOutputStream.a0(7, this.enumValueId_);
                    }
                    if ((this.bitField0_ & 128) == 128) {
                        codedOutputStream.d0(8, this.annotation_);
                    }
                    for (int i4 = 0; i4 < this.arrayElement_.size(); i4++) {
                        codedOutputStream.d0(9, this.arrayElement_.get(i4));
                    }
                    if ((this.bitField0_ & 512) == 512) {
                        codedOutputStream.a0(10, this.flags_);
                    }
                    if ((this.bitField0_ & 256) == 256) {
                        codedOutputStream.a0(11, this.arrayDimensionCount_);
                    }
                    codedOutputStream.i0(this.unknownFields);
                }

                public static b newBuilder(Value value) {
                    return newBuilder().h(value);
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
                public Value getDefaultInstanceForType() {
                    return defaultInstance;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
                public b newBuilderForType() {
                    return newBuilder();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
                public b toBuilder() {
                    return newBuilder(this);
                }

                private Value(GeneratedMessageLite.b bVar) {
                    super(bVar);
                    this.memoizedIsInitialized = (byte) -1;
                    this.memoizedSerializedSize = -1;
                    this.unknownFields = bVar.f();
                }

                private Value(boolean z3) {
                    this.memoizedIsInitialized = (byte) -1;
                    this.memoizedSerializedSize = -1;
                    this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f57629a;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r5v0 */
                /* JADX WARN: Type inference failed for: r5v1 */
                /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
                private Value(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                    this.memoizedIsInitialized = (byte) -1;
                    this.memoizedSerializedSize = -1;
                    initFields();
                    d.b u3 = kotlin.reflect.jvm.internal.impl.protobuf.d.u();
                    CodedOutputStream J = CodedOutputStream.J(u3, 1);
                    boolean z3 = false;
                    boolean z4 = false;
                    while (true) {
                        ?? r5 = 256;
                        if (!z3) {
                            try {
                                try {
                                    int K = eVar.K();
                                    switch (K) {
                                        case 0:
                                            break;
                                        case 8:
                                            int n4 = eVar.n();
                                            Type valueOf = Type.valueOf(n4);
                                            if (valueOf == null) {
                                                J.o0(K);
                                                J.o0(n4);
                                            } else {
                                                this.bitField0_ |= 1;
                                                this.type_ = valueOf;
                                                continue;
                                            }
                                        case 16:
                                            this.bitField0_ |= 2;
                                            this.intValue_ = eVar.H();
                                            continue;
                                        case 29:
                                            this.bitField0_ |= 4;
                                            this.floatValue_ = eVar.q();
                                            continue;
                                        case 33:
                                            this.bitField0_ |= 8;
                                            this.doubleValue_ = eVar.m();
                                            continue;
                                        case 40:
                                            this.bitField0_ |= 16;
                                            this.stringValue_ = eVar.s();
                                            continue;
                                        case 48:
                                            this.bitField0_ |= 32;
                                            this.classId_ = eVar.s();
                                            continue;
                                        case 56:
                                            this.bitField0_ |= 64;
                                            this.enumValueId_ = eVar.s();
                                            continue;
                                        case 66:
                                            b builder = (this.bitField0_ & 128) == 128 ? this.annotation_.toBuilder() : null;
                                            Annotation annotation = (Annotation) eVar.u(Annotation.PARSER, fVar);
                                            this.annotation_ = annotation;
                                            if (builder != null) {
                                                builder.h(annotation);
                                                this.annotation_ = builder.l();
                                            }
                                            this.bitField0_ |= 128;
                                            continue;
                                        case 74:
                                            if (!(z4 & true)) {
                                                this.arrayElement_ = new ArrayList();
                                                z4 |= true;
                                            }
                                            this.arrayElement_.add(eVar.u(PARSER, fVar));
                                            continue;
                                        case 80:
                                            this.bitField0_ |= 512;
                                            this.flags_ = eVar.s();
                                            continue;
                                        case 88:
                                            this.bitField0_ |= 256;
                                            this.arrayDimensionCount_ = eVar.s();
                                            continue;
                                        default:
                                            r5 = parseUnknownField(eVar, J, fVar, K);
                                            if (r5 == 0) {
                                                break;
                                            } else {
                                                continue;
                                            }
                                    }
                                    z3 = true;
                                } catch (InvalidProtocolBufferException e4) {
                                    throw e4.setUnfinishedMessage(this);
                                } catch (IOException e5) {
                                    throw new InvalidProtocolBufferException(e5.getMessage()).setUnfinishedMessage(this);
                                }
                            } catch (Throwable th) {
                                if ((z4 & true) == r5) {
                                    this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
                                }
                                try {
                                    J.I();
                                } catch (IOException unused) {
                                } catch (Throwable th2) {
                                    this.unknownFields = u3.g();
                                    throw th2;
                                }
                                this.unknownFields = u3.g();
                                makeExtensionsImmutable();
                                throw th;
                            }
                        } else {
                            if (z4 & true) {
                                this.arrayElement_ = Collections.unmodifiableList(this.arrayElement_);
                            }
                            try {
                                J.I();
                            } catch (IOException unused2) {
                            } catch (Throwable th3) {
                                this.unknownFields = u3.g();
                                throw th3;
                            }
                            this.unknownFields = u3.g();
                            makeExtensionsImmutable();
                            return;
                        }
                    }
                }
            }

            /* loaded from: E:\TSN-r\205dec\7343912.dex */
            static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<Argument> {
                a() {
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
                /* renamed from: m */
                public Argument c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                    return new Argument(eVar, fVar);
                }
            }

            /* loaded from: E:\TSN-r\205dec\7343912.dex */
            public static final class b extends GeneratedMessageLite.b<Argument, b> implements kotlin.reflect.jvm.internal.impl.metadata.b {

                /* renamed from: b  reason: collision with root package name */
                private int f57297b;

                /* renamed from: c  reason: collision with root package name */
                private int f57298c;

                /* renamed from: d  reason: collision with root package name */
                private Value f57299d = Value.getDefaultInstance();

                private b() {
                    s();
                }

                static /* synthetic */ b j() {
                    return n();
                }

                private static b n() {
                    return new b();
                }

                private void s() {
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
                public final boolean isInitialized() {
                    return q() && r() && p().isInitialized();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
                /* renamed from: k */
                public Argument build() {
                    Argument l4 = l();
                    if (l4.isInitialized()) {
                        return l4;
                    }
                    throw a.AbstractC1158a.c(l4);
                }

                public Argument l() {
                    Argument argument = new Argument(this);
                    int i4 = this.f57297b;
                    int i5 = (i4 & 1) != 1 ? 0 : 1;
                    argument.nameId_ = this.f57298c;
                    if ((i4 & 2) == 2) {
                        i5 |= 2;
                    }
                    argument.value_ = this.f57299d;
                    argument.bitField0_ = i5;
                    return argument;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
                /* renamed from: m */
                public b d() {
                    return n().h(l());
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, kotlin.reflect.jvm.internal.impl.protobuf.o
                /* renamed from: o */
                public Argument getDefaultInstanceForType() {
                    return Argument.getDefaultInstance();
                }

                public Value p() {
                    return this.f57299d;
                }

                public boolean q() {
                    return (this.f57297b & 1) == 1;
                }

                public boolean r() {
                    return (this.f57297b & 2) == 2;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
                /* renamed from: t */
                public b h(Argument argument) {
                    if (argument == Argument.getDefaultInstance()) {
                        return this;
                    }
                    if (argument.hasNameId()) {
                        w(argument.getNameId());
                    }
                    if (argument.hasValue()) {
                        v(argument.getValue());
                    }
                    i(f().c(argument.unknownFields));
                    return this;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
                @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC1158a, kotlin.reflect.jvm.internal.impl.protobuf.n.a
                /* renamed from: u */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.b g(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                    /*
                        r2 = this;
                        r0 = 0
                        kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                        java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                        if (r3 == 0) goto Le
                        r2.h(r3)
                    Le:
                        return r2
                    Lf:
                        r3 = move-exception
                        goto L1b
                    L11:
                        r3 = move-exception
                        kotlin.reflect.jvm.internal.impl.protobuf.n r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> Lf
                        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument) r4     // Catch: java.lang.Throwable -> Lf
                        throw r3     // Catch: java.lang.Throwable -> L19
                    L19:
                        r3 = move-exception
                        r0 = r4
                    L1b:
                        if (r0 == 0) goto L20
                        r2.h(r0)
                    L20:
                        throw r3
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.Argument.b.g(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$Argument$b");
                }

                public b v(Value value) {
                    if ((this.f57297b & 2) == 2 && this.f57299d != Value.getDefaultInstance()) {
                        this.f57299d = Value.newBuilder(this.f57299d).h(value).l();
                    } else {
                        this.f57299d = value;
                    }
                    this.f57297b |= 2;
                    return this;
                }

                public b w(int i4) {
                    this.f57297b |= 1;
                    this.f57298c = i4;
                    return this;
                }
            }

            static {
                Argument argument = new Argument(true);
                defaultInstance = argument;
                argument.initFields();
            }

            public static Argument getDefaultInstance() {
                return defaultInstance;
            }

            private void initFields() {
                this.nameId_ = 0;
                this.value_ = Value.getDefaultInstance();
            }

            public static b newBuilder() {
                return b.j();
            }

            public int getNameId() {
                return this.nameId_;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
            public kotlin.reflect.jvm.internal.impl.protobuf.p<Argument> getParserForType() {
                return PARSER;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
            public int getSerializedSize() {
                int i4 = this.memoizedSerializedSize;
                if (i4 != -1) {
                    return i4;
                }
                int o4 = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.o(1, this.nameId_) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    o4 += CodedOutputStream.s(2, this.value_);
                }
                int size = o4 + this.unknownFields.size();
                this.memoizedSerializedSize = size;
                return size;
            }

            public Value getValue() {
                return this.value_;
            }

            public boolean hasNameId() {
                return (this.bitField0_ & 1) == 1;
            }

            public boolean hasValue() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public final boolean isInitialized() {
                byte b4 = this.memoizedIsInitialized;
                if (b4 == 1) {
                    return true;
                }
                if (b4 == 0) {
                    return false;
                }
                if (!hasNameId()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                } else if (!hasValue()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                } else if (!getValue().isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                } else {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                }
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                getSerializedSize();
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.a0(1, this.nameId_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.d0(2, this.value_);
                }
                codedOutputStream.i0(this.unknownFields);
            }

            public static b newBuilder(Argument argument) {
                return newBuilder().h(argument);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public Argument getDefaultInstanceForType() {
                return defaultInstance;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
            public b newBuilderForType() {
                return newBuilder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
            public b toBuilder() {
                return newBuilder(this);
            }

            private Argument(GeneratedMessageLite.b bVar) {
                super(bVar);
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = bVar.f();
            }

            private Argument(boolean z3) {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f57629a;
            }

            private Argument(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                initFields();
                d.b u3 = kotlin.reflect.jvm.internal.impl.protobuf.d.u();
                CodedOutputStream J = CodedOutputStream.J(u3, 1);
                boolean z3 = false;
                while (!z3) {
                    try {
                        try {
                            try {
                                int K = eVar.K();
                                if (K != 0) {
                                    if (K == 8) {
                                        this.bitField0_ |= 1;
                                        this.nameId_ = eVar.s();
                                    } else if (K != 18) {
                                        if (!parseUnknownField(eVar, J, fVar, K)) {
                                        }
                                    } else {
                                        Value.b builder = (this.bitField0_ & 2) == 2 ? this.value_.toBuilder() : null;
                                        Value value = (Value) eVar.u(Value.PARSER, fVar);
                                        this.value_ = value;
                                        if (builder != null) {
                                            builder.h(value);
                                            this.value_ = builder.l();
                                        }
                                        this.bitField0_ |= 2;
                                    }
                                }
                                z3 = true;
                            } catch (IOException e4) {
                                throw new InvalidProtocolBufferException(e4.getMessage()).setUnfinishedMessage(this);
                            }
                        } catch (InvalidProtocolBufferException e5) {
                            throw e5.setUnfinishedMessage(this);
                        }
                    } catch (Throwable th) {
                        try {
                            J.I();
                        } catch (IOException unused) {
                        } catch (Throwable th2) {
                            this.unknownFields = u3.g();
                            throw th2;
                        }
                        this.unknownFields = u3.g();
                        makeExtensionsImmutable();
                        throw th;
                    }
                }
                try {
                    J.I();
                } catch (IOException unused2) {
                } catch (Throwable th3) {
                    this.unknownFields = u3.g();
                    throw th3;
                }
                this.unknownFields = u3.g();
                makeExtensionsImmutable();
            }
        }

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<Annotation> {
            a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
            /* renamed from: m */
            public Annotation c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                return new Annotation(eVar, fVar);
            }
        }

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class b extends GeneratedMessageLite.b<Annotation, b> implements c {

            /* renamed from: b  reason: collision with root package name */
            private int f57300b;

            /* renamed from: c  reason: collision with root package name */
            private int f57301c;

            /* renamed from: d  reason: collision with root package name */
            private List<Argument> f57302d = Collections.emptyList();

            private b() {
                t();
            }

            static /* synthetic */ b j() {
                return n();
            }

            private static b n() {
                return new b();
            }

            private void o() {
                if ((this.f57300b & 2) != 2) {
                    this.f57302d = new ArrayList(this.f57302d);
                    this.f57300b |= 2;
                }
            }

            private void t() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public final boolean isInitialized() {
                if (s()) {
                    for (int i4 = 0; i4 < q(); i4++) {
                        if (!p(i4).isInitialized()) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: k */
            public Annotation build() {
                Annotation l4 = l();
                if (l4.isInitialized()) {
                    return l4;
                }
                throw a.AbstractC1158a.c(l4);
            }

            public Annotation l() {
                Annotation annotation = new Annotation(this);
                int i4 = (this.f57300b & 1) != 1 ? 0 : 1;
                annotation.id_ = this.f57301c;
                if ((this.f57300b & 2) == 2) {
                    this.f57302d = Collections.unmodifiableList(this.f57302d);
                    this.f57300b &= -3;
                }
                annotation.argument_ = this.f57302d;
                annotation.bitField0_ = i4;
                return annotation;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: m */
            public b d() {
                return n().h(l());
            }

            public Argument p(int i4) {
                return this.f57302d.get(i4);
            }

            public int q() {
                return this.f57302d.size();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, kotlin.reflect.jvm.internal.impl.protobuf.o
            /* renamed from: r */
            public Annotation getDefaultInstanceForType() {
                return Annotation.getDefaultInstance();
            }

            public boolean s() {
                return (this.f57300b & 1) == 1;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: u */
            public b h(Annotation annotation) {
                if (annotation == Annotation.getDefaultInstance()) {
                    return this;
                }
                if (annotation.hasId()) {
                    w(annotation.getId());
                }
                if (!annotation.argument_.isEmpty()) {
                    if (this.f57302d.isEmpty()) {
                        this.f57302d = annotation.argument_;
                        this.f57300b &= -3;
                    } else {
                        o();
                        this.f57302d.addAll(annotation.argument_);
                    }
                }
                i(f().c(annotation.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC1158a, kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: v */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.b g(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.h(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1b
                L11:
                    r3 = move-exception
                    kotlin.reflect.jvm.internal.impl.protobuf.n r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> Lf
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation) r4     // Catch: java.lang.Throwable -> Lf
                    throw r3     // Catch: java.lang.Throwable -> L19
                L19:
                    r3 = move-exception
                    r0 = r4
                L1b:
                    if (r0 == 0) goto L20
                    r2.h(r0)
                L20:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Annotation.b.g(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation$b");
            }

            public b w(int i4) {
                this.f57300b |= 1;
                this.f57301c = i4;
                return this;
            }
        }

        static {
            Annotation annotation = new Annotation(true);
            defaultInstance = annotation;
            annotation.initFields();
        }

        public static Annotation getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.id_ = 0;
            this.argument_ = Collections.emptyList();
        }

        public static b newBuilder() {
            return b.j();
        }

        public Argument getArgument(int i4) {
            return this.argument_.get(i4);
        }

        public int getArgumentCount() {
            return this.argument_.size();
        }

        public List<Argument> getArgumentList() {
            return this.argument_;
        }

        public int getId() {
            return this.id_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
        public kotlin.reflect.jvm.internal.impl.protobuf.p<Annotation> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public int getSerializedSize() {
            int i4 = this.memoizedSerializedSize;
            if (i4 != -1) {
                return i4;
            }
            int o4 = (this.bitField0_ & 1) == 1 ? CodedOutputStream.o(1, this.id_) + 0 : 0;
            for (int i5 = 0; i5 < this.argument_.size(); i5++) {
                o4 += CodedOutputStream.s(2, this.argument_.get(i5));
            }
            int size = o4 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public boolean hasId() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public final boolean isInitialized() {
            byte b4 = this.memoizedIsInitialized;
            if (b4 == 1) {
                return true;
            }
            if (b4 == 0) {
                return false;
            }
            if (!hasId()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i4 = 0; i4 < getArgumentCount(); i4++) {
                if (!getArgument(i4).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.a0(1, this.id_);
            }
            for (int i4 = 0; i4 < this.argument_.size(); i4++) {
                codedOutputStream.d0(2, this.argument_.get(i4));
            }
            codedOutputStream.i0(this.unknownFields);
        }

        public static b newBuilder(Annotation annotation) {
            return newBuilder().h(annotation);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public Annotation getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b toBuilder() {
            return newBuilder(this);
        }

        private Annotation(GeneratedMessageLite.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.f();
        }

        private Annotation(boolean z3) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f57629a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Annotation(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            d.b u3 = kotlin.reflect.jvm.internal.impl.protobuf.d.u();
            CodedOutputStream J = CodedOutputStream.J(u3, 1);
            boolean z3 = false;
            boolean z4 = false;
            while (!z3) {
                try {
                    try {
                        int K = eVar.K();
                        if (K != 0) {
                            if (K == 8) {
                                this.bitField0_ |= 1;
                                this.id_ = eVar.s();
                            } else if (K != 18) {
                                if (!parseUnknownField(eVar, J, fVar, K)) {
                                }
                            } else {
                                if (!(z4 & true)) {
                                    this.argument_ = new ArrayList();
                                    z4 |= true;
                                }
                                this.argument_.add(eVar.u(Argument.PARSER, fVar));
                            }
                        }
                        z3 = true;
                    } catch (InvalidProtocolBufferException e4) {
                        throw e4.setUnfinishedMessage(this);
                    } catch (IOException e5) {
                        throw new InvalidProtocolBufferException(e5.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    if (z4 & true) {
                        this.argument_ = Collections.unmodifiableList(this.argument_);
                    }
                    try {
                        J.I();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.unknownFields = u3.g();
                        throw th2;
                    }
                    this.unknownFields = u3.g();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z4 & true) {
                this.argument_ = Collections.unmodifiableList(this.argument_);
            }
            try {
                J.I();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.unknownFields = u3.g();
                throw th3;
            }
            this.unknownFields = u3.g();
            makeExtensionsImmutable();
        }
    }

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class Class extends GeneratedMessageLite.ExtendableMessage<Class> implements d {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<Class> PARSER = new a();
        private static final Class defaultInstance;
        private int bitField0_;
        private int companionObjectName_;
        private List<Constructor> constructor_;
        private List<EnumEntry> enumEntry_;
        private int flags_;
        private int fqName_;
        private List<Function> function_;
        private int inlineClassUnderlyingPropertyName_;
        private int inlineClassUnderlyingTypeId_;
        private Type inlineClassUnderlyingType_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int nestedClassNameMemoizedSerializedSize;
        private List<Integer> nestedClassName_;
        private List<Property> property_;
        private int sealedSubclassFqNameMemoizedSerializedSize;
        private List<Integer> sealedSubclassFqName_;
        private int supertypeIdMemoizedSerializedSize;
        private List<Integer> supertypeId_;
        private List<Type> supertype_;
        private List<TypeAlias> typeAlias_;
        private List<TypeParameter> typeParameter_;
        private TypeTable typeTable_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;
        private VersionRequirementTable versionRequirementTable_;
        private List<Integer> versionRequirement_;

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public enum Kind implements h.a {
            CLASS(0, 0),
            INTERFACE(1, 1),
            ENUM_CLASS(2, 2),
            ENUM_ENTRY(3, 3),
            ANNOTATION_CLASS(4, 4),
            OBJECT(5, 5),
            COMPANION_OBJECT(6, 6);
            
            private static h.b<Kind> internalValueMap = new a();
            private final int value;

            /* loaded from: E:\TSN-r\205dec\7343912.dex */
            static class a implements h.b<Kind> {
                a() {
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
                /* renamed from: b */
                public Kind a(int i4) {
                    return Kind.valueOf(i4);
                }
            }

            Kind(int i4, int i5) {
                this.value = i5;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.a
            public final int getNumber() {
                return this.value;
            }

            public static Kind valueOf(int i4) {
                switch (i4) {
                    case 0:
                        return CLASS;
                    case 1:
                        return INTERFACE;
                    case 2:
                        return ENUM_CLASS;
                    case 3:
                        return ENUM_ENTRY;
                    case 4:
                        return ANNOTATION_CLASS;
                    case 5:
                        return OBJECT;
                    case 6:
                        return COMPANION_OBJECT;
                    default:
                        return null;
                }
            }
        }

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<Class> {
            a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
            /* renamed from: m */
            public Class c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                return new Class(eVar, fVar);
            }
        }

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class b extends GeneratedMessageLite.c<Class, b> implements d {

            /* renamed from: d  reason: collision with root package name */
            private int f57303d;

            /* renamed from: f  reason: collision with root package name */
            private int f57305f;

            /* renamed from: g  reason: collision with root package name */
            private int f57306g;

            /* renamed from: r  reason: collision with root package name */
            private int f57317r;

            /* renamed from: t  reason: collision with root package name */
            private int f57319t;

            /* renamed from: e  reason: collision with root package name */
            private int f57304e = 6;

            /* renamed from: h  reason: collision with root package name */
            private List<TypeParameter> f57307h = Collections.emptyList();

            /* renamed from: i  reason: collision with root package name */
            private List<Type> f57308i = Collections.emptyList();

            /* renamed from: j  reason: collision with root package name */
            private List<Integer> f57309j = Collections.emptyList();

            /* renamed from: k  reason: collision with root package name */
            private List<Integer> f57310k = Collections.emptyList();

            /* renamed from: l  reason: collision with root package name */
            private List<Constructor> f57311l = Collections.emptyList();

            /* renamed from: m  reason: collision with root package name */
            private List<Function> f57312m = Collections.emptyList();

            /* renamed from: n  reason: collision with root package name */
            private List<Property> f57313n = Collections.emptyList();

            /* renamed from: o  reason: collision with root package name */
            private List<TypeAlias> f57314o = Collections.emptyList();

            /* renamed from: p  reason: collision with root package name */
            private List<EnumEntry> f57315p = Collections.emptyList();

            /* renamed from: q  reason: collision with root package name */
            private List<Integer> f57316q = Collections.emptyList();

            /* renamed from: s  reason: collision with root package name */
            private Type f57318s = Type.getDefaultInstance();

            /* renamed from: u  reason: collision with root package name */
            private TypeTable f57320u = TypeTable.getDefaultInstance();

            /* renamed from: v  reason: collision with root package name */
            private List<Integer> f57321v = Collections.emptyList();

            /* renamed from: w  reason: collision with root package name */
            private VersionRequirementTable f57322w = VersionRequirementTable.getDefaultInstance();

            private b() {
                a0();
            }

            private void A() {
                if ((this.f57303d & 4096) != 4096) {
                    this.f57316q = new ArrayList(this.f57316q);
                    this.f57303d |= 4096;
                }
            }

            private void B() {
                if ((this.f57303d & 32) != 32) {
                    this.f57309j = new ArrayList(this.f57309j);
                    this.f57303d |= 32;
                }
            }

            private void C() {
                if ((this.f57303d & 16) != 16) {
                    this.f57308i = new ArrayList(this.f57308i);
                    this.f57303d |= 16;
                }
            }

            private void D() {
                if ((this.f57303d & 1024) != 1024) {
                    this.f57314o = new ArrayList(this.f57314o);
                    this.f57303d |= 1024;
                }
            }

            private void E() {
                if ((this.f57303d & 8) != 8) {
                    this.f57307h = new ArrayList(this.f57307h);
                    this.f57303d |= 8;
                }
            }

            private void F() {
                if ((this.f57303d & 131072) != 131072) {
                    this.f57321v = new ArrayList(this.f57321v);
                    this.f57303d |= 131072;
                }
            }

            private void a0() {
            }

            static /* synthetic */ b p() {
                return t();
            }

            private static b t() {
                return new b();
            }

            private void u() {
                if ((this.f57303d & 128) != 128) {
                    this.f57311l = new ArrayList(this.f57311l);
                    this.f57303d |= 128;
                }
            }

            private void v() {
                if ((this.f57303d & 2048) != 2048) {
                    this.f57315p = new ArrayList(this.f57315p);
                    this.f57303d |= 2048;
                }
            }

            private void x() {
                if ((this.f57303d & 256) != 256) {
                    this.f57312m = new ArrayList(this.f57312m);
                    this.f57303d |= 256;
                }
            }

            private void y() {
                if ((this.f57303d & 64) != 64) {
                    this.f57310k = new ArrayList(this.f57310k);
                    this.f57303d |= 64;
                }
            }

            private void z() {
                if ((this.f57303d & 512) != 512) {
                    this.f57313n = new ArrayList(this.f57313n);
                    this.f57303d |= 512;
                }
            }

            public Constructor G(int i4) {
                return this.f57311l.get(i4);
            }

            public int H() {
                return this.f57311l.size();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, kotlin.reflect.jvm.internal.impl.protobuf.o
            /* renamed from: I */
            public Class getDefaultInstanceForType() {
                return Class.getDefaultInstance();
            }

            public EnumEntry J(int i4) {
                return this.f57315p.get(i4);
            }

            public int K() {
                return this.f57315p.size();
            }

            public Function L(int i4) {
                return this.f57312m.get(i4);
            }

            public int M() {
                return this.f57312m.size();
            }

            public Type N() {
                return this.f57318s;
            }

            public Property O(int i4) {
                return this.f57313n.get(i4);
            }

            public int P() {
                return this.f57313n.size();
            }

            public Type Q(int i4) {
                return this.f57308i.get(i4);
            }

            public int R() {
                return this.f57308i.size();
            }

            public TypeAlias S(int i4) {
                return this.f57314o.get(i4);
            }

            public int T() {
                return this.f57314o.size();
            }

            public TypeParameter U(int i4) {
                return this.f57307h.get(i4);
            }

            public int V() {
                return this.f57307h.size();
            }

            public TypeTable W() {
                return this.f57320u;
            }

            public boolean X() {
                return (this.f57303d & 2) == 2;
            }

            public boolean Y() {
                return (this.f57303d & 16384) == 16384;
            }

            public boolean Z() {
                return (this.f57303d & 65536) == 65536;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: b0 */
            public b h(Class r3) {
                if (r3 == Class.getDefaultInstance()) {
                    return this;
                }
                if (r3.hasFlags()) {
                    h0(r3.getFlags());
                }
                if (r3.hasFqName()) {
                    i0(r3.getFqName());
                }
                if (r3.hasCompanionObjectName()) {
                    g0(r3.getCompanionObjectName());
                }
                if (!r3.typeParameter_.isEmpty()) {
                    if (this.f57307h.isEmpty()) {
                        this.f57307h = r3.typeParameter_;
                        this.f57303d &= -9;
                    } else {
                        E();
                        this.f57307h.addAll(r3.typeParameter_);
                    }
                }
                if (!r3.supertype_.isEmpty()) {
                    if (this.f57308i.isEmpty()) {
                        this.f57308i = r3.supertype_;
                        this.f57303d &= -17;
                    } else {
                        C();
                        this.f57308i.addAll(r3.supertype_);
                    }
                }
                if (!r3.supertypeId_.isEmpty()) {
                    if (this.f57309j.isEmpty()) {
                        this.f57309j = r3.supertypeId_;
                        this.f57303d &= -33;
                    } else {
                        B();
                        this.f57309j.addAll(r3.supertypeId_);
                    }
                }
                if (!r3.nestedClassName_.isEmpty()) {
                    if (this.f57310k.isEmpty()) {
                        this.f57310k = r3.nestedClassName_;
                        this.f57303d &= -65;
                    } else {
                        y();
                        this.f57310k.addAll(r3.nestedClassName_);
                    }
                }
                if (!r3.constructor_.isEmpty()) {
                    if (this.f57311l.isEmpty()) {
                        this.f57311l = r3.constructor_;
                        this.f57303d &= -129;
                    } else {
                        u();
                        this.f57311l.addAll(r3.constructor_);
                    }
                }
                if (!r3.function_.isEmpty()) {
                    if (this.f57312m.isEmpty()) {
                        this.f57312m = r3.function_;
                        this.f57303d &= -257;
                    } else {
                        x();
                        this.f57312m.addAll(r3.function_);
                    }
                }
                if (!r3.property_.isEmpty()) {
                    if (this.f57313n.isEmpty()) {
                        this.f57313n = r3.property_;
                        this.f57303d &= -513;
                    } else {
                        z();
                        this.f57313n.addAll(r3.property_);
                    }
                }
                if (!r3.typeAlias_.isEmpty()) {
                    if (this.f57314o.isEmpty()) {
                        this.f57314o = r3.typeAlias_;
                        this.f57303d &= -1025;
                    } else {
                        D();
                        this.f57314o.addAll(r3.typeAlias_);
                    }
                }
                if (!r3.enumEntry_.isEmpty()) {
                    if (this.f57315p.isEmpty()) {
                        this.f57315p = r3.enumEntry_;
                        this.f57303d &= -2049;
                    } else {
                        v();
                        this.f57315p.addAll(r3.enumEntry_);
                    }
                }
                if (!r3.sealedSubclassFqName_.isEmpty()) {
                    if (this.f57316q.isEmpty()) {
                        this.f57316q = r3.sealedSubclassFqName_;
                        this.f57303d &= -4097;
                    } else {
                        A();
                        this.f57316q.addAll(r3.sealedSubclassFqName_);
                    }
                }
                if (r3.hasInlineClassUnderlyingPropertyName()) {
                    j0(r3.getInlineClassUnderlyingPropertyName());
                }
                if (r3.hasInlineClassUnderlyingType()) {
                    d0(r3.getInlineClassUnderlyingType());
                }
                if (r3.hasInlineClassUnderlyingTypeId()) {
                    k0(r3.getInlineClassUnderlyingTypeId());
                }
                if (r3.hasTypeTable()) {
                    e0(r3.getTypeTable());
                }
                if (!r3.versionRequirement_.isEmpty()) {
                    if (this.f57321v.isEmpty()) {
                        this.f57321v = r3.versionRequirement_;
                        this.f57303d &= -131073;
                    } else {
                        F();
                        this.f57321v.addAll(r3.versionRequirement_);
                    }
                }
                if (r3.hasVersionRequirementTable()) {
                    f0(r3.getVersionRequirementTable());
                }
                o(r3);
                i(f().c(r3.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC1158a, kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: c0 */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class.b g(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.h(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1b
                L11:
                    r3 = move-exception
                    kotlin.reflect.jvm.internal.impl.protobuf.n r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> Lf
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class) r4     // Catch: java.lang.Throwable -> Lf
                    throw r3     // Catch: java.lang.Throwable -> L19
                L19:
                    r3 = move-exception
                    r0 = r4
                L1b:
                    if (r0 == 0) goto L20
                    r2.h(r0)
                L20:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Class.b.g(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class$b");
            }

            public b d0(Type type) {
                if ((this.f57303d & 16384) == 16384 && this.f57318s != Type.getDefaultInstance()) {
                    this.f57318s = Type.newBuilder(this.f57318s).h(type).r();
                } else {
                    this.f57318s = type;
                }
                this.f57303d |= 16384;
                return this;
            }

            public b e0(TypeTable typeTable) {
                if ((this.f57303d & 65536) == 65536 && this.f57320u != TypeTable.getDefaultInstance()) {
                    this.f57320u = TypeTable.newBuilder(this.f57320u).h(typeTable).l();
                } else {
                    this.f57320u = typeTable;
                }
                this.f57303d |= 65536;
                return this;
            }

            public b f0(VersionRequirementTable versionRequirementTable) {
                if ((this.f57303d & 262144) == 262144 && this.f57322w != VersionRequirementTable.getDefaultInstance()) {
                    this.f57322w = VersionRequirementTable.newBuilder(this.f57322w).h(versionRequirementTable).l();
                } else {
                    this.f57322w = versionRequirementTable;
                }
                this.f57303d |= 262144;
                return this;
            }

            public b g0(int i4) {
                this.f57303d |= 4;
                this.f57306g = i4;
                return this;
            }

            public b h0(int i4) {
                this.f57303d |= 1;
                this.f57304e = i4;
                return this;
            }

            public b i0(int i4) {
                this.f57303d |= 2;
                this.f57305f = i4;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public final boolean isInitialized() {
                if (X()) {
                    for (int i4 = 0; i4 < V(); i4++) {
                        if (!U(i4).isInitialized()) {
                            return false;
                        }
                    }
                    for (int i5 = 0; i5 < R(); i5++) {
                        if (!Q(i5).isInitialized()) {
                            return false;
                        }
                    }
                    for (int i6 = 0; i6 < H(); i6++) {
                        if (!G(i6).isInitialized()) {
                            return false;
                        }
                    }
                    for (int i7 = 0; i7 < M(); i7++) {
                        if (!L(i7).isInitialized()) {
                            return false;
                        }
                    }
                    for (int i8 = 0; i8 < P(); i8++) {
                        if (!O(i8).isInitialized()) {
                            return false;
                        }
                    }
                    for (int i9 = 0; i9 < T(); i9++) {
                        if (!S(i9).isInitialized()) {
                            return false;
                        }
                    }
                    for (int i10 = 0; i10 < K(); i10++) {
                        if (!J(i10).isInitialized()) {
                            return false;
                        }
                    }
                    if (!Y() || N().isInitialized()) {
                        return (!Z() || W().isInitialized()) && n();
                    }
                    return false;
                }
                return false;
            }

            public b j0(int i4) {
                this.f57303d |= 8192;
                this.f57317r = i4;
                return this;
            }

            public b k0(int i4) {
                this.f57303d |= 32768;
                this.f57319t = i4;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: q */
            public Class build() {
                Class r3 = r();
                if (r3.isInitialized()) {
                    return r3;
                }
                throw a.AbstractC1158a.c(r3);
            }

            public Class r() {
                Class r02 = new Class(this);
                int i4 = this.f57303d;
                int i5 = (i4 & 1) != 1 ? 0 : 1;
                r02.flags_ = this.f57304e;
                if ((i4 & 2) == 2) {
                    i5 |= 2;
                }
                r02.fqName_ = this.f57305f;
                if ((i4 & 4) == 4) {
                    i5 |= 4;
                }
                r02.companionObjectName_ = this.f57306g;
                if ((this.f57303d & 8) == 8) {
                    this.f57307h = Collections.unmodifiableList(this.f57307h);
                    this.f57303d &= -9;
                }
                r02.typeParameter_ = this.f57307h;
                if ((this.f57303d & 16) == 16) {
                    this.f57308i = Collections.unmodifiableList(this.f57308i);
                    this.f57303d &= -17;
                }
                r02.supertype_ = this.f57308i;
                if ((this.f57303d & 32) == 32) {
                    this.f57309j = Collections.unmodifiableList(this.f57309j);
                    this.f57303d &= -33;
                }
                r02.supertypeId_ = this.f57309j;
                if ((this.f57303d & 64) == 64) {
                    this.f57310k = Collections.unmodifiableList(this.f57310k);
                    this.f57303d &= -65;
                }
                r02.nestedClassName_ = this.f57310k;
                if ((this.f57303d & 128) == 128) {
                    this.f57311l = Collections.unmodifiableList(this.f57311l);
                    this.f57303d &= -129;
                }
                r02.constructor_ = this.f57311l;
                if ((this.f57303d & 256) == 256) {
                    this.f57312m = Collections.unmodifiableList(this.f57312m);
                    this.f57303d &= -257;
                }
                r02.function_ = this.f57312m;
                if ((this.f57303d & 512) == 512) {
                    this.f57313n = Collections.unmodifiableList(this.f57313n);
                    this.f57303d &= -513;
                }
                r02.property_ = this.f57313n;
                if ((this.f57303d & 1024) == 1024) {
                    this.f57314o = Collections.unmodifiableList(this.f57314o);
                    this.f57303d &= -1025;
                }
                r02.typeAlias_ = this.f57314o;
                if ((this.f57303d & 2048) == 2048) {
                    this.f57315p = Collections.unmodifiableList(this.f57315p);
                    this.f57303d &= -2049;
                }
                r02.enumEntry_ = this.f57315p;
                if ((this.f57303d & 4096) == 4096) {
                    this.f57316q = Collections.unmodifiableList(this.f57316q);
                    this.f57303d &= -4097;
                }
                r02.sealedSubclassFqName_ = this.f57316q;
                if ((i4 & 8192) == 8192) {
                    i5 |= 8;
                }
                r02.inlineClassUnderlyingPropertyName_ = this.f57317r;
                if ((i4 & 16384) == 16384) {
                    i5 |= 16;
                }
                r02.inlineClassUnderlyingType_ = this.f57318s;
                if ((i4 & 32768) == 32768) {
                    i5 |= 32;
                }
                r02.inlineClassUnderlyingTypeId_ = this.f57319t;
                if ((i4 & 65536) == 65536) {
                    i5 |= 64;
                }
                r02.typeTable_ = this.f57320u;
                if ((this.f57303d & 131072) == 131072) {
                    this.f57321v = Collections.unmodifiableList(this.f57321v);
                    this.f57303d &= -131073;
                }
                r02.versionRequirement_ = this.f57321v;
                if ((i4 & 262144) == 262144) {
                    i5 |= 128;
                }
                r02.versionRequirementTable_ = this.f57322w;
                r02.bitField0_ = i5;
                return r02;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.c
            /* renamed from: s */
            public b l() {
                return t().h(r());
            }
        }

        static {
            Class r02 = new Class(true);
            defaultInstance = r02;
            r02.initFields();
        }

        public static Class getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.flags_ = 6;
            this.fqName_ = 0;
            this.companionObjectName_ = 0;
            this.typeParameter_ = Collections.emptyList();
            this.supertype_ = Collections.emptyList();
            this.supertypeId_ = Collections.emptyList();
            this.nestedClassName_ = Collections.emptyList();
            this.constructor_ = Collections.emptyList();
            this.function_ = Collections.emptyList();
            this.property_ = Collections.emptyList();
            this.typeAlias_ = Collections.emptyList();
            this.enumEntry_ = Collections.emptyList();
            this.sealedSubclassFqName_ = Collections.emptyList();
            this.inlineClassUnderlyingPropertyName_ = 0;
            this.inlineClassUnderlyingType_ = Type.getDefaultInstance();
            this.inlineClassUnderlyingTypeId_ = 0;
            this.typeTable_ = TypeTable.getDefaultInstance();
            this.versionRequirement_ = Collections.emptyList();
            this.versionRequirementTable_ = VersionRequirementTable.getDefaultInstance();
        }

        public static b newBuilder() {
            return b.p();
        }

        public static Class parseFrom(InputStream inputStream, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws IOException {
            return PARSER.a(inputStream, fVar);
        }

        public int getCompanionObjectName() {
            return this.companionObjectName_;
        }

        public Constructor getConstructor(int i4) {
            return this.constructor_.get(i4);
        }

        public int getConstructorCount() {
            return this.constructor_.size();
        }

        public List<Constructor> getConstructorList() {
            return this.constructor_;
        }

        public EnumEntry getEnumEntry(int i4) {
            return this.enumEntry_.get(i4);
        }

        public int getEnumEntryCount() {
            return this.enumEntry_.size();
        }

        public List<EnumEntry> getEnumEntryList() {
            return this.enumEntry_;
        }

        public int getFlags() {
            return this.flags_;
        }

        public int getFqName() {
            return this.fqName_;
        }

        public Function getFunction(int i4) {
            return this.function_.get(i4);
        }

        public int getFunctionCount() {
            return this.function_.size();
        }

        public List<Function> getFunctionList() {
            return this.function_;
        }

        public int getInlineClassUnderlyingPropertyName() {
            return this.inlineClassUnderlyingPropertyName_;
        }

        public Type getInlineClassUnderlyingType() {
            return this.inlineClassUnderlyingType_;
        }

        public int getInlineClassUnderlyingTypeId() {
            return this.inlineClassUnderlyingTypeId_;
        }

        public List<Integer> getNestedClassNameList() {
            return this.nestedClassName_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
        public kotlin.reflect.jvm.internal.impl.protobuf.p<Class> getParserForType() {
            return PARSER;
        }

        public Property getProperty(int i4) {
            return this.property_.get(i4);
        }

        public int getPropertyCount() {
            return this.property_.size();
        }

        public List<Property> getPropertyList() {
            return this.property_;
        }

        public List<Integer> getSealedSubclassFqNameList() {
            return this.sealedSubclassFqName_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public int getSerializedSize() {
            int i4 = this.memoizedSerializedSize;
            if (i4 != -1) {
                return i4;
            }
            int o4 = (this.bitField0_ & 1) == 1 ? CodedOutputStream.o(1, this.flags_) + 0 : 0;
            int i5 = 0;
            for (int i6 = 0; i6 < this.supertypeId_.size(); i6++) {
                i5 += CodedOutputStream.p(this.supertypeId_.get(i6).intValue());
            }
            int i7 = o4 + i5;
            if (!getSupertypeIdList().isEmpty()) {
                i7 = i7 + 1 + CodedOutputStream.p(i5);
            }
            this.supertypeIdMemoizedSerializedSize = i5;
            if ((this.bitField0_ & 2) == 2) {
                i7 += CodedOutputStream.o(3, this.fqName_);
            }
            if ((this.bitField0_ & 4) == 4) {
                i7 += CodedOutputStream.o(4, this.companionObjectName_);
            }
            for (int i8 = 0; i8 < this.typeParameter_.size(); i8++) {
                i7 += CodedOutputStream.s(5, this.typeParameter_.get(i8));
            }
            for (int i9 = 0; i9 < this.supertype_.size(); i9++) {
                i7 += CodedOutputStream.s(6, this.supertype_.get(i9));
            }
            int i10 = 0;
            for (int i11 = 0; i11 < this.nestedClassName_.size(); i11++) {
                i10 += CodedOutputStream.p(this.nestedClassName_.get(i11).intValue());
            }
            int i12 = i7 + i10;
            if (!getNestedClassNameList().isEmpty()) {
                i12 = i12 + 1 + CodedOutputStream.p(i10);
            }
            this.nestedClassNameMemoizedSerializedSize = i10;
            for (int i13 = 0; i13 < this.constructor_.size(); i13++) {
                i12 += CodedOutputStream.s(8, this.constructor_.get(i13));
            }
            for (int i14 = 0; i14 < this.function_.size(); i14++) {
                i12 += CodedOutputStream.s(9, this.function_.get(i14));
            }
            for (int i15 = 0; i15 < this.property_.size(); i15++) {
                i12 += CodedOutputStream.s(10, this.property_.get(i15));
            }
            for (int i16 = 0; i16 < this.typeAlias_.size(); i16++) {
                i12 += CodedOutputStream.s(11, this.typeAlias_.get(i16));
            }
            for (int i17 = 0; i17 < this.enumEntry_.size(); i17++) {
                i12 += CodedOutputStream.s(13, this.enumEntry_.get(i17));
            }
            int i18 = 0;
            for (int i19 = 0; i19 < this.sealedSubclassFqName_.size(); i19++) {
                i18 += CodedOutputStream.p(this.sealedSubclassFqName_.get(i19).intValue());
            }
            int i20 = i12 + i18;
            if (!getSealedSubclassFqNameList().isEmpty()) {
                i20 = i20 + 2 + CodedOutputStream.p(i18);
            }
            this.sealedSubclassFqNameMemoizedSerializedSize = i18;
            if ((this.bitField0_ & 8) == 8) {
                i20 += CodedOutputStream.o(17, this.inlineClassUnderlyingPropertyName_);
            }
            if ((this.bitField0_ & 16) == 16) {
                i20 += CodedOutputStream.s(18, this.inlineClassUnderlyingType_);
            }
            if ((this.bitField0_ & 32) == 32) {
                i20 += CodedOutputStream.o(19, this.inlineClassUnderlyingTypeId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                i20 += CodedOutputStream.s(30, this.typeTable_);
            }
            int i21 = 0;
            for (int i22 = 0; i22 < this.versionRequirement_.size(); i22++) {
                i21 += CodedOutputStream.p(this.versionRequirement_.get(i22).intValue());
            }
            int size = i20 + i21 + (getVersionRequirementList().size() * 2);
            if ((this.bitField0_ & 128) == 128) {
                size += CodedOutputStream.s(32, this.versionRequirementTable_);
            }
            int extensionsSerializedSize = size + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public Type getSupertype(int i4) {
            return this.supertype_.get(i4);
        }

        public int getSupertypeCount() {
            return this.supertype_.size();
        }

        public List<Integer> getSupertypeIdList() {
            return this.supertypeId_;
        }

        public List<Type> getSupertypeList() {
            return this.supertype_;
        }

        public TypeAlias getTypeAlias(int i4) {
            return this.typeAlias_.get(i4);
        }

        public int getTypeAliasCount() {
            return this.typeAlias_.size();
        }

        public List<TypeAlias> getTypeAliasList() {
            return this.typeAlias_;
        }

        public TypeParameter getTypeParameter(int i4) {
            return this.typeParameter_.get(i4);
        }

        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        public List<TypeParameter> getTypeParameterList() {
            return this.typeParameter_;
        }

        public TypeTable getTypeTable() {
            return this.typeTable_;
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        public VersionRequirementTable getVersionRequirementTable() {
            return this.versionRequirementTable_;
        }

        public boolean hasCompanionObjectName() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasFqName() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasInlineClassUnderlyingPropertyName() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasInlineClassUnderlyingType() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean hasInlineClassUnderlyingTypeId() {
            return (this.bitField0_ & 32) == 32;
        }

        public boolean hasTypeTable() {
            return (this.bitField0_ & 64) == 64;
        }

        public boolean hasVersionRequirementTable() {
            return (this.bitField0_ & 128) == 128;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public final boolean isInitialized() {
            byte b4 = this.memoizedIsInitialized;
            if (b4 == 1) {
                return true;
            }
            if (b4 == 0) {
                return false;
            }
            if (!hasFqName()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i4 = 0; i4 < getTypeParameterCount(); i4++) {
                if (!getTypeParameter(i4).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i5 = 0; i5 < getSupertypeCount(); i5++) {
                if (!getSupertype(i5).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i6 = 0; i6 < getConstructorCount(); i6++) {
                if (!getConstructor(i6).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i7 = 0; i7 < getFunctionCount(); i7++) {
                if (!getFunction(i7).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i8 = 0; i8 < getPropertyCount(); i8++) {
                if (!getProperty(i8).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i9 = 0; i9 < getTypeAliasCount(); i9++) {
                if (!getTypeAlias(i9).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i10 = 0; i10 < getEnumEntryCount(); i10++) {
                if (!getEnumEntry(i10).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasInlineClassUnderlyingType() && !getInlineClassUnderlyingType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (hasTypeTable() && !getTypeTable().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (!extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.a newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.a0(1, this.flags_);
            }
            if (getSupertypeIdList().size() > 0) {
                codedOutputStream.o0(18);
                codedOutputStream.o0(this.supertypeIdMemoizedSerializedSize);
            }
            for (int i4 = 0; i4 < this.supertypeId_.size(); i4++) {
                codedOutputStream.b0(this.supertypeId_.get(i4).intValue());
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.a0(3, this.fqName_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.a0(4, this.companionObjectName_);
            }
            for (int i5 = 0; i5 < this.typeParameter_.size(); i5++) {
                codedOutputStream.d0(5, this.typeParameter_.get(i5));
            }
            for (int i6 = 0; i6 < this.supertype_.size(); i6++) {
                codedOutputStream.d0(6, this.supertype_.get(i6));
            }
            if (getNestedClassNameList().size() > 0) {
                codedOutputStream.o0(58);
                codedOutputStream.o0(this.nestedClassNameMemoizedSerializedSize);
            }
            for (int i7 = 0; i7 < this.nestedClassName_.size(); i7++) {
                codedOutputStream.b0(this.nestedClassName_.get(i7).intValue());
            }
            for (int i8 = 0; i8 < this.constructor_.size(); i8++) {
                codedOutputStream.d0(8, this.constructor_.get(i8));
            }
            for (int i9 = 0; i9 < this.function_.size(); i9++) {
                codedOutputStream.d0(9, this.function_.get(i9));
            }
            for (int i10 = 0; i10 < this.property_.size(); i10++) {
                codedOutputStream.d0(10, this.property_.get(i10));
            }
            for (int i11 = 0; i11 < this.typeAlias_.size(); i11++) {
                codedOutputStream.d0(11, this.typeAlias_.get(i11));
            }
            for (int i12 = 0; i12 < this.enumEntry_.size(); i12++) {
                codedOutputStream.d0(13, this.enumEntry_.get(i12));
            }
            if (getSealedSubclassFqNameList().size() > 0) {
                codedOutputStream.o0(130);
                codedOutputStream.o0(this.sealedSubclassFqNameMemoizedSerializedSize);
            }
            for (int i13 = 0; i13 < this.sealedSubclassFqName_.size(); i13++) {
                codedOutputStream.b0(this.sealedSubclassFqName_.get(i13).intValue());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.a0(17, this.inlineClassUnderlyingPropertyName_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.d0(18, this.inlineClassUnderlyingType_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.a0(19, this.inlineClassUnderlyingTypeId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.d0(30, this.typeTable_);
            }
            for (int i14 = 0; i14 < this.versionRequirement_.size(); i14++) {
                codedOutputStream.a0(31, this.versionRequirement_.get(i14).intValue());
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.d0(32, this.versionRequirementTable_);
            }
            newExtensionWriter.a(19000, codedOutputStream);
            codedOutputStream.i0(this.unknownFields);
        }

        public static b newBuilder(Class r12) {
            return newBuilder().h(r12);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public Class getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b toBuilder() {
            return newBuilder(this);
        }

        private Class(GeneratedMessageLite.c<Class, ?> cVar) {
            super(cVar);
            this.supertypeIdMemoizedSerializedSize = -1;
            this.nestedClassNameMemoizedSerializedSize = -1;
            this.sealedSubclassFqNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = cVar.f();
        }

        private Class(boolean z3) {
            this.supertypeIdMemoizedSerializedSize = -1;
            this.nestedClassNameMemoizedSerializedSize = -1;
            this.sealedSubclassFqNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f57629a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Class(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
            this.supertypeIdMemoizedSerializedSize = -1;
            this.nestedClassNameMemoizedSerializedSize = -1;
            this.sealedSubclassFqNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            d.b u3 = kotlin.reflect.jvm.internal.impl.protobuf.d.u();
            CodedOutputStream J = CodedOutputStream.J(u3, 1);
            boolean z3 = false;
            boolean z4 = false;
            while (!z3) {
                try {
                    try {
                        int K = eVar.K();
                        switch (K) {
                            case 0:
                                z3 = true;
                                break;
                            case 8:
                                this.bitField0_ |= 1;
                                this.flags_ = eVar.s();
                                break;
                            case 16:
                                if (!(z4 & true)) {
                                    this.supertypeId_ = new ArrayList();
                                    z4 |= true;
                                }
                                this.supertypeId_.add(Integer.valueOf(eVar.s()));
                                break;
                            case 18:
                                int j4 = eVar.j(eVar.A());
                                if (!(z4 & true) && eVar.e() > 0) {
                                    this.supertypeId_ = new ArrayList();
                                    z4 |= true;
                                }
                                while (eVar.e() > 0) {
                                    this.supertypeId_.add(Integer.valueOf(eVar.s()));
                                }
                                eVar.i(j4);
                                break;
                            case 24:
                                this.bitField0_ |= 2;
                                this.fqName_ = eVar.s();
                                break;
                            case 32:
                                this.bitField0_ |= 4;
                                this.companionObjectName_ = eVar.s();
                                break;
                            case 42:
                                if (!(z4 & true)) {
                                    this.typeParameter_ = new ArrayList();
                                    z4 |= true;
                                }
                                this.typeParameter_.add(eVar.u(TypeParameter.PARSER, fVar));
                                break;
                            case 50:
                                if (!(z4 & true)) {
                                    this.supertype_ = new ArrayList();
                                    z4 |= true;
                                }
                                this.supertype_.add(eVar.u(Type.PARSER, fVar));
                                break;
                            case 56:
                                if (!(z4 & true)) {
                                    this.nestedClassName_ = new ArrayList();
                                    z4 |= true;
                                }
                                this.nestedClassName_.add(Integer.valueOf(eVar.s()));
                                break;
                            case 58:
                                int j5 = eVar.j(eVar.A());
                                if (!(z4 & true) && eVar.e() > 0) {
                                    this.nestedClassName_ = new ArrayList();
                                    z4 |= true;
                                }
                                while (eVar.e() > 0) {
                                    this.nestedClassName_.add(Integer.valueOf(eVar.s()));
                                }
                                eVar.i(j5);
                                break;
                            case 66:
                                if (!(z4 & true)) {
                                    this.constructor_ = new ArrayList();
                                    z4 |= true;
                                }
                                this.constructor_.add(eVar.u(Constructor.PARSER, fVar));
                                break;
                            case 74:
                                if (!(z4 & true)) {
                                    this.function_ = new ArrayList();
                                    z4 |= true;
                                }
                                this.function_.add(eVar.u(Function.PARSER, fVar));
                                break;
                            case 82:
                                if (!(z4 & true)) {
                                    this.property_ = new ArrayList();
                                    z4 |= true;
                                }
                                this.property_.add(eVar.u(Property.PARSER, fVar));
                                break;
                            case 90:
                                if (!(z4 & true)) {
                                    this.typeAlias_ = new ArrayList();
                                    z4 |= true;
                                }
                                this.typeAlias_.add(eVar.u(TypeAlias.PARSER, fVar));
                                break;
                            case 106:
                                if (!(z4 & true)) {
                                    this.enumEntry_ = new ArrayList();
                                    z4 |= true;
                                }
                                this.enumEntry_.add(eVar.u(EnumEntry.PARSER, fVar));
                                break;
                            case 128:
                                if (!(z4 & true)) {
                                    this.sealedSubclassFqName_ = new ArrayList();
                                    z4 |= true;
                                }
                                this.sealedSubclassFqName_.add(Integer.valueOf(eVar.s()));
                                break;
                            case 130:
                                int j6 = eVar.j(eVar.A());
                                if (!(z4 & true) && eVar.e() > 0) {
                                    this.sealedSubclassFqName_ = new ArrayList();
                                    z4 |= true;
                                }
                                while (eVar.e() > 0) {
                                    this.sealedSubclassFqName_.add(Integer.valueOf(eVar.s()));
                                }
                                eVar.i(j6);
                                break;
                            case 136:
                                this.bitField0_ |= 8;
                                this.inlineClassUnderlyingPropertyName_ = eVar.s();
                                break;
                            case 146:
                                Type.b builder = (this.bitField0_ & 16) == 16 ? this.inlineClassUnderlyingType_.toBuilder() : null;
                                Type type = (Type) eVar.u(Type.PARSER, fVar);
                                this.inlineClassUnderlyingType_ = type;
                                if (builder != null) {
                                    builder.h(type);
                                    this.inlineClassUnderlyingType_ = builder.r();
                                }
                                this.bitField0_ |= 16;
                                break;
                            case 152:
                                this.bitField0_ |= 32;
                                this.inlineClassUnderlyingTypeId_ = eVar.s();
                                break;
                            case 242:
                                TypeTable.b builder2 = (this.bitField0_ & 64) == 64 ? this.typeTable_.toBuilder() : null;
                                TypeTable typeTable = (TypeTable) eVar.u(TypeTable.PARSER, fVar);
                                this.typeTable_ = typeTable;
                                if (builder2 != null) {
                                    builder2.h(typeTable);
                                    this.typeTable_ = builder2.l();
                                }
                                this.bitField0_ |= 64;
                                break;
                            case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT /* 248 */:
                                if (!(z4 & true)) {
                                    this.versionRequirement_ = new ArrayList();
                                    z4 |= true;
                                }
                                this.versionRequirement_.add(Integer.valueOf(eVar.s()));
                                break;
                            case 250:
                                int j7 = eVar.j(eVar.A());
                                if (!(z4 & true) && eVar.e() > 0) {
                                    this.versionRequirement_ = new ArrayList();
                                    z4 |= true;
                                }
                                while (eVar.e() > 0) {
                                    this.versionRequirement_.add(Integer.valueOf(eVar.s()));
                                }
                                eVar.i(j7);
                                break;
                            case MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE /* 258 */:
                                VersionRequirementTable.b builder3 = (this.bitField0_ & 128) == 128 ? this.versionRequirementTable_.toBuilder() : null;
                                VersionRequirementTable versionRequirementTable = (VersionRequirementTable) eVar.u(VersionRequirementTable.PARSER, fVar);
                                this.versionRequirementTable_ = versionRequirementTable;
                                if (builder3 != null) {
                                    builder3.h(versionRequirementTable);
                                    this.versionRequirementTable_ = builder3.l();
                                }
                                this.bitField0_ |= 128;
                                break;
                            default:
                                if (parseUnknownField(eVar, J, fVar, K)) {
                                    break;
                                }
                                z3 = true;
                                break;
                        }
                    } catch (InvalidProtocolBufferException e4) {
                        throw e4.setUnfinishedMessage(this);
                    } catch (IOException e5) {
                        throw new InvalidProtocolBufferException(e5.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    if (z4 & true) {
                        this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
                    }
                    if (z4 & true) {
                        this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    }
                    if (z4 & true) {
                        this.supertype_ = Collections.unmodifiableList(this.supertype_);
                    }
                    if (z4 & true) {
                        this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
                    }
                    if (z4 & true) {
                        this.constructor_ = Collections.unmodifiableList(this.constructor_);
                    }
                    if (z4 & true) {
                        this.function_ = Collections.unmodifiableList(this.function_);
                    }
                    if (z4 & true) {
                        this.property_ = Collections.unmodifiableList(this.property_);
                    }
                    if (z4 & true) {
                        this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
                    }
                    if (z4 & true) {
                        this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
                    }
                    if (z4 & true) {
                        this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
                    }
                    if (z4 & true) {
                        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                    }
                    try {
                        J.I();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.unknownFields = u3.g();
                        throw th2;
                    }
                    this.unknownFields = u3.g();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z4 & true) {
                this.supertypeId_ = Collections.unmodifiableList(this.supertypeId_);
            }
            if (z4 & true) {
                this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
            }
            if (z4 & true) {
                this.supertype_ = Collections.unmodifiableList(this.supertype_);
            }
            if (z4 & true) {
                this.nestedClassName_ = Collections.unmodifiableList(this.nestedClassName_);
            }
            if (z4 & true) {
                this.constructor_ = Collections.unmodifiableList(this.constructor_);
            }
            if (z4 & true) {
                this.function_ = Collections.unmodifiableList(this.function_);
            }
            if (z4 & true) {
                this.property_ = Collections.unmodifiableList(this.property_);
            }
            if (z4 & true) {
                this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
            }
            if (z4 & true) {
                this.enumEntry_ = Collections.unmodifiableList(this.enumEntry_);
            }
            if (z4 & true) {
                this.sealedSubclassFqName_ = Collections.unmodifiableList(this.sealedSubclassFqName_);
            }
            if (z4 & true) {
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
            }
            try {
                J.I();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.unknownFields = u3.g();
                throw th3;
            }
            this.unknownFields = u3.g();
            makeExtensionsImmutable();
        }
    }

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class Constructor extends GeneratedMessageLite.ExtendableMessage<Constructor> implements e {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<Constructor> PARSER = new a();
        private static final Constructor defaultInstance;
        private int bitField0_;
        private int flags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;
        private List<ValueParameter> valueParameter_;
        private List<Integer> versionRequirement_;

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<Constructor> {
            a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
            /* renamed from: m */
            public Constructor c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                return new Constructor(eVar, fVar);
            }
        }

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class b extends GeneratedMessageLite.c<Constructor, b> implements e {

            /* renamed from: d  reason: collision with root package name */
            private int f57323d;

            /* renamed from: e  reason: collision with root package name */
            private int f57324e = 6;

            /* renamed from: f  reason: collision with root package name */
            private List<ValueParameter> f57325f = Collections.emptyList();

            /* renamed from: g  reason: collision with root package name */
            private List<Integer> f57326g = Collections.emptyList();

            private b() {
                A();
            }

            private void A() {
            }

            static /* synthetic */ b p() {
                return t();
            }

            private static b t() {
                return new b();
            }

            private void u() {
                if ((this.f57323d & 2) != 2) {
                    this.f57325f = new ArrayList(this.f57325f);
                    this.f57323d |= 2;
                }
            }

            private void v() {
                if ((this.f57323d & 4) != 4) {
                    this.f57326g = new ArrayList(this.f57326g);
                    this.f57323d |= 4;
                }
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: B */
            public b h(Constructor constructor) {
                if (constructor == Constructor.getDefaultInstance()) {
                    return this;
                }
                if (constructor.hasFlags()) {
                    D(constructor.getFlags());
                }
                if (!constructor.valueParameter_.isEmpty()) {
                    if (this.f57325f.isEmpty()) {
                        this.f57325f = constructor.valueParameter_;
                        this.f57323d &= -3;
                    } else {
                        u();
                        this.f57325f.addAll(constructor.valueParameter_);
                    }
                }
                if (!constructor.versionRequirement_.isEmpty()) {
                    if (this.f57326g.isEmpty()) {
                        this.f57326g = constructor.versionRequirement_;
                        this.f57323d &= -5;
                    } else {
                        v();
                        this.f57326g.addAll(constructor.versionRequirement_);
                    }
                }
                o(constructor);
                i(f().c(constructor.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC1158a, kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: C */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor.b g(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.h(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1b
                L11:
                    r3 = move-exception
                    kotlin.reflect.jvm.internal.impl.protobuf.n r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> Lf
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor) r4     // Catch: java.lang.Throwable -> Lf
                    throw r3     // Catch: java.lang.Throwable -> L19
                L19:
                    r3 = move-exception
                    r0 = r4
                L1b:
                    if (r0 == 0) goto L20
                    r2.h(r0)
                L20:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Constructor.b.g(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor$b");
            }

            public b D(int i4) {
                this.f57323d |= 1;
                this.f57324e = i4;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public final boolean isInitialized() {
                for (int i4 = 0; i4 < z(); i4++) {
                    if (!y(i4).isInitialized()) {
                        return false;
                    }
                }
                return n();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: q */
            public Constructor build() {
                Constructor r3 = r();
                if (r3.isInitialized()) {
                    return r3;
                }
                throw a.AbstractC1158a.c(r3);
            }

            public Constructor r() {
                Constructor constructor = new Constructor(this);
                int i4 = (this.f57323d & 1) != 1 ? 0 : 1;
                constructor.flags_ = this.f57324e;
                if ((this.f57323d & 2) == 2) {
                    this.f57325f = Collections.unmodifiableList(this.f57325f);
                    this.f57323d &= -3;
                }
                constructor.valueParameter_ = this.f57325f;
                if ((this.f57323d & 4) == 4) {
                    this.f57326g = Collections.unmodifiableList(this.f57326g);
                    this.f57323d &= -5;
                }
                constructor.versionRequirement_ = this.f57326g;
                constructor.bitField0_ = i4;
                return constructor;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.c
            /* renamed from: s */
            public b l() {
                return t().h(r());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, kotlin.reflect.jvm.internal.impl.protobuf.o
            /* renamed from: x */
            public Constructor getDefaultInstanceForType() {
                return Constructor.getDefaultInstance();
            }

            public ValueParameter y(int i4) {
                return this.f57325f.get(i4);
            }

            public int z() {
                return this.f57325f.size();
            }
        }

        static {
            Constructor constructor = new Constructor(true);
            defaultInstance = constructor;
            constructor.initFields();
        }

        public static Constructor getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.flags_ = 6;
            this.valueParameter_ = Collections.emptyList();
            this.versionRequirement_ = Collections.emptyList();
        }

        public static b newBuilder() {
            return b.p();
        }

        public int getFlags() {
            return this.flags_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
        public kotlin.reflect.jvm.internal.impl.protobuf.p<Constructor> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public int getSerializedSize() {
            int i4 = this.memoizedSerializedSize;
            if (i4 != -1) {
                return i4;
            }
            int o4 = (this.bitField0_ & 1) == 1 ? CodedOutputStream.o(1, this.flags_) + 0 : 0;
            for (int i5 = 0; i5 < this.valueParameter_.size(); i5++) {
                o4 += CodedOutputStream.s(2, this.valueParameter_.get(i5));
            }
            int i6 = 0;
            for (int i7 = 0; i7 < this.versionRequirement_.size(); i7++) {
                i6 += CodedOutputStream.p(this.versionRequirement_.get(i7).intValue());
            }
            int size = o4 + i6 + (getVersionRequirementList().size() * 2) + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public ValueParameter getValueParameter(int i4) {
            return this.valueParameter_.get(i4);
        }

        public int getValueParameterCount() {
            return this.valueParameter_.size();
        }

        public List<ValueParameter> getValueParameterList() {
            return this.valueParameter_;
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public final boolean isInitialized() {
            byte b4 = this.memoizedIsInitialized;
            if (b4 == 1) {
                return true;
            }
            if (b4 == 0) {
                return false;
            }
            for (int i4 = 0; i4 < getValueParameterCount(); i4++) {
                if (!getValueParameter(i4).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (!extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.a newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.a0(1, this.flags_);
            }
            for (int i4 = 0; i4 < this.valueParameter_.size(); i4++) {
                codedOutputStream.d0(2, this.valueParameter_.get(i4));
            }
            for (int i5 = 0; i5 < this.versionRequirement_.size(); i5++) {
                codedOutputStream.a0(31, this.versionRequirement_.get(i5).intValue());
            }
            newExtensionWriter.a(19000, codedOutputStream);
            codedOutputStream.i0(this.unknownFields);
        }

        public static b newBuilder(Constructor constructor) {
            return newBuilder().h(constructor);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public Constructor getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b toBuilder() {
            return newBuilder(this);
        }

        private Constructor(GeneratedMessageLite.c<Constructor, ?> cVar) {
            super(cVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = cVar.f();
        }

        private Constructor(boolean z3) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f57629a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Constructor(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            d.b u3 = kotlin.reflect.jvm.internal.impl.protobuf.d.u();
            CodedOutputStream J = CodedOutputStream.J(u3, 1);
            boolean z3 = false;
            boolean z4 = false;
            while (!z3) {
                try {
                    try {
                        try {
                            int K = eVar.K();
                            if (K != 0) {
                                if (K == 8) {
                                    this.bitField0_ |= 1;
                                    this.flags_ = eVar.s();
                                } else if (K == 18) {
                                    if (!(z4 & true)) {
                                        this.valueParameter_ = new ArrayList();
                                        z4 |= true;
                                    }
                                    this.valueParameter_.add(eVar.u(ValueParameter.PARSER, fVar));
                                } else if (K == 248) {
                                    if (!(z4 & true)) {
                                        this.versionRequirement_ = new ArrayList();
                                        z4 |= true;
                                    }
                                    this.versionRequirement_.add(Integer.valueOf(eVar.s()));
                                } else if (K != 250) {
                                    if (!parseUnknownField(eVar, J, fVar, K)) {
                                    }
                                } else {
                                    int j4 = eVar.j(eVar.A());
                                    if (!(z4 & true) && eVar.e() > 0) {
                                        this.versionRequirement_ = new ArrayList();
                                        z4 |= true;
                                    }
                                    while (eVar.e() > 0) {
                                        this.versionRequirement_.add(Integer.valueOf(eVar.s()));
                                    }
                                    eVar.i(j4);
                                }
                            }
                            z3 = true;
                        } catch (IOException e4) {
                            throw new InvalidProtocolBufferException(e4.getMessage()).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e5) {
                        throw e5.setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    if (z4 & true) {
                        this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                    }
                    if (z4 & true) {
                        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                    }
                    try {
                        J.I();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.unknownFields = u3.g();
                        throw th2;
                    }
                    this.unknownFields = u3.g();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z4 & true) {
                this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
            }
            if (z4 & true) {
                this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
            }
            try {
                J.I();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.unknownFields = u3.g();
                throw th3;
            }
            this.unknownFields = u3.g();
            makeExtensionsImmutable();
        }
    }

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class Contract extends GeneratedMessageLite implements f {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<Contract> PARSER = new a();
        private static final Contract defaultInstance;
        private List<Effect> effect_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<Contract> {
            a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
            /* renamed from: m */
            public Contract c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                return new Contract(eVar, fVar);
            }
        }

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class b extends GeneratedMessageLite.b<Contract, b> implements f {

            /* renamed from: b  reason: collision with root package name */
            private int f57327b;

            /* renamed from: c  reason: collision with root package name */
            private List<Effect> f57328c = Collections.emptyList();

            private b() {
                s();
            }

            static /* synthetic */ b j() {
                return n();
            }

            private static b n() {
                return new b();
            }

            private void o() {
                if ((this.f57327b & 1) != 1) {
                    this.f57328c = new ArrayList(this.f57328c);
                    this.f57327b |= 1;
                }
            }

            private void s() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public final boolean isInitialized() {
                for (int i4 = 0; i4 < r(); i4++) {
                    if (!q(i4).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: k */
            public Contract build() {
                Contract l4 = l();
                if (l4.isInitialized()) {
                    return l4;
                }
                throw a.AbstractC1158a.c(l4);
            }

            public Contract l() {
                Contract contract = new Contract(this);
                if ((this.f57327b & 1) == 1) {
                    this.f57328c = Collections.unmodifiableList(this.f57328c);
                    this.f57327b &= -2;
                }
                contract.effect_ = this.f57328c;
                return contract;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: m */
            public b d() {
                return n().h(l());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, kotlin.reflect.jvm.internal.impl.protobuf.o
            /* renamed from: p */
            public Contract getDefaultInstanceForType() {
                return Contract.getDefaultInstance();
            }

            public Effect q(int i4) {
                return this.f57328c.get(i4);
            }

            public int r() {
                return this.f57328c.size();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: t */
            public b h(Contract contract) {
                if (contract == Contract.getDefaultInstance()) {
                    return this;
                }
                if (!contract.effect_.isEmpty()) {
                    if (this.f57328c.isEmpty()) {
                        this.f57328c = contract.effect_;
                        this.f57327b &= -2;
                    } else {
                        o();
                        this.f57328c.addAll(contract.effect_);
                    }
                }
                i(f().c(contract.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC1158a, kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: u */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Contract.b g(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Contract.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Contract) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.h(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1b
                L11:
                    r3 = move-exception
                    kotlin.reflect.jvm.internal.impl.protobuf.n r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> Lf
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Contract) r4     // Catch: java.lang.Throwable -> Lf
                    throw r3     // Catch: java.lang.Throwable -> L19
                L19:
                    r3 = move-exception
                    r0 = r4
                L1b:
                    if (r0 == 0) goto L20
                    r2.h(r0)
                L20:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Contract.b.g(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Contract$b");
            }
        }

        static {
            Contract contract = new Contract(true);
            defaultInstance = contract;
            contract.initFields();
        }

        public static Contract getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.effect_ = Collections.emptyList();
        }

        public static b newBuilder() {
            return b.j();
        }

        public Effect getEffect(int i4) {
            return this.effect_.get(i4);
        }

        public int getEffectCount() {
            return this.effect_.size();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
        public kotlin.reflect.jvm.internal.impl.protobuf.p<Contract> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public int getSerializedSize() {
            int i4 = this.memoizedSerializedSize;
            if (i4 != -1) {
                return i4;
            }
            int i5 = 0;
            for (int i6 = 0; i6 < this.effect_.size(); i6++) {
                i5 += CodedOutputStream.s(1, this.effect_.get(i6));
            }
            int size = i5 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public final boolean isInitialized() {
            byte b4 = this.memoizedIsInitialized;
            if (b4 == 1) {
                return true;
            }
            if (b4 == 0) {
                return false;
            }
            for (int i4 = 0; i4 < getEffectCount(); i4++) {
                if (!getEffect(i4).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            for (int i4 = 0; i4 < this.effect_.size(); i4++) {
                codedOutputStream.d0(1, this.effect_.get(i4));
            }
            codedOutputStream.i0(this.unknownFields);
        }

        public static b newBuilder(Contract contract) {
            return newBuilder().h(contract);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public Contract getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b toBuilder() {
            return newBuilder(this);
        }

        private Contract(GeneratedMessageLite.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.f();
        }

        private Contract(boolean z3) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f57629a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Contract(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            d.b u3 = kotlin.reflect.jvm.internal.impl.protobuf.d.u();
            CodedOutputStream J = CodedOutputStream.J(u3, 1);
            boolean z3 = false;
            boolean z4 = false;
            while (!z3) {
                try {
                    try {
                        int K = eVar.K();
                        if (K != 0) {
                            if (K != 10) {
                                if (!parseUnknownField(eVar, J, fVar, K)) {
                                }
                            } else {
                                if (!(z4 & true)) {
                                    this.effect_ = new ArrayList();
                                    z4 |= true;
                                }
                                this.effect_.add(eVar.u(Effect.PARSER, fVar));
                            }
                        }
                        z3 = true;
                    } catch (InvalidProtocolBufferException e4) {
                        throw e4.setUnfinishedMessage(this);
                    } catch (IOException e5) {
                        throw new InvalidProtocolBufferException(e5.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    if (z4 & true) {
                        this.effect_ = Collections.unmodifiableList(this.effect_);
                    }
                    try {
                        J.I();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.unknownFields = u3.g();
                        throw th2;
                    }
                    this.unknownFields = u3.g();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z4 & true) {
                this.effect_ = Collections.unmodifiableList(this.effect_);
            }
            try {
                J.I();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.unknownFields = u3.g();
                throw th3;
            }
            this.unknownFields = u3.g();
            makeExtensionsImmutable();
        }
    }

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class Effect extends GeneratedMessageLite implements g {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<Effect> PARSER = new a();
        private static final Effect defaultInstance;
        private int bitField0_;
        private Expression conclusionOfConditionalEffect_;
        private List<Expression> effectConstructorArgument_;
        private EffectType effectType_;
        private InvocationKind kind_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public enum EffectType implements h.a {
            RETURNS_CONSTANT(0, 0),
            CALLS(1, 1),
            RETURNS_NOT_NULL(2, 2);
            
            private static h.b<EffectType> internalValueMap = new a();
            private final int value;

            /* loaded from: E:\TSN-r\205dec\7343912.dex */
            static class a implements h.b<EffectType> {
                a() {
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
                /* renamed from: b */
                public EffectType a(int i4) {
                    return EffectType.valueOf(i4);
                }
            }

            EffectType(int i4, int i5) {
                this.value = i5;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.a
            public final int getNumber() {
                return this.value;
            }

            public static EffectType valueOf(int i4) {
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 != 2) {
                            return null;
                        }
                        return RETURNS_NOT_NULL;
                    }
                    return CALLS;
                }
                return RETURNS_CONSTANT;
            }
        }

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public enum InvocationKind implements h.a {
            AT_MOST_ONCE(0, 0),
            EXACTLY_ONCE(1, 1),
            AT_LEAST_ONCE(2, 2);
            
            private static h.b<InvocationKind> internalValueMap = new a();
            private final int value;

            /* loaded from: E:\TSN-r\205dec\7343912.dex */
            static class a implements h.b<InvocationKind> {
                a() {
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
                /* renamed from: b */
                public InvocationKind a(int i4) {
                    return InvocationKind.valueOf(i4);
                }
            }

            InvocationKind(int i4, int i5) {
                this.value = i5;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.a
            public final int getNumber() {
                return this.value;
            }

            public static InvocationKind valueOf(int i4) {
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 != 2) {
                            return null;
                        }
                        return AT_LEAST_ONCE;
                    }
                    return EXACTLY_ONCE;
                }
                return AT_MOST_ONCE;
            }
        }

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<Effect> {
            a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
            /* renamed from: m */
            public Effect c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                return new Effect(eVar, fVar);
            }
        }

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class b extends GeneratedMessageLite.b<Effect, b> implements g {

            /* renamed from: b  reason: collision with root package name */
            private int f57329b;

            /* renamed from: c  reason: collision with root package name */
            private EffectType f57330c = EffectType.RETURNS_CONSTANT;

            /* renamed from: d  reason: collision with root package name */
            private List<Expression> f57331d = Collections.emptyList();

            /* renamed from: e  reason: collision with root package name */
            private Expression f57332e = Expression.getDefaultInstance();

            /* renamed from: f  reason: collision with root package name */
            private InvocationKind f57333f = InvocationKind.AT_MOST_ONCE;

            private b() {
                u();
            }

            static /* synthetic */ b j() {
                return n();
            }

            private static b n() {
                return new b();
            }

            private void o() {
                if ((this.f57329b & 2) != 2) {
                    this.f57331d = new ArrayList(this.f57331d);
                    this.f57329b |= 2;
                }
            }

            private void u() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public final boolean isInitialized() {
                for (int i4 = 0; i4 < s(); i4++) {
                    if (!r(i4).isInitialized()) {
                        return false;
                    }
                }
                return !t() || p().isInitialized();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: k */
            public Effect build() {
                Effect l4 = l();
                if (l4.isInitialized()) {
                    return l4;
                }
                throw a.AbstractC1158a.c(l4);
            }

            public Effect l() {
                Effect effect = new Effect(this);
                int i4 = this.f57329b;
                int i5 = (i4 & 1) != 1 ? 0 : 1;
                effect.effectType_ = this.f57330c;
                if ((this.f57329b & 2) == 2) {
                    this.f57331d = Collections.unmodifiableList(this.f57331d);
                    this.f57329b &= -3;
                }
                effect.effectConstructorArgument_ = this.f57331d;
                if ((i4 & 4) == 4) {
                    i5 |= 2;
                }
                effect.conclusionOfConditionalEffect_ = this.f57332e;
                if ((i4 & 8) == 8) {
                    i5 |= 4;
                }
                effect.kind_ = this.f57333f;
                effect.bitField0_ = i5;
                return effect;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: m */
            public b d() {
                return n().h(l());
            }

            public Expression p() {
                return this.f57332e;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, kotlin.reflect.jvm.internal.impl.protobuf.o
            /* renamed from: q */
            public Effect getDefaultInstanceForType() {
                return Effect.getDefaultInstance();
            }

            public Expression r(int i4) {
                return this.f57331d.get(i4);
            }

            public int s() {
                return this.f57331d.size();
            }

            public boolean t() {
                return (this.f57329b & 4) == 4;
            }

            public b v(Expression expression) {
                if ((this.f57329b & 4) == 4 && this.f57332e != Expression.getDefaultInstance()) {
                    this.f57332e = Expression.newBuilder(this.f57332e).h(expression).l();
                } else {
                    this.f57332e = expression;
                }
                this.f57329b |= 4;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: w */
            public b h(Effect effect) {
                if (effect == Effect.getDefaultInstance()) {
                    return this;
                }
                if (effect.hasEffectType()) {
                    y(effect.getEffectType());
                }
                if (!effect.effectConstructorArgument_.isEmpty()) {
                    if (this.f57331d.isEmpty()) {
                        this.f57331d = effect.effectConstructorArgument_;
                        this.f57329b &= -3;
                    } else {
                        o();
                        this.f57331d.addAll(effect.effectConstructorArgument_);
                    }
                }
                if (effect.hasConclusionOfConditionalEffect()) {
                    v(effect.getConclusionOfConditionalEffect());
                }
                if (effect.hasKind()) {
                    z(effect.getKind());
                }
                i(f().c(effect.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC1158a, kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: x */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Effect.b g(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Effect> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Effect.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Effect r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Effect) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.h(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1b
                L11:
                    r3 = move-exception
                    kotlin.reflect.jvm.internal.impl.protobuf.n r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> Lf
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Effect r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Effect) r4     // Catch: java.lang.Throwable -> Lf
                    throw r3     // Catch: java.lang.Throwable -> L19
                L19:
                    r3 = move-exception
                    r0 = r4
                L1b:
                    if (r0 == 0) goto L20
                    r2.h(r0)
                L20:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Effect.b.g(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Effect$b");
            }

            public b y(EffectType effectType) {
                effectType.getClass();
                this.f57329b |= 1;
                this.f57330c = effectType;
                return this;
            }

            public b z(InvocationKind invocationKind) {
                invocationKind.getClass();
                this.f57329b |= 8;
                this.f57333f = invocationKind;
                return this;
            }
        }

        static {
            Effect effect = new Effect(true);
            defaultInstance = effect;
            effect.initFields();
        }

        public static Effect getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.effectType_ = EffectType.RETURNS_CONSTANT;
            this.effectConstructorArgument_ = Collections.emptyList();
            this.conclusionOfConditionalEffect_ = Expression.getDefaultInstance();
            this.kind_ = InvocationKind.AT_MOST_ONCE;
        }

        public static b newBuilder() {
            return b.j();
        }

        public Expression getConclusionOfConditionalEffect() {
            return this.conclusionOfConditionalEffect_;
        }

        public Expression getEffectConstructorArgument(int i4) {
            return this.effectConstructorArgument_.get(i4);
        }

        public int getEffectConstructorArgumentCount() {
            return this.effectConstructorArgument_.size();
        }

        public EffectType getEffectType() {
            return this.effectType_;
        }

        public InvocationKind getKind() {
            return this.kind_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
        public kotlin.reflect.jvm.internal.impl.protobuf.p<Effect> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public int getSerializedSize() {
            int i4 = this.memoizedSerializedSize;
            if (i4 != -1) {
                return i4;
            }
            int h4 = (this.bitField0_ & 1) == 1 ? CodedOutputStream.h(1, this.effectType_.getNumber()) + 0 : 0;
            for (int i5 = 0; i5 < this.effectConstructorArgument_.size(); i5++) {
                h4 += CodedOutputStream.s(2, this.effectConstructorArgument_.get(i5));
            }
            if ((this.bitField0_ & 2) == 2) {
                h4 += CodedOutputStream.s(3, this.conclusionOfConditionalEffect_);
            }
            if ((this.bitField0_ & 4) == 4) {
                h4 += CodedOutputStream.h(4, this.kind_.getNumber());
            }
            int size = h4 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public boolean hasConclusionOfConditionalEffect() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasEffectType() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasKind() {
            return (this.bitField0_ & 4) == 4;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public final boolean isInitialized() {
            byte b4 = this.memoizedIsInitialized;
            if (b4 == 1) {
                return true;
            }
            if (b4 == 0) {
                return false;
            }
            for (int i4 = 0; i4 < getEffectConstructorArgumentCount(); i4++) {
                if (!getEffectConstructorArgument(i4).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasConclusionOfConditionalEffect() && !getConclusionOfConditionalEffect().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.S(1, this.effectType_.getNumber());
            }
            for (int i4 = 0; i4 < this.effectConstructorArgument_.size(); i4++) {
                codedOutputStream.d0(2, this.effectConstructorArgument_.get(i4));
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.d0(3, this.conclusionOfConditionalEffect_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.S(4, this.kind_.getNumber());
            }
            codedOutputStream.i0(this.unknownFields);
        }

        public static b newBuilder(Effect effect) {
            return newBuilder().h(effect);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public Effect getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b toBuilder() {
            return newBuilder(this);
        }

        private Effect(GeneratedMessageLite.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.f();
        }

        private Effect(boolean z3) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f57629a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Effect(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            d.b u3 = kotlin.reflect.jvm.internal.impl.protobuf.d.u();
            CodedOutputStream J = CodedOutputStream.J(u3, 1);
            boolean z3 = false;
            boolean z4 = false;
            while (!z3) {
                try {
                    try {
                        int K = eVar.K();
                        if (K != 0) {
                            if (K == 8) {
                                int n4 = eVar.n();
                                EffectType valueOf = EffectType.valueOf(n4);
                                if (valueOf == null) {
                                    J.o0(K);
                                    J.o0(n4);
                                } else {
                                    this.bitField0_ |= 1;
                                    this.effectType_ = valueOf;
                                }
                            } else if (K == 18) {
                                if (!(z4 & true)) {
                                    this.effectConstructorArgument_ = new ArrayList();
                                    z4 |= true;
                                }
                                this.effectConstructorArgument_.add(eVar.u(Expression.PARSER, fVar));
                            } else if (K == 26) {
                                Expression.b builder = (this.bitField0_ & 2) == 2 ? this.conclusionOfConditionalEffect_.toBuilder() : null;
                                Expression expression = (Expression) eVar.u(Expression.PARSER, fVar);
                                this.conclusionOfConditionalEffect_ = expression;
                                if (builder != null) {
                                    builder.h(expression);
                                    this.conclusionOfConditionalEffect_ = builder.l();
                                }
                                this.bitField0_ |= 2;
                            } else if (K != 32) {
                                if (!parseUnknownField(eVar, J, fVar, K)) {
                                }
                            } else {
                                int n5 = eVar.n();
                                InvocationKind valueOf2 = InvocationKind.valueOf(n5);
                                if (valueOf2 == null) {
                                    J.o0(K);
                                    J.o0(n5);
                                } else {
                                    this.bitField0_ |= 4;
                                    this.kind_ = valueOf2;
                                }
                            }
                        }
                        z3 = true;
                    } catch (InvalidProtocolBufferException e4) {
                        throw e4.setUnfinishedMessage(this);
                    } catch (IOException e5) {
                        throw new InvalidProtocolBufferException(e5.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    if (z4 & true) {
                        this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
                    }
                    try {
                        J.I();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.unknownFields = u3.g();
                        throw th2;
                    }
                    this.unknownFields = u3.g();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z4 & true) {
                this.effectConstructorArgument_ = Collections.unmodifiableList(this.effectConstructorArgument_);
            }
            try {
                J.I();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.unknownFields = u3.g();
                throw th3;
            }
            this.unknownFields = u3.g();
            makeExtensionsImmutable();
        }
    }

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class EnumEntry extends GeneratedMessageLite.ExtendableMessage<EnumEntry> implements h {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<EnumEntry> PARSER = new a();
        private static final EnumEntry defaultInstance;
        private int bitField0_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<EnumEntry> {
            a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
            /* renamed from: m */
            public EnumEntry c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                return new EnumEntry(eVar, fVar);
            }
        }

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class b extends GeneratedMessageLite.c<EnumEntry, b> implements h {

            /* renamed from: d  reason: collision with root package name */
            private int f57334d;

            /* renamed from: e  reason: collision with root package name */
            private int f57335e;

            private b() {
                v();
            }

            static /* synthetic */ b p() {
                return t();
            }

            private static b t() {
                return new b();
            }

            private void v() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public final boolean isInitialized() {
                return n();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: q */
            public EnumEntry build() {
                EnumEntry r3 = r();
                if (r3.isInitialized()) {
                    return r3;
                }
                throw a.AbstractC1158a.c(r3);
            }

            public EnumEntry r() {
                EnumEntry enumEntry = new EnumEntry(this);
                int i4 = (this.f57334d & 1) != 1 ? 0 : 1;
                enumEntry.name_ = this.f57335e;
                enumEntry.bitField0_ = i4;
                return enumEntry;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.c
            /* renamed from: s */
            public b l() {
                return t().h(r());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, kotlin.reflect.jvm.internal.impl.protobuf.o
            /* renamed from: u */
            public EnumEntry getDefaultInstanceForType() {
                return EnumEntry.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: w */
            public b h(EnumEntry enumEntry) {
                if (enumEntry == EnumEntry.getDefaultInstance()) {
                    return this;
                }
                if (enumEntry.hasName()) {
                    y(enumEntry.getName());
                }
                o(enumEntry);
                i(f().c(enumEntry.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC1158a, kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: x */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.EnumEntry.b g(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.EnumEntry.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.EnumEntry) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.h(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1b
                L11:
                    r3 = move-exception
                    kotlin.reflect.jvm.internal.impl.protobuf.n r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> Lf
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.EnumEntry) r4     // Catch: java.lang.Throwable -> Lf
                    throw r3     // Catch: java.lang.Throwable -> L19
                L19:
                    r3 = move-exception
                    r0 = r4
                L1b:
                    if (r0 == 0) goto L20
                    r2.h(r0)
                L20:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.EnumEntry.b.g(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry$b");
            }

            public b y(int i4) {
                this.f57334d |= 1;
                this.f57335e = i4;
                return this;
            }
        }

        static {
            EnumEntry enumEntry = new EnumEntry(true);
            defaultInstance = enumEntry;
            enumEntry.initFields();
        }

        public static EnumEntry getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.name_ = 0;
        }

        public static b newBuilder() {
            return b.p();
        }

        public int getName() {
            return this.name_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
        public kotlin.reflect.jvm.internal.impl.protobuf.p<EnumEntry> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public int getSerializedSize() {
            int i4 = this.memoizedSerializedSize;
            if (i4 != -1) {
                return i4;
            }
            int o4 = ((this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.o(1, this.name_) : 0) + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = o4;
            return o4;
        }

        public boolean hasName() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public final boolean isInitialized() {
            byte b4 = this.memoizedIsInitialized;
            if (b4 == 1) {
                return true;
            }
            if (b4 == 0) {
                return false;
            }
            if (!extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.a newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.a0(1, this.name_);
            }
            newExtensionWriter.a(200, codedOutputStream);
            codedOutputStream.i0(this.unknownFields);
        }

        public static b newBuilder(EnumEntry enumEntry) {
            return newBuilder().h(enumEntry);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public EnumEntry getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b toBuilder() {
            return newBuilder(this);
        }

        private EnumEntry(GeneratedMessageLite.c<EnumEntry, ?> cVar) {
            super(cVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = cVar.f();
        }

        private EnumEntry(boolean z3) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f57629a;
        }

        private EnumEntry(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            d.b u3 = kotlin.reflect.jvm.internal.impl.protobuf.d.u();
            CodedOutputStream J = CodedOutputStream.J(u3, 1);
            boolean z3 = false;
            while (!z3) {
                try {
                    try {
                        int K = eVar.K();
                        if (K != 0) {
                            if (K != 8) {
                                if (!parseUnknownField(eVar, J, fVar, K)) {
                                }
                            } else {
                                this.bitField0_ |= 1;
                                this.name_ = eVar.s();
                            }
                        }
                        z3 = true;
                    } catch (InvalidProtocolBufferException e4) {
                        throw e4.setUnfinishedMessage(this);
                    } catch (IOException e5) {
                        throw new InvalidProtocolBufferException(e5.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    try {
                        J.I();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.unknownFields = u3.g();
                        throw th2;
                    }
                    this.unknownFields = u3.g();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            try {
                J.I();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.unknownFields = u3.g();
                throw th3;
            }
            this.unknownFields = u3.g();
            makeExtensionsImmutable();
        }
    }

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class Expression extends GeneratedMessageLite implements i {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<Expression> PARSER = new a();
        private static final Expression defaultInstance;
        private List<Expression> andArgument_;
        private int bitField0_;
        private ConstantValue constantValue_;
        private int flags_;
        private int isInstanceTypeId_;
        private Type isInstanceType_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<Expression> orArgument_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;
        private int valueParameterReference_;

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public enum ConstantValue implements h.a {
            TRUE(0, 0),
            FALSE(1, 1),
            NULL(2, 2);
            
            private static h.b<ConstantValue> internalValueMap = new a();
            private final int value;

            /* loaded from: E:\TSN-r\205dec\7343912.dex */
            static class a implements h.b<ConstantValue> {
                a() {
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
                /* renamed from: b */
                public ConstantValue a(int i4) {
                    return ConstantValue.valueOf(i4);
                }
            }

            ConstantValue(int i4, int i5) {
                this.value = i5;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.a
            public final int getNumber() {
                return this.value;
            }

            public static ConstantValue valueOf(int i4) {
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 != 2) {
                            return null;
                        }
                        return NULL;
                    }
                    return FALSE;
                }
                return TRUE;
            }
        }

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<Expression> {
            a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
            /* renamed from: m */
            public Expression c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                return new Expression(eVar, fVar);
            }
        }

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class b extends GeneratedMessageLite.b<Expression, b> implements i {

            /* renamed from: b  reason: collision with root package name */
            private int f57336b;

            /* renamed from: c  reason: collision with root package name */
            private int f57337c;

            /* renamed from: d  reason: collision with root package name */
            private int f57338d;

            /* renamed from: g  reason: collision with root package name */
            private int f57341g;

            /* renamed from: e  reason: collision with root package name */
            private ConstantValue f57339e = ConstantValue.TRUE;

            /* renamed from: f  reason: collision with root package name */
            private Type f57340f = Type.getDefaultInstance();

            /* renamed from: h  reason: collision with root package name */
            private List<Expression> f57342h = Collections.emptyList();

            /* renamed from: i  reason: collision with root package name */
            private List<Expression> f57343i = Collections.emptyList();

            private b() {
                y();
            }

            static /* synthetic */ b j() {
                return n();
            }

            private static b n() {
                return new b();
            }

            private void o() {
                if ((this.f57336b & 32) != 32) {
                    this.f57342h = new ArrayList(this.f57342h);
                    this.f57336b |= 32;
                }
            }

            private void p() {
                if ((this.f57336b & 64) != 64) {
                    this.f57343i = new ArrayList(this.f57343i);
                    this.f57336b |= 64;
                }
            }

            private void y() {
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC1158a, kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: A */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Expression.b g(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Expression> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Expression.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Expression r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Expression) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.h(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1b
                L11:
                    r3 = move-exception
                    kotlin.reflect.jvm.internal.impl.protobuf.n r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> Lf
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Expression r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Expression) r4     // Catch: java.lang.Throwable -> Lf
                    throw r3     // Catch: java.lang.Throwable -> L19
                L19:
                    r3 = move-exception
                    r0 = r4
                L1b:
                    if (r0 == 0) goto L20
                    r2.h(r0)
                L20:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Expression.b.g(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Expression$b");
            }

            public b B(Type type) {
                if ((this.f57336b & 8) == 8 && this.f57340f != Type.getDefaultInstance()) {
                    this.f57340f = Type.newBuilder(this.f57340f).h(type).r();
                } else {
                    this.f57340f = type;
                }
                this.f57336b |= 8;
                return this;
            }

            public b C(ConstantValue constantValue) {
                constantValue.getClass();
                this.f57336b |= 4;
                this.f57339e = constantValue;
                return this;
            }

            public b D(int i4) {
                this.f57336b |= 1;
                this.f57337c = i4;
                return this;
            }

            public b E(int i4) {
                this.f57336b |= 16;
                this.f57341g = i4;
                return this;
            }

            public b F(int i4) {
                this.f57336b |= 2;
                this.f57338d = i4;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public final boolean isInitialized() {
                if (!x() || t().isInitialized()) {
                    for (int i4 = 0; i4 < r(); i4++) {
                        if (!q(i4).isInitialized()) {
                            return false;
                        }
                    }
                    for (int i5 = 0; i5 < v(); i5++) {
                        if (!u(i5).isInitialized()) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: k */
            public Expression build() {
                Expression l4 = l();
                if (l4.isInitialized()) {
                    return l4;
                }
                throw a.AbstractC1158a.c(l4);
            }

            public Expression l() {
                Expression expression = new Expression(this);
                int i4 = this.f57336b;
                int i5 = (i4 & 1) != 1 ? 0 : 1;
                expression.flags_ = this.f57337c;
                if ((i4 & 2) == 2) {
                    i5 |= 2;
                }
                expression.valueParameterReference_ = this.f57338d;
                if ((i4 & 4) == 4) {
                    i5 |= 4;
                }
                expression.constantValue_ = this.f57339e;
                if ((i4 & 8) == 8) {
                    i5 |= 8;
                }
                expression.isInstanceType_ = this.f57340f;
                if ((i4 & 16) == 16) {
                    i5 |= 16;
                }
                expression.isInstanceTypeId_ = this.f57341g;
                if ((this.f57336b & 32) == 32) {
                    this.f57342h = Collections.unmodifiableList(this.f57342h);
                    this.f57336b &= -33;
                }
                expression.andArgument_ = this.f57342h;
                if ((this.f57336b & 64) == 64) {
                    this.f57343i = Collections.unmodifiableList(this.f57343i);
                    this.f57336b &= -65;
                }
                expression.orArgument_ = this.f57343i;
                expression.bitField0_ = i5;
                return expression;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: m */
            public b d() {
                return n().h(l());
            }

            public Expression q(int i4) {
                return this.f57342h.get(i4);
            }

            public int r() {
                return this.f57342h.size();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, kotlin.reflect.jvm.internal.impl.protobuf.o
            /* renamed from: s */
            public Expression getDefaultInstanceForType() {
                return Expression.getDefaultInstance();
            }

            public Type t() {
                return this.f57340f;
            }

            public Expression u(int i4) {
                return this.f57343i.get(i4);
            }

            public int v() {
                return this.f57343i.size();
            }

            public boolean x() {
                return (this.f57336b & 8) == 8;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: z */
            public b h(Expression expression) {
                if (expression == Expression.getDefaultInstance()) {
                    return this;
                }
                if (expression.hasFlags()) {
                    D(expression.getFlags());
                }
                if (expression.hasValueParameterReference()) {
                    F(expression.getValueParameterReference());
                }
                if (expression.hasConstantValue()) {
                    C(expression.getConstantValue());
                }
                if (expression.hasIsInstanceType()) {
                    B(expression.getIsInstanceType());
                }
                if (expression.hasIsInstanceTypeId()) {
                    E(expression.getIsInstanceTypeId());
                }
                if (!expression.andArgument_.isEmpty()) {
                    if (this.f57342h.isEmpty()) {
                        this.f57342h = expression.andArgument_;
                        this.f57336b &= -33;
                    } else {
                        o();
                        this.f57342h.addAll(expression.andArgument_);
                    }
                }
                if (!expression.orArgument_.isEmpty()) {
                    if (this.f57343i.isEmpty()) {
                        this.f57343i = expression.orArgument_;
                        this.f57336b &= -65;
                    } else {
                        p();
                        this.f57343i.addAll(expression.orArgument_);
                    }
                }
                i(f().c(expression.unknownFields));
                return this;
            }
        }

        static {
            Expression expression = new Expression(true);
            defaultInstance = expression;
            expression.initFields();
        }

        public static Expression getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.flags_ = 0;
            this.valueParameterReference_ = 0;
            this.constantValue_ = ConstantValue.TRUE;
            this.isInstanceType_ = Type.getDefaultInstance();
            this.isInstanceTypeId_ = 0;
            this.andArgument_ = Collections.emptyList();
            this.orArgument_ = Collections.emptyList();
        }

        public static b newBuilder() {
            return b.j();
        }

        public Expression getAndArgument(int i4) {
            return this.andArgument_.get(i4);
        }

        public int getAndArgumentCount() {
            return this.andArgument_.size();
        }

        public ConstantValue getConstantValue() {
            return this.constantValue_;
        }

        public int getFlags() {
            return this.flags_;
        }

        public Type getIsInstanceType() {
            return this.isInstanceType_;
        }

        public int getIsInstanceTypeId() {
            return this.isInstanceTypeId_;
        }

        public Expression getOrArgument(int i4) {
            return this.orArgument_.get(i4);
        }

        public int getOrArgumentCount() {
            return this.orArgument_.size();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
        public kotlin.reflect.jvm.internal.impl.protobuf.p<Expression> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public int getSerializedSize() {
            int i4 = this.memoizedSerializedSize;
            if (i4 != -1) {
                return i4;
            }
            int o4 = (this.bitField0_ & 1) == 1 ? CodedOutputStream.o(1, this.flags_) + 0 : 0;
            if ((this.bitField0_ & 2) == 2) {
                o4 += CodedOutputStream.o(2, this.valueParameterReference_);
            }
            if ((this.bitField0_ & 4) == 4) {
                o4 += CodedOutputStream.h(3, this.constantValue_.getNumber());
            }
            if ((this.bitField0_ & 8) == 8) {
                o4 += CodedOutputStream.s(4, this.isInstanceType_);
            }
            if ((this.bitField0_ & 16) == 16) {
                o4 += CodedOutputStream.o(5, this.isInstanceTypeId_);
            }
            for (int i5 = 0; i5 < this.andArgument_.size(); i5++) {
                o4 += CodedOutputStream.s(6, this.andArgument_.get(i5));
            }
            for (int i6 = 0; i6 < this.orArgument_.size(); i6++) {
                o4 += CodedOutputStream.s(7, this.orArgument_.get(i6));
            }
            int size = o4 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public int getValueParameterReference() {
            return this.valueParameterReference_;
        }

        public boolean hasConstantValue() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasIsInstanceType() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasIsInstanceTypeId() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean hasValueParameterReference() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public final boolean isInitialized() {
            byte b4 = this.memoizedIsInitialized;
            if (b4 == 1) {
                return true;
            }
            if (b4 == 0) {
                return false;
            }
            if (hasIsInstanceType() && !getIsInstanceType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i4 = 0; i4 < getAndArgumentCount(); i4++) {
                if (!getAndArgument(i4).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i5 = 0; i5 < getOrArgumentCount(); i5++) {
                if (!getOrArgument(i5).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.a0(1, this.flags_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.a0(2, this.valueParameterReference_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.S(3, this.constantValue_.getNumber());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.d0(4, this.isInstanceType_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.a0(5, this.isInstanceTypeId_);
            }
            for (int i4 = 0; i4 < this.andArgument_.size(); i4++) {
                codedOutputStream.d0(6, this.andArgument_.get(i4));
            }
            for (int i5 = 0; i5 < this.orArgument_.size(); i5++) {
                codedOutputStream.d0(7, this.orArgument_.get(i5));
            }
            codedOutputStream.i0(this.unknownFields);
        }

        public static b newBuilder(Expression expression) {
            return newBuilder().h(expression);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public Expression getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b toBuilder() {
            return newBuilder(this);
        }

        private Expression(GeneratedMessageLite.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.f();
        }

        private Expression(boolean z3) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f57629a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Expression(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            d.b u3 = kotlin.reflect.jvm.internal.impl.protobuf.d.u();
            CodedOutputStream J = CodedOutputStream.J(u3, 1);
            boolean z3 = false;
            boolean z4 = false;
            while (!z3) {
                try {
                    try {
                        int K = eVar.K();
                        if (K != 0) {
                            if (K == 8) {
                                this.bitField0_ |= 1;
                                this.flags_ = eVar.s();
                            } else if (K == 16) {
                                this.bitField0_ |= 2;
                                this.valueParameterReference_ = eVar.s();
                            } else if (K == 24) {
                                int n4 = eVar.n();
                                ConstantValue valueOf = ConstantValue.valueOf(n4);
                                if (valueOf == null) {
                                    J.o0(K);
                                    J.o0(n4);
                                } else {
                                    this.bitField0_ |= 4;
                                    this.constantValue_ = valueOf;
                                }
                            } else if (K == 34) {
                                Type.b builder = (this.bitField0_ & 8) == 8 ? this.isInstanceType_.toBuilder() : null;
                                Type type = (Type) eVar.u(Type.PARSER, fVar);
                                this.isInstanceType_ = type;
                                if (builder != null) {
                                    builder.h(type);
                                    this.isInstanceType_ = builder.r();
                                }
                                this.bitField0_ |= 8;
                            } else if (K == 40) {
                                this.bitField0_ |= 16;
                                this.isInstanceTypeId_ = eVar.s();
                            } else if (K == 50) {
                                if (!(z4 & true)) {
                                    this.andArgument_ = new ArrayList();
                                    z4 |= true;
                                }
                                this.andArgument_.add(eVar.u(PARSER, fVar));
                            } else if (K != 58) {
                                if (!parseUnknownField(eVar, J, fVar, K)) {
                                }
                            } else {
                                if (!(z4 & true)) {
                                    this.orArgument_ = new ArrayList();
                                    z4 |= true;
                                }
                                this.orArgument_.add(eVar.u(PARSER, fVar));
                            }
                        }
                        z3 = true;
                    } catch (InvalidProtocolBufferException e4) {
                        throw e4.setUnfinishedMessage(this);
                    } catch (IOException e5) {
                        throw new InvalidProtocolBufferException(e5.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    if (z4 & true) {
                        this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
                    }
                    if (z4 & true) {
                        this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
                    }
                    try {
                        J.I();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.unknownFields = u3.g();
                        throw th2;
                    }
                    this.unknownFields = u3.g();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z4 & true) {
                this.andArgument_ = Collections.unmodifiableList(this.andArgument_);
            }
            if (z4 & true) {
                this.orArgument_ = Collections.unmodifiableList(this.orArgument_);
            }
            try {
                J.I();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.unknownFields = u3.g();
                throw th3;
            }
            this.unknownFields = u3.g();
            makeExtensionsImmutable();
        }
    }

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class Function extends GeneratedMessageLite.ExtendableMessage<Function> implements j {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<Function> PARSER = new a();
        private static final Function defaultInstance;
        private int bitField0_;
        private Contract contract_;
        private int flags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private int oldFlags_;
        private int receiverTypeId_;
        private Type receiverType_;
        private int returnTypeId_;
        private Type returnType_;
        private List<TypeParameter> typeParameter_;
        private TypeTable typeTable_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;
        private List<ValueParameter> valueParameter_;
        private List<Integer> versionRequirement_;

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<Function> {
            a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
            /* renamed from: m */
            public Function c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                return new Function(eVar, fVar);
            }
        }

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class b extends GeneratedMessageLite.c<Function, b> implements j {

            /* renamed from: d  reason: collision with root package name */
            private int f57344d;

            /* renamed from: g  reason: collision with root package name */
            private int f57347g;

            /* renamed from: i  reason: collision with root package name */
            private int f57349i;

            /* renamed from: l  reason: collision with root package name */
            private int f57352l;

            /* renamed from: e  reason: collision with root package name */
            private int f57345e = 6;

            /* renamed from: f  reason: collision with root package name */
            private int f57346f = 6;

            /* renamed from: h  reason: collision with root package name */
            private Type f57348h = Type.getDefaultInstance();

            /* renamed from: j  reason: collision with root package name */
            private List<TypeParameter> f57350j = Collections.emptyList();

            /* renamed from: k  reason: collision with root package name */
            private Type f57351k = Type.getDefaultInstance();

            /* renamed from: m  reason: collision with root package name */
            private List<ValueParameter> f57353m = Collections.emptyList();

            /* renamed from: n  reason: collision with root package name */
            private TypeTable f57354n = TypeTable.getDefaultInstance();

            /* renamed from: o  reason: collision with root package name */
            private List<Integer> f57355o = Collections.emptyList();

            /* renamed from: p  reason: collision with root package name */
            private Contract f57356p = Contract.getDefaultInstance();

            private b() {
                M();
            }

            private void M() {
            }

            static /* synthetic */ b p() {
                return t();
            }

            private static b t() {
                return new b();
            }

            private void u() {
                if ((this.f57344d & 32) != 32) {
                    this.f57350j = new ArrayList(this.f57350j);
                    this.f57344d |= 32;
                }
            }

            private void v() {
                if ((this.f57344d & 256) != 256) {
                    this.f57353m = new ArrayList(this.f57353m);
                    this.f57344d |= 256;
                }
            }

            private void x() {
                if ((this.f57344d & 1024) != 1024) {
                    this.f57355o = new ArrayList(this.f57355o);
                    this.f57344d |= 1024;
                }
            }

            public Type A() {
                return this.f57351k;
            }

            public Type B() {
                return this.f57348h;
            }

            public TypeParameter C(int i4) {
                return this.f57350j.get(i4);
            }

            public int D() {
                return this.f57350j.size();
            }

            public TypeTable E() {
                return this.f57354n;
            }

            public ValueParameter F(int i4) {
                return this.f57353m.get(i4);
            }

            public int G() {
                return this.f57353m.size();
            }

            public boolean H() {
                return (this.f57344d & 2048) == 2048;
            }

            public boolean I() {
                return (this.f57344d & 4) == 4;
            }

            public boolean J() {
                return (this.f57344d & 64) == 64;
            }

            public boolean K() {
                return (this.f57344d & 8) == 8;
            }

            public boolean L() {
                return (this.f57344d & 512) == 512;
            }

            public b N(Contract contract) {
                if ((this.f57344d & 2048) == 2048 && this.f57356p != Contract.getDefaultInstance()) {
                    this.f57356p = Contract.newBuilder(this.f57356p).h(contract).l();
                } else {
                    this.f57356p = contract;
                }
                this.f57344d |= 2048;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: O */
            public b h(Function function) {
                if (function == Function.getDefaultInstance()) {
                    return this;
                }
                if (function.hasFlags()) {
                    T(function.getFlags());
                }
                if (function.hasOldFlags()) {
                    V(function.getOldFlags());
                }
                if (function.hasName()) {
                    U(function.getName());
                }
                if (function.hasReturnType()) {
                    R(function.getReturnType());
                }
                if (function.hasReturnTypeId()) {
                    X(function.getReturnTypeId());
                }
                if (!function.typeParameter_.isEmpty()) {
                    if (this.f57350j.isEmpty()) {
                        this.f57350j = function.typeParameter_;
                        this.f57344d &= -33;
                    } else {
                        u();
                        this.f57350j.addAll(function.typeParameter_);
                    }
                }
                if (function.hasReceiverType()) {
                    Q(function.getReceiverType());
                }
                if (function.hasReceiverTypeId()) {
                    W(function.getReceiverTypeId());
                }
                if (!function.valueParameter_.isEmpty()) {
                    if (this.f57353m.isEmpty()) {
                        this.f57353m = function.valueParameter_;
                        this.f57344d &= -257;
                    } else {
                        v();
                        this.f57353m.addAll(function.valueParameter_);
                    }
                }
                if (function.hasTypeTable()) {
                    S(function.getTypeTable());
                }
                if (!function.versionRequirement_.isEmpty()) {
                    if (this.f57355o.isEmpty()) {
                        this.f57355o = function.versionRequirement_;
                        this.f57344d &= -1025;
                    } else {
                        x();
                        this.f57355o.addAll(function.versionRequirement_);
                    }
                }
                if (function.hasContract()) {
                    N(function.getContract());
                }
                o(function);
                i(f().c(function.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC1158a, kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: P */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function.b g(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.h(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1b
                L11:
                    r3 = move-exception
                    kotlin.reflect.jvm.internal.impl.protobuf.n r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> Lf
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function) r4     // Catch: java.lang.Throwable -> Lf
                    throw r3     // Catch: java.lang.Throwable -> L19
                L19:
                    r3 = move-exception
                    r0 = r4
                L1b:
                    if (r0 == 0) goto L20
                    r2.h(r0)
                L20:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Function.b.g(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function$b");
            }

            public b Q(Type type) {
                if ((this.f57344d & 64) == 64 && this.f57351k != Type.getDefaultInstance()) {
                    this.f57351k = Type.newBuilder(this.f57351k).h(type).r();
                } else {
                    this.f57351k = type;
                }
                this.f57344d |= 64;
                return this;
            }

            public b R(Type type) {
                if ((this.f57344d & 8) == 8 && this.f57348h != Type.getDefaultInstance()) {
                    this.f57348h = Type.newBuilder(this.f57348h).h(type).r();
                } else {
                    this.f57348h = type;
                }
                this.f57344d |= 8;
                return this;
            }

            public b S(TypeTable typeTable) {
                if ((this.f57344d & 512) == 512 && this.f57354n != TypeTable.getDefaultInstance()) {
                    this.f57354n = TypeTable.newBuilder(this.f57354n).h(typeTable).l();
                } else {
                    this.f57354n = typeTable;
                }
                this.f57344d |= 512;
                return this;
            }

            public b T(int i4) {
                this.f57344d |= 1;
                this.f57345e = i4;
                return this;
            }

            public b U(int i4) {
                this.f57344d |= 4;
                this.f57347g = i4;
                return this;
            }

            public b V(int i4) {
                this.f57344d |= 2;
                this.f57346f = i4;
                return this;
            }

            public b W(int i4) {
                this.f57344d |= 128;
                this.f57352l = i4;
                return this;
            }

            public b X(int i4) {
                this.f57344d |= 16;
                this.f57349i = i4;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public final boolean isInitialized() {
                if (I()) {
                    if (!K() || B().isInitialized()) {
                        for (int i4 = 0; i4 < D(); i4++) {
                            if (!C(i4).isInitialized()) {
                                return false;
                            }
                        }
                        if (!J() || A().isInitialized()) {
                            for (int i5 = 0; i5 < G(); i5++) {
                                if (!F(i5).isInitialized()) {
                                    return false;
                                }
                            }
                            if (!L() || E().isInitialized()) {
                                return (!H() || y().isInitialized()) && n();
                            }
                            return false;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: q */
            public Function build() {
                Function r3 = r();
                if (r3.isInitialized()) {
                    return r3;
                }
                throw a.AbstractC1158a.c(r3);
            }

            public Function r() {
                Function function = new Function(this);
                int i4 = this.f57344d;
                int i5 = (i4 & 1) != 1 ? 0 : 1;
                function.flags_ = this.f57345e;
                if ((i4 & 2) == 2) {
                    i5 |= 2;
                }
                function.oldFlags_ = this.f57346f;
                if ((i4 & 4) == 4) {
                    i5 |= 4;
                }
                function.name_ = this.f57347g;
                if ((i4 & 8) == 8) {
                    i5 |= 8;
                }
                function.returnType_ = this.f57348h;
                if ((i4 & 16) == 16) {
                    i5 |= 16;
                }
                function.returnTypeId_ = this.f57349i;
                if ((this.f57344d & 32) == 32) {
                    this.f57350j = Collections.unmodifiableList(this.f57350j);
                    this.f57344d &= -33;
                }
                function.typeParameter_ = this.f57350j;
                if ((i4 & 64) == 64) {
                    i5 |= 32;
                }
                function.receiverType_ = this.f57351k;
                if ((i4 & 128) == 128) {
                    i5 |= 64;
                }
                function.receiverTypeId_ = this.f57352l;
                if ((this.f57344d & 256) == 256) {
                    this.f57353m = Collections.unmodifiableList(this.f57353m);
                    this.f57344d &= -257;
                }
                function.valueParameter_ = this.f57353m;
                if ((i4 & 512) == 512) {
                    i5 |= 128;
                }
                function.typeTable_ = this.f57354n;
                if ((this.f57344d & 1024) == 1024) {
                    this.f57355o = Collections.unmodifiableList(this.f57355o);
                    this.f57344d &= -1025;
                }
                function.versionRequirement_ = this.f57355o;
                if ((i4 & 2048) == 2048) {
                    i5 |= 256;
                }
                function.contract_ = this.f57356p;
                function.bitField0_ = i5;
                return function;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.c
            /* renamed from: s */
            public b l() {
                return t().h(r());
            }

            public Contract y() {
                return this.f57356p;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, kotlin.reflect.jvm.internal.impl.protobuf.o
            /* renamed from: z */
            public Function getDefaultInstanceForType() {
                return Function.getDefaultInstance();
            }
        }

        static {
            Function function = new Function(true);
            defaultInstance = function;
            function.initFields();
        }

        public static Function getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.flags_ = 6;
            this.oldFlags_ = 6;
            this.name_ = 0;
            this.returnType_ = Type.getDefaultInstance();
            this.returnTypeId_ = 0;
            this.typeParameter_ = Collections.emptyList();
            this.receiverType_ = Type.getDefaultInstance();
            this.receiverTypeId_ = 0;
            this.valueParameter_ = Collections.emptyList();
            this.typeTable_ = TypeTable.getDefaultInstance();
            this.versionRequirement_ = Collections.emptyList();
            this.contract_ = Contract.getDefaultInstance();
        }

        public static b newBuilder() {
            return b.p();
        }

        public static Function parseFrom(InputStream inputStream, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws IOException {
            return PARSER.a(inputStream, fVar);
        }

        public Contract getContract() {
            return this.contract_;
        }

        public int getFlags() {
            return this.flags_;
        }

        public int getName() {
            return this.name_;
        }

        public int getOldFlags() {
            return this.oldFlags_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
        public kotlin.reflect.jvm.internal.impl.protobuf.p<Function> getParserForType() {
            return PARSER;
        }

        public Type getReceiverType() {
            return this.receiverType_;
        }

        public int getReceiverTypeId() {
            return this.receiverTypeId_;
        }

        public Type getReturnType() {
            return this.returnType_;
        }

        public int getReturnTypeId() {
            return this.returnTypeId_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public int getSerializedSize() {
            int i4 = this.memoizedSerializedSize;
            if (i4 != -1) {
                return i4;
            }
            int o4 = (this.bitField0_ & 2) == 2 ? CodedOutputStream.o(1, this.oldFlags_) + 0 : 0;
            if ((this.bitField0_ & 4) == 4) {
                o4 += CodedOutputStream.o(2, this.name_);
            }
            if ((this.bitField0_ & 8) == 8) {
                o4 += CodedOutputStream.s(3, this.returnType_);
            }
            for (int i5 = 0; i5 < this.typeParameter_.size(); i5++) {
                o4 += CodedOutputStream.s(4, this.typeParameter_.get(i5));
            }
            if ((this.bitField0_ & 32) == 32) {
                o4 += CodedOutputStream.s(5, this.receiverType_);
            }
            for (int i6 = 0; i6 < this.valueParameter_.size(); i6++) {
                o4 += CodedOutputStream.s(6, this.valueParameter_.get(i6));
            }
            if ((this.bitField0_ & 16) == 16) {
                o4 += CodedOutputStream.o(7, this.returnTypeId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                o4 += CodedOutputStream.o(8, this.receiverTypeId_);
            }
            if ((this.bitField0_ & 1) == 1) {
                o4 += CodedOutputStream.o(9, this.flags_);
            }
            if ((this.bitField0_ & 128) == 128) {
                o4 += CodedOutputStream.s(30, this.typeTable_);
            }
            int i7 = 0;
            for (int i8 = 0; i8 < this.versionRequirement_.size(); i8++) {
                i7 += CodedOutputStream.p(this.versionRequirement_.get(i8).intValue());
            }
            int size = o4 + i7 + (getVersionRequirementList().size() * 2);
            if ((this.bitField0_ & 256) == 256) {
                size += CodedOutputStream.s(32, this.contract_);
            }
            int extensionsSerializedSize = size + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public TypeParameter getTypeParameter(int i4) {
            return this.typeParameter_.get(i4);
        }

        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        public List<TypeParameter> getTypeParameterList() {
            return this.typeParameter_;
        }

        public TypeTable getTypeTable() {
            return this.typeTable_;
        }

        public ValueParameter getValueParameter(int i4) {
            return this.valueParameter_.get(i4);
        }

        public int getValueParameterCount() {
            return this.valueParameter_.size();
        }

        public List<ValueParameter> getValueParameterList() {
            return this.valueParameter_;
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        public boolean hasContract() {
            return (this.bitField0_ & 256) == 256;
        }

        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasName() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasOldFlags() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasReceiverType() {
            return (this.bitField0_ & 32) == 32;
        }

        public boolean hasReceiverTypeId() {
            return (this.bitField0_ & 64) == 64;
        }

        public boolean hasReturnType() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasReturnTypeId() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean hasTypeTable() {
            return (this.bitField0_ & 128) == 128;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public final boolean isInitialized() {
            byte b4 = this.memoizedIsInitialized;
            if (b4 == 1) {
                return true;
            }
            if (b4 == 0) {
                return false;
            }
            if (!hasName()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (hasReturnType() && !getReturnType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else {
                for (int i4 = 0; i4 < getTypeParameterCount(); i4++) {
                    if (!getTypeParameter(i4).isInitialized()) {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                if (hasReceiverType() && !getReceiverType().isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
                for (int i5 = 0; i5 < getValueParameterCount(); i5++) {
                    if (!getValueParameter(i5).isInitialized()) {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                if (hasTypeTable() && !getTypeTable().isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                } else if (hasContract() && !getContract().isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                } else if (!extensionsAreInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                } else {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                }
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.a newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.a0(1, this.oldFlags_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.a0(2, this.name_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.d0(3, this.returnType_);
            }
            for (int i4 = 0; i4 < this.typeParameter_.size(); i4++) {
                codedOutputStream.d0(4, this.typeParameter_.get(i4));
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.d0(5, this.receiverType_);
            }
            for (int i5 = 0; i5 < this.valueParameter_.size(); i5++) {
                codedOutputStream.d0(6, this.valueParameter_.get(i5));
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.a0(7, this.returnTypeId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.a0(8, this.receiverTypeId_);
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.a0(9, this.flags_);
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.d0(30, this.typeTable_);
            }
            for (int i6 = 0; i6 < this.versionRequirement_.size(); i6++) {
                codedOutputStream.a0(31, this.versionRequirement_.get(i6).intValue());
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.d0(32, this.contract_);
            }
            newExtensionWriter.a(19000, codedOutputStream);
            codedOutputStream.i0(this.unknownFields);
        }

        public static b newBuilder(Function function) {
            return newBuilder().h(function);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public Function getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b toBuilder() {
            return newBuilder(this);
        }

        private Function(GeneratedMessageLite.c<Function, ?> cVar) {
            super(cVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = cVar.f();
        }

        private Function(boolean z3) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f57629a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v0 */
        /* JADX WARN: Type inference failed for: r5v1 */
        /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
        private Function(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            d.b u3 = kotlin.reflect.jvm.internal.impl.protobuf.d.u();
            CodedOutputStream J = CodedOutputStream.J(u3, 1);
            boolean z3 = false;
            boolean z4 = false;
            while (true) {
                ?? r5 = 1024;
                if (!z3) {
                    try {
                        try {
                            try {
                                int K = eVar.K();
                                switch (K) {
                                    case 0:
                                        break;
                                    case 8:
                                        this.bitField0_ |= 2;
                                        this.oldFlags_ = eVar.s();
                                        continue;
                                    case 16:
                                        this.bitField0_ |= 4;
                                        this.name_ = eVar.s();
                                        continue;
                                    case 26:
                                        Type.b builder = (this.bitField0_ & 8) == 8 ? this.returnType_.toBuilder() : null;
                                        Type type = (Type) eVar.u(Type.PARSER, fVar);
                                        this.returnType_ = type;
                                        if (builder != null) {
                                            builder.h(type);
                                            this.returnType_ = builder.r();
                                        }
                                        this.bitField0_ |= 8;
                                        continue;
                                    case 34:
                                        if (!(z4 & true)) {
                                            this.typeParameter_ = new ArrayList();
                                            z4 |= true;
                                        }
                                        this.typeParameter_.add(eVar.u(TypeParameter.PARSER, fVar));
                                        continue;
                                    case 42:
                                        Type.b builder2 = (this.bitField0_ & 32) == 32 ? this.receiverType_.toBuilder() : null;
                                        Type type2 = (Type) eVar.u(Type.PARSER, fVar);
                                        this.receiverType_ = type2;
                                        if (builder2 != null) {
                                            builder2.h(type2);
                                            this.receiverType_ = builder2.r();
                                        }
                                        this.bitField0_ |= 32;
                                        continue;
                                    case 50:
                                        if (!(z4 & true)) {
                                            this.valueParameter_ = new ArrayList();
                                            z4 |= true;
                                        }
                                        this.valueParameter_.add(eVar.u(ValueParameter.PARSER, fVar));
                                        continue;
                                    case 56:
                                        this.bitField0_ |= 16;
                                        this.returnTypeId_ = eVar.s();
                                        continue;
                                    case 64:
                                        this.bitField0_ |= 64;
                                        this.receiverTypeId_ = eVar.s();
                                        continue;
                                    case 72:
                                        this.bitField0_ |= 1;
                                        this.flags_ = eVar.s();
                                        continue;
                                    case 242:
                                        TypeTable.b builder3 = (this.bitField0_ & 128) == 128 ? this.typeTable_.toBuilder() : null;
                                        TypeTable typeTable = (TypeTable) eVar.u(TypeTable.PARSER, fVar);
                                        this.typeTable_ = typeTable;
                                        if (builder3 != null) {
                                            builder3.h(typeTable);
                                            this.typeTable_ = builder3.l();
                                        }
                                        this.bitField0_ |= 128;
                                        continue;
                                    case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT /* 248 */:
                                        if (!(z4 & true)) {
                                            this.versionRequirement_ = new ArrayList();
                                            z4 |= true;
                                        }
                                        this.versionRequirement_.add(Integer.valueOf(eVar.s()));
                                        continue;
                                    case 250:
                                        int j4 = eVar.j(eVar.A());
                                        if (!(z4 & true) && eVar.e() > 0) {
                                            this.versionRequirement_ = new ArrayList();
                                            z4 |= true;
                                        }
                                        while (eVar.e() > 0) {
                                            this.versionRequirement_.add(Integer.valueOf(eVar.s()));
                                        }
                                        eVar.i(j4);
                                        continue;
                                        break;
                                    case MediaPlayer.MEDIA_PLAYER_OPTION_RANGE_MODE /* 258 */:
                                        Contract.b builder4 = (this.bitField0_ & 256) == 256 ? this.contract_.toBuilder() : null;
                                        Contract contract = (Contract) eVar.u(Contract.PARSER, fVar);
                                        this.contract_ = contract;
                                        if (builder4 != null) {
                                            builder4.h(contract);
                                            this.contract_ = builder4.l();
                                        }
                                        this.bitField0_ |= 256;
                                        continue;
                                    default:
                                        r5 = parseUnknownField(eVar, J, fVar, K);
                                        if (r5 == 0) {
                                            break;
                                        } else {
                                            continue;
                                        }
                                }
                                z3 = true;
                            } catch (InvalidProtocolBufferException e4) {
                                throw e4.setUnfinishedMessage(this);
                            }
                        } catch (IOException e5) {
                            throw new InvalidProtocolBufferException(e5.getMessage()).setUnfinishedMessage(this);
                        }
                    } catch (Throwable th) {
                        if (z4 & true) {
                            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                        }
                        if (z4 & true) {
                            this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                        }
                        if ((z4 & true) == r5) {
                            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                        }
                        try {
                            J.I();
                        } catch (IOException unused) {
                        } catch (Throwable th2) {
                            this.unknownFields = u3.g();
                            throw th2;
                        }
                        this.unknownFields = u3.g();
                        makeExtensionsImmutable();
                        throw th;
                    }
                } else {
                    if (z4 & true) {
                        this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    }
                    if (z4 & true) {
                        this.valueParameter_ = Collections.unmodifiableList(this.valueParameter_);
                    }
                    if (z4 & true) {
                        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                    }
                    try {
                        J.I();
                    } catch (IOException unused2) {
                    } catch (Throwable th3) {
                        this.unknownFields = u3.g();
                        throw th3;
                    }
                    this.unknownFields = u3.g();
                    makeExtensionsImmutable();
                    return;
                }
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public enum MemberKind implements h.a {
        DECLARATION(0, 0),
        FAKE_OVERRIDE(1, 1),
        DELEGATION(2, 2),
        SYNTHESIZED(3, 3);
        
        private static h.b<MemberKind> internalValueMap = new a();
        private final int value;

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static class a implements h.b<MemberKind> {
            a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
            /* renamed from: b */
            public MemberKind a(int i4) {
                return MemberKind.valueOf(i4);
            }
        }

        MemberKind(int i4, int i5) {
            this.value = i5;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.a
        public final int getNumber() {
            return this.value;
        }

        public static MemberKind valueOf(int i4) {
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            return null;
                        }
                        return SYNTHESIZED;
                    }
                    return DELEGATION;
                }
                return FAKE_OVERRIDE;
            }
            return DECLARATION;
        }
    }

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public enum Modality implements h.a {
        FINAL(0, 0),
        OPEN(1, 1),
        ABSTRACT(2, 2),
        SEALED(3, 3);
        
        private static h.b<Modality> internalValueMap = new a();
        private final int value;

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static class a implements h.b<Modality> {
            a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
            /* renamed from: b */
            public Modality a(int i4) {
                return Modality.valueOf(i4);
            }
        }

        Modality(int i4, int i5) {
            this.value = i5;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.a
        public final int getNumber() {
            return this.value;
        }

        public static Modality valueOf(int i4) {
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            return null;
                        }
                        return SEALED;
                    }
                    return ABSTRACT;
                }
                return OPEN;
            }
            return FINAL;
        }
    }

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class Package extends GeneratedMessageLite.ExtendableMessage<Package> implements l {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<Package> PARSER = new a();
        private static final Package defaultInstance;
        private int bitField0_;
        private List<Function> function_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<Property> property_;
        private List<TypeAlias> typeAlias_;
        private TypeTable typeTable_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;
        private VersionRequirementTable versionRequirementTable_;

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<Package> {
            a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
            /* renamed from: m */
            public Package c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                return new Package(eVar, fVar);
            }
        }

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class b extends GeneratedMessageLite.c<Package, b> implements l {

            /* renamed from: d  reason: collision with root package name */
            private int f57357d;

            /* renamed from: e  reason: collision with root package name */
            private List<Function> f57358e = Collections.emptyList();

            /* renamed from: f  reason: collision with root package name */
            private List<Property> f57359f = Collections.emptyList();

            /* renamed from: g  reason: collision with root package name */
            private List<TypeAlias> f57360g = Collections.emptyList();

            /* renamed from: h  reason: collision with root package name */
            private TypeTable f57361h = TypeTable.getDefaultInstance();

            /* renamed from: i  reason: collision with root package name */
            private VersionRequirementTable f57362i = VersionRequirementTable.getDefaultInstance();

            private b() {
                H();
            }

            private void H() {
            }

            static /* synthetic */ b p() {
                return t();
            }

            private static b t() {
                return new b();
            }

            private void u() {
                if ((this.f57357d & 1) != 1) {
                    this.f57358e = new ArrayList(this.f57358e);
                    this.f57357d |= 1;
                }
            }

            private void v() {
                if ((this.f57357d & 2) != 2) {
                    this.f57359f = new ArrayList(this.f57359f);
                    this.f57357d |= 2;
                }
            }

            private void x() {
                if ((this.f57357d & 4) != 4) {
                    this.f57360g = new ArrayList(this.f57360g);
                    this.f57357d |= 4;
                }
            }

            public int A() {
                return this.f57358e.size();
            }

            public Property B(int i4) {
                return this.f57359f.get(i4);
            }

            public int C() {
                return this.f57359f.size();
            }

            public TypeAlias D(int i4) {
                return this.f57360g.get(i4);
            }

            public int E() {
                return this.f57360g.size();
            }

            public TypeTable F() {
                return this.f57361h;
            }

            public boolean G() {
                return (this.f57357d & 8) == 8;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: I */
            public b h(Package r3) {
                if (r3 == Package.getDefaultInstance()) {
                    return this;
                }
                if (!r3.function_.isEmpty()) {
                    if (this.f57358e.isEmpty()) {
                        this.f57358e = r3.function_;
                        this.f57357d &= -2;
                    } else {
                        u();
                        this.f57358e.addAll(r3.function_);
                    }
                }
                if (!r3.property_.isEmpty()) {
                    if (this.f57359f.isEmpty()) {
                        this.f57359f = r3.property_;
                        this.f57357d &= -3;
                    } else {
                        v();
                        this.f57359f.addAll(r3.property_);
                    }
                }
                if (!r3.typeAlias_.isEmpty()) {
                    if (this.f57360g.isEmpty()) {
                        this.f57360g = r3.typeAlias_;
                        this.f57357d &= -5;
                    } else {
                        x();
                        this.f57360g.addAll(r3.typeAlias_);
                    }
                }
                if (r3.hasTypeTable()) {
                    K(r3.getTypeTable());
                }
                if (r3.hasVersionRequirementTable()) {
                    L(r3.getVersionRequirementTable());
                }
                o(r3);
                i(f().c(r3.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC1158a, kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: J */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package.b g(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.h(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1b
                L11:
                    r3 = move-exception
                    kotlin.reflect.jvm.internal.impl.protobuf.n r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> Lf
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package) r4     // Catch: java.lang.Throwable -> Lf
                    throw r3     // Catch: java.lang.Throwable -> L19
                L19:
                    r3 = move-exception
                    r0 = r4
                L1b:
                    if (r0 == 0) goto L20
                    r2.h(r0)
                L20:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Package.b.g(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package$b");
            }

            public b K(TypeTable typeTable) {
                if ((this.f57357d & 8) == 8 && this.f57361h != TypeTable.getDefaultInstance()) {
                    this.f57361h = TypeTable.newBuilder(this.f57361h).h(typeTable).l();
                } else {
                    this.f57361h = typeTable;
                }
                this.f57357d |= 8;
                return this;
            }

            public b L(VersionRequirementTable versionRequirementTable) {
                if ((this.f57357d & 16) == 16 && this.f57362i != VersionRequirementTable.getDefaultInstance()) {
                    this.f57362i = VersionRequirementTable.newBuilder(this.f57362i).h(versionRequirementTable).l();
                } else {
                    this.f57362i = versionRequirementTable;
                }
                this.f57357d |= 16;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public final boolean isInitialized() {
                for (int i4 = 0; i4 < A(); i4++) {
                    if (!z(i4).isInitialized()) {
                        return false;
                    }
                }
                for (int i5 = 0; i5 < C(); i5++) {
                    if (!B(i5).isInitialized()) {
                        return false;
                    }
                }
                for (int i6 = 0; i6 < E(); i6++) {
                    if (!D(i6).isInitialized()) {
                        return false;
                    }
                }
                return (!G() || F().isInitialized()) && n();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: q */
            public Package build() {
                Package r3 = r();
                if (r3.isInitialized()) {
                    return r3;
                }
                throw a.AbstractC1158a.c(r3);
            }

            public Package r() {
                Package r02 = new Package(this);
                int i4 = this.f57357d;
                if ((i4 & 1) == 1) {
                    this.f57358e = Collections.unmodifiableList(this.f57358e);
                    this.f57357d &= -2;
                }
                r02.function_ = this.f57358e;
                if ((this.f57357d & 2) == 2) {
                    this.f57359f = Collections.unmodifiableList(this.f57359f);
                    this.f57357d &= -3;
                }
                r02.property_ = this.f57359f;
                if ((this.f57357d & 4) == 4) {
                    this.f57360g = Collections.unmodifiableList(this.f57360g);
                    this.f57357d &= -5;
                }
                r02.typeAlias_ = this.f57360g;
                int i5 = (i4 & 8) != 8 ? 0 : 1;
                r02.typeTable_ = this.f57361h;
                if ((i4 & 16) == 16) {
                    i5 |= 2;
                }
                r02.versionRequirementTable_ = this.f57362i;
                r02.bitField0_ = i5;
                return r02;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.c
            /* renamed from: s */
            public b l() {
                return t().h(r());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, kotlin.reflect.jvm.internal.impl.protobuf.o
            /* renamed from: y */
            public Package getDefaultInstanceForType() {
                return Package.getDefaultInstance();
            }

            public Function z(int i4) {
                return this.f57358e.get(i4);
            }
        }

        static {
            Package r02 = new Package(true);
            defaultInstance = r02;
            r02.initFields();
        }

        public static Package getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.function_ = Collections.emptyList();
            this.property_ = Collections.emptyList();
            this.typeAlias_ = Collections.emptyList();
            this.typeTable_ = TypeTable.getDefaultInstance();
            this.versionRequirementTable_ = VersionRequirementTable.getDefaultInstance();
        }

        public static b newBuilder() {
            return b.p();
        }

        public static Package parseFrom(InputStream inputStream, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws IOException {
            return PARSER.a(inputStream, fVar);
        }

        public Function getFunction(int i4) {
            return this.function_.get(i4);
        }

        public int getFunctionCount() {
            return this.function_.size();
        }

        public List<Function> getFunctionList() {
            return this.function_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
        public kotlin.reflect.jvm.internal.impl.protobuf.p<Package> getParserForType() {
            return PARSER;
        }

        public Property getProperty(int i4) {
            return this.property_.get(i4);
        }

        public int getPropertyCount() {
            return this.property_.size();
        }

        public List<Property> getPropertyList() {
            return this.property_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public int getSerializedSize() {
            int i4 = this.memoizedSerializedSize;
            if (i4 != -1) {
                return i4;
            }
            int i5 = 0;
            for (int i6 = 0; i6 < this.function_.size(); i6++) {
                i5 += CodedOutputStream.s(3, this.function_.get(i6));
            }
            for (int i7 = 0; i7 < this.property_.size(); i7++) {
                i5 += CodedOutputStream.s(4, this.property_.get(i7));
            }
            for (int i8 = 0; i8 < this.typeAlias_.size(); i8++) {
                i5 += CodedOutputStream.s(5, this.typeAlias_.get(i8));
            }
            if ((this.bitField0_ & 1) == 1) {
                i5 += CodedOutputStream.s(30, this.typeTable_);
            }
            if ((this.bitField0_ & 2) == 2) {
                i5 += CodedOutputStream.s(32, this.versionRequirementTable_);
            }
            int extensionsSerializedSize = i5 + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public TypeAlias getTypeAlias(int i4) {
            return this.typeAlias_.get(i4);
        }

        public int getTypeAliasCount() {
            return this.typeAlias_.size();
        }

        public List<TypeAlias> getTypeAliasList() {
            return this.typeAlias_;
        }

        public TypeTable getTypeTable() {
            return this.typeTable_;
        }

        public VersionRequirementTable getVersionRequirementTable() {
            return this.versionRequirementTable_;
        }

        public boolean hasTypeTable() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasVersionRequirementTable() {
            return (this.bitField0_ & 2) == 2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public final boolean isInitialized() {
            byte b4 = this.memoizedIsInitialized;
            if (b4 == 1) {
                return true;
            }
            if (b4 == 0) {
                return false;
            }
            for (int i4 = 0; i4 < getFunctionCount(); i4++) {
                if (!getFunction(i4).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i5 = 0; i5 < getPropertyCount(); i5++) {
                if (!getProperty(i5).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            for (int i6 = 0; i6 < getTypeAliasCount(); i6++) {
                if (!getTypeAlias(i6).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasTypeTable() && !getTypeTable().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (!extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.a newExtensionWriter = newExtensionWriter();
            for (int i4 = 0; i4 < this.function_.size(); i4++) {
                codedOutputStream.d0(3, this.function_.get(i4));
            }
            for (int i5 = 0; i5 < this.property_.size(); i5++) {
                codedOutputStream.d0(4, this.property_.get(i5));
            }
            for (int i6 = 0; i6 < this.typeAlias_.size(); i6++) {
                codedOutputStream.d0(5, this.typeAlias_.get(i6));
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.d0(30, this.typeTable_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.d0(32, this.versionRequirementTable_);
            }
            newExtensionWriter.a(200, codedOutputStream);
            codedOutputStream.i0(this.unknownFields);
        }

        public static b newBuilder(Package r12) {
            return newBuilder().h(r12);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public Package getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b toBuilder() {
            return newBuilder(this);
        }

        private Package(GeneratedMessageLite.c<Package, ?> cVar) {
            super(cVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = cVar.f();
        }

        private Package(boolean z3) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f57629a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Package(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            d.b u3 = kotlin.reflect.jvm.internal.impl.protobuf.d.u();
            CodedOutputStream J = CodedOutputStream.J(u3, 1);
            boolean z3 = false;
            boolean z4 = false;
            while (!z3) {
                try {
                    try {
                        try {
                            int K = eVar.K();
                            if (K != 0) {
                                if (K == 26) {
                                    if (!(z4 & true)) {
                                        this.function_ = new ArrayList();
                                        z4 |= true;
                                    }
                                    this.function_.add(eVar.u(Function.PARSER, fVar));
                                } else if (K == 34) {
                                    if (!(z4 & true)) {
                                        this.property_ = new ArrayList();
                                        z4 |= true;
                                    }
                                    this.property_.add(eVar.u(Property.PARSER, fVar));
                                } else if (K != 42) {
                                    if (K == 242) {
                                        TypeTable.b builder = (this.bitField0_ & 1) == 1 ? this.typeTable_.toBuilder() : null;
                                        TypeTable typeTable = (TypeTable) eVar.u(TypeTable.PARSER, fVar);
                                        this.typeTable_ = typeTable;
                                        if (builder != null) {
                                            builder.h(typeTable);
                                            this.typeTable_ = builder.l();
                                        }
                                        this.bitField0_ |= 1;
                                    } else if (K != 258) {
                                        if (!parseUnknownField(eVar, J, fVar, K)) {
                                        }
                                    } else {
                                        VersionRequirementTable.b builder2 = (this.bitField0_ & 2) == 2 ? this.versionRequirementTable_.toBuilder() : null;
                                        VersionRequirementTable versionRequirementTable = (VersionRequirementTable) eVar.u(VersionRequirementTable.PARSER, fVar);
                                        this.versionRequirementTable_ = versionRequirementTable;
                                        if (builder2 != null) {
                                            builder2.h(versionRequirementTable);
                                            this.versionRequirementTable_ = builder2.l();
                                        }
                                        this.bitField0_ |= 2;
                                    }
                                } else {
                                    if (!(z4 & true)) {
                                        this.typeAlias_ = new ArrayList();
                                        z4 |= true;
                                    }
                                    this.typeAlias_.add(eVar.u(TypeAlias.PARSER, fVar));
                                }
                            }
                            z3 = true;
                        } catch (IOException e4) {
                            throw new InvalidProtocolBufferException(e4.getMessage()).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e5) {
                        throw e5.setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    if (z4 & true) {
                        this.function_ = Collections.unmodifiableList(this.function_);
                    }
                    if (z4 & true) {
                        this.property_ = Collections.unmodifiableList(this.property_);
                    }
                    if (z4 & true) {
                        this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
                    }
                    try {
                        J.I();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.unknownFields = u3.g();
                        throw th2;
                    }
                    this.unknownFields = u3.g();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z4 & true) {
                this.function_ = Collections.unmodifiableList(this.function_);
            }
            if (z4 & true) {
                this.property_ = Collections.unmodifiableList(this.property_);
            }
            if (z4 & true) {
                this.typeAlias_ = Collections.unmodifiableList(this.typeAlias_);
            }
            try {
                J.I();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.unknownFields = u3.g();
                throw th3;
            }
            this.unknownFields = u3.g();
            makeExtensionsImmutable();
        }
    }

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class PackageFragment extends GeneratedMessageLite.ExtendableMessage<PackageFragment> implements k {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<PackageFragment> PARSER = new a();
        private static final PackageFragment defaultInstance;
        private int bitField0_;
        private List<Class> class__;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private Package package_;
        private QualifiedNameTable qualifiedNames_;
        private StringTable strings_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<PackageFragment> {
            a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
            /* renamed from: m */
            public PackageFragment c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                return new PackageFragment(eVar, fVar);
            }
        }

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class b extends GeneratedMessageLite.c<PackageFragment, b> implements k {

            /* renamed from: d  reason: collision with root package name */
            private int f57363d;

            /* renamed from: e  reason: collision with root package name */
            private StringTable f57364e = StringTable.getDefaultInstance();

            /* renamed from: f  reason: collision with root package name */
            private QualifiedNameTable f57365f = QualifiedNameTable.getDefaultInstance();

            /* renamed from: g  reason: collision with root package name */
            private Package f57366g = Package.getDefaultInstance();

            /* renamed from: h  reason: collision with root package name */
            private List<Class> f57367h = Collections.emptyList();

            private b() {
                D();
            }

            private void D() {
            }

            static /* synthetic */ b p() {
                return t();
            }

            private static b t() {
                return new b();
            }

            private void u() {
                if ((this.f57363d & 8) != 8) {
                    this.f57367h = new ArrayList(this.f57367h);
                    this.f57363d |= 8;
                }
            }

            public QualifiedNameTable A() {
                return this.f57365f;
            }

            public boolean B() {
                return (this.f57363d & 4) == 4;
            }

            public boolean C() {
                return (this.f57363d & 2) == 2;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: E */
            public b h(PackageFragment packageFragment) {
                if (packageFragment == PackageFragment.getDefaultInstance()) {
                    return this;
                }
                if (packageFragment.hasStrings()) {
                    I(packageFragment.getStrings());
                }
                if (packageFragment.hasQualifiedNames()) {
                    H(packageFragment.getQualifiedNames());
                }
                if (packageFragment.hasPackage()) {
                    G(packageFragment.getPackage());
                }
                if (!packageFragment.class__.isEmpty()) {
                    if (this.f57367h.isEmpty()) {
                        this.f57367h = packageFragment.class__;
                        this.f57363d &= -9;
                    } else {
                        u();
                        this.f57367h.addAll(packageFragment.class__);
                    }
                }
                o(packageFragment);
                i(f().c(packageFragment.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC1158a, kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: F */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.PackageFragment.b g(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.PackageFragment.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.PackageFragment) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.h(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1b
                L11:
                    r3 = move-exception
                    kotlin.reflect.jvm.internal.impl.protobuf.n r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> Lf
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.PackageFragment) r4     // Catch: java.lang.Throwable -> Lf
                    throw r3     // Catch: java.lang.Throwable -> L19
                L19:
                    r3 = move-exception
                    r0 = r4
                L1b:
                    if (r0 == 0) goto L20
                    r2.h(r0)
                L20:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.PackageFragment.b.g(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment$b");
            }

            public b G(Package r4) {
                if ((this.f57363d & 4) == 4 && this.f57366g != Package.getDefaultInstance()) {
                    this.f57366g = Package.newBuilder(this.f57366g).h(r4).r();
                } else {
                    this.f57366g = r4;
                }
                this.f57363d |= 4;
                return this;
            }

            public b H(QualifiedNameTable qualifiedNameTable) {
                if ((this.f57363d & 2) == 2 && this.f57365f != QualifiedNameTable.getDefaultInstance()) {
                    this.f57365f = QualifiedNameTable.newBuilder(this.f57365f).h(qualifiedNameTable).l();
                } else {
                    this.f57365f = qualifiedNameTable;
                }
                this.f57363d |= 2;
                return this;
            }

            public b I(StringTable stringTable) {
                if ((this.f57363d & 1) == 1 && this.f57364e != StringTable.getDefaultInstance()) {
                    this.f57364e = StringTable.newBuilder(this.f57364e).h(stringTable).l();
                } else {
                    this.f57364e = stringTable;
                }
                this.f57363d |= 1;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public final boolean isInitialized() {
                if (!C() || A().isInitialized()) {
                    if (!B() || z().isInitialized()) {
                        for (int i4 = 0; i4 < x(); i4++) {
                            if (!v(i4).isInitialized()) {
                                return false;
                            }
                        }
                        return n();
                    }
                    return false;
                }
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: q */
            public PackageFragment build() {
                PackageFragment r3 = r();
                if (r3.isInitialized()) {
                    return r3;
                }
                throw a.AbstractC1158a.c(r3);
            }

            public PackageFragment r() {
                PackageFragment packageFragment = new PackageFragment(this);
                int i4 = this.f57363d;
                int i5 = (i4 & 1) != 1 ? 0 : 1;
                packageFragment.strings_ = this.f57364e;
                if ((i4 & 2) == 2) {
                    i5 |= 2;
                }
                packageFragment.qualifiedNames_ = this.f57365f;
                if ((i4 & 4) == 4) {
                    i5 |= 4;
                }
                packageFragment.package_ = this.f57366g;
                if ((this.f57363d & 8) == 8) {
                    this.f57367h = Collections.unmodifiableList(this.f57367h);
                    this.f57363d &= -9;
                }
                packageFragment.class__ = this.f57367h;
                packageFragment.bitField0_ = i5;
                return packageFragment;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.c
            /* renamed from: s */
            public b l() {
                return t().h(r());
            }

            public Class v(int i4) {
                return this.f57367h.get(i4);
            }

            public int x() {
                return this.f57367h.size();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, kotlin.reflect.jvm.internal.impl.protobuf.o
            /* renamed from: y */
            public PackageFragment getDefaultInstanceForType() {
                return PackageFragment.getDefaultInstance();
            }

            public Package z() {
                return this.f57366g;
            }
        }

        static {
            PackageFragment packageFragment = new PackageFragment(true);
            defaultInstance = packageFragment;
            packageFragment.initFields();
        }

        public static PackageFragment getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.strings_ = StringTable.getDefaultInstance();
            this.qualifiedNames_ = QualifiedNameTable.getDefaultInstance();
            this.package_ = Package.getDefaultInstance();
            this.class__ = Collections.emptyList();
        }

        public static b newBuilder() {
            return b.p();
        }

        public static PackageFragment parseFrom(InputStream inputStream, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws IOException {
            return PARSER.a(inputStream, fVar);
        }

        public Class getClass_(int i4) {
            return this.class__.get(i4);
        }

        public int getClass_Count() {
            return this.class__.size();
        }

        public List<Class> getClass_List() {
            return this.class__;
        }

        public Package getPackage() {
            return this.package_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
        public kotlin.reflect.jvm.internal.impl.protobuf.p<PackageFragment> getParserForType() {
            return PARSER;
        }

        public QualifiedNameTable getQualifiedNames() {
            return this.qualifiedNames_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public int getSerializedSize() {
            int i4 = this.memoizedSerializedSize;
            if (i4 != -1) {
                return i4;
            }
            int s3 = (this.bitField0_ & 1) == 1 ? CodedOutputStream.s(1, this.strings_) + 0 : 0;
            if ((this.bitField0_ & 2) == 2) {
                s3 += CodedOutputStream.s(2, this.qualifiedNames_);
            }
            if ((this.bitField0_ & 4) == 4) {
                s3 += CodedOutputStream.s(3, this.package_);
            }
            for (int i5 = 0; i5 < this.class__.size(); i5++) {
                s3 += CodedOutputStream.s(4, this.class__.get(i5));
            }
            int extensionsSerializedSize = s3 + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public StringTable getStrings() {
            return this.strings_;
        }

        public boolean hasPackage() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasQualifiedNames() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasStrings() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public final boolean isInitialized() {
            byte b4 = this.memoizedIsInitialized;
            if (b4 == 1) {
                return true;
            }
            if (b4 == 0) {
                return false;
            }
            if (hasQualifiedNames() && !getQualifiedNames().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (hasPackage() && !getPackage().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else {
                for (int i4 = 0; i4 < getClass_Count(); i4++) {
                    if (!getClass_(i4).isInitialized()) {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                if (!extensionsAreInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.a newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.d0(1, this.strings_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.d0(2, this.qualifiedNames_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.d0(3, this.package_);
            }
            for (int i4 = 0; i4 < this.class__.size(); i4++) {
                codedOutputStream.d0(4, this.class__.get(i4));
            }
            newExtensionWriter.a(200, codedOutputStream);
            codedOutputStream.i0(this.unknownFields);
        }

        public static b newBuilder(PackageFragment packageFragment) {
            return newBuilder().h(packageFragment);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public PackageFragment getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b toBuilder() {
            return newBuilder(this);
        }

        private PackageFragment(GeneratedMessageLite.c<PackageFragment, ?> cVar) {
            super(cVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = cVar.f();
        }

        private PackageFragment(boolean z3) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f57629a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private PackageFragment(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            d.b u3 = kotlin.reflect.jvm.internal.impl.protobuf.d.u();
            CodedOutputStream J = CodedOutputStream.J(u3, 1);
            boolean z3 = false;
            boolean z4 = false;
            while (!z3) {
                try {
                    try {
                        try {
                            int K = eVar.K();
                            if (K != 0) {
                                if (K == 10) {
                                    StringTable.b builder = (this.bitField0_ & 1) == 1 ? this.strings_.toBuilder() : null;
                                    StringTable stringTable = (StringTable) eVar.u(StringTable.PARSER, fVar);
                                    this.strings_ = stringTable;
                                    if (builder != null) {
                                        builder.h(stringTable);
                                        this.strings_ = builder.l();
                                    }
                                    this.bitField0_ |= 1;
                                } else if (K == 18) {
                                    QualifiedNameTable.b builder2 = (this.bitField0_ & 2) == 2 ? this.qualifiedNames_.toBuilder() : null;
                                    QualifiedNameTable qualifiedNameTable = (QualifiedNameTable) eVar.u(QualifiedNameTable.PARSER, fVar);
                                    this.qualifiedNames_ = qualifiedNameTable;
                                    if (builder2 != null) {
                                        builder2.h(qualifiedNameTable);
                                        this.qualifiedNames_ = builder2.l();
                                    }
                                    this.bitField0_ |= 2;
                                } else if (K == 26) {
                                    Package.b builder3 = (this.bitField0_ & 4) == 4 ? this.package_.toBuilder() : null;
                                    Package r6 = (Package) eVar.u(Package.PARSER, fVar);
                                    this.package_ = r6;
                                    if (builder3 != null) {
                                        builder3.h(r6);
                                        this.package_ = builder3.r();
                                    }
                                    this.bitField0_ |= 4;
                                } else if (K != 34) {
                                    if (!parseUnknownField(eVar, J, fVar, K)) {
                                    }
                                } else {
                                    if (!(z4 & true)) {
                                        this.class__ = new ArrayList();
                                        z4 |= true;
                                    }
                                    this.class__.add(eVar.u(Class.PARSER, fVar));
                                }
                            }
                            z3 = true;
                        } catch (InvalidProtocolBufferException e4) {
                            throw e4.setUnfinishedMessage(this);
                        }
                    } catch (IOException e5) {
                        throw new InvalidProtocolBufferException(e5.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    if (z4 & true) {
                        this.class__ = Collections.unmodifiableList(this.class__);
                    }
                    try {
                        J.I();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.unknownFields = u3.g();
                        throw th2;
                    }
                    this.unknownFields = u3.g();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z4 & true) {
                this.class__ = Collections.unmodifiableList(this.class__);
            }
            try {
                J.I();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.unknownFields = u3.g();
                throw th3;
            }
            this.unknownFields = u3.g();
            makeExtensionsImmutable();
        }
    }

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class Property extends GeneratedMessageLite.ExtendableMessage<Property> implements m {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<Property> PARSER = new a();
        private static final Property defaultInstance;
        private int bitField0_;
        private int flags_;
        private int getterFlags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private int oldFlags_;
        private int receiverTypeId_;
        private Type receiverType_;
        private int returnTypeId_;
        private Type returnType_;
        private int setterFlags_;
        private ValueParameter setterValueParameter_;
        private List<TypeParameter> typeParameter_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;
        private List<Integer> versionRequirement_;

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<Property> {
            a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
            /* renamed from: m */
            public Property c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                return new Property(eVar, fVar);
            }
        }

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class b extends GeneratedMessageLite.c<Property, b> implements m {

            /* renamed from: d  reason: collision with root package name */
            private int f57368d;

            /* renamed from: g  reason: collision with root package name */
            private int f57371g;

            /* renamed from: i  reason: collision with root package name */
            private int f57373i;

            /* renamed from: l  reason: collision with root package name */
            private int f57376l;

            /* renamed from: n  reason: collision with root package name */
            private int f57378n;

            /* renamed from: o  reason: collision with root package name */
            private int f57379o;

            /* renamed from: e  reason: collision with root package name */
            private int f57369e = MediaPlayer.MEDIA_PLAYER_OPTION_TCP_FAST_OPEN_SUCCESS;

            /* renamed from: f  reason: collision with root package name */
            private int f57370f = 2054;

            /* renamed from: h  reason: collision with root package name */
            private Type f57372h = Type.getDefaultInstance();

            /* renamed from: j  reason: collision with root package name */
            private List<TypeParameter> f57374j = Collections.emptyList();

            /* renamed from: k  reason: collision with root package name */
            private Type f57375k = Type.getDefaultInstance();

            /* renamed from: m  reason: collision with root package name */
            private ValueParameter f57377m = ValueParameter.getDefaultInstance();

            /* renamed from: p  reason: collision with root package name */
            private List<Integer> f57380p = Collections.emptyList();

            private b() {
                H();
            }

            private void H() {
            }

            static /* synthetic */ b p() {
                return t();
            }

            private static b t() {
                return new b();
            }

            private void u() {
                if ((this.f57368d & 32) != 32) {
                    this.f57374j = new ArrayList(this.f57374j);
                    this.f57368d |= 32;
                }
            }

            private void v() {
                if ((this.f57368d & 2048) != 2048) {
                    this.f57380p = new ArrayList(this.f57380p);
                    this.f57368d |= 2048;
                }
            }

            public ValueParameter A() {
                return this.f57377m;
            }

            public TypeParameter B(int i4) {
                return this.f57374j.get(i4);
            }

            public int C() {
                return this.f57374j.size();
            }

            public boolean D() {
                return (this.f57368d & 4) == 4;
            }

            public boolean E() {
                return (this.f57368d & 64) == 64;
            }

            public boolean F() {
                return (this.f57368d & 8) == 8;
            }

            public boolean G() {
                return (this.f57368d & 256) == 256;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: I */
            public b h(Property property) {
                if (property == Property.getDefaultInstance()) {
                    return this;
                }
                if (property.hasFlags()) {
                    N(property.getFlags());
                }
                if (property.hasOldFlags()) {
                    Q(property.getOldFlags());
                }
                if (property.hasName()) {
                    P(property.getName());
                }
                if (property.hasReturnType()) {
                    L(property.getReturnType());
                }
                if (property.hasReturnTypeId()) {
                    S(property.getReturnTypeId());
                }
                if (!property.typeParameter_.isEmpty()) {
                    if (this.f57374j.isEmpty()) {
                        this.f57374j = property.typeParameter_;
                        this.f57368d &= -33;
                    } else {
                        u();
                        this.f57374j.addAll(property.typeParameter_);
                    }
                }
                if (property.hasReceiverType()) {
                    K(property.getReceiverType());
                }
                if (property.hasReceiverTypeId()) {
                    R(property.getReceiverTypeId());
                }
                if (property.hasSetterValueParameter()) {
                    M(property.getSetterValueParameter());
                }
                if (property.hasGetterFlags()) {
                    O(property.getGetterFlags());
                }
                if (property.hasSetterFlags()) {
                    T(property.getSetterFlags());
                }
                if (!property.versionRequirement_.isEmpty()) {
                    if (this.f57380p.isEmpty()) {
                        this.f57380p = property.versionRequirement_;
                        this.f57368d &= -2049;
                    } else {
                        v();
                        this.f57380p.addAll(property.versionRequirement_);
                    }
                }
                o(property);
                i(f().c(property.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC1158a, kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: J */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property.b g(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.h(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1b
                L11:
                    r3 = move-exception
                    kotlin.reflect.jvm.internal.impl.protobuf.n r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> Lf
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property) r4     // Catch: java.lang.Throwable -> Lf
                    throw r3     // Catch: java.lang.Throwable -> L19
                L19:
                    r3 = move-exception
                    r0 = r4
                L1b:
                    if (r0 == 0) goto L20
                    r2.h(r0)
                L20:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Property.b.g(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property$b");
            }

            public b K(Type type) {
                if ((this.f57368d & 64) == 64 && this.f57375k != Type.getDefaultInstance()) {
                    this.f57375k = Type.newBuilder(this.f57375k).h(type).r();
                } else {
                    this.f57375k = type;
                }
                this.f57368d |= 64;
                return this;
            }

            public b L(Type type) {
                if ((this.f57368d & 8) == 8 && this.f57372h != Type.getDefaultInstance()) {
                    this.f57372h = Type.newBuilder(this.f57372h).h(type).r();
                } else {
                    this.f57372h = type;
                }
                this.f57368d |= 8;
                return this;
            }

            public b M(ValueParameter valueParameter) {
                if ((this.f57368d & 256) == 256 && this.f57377m != ValueParameter.getDefaultInstance()) {
                    this.f57377m = ValueParameter.newBuilder(this.f57377m).h(valueParameter).r();
                } else {
                    this.f57377m = valueParameter;
                }
                this.f57368d |= 256;
                return this;
            }

            public b N(int i4) {
                this.f57368d |= 1;
                this.f57369e = i4;
                return this;
            }

            public b O(int i4) {
                this.f57368d |= 512;
                this.f57378n = i4;
                return this;
            }

            public b P(int i4) {
                this.f57368d |= 4;
                this.f57371g = i4;
                return this;
            }

            public b Q(int i4) {
                this.f57368d |= 2;
                this.f57370f = i4;
                return this;
            }

            public b R(int i4) {
                this.f57368d |= 128;
                this.f57376l = i4;
                return this;
            }

            public b S(int i4) {
                this.f57368d |= 16;
                this.f57373i = i4;
                return this;
            }

            public b T(int i4) {
                this.f57368d |= 1024;
                this.f57379o = i4;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public final boolean isInitialized() {
                if (D()) {
                    if (!F() || z().isInitialized()) {
                        for (int i4 = 0; i4 < C(); i4++) {
                            if (!B(i4).isInitialized()) {
                                return false;
                            }
                        }
                        if (!E() || y().isInitialized()) {
                            return (!G() || A().isInitialized()) && n();
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: q */
            public Property build() {
                Property r3 = r();
                if (r3.isInitialized()) {
                    return r3;
                }
                throw a.AbstractC1158a.c(r3);
            }

            public Property r() {
                Property property = new Property(this);
                int i4 = this.f57368d;
                int i5 = (i4 & 1) != 1 ? 0 : 1;
                property.flags_ = this.f57369e;
                if ((i4 & 2) == 2) {
                    i5 |= 2;
                }
                property.oldFlags_ = this.f57370f;
                if ((i4 & 4) == 4) {
                    i5 |= 4;
                }
                property.name_ = this.f57371g;
                if ((i4 & 8) == 8) {
                    i5 |= 8;
                }
                property.returnType_ = this.f57372h;
                if ((i4 & 16) == 16) {
                    i5 |= 16;
                }
                property.returnTypeId_ = this.f57373i;
                if ((this.f57368d & 32) == 32) {
                    this.f57374j = Collections.unmodifiableList(this.f57374j);
                    this.f57368d &= -33;
                }
                property.typeParameter_ = this.f57374j;
                if ((i4 & 64) == 64) {
                    i5 |= 32;
                }
                property.receiverType_ = this.f57375k;
                if ((i4 & 128) == 128) {
                    i5 |= 64;
                }
                property.receiverTypeId_ = this.f57376l;
                if ((i4 & 256) == 256) {
                    i5 |= 128;
                }
                property.setterValueParameter_ = this.f57377m;
                if ((i4 & 512) == 512) {
                    i5 |= 256;
                }
                property.getterFlags_ = this.f57378n;
                if ((i4 & 1024) == 1024) {
                    i5 |= 512;
                }
                property.setterFlags_ = this.f57379o;
                if ((this.f57368d & 2048) == 2048) {
                    this.f57380p = Collections.unmodifiableList(this.f57380p);
                    this.f57368d &= -2049;
                }
                property.versionRequirement_ = this.f57380p;
                property.bitField0_ = i5;
                return property;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.c
            /* renamed from: s */
            public b l() {
                return t().h(r());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, kotlin.reflect.jvm.internal.impl.protobuf.o
            /* renamed from: x */
            public Property getDefaultInstanceForType() {
                return Property.getDefaultInstance();
            }

            public Type y() {
                return this.f57375k;
            }

            public Type z() {
                return this.f57372h;
            }
        }

        static {
            Property property = new Property(true);
            defaultInstance = property;
            property.initFields();
        }

        public static Property getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.flags_ = MediaPlayer.MEDIA_PLAYER_OPTION_TCP_FAST_OPEN_SUCCESS;
            this.oldFlags_ = 2054;
            this.name_ = 0;
            this.returnType_ = Type.getDefaultInstance();
            this.returnTypeId_ = 0;
            this.typeParameter_ = Collections.emptyList();
            this.receiverType_ = Type.getDefaultInstance();
            this.receiverTypeId_ = 0;
            this.setterValueParameter_ = ValueParameter.getDefaultInstance();
            this.getterFlags_ = 0;
            this.setterFlags_ = 0;
            this.versionRequirement_ = Collections.emptyList();
        }

        public static b newBuilder() {
            return b.p();
        }

        public int getFlags() {
            return this.flags_;
        }

        public int getGetterFlags() {
            return this.getterFlags_;
        }

        public int getName() {
            return this.name_;
        }

        public int getOldFlags() {
            return this.oldFlags_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
        public kotlin.reflect.jvm.internal.impl.protobuf.p<Property> getParserForType() {
            return PARSER;
        }

        public Type getReceiverType() {
            return this.receiverType_;
        }

        public int getReceiverTypeId() {
            return this.receiverTypeId_;
        }

        public Type getReturnType() {
            return this.returnType_;
        }

        public int getReturnTypeId() {
            return this.returnTypeId_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public int getSerializedSize() {
            int i4 = this.memoizedSerializedSize;
            if (i4 != -1) {
                return i4;
            }
            int o4 = (this.bitField0_ & 2) == 2 ? CodedOutputStream.o(1, this.oldFlags_) + 0 : 0;
            if ((this.bitField0_ & 4) == 4) {
                o4 += CodedOutputStream.o(2, this.name_);
            }
            if ((this.bitField0_ & 8) == 8) {
                o4 += CodedOutputStream.s(3, this.returnType_);
            }
            for (int i5 = 0; i5 < this.typeParameter_.size(); i5++) {
                o4 += CodedOutputStream.s(4, this.typeParameter_.get(i5));
            }
            if ((this.bitField0_ & 32) == 32) {
                o4 += CodedOutputStream.s(5, this.receiverType_);
            }
            if ((this.bitField0_ & 128) == 128) {
                o4 += CodedOutputStream.s(6, this.setterValueParameter_);
            }
            if ((this.bitField0_ & 256) == 256) {
                o4 += CodedOutputStream.o(7, this.getterFlags_);
            }
            if ((this.bitField0_ & 512) == 512) {
                o4 += CodedOutputStream.o(8, this.setterFlags_);
            }
            if ((this.bitField0_ & 16) == 16) {
                o4 += CodedOutputStream.o(9, this.returnTypeId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                o4 += CodedOutputStream.o(10, this.receiverTypeId_);
            }
            if ((this.bitField0_ & 1) == 1) {
                o4 += CodedOutputStream.o(11, this.flags_);
            }
            int i6 = 0;
            for (int i7 = 0; i7 < this.versionRequirement_.size(); i7++) {
                i6 += CodedOutputStream.p(this.versionRequirement_.get(i7).intValue());
            }
            int size = o4 + i6 + (getVersionRequirementList().size() * 2) + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public int getSetterFlags() {
            return this.setterFlags_;
        }

        public ValueParameter getSetterValueParameter() {
            return this.setterValueParameter_;
        }

        public TypeParameter getTypeParameter(int i4) {
            return this.typeParameter_.get(i4);
        }

        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        public List<TypeParameter> getTypeParameterList() {
            return this.typeParameter_;
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasGetterFlags() {
            return (this.bitField0_ & 256) == 256;
        }

        public boolean hasName() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasOldFlags() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasReceiverType() {
            return (this.bitField0_ & 32) == 32;
        }

        public boolean hasReceiverTypeId() {
            return (this.bitField0_ & 64) == 64;
        }

        public boolean hasReturnType() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasReturnTypeId() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean hasSetterFlags() {
            return (this.bitField0_ & 512) == 512;
        }

        public boolean hasSetterValueParameter() {
            return (this.bitField0_ & 128) == 128;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public final boolean isInitialized() {
            byte b4 = this.memoizedIsInitialized;
            if (b4 == 1) {
                return true;
            }
            if (b4 == 0) {
                return false;
            }
            if (!hasName()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (hasReturnType() && !getReturnType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else {
                for (int i4 = 0; i4 < getTypeParameterCount(); i4++) {
                    if (!getTypeParameter(i4).isInitialized()) {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                if (hasReceiverType() && !getReceiverType().isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                } else if (hasSetterValueParameter() && !getSetterValueParameter().isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                } else if (!extensionsAreInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                } else {
                    this.memoizedIsInitialized = (byte) 1;
                    return true;
                }
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.a newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.a0(1, this.oldFlags_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.a0(2, this.name_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.d0(3, this.returnType_);
            }
            for (int i4 = 0; i4 < this.typeParameter_.size(); i4++) {
                codedOutputStream.d0(4, this.typeParameter_.get(i4));
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.d0(5, this.receiverType_);
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.d0(6, this.setterValueParameter_);
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.a0(7, this.getterFlags_);
            }
            if ((this.bitField0_ & 512) == 512) {
                codedOutputStream.a0(8, this.setterFlags_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.a0(9, this.returnTypeId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.a0(10, this.receiverTypeId_);
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.a0(11, this.flags_);
            }
            for (int i5 = 0; i5 < this.versionRequirement_.size(); i5++) {
                codedOutputStream.a0(31, this.versionRequirement_.get(i5).intValue());
            }
            newExtensionWriter.a(19000, codedOutputStream);
            codedOutputStream.i0(this.unknownFields);
        }

        public static b newBuilder(Property property) {
            return newBuilder().h(property);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public Property getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b toBuilder() {
            return newBuilder(this);
        }

        private Property(GeneratedMessageLite.c<Property, ?> cVar) {
            super(cVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = cVar.f();
        }

        private Property(boolean z3) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f57629a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v0 */
        /* JADX WARN: Type inference failed for: r5v1 */
        /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
        private Property(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            d.b u3 = kotlin.reflect.jvm.internal.impl.protobuf.d.u();
            CodedOutputStream J = CodedOutputStream.J(u3, 1);
            boolean z3 = false;
            boolean z4 = false;
            while (true) {
                ?? r5 = 2048;
                if (!z3) {
                    try {
                        try {
                            try {
                                int K = eVar.K();
                                switch (K) {
                                    case 0:
                                        break;
                                    case 8:
                                        this.bitField0_ |= 2;
                                        this.oldFlags_ = eVar.s();
                                        continue;
                                    case 16:
                                        this.bitField0_ |= 4;
                                        this.name_ = eVar.s();
                                        continue;
                                    case 26:
                                        Type.b builder = (this.bitField0_ & 8) == 8 ? this.returnType_.toBuilder() : null;
                                        Type type = (Type) eVar.u(Type.PARSER, fVar);
                                        this.returnType_ = type;
                                        if (builder != null) {
                                            builder.h(type);
                                            this.returnType_ = builder.r();
                                        }
                                        this.bitField0_ |= 8;
                                        continue;
                                    case 34:
                                        if (!(z4 & true)) {
                                            this.typeParameter_ = new ArrayList();
                                            z4 |= true;
                                        }
                                        this.typeParameter_.add(eVar.u(TypeParameter.PARSER, fVar));
                                        continue;
                                    case 42:
                                        Type.b builder2 = (this.bitField0_ & 32) == 32 ? this.receiverType_.toBuilder() : null;
                                        Type type2 = (Type) eVar.u(Type.PARSER, fVar);
                                        this.receiverType_ = type2;
                                        if (builder2 != null) {
                                            builder2.h(type2);
                                            this.receiverType_ = builder2.r();
                                        }
                                        this.bitField0_ |= 32;
                                        continue;
                                    case 50:
                                        ValueParameter.b builder3 = (this.bitField0_ & 128) == 128 ? this.setterValueParameter_.toBuilder() : null;
                                        ValueParameter valueParameter = (ValueParameter) eVar.u(ValueParameter.PARSER, fVar);
                                        this.setterValueParameter_ = valueParameter;
                                        if (builder3 != null) {
                                            builder3.h(valueParameter);
                                            this.setterValueParameter_ = builder3.r();
                                        }
                                        this.bitField0_ |= 128;
                                        continue;
                                    case 56:
                                        this.bitField0_ |= 256;
                                        this.getterFlags_ = eVar.s();
                                        continue;
                                    case 64:
                                        this.bitField0_ |= 512;
                                        this.setterFlags_ = eVar.s();
                                        continue;
                                    case 72:
                                        this.bitField0_ |= 16;
                                        this.returnTypeId_ = eVar.s();
                                        continue;
                                    case 80:
                                        this.bitField0_ |= 64;
                                        this.receiverTypeId_ = eVar.s();
                                        continue;
                                    case 88:
                                        this.bitField0_ |= 1;
                                        this.flags_ = eVar.s();
                                        continue;
                                    case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT /* 248 */:
                                        if (!(z4 & true)) {
                                            this.versionRequirement_ = new ArrayList();
                                            z4 |= true;
                                        }
                                        this.versionRequirement_.add(Integer.valueOf(eVar.s()));
                                        continue;
                                    case 250:
                                        int j4 = eVar.j(eVar.A());
                                        if (!(z4 & true) && eVar.e() > 0) {
                                            this.versionRequirement_ = new ArrayList();
                                            z4 |= true;
                                        }
                                        while (eVar.e() > 0) {
                                            this.versionRequirement_.add(Integer.valueOf(eVar.s()));
                                        }
                                        eVar.i(j4);
                                        continue;
                                        break;
                                    default:
                                        r5 = parseUnknownField(eVar, J, fVar, K);
                                        if (r5 == 0) {
                                            break;
                                        } else {
                                            continue;
                                        }
                                }
                                z3 = true;
                            } catch (IOException e4) {
                                throw new InvalidProtocolBufferException(e4.getMessage()).setUnfinishedMessage(this);
                            }
                        } catch (InvalidProtocolBufferException e5) {
                            throw e5.setUnfinishedMessage(this);
                        }
                    } catch (Throwable th) {
                        if (z4 & true) {
                            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                        }
                        if ((z4 & true) == r5) {
                            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                        }
                        try {
                            J.I();
                        } catch (IOException unused) {
                        } catch (Throwable th2) {
                            this.unknownFields = u3.g();
                            throw th2;
                        }
                        this.unknownFields = u3.g();
                        makeExtensionsImmutable();
                        throw th;
                    }
                } else {
                    if (z4 & true) {
                        this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    }
                    if (z4 & true) {
                        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                    }
                    try {
                        J.I();
                    } catch (IOException unused2) {
                    } catch (Throwable th3) {
                        this.unknownFields = u3.g();
                        throw th3;
                    }
                    this.unknownFields = u3.g();
                    makeExtensionsImmutable();
                    return;
                }
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class QualifiedNameTable extends GeneratedMessageLite implements o {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<QualifiedNameTable> PARSER = new a();
        private static final QualifiedNameTable defaultInstance;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<QualifiedName> qualifiedName_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class QualifiedName extends GeneratedMessageLite implements n {
            public static kotlin.reflect.jvm.internal.impl.protobuf.p<QualifiedName> PARSER = new a();
            private static final QualifiedName defaultInstance;
            private int bitField0_;
            private Kind kind_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private int parentQualifiedName_;
            private int shortName_;
            private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

            /* loaded from: E:\TSN-r\205dec\7343912.dex */
            public enum Kind implements h.a {
                CLASS(0, 0),
                PACKAGE(1, 1),
                LOCAL(2, 2);
                
                private static h.b<Kind> internalValueMap = new a();
                private final int value;

                /* loaded from: E:\TSN-r\205dec\7343912.dex */
                static class a implements h.b<Kind> {
                    a() {
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
                    /* renamed from: b */
                    public Kind a(int i4) {
                        return Kind.valueOf(i4);
                    }
                }

                Kind(int i4, int i5) {
                    this.value = i5;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.a
                public final int getNumber() {
                    return this.value;
                }

                public static Kind valueOf(int i4) {
                    if (i4 != 0) {
                        if (i4 != 1) {
                            if (i4 != 2) {
                                return null;
                            }
                            return LOCAL;
                        }
                        return PACKAGE;
                    }
                    return CLASS;
                }
            }

            /* loaded from: E:\TSN-r\205dec\7343912.dex */
            static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<QualifiedName> {
                a() {
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
                /* renamed from: m */
                public QualifiedName c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                    return new QualifiedName(eVar, fVar);
                }
            }

            /* loaded from: E:\TSN-r\205dec\7343912.dex */
            public static final class b extends GeneratedMessageLite.b<QualifiedName, b> implements n {

                /* renamed from: b  reason: collision with root package name */
                private int f57381b;

                /* renamed from: d  reason: collision with root package name */
                private int f57383d;

                /* renamed from: c  reason: collision with root package name */
                private int f57382c = -1;

                /* renamed from: e  reason: collision with root package name */
                private Kind f57384e = Kind.PACKAGE;

                private b() {
                    q();
                }

                static /* synthetic */ b j() {
                    return n();
                }

                private static b n() {
                    return new b();
                }

                private void q() {
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
                public final boolean isInitialized() {
                    return p();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
                /* renamed from: k */
                public QualifiedName build() {
                    QualifiedName l4 = l();
                    if (l4.isInitialized()) {
                        return l4;
                    }
                    throw a.AbstractC1158a.c(l4);
                }

                public QualifiedName l() {
                    QualifiedName qualifiedName = new QualifiedName(this);
                    int i4 = this.f57381b;
                    int i5 = (i4 & 1) != 1 ? 0 : 1;
                    qualifiedName.parentQualifiedName_ = this.f57382c;
                    if ((i4 & 2) == 2) {
                        i5 |= 2;
                    }
                    qualifiedName.shortName_ = this.f57383d;
                    if ((i4 & 4) == 4) {
                        i5 |= 4;
                    }
                    qualifiedName.kind_ = this.f57384e;
                    qualifiedName.bitField0_ = i5;
                    return qualifiedName;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
                /* renamed from: m */
                public b d() {
                    return n().h(l());
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, kotlin.reflect.jvm.internal.impl.protobuf.o
                /* renamed from: o */
                public QualifiedName getDefaultInstanceForType() {
                    return QualifiedName.getDefaultInstance();
                }

                public boolean p() {
                    return (this.f57381b & 2) == 2;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
                /* renamed from: r */
                public b h(QualifiedName qualifiedName) {
                    if (qualifiedName == QualifiedName.getDefaultInstance()) {
                        return this;
                    }
                    if (qualifiedName.hasParentQualifiedName()) {
                        u(qualifiedName.getParentQualifiedName());
                    }
                    if (qualifiedName.hasShortName()) {
                        v(qualifiedName.getShortName());
                    }
                    if (qualifiedName.hasKind()) {
                        t(qualifiedName.getKind());
                    }
                    i(f().c(qualifiedName.unknownFields));
                    return this;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
                @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC1158a, kotlin.reflect.jvm.internal.impl.protobuf.n.a
                /* renamed from: s */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable.QualifiedName.b g(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                    /*
                        r2 = this;
                        r0 = 0
                        kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable$QualifiedName> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable.QualifiedName.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                        java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable$QualifiedName r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable.QualifiedName) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                        if (r3 == 0) goto Le
                        r2.h(r3)
                    Le:
                        return r2
                    Lf:
                        r3 = move-exception
                        goto L1b
                    L11:
                        r3 = move-exception
                        kotlin.reflect.jvm.internal.impl.protobuf.n r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> Lf
                        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable$QualifiedName r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable.QualifiedName) r4     // Catch: java.lang.Throwable -> Lf
                        throw r3     // Catch: java.lang.Throwable -> L19
                    L19:
                        r3 = move-exception
                        r0 = r4
                    L1b:
                        if (r0 == 0) goto L20
                        r2.h(r0)
                    L20:
                        throw r3
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable.QualifiedName.b.g(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable$QualifiedName$b");
                }

                public b t(Kind kind) {
                    kind.getClass();
                    this.f57381b |= 4;
                    this.f57384e = kind;
                    return this;
                }

                public b u(int i4) {
                    this.f57381b |= 1;
                    this.f57382c = i4;
                    return this;
                }

                public b v(int i4) {
                    this.f57381b |= 2;
                    this.f57383d = i4;
                    return this;
                }
            }

            static {
                QualifiedName qualifiedName = new QualifiedName(true);
                defaultInstance = qualifiedName;
                qualifiedName.initFields();
            }

            public static QualifiedName getDefaultInstance() {
                return defaultInstance;
            }

            private void initFields() {
                this.parentQualifiedName_ = -1;
                this.shortName_ = 0;
                this.kind_ = Kind.PACKAGE;
            }

            public static b newBuilder() {
                return b.j();
            }

            public Kind getKind() {
                return this.kind_;
            }

            public int getParentQualifiedName() {
                return this.parentQualifiedName_;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
            public kotlin.reflect.jvm.internal.impl.protobuf.p<QualifiedName> getParserForType() {
                return PARSER;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
            public int getSerializedSize() {
                int i4 = this.memoizedSerializedSize;
                if (i4 != -1) {
                    return i4;
                }
                int o4 = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.o(1, this.parentQualifiedName_) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    o4 += CodedOutputStream.o(2, this.shortName_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    o4 += CodedOutputStream.h(3, this.kind_.getNumber());
                }
                int size = o4 + this.unknownFields.size();
                this.memoizedSerializedSize = size;
                return size;
            }

            public int getShortName() {
                return this.shortName_;
            }

            public boolean hasKind() {
                return (this.bitField0_ & 4) == 4;
            }

            public boolean hasParentQualifiedName() {
                return (this.bitField0_ & 1) == 1;
            }

            public boolean hasShortName() {
                return (this.bitField0_ & 2) == 2;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public final boolean isInitialized() {
                byte b4 = this.memoizedIsInitialized;
                if (b4 == 1) {
                    return true;
                }
                if (b4 == 0) {
                    return false;
                }
                if (!hasShortName()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                getSerializedSize();
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.a0(1, this.parentQualifiedName_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.a0(2, this.shortName_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    codedOutputStream.S(3, this.kind_.getNumber());
                }
                codedOutputStream.i0(this.unknownFields);
            }

            public static b newBuilder(QualifiedName qualifiedName) {
                return newBuilder().h(qualifiedName);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public QualifiedName getDefaultInstanceForType() {
                return defaultInstance;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
            public b newBuilderForType() {
                return newBuilder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
            public b toBuilder() {
                return newBuilder(this);
            }

            private QualifiedName(GeneratedMessageLite.b bVar) {
                super(bVar);
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = bVar.f();
            }

            private QualifiedName(boolean z3) {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f57629a;
            }

            private QualifiedName(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                initFields();
                d.b u3 = kotlin.reflect.jvm.internal.impl.protobuf.d.u();
                CodedOutputStream J = CodedOutputStream.J(u3, 1);
                boolean z3 = false;
                while (!z3) {
                    try {
                        try {
                            int K = eVar.K();
                            if (K != 0) {
                                if (K == 8) {
                                    this.bitField0_ |= 1;
                                    this.parentQualifiedName_ = eVar.s();
                                } else if (K == 16) {
                                    this.bitField0_ |= 2;
                                    this.shortName_ = eVar.s();
                                } else if (K != 24) {
                                    if (!parseUnknownField(eVar, J, fVar, K)) {
                                    }
                                } else {
                                    int n4 = eVar.n();
                                    Kind valueOf = Kind.valueOf(n4);
                                    if (valueOf == null) {
                                        J.o0(K);
                                        J.o0(n4);
                                    } else {
                                        this.bitField0_ |= 4;
                                        this.kind_ = valueOf;
                                    }
                                }
                            }
                            z3 = true;
                        } catch (InvalidProtocolBufferException e4) {
                            throw e4.setUnfinishedMessage(this);
                        } catch (IOException e5) {
                            throw new InvalidProtocolBufferException(e5.getMessage()).setUnfinishedMessage(this);
                        }
                    } catch (Throwable th) {
                        try {
                            J.I();
                        } catch (IOException unused) {
                        } catch (Throwable th2) {
                            this.unknownFields = u3.g();
                            throw th2;
                        }
                        this.unknownFields = u3.g();
                        makeExtensionsImmutable();
                        throw th;
                    }
                }
                try {
                    J.I();
                } catch (IOException unused2) {
                } catch (Throwable th3) {
                    this.unknownFields = u3.g();
                    throw th3;
                }
                this.unknownFields = u3.g();
                makeExtensionsImmutable();
            }
        }

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<QualifiedNameTable> {
            a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
            /* renamed from: m */
            public QualifiedNameTable c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                return new QualifiedNameTable(eVar, fVar);
            }
        }

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class b extends GeneratedMessageLite.b<QualifiedNameTable, b> implements o {

            /* renamed from: b  reason: collision with root package name */
            private int f57385b;

            /* renamed from: c  reason: collision with root package name */
            private List<QualifiedName> f57386c = Collections.emptyList();

            private b() {
                s();
            }

            static /* synthetic */ b j() {
                return n();
            }

            private static b n() {
                return new b();
            }

            private void o() {
                if ((this.f57385b & 1) != 1) {
                    this.f57386c = new ArrayList(this.f57386c);
                    this.f57385b |= 1;
                }
            }

            private void s() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public final boolean isInitialized() {
                for (int i4 = 0; i4 < r(); i4++) {
                    if (!q(i4).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: k */
            public QualifiedNameTable build() {
                QualifiedNameTable l4 = l();
                if (l4.isInitialized()) {
                    return l4;
                }
                throw a.AbstractC1158a.c(l4);
            }

            public QualifiedNameTable l() {
                QualifiedNameTable qualifiedNameTable = new QualifiedNameTable(this);
                if ((this.f57385b & 1) == 1) {
                    this.f57386c = Collections.unmodifiableList(this.f57386c);
                    this.f57385b &= -2;
                }
                qualifiedNameTable.qualifiedName_ = this.f57386c;
                return qualifiedNameTable;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: m */
            public b d() {
                return n().h(l());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, kotlin.reflect.jvm.internal.impl.protobuf.o
            /* renamed from: p */
            public QualifiedNameTable getDefaultInstanceForType() {
                return QualifiedNameTable.getDefaultInstance();
            }

            public QualifiedName q(int i4) {
                return this.f57386c.get(i4);
            }

            public int r() {
                return this.f57386c.size();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: t */
            public b h(QualifiedNameTable qualifiedNameTable) {
                if (qualifiedNameTable == QualifiedNameTable.getDefaultInstance()) {
                    return this;
                }
                if (!qualifiedNameTable.qualifiedName_.isEmpty()) {
                    if (this.f57386c.isEmpty()) {
                        this.f57386c = qualifiedNameTable.qualifiedName_;
                        this.f57385b &= -2;
                    } else {
                        o();
                        this.f57386c.addAll(qualifiedNameTable.qualifiedName_);
                    }
                }
                i(f().c(qualifiedNameTable.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC1158a, kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: u */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable.b g(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.h(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1b
                L11:
                    r3 = move-exception
                    kotlin.reflect.jvm.internal.impl.protobuf.n r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> Lf
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable) r4     // Catch: java.lang.Throwable -> Lf
                    throw r3     // Catch: java.lang.Throwable -> L19
                L19:
                    r3 = move-exception
                    r0 = r4
                L1b:
                    if (r0 == 0) goto L20
                    r2.h(r0)
                L20:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.QualifiedNameTable.b.g(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$QualifiedNameTable$b");
            }
        }

        static {
            QualifiedNameTable qualifiedNameTable = new QualifiedNameTable(true);
            defaultInstance = qualifiedNameTable;
            qualifiedNameTable.initFields();
        }

        public static QualifiedNameTable getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.qualifiedName_ = Collections.emptyList();
        }

        public static b newBuilder() {
            return b.j();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
        public kotlin.reflect.jvm.internal.impl.protobuf.p<QualifiedNameTable> getParserForType() {
            return PARSER;
        }

        public QualifiedName getQualifiedName(int i4) {
            return this.qualifiedName_.get(i4);
        }

        public int getQualifiedNameCount() {
            return this.qualifiedName_.size();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public int getSerializedSize() {
            int i4 = this.memoizedSerializedSize;
            if (i4 != -1) {
                return i4;
            }
            int i5 = 0;
            for (int i6 = 0; i6 < this.qualifiedName_.size(); i6++) {
                i5 += CodedOutputStream.s(1, this.qualifiedName_.get(i6));
            }
            int size = i5 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public final boolean isInitialized() {
            byte b4 = this.memoizedIsInitialized;
            if (b4 == 1) {
                return true;
            }
            if (b4 == 0) {
                return false;
            }
            for (int i4 = 0; i4 < getQualifiedNameCount(); i4++) {
                if (!getQualifiedName(i4).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            for (int i4 = 0; i4 < this.qualifiedName_.size(); i4++) {
                codedOutputStream.d0(1, this.qualifiedName_.get(i4));
            }
            codedOutputStream.i0(this.unknownFields);
        }

        public static b newBuilder(QualifiedNameTable qualifiedNameTable) {
            return newBuilder().h(qualifiedNameTable);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public QualifiedNameTable getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b toBuilder() {
            return newBuilder(this);
        }

        private QualifiedNameTable(GeneratedMessageLite.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.f();
        }

        private QualifiedNameTable(boolean z3) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f57629a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private QualifiedNameTable(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            d.b u3 = kotlin.reflect.jvm.internal.impl.protobuf.d.u();
            CodedOutputStream J = CodedOutputStream.J(u3, 1);
            boolean z3 = false;
            boolean z4 = false;
            while (!z3) {
                try {
                    try {
                        int K = eVar.K();
                        if (K != 0) {
                            if (K != 10) {
                                if (!parseUnknownField(eVar, J, fVar, K)) {
                                }
                            } else {
                                if (!(z4 & true)) {
                                    this.qualifiedName_ = new ArrayList();
                                    z4 |= true;
                                }
                                this.qualifiedName_.add(eVar.u(QualifiedName.PARSER, fVar));
                            }
                        }
                        z3 = true;
                    } catch (InvalidProtocolBufferException e4) {
                        throw e4.setUnfinishedMessage(this);
                    } catch (IOException e5) {
                        throw new InvalidProtocolBufferException(e5.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    if (z4 & true) {
                        this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
                    }
                    try {
                        J.I();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.unknownFields = u3.g();
                        throw th2;
                    }
                    this.unknownFields = u3.g();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z4 & true) {
                this.qualifiedName_ = Collections.unmodifiableList(this.qualifiedName_);
            }
            try {
                J.I();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.unknownFields = u3.g();
                throw th3;
            }
            this.unknownFields = u3.g();
            makeExtensionsImmutable();
        }
    }

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class StringTable extends GeneratedMessageLite implements p {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<StringTable> PARSER = new a();
        private static final StringTable defaultInstance;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private kotlin.reflect.jvm.internal.impl.protobuf.l string_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<StringTable> {
            a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
            /* renamed from: m */
            public StringTable c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                return new StringTable(eVar, fVar);
            }
        }

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class b extends GeneratedMessageLite.b<StringTable, b> implements p {

            /* renamed from: b  reason: collision with root package name */
            private int f57387b;

            /* renamed from: c  reason: collision with root package name */
            private kotlin.reflect.jvm.internal.impl.protobuf.l f57388c = kotlin.reflect.jvm.internal.impl.protobuf.k.f57671b;

            private b() {
                q();
            }

            static /* synthetic */ b j() {
                return n();
            }

            private static b n() {
                return new b();
            }

            private void o() {
                if ((this.f57387b & 1) != 1) {
                    this.f57388c = new kotlin.reflect.jvm.internal.impl.protobuf.k(this.f57388c);
                    this.f57387b |= 1;
                }
            }

            private void q() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public final boolean isInitialized() {
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: k */
            public StringTable build() {
                StringTable l4 = l();
                if (l4.isInitialized()) {
                    return l4;
                }
                throw a.AbstractC1158a.c(l4);
            }

            public StringTable l() {
                StringTable stringTable = new StringTable(this);
                if ((this.f57387b & 1) == 1) {
                    this.f57388c = this.f57388c.j();
                    this.f57387b &= -2;
                }
                stringTable.string_ = this.f57388c;
                return stringTable;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: m */
            public b d() {
                return n().h(l());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, kotlin.reflect.jvm.internal.impl.protobuf.o
            /* renamed from: p */
            public StringTable getDefaultInstanceForType() {
                return StringTable.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: r */
            public b h(StringTable stringTable) {
                if (stringTable == StringTable.getDefaultInstance()) {
                    return this;
                }
                if (!stringTable.string_.isEmpty()) {
                    if (this.f57388c.isEmpty()) {
                        this.f57388c = stringTable.string_;
                        this.f57387b &= -2;
                    } else {
                        o();
                        this.f57388c.addAll(stringTable.string_);
                    }
                }
                i(f().c(stringTable.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC1158a, kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: s */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.StringTable.b g(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.StringTable.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.StringTable) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.h(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1b
                L11:
                    r3 = move-exception
                    kotlin.reflect.jvm.internal.impl.protobuf.n r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> Lf
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.StringTable) r4     // Catch: java.lang.Throwable -> Lf
                    throw r3     // Catch: java.lang.Throwable -> L19
                L19:
                    r3 = move-exception
                    r0 = r4
                L1b:
                    if (r0 == 0) goto L20
                    r2.h(r0)
                L20:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.StringTable.b.g(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$StringTable$b");
            }
        }

        static {
            StringTable stringTable = new StringTable(true);
            defaultInstance = stringTable;
            stringTable.initFields();
        }

        public static StringTable getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.string_ = kotlin.reflect.jvm.internal.impl.protobuf.k.f57671b;
        }

        public static b newBuilder() {
            return b.j();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
        public kotlin.reflect.jvm.internal.impl.protobuf.p<StringTable> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public int getSerializedSize() {
            int i4 = this.memoizedSerializedSize;
            if (i4 != -1) {
                return i4;
            }
            int i5 = 0;
            for (int i6 = 0; i6 < this.string_.size(); i6++) {
                i5 += CodedOutputStream.e(this.string_.e(i6));
            }
            int size = 0 + i5 + (getStringList().size() * 1) + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public String getString(int i4) {
            return this.string_.get(i4);
        }

        public kotlin.reflect.jvm.internal.impl.protobuf.q getStringList() {
            return this.string_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public final boolean isInitialized() {
            byte b4 = this.memoizedIsInitialized;
            if (b4 == 1) {
                return true;
            }
            if (b4 == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            for (int i4 = 0; i4 < this.string_.size(); i4++) {
                codedOutputStream.O(1, this.string_.e(i4));
            }
            codedOutputStream.i0(this.unknownFields);
        }

        public static b newBuilder(StringTable stringTable) {
            return newBuilder().h(stringTable);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public StringTable getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b toBuilder() {
            return newBuilder(this);
        }

        private StringTable(GeneratedMessageLite.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.f();
        }

        private StringTable(boolean z3) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f57629a;
        }

        private StringTable(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            d.b u3 = kotlin.reflect.jvm.internal.impl.protobuf.d.u();
            CodedOutputStream J = CodedOutputStream.J(u3, 1);
            boolean z3 = false;
            boolean z4 = false;
            while (!z3) {
                try {
                    try {
                        try {
                            int K = eVar.K();
                            if (K != 0) {
                                if (K != 10) {
                                    if (!parseUnknownField(eVar, J, fVar, K)) {
                                    }
                                } else {
                                    kotlin.reflect.jvm.internal.impl.protobuf.d l4 = eVar.l();
                                    if (!(z4 & true)) {
                                        this.string_ = new kotlin.reflect.jvm.internal.impl.protobuf.k();
                                        z4 |= true;
                                    }
                                    this.string_.f(l4);
                                }
                            }
                            z3 = true;
                        } catch (IOException e4) {
                            throw new InvalidProtocolBufferException(e4.getMessage()).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e5) {
                        throw e5.setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    if (z4 & true) {
                        this.string_ = this.string_.j();
                    }
                    try {
                        J.I();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.unknownFields = u3.g();
                        throw th2;
                    }
                    this.unknownFields = u3.g();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z4 & true) {
                this.string_ = this.string_.j();
            }
            try {
                J.I();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.unknownFields = u3.g();
                throw th3;
            }
            this.unknownFields = u3.g();
            makeExtensionsImmutable();
        }
    }

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class Type extends GeneratedMessageLite.ExtendableMessage<Type> implements s {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<Type> PARSER = new a();
        private static final Type defaultInstance;
        private int abbreviatedTypeId_;
        private Type abbreviatedType_;
        private List<Argument> argument_;
        private int bitField0_;
        private int className_;
        private int flags_;
        private int flexibleTypeCapabilitiesId_;
        private int flexibleUpperBoundId_;
        private Type flexibleUpperBound_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private boolean nullable_;
        private int outerTypeId_;
        private Type outerType_;
        private int typeAliasName_;
        private int typeParameterName_;
        private int typeParameter_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class Argument extends GeneratedMessageLite implements q {
            public static kotlin.reflect.jvm.internal.impl.protobuf.p<Argument> PARSER = new a();
            private static final Argument defaultInstance;
            private int bitField0_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private Projection projection_;
            private int typeId_;
            private Type type_;
            private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

            /* loaded from: E:\TSN-r\205dec\7343912.dex */
            public enum Projection implements h.a {
                IN(0, 0),
                OUT(1, 1),
                INV(2, 2),
                STAR(3, 3);
                
                private static h.b<Projection> internalValueMap = new a();
                private final int value;

                /* loaded from: E:\TSN-r\205dec\7343912.dex */
                static class a implements h.b<Projection> {
                    a() {
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
                    /* renamed from: b */
                    public Projection a(int i4) {
                        return Projection.valueOf(i4);
                    }
                }

                Projection(int i4, int i5) {
                    this.value = i5;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.a
                public final int getNumber() {
                    return this.value;
                }

                public static Projection valueOf(int i4) {
                    if (i4 != 0) {
                        if (i4 != 1) {
                            if (i4 != 2) {
                                if (i4 != 3) {
                                    return null;
                                }
                                return STAR;
                            }
                            return INV;
                        }
                        return OUT;
                    }
                    return IN;
                }
            }

            /* loaded from: E:\TSN-r\205dec\7343912.dex */
            static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<Argument> {
                a() {
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
                /* renamed from: m */
                public Argument c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                    return new Argument(eVar, fVar);
                }
            }

            /* loaded from: E:\TSN-r\205dec\7343912.dex */
            public static final class b extends GeneratedMessageLite.b<Argument, b> implements q {

                /* renamed from: b  reason: collision with root package name */
                private int f57389b;

                /* renamed from: c  reason: collision with root package name */
                private Projection f57390c = Projection.INV;

                /* renamed from: d  reason: collision with root package name */
                private Type f57391d = Type.getDefaultInstance();

                /* renamed from: e  reason: collision with root package name */
                private int f57392e;

                private b() {
                    q();
                }

                static /* synthetic */ b j() {
                    return n();
                }

                private static b n() {
                    return new b();
                }

                private void q() {
                }

                public Type getType() {
                    return this.f57391d;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
                public final boolean isInitialized() {
                    return !p() || getType().isInitialized();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
                /* renamed from: k */
                public Argument build() {
                    Argument l4 = l();
                    if (l4.isInitialized()) {
                        return l4;
                    }
                    throw a.AbstractC1158a.c(l4);
                }

                public Argument l() {
                    Argument argument = new Argument(this);
                    int i4 = this.f57389b;
                    int i5 = (i4 & 1) != 1 ? 0 : 1;
                    argument.projection_ = this.f57390c;
                    if ((i4 & 2) == 2) {
                        i5 |= 2;
                    }
                    argument.type_ = this.f57391d;
                    if ((i4 & 4) == 4) {
                        i5 |= 4;
                    }
                    argument.typeId_ = this.f57392e;
                    argument.bitField0_ = i5;
                    return argument;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
                /* renamed from: m */
                public b d() {
                    return n().h(l());
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, kotlin.reflect.jvm.internal.impl.protobuf.o
                /* renamed from: o */
                public Argument getDefaultInstanceForType() {
                    return Argument.getDefaultInstance();
                }

                public boolean p() {
                    return (this.f57389b & 2) == 2;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
                /* renamed from: r */
                public b h(Argument argument) {
                    if (argument == Argument.getDefaultInstance()) {
                        return this;
                    }
                    if (argument.hasProjection()) {
                        u(argument.getProjection());
                    }
                    if (argument.hasType()) {
                        t(argument.getType());
                    }
                    if (argument.hasTypeId()) {
                        v(argument.getTypeId());
                    }
                    i(f().c(argument.unknownFields));
                    return this;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
                @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC1158a, kotlin.reflect.jvm.internal.impl.protobuf.n.a
                /* renamed from: s */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument.b g(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                    /*
                        r2 = this;
                        r0 = 0
                        kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Argument> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                        java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Argument r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                        if (r3 == 0) goto Le
                        r2.h(r3)
                    Le:
                        return r2
                    Lf:
                        r3 = move-exception
                        goto L1b
                    L11:
                        r3 = move-exception
                        kotlin.reflect.jvm.internal.impl.protobuf.n r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> Lf
                        kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Argument r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument) r4     // Catch: java.lang.Throwable -> Lf
                        throw r3     // Catch: java.lang.Throwable -> L19
                    L19:
                        r3 = move-exception
                        r0 = r4
                    L1b:
                        if (r0 == 0) goto L20
                        r2.h(r0)
                    L20:
                        throw r3
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.Argument.b.g(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$Argument$b");
                }

                public b t(Type type) {
                    if ((this.f57389b & 2) == 2 && this.f57391d != Type.getDefaultInstance()) {
                        this.f57391d = Type.newBuilder(this.f57391d).h(type).r();
                    } else {
                        this.f57391d = type;
                    }
                    this.f57389b |= 2;
                    return this;
                }

                public b u(Projection projection) {
                    projection.getClass();
                    this.f57389b |= 1;
                    this.f57390c = projection;
                    return this;
                }

                public b v(int i4) {
                    this.f57389b |= 4;
                    this.f57392e = i4;
                    return this;
                }
            }

            static {
                Argument argument = new Argument(true);
                defaultInstance = argument;
                argument.initFields();
            }

            public static Argument getDefaultInstance() {
                return defaultInstance;
            }

            private void initFields() {
                this.projection_ = Projection.INV;
                this.type_ = Type.getDefaultInstance();
                this.typeId_ = 0;
            }

            public static b newBuilder() {
                return b.j();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
            public kotlin.reflect.jvm.internal.impl.protobuf.p<Argument> getParserForType() {
                return PARSER;
            }

            public Projection getProjection() {
                return this.projection_;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
            public int getSerializedSize() {
                int i4 = this.memoizedSerializedSize;
                if (i4 != -1) {
                    return i4;
                }
                int h4 = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.h(1, this.projection_.getNumber()) : 0;
                if ((this.bitField0_ & 2) == 2) {
                    h4 += CodedOutputStream.s(2, this.type_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    h4 += CodedOutputStream.o(3, this.typeId_);
                }
                int size = h4 + this.unknownFields.size();
                this.memoizedSerializedSize = size;
                return size;
            }

            public Type getType() {
                return this.type_;
            }

            public int getTypeId() {
                return this.typeId_;
            }

            public boolean hasProjection() {
                return (this.bitField0_ & 1) == 1;
            }

            public boolean hasType() {
                return (this.bitField0_ & 2) == 2;
            }

            public boolean hasTypeId() {
                return (this.bitField0_ & 4) == 4;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public final boolean isInitialized() {
                byte b4 = this.memoizedIsInitialized;
                if (b4 == 1) {
                    return true;
                }
                if (b4 == 0) {
                    return false;
                }
                if (hasType() && !getType().isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                getSerializedSize();
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.S(1, this.projection_.getNumber());
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.d0(2, this.type_);
                }
                if ((this.bitField0_ & 4) == 4) {
                    codedOutputStream.a0(3, this.typeId_);
                }
                codedOutputStream.i0(this.unknownFields);
            }

            public static b newBuilder(Argument argument) {
                return newBuilder().h(argument);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public Argument getDefaultInstanceForType() {
                return defaultInstance;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
            public b newBuilderForType() {
                return newBuilder();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
            public b toBuilder() {
                return newBuilder(this);
            }

            private Argument(GeneratedMessageLite.b bVar) {
                super(bVar);
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = bVar.f();
            }

            private Argument(boolean z3) {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f57629a;
            }

            private Argument(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                initFields();
                d.b u3 = kotlin.reflect.jvm.internal.impl.protobuf.d.u();
                CodedOutputStream J = CodedOutputStream.J(u3, 1);
                boolean z3 = false;
                while (!z3) {
                    try {
                        try {
                            try {
                                int K = eVar.K();
                                if (K != 0) {
                                    if (K == 8) {
                                        int n4 = eVar.n();
                                        Projection valueOf = Projection.valueOf(n4);
                                        if (valueOf == null) {
                                            J.o0(K);
                                            J.o0(n4);
                                        } else {
                                            this.bitField0_ |= 1;
                                            this.projection_ = valueOf;
                                        }
                                    } else if (K == 18) {
                                        b builder = (this.bitField0_ & 2) == 2 ? this.type_.toBuilder() : null;
                                        Type type = (Type) eVar.u(Type.PARSER, fVar);
                                        this.type_ = type;
                                        if (builder != null) {
                                            builder.h(type);
                                            this.type_ = builder.r();
                                        }
                                        this.bitField0_ |= 2;
                                    } else if (K != 24) {
                                        if (!parseUnknownField(eVar, J, fVar, K)) {
                                        }
                                    } else {
                                        this.bitField0_ |= 4;
                                        this.typeId_ = eVar.s();
                                    }
                                }
                                z3 = true;
                            } catch (IOException e4) {
                                throw new InvalidProtocolBufferException(e4.getMessage()).setUnfinishedMessage(this);
                            }
                        } catch (InvalidProtocolBufferException e5) {
                            throw e5.setUnfinishedMessage(this);
                        }
                    } catch (Throwable th) {
                        try {
                            J.I();
                        } catch (IOException unused) {
                        } catch (Throwable th2) {
                            this.unknownFields = u3.g();
                            throw th2;
                        }
                        this.unknownFields = u3.g();
                        makeExtensionsImmutable();
                        throw th;
                    }
                }
                try {
                    J.I();
                } catch (IOException unused2) {
                } catch (Throwable th3) {
                    this.unknownFields = u3.g();
                    throw th3;
                }
                this.unknownFields = u3.g();
                makeExtensionsImmutable();
            }
        }

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<Type> {
            a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
            /* renamed from: m */
            public Type c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                return new Type(eVar, fVar);
            }
        }

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class b extends GeneratedMessageLite.c<Type, b> implements s {

            /* renamed from: d  reason: collision with root package name */
            private int f57393d;

            /* renamed from: f  reason: collision with root package name */
            private boolean f57395f;

            /* renamed from: g  reason: collision with root package name */
            private int f57396g;

            /* renamed from: i  reason: collision with root package name */
            private int f57398i;

            /* renamed from: j  reason: collision with root package name */
            private int f57399j;

            /* renamed from: k  reason: collision with root package name */
            private int f57400k;

            /* renamed from: l  reason: collision with root package name */
            private int f57401l;

            /* renamed from: m  reason: collision with root package name */
            private int f57402m;

            /* renamed from: o  reason: collision with root package name */
            private int f57404o;

            /* renamed from: q  reason: collision with root package name */
            private int f57406q;

            /* renamed from: r  reason: collision with root package name */
            private int f57407r;

            /* renamed from: e  reason: collision with root package name */
            private List<Argument> f57394e = Collections.emptyList();

            /* renamed from: h  reason: collision with root package name */
            private Type f57397h = Type.getDefaultInstance();

            /* renamed from: n  reason: collision with root package name */
            private Type f57403n = Type.getDefaultInstance();

            /* renamed from: p  reason: collision with root package name */
            private Type f57405p = Type.getDefaultInstance();

            private b() {
                E();
            }

            private void E() {
            }

            static /* synthetic */ b p() {
                return t();
            }

            private static b t() {
                return new b();
            }

            private void u() {
                if ((this.f57393d & 1) != 1) {
                    this.f57394e = new ArrayList(this.f57394e);
                    this.f57393d |= 1;
                }
            }

            public Type A() {
                return this.f57403n;
            }

            public boolean B() {
                return (this.f57393d & 2048) == 2048;
            }

            public boolean C() {
                return (this.f57393d & 8) == 8;
            }

            public boolean D() {
                return (this.f57393d & 512) == 512;
            }

            public b F(Type type) {
                if ((this.f57393d & 2048) == 2048 && this.f57405p != Type.getDefaultInstance()) {
                    this.f57405p = Type.newBuilder(this.f57405p).h(type).r();
                } else {
                    this.f57405p = type;
                }
                this.f57393d |= 2048;
                return this;
            }

            public b G(Type type) {
                if ((this.f57393d & 8) == 8 && this.f57397h != Type.getDefaultInstance()) {
                    this.f57397h = Type.newBuilder(this.f57397h).h(type).r();
                } else {
                    this.f57397h = type;
                }
                this.f57393d |= 8;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: H */
            public b h(Type type) {
                if (type == Type.getDefaultInstance()) {
                    return this;
                }
                if (!type.argument_.isEmpty()) {
                    if (this.f57394e.isEmpty()) {
                        this.f57394e = type.argument_;
                        this.f57393d &= -2;
                    } else {
                        u();
                        this.f57394e.addAll(type.argument_);
                    }
                }
                if (type.hasNullable()) {
                    P(type.getNullable());
                }
                if (type.hasFlexibleTypeCapabilitiesId()) {
                    N(type.getFlexibleTypeCapabilitiesId());
                }
                if (type.hasFlexibleUpperBound()) {
                    G(type.getFlexibleUpperBound());
                }
                if (type.hasFlexibleUpperBoundId()) {
                    O(type.getFlexibleUpperBoundId());
                }
                if (type.hasClassName()) {
                    L(type.getClassName());
                }
                if (type.hasTypeParameter()) {
                    S(type.getTypeParameter());
                }
                if (type.hasTypeParameterName()) {
                    T(type.getTypeParameterName());
                }
                if (type.hasTypeAliasName()) {
                    R(type.getTypeAliasName());
                }
                if (type.hasOuterType()) {
                    J(type.getOuterType());
                }
                if (type.hasOuterTypeId()) {
                    Q(type.getOuterTypeId());
                }
                if (type.hasAbbreviatedType()) {
                    F(type.getAbbreviatedType());
                }
                if (type.hasAbbreviatedTypeId()) {
                    K(type.getAbbreviatedTypeId());
                }
                if (type.hasFlags()) {
                    M(type.getFlags());
                }
                o(type);
                i(f().c(type.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC1158a, kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: I */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.b g(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.h(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1b
                L11:
                    r3 = move-exception
                    kotlin.reflect.jvm.internal.impl.protobuf.n r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> Lf
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type) r4     // Catch: java.lang.Throwable -> Lf
                    throw r3     // Catch: java.lang.Throwable -> L19
                L19:
                    r3 = move-exception
                    r0 = r4
                L1b:
                    if (r0 == 0) goto L20
                    r2.h(r0)
                L20:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.Type.b.g(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type$b");
            }

            public b J(Type type) {
                if ((this.f57393d & 512) == 512 && this.f57403n != Type.getDefaultInstance()) {
                    this.f57403n = Type.newBuilder(this.f57403n).h(type).r();
                } else {
                    this.f57403n = type;
                }
                this.f57393d |= 512;
                return this;
            }

            public b K(int i4) {
                this.f57393d |= 4096;
                this.f57406q = i4;
                return this;
            }

            public b L(int i4) {
                this.f57393d |= 32;
                this.f57399j = i4;
                return this;
            }

            public b M(int i4) {
                this.f57393d |= 8192;
                this.f57407r = i4;
                return this;
            }

            public b N(int i4) {
                this.f57393d |= 4;
                this.f57396g = i4;
                return this;
            }

            public b O(int i4) {
                this.f57393d |= 16;
                this.f57398i = i4;
                return this;
            }

            public b P(boolean z3) {
                this.f57393d |= 2;
                this.f57395f = z3;
                return this;
            }

            public b Q(int i4) {
                this.f57393d |= 1024;
                this.f57404o = i4;
                return this;
            }

            public b R(int i4) {
                this.f57393d |= 256;
                this.f57402m = i4;
                return this;
            }

            public b S(int i4) {
                this.f57393d |= 64;
                this.f57400k = i4;
                return this;
            }

            public b T(int i4) {
                this.f57393d |= 128;
                this.f57401l = i4;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public final boolean isInitialized() {
                for (int i4 = 0; i4 < x(); i4++) {
                    if (!w(i4).isInitialized()) {
                        return false;
                    }
                }
                if (!C() || z().isInitialized()) {
                    if (!D() || A().isInitialized()) {
                        return (!B() || v().isInitialized()) && n();
                    }
                    return false;
                }
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: q */
            public Type build() {
                Type r3 = r();
                if (r3.isInitialized()) {
                    return r3;
                }
                throw a.AbstractC1158a.c(r3);
            }

            public Type r() {
                Type type = new Type(this);
                int i4 = this.f57393d;
                if ((i4 & 1) == 1) {
                    this.f57394e = Collections.unmodifiableList(this.f57394e);
                    this.f57393d &= -2;
                }
                type.argument_ = this.f57394e;
                int i5 = (i4 & 2) != 2 ? 0 : 1;
                type.nullable_ = this.f57395f;
                if ((i4 & 4) == 4) {
                    i5 |= 2;
                }
                type.flexibleTypeCapabilitiesId_ = this.f57396g;
                if ((i4 & 8) == 8) {
                    i5 |= 4;
                }
                type.flexibleUpperBound_ = this.f57397h;
                if ((i4 & 16) == 16) {
                    i5 |= 8;
                }
                type.flexibleUpperBoundId_ = this.f57398i;
                if ((i4 & 32) == 32) {
                    i5 |= 16;
                }
                type.className_ = this.f57399j;
                if ((i4 & 64) == 64) {
                    i5 |= 32;
                }
                type.typeParameter_ = this.f57400k;
                if ((i4 & 128) == 128) {
                    i5 |= 64;
                }
                type.typeParameterName_ = this.f57401l;
                if ((i4 & 256) == 256) {
                    i5 |= 128;
                }
                type.typeAliasName_ = this.f57402m;
                if ((i4 & 512) == 512) {
                    i5 |= 256;
                }
                type.outerType_ = this.f57403n;
                if ((i4 & 1024) == 1024) {
                    i5 |= 512;
                }
                type.outerTypeId_ = this.f57404o;
                if ((i4 & 2048) == 2048) {
                    i5 |= 1024;
                }
                type.abbreviatedType_ = this.f57405p;
                if ((i4 & 4096) == 4096) {
                    i5 |= 2048;
                }
                type.abbreviatedTypeId_ = this.f57406q;
                if ((i4 & 8192) == 8192) {
                    i5 |= 4096;
                }
                type.flags_ = this.f57407r;
                type.bitField0_ = i5;
                return type;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.c
            /* renamed from: s */
            public b l() {
                return t().h(r());
            }

            public Type v() {
                return this.f57405p;
            }

            public Argument w(int i4) {
                return this.f57394e.get(i4);
            }

            public int x() {
                return this.f57394e.size();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, kotlin.reflect.jvm.internal.impl.protobuf.o
            /* renamed from: y */
            public Type getDefaultInstanceForType() {
                return Type.getDefaultInstance();
            }

            public Type z() {
                return this.f57397h;
            }
        }

        static {
            Type type = new Type(true);
            defaultInstance = type;
            type.initFields();
        }

        public static Type getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.argument_ = Collections.emptyList();
            this.nullable_ = false;
            this.flexibleTypeCapabilitiesId_ = 0;
            this.flexibleUpperBound_ = getDefaultInstance();
            this.flexibleUpperBoundId_ = 0;
            this.className_ = 0;
            this.typeParameter_ = 0;
            this.typeParameterName_ = 0;
            this.typeAliasName_ = 0;
            this.outerType_ = getDefaultInstance();
            this.outerTypeId_ = 0;
            this.abbreviatedType_ = getDefaultInstance();
            this.abbreviatedTypeId_ = 0;
            this.flags_ = 0;
        }

        public static b newBuilder() {
            return b.p();
        }

        public Type getAbbreviatedType() {
            return this.abbreviatedType_;
        }

        public int getAbbreviatedTypeId() {
            return this.abbreviatedTypeId_;
        }

        public Argument getArgument(int i4) {
            return this.argument_.get(i4);
        }

        public int getArgumentCount() {
            return this.argument_.size();
        }

        public List<Argument> getArgumentList() {
            return this.argument_;
        }

        public int getClassName() {
            return this.className_;
        }

        public int getFlags() {
            return this.flags_;
        }

        public int getFlexibleTypeCapabilitiesId() {
            return this.flexibleTypeCapabilitiesId_;
        }

        public Type getFlexibleUpperBound() {
            return this.flexibleUpperBound_;
        }

        public int getFlexibleUpperBoundId() {
            return this.flexibleUpperBoundId_;
        }

        public boolean getNullable() {
            return this.nullable_;
        }

        public Type getOuterType() {
            return this.outerType_;
        }

        public int getOuterTypeId() {
            return this.outerTypeId_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
        public kotlin.reflect.jvm.internal.impl.protobuf.p<Type> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public int getSerializedSize() {
            int i4 = this.memoizedSerializedSize;
            if (i4 != -1) {
                return i4;
            }
            int o4 = (this.bitField0_ & 4096) == 4096 ? CodedOutputStream.o(1, this.flags_) + 0 : 0;
            for (int i5 = 0; i5 < this.argument_.size(); i5++) {
                o4 += CodedOutputStream.s(2, this.argument_.get(i5));
            }
            if ((this.bitField0_ & 1) == 1) {
                o4 += CodedOutputStream.a(3, this.nullable_);
            }
            if ((this.bitField0_ & 2) == 2) {
                o4 += CodedOutputStream.o(4, this.flexibleTypeCapabilitiesId_);
            }
            if ((this.bitField0_ & 4) == 4) {
                o4 += CodedOutputStream.s(5, this.flexibleUpperBound_);
            }
            if ((this.bitField0_ & 16) == 16) {
                o4 += CodedOutputStream.o(6, this.className_);
            }
            if ((this.bitField0_ & 32) == 32) {
                o4 += CodedOutputStream.o(7, this.typeParameter_);
            }
            if ((this.bitField0_ & 8) == 8) {
                o4 += CodedOutputStream.o(8, this.flexibleUpperBoundId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                o4 += CodedOutputStream.o(9, this.typeParameterName_);
            }
            if ((this.bitField0_ & 256) == 256) {
                o4 += CodedOutputStream.s(10, this.outerType_);
            }
            if ((this.bitField0_ & 512) == 512) {
                o4 += CodedOutputStream.o(11, this.outerTypeId_);
            }
            if ((this.bitField0_ & 128) == 128) {
                o4 += CodedOutputStream.o(12, this.typeAliasName_);
            }
            if ((this.bitField0_ & 1024) == 1024) {
                o4 += CodedOutputStream.s(13, this.abbreviatedType_);
            }
            if ((this.bitField0_ & 2048) == 2048) {
                o4 += CodedOutputStream.o(14, this.abbreviatedTypeId_);
            }
            int extensionsSerializedSize = o4 + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public int getTypeAliasName() {
            return this.typeAliasName_;
        }

        public int getTypeParameter() {
            return this.typeParameter_;
        }

        public int getTypeParameterName() {
            return this.typeParameterName_;
        }

        public boolean hasAbbreviatedType() {
            return (this.bitField0_ & 1024) == 1024;
        }

        public boolean hasAbbreviatedTypeId() {
            return (this.bitField0_ & 2048) == 2048;
        }

        public boolean hasClassName() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean hasFlags() {
            return (this.bitField0_ & 4096) == 4096;
        }

        public boolean hasFlexibleTypeCapabilitiesId() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasFlexibleUpperBound() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasFlexibleUpperBoundId() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasNullable() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasOuterType() {
            return (this.bitField0_ & 256) == 256;
        }

        public boolean hasOuterTypeId() {
            return (this.bitField0_ & 512) == 512;
        }

        public boolean hasTypeAliasName() {
            return (this.bitField0_ & 128) == 128;
        }

        public boolean hasTypeParameter() {
            return (this.bitField0_ & 32) == 32;
        }

        public boolean hasTypeParameterName() {
            return (this.bitField0_ & 64) == 64;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public final boolean isInitialized() {
            byte b4 = this.memoizedIsInitialized;
            if (b4 == 1) {
                return true;
            }
            if (b4 == 0) {
                return false;
            }
            for (int i4 = 0; i4 < getArgumentCount(); i4++) {
                if (!getArgument(i4).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasFlexibleUpperBound() && !getFlexibleUpperBound().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (hasOuterType() && !getOuterType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (hasAbbreviatedType() && !getAbbreviatedType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (!extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.a newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 4096) == 4096) {
                codedOutputStream.a0(1, this.flags_);
            }
            for (int i4 = 0; i4 < this.argument_.size(); i4++) {
                codedOutputStream.d0(2, this.argument_.get(i4));
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.L(3, this.nullable_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.a0(4, this.flexibleTypeCapabilitiesId_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.d0(5, this.flexibleUpperBound_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.a0(6, this.className_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.a0(7, this.typeParameter_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.a0(8, this.flexibleUpperBoundId_);
            }
            if ((this.bitField0_ & 64) == 64) {
                codedOutputStream.a0(9, this.typeParameterName_);
            }
            if ((this.bitField0_ & 256) == 256) {
                codedOutputStream.d0(10, this.outerType_);
            }
            if ((this.bitField0_ & 512) == 512) {
                codedOutputStream.a0(11, this.outerTypeId_);
            }
            if ((this.bitField0_ & 128) == 128) {
                codedOutputStream.a0(12, this.typeAliasName_);
            }
            if ((this.bitField0_ & 1024) == 1024) {
                codedOutputStream.d0(13, this.abbreviatedType_);
            }
            if ((this.bitField0_ & 2048) == 2048) {
                codedOutputStream.a0(14, this.abbreviatedTypeId_);
            }
            newExtensionWriter.a(200, codedOutputStream);
            codedOutputStream.i0(this.unknownFields);
        }

        public static b newBuilder(Type type) {
            return newBuilder().h(type);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public Type getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b toBuilder() {
            return newBuilder(this);
        }

        private Type(GeneratedMessageLite.c<Type, ?> cVar) {
            super(cVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = cVar.f();
        }

        private Type(boolean z3) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f57629a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private Type(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
            b builder;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            d.b u3 = kotlin.reflect.jvm.internal.impl.protobuf.d.u();
            CodedOutputStream J = CodedOutputStream.J(u3, 1);
            boolean z3 = false;
            boolean z4 = false;
            while (!z3) {
                try {
                    try {
                        int K = eVar.K();
                        switch (K) {
                            case 0:
                                break;
                            case 8:
                                this.bitField0_ |= 4096;
                                this.flags_ = eVar.s();
                                continue;
                            case 18:
                                if (!(z4 & true)) {
                                    this.argument_ = new ArrayList();
                                    z4 |= true;
                                }
                                this.argument_.add(eVar.u(Argument.PARSER, fVar));
                                continue;
                            case 24:
                                this.bitField0_ |= 1;
                                this.nullable_ = eVar.k();
                                continue;
                            case 32:
                                this.bitField0_ |= 2;
                                this.flexibleTypeCapabilitiesId_ = eVar.s();
                                continue;
                            case 42:
                                builder = (this.bitField0_ & 4) == 4 ? this.flexibleUpperBound_.toBuilder() : null;
                                Type type = (Type) eVar.u(PARSER, fVar);
                                this.flexibleUpperBound_ = type;
                                if (builder != null) {
                                    builder.h(type);
                                    this.flexibleUpperBound_ = builder.r();
                                }
                                this.bitField0_ |= 4;
                                continue;
                            case 48:
                                this.bitField0_ |= 16;
                                this.className_ = eVar.s();
                                continue;
                            case 56:
                                this.bitField0_ |= 32;
                                this.typeParameter_ = eVar.s();
                                continue;
                            case 64:
                                this.bitField0_ |= 8;
                                this.flexibleUpperBoundId_ = eVar.s();
                                continue;
                            case 72:
                                this.bitField0_ |= 64;
                                this.typeParameterName_ = eVar.s();
                                continue;
                            case 82:
                                builder = (this.bitField0_ & 256) == 256 ? this.outerType_.toBuilder() : null;
                                Type type2 = (Type) eVar.u(PARSER, fVar);
                                this.outerType_ = type2;
                                if (builder != null) {
                                    builder.h(type2);
                                    this.outerType_ = builder.r();
                                }
                                this.bitField0_ |= 256;
                                continue;
                            case 88:
                                this.bitField0_ |= 512;
                                this.outerTypeId_ = eVar.s();
                                continue;
                            case 96:
                                this.bitField0_ |= 128;
                                this.typeAliasName_ = eVar.s();
                                continue;
                            case 106:
                                builder = (this.bitField0_ & 1024) == 1024 ? this.abbreviatedType_.toBuilder() : null;
                                Type type3 = (Type) eVar.u(PARSER, fVar);
                                this.abbreviatedType_ = type3;
                                if (builder != null) {
                                    builder.h(type3);
                                    this.abbreviatedType_ = builder.r();
                                }
                                this.bitField0_ |= 1024;
                                continue;
                            case 112:
                                this.bitField0_ |= 2048;
                                this.abbreviatedTypeId_ = eVar.s();
                                continue;
                            default:
                                if (!parseUnknownField(eVar, J, fVar, K)) {
                                    break;
                                } else {
                                    continue;
                                }
                        }
                        z3 = true;
                    } catch (InvalidProtocolBufferException e4) {
                        throw e4.setUnfinishedMessage(this);
                    } catch (IOException e5) {
                        throw new InvalidProtocolBufferException(e5.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    if (z4 & true) {
                        this.argument_ = Collections.unmodifiableList(this.argument_);
                    }
                    try {
                        J.I();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.unknownFields = u3.g();
                        throw th2;
                    }
                    this.unknownFields = u3.g();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z4 & true) {
                this.argument_ = Collections.unmodifiableList(this.argument_);
            }
            try {
                J.I();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.unknownFields = u3.g();
                throw th3;
            }
            this.unknownFields = u3.g();
            makeExtensionsImmutable();
        }
    }

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class TypeAlias extends GeneratedMessageLite.ExtendableMessage<TypeAlias> implements r {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<TypeAlias> PARSER = new a();
        private static final TypeAlias defaultInstance;
        private List<Annotation> annotation_;
        private int bitField0_;
        private int expandedTypeId_;
        private Type expandedType_;
        private int flags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private List<TypeParameter> typeParameter_;
        private int underlyingTypeId_;
        private Type underlyingType_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;
        private List<Integer> versionRequirement_;

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<TypeAlias> {
            a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
            /* renamed from: m */
            public TypeAlias c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                return new TypeAlias(eVar, fVar);
            }
        }

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class b extends GeneratedMessageLite.c<TypeAlias, b> implements r {

            /* renamed from: d  reason: collision with root package name */
            private int f57408d;

            /* renamed from: f  reason: collision with root package name */
            private int f57410f;

            /* renamed from: i  reason: collision with root package name */
            private int f57413i;

            /* renamed from: k  reason: collision with root package name */
            private int f57415k;

            /* renamed from: e  reason: collision with root package name */
            private int f57409e = 6;

            /* renamed from: g  reason: collision with root package name */
            private List<TypeParameter> f57411g = Collections.emptyList();

            /* renamed from: h  reason: collision with root package name */
            private Type f57412h = Type.getDefaultInstance();

            /* renamed from: j  reason: collision with root package name */
            private Type f57414j = Type.getDefaultInstance();

            /* renamed from: l  reason: collision with root package name */
            private List<Annotation> f57416l = Collections.emptyList();

            /* renamed from: m  reason: collision with root package name */
            private List<Integer> f57417m = Collections.emptyList();

            private b() {
                I();
            }

            private void I() {
            }

            static /* synthetic */ b p() {
                return t();
            }

            private static b t() {
                return new b();
            }

            private void u() {
                if ((this.f57408d & 128) != 128) {
                    this.f57416l = new ArrayList(this.f57416l);
                    this.f57408d |= 128;
                }
            }

            private void v() {
                if ((this.f57408d & 4) != 4) {
                    this.f57411g = new ArrayList(this.f57411g);
                    this.f57408d |= 4;
                }
            }

            private void x() {
                if ((this.f57408d & 256) != 256) {
                    this.f57417m = new ArrayList(this.f57417m);
                    this.f57408d |= 256;
                }
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, kotlin.reflect.jvm.internal.impl.protobuf.o
            /* renamed from: A */
            public TypeAlias getDefaultInstanceForType() {
                return TypeAlias.getDefaultInstance();
            }

            public Type B() {
                return this.f57414j;
            }

            public TypeParameter C(int i4) {
                return this.f57411g.get(i4);
            }

            public int D() {
                return this.f57411g.size();
            }

            public Type E() {
                return this.f57412h;
            }

            public boolean F() {
                return (this.f57408d & 32) == 32;
            }

            public boolean G() {
                return (this.f57408d & 2) == 2;
            }

            public boolean H() {
                return (this.f57408d & 8) == 8;
            }

            public b J(Type type) {
                if ((this.f57408d & 32) == 32 && this.f57414j != Type.getDefaultInstance()) {
                    this.f57414j = Type.newBuilder(this.f57414j).h(type).r();
                } else {
                    this.f57414j = type;
                }
                this.f57408d |= 32;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: K */
            public b h(TypeAlias typeAlias) {
                if (typeAlias == TypeAlias.getDefaultInstance()) {
                    return this;
                }
                if (typeAlias.hasFlags()) {
                    O(typeAlias.getFlags());
                }
                if (typeAlias.hasName()) {
                    P(typeAlias.getName());
                }
                if (!typeAlias.typeParameter_.isEmpty()) {
                    if (this.f57411g.isEmpty()) {
                        this.f57411g = typeAlias.typeParameter_;
                        this.f57408d &= -5;
                    } else {
                        v();
                        this.f57411g.addAll(typeAlias.typeParameter_);
                    }
                }
                if (typeAlias.hasUnderlyingType()) {
                    M(typeAlias.getUnderlyingType());
                }
                if (typeAlias.hasUnderlyingTypeId()) {
                    Q(typeAlias.getUnderlyingTypeId());
                }
                if (typeAlias.hasExpandedType()) {
                    J(typeAlias.getExpandedType());
                }
                if (typeAlias.hasExpandedTypeId()) {
                    N(typeAlias.getExpandedTypeId());
                }
                if (!typeAlias.annotation_.isEmpty()) {
                    if (this.f57416l.isEmpty()) {
                        this.f57416l = typeAlias.annotation_;
                        this.f57408d &= -129;
                    } else {
                        u();
                        this.f57416l.addAll(typeAlias.annotation_);
                    }
                }
                if (!typeAlias.versionRequirement_.isEmpty()) {
                    if (this.f57417m.isEmpty()) {
                        this.f57417m = typeAlias.versionRequirement_;
                        this.f57408d &= -257;
                    } else {
                        x();
                        this.f57417m.addAll(typeAlias.versionRequirement_);
                    }
                }
                o(typeAlias);
                i(f().c(typeAlias.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC1158a, kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: L */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias.b g(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.h(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1b
                L11:
                    r3 = move-exception
                    kotlin.reflect.jvm.internal.impl.protobuf.n r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> Lf
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias) r4     // Catch: java.lang.Throwable -> Lf
                    throw r3     // Catch: java.lang.Throwable -> L19
                L19:
                    r3 = move-exception
                    r0 = r4
                L1b:
                    if (r0 == 0) goto L20
                    r2.h(r0)
                L20:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeAlias.b.g(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias$b");
            }

            public b M(Type type) {
                if ((this.f57408d & 8) == 8 && this.f57412h != Type.getDefaultInstance()) {
                    this.f57412h = Type.newBuilder(this.f57412h).h(type).r();
                } else {
                    this.f57412h = type;
                }
                this.f57408d |= 8;
                return this;
            }

            public b N(int i4) {
                this.f57408d |= 64;
                this.f57415k = i4;
                return this;
            }

            public b O(int i4) {
                this.f57408d |= 1;
                this.f57409e = i4;
                return this;
            }

            public b P(int i4) {
                this.f57408d |= 2;
                this.f57410f = i4;
                return this;
            }

            public b Q(int i4) {
                this.f57408d |= 16;
                this.f57413i = i4;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public final boolean isInitialized() {
                if (G()) {
                    for (int i4 = 0; i4 < D(); i4++) {
                        if (!C(i4).isInitialized()) {
                            return false;
                        }
                    }
                    if (!H() || E().isInitialized()) {
                        if (!F() || B().isInitialized()) {
                            for (int i5 = 0; i5 < z(); i5++) {
                                if (!y(i5).isInitialized()) {
                                    return false;
                                }
                            }
                            return n();
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: q */
            public TypeAlias build() {
                TypeAlias r3 = r();
                if (r3.isInitialized()) {
                    return r3;
                }
                throw a.AbstractC1158a.c(r3);
            }

            public TypeAlias r() {
                TypeAlias typeAlias = new TypeAlias(this);
                int i4 = this.f57408d;
                int i5 = (i4 & 1) != 1 ? 0 : 1;
                typeAlias.flags_ = this.f57409e;
                if ((i4 & 2) == 2) {
                    i5 |= 2;
                }
                typeAlias.name_ = this.f57410f;
                if ((this.f57408d & 4) == 4) {
                    this.f57411g = Collections.unmodifiableList(this.f57411g);
                    this.f57408d &= -5;
                }
                typeAlias.typeParameter_ = this.f57411g;
                if ((i4 & 8) == 8) {
                    i5 |= 4;
                }
                typeAlias.underlyingType_ = this.f57412h;
                if ((i4 & 16) == 16) {
                    i5 |= 8;
                }
                typeAlias.underlyingTypeId_ = this.f57413i;
                if ((i4 & 32) == 32) {
                    i5 |= 16;
                }
                typeAlias.expandedType_ = this.f57414j;
                if ((i4 & 64) == 64) {
                    i5 |= 32;
                }
                typeAlias.expandedTypeId_ = this.f57415k;
                if ((this.f57408d & 128) == 128) {
                    this.f57416l = Collections.unmodifiableList(this.f57416l);
                    this.f57408d &= -129;
                }
                typeAlias.annotation_ = this.f57416l;
                if ((this.f57408d & 256) == 256) {
                    this.f57417m = Collections.unmodifiableList(this.f57417m);
                    this.f57408d &= -257;
                }
                typeAlias.versionRequirement_ = this.f57417m;
                typeAlias.bitField0_ = i5;
                return typeAlias;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.c
            /* renamed from: s */
            public b l() {
                return t().h(r());
            }

            public Annotation y(int i4) {
                return this.f57416l.get(i4);
            }

            public int z() {
                return this.f57416l.size();
            }
        }

        static {
            TypeAlias typeAlias = new TypeAlias(true);
            defaultInstance = typeAlias;
            typeAlias.initFields();
        }

        public static TypeAlias getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.flags_ = 6;
            this.name_ = 0;
            this.typeParameter_ = Collections.emptyList();
            this.underlyingType_ = Type.getDefaultInstance();
            this.underlyingTypeId_ = 0;
            this.expandedType_ = Type.getDefaultInstance();
            this.expandedTypeId_ = 0;
            this.annotation_ = Collections.emptyList();
            this.versionRequirement_ = Collections.emptyList();
        }

        public static b newBuilder() {
            return b.p();
        }

        public static TypeAlias parseDelimitedFrom(InputStream inputStream, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws IOException {
            return PARSER.d(inputStream, fVar);
        }

        public Annotation getAnnotation(int i4) {
            return this.annotation_.get(i4);
        }

        public int getAnnotationCount() {
            return this.annotation_.size();
        }

        public List<Annotation> getAnnotationList() {
            return this.annotation_;
        }

        public Type getExpandedType() {
            return this.expandedType_;
        }

        public int getExpandedTypeId() {
            return this.expandedTypeId_;
        }

        public int getFlags() {
            return this.flags_;
        }

        public int getName() {
            return this.name_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
        public kotlin.reflect.jvm.internal.impl.protobuf.p<TypeAlias> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public int getSerializedSize() {
            int i4 = this.memoizedSerializedSize;
            if (i4 != -1) {
                return i4;
            }
            int o4 = (this.bitField0_ & 1) == 1 ? CodedOutputStream.o(1, this.flags_) + 0 : 0;
            if ((this.bitField0_ & 2) == 2) {
                o4 += CodedOutputStream.o(2, this.name_);
            }
            for (int i5 = 0; i5 < this.typeParameter_.size(); i5++) {
                o4 += CodedOutputStream.s(3, this.typeParameter_.get(i5));
            }
            if ((this.bitField0_ & 4) == 4) {
                o4 += CodedOutputStream.s(4, this.underlyingType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                o4 += CodedOutputStream.o(5, this.underlyingTypeId_);
            }
            if ((this.bitField0_ & 16) == 16) {
                o4 += CodedOutputStream.s(6, this.expandedType_);
            }
            if ((this.bitField0_ & 32) == 32) {
                o4 += CodedOutputStream.o(7, this.expandedTypeId_);
            }
            for (int i6 = 0; i6 < this.annotation_.size(); i6++) {
                o4 += CodedOutputStream.s(8, this.annotation_.get(i6));
            }
            int i7 = 0;
            for (int i8 = 0; i8 < this.versionRequirement_.size(); i8++) {
                i7 += CodedOutputStream.p(this.versionRequirement_.get(i8).intValue());
            }
            int size = o4 + i7 + (getVersionRequirementList().size() * 2) + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public TypeParameter getTypeParameter(int i4) {
            return this.typeParameter_.get(i4);
        }

        public int getTypeParameterCount() {
            return this.typeParameter_.size();
        }

        public List<TypeParameter> getTypeParameterList() {
            return this.typeParameter_;
        }

        public Type getUnderlyingType() {
            return this.underlyingType_;
        }

        public int getUnderlyingTypeId() {
            return this.underlyingTypeId_;
        }

        public List<Integer> getVersionRequirementList() {
            return this.versionRequirement_;
        }

        public boolean hasExpandedType() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean hasExpandedTypeId() {
            return (this.bitField0_ & 32) == 32;
        }

        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasName() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasUnderlyingType() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasUnderlyingTypeId() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public final boolean isInitialized() {
            byte b4 = this.memoizedIsInitialized;
            if (b4 == 1) {
                return true;
            }
            if (b4 == 0) {
                return false;
            }
            if (!hasName()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            }
            for (int i4 = 0; i4 < getTypeParameterCount(); i4++) {
                if (!getTypeParameter(i4).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            if (hasUnderlyingType() && !getUnderlyingType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (hasExpandedType() && !getExpandedType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else {
                for (int i5 = 0; i5 < getAnnotationCount(); i5++) {
                    if (!getAnnotation(i5).isInitialized()) {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                if (!extensionsAreInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.a newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.a0(1, this.flags_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.a0(2, this.name_);
            }
            for (int i4 = 0; i4 < this.typeParameter_.size(); i4++) {
                codedOutputStream.d0(3, this.typeParameter_.get(i4));
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.d0(4, this.underlyingType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.a0(5, this.underlyingTypeId_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.d0(6, this.expandedType_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.a0(7, this.expandedTypeId_);
            }
            for (int i5 = 0; i5 < this.annotation_.size(); i5++) {
                codedOutputStream.d0(8, this.annotation_.get(i5));
            }
            for (int i6 = 0; i6 < this.versionRequirement_.size(); i6++) {
                codedOutputStream.a0(31, this.versionRequirement_.get(i6).intValue());
            }
            newExtensionWriter.a(200, codedOutputStream);
            codedOutputStream.i0(this.unknownFields);
        }

        public static b newBuilder(TypeAlias typeAlias) {
            return newBuilder().h(typeAlias);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public TypeAlias getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b toBuilder() {
            return newBuilder(this);
        }

        private TypeAlias(GeneratedMessageLite.c<TypeAlias, ?> cVar) {
            super(cVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = cVar.f();
        }

        private TypeAlias(boolean z3) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f57629a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v0 */
        /* JADX WARN: Type inference failed for: r5v1 */
        /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
        private TypeAlias(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
            Type.b builder;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            d.b u3 = kotlin.reflect.jvm.internal.impl.protobuf.d.u();
            CodedOutputStream J = CodedOutputStream.J(u3, 1);
            boolean z3 = false;
            boolean z4 = false;
            while (true) {
                ?? r5 = 128;
                if (!z3) {
                    try {
                        try {
                            try {
                                int K = eVar.K();
                                switch (K) {
                                    case 0:
                                        break;
                                    case 8:
                                        this.bitField0_ |= 1;
                                        this.flags_ = eVar.s();
                                        continue;
                                    case 16:
                                        this.bitField0_ |= 2;
                                        this.name_ = eVar.s();
                                        continue;
                                    case 26:
                                        if (!(z4 & true)) {
                                            this.typeParameter_ = new ArrayList();
                                            z4 |= true;
                                        }
                                        this.typeParameter_.add(eVar.u(TypeParameter.PARSER, fVar));
                                        continue;
                                    case 34:
                                        builder = (this.bitField0_ & 4) == 4 ? this.underlyingType_.toBuilder() : null;
                                        Type type = (Type) eVar.u(Type.PARSER, fVar);
                                        this.underlyingType_ = type;
                                        if (builder != null) {
                                            builder.h(type);
                                            this.underlyingType_ = builder.r();
                                        }
                                        this.bitField0_ |= 4;
                                        continue;
                                    case 40:
                                        this.bitField0_ |= 8;
                                        this.underlyingTypeId_ = eVar.s();
                                        continue;
                                    case 50:
                                        builder = (this.bitField0_ & 16) == 16 ? this.expandedType_.toBuilder() : null;
                                        Type type2 = (Type) eVar.u(Type.PARSER, fVar);
                                        this.expandedType_ = type2;
                                        if (builder != null) {
                                            builder.h(type2);
                                            this.expandedType_ = builder.r();
                                        }
                                        this.bitField0_ |= 16;
                                        continue;
                                    case 56:
                                        this.bitField0_ |= 32;
                                        this.expandedTypeId_ = eVar.s();
                                        continue;
                                    case 66:
                                        if (!(z4 & true)) {
                                            this.annotation_ = new ArrayList();
                                            z4 |= true;
                                        }
                                        this.annotation_.add(eVar.u(Annotation.PARSER, fVar));
                                        continue;
                                    case MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT /* 248 */:
                                        if (!(z4 & true)) {
                                            this.versionRequirement_ = new ArrayList();
                                            z4 |= true;
                                        }
                                        this.versionRequirement_.add(Integer.valueOf(eVar.s()));
                                        continue;
                                    case 250:
                                        int j4 = eVar.j(eVar.A());
                                        if (!(z4 & true) && eVar.e() > 0) {
                                            this.versionRequirement_ = new ArrayList();
                                            z4 |= true;
                                        }
                                        while (eVar.e() > 0) {
                                            this.versionRequirement_.add(Integer.valueOf(eVar.s()));
                                        }
                                        eVar.i(j4);
                                        continue;
                                        break;
                                    default:
                                        r5 = parseUnknownField(eVar, J, fVar, K);
                                        if (r5 == 0) {
                                            break;
                                        } else {
                                            continue;
                                        }
                                }
                                z3 = true;
                            } catch (InvalidProtocolBufferException e4) {
                                throw e4.setUnfinishedMessage(this);
                            }
                        } catch (IOException e5) {
                            throw new InvalidProtocolBufferException(e5.getMessage()).setUnfinishedMessage(this);
                        }
                    } catch (Throwable th) {
                        if (z4 & true) {
                            this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                        }
                        if ((z4 & true) == r5) {
                            this.annotation_ = Collections.unmodifiableList(this.annotation_);
                        }
                        if (z4 & true) {
                            this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                        }
                        try {
                            J.I();
                        } catch (IOException unused) {
                        } catch (Throwable th2) {
                            this.unknownFields = u3.g();
                            throw th2;
                        }
                        this.unknownFields = u3.g();
                        makeExtensionsImmutable();
                        throw th;
                    }
                } else {
                    if (z4 & true) {
                        this.typeParameter_ = Collections.unmodifiableList(this.typeParameter_);
                    }
                    if (z4 & true) {
                        this.annotation_ = Collections.unmodifiableList(this.annotation_);
                    }
                    if (z4 & true) {
                        this.versionRequirement_ = Collections.unmodifiableList(this.versionRequirement_);
                    }
                    try {
                        J.I();
                    } catch (IOException unused2) {
                    } catch (Throwable th3) {
                        this.unknownFields = u3.g();
                        throw th3;
                    }
                    this.unknownFields = u3.g();
                    makeExtensionsImmutable();
                    return;
                }
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class TypeParameter extends GeneratedMessageLite.ExtendableMessage<TypeParameter> implements t {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<TypeParameter> PARSER = new a();
        private static final TypeParameter defaultInstance;
        private int bitField0_;
        private int id_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private boolean reified_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;
        private int upperBoundIdMemoizedSerializedSize;
        private List<Integer> upperBoundId_;
        private List<Type> upperBound_;
        private Variance variance_;

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public enum Variance implements h.a {
            IN(0, 0),
            OUT(1, 1),
            INV(2, 2);
            
            private static h.b<Variance> internalValueMap = new a();
            private final int value;

            /* loaded from: E:\TSN-r\205dec\7343912.dex */
            static class a implements h.b<Variance> {
                a() {
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
                /* renamed from: b */
                public Variance a(int i4) {
                    return Variance.valueOf(i4);
                }
            }

            Variance(int i4, int i5) {
                this.value = i5;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.a
            public final int getNumber() {
                return this.value;
            }

            public static Variance valueOf(int i4) {
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 != 2) {
                            return null;
                        }
                        return INV;
                    }
                    return OUT;
                }
                return IN;
            }
        }

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<TypeParameter> {
            a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
            /* renamed from: m */
            public TypeParameter c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                return new TypeParameter(eVar, fVar);
            }
        }

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class b extends GeneratedMessageLite.c<TypeParameter, b> implements t {

            /* renamed from: d  reason: collision with root package name */
            private int f57418d;

            /* renamed from: e  reason: collision with root package name */
            private int f57419e;

            /* renamed from: f  reason: collision with root package name */
            private int f57420f;

            /* renamed from: g  reason: collision with root package name */
            private boolean f57421g;

            /* renamed from: h  reason: collision with root package name */
            private Variance f57422h = Variance.INV;

            /* renamed from: i  reason: collision with root package name */
            private List<Type> f57423i = Collections.emptyList();

            /* renamed from: j  reason: collision with root package name */
            private List<Integer> f57424j = Collections.emptyList();

            private b() {
                C();
            }

            private void C() {
            }

            static /* synthetic */ b p() {
                return t();
            }

            private static b t() {
                return new b();
            }

            private void u() {
                if ((this.f57418d & 32) != 32) {
                    this.f57424j = new ArrayList(this.f57424j);
                    this.f57418d |= 32;
                }
            }

            private void v() {
                if ((this.f57418d & 16) != 16) {
                    this.f57423i = new ArrayList(this.f57423i);
                    this.f57418d |= 16;
                }
            }

            public boolean A() {
                return (this.f57418d & 1) == 1;
            }

            public boolean B() {
                return (this.f57418d & 2) == 2;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: D */
            public b h(TypeParameter typeParameter) {
                if (typeParameter == TypeParameter.getDefaultInstance()) {
                    return this;
                }
                if (typeParameter.hasId()) {
                    F(typeParameter.getId());
                }
                if (typeParameter.hasName()) {
                    G(typeParameter.getName());
                }
                if (typeParameter.hasReified()) {
                    H(typeParameter.getReified());
                }
                if (typeParameter.hasVariance()) {
                    I(typeParameter.getVariance());
                }
                if (!typeParameter.upperBound_.isEmpty()) {
                    if (this.f57423i.isEmpty()) {
                        this.f57423i = typeParameter.upperBound_;
                        this.f57418d &= -17;
                    } else {
                        v();
                        this.f57423i.addAll(typeParameter.upperBound_);
                    }
                }
                if (!typeParameter.upperBoundId_.isEmpty()) {
                    if (this.f57424j.isEmpty()) {
                        this.f57424j = typeParameter.upperBoundId_;
                        this.f57418d &= -33;
                    } else {
                        u();
                        this.f57424j.addAll(typeParameter.upperBoundId_);
                    }
                }
                o(typeParameter);
                i(f().c(typeParameter.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC1158a, kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: E */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter.b g(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.h(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1b
                L11:
                    r3 = move-exception
                    kotlin.reflect.jvm.internal.impl.protobuf.n r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> Lf
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter) r4     // Catch: java.lang.Throwable -> Lf
                    throw r3     // Catch: java.lang.Throwable -> L19
                L19:
                    r3 = move-exception
                    r0 = r4
                L1b:
                    if (r0 == 0) goto L20
                    r2.h(r0)
                L20:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeParameter.b.g(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter$b");
            }

            public b F(int i4) {
                this.f57418d |= 1;
                this.f57419e = i4;
                return this;
            }

            public b G(int i4) {
                this.f57418d |= 2;
                this.f57420f = i4;
                return this;
            }

            public b H(boolean z3) {
                this.f57418d |= 4;
                this.f57421g = z3;
                return this;
            }

            public b I(Variance variance) {
                variance.getClass();
                this.f57418d |= 8;
                this.f57422h = variance;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public final boolean isInitialized() {
                if (A() && B()) {
                    for (int i4 = 0; i4 < z(); i4++) {
                        if (!y(i4).isInitialized()) {
                            return false;
                        }
                    }
                    return n();
                }
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: q */
            public TypeParameter build() {
                TypeParameter r3 = r();
                if (r3.isInitialized()) {
                    return r3;
                }
                throw a.AbstractC1158a.c(r3);
            }

            public TypeParameter r() {
                TypeParameter typeParameter = new TypeParameter(this);
                int i4 = this.f57418d;
                int i5 = (i4 & 1) != 1 ? 0 : 1;
                typeParameter.id_ = this.f57419e;
                if ((i4 & 2) == 2) {
                    i5 |= 2;
                }
                typeParameter.name_ = this.f57420f;
                if ((i4 & 4) == 4) {
                    i5 |= 4;
                }
                typeParameter.reified_ = this.f57421g;
                if ((i4 & 8) == 8) {
                    i5 |= 8;
                }
                typeParameter.variance_ = this.f57422h;
                if ((this.f57418d & 16) == 16) {
                    this.f57423i = Collections.unmodifiableList(this.f57423i);
                    this.f57418d &= -17;
                }
                typeParameter.upperBound_ = this.f57423i;
                if ((this.f57418d & 32) == 32) {
                    this.f57424j = Collections.unmodifiableList(this.f57424j);
                    this.f57418d &= -33;
                }
                typeParameter.upperBoundId_ = this.f57424j;
                typeParameter.bitField0_ = i5;
                return typeParameter;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.c
            /* renamed from: s */
            public b l() {
                return t().h(r());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, kotlin.reflect.jvm.internal.impl.protobuf.o
            /* renamed from: x */
            public TypeParameter getDefaultInstanceForType() {
                return TypeParameter.getDefaultInstance();
            }

            public Type y(int i4) {
                return this.f57423i.get(i4);
            }

            public int z() {
                return this.f57423i.size();
            }
        }

        static {
            TypeParameter typeParameter = new TypeParameter(true);
            defaultInstance = typeParameter;
            typeParameter.initFields();
        }

        public static TypeParameter getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.id_ = 0;
            this.name_ = 0;
            this.reified_ = false;
            this.variance_ = Variance.INV;
            this.upperBound_ = Collections.emptyList();
            this.upperBoundId_ = Collections.emptyList();
        }

        public static b newBuilder() {
            return b.p();
        }

        public int getId() {
            return this.id_;
        }

        public int getName() {
            return this.name_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
        public kotlin.reflect.jvm.internal.impl.protobuf.p<TypeParameter> getParserForType() {
            return PARSER;
        }

        public boolean getReified() {
            return this.reified_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public int getSerializedSize() {
            int i4 = this.memoizedSerializedSize;
            if (i4 != -1) {
                return i4;
            }
            int o4 = (this.bitField0_ & 1) == 1 ? CodedOutputStream.o(1, this.id_) + 0 : 0;
            if ((this.bitField0_ & 2) == 2) {
                o4 += CodedOutputStream.o(2, this.name_);
            }
            if ((this.bitField0_ & 4) == 4) {
                o4 += CodedOutputStream.a(3, this.reified_);
            }
            if ((this.bitField0_ & 8) == 8) {
                o4 += CodedOutputStream.h(4, this.variance_.getNumber());
            }
            for (int i5 = 0; i5 < this.upperBound_.size(); i5++) {
                o4 += CodedOutputStream.s(5, this.upperBound_.get(i5));
            }
            int i6 = 0;
            for (int i7 = 0; i7 < this.upperBoundId_.size(); i7++) {
                i6 += CodedOutputStream.p(this.upperBoundId_.get(i7).intValue());
            }
            int i8 = o4 + i6;
            if (!getUpperBoundIdList().isEmpty()) {
                i8 = i8 + 1 + CodedOutputStream.p(i6);
            }
            this.upperBoundIdMemoizedSerializedSize = i6;
            int extensionsSerializedSize = i8 + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public Type getUpperBound(int i4) {
            return this.upperBound_.get(i4);
        }

        public int getUpperBoundCount() {
            return this.upperBound_.size();
        }

        public List<Integer> getUpperBoundIdList() {
            return this.upperBoundId_;
        }

        public List<Type> getUpperBoundList() {
            return this.upperBound_;
        }

        public Variance getVariance() {
            return this.variance_;
        }

        public boolean hasId() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasName() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasReified() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasVariance() {
            return (this.bitField0_ & 8) == 8;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public final boolean isInitialized() {
            byte b4 = this.memoizedIsInitialized;
            if (b4 == 1) {
                return true;
            }
            if (b4 == 0) {
                return false;
            }
            if (!hasId()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (!hasName()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else {
                for (int i4 = 0; i4 < getUpperBoundCount(); i4++) {
                    if (!getUpperBound(i4).isInitialized()) {
                        this.memoizedIsInitialized = (byte) 0;
                        return false;
                    }
                }
                if (!extensionsAreInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.a newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.a0(1, this.id_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.a0(2, this.name_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.L(3, this.reified_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.S(4, this.variance_.getNumber());
            }
            for (int i4 = 0; i4 < this.upperBound_.size(); i4++) {
                codedOutputStream.d0(5, this.upperBound_.get(i4));
            }
            if (getUpperBoundIdList().size() > 0) {
                codedOutputStream.o0(50);
                codedOutputStream.o0(this.upperBoundIdMemoizedSerializedSize);
            }
            for (int i5 = 0; i5 < this.upperBoundId_.size(); i5++) {
                codedOutputStream.b0(this.upperBoundId_.get(i5).intValue());
            }
            newExtensionWriter.a(1000, codedOutputStream);
            codedOutputStream.i0(this.unknownFields);
        }

        public static b newBuilder(TypeParameter typeParameter) {
            return newBuilder().h(typeParameter);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public TypeParameter getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b toBuilder() {
            return newBuilder(this);
        }

        private TypeParameter(GeneratedMessageLite.c<TypeParameter, ?> cVar) {
            super(cVar);
            this.upperBoundIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = cVar.f();
        }

        private TypeParameter(boolean z3) {
            this.upperBoundIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f57629a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private TypeParameter(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
            this.upperBoundIdMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            d.b u3 = kotlin.reflect.jvm.internal.impl.protobuf.d.u();
            CodedOutputStream J = CodedOutputStream.J(u3, 1);
            boolean z3 = false;
            boolean z4 = false;
            while (!z3) {
                try {
                    try {
                        try {
                            int K = eVar.K();
                            if (K != 0) {
                                if (K == 8) {
                                    this.bitField0_ |= 1;
                                    this.id_ = eVar.s();
                                } else if (K == 16) {
                                    this.bitField0_ |= 2;
                                    this.name_ = eVar.s();
                                } else if (K == 24) {
                                    this.bitField0_ |= 4;
                                    this.reified_ = eVar.k();
                                } else if (K == 32) {
                                    int n4 = eVar.n();
                                    Variance valueOf = Variance.valueOf(n4);
                                    if (valueOf == null) {
                                        J.o0(K);
                                        J.o0(n4);
                                    } else {
                                        this.bitField0_ |= 8;
                                        this.variance_ = valueOf;
                                    }
                                } else if (K == 42) {
                                    if (!(z4 & true)) {
                                        this.upperBound_ = new ArrayList();
                                        z4 |= true;
                                    }
                                    this.upperBound_.add(eVar.u(Type.PARSER, fVar));
                                } else if (K == 48) {
                                    if (!(z4 & true)) {
                                        this.upperBoundId_ = new ArrayList();
                                        z4 |= true;
                                    }
                                    this.upperBoundId_.add(Integer.valueOf(eVar.s()));
                                } else if (K != 50) {
                                    if (!parseUnknownField(eVar, J, fVar, K)) {
                                    }
                                } else {
                                    int j4 = eVar.j(eVar.A());
                                    if (!(z4 & true) && eVar.e() > 0) {
                                        this.upperBoundId_ = new ArrayList();
                                        z4 |= true;
                                    }
                                    while (eVar.e() > 0) {
                                        this.upperBoundId_.add(Integer.valueOf(eVar.s()));
                                    }
                                    eVar.i(j4);
                                }
                            }
                            z3 = true;
                        } catch (InvalidProtocolBufferException e4) {
                            throw e4.setUnfinishedMessage(this);
                        }
                    } catch (IOException e5) {
                        throw new InvalidProtocolBufferException(e5.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    if (z4 & true) {
                        this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
                    }
                    if (z4 & true) {
                        this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
                    }
                    try {
                        J.I();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.unknownFields = u3.g();
                        throw th2;
                    }
                    this.unknownFields = u3.g();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z4 & true) {
                this.upperBound_ = Collections.unmodifiableList(this.upperBound_);
            }
            if (z4 & true) {
                this.upperBoundId_ = Collections.unmodifiableList(this.upperBoundId_);
            }
            try {
                J.I();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.unknownFields = u3.g();
                throw th3;
            }
            this.unknownFields = u3.g();
            makeExtensionsImmutable();
        }
    }

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class TypeTable extends GeneratedMessageLite implements u {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<TypeTable> PARSER = new a();
        private static final TypeTable defaultInstance;
        private int bitField0_;
        private int firstNullable_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<Type> type_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<TypeTable> {
            a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
            /* renamed from: m */
            public TypeTable c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                return new TypeTable(eVar, fVar);
            }
        }

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class b extends GeneratedMessageLite.b<TypeTable, b> implements u {

            /* renamed from: b  reason: collision with root package name */
            private int f57425b;

            /* renamed from: c  reason: collision with root package name */
            private List<Type> f57426c = Collections.emptyList();

            /* renamed from: d  reason: collision with root package name */
            private int f57427d = -1;

            private b() {
                r();
            }

            static /* synthetic */ b j() {
                return n();
            }

            private static b n() {
                return new b();
            }

            private void o() {
                if ((this.f57425b & 1) != 1) {
                    this.f57426c = new ArrayList(this.f57426c);
                    this.f57425b |= 1;
                }
            }

            private void r() {
            }

            public Type getType(int i4) {
                return this.f57426c.get(i4);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public final boolean isInitialized() {
                for (int i4 = 0; i4 < q(); i4++) {
                    if (!getType(i4).isInitialized()) {
                        return false;
                    }
                }
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: k */
            public TypeTable build() {
                TypeTable l4 = l();
                if (l4.isInitialized()) {
                    return l4;
                }
                throw a.AbstractC1158a.c(l4);
            }

            public TypeTable l() {
                TypeTable typeTable = new TypeTable(this);
                int i4 = this.f57425b;
                if ((i4 & 1) == 1) {
                    this.f57426c = Collections.unmodifiableList(this.f57426c);
                    this.f57425b &= -2;
                }
                typeTable.type_ = this.f57426c;
                int i5 = (i4 & 2) != 2 ? 0 : 1;
                typeTable.firstNullable_ = this.f57427d;
                typeTable.bitField0_ = i5;
                return typeTable;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: m */
            public b d() {
                return n().h(l());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, kotlin.reflect.jvm.internal.impl.protobuf.o
            /* renamed from: p */
            public TypeTable getDefaultInstanceForType() {
                return TypeTable.getDefaultInstance();
            }

            public int q() {
                return this.f57426c.size();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: s */
            public b h(TypeTable typeTable) {
                if (typeTable == TypeTable.getDefaultInstance()) {
                    return this;
                }
                if (!typeTable.type_.isEmpty()) {
                    if (this.f57426c.isEmpty()) {
                        this.f57426c = typeTable.type_;
                        this.f57425b &= -2;
                    } else {
                        o();
                        this.f57426c.addAll(typeTable.type_);
                    }
                }
                if (typeTable.hasFirstNullable()) {
                    u(typeTable.getFirstNullable());
                }
                i(f().c(typeTable.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC1158a, kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: t */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeTable.b g(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeTable.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeTable) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.h(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1b
                L11:
                    r3 = move-exception
                    kotlin.reflect.jvm.internal.impl.protobuf.n r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> Lf
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeTable) r4     // Catch: java.lang.Throwable -> Lf
                    throw r3     // Catch: java.lang.Throwable -> L19
                L19:
                    r3 = move-exception
                    r0 = r4
                L1b:
                    if (r0 == 0) goto L20
                    r2.h(r0)
                L20:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.TypeTable.b.g(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable$b");
            }

            public b u(int i4) {
                this.f57425b |= 2;
                this.f57427d = i4;
                return this;
            }
        }

        static {
            TypeTable typeTable = new TypeTable(true);
            defaultInstance = typeTable;
            typeTable.initFields();
        }

        public static TypeTable getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.type_ = Collections.emptyList();
            this.firstNullable_ = -1;
        }

        public static b newBuilder() {
            return b.j();
        }

        public int getFirstNullable() {
            return this.firstNullable_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
        public kotlin.reflect.jvm.internal.impl.protobuf.p<TypeTable> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public int getSerializedSize() {
            int i4 = this.memoizedSerializedSize;
            if (i4 != -1) {
                return i4;
            }
            int i5 = 0;
            for (int i6 = 0; i6 < this.type_.size(); i6++) {
                i5 += CodedOutputStream.s(1, this.type_.get(i6));
            }
            if ((this.bitField0_ & 1) == 1) {
                i5 += CodedOutputStream.o(2, this.firstNullable_);
            }
            int size = i5 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public Type getType(int i4) {
            return this.type_.get(i4);
        }

        public int getTypeCount() {
            return this.type_.size();
        }

        public List<Type> getTypeList() {
            return this.type_;
        }

        public boolean hasFirstNullable() {
            return (this.bitField0_ & 1) == 1;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public final boolean isInitialized() {
            byte b4 = this.memoizedIsInitialized;
            if (b4 == 1) {
                return true;
            }
            if (b4 == 0) {
                return false;
            }
            for (int i4 = 0; i4 < getTypeCount(); i4++) {
                if (!getType(i4).isInitialized()) {
                    this.memoizedIsInitialized = (byte) 0;
                    return false;
                }
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            for (int i4 = 0; i4 < this.type_.size(); i4++) {
                codedOutputStream.d0(1, this.type_.get(i4));
            }
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.a0(2, this.firstNullable_);
            }
            codedOutputStream.i0(this.unknownFields);
        }

        public static b newBuilder(TypeTable typeTable) {
            return newBuilder().h(typeTable);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public TypeTable getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b toBuilder() {
            return newBuilder(this);
        }

        private TypeTable(GeneratedMessageLite.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.f();
        }

        private TypeTable(boolean z3) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f57629a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private TypeTable(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            d.b u3 = kotlin.reflect.jvm.internal.impl.protobuf.d.u();
            CodedOutputStream J = CodedOutputStream.J(u3, 1);
            boolean z3 = false;
            boolean z4 = false;
            while (!z3) {
                try {
                    try {
                        int K = eVar.K();
                        if (K != 0) {
                            if (K == 10) {
                                if (!(z4 & true)) {
                                    this.type_ = new ArrayList();
                                    z4 |= true;
                                }
                                this.type_.add(eVar.u(Type.PARSER, fVar));
                            } else if (K != 16) {
                                if (!parseUnknownField(eVar, J, fVar, K)) {
                                }
                            } else {
                                this.bitField0_ |= 1;
                                this.firstNullable_ = eVar.s();
                            }
                        }
                        z3 = true;
                    } catch (InvalidProtocolBufferException e4) {
                        throw e4.setUnfinishedMessage(this);
                    } catch (IOException e5) {
                        throw new InvalidProtocolBufferException(e5.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    if (z4 & true) {
                        this.type_ = Collections.unmodifiableList(this.type_);
                    }
                    try {
                        J.I();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.unknownFields = u3.g();
                        throw th2;
                    }
                    this.unknownFields = u3.g();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z4 & true) {
                this.type_ = Collections.unmodifiableList(this.type_);
            }
            try {
                J.I();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.unknownFields = u3.g();
                throw th3;
            }
            this.unknownFields = u3.g();
            makeExtensionsImmutable();
        }
    }

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class ValueParameter extends GeneratedMessageLite.ExtendableMessage<ValueParameter> implements v {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<ValueParameter> PARSER = new a();
        private static final ValueParameter defaultInstance;
        private int bitField0_;
        private int flags_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private int typeId_;
        private Type type_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;
        private int varargElementTypeId_;
        private Type varargElementType_;

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<ValueParameter> {
            a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
            /* renamed from: m */
            public ValueParameter c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                return new ValueParameter(eVar, fVar);
            }
        }

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class b extends GeneratedMessageLite.c<ValueParameter, b> implements v {

            /* renamed from: d  reason: collision with root package name */
            private int f57428d;

            /* renamed from: e  reason: collision with root package name */
            private int f57429e;

            /* renamed from: f  reason: collision with root package name */
            private int f57430f;

            /* renamed from: h  reason: collision with root package name */
            private int f57432h;

            /* renamed from: j  reason: collision with root package name */
            private int f57434j;

            /* renamed from: g  reason: collision with root package name */
            private Type f57431g = Type.getDefaultInstance();

            /* renamed from: i  reason: collision with root package name */
            private Type f57433i = Type.getDefaultInstance();

            private b() {
                A();
            }

            private void A() {
            }

            static /* synthetic */ b p() {
                return t();
            }

            private static b t() {
                return new b();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: B */
            public b h(ValueParameter valueParameter) {
                if (valueParameter == ValueParameter.getDefaultInstance()) {
                    return this;
                }
                if (valueParameter.hasFlags()) {
                    F(valueParameter.getFlags());
                }
                if (valueParameter.hasName()) {
                    G(valueParameter.getName());
                }
                if (valueParameter.hasType()) {
                    D(valueParameter.getType());
                }
                if (valueParameter.hasTypeId()) {
                    H(valueParameter.getTypeId());
                }
                if (valueParameter.hasVarargElementType()) {
                    E(valueParameter.getVarargElementType());
                }
                if (valueParameter.hasVarargElementTypeId()) {
                    I(valueParameter.getVarargElementTypeId());
                }
                o(valueParameter);
                i(f().c(valueParameter.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC1158a, kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: C */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter.b g(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.h(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1b
                L11:
                    r3 = move-exception
                    kotlin.reflect.jvm.internal.impl.protobuf.n r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> Lf
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter) r4     // Catch: java.lang.Throwable -> Lf
                    throw r3     // Catch: java.lang.Throwable -> L19
                L19:
                    r3 = move-exception
                    r0 = r4
                L1b:
                    if (r0 == 0) goto L20
                    r2.h(r0)
                L20:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.ValueParameter.b.g(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter$b");
            }

            public b D(Type type) {
                if ((this.f57428d & 4) == 4 && this.f57431g != Type.getDefaultInstance()) {
                    this.f57431g = Type.newBuilder(this.f57431g).h(type).r();
                } else {
                    this.f57431g = type;
                }
                this.f57428d |= 4;
                return this;
            }

            public b E(Type type) {
                if ((this.f57428d & 16) == 16 && this.f57433i != Type.getDefaultInstance()) {
                    this.f57433i = Type.newBuilder(this.f57433i).h(type).r();
                } else {
                    this.f57433i = type;
                }
                this.f57428d |= 16;
                return this;
            }

            public b F(int i4) {
                this.f57428d |= 1;
                this.f57429e = i4;
                return this;
            }

            public b G(int i4) {
                this.f57428d |= 2;
                this.f57430f = i4;
                return this;
            }

            public b H(int i4) {
                this.f57428d |= 8;
                this.f57432h = i4;
                return this;
            }

            public b I(int i4) {
                this.f57428d |= 32;
                this.f57434j = i4;
                return this;
            }

            public Type getType() {
                return this.f57431g;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public final boolean isInitialized() {
                if (x()) {
                    if (!y() || getType().isInitialized()) {
                        return (!z() || v().isInitialized()) && n();
                    }
                    return false;
                }
                return false;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: q */
            public ValueParameter build() {
                ValueParameter r3 = r();
                if (r3.isInitialized()) {
                    return r3;
                }
                throw a.AbstractC1158a.c(r3);
            }

            public ValueParameter r() {
                ValueParameter valueParameter = new ValueParameter(this);
                int i4 = this.f57428d;
                int i5 = (i4 & 1) != 1 ? 0 : 1;
                valueParameter.flags_ = this.f57429e;
                if ((i4 & 2) == 2) {
                    i5 |= 2;
                }
                valueParameter.name_ = this.f57430f;
                if ((i4 & 4) == 4) {
                    i5 |= 4;
                }
                valueParameter.type_ = this.f57431g;
                if ((i4 & 8) == 8) {
                    i5 |= 8;
                }
                valueParameter.typeId_ = this.f57432h;
                if ((i4 & 16) == 16) {
                    i5 |= 16;
                }
                valueParameter.varargElementType_ = this.f57433i;
                if ((i4 & 32) == 32) {
                    i5 |= 32;
                }
                valueParameter.varargElementTypeId_ = this.f57434j;
                valueParameter.bitField0_ = i5;
                return valueParameter;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.c
            /* renamed from: s */
            public b l() {
                return t().h(r());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, kotlin.reflect.jvm.internal.impl.protobuf.o
            /* renamed from: u */
            public ValueParameter getDefaultInstanceForType() {
                return ValueParameter.getDefaultInstance();
            }

            public Type v() {
                return this.f57433i;
            }

            public boolean x() {
                return (this.f57428d & 2) == 2;
            }

            public boolean y() {
                return (this.f57428d & 4) == 4;
            }

            public boolean z() {
                return (this.f57428d & 16) == 16;
            }
        }

        static {
            ValueParameter valueParameter = new ValueParameter(true);
            defaultInstance = valueParameter;
            valueParameter.initFields();
        }

        public static ValueParameter getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.flags_ = 0;
            this.name_ = 0;
            this.type_ = Type.getDefaultInstance();
            this.typeId_ = 0;
            this.varargElementType_ = Type.getDefaultInstance();
            this.varargElementTypeId_ = 0;
        }

        public static b newBuilder() {
            return b.p();
        }

        public int getFlags() {
            return this.flags_;
        }

        public int getName() {
            return this.name_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
        public kotlin.reflect.jvm.internal.impl.protobuf.p<ValueParameter> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public int getSerializedSize() {
            int i4 = this.memoizedSerializedSize;
            if (i4 != -1) {
                return i4;
            }
            int o4 = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.o(1, this.flags_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                o4 += CodedOutputStream.o(2, this.name_);
            }
            if ((this.bitField0_ & 4) == 4) {
                o4 += CodedOutputStream.s(3, this.type_);
            }
            if ((this.bitField0_ & 16) == 16) {
                o4 += CodedOutputStream.s(4, this.varargElementType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                o4 += CodedOutputStream.o(5, this.typeId_);
            }
            if ((this.bitField0_ & 32) == 32) {
                o4 += CodedOutputStream.o(6, this.varargElementTypeId_);
            }
            int extensionsSerializedSize = o4 + extensionsSerializedSize() + this.unknownFields.size();
            this.memoizedSerializedSize = extensionsSerializedSize;
            return extensionsSerializedSize;
        }

        public Type getType() {
            return this.type_;
        }

        public int getTypeId() {
            return this.typeId_;
        }

        public Type getVarargElementType() {
            return this.varargElementType_;
        }

        public int getVarargElementTypeId() {
            return this.varargElementTypeId_;
        }

        public boolean hasFlags() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasName() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasType() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasTypeId() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasVarargElementType() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean hasVarargElementTypeId() {
            return (this.bitField0_ & 32) == 32;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public final boolean isInitialized() {
            byte b4 = this.memoizedIsInitialized;
            if (b4 == 1) {
                return true;
            }
            if (b4 == 0) {
                return false;
            }
            if (!hasName()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (hasType() && !getType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (hasVarargElementType() && !getVarargElementType().isInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else if (!extensionsAreInitialized()) {
                this.memoizedIsInitialized = (byte) 0;
                return false;
            } else {
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            GeneratedMessageLite.ExtendableMessage<MessageType>.a newExtensionWriter = newExtensionWriter();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.a0(1, this.flags_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.a0(2, this.name_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.d0(3, this.type_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.d0(4, this.varargElementType_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.a0(5, this.typeId_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.a0(6, this.varargElementTypeId_);
            }
            newExtensionWriter.a(200, codedOutputStream);
            codedOutputStream.i0(this.unknownFields);
        }

        public static b newBuilder(ValueParameter valueParameter) {
            return newBuilder().h(valueParameter);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public ValueParameter getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b toBuilder() {
            return newBuilder(this);
        }

        private ValueParameter(GeneratedMessageLite.c<ValueParameter, ?> cVar) {
            super(cVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = cVar.f();
        }

        private ValueParameter(boolean z3) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f57629a;
        }

        private ValueParameter(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
            Type.b builder;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            d.b u3 = kotlin.reflect.jvm.internal.impl.protobuf.d.u();
            CodedOutputStream J = CodedOutputStream.J(u3, 1);
            boolean z3 = false;
            while (!z3) {
                try {
                    try {
                        try {
                            int K = eVar.K();
                            if (K != 0) {
                                if (K == 8) {
                                    this.bitField0_ |= 1;
                                    this.flags_ = eVar.s();
                                } else if (K != 16) {
                                    if (K == 26) {
                                        builder = (this.bitField0_ & 4) == 4 ? this.type_.toBuilder() : null;
                                        Type type = (Type) eVar.u(Type.PARSER, fVar);
                                        this.type_ = type;
                                        if (builder != null) {
                                            builder.h(type);
                                            this.type_ = builder.r();
                                        }
                                        this.bitField0_ |= 4;
                                    } else if (K == 34) {
                                        builder = (this.bitField0_ & 16) == 16 ? this.varargElementType_.toBuilder() : null;
                                        Type type2 = (Type) eVar.u(Type.PARSER, fVar);
                                        this.varargElementType_ = type2;
                                        if (builder != null) {
                                            builder.h(type2);
                                            this.varargElementType_ = builder.r();
                                        }
                                        this.bitField0_ |= 16;
                                    } else if (K == 40) {
                                        this.bitField0_ |= 8;
                                        this.typeId_ = eVar.s();
                                    } else if (K != 48) {
                                        if (!parseUnknownField(eVar, J, fVar, K)) {
                                        }
                                    } else {
                                        this.bitField0_ |= 32;
                                        this.varargElementTypeId_ = eVar.s();
                                    }
                                } else {
                                    this.bitField0_ |= 2;
                                    this.name_ = eVar.s();
                                }
                            }
                            z3 = true;
                        } catch (InvalidProtocolBufferException e4) {
                            throw e4.setUnfinishedMessage(this);
                        }
                    } catch (IOException e5) {
                        throw new InvalidProtocolBufferException(e5.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    try {
                        J.I();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.unknownFields = u3.g();
                        throw th2;
                    }
                    this.unknownFields = u3.g();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            try {
                J.I();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.unknownFields = u3.g();
                throw th3;
            }
            this.unknownFields = u3.g();
            makeExtensionsImmutable();
        }
    }

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class VersionRequirement extends GeneratedMessageLite implements w {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<VersionRequirement> PARSER = new a();
        private static final VersionRequirement defaultInstance;
        private int bitField0_;
        private int errorCode_;
        private Level level_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int message_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;
        private int versionFull_;
        private VersionKind versionKind_;
        private int version_;

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public enum Level implements h.a {
            WARNING(0, 0),
            ERROR(1, 1),
            HIDDEN(2, 2);
            
            private static h.b<Level> internalValueMap = new a();
            private final int value;

            /* loaded from: E:\TSN-r\205dec\7343912.dex */
            static class a implements h.b<Level> {
                a() {
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
                /* renamed from: b */
                public Level a(int i4) {
                    return Level.valueOf(i4);
                }
            }

            Level(int i4, int i5) {
                this.value = i5;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.a
            public final int getNumber() {
                return this.value;
            }

            public static Level valueOf(int i4) {
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 != 2) {
                            return null;
                        }
                        return HIDDEN;
                    }
                    return ERROR;
                }
                return WARNING;
            }
        }

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public enum VersionKind implements h.a {
            LANGUAGE_VERSION(0, 0),
            COMPILER_VERSION(1, 1),
            API_VERSION(2, 2);
            
            private static h.b<VersionKind> internalValueMap = new a();
            private final int value;

            /* loaded from: E:\TSN-r\205dec\7343912.dex */
            static class a implements h.b<VersionKind> {
                a() {
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
                /* renamed from: b */
                public VersionKind a(int i4) {
                    return VersionKind.valueOf(i4);
                }
            }

            VersionKind(int i4, int i5) {
                this.value = i5;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.a
            public final int getNumber() {
                return this.value;
            }

            public static VersionKind valueOf(int i4) {
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 != 2) {
                            return null;
                        }
                        return API_VERSION;
                    }
                    return COMPILER_VERSION;
                }
                return LANGUAGE_VERSION;
            }
        }

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<VersionRequirement> {
            a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
            /* renamed from: m */
            public VersionRequirement c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                return new VersionRequirement(eVar, fVar);
            }
        }

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class b extends GeneratedMessageLite.b<VersionRequirement, b> implements w {

            /* renamed from: b  reason: collision with root package name */
            private int f57435b;

            /* renamed from: c  reason: collision with root package name */
            private int f57436c;

            /* renamed from: d  reason: collision with root package name */
            private int f57437d;

            /* renamed from: f  reason: collision with root package name */
            private int f57439f;

            /* renamed from: g  reason: collision with root package name */
            private int f57440g;

            /* renamed from: e  reason: collision with root package name */
            private Level f57438e = Level.ERROR;

            /* renamed from: h  reason: collision with root package name */
            private VersionKind f57441h = VersionKind.LANGUAGE_VERSION;

            private b() {
                p();
            }

            static /* synthetic */ b j() {
                return n();
            }

            private static b n() {
                return new b();
            }

            private void p() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public final boolean isInitialized() {
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: k */
            public VersionRequirement build() {
                VersionRequirement l4 = l();
                if (l4.isInitialized()) {
                    return l4;
                }
                throw a.AbstractC1158a.c(l4);
            }

            public VersionRequirement l() {
                VersionRequirement versionRequirement = new VersionRequirement(this);
                int i4 = this.f57435b;
                int i5 = (i4 & 1) != 1 ? 0 : 1;
                versionRequirement.version_ = this.f57436c;
                if ((i4 & 2) == 2) {
                    i5 |= 2;
                }
                versionRequirement.versionFull_ = this.f57437d;
                if ((i4 & 4) == 4) {
                    i5 |= 4;
                }
                versionRequirement.level_ = this.f57438e;
                if ((i4 & 8) == 8) {
                    i5 |= 8;
                }
                versionRequirement.errorCode_ = this.f57439f;
                if ((i4 & 16) == 16) {
                    i5 |= 16;
                }
                versionRequirement.message_ = this.f57440g;
                if ((i4 & 32) == 32) {
                    i5 |= 32;
                }
                versionRequirement.versionKind_ = this.f57441h;
                versionRequirement.bitField0_ = i5;
                return versionRequirement;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: m */
            public b d() {
                return n().h(l());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, kotlin.reflect.jvm.internal.impl.protobuf.o
            /* renamed from: o */
            public VersionRequirement getDefaultInstanceForType() {
                return VersionRequirement.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: q */
            public b h(VersionRequirement versionRequirement) {
                if (versionRequirement == VersionRequirement.getDefaultInstance()) {
                    return this;
                }
                if (versionRequirement.hasVersion()) {
                    v(versionRequirement.getVersion());
                }
                if (versionRequirement.hasVersionFull()) {
                    w(versionRequirement.getVersionFull());
                }
                if (versionRequirement.hasLevel()) {
                    t(versionRequirement.getLevel());
                }
                if (versionRequirement.hasErrorCode()) {
                    s(versionRequirement.getErrorCode());
                }
                if (versionRequirement.hasMessage()) {
                    u(versionRequirement.getMessage());
                }
                if (versionRequirement.hasVersionKind()) {
                    x(versionRequirement.getVersionKind());
                }
                i(f().c(versionRequirement.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC1158a, kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: r */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement.b g(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirement> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirement r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.h(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1b
                L11:
                    r3 = move-exception
                    kotlin.reflect.jvm.internal.impl.protobuf.n r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> Lf
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirement r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement) r4     // Catch: java.lang.Throwable -> Lf
                    throw r3     // Catch: java.lang.Throwable -> L19
                L19:
                    r3 = move-exception
                    r0 = r4
                L1b:
                    if (r0 == 0) goto L20
                    r2.h(r0)
                L20:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirement.b.g(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirement$b");
            }

            public b s(int i4) {
                this.f57435b |= 8;
                this.f57439f = i4;
                return this;
            }

            public b t(Level level) {
                level.getClass();
                this.f57435b |= 4;
                this.f57438e = level;
                return this;
            }

            public b u(int i4) {
                this.f57435b |= 16;
                this.f57440g = i4;
                return this;
            }

            public b v(int i4) {
                this.f57435b |= 1;
                this.f57436c = i4;
                return this;
            }

            public b w(int i4) {
                this.f57435b |= 2;
                this.f57437d = i4;
                return this;
            }

            public b x(VersionKind versionKind) {
                versionKind.getClass();
                this.f57435b |= 32;
                this.f57441h = versionKind;
                return this;
            }
        }

        static {
            VersionRequirement versionRequirement = new VersionRequirement(true);
            defaultInstance = versionRequirement;
            versionRequirement.initFields();
        }

        public static VersionRequirement getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.version_ = 0;
            this.versionFull_ = 0;
            this.level_ = Level.ERROR;
            this.errorCode_ = 0;
            this.message_ = 0;
            this.versionKind_ = VersionKind.LANGUAGE_VERSION;
        }

        public static b newBuilder() {
            return b.j();
        }

        public int getErrorCode() {
            return this.errorCode_;
        }

        public Level getLevel() {
            return this.level_;
        }

        public int getMessage() {
            return this.message_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
        public kotlin.reflect.jvm.internal.impl.protobuf.p<VersionRequirement> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public int getSerializedSize() {
            int i4 = this.memoizedSerializedSize;
            if (i4 != -1) {
                return i4;
            }
            int o4 = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.o(1, this.version_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                o4 += CodedOutputStream.o(2, this.versionFull_);
            }
            if ((this.bitField0_ & 4) == 4) {
                o4 += CodedOutputStream.h(3, this.level_.getNumber());
            }
            if ((this.bitField0_ & 8) == 8) {
                o4 += CodedOutputStream.o(4, this.errorCode_);
            }
            if ((this.bitField0_ & 16) == 16) {
                o4 += CodedOutputStream.o(5, this.message_);
            }
            if ((this.bitField0_ & 32) == 32) {
                o4 += CodedOutputStream.h(6, this.versionKind_.getNumber());
            }
            int size = o4 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public int getVersion() {
            return this.version_;
        }

        public int getVersionFull() {
            return this.versionFull_;
        }

        public VersionKind getVersionKind() {
            return this.versionKind_;
        }

        public boolean hasErrorCode() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasLevel() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasMessage() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean hasVersion() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasVersionFull() {
            return (this.bitField0_ & 2) == 2;
        }

        public boolean hasVersionKind() {
            return (this.bitField0_ & 32) == 32;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public final boolean isInitialized() {
            byte b4 = this.memoizedIsInitialized;
            if (b4 == 1) {
                return true;
            }
            if (b4 == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.a0(1, this.version_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.a0(2, this.versionFull_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.S(3, this.level_.getNumber());
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.a0(4, this.errorCode_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.a0(5, this.message_);
            }
            if ((this.bitField0_ & 32) == 32) {
                codedOutputStream.S(6, this.versionKind_.getNumber());
            }
            codedOutputStream.i0(this.unknownFields);
        }

        public static b newBuilder(VersionRequirement versionRequirement) {
            return newBuilder().h(versionRequirement);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public VersionRequirement getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b toBuilder() {
            return newBuilder(this);
        }

        private VersionRequirement(GeneratedMessageLite.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.f();
        }

        private VersionRequirement(boolean z3) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f57629a;
        }

        private VersionRequirement(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            d.b u3 = kotlin.reflect.jvm.internal.impl.protobuf.d.u();
            CodedOutputStream J = CodedOutputStream.J(u3, 1);
            boolean z3 = false;
            while (!z3) {
                try {
                    try {
                        int K = eVar.K();
                        if (K != 0) {
                            if (K == 8) {
                                this.bitField0_ |= 1;
                                this.version_ = eVar.s();
                            } else if (K == 16) {
                                this.bitField0_ |= 2;
                                this.versionFull_ = eVar.s();
                            } else if (K == 24) {
                                int n4 = eVar.n();
                                Level valueOf = Level.valueOf(n4);
                                if (valueOf == null) {
                                    J.o0(K);
                                    J.o0(n4);
                                } else {
                                    this.bitField0_ |= 4;
                                    this.level_ = valueOf;
                                }
                            } else if (K == 32) {
                                this.bitField0_ |= 8;
                                this.errorCode_ = eVar.s();
                            } else if (K == 40) {
                                this.bitField0_ |= 16;
                                this.message_ = eVar.s();
                            } else if (K != 48) {
                                if (!parseUnknownField(eVar, J, fVar, K)) {
                                }
                            } else {
                                int n5 = eVar.n();
                                VersionKind valueOf2 = VersionKind.valueOf(n5);
                                if (valueOf2 == null) {
                                    J.o0(K);
                                    J.o0(n5);
                                } else {
                                    this.bitField0_ |= 32;
                                    this.versionKind_ = valueOf2;
                                }
                            }
                        }
                        z3 = true;
                    } catch (InvalidProtocolBufferException e4) {
                        throw e4.setUnfinishedMessage(this);
                    } catch (IOException e5) {
                        throw new InvalidProtocolBufferException(e5.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    try {
                        J.I();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.unknownFields = u3.g();
                        throw th2;
                    }
                    this.unknownFields = u3.g();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            try {
                J.I();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.unknownFields = u3.g();
                throw th3;
            }
            this.unknownFields = u3.g();
            makeExtensionsImmutable();
        }
    }

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class VersionRequirementTable extends GeneratedMessageLite implements x {
        public static kotlin.reflect.jvm.internal.impl.protobuf.p<VersionRequirementTable> PARSER = new a();
        private static final VersionRequirementTable defaultInstance;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<VersionRequirement> requirement_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<VersionRequirementTable> {
            a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
            /* renamed from: m */
            public VersionRequirementTable c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
                return new VersionRequirementTable(eVar, fVar);
            }
        }

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class b extends GeneratedMessageLite.b<VersionRequirementTable, b> implements x {

            /* renamed from: b  reason: collision with root package name */
            private int f57442b;

            /* renamed from: c  reason: collision with root package name */
            private List<VersionRequirement> f57443c = Collections.emptyList();

            private b() {
                q();
            }

            static /* synthetic */ b j() {
                return n();
            }

            private static b n() {
                return new b();
            }

            private void o() {
                if ((this.f57442b & 1) != 1) {
                    this.f57443c = new ArrayList(this.f57443c);
                    this.f57442b |= 1;
                }
            }

            private void q() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public final boolean isInitialized() {
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: k */
            public VersionRequirementTable build() {
                VersionRequirementTable l4 = l();
                if (l4.isInitialized()) {
                    return l4;
                }
                throw a.AbstractC1158a.c(l4);
            }

            public VersionRequirementTable l() {
                VersionRequirementTable versionRequirementTable = new VersionRequirementTable(this);
                if ((this.f57442b & 1) == 1) {
                    this.f57443c = Collections.unmodifiableList(this.f57443c);
                    this.f57442b &= -2;
                }
                versionRequirementTable.requirement_ = this.f57443c;
                return versionRequirementTable;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: m */
            public b d() {
                return n().h(l());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, kotlin.reflect.jvm.internal.impl.protobuf.o
            /* renamed from: p */
            public VersionRequirementTable getDefaultInstanceForType() {
                return VersionRequirementTable.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: r */
            public b h(VersionRequirementTable versionRequirementTable) {
                if (versionRequirementTable == VersionRequirementTable.getDefaultInstance()) {
                    return this;
                }
                if (!versionRequirementTable.requirement_.isEmpty()) {
                    if (this.f57443c.isEmpty()) {
                        this.f57443c = versionRequirementTable.requirement_;
                        this.f57442b &= -2;
                    } else {
                        o();
                        this.f57443c.addAll(versionRequirementTable.requirement_);
                    }
                }
                i(f().c(versionRequirementTable.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC1158a, kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: s */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirementTable.b g(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable> r1 = kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirementTable.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable r3 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirementTable) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    if (r3 == 0) goto Le
                    r2.h(r3)
                Le:
                    return r2
                Lf:
                    r3 = move-exception
                    goto L1b
                L11:
                    r3 = move-exception
                    kotlin.reflect.jvm.internal.impl.protobuf.n r4 = r3.getUnfinishedMessage()     // Catch: java.lang.Throwable -> Lf
                    kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable r4 = (kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirementTable) r4     // Catch: java.lang.Throwable -> Lf
                    throw r3     // Catch: java.lang.Throwable -> L19
                L19:
                    r3 = move-exception
                    r0 = r4
                L1b:
                    if (r0 == 0) goto L20
                    r2.h(r0)
                L20:
                    throw r3
                */
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf.VersionRequirementTable.b.g(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$VersionRequirementTable$b");
            }
        }

        static {
            VersionRequirementTable versionRequirementTable = new VersionRequirementTable(true);
            defaultInstance = versionRequirementTable;
            versionRequirementTable.initFields();
        }

        public static VersionRequirementTable getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.requirement_ = Collections.emptyList();
        }

        public static b newBuilder() {
            return b.j();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
        public kotlin.reflect.jvm.internal.impl.protobuf.p<VersionRequirementTable> getParserForType() {
            return PARSER;
        }

        public int getRequirementCount() {
            return this.requirement_.size();
        }

        public List<VersionRequirement> getRequirementList() {
            return this.requirement_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public int getSerializedSize() {
            int i4 = this.memoizedSerializedSize;
            if (i4 != -1) {
                return i4;
            }
            int i5 = 0;
            for (int i6 = 0; i6 < this.requirement_.size(); i6++) {
                i5 += CodedOutputStream.s(1, this.requirement_.get(i6));
            }
            int size = i5 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public final boolean isInitialized() {
            byte b4 = this.memoizedIsInitialized;
            if (b4 == 1) {
                return true;
            }
            if (b4 == 0) {
                return false;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            for (int i4 = 0; i4 < this.requirement_.size(); i4++) {
                codedOutputStream.d0(1, this.requirement_.get(i4));
            }
            codedOutputStream.i0(this.unknownFields);
        }

        public static b newBuilder(VersionRequirementTable versionRequirementTable) {
            return newBuilder().h(versionRequirementTable);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public VersionRequirementTable getDefaultInstanceForType() {
            return defaultInstance;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b newBuilderForType() {
            return newBuilder();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public b toBuilder() {
            return newBuilder(this);
        }

        private VersionRequirementTable(GeneratedMessageLite.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.f();
        }

        private VersionRequirementTable(boolean z3) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f57629a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private VersionRequirementTable(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            d.b u3 = kotlin.reflect.jvm.internal.impl.protobuf.d.u();
            CodedOutputStream J = CodedOutputStream.J(u3, 1);
            boolean z3 = false;
            boolean z4 = false;
            while (!z3) {
                try {
                    try {
                        int K = eVar.K();
                        if (K != 0) {
                            if (K != 10) {
                                if (!parseUnknownField(eVar, J, fVar, K)) {
                                }
                            } else {
                                if (!(z4 & true)) {
                                    this.requirement_ = new ArrayList();
                                    z4 |= true;
                                }
                                this.requirement_.add(eVar.u(VersionRequirement.PARSER, fVar));
                            }
                        }
                        z3 = true;
                    } catch (InvalidProtocolBufferException e4) {
                        throw e4.setUnfinishedMessage(this);
                    } catch (IOException e5) {
                        throw new InvalidProtocolBufferException(e5.getMessage()).setUnfinishedMessage(this);
                    }
                } catch (Throwable th) {
                    if (z4 & true) {
                        this.requirement_ = Collections.unmodifiableList(this.requirement_);
                    }
                    try {
                        J.I();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.unknownFields = u3.g();
                        throw th2;
                    }
                    this.unknownFields = u3.g();
                    makeExtensionsImmutable();
                    throw th;
                }
            }
            if (z4 & true) {
                this.requirement_ = Collections.unmodifiableList(this.requirement_);
            }
            try {
                J.I();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.unknownFields = u3.g();
                throw th3;
            }
            this.unknownFields = u3.g();
            makeExtensionsImmutable();
        }
    }

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public enum Visibility implements h.a {
        INTERNAL(0, 0),
        PRIVATE(1, 1),
        PROTECTED(2, 2),
        PUBLIC(3, 3),
        PRIVATE_TO_THIS(4, 4),
        LOCAL(5, 5);
        
        private static h.b<Visibility> internalValueMap = new a();
        private final int value;

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static class a implements h.b<Visibility> {
            a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
            /* renamed from: b */
            public Visibility a(int i4) {
                return Visibility.valueOf(i4);
            }
        }

        Visibility(int i4, int i5) {
            this.value = i5;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.a
        public final int getNumber() {
            return this.value;
        }

        public static Visibility valueOf(int i4) {
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            if (i4 != 4) {
                                if (i4 != 5) {
                                    return null;
                                }
                                return LOCAL;
                            }
                            return PRIVATE_TO_THIS;
                        }
                        return PUBLIC;
                    }
                    return PROTECTED;
                }
                return PRIVATE;
            }
            return INTERNAL;
        }
    }
}
