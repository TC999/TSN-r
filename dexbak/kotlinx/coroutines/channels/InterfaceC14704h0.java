package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Annotations;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.selects.InterfaceC15196e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

/* compiled from: Channel.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H¦@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00028\u0000H&¢\u0006\u0004\b\b\u0010\tJ\u0014\u0010\f\u001a\u00020\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH&J-\u0010\u0011\u001a\u00020\u00042#\u0010\u0010\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00040\rH'R\u001a\u0010\u0016\u001a\u00020\u00078&X§\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0019\u001a\u00020\u00078&X§\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0017\u0010\u0013R&\u0010\u001d\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00000\u001a8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, m12616d2 = {"Lkotlinx/coroutines/channels/h0;", ExifInterface.LONGITUDE_EAST, "", "element", "Lkotlin/f1;", "P", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "offer", "(Ljava/lang/Object;)Z", "", "cause", "L", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "handler", "C", "Q", "()Z", "isClosedForSend$annotations", "()V", "isClosedForSend", CampaignEx.JSON_KEY_AD_Q, "isFull$annotations", "isFull", "Lkotlinx/coroutines/selects/e;", "s", "()Lkotlinx/coroutines/selects/e;", "onSend", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.channels.h0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface InterfaceC14704h0<E> {

    /* compiled from: Channel.kt */
    @Metadata(m12618bv = {1, 0, 3}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.channels.h0$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C14705a {
        /* renamed from: a */
        public static /* synthetic */ boolean m5442a(InterfaceC14704h0 interfaceC14704h0, Throwable th, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    th = null;
                }
                return interfaceC14704h0.mo5178L(th);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
        }

        @ExperimentalCoroutinesApi
        /* renamed from: b */
        public static /* synthetic */ void m5441b() {
        }

        @Annotations(level = DeprecationLevel.ERROR, message = "Will be removed in next releases without replacement")
        @ExperimentalCoroutinesApi
        /* renamed from: c */
        public static /* synthetic */ void m5440c() {
        }
    }

    @ExperimentalCoroutinesApi
    /* renamed from: C */
    void mo5200C(@NotNull InterfaceC15280l<? super Throwable, Unit> interfaceC15280l);

    /* renamed from: L */
    boolean mo5178L(@Nullable Throwable th);

    @Nullable
    /* renamed from: P */
    Object mo5177P(E e, @NotNull InterfaceC14268c<? super Unit> interfaceC14268c);

    /* renamed from: Q */
    boolean mo5199Q();

    boolean offer(E e);

    /* renamed from: q */
    boolean mo5187q();

    @NotNull
    /* renamed from: s */
    InterfaceC15196e<E, InterfaceC14704h0<E>> mo5176s();
}
