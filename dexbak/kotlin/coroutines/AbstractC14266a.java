package kotlin.coroutines;

import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;

/* compiled from: CoroutineContextImpl.kt */
@SinceKotlin(version = "1.3")
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001e\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, m12616d2 = {"Lkotlin/coroutines/a;", "Lkotlin/coroutines/f$b;", "Lkotlin/coroutines/f$c;", DomainCampaignEx.LOOPBACK_KEY, "Lkotlin/coroutines/f$c;", "getKey", "()Lkotlin/coroutines/f$c;", "<init>", "(Lkotlin/coroutines/f$c;)V", "kotlin-stdlib"}, m12615k = 1, m12614mv = {1, 5, 1})
/* renamed from: kotlin.coroutines.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class AbstractC14266a implements CoroutineContext.InterfaceC14275b {
    @NotNull
    private final CoroutineContext.InterfaceC14277c<?> key;

    public AbstractC14266a(@NotNull CoroutineContext.InterfaceC14277c<?> key) {
        C14342f0.m8184p(key, "key");
        this.key = key;
    }

    @Override // kotlin.coroutines.CoroutineContext.InterfaceC14275b, kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, @NotNull InterfaceC15284p<? super R, ? super CoroutineContext.InterfaceC14275b, ? extends R> operation) {
        C14342f0.m8184p(operation, "operation");
        return (R) CoroutineContext.InterfaceC14275b.C14276a.m8661a(this, r, operation);
    }

    @Override // kotlin.coroutines.CoroutineContext.InterfaceC14275b, kotlin.coroutines.CoroutineContext
    @Nullable
    public <E extends CoroutineContext.InterfaceC14275b> E get(@NotNull CoroutineContext.InterfaceC14277c<E> key) {
        C14342f0.m8184p(key, "key");
        return (E) CoroutineContext.InterfaceC14275b.C14276a.m8660b(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext.InterfaceC14275b
    @NotNull
    public CoroutineContext.InterfaceC14277c<?> getKey() {
        return this.key;
    }

    @Override // kotlin.coroutines.CoroutineContext.InterfaceC14275b, kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext minusKey(@NotNull CoroutineContext.InterfaceC14277c<?> key) {
        C14342f0.m8184p(key, "key");
        return CoroutineContext.InterfaceC14275b.C14276a.m8659c(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext plus(@NotNull CoroutineContext context) {
        C14342f0.m8184p(context, "context");
        return CoroutineContext.InterfaceC14275b.C14276a.m8658d(this, context);
    }
}
