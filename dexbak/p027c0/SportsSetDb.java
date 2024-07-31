package p027c0;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Entity(indices = {@Index(unique = true, value = {"userId", "type"})}, primaryKeys = {"userId", "type"}, tableName = "sports_set")
@Metadata(m12618bv = {}, m12617d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0002HÆ\u0003J'\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0002HÆ\u0001J\t\u0010\n\u001a\u00020\u0002HÖ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\u0006\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0007\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0010\u001a\u0004\b\u0017\u0010\u0012\"\u0004\b\u0018\u0010\u0014¨\u0006\u001b"}, m12616d2 = {"Lc0/d;", "", "", "a", "b", "c", "userId", "type", "getSetting", "d", "toString", "", TTDownloadField.TT_HASHCODE, AdnName.OTHER, "", "equals", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "j", "(Ljava/lang/String;)V", "getType", "i", "f", "h", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: c0.d */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class SportsSetDb {
    @ColumnInfo(name = "userId", typeAffinity = 2)
    @NotNull

    /* renamed from: a */
    private String f1510a;
    @ColumnInfo(name = "type", typeAffinity = 2)
    @NotNull

    /* renamed from: b */
    private String f1511b;
    @ColumnInfo(name = "content", typeAffinity = 2)
    @NotNull

    /* renamed from: c */
    private String f1512c;

    public SportsSetDb(@NotNull String userId, @NotNull String type, @NotNull String getSetting) {
        C14342f0.m8184p(userId, "userId");
        C14342f0.m8184p(type, "type");
        C14342f0.m8184p(getSetting, "getSetting");
        this.f1510a = userId;
        this.f1511b = type;
        this.f1512c = getSetting;
    }

    /* renamed from: e */
    public static /* synthetic */ SportsSetDb m58057e(SportsSetDb sportsSetDb, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sportsSetDb.f1510a;
        }
        if ((i & 2) != 0) {
            str2 = sportsSetDb.f1511b;
        }
        if ((i & 4) != 0) {
            str3 = sportsSetDb.f1512c;
        }
        return sportsSetDb.m58058d(str, str2, str3);
    }

    @NotNull
    /* renamed from: a */
    public final String m58061a() {
        return this.f1510a;
    }

    @NotNull
    /* renamed from: b */
    public final String m58060b() {
        return this.f1511b;
    }

    @NotNull
    /* renamed from: c */
    public final String m58059c() {
        return this.f1512c;
    }

    @NotNull
    /* renamed from: d */
    public final SportsSetDb m58058d(@NotNull String userId, @NotNull String type, @NotNull String getSetting) {
        C14342f0.m8184p(userId, "userId");
        C14342f0.m8184p(type, "type");
        C14342f0.m8184p(getSetting, "getSetting");
        return new SportsSetDb(userId, type, getSetting);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SportsSetDb) {
            SportsSetDb sportsSetDb = (SportsSetDb) obj;
            return C14342f0.m8193g(this.f1510a, sportsSetDb.f1510a) && C14342f0.m8193g(this.f1511b, sportsSetDb.f1511b) && C14342f0.m8193g(this.f1512c, sportsSetDb.f1512c);
        }
        return false;
    }

    @NotNull
    /* renamed from: f */
    public final String m58056f() {
        return this.f1512c;
    }

    @NotNull
    /* renamed from: g */
    public final String m58055g() {
        return this.f1510a;
    }

    @NotNull
    public final String getType() {
        return this.f1511b;
    }

    /* renamed from: h */
    public final void m58054h(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.f1512c = str;
    }

    public int hashCode() {
        return (((this.f1510a.hashCode() * 31) + this.f1511b.hashCode()) * 31) + this.f1512c.hashCode();
    }

    /* renamed from: i */
    public final void m58053i(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.f1511b = str;
    }

    /* renamed from: j */
    public final void m58052j(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.f1510a = str;
    }

    @NotNull
    public String toString() {
        return "SportsSetDb(userId=" + this.f1510a + ", type=" + this.f1511b + ", getSetting=" + this.f1512c + ')';
    }
}
