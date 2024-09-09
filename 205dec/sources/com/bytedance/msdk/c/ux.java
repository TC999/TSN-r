package com.bytedance.msdk.c;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.bytedance.msdk.adapter.w.f;
import com.bytedance.msdk.api.sr.c.r.gd;
import com.bytedance.msdk.api.sr.c.r.k;
import com.bytedance.msdk.api.sr.c.r.p;
import com.bytedance.msdk.f.j;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.adhost.R;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.bytedance.sdk.openadsdk.ys.w.w.ev;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class ux implements xv, Comparable<ux> {

    /* renamed from: a  reason: collision with root package name */
    protected f f27667a;
    private int au;

    /* renamed from: b  reason: collision with root package name */
    private String f27668b;
    private String ba;
    private int be;
    private int bj;
    protected f bk;
    private String bm;
    private int bs;
    private double bw;

    /* renamed from: c  reason: collision with root package name */
    private String f27669c;
    private String ck;

    /* renamed from: e  reason: collision with root package name */
    private int f27670e;
    private boolean eb;
    private long eq;
    private int eu;
    protected com.bytedance.msdk.api.sr.c.w ev;

    /* renamed from: f  reason: collision with root package name */
    protected com.bytedance.msdk.api.sr.c.r.xv f27671f;
    private int fp;
    private double fz;

    /* renamed from: g  reason: collision with root package name */
    private int f27672g;
    private int gb;
    protected com.bytedance.msdk.api.sr.c.sr gd;
    private String gp;

    /* renamed from: i  reason: collision with root package name */
    private String f27674i;
    private String ia;

    /* renamed from: j  reason: collision with root package name */
    private int f27675j;

    /* renamed from: k  reason: collision with root package name */
    protected com.bytedance.msdk.api.sr.c.xv.w f27676k;
    private String kk;
    private String kn;
    private int lf;
    private long lw;

    /* renamed from: m  reason: collision with root package name */
    private int f27677m;
    private String me;
    private String mu;

    /* renamed from: n  reason: collision with root package name */
    private boolean f27678n;
    private int ng;
    private String oo;
    private String ox;

    /* renamed from: p  reason: collision with root package name */
    protected p f27679p;
    private String pr;

    /* renamed from: q  reason: collision with root package name */
    private double f27680q;
    private String qy;

    /* renamed from: r  reason: collision with root package name */
    protected gd f27681r;
    private volatile boolean rh;

    /* renamed from: s  reason: collision with root package name */
    private String f27682s;
    private String sr;

    /* renamed from: t  reason: collision with root package name */
    private int f27683t;
    private int ux;

    /* renamed from: w  reason: collision with root package name */
    private String f27685w;
    private String wo;
    private String wv;
    private Map<String, Object> wx;

    /* renamed from: x  reason: collision with root package name */
    private double f27686x;
    private String xg;
    private String xk;
    private boolean xu;
    private String xv;

    /* renamed from: y  reason: collision with root package name */
    private String f27687y;
    private int ys;
    private Map<String, String> yu;

    /* renamed from: z  reason: collision with root package name */
    private boolean f27688z;
    private String zr;
    private String zt;

    /* renamed from: u  reason: collision with root package name */
    private List<String> f27684u = new ArrayList();
    private int ls = -1;
    private int gw = 1;
    private int vc = 1;
    private int up = 1;
    private int mt = 1;
    private volatile boolean ok = false;

    /* renamed from: h  reason: collision with root package name */
    private volatile boolean f27673h = false;
    private volatile boolean oh = false;
    private volatile boolean fm = false;
    private final Map<String, Object> te = new j();
    private boolean ge = false;
    private boolean ta = false;
    private String tl = "1";
    private Map<String, Object> iw = new HashMap();
    private Map<String, Object> zg = new ConcurrentHashMap();

    private void c(ViewGroup viewGroup, k kVar) {
        if (viewGroup instanceof FrameLayout) {
            c(viewGroup);
            View findViewById = viewGroup.findViewById(R.id.tt_mediation_mtg_ad_choice);
            if (findViewById != null) {
                findViewById.setVisibility(8);
            }
            if (kVar != null) {
                clearLogoView(viewGroup.findViewById(kVar.f27511a));
            }
        }
    }

    public boolean adnHasAdVideoCachedApi() {
        return false;
    }

    public void bidLoseNotify(Map<String, Object> map) {
    }

    public void bidWinNotify(Map<String, Object> map) {
    }

    public boolean canAdReuse() {
        int i4 = this.lf;
        return i4 == 0 || i4 == 100;
    }

    public void cancelDownload() {
    }

    public void clearLogoView(View view) {
        if (view != null) {
            view.setVisibility(0);
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).removeAllViews();
            } else if (view instanceof ImageView) {
                ((ImageView) view).setImageDrawable(null);
            }
        }
    }

    public void dislikeClick(String str, Map<String, Object> map) {
    }

    public String getActionText() {
        return this.ia;
    }

    public String getAdDescription() {
        return this.f27685w;
    }

    public String getAdExtra() {
        return this.f27668b;
    }

    public long getAdId() {
        return 0L;
    }

    @Deprecated
    public View getAdLogoView() {
        return null;
    }

    public String getAdNetWorkName() {
        return this.zr;
    }

    public int getAdNetworkPlatformId() {
        return this.f27670e;
    }

    public String getAdNetworkSlotId() {
        return this.mu;
    }

    public int getAdNetworkSlotType() {
        return this.lf;
    }

    public String getAdTitle() {
        return this.f27669c;
    }

    public int getAdType() {
        return this.gb;
    }

    public View getAdView() {
        return null;
    }

    public String getAdnName() {
        return TextUtils.isEmpty(this.zr) ? this.zt : this.zr;
    }

    public String getAid() {
        return this.bm;
    }

    public Map<String, Object> getAppInfoExtra() {
        return this.wx;
    }

    public String getAppName() {
        return this.ba;
    }

    public int getAppSize() {
        return this.f27677m;
    }

    public String getAuthorName() {
        return this.f27687y;
    }

    public double getBiddingCpmWithOutExchangeRate() {
        if (isServerBiddingAd()) {
            if (getServerBiddingShowCpm() < 0.0d) {
                return 0.0d;
            }
            return getServerBiddingShowCpm();
        }
        return this.f27680q;
    }

    public double getCpm() {
        try {
        } catch (NumberFormatException e4) {
            e4.printStackTrace();
        }
        if (isServerBiddingAd()) {
            if (getServerBiddingShowCpm() < 0.0d) {
                return 0.0d;
            }
            return getServerBiddingShowCpm();
        }
        if (isClientBiddingAd() || isMultiBiddingAd()) {
            return this.f27680q * Double.valueOf(this.tl).doubleValue();
        }
        return this.f27680q;
    }

    public long getCreativeId() {
        return 0L;
    }

    public String getCustomAdNetWorkName() {
        return this.zt;
    }

    @Override // com.bytedance.msdk.c.xv
    public ev getDislikeDialog(Activity activity) {
        return null;
    }

    @Override // com.bytedance.msdk.c.xv
    public ev getDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        return null;
    }

    @Override // com.bytedance.msdk.c.xv
    public com.bytedance.sdk.openadsdk.ys.w.w.sr getDislikeInfo() {
        return null;
    }

    public int getDownloadStatus() {
        return -1;
    }

    public String getErrorMsg() {
        return this.qy;
    }

    public Map<String, Object> getEventMap() {
        return this.zg;
    }

    public String getExchangeRate() {
        return this.tl;
    }

    public final Map<String, Object> getExtraMsg() {
        return this.iw;
    }

    public String getFailCallback() {
        return this.ox;
    }

    public final long getFillTime() {
        return this.lw;
    }

    public String getFunctionDescUrl() {
        return this.gp;
    }

    public com.bytedance.msdk.api.sr.c.r.f getGMNativeCustomVideoReporter() {
        return null;
    }

    public String getIconUrl() {
        return this.xv;
    }

    public int getIfReuseAds() {
        return this.eu;
    }

    public int getImageHeight() {
        return this.f27683t;
    }

    public int getImageMode() {
        return this.f27675j;
    }

    public String getImageUrl() {
        return this.sr;
    }

    public int getImageWidth() {
        return this.ux;
    }

    public List<String> getImages() {
        return this.f27684u;
    }

    public int getInteractionType() {
        return this.ls;
    }

    public boolean getIsAppDownload() {
        return this.f27688z;
    }

    public String getLevelTag() {
        return this.kn;
    }

    public int getLoadSort() {
        return this.bs;
    }

    public Map<String, Object> getMediaExtraInfo() {
        return this.te;
    }

    public int getMediationRitReqType(String str) {
        if (TextUtils.equals(str, this.oo)) {
            return this.up;
        }
        return this.gw;
    }

    public int getMediationRitReqTypeSrc(String str) {
        if (TextUtils.equals(str, this.oo)) {
            return this.mt;
        }
        return this.vc;
    }

    public int[] getMinWindowSize() {
        return null;
    }

    public String getMultiCpm() {
        if (isServerBiddingAd()) {
            return getServerBiddingLoadCpm() < 0.0d ? "-1" : String.valueOf(getServerBiddingLoadCpm());
        }
        return String.valueOf(getCpm());
    }

    public String getNetWorkPlatFormCpm() {
        if (isServerBiddingAd()) {
            return getServerBiddingShowCpm() < 0.0d ? "-1" : String.valueOf(getServerBiddingShowCpm());
        }
        return String.valueOf(getCpm());
    }

    public int getOriginType() {
        return this.au;
    }

    public String getPackageName() {
        return this.f27682s;
    }

    public long getPackageSizeBytes() {
        return this.eq;
    }

    public Map<String, String> getPermissionsMap() {
        return this.yu;
    }

    public String getPermissionsUrl() {
        return this.me;
    }

    public int getPricingType() {
        return this.ng;
    }

    public String getPrivacyAgreement() {
        return this.wv;
    }

    public String getReqId() {
        return null;
    }

    @Deprecated
    public int getSdkNum() {
        return this.f27670e;
    }

    public String getSdkVersion() {
        return this.kk;
    }

    public double getServerBiddingLoadCpm() {
        return this.f27686x;
    }

    public double getServerBiddingShowCpm() {
        return this.bw;
    }

    public int getShowSort() {
        return this.f27672g;
    }

    public String getSource() {
        return this.f27674i;
    }

    public Bitmap getSplashBitMap() {
        return null;
    }

    public View getSplashCardView() {
        return null;
    }

    public View getSplashClickEyeView() {
        return null;
    }

    public double getStarRating() {
        return this.fz;
    }

    public String getStore() {
        return this.ck;
    }

    public int getSubAdType() {
        return this.bj;
    }

    public int getSupportRender() {
        return this.be;
    }

    public String getVersionName() {
        return this.xk;
    }

    public int getVideoHeight() {
        return this.fp;
    }

    public String getVideoUrl() {
        return null;
    }

    public int getVideoWidth() {
        return this.ys;
    }

    public String getWinCallback() {
        return this.wo;
    }

    public boolean hasAppInfo() {
        if (TextUtils.isEmpty(this.ba) && TextUtils.isEmpty(this.f27687y) && this.eq <= 0 && TextUtils.isEmpty(this.me)) {
            Map<String, String> map = this.yu;
            return ((map == null || map.size() <= 0) && TextUtils.isEmpty(this.wv) && TextUtils.isEmpty(this.xk) && TextUtils.isEmpty(this.pr)) ? false : true;
        }
        return true;
    }

    public abstract boolean hasDestroyed();

    public boolean hasDislike() {
        return false;
    }

    public boolean isAdnPreload() {
        return false;
    }

    public boolean isCacheSuccess() {
        return this.eb;
    }

    public boolean isClickListenRepeatOnce() {
        if (this.oh) {
            return true;
        }
        this.oh = true;
        return false;
    }

    public boolean isClickListenRepeatPlayAgainOnce() {
        if (this.fm) {
            return true;
        }
        this.fm = true;
        return false;
    }

    public boolean isClientBiddingAd() {
        return this.lf == 1;
    }

    public boolean isCustomAd() {
        return this instanceof com.bytedance.msdk.api.sr.c.w.xv;
    }

    public boolean isExpressAd() {
        return this.f27678n;
    }

    public boolean isHasShown() {
        return this.rh;
    }

    public boolean isIsCallback() {
        return this.ta;
    }

    public boolean isMultiBiddingAd() {
        return this.lf == 3;
    }

    public boolean isNormalAd() {
        return this.lf == 0;
    }

    public boolean isPAd() {
        return this.lf == 100;
    }

    public final boolean isReady(String str) {
        MediationConstant.AdIsReadyStatus isReadyStatus = isReadyStatus();
        if (isReadyStatus == MediationConstant.AdIsReadyStatus.ADN_NO_READY_API) {
            return !com.bytedance.msdk.core.ux.c.c.c().c(str, this);
        }
        return isReadyStatus == MediationConstant.AdIsReadyStatus.AD_IS_READY;
    }

    public MediationConstant.AdIsReadyStatus isReadyStatus() {
        return MediationConstant.AdIsReadyStatus.ADN_NO_READY_API;
    }

    public boolean isServerBiddingAd() {
        return this.lf == 2;
    }

    public boolean isShowListenRepeatOnce() {
        if (this.f27673h) {
            return true;
        }
        this.f27673h = true;
        return false;
    }

    public boolean isShowRepeatOnce() {
        if (this.ok) {
            return true;
        }
        this.ok = true;
        return false;
    }

    public boolean isTimeoutFill() {
        return this.ge;
    }

    public boolean isUseCustomVideo() {
        return this.xu;
    }

    public void onDestroy() {
        this.f27671f = null;
        this.f27681r = null;
        this.ev = null;
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void pauseAppDownload() {
    }

    public void putEventParam(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        this.zg.put(str, obj);
    }

    public void putEventParams(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        this.zg.putAll(map);
    }

    public void putExtraMsg(String str, Object obj) {
        if (TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        this.iw.put(str, obj);
    }

    public void registerViewForInteraction(@NonNull ViewGroup viewGroup, List<View> list, List<View> list2, k kVar) {
        c(viewGroup, kVar);
    }

    public void removeSelfFromParent(View view) {
        if (view != null) {
            try {
                ViewParent parent = view.getParent();
                if (parent == null || !(parent instanceof ViewGroup)) {
                    return;
                }
                ((ViewGroup) parent).removeView(view);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    public void render() {
    }

    public void resumeAppDownload() {
    }

    public void setActionText(String str) {
        this.ia = str;
    }

    public void setAdDescription(String str) {
        this.f27685w = str;
    }

    public void setAdExtra(String str) {
        this.f27668b = str;
    }

    public void setAdNetWorkName(String str) {
        this.zr = str;
    }

    public void setAdNetworkSlotId(String str) {
        this.mu = str;
    }

    public void setAdNetworkSlotType(int i4) {
        this.lf = i4;
    }

    public void setAdType(int i4) {
        this.gb = i4;
    }

    public void setAid(String str) {
        this.bm = str;
    }

    public void setAppInfoExtra(Map<String, Object> map) {
        this.wx = map;
    }

    public void setAppName(String str) {
        this.ba = str;
    }

    public void setAppSize(int i4) {
        this.f27677m = i4;
    }

    public void setAuthorName(String str) {
        this.f27687y = str;
    }

    public void setCacheSuccess(boolean z3) {
        this.eb = z3;
    }

    public void setCpm(double d4) {
        this.f27680q = d4;
    }

    public void setCustomAdNetWorkName(String str) {
        this.zt = str;
    }

    @Override // com.bytedance.msdk.c.xv
    public void setDislikeCallback(Activity activity, com.bytedance.sdk.openadsdk.s.c.w.c.c cVar) {
    }

    @Override // com.bytedance.msdk.c.xv
    public void setDislikeDialog(Dialog dialog) {
    }

    public void setErrorMsg(String str) {
        this.qy = str;
    }

    public void setExchangeRate(String str) {
        this.tl = str;
    }

    public void setExpressAd(boolean z3) {
        this.f27678n = z3;
    }

    public void setFailCallback(String str) {
        this.ox = str;
    }

    public final void setFillTime(long j4) {
        if (this.lw == 0) {
            this.lw = j4;
        }
    }

    public void setFunctionDescUrl(String str) {
        this.gp = str;
    }

    public void setGMDrawAdListener(com.bytedance.msdk.api.sr.c.xv.w wVar) {
        this.f27676k = wVar;
    }

    public void setGMVideoRewardListener(p pVar) {
        this.f27679p = pVar;
    }

    public void setGmShakeViewListener(com.bytedance.msdk.api.sr.c.sr srVar) {
        this.gd = srVar;
    }

    public void setHasShown(boolean z3) {
        this.rh = z3;
    }

    public void setIconUrl(String str) {
        this.xv = str;
    }

    public void setIfReuseAds(int i4) {
        this.eu = i4;
    }

    public void setImageHeight(int i4) {
        this.f27683t = i4;
    }

    public void setImageMode(int i4) {
        this.f27675j = i4;
    }

    public void setImageUrl(String str) {
        this.sr = str;
    }

    public void setImageWidth(int i4) {
        this.ux = i4;
    }

    public void setImages(List<String> list) {
        if (list != null) {
            this.f27684u.addAll(list);
        }
    }

    public void setInteractionType(int i4) {
        this.ls = i4;
    }

    public void setIsAppDownload(boolean z3) {
        this.f27688z = z3;
    }

    public void setIsCallback(boolean z3) {
        this.ta = z3;
    }

    public void setLevelTag(String str) {
        this.kn = str;
    }

    public void setLinkIdFromRealReq(String str) {
        this.oo = str;
    }

    public void setLoadSort(int i4) {
        this.bs = i4;
    }

    public void setMediaExtraInfo(Map<String, Object> map) {
        if (map != null) {
            this.te.putAll(map);
        }
    }

    public void setMediationRitReqType(int i4) {
        this.gw = i4;
    }

    public void setMediationRitReqTypeFromRealReq(int i4) {
        this.up = i4;
    }

    public void setMediationRitReqTypeSrc(int i4) {
        this.vc = i4;
    }

    public void setMediationRitReqTypeSrcFromRealReq(int i4) {
        this.mt = i4;
    }

    public void setOriginType(int i4) {
        this.au = i4;
    }

    public void setPackageName(String str) {
        this.f27682s = str;
    }

    public void setPackageSizeBytes(long j4) {
        this.eq = j4;
    }

    public void setPermissionsMap(Map<String, String> map) {
        this.yu = map;
    }

    public void setPermissionsUrl(String str) {
        this.me = str;
    }

    public void setPricingType(int i4) {
        this.ng = i4;
    }

    public void setPrivacyAgreement(String str) {
        this.wv = str;
    }

    public void setRating(double d4) {
        this.fz = d4;
    }

    public void setRit(String str) {
        this.xg = str;
    }

    public void setSdkNum(int i4) {
        this.f27670e = i4;
    }

    public void setSdkVersion(String str) {
        this.kk = str;
    }

    public void setServerBiddingLoadCpm(double d4) {
        this.f27686x = d4;
    }

    public void setServerBiddingShowCpm(double d4) {
        this.bw = d4;
    }

    public void setShowSort(int i4) {
        this.f27672g = i4;
    }

    public void setSource(String str) {
        this.f27674i = str;
    }

    public void setStore(String str) {
        this.ck = str;
    }

    public void setSubAdType(int i4) {
        this.bj = i4;
    }

    public void setSupportRender(int i4) {
        this.be = i4;
    }

    public void setTTAdAppDownloadListener(com.bytedance.msdk.api.sr.c.w wVar) {
        this.ev = wVar;
    }

    public void setTTAdatperCallback(f fVar) {
        this.f27667a = fVar;
    }

    public void setTTAdatperRewardPlayAgainCallback(f fVar) {
        this.bk = fVar;
    }

    public void setTTNativeAdListener(com.bytedance.msdk.api.sr.c.r.xv xvVar) {
        this.f27671f = xvVar;
    }

    public void setTTVideoListener(gd gdVar) {
        this.f27681r = gdVar;
    }

    public void setTimeoutFill(boolean z3) {
        this.ge = z3;
    }

    public void setTitle(String str) {
        this.f27669c = str;
    }

    public void setUseCustomVideo(boolean z3) {
        this.xu = z3;
    }

    public void setVersionName(String str) {
        this.xk = str;
    }

    public void setVideoHeight(int i4) {
        this.fp = i4;
    }

    public void setVideoWidth(int i4) {
        this.ys = i4;
    }

    public void setWinCallback(String str) {
        this.wo = str;
    }

    public void showAd(Activity activity, TTAdConstant.RitScenes ritScenes, String str) {
    }

    public void showMinWindow(Rect rect, f fVar) {
    }

    public void showSplashAd(ViewGroup viewGroup) {
    }

    public void showSplashCardView(ViewGroup viewGroup, Activity activity) {
    }

    public void showSplashClickEyeView(ViewGroup viewGroup) {
    }

    public void splashMinWindowAnimationFinish() {
    }

    public void unregisterView() {
    }

    @Override // com.bytedance.msdk.c.xv
    public void uploadDislikeEvent(String str) {
    }

    @Override // java.lang.Comparable
    public int compareTo(ux uxVar) {
        if (uxVar != null && this.bs <= uxVar.getLoadSort()) {
            if (this.bs < uxVar.getLoadSort()) {
                return -1;
            }
            if (this.f27672g > uxVar.getShowSort()) {
                return 1;
            }
            return this.f27672g < uxVar.getShowSort() ? -1 : 0;
        }
        return 1;
    }

    public void registerViewForInteraction(@NonNull Activity activity, @NonNull ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, k kVar) {
        if (list3 != null) {
            if (list2 == null) {
                list2 = new ArrayList<>();
            }
            list2.addAll(list3);
        }
        c(viewGroup, kVar);
    }

    public void putExtraMsg(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        this.iw.putAll(map);
    }

    private void c(@NonNull ViewGroup viewGroup) {
        try {
            FrameLayout frameLayout = (FrameLayout) viewGroup;
            if (frameLayout.getChildCount() == 0) {
                return;
            }
            int i4 = 0;
            if (getAdNetworkPlatformId() != 3 && (frameLayout.getChildAt(0) instanceof ViewGroup)) {
                ViewGroup viewGroup2 = (ViewGroup) frameLayout.getChildAt(0);
                if ("tt_gdt_developer_view_root".equals(viewGroup2.getTag(R.id.tt_mediation_gdt_developer_view_root_tag_key))) {
                    frameLayout.removeView(viewGroup2);
                    int i5 = 0;
                    while (i5 < viewGroup2.getChildCount()) {
                        View childAt = viewGroup2.getChildAt(i5);
                        if (childAt != null) {
                            Object tag = childAt.getTag(R.id.tt_mediation_gdt_developer_view_tag_key);
                            if ((tag instanceof String) && tag.equals("tt_gdt_developer_view")) {
                                viewGroup2.removeView(childAt);
                                frameLayout.addView(childAt, childAt.getLayoutParams());
                            }
                        }
                        i5++;
                    }
                }
            }
            if (getAdNetworkPlatformId() == 2 || !(frameLayout.getChildAt(0) instanceof ViewGroup)) {
                return;
            }
            ViewGroup viewGroup3 = (ViewGroup) frameLayout.getChildAt(0);
            if ("tt_admob_native_view_root_tag".equals(viewGroup3.getTag(R.id.tt_mediation_admob_developer_view_root_tag_key))) {
                frameLayout.removeView(viewGroup3);
                while (i4 < viewGroup3.getChildCount()) {
                    View childAt2 = viewGroup3.getChildAt(i4);
                    if (childAt2 != null) {
                        Object tag2 = childAt2.getTag(R.id.tt_mediation_admob_developer_view_tag_key);
                        if ((tag2 instanceof String) && tag2.equals("tt_admob_native_view_tag")) {
                            viewGroup3.removeView(childAt2);
                            frameLayout.addView(childAt2, childAt2.getLayoutParams());
                        }
                    }
                    i4++;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
