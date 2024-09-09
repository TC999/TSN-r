package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.reflect.jvm.internal.impl.descriptors.w;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.types.m0;
import kotlin.reflect.jvm.internal.impl.util.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: modifierChecks.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class k implements kotlin.reflect.jvm.internal.impl.util.b {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f58515a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final d2.l<kotlin.reflect.jvm.internal.impl.builtins.h, e0> f58516b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final String f58517c;

    /* compiled from: modifierChecks.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends k {
        @NotNull

        /* renamed from: d  reason: collision with root package name */
        public static final a f58518d = new a();

        /* compiled from: modifierChecks.kt */
        /* renamed from: kotlin.reflect.jvm.internal.impl.util.k$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class C1188a extends Lambda implements d2.l<kotlin.reflect.jvm.internal.impl.builtins.h, e0> {

            /* renamed from: a  reason: collision with root package name */
            public static final C1188a f58519a = new C1188a();

            C1188a() {
                super(1);
            }

            @Override // d2.l
            @NotNull
            /* renamed from: a */
            public final e0 invoke(@NotNull kotlin.reflect.jvm.internal.impl.builtins.h hVar) {
                f0.p(hVar, "$this$null");
                m0 booleanType = hVar.n();
                f0.o(booleanType, "booleanType");
                return booleanType;
            }
        }

        private a() {
            super("Boolean", C1188a.f58519a, null);
        }
    }

    /* compiled from: modifierChecks.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends k {
        @NotNull

        /* renamed from: d  reason: collision with root package name */
        public static final b f58520d = new b();

        /* compiled from: modifierChecks.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class a extends Lambda implements d2.l<kotlin.reflect.jvm.internal.impl.builtins.h, e0> {

            /* renamed from: a  reason: collision with root package name */
            public static final a f58521a = new a();

            a() {
                super(1);
            }

            @Override // d2.l
            @NotNull
            /* renamed from: a */
            public final e0 invoke(@NotNull kotlin.reflect.jvm.internal.impl.builtins.h hVar) {
                f0.p(hVar, "$this$null");
                m0 intType = hVar.D();
                f0.o(intType, "intType");
                return intType;
            }
        }

        private b() {
            super("Int", a.f58521a, null);
        }
    }

    /* compiled from: modifierChecks.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c extends k {
        @NotNull

        /* renamed from: d  reason: collision with root package name */
        public static final c f58522d = new c();

        /* compiled from: modifierChecks.kt */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        static final class a extends Lambda implements d2.l<kotlin.reflect.jvm.internal.impl.builtins.h, e0> {

            /* renamed from: a  reason: collision with root package name */
            public static final a f58523a = new a();

            a() {
                super(1);
            }

            @Override // d2.l
            @NotNull
            /* renamed from: a */
            public final e0 invoke(@NotNull kotlin.reflect.jvm.internal.impl.builtins.h hVar) {
                f0.p(hVar, "$this$null");
                m0 unitType = hVar.Z();
                f0.o(unitType, "unitType");
                return unitType;
            }
        }

        private c() {
            super("Unit", a.f58523a, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private k(String str, d2.l<? super kotlin.reflect.jvm.internal.impl.builtins.h, ? extends e0> lVar) {
        this.f58515a = str;
        this.f58516b = lVar;
        this.f58517c = f0.C("must return ", str);
    }

    public /* synthetic */ k(String str, d2.l lVar, u uVar) {
        this(str, lVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.b
    @Nullable
    public String a(@NotNull w wVar) {
        return b.a.a(this, wVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.b
    public boolean b(@NotNull w functionDescriptor) {
        f0.p(functionDescriptor, "functionDescriptor");
        return f0.g(functionDescriptor.getReturnType(), this.f58516b.invoke(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.g(functionDescriptor)));
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.b
    @NotNull
    public String getDescription() {
        return this.f58517c;
    }
}
