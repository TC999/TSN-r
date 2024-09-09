package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AbstractClassTypeConstructor.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class b extends g implements y0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull kotlin.reflect.jvm.internal.impl.storage.n nVar) {
        super(nVar);
        if (nVar == null) {
            t(0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static /* synthetic */ void t(int r9) {
        /*
            r0 = 4
            r1 = 3
            r2 = 1
            if (r9 == r2) goto Lc
            if (r9 == r1) goto Lc
            if (r9 == r0) goto Lc
            java.lang.String r3 = "Argument for @NotNull parameter '%s' of %s.%s must not be null"
            goto Le
        Lc:
            java.lang.String r3 = "@NotNull method %s.%s must not return null"
        Le:
            r4 = 2
            if (r9 == r2) goto L17
            if (r9 == r1) goto L17
            if (r9 == r0) goto L17
            r5 = 3
            goto L18
        L17:
            r5 = 2
        L18:
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.String r6 = "kotlin/reflect/jvm/internal/impl/types/AbstractClassTypeConstructor"
            r7 = 0
            if (r9 == r2) goto L2f
            if (r9 == r4) goto L2a
            if (r9 == r1) goto L2f
            if (r9 == r0) goto L2f
            java.lang.String r8 = "storageManager"
            r5[r7] = r8
            goto L31
        L2a:
            java.lang.String r8 = "classifier"
            r5[r7] = r8
            goto L31
        L2f:
            r5[r7] = r6
        L31:
            if (r9 == r2) goto L3f
            if (r9 == r1) goto L3a
            if (r9 == r0) goto L3a
            r5[r2] = r6
            goto L43
        L3a:
            java.lang.String r6 = "getAdditionalNeighboursInSupertypeGraph"
            r5[r2] = r6
            goto L43
        L3f:
            java.lang.String r6 = "getBuiltIns"
            r5[r2] = r6
        L43:
            if (r9 == r2) goto L54
            if (r9 == r4) goto L50
            if (r9 == r1) goto L54
            if (r9 == r0) goto L54
            java.lang.String r6 = "<init>"
            r5[r4] = r6
            goto L54
        L50:
            java.lang.String r6 = "isSameClassifier"
            r5[r4] = r6
        L54:
            java.lang.String r3 = java.lang.String.format(r3, r5)
            if (r9 == r2) goto L64
            if (r9 == r1) goto L64
            if (r9 == r0) goto L64
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            r9.<init>(r3)
            goto L69
        L64:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            r9.<init>(r3)
        L69:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.b.t(int):void");
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.l
    protected boolean f(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.f fVar) {
        if (fVar == null) {
            t(2);
        }
        return (fVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.d) && d(b(), fVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.y0
    @NotNull
    public kotlin.reflect.jvm.internal.impl.builtins.h k() {
        kotlin.reflect.jvm.internal.impl.builtins.h g4 = kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.a.g(b());
        if (g4 == null) {
            t(1);
        }
        return g4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g
    @Nullable
    protected e0 l() {
        if (kotlin.reflect.jvm.internal.impl.builtins.h.s0(b())) {
            return null;
        }
        return k().i();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.g
    @NotNull
    protected Collection<e0> m(boolean z3) {
        kotlin.reflect.jvm.internal.impl.descriptors.k b4 = b().b();
        if (!(b4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.d)) {
            List emptyList = Collections.emptyList();
            if (emptyList == null) {
                t(3);
            }
            return emptyList;
        }
        kotlin.reflect.jvm.internal.impl.utils.e eVar = new kotlin.reflect.jvm.internal.impl.utils.e();
        kotlin.reflect.jvm.internal.impl.descriptors.d dVar = (kotlin.reflect.jvm.internal.impl.descriptors.d) b4;
        eVar.add(dVar.q());
        kotlin.reflect.jvm.internal.impl.descriptors.d l02 = dVar.l0();
        if (z3 && l02 != null) {
            eVar.add(l02.q());
        }
        return eVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.l, kotlin.reflect.jvm.internal.impl.types.y0
    @NotNull
    /* renamed from: u */
    public abstract kotlin.reflect.jvm.internal.impl.descriptors.d b();
}
