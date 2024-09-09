package kotlin.internal;

import java.lang.reflect.Method;
import java.util.List;
import java.util.regex.MatchResult;
import kotlin.Metadata;
import kotlin.collections.l;
import kotlin.collections.w;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.f0;
import kotlin.random.Random;
import kotlin.text.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: PlatformImplementations.kt */
@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016\u00a8\u0006\u0013"}, d2 = {"Lkotlin/internal/a;", "", "", "cause", "exception", "Lkotlin/f1;", "a", "", "d", "Ljava/util/regex/MatchResult;", "matchResult", "", "name", "Lkotlin/text/h;", "c", "Lkotlin/random/Random;", "b", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: PlatformImplementations.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c2\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004\u00a8\u0006\n"}, d2 = {"Lkotlin/internal/a$a;", "", "Ljava/lang/reflect/Method;", "b", "Ljava/lang/reflect/Method;", "addSuppressed", "c", "getSuppressed", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
    /* renamed from: kotlin.internal.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class C1099a {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final C1099a f55542a = new C1099a();
        @JvmField
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public static final Method f55543b;
        @JvmField
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        public static final Method f55544c;

        /* JADX WARN: Removed duplicated region for block: B:22:0x0042 A[EDGE_INSN: B:22:0x0042->B:14:0x0042 ?: BREAK  , SYNTHETIC] */
        static {
            /*
                kotlin.internal.a$a r0 = new kotlin.internal.a$a
                r0.<init>()
                kotlin.internal.a.C1099a.f55542a = r0
                java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
                java.lang.reflect.Method[] r1 = r0.getMethods()
                java.lang.String r2 = "throwableMethods"
                kotlin.jvm.internal.f0.o(r1, r2)
                int r2 = r1.length
                r3 = 0
                r4 = 0
            L15:
                r5 = 0
                if (r4 >= r2) goto L41
                r6 = r1[r4]
                int r4 = r4 + 1
                java.lang.String r7 = r6.getName()
                java.lang.String r8 = "addSuppressed"
                boolean r7 = kotlin.jvm.internal.f0.g(r7, r8)
                if (r7 == 0) goto L3d
                java.lang.Class[] r7 = r6.getParameterTypes()
                java.lang.String r8 = "it.parameterTypes"
                kotlin.jvm.internal.f0.o(r7, r8)
                java.lang.Object r7 = kotlin.collections.l.Ws(r7)
                boolean r7 = kotlin.jvm.internal.f0.g(r7, r0)
                if (r7 == 0) goto L3d
                r7 = 1
                goto L3e
            L3d:
                r7 = 0
            L3e:
                if (r7 == 0) goto L15
                goto L42
            L41:
                r6 = r5
            L42:
                kotlin.internal.a.C1099a.f55543b = r6
                int r0 = r1.length
            L45:
                if (r3 >= r0) goto L58
                r2 = r1[r3]
                int r3 = r3 + 1
                java.lang.String r4 = r2.getName()
                java.lang.String r6 = "getSuppressed"
                boolean r4 = kotlin.jvm.internal.f0.g(r4, r6)
                if (r4 == 0) goto L45
                r5 = r2
            L58:
                kotlin.internal.a.C1099a.f55544c = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.internal.a.C1099a.<clinit>():void");
        }

        private C1099a() {
        }
    }

    public void a(@NotNull Throwable cause, @NotNull Throwable exception) {
        f0.p(cause, "cause");
        f0.p(exception, "exception");
        Method method = C1099a.f55543b;
        if (method == null) {
            return;
        }
        method.invoke(cause, exception);
    }

    @NotNull
    public Random b() {
        return new kotlin.random.b();
    }

    @Nullable
    public h c(@NotNull MatchResult matchResult, @NotNull String name) {
        f0.p(matchResult, "matchResult");
        f0.p(name, "name");
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }

    @NotNull
    public List<Throwable> d(@NotNull Throwable exception) {
        f0.p(exception, "exception");
        Method method = C1099a.f55544c;
        Object invoke = method == null ? null : method.invoke(exception, new Object[0]);
        if (invoke == null) {
            return w.F();
        }
        return l.t((Throwable[]) invoke);
    }
}
