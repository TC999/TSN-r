package c0;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6329136.dex
 */
/* compiled from: SportsSetDb.kt */
@Entity(indices = {@Index(unique = true, value = {"userId", "type"})}, primaryKeys = {"userId", "type"}, tableName = "sports_set")
@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0004\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003J'\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0002H\u00c6\u0001J\t\u0010\n\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\f\u001a\u00020\u000bH\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014\u00a8\u0006\u001b"}, d2 = {"Lc0/d;", "", "", "a", "b", "c", "userId", "type", "getSetting", "d", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "j", "(Ljava/lang/String;)V", "getType", "i", "f", "h", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "student_xiaomiRelease"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class d {
    @ColumnInfo(name = "userId", typeAffinity = 2)
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private String f1509a;
    @ColumnInfo(name = "type", typeAffinity = 2)
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private String f1510b;
    @ColumnInfo(name = "content", typeAffinity = 2)
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private String f1511c;

    public d(@NotNull String userId, @NotNull String type, @NotNull String getSetting) {
        f0.p(userId, "userId");
        f0.p(type, "type");
        f0.p(getSetting, "getSetting");
        this.f1509a = userId;
        this.f1510b = type;
        this.f1511c = getSetting;
    }

    public static /* synthetic */ d e(d dVar, String str, String str2, String str3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = dVar.f1509a;
        }
        if ((i4 & 2) != 0) {
            str2 = dVar.f1510b;
        }
        if ((i4 & 4) != 0) {
            str3 = dVar.f1511c;
        }
        return dVar.d(str, str2, str3);
    }

    @NotNull
    public final String a() {
        return this.f1509a;
    }

    @NotNull
    public final String b() {
        return this.f1510b;
    }

    @NotNull
    public final String c() {
        return this.f1511c;
    }

    @NotNull
    public final d d(@NotNull String userId, @NotNull String type, @NotNull String getSetting) {
        f0.p(userId, "userId");
        f0.p(type, "type");
        f0.p(getSetting, "getSetting");
        return new d(userId, type, getSetting);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            return f0.g(this.f1509a, dVar.f1509a) && f0.g(this.f1510b, dVar.f1510b) && f0.g(this.f1511c, dVar.f1511c);
        }
        return false;
    }

    @NotNull
    public final String f() {
        return this.f1511c;
    }

    @NotNull
    public final String g() {
        return this.f1509a;
    }

    @NotNull
    public final String getType() {
        return this.f1510b;
    }

    public final void h(@NotNull String str) {
        f0.p(str, "<set-?>");
        this.f1511c = str;
    }

    public int hashCode() {
        return (((this.f1509a.hashCode() * 31) + this.f1510b.hashCode()) * 31) + this.f1511c.hashCode();
    }

    public final void i(@NotNull String str) {
        f0.p(str, "<set-?>");
        this.f1510b = str;
    }

    public final void j(@NotNull String str) {
        f0.p(str, "<set-?>");
        this.f1509a = str;
    }

    @NotNull
    public String toString() {
        return "SportsSetDb(userId=" + this.f1509a + ", type=" + this.f1510b + ", getSetting=" + this.f1511c + ')';
    }
}
