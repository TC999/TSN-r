package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.protobuf.WireFormat;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.g;
import kotlin.reflect.jvm.internal.impl.protobuf.h;
import kotlin.reflect.jvm.internal.impl.protobuf.n;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class GeneratedMessageLite extends kotlin.reflect.jvm.internal.impl.protobuf.a implements Serializable {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f57603a;

        static {
            int[] iArr = new int[WireFormat.JavaType.values().length];
            f57603a = iArr;
            try {
                iArr[WireFormat.JavaType.MESSAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f57603a[WireFormat.JavaType.ENUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static abstract class b<MessageType extends GeneratedMessageLite, BuilderType extends b> extends a.AbstractC1158a<BuilderType> {

        /* renamed from: a  reason: collision with root package name */
        private kotlin.reflect.jvm.internal.impl.protobuf.d f57604a = kotlin.reflect.jvm.internal.impl.protobuf.d.f57629a;

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC1158a
        /* renamed from: d */
        public BuilderType clone() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        /* renamed from: e */
        public abstract MessageType getDefaultInstanceForType();

        public final kotlin.reflect.jvm.internal.impl.protobuf.d f() {
            return this.f57604a;
        }

        public abstract BuilderType h(MessageType messagetype);

        public final BuilderType i(kotlin.reflect.jvm.internal.impl.protobuf.d dVar) {
            this.f57604a = dVar;
            return this;
        }
    }

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static abstract class c<MessageType extends ExtendableMessage<MessageType>, BuilderType extends c<MessageType, BuilderType>> extends b<MessageType, BuilderType> implements d<MessageType> {

        /* renamed from: b  reason: collision with root package name */
        private g<e> f57605b = g.g();

        /* renamed from: c  reason: collision with root package name */
        private boolean f57606c;

        /* JADX INFO: Access modifiers changed from: private */
        public g<e> k() {
            this.f57605b.q();
            this.f57606c = false;
            return this.f57605b;
        }

        private void m() {
            if (this.f57606c) {
                return;
            }
            this.f57605b = this.f57605b.clone();
            this.f57606c = true;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.b
        /* renamed from: l */
        public BuilderType d() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public boolean n() {
            return this.f57605b.n();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void o(MessageType messagetype) {
            m();
            this.f57605b.r(((ExtendableMessage) messagetype).extensions);
        }
    }

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface d<MessageType extends ExtendableMessage> extends o {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class e implements g.b<e> {

        /* renamed from: a  reason: collision with root package name */
        final h.b<?> f57607a;

        /* renamed from: b  reason: collision with root package name */
        final int f57608b;

        /* renamed from: c  reason: collision with root package name */
        final WireFormat.FieldType f57609c;

        /* renamed from: d  reason: collision with root package name */
        final boolean f57610d;

        /* renamed from: e  reason: collision with root package name */
        final boolean f57611e;

        e(h.b<?> bVar, int i4, WireFormat.FieldType fieldType, boolean z3, boolean z4) {
            this.f57607a = bVar;
            this.f57608b = i4;
            this.f57609c = fieldType;
            this.f57610d = z3;
            this.f57611e = z4;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.g.b
        public WireFormat.JavaType I() {
            return this.f57609c.getJavaType();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.g.b
        public boolean J() {
            return this.f57611e;
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(e eVar) {
            return this.f57608b - eVar.f57608b;
        }

        public h.b<?> b() {
            return this.f57607a;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.g.b
        public n.a c(n.a aVar, n nVar) {
            return ((b) aVar).h((GeneratedMessageLite) nVar);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.g.b
        public int getNumber() {
            return this.f57608b;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.g.b
        public boolean v() {
            return this.f57610d;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.g.b
        public WireFormat.FieldType x() {
            return this.f57609c;
        }
    }

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class f<ContainingType extends n, Type> {

        /* renamed from: a  reason: collision with root package name */
        final ContainingType f57612a;

        /* renamed from: b  reason: collision with root package name */
        final Type f57613b;

        /* renamed from: c  reason: collision with root package name */
        final n f57614c;

        /* renamed from: d  reason: collision with root package name */
        final e f57615d;

        /* renamed from: e  reason: collision with root package name */
        final Class f57616e;

        /* renamed from: f  reason: collision with root package name */
        final Method f57617f;

        f(ContainingType containingtype, Type type, n nVar, e eVar, Class cls) {
            if (containingtype != null) {
                if (eVar.x() == WireFormat.FieldType.MESSAGE && nVar == null) {
                    throw new IllegalArgumentException("Null messageDefaultInstance");
                }
                this.f57612a = containingtype;
                this.f57613b = type;
                this.f57614c = nVar;
                this.f57615d = eVar;
                this.f57616e = cls;
                if (h.a.class.isAssignableFrom(cls)) {
                    this.f57617f = GeneratedMessageLite.getMethodOrDie(cls, "valueOf", Integer.TYPE);
                    return;
                } else {
                    this.f57617f = null;
                    return;
                }
            }
            throw new IllegalArgumentException("Null containingTypeDefaultInstance");
        }

        Object a(Object obj) {
            if (this.f57615d.v()) {
                if (this.f57615d.I() == WireFormat.JavaType.ENUM) {
                    ArrayList arrayList = new ArrayList();
                    for (Object obj2 : (List) obj) {
                        arrayList.add(e(obj2));
                    }
                    return arrayList;
                }
                return obj;
            }
            return e(obj);
        }

        public ContainingType b() {
            return this.f57612a;
        }

        public n c() {
            return this.f57614c;
        }

        public int d() {
            return this.f57615d.getNumber();
        }

        Object e(Object obj) {
            return this.f57615d.I() == WireFormat.JavaType.ENUM ? GeneratedMessageLite.invokeOrDie(this.f57617f, null, (Integer) obj) : obj;
        }

        Object f(Object obj) {
            return this.f57615d.I() == WireFormat.JavaType.ENUM ? Integer.valueOf(((h.a) obj).getNumber()) : obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GeneratedMessageLite() {
    }

    static Method getMethodOrDie(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e4) {
            String name = cls.getName();
            String valueOf = String.valueOf(str);
            StringBuilder sb = new StringBuilder(name.length() + 45 + valueOf.length());
            sb.append("Generated message class \"");
            sb.append(name);
            sb.append("\" missing method \"");
            sb.append(valueOf);
            sb.append("\".");
            throw new RuntimeException(sb.toString(), e4);
        }
    }

    static Object invokeOrDie(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e4) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e4);
        } catch (InvocationTargetException e5) {
            Throwable cause = e5.getCause();
            if (!(cause instanceof RuntimeException)) {
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
            throw ((RuntimeException) cause);
        }
    }

    public static <ContainingType extends n, Type> f<ContainingType, Type> newRepeatedGeneratedExtension(ContainingType containingtype, n nVar, h.b<?> bVar, int i4, WireFormat.FieldType fieldType, boolean z3, Class cls) {
        return new f<>(containingtype, Collections.emptyList(), nVar, new e(bVar, i4, fieldType, true, z3), cls);
    }

    public static <ContainingType extends n, Type> f<ContainingType, Type> newSingularGeneratedExtension(ContainingType containingtype, Type type, n nVar, h.b<?> bVar, int i4, WireFormat.FieldType fieldType, Class cls) {
        return new f<>(containingtype, type, nVar, new e(bVar, i4, fieldType, false, false), cls);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.n
    public p<? extends n> getParserForType() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void makeExtensionsImmutable() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean parseUnknownField(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, CodedOutputStream codedOutputStream, kotlin.reflect.jvm.internal.impl.protobuf.f fVar, int i4) throws IOException {
        return eVar.P(i4, codedOutputStream);
    }

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static abstract class ExtendableMessage<MessageType extends ExtendableMessage<MessageType>> extends GeneratedMessageLite implements d<MessageType> {
        private final g<e> extensions;

        /* JADX INFO: Access modifiers changed from: protected */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class a {

            /* renamed from: a  reason: collision with root package name */
            private final Iterator<Map.Entry<e, Object>> f57599a;

            /* renamed from: b  reason: collision with root package name */
            private Map.Entry<e, Object> f57600b;

            /* renamed from: c  reason: collision with root package name */
            private final boolean f57601c;

            /* synthetic */ a(ExtendableMessage extendableMessage, boolean z3, a aVar) {
                this(z3);
            }

            public void a(int i4, CodedOutputStream codedOutputStream) throws IOException {
                while (true) {
                    Map.Entry<e, Object> entry = this.f57600b;
                    if (entry == null || entry.getKey().getNumber() >= i4) {
                        return;
                    }
                    e key = this.f57600b.getKey();
                    if (this.f57601c && key.I() == WireFormat.JavaType.MESSAGE && !key.v()) {
                        codedOutputStream.f0(key.getNumber(), (n) this.f57600b.getValue());
                    } else {
                        g.z(key, this.f57600b.getValue(), codedOutputStream);
                    }
                    if (this.f57599a.hasNext()) {
                        this.f57600b = this.f57599a.next();
                    } else {
                        this.f57600b = null;
                    }
                }
            }

            private a(boolean z3) {
                Iterator<Map.Entry<e, Object>> p3 = ExtendableMessage.this.extensions.p();
                this.f57599a = p3;
                if (p3.hasNext()) {
                    this.f57600b = p3.next();
                }
                this.f57601c = z3;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public ExtendableMessage() {
            this.extensions = g.t();
        }

        private void verifyExtensionContainingType(f<MessageType, ?> fVar) {
            if (fVar.b() != getDefaultInstanceForType()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public boolean extensionsAreInitialized() {
            return this.extensions.n();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public int extensionsSerializedSize() {
            return this.extensions.k();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <Type> Type getExtension(f<MessageType, Type> fVar) {
            verifyExtensionContainingType(fVar);
            Object h4 = this.extensions.h(fVar.f57615d);
            if (h4 == null) {
                return fVar.f57613b;
            }
            return (Type) fVar.a(h4);
        }

        public final <Type> int getExtensionCount(f<MessageType, List<Type>> fVar) {
            verifyExtensionContainingType(fVar);
            return this.extensions.j(fVar.f57615d);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <Type> boolean hasExtension(f<MessageType, Type> fVar) {
            verifyExtensionContainingType(fVar);
            return this.extensions.m(fVar.f57615d);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite
        public void makeExtensionsImmutable() {
            this.extensions.q();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public ExtendableMessage<MessageType>.a newExtensionWriter() {
            return new a(this, false, null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite
        public boolean parseUnknownField(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, CodedOutputStream codedOutputStream, kotlin.reflect.jvm.internal.impl.protobuf.f fVar, int i4) throws IOException {
            return GeneratedMessageLite.parseUnknownField(this.extensions, getDefaultInstanceForType(), eVar, codedOutputStream, fVar, i4);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public ExtendableMessage(c<MessageType, ?> cVar) {
            this.extensions = cVar.k();
        }

        public final <Type> Type getExtension(f<MessageType, List<Type>> fVar, int i4) {
            verifyExtensionContainingType(fVar);
            return (Type) fVar.e(this.extensions.i(fVar.f57615d, i4));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GeneratedMessageLite(b bVar) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static <MessageType extends kotlin.reflect.jvm.internal.impl.protobuf.n> boolean parseUnknownField(kotlin.reflect.jvm.internal.impl.protobuf.g<kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.e> r5, MessageType r6, kotlin.reflect.jvm.internal.impl.protobuf.e r7, kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream r8, kotlin.reflect.jvm.internal.impl.protobuf.f r9, int r10) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 289
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite.parseUnknownField(kotlin.reflect.jvm.internal.impl.protobuf.g, kotlin.reflect.jvm.internal.impl.protobuf.n, kotlin.reflect.jvm.internal.impl.protobuf.e, kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream, kotlin.reflect.jvm.internal.impl.protobuf.f, int):boolean");
    }
}
