package kotlinx.coroutines;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;
import kotlin.coroutines.f;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: CoroutineName.kt */
@Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0004\u001a\u00020\u0002H\u00c6\u0003J\u0013\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002H\u00c6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u00d6\u0003R\u0017\u0010\u0005\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/p0;", "Lkotlin/coroutines/a;", "", "toString", CampaignEx.JSON_KEY_AD_Q, "name", "r", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "B", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "b", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class p0 extends kotlin.coroutines.a {

    /* renamed from: b  reason: collision with root package name */
    public static final a f60529b = new a(null);
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f60530a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: CoroutineName.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/p0$a;", "Lkotlin/coroutines/f$c;", "Lkotlinx/coroutines/p0;", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a implements f.c<p0> {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }
    }

    public p0(@NotNull String str) {
        super(f60529b);
        this.f60530a = str;
    }

    public static /* synthetic */ p0 t(p0 p0Var, String str, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = p0Var.f60530a;
        }
        return p0Var.r(str);
    }

    @NotNull
    public final String B() {
        return this.f60530a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof p0) && kotlin.jvm.internal.f0.g(this.f60530a, ((p0) obj).f60530a);
        }
        return true;
    }

    public int hashCode() {
        String str = this.f60530a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @NotNull
    public final String q() {
        return this.f60530a;
    }

    @NotNull
    public final p0 r(@NotNull String str) {
        return new p0(str);
    }

    @NotNull
    public String toString() {
        return "CoroutineName(" + this.f60530a + ')';
    }
}
