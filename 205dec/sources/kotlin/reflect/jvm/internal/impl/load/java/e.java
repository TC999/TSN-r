package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: specialBuiltinMembers.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class e extends SpecialGenericSignatures {
    @NotNull

    /* renamed from: n  reason: collision with root package name */
    public static final e f56730n = new e();

    /* compiled from: specialBuiltinMembers.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class a extends Lambda implements d2.l<CallableMemberDescriptor, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f56731a = new a();

        a() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final Boolean invoke(@NotNull CallableMemberDescriptor it) {
            f0.p(it, "it");
            return Boolean.valueOf(e.f56730n.j(it));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: specialBuiltinMembers.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends Lambda implements d2.l<CallableMemberDescriptor, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f56732a = new b();

        b() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final Boolean invoke(@NotNull CallableMemberDescriptor it) {
            f0.p(it, "it");
            return Boolean.valueOf((it instanceof kotlin.reflect.jvm.internal.impl.descriptors.w) && e.f56730n.j(it));
        }
    }

    private e() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean j(CallableMemberDescriptor callableMemberDescriptor) {
        boolean H1;
        H1 = kotlin.collections.f0.H1(SpecialGenericSignatures.f56640a.e(), kotlin.reflect.jvm.internal.impl.load.kotlin.u.d(callableMemberDescriptor));
        return H1;
    }

    @JvmStatic
    @Nullable
    public static final kotlin.reflect.jvm.internal.impl.descriptors.w k(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.w functionDescriptor) {
        f0.p(functionDescriptor, "functionDescriptor");
        e eVar = f56730n;
        kotlin.reflect.jvm.internal.impl.name.f name = functionDescriptor.getName();
        f0.o(name, "functionDescriptor.name");
        if (eVar.l(name)) {
            return (kotlin.reflect.jvm.internal.impl.descriptors.w) kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.d(functionDescriptor, false, a.f56731a, 1, null);
        }
        return null;
    }

    @JvmStatic
    @Nullable
    public static final SpecialGenericSignatures.SpecialSignatureInfo m(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        f0.p(callableMemberDescriptor, "<this>");
        SpecialGenericSignatures.a aVar = SpecialGenericSignatures.f56640a;
        if (aVar.d().contains(callableMemberDescriptor.getName())) {
            CallableMemberDescriptor d4 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.d(callableMemberDescriptor, false, b.f56732a, 1, null);
            String d5 = d4 == null ? null : kotlin.reflect.jvm.internal.impl.load.kotlin.u.d(d4);
            if (d5 == null) {
                return null;
            }
            return aVar.l(d5);
        }
        return null;
    }

    public final boolean l(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar) {
        f0.p(fVar, "<this>");
        return SpecialGenericSignatures.f56640a.d().contains(fVar);
    }
}
