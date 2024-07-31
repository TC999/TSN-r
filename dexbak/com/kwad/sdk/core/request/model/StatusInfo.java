package com.kwad.sdk.core.request.model;

import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.p392d.C10274a;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.p449a.InterfaceC10968f;
import com.kwad.sdk.utils.C11037b;
import com.kwad.sdk.utils.C11126t;
import java.io.Serializable;
import java.util.List;
import org.json.JSONObject;

@KsJson
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class StatusInfo extends C10482a {
    public int azK;
    public int azL;
    public SplashAdInfo azM;
    public NativeAdRequestInfo azN;
    public List<C10480f> azO;

    @KsJson
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class NativeAdRequestInfo extends C10482a implements Serializable {
        private static final long serialVersionUID = -7917397487136276024L;
        public NativeAdStyleControl nativeAdStyleControl;

        public static NativeAdRequestInfo create(SceneImpl sceneImpl) {
            NativeAdRequestInfo nativeAdRequestInfo = new NativeAdRequestInfo();
            nativeAdRequestInfo.nativeAdStyleControl = C11037b.m23977e(sceneImpl);
            return nativeAdRequestInfo;
        }
    }

    @KsJson
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class NativeAdStyleControl extends C10482a implements Serializable {
        private static final long serialVersionUID = -6047032783829467891L;
        public boolean enableShake;

        @Override // com.kwad.sdk.core.response.p408a.C10482a
        public final void afterToJson(JSONObject jSONObject) {
            super.afterToJson(jSONObject);
            C11126t.putValue(jSONObject, "enableShake", this.enableShake);
        }
    }

    @KsJson
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class SplashAdInfo extends C10482a implements Serializable {
        private static final long serialVersionUID = 7910709346852904072L;
        public int dailyShowCount;
        public SplashStyleControl splashStyleControl;

        public static SplashAdInfo create(SceneImpl sceneImpl) {
            SplashAdInfo splashAdInfo = new SplashAdInfo();
            splashAdInfo.dailyShowCount = C11037b.m23980KQ();
            splashAdInfo.splashStyleControl = C11037b.m23978d(sceneImpl);
            return splashAdInfo;
        }
    }

    @KsJson
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class SplashStyleControl extends C10482a implements Serializable {
        private static final long serialVersionUID = -6510852657198503314L;
        public boolean disableRotate;
        public boolean disableShake;
        public boolean disableSlide;
    }

    private StatusInfo(SceneImpl sceneImpl) {
        try {
            int i = 1;
            this.azK = ((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).mo24338yq() ? 1 : 0;
            if (!((InterfaceC10968f) ServiceProvider.get(InterfaceC10968f.class)).mo24337yr()) {
                i = 0;
            }
            this.azL = i;
            this.azO = C10274a.m26473DH();
            this.azN = NativeAdRequestInfo.create(sceneImpl);
            this.azM = SplashAdInfo.create(sceneImpl);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: c */
    public static StatusInfo m25997c(SceneImpl sceneImpl) {
        return new StatusInfo(sceneImpl);
    }
}
