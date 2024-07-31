package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.jvm.internal.boxing;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.internal.C15090p0;
import kotlinx.coroutines.internal.C15092q0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ThreadContextElement.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a-\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0002\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\u0007\u001a\u00020\u0006*\u0006\u0012\u0002\b\u00030\u0001H\u0086Hø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u001b\u0010\n\u001a\u00020\t*\u0006\u0012\u0002\b\u00030\u0001H\u0086Hø\u0001\u0000¢\u0006\u0004\b\n\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Ljava/lang/ThreadLocal;", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlinx/coroutines/i3;", "a", "(Ljava/lang/ThreadLocal;Ljava/lang/Object;)Lkotlinx/coroutines/i3;", "", "e", "(Ljava/lang/ThreadLocal;Lkotlin/coroutines/c;)Ljava/lang/Object;", "Lkotlin/f1;", "c", "kotlinx-coroutines-core"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.j3 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class C15115j3 {
    @NotNull
    /* renamed from: a */
    public static final <T> ThreadContextElement<T> m4095a(@NotNull ThreadLocal<T> threadLocal, T t) {
        return new C15090p0(t, threadLocal);
    }

    /* renamed from: b */
    public static /* synthetic */ ThreadContextElement m4094b(ThreadLocal threadLocal, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = threadLocal.get();
        }
        return m4095a(threadLocal, obj);
    }

    @Nullable
    /* renamed from: c */
    public static final Object m4093c(@NotNull ThreadLocal<?> threadLocal, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c) {
        if (boxing.m8631a(interfaceC14268c.getContext().get(new C15092q0(threadLocal)) != null).booleanValue()) {
            return Unit.f41048a;
        }
        throw new IllegalStateException(("ThreadLocal " + threadLocal + " is missing from context " + interfaceC14268c.getContext()).toString());
    }

    @Nullable
    /* renamed from: d */
    private static final Object m4092d(@NotNull ThreadLocal threadLocal, @NotNull InterfaceC14268c interfaceC14268c) {
        InlineMarker.m8227e(3);
        throw null;
    }

    @Nullable
    /* renamed from: e */
    public static final Object m4091e(@NotNull ThreadLocal<?> threadLocal, @NotNull InterfaceC14268c<? super Boolean> interfaceC14268c) {
        return boxing.m8631a(interfaceC14268c.getContext().get(new C15092q0(threadLocal)) != null);
    }

    @Nullable
    /* renamed from: f */
    private static final Object m4090f(@NotNull ThreadLocal threadLocal, @NotNull InterfaceC14268c interfaceC14268c) {
        InlineMarker.m8227e(3);
        throw null;
    }
}
