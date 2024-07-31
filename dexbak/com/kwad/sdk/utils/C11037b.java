package com.kwad.sdk.utils;

import android.text.TextUtils;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.request.model.StatusInfo;
import com.kwad.sdk.internal.api.NativeAdExtraDataImpl;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.internal.api.SplashExtraDataImpl;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.utils.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11037b {
    /* renamed from: KQ */
    public static int m23980KQ() {
        String m23637LH = C11137y.m23637LH();
        if (TextUtils.isEmpty(m23637LH)) {
            return 0;
        }
        try {
            JSONObject jSONObject = new JSONObject(m23637LH);
            int optInt = jSONObject.optInt("currentDailyCount");
            if (m23979c(jSONObject.optLong("lastShowTimestamp"), System.currentTimeMillis())) {
                return optInt;
            }
            return 0;
        } catch (Exception e) {
            C10331c.printStackTraceOnly(e);
            return 0;
        }
    }

    /* renamed from: c */
    private static boolean m23979c(long j, long j2) {
        if (j > 0 && j2 > 0) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                return simpleDateFormat.format(new Date(j)).equals(simpleDateFormat.format(new Date(j2)));
            } catch (Exception e) {
                C10331c.printStackTraceOnly(e);
            }
        }
        return false;
    }

    /* renamed from: d */
    public static StatusInfo.SplashStyleControl m23978d(SceneImpl sceneImpl) {
        StatusInfo.SplashStyleControl splashStyleControl = new StatusInfo.SplashStyleControl();
        if (sceneImpl != null && m23976f(sceneImpl)) {
            SplashExtraDataImpl splashExtraDataImpl = sceneImpl.splashExtraData;
            splashStyleControl.disableShake = splashExtraDataImpl.disableShake;
            splashStyleControl.disableRotate = splashExtraDataImpl.disableRotate;
            splashStyleControl.disableSlide = splashExtraDataImpl.disableSlide;
            return splashStyleControl;
        }
        return null;
    }

    /* renamed from: e */
    public static StatusInfo.NativeAdStyleControl m23977e(SceneImpl sceneImpl) {
        NativeAdExtraDataImpl nativeAdExtraDataImpl;
        StatusInfo.NativeAdStyleControl nativeAdStyleControl = new StatusInfo.NativeAdStyleControl();
        if (sceneImpl == null || (nativeAdExtraDataImpl = sceneImpl.nativeAdExtraData) == null) {
            return null;
        }
        nativeAdStyleControl.enableShake = nativeAdExtraDataImpl.enableShake;
        return nativeAdStyleControl;
    }

    /* renamed from: f */
    private static boolean m23976f(SceneImpl sceneImpl) {
        return sceneImpl.splashExtraData != null;
    }
}
