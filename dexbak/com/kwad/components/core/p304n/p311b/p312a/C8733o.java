package com.kwad.components.core.p304n.p311b.p312a;

import android.content.Context;
import android.os.Vibrator;
import com.kwad.components.offline.api.core.api.IVibratorUtil;
import com.kwad.sdk.utils.C11064bn;

/* renamed from: com.kwad.components.core.n.b.a.o */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8733o implements IVibratorUtil {
    @Override // com.kwad.components.offline.api.core.api.IVibratorUtil
    public final void cancelVibrate(Context context, Vibrator vibrator) {
        C11064bn.m23861b(context, vibrator);
    }

    @Override // com.kwad.components.offline.api.core.api.IVibratorUtil
    public final void vibrate(Context context, Vibrator vibrator, long j) {
        C11064bn.vibrate(context, vibrator, j);
    }
}
