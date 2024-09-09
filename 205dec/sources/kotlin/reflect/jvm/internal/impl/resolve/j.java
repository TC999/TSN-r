package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import java.util.LinkedList;
import kotlin.f1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: overridingUtils.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class j {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [H] */
    /* compiled from: overridingUtils.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<H> extends Lambda implements d2.l<H, f1> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.utils.f<H> f57874a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(kotlin.reflect.jvm.internal.impl.utils.f<H> fVar) {
            super(1);
            this.f57874a = fVar;
        }

        public final void a(H it) {
            kotlin.reflect.jvm.internal.impl.utils.f<H> fVar = this.f57874a;
            f0.o(it, "it");
            fVar.add(it);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // d2.l
        public /* bridge */ /* synthetic */ f1 invoke(Object obj) {
            a(obj);
            return f1.f55527a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static final <H> Collection<H> a(@NotNull Collection<? extends H> collection, @NotNull d2.l<? super H, ? extends kotlin.reflect.jvm.internal.impl.descriptors.a> descriptorByHandle) {
        Object m22;
        Object Q4;
        f0.p(collection, "<this>");
        f0.p(descriptorByHandle, "descriptorByHandle");
        if (collection.size() <= 1) {
            return collection;
        }
        LinkedList linkedList = new LinkedList(collection);
        kotlin.reflect.jvm.internal.impl.utils.f a4 = kotlin.reflect.jvm.internal.impl.utils.f.f58554c.a();
        while (!linkedList.isEmpty()) {
            m22 = kotlin.collections.f0.m2(linkedList);
            kotlin.reflect.jvm.internal.impl.utils.f a5 = kotlin.reflect.jvm.internal.impl.utils.f.f58554c.a();
            Collection<? super H> q3 = OverridingUtil.q(m22, linkedList, descriptorByHandle, new a(a5));
            f0.o(q3, "val conflictedHandles = \u2026nflictedHandles.add(it) }");
            if (q3.size() == 1 && a5.isEmpty()) {
                Q4 = kotlin.collections.f0.Q4(q3);
                f0.o(Q4, "overridableGroup.single()");
                a4.add(Q4);
            } else {
                Object obj = (Object) OverridingUtil.M(q3, descriptorByHandle);
                f0.o(obj, "selectMostSpecificMember\u2026roup, descriptorByHandle)");
                kotlin.reflect.jvm.internal.impl.descriptors.a invoke = descriptorByHandle.invoke(obj);
                for (Object it : q3) {
                    f0.o(it, "it");
                    if (!OverridingUtil.C(invoke, descriptorByHandle.invoke(it))) {
                        a5.add(it);
                    }
                }
                if (!a5.isEmpty()) {
                    a4.addAll(a5);
                }
                a4.add(obj);
            }
        }
        return a4;
    }
}
