package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.InterfaceC14268c;
import kotlinx.coroutines.internal.Scopes;
import kotlinx.coroutines.internal.ThreadContext;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Builders.common.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0002B\u001d\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0014¨\u0006\r"}, m12616d2 = {"Lkotlinx/coroutines/t3;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/internal/f0;", "", "state", "Lkotlin/f1;", "k1", "Lkotlin/coroutines/f;", "context", "Lkotlin/coroutines/c;", "uCont", "<init>", "(Lkotlin/coroutines/f;Lkotlin/coroutines/c;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.t3 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15228t3<T> extends Scopes<T> {
    public C15228t3(@NotNull CoroutineContext coroutineContext, @NotNull InterfaceC14268c<? super T> interfaceC14268c) {
        super(coroutineContext, interfaceC14268c);
    }

    @Override // kotlinx.coroutines.internal.Scopes, kotlinx.coroutines.AbstractCoroutine
    /* renamed from: k1 */
    protected void mo3590k1(@Nullable Object obj) {
        Object m4406a = C15063i0.m4406a(obj, this.f43040d);
        CoroutineContext context = this.f43040d.getContext();
        Object m4253c = ThreadContext.m4253c(context, null);
        try {
            this.f43040d.resumeWith(m4406a);
            Unit unit = Unit.f41048a;
        } finally {
            ThreadContext.m4255a(context, m4253c);
        }
    }
}
