package kotlin.coroutines;

import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.ExperimentalStdlibApi;
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
@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a-\u0010\u0004\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005\u001a\u0018\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0007\u00a8\u0006\b"}, d2 = {"Lkotlin/coroutines/f$b;", "E", "Lkotlin/coroutines/f$c;", DomainCampaignEx.LOOPBACK_KEY, "a", "(Lkotlin/coroutines/f$b;Lkotlin/coroutines/f$c;)Lkotlin/coroutines/f$b;", "Lkotlin/coroutines/f;", "b", "kotlin-stdlib"}, k = 2, mv = {1, 6, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class g {
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @Nullable
    public static final <E extends f.b> E a(@NotNull f.b bVar, @NotNull f.c<E> key) {
        f0.p(bVar, "<this>");
        f0.p(key, "key");
        if (key instanceof b) {
            b bVar2 = (b) key;
            if (bVar2.a(bVar.getKey())) {
                E e4 = (E) bVar2.b(bVar);
                if (e4 instanceof f.b) {
                    return e4;
                }
                return null;
            }
            return null;
        } else if (bVar.getKey() == key) {
            return bVar;
        } else {
            return null;
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @NotNull
    public static final f b(@NotNull f.b bVar, @NotNull f.c<?> key) {
        f0.p(bVar, "<this>");
        f0.p(key, "key");
        if (!(key instanceof b)) {
            return bVar.getKey() == key ? EmptyCoroutineContext.INSTANCE : bVar;
        }
        b bVar2 = (b) key;
        return (!bVar2.a(bVar.getKey()) || bVar2.b(bVar) == null) ? bVar : EmptyCoroutineContext.INSTANCE;
    }
}
