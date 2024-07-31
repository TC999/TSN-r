package kotlin.internal;

import java.lang.reflect.Method;
import java.util.regex.MatchResult;
import kotlin.Metadata;
import kotlin.jvm.JvmPlatformAnnotations;
import kotlin.jvm.internal.C14342f0;
import kotlin.random.C14393b;
import kotlin.random.Random;
import kotlin.text.C14564h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {}, m12617d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u0001:\u0001\u0006B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016¨\u0006\u0013"}, m12616d2 = {"Lkotlin/internal/a;", "", "", "cause", "exception", "Lkotlin/f1;", "a", "", "d", "Ljava/util/regex/MatchResult;", "matchResult", "", "name", "Lkotlin/text/h;", "c", "Lkotlin/random/Random;", "b", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.internal.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class PlatformImplementations {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PlatformImplementations.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004¨\u0006\n"}, m12616d2 = {"Lkotlin/internal/a$a;", "", "Ljava/lang/reflect/Method;", "a", "Ljava/lang/reflect/Method;", "addSuppressed", "b", "getSuppressed", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.internal.a$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14306a {
        @JvmPlatformAnnotations
        @Nullable

        /* renamed from: a */
        public static final Method f41059a;
        @JvmPlatformAnnotations
        @Nullable

        /* renamed from: b */
        public static final Method f41060b;
        @NotNull

        /* renamed from: c */
        public static final C14306a f41061c = new C14306a();

        /* JADX WARN: Removed duplicated region for block: B:13:0x0046 A[LOOP:0: B:3:0x0015->B:13:0x0046, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x004a A[EDGE_INSN: B:23:0x004a->B:15:0x004a ?: BREAK  , SYNTHETIC] */
        static {
            /*
                kotlin.internal.a$a r0 = new kotlin.internal.a$a
                r0.<init>()
                kotlin.internal.PlatformImplementations.C14306a.f41061c = r0
                java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
                java.lang.reflect.Method[] r1 = r0.getMethods()
                java.lang.String r2 = "throwableMethods"
                kotlin.jvm.internal.C14342f0.m8185o(r1, r2)
                int r2 = r1.length
                r3 = 0
                r4 = 0
            L15:
                java.lang.String r5 = "it"
                r6 = 0
                if (r4 >= r2) goto L49
                r7 = r1[r4]
                kotlin.jvm.internal.C14342f0.m8185o(r7, r5)
                java.lang.String r8 = r7.getName()
                java.lang.String r9 = "addSuppressed"
                boolean r8 = kotlin.jvm.internal.C14342f0.m8193g(r8, r9)
                if (r8 == 0) goto L42
                java.lang.Class[] r8 = r7.getParameterTypes()
                java.lang.String r9 = "it.parameterTypes"
                kotlin.jvm.internal.C14342f0.m8185o(r8, r9)
                java.lang.Object r8 = kotlin.collections.C14173m.m11868Ws(r8)
                java.lang.Class r8 = (java.lang.Class) r8
                boolean r8 = kotlin.jvm.internal.C14342f0.m8193g(r8, r0)
                if (r8 == 0) goto L42
                r8 = 1
                goto L43
            L42:
                r8 = 0
            L43:
                if (r8 == 0) goto L46
                goto L4a
            L46:
                int r4 = r4 + 1
                goto L15
            L49:
                r7 = r6
            L4a:
                kotlin.internal.PlatformImplementations.C14306a.f41059a = r7
                int r0 = r1.length
            L4d:
                if (r3 >= r0) goto L65
                r2 = r1[r3]
                kotlin.jvm.internal.C14342f0.m8185o(r2, r5)
                java.lang.String r4 = r2.getName()
                java.lang.String r7 = "getSuppressed"
                boolean r4 = kotlin.jvm.internal.C14342f0.m8193g(r4, r7)
                if (r4 == 0) goto L62
                r6 = r2
                goto L65
            L62:
                int r3 = r3 + 1
                goto L4d
            L65:
                kotlin.internal.PlatformImplementations.C14306a.f41060b = r6
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.internal.PlatformImplementations.C14306a.<clinit>():void");
        }

        private C14306a() {
        }
    }

    /* renamed from: a */
    public void mo8538a(@NotNull Throwable cause, @NotNull Throwable exception) {
        C14342f0.m8184p(cause, "cause");
        C14342f0.m8184p(exception, "exception");
        Method method = C14306a.f41059a;
        if (method != null) {
            method.invoke(cause, exception);
        }
    }

    @NotNull
    /* renamed from: b */
    public Random mo8537b() {
        return new C14393b();
    }

    @Nullable
    /* renamed from: c */
    public C14564h mo8536c(@NotNull MatchResult matchResult, @NotNull String name) {
        C14342f0.m8184p(matchResult, "matchResult");
        C14342f0.m8184p(name, "name");
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0012, code lost:
        r3 = kotlin.collections._ArraysJvm.m11537t((java.lang.Throwable[]) r3);
     */
    @org.jetbrains.annotations.NotNull
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.List<java.lang.Throwable> mo8535d(@org.jetbrains.annotations.NotNull java.lang.Throwable r3) {
        /*
            r2 = this;
            java.lang.String r0 = "exception"
            kotlin.jvm.internal.C14342f0.m8184p(r3, r0)
            java.lang.reflect.Method r0 = kotlin.internal.PlatformImplementations.C14306a.f41060b
            if (r0 == 0) goto L1b
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.Object r3 = r0.invoke(r3, r1)
            if (r3 == 0) goto L1b
            java.lang.Throwable[] r3 = (java.lang.Throwable[]) r3
            java.util.List r3 = kotlin.collections.C14173m.m11823t(r3)
            if (r3 == 0) goto L1b
            goto L1f
        L1b:
            java.util.List r3 = kotlin.collections.C14233v.m9031E()
        L1f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.internal.PlatformImplementations.mo8535d(java.lang.Throwable):java.util.List");
    }
}
