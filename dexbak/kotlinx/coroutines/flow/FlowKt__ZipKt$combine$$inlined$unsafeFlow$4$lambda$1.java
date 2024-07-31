package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.C14342f0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Zip.kt */
@Metadata(m12618bv = {1, 0, 3}, m12617d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\u0010\u0000\u001a\f\u0012\u0006\u0012\u0004\u0018\u0001H\u0002\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0004\b\u0001\u0010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m12616d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "invoke", "()[Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__ZipKt$combine$6$1"}, m12615k = 3, m12614mv = {1, 4, 0})
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class FlowKt__ZipKt$combine$$inlined$unsafeFlow$4$lambda$1<T> extends Lambda implements InterfaceC15269a<T[]> {
    final /* synthetic */ FlowKt__ZipKt$combine$$inlined$unsafeFlow$4 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ZipKt$combine$$inlined$unsafeFlow$4$lambda$1(FlowKt__ZipKt$combine$$inlined$unsafeFlow$4 flowKt__ZipKt$combine$$inlined$unsafeFlow$4) {
        super(0);
        this.this$0 = flowKt__ZipKt$combine$$inlined$unsafeFlow$4;
    }

    @Override // p617l1.InterfaceC15269a
    @Nullable
    public final T[] invoke() {
        int length = this.this$0.f42630a.length;
        C14342f0.m8175y(0, "T?");
        return (T[]) new Object[length];
    }
}
