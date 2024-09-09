package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Regex.kt */
@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\u001d\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0004H\u00c6\u0001J\t\u0010\t\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u000b\u001a\u00020\nH\u00d6\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0017"}, d2 = {"Lkotlin/text/h;", "", "", "a", "Lkotlin/ranges/k;", "b", "value", "range", "c", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "Lkotlin/ranges/k;", "e", "()Lkotlin/ranges/k;", "<init>", "(Ljava/lang/String;Lkotlin/ranges/k;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class h {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f58949a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final kotlin.ranges.k f58950b;

    public h(@NotNull String value, @NotNull kotlin.ranges.k range) {
        f0.p(value, "value");
        f0.p(range, "range");
        this.f58949a = value;
        this.f58950b = range;
    }

    public static /* synthetic */ h d(h hVar, String str, kotlin.ranges.k kVar, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = hVar.f58949a;
        }
        if ((i4 & 2) != 0) {
            kVar = hVar.f58950b;
        }
        return hVar.c(str, kVar);
    }

    @NotNull
    public final String a() {
        return this.f58949a;
    }

    @NotNull
    public final kotlin.ranges.k b() {
        return this.f58950b;
    }

    @NotNull
    public final h c(@NotNull String value, @NotNull kotlin.ranges.k range) {
        f0.p(value, "value");
        f0.p(range, "range");
        return new h(value, range);
    }

    @NotNull
    public final kotlin.ranges.k e() {
        return this.f58950b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            return f0.g(this.f58949a, hVar.f58949a) && f0.g(this.f58950b, hVar.f58950b);
        }
        return false;
    }

    @NotNull
    public final String f() {
        return this.f58949a;
    }

    public int hashCode() {
        return (this.f58949a.hashCode() * 31) + this.f58950b.hashCode();
    }

    @NotNull
    public String toString() {
        return "MatchGroup(value=" + this.f58949a + ", range=" + this.f58950b + ')';
    }
}
