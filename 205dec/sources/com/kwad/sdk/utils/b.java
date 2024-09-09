package com.kwad.sdk.utils;

import android.text.TextUtils;
import com.kwad.sdk.core.request.model.StatusInfo;
import com.kwad.sdk.internal.api.NativeAdExtraDataImpl;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.internal.api.SplashExtraDataImpl;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b {
    public static int KQ() {
        String LH = y.LH();
        if (TextUtils.isEmpty(LH)) {
            return 0;
        }
        try {
            JSONObject jSONObject = new JSONObject(LH);
            int optInt = jSONObject.optInt("currentDailyCount");
            if (c(jSONObject.optLong("lastShowTimestamp"), System.currentTimeMillis())) {
                return optInt;
            }
            return 0;
        } catch (Exception e4) {
            com.kwad.sdk.core.e.c.printStackTraceOnly(e4);
            return 0;
        }
    }

    private static boolean c(long j4, long j5) {
        if (j4 > 0 && j5 > 0) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                return simpleDateFormat.format(new Date(j4)).equals(simpleDateFormat.format(new Date(j5)));
            } catch (Exception e4) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(e4);
            }
        }
        return false;
    }

    public static StatusInfo.SplashStyleControl d(SceneImpl sceneImpl) {
        StatusInfo.SplashStyleControl splashStyleControl = new StatusInfo.SplashStyleControl();
        if (sceneImpl != null && f(sceneImpl)) {
            SplashExtraDataImpl splashExtraDataImpl = sceneImpl.splashExtraData;
            splashStyleControl.disableShake = splashExtraDataImpl.disableShake;
            splashStyleControl.disableRotate = splashExtraDataImpl.disableRotate;
            splashStyleControl.disableSlide = splashExtraDataImpl.disableSlide;
            return splashStyleControl;
        }
        return null;
    }

    public static StatusInfo.NativeAdStyleControl e(SceneImpl sceneImpl) {
        NativeAdExtraDataImpl nativeAdExtraDataImpl;
        StatusInfo.NativeAdStyleControl nativeAdStyleControl = new StatusInfo.NativeAdStyleControl();
        if (sceneImpl == null || (nativeAdExtraDataImpl = sceneImpl.nativeAdExtraData) == null) {
            return null;
        }
        nativeAdStyleControl.enableShake = nativeAdExtraDataImpl.enableShake;
        return nativeAdStyleControl;
    }

    private static boolean f(SceneImpl sceneImpl) {
        return sceneImpl.splashExtraData != null;
    }
}
