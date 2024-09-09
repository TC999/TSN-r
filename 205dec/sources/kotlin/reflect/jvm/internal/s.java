package kotlin.reflect.jvm.internal;

import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.f1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.n0;
import kotlin.reflect.full.IllegalPropertyDelegateAccessException;
import kotlin.reflect.j;
import kotlin.reflect.jvm.internal.e;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.f;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.impl.descriptors.q0;
import kotlin.reflect.jvm.internal.impl.descriptors.r0;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.d;
import kotlin.reflect.jvm.internal.y;
import kotlin.reflect.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: KPropertyImpl.kt */
@Metadata(bv = {}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\b \u0018\u0000 L*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0004MNOPB\u0019\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\u0006\u0010F\u001a\u00020)\u00a2\u0006\u0004\bG\u0010HB5\b\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\u0006\u0010\u001c\u001a\u00020\u0010\u0012\u0006\u0010\u001f\u001a\u00020\u0010\u0012\b\u0010I\u001a\u0004\u0018\u00010)\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\bG\u0010JB+\b\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\u0006\u0010\u001c\u001a\u00020\u0010\u0012\u0006\u0010\u001f\u001a\u00020\u0010\u0012\b\u00100\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\bG\u0010KJ\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0004J(\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H\u0004J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007H\u0096\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016R\u001a\u0010\u0017\u001a\u00020\u00128\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001c\u001a\u00020\u00108\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001f\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0019\u001a\u0004\b\u001e\u0010\u001bR\u0016\u0010\"\u001a\u0004\u0018\u00010\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001c\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010$0#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\"\u0010-\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010)0)0(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0013\u00100\u001a\u0004\u0018\u00010\u00078F\u00a2\u0006\u0006\u001a\u0004\b.\u0010/R\u0014\u00103\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b1\u00102R\u0013\u00106\u001a\u0004\u0018\u00010$8F\u00a2\u0006\u0006\u001a\u0004\b4\u00105R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u00028\u0000078&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b8\u00109R\u0018\u0010>\u001a\u0006\u0012\u0002\b\u00030;8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b<\u0010=R\u001a\u0010@\u001a\b\u0012\u0002\b\u0003\u0018\u00010;8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b?\u0010=R\u0014\u0010A\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bA\u00102R\u0014\u0010B\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bB\u00102R\u0014\u0010C\u001a\u00020\f8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bC\u00102R\u0014\u0010F\u001a\u00020)8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\bD\u0010E\u00a8\u0006Q"}, d2 = {"Lkotlin/reflect/jvm/internal/s;", "V", "Lkotlin/reflect/jvm/internal/f;", "Lkotlin/reflect/n;", "Ljava/lang/reflect/Member;", "M", "fieldOrMethod", "", "receiver1", "receiver2", "O", "other", "", "equals", "", "hashCode", "", "toString", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "e", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "G", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "f", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "name", "g", "S", "signature", "h", "Ljava/lang/Object;", "rawBoundReceiver", "Lkotlin/reflect/jvm/internal/y$b;", "Ljava/lang/reflect/Field;", "i", "Lkotlin/reflect/jvm/internal/y$b;", "_javaField", "Lkotlin/reflect/jvm/internal/y$a;", "Lkotlin/reflect/jvm/internal/impl/descriptors/p0;", "kotlin.jvm.PlatformType", "j", "Lkotlin/reflect/jvm/internal/y$a;", "_descriptor", "N", "()Ljava/lang/Object;", "boundReceiver", "K", "()Z", "isBound", "R", "()Ljava/lang/reflect/Field;", "javaField", "Lkotlin/reflect/jvm/internal/s$c;", "Q", "()Lkotlin/reflect/jvm/internal/s$c;", "getter", "Lkotlin/reflect/jvm/internal/calls/c;", "F", "()Lkotlin/reflect/jvm/internal/calls/c;", "caller", "H", "defaultCaller", "isLateinit", "isConst", "isSuspend", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", "descriptor", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;)V", "descriptorInitialValue", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;Ljava/lang/Object;)V", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "k", "a", "b", "c", "d", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class s<V> extends kotlin.reflect.jvm.internal.f<V> implements kotlin.reflect.n<V> {
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    public static final b f58640k = new b(null);
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    private static final Object f58641l = new Object();
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final KDeclarationContainerImpl f58642e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final String f58643f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private final String f58644g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private final Object f58645h;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    private final y.b<Field> f58646i;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private final y.a<p0> f58647j;

    /* compiled from: KPropertyImpl.kt */
    @Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u0001*\u0006\b\u0002\u0010\u0002 \u00012\b\u0012\u0004\u0012\u00028\u00020\u00032\b\u0012\u0004\u0012\u00028\u00010\u00042\b\u0012\u0004\u0012\u00028\u00020\u0005B\u0007\u00a2\u0006\u0004\b\u001f\u0010 R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u00068&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0011\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000e8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0016\u001a\u00020\u00128VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00128VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00128VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00128VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u0014R\u0014\u0010\u001a\u001a\u00020\u00128VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u0014R\u0014\u0010\u001e\u001a\u00020\u001b8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lkotlin/reflect/jvm/internal/s$a;", "PropertyType", "ReturnType", "Lkotlin/reflect/jvm/internal/f;", "Lkotlin/reflect/n$a;", "Lkotlin/reflect/i;", "Lkotlin/reflect/jvm/internal/s;", "M", "()Lkotlin/reflect/jvm/internal/s;", "property", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "G", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "container", "Lkotlin/reflect/jvm/internal/calls/c;", "H", "()Lkotlin/reflect/jvm/internal/calls/c;", "defaultCaller", "", "K", "()Z", "isBound", "isInline", "isExternal", "isOperator", "isInfix", "isSuspend", "Lkotlin/reflect/jvm/internal/impl/descriptors/o0;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyAccessorDescriptor;", "descriptor", "<init>", "()V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static abstract class a<PropertyType, ReturnType> extends kotlin.reflect.jvm.internal.f<ReturnType> implements kotlin.reflect.i<ReturnType>, n.a<PropertyType> {
        @Override // kotlin.reflect.jvm.internal.f
        @NotNull
        public KDeclarationContainerImpl G() {
            return M().G();
        }

        @Override // kotlin.reflect.jvm.internal.f
        @Nullable
        public kotlin.reflect.jvm.internal.calls.c<?> H() {
            return null;
        }

        @Override // kotlin.reflect.jvm.internal.f
        public boolean K() {
            return M().K();
        }

        @NotNull
        public abstract o0 L();

        @NotNull
        public abstract s<PropertyType> M();

        @Override // kotlin.reflect.i
        public boolean isExternal() {
            return L().isExternal();
        }

        @Override // kotlin.reflect.i
        public boolean isInfix() {
            return L().isInfix();
        }

        @Override // kotlin.reflect.i
        public boolean isInline() {
            return L().isInline();
        }

        @Override // kotlin.reflect.i
        public boolean isOperator() {
            return L().isOperator();
        }

        @Override // kotlin.reflect.c
        public boolean isSuspend() {
            return L().isSuspend();
        }
    }

    /* compiled from: KPropertyImpl.kt */
    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0002\u001a\u00020\u00018\u0006\u00a2\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\b"}, d2 = {"Lkotlin/reflect/jvm/internal/s$b;", "", "EXTENSION_PROPERTY_DELEGATE", "Ljava/lang/Object;", "a", "()Ljava/lang/Object;", "<init>", "()V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.u uVar) {
            this();
        }

        @NotNull
        public final Object a() {
            return s.f58641l;
        }
    }

    /* compiled from: KPropertyImpl.kt */
    @Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00010\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0096\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016R\u001b\u0010\u0011\u001a\u00020\f8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001f\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u00128VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lkotlin/reflect/jvm/internal/s$c;", "V", "Lkotlin/reflect/jvm/internal/s$a;", "Lkotlin/reflect/n$c;", "", "toString", "", "other", "", "equals", "", "hashCode", "Lkotlin/reflect/jvm/internal/impl/descriptors/q0;", "e", "Lkotlin/reflect/jvm/internal/y$a;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;", "descriptor", "Lkotlin/reflect/jvm/internal/calls/c;", "f", "Lkotlin/reflect/jvm/internal/y$b;", "F", "()Lkotlin/reflect/jvm/internal/calls/c;", "caller", "getName", "()Ljava/lang/String;", "name", "<init>", "()V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static abstract class c<V> extends a<V, V> implements n.c<V> {

        /* renamed from: g  reason: collision with root package name */
        static final /* synthetic */ kotlin.reflect.n<Object>[] f58648g = {n0.u(new PropertyReference1Impl(n0.d(c.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertyGetterDescriptor;")), n0.u(new PropertyReference1Impl(n0.d(c.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};
        @NotNull

        /* renamed from: e  reason: collision with root package name */
        private final y.a f58649e = y.c(new b(this));
        @NotNull

        /* renamed from: f  reason: collision with root package name */
        private final y.b f58650f = y.b(new a(this));

        /* compiled from: KPropertyImpl.kt */
        @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0012\u0012\u0002\b\u0003 \u0002*\b\u0012\u0002\b\u0003\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0000 \u0001\"\u0006\b\u0001\u0010\u0000 \u0001H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"V", "Lkotlin/reflect/jvm/internal/calls/c;", "kotlin.jvm.PlatformType", "a", "()Lkotlin/reflect/jvm/internal/calls/c;"}, k = 3, mv = {1, 6, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class a extends Lambda implements d2.a<kotlin.reflect.jvm.internal.calls.c<?>> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ c<V> f58651a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(c<? extends V> cVar) {
                super(0);
                this.f58651a = cVar;
            }

            @Override // d2.a
            /* renamed from: a */
            public final kotlin.reflect.jvm.internal.calls.c<?> invoke() {
                kotlin.reflect.jvm.internal.calls.c<?> b4;
                b4 = t.b(this.f58651a, true);
                return b4;
            }
        }

        /* compiled from: KPropertyImpl.kt */
        @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0000 \u0001\"\u0006\b\u0001\u0010\u0000 \u0001H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"V", "Lkotlin/reflect/jvm/internal/impl/descriptors/q0;", "kotlin.jvm.PlatformType", "a", "()Lkotlin/reflect/jvm/internal/impl/descriptors/q0;"}, k = 3, mv = {1, 6, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class b extends Lambda implements d2.a<q0> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ c<V> f58652a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            b(c<? extends V> cVar) {
                super(0);
                this.f58652a = cVar;
            }

            @Override // d2.a
            /* renamed from: a */
            public final q0 invoke() {
                q0 getter = this.f58652a.M().I().getGetter();
                return getter == null ? kotlin.reflect.jvm.internal.impl.resolve.c.b(this.f58652a.M().I(), kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0.b()) : getter;
            }
        }

        @Override // kotlin.reflect.jvm.internal.f
        @NotNull
        public kotlin.reflect.jvm.internal.calls.c<?> F() {
            Object b4 = this.f58650f.b(this, f58648g[1]);
            kotlin.jvm.internal.f0.o(b4, "<get-caller>(...)");
            return (kotlin.reflect.jvm.internal.calls.c) b4;
        }

        @Override // kotlin.reflect.jvm.internal.s.a
        @NotNull
        /* renamed from: N */
        public q0 L() {
            Object b4 = this.f58649e.b(this, f58648g[0]);
            kotlin.jvm.internal.f0.o(b4, "<get-descriptor>(...)");
            return (q0) b4;
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof c) && kotlin.jvm.internal.f0.g(M(), ((c) obj).M());
        }

        @Override // kotlin.reflect.c
        @NotNull
        public String getName() {
            return "<get-" + M().getName() + '>';
        }

        public int hashCode() {
            return M().hashCode();
        }

        @NotNull
        public String toString() {
            return kotlin.jvm.internal.f0.C("getter of ", M());
        }
    }

    /* compiled from: KPropertyImpl.kt */
    @Metadata(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b&\u0018\u0000*\u0004\b\u0001\u0010\u00012\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00010\u0004B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0002J\b\u0010\f\u001a\u00020\u000bH\u0016R\u001b\u0010\u0012\u001a\u00020\r8VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001f\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u00138VX\u0096\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00058VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lkotlin/reflect/jvm/internal/s$d;", "V", "Lkotlin/reflect/jvm/internal/s$a;", "Lkotlin/f1;", "Lkotlin/reflect/j$a;", "", "toString", "", "other", "", "equals", "", "hashCode", "Lkotlin/reflect/jvm/internal/impl/descriptors/r0;", "e", "Lkotlin/reflect/jvm/internal/y$a;", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;", "descriptor", "Lkotlin/reflect/jvm/internal/calls/c;", "f", "Lkotlin/reflect/jvm/internal/y$b;", "F", "()Lkotlin/reflect/jvm/internal/calls/c;", "caller", "getName", "()Ljava/lang/String;", "name", "<init>", "()V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static abstract class d<V> extends a<V, f1> implements j.a<V> {

        /* renamed from: g  reason: collision with root package name */
        static final /* synthetic */ kotlin.reflect.n<Object>[] f58653g = {n0.u(new PropertyReference1Impl(n0.d(d.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/PropertySetterDescriptor;")), n0.u(new PropertyReference1Impl(n0.d(d.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};
        @NotNull

        /* renamed from: e  reason: collision with root package name */
        private final y.a f58654e = y.c(new b(this));
        @NotNull

        /* renamed from: f  reason: collision with root package name */
        private final y.b f58655f = y.b(new a(this));

        /* compiled from: KPropertyImpl.kt */
        @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u0012\u0012\u0002\b\u0003 \u0002*\b\u0012\u0002\b\u0003\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0006\b\u0001\u0010\u0000 \u0001H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"V", "Lkotlin/reflect/jvm/internal/calls/c;", "kotlin.jvm.PlatformType", "a", "()Lkotlin/reflect/jvm/internal/calls/c;"}, k = 3, mv = {1, 6, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class a extends Lambda implements d2.a<kotlin.reflect.jvm.internal.calls.c<?>> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ d<V> f58656a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(d<V> dVar) {
                super(0);
                this.f58656a = dVar;
            }

            @Override // d2.a
            /* renamed from: a */
            public final kotlin.reflect.jvm.internal.calls.c<?> invoke() {
                kotlin.reflect.jvm.internal.calls.c<?> b4;
                b4 = t.b(this.f58656a, false);
                return b4;
            }
        }

        /* compiled from: KPropertyImpl.kt */
        @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\u0004\b\u0000\u0010\u0000\"\u0006\b\u0001\u0010\u0000 \u0001H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"V", "Lkotlin/reflect/jvm/internal/impl/descriptors/r0;", "kotlin.jvm.PlatformType", "a", "()Lkotlin/reflect/jvm/internal/impl/descriptors/r0;"}, k = 3, mv = {1, 6, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class b extends Lambda implements d2.a<r0> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ d<V> f58657a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(d<V> dVar) {
                super(0);
                this.f58657a = dVar;
            }

            @Override // d2.a
            /* renamed from: a */
            public final r0 invoke() {
                r0 setter = this.f58657a.M().I().getSetter();
                if (setter == null) {
                    p0 I = this.f58657a.M().I();
                    f.a aVar = kotlin.reflect.jvm.internal.impl.descriptors.annotations.f.f56241g0;
                    return kotlin.reflect.jvm.internal.impl.resolve.c.c(I, aVar.b(), aVar.b());
                }
                return setter;
            }
        }

        @Override // kotlin.reflect.jvm.internal.f
        @NotNull
        public kotlin.reflect.jvm.internal.calls.c<?> F() {
            Object b4 = this.f58655f.b(this, f58653g[1]);
            kotlin.jvm.internal.f0.o(b4, "<get-caller>(...)");
            return (kotlin.reflect.jvm.internal.calls.c) b4;
        }

        @Override // kotlin.reflect.jvm.internal.s.a
        @NotNull
        /* renamed from: N */
        public r0 L() {
            Object b4 = this.f58654e.b(this, f58653g[0]);
            kotlin.jvm.internal.f0.o(b4, "<get-descriptor>(...)");
            return (r0) b4;
        }

        public boolean equals(@Nullable Object obj) {
            return (obj instanceof d) && kotlin.jvm.internal.f0.g(M(), ((d) obj).M());
        }

        @Override // kotlin.reflect.c
        @NotNull
        public String getName() {
            return "<set-" + M().getName() + '>';
        }

        public int hashCode() {
            return M().hashCode();
        }

        @NotNull
        public String toString() {
            return kotlin.jvm.internal.f0.C("setter of ", M());
        }
    }

    /* compiled from: KPropertyImpl.kt */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\u0006\b\u0000\u0010\u0000 \u0001H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"V", "Lkotlin/reflect/jvm/internal/impl/descriptors/p0;", "kotlin.jvm.PlatformType", "a", "()Lkotlin/reflect/jvm/internal/impl/descriptors/p0;"}, k = 3, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class e extends Lambda implements d2.a<p0> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s<V> f58658a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        e(s<? extends V> sVar) {
            super(0);
            this.f58658a = sVar;
        }

        @Override // d2.a
        /* renamed from: a */
        public final p0 invoke() {
            return this.f58658a.G().H(this.f58658a.getName(), this.f58658a.S());
        }
    }

    /* compiled from: KPropertyImpl.kt */
    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0000 \u0001H\n\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"V", "Ljava/lang/reflect/Field;", "a", "()Ljava/lang/reflect/Field;"}, k = 3, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class f extends Lambda implements d2.a<Field> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ s<V> f58659a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        f(s<? extends V> sVar) {
            super(0);
            this.f58659a = sVar;
        }

        @Override // d2.a
        @Nullable
        /* renamed from: a */
        public final Field invoke() {
            Class<?> enclosingClass;
            kotlin.reflect.jvm.internal.e f4 = b0.f55877a.f(this.f58659a.I());
            if (f4 instanceof e.c) {
                e.c cVar = (e.c) f4;
                p0 b4 = cVar.b();
                d.a d4 = kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.g.d(kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.g.f57549a, cVar.e(), cVar.d(), cVar.g(), false, 8, null);
                if (d4 == null) {
                    return null;
                }
                s<V> sVar = this.f58659a;
                if (!kotlin.reflect.jvm.internal.impl.load.java.j.e(b4) && !kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization.g.f(cVar.e())) {
                    kotlin.reflect.jvm.internal.impl.descriptors.k b5 = b4.b();
                    enclosingClass = b5 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d ? f0.p((kotlin.reflect.jvm.internal.impl.descriptors.d) b5) : sVar.G().d();
                } else {
                    enclosingClass = sVar.G().d().getEnclosingClass();
                }
                if (enclosingClass != null) {
                    try {
                        return enclosingClass.getDeclaredField(d4.c());
                    } catch (NoSuchFieldException unused) {
                        return null;
                    }
                }
                return ((e.a) f4).b();
            } else if (f4 instanceof e.a) {
                return ((e.a) f4).b();
            } else {
                if ((f4 instanceof e.b) || (f4 instanceof e.d)) {
                    return null;
                }
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    private s(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, p0 p0Var, Object obj) {
        this.f58642e = kDeclarationContainerImpl;
        this.f58643f = str;
        this.f58644g = str2;
        this.f58645h = obj;
        y.b<Field> b4 = y.b(new f(this));
        kotlin.jvm.internal.f0.o(b4, "lazy {\n        when (val\u2026y -> null\n        }\n    }");
        this.f58646i = b4;
        y.a<p0> d4 = y.d(p0Var, new e(this));
        kotlin.jvm.internal.f0.o(d4, "lazySoft(descriptorIniti\u2026or(name, signature)\n    }");
        this.f58647j = d4;
    }

    @Override // kotlin.reflect.jvm.internal.f
    @NotNull
    public kotlin.reflect.jvm.internal.calls.c<?> F() {
        return Q().F();
    }

    @Override // kotlin.reflect.jvm.internal.f
    @NotNull
    public KDeclarationContainerImpl G() {
        return this.f58642e;
    }

    @Override // kotlin.reflect.jvm.internal.f
    @Nullable
    public kotlin.reflect.jvm.internal.calls.c<?> H() {
        return Q().H();
    }

    @Override // kotlin.reflect.jvm.internal.f
    public boolean K() {
        return !kotlin.jvm.internal.f0.g(this.f58645h, CallableReference.NO_RECEIVER);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final Member M() {
        if (I().D()) {
            kotlin.reflect.jvm.internal.e f4 = b0.f55877a.f(I());
            if (f4 instanceof e.c) {
                e.c cVar = (e.c) f4;
                if (cVar.f().hasDelegateMethod()) {
                    JvmProtoBuf.JvmMethodSignature delegateMethod = cVar.f().getDelegateMethod();
                    if (delegateMethod.hasName() && delegateMethod.hasDesc()) {
                        return G().G(cVar.d().getString(delegateMethod.getName()), cVar.d().getString(delegateMethod.getDesc()));
                    }
                    return null;
                }
            }
            return R();
        }
        return null;
    }

    @Nullable
    public final Object N() {
        return kotlin.reflect.jvm.internal.calls.g.a(this.f58645h, I());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final Object O(@Nullable Member member, @Nullable Object obj, @Nullable Object obj2) {
        try {
            Object obj3 = f58641l;
            if ((obj != obj3 && obj2 != obj3) || I().Q() != null) {
                Object N = K() ? N() : obj;
                if (!(N != obj3)) {
                    N = null;
                }
                if (!K()) {
                    obj = obj2;
                }
                if (!(obj != obj3)) {
                    obj = null;
                }
                if (member == null) {
                    return null;
                }
                if (member instanceof Field) {
                    return ((Field) member).get(N);
                }
                if (!(member instanceof Method)) {
                    throw new AssertionError("delegate field/method " + member + " neither field nor method");
                }
                int length = ((Method) member).getParameterTypes().length;
                if (length != 0) {
                    if (length == 1) {
                        Method method = (Method) member;
                        Object[] objArr = new Object[1];
                        if (N == null) {
                            Class<?> cls = ((Method) member).getParameterTypes()[0];
                            kotlin.jvm.internal.f0.o(cls, "fieldOrMethod.parameterTypes[0]");
                            N = f0.g(cls);
                        }
                        objArr[0] = N;
                        return method.invoke(null, objArr);
                    } else if (length == 2) {
                        Method method2 = (Method) member;
                        Object[] objArr2 = new Object[2];
                        objArr2[0] = N;
                        if (obj == null) {
                            Class<?> cls2 = ((Method) member).getParameterTypes()[1];
                            kotlin.jvm.internal.f0.o(cls2, "fieldOrMethod.parameterTypes[1]");
                            obj = f0.g(cls2);
                        }
                        objArr2[1] = obj;
                        return method2.invoke(null, objArr2);
                    } else {
                        throw new AssertionError("delegate method " + member + " should take 0, 1, or 2 parameters");
                    }
                }
                return ((Method) member).invoke(null, new Object[0]);
            }
            throw new RuntimeException('\'' + this + "' is not an extension property and thus getExtensionDelegate() is not going to work, use getDelegate() instead");
        } catch (IllegalAccessException e4) {
            throw new IllegalPropertyDelegateAccessException(e4);
        }
    }

    @Override // kotlin.reflect.jvm.internal.f
    @NotNull
    /* renamed from: P */
    public p0 I() {
        p0 invoke = this.f58647j.invoke();
        kotlin.jvm.internal.f0.o(invoke, "_descriptor()");
        return invoke;
    }

    @NotNull
    public abstract c<V> Q();

    @Nullable
    public final Field R() {
        return this.f58646i.invoke();
    }

    @NotNull
    public final String S() {
        return this.f58644g;
    }

    public boolean equals(@Nullable Object obj) {
        s<?> d4 = f0.d(obj);
        return d4 != null && kotlin.jvm.internal.f0.g(G(), d4.G()) && kotlin.jvm.internal.f0.g(getName(), d4.getName()) && kotlin.jvm.internal.f0.g(this.f58644g, d4.f58644g) && kotlin.jvm.internal.f0.g(this.f58645h, d4.f58645h);
    }

    @Override // kotlin.reflect.c
    @NotNull
    public String getName() {
        return this.f58643f;
    }

    public int hashCode() {
        return (((G().hashCode() * 31) + getName().hashCode()) * 31) + this.f58644g.hashCode();
    }

    @Override // kotlin.reflect.n
    public boolean isConst() {
        return I().isConst();
    }

    @Override // kotlin.reflect.n
    public boolean isLateinit() {
        return I().v0();
    }

    @Override // kotlin.reflect.c
    public boolean isSuspend() {
        return false;
    }

    @NotNull
    public String toString() {
        return a0.f55871a.g(I());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public s(@NotNull KDeclarationContainerImpl container, @NotNull String name, @NotNull String signature, @Nullable Object obj) {
        this(container, name, signature, null, obj);
        kotlin.jvm.internal.f0.p(container, "container");
        kotlin.jvm.internal.f0.p(name, "name");
        kotlin.jvm.internal.f0.p(signature, "signature");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public s(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.KDeclarationContainerImpl r8, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.p0 r9) {
        /*
            r7 = this;
            java.lang.String r0 = "container"
            kotlin.jvm.internal.f0.p(r8, r0)
            java.lang.String r0 = "descriptor"
            kotlin.jvm.internal.f0.p(r9, r0)
            kotlin.reflect.jvm.internal.impl.name.f r0 = r9.getName()
            java.lang.String r3 = r0.b()
            java.lang.String r0 = "descriptor.name.asString()"
            kotlin.jvm.internal.f0.o(r3, r0)
            kotlin.reflect.jvm.internal.b0 r0 = kotlin.reflect.jvm.internal.b0.f55877a
            kotlin.reflect.jvm.internal.e r0 = r0.f(r9)
            java.lang.String r4 = r0.a()
            java.lang.Object r6 = kotlin.jvm.internal.CallableReference.NO_RECEIVER
            r1 = r7
            r2 = r8
            r5 = r9
            r1.<init>(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.s.<init>(kotlin.reflect.jvm.internal.KDeclarationContainerImpl, kotlin.reflect.jvm.internal.impl.descriptors.p0):void");
    }
}
