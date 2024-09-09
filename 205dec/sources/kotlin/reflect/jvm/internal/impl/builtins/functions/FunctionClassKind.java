package kotlin.reflect.jvm.internal.impl.builtins.functions;

import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.reflect.jvm.internal.impl.builtins.j;
import kotlin.reflect.jvm.internal.impl.name.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum KFunction uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:368)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:333)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:318)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:289)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: FunctionClassKind.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class FunctionClassKind {
    private static final /* synthetic */ FunctionClassKind[] $VALUES;
    @NotNull
    public static final a Companion;
    public static final FunctionClassKind KFunction;
    public static final FunctionClassKind KSuspendFunction;
    @NotNull
    private final String classNamePrefix;
    private final boolean isReflectType;
    private final boolean isSuspendType;
    @NotNull
    private final kotlin.reflect.jvm.internal.impl.name.c packageFqName;
    public static final FunctionClassKind Function = new FunctionClassKind("Function", 0, j.f56084m, "Function", false, false);
    public static final FunctionClassKind SuspendFunction = new FunctionClassKind("SuspendFunction", 1, j.f56076e, "SuspendFunction", true, false);

    /* compiled from: FunctionClassKind.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {

        /* compiled from: FunctionClassKind.kt */
        /* renamed from: kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public static final class C1122a {
            @NotNull

            /* renamed from: a  reason: collision with root package name */
            private final FunctionClassKind f56025a;

            /* renamed from: b  reason: collision with root package name */
            private final int f56026b;

            public C1122a(@NotNull FunctionClassKind kind, int i4) {
                f0.p(kind, "kind");
                this.f56025a = kind;
                this.f56026b = i4;
            }

            @NotNull
            public final FunctionClassKind a() {
                return this.f56025a;
            }

            public final int b() {
                return this.f56026b;
            }

            @NotNull
            public final FunctionClassKind c() {
                return this.f56025a;
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj instanceof C1122a) {
                    C1122a c1122a = (C1122a) obj;
                    return this.f56025a == c1122a.f56025a && this.f56026b == c1122a.f56026b;
                }
                return false;
            }

            public int hashCode() {
                return (this.f56025a.hashCode() * 31) + this.f56026b;
            }

            @NotNull
            public String toString() {
                return "KindWithArity(kind=" + this.f56025a + ", arity=" + this.f56026b + ')';
            }
        }

        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        private final Integer d(String str) {
            if (str.length() == 0) {
                return null;
            }
            int length = str.length();
            int i4 = 0;
            int i5 = 0;
            while (i4 < length) {
                char charAt = str.charAt(i4);
                i4++;
                int i6 = charAt - '0';
                if (!(i6 >= 0 && i6 < 10)) {
                    return null;
                }
                i5 = (i5 * 10) + i6;
            }
            return Integer.valueOf(i5);
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0032 A[SYNTHETIC] */
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind a(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.name.c r9, @org.jetbrains.annotations.NotNull java.lang.String r10) {
            /*
                r8 = this;
                java.lang.String r0 = "packageFqName"
                kotlin.jvm.internal.f0.p(r9, r0)
                java.lang.String r0 = "className"
                kotlin.jvm.internal.f0.p(r10, r0)
                kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind[] r0 = kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind.values()
                int r1 = r0.length
                r2 = 0
                r3 = 0
            L11:
                r4 = 0
                if (r3 >= r1) goto L33
                r5 = r0[r3]
                int r3 = r3 + 1
                kotlin.reflect.jvm.internal.impl.name.c r6 = r5.getPackageFqName()
                boolean r6 = kotlin.jvm.internal.f0.g(r6, r9)
                if (r6 == 0) goto L2f
                java.lang.String r6 = r5.getClassNamePrefix()
                r7 = 2
                boolean r4 = kotlin.text.n.u2(r10, r6, r2, r7, r4)
                if (r4 == 0) goto L2f
                r4 = 1
                goto L30
            L2f:
                r4 = 0
            L30:
                if (r4 == 0) goto L11
                r4 = r5
            L33:
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind.a.a(kotlin.reflect.jvm.internal.impl.name.c, java.lang.String):kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind");
        }

        @JvmStatic
        @Nullable
        public final FunctionClassKind b(@NotNull String className, @NotNull kotlin.reflect.jvm.internal.impl.name.c packageFqName) {
            f0.p(className, "className");
            f0.p(packageFqName, "packageFqName");
            C1122a c4 = c(className, packageFqName);
            if (c4 == null) {
                return null;
            }
            return c4.c();
        }

        @Nullable
        public final C1122a c(@NotNull String className, @NotNull kotlin.reflect.jvm.internal.impl.name.c packageFqName) {
            f0.p(className, "className");
            f0.p(packageFqName, "packageFqName");
            FunctionClassKind a4 = a(packageFqName, className);
            if (a4 == null) {
                return null;
            }
            String substring = className.substring(a4.getClassNamePrefix().length());
            f0.o(substring, "this as java.lang.String).substring(startIndex)");
            Integer d4 = d(substring);
            if (d4 == null) {
                return null;
            }
            return new C1122a(a4, d4.intValue());
        }
    }

    private static final /* synthetic */ FunctionClassKind[] $values() {
        return new FunctionClassKind[]{Function, SuspendFunction, KFunction, KSuspendFunction};
    }

    static {
        kotlin.reflect.jvm.internal.impl.name.c cVar = j.f56081j;
        KFunction = new FunctionClassKind("KFunction", 2, cVar, "KFunction", false, true);
        KSuspendFunction = new FunctionClassKind("KSuspendFunction", 3, cVar, "KSuspendFunction", true, true);
        $VALUES = $values();
        Companion = new a(null);
    }

    private FunctionClassKind(String str, int i4, kotlin.reflect.jvm.internal.impl.name.c cVar, String str2, boolean z3, boolean z4) {
        this.packageFqName = cVar;
        this.classNamePrefix = str2;
        this.isSuspendType = z3;
        this.isReflectType = z4;
    }

    public static FunctionClassKind valueOf(String str) {
        return (FunctionClassKind) Enum.valueOf(FunctionClassKind.class, str);
    }

    public static FunctionClassKind[] values() {
        return (FunctionClassKind[]) $VALUES.clone();
    }

    @NotNull
    public final String getClassNamePrefix() {
        return this.classNamePrefix;
    }

    @NotNull
    public final kotlin.reflect.jvm.internal.impl.name.c getPackageFqName() {
        return this.packageFqName;
    }

    @NotNull
    public final f numberedClassName(int i4) {
        f f4 = f.f(f0.C(this.classNamePrefix, Integer.valueOf(i4)));
        f0.o(f4, "identifier(\"$classNamePrefix$arity\")");
        return f4;
    }
}
