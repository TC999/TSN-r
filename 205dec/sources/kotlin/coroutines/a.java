package kotlin.coroutines;

import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import d2.p;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.f;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: CoroutineContextImpl.kt */
@SinceKotlin(version = "1.3")
@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u001e\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lkotlin/coroutines/a;", "Lkotlin/coroutines/f$b;", "Lkotlin/coroutines/f$c;", DomainCampaignEx.LOOPBACK_KEY, "Lkotlin/coroutines/f$c;", "getKey", "()Lkotlin/coroutines/f$c;", "<init>", "(Lkotlin/coroutines/f$c;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class a implements f.b {
    @NotNull
    private final f.c<?> key;

    public a(@NotNull f.c<?> key) {
        f0.p(key, "key");
        this.key = key;
    }

    @Override // kotlin.coroutines.f.b, kotlin.coroutines.f
    public <R> R fold(R r3, @NotNull p<? super R, ? super f.b, ? extends R> pVar) {
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
        return this.key;
    }

    @Override // kotlin.coroutines.f.b, kotlin.coroutines.f
    @NotNull
    public f minusKey(@NotNull f.c<?> cVar) {
        return f.b.a.c(this, cVar);
    }

    @Override // kotlin.coroutines.f
    @NotNull
    public f plus(@NotNull f fVar) {
        return f.b.a.d(this, fVar);
    }
}
