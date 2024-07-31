package kotlin.ranges;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;
import kotlin.collections.AbstractC14213q0;
import kotlin.internal.progressionUtil;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p620m1.KMarkers;

/* compiled from: Progressions.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0016\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\rB!\b\u0000\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u0018\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\t\u0010\u0004\u001a\u00020\u0003H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0013\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0096\u0002J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\u0017\u0010\u0011\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0014\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\u0013\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u000e\u001a\u0004\b\u0015\u0010\u0010¨\u0006\u001b"}, m12616d2 = {"Lkotlin/ranges/i;", "", "", "Lkotlin/collections/q0;", "f", "", "isEmpty", "", AdnName.OTHER, "equals", TTDownloadField.TT_HASHCODE, "", "toString", "a", "I", "c", "()I", "first", "b", "d", "last", "e", "step", CampaignEx.JSON_NATIVE_VIDEO_START, "endInclusive", "<init>", "(III)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.ranges.i */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class C14410i implements Iterable<Integer>, KMarkers {
    @NotNull

    /* renamed from: d */
    public static final C14411a f41292d = new C14411a(null);

    /* renamed from: a */
    private final int f41293a;

    /* renamed from: b */
    private final int f41294b;

    /* renamed from: c */
    private final int f41295c;

    /* compiled from: Progressions.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0002¨\u0006\n"}, m12616d2 = {"Lkotlin/ranges/i$a;", "", "", "rangeStart", "rangeEnd", "step", "Lkotlin/ranges/i;", "a", "<init>", "()V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
    /* renamed from: kotlin.ranges.i$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14411a {
        private C14411a() {
        }

        @NotNull
        /* renamed from: a */
        public final C14410i m7600a(int i, int i2, int i3) {
            return new C14410i(i, i2, i3);
        }

        public /* synthetic */ C14411a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public C14410i(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i3 != Integer.MIN_VALUE) {
            this.f41293a = i;
            this.f41294b = progressionUtil.m8529c(i, i2, i3);
            this.f41295c = i3;
            return;
        }
        throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
    }

    /* renamed from: c */
    public final int m7604c() {
        return this.f41293a;
    }

    /* renamed from: d */
    public final int m7603d() {
        return this.f41294b;
    }

    /* renamed from: e */
    public final int m7602e() {
        return this.f41295c;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof C14410i) {
            if (!isEmpty() || !((C14410i) obj).isEmpty()) {
                C14410i c14410i = (C14410i) obj;
                if (this.f41293a != c14410i.f41293a || this.f41294b != c14410i.f41294b || this.f41295c != c14410i.f41295c) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // java.lang.Iterable
    @NotNull
    /* renamed from: f */
    public AbstractC14213q0 iterator() {
        return new C14412j(this.f41293a, this.f41294b, this.f41295c);
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f41293a * 31) + this.f41294b) * 31) + this.f41295c;
    }

    public boolean isEmpty() {
        if (this.f41295c > 0) {
            if (this.f41293a > this.f41294b) {
                return true;
            }
        } else if (this.f41293a < this.f41294b) {
            return true;
        }
        return false;
    }

    @NotNull
    public String toString() {
        StringBuilder sb;
        int i;
        if (this.f41295c > 0) {
            sb = new StringBuilder();
            sb.append(this.f41293a);
            sb.append("..");
            sb.append(this.f41294b);
            sb.append(" step ");
            i = this.f41295c;
        } else {
            sb = new StringBuilder();
            sb.append(this.f41293a);
            sb.append(" downTo ");
            sb.append(this.f41294b);
            sb.append(" step ");
            i = -this.f41295c;
        }
        sb.append(i);
        return sb.toString();
    }
}
