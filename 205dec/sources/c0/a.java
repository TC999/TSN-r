package c0;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6329136.dex
 */
/* compiled from: FaceDb.kt */
@Entity(tableName = "face")
@Metadata(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u00a2\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0006\u001a\u00020\u0004H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0004H\u00c6\u0003J1\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u0004H\u00c6\u0001J\t\u0010\r\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u000eH\u00d6\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001c\u00a8\u0006#"}, d2 = {"Lc0/a;", "", "", "a", "", "b", "c", "d", "id", "identify", "type", "facePath", "e", "toString", "", "hashCode", "other", "", "equals", "J", "h", "()J", "k", "(J)V", "Ljava/lang/String;", "i", "()Ljava/lang/String;", "l", "(Ljava/lang/String;)V", "getType", "m", "g", "j", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class a {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id", typeAffinity = 3)

    /* renamed from: a  reason: collision with root package name */
    private long f1469a;
    @ColumnInfo(name = "identify", typeAffinity = 2)
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private String f1470b;
    @ColumnInfo(name = "type", typeAffinity = 2)
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private String f1471c;
    @ColumnInfo(name = "facePath", typeAffinity = 2)
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private String f1472d;

    public a(long j4, @NotNull String identify, @NotNull String type, @NotNull String facePath) {
        f0.p(identify, "identify");
        f0.p(type, "type");
        f0.p(facePath, "facePath");
        this.f1469a = j4;
        this.f1470b = identify;
        this.f1471c = type;
        this.f1472d = facePath;
    }

    public static /* synthetic */ a f(a aVar, long j4, String str, String str2, String str3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            j4 = aVar.f1469a;
        }
        long j5 = j4;
        if ((i4 & 2) != 0) {
            str = aVar.f1470b;
        }
        String str4 = str;
        if ((i4 & 4) != 0) {
            str2 = aVar.f1471c;
        }
        String str5 = str2;
        if ((i4 & 8) != 0) {
            str3 = aVar.f1472d;
        }
        return aVar.e(j5, str4, str5, str3);
    }

    public final long a() {
        return this.f1469a;
    }

    @NotNull
    public final String b() {
        return this.f1470b;
    }

    @NotNull
    public final String c() {
        return this.f1471c;
    }

    @NotNull
    public final String d() {
        return this.f1472d;
    }

    @NotNull
    public final a e(long j4, @NotNull String identify, @NotNull String type, @NotNull String facePath) {
        f0.p(identify, "identify");
        f0.p(type, "type");
        f0.p(facePath, "facePath");
        return new a(j4, identify, type, facePath);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.f1469a == aVar.f1469a && f0.g(this.f1470b, aVar.f1470b) && f0.g(this.f1471c, aVar.f1471c) && f0.g(this.f1472d, aVar.f1472d);
        }
        return false;
    }

    @NotNull
    public final String g() {
        return this.f1472d;
    }

    @NotNull
    public final String getType() {
        return this.f1471c;
    }

    public final long h() {
        return this.f1469a;
    }

    public int hashCode() {
        return (((((b0.a.a(this.f1469a) * 31) + this.f1470b.hashCode()) * 31) + this.f1471c.hashCode()) * 31) + this.f1472d.hashCode();
    }

    @NotNull
    public final String i() {
        return this.f1470b;
    }

    public final void j(@NotNull String str) {
        f0.p(str, "<set-?>");
        this.f1472d = str;
    }

    public final void k(long j4) {
        this.f1469a = j4;
    }

    public final void l(@NotNull String str) {
        f0.p(str, "<set-?>");
        this.f1470b = str;
    }

    public final void m(@NotNull String str) {
        f0.p(str, "<set-?>");
        this.f1471c = str;
    }

    @NotNull
    public String toString() {
        return "FaceDb(id=" + this.f1469a + ", identify=" + this.f1470b + ", type=" + this.f1471c + ", facePath=" + this.f1472d + ')';
    }

    public /* synthetic */ a(long j4, String str, String str2, String str3, int i4, u uVar) {
        this((i4 & 1) != 0 ? 0L : j4, str, str2, str3);
    }
}
