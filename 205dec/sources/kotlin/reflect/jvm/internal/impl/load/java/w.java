package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;
import java.util.Map;
import kotlin.collections.z0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Jsr305Settings.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class w {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final ReportLevel f57095a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final ReportLevel f57096b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final Map<kotlin.reflect.jvm.internal.impl.name.c, ReportLevel> f57097c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final kotlin.p f57098d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f57099e;

    /* compiled from: Jsr305Settings.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class a extends Lambda implements d2.a<String[]> {
        a() {
            super(0);
        }

        @Override // d2.a
        @NotNull
        /* renamed from: a */
        public final String[] invoke() {
            List j4;
            List b4;
            w wVar = w.this;
            j4 = kotlin.collections.x.j();
            j4.add(wVar.a().getDescription());
            ReportLevel b5 = wVar.b();
            if (b5 != null) {
                j4.add(f0.C("under-migration:", b5.getDescription()));
            }
            for (Map.Entry<kotlin.reflect.jvm.internal.impl.name.c, ReportLevel> entry : wVar.c().entrySet()) {
                j4.add('@' + entry.getKey() + ':' + entry.getValue().getDescription());
            }
            b4 = kotlin.collections.x.b(j4);
            Object[] array = b4.toArray(new String[0]);
            if (array != null) {
                return (String[]) array;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public w(@NotNull ReportLevel globalLevel, @Nullable ReportLevel reportLevel, @NotNull Map<kotlin.reflect.jvm.internal.impl.name.c, ? extends ReportLevel> userDefinedLevelForSpecificAnnotation) {
        kotlin.p a4;
        f0.p(globalLevel, "globalLevel");
        f0.p(userDefinedLevelForSpecificAnnotation, "userDefinedLevelForSpecificAnnotation");
        this.f57095a = globalLevel;
        this.f57096b = reportLevel;
        this.f57097c = userDefinedLevelForSpecificAnnotation;
        a4 = kotlin.r.a(new a());
        this.f57098d = a4;
        ReportLevel reportLevel2 = ReportLevel.IGNORE;
        this.f57099e = globalLevel == reportLevel2 && reportLevel == reportLevel2 && userDefinedLevelForSpecificAnnotation.isEmpty();
    }

    @NotNull
    public final ReportLevel a() {
        return this.f57095a;
    }

    @Nullable
    public final ReportLevel b() {
        return this.f57096b;
    }

    @NotNull
    public final Map<kotlin.reflect.jvm.internal.impl.name.c, ReportLevel> c() {
        return this.f57097c;
    }

    public final boolean d() {
        return this.f57099e;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof w) {
            w wVar = (w) obj;
            return this.f57095a == wVar.f57095a && this.f57096b == wVar.f57096b && f0.g(this.f57097c, wVar.f57097c);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f57095a.hashCode() * 31;
        ReportLevel reportLevel = this.f57096b;
        return ((hashCode + (reportLevel == null ? 0 : reportLevel.hashCode())) * 31) + this.f57097c.hashCode();
    }

    @NotNull
    public String toString() {
        return "Jsr305Settings(globalLevel=" + this.f57095a + ", migrationLevel=" + this.f57096b + ", userDefinedLevelForSpecificAnnotation=" + this.f57097c + ')';
    }

    public /* synthetic */ w(ReportLevel reportLevel, ReportLevel reportLevel2, Map map, int i4, kotlin.jvm.internal.u uVar) {
        this(reportLevel, (i4 & 2) != 0 ? null : reportLevel2, (i4 & 4) != 0 ? z0.z() : map);
    }
}
