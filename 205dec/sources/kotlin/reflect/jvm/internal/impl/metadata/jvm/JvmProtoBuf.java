package kotlin.reflect.jvm.internal.impl.metadata.jvm;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.d;
import kotlin.reflect.jvm.internal.impl.protobuf.f;
import kotlin.reflect.jvm.internal.impl.protobuf.h;
import kotlin.reflect.jvm.internal.impl.protobuf.p;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class JvmProtoBuf {

    /* renamed from: a  reason: collision with root package name */
    public static final GeneratedMessageLite.f<ProtoBuf.Constructor, JvmMethodSignature> f57487a;

    /* renamed from: b  reason: collision with root package name */
    public static final GeneratedMessageLite.f<ProtoBuf.Function, JvmMethodSignature> f57488b;

    /* renamed from: c  reason: collision with root package name */
    public static final GeneratedMessageLite.f<ProtoBuf.Function, Integer> f57489c;

    /* renamed from: d  reason: collision with root package name */
    public static final GeneratedMessageLite.f<ProtoBuf.Property, JvmPropertySignature> f57490d;

    /* renamed from: e  reason: collision with root package name */
    public static final GeneratedMessageLite.f<ProtoBuf.Property, Integer> f57491e;

    /* renamed from: f  reason: collision with root package name */
    public static final GeneratedMessageLite.f<ProtoBuf.Type, List<ProtoBuf.Annotation>> f57492f;

    /* renamed from: g  reason: collision with root package name */
    public static final GeneratedMessageLite.f<ProtoBuf.Type, Boolean> f57493g;

    /* renamed from: h  reason: collision with root package name */
    public static final GeneratedMessageLite.f<ProtoBuf.TypeParameter, List<ProtoBuf.Annotation>> f57494h;

    /* renamed from: i  reason: collision with root package name */
    public static final GeneratedMessageLite.f<ProtoBuf.Class, Integer> f57495i;

    /* renamed from: j  reason: collision with root package name */
    public static final GeneratedMessageLite.f<ProtoBuf.Class, List<ProtoBuf.Property>> f57496j;

    /* renamed from: k  reason: collision with root package name */
    public static final GeneratedMessageLite.f<ProtoBuf.Class, Integer> f57497k;

    /* renamed from: l  reason: collision with root package name */
    public static final GeneratedMessageLite.f<ProtoBuf.Class, Integer> f57498l;

    /* renamed from: m  reason: collision with root package name */
    public static final GeneratedMessageLite.f<ProtoBuf.Package, Integer> f57499m;

    /* renamed from: n  reason: collision with root package name */
    public static final GeneratedMessageLite.f<ProtoBuf.Package, List<ProtoBuf.Property>> f57500n;

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class JvmFieldSignature extends GeneratedMessageLite implements kotlin.reflect.jvm.internal.impl.metadata.jvm.a {
        public static p<JvmFieldSignature> PARSER = new a();
        private static final JvmFieldSignature defaultInstance;
        private int bitField0_;
        private int desc_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<JvmFieldSignature> {
            a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
            /* renamed from: m */
            public JvmFieldSignature c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, f fVar) throws InvalidProtocolBufferException {
                return new JvmFieldSignature(eVar, fVar);
            }
        }

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class b extends GeneratedMessageLite.b<JvmFieldSignature, b> implements kotlin.reflect.jvm.internal.impl.metadata.jvm.a {

            /* renamed from: b  reason: collision with root package name */
            private int f57501b;

            /* renamed from: c  reason: collision with root package name */
            private int f57502c;

            /* renamed from: d  reason: collision with root package name */
            private int f57503d;

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
            public JvmFieldSignature build() {
                JvmFieldSignature l4 = l();
                if (l4.isInitialized()) {
                    return l4;
                }
                throw a.AbstractC1158a.c(l4);
            }

            public JvmFieldSignature l() {
                JvmFieldSignature jvmFieldSignature = new JvmFieldSignature(this);
                int i4 = this.f57501b;
                int i5 = (i4 & 1) != 1 ? 0 : 1;
                jvmFieldSignature.name_ = this.f57502c;
                if ((i4 & 2) == 2) {
                    i5 |= 2;
                }
                jvmFieldSignature.desc_ = this.f57503d;
                jvmFieldSignature.bitField0_ = i5;
                return jvmFieldSignature;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: m */
            public b d() {
                return n().h(l());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, kotlin.reflect.jvm.internal.impl.protobuf.o
            /* renamed from: o */
            public JvmFieldSignature getDefaultInstanceForType() {
                return JvmFieldSignature.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: q */
            public b h(JvmFieldSignature jvmFieldSignature) {
                if (jvmFieldSignature == JvmFieldSignature.getDefaultInstance()) {
                    return this;
                }
                if (jvmFieldSignature.hasName()) {
                    t(jvmFieldSignature.getName());
                }
                if (jvmFieldSignature.hasDesc()) {
                    s(jvmFieldSignature.getDesc());
                }
                i(f().c(jvmFieldSignature.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC1158a, kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: r */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmFieldSignature.b g(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmFieldSignature> r1 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmFieldSignature.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmFieldSignature r3 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmFieldSignature) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmFieldSignature r4 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmFieldSignature) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmFieldSignature.b.g(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmFieldSignature$b");
            }

            public b s(int i4) {
                this.f57501b |= 2;
                this.f57503d = i4;
                return this;
            }

            public b t(int i4) {
                this.f57501b |= 1;
                this.f57502c = i4;
                return this;
            }
        }

        static {
            JvmFieldSignature jvmFieldSignature = new JvmFieldSignature(true);
            defaultInstance = jvmFieldSignature;
            jvmFieldSignature.initFields();
        }

        public static JvmFieldSignature getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.name_ = 0;
            this.desc_ = 0;
        }

        public static b newBuilder() {
            return b.j();
        }

        public int getDesc() {
            return this.desc_;
        }

        public int getName() {
            return this.name_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
        public p<JvmFieldSignature> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public int getSerializedSize() {
            int i4 = this.memoizedSerializedSize;
            if (i4 != -1) {
                return i4;
            }
            int o4 = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.o(1, this.name_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                o4 += CodedOutputStream.o(2, this.desc_);
            }
            int size = o4 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public boolean hasDesc() {
            return (this.bitField0_ & 2) == 2;
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
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.a0(1, this.name_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.a0(2, this.desc_);
            }
            codedOutputStream.i0(this.unknownFields);
        }

        public static b newBuilder(JvmFieldSignature jvmFieldSignature) {
            return newBuilder().h(jvmFieldSignature);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public JvmFieldSignature getDefaultInstanceForType() {
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

        private JvmFieldSignature(GeneratedMessageLite.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.f();
        }

        private JvmFieldSignature(boolean z3) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f57629a;
        }

        private JvmFieldSignature(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, f fVar) throws InvalidProtocolBufferException {
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
                                this.name_ = eVar.s();
                            } else if (K != 16) {
                                if (!parseUnknownField(eVar, J, fVar, K)) {
                                }
                            } else {
                                this.bitField0_ |= 2;
                                this.desc_ = eVar.s();
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
    public static final class JvmMethodSignature extends GeneratedMessageLite implements kotlin.reflect.jvm.internal.impl.metadata.jvm.b {
        public static p<JvmMethodSignature> PARSER = new a();
        private static final JvmMethodSignature defaultInstance;
        private int bitField0_;
        private int desc_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private int name_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<JvmMethodSignature> {
            a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
            /* renamed from: m */
            public JvmMethodSignature c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, f fVar) throws InvalidProtocolBufferException {
                return new JvmMethodSignature(eVar, fVar);
            }
        }

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class b extends GeneratedMessageLite.b<JvmMethodSignature, b> implements kotlin.reflect.jvm.internal.impl.metadata.jvm.b {

            /* renamed from: b  reason: collision with root package name */
            private int f57504b;

            /* renamed from: c  reason: collision with root package name */
            private int f57505c;

            /* renamed from: d  reason: collision with root package name */
            private int f57506d;

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
            public JvmMethodSignature build() {
                JvmMethodSignature l4 = l();
                if (l4.isInitialized()) {
                    return l4;
                }
                throw a.AbstractC1158a.c(l4);
            }

            public JvmMethodSignature l() {
                JvmMethodSignature jvmMethodSignature = new JvmMethodSignature(this);
                int i4 = this.f57504b;
                int i5 = (i4 & 1) != 1 ? 0 : 1;
                jvmMethodSignature.name_ = this.f57505c;
                if ((i4 & 2) == 2) {
                    i5 |= 2;
                }
                jvmMethodSignature.desc_ = this.f57506d;
                jvmMethodSignature.bitField0_ = i5;
                return jvmMethodSignature;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: m */
            public b d() {
                return n().h(l());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, kotlin.reflect.jvm.internal.impl.protobuf.o
            /* renamed from: o */
            public JvmMethodSignature getDefaultInstanceForType() {
                return JvmMethodSignature.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: q */
            public b h(JvmMethodSignature jvmMethodSignature) {
                if (jvmMethodSignature == JvmMethodSignature.getDefaultInstance()) {
                    return this;
                }
                if (jvmMethodSignature.hasName()) {
                    t(jvmMethodSignature.getName());
                }
                if (jvmMethodSignature.hasDesc()) {
                    s(jvmMethodSignature.getDesc());
                }
                i(f().c(jvmMethodSignature.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC1158a, kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: r */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature.b g(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature> r1 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature r3 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature r4 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmMethodSignature.b.g(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmMethodSignature$b");
            }

            public b s(int i4) {
                this.f57504b |= 2;
                this.f57506d = i4;
                return this;
            }

            public b t(int i4) {
                this.f57504b |= 1;
                this.f57505c = i4;
                return this;
            }
        }

        static {
            JvmMethodSignature jvmMethodSignature = new JvmMethodSignature(true);
            defaultInstance = jvmMethodSignature;
            jvmMethodSignature.initFields();
        }

        public static JvmMethodSignature getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.name_ = 0;
            this.desc_ = 0;
        }

        public static b newBuilder() {
            return b.j();
        }

        public int getDesc() {
            return this.desc_;
        }

        public int getName() {
            return this.name_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
        public p<JvmMethodSignature> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public int getSerializedSize() {
            int i4 = this.memoizedSerializedSize;
            if (i4 != -1) {
                return i4;
            }
            int o4 = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.o(1, this.name_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                o4 += CodedOutputStream.o(2, this.desc_);
            }
            int size = o4 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public boolean hasDesc() {
            return (this.bitField0_ & 2) == 2;
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
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.a0(1, this.name_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.a0(2, this.desc_);
            }
            codedOutputStream.i0(this.unknownFields);
        }

        public static b newBuilder(JvmMethodSignature jvmMethodSignature) {
            return newBuilder().h(jvmMethodSignature);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public JvmMethodSignature getDefaultInstanceForType() {
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

        private JvmMethodSignature(GeneratedMessageLite.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.f();
        }

        private JvmMethodSignature(boolean z3) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f57629a;
        }

        private JvmMethodSignature(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, f fVar) throws InvalidProtocolBufferException {
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
                                this.name_ = eVar.s();
                            } else if (K != 16) {
                                if (!parseUnknownField(eVar, J, fVar, K)) {
                                }
                            } else {
                                this.bitField0_ |= 2;
                                this.desc_ = eVar.s();
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
    public static final class JvmPropertySignature extends GeneratedMessageLite implements c {
        public static p<JvmPropertySignature> PARSER = new a();
        private static final JvmPropertySignature defaultInstance;
        private int bitField0_;
        private JvmMethodSignature delegateMethod_;
        private JvmFieldSignature field_;
        private JvmMethodSignature getter_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private JvmMethodSignature setter_;
        private JvmMethodSignature syntheticMethod_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<JvmPropertySignature> {
            a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
            /* renamed from: m */
            public JvmPropertySignature c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, f fVar) throws InvalidProtocolBufferException {
                return new JvmPropertySignature(eVar, fVar);
            }
        }

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class b extends GeneratedMessageLite.b<JvmPropertySignature, b> implements c {

            /* renamed from: b  reason: collision with root package name */
            private int f57507b;

            /* renamed from: c  reason: collision with root package name */
            private JvmFieldSignature f57508c = JvmFieldSignature.getDefaultInstance();

            /* renamed from: d  reason: collision with root package name */
            private JvmMethodSignature f57509d = JvmMethodSignature.getDefaultInstance();

            /* renamed from: e  reason: collision with root package name */
            private JvmMethodSignature f57510e = JvmMethodSignature.getDefaultInstance();

            /* renamed from: f  reason: collision with root package name */
            private JvmMethodSignature f57511f = JvmMethodSignature.getDefaultInstance();

            /* renamed from: g  reason: collision with root package name */
            private JvmMethodSignature f57512g = JvmMethodSignature.getDefaultInstance();

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
            public JvmPropertySignature build() {
                JvmPropertySignature l4 = l();
                if (l4.isInitialized()) {
                    return l4;
                }
                throw a.AbstractC1158a.c(l4);
            }

            public JvmPropertySignature l() {
                JvmPropertySignature jvmPropertySignature = new JvmPropertySignature(this);
                int i4 = this.f57507b;
                int i5 = (i4 & 1) != 1 ? 0 : 1;
                jvmPropertySignature.field_ = this.f57508c;
                if ((i4 & 2) == 2) {
                    i5 |= 2;
                }
                jvmPropertySignature.syntheticMethod_ = this.f57509d;
                if ((i4 & 4) == 4) {
                    i5 |= 4;
                }
                jvmPropertySignature.getter_ = this.f57510e;
                if ((i4 & 8) == 8) {
                    i5 |= 8;
                }
                jvmPropertySignature.setter_ = this.f57511f;
                if ((i4 & 16) == 16) {
                    i5 |= 16;
                }
                jvmPropertySignature.delegateMethod_ = this.f57512g;
                jvmPropertySignature.bitField0_ = i5;
                return jvmPropertySignature;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: m */
            public b d() {
                return n().h(l());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, kotlin.reflect.jvm.internal.impl.protobuf.o
            /* renamed from: o */
            public JvmPropertySignature getDefaultInstanceForType() {
                return JvmPropertySignature.getDefaultInstance();
            }

            public b q(JvmMethodSignature jvmMethodSignature) {
                if ((this.f57507b & 16) == 16 && this.f57512g != JvmMethodSignature.getDefaultInstance()) {
                    this.f57512g = JvmMethodSignature.newBuilder(this.f57512g).h(jvmMethodSignature).l();
                } else {
                    this.f57512g = jvmMethodSignature;
                }
                this.f57507b |= 16;
                return this;
            }

            public b r(JvmFieldSignature jvmFieldSignature) {
                if ((this.f57507b & 1) == 1 && this.f57508c != JvmFieldSignature.getDefaultInstance()) {
                    this.f57508c = JvmFieldSignature.newBuilder(this.f57508c).h(jvmFieldSignature).l();
                } else {
                    this.f57508c = jvmFieldSignature;
                }
                this.f57507b |= 1;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: s */
            public b h(JvmPropertySignature jvmPropertySignature) {
                if (jvmPropertySignature == JvmPropertySignature.getDefaultInstance()) {
                    return this;
                }
                if (jvmPropertySignature.hasField()) {
                    r(jvmPropertySignature.getField());
                }
                if (jvmPropertySignature.hasSyntheticMethod()) {
                    w(jvmPropertySignature.getSyntheticMethod());
                }
                if (jvmPropertySignature.hasGetter()) {
                    u(jvmPropertySignature.getGetter());
                }
                if (jvmPropertySignature.hasSetter()) {
                    v(jvmPropertySignature.getSetter());
                }
                if (jvmPropertySignature.hasDelegateMethod()) {
                    q(jvmPropertySignature.getDelegateMethod());
                }
                i(f().c(jvmPropertySignature.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC1158a, kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: t */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature.b g(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmPropertySignature> r1 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmPropertySignature r3 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmPropertySignature r4 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.JvmPropertySignature.b.g(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$JvmPropertySignature$b");
            }

            public b u(JvmMethodSignature jvmMethodSignature) {
                if ((this.f57507b & 4) == 4 && this.f57510e != JvmMethodSignature.getDefaultInstance()) {
                    this.f57510e = JvmMethodSignature.newBuilder(this.f57510e).h(jvmMethodSignature).l();
                } else {
                    this.f57510e = jvmMethodSignature;
                }
                this.f57507b |= 4;
                return this;
            }

            public b v(JvmMethodSignature jvmMethodSignature) {
                if ((this.f57507b & 8) == 8 && this.f57511f != JvmMethodSignature.getDefaultInstance()) {
                    this.f57511f = JvmMethodSignature.newBuilder(this.f57511f).h(jvmMethodSignature).l();
                } else {
                    this.f57511f = jvmMethodSignature;
                }
                this.f57507b |= 8;
                return this;
            }

            public b w(JvmMethodSignature jvmMethodSignature) {
                if ((this.f57507b & 2) == 2 && this.f57509d != JvmMethodSignature.getDefaultInstance()) {
                    this.f57509d = JvmMethodSignature.newBuilder(this.f57509d).h(jvmMethodSignature).l();
                } else {
                    this.f57509d = jvmMethodSignature;
                }
                this.f57507b |= 2;
                return this;
            }
        }

        static {
            JvmPropertySignature jvmPropertySignature = new JvmPropertySignature(true);
            defaultInstance = jvmPropertySignature;
            jvmPropertySignature.initFields();
        }

        public static JvmPropertySignature getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.field_ = JvmFieldSignature.getDefaultInstance();
            this.syntheticMethod_ = JvmMethodSignature.getDefaultInstance();
            this.getter_ = JvmMethodSignature.getDefaultInstance();
            this.setter_ = JvmMethodSignature.getDefaultInstance();
            this.delegateMethod_ = JvmMethodSignature.getDefaultInstance();
        }

        public static b newBuilder() {
            return b.j();
        }

        public JvmMethodSignature getDelegateMethod() {
            return this.delegateMethod_;
        }

        public JvmFieldSignature getField() {
            return this.field_;
        }

        public JvmMethodSignature getGetter() {
            return this.getter_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
        public p<JvmPropertySignature> getParserForType() {
            return PARSER;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public int getSerializedSize() {
            int i4 = this.memoizedSerializedSize;
            if (i4 != -1) {
                return i4;
            }
            int s3 = (this.bitField0_ & 1) == 1 ? 0 + CodedOutputStream.s(1, this.field_) : 0;
            if ((this.bitField0_ & 2) == 2) {
                s3 += CodedOutputStream.s(2, this.syntheticMethod_);
            }
            if ((this.bitField0_ & 4) == 4) {
                s3 += CodedOutputStream.s(3, this.getter_);
            }
            if ((this.bitField0_ & 8) == 8) {
                s3 += CodedOutputStream.s(4, this.setter_);
            }
            if ((this.bitField0_ & 16) == 16) {
                s3 += CodedOutputStream.s(5, this.delegateMethod_);
            }
            int size = s3 + this.unknownFields.size();
            this.memoizedSerializedSize = size;
            return size;
        }

        public JvmMethodSignature getSetter() {
            return this.setter_;
        }

        public JvmMethodSignature getSyntheticMethod() {
            return this.syntheticMethod_;
        }

        public boolean hasDelegateMethod() {
            return (this.bitField0_ & 16) == 16;
        }

        public boolean hasField() {
            return (this.bitField0_ & 1) == 1;
        }

        public boolean hasGetter() {
            return (this.bitField0_ & 4) == 4;
        }

        public boolean hasSetter() {
            return (this.bitField0_ & 8) == 8;
        }

        public boolean hasSyntheticMethod() {
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
            this.memoizedIsInitialized = (byte) 1;
            return true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
            getSerializedSize();
            if ((this.bitField0_ & 1) == 1) {
                codedOutputStream.d0(1, this.field_);
            }
            if ((this.bitField0_ & 2) == 2) {
                codedOutputStream.d0(2, this.syntheticMethod_);
            }
            if ((this.bitField0_ & 4) == 4) {
                codedOutputStream.d0(3, this.getter_);
            }
            if ((this.bitField0_ & 8) == 8) {
                codedOutputStream.d0(4, this.setter_);
            }
            if ((this.bitField0_ & 16) == 16) {
                codedOutputStream.d0(5, this.delegateMethod_);
            }
            codedOutputStream.i0(this.unknownFields);
        }

        public static b newBuilder(JvmPropertySignature jvmPropertySignature) {
            return newBuilder().h(jvmPropertySignature);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public JvmPropertySignature getDefaultInstanceForType() {
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

        private JvmPropertySignature(GeneratedMessageLite.b bVar) {
            super(bVar);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.f();
        }

        private JvmPropertySignature(boolean z3) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f57629a;
        }

        private JvmPropertySignature(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, f fVar) throws InvalidProtocolBufferException {
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
                            if (K == 10) {
                                JvmFieldSignature.b builder = (this.bitField0_ & 1) == 1 ? this.field_.toBuilder() : null;
                                JvmFieldSignature jvmFieldSignature = (JvmFieldSignature) eVar.u(JvmFieldSignature.PARSER, fVar);
                                this.field_ = jvmFieldSignature;
                                if (builder != null) {
                                    builder.h(jvmFieldSignature);
                                    this.field_ = builder.l();
                                }
                                this.bitField0_ |= 1;
                            } else if (K == 18) {
                                JvmMethodSignature.b builder2 = (this.bitField0_ & 2) == 2 ? this.syntheticMethod_.toBuilder() : null;
                                JvmMethodSignature jvmMethodSignature = (JvmMethodSignature) eVar.u(JvmMethodSignature.PARSER, fVar);
                                this.syntheticMethod_ = jvmMethodSignature;
                                if (builder2 != null) {
                                    builder2.h(jvmMethodSignature);
                                    this.syntheticMethod_ = builder2.l();
                                }
                                this.bitField0_ |= 2;
                            } else if (K == 26) {
                                JvmMethodSignature.b builder3 = (this.bitField0_ & 4) == 4 ? this.getter_.toBuilder() : null;
                                JvmMethodSignature jvmMethodSignature2 = (JvmMethodSignature) eVar.u(JvmMethodSignature.PARSER, fVar);
                                this.getter_ = jvmMethodSignature2;
                                if (builder3 != null) {
                                    builder3.h(jvmMethodSignature2);
                                    this.getter_ = builder3.l();
                                }
                                this.bitField0_ |= 4;
                            } else if (K == 34) {
                                JvmMethodSignature.b builder4 = (this.bitField0_ & 8) == 8 ? this.setter_.toBuilder() : null;
                                JvmMethodSignature jvmMethodSignature3 = (JvmMethodSignature) eVar.u(JvmMethodSignature.PARSER, fVar);
                                this.setter_ = jvmMethodSignature3;
                                if (builder4 != null) {
                                    builder4.h(jvmMethodSignature3);
                                    this.setter_ = builder4.l();
                                }
                                this.bitField0_ |= 8;
                            } else if (K != 42) {
                                if (!parseUnknownField(eVar, J, fVar, K)) {
                                }
                            } else {
                                JvmMethodSignature.b builder5 = (this.bitField0_ & 16) == 16 ? this.delegateMethod_.toBuilder() : null;
                                JvmMethodSignature jvmMethodSignature4 = (JvmMethodSignature) eVar.u(JvmMethodSignature.PARSER, fVar);
                                this.delegateMethod_ = jvmMethodSignature4;
                                if (builder5 != null) {
                                    builder5.h(jvmMethodSignature4);
                                    this.delegateMethod_ = builder5.l();
                                }
                                this.bitField0_ |= 16;
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
    public static final class StringTableTypes extends GeneratedMessageLite implements e {
        public static p<StringTableTypes> PARSER = new a();
        private static final StringTableTypes defaultInstance;
        private int localNameMemoizedSerializedSize;
        private List<Integer> localName_;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private List<Record> record_;
        private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class Record extends GeneratedMessageLite implements d {
            public static p<Record> PARSER = new a();
            private static final Record defaultInstance;
            private int bitField0_;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private Operation operation_;
            private int predefinedIndex_;
            private int range_;
            private int replaceCharMemoizedSerializedSize;
            private List<Integer> replaceChar_;
            private Object string_;
            private int substringIndexMemoizedSerializedSize;
            private List<Integer> substringIndex_;
            private final kotlin.reflect.jvm.internal.impl.protobuf.d unknownFields;

            /* loaded from: E:\TSN-r\205dec\7343912.dex */
            public enum Operation implements h.a {
                NONE(0, 0),
                INTERNAL_TO_CLASS_ID(1, 1),
                DESC_TO_CLASS_ID(2, 2);
                
                private static h.b<Operation> internalValueMap = new a();
                private final int value;

                /* loaded from: E:\TSN-r\205dec\7343912.dex */
                static class a implements h.b<Operation> {
                    a() {
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
                    /* renamed from: b */
                    public Operation a(int i4) {
                        return Operation.valueOf(i4);
                    }
                }

                Operation(int i4, int i5) {
                    this.value = i5;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.a
                public final int getNumber() {
                    return this.value;
                }

                public static Operation valueOf(int i4) {
                    if (i4 != 0) {
                        if (i4 != 1) {
                            if (i4 != 2) {
                                return null;
                            }
                            return DESC_TO_CLASS_ID;
                        }
                        return INTERNAL_TO_CLASS_ID;
                    }
                    return NONE;
                }
            }

            /* loaded from: E:\TSN-r\205dec\7343912.dex */
            static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<Record> {
                a() {
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
                /* renamed from: m */
                public Record c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, f fVar) throws InvalidProtocolBufferException {
                    return new Record(eVar, fVar);
                }
            }

            /* loaded from: E:\TSN-r\205dec\7343912.dex */
            public static final class b extends GeneratedMessageLite.b<Record, b> implements d {

                /* renamed from: b  reason: collision with root package name */
                private int f57513b;

                /* renamed from: d  reason: collision with root package name */
                private int f57515d;

                /* renamed from: c  reason: collision with root package name */
                private int f57514c = 1;

                /* renamed from: e  reason: collision with root package name */
                private Object f57516e = "";

                /* renamed from: f  reason: collision with root package name */
                private Operation f57517f = Operation.NONE;

                /* renamed from: g  reason: collision with root package name */
                private List<Integer> f57518g = Collections.emptyList();

                /* renamed from: h  reason: collision with root package name */
                private List<Integer> f57519h = Collections.emptyList();

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
                    if ((this.f57513b & 32) != 32) {
                        this.f57519h = new ArrayList(this.f57519h);
                        this.f57513b |= 32;
                    }
                }

                private void p() {
                    if ((this.f57513b & 16) != 16) {
                        this.f57518g = new ArrayList(this.f57518g);
                        this.f57513b |= 16;
                    }
                }

                private void r() {
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
                public final boolean isInitialized() {
                    return true;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
                /* renamed from: k */
                public Record build() {
                    Record l4 = l();
                    if (l4.isInitialized()) {
                        return l4;
                    }
                    throw a.AbstractC1158a.c(l4);
                }

                public Record l() {
                    Record record = new Record(this);
                    int i4 = this.f57513b;
                    int i5 = (i4 & 1) != 1 ? 0 : 1;
                    record.range_ = this.f57514c;
                    if ((i4 & 2) == 2) {
                        i5 |= 2;
                    }
                    record.predefinedIndex_ = this.f57515d;
                    if ((i4 & 4) == 4) {
                        i5 |= 4;
                    }
                    record.string_ = this.f57516e;
                    if ((i4 & 8) == 8) {
                        i5 |= 8;
                    }
                    record.operation_ = this.f57517f;
                    if ((this.f57513b & 16) == 16) {
                        this.f57518g = Collections.unmodifiableList(this.f57518g);
                        this.f57513b &= -17;
                    }
                    record.substringIndex_ = this.f57518g;
                    if ((this.f57513b & 32) == 32) {
                        this.f57519h = Collections.unmodifiableList(this.f57519h);
                        this.f57513b &= -33;
                    }
                    record.replaceChar_ = this.f57519h;
                    record.bitField0_ = i5;
                    return record;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
                /* renamed from: m */
                public b d() {
                    return n().h(l());
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, kotlin.reflect.jvm.internal.impl.protobuf.o
                /* renamed from: q */
                public Record getDefaultInstanceForType() {
                    return Record.getDefaultInstance();
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
                /* renamed from: s */
                public b h(Record record) {
                    if (record == Record.getDefaultInstance()) {
                        return this;
                    }
                    if (record.hasRange()) {
                        w(record.getRange());
                    }
                    if (record.hasPredefinedIndex()) {
                        v(record.getPredefinedIndex());
                    }
                    if (record.hasString()) {
                        this.f57513b |= 4;
                        this.f57516e = record.string_;
                    }
                    if (record.hasOperation()) {
                        u(record.getOperation());
                    }
                    if (!record.substringIndex_.isEmpty()) {
                        if (this.f57518g.isEmpty()) {
                            this.f57518g = record.substringIndex_;
                            this.f57513b &= -17;
                        } else {
                            p();
                            this.f57518g.addAll(record.substringIndex_);
                        }
                    }
                    if (!record.replaceChar_.isEmpty()) {
                        if (this.f57519h.isEmpty()) {
                            this.f57519h = record.replaceChar_;
                            this.f57513b &= -33;
                        } else {
                            o();
                            this.f57519h.addAll(record.replaceChar_);
                        }
                    }
                    i(f().c(record.unknownFields));
                    return this;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
                @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC1158a, kotlin.reflect.jvm.internal.impl.protobuf.n.a
                /* renamed from: t */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.Record.b g(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                    /*
                        r2 = this;
                        r0 = 0
                        kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes$Record> r1 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.Record.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                        java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                        kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes$Record r3 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.Record) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                        kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes$Record r4 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.Record) r4     // Catch: java.lang.Throwable -> Lf
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
                    throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.Record.b.g(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes$Record$b");
                }

                public b u(Operation operation) {
                    operation.getClass();
                    this.f57513b |= 8;
                    this.f57517f = operation;
                    return this;
                }

                public b v(int i4) {
                    this.f57513b |= 2;
                    this.f57515d = i4;
                    return this;
                }

                public b w(int i4) {
                    this.f57513b |= 1;
                    this.f57514c = i4;
                    return this;
                }
            }

            static {
                Record record = new Record(true);
                defaultInstance = record;
                record.initFields();
            }

            public static Record getDefaultInstance() {
                return defaultInstance;
            }

            private void initFields() {
                this.range_ = 1;
                this.predefinedIndex_ = 0;
                this.string_ = "";
                this.operation_ = Operation.NONE;
                this.substringIndex_ = Collections.emptyList();
                this.replaceChar_ = Collections.emptyList();
            }

            public static b newBuilder() {
                return b.j();
            }

            public Operation getOperation() {
                return this.operation_;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
            public p<Record> getParserForType() {
                return PARSER;
            }

            public int getPredefinedIndex() {
                return this.predefinedIndex_;
            }

            public int getRange() {
                return this.range_;
            }

            public int getReplaceCharCount() {
                return this.replaceChar_.size();
            }

            public List<Integer> getReplaceCharList() {
                return this.replaceChar_;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
            public int getSerializedSize() {
                int i4 = this.memoizedSerializedSize;
                if (i4 != -1) {
                    return i4;
                }
                int o4 = (this.bitField0_ & 1) == 1 ? CodedOutputStream.o(1, this.range_) + 0 : 0;
                if ((this.bitField0_ & 2) == 2) {
                    o4 += CodedOutputStream.o(2, this.predefinedIndex_);
                }
                if ((this.bitField0_ & 8) == 8) {
                    o4 += CodedOutputStream.h(3, this.operation_.getNumber());
                }
                int i5 = 0;
                for (int i6 = 0; i6 < this.substringIndex_.size(); i6++) {
                    i5 += CodedOutputStream.p(this.substringIndex_.get(i6).intValue());
                }
                int i7 = o4 + i5;
                if (!getSubstringIndexList().isEmpty()) {
                    i7 = i7 + 1 + CodedOutputStream.p(i5);
                }
                this.substringIndexMemoizedSerializedSize = i5;
                int i8 = 0;
                for (int i9 = 0; i9 < this.replaceChar_.size(); i9++) {
                    i8 += CodedOutputStream.p(this.replaceChar_.get(i9).intValue());
                }
                int i10 = i7 + i8;
                if (!getReplaceCharList().isEmpty()) {
                    i10 = i10 + 1 + CodedOutputStream.p(i8);
                }
                this.replaceCharMemoizedSerializedSize = i8;
                if ((this.bitField0_ & 4) == 4) {
                    i10 += CodedOutputStream.d(6, getStringBytes());
                }
                int size = i10 + this.unknownFields.size();
                this.memoizedSerializedSize = size;
                return size;
            }

            public String getString() {
                Object obj = this.string_;
                if (obj instanceof String) {
                    return (String) obj;
                }
                kotlin.reflect.jvm.internal.impl.protobuf.d dVar = (kotlin.reflect.jvm.internal.impl.protobuf.d) obj;
                String A = dVar.A();
                if (dVar.r()) {
                    this.string_ = A;
                }
                return A;
            }

            public kotlin.reflect.jvm.internal.impl.protobuf.d getStringBytes() {
                Object obj = this.string_;
                if (obj instanceof String) {
                    kotlin.reflect.jvm.internal.impl.protobuf.d m4 = kotlin.reflect.jvm.internal.impl.protobuf.d.m((String) obj);
                    this.string_ = m4;
                    return m4;
                }
                return (kotlin.reflect.jvm.internal.impl.protobuf.d) obj;
            }

            public int getSubstringIndexCount() {
                return this.substringIndex_.size();
            }

            public List<Integer> getSubstringIndexList() {
                return this.substringIndex_;
            }

            public boolean hasOperation() {
                return (this.bitField0_ & 8) == 8;
            }

            public boolean hasPredefinedIndex() {
                return (this.bitField0_ & 2) == 2;
            }

            public boolean hasRange() {
                return (this.bitField0_ & 1) == 1;
            }

            public boolean hasString() {
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
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                getSerializedSize();
                if ((this.bitField0_ & 1) == 1) {
                    codedOutputStream.a0(1, this.range_);
                }
                if ((this.bitField0_ & 2) == 2) {
                    codedOutputStream.a0(2, this.predefinedIndex_);
                }
                if ((this.bitField0_ & 8) == 8) {
                    codedOutputStream.S(3, this.operation_.getNumber());
                }
                if (getSubstringIndexList().size() > 0) {
                    codedOutputStream.o0(34);
                    codedOutputStream.o0(this.substringIndexMemoizedSerializedSize);
                }
                for (int i4 = 0; i4 < this.substringIndex_.size(); i4++) {
                    codedOutputStream.b0(this.substringIndex_.get(i4).intValue());
                }
                if (getReplaceCharList().size() > 0) {
                    codedOutputStream.o0(42);
                    codedOutputStream.o0(this.replaceCharMemoizedSerializedSize);
                }
                for (int i5 = 0; i5 < this.replaceChar_.size(); i5++) {
                    codedOutputStream.b0(this.replaceChar_.get(i5).intValue());
                }
                if ((this.bitField0_ & 4) == 4) {
                    codedOutputStream.O(6, getStringBytes());
                }
                codedOutputStream.i0(this.unknownFields);
            }

            public static b newBuilder(Record record) {
                return newBuilder().h(record);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public Record getDefaultInstanceForType() {
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

            private Record(GeneratedMessageLite.b bVar) {
                super(bVar);
                this.substringIndexMemoizedSerializedSize = -1;
                this.replaceCharMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = bVar.f();
            }

            private Record(boolean z3) {
                this.substringIndexMemoizedSerializedSize = -1;
                this.replaceCharMemoizedSerializedSize = -1;
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f57629a;
            }

            private Record(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, f fVar) throws InvalidProtocolBufferException {
                this.substringIndexMemoizedSerializedSize = -1;
                this.replaceCharMemoizedSerializedSize = -1;
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
                                    this.range_ = eVar.s();
                                } else if (K == 16) {
                                    this.bitField0_ |= 2;
                                    this.predefinedIndex_ = eVar.s();
                                } else if (K == 24) {
                                    int n4 = eVar.n();
                                    Operation valueOf = Operation.valueOf(n4);
                                    if (valueOf == null) {
                                        J.o0(K);
                                        J.o0(n4);
                                    } else {
                                        this.bitField0_ |= 8;
                                        this.operation_ = valueOf;
                                    }
                                } else if (K == 32) {
                                    if (!(z4 & true)) {
                                        this.substringIndex_ = new ArrayList();
                                        z4 |= true;
                                    }
                                    this.substringIndex_.add(Integer.valueOf(eVar.s()));
                                } else if (K == 34) {
                                    int j4 = eVar.j(eVar.A());
                                    if (!(z4 & true) && eVar.e() > 0) {
                                        this.substringIndex_ = new ArrayList();
                                        z4 |= true;
                                    }
                                    while (eVar.e() > 0) {
                                        this.substringIndex_.add(Integer.valueOf(eVar.s()));
                                    }
                                    eVar.i(j4);
                                } else if (K == 40) {
                                    if (!(z4 & true)) {
                                        this.replaceChar_ = new ArrayList();
                                        z4 |= true;
                                    }
                                    this.replaceChar_.add(Integer.valueOf(eVar.s()));
                                } else if (K == 42) {
                                    int j5 = eVar.j(eVar.A());
                                    if (!(z4 & true) && eVar.e() > 0) {
                                        this.replaceChar_ = new ArrayList();
                                        z4 |= true;
                                    }
                                    while (eVar.e() > 0) {
                                        this.replaceChar_.add(Integer.valueOf(eVar.s()));
                                    }
                                    eVar.i(j5);
                                } else if (K != 50) {
                                    if (!parseUnknownField(eVar, J, fVar, K)) {
                                    }
                                } else {
                                    kotlin.reflect.jvm.internal.impl.protobuf.d l4 = eVar.l();
                                    this.bitField0_ |= 4;
                                    this.string_ = l4;
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
                            this.substringIndex_ = Collections.unmodifiableList(this.substringIndex_);
                        }
                        if (z4 & true) {
                            this.replaceChar_ = Collections.unmodifiableList(this.replaceChar_);
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
                    this.substringIndex_ = Collections.unmodifiableList(this.substringIndex_);
                }
                if (z4 & true) {
                    this.replaceChar_ = Collections.unmodifiableList(this.replaceChar_);
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
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<StringTableTypes> {
            a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
            /* renamed from: m */
            public StringTableTypes c(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, f fVar) throws InvalidProtocolBufferException {
                return new StringTableTypes(eVar, fVar);
            }
        }

        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class b extends GeneratedMessageLite.b<StringTableTypes, b> implements e {

            /* renamed from: b  reason: collision with root package name */
            private int f57520b;

            /* renamed from: c  reason: collision with root package name */
            private List<Record> f57521c = Collections.emptyList();

            /* renamed from: d  reason: collision with root package name */
            private List<Integer> f57522d = Collections.emptyList();

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
                if ((this.f57520b & 2) != 2) {
                    this.f57522d = new ArrayList(this.f57522d);
                    this.f57520b |= 2;
                }
            }

            private void p() {
                if ((this.f57520b & 1) != 1) {
                    this.f57521c = new ArrayList(this.f57521c);
                    this.f57520b |= 1;
                }
            }

            private void r() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public final boolean isInitialized() {
                return true;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: k */
            public StringTableTypes build() {
                StringTableTypes l4 = l();
                if (l4.isInitialized()) {
                    return l4;
                }
                throw a.AbstractC1158a.c(l4);
            }

            public StringTableTypes l() {
                StringTableTypes stringTableTypes = new StringTableTypes(this);
                if ((this.f57520b & 1) == 1) {
                    this.f57521c = Collections.unmodifiableList(this.f57521c);
                    this.f57520b &= -2;
                }
                stringTableTypes.record_ = this.f57521c;
                if ((this.f57520b & 2) == 2) {
                    this.f57522d = Collections.unmodifiableList(this.f57522d);
                    this.f57520b &= -3;
                }
                stringTableTypes.localName_ = this.f57522d;
                return stringTableTypes;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: m */
            public b d() {
                return n().h(l());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b, kotlin.reflect.jvm.internal.impl.protobuf.o
            /* renamed from: q */
            public StringTableTypes getDefaultInstanceForType() {
                return StringTableTypes.getDefaultInstance();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
            /* renamed from: s */
            public b h(StringTableTypes stringTableTypes) {
                if (stringTableTypes == StringTableTypes.getDefaultInstance()) {
                    return this;
                }
                if (!stringTableTypes.record_.isEmpty()) {
                    if (this.f57521c.isEmpty()) {
                        this.f57521c = stringTableTypes.record_;
                        this.f57520b &= -2;
                    } else {
                        p();
                        this.f57521c.addAll(stringTableTypes.record_);
                    }
                }
                if (!stringTableTypes.localName_.isEmpty()) {
                    if (this.f57522d.isEmpty()) {
                        this.f57522d = stringTableTypes.localName_;
                        this.f57520b &= -3;
                    } else {
                        o();
                        this.f57522d.addAll(stringTableTypes.localName_);
                    }
                }
                i(f().c(stringTableTypes.unknownFields));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC1158a, kotlin.reflect.jvm.internal.impl.protobuf.n.a
            /* renamed from: t */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.b g(kotlin.reflect.jvm.internal.impl.protobuf.e r3, kotlin.reflect.jvm.internal.impl.protobuf.f r4) throws java.io.IOException {
                /*
                    r2 = this;
                    r0 = 0
                    kotlin.reflect.jvm.internal.impl.protobuf.p<kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes> r1 = kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.PARSER     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
                    kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes r3 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes) r3     // Catch: java.lang.Throwable -> Lf kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException -> L11
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
                    kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes r4 = (kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf.StringTableTypes.b.g(kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.f):kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf$StringTableTypes$b");
            }
        }

        static {
            StringTableTypes stringTableTypes = new StringTableTypes(true);
            defaultInstance = stringTableTypes;
            stringTableTypes.initFields();
        }

        public static StringTableTypes getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.record_ = Collections.emptyList();
            this.localName_ = Collections.emptyList();
        }

        public static b newBuilder() {
            return b.j();
        }

        public static StringTableTypes parseDelimitedFrom(InputStream inputStream, f fVar) throws IOException {
            return PARSER.d(inputStream, fVar);
        }

        public List<Integer> getLocalNameList() {
            return this.localName_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite, kotlin.reflect.jvm.internal.impl.protobuf.n
        public p<StringTableTypes> getParserForType() {
            return PARSER;
        }

        public List<Record> getRecordList() {
            return this.record_;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
        public int getSerializedSize() {
            int i4 = this.memoizedSerializedSize;
            if (i4 != -1) {
                return i4;
            }
            int i5 = 0;
            for (int i6 = 0; i6 < this.record_.size(); i6++) {
                i5 += CodedOutputStream.s(1, this.record_.get(i6));
            }
            int i7 = 0;
            for (int i8 = 0; i8 < this.localName_.size(); i8++) {
                i7 += CodedOutputStream.p(this.localName_.get(i8).intValue());
            }
            int i9 = i5 + i7;
            if (!getLocalNameList().isEmpty()) {
                i9 = i9 + 1 + CodedOutputStream.p(i7);
            }
            this.localNameMemoizedSerializedSize = i7;
            int size = i9 + this.unknownFields.size();
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
            for (int i4 = 0; i4 < this.record_.size(); i4++) {
                codedOutputStream.d0(1, this.record_.get(i4));
            }
            if (getLocalNameList().size() > 0) {
                codedOutputStream.o0(42);
                codedOutputStream.o0(this.localNameMemoizedSerializedSize);
            }
            for (int i5 = 0; i5 < this.localName_.size(); i5++) {
                codedOutputStream.b0(this.localName_.get(i5).intValue());
            }
            codedOutputStream.i0(this.unknownFields);
        }

        public static b newBuilder(StringTableTypes stringTableTypes) {
            return newBuilder().h(stringTableTypes);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public StringTableTypes getDefaultInstanceForType() {
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

        private StringTableTypes(GeneratedMessageLite.b bVar) {
            super(bVar);
            this.localNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = bVar.f();
        }

        private StringTableTypes(boolean z3) {
            this.localNameMemoizedSerializedSize = -1;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            this.unknownFields = kotlin.reflect.jvm.internal.impl.protobuf.d.f57629a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private StringTableTypes(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, f fVar) throws InvalidProtocolBufferException {
            this.localNameMemoizedSerializedSize = -1;
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
                                    this.record_ = new ArrayList();
                                    z4 |= true;
                                }
                                this.record_.add(eVar.u(Record.PARSER, fVar));
                            } else if (K == 40) {
                                if (!(z4 & true)) {
                                    this.localName_ = new ArrayList();
                                    z4 |= true;
                                }
                                this.localName_.add(Integer.valueOf(eVar.s()));
                            } else if (K != 42) {
                                if (!parseUnknownField(eVar, J, fVar, K)) {
                                }
                            } else {
                                int j4 = eVar.j(eVar.A());
                                if (!(z4 & true) && eVar.e() > 0) {
                                    this.localName_ = new ArrayList();
                                    z4 |= true;
                                }
                                while (eVar.e() > 0) {
                                    this.localName_.add(Integer.valueOf(eVar.s()));
                                }
                                eVar.i(j4);
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
                        this.record_ = Collections.unmodifiableList(this.record_);
                    }
                    if (z4 & true) {
                        this.localName_ = Collections.unmodifiableList(this.localName_);
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
                this.record_ = Collections.unmodifiableList(this.record_);
            }
            if (z4 & true) {
                this.localName_ = Collections.unmodifiableList(this.localName_);
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

    static {
        ProtoBuf.Constructor defaultInstance = ProtoBuf.Constructor.getDefaultInstance();
        JvmMethodSignature defaultInstance2 = JvmMethodSignature.getDefaultInstance();
        JvmMethodSignature defaultInstance3 = JvmMethodSignature.getDefaultInstance();
        WireFormat.FieldType fieldType = WireFormat.FieldType.MESSAGE;
        f57487a = GeneratedMessageLite.newSingularGeneratedExtension(defaultInstance, defaultInstance2, defaultInstance3, null, 100, fieldType, JvmMethodSignature.class);
        f57488b = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Function.getDefaultInstance(), JvmMethodSignature.getDefaultInstance(), JvmMethodSignature.getDefaultInstance(), null, 100, fieldType, JvmMethodSignature.class);
        ProtoBuf.Function defaultInstance4 = ProtoBuf.Function.getDefaultInstance();
        WireFormat.FieldType fieldType2 = WireFormat.FieldType.INT32;
        f57489c = GeneratedMessageLite.newSingularGeneratedExtension(defaultInstance4, 0, null, null, 101, fieldType2, Integer.class);
        f57490d = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Property.getDefaultInstance(), JvmPropertySignature.getDefaultInstance(), JvmPropertySignature.getDefaultInstance(), null, 100, fieldType, JvmPropertySignature.class);
        f57491e = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Property.getDefaultInstance(), 0, null, null, 101, fieldType2, Integer.class);
        f57492f = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Type.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 100, fieldType, false, ProtoBuf.Annotation.class);
        f57493g = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Type.getDefaultInstance(), Boolean.FALSE, null, null, 101, WireFormat.FieldType.BOOL, Boolean.class);
        f57494h = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.TypeParameter.getDefaultInstance(), ProtoBuf.Annotation.getDefaultInstance(), null, 100, fieldType, false, ProtoBuf.Annotation.class);
        f57495i = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Class.getDefaultInstance(), 0, null, null, 101, fieldType2, Integer.class);
        f57496j = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Class.getDefaultInstance(), ProtoBuf.Property.getDefaultInstance(), null, 102, fieldType, false, ProtoBuf.Property.class);
        f57497k = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Class.getDefaultInstance(), 0, null, null, 103, fieldType2, Integer.class);
        f57498l = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Class.getDefaultInstance(), 0, null, null, 104, fieldType2, Integer.class);
        f57499m = GeneratedMessageLite.newSingularGeneratedExtension(ProtoBuf.Package.getDefaultInstance(), 0, null, null, 101, fieldType2, Integer.class);
        f57500n = GeneratedMessageLite.newRepeatedGeneratedExtension(ProtoBuf.Package.getDefaultInstance(), ProtoBuf.Property.getDefaultInstance(), null, 102, fieldType, false, ProtoBuf.Property.class);
    }

    public static void a(f fVar) {
        fVar.a(f57487a);
        fVar.a(f57488b);
        fVar.a(f57489c);
        fVar.a(f57490d);
        fVar.a(f57491e);
        fVar.a(f57492f);
        fVar.a(f57493g);
        fVar.a(f57494h);
        fVar.a(f57495i);
        fVar.a(f57496j);
        fVar.a(f57497k);
        fVar.a(f57498l);
        fVar.a(f57499m);
        fVar.a(f57500n);
    }
}
