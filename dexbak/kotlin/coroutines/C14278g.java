package kotlin.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: CoroutineContextImpl.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a-\u0010\u0004\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0018\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0007¨\u0006\b"}, m12616d2 = {"Lkotlin/coroutines/f$b;", ExifInterface.LONGITUDE_EAST, "Lkotlin/coroutines/f$c;", DomainCampaignEx.LOOPBACK_KEY, "a", "(Lkotlin/coroutines/f$b;Lkotlin/coroutines/f$c;)Lkotlin/coroutines/f$b;", "Lkotlin/coroutines/f;", "b", "kotlin-stdlib"}, m12615k = 2, m12614mv = {1, 5, 1})
/* renamed from: kotlin.coroutines.g */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14278g {
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @Nullable
    /* renamed from: a */
    public static final <E extends CoroutineContext.InterfaceC14275b> E m8657a(@NotNull CoroutineContext.InterfaceC14275b getPolymorphicElement, @NotNull CoroutineContext.InterfaceC14277c<E> key) {
        C14342f0.m8184p(getPolymorphicElement, "$this$getPolymorphicElement");
        C14342f0.m8184p(key, "key");
        if (key instanceof AbstractC14267b) {
            AbstractC14267b abstractC14267b = (AbstractC14267b) key;
            if (abstractC14267b.m8680a(getPolymorphicElement.getKey())) {
                E e = (E) abstractC14267b.m8679b(getPolymorphicElement);
                if (e instanceof CoroutineContext.InterfaceC14275b) {
                    return e;
                }
                return null;
            }
            return null;
        } else if (getPolymorphicElement.getKey() == key) {
            return getPolymorphicElement;
        } else {
            return null;
        }
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalStdlibApi
    @NotNull
    /* renamed from: b */
    public static final CoroutineContext m8656b(@NotNull CoroutineContext.InterfaceC14275b minusPolymorphicKey, @NotNull CoroutineContext.InterfaceC14277c<?> key) {
        C14342f0.m8184p(minusPolymorphicKey, "$this$minusPolymorphicKey");
        C14342f0.m8184p(key, "key");
        if (!(key instanceof AbstractC14267b)) {
            return minusPolymorphicKey.getKey() == key ? EmptyCoroutineContext.INSTANCE : minusPolymorphicKey;
        }
        AbstractC14267b abstractC14267b = (AbstractC14267b) key;
        return (!abstractC14267b.m8680a(minusPolymorphicKey.getKey()) || abstractC14267b.m8679b(minusPolymorphicKey) == null) ? minusPolymorphicKey : EmptyCoroutineContext.INSTANCE;
    }
}
