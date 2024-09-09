package kotlin.reflect.jvm.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KParameter;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.impl.descriptors.s0;
import org.jetbrains.annotations.NotNull;

/* compiled from: ReflectionObjectRenderer.kt */
@Metadata(bv = {}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\u0007\u001a\u00020\u0006*\u00060\u0002j\u0002`\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u0006*\u00060\u0002j\u0002`\u00032\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u000eJ\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u0010J\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0010J\u000e\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0017R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lkotlin/reflect/jvm/internal/a0;", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "Lkotlin/reflect/jvm/internal/impl/descriptors/s0;", "receiver", "Lkotlin/f1;", "a", "Lkotlin/reflect/jvm/internal/impl/descriptors/a;", "callable", "b", "descriptor", "", "c", "Lkotlin/reflect/jvm/internal/impl/descriptors/p0;", "g", "Lkotlin/reflect/jvm/internal/impl/descriptors/w;", "d", "invoke", "e", "Lkotlin/reflect/jvm/internal/o;", "parameter", "f", "Lkotlin/reflect/jvm/internal/impl/types/e0;", "type", "h", "Lkotlin/reflect/jvm/internal/impl/renderer/b;", "Lkotlin/reflect/jvm/internal/impl/renderer/b;", "renderer", "<init>", "()V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a0 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a0 f55871a = new a0();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.renderer.b f55872b = kotlin.reflect.jvm.internal.impl.renderer.b.f57729g;

    /* compiled from: ReflectionObjectRenderer.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f55873a;

        static {
            int[] iArr = new int[KParameter.Kind.values().length];
            iArr[KParameter.Kind.EXTENSION_RECEIVER.ordinal()] = 1;
            iArr[KParameter.Kind.INSTANCE.ordinal()] = 2;
            iArr[KParameter.Kind.VALUE.ordinal()] = 3;
            f55873a = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReflectionObjectRenderer.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlin/reflect/jvm/internal/impl/descriptors/d1;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lkotlin/reflect/jvm/internal/impl/descriptors/d1;)Ljava/lang/CharSequence;"}, k = 3, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends Lambda implements d2.l<d1, CharSequence> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f55874a = new b();

        b() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final CharSequence invoke(d1 d1Var) {
            a0 a0Var = a0.f55871a;
            kotlin.reflect.jvm.internal.impl.types.e0 type = d1Var.getType();
            kotlin.jvm.internal.f0.o(type, "it.type");
            return a0Var.h(type);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReflectionObjectRenderer.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlin/reflect/jvm/internal/impl/descriptors/d1;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lkotlin/reflect/jvm/internal/impl/descriptors/d1;)Ljava/lang/CharSequence;"}, k = 3, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c extends Lambda implements d2.l<d1, CharSequence> {

        /* renamed from: a  reason: collision with root package name */
        public static final c f55875a = new c();

        c() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final CharSequence invoke(d1 d1Var) {
            a0 a0Var = a0.f55871a;
            kotlin.reflect.jvm.internal.impl.types.e0 type = d1Var.getType();
            kotlin.jvm.internal.f0.o(type, "it.type");
            return a0Var.h(type);
        }
    }

    private a0() {
    }

    private final void a(StringBuilder sb, s0 s0Var) {
        if (s0Var != null) {
            kotlin.reflect.jvm.internal.impl.types.e0 type = s0Var.getType();
            kotlin.jvm.internal.f0.o(type, "receiver.type");
            sb.append(h(type));
            sb.append(".");
        }
    }

    private final void b(StringBuilder sb, kotlin.reflect.jvm.internal.impl.descriptors.a aVar) {
        s0 i4 = f0.i(aVar);
        s0 Q = aVar.Q();
        a(sb, i4);
        boolean z3 = (i4 == null || Q == null) ? false : true;
        if (z3) {
            sb.append("(");
        }
        a(sb, Q);
        if (z3) {
            sb.append(")");
        }
    }

    private final String c(kotlin.reflect.jvm.internal.impl.descriptors.a aVar) {
        if (aVar instanceof p0) {
            return g((p0) aVar);
        }
        if (aVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.w) {
            return d((kotlin.reflect.jvm.internal.impl.descriptors.w) aVar);
        }
        throw new IllegalStateException(kotlin.jvm.internal.f0.C("Illegal callable: ", aVar).toString());
    }

    @NotNull
    public final String d(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.w descriptor) {
        kotlin.jvm.internal.f0.p(descriptor, "descriptor");
        StringBuilder sb = new StringBuilder();
        sb.append("fun ");
        a0 a0Var = f55871a;
        a0Var.b(sb, descriptor);
        kotlin.reflect.jvm.internal.impl.renderer.b bVar = f55872b;
        kotlin.reflect.jvm.internal.impl.name.f name = descriptor.getName();
        kotlin.jvm.internal.f0.o(name, "descriptor.name");
        sb.append(bVar.x(name, true));
        List<d1> h4 = descriptor.h();
        kotlin.jvm.internal.f0.o(h4, "descriptor.valueParameters");
        kotlin.collections.f0.V2(h4, sb, ", ", "(", ")", 0, null, b.f55874a, 48, null);
        sb.append(": ");
        kotlin.reflect.jvm.internal.impl.types.e0 returnType = descriptor.getReturnType();
        kotlin.jvm.internal.f0.m(returnType);
        kotlin.jvm.internal.f0.o(returnType, "descriptor.returnType!!");
        sb.append(a0Var.h(returnType));
        String sb2 = sb.toString();
        kotlin.jvm.internal.f0.o(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @NotNull
    public final String e(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.w invoke) {
        kotlin.jvm.internal.f0.p(invoke, "invoke");
        StringBuilder sb = new StringBuilder();
        a0 a0Var = f55871a;
        a0Var.b(sb, invoke);
        List<d1> h4 = invoke.h();
        kotlin.jvm.internal.f0.o(h4, "invoke.valueParameters");
        kotlin.collections.f0.V2(h4, sb, ", ", "(", ")", 0, null, c.f55875a, 48, null);
        sb.append(" -> ");
        kotlin.reflect.jvm.internal.impl.types.e0 returnType = invoke.getReturnType();
        kotlin.jvm.internal.f0.m(returnType);
        kotlin.jvm.internal.f0.o(returnType, "invoke.returnType!!");
        sb.append(a0Var.h(returnType));
        String sb2 = sb.toString();
        kotlin.jvm.internal.f0.o(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @NotNull
    public final String f(@NotNull o parameter) {
        kotlin.jvm.internal.f0.p(parameter, "parameter");
        StringBuilder sb = new StringBuilder();
        int i4 = a.f55873a[parameter.i().ordinal()];
        if (i4 == 1) {
            sb.append("extension receiver parameter");
        } else if (i4 == 2) {
            sb.append("instance parameter");
        } else if (i4 == 3) {
            sb.append("parameter #" + parameter.f() + ' ' + ((Object) parameter.getName()));
        }
        sb.append(" of ");
        sb.append(f55871a.c(parameter.e().I()));
        String sb2 = sb.toString();
        kotlin.jvm.internal.f0.o(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @NotNull
    public final String g(@NotNull p0 descriptor) {
        kotlin.jvm.internal.f0.p(descriptor, "descriptor");
        StringBuilder sb = new StringBuilder();
        sb.append(descriptor.O() ? "var " : "val ");
        a0 a0Var = f55871a;
        a0Var.b(sb, descriptor);
        kotlin.reflect.jvm.internal.impl.renderer.b bVar = f55872b;
        kotlin.reflect.jvm.internal.impl.name.f name = descriptor.getName();
        kotlin.jvm.internal.f0.o(name, "descriptor.name");
        sb.append(bVar.x(name, true));
        sb.append(": ");
        kotlin.reflect.jvm.internal.impl.types.e0 type = descriptor.getType();
        kotlin.jvm.internal.f0.o(type, "descriptor.type");
        sb.append(a0Var.h(type));
        String sb2 = sb.toString();
        kotlin.jvm.internal.f0.o(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    @NotNull
    public final String h(@NotNull kotlin.reflect.jvm.internal.impl.types.e0 type) {
        kotlin.jvm.internal.f0.p(type, "type");
        return f55872b.y(type);
    }
}
