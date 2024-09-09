package kotlin.reflect.jvm.internal.impl.load.java.components;

import d2.l;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.f1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DescriptorResolverUtils.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DescriptorResolverUtils.java */
    /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.components.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class C1134a extends kotlin.reflect.jvm.internal.impl.resolve.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ p f56676a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Set f56677b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ boolean f56678c;

        /* compiled from: DescriptorResolverUtils.java */
        /* renamed from: kotlin.reflect.jvm.internal.impl.load.java.components.a$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        class C1135a implements l<CallableMemberDescriptor, f1> {
            C1135a() {
            }

            private static /* synthetic */ void a(int i4) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "descriptor", "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1$1", "invoke"));
            }

            @Override // d2.l
            /* renamed from: b */
            public f1 invoke(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
                if (callableMemberDescriptor == null) {
                    a(0);
                }
                C1134a.this.f56676a.a(callableMemberDescriptor);
                return f1.f55527a;
            }
        }

        C1134a(p pVar, Set set, boolean z3) {
            this.f56676a = pVar;
            this.f56677b = set;
            this.f56678c = z3;
        }

        private static /* synthetic */ void f(int i4) {
            Object[] objArr = new Object[3];
            if (i4 == 1) {
                objArr[0] = "fromSuper";
            } else if (i4 == 2) {
                objArr[0] = "fromCurrent";
            } else if (i4 == 3) {
                objArr[0] = "member";
            } else if (i4 != 4) {
                objArr[0] = "fakeOverride";
            } else {
                objArr[0] = "overridden";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils$1";
            if (i4 == 1 || i4 == 2) {
                objArr[2] = "conflict";
            } else if (i4 == 3 || i4 == 4) {
                objArr[2] = "setOverriddenDescriptors";
            } else {
                objArr[2] = "addFakeOverride";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.h
        public void a(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
            if (callableMemberDescriptor == null) {
                f(0);
            }
            OverridingUtil.L(callableMemberDescriptor, new C1135a());
            this.f56677b.add(callableMemberDescriptor);
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.h
        public void d(@NotNull CallableMemberDescriptor callableMemberDescriptor, @NotNull Collection<? extends CallableMemberDescriptor> collection) {
            if (callableMemberDescriptor == null) {
                f(3);
            }
            if (collection == null) {
                f(4);
            }
            if (!this.f56678c || callableMemberDescriptor.i() == CallableMemberDescriptor.Kind.FAKE_OVERRIDE) {
                super.d(callableMemberDescriptor, collection);
            }
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.g
        public void e(@NotNull CallableMemberDescriptor callableMemberDescriptor, @NotNull CallableMemberDescriptor callableMemberDescriptor2) {
            if (callableMemberDescriptor == null) {
                f(1);
            }
            if (callableMemberDescriptor2 == null) {
                f(2);
            }
        }
    }

    private static /* synthetic */ void a(int i4) {
        String str = i4 != 18 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i4 != 18 ? 3 : 2];
        switch (i4) {
            case 1:
            case 7:
            case 13:
                objArr[0] = "membersFromSupertypes";
                break;
            case 2:
            case 8:
            case 14:
                objArr[0] = "membersFromCurrent";
                break;
            case 3:
            case 9:
            case 15:
                objArr[0] = "classDescriptor";
                break;
            case 4:
            case 10:
            case 16:
                objArr[0] = "errorReporter";
                break;
            case 5:
            case 11:
            case 17:
                objArr[0] = "overridingUtil";
                break;
            case 6:
            case 12:
            case 19:
            default:
                objArr[0] = "name";
                break;
            case 18:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
                break;
            case 20:
                objArr[0] = "annotationClass";
                break;
        }
        if (i4 != 18) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/load/java/components/DescriptorResolverUtils";
        } else {
            objArr[1] = "resolveOverrides";
        }
        switch (i4) {
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                objArr[2] = "resolveOverridesForStaticMembers";
                break;
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
                objArr[2] = "resolveOverrides";
                break;
            case 18:
                break;
            case 19:
            case 20:
                objArr[2] = "getAnnotationParameterByName";
                break;
            default:
                objArr[2] = "resolveOverridesForNonStaticMembers";
                break;
        }
        String format = String.format(str, objArr);
        if (i4 == 18) {
            throw new IllegalStateException(format);
        }
    }

    @Nullable
    public static d1 b(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar) {
        if (fVar == null) {
            a(19);
        }
        if (dVar == null) {
            a(20);
        }
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.c> g4 = dVar.g();
        if (g4.size() != 1) {
            return null;
        }
        for (d1 d1Var : g4.iterator().next().h()) {
            if (d1Var.getName().equals(fVar)) {
                return d1Var;
            }
        }
        return null;
    }

    @NotNull
    private static <D extends CallableMemberDescriptor> Collection<D> c(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull Collection<D> collection, @NotNull Collection<D> collection2, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull p pVar, @NotNull OverridingUtil overridingUtil, boolean z3) {
        if (fVar == null) {
            a(12);
        }
        if (collection == null) {
            a(13);
        }
        if (collection2 == null) {
            a(14);
        }
        if (dVar == null) {
            a(15);
        }
        if (pVar == null) {
            a(16);
        }
        if (overridingUtil == null) {
            a(17);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        overridingUtil.w(fVar, collection, collection2, dVar, new C1134a(pVar, linkedHashSet, z3));
        return linkedHashSet;
    }

    @NotNull
    public static <D extends CallableMemberDescriptor> Collection<D> d(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull Collection<D> collection, @NotNull Collection<D> collection2, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull p pVar, @NotNull OverridingUtil overridingUtil) {
        if (fVar == null) {
            a(0);
        }
        if (collection == null) {
            a(1);
        }
        if (collection2 == null) {
            a(2);
        }
        if (dVar == null) {
            a(3);
        }
        if (pVar == null) {
            a(4);
        }
        if (overridingUtil == null) {
            a(5);
        }
        return c(fVar, collection, collection2, dVar, pVar, overridingUtil, false);
    }

    @NotNull
    public static <D extends CallableMemberDescriptor> Collection<D> e(@NotNull kotlin.reflect.jvm.internal.impl.name.f fVar, @NotNull Collection<D> collection, @NotNull Collection<D> collection2, @NotNull kotlin.reflect.jvm.internal.impl.descriptors.d dVar, @NotNull p pVar, @NotNull OverridingUtil overridingUtil) {
        if (fVar == null) {
            a(6);
        }
        if (collection == null) {
            a(7);
        }
        if (collection2 == null) {
            a(8);
        }
        if (dVar == null) {
            a(9);
        }
        if (pVar == null) {
            a(10);
        }
        if (overridingUtil == null) {
            a(11);
        }
        return c(fVar, collection, collection2, dVar, pVar, overridingUtil, true);
    }
}
