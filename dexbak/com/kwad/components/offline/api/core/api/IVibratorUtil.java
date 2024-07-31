package com.kwad.components.offline.api.core.api;

import android.content.Context;
import android.os.Vibrator;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public interface IVibratorUtil {
    void cancelVibrate(Context context, Vibrator vibrator);

    void vibrate(Context context, Vibrator vibrator, long j);
}
