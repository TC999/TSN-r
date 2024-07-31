package kotlin.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.CoroutineContext.InterfaceC14275b;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

/* compiled from: CoroutineContextImpl.kt */
@SinceKotlin(version = "1.3")
@Metadata(m12618bv = {}, m12617d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b'\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00028\u00002\b\u0012\u0004\u0012\u00028\u00010\u0004B:\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012#\u0010\u0012\u001a\u001f\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0005\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u000f¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0006\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\n\u001a\u00020\t2\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0000¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\f¨\u0006\u0015"}, m12616d2 = {"Lkotlin/coroutines/b;", "Lkotlin/coroutines/f$b;", "B", ExifInterface.LONGITUDE_EAST, "Lkotlin/coroutines/f$c;", "element", "b", "(Lkotlin/coroutines/f$b;)Lkotlin/coroutines/f$b;", DomainCampaignEx.LOOPBACK_KEY, "", "a", "(Lkotlin/coroutines/f$c;)Z", "Lkotlin/coroutines/f$c;", "topmostKey", "baseKey", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "safeCast", "<init>", "(Lkotlin/coroutines/f$c;Ll1/l;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
@ExperimentalStdlibApi
/* renamed from: kotlin.coroutines.b */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class AbstractC14267b<B extends CoroutineContext.InterfaceC14275b, E extends B> implements CoroutineContext.InterfaceC14277c<E> {

    /* renamed from: a */
    private final CoroutineContext.InterfaceC14277c<?> f41022a;

    /* renamed from: b */
    private final InterfaceC15280l<CoroutineContext.InterfaceC14275b, E> f41023b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [l1.l<kotlin.coroutines.f$b, E extends B>, java.lang.Object, l1.l<? super kotlin.coroutines.f$b, ? extends E extends B>] */
    public AbstractC14267b(@NotNull CoroutineContext.InterfaceC14277c<B> baseKey, @NotNull InterfaceC15280l<? super CoroutineContext.InterfaceC14275b, ? extends E> safeCast) {
        C14342f0.m8184p(baseKey, "baseKey");
        C14342f0.m8184p(safeCast, "safeCast");
        this.f41023b = safeCast;
        this.f41022a = baseKey instanceof AbstractC14267b ? (CoroutineContext.InterfaceC14277c<B>) ((AbstractC14267b) baseKey).f41022a : baseKey;
    }

    /* renamed from: a */
    public final boolean m8680a(@NotNull CoroutineContext.InterfaceC14277c<?> key) {
        C14342f0.m8184p(key, "key");
        return key == this || this.f41022a == key;
    }

    /* JADX WARN: Incorrect return type in method signature: (Lkotlin/coroutines/f$b;)TE; */
    @Nullable
    /* renamed from: b */
    public final CoroutineContext.InterfaceC14275b m8679b(@NotNull CoroutineContext.InterfaceC14275b element) {
        C14342f0.m8184p(element, "element");
        return (CoroutineContext.InterfaceC14275b) this.f41023b.invoke(element);
    }
}
