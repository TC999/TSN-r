package com.bytedance.sdk.openadsdk.mediation.bridge.custom.native_ad;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.mediation.MediationApiLog;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationAdDislike;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationNativeAdAppInfo;
import com.bytedance.sdk.openadsdk.mediation.ad.MediationViewBinder;
import com.bytedance.sdk.openadsdk.mediation.bridge.MediationValueSetBuilder;
import com.bytedance.sdk.openadsdk.mediation.bridge.valueset.MediationValueUtil;
import com.bytedance.sdk.openadsdk.mediation.c.c.p;
import com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd;
import com.bytedance.sdk.openadsdk.mediation.custom.MediationCustomNativeDislikeDialog;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class MediationCustomNativeAd implements Bridge, IMediationCustomNativeAd {

    /* renamed from: a  reason: collision with root package name */
    private int f36074a;
    private double bk;

    /* renamed from: c  reason: collision with root package name */
    private double f36075c;
    private int ev;

    /* renamed from: f  reason: collision with root package name */
    private String f36076f;
    private boolean fp;
    private MediationNativeAdAppInfo fz;
    private String gd;

    /* renamed from: i  reason: collision with root package name */
    private MediationCustomNativeDislikeDialog f36077i;
    private int ia;

    /* renamed from: k  reason: collision with root package name */
    private int f36078k;

    /* renamed from: p  reason: collision with root package name */
    private String f36079p;

    /* renamed from: r  reason: collision with root package name */
    private int f36080r;

    /* renamed from: s  reason: collision with root package name */
    private int f36081s;
    private String sr;

    /* renamed from: t  reason: collision with root package name */
    private List<String> f36082t;

    /* renamed from: u  reason: collision with root package name */
    private Bridge f36083u;
    private String ux;

    /* renamed from: w  reason: collision with root package name */
    private Map<String, Object> f36084w;
    private String xv;
    private String ys;

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        MediationAdDislike dislikeDialog;
        if (i4 == 8127) {
            this.f36083u = (Bridge) valueSet.objectValue(8034, Bridge.class);
        } else if (i4 == 6083) {
            render();
        } else if (i4 == 6081) {
            return (T) getExpressView();
        } else {
            if (i4 == 8159) {
                registerView((Activity) valueSet.objectValue(20033, Activity.class), (ViewGroup) valueSet.objectValue(8067, ViewGroup.class), (List) valueSet.objectValue(8068, List.class), (List) valueSet.objectValue(8069, List.class), (List) valueSet.objectValue(8070, List.class), BridgeUtil.buildViewBinder((Bridge) valueSet.objectValue(8071, Bridge.class)));
            } else if (i4 == 8135) {
                return (T) Boolean.valueOf(hasDislike());
            } else {
                if (i4 == 8149) {
                    onPause();
                } else if (i4 == 8148) {
                    onResume();
                } else if (i4 == 8109) {
                    onDestroy();
                } else if (i4 == 8121) {
                    return (T) isReadyCondition();
                } else {
                    if (i4 == 8194) {
                        String stringValue = valueSet.stringValue(8036);
                        Map<String, Object> map = (Map) valueSet.objectValue(8075, Map.class);
                        MediationCustomNativeDislikeDialog mediationCustomNativeDislikeDialog = this.f36077i;
                        if (mediationCustomNativeDislikeDialog != null) {
                            mediationCustomNativeDislikeDialog.dislikeClick(stringValue, map);
                        }
                    } else if (i4 == 6072) {
                        Activity activity = (Activity) valueSet.objectValue(20033, Activity.class);
                        Map<String, Object> map2 = (Map) valueSet.objectValue(8075, Map.class);
                        MediationCustomNativeDislikeDialog mediationCustomNativeDislikeDialog2 = this.f36077i;
                        if (mediationCustomNativeDislikeDialog2 != null && (dislikeDialog = mediationCustomNativeDislikeDialog2.getDislikeDialog(activity, map2)) != null) {
                            return (T) new p(dislikeDialog);
                        }
                    } else if (i4 == 8320) {
                        return (T) new MediationCustomizeVideoImpl(getNativeCustomVideoReporter());
                    } else {
                        if (i4 == 8228) {
                            return (T) getVideoUrl();
                        }
                        if (i4 == 8225) {
                            MediationApiLog.i("TTMediationSDK", "MediationCustomNativeAd receiveBidResult");
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
        Bridge bridge = this.f36083u;
        if (bridge != null) {
            bridge.call(8130, null, Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callAdShow() {
        Bridge bridge = this.f36083u;
        if (bridge != null) {
            bridge.call(8113, null, Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callDislikeCancel() {
        Bridge bridge = this.f36083u;
        if (bridge != null) {
            bridge.call(8184, null, Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callDislikeSelected(int i4, String str) {
        if (this.f36083u != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8038, i4);
            create.add(8039, str);
            this.f36083u.call(8132, create.build(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callDislikeShow() {
        Bridge bridge = this.f36083u;
        if (bridge != null) {
            bridge.call(8185, null, Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnDownloadActive(long j4, long j5) {
        if (this.f36083u != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8062, j4);
            create.add(8063, j5);
            this.f36083u.call(8187, create.build(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnDownloadFailed(long j4, long j5, String str, String str2) {
        if (this.f36083u != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8062, j4);
            create.add(8063, j5);
            create.add(8066, str);
            create.add(8056, str2);
            this.f36083u.call(8157, create.build(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnDownloadFinished(long j4, String str, String str2) {
        if (this.f36083u != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8062, j4);
            create.add(8066, str);
            create.add(8056, str2);
            this.f36083u.call(8155, create.build(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnDownloadPaused(long j4, long j5, String str, String str2) {
        if (this.f36083u != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8062, j4);
            create.add(8063, j5);
            create.add(8066, str);
            create.add(8056, str2);
            this.f36083u.call(8158, create.build(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnIdle() {
        Bridge bridge = this.f36083u;
        if (bridge != null) {
            bridge.call(8152, null, Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callOnInstalled(String str, String str2) {
        if (this.f36083u != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8066, str);
            create.add(8056, str2);
            this.f36083u.call(8156, create.build(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callRenderFail(View view, int i4, String str) {
        if (this.f36083u != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8042, view);
            create.add(8014, i4);
            create.add(8015, str);
            this.f36083u.call(8134, create.build(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callRenderSuccess(float f4, float f5) {
        if (this.f36083u != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8040, f4);
            create.add(8041, f5);
            this.f36083u.call(8133, create.build(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoCompleted() {
        Bridge bridge = this.f36083u;
        if (bridge != null) {
            bridge.call(8118, null, Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoError(int i4, String str) {
        if (this.f36083u != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8014, i4);
            create.add(8015, str);
            this.f36083u.call(8117, create.build(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoPause() {
        Bridge bridge = this.f36083u;
        if (bridge != null) {
            bridge.call(8146, null, Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoProgressUpdate(long j4, long j5) {
        if (this.f36083u != null) {
            MediationValueSetBuilder create = MediationValueSetBuilder.create();
            create.add(8072, j4);
            create.add(8073, j5);
            this.f36083u.call(8154, create.build(), Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoResume() {
        Bridge bridge = this.f36083u;
        if (bridge != null) {
            bridge.call(8150, null, Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void callVideoStart() {
        Bridge bridge = this.f36083u;
        if (bridge != null) {
            bridge.call(8145, null, Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public int getBiddingType() {
        Bridge bridge = this.f36083u;
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
        create.add(8016, this.f36075c);
        create.add(AVMDLDataLoader.KeyIsLiveCacheThresholdHttpToP2p, this.f36084w);
        create.add(8045, this.xv);
        create.add(8046, this.sr);
        create.add(8048, this.ux);
        create.add(8050, this.f36076f);
        create.add(8051, this.ev);
        create.add(8052, this.f36080r);
        create.add(8061, this.gd);
        create.add(8054, this.f36079p);
        create.add(8420, this.f36078k);
        create.add(8421, this.f36074a);
        create.add(8082, this.bk);
        create.add(8053, this.f36082t);
        create.add(8049, this.ys);
        create.add(8033, this.fp);
        create.add(8060, this.ia);
        create.add(8059, this.f36081s);
        MediationNativeAdAppInfo mediationNativeAdAppInfo = this.fz;
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
        Bridge bridge = this.f36083u;
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
        Bridge bridge = this.f36083u;
        if (bridge != null) {
            return ((Boolean) bridge.call(8136, null, Boolean.class)).booleanValue();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public boolean isUseCustomVideo() {
        Bridge bridge = this.f36083u;
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
    public void receiveBidResult(boolean z3, double d4, int i4, Map<String, Object> map) {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void registerView(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, MediationViewBinder mediationViewBinder) {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void render() {
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setActionText(String str) {
        this.gd = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setAdImageMode(int i4) {
        this.ia = i4;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setBiddingPrice(double d4) {
        this.f36075c = d4;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setDescription(String str) {
        this.sr = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setDislikeDialogCallBack(MediationCustomNativeDislikeDialog mediationCustomNativeDislikeDialog) {
        Bridge bridge = this.f36083u;
        if (bridge != null) {
            this.f36077i = mediationCustomNativeDislikeDialog;
            bridge.call(6085, null, Void.class);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setExpressAd(boolean z3) {
        this.fp = z3;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setIconUrl(String str) {
        this.ux = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setImageHeight(int i4) {
        this.ev = i4;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setImageList(List<String> list) {
        this.f36082t = list;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setImageUrl(String str) {
        this.f36076f = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setImageWidth(int i4) {
        this.f36080r = i4;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setInteractionType(int i4) {
        this.f36081s = i4;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setMediaExtraInfo(Map<String, Object> map) {
        this.f36084w = map;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setNativeAdAppInfo(MediationNativeAdAppInfo mediationNativeAdAppInfo) {
        this.fz = mediationNativeAdAppInfo;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setPackageName(String str) {
        this.f36079p = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setSource(String str) {
        this.ys = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setStarRating(double d4) {
        this.bk = d4;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setTitle(String str) {
        this.xv = str;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setVideoHeight(int i4) {
        this.f36074a = i4;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.custom.IMediationCustomNativeAd
    public void setVideoWidth(int i4) {
        this.f36078k = i4;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return getValueSet();
    }
}
