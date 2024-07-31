package androidx.core.p018os;

import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.umeng.ccg.CcgConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.C14342f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p617l1.InterfaceC15269a;

@Metadata(m12618bv = {}, m12617d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a1\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\b\u0004\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0086\b\u001a1\u0010\u000b\u001a\u00020\b*\u00020\u00002\u0006\u0010\n\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\b\u0004\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0086\b¨\u0006\f"}, m12616d2 = {"Landroid/os/Handler;", "", "delayInMillis", "", BidResponsed.KEY_TOKEN, "Lkotlin/Function0;", "Lkotlin/f1;", CcgConstant.f38549t, "Ljava/lang/Runnable;", "postDelayed", "uptimeMillis", "postAtTime", "core-ktx_release"}, m12615k = 2, m12614mv = {1, 4, 0})
/* renamed from: androidx.core.os.HandlerKt */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class Handler {
    @NotNull
    public static final Runnable postAtTime(@NotNull android.os.Handler postAtTime, long j, @Nullable Object obj, @NotNull InterfaceC15269a<Unit> action) {
        C14342f0.m8183q(postAtTime, "$this$postAtTime");
        C14342f0.m8183q(action, "action");
        HandlerKt$postAtTime$runnable$1 handlerKt$postAtTime$runnable$1 = new HandlerKt$postAtTime$runnable$1(action);
        postAtTime.postAtTime(handlerKt$postAtTime$runnable$1, obj, j);
        return handlerKt$postAtTime$runnable$1;
    }

    public static /* synthetic */ Runnable postAtTime$default(android.os.Handler postAtTime, long j, Object obj, InterfaceC15269a action, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        C14342f0.m8183q(postAtTime, "$this$postAtTime");
        C14342f0.m8183q(action, "action");
        HandlerKt$postAtTime$runnable$1 handlerKt$postAtTime$runnable$1 = new HandlerKt$postAtTime$runnable$1(action);
        postAtTime.postAtTime(handlerKt$postAtTime$runnable$1, obj, j);
        return handlerKt$postAtTime$runnable$1;
    }

    @NotNull
    public static final Runnable postDelayed(@NotNull android.os.Handler postDelayed, long j, @Nullable Object obj, @NotNull InterfaceC15269a<Unit> action) {
        C14342f0.m8183q(postDelayed, "$this$postDelayed");
        C14342f0.m8183q(action, "action");
        HandlerKt$postDelayed$runnable$1 handlerKt$postDelayed$runnable$1 = new HandlerKt$postDelayed$runnable$1(action);
        if (obj == null) {
            postDelayed.postDelayed(handlerKt$postDelayed$runnable$1, j);
        } else {
            HandlerCompat.postDelayed(postDelayed, handlerKt$postDelayed$runnable$1, obj, j);
        }
        return handlerKt$postDelayed$runnable$1;
    }

    public static /* synthetic */ Runnable postDelayed$default(android.os.Handler postDelayed, long j, Object obj, InterfaceC15269a action, int i, Object obj2) {
        if ((i & 2) != 0) {
            obj = null;
        }
        C14342f0.m8183q(postDelayed, "$this$postDelayed");
        C14342f0.m8183q(action, "action");
        HandlerKt$postDelayed$runnable$1 handlerKt$postDelayed$runnable$1 = new HandlerKt$postDelayed$runnable$1(action);
        if (obj == null) {
            postDelayed.postDelayed(handlerKt$postDelayed$runnable$1, j);
        } else {
            HandlerCompat.postDelayed(postDelayed, handlerKt$postDelayed$runnable$1, obj, j);
        }
        return handlerKt$postDelayed$runnable$1;
    }
}
