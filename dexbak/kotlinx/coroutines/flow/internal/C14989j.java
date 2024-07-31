package kotlinx.coroutines.flow.internal;

import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmPlatformAnnotations;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15284p;

/* compiled from: SafeCollector.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0007\b\u0000\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0003B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rR\u001e\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000f"}, m12616d2 = {"Lkotlinx/coroutines/flow/internal/j;", "Lkotlin/coroutines/f$b;", "Lkotlin/coroutines/f$c;", "a", "Lkotlin/coroutines/f$c;", "getKey", "()Lkotlin/coroutines/f$c;", DomainCampaignEx.LOOPBACK_KEY, "", "b", "Ljava/lang/Throwable;", "e", "<init>", "(Ljava/lang/Throwable;)V", "c", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.flow.internal.j */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C14989j implements CoroutineContext.InterfaceC14275b {

    /* renamed from: c */
    public static final C14990a f42838c = new C14990a(null);
    @NotNull

    /* renamed from: a */
    private final CoroutineContext.InterfaceC14277c<?> f42839a = f42838c;
    @JvmPlatformAnnotations
    @NotNull

    /* renamed from: b */
    public final Throwable f42840b;

    /* compiled from: SafeCollector.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, m12616d2 = {"Lkotlinx/coroutines/flow/internal/j$a;", "Lkotlin/coroutines/f$c;", "Lkotlinx/coroutines/flow/internal/j;", "<init>", "()V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.internal.j$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C14990a implements CoroutineContext.InterfaceC14277c<C14989j> {
        private C14990a() {
        }

        public /* synthetic */ C14990a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public C14989j(@NotNull Throwable th) {
        this.f42840b = th;
    }

    @Override // kotlin.coroutines.CoroutineContext.InterfaceC14275b, kotlin.coroutines.CoroutineContext
    public <R> R fold(R r, @NotNull InterfaceC15284p<? super R, ? super CoroutineContext.InterfaceC14275b, ? extends R> interfaceC15284p) {
        return (R) CoroutineContext.InterfaceC14275b.C14276a.m8661a(this, r, interfaceC15284p);
    }

    @Override // kotlin.coroutines.CoroutineContext.InterfaceC14275b, kotlin.coroutines.CoroutineContext
    @Nullable
    public <E extends CoroutineContext.InterfaceC14275b> E get(@NotNull CoroutineContext.InterfaceC14277c<E> interfaceC14277c) {
        return (E) CoroutineContext.InterfaceC14275b.C14276a.m8660b(this, interfaceC14277c);
    }

    @Override // kotlin.coroutines.CoroutineContext.InterfaceC14275b
    @NotNull
    public CoroutineContext.InterfaceC14277c<?> getKey() {
        return this.f42839a;
    }

    @Override // kotlin.coroutines.CoroutineContext.InterfaceC14275b, kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext minusKey(@NotNull CoroutineContext.InterfaceC14277c<?> interfaceC14277c) {
        return CoroutineContext.InterfaceC14275b.C14276a.m8659c(this, interfaceC14277c);
    }

    @Override // kotlin.coroutines.CoroutineContext
    @NotNull
    public CoroutineContext plus(@NotNull CoroutineContext coroutineContext) {
        return CoroutineContext.InterfaceC14275b.C14276a.m8658d(this, coroutineContext);
    }
}
