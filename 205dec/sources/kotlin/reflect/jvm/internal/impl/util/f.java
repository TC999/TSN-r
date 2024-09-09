package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.reflect.jvm.internal.impl.descriptors.w;
import kotlin.reflect.jvm.internal.impl.util.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: modifierChecks.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class f implements kotlin.reflect.jvm.internal.impl.util.b {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f58477a;

    /* compiled from: modifierChecks.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends f {
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        public static final a f58478b = new a();

        private a() {
            super("must be a member function", null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.b
        public boolean b(@NotNull w functionDescriptor) {
            f0.p(functionDescriptor, "functionDescriptor");
            return functionDescriptor.M() != null;
        }
    }

    /* compiled from: modifierChecks.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends f {
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        public static final b f58479b = new b();

        private b() {
            super("must be a member or an extension function", null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.b
        public boolean b(@NotNull w functionDescriptor) {
            f0.p(functionDescriptor, "functionDescriptor");
            return (functionDescriptor.M() == null && functionDescriptor.Q() == null) ? false : true;
        }
    }

    private f(String str) {
        this.f58477a = str;
    }

    public /* synthetic */ f(String str, u uVar) {
        this(str);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.b
    @Nullable
    public String a(@NotNull w wVar) {
        return b.a.a(this, wVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.b
    @NotNull
    public String getDescription() {
        return this.f58477a;
    }
}
