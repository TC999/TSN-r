package kotlin.coroutines.jvm.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\"\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0001\u001a\u0014\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0001\u001a\u0014\u0010\u0007\u001a\u00020\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0001¨\u0006\b"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/c;", "completion", "a", "frame", "Lkotlin/f1;", "b", "c", "kotlin-stdlib"}, m12615k = 2, m12614mv = {1, 5, 1})
/* renamed from: kotlin.coroutines.jvm.internal.e */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class DebugProbes {
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(version = "1.3")
    @NotNull
    /* renamed from: a */
    public static final <T> InterfaceC14268c<T> m8618a(@NotNull InterfaceC14268c<? super T> completion) {
        C14342f0.m8184p(completion, "completion");
        return completion;
    }

    @SinceKotlin(version = "1.3")
    /* renamed from: b */
    public static final void m8617b(@NotNull InterfaceC14268c<?> frame) {
        C14342f0.m8184p(frame, "frame");
    }

    @SinceKotlin(version = "1.3")
    /* renamed from: c */
    public static final void m8616c(@NotNull InterfaceC14268c<?> frame) {
        C14342f0.m8184p(frame, "frame");
    }
}
