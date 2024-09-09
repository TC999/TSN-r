package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Zip.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\u0010\u0000\u001a\f\u0012\u0006\u0012\u0004\u0018\u0001H\u0002\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0004\b\u0001\u0010\u0003H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "T", "R", "invoke", "()[Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__ZipKt$combine$5$1"}, k = 3, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class FlowKt__ZipKt$combine$$inlined$unsafeFlow$2$lambda$1<T> extends Lambda implements d2.a<T[]> {
    final /* synthetic */ FlowKt__ZipKt$combine$$inlined$unsafeFlow$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ZipKt$combine$$inlined$unsafeFlow$2$lambda$1(FlowKt__ZipKt$combine$$inlined$unsafeFlow$2 flowKt__ZipKt$combine$$inlined$unsafeFlow$2) {
        super(0);
        this.this$0 = flowKt__ZipKt$combine$$inlined$unsafeFlow$2;
    }

    @Override // d2.a
    @Nullable
    public final T[] invoke() {
        int length = this.this$0.f59952a.length;
        kotlin.jvm.internal.f0.y(0, "T?");
        return (T[]) new Object[length];
    }
}
