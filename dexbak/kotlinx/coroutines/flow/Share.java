package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmPlatformAnnotations;
import kotlinx.coroutines.channels.BufferOverflow;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B-\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, m12616d2 = {"Lkotlinx/coroutines/flow/c0;", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/coroutines/flow/h;", "a", "Lkotlinx/coroutines/flow/h;", "upstream", "", "b", "I", "extraBufferCapacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "c", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlin/coroutines/f;", "d", "Lkotlin/coroutines/f;", "context", "<init>", "(Lkotlinx/coroutines/flow/h;ILkotlinx/coroutines/channels/BufferOverflow;Lkotlin/coroutines/f;)V", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.flow.c0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
final class Share<T> {
    @JvmPlatformAnnotations
    @NotNull

    /* renamed from: a */
    public final InterfaceC14958h<T> f42681a;
    @JvmPlatformAnnotations

    /* renamed from: b */
    public final int f42682b;
    @JvmPlatformAnnotations
    @NotNull

    /* renamed from: c */
    public final BufferOverflow f42683c;
    @JvmPlatformAnnotations
    @NotNull

    /* renamed from: d */
    public final CoroutineContext f42684d;

    /* JADX WARN: Multi-variable type inference failed */
    public Share(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, int i, @NotNull BufferOverflow bufferOverflow, @NotNull CoroutineContext coroutineContext) {
        this.f42681a = interfaceC14958h;
        this.f42682b = i;
        this.f42683c = bufferOverflow;
        this.f42684d = coroutineContext;
    }
}
