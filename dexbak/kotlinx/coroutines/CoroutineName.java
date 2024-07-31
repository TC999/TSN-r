package kotlinx.coroutines;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;
import kotlin.coroutines.AbstractC14266a;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\u0013\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001J\t\u0010\b\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tHÖ\u0003R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, m12616d2 = {"Lkotlinx/coroutines/p0;", "Lkotlin/coroutines/a;", "", "toString", "p", "name", CampaignEx.JSON_KEY_AD_Q, "", TTDownloadField.TT_HASHCODE, "", AdnName.OTHER, "", "equals", "a", "Ljava/lang/String;", "s", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "b", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.p0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class CoroutineName extends AbstractC14266a {

    /* renamed from: b */
    public static final C15154a f43212b = new C15154a(null);
    @NotNull

    /* renamed from: a */
    private final String f43213a;

    /* compiled from: CoroutineName.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, m12616d2 = {"Lkotlinx/coroutines/p0$a;", "Lkotlin/coroutines/f$c;", "Lkotlinx/coroutines/p0;", "<init>", "()V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.p0$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15154a implements CoroutineContext.InterfaceC14277c<CoroutineName> {
        private C15154a() {
        }

        public /* synthetic */ C15154a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public CoroutineName(@NotNull String str) {
        super(f43212b);
        this.f43213a = str;
    }

    /* renamed from: r */
    public static /* synthetic */ CoroutineName m3879r(CoroutineName coroutineName, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = coroutineName.f43213a;
        }
        return coroutineName.m3880q(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof CoroutineName) && C14342f0.m8193g(this.f43213a, ((CoroutineName) obj).f43213a);
        }
        return true;
    }

    public int hashCode() {
        String str = this.f43213a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @NotNull
    /* renamed from: p */
    public final String m3881p() {
        return this.f43213a;
    }

    @NotNull
    /* renamed from: q */
    public final CoroutineName m3880q(@NotNull String str) {
        return new CoroutineName(str);
    }

    @NotNull
    /* renamed from: s */
    public final String m3878s() {
        return this.f43213a;
    }

    @NotNull
    public String toString() {
        return "CoroutineName(" + this.f43213a + ')';
    }
}
