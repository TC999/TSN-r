package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.o0;
import kotlin.reflect.jvm.internal.impl.descriptors.p0;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.types.m0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: specialBuiltinMembers.kt */
@JvmName(name = "SpecialBuiltinMembers")
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class d0 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: specialBuiltinMembers.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends Lambda implements d2.l<CallableMemberDescriptor, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f56718a = new a();

        a() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final Boolean invoke(@NotNull CallableMemberDescriptor it) {
            f0.p(it, "it");
            return Boolean.valueOf(h.f56738a.b(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.o(it)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: specialBuiltinMembers.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends Lambda implements d2.l<CallableMemberDescriptor, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f56719a = new b();

        b() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final Boolean invoke(@NotNull CallableMemberDescriptor it) {
            f0.p(it, "it");
            return Boolean.valueOf(d.f56716n.j((u0) it));
        }
    }

    /* compiled from: specialBuiltinMembers.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class c extends Lambda implements d2.l<CallableMemberDescriptor, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public static final c f56720a = new c();

        c() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: a */
        public final Boolean invoke(@NotNull CallableMemberDescriptor it) {
            f0.p(it, "it");
            return Boolean.valueOf(kotlin.reflect.jvm.internal.impl.builtins.h.e0(it) && e.m(it) != null);
        }
    }

    public static final boolean a(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        f0.p(callableMemberDescriptor, "<this>");
        return d(callableMemberDescriptor) != null;
    }

    @Nullable
    public static final String b(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        kotlin.reflect.jvm.internal.impl.name.f i4;
        f0.p(callableMemberDescriptor, "callableMemberDescriptor");
        CallableMemberDescriptor c4 = c(callableMemberDescriptor);
        if (c4 == null) {
            return null;
        }
        CallableMemberDescriptor o4 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.o(c4);
        if (o4 instanceof p0) {
            return h.f56738a.a(o4);
        }
        if (!(o4 instanceof u0) || (i4 = d.f56716n.i((u0) o4)) == null) {
            return null;
        }
        return i4.b();
    }

    private static final CallableMemberDescriptor c(CallableMemberDescriptor callableMemberDescriptor) {
        if (kotlin.reflect.jvm.internal.impl.builtins.h.e0(callableMemberDescriptor)) {
            return d(callableMemberDescriptor);
        }
        return null;
    }

    @Nullable
    public static final <T extends CallableMemberDescriptor> T d(@NotNull T t3) {
        f0.p(t3, "<this>");
        if (SpecialGenericSignatures.f56640a.g().contains(t3.getName()) || f.f56733a.d().contains(kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.o(t3).getName())) {
            if (t3 instanceof p0 ? true : t3 instanceof o0) {
                return (T) kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.d(t3, false, a.f56718a, 1, null);
            }
            if (t3 instanceof u0) {
                return (T) kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.d(t3, false, b.f56719a, 1, null);
            }
            return null;
        }
        return null;
    }

    @Nullable
    public static final <T extends CallableMemberDescriptor> T e(@NotNull T t3) {
        f0.p(t3, "<this>");
        T t4 = (T) d(t3);
        if (t4 == null) {
            e eVar = e.f56730n;
            kotlin.reflect.jvm.internal.impl.name.f name = t3.getName();
            f0.o(name, "name");
            if (eVar.l(name)) {
                return (T) kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.d(t3, false, c.f56720a, 1, null);
            }
            return null;
        }
        return t4;
    }

    public static final boolean f(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.a specialCallableDescriptor) {
        f0.p(dVar, "<this>");
        f0.p(specialCallableDescriptor, "specialCallableDescriptor");
        m0 q3 = ((kotlin.reflect.jvm.internal.impl.descriptors.d) specialCallableDescriptor.b()).q();
        f0.o(q3, "specialCallableDescripto\u2026ssDescriptor).defaultType");
        kotlin.reflect.jvm.internal.impl.descriptors.d s3 = kotlin.reflect.jvm.internal.impl.resolve.d.s(dVar);
        while (true) {
            if (s3 == null) {
                return false;
            }
            if (!(s3 instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.c)) {
                if (kotlin.reflect.jvm.internal.impl.types.checker.u.b(s3.q(), q3) != null) {
                    return !kotlin.reflect.jvm.internal.impl.builtins.h.e0(s3);
                }
            }
            s3 = kotlin.reflect.jvm.internal.impl.resolve.d.s(s3);
        }
    }

    public static final boolean g(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        f0.p(callableMemberDescriptor, "<this>");
        return kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.o(callableMemberDescriptor).b() instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.c;
    }

    public static final boolean h(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        f0.p(callableMemberDescriptor, "<this>");
        return g(callableMemberDescriptor) || kotlin.reflect.jvm.internal.impl.builtins.h.e0(callableMemberDescriptor);
    }
}
