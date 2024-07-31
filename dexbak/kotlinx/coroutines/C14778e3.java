package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Builders.common.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0012\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0014¨\u0006\f"}, m12616d2 = {"Lkotlinx/coroutines/e3;", "Lkotlinx/coroutines/a;", "Lkotlin/f1;", "", "exception", "", "z0", "Lkotlin/coroutines/f;", "parentContext", "active", "<init>", "(Lkotlin/coroutines/f;Z)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.e3 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class C14778e3 extends AbstractCoroutine<Unit> {
    public C14778e3(@NotNull CoroutineContext coroutineContext, boolean z) {
        super(coroutineContext, z);
    }

    @Override // kotlinx.coroutines.C15125l2
    /* renamed from: z0 */
    protected boolean mo4013z0(@NotNull Throwable th) {
        C15137n0.m3969b(getContext(), th);
        return true;
    }
}
