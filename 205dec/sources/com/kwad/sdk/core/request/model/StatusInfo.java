package com.kwad.sdk.core.request.model;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.t;
import java.io.Serializable;
import java.util.List;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsJson
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class StatusInfo extends com.kwad.sdk.core.response.a.a {
    public int azK;
    public int azL;
    public SplashAdInfo azM;
    public NativeAdRequestInfo azN;
    public List<f> azO;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    @KsJson
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static final class NativeAdRequestInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = -7917397487136276024L;
        public NativeAdStyleControl nativeAdStyleControl;

        public static NativeAdRequestInfo create(SceneImpl sceneImpl) {
            NativeAdRequestInfo nativeAdRequestInfo = new NativeAdRequestInfo();
            nativeAdRequestInfo.nativeAdStyleControl = com.kwad.sdk.utils.b.e(sceneImpl);
            return nativeAdRequestInfo;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    @KsJson
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static final class NativeAdStyleControl extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = -6047032783829467891L;
        public boolean enableShake;

        @Override // com.kwad.sdk.core.response.a.a
        public final void afterToJson(JSONObject jSONObject) {
            super.afterToJson(jSONObject);
            t.putValue(jSONObject, "enableShake", this.enableShake);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    @KsJson
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static final class SplashAdInfo extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = 7910709346852904072L;
        public int dailyShowCount;
        public SplashStyleControl splashStyleControl;

        public static SplashAdInfo create(SceneImpl sceneImpl) {
            SplashAdInfo splashAdInfo = new SplashAdInfo();
            splashAdInfo.dailyShowCount = com.kwad.sdk.utils.b.KQ();
            splashAdInfo.splashStyleControl = com.kwad.sdk.utils.b.d(sceneImpl);
            return splashAdInfo;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    @KsJson
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static final class SplashStyleControl extends com.kwad.sdk.core.response.a.a implements Serializable {
        private static final long serialVersionUID = -6510852657198503314L;
        public boolean disableRotate;
        public boolean disableShake;
        public boolean disableSlide;
    }

    private StatusInfo(SceneImpl sceneImpl) {
        try {
            int i4 = 1;
            this.azK = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).yq() ? 1 : 0;
            if (!((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).yr()) {
                i4 = 0;
            }
            this.azL = i4;
            this.azO = com.kwad.sdk.core.d.a.DH();
            this.azN = NativeAdRequestInfo.create(sceneImpl);
            this.azM = SplashAdInfo.create(sceneImpl);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static StatusInfo c(SceneImpl sceneImpl) {
        return new StatusInfo(sceneImpl);
    }
}
