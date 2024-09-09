package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Map;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: specialBuiltinMembers.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class d extends SpecialGenericSignatures {
    @NotNull

    /* renamed from: n  reason: collision with root package name */
    public static final d f56716n = new d();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: specialBuiltinMembers.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends Lambda implements d2.l<CallableMemberDescriptor, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ u0 f56717a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(u0 u0Var) {
            super(1);
            this.f56717a = u0Var;
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final Boolean invoke(@NotNull CallableMemberDescriptor it) {
            f0.p(it, "it");
            return Boolean.valueOf(SpecialGenericSignatures.f56640a.j().containsKey(kotlin.reflect.jvm.internal.impl.load.kotlin.u.d(this.f56717a)));
        }
    }

    private d() {
    }

    @Nullable
    public final kotlin.reflect.jvm.internal.impl.name.f i(@NotNull u0 functionDescriptor) {
        f0.p(functionDescriptor, "functionDescriptor");
        Map<String, kotlin.reflect.jvm.internal.impl.name.f> j4 = SpecialGenericSignatures.f56640a.j();
        String d4 = kotlin.reflect.jvm.internal.impl.load.kotlin.u.d(functionDescriptor);
        if (d4 == null) {
            return null;
        }
        return j4.get(d4);
    }

    public final boolean j(@NotNull u0 functionDescriptor) {
        f0.p(functionDescriptor, "functionDescriptor");
        return kotlin.reflect.jvm.internal.impl.builtins.h.e0(functionDescriptor) && kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.d(functionDescriptor, false, new a(functionDescriptor), 1, null) != null;
    }

    public final boolean k(@NotNull u0 u0Var) {
        f0.p(u0Var, "<this>");
        return f0.g(u0Var.getName().b(), "removeAt") && f0.g(kotlin.reflect.jvm.internal.impl.load.kotlin.u.d(u0Var), SpecialGenericSignatures.f56640a.h().b());
    }
}
