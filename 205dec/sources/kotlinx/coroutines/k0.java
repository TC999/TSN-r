package kotlinx.coroutines;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: CoroutineContext.kt */
@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\u001a\b\u0010\u0001\u001a\u00020\u0000H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0003*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0007\u001a6\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0080\b\u00a2\u0006\u0004\b\u000b\u0010\f\"\u0014\u0010\u000f\u001a\u00020\r8\u0000X\u0080T\u00a2\u0006\u0006\n\u0004\b\u0001\u0010\u000e\"\u001a\u0010\u0015\u001a\u00020\u00108\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0014\u0010\u0016\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000e\"\u001a\u0010\u0018\u001a\u0004\u0018\u00010\r*\u00020\u00038@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0017\u00a8\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/l0;", "a", "Lkotlinx/coroutines/q0;", "Lkotlin/coroutines/f;", "context", "d", "T", "", "countOrElement", "Lkotlin/Function0;", "block", "e", "(Lkotlin/coroutines/f;Ljava/lang/Object;Ld2/a;)Ljava/lang/Object;", "", "Ljava/lang/String;", "COROUTINES_SCHEDULER_PROPERTY_NAME", "", "b", "Z", "c", "()Z", "useCoroutinesScheduler", "DEBUG_THREAD_NAME_SEPARATOR", "(Lkotlin/coroutines/f;)Ljava/lang/String;", "coroutineName", "kotlinx-coroutines-core"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class k0 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final String f60459a = "kotlinx.coroutines.scheduler";

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f60460b;

    /* renamed from: c  reason: collision with root package name */
    private static final String f60461c = " @";

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0028, code lost:
        if (r0.equals("on") != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0031, code lost:
        if (r0.equals("") != false) goto L21;
     */
    static {
        /*
            java.lang.String r0 = "kotlinx.coroutines.scheduler"
            java.lang.String r0 = kotlinx.coroutines.internal.l0.d(r0)
            if (r0 != 0) goto L9
            goto L33
        L9:
            int r1 = r0.hashCode()
            if (r1 == 0) goto L2b
            r2 = 3551(0xddf, float:4.976E-42)
            if (r1 == r2) goto L22
            r2 = 109935(0x1ad6f, float:1.54052E-40)
            if (r1 != r2) goto L37
            java.lang.String r1 = "off"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L37
            r0 = 0
            goto L34
        L22:
            java.lang.String r1 = "on"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L37
            goto L33
        L2b:
            java.lang.String r1 = ""
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L37
        L33:
            r0 = 1
        L34:
            kotlinx.coroutines.k0.f60460b = r0
            return
        L37:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "System property 'kotlinx.coroutines.scheduler' has unrecognized value '"
            r1.append(r2)
            r1.append(r0)
            r0 = 39
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.k0.<clinit>():void");
    }

    @NotNull
    public static final l0 a() {
        return f60460b ? kotlinx.coroutines.scheduling.c.f60593h : x.f60761e;
    }

    @Nullable
    public static final String b(@NotNull kotlin.coroutines.f fVar) {
        return null;
    }

    public static final boolean c() {
        return f60460b;
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final kotlin.coroutines.f d(@NotNull q0 q0Var, @NotNull kotlin.coroutines.f fVar) {
        kotlin.coroutines.f plus = q0Var.getCoroutineContext().plus(fVar);
        return (plus == f1.a() || plus.get(kotlin.coroutines.d.f55503f0) != null) ? plus : plus.plus(f1.a());
    }

    public static final <T> T e(@NotNull kotlin.coroutines.f fVar, @Nullable Object obj, @NotNull d2.a<? extends T> aVar) {
        Object c4 = kotlinx.coroutines.internal.o0.c(fVar, obj);
        try {
            return aVar.invoke();
        } finally {
            kotlin.jvm.internal.c0.d(1);
            kotlinx.coroutines.internal.o0.a(fVar, c4);
            kotlin.jvm.internal.c0.c(1);
        }
    }
}
