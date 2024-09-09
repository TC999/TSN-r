package com.kwad.components.offline.api.core.api;

import android.content.Context;
import android.os.Vibrator;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public interface IVibratorUtil {
    void cancelVibrate(Context context, Vibrator vibrator);

    void vibrate(Context context, Vibrator vibrator, long j4);
}
