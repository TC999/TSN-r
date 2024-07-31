package kotlinx.coroutines.internal;

import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ThreadContext.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0010\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001J\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001J\u0006\u0010\u0006\u001a\u00020\u0003R\u001e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\bR\u0016\u0010\u000b\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\nR\u0017\u0010\u0010\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\u0005\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, m12616d2 = {"Lkotlinx/coroutines/internal/u0;", "", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/f1;", "a", "c", "b", "", "[Ljava/lang/Object;", "", "I", "i", "Lkotlin/coroutines/f;", "Lkotlin/coroutines/f;", "getContext", "()Lkotlin/coroutines/f;", "context", "n", "<init>", "(Lkotlin/coroutines/f;I)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.internal.u0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15103u0 {

    /* renamed from: a */
    private Object[] f43102a;

    /* renamed from: b */
    private int f43103b;
    @NotNull

    /* renamed from: c */
    private final CoroutineContext f43104c;

    public C15103u0(@NotNull CoroutineContext coroutineContext, int i) {
        this.f43104c = coroutineContext;
        this.f43102a = new Object[i];
    }

    /* renamed from: a */
    public final void m4162a(@Nullable Object obj) {
        Object[] objArr = this.f43102a;
        int i = this.f43103b;
        this.f43103b = i + 1;
        objArr[i] = obj;
    }

    /* renamed from: b */
    public final void m4161b() {
        this.f43103b = 0;
    }

    @Nullable
    /* renamed from: c */
    public final Object m4160c() {
        Object[] objArr = this.f43102a;
        int i = this.f43103b;
        this.f43103b = i + 1;
        return objArr[i];
    }

    @NotNull
    public final CoroutineContext getContext() {
        return this.f43104c;
    }
}
