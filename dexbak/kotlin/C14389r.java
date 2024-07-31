package kotlin;

import androidx.exifinterface.media.ExifInterface;
import io.netty.handler.codec.rtsp.RtspHeaders;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyJVM.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a \u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\u001a(\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\u001a*\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u00002\b\u0010\t\u001a\u0004\u0018\u00010\b2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001¨\u0006\u000b"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function0;", "initializer", "Lkotlin/o;", "c", "Lkotlin/LazyThreadSafetyMode;", RtspHeaders.Values.MODE, "b", "", "lock", "a", "kotlin-stdlib"}, m12615k = 5, m12614mv = {1, 5, 1}, m12611xs = "kotlin/LazyKt")
/* renamed from: kotlin.r */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class C14389r {
    @NotNull
    /* renamed from: a */
    public static final <T> InterfaceC14378o<T> m7721a(@Nullable Object obj, @NotNull InterfaceC15269a<? extends T> initializer) {
        C14342f0.m8184p(initializer, "initializer");
        return new C14335j0(initializer, obj);
    }

    @NotNull
    /* renamed from: b */
    public static <T> InterfaceC14378o<T> m7720b(@NotNull LazyThreadSafetyMode mode, @NotNull InterfaceC15269a<? extends T> initializer) {
        C14342f0.m8184p(mode, "mode");
        C14342f0.m8184p(initializer, "initializer");
        int i = C14380p.f41250a[mode.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    return new UnsafeLazyImpl(initializer);
                }
                throw new NoWhenBranchMatchedException();
            }
            return new LazyJVM(initializer);
        }
        return new C14335j0(initializer, null, 2, null);
    }

    @NotNull
    /* renamed from: c */
    public static <T> InterfaceC14378o<T> m7719c(@NotNull InterfaceC15269a<? extends T> initializer) {
        C14342f0.m8184p(initializer, "initializer");
        return new C14335j0(initializer, null, 2, null);
    }
}
