package com.bytedance.msdk.core.c;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.msdk.api.sr.c.r.k;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends w {
    public c(com.bytedance.msdk.adapter.c cVar) {
        super(cVar);
    }

    private com.bytedance.msdk.api.sr.c.c.c w() {
        return (com.bytedance.msdk.api.sr.c.c.c) this.f27667a;
    }

    @Override // com.bytedance.msdk.core.c.w
    public <T> T c(int i4, ValueSet valueSet, Class<T> cls) {
        if (i4 == 1008) {
            if (this.f27667a instanceof com.bytedance.msdk.api.sr.c.c.c) {
                w().k_();
                return null;
            }
            return null;
        } else if (i4 == 1009) {
            if (this.f27667a instanceof com.bytedance.msdk.api.sr.c.c.c) {
                w().j_();
                return null;
            }
            return null;
        } else if (i4 == 1014) {
            if (this.f27667a instanceof com.bytedance.msdk.api.sr.c.c.c) {
                com.bytedance.msdk.adapter.c cVar = ((w) this).f27851w;
                if (cVar != null) {
                    com.bytedance.msdk.core.w.c.c(cVar.getAdapterRit());
                }
                w().i_();
                return null;
            }
            return null;
        } else if (i4 == 1016) {
            if (this.f27667a instanceof com.bytedance.msdk.api.sr.c.c.c) {
                w().c();
                return null;
            }
            return null;
        } else if (i4 == 8111) {
            setCpm(valueSet.doubleValue(8016));
            return null;
        } else if (i4 != 8140) {
            if (i4 != 8207) {
                return null;
            }
            setLevelTag(valueSet.stringValue(8058));
            return null;
        } else {
            String stringValue = valueSet.stringValue(8045);
            String stringValue2 = valueSet.stringValue(8046);
            int intValue = valueSet.intValue(8047);
            String stringValue3 = valueSet.stringValue(8048);
            String stringValue4 = valueSet.stringValue(8049);
            String stringValue5 = valueSet.stringValue(8050);
            int intValue2 = valueSet.intValue(8051);
            int intValue3 = valueSet.intValue(8052);
            String stringValue6 = valueSet.stringValue(8054);
            boolean booleanValue = valueSet.booleanValue(8055);
            String stringValue7 = valueSet.stringValue(8056);
            String stringValue8 = valueSet.stringValue(8057);
            Object objectValue = valueSet.objectValue(8036, Object.class);
            String stringValue9 = valueSet.stringValue(8058);
            double doubleValue = valueSet.doubleValue(8016);
            boolean booleanValue2 = valueSet.booleanValue(8033);
            int intValue4 = valueSet.intValue(8060);
            String stringValue10 = valueSet.stringValue(8061);
            String stringValue11 = valueSet.stringValue(8061);
            long longValue = valueSet.longValue(8078);
            String stringValue12 = valueSet.stringValue(8079);
            Map<String, String> map = (Map) valueSet.objectValue(8427, Map.class);
            String stringValue13 = valueSet.stringValue(8080);
            String stringValue14 = valueSet.stringValue(8081);
            double doubleValue2 = valueSet.doubleValue(8082);
            int intValue5 = valueSet.intValue(8059);
            String stringValue15 = valueSet.stringValue(8551);
            setTitle(stringValue);
            setAdDescription(stringValue2);
            setAppSize(intValue);
            setIconUrl(stringValue3);
            setSource(stringValue4);
            setImageUrl(stringValue5);
            setImageHeight(intValue2);
            setImageWidth(intValue3);
            setImages((List) valueSet.objectValue(8053, List.class));
            setPackageName(stringValue6);
            setIsAppDownload(booleanValue);
            setAppName(stringValue7);
            setAuthorName(stringValue8);
            if (TextUtils.equals(getAdNetWorkName(), "baidu")) {
                putExtraMsg("baidu_dislike_info", objectValue);
            }
            setLevelTag(stringValue9);
            setCpm(doubleValue);
            setExpressAd(booleanValue2);
            setImageMode(intValue4);
            setInteractionType(intValue5);
            setActionText(stringValue10);
            setStore(stringValue11);
            setPackageSizeBytes(longValue);
            setPermissionsUrl(stringValue12);
            setPermissionsMap(map);
            setPrivacyAgreement(stringValue13);
            setVersionName(stringValue14);
            setRating(doubleValue2);
            setFunctionDescUrl(stringValue15);
            return null;
        }
    }

    @Override // com.bytedance.msdk.c.ux
    public View getAdView() {
        Bridge bridge = ((w) this).f27850c;
        if (bridge != null) {
            return (View) bridge.call(6081, null, View.class);
        }
        return super.getAdView();
    }

    @Override // com.bytedance.msdk.c.ux
    public String getReqId() {
        Bridge bridge = ((w) this).f27850c;
        if (bridge != null) {
            return (String) bridge.call(8147, null, String.class);
        }
        return super.getReqId();
    }

    @Override // com.bytedance.msdk.c.ux
    public boolean hasDislike() {
        try {
            Bridge bridge = ((w) this).f27850c;
            if (bridge != null) {
                return ((Boolean) bridge.call(8135, null, Boolean.class)).booleanValue();
            }
        } catch (Exception unused) {
        }
        return super.hasDislike();
    }

    @Override // com.bytedance.msdk.c.ux
    public MediationConstant.AdIsReadyStatus isReadyStatus() {
        Bridge bridge = ((w) this).f27850c;
        if (bridge != null) {
            MediationConstant.AdIsReadyStatus adIsReadyStatus = (MediationConstant.AdIsReadyStatus) bridge.call(8121, null, MediationConstant.AdIsReadyStatus.class);
            return adIsReadyStatus == null ? super.isReadyStatus() : adIsReadyStatus;
        }
        return super.isReadyStatus();
    }

    @Override // com.bytedance.msdk.c.ux
    public void registerViewForInteraction(Activity activity, @NonNull ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, k kVar) {
        if (((w) this).f27850c != null) {
            b a4 = b.a();
            a4.h(20033, activity);
            a4.h(8067, viewGroup);
            a4.h(8068, list);
            a4.h(8069, list2);
            a4.h(8070, list3);
            a4.h(8071, k.c(kVar));
            ((w) this).f27850c.call(8159, a4.l(), Void.class);
        }
    }
}
