package p023b0;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import io.netty.handler.codec.rtsp.RtspHeaders;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0005\u001a\u00020\u0002HÆ\u0003J'\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0002HÆ\u0001J\t\u0010\u000b\u001a\u00020\nHÖ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0014\u0010\u0013R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013¨\u0006\u0018"}, m12616d2 = {"Lb0/b;", "", "", "a", "b", "c", "count", "distance", RtspHeaders.Values.TIME, "d", "", "toString", "", TTDownloadField.TT_HASHCODE, AdnName.OTHER, "", "equals", "J", "f", "()J", "g", "h", "<init>", "(JJJ)V", "student_xiaomiRelease"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: b0.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class CountDistanceTime {

    /* renamed from: a */
    private final long f239a;

    /* renamed from: b */
    private final long f240b;

    /* renamed from: c */
    private final long f241c;

    public CountDistanceTime(long j, long j2, long j3) {
        this.f239a = j;
        this.f240b = j2;
        this.f241c = j3;
    }

    /* renamed from: e */
    public static /* synthetic */ CountDistanceTime m59970e(CountDistanceTime countDistanceTime, long j, long j2, long j3, int i, Object obj) {
        if ((i & 1) != 0) {
            j = countDistanceTime.f239a;
        }
        long j4 = j;
        if ((i & 2) != 0) {
            j2 = countDistanceTime.f240b;
        }
        long j5 = j2;
        if ((i & 4) != 0) {
            j3 = countDistanceTime.f241c;
        }
        return countDistanceTime.m59971d(j4, j5, j3);
    }

    /* renamed from: a */
    public final long m59974a() {
        return this.f239a;
    }

    /* renamed from: b */
    public final long m59973b() {
        return this.f240b;
    }

    /* renamed from: c */
    public final long m59972c() {
        return this.f241c;
    }

    @NotNull
    /* renamed from: d */
    public final CountDistanceTime m59971d(long j, long j2, long j3) {
        return new CountDistanceTime(j, j2, j3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CountDistanceTime) {
            CountDistanceTime countDistanceTime = (CountDistanceTime) obj;
            return this.f239a == countDistanceTime.f239a && this.f240b == countDistanceTime.f240b && this.f241c == countDistanceTime.f241c;
        }
        return false;
    }

    /* renamed from: f */
    public final long m59969f() {
        return this.f239a;
    }

    /* renamed from: g */
    public final long m59968g() {
        return this.f240b;
    }

    /* renamed from: h */
    public final long m59967h() {
        return this.f241c;
    }

    public int hashCode() {
        return (((C0931a.m59975a(this.f239a) * 31) + C0931a.m59975a(this.f240b)) * 31) + C0931a.m59975a(this.f241c);
    }

    @NotNull
    public String toString() {
        return "CountDistanceTime(count=" + this.f239a + ", distance=" + this.f240b + ", time=" + this.f241c + ')';
    }
}
