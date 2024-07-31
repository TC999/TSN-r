package kotlin.time;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: measureTime.kt */
@SinceKotlin(version = "1.3")
@Metadata(m12618bv = {}, m12617d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u001a\u0012\u0006\u0010\b\u001a\u00028\u0000\u0012\u0006\u0010\t\u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0006\u001a\u00020\u0005HÆ\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\b\u001a\u00028\u00002\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\r\u001a\u00020\fHÖ\u0001J\t\u0010\u000f\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÖ\u0003R\u0017\u0010\b\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u001d\u0010\t\u001a\u00020\u00058\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0016\u0010\u0007\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u0019"}, m12616d2 = {"Lkotlin/time/q;", ExifInterface.GPS_DIRECTION_TRUE, "", "a", "()Ljava/lang/Object;", "Lkotlin/time/d;", "b", "()J", DomainCampaignEx.LOOPBACK_VALUE, "duration", "c", "(Ljava/lang/Object;J)Lkotlin/time/q;", "", "toString", "", TTDownloadField.TT_HASHCODE, AdnName.OTHER, "", "equals", "Ljava/lang/Object;", "f", "J", "e", "<init>", "(Ljava/lang/Object;JLkotlin/jvm/internal/u;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
@ExperimentalTime
/* renamed from: kotlin.time.q */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14606q<T> {

    /* renamed from: a */
    private final T f41672a;

    /* renamed from: b */
    private final long f41673b;

    private C14606q(T t, long j) {
        this.f41672a = t;
        this.f41673b = j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: d */
    public static /* synthetic */ C14606q m5973d(C14606q c14606q, Object obj, long j, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = c14606q.f41672a;
        }
        if ((i & 2) != 0) {
            j = c14606q.f41673b;
        }
        return c14606q.m5974c(obj, j);
    }

    /* renamed from: a */
    public final T m5976a() {
        return this.f41672a;
    }

    /* renamed from: b */
    public final long m5975b() {
        return this.f41673b;
    }

    @NotNull
    /* renamed from: c */
    public final C14606q<T> m5974c(T t, long j) {
        return new C14606q<>(t, j);
    }

    /* renamed from: e */
    public final long m5972e() {
        return this.f41673b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof C14606q) {
                C14606q c14606q = (C14606q) obj;
                return C14342f0.m8193g(this.f41672a, c14606q.f41672a) && this.f41673b == c14606q.f41673b;
            }
            return false;
        }
        return true;
    }

    /* renamed from: f */
    public final T m5971f() {
        return this.f41672a;
    }

    public int hashCode() {
        T t = this.f41672a;
        int hashCode = t != null ? t.hashCode() : 0;
        long j = this.f41673b;
        return (hashCode * 31) + ((int) (j ^ (j >>> 32)));
    }

    @NotNull
    public String toString() {
        return "TimedValue(value=" + this.f41672a + ", duration=" + Duration.m6102x0(this.f41673b) + ")";
    }

    public /* synthetic */ C14606q(Object obj, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, j);
    }
}
