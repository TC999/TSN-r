package kotlinx.coroutines.flow.internal;

import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.Metadata;
import kotlin.coroutines.f;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SafeCollector.kt */
@Metadata(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0007\b\u0000\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0003B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\f\u0010\rR\u001e\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/flow/internal/j;", "Lkotlin/coroutines/f$b;", "Lkotlin/coroutines/f$c;", "a", "Lkotlin/coroutines/f$c;", "getKey", "()Lkotlin/coroutines/f$c;", DomainCampaignEx.LOOPBACK_KEY, "", "b", "Ljava/lang/Throwable;", "e", "<init>", "(Ljava/lang/Throwable;)V", "c", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class j implements f.b {

    /* renamed from: c  reason: collision with root package name */
    public static final a f60155c = new a(null);
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final f.c<?> f60156a = f60155c;
    @JvmField
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final Throwable f60157b;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: SafeCollector.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/flow/internal/j$a;", "Lkotlin/coroutines/f$c;", "Lkotlinx/coroutines/flow/internal/j;", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a implements f.c<j> {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }
    }

    public j(@NotNull Throwable th) {
        this.f60157b = th;
    }

    @Override // kotlin.coroutines.f.b, kotlin.coroutines.f
    public <R> R fold(R r3, @NotNull d2.p<? super R, ? super f.b, ? extends R> pVar) {
        return (R) f.b.a.a(this, r3, pVar);
    }

    @Override // kotlin.coroutines.f.b, kotlin.coroutines.f
    @Nullable
    public <E extends f.b> E get(@NotNull f.c<E> cVar) {
        return (E) f.b.a.b(this, cVar);
    }

    @Override // kotlin.coroutines.f.b
    @NotNull
    public f.c<?> getKey() {
        return this.f60156a;
    }

    @Override // kotlin.coroutines.f.b, kotlin.coroutines.f
    @NotNull
    public kotlin.coroutines.f minusKey(@NotNull f.c<?> cVar) {
        return f.b.a.c(this, cVar);
    }

    @Override // kotlin.coroutines.f
    @NotNull
    public kotlin.coroutines.f plus(@NotNull kotlin.coroutines.f fVar) {
        return f.b.a.d(this, fVar);
    }
}
