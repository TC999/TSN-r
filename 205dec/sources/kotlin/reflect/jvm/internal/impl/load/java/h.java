package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Collection;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClassicBuiltinSpecialProperties.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class h {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final h f56738a = new h();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ClassicBuiltinSpecialProperties.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends Lambda implements d2.l<CallableMemberDescriptor, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f56739a = new a();

        a() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final Boolean invoke(@NotNull CallableMemberDescriptor it) {
            f0.p(it, "it");
            return Boolean.valueOf(h.f56738a.b(it));
        }
    }

    private h() {
    }

    private final boolean c(CallableMemberDescriptor callableMemberDescriptor) {
        boolean H1;
        H1 = kotlin.collections.f0.H1(f.f56733a.c(), kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.e(callableMemberDescriptor));
        if (H1 && callableMemberDescriptor.h().isEmpty()) {
            return true;
        }
        if (kotlin.reflect.jvm.internal.impl.builtins.h.e0(callableMemberDescriptor)) {
            Collection<? extends CallableMemberDescriptor> overriddenDescriptors = callableMemberDescriptor.d();
            f0.o(overriddenDescriptors, "overriddenDescriptors");
            if (!overriddenDescriptors.isEmpty()) {
                for (CallableMemberDescriptor it : overriddenDescriptors) {
                    h hVar = f56738a;
                    f0.o(it, "it");
                    if (hVar.b(it)) {
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

    @Nullable
    public final String a(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        kotlin.reflect.jvm.internal.impl.name.f fVar;
        f0.p(callableMemberDescriptor, "<this>");
        kotlin.reflect.jvm.internal.impl.builtins.h.e0(callableMemberDescriptor);
        CallableMemberDescriptor d4 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.d(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.o(callableMemberDescriptor), false, a.f56739a, 1, null);
        if (d4 == null || (fVar = f.f56733a.a().get(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.i(d4))) == null) {
            return null;
        }
        return fVar.b();
    }

    public final boolean b(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        f0.p(callableMemberDescriptor, "callableMemberDescriptor");
        if (f.f56733a.d().contains(callableMemberDescriptor.getName())) {
            return c(callableMemberDescriptor);
        }
        return false;
    }
}
