package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Map;
import kotlin.collections.z0;
import kotlin.jvm.internal.f0;
import kotlin.l0;
import kotlin.reflect.jvm.internal.impl.load.java.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: JavaNullabilityAnnotationSettings.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class s {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.name.c f56982a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final kotlin.reflect.jvm.internal.impl.name.c f56983b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final a0<t> f56984c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private static final t f56985d;

    static {
        Map W;
        kotlin.reflect.jvm.internal.impl.name.c cVar = new kotlin.reflect.jvm.internal.impl.name.c("org.jspecify.nullness");
        f56982a = cVar;
        kotlin.reflect.jvm.internal.impl.name.c cVar2 = new kotlin.reflect.jvm.internal.impl.name.c("org.checkerframework.checker.nullness.compatqual");
        f56983b = cVar2;
        kotlin.reflect.jvm.internal.impl.name.c cVar3 = new kotlin.reflect.jvm.internal.impl.name.c("org.jetbrains.annotations");
        t.a aVar = t.f56986d;
        kotlin.reflect.jvm.internal.impl.name.c cVar4 = new kotlin.reflect.jvm.internal.impl.name.c("androidx.annotation.RecentlyNullable");
        ReportLevel reportLevel = ReportLevel.WARN;
        kotlin.m mVar = new kotlin.m(1, 7);
        ReportLevel reportLevel2 = ReportLevel.STRICT;
        W = z0.W(l0.a(cVar3, aVar.a()), l0.a(new kotlin.reflect.jvm.internal.impl.name.c("androidx.annotation"), aVar.a()), l0.a(new kotlin.reflect.jvm.internal.impl.name.c("android.support.annotation"), aVar.a()), l0.a(new kotlin.reflect.jvm.internal.impl.name.c("android.annotation"), aVar.a()), l0.a(new kotlin.reflect.jvm.internal.impl.name.c("com.android.annotations"), aVar.a()), l0.a(new kotlin.reflect.jvm.internal.impl.name.c("org.eclipse.jdt.annotation"), aVar.a()), l0.a(new kotlin.reflect.jvm.internal.impl.name.c("org.checkerframework.checker.nullness.qual"), aVar.a()), l0.a(cVar2, aVar.a()), l0.a(new kotlin.reflect.jvm.internal.impl.name.c("javax.annotation"), aVar.a()), l0.a(new kotlin.reflect.jvm.internal.impl.name.c("edu.umd.cs.findbugs.annotations"), aVar.a()), l0.a(new kotlin.reflect.jvm.internal.impl.name.c("io.reactivex.annotations"), aVar.a()), l0.a(cVar4, new t(reportLevel, null, null, 4, null)), l0.a(new kotlin.reflect.jvm.internal.impl.name.c("androidx.annotation.RecentlyNonNull"), new t(reportLevel, null, null, 4, null)), l0.a(new kotlin.reflect.jvm.internal.impl.name.c("lombok"), aVar.a()), l0.a(cVar, new t(reportLevel, mVar, reportLevel2)), l0.a(new kotlin.reflect.jvm.internal.impl.name.c("io.reactivex.rxjava3.annotations"), new t(reportLevel, new kotlin.m(1, 7), reportLevel2)));
        f56984c = new b0(W);
        f56985d = new t(reportLevel, null, null, 4, null);
    }

    @NotNull
    public static final w a(@NotNull kotlin.m configuredKotlinVersion) {
        ReportLevel c4;
        f0.p(configuredKotlinVersion, "configuredKotlinVersion");
        t tVar = f56985d;
        if (tVar.d() != null && tVar.d().compareTo(configuredKotlinVersion) <= 0) {
            c4 = tVar.b();
        } else {
            c4 = tVar.c();
        }
        ReportLevel reportLevel = c4;
        return new w(reportLevel, c(reportLevel), null, 4, null);
    }

    public static /* synthetic */ w b(kotlin.m mVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            mVar = kotlin.m.f55726g;
        }
        return a(mVar);
    }

    @Nullable
    public static final ReportLevel c(@NotNull ReportLevel globalReportLevel) {
        f0.p(globalReportLevel, "globalReportLevel");
        if (globalReportLevel == ReportLevel.WARN) {
            return null;
        }
        return globalReportLevel;
    }

    @NotNull
    public static final ReportLevel d(@NotNull kotlin.reflect.jvm.internal.impl.name.c annotationFqName) {
        f0.p(annotationFqName, "annotationFqName");
        return g(annotationFqName, a0.f56663a.a(), null, 4, null);
    }

    @NotNull
    public static final kotlin.reflect.jvm.internal.impl.name.c e() {
        return f56982a;
    }

    @NotNull
    public static final ReportLevel f(@NotNull kotlin.reflect.jvm.internal.impl.name.c annotation, @NotNull a0<? extends ReportLevel> configuredReportLevels, @NotNull kotlin.m configuredKotlinVersion) {
        f0.p(annotation, "annotation");
        f0.p(configuredReportLevels, "configuredReportLevels");
        f0.p(configuredKotlinVersion, "configuredKotlinVersion");
        ReportLevel a4 = configuredReportLevels.a(annotation);
        if (a4 == null) {
            t a5 = f56984c.a(annotation);
            if (a5 == null) {
                return ReportLevel.IGNORE;
            }
            if (a5.d() != null && a5.d().compareTo(configuredKotlinVersion) <= 0) {
                return a5.b();
            }
            return a5.c();
        }
        return a4;
    }

    public static /* synthetic */ ReportLevel g(kotlin.reflect.jvm.internal.impl.name.c cVar, a0 a0Var, kotlin.m mVar, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            mVar = kotlin.m.f55726g;
        }
        return f(cVar, a0Var, mVar);
    }
}
