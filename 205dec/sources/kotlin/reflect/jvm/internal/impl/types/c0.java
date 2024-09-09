package kotlin.reflect.jvm.internal.impl.types;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TypeSubstitution.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class c0 extends d1 {
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.a1[] f58269c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final a1[] f58270d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f58271e;

    public /* synthetic */ c0(kotlin.reflect.jvm.internal.impl.descriptors.a1[] a1VarArr, a1[] a1VarArr2, boolean z3, int i4, kotlin.jvm.internal.u uVar) {
        this(a1VarArr, a1VarArr2, (i4 & 4) != 0 ? false : z3);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.d1
    public boolean b() {
        return this.f58271e;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.d1
    @Nullable
    public a1 e(@NotNull e0 key) {
        kotlin.jvm.internal.f0.p(key, "key");
        kotlin.reflect.jvm.internal.impl.descriptors.f b4 = key.H0().b();
        kotlin.reflect.jvm.internal.impl.descriptors.a1 a1Var = b4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.a1 ? (kotlin.reflect.jvm.internal.impl.descriptors.a1) b4 : null;
        if (a1Var == null) {
            return null;
        }
        int f4 = a1Var.f();
        kotlin.reflect.jvm.internal.impl.descriptors.a1[] a1VarArr = this.f58269c;
        if (f4 >= a1VarArr.length || !kotlin.jvm.internal.f0.g(a1VarArr[f4].j(), a1Var.j())) {
            return null;
        }
        return this.f58270d[f4];
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.d1
    public boolean f() {
        return this.f58270d.length == 0;
    }

    @NotNull
    public final a1[] i() {
        return this.f58270d;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.descriptors.a1[] j() {
        return this.f58269c;
    }

    public c0(@NotNull kotlin.reflect.jvm.internal.impl.descriptors.a1[] parameters, @NotNull a1[] arguments, boolean z3) {
        kotlin.jvm.internal.f0.p(parameters, "parameters");
        kotlin.jvm.internal.f0.p(arguments, "arguments");
        this.f58269c = parameters;
        this.f58270d = arguments;
        this.f58271e = z3;
        int length = parameters.length;
        int length2 = arguments.length;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public c0(@org.jetbrains.annotations.NotNull java.util.List<? extends kotlin.reflect.jvm.internal.impl.descriptors.a1> r9, @org.jetbrains.annotations.NotNull java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.a1> r10) {
        /*
            r8 = this;
            java.lang.String r0 = "parameters"
            kotlin.jvm.internal.f0.p(r9, r0)
            java.lang.String r0 = "argumentsList"
            kotlin.jvm.internal.f0.p(r10, r0)
            r0 = 0
            kotlin.reflect.jvm.internal.impl.descriptors.a1[] r1 = new kotlin.reflect.jvm.internal.impl.descriptors.a1[r0]
            java.lang.Object[] r9 = r9.toArray(r1)
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>"
            if (r9 == 0) goto L31
            r3 = r9
            kotlin.reflect.jvm.internal.impl.descriptors.a1[] r3 = (kotlin.reflect.jvm.internal.impl.descriptors.a1[]) r3
            kotlin.reflect.jvm.internal.impl.types.a1[] r9 = new kotlin.reflect.jvm.internal.impl.types.a1[r0]
            java.lang.Object[] r9 = r10.toArray(r9)
            if (r9 == 0) goto L2b
            r4 = r9
            kotlin.reflect.jvm.internal.impl.types.a1[] r4 = (kotlin.reflect.jvm.internal.impl.types.a1[]) r4
            r5 = 0
            r6 = 4
            r7 = 0
            r2 = r8
            r2.<init>(r3, r4, r5, r6, r7)
            return
        L2b:
            java.lang.NullPointerException r9 = new java.lang.NullPointerException
            r9.<init>(r1)
            throw r9
        L31:
            java.lang.NullPointerException r9 = new java.lang.NullPointerException
            r9.<init>(r1)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.c0.<init>(java.util.List, java.util.List):void");
    }
}
