package kotlin.reflect.jvm.internal.impl.util;

import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.reflect.jvm.internal.impl.descriptors.s0;
import kotlin.reflect.jvm.internal.impl.descriptors.w;
import kotlin.reflect.jvm.internal.impl.types.e0;
import kotlin.reflect.jvm.internal.impl.util.f;
import kotlin.reflect.jvm.internal.impl.util.k;
import kotlin.reflect.jvm.internal.impl.util.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: modifierChecks.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class i extends kotlin.reflect.jvm.internal.impl.util.a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final i f58483a = new i();
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final List<d> f58484b;

    /* compiled from: modifierChecks.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class a extends Lambda implements d2.l<w, String> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f58485a = new a();

        a() {
            super(1);
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0029, code lost:
            if ((!kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.a(r4) && r4.t0() == null) == true) goto L4;
         */
        @Override // d2.l
        @org.jetbrains.annotations.Nullable
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.String invoke(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.w r4) {
            /*
                r3 = this;
                java.lang.String r0 = "$this$$receiver"
                kotlin.jvm.internal.f0.p(r4, r0)
                java.util.List r4 = r4.h()
                java.lang.String r0 = "valueParameters"
                kotlin.jvm.internal.f0.o(r4, r0)
                java.lang.Object r4 = kotlin.collections.w.g3(r4)
                kotlin.reflect.jvm.internal.impl.descriptors.d1 r4 = (kotlin.reflect.jvm.internal.impl.descriptors.d1) r4
                r0 = 1
                r1 = 0
                if (r4 != 0) goto L1a
            L18:
                r0 = 0
                goto L2b
            L1a:
                boolean r2 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.a(r4)
                if (r2 != 0) goto L28
                kotlin.reflect.jvm.internal.impl.types.e0 r4 = r4.t0()
                if (r4 != 0) goto L28
                r4 = 1
                goto L29
            L28:
                r4 = 0
            L29:
                if (r4 != r0) goto L18
            L2b:
                kotlin.reflect.jvm.internal.impl.util.i r4 = kotlin.reflect.jvm.internal.impl.util.i.f58483a
                if (r0 != 0) goto L32
                java.lang.String r4 = "last parameter should not have a default value or be a vararg"
                goto L33
            L32:
                r4 = 0
            L33:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.util.i.a.invoke(kotlin.reflect.jvm.internal.impl.descriptors.w):java.lang.String");
        }
    }

    /* compiled from: modifierChecks.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class b extends Lambda implements d2.l<w, String> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f58486a = new b();

        b() {
            super(1);
        }

        private static final boolean b(kotlin.reflect.jvm.internal.impl.descriptors.k kVar) {
            return (kVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) && kotlin.reflect.jvm.internal.impl.builtins.h.a0((kotlin.reflect.jvm.internal.impl.descriptors.d) kVar);
        }

        @Override // d2.l
        @Nullable
        /* renamed from: a */
        public final String invoke(@NotNull w $receiver) {
            boolean z3;
            f0.p($receiver, "$this$$receiver");
            i iVar = i.f58483a;
            kotlin.reflect.jvm.internal.impl.descriptors.k containingDeclaration = $receiver.b();
            f0.o(containingDeclaration, "containingDeclaration");
            boolean z4 = true;
            if (!b(containingDeclaration)) {
                Collection<? extends w> overriddenDescriptors = $receiver.d();
                f0.o(overriddenDescriptors, "overriddenDescriptors");
                if (!overriddenDescriptors.isEmpty()) {
                    for (w wVar : overriddenDescriptors) {
                        kotlin.reflect.jvm.internal.impl.descriptors.k b4 = wVar.b();
                        f0.o(b4, "it.containingDeclaration");
                        if (b(b4)) {
                            z3 = true;
                            break;
                        }
                    }
                }
                z3 = false;
                if (!z3) {
                    z4 = false;
                }
            }
            if (z4) {
                return null;
            }
            return "must override ''equals()'' in Any";
        }
    }

    /* compiled from: modifierChecks.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class c extends Lambda implements d2.l<w, String> {

        /* renamed from: a  reason: collision with root package name */
        public static final c f58487a = new c();

        c() {
            super(1);
        }

        @Override // d2.l
        @Nullable
        /* renamed from: a */
        public final String invoke(@NotNull w $receiver) {
            boolean m4;
            f0.p($receiver, "$this$$receiver");
            s0 M = $receiver.M();
            if (M == null) {
                M = $receiver.Q();
            }
            i iVar = i.f58483a;
            boolean z3 = false;
            if (M != null) {
                e0 returnType = $receiver.getReturnType();
                if (returnType == null) {
                    m4 = false;
                } else {
                    e0 type = M.getType();
                    f0.o(type, "receiver.type");
                    m4 = kotlin.reflect.jvm.internal.impl.types.typeUtil.a.m(returnType, type);
                }
                if (m4) {
                    z3 = true;
                }
            }
            if (z3) {
                return null;
            }
            return "receiver must be a supertype of the return type";
        }
    }

    static {
        List M;
        List<d> M2;
        kotlin.reflect.jvm.internal.impl.name.f fVar = j.f58498j;
        f.b bVar = f.b.f58479b;
        kotlin.reflect.jvm.internal.impl.util.b[] bVarArr = {bVar, new l.a(1)};
        kotlin.reflect.jvm.internal.impl.name.f fVar2 = j.f58499k;
        kotlin.reflect.jvm.internal.impl.util.b[] bVarArr2 = {bVar, new l.a(2)};
        kotlin.reflect.jvm.internal.impl.name.f fVar3 = j.f58490b;
        h hVar = h.f58481a;
        e eVar = e.f58475a;
        kotlin.reflect.jvm.internal.impl.name.f fVar4 = j.f58495g;
        l.d dVar = l.d.f58528b;
        k.a aVar = k.a.f58518d;
        kotlin.reflect.jvm.internal.impl.name.f fVar5 = j.f58497i;
        l.c cVar = l.c.f58527b;
        M = CollectionsKt__CollectionsKt.M(j.f58511w, j.f58512x);
        M2 = CollectionsKt__CollectionsKt.M(new d(fVar, bVarArr, (d2.l) null, 4, (u) null), new d(fVar2, bVarArr2, a.f58485a), new d(fVar3, new kotlin.reflect.jvm.internal.impl.util.b[]{bVar, hVar, new l.a(2), eVar}, (d2.l) null, 4, (u) null), new d(j.f58491c, new kotlin.reflect.jvm.internal.impl.util.b[]{bVar, hVar, new l.a(3), eVar}, (d2.l) null, 4, (u) null), new d(j.f58492d, new kotlin.reflect.jvm.internal.impl.util.b[]{bVar, hVar, new l.b(2), eVar}, (d2.l) null, 4, (u) null), new d(j.f58496h, new kotlin.reflect.jvm.internal.impl.util.b[]{bVar}, (d2.l) null, 4, (u) null), new d(fVar4, new kotlin.reflect.jvm.internal.impl.util.b[]{bVar, dVar, hVar, aVar}, (d2.l) null, 4, (u) null), new d(fVar5, new kotlin.reflect.jvm.internal.impl.util.b[]{bVar, cVar}, (d2.l) null, 4, (u) null), new d(j.f58500l, new kotlin.reflect.jvm.internal.impl.util.b[]{bVar, cVar}, (d2.l) null, 4, (u) null), new d(j.f58501m, new kotlin.reflect.jvm.internal.impl.util.b[]{bVar, cVar, aVar}, (d2.l) null, 4, (u) null), new d(j.H, new kotlin.reflect.jvm.internal.impl.util.b[]{bVar, dVar, hVar}, (d2.l) null, 4, (u) null), new d(j.f58493e, new kotlin.reflect.jvm.internal.impl.util.b[]{f.a.f58478b}, b.f58486a), new d(j.f58494f, new kotlin.reflect.jvm.internal.impl.util.b[]{bVar, k.b.f58520d, dVar, hVar}, (d2.l) null, 4, (u) null), new d(j.Q, new kotlin.reflect.jvm.internal.impl.util.b[]{bVar, dVar, hVar}, (d2.l) null, 4, (u) null), new d(j.P, new kotlin.reflect.jvm.internal.impl.util.b[]{bVar, cVar}, (d2.l) null, 4, (u) null), new d(M, new kotlin.reflect.jvm.internal.impl.util.b[]{bVar}, c.f58487a), new d(j.R, new kotlin.reflect.jvm.internal.impl.util.b[]{bVar, k.c.f58522d, dVar, hVar}, (d2.l) null, 4, (u) null), new d(j.f58503o, new kotlin.reflect.jvm.internal.impl.util.b[]{bVar, cVar}, (d2.l) null, 4, (u) null));
        f58484b = M2;
    }

    private i() {
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.a
    @NotNull
    public List<d> b() {
        return f58484b;
    }
}
