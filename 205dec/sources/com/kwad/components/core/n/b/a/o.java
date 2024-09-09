package com.kwad.components.core.n.b.a;

import android.content.Context;
import android.os.Vibrator;
import com.kwad.components.offline.api.core.api.IVibratorUtil;
import com.kwad.sdk.utils.bn;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class o implements IVibratorUtil {
    @Override // com.kwad.components.offline.api.core.api.IVibratorUtil
    public final void cancelVibrate(Context context, Vibrator vibrator) {
        bn.b(context, vibrator);
    }

    @Override // com.kwad.components.offline.api.core.api.IVibratorUtil
    public final void vibrate(Context context, Vibrator vibrator, long j4) {
        bn.vibrate(context, vibrator, j4);
    }
}
