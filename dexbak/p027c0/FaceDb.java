package p027c0;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kuaishou.weapon.p205p0.C7304t;
import com.kwad.sdk.api.model.AdnName;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p023b0.C0931a;

@Entity(tableName = "face")
@Metadata(m12618bv = {}, m12617d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0004\u0012\u0006\u0010\u000b\u001a\u00020\u0004¢\u0006\u0004\b!\u0010\"J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0006\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0004HÆ\u0003J1\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u0004HÆ\u0001J\t\u0010\r\u001a\u00020\u0004HÖ\u0001J\t\u0010\u000f\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\n\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001c¨\u0006#"}, m12616d2 = {"Lc0/a;", "", "", "a", "", "b", "c", "d", "id", "identify", "type", "facePath", "e", "toString", "", TTDownloadField.TT_HASHCODE, AdnName.OTHER, "", "equals", "J", "h", "()J", "k", "(J)V", "Ljava/lang/String;", "i", "()Ljava/lang/String;", C7304t.f25048d, "(Ljava/lang/String;)V", "getType", "m", "g", "j", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: c0.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class FaceDb {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id", typeAffinity = 3)

    /* renamed from: a */
    private long f1470a;
    @ColumnInfo(name = "identify", typeAffinity = 2)
    @NotNull

    /* renamed from: b */
    private String f1471b;
    @ColumnInfo(name = "type", typeAffinity = 2)
    @NotNull

    /* renamed from: c */
    private String f1472c;
    @ColumnInfo(name = "facePath", typeAffinity = 2)
    @NotNull

    /* renamed from: d */
    private String f1473d;

    public FaceDb(long j, @NotNull String identify, @NotNull String type, @NotNull String facePath) {
        C14342f0.m8184p(identify, "identify");
        C14342f0.m8184p(type, "type");
        C14342f0.m8184p(facePath, "facePath");
        this.f1470a = j;
        this.f1471b = identify;
        this.f1472c = type;
        this.f1473d = facePath;
    }

    /* renamed from: f */
    public static /* synthetic */ FaceDb m58180f(FaceDb faceDb, long j, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            j = faceDb.f1470a;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = faceDb.f1471b;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            str2 = faceDb.f1472c;
        }
        String str5 = str2;
        if ((i & 8) != 0) {
            str3 = faceDb.f1473d;
        }
        return faceDb.m58181e(j2, str4, str5, str3);
    }

    /* renamed from: a */
    public final long m58185a() {
        return this.f1470a;
    }

    @NotNull
    /* renamed from: b */
    public final String m58184b() {
        return this.f1471b;
    }

    @NotNull
    /* renamed from: c */
    public final String m58183c() {
        return this.f1472c;
    }

    @NotNull
    /* renamed from: d */
    public final String m58182d() {
        return this.f1473d;
    }

    @NotNull
    /* renamed from: e */
    public final FaceDb m58181e(long j, @NotNull String identify, @NotNull String type, @NotNull String facePath) {
        C14342f0.m8184p(identify, "identify");
        C14342f0.m8184p(type, "type");
        C14342f0.m8184p(facePath, "facePath");
        return new FaceDb(j, identify, type, facePath);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FaceDb) {
            FaceDb faceDb = (FaceDb) obj;
            return this.f1470a == faceDb.f1470a && C14342f0.m8193g(this.f1471b, faceDb.f1471b) && C14342f0.m8193g(this.f1472c, faceDb.f1472c) && C14342f0.m8193g(this.f1473d, faceDb.f1473d);
        }
        return false;
    }

    @NotNull
    /* renamed from: g */
    public final String m58179g() {
        return this.f1473d;
    }

    @NotNull
    public final String getType() {
        return this.f1472c;
    }

    /* renamed from: h */
    public final long m58178h() {
        return this.f1470a;
    }

    public int hashCode() {
        return (((((C0931a.m59975a(this.f1470a) * 31) + this.f1471b.hashCode()) * 31) + this.f1472c.hashCode()) * 31) + this.f1473d.hashCode();
    }

    @NotNull
    /* renamed from: i */
    public final String m58177i() {
        return this.f1471b;
    }

    /* renamed from: j */
    public final void m58176j(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.f1473d = str;
    }

    /* renamed from: k */
    public final void m58175k(long j) {
        this.f1470a = j;
    }

    /* renamed from: l */
    public final void m58174l(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.f1471b = str;
    }

    /* renamed from: m */
    public final void m58173m(@NotNull String str) {
        C14342f0.m8184p(str, "<set-?>");
        this.f1472c = str;
    }

    @NotNull
    public String toString() {
        return "FaceDb(id=" + this.f1470a + ", identify=" + this.f1471b + ", type=" + this.f1472c + ", facePath=" + this.f1473d + ')';
    }

    public /* synthetic */ FaceDb(long j, String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, str, str2, str3);
    }
}
