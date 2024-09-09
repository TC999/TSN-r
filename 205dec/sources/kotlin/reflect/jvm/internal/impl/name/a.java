package kotlin.reflect.jvm.internal.impl.name;

import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.text.w;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CallableId.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a {
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private static final C1157a f57551e = new C1157a(null);
    @Deprecated
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private static final f f57552f;
    @Deprecated
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private static final c f57553g;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final c f57554a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final c f57555b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final f f57556c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final c f57557d;

    /* compiled from: CallableId.kt */
    /* renamed from: kotlin.reflect.jvm.internal.impl.name.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    private static final class C1157a {
        private C1157a() {
        }

        public /* synthetic */ C1157a(u uVar) {
            this();
        }
    }

    static {
        f fVar = h.f57588l;
        f57552f = fVar;
        c k4 = c.k(fVar);
        f0.o(k4, "topLevel(LOCAL_NAME)");
        f57553g = k4;
    }

    public a(@NotNull c packageName, @Nullable c cVar, @NotNull f callableName, @Nullable c cVar2) {
        f0.p(packageName, "packageName");
        f0.p(callableName, "callableName");
        this.f57554a = packageName;
        this.f57555b = cVar;
        this.f57556c = callableName;
        this.f57557d = cVar2;
    }

    @NotNull
    public final f a() {
        return this.f57556c;
    }

    @Nullable
    public final c b() {
        return this.f57555b;
    }

    @NotNull
    public final c c() {
        return this.f57554a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return f0.g(this.f57554a, aVar.f57554a) && f0.g(this.f57555b, aVar.f57555b) && f0.g(this.f57556c, aVar.f57556c) && f0.g(this.f57557d, aVar.f57557d);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f57554a.hashCode() * 31;
        c cVar = this.f57555b;
        int hashCode2 = (((hashCode + (cVar == null ? 0 : cVar.hashCode())) * 31) + this.f57556c.hashCode()) * 31;
        c cVar2 = this.f57557d;
        return hashCode2 + (cVar2 != null ? cVar2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        String j22;
        StringBuilder sb = new StringBuilder();
        String b4 = c().b();
        f0.o(b4, "packageName.asString()");
        j22 = w.j2(b4, '.', '/', false, 4, null);
        sb.append(j22);
        sb.append(TTPathConst.sSeparator);
        if (b() != null) {
            sb.append(b());
            sb.append(".");
        }
        sb.append(a());
        String sb2 = sb.toString();
        f0.o(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public /* synthetic */ a(c cVar, c cVar2, f fVar, c cVar3, int i4, u uVar) {
        this(cVar, cVar2, fVar, (i4 & 8) != 0 ? null : cVar3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(@NotNull c packageName, @NotNull f callableName) {
        this(packageName, null, callableName, null, 8, null);
        f0.p(packageName, "packageName");
        f0.p(callableName, "callableName");
    }
}
