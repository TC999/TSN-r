package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.umeng.analytics.pro.UMCommonContent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15280l;

/* compiled from: CancellableContinuation.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\b\u0012\u0004\u0012\u00028\u00000\u0002J%\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00028\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H'¢\u0006\u0004\b\u0006\u0010\u0007JH\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00028\u00002\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042#\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bH'¢\u0006\u0004\b\u000f\u0010\u0010J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\tH'J\u0010\u0010\u0001\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0004H'J\b\u0010\u0014\u001a\u00020\rH'J\u0014\u0010\u0016\u001a\u00020\u00152\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\tH&J1\u0010\u0019\u001a\u00020\r2'\u0010\u0018\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\bj\u0002`\u0017H&J\u001b\u0010\u001b\u001a\u00020\r*\u00020\u001a2\u0006\u0010\u0003\u001a\u00028\u0000H'¢\u0006\u0004\b\u001b\u0010\u001cJ\u0014\u0010\u001d\u001a\u00020\r*\u00020\u001a2\u0006\u0010\u0011\u001a\u00020\tH'J<\u0010\u001e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00028\u00002#\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bH'¢\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00158&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u00158&X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010!R\u0014\u0010#\u001a\u00020\u00158&X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010!¨\u0006$"}, m12616d2 = {"Lkotlinx/coroutines/o;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/c;", DomainCampaignEx.LOOPBACK_VALUE, "", "idempotent", "f", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "Lkotlin/f1;", "onCancellation", "N", "(Ljava/lang/Object;Ljava/lang/Object;Ll1/l;)Ljava/lang/Object;", "exception", "p", BidResponsed.KEY_TOKEN, "J", "", "a", "Lkotlinx/coroutines/CompletionHandler;", "handler", "e", "Lkotlinx/coroutines/l0;", "I", "(Lkotlinx/coroutines/l0;Ljava/lang/Object;)V", "r", UMCommonContent.f37777aG, "(Ljava/lang/Object;Ll1/l;)V", "isActive", "()Z", "isCompleted", "isCancelled", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.o */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public interface InterfaceC15146o<T> extends InterfaceC14268c<T> {

    /* compiled from: CancellableContinuation.kt */
    @Metadata(m12618bv = {1, 0, 3}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.o$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15147a {
        /* renamed from: a */
        public static /* synthetic */ boolean m3945a(InterfaceC15146o interfaceC15146o, Throwable th, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    th = null;
                }
                return interfaceC15146o.mo3905a(th);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }

        /* renamed from: b */
        public static /* synthetic */ Object m3944b(InterfaceC15146o interfaceC15146o, Object obj, Object obj2, int i, Object obj3) {
            if (obj3 == null) {
                if ((i & 2) != 0) {
                    obj2 = null;
                }
                return interfaceC15146o.mo3901f(obj, obj2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: tryResume");
        }
    }

    @ExperimentalCoroutinesApi
    /* renamed from: I */
    void mo3916I(@NotNull CoroutineDispatcher coroutineDispatcher, T t);

    @InternalCoroutinesApi
    /* renamed from: J */
    void mo3915J();

    @InternalCoroutinesApi
    @Nullable
    /* renamed from: N */
    Object mo3911N(T t, @Nullable Object obj, @Nullable InterfaceC15280l<? super Throwable, Unit> interfaceC15280l);

    @InternalCoroutinesApi
    /* renamed from: T */
    void mo3906T(@NotNull Object obj);

    /* renamed from: a */
    boolean mo3905a(@Nullable Throwable th);

    /* renamed from: e */
    void mo3902e(@NotNull InterfaceC15280l<? super Throwable, Unit> interfaceC15280l);

    @InternalCoroutinesApi
    @Nullable
    /* renamed from: f */
    Object mo3901f(T t, @Nullable Object obj);

    boolean isActive();

    boolean isCancelled();

    boolean isCompleted();

    @InternalCoroutinesApi
    @Nullable
    /* renamed from: p */
    Object mo3892p(@NotNull Throwable th);

    @ExperimentalCoroutinesApi
    /* renamed from: r */
    void mo3890r(@NotNull CoroutineDispatcher coroutineDispatcher, @NotNull Throwable th);

    @ExperimentalCoroutinesApi
    /* renamed from: z */
    void mo3882z(T t, @Nullable InterfaceC15280l<? super Throwable, Unit> interfaceC15280l);
}
