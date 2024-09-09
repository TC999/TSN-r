package androidx.core.os;

import android.os.Handler;
import d2.a;
import kotlin.Metadata;
import kotlin.f1;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: Handler.kt */
@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a1\u0010\t\u001a\u00020\b*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\b\u0004\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0086\b\u001a1\u0010\u000b\u001a\u00020\b*\u00020\u00002\u0006\u0010\n\u001a\u00020\u00012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\b\u0004\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0086\b\u00a8\u0006\f"}, d2 = {"Landroid/os/Handler;", "", "delayInMillis", "", "token", "Lkotlin/Function0;", "Lkotlin/f1;", "action", "Ljava/lang/Runnable;", "postDelayed", "uptimeMillis", "postAtTime", "core-ktx_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public final class HandlerKt {
    @NotNull
    public static final Runnable postAtTime(@NotNull Handler postAtTime, long j4, @Nullable Object obj, @NotNull a<f1> action) {
        f0.q(postAtTime, "$this$postAtTime");
        f0.q(action, "action");
        HandlerKt$postAtTime$runnable$1 handlerKt$postAtTime$runnable$1 = new HandlerKt$postAtTime$runnable$1(action);
        postAtTime.postAtTime(handlerKt$postAtTime$runnable$1, obj, j4);
        return handlerKt$postAtTime$runnable$1;
    }

    public static /* synthetic */ Runnable postAtTime$default(Handler postAtTime, long j4, Object obj, a action, int i4, Object obj2) {
        if ((i4 & 2) != 0) {
            obj = null;
        }
        f0.q(postAtTime, "$this$postAtTime");
        f0.q(action, "action");
        HandlerKt$postAtTime$runnable$1 handlerKt$postAtTime$runnable$1 = new HandlerKt$postAtTime$runnable$1(action);
        postAtTime.postAtTime(handlerKt$postAtTime$runnable$1, obj, j4);
        return handlerKt$postAtTime$runnable$1;
    }

    @NotNull
    public static final Runnable postDelayed(@NotNull Handler postDelayed, long j4, @Nullable Object obj, @NotNull a<f1> action) {
        f0.q(postDelayed, "$this$postDelayed");
        f0.q(action, "action");
        HandlerKt$postDelayed$runnable$1 handlerKt$postDelayed$runnable$1 = new HandlerKt$postDelayed$runnable$1(action);
        if (obj == null) {
            postDelayed.postDelayed(handlerKt$postDelayed$runnable$1, j4);
        } else {
            HandlerCompat.postDelayed(postDelayed, handlerKt$postDelayed$runnable$1, obj, j4);
        }
        return handlerKt$postDelayed$runnable$1;
    }

    public static /* synthetic */ Runnable postDelayed$default(Handler postDelayed, long j4, Object obj, a action, int i4, Object obj2) {
        if ((i4 & 2) != 0) {
            obj = null;
        }
        f0.q(postDelayed, "$this$postDelayed");
        f0.q(action, "action");
        HandlerKt$postDelayed$runnable$1 handlerKt$postDelayed$runnable$1 = new HandlerKt$postDelayed$runnable$1(action);
        if (obj == null) {
            postDelayed.postDelayed(handlerKt$postDelayed$runnable$1, j4);
        } else {
            HandlerCompat.postDelayed(postDelayed, handlerKt$postDelayed$runnable$1, obj, j4);
        }
        return handlerKt$postDelayed$runnable$1;
    }
}
