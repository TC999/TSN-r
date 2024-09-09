package kotlin.coroutines;

import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import d2.l;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.f;
import kotlin.coroutines.f.b;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: CoroutineContextImpl.kt */
@SinceKotlin(version = "1.3")
@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00028\u00002\b\u0012\u0004\u0012\u00028\u00010\u0004B:\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012#\u0010\u0012\u001a\u001f\u0012\u0013\u0012\u00110\u0001\u00a2\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0005\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0006\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\n\u001a\u00020\t2\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0000\u00a2\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\f\u00a8\u0006\u0015"}, d2 = {"Lkotlin/coroutines/b;", "Lkotlin/coroutines/f$b;", "B", "E", "Lkotlin/coroutines/f$c;", "element", "b", "(Lkotlin/coroutines/f$b;)Lkotlin/coroutines/f$b;", DomainCampaignEx.LOOPBACK_KEY, "", "a", "(Lkotlin/coroutines/f$c;)Z", "Lkotlin/coroutines/f$c;", "topmostKey", "baseKey", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "safeCast", "<init>", "(Lkotlin/coroutines/f$c;Ld2/l;)V", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0})
@ExperimentalStdlibApi
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class b<B extends f.b, E extends B> implements f.c<E> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final l<f.b, E> f55501a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final f.c<?> f55502b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [d2.l<kotlin.coroutines.f$b, E extends B>, java.lang.Object, d2.l<? super kotlin.coroutines.f$b, ? extends E extends B>] */
    public b(@NotNull f.c<B> baseKey, @NotNull l<? super f.b, ? extends E> safeCast) {
        f0.p(baseKey, "baseKey");
        f0.p(safeCast, "safeCast");
        this.f55501a = safeCast;
        this.f55502b = baseKey instanceof b ? (f.c<B>) ((b) baseKey).f55502b : baseKey;
    }

    public final boolean a(@NotNull f.c<?> key) {
        f0.p(key, "key");
        return key == this || this.f55502b == key;
    }

    /* JADX WARN: Incorrect return type in method signature: (Lkotlin/coroutines/f$b;)TE; */
    @Nullable
    public final f.b b(@NotNull f.b element) {
        f0.p(element, "element");
        return (f.b) this.f55501a.invoke(element);
    }
}
