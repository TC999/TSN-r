package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.n0;
import org.jetbrains.annotations.NotNull;

/* compiled from: JavaTypeEnhancementState.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class u {
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public static final b f57088d = new b(null);
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private static final u f57089e = new u(s.b(null, 1, null), a.f57093a);
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final w f57090a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final d2.l<kotlin.reflect.jvm.internal.impl.name.c, ReportLevel> f57091b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f57092c;

    /* compiled from: JavaTypeEnhancementState.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    /* synthetic */ class a extends FunctionReference implements d2.l<kotlin.reflect.jvm.internal.impl.name.c, ReportLevel> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f57093a = new a();

        a() {
            super(1);
        }

        @Override // d2.l
        @NotNull
        /* renamed from: d */
        public final ReportLevel invoke(@NotNull kotlin.reflect.jvm.internal.impl.name.c p02) {
            f0.p(p02, "p0");
            return s.d(p02);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.c
        @NotNull
        public final String getName() {
            return "getDefaultReportLevelForAnnotation";
        }

        @Override // kotlin.jvm.internal.CallableReference
        @NotNull
        public final kotlin.reflect.h getOwner() {
            return n0.h(s.class, "compiler.common.jvm");
        }

        @Override // kotlin.jvm.internal.CallableReference
        @NotNull
        public final String getSignature() {
            return "getDefaultReportLevelForAnnotation(Lorg/jetbrains/kotlin/name/FqName;)Lorg/jetbrains/kotlin/load/java/ReportLevel;";
        }
    }

    /* compiled from: JavaTypeEnhancementState.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.u uVar) {
            this();
        }

        @NotNull
        public final u a() {
            return u.f57089e;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public u(@NotNull w jsr305, @NotNull d2.l<? super kotlin.reflect.jvm.internal.impl.name.c, ? extends ReportLevel> getReportLevelForAnnotation) {
        f0.p(jsr305, "jsr305");
        f0.p(getReportLevelForAnnotation, "getReportLevelForAnnotation");
        this.f57090a = jsr305;
        this.f57091b = getReportLevelForAnnotation;
        this.f57092c = jsr305.d() || getReportLevelForAnnotation.invoke(s.e()) == ReportLevel.IGNORE;
    }

    public final boolean b() {
        return this.f57092c;
    }

    @NotNull
    public final d2.l<kotlin.reflect.jvm.internal.impl.name.c, ReportLevel> c() {
        return this.f57091b;
    }

    @NotNull
    public final w d() {
        return this.f57090a;
    }

    @NotNull
    public String toString() {
        return "JavaTypeEnhancementState(jsr305=" + this.f57090a + ", getReportLevelForAnnotation=" + this.f57091b + ')';
    }
}
