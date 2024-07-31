package com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationValueUtil;
import com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomNativeDislikeDialog;
import com.bytedance.sdk.openadsdk.mediation.p159ad.MediationAdDislike;
import com.bytedance.sdk.openadsdk.mediation.p159ad.MediationNativeAdAppInfo;
import com.bytedance.sdk.openadsdk.mediation.p159ad.MediationViewBinder;
import com.bytedance.sdk.openadsdk.mediation.p170ok.p171ok.C6484k;
import java.util.List;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MediationCustomNativeAd implements Bridge, IMediationCustomNativeAd {

    /* renamed from: a */
    private Map<String, Object> f22721a;

    /* renamed from: bl */
    private String f22722bl;

    /* renamed from: h */
    private int f22723h;

    /* renamed from: i */
    private boolean f22724i;

    /* renamed from: io */
    private MediationCustomNativeDislikeDialog f22725io;

    /* renamed from: j */
    private int f22726j;

    /* renamed from: k */
    private String f22727k;

    /* renamed from: kf */
    private String f22728kf;

    /* renamed from: n */
    private String f22729n;

    /* renamed from: ok */
    private double f22730ok;

    /* renamed from: p */
    private int f22731p;

    /* renamed from: q */
    private String f22732q;

    /* renamed from: r */
    private int f22733r;

    /* renamed from: rh */
    private List<String> f22734rh;

    /* renamed from: s */
    private String f22735s;

    /* renamed from: t */
    private String f22736t;

    /* renamed from: td */
    private int f22737td;

    /* renamed from: u */
    private Bridge f22738u;

    /* renamed from: x */
    private int f22739x;

    /* renamed from: z */
    private double f22740z;

    /* renamed from: zz */
    private MediationNativeAdAppInfo f22741zz;

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        MediationAdDislike dislikeDialog;
        if (i == 8127) {
            this.f22738u = (Bridge) valueSet.objectValue(8034, Bridge.class);
        } else if (i == 6083) {
            render();
        } else if (i == 6081) {
            return (T) getExpressView();
        } else {
            if (i == 8159) {
                registerView((Activity) valueSet.objectValue(20033, Activity.class), (ViewGroup) valueSet.objectValue(8067, ViewGroup.class), (List) valueSet.objectValue(8068, List.class), (List) valueSet.objectValue(8069, List.class), (List) valueSet.objectValue(8070, List.class), BridgeUtil.buildViewBinder((Bridge) valueSet.objectValue(8071, Bridge.class)));
            } else if (i == 8135) {
                return (T) Boolean.valueOf(hasDislike());
            } else {
                if (i == 8149) {
                    onPause();
                } else if (i == 8148) {
                    onResume();
                } else if (i == 8109) {
                    onDestroy();
                } else if (i == 8121) {
                    return (T) isReadyCondition();
                } else {
                    if (i == 8194) {
                        String stringValue = valueSet.stringValue(8036);
                        Map<String, Object> map = (Map) valueSet.objectValue(8075, Map.class);
                        MediationCustomNativeDislikeDialog mediationCustomNativeDislikeDialog = this.f22725io;
                        if (mediationCustomNativeDislikeDialog != null) {
                            mediationCustomNativeDislikeDialog.dislikeClick(stringValue, map);
                        }
                    } else if (i == 6072) {
                        Activity activity = (Activity) valueSet.objectValue(20033, Activity.class);
                        Map<String, Object> map2 = (Map) valueSet.objectValue(8075, Map.class);
                        MediationCustomNativeDislikeDialog mediationCustomNativeDislikeDialog2 = this.f22725io;
                        if (mediationCustomNativeDislikeDialog2 != null && (dislikeDialog = mediationCustomNativeDislikeDialog2.getDislikeDialog(activity, map2)) != null) {
                            return (T) new C6484k(dislikeDialog);
                        }
                    } else if (i == 8320) {
                        return (T) new MediationCustomizeVideoImpl(getNativeCustomVideoReporter());
                    } else {
                        if (i == 8228) {
                            return (T) getVideoUrl();
                        }
                        if (i == 8225) {
                            MediationApiLog.m36297i("TTMediationSDK", "MediationCustomNativeAd receiveBidResult");
                            receiveBidResult(valueSet.booleanValue(8406), valueSet.doubleValue(8407), valueSet.intValue(8408), (Map) valueSet.objectValue(8075, Map.class));
                        }
                    }
                }
            }
        }
        return (T) MediationValueUtil.checkClassType(cls);
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callAdClick() {
        Bridge bridge = this.f22738u;
        if (bridge != null) {
            bridge.call(8130, null, Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callAdShow() {
        Bridge bridge = this.f22738u;
        if (bridge != null) {
            bridge.call(8113, null, Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callDislikeCancel() {
        Bridge bridge = this.f22738u;
        if (bridge != null) {
            bridge.call(8184, null, Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callDislikeSelected(int i, String str) {
        if (this.f22738u != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8038, i);
            create.add(8039, str);
            this.f22738u.call(8132, create.build(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callDislikeShow() {
        Bridge bridge = this.f22738u;
        if (bridge != null) {
            bridge.call(8185, null, Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnDownloadActive(long j, long j2) {
        if (this.f22738u != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8062, j);
            create.add(8063, j2);
            this.f22738u.call(8187, create.build(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnDownloadFailed(long j, long j2, String str, String str2) {
        if (this.f22738u != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8062, j);
            create.add(8063, j2);
            create.add(8066, str);
            create.add(8056, str2);
            this.f22738u.call(8157, create.build(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnDownloadFinished(long j, String str, String str2) {
        if (this.f22738u != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8062, j);
            create.add(8066, str);
            create.add(8056, str2);
            this.f22738u.call(8155, create.build(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnDownloadPaused(long j, long j2, String str, String str2) {
        if (this.f22738u != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8062, j);
            create.add(8063, j2);
            create.add(8066, str);
            create.add(8056, str2);
            this.f22738u.call(8158, create.build(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnIdle() {
        Bridge bridge = this.f22738u;
        if (bridge != null) {
            bridge.call(8152, null, Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnInstalled(String str, String str2) {
        if (this.f22738u != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8066, str);
            create.add(8056, str2);
            this.f22738u.call(8156, create.build(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callRenderFail(View view, int i, String str) {
        if (this.f22738u != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8042, view);
            create.add(8014, i);
            create.add(8015, str);
            this.f22738u.call(8134, create.build(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callRenderSuccess(float f, float f2) {
        if (this.f22738u != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8040, f);
            create.add(8041, f2);
            this.f22738u.call(8133, create.build(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoCompleted() {
        Bridge bridge = this.f22738u;
        if (bridge != null) {
            bridge.call(8118, null, Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoError(int i, String str) {
        if (this.f22738u != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8014, i);
            create.add(8015, str);
            this.f22738u.call(8117, create.build(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoPause() {
        Bridge bridge = this.f22738u;
        if (bridge != null) {
            bridge.call(8146, null, Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoProgressUpdate(long j, long j2) {
        if (this.f22738u != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8072, j);
            create.add(8073, j2);
            this.f22738u.call(8154, create.build(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoResume() {
        Bridge bridge = this.f22738u;
        if (bridge != null) {
            bridge.call(8150, null, Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoStart() {
        Bridge bridge = this.f22738u;
        if (bridge != null) {
            bridge.call(8145, null, Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public int getBiddingType() {
        Bridge bridge = this.f22738u;
        if (bridge != null) {
            return ((Integer) bridge.call(8226, null, Integer.class)).intValue();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public View getExpressView() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public TTFeedAd.CustomizeVideo getNativeCustomVideoReporter() {
        return null;
    }

    public ValueSet getValueSet() {
        MediationValueSetBuilder create = MediationValueSetBuilder.create();
        create.add(8016, this.f22730ok);
        create.add(8006, this.f22721a);
        create.add(8045, this.f22722bl);
        create.add(8046, this.f22735s);
        create.add(8048, this.f22729n);
        create.add(8050, this.f22728kf);
        create.add(8051, this.f22731p);
        create.add(8052, this.f22723h);
        create.add(8061, this.f22732q);
        create.add(8054, this.f22727k);
        create.add(8420, this.f22733r);
        create.add(8421, this.f22726j);
        create.add(8082, this.f22740z);
        create.add(8053, this.f22734rh);
        create.add(8049, this.f22736t);
        create.add(8033, this.f22724i);
        create.add(8060, this.f22739x);
        create.add(8059, this.f22737td);
        MediationNativeAdAppInfo mediationNativeAdAppInfo = this.f22741zz;
        if (mediationNativeAdAppInfo != null) {
            create.add(8315, new MediationNativeAppInfoImpl(mediationNativeAdAppInfo));
        }
        return create.build();
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public String getVideoUrl() {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public boolean hasDislike() {
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public boolean isClientBidding() {
        Bridge bridge = this.f22738u;
        if (bridge != null) {
            return ((Boolean) bridge.call(8110, null, Boolean.class)).booleanValue();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public MediationConstant.AdIsReadyStatus isReadyCondition() {
        return MediationConstant.AdIsReadyStatus.ADN_NO_READY_API;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public boolean isServerBidding() {
        Bridge bridge = this.f22738u;
        if (bridge != null) {
            return ((Boolean) bridge.call(8136, null, Boolean.class)).booleanValue();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public boolean isUseCustomVideo() {
        Bridge bridge = this.f22738u;
        if (bridge != null) {
            return ((Boolean) bridge.call(8160, null, Boolean.class)).booleanValue();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void onDestroy() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void onPause() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void onResume() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void receiveBidResult(boolean z, double d, int i, Map<String, Object> map) {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void registerView(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, MediationViewBinder mediationViewBinder) {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void render() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setActionText(String str) {
        this.f22732q = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setAdImageMode(int i) {
        this.f22739x = i;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setBiddingPrice(double d) {
        this.f22730ok = d;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setDescription(String str) {
        this.f22735s = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setDislikeDialogCallBack(MediationCustomNativeDislikeDialog mediationCustomNativeDislikeDialog) {
        Bridge bridge = this.f22738u;
        if (bridge != null) {
            this.f22725io = mediationCustomNativeDislikeDialog;
            bridge.call(6085, null, Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setExpressAd(boolean z) {
        this.f22724i = z;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setIconUrl(String str) {
        this.f22729n = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setImageHeight(int i) {
        this.f22731p = i;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setImageList(List<String> list) {
        this.f22734rh = list;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setImageUrl(String str) {
        this.f22728kf = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setImageWidth(int i) {
        this.f22723h = i;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setInteractionType(int i) {
        this.f22737td = i;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setMediaExtraInfo(Map<String, Object> map) {
        this.f22721a = map;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setNativeAdAppInfo(MediationNativeAdAppInfo mediationNativeAdAppInfo) {
        this.f22741zz = mediationNativeAdAppInfo;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setPackageName(String str) {
        this.f22727k = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setSource(String str) {
        this.f22736t = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setStarRating(double d) {
        this.f22740z = d;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setTitle(String str) {
        this.f22722bl = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setVideoHeight(int i) {
        this.f22726j = i;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setVideoWidth(int i) {
        this.f22733r = i;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return getValueSet();
    }
}
