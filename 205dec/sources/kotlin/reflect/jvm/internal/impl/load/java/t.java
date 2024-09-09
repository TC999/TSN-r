package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JavaNullabilityAnnotationsStatus.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class t {
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public static final a f56986d = new a(null);
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private static final t f56987e = new t(ReportLevel.STRICT, null, null, 6, null);
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final ReportLevel f56988a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.m f56989b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final ReportLevel f56990c;

    /* compiled from: JavaNullabilityAnnotationsStatus.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @NotNull
        public final t a() {
            return t.f56987e;
        }
    }

    public t(@NotNull ReportLevel reportLevelBefore, @Nullable kotlin.m mVar, @NotNull ReportLevel reportLevelAfter) {
        f0.p(reportLevelBefore, "reportLevelBefore");
        f0.p(reportLevelAfter, "reportLevelAfter");
        this.f56988a = reportLevelBefore;
        this.f56989b = mVar;
        this.f56990c = reportLevelAfter;
    }

    @NotNull
    public final ReportLevel b() {
        return this.f56990c;
    }

    @NotNull
    public final ReportLevel c() {
        return this.f56988a;
    }

    @Nullable
    public final kotlin.m d() {
        return this.f56989b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof t) {
            t tVar = (t) obj;
            return this.f56988a == tVar.f56988a && f0.g(this.f56989b, tVar.f56989b) && this.f56990c == tVar.f56990c;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f56988a.hashCode() * 31;
        kotlin.m mVar = this.f56989b;
        return ((hashCode + (mVar == null ? 0 : mVar.hashCode())) * 31) + this.f56990c.hashCode();
    }

    @NotNull
    public String toString() {
        return "JavaNullabilityAnnotationsStatus(reportLevelBefore=" + this.f56988a + ", sinceVersion=" + this.f56989b + ", reportLevelAfter=" + this.f56990c + ')';
    }

    public /* synthetic */ t(ReportLevel reportLevel, kotlin.m mVar, ReportLevel reportLevel2, int i4, kotlin.jvm.internal.u uVar) {
        this(reportLevel, (i4 & 2) != 0 ? new kotlin.m(1, 0) : mVar, (i4 & 4) != 0 ? reportLevel : reportLevel2);
    }
}
