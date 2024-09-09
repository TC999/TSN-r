package kotlin.reflect.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.SortedMap;
import kotlin.Metadata;
import kotlin.collections.y0;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.n0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.y;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: KDeclarationContainerImpl.kt */
@Metadata(bv = {}, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\b \u0018\u0000 =2\u00020\u0001:\u0003=>?B\u0007\u00a2\u0006\u0004\b;\u0010<JG\u0010\u000b\u001a\u0004\u0018\u00010\n*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0010\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u00052\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\t\u001a\u00020\bH\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ?\u0010\r\u001a\u0004\u0018\u00010\n*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0010\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u00052\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ(\u0010\u0011\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010*\u0006\u0012\u0002\b\u00030\u00022\u0010\u0010\u0006\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u000fH\u0002J*\u0010\u0017\u001a\u00020\u00162\u0010\u0010\u0013\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\bH\u0002J\u001a\u0010\u0018\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0003H\u0002J$\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0002J\u0014\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0014\u001a\u00020\u0003H\u0002J\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010\u0004\u001a\u00020\u001eH&J\u0016\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u001f2\u0006\u0010\u0004\u001a\u00020\u001eH&J\u0012\u0010%\u001a\u0004\u0018\u00010 2\u0006\u0010$\u001a\u00020\u0019H&J\"\u0010+\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030*0\u001f2\u0006\u0010'\u001a\u00020&2\u0006\u0010)\u001a\u00020(H\u0004J\u0016\u0010-\u001a\u00020 2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u0003J\u0016\u0010.\u001a\u00020\"2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u0003J\u0018\u0010/\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0003J \u00101\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u00100\u001a\u00020\bJ\u0014\u00102\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00102\u0006\u0010\u0014\u001a\u00020\u0003J\u0014\u00103\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00102\u0006\u0010\u0014\u001a\u00020\u0003R\u0018\u00106\u001a\u0006\u0012\u0002\b\u00030\u00028TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b4\u00105R\u001a\u0010:\u001a\b\u0012\u0004\u0012\u0002070\u001f8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b8\u00109\u00a8\u0006@"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "Lkotlin/jvm/internal/r;", "Ljava/lang/Class;", "", "name", "", "parameterTypes", "returnType", "", "isStaticDefault", "Ljava/lang/reflect/Method;", "Q", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;Z)Ljava/lang/reflect/Method;", "T", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;Ljava/lang/Class;)Ljava/lang/reflect/Method;", "", "Ljava/lang/reflect/Constructor;", "S", "", "result", "desc", "isConstructor", "Lkotlin/f1;", "r", "O", "", "begin", "end", "R", "P", "Lkotlin/reflect/jvm/internal/impl/name/f;", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/p0;", "N", "Lkotlin/reflect/jvm/internal/impl/descriptors/w;", "J", "index", "K", "Lkotlin/reflect/jvm/internal/impl/resolve/scopes/h;", "scope", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "belonginess", "Lkotlin/reflect/jvm/internal/f;", "L", "signature", "H", "F", "G", "isMember", "x", "s", "u", "M", "()Ljava/lang/Class;", "methodOwner", "Lkotlin/reflect/jvm/internal/impl/descriptors/j;", "I", "()Ljava/util/Collection;", "constructorDescriptors", "<init>", "()V", "a", "b", "MemberBelonginess", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class KDeclarationContainerImpl implements kotlin.jvm.internal.r {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f55859a = new a(null);

    /* renamed from: b  reason: collision with root package name */
    private static final Class<?> f55860b = kotlin.jvm.internal.u.class;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final Regex f55861c = new Regex("<v#(\\d+)>");

    /* compiled from: KDeclarationContainerImpl.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0084\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$MemberBelonginess;", "", "(Ljava/lang/String;I)V", "accept", "", "member", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "DECLARED", "INHERITED", "kotlin-reflection"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    protected enum MemberBelonginess {
        DECLARED,
        INHERITED;

        public final boolean accept(@NotNull CallableMemberDescriptor member) {
            kotlin.jvm.internal.f0.p(member, "member");
            return member.i().isReal() == (this == DECLARED);
        }
    }

    /* compiled from: KDeclarationContainerImpl.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R$\u0010\t\u001a\u0012\u0012\u0002\b\u0003 \b*\b\u0012\u0002\b\u0003\u0018\u00010\u00070\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$a;", "", "Lkotlin/text/Regex;", "LOCAL_PROPERTY_SIGNATURE", "Lkotlin/text/Regex;", "a", "()Lkotlin/text/Regex;", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "DEFAULT_CONSTRUCTOR_MARKER", "Ljava/lang/Class;", "<init>", "()V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @NotNull
        public final Regex a() {
            return KDeclarationContainerImpl.f55861c;
        }
    }

    /* compiled from: KDeclarationContainerImpl.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00a6\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tR\u001b\u0010\u0007\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl$b;", "", "Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/k;", "a", "Lkotlin/reflect/jvm/internal/y$a;", "getModuleData", "()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;", "moduleData", "<init>", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;)V", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public abstract class b {

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ kotlin.reflect.n<Object>[] f55862c = {n0.u(new PropertyReference1Impl(n0.d(b.class), "moduleData", "getModuleData()Lorg/jetbrains/kotlin/descriptors/runtime/components/RuntimeModuleData;"))};
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        private final y.a f55863a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ KDeclarationContainerImpl f55864b;

        /* compiled from: KDeclarationContainerImpl.kt */
        @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/k;", "kotlin.jvm.PlatformType", "a", "()Lkotlin/reflect/jvm/internal/impl/descriptors/runtime/components/k;"}, k = 3, mv = {1, 6, 0})
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class a extends Lambda implements d2.a<kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.k> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ KDeclarationContainerImpl f55865a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(KDeclarationContainerImpl kDeclarationContainerImpl) {
                super(0);
                this.f55865a = kDeclarationContainerImpl;
            }

            @Override // d2.a
            /* renamed from: a */
            public final kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.k invoke() {
                return x.b(this.f55865a.d());
            }
        }

        public b(KDeclarationContainerImpl this$0) {
            kotlin.jvm.internal.f0.p(this$0, "this$0");
            this.f55864b = this$0;
            this.f55863a = y.c(new a(this$0));
        }

        @NotNull
        public final kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.k a() {
            Object b4 = this.f55863a.b(this, f55862c[0]);
            kotlin.jvm.internal.f0.o(b4, "<get-moduleData>(...)");
            return (kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.k) b4;
        }
    }

    /* compiled from: KDeclarationContainerImpl.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/reflect/jvm/internal/impl/descriptors/w;", "descriptor", "", "a", "(Lkotlin/reflect/jvm/internal/impl/descriptors/w;)Ljava/lang/CharSequence;"}, k = 3, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class c extends Lambda implements d2.l<kotlin.reflect.jvm.internal.impl.descriptors.w, CharSequence> {

        /* renamed from: a  reason: collision with root package name */
        public static final c f55866a = new c();

        c() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final CharSequence invoke(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.w descriptor) {
            kotlin.jvm.internal.f0.p(descriptor, "descriptor");
            return kotlin.reflect.jvm.internal.impl.renderer.b.f57732j.s(descriptor) + " | " + b0.f55877a.g(descriptor).a();
        }
    }

    /* compiled from: KDeclarationContainerImpl.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlin/reflect/jvm/internal/impl/descriptors/p0;", "descriptor", "", "a", "(Lkotlin/reflect/jvm/internal/impl/descriptors/p0;)Ljava/lang/CharSequence;"}, k = 3, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class d extends Lambda implements d2.l<p0, CharSequence> {

        /* renamed from: a  reason: collision with root package name */
        public static final d f55867a = new d();

        d() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final CharSequence invoke(@NotNull p0 descriptor) {
            kotlin.jvm.internal.f0.p(descriptor, "descriptor");
            return kotlin.reflect.jvm.internal.impl.renderer.b.f57732j.s(descriptor) + " | " + b0.f55877a.f(descriptor).a();
        }
    }

    /* compiled from: KDeclarationContainerImpl.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlin/reflect/jvm/internal/impl/descriptors/s;", "kotlin.jvm.PlatformType", "first", "second", "", "a", "(Lkotlin/reflect/jvm/internal/impl/descriptors/s;Lkotlin/reflect/jvm/internal/impl/descriptors/s;)I"}, k = 3, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class e<T> implements Comparator {

        /* renamed from: a  reason: collision with root package name */
        public static final e<T> f55868a = new e<>();

        e() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public final int compare(kotlin.reflect.jvm.internal.impl.descriptors.s sVar, kotlin.reflect.jvm.internal.impl.descriptors.s sVar2) {
            Integer d4 = kotlin.reflect.jvm.internal.impl.descriptors.r.d(sVar, sVar2);
            if (d4 == null) {
                return 0;
            }
            return d4.intValue();
        }
    }

    /* compiled from: KDeclarationContainerImpl.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"kotlin/reflect/jvm/internal/KDeclarationContainerImpl$f", "Lkotlin/reflect/jvm/internal/a;", "Lkotlin/reflect/jvm/internal/impl/descriptors/j;", "descriptor", "Lkotlin/f1;", "data", "Lkotlin/reflect/jvm/internal/f;", "visitConstructorDescriptor", "(Lorg/jetbrains/kotlin/descriptors/ConstructorDescriptor;Lkotlin/f1;)Lkotlin/reflect/jvm/internal/f;", "kotlin-reflection"}, k = 1, mv = {1, 6, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class f extends kotlin.reflect.jvm.internal.a {
        f() {
            super(KDeclarationContainerImpl.this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.impl.l, kotlin.reflect.jvm.internal.impl.descriptors.m
        @NotNull
        /* renamed from: r */
        public kotlin.reflect.jvm.internal.f<?> j(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.j descriptor, @NotNull f1 data) {
            kotlin.jvm.internal.f0.p(descriptor, "descriptor");
            kotlin.jvm.internal.f0.p(data, "data");
            throw new IllegalStateException(kotlin.jvm.internal.f0.C("No constructors should appear here: ", descriptor));
        }
    }

    private final List<Class<?>> O(String str) {
        boolean U2;
        int q3;
        int i4;
        ArrayList arrayList = new ArrayList();
        int i5 = 1;
        while (str.charAt(i5) != ')') {
            int i6 = i5;
            while (str.charAt(i6) == '[') {
                i6++;
            }
            char charAt = str.charAt(i6);
            U2 = kotlin.text.x.U2("VZCBSIFJD", charAt, false, 2, null);
            if (U2) {
                i4 = i6 + 1;
            } else if (charAt == 'L') {
                q3 = kotlin.text.x.q3(str, ';', i5, false, 4, null);
                i4 = q3 + 1;
            } else {
                throw new KotlinReflectionInternalError(kotlin.jvm.internal.f0.C("Unknown type prefix in the method signature: ", str));
            }
            arrayList.add(R(str, i5, i4));
            i5 = i4;
        }
        return arrayList;
    }

    private final Class<?> P(String str) {
        int q3;
        q3 = kotlin.text.x.q3(str, ')', 0, false, 6, null);
        return R(str, q3 + 1, str.length());
    }

    private final Method Q(Class<?> cls, String str, Class<?>[] clsArr, Class<?> cls2, boolean z3) {
        Class<? super Object> superclass;
        Class<?> a4;
        if (z3) {
            clsArr[0] = cls;
        }
        Method T = T(cls, str, clsArr, cls2);
        if (T == null && ((superclass = cls.getSuperclass()) == null || (T = Q(superclass, str, clsArr, cls2, z3)) == null)) {
            Class<?>[] interfaces = cls.getInterfaces();
            kotlin.jvm.internal.f0.o(interfaces, "interfaces");
            int length = interfaces.length;
            int i4 = 0;
            while (i4 < length) {
                Class<?> superInterface = interfaces[i4];
                i4++;
                kotlin.jvm.internal.f0.o(superInterface, "superInterface");
                Method Q = Q(superInterface, str, clsArr, cls2, z3);
                if (Q == null) {
                    if (z3 && (a4 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.components.e.a(kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.f(superInterface), kotlin.jvm.internal.f0.C(superInterface.getName(), "$DefaultImpls"))) != null) {
                        clsArr[0] = superInterface;
                        Q = T(a4, str, clsArr, cls2);
                        if (Q == null) {
                        }
                    }
                }
                return Q;
            }
            return null;
        }
        return T;
    }

    private final Class<?> R(String str, int i4, int i5) {
        String j22;
        char charAt = str.charAt(i4);
        if (charAt == 'L') {
            ClassLoader f4 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.f(d());
            String substring = str.substring(i4 + 1, i5 - 1);
            kotlin.jvm.internal.f0.o(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            j22 = kotlin.text.w.j2(substring, '/', '.', false, 4, null);
            Class<?> loadClass = f4.loadClass(j22);
            kotlin.jvm.internal.f0.o(loadClass, "jClass.safeClassLoader.l\u2026d - 1).replace('/', '.'))");
            return loadClass;
        } else if (charAt == '[') {
            return f0.f(R(str, i4 + 1, i5));
        } else {
            if (charAt == 'V') {
                Class<?> TYPE = Void.TYPE;
                kotlin.jvm.internal.f0.o(TYPE, "TYPE");
                return TYPE;
            } else if (charAt == 'Z') {
                return Boolean.TYPE;
            } else {
                if (charAt == 'C') {
                    return Character.TYPE;
                }
                if (charAt == 'B') {
                    return Byte.TYPE;
                }
                if (charAt == 'S') {
                    return Short.TYPE;
                }
                if (charAt == 'I') {
                    return Integer.TYPE;
                }
                if (charAt == 'F') {
                    return Float.TYPE;
                }
                if (charAt == 'J') {
                    return Long.TYPE;
                }
                if (charAt == 'D') {
                    return Double.TYPE;
                }
                throw new KotlinReflectionInternalError(kotlin.jvm.internal.f0.C("Unknown type prefix in the method signature: ", str));
            }
        }
    }

    private final Constructor<?> S(Class<?> cls, List<? extends Class<?>> list) {
        try {
            Object[] array = list.toArray(new Class[0]);
            if (array != null) {
                Class[] clsArr = (Class[]) array;
                return cls.getDeclaredConstructor((Class[]) Arrays.copyOf(clsArr, clsArr.length));
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private final Method T(Class<?> cls, String str, Class<?>[] clsArr, Class<?> cls2) {
        boolean z3;
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
            if (kotlin.jvm.internal.f0.g(declaredMethod.getReturnType(), cls2)) {
                return declaredMethod;
            }
            Method[] declaredMethods = cls.getDeclaredMethods();
            kotlin.jvm.internal.f0.o(declaredMethods, "declaredMethods");
            int length = declaredMethods.length;
            int i4 = 0;
            while (i4 < length) {
                Method method = declaredMethods[i4];
                i4++;
                if (kotlin.jvm.internal.f0.g(method.getName(), str) && kotlin.jvm.internal.f0.g(method.getReturnType(), cls2) && Arrays.equals(method.getParameterTypes(), clsArr)) {
                    z3 = true;
                    continue;
                } else {
                    z3 = false;
                    continue;
                }
                if (z3) {
                    return method;
                }
            }
            return null;
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private final void r(List<Class<?>> list, String str, boolean z3) {
        List<Class<?>> O = O(str);
        list.addAll(O);
        int size = ((O.size() + 32) - 1) / 32;
        int i4 = 0;
        while (i4 < size) {
            i4++;
            Class<?> TYPE = Integer.TYPE;
            kotlin.jvm.internal.f0.o(TYPE, "TYPE");
            list.add(TYPE);
        }
        Class cls = z3 ? f55860b : Object.class;
        kotlin.jvm.internal.f0.o(cls, "if (isConstructor) DEFAU\u2026RKER else Any::class.java");
        list.add(cls);
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.descriptors.w F(@NotNull String name, @NotNull String signature) {
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.w> J;
        Object S4;
        String X2;
        kotlin.jvm.internal.f0.p(name, "name");
        kotlin.jvm.internal.f0.p(signature, "signature");
        if (kotlin.jvm.internal.f0.g(name, "<init>")) {
            J = kotlin.collections.f0.G5(I());
        } else {
            kotlin.reflect.jvm.internal.impl.name.f f4 = kotlin.reflect.jvm.internal.impl.name.f.f(name);
            kotlin.jvm.internal.f0.o(f4, "identifier(name)");
            J = J(f4);
        }
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.w> collection = J;
        ArrayList arrayList = new ArrayList();
        for (Object obj : collection) {
            if (kotlin.jvm.internal.f0.g(b0.f55877a.g((kotlin.reflect.jvm.internal.impl.descriptors.w) obj).a(), signature)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.size() != 1) {
            X2 = kotlin.collections.f0.X2(collection, "\n", null, null, 0, null, c.f55866a, 30, null);
            StringBuilder sb = new StringBuilder();
            sb.append("Function '");
            sb.append(name);
            sb.append("' (JVM signature: ");
            sb.append(signature);
            sb.append(") not resolved in ");
            sb.append(this);
            sb.append(':');
            sb.append(X2.length() == 0 ? " no members found" : kotlin.jvm.internal.f0.C("\n", X2));
            throw new KotlinReflectionInternalError(sb.toString());
        }
        S4 = kotlin.collections.f0.S4(arrayList);
        return (kotlin.reflect.jvm.internal.impl.descriptors.w) S4;
    }

    @Nullable
    public final Method G(@NotNull String name, @NotNull String desc) {
        Method Q;
        kotlin.jvm.internal.f0.p(name, "name");
        kotlin.jvm.internal.f0.p(desc, "desc");
        if (kotlin.jvm.internal.f0.g(name, "<init>")) {
            return null;
        }
        Object[] array = O(desc).toArray(new Class[0]);
        if (array != null) {
            Class<?>[] clsArr = (Class[]) array;
            Class<?> P = P(desc);
            Method Q2 = Q(M(), name, clsArr, P, false);
            if (Q2 == null) {
                if (!M().isInterface() || (Q = Q(Object.class, name, clsArr, P, false)) == null) {
                    return null;
                }
                return Q;
            }
            return Q2;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @NotNull
    public final p0 H(@NotNull String name, @NotNull String signature) {
        Object S4;
        SortedMap r3;
        Object Y2;
        String X2;
        Object m22;
        kotlin.jvm.internal.f0.p(name, "name");
        kotlin.jvm.internal.f0.p(signature, "signature");
        kotlin.text.k matchEntire = f55861c.matchEntire(signature);
        if (matchEntire != null) {
            String str = matchEntire.a().k().b().get(1);
            p0 K = K(Integer.parseInt(str));
            if (K != null) {
                return K;
            }
            throw new KotlinReflectionInternalError("Local property #" + str + " not found in " + d());
        }
        kotlin.reflect.jvm.internal.impl.name.f f4 = kotlin.reflect.jvm.internal.impl.name.f.f(name);
        kotlin.jvm.internal.f0.o(f4, "identifier(name)");
        Collection<p0> N = N(f4);
        ArrayList arrayList = new ArrayList();
        for (Object obj : N) {
            if (kotlin.jvm.internal.f0.g(b0.f55877a.f((p0) obj).a(), signature)) {
                arrayList.add(obj);
            }
        }
        if (!arrayList.isEmpty()) {
            if (arrayList.size() != 1) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Object obj2 : arrayList) {
                    kotlin.reflect.jvm.internal.impl.descriptors.s visibility = ((p0) obj2).getVisibility();
                    Object obj3 = linkedHashMap.get(visibility);
                    if (obj3 == null) {
                        obj3 = new ArrayList();
                        linkedHashMap.put(visibility, obj3);
                    }
                    ((List) obj3).add(obj2);
                }
                r3 = y0.r(linkedHashMap, e.f55868a);
                Collection values = r3.values();
                kotlin.jvm.internal.f0.o(values, "properties\n             \u2026\n                }.values");
                Y2 = kotlin.collections.f0.Y2(values);
                List mostVisibleProperties = (List) Y2;
                if (mostVisibleProperties.size() == 1) {
                    kotlin.jvm.internal.f0.o(mostVisibleProperties, "mostVisibleProperties");
                    m22 = kotlin.collections.f0.m2(mostVisibleProperties);
                    return (p0) m22;
                }
                kotlin.reflect.jvm.internal.impl.name.f f5 = kotlin.reflect.jvm.internal.impl.name.f.f(name);
                kotlin.jvm.internal.f0.o(f5, "identifier(name)");
                X2 = kotlin.collections.f0.X2(N(f5), "\n", null, null, 0, null, d.f55867a, 30, null);
                StringBuilder sb = new StringBuilder();
                sb.append("Property '");
                sb.append(name);
                sb.append("' (JVM signature: ");
                sb.append(signature);
                sb.append(") not resolved in ");
                sb.append(this);
                sb.append(':');
                sb.append(X2.length() == 0 ? " no members found" : kotlin.jvm.internal.f0.C("\n", X2));
                throw new KotlinReflectionInternalError(sb.toString());
            }
            S4 = kotlin.collections.f0.S4(arrayList);
            return (p0) S4;
        }
        throw new KotlinReflectionInternalError("Property '" + name + "' (JVM signature: " + signature + ") not resolved in " + this);
    }

    @NotNull
    public abstract Collection<kotlin.reflect.jvm.internal.impl.descriptors.j> I();

    @NotNull
    public abstract Collection<kotlin.reflect.jvm.internal.impl.descriptors.w> J(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar);

    @Nullable
    public abstract p0 K(int i4);

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0050 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x001e A[SYNTHETIC] */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.Collection<kotlin.reflect.jvm.internal.f<?>> L(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.resolve.scopes.h r8, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.KDeclarationContainerImpl.MemberBelonginess r9) {
        /*
            r7 = this;
            java.lang.String r0 = "scope"
            kotlin.jvm.internal.f0.p(r8, r0)
            java.lang.String r0 = "belonginess"
            kotlin.jvm.internal.f0.p(r9, r0)
            kotlin.reflect.jvm.internal.KDeclarationContainerImpl$f r0 = new kotlin.reflect.jvm.internal.KDeclarationContainerImpl$f
            r0.<init>()
            r1 = 0
            r2 = 3
            java.util.Collection r8 = kotlin.reflect.jvm.internal.impl.resolve.scopes.k.a.a(r8, r1, r1, r2, r1)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r8 = r8.iterator()
        L1e:
            boolean r3 = r8.hasNext()
            if (r3 == 0) goto L54
            java.lang.Object r3 = r8.next()
            kotlin.reflect.jvm.internal.impl.descriptors.k r3 = (kotlin.reflect.jvm.internal.impl.descriptors.k) r3
            boolean r4 = r3 instanceof kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
            if (r4 == 0) goto L4c
            r4 = r3
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r4 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r4
            kotlin.reflect.jvm.internal.impl.descriptors.s r5 = r4.getVisibility()
            kotlin.reflect.jvm.internal.impl.descriptors.s r6 = kotlin.reflect.jvm.internal.impl.descriptors.r.f56534h
            boolean r5 = kotlin.jvm.internal.f0.g(r5, r6)
            if (r5 != 0) goto L4c
            boolean r4 = r9.accept(r4)
            if (r4 == 0) goto L4c
            kotlin.f1 r4 = kotlin.f1.f55527a
            java.lang.Object r3 = r3.C(r0, r4)
            kotlin.reflect.jvm.internal.f r3 = (kotlin.reflect.jvm.internal.f) r3
            goto L4d
        L4c:
            r3 = r1
        L4d:
            if (r3 != 0) goto L50
            goto L1e
        L50:
            r2.add(r3)
            goto L1e
        L54:
            java.util.List r8 = kotlin.collections.w.G5(r2)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.KDeclarationContainerImpl.L(kotlin.reflect.jvm.internal.impl.resolve.scopes.h, kotlin.reflect.jvm.internal.KDeclarationContainerImpl$MemberBelonginess):java.util.Collection");
    }

    @NotNull
    protected Class<?> M() {
        Class<?> g4 = kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.d.g(d());
        return g4 == null ? d() : g4;
    }

    @NotNull
    public abstract Collection<p0> N(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar);

    @Nullable
    public final Constructor<?> s(@NotNull String desc) {
        kotlin.jvm.internal.f0.p(desc, "desc");
        return S(d(), O(desc));
    }

    @Nullable
    public final Constructor<?> u(@NotNull String desc) {
        kotlin.jvm.internal.f0.p(desc, "desc");
        Class<?> d4 = d();
        ArrayList arrayList = new ArrayList();
        r(arrayList, desc, true);
        f1 f1Var = f1.f55527a;
        return S(d4, arrayList);
    }

    @Nullable
    public final Method x(@NotNull String name, @NotNull String desc, boolean z3) {
        kotlin.jvm.internal.f0.p(name, "name");
        kotlin.jvm.internal.f0.p(desc, "desc");
        if (kotlin.jvm.internal.f0.g(name, "<init>")) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (z3) {
            arrayList.add(d());
        }
        r(arrayList, desc, false);
        Class<?> M = M();
        String C = kotlin.jvm.internal.f0.C(name, "$default");
        Object[] array = arrayList.toArray(new Class[0]);
        if (array != null) {
            return Q(M, C, (Class[]) array, P(desc), z3);
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }
}
