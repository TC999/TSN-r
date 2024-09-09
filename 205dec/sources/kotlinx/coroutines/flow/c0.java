package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlinx.coroutines.channels.BufferOverflow;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Share.kt */
@Metadata(bv = {}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B-\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/flow/c0;", "T", "", "Lkotlinx/coroutines/flow/h;", "a", "Lkotlinx/coroutines/flow/h;", "upstream", "", "b", "I", "extraBufferCapacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "c", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlin/coroutines/f;", "d", "Lkotlin/coroutines/f;", "context", "<init>", "(Lkotlinx/coroutines/flow/h;ILkotlinx/coroutines/channels/BufferOverflow;Lkotlin/coroutines/f;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\7343912.dex */
final class c0<T> {
    @JvmField
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final h<T> f59998a;
    @JvmField

    /* renamed from: b  reason: collision with root package name */
    public final int f59999b;
    @JvmField
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public final BufferOverflow f60000c;
    @JvmField
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public final kotlin.coroutines.f f60001d;

    /* JADX WARN: Multi-variable type inference failed */
    public c0(@NotNull h<? extends T> hVar, int i4, @NotNull BufferOverflow bufferOverflow, @NotNull kotlin.coroutines.f fVar) {
        this.f59998a = hVar;
        this.f59999b = i4;
        this.f60000c = bufferOverflow;
        this.f60001d = fVar;
    }
}
