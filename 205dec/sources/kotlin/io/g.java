package kotlin.io;

import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: FilePathComponents.kt */
@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\b\u00a2\u0006\u0004\b\"\u0010#J\u0016\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\t\u0010\u0007\u001a\u00020\u0005H\u00c6\u0003J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u00c6\u0003J#\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00052\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u00c6\u0001J\t\u0010\u000e\u001a\u00020\rH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\n\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u001b\u001a\u00020\r8F\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001e\u001a\u00020\u00118F\u00a2\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010!\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lkotlin/io/g;", "", "", "beginIndex", "endIndex", "Ljava/io/File;", "j", "a", "", "b", "root", "segments", "c", "", "toString", "hashCode", "other", "", "equals", "Ljava/io/File;", "e", "()Ljava/io/File;", "Ljava/util/List;", "g", "()Ljava/util/List;", "f", "()Ljava/lang/String;", "rootName", "i", "()Z", "isRooted", "h", "()I", "size", "<init>", "(Ljava/io/File;Ljava/util/List;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class g {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final File f55553a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final List<File> f55554b;

    /* JADX WARN: Multi-variable type inference failed */
    public g(@NotNull File root, @NotNull List<? extends File> segments) {
        f0.p(root, "root");
        f0.p(segments, "segments");
        this.f55553a = root;
        this.f55554b = segments;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ g d(g gVar, File file, List list, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            file = gVar.f55553a;
        }
        if ((i4 & 2) != 0) {
            list = gVar.f55554b;
        }
        return gVar.c(file, list);
    }

    @NotNull
    public final File a() {
        return this.f55553a;
    }

    @NotNull
    public final List<File> b() {
        return this.f55554b;
    }

    @NotNull
    public final g c(@NotNull File root, @NotNull List<? extends File> segments) {
        f0.p(root, "root");
        f0.p(segments, "segments");
        return new g(root, segments);
    }

    @NotNull
    public final File e() {
        return this.f55553a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof g) {
            g gVar = (g) obj;
            return f0.g(this.f55553a, gVar.f55553a) && f0.g(this.f55554b, gVar.f55554b);
        }
        return false;
    }

    @NotNull
    public final String f() {
        String path = this.f55553a.getPath();
        f0.o(path, "root.path");
        return path;
    }

    @NotNull
    public final List<File> g() {
        return this.f55554b;
    }

    public final int h() {
        return this.f55554b.size();
    }

    public int hashCode() {
        return (this.f55553a.hashCode() * 31) + this.f55554b.hashCode();
    }

    public final boolean i() {
        String path = this.f55553a.getPath();
        f0.o(path, "root.path");
        return path.length() > 0;
    }

    @NotNull
    public final File j(int i4, int i5) {
        String X2;
        if (i4 >= 0 && i4 <= i5 && i5 <= h()) {
            List<File> subList = this.f55554b.subList(i4, i5);
            String separator = File.separator;
            f0.o(separator, "separator");
            X2 = kotlin.collections.f0.X2(subList, separator, null, null, 0, null, null, 62, null);
            return new File(X2);
        }
        throw new IllegalArgumentException();
    }

    @NotNull
    public String toString() {
        return "FilePathComponents(root=" + this.f55553a + ", segments=" + this.f55554b + ')';
    }
}
