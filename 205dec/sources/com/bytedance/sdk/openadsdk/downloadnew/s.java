package com.bytedance.sdk.openadsdk.downloadnew;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.api.ok.h;
import com.bytedance.sdk.openadsdk.api.ok.kf;
import com.bytedance.sdk.openadsdk.api.ok.n;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.download.api.model.s;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public final class s implements Bridge {
    private static volatile s ok;

    /* renamed from: a  reason: collision with root package name */
    private final Context f35816a;
    private AdDownloadModel.Builder bl;

    /* renamed from: h  reason: collision with root package name */
    private AdDownloadEventConfig.Builder f35817h;
    private AdDownloadController kf;

    /* renamed from: n  reason: collision with root package name */
    private AdDownloadController.Builder f35818n;

    /* renamed from: p  reason: collision with root package name */
    private AdDownloadEventConfig f35819p;

    /* renamed from: s  reason: collision with root package name */
    private AdDownloadModel f35820s;

    private s(Context context) {
        this.f35816a = context;
    }

    private void a(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        AdDownloadModel.Builder ok2 = ok(((Long) map.get("id")).longValue(), (String) map.get("appIcon"), ((Boolean) map.get("isShowNotification")).booleanValue(), ((Boolean) map.get("isAutoInstallWithoutNotification")).booleanValue(), (String) map.get("logExtra"), (JSONObject) map.get("extraJson"), (JSONObject) map.get("downloadSettings"), (String) map.get("filePath"), (String) map.get("downloadUrl"), (String) map.get("appName"), (String) map.get("packageName"), ((Boolean) map.get("isNeedIndependentProcess")).booleanValue(), (String) map.get("openUrl"), (String) map.get("webTitle"), (String) map.get("webUrl"));
        this.bl = ok2;
        this.f35820s = ok2.build();
    }

    private DownloadStatusChangeListener bl(Object obj) {
        if (obj instanceof DownloadStatusChangeListener) {
            return (DownloadStatusChangeListener) obj;
        }
        if (obj instanceof EventListener) {
            return new n((EventListener) obj);
        }
        return null;
    }

    private Activity getActivity(Object obj) {
        if (obj instanceof Activity) {
            return (Activity) obj;
        }
        return null;
    }

    private ExitInstallListener h(Object obj) {
        if (obj instanceof ExitInstallListener) {
            return (ExitInstallListener) obj;
        }
        return null;
    }

    private DownloadController kf(Object obj) {
        if (obj instanceof DownloadController) {
            return (DownloadController) obj;
        }
        return null;
    }

    private DownloadEventConfig n(Object obj) {
        if (obj instanceof DownloadEventConfig) {
            return (DownloadEventConfig) obj;
        }
        return null;
    }

    public static s ok(Context context) {
        if (ok == null) {
            synchronized (s.class) {
                if (ok == null) {
                    ok = new s(context);
                }
            }
        }
        return ok;
    }

    private static boolean ok(IDownloadButtonClickListener iDownloadButtonClickListener) {
        return iDownloadButtonClickListener != null;
    }

    private OnItemClickListener p(Object obj) {
        if (obj instanceof OnItemClickListener) {
            return (OnItemClickListener) obj;
        }
        if (obj instanceof EventListener) {
            return new h((EventListener) obj);
        }
        return null;
    }

    private IDownloadButtonClickListener q(Object obj) {
        if (obj instanceof IDownloadButtonClickListener) {
            return (IDownloadButtonClickListener) obj;
        }
        if (obj instanceof EventListener) {
            return new kf((EventListener) obj);
        }
        return null;
    }

    private int qa() {
        AdDownloadController adDownloadController = this.kf;
        if (adDownloadController == null) {
            return 0;
        }
        return adDownloadController.getDownloadMode();
    }

    private DownloadModel s(Object obj) {
        if (obj instanceof DownloadModel) {
            return (DownloadModel) obj;
        }
        return null;
    }

    public String ah() {
        AdDownloadModel adDownloadModel = this.f35820s;
        return adDownloadModel == null ? "" : adDownloadModel.getMimeType();
    }

    public boolean az() {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return false;
        }
        return adDownloadModel.distinctDir();
    }

    public boolean b() {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return true;
        }
        return adDownloadModel.isAutoInstall();
    }

    public JSONObject c() {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getExtra();
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        Map<String, Object> hashMap;
        if (i4 == 20) {
            ok((Bundle) valueSet.objectValue(0, Bundle.class));
            return null;
        }
        if (valueSet != null && valueSet.objectValue(0, Map.class) != null) {
            hashMap = (Map) valueSet.objectValue(0, Map.class);
        } else {
            hashMap = new HashMap<>();
        }
        return (T) ok(cls, i4, hashMap);
    }

    public void cf() {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.forceHideNotification();
    }

    public String cs() {
        AdDownloadModel adDownloadModel = this.f35820s;
        return adDownloadModel == null ? "" : adDownloadModel.getFileName();
    }

    public DeepLink d() {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getDeepLink();
    }

    public String de() {
        AdDownloadModel adDownloadModel = this.f35820s;
        return adDownloadModel == null ? "" : adDownloadModel.getVersionName();
    }

    public boolean dn() {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return true;
        }
        return adDownloadModel.isAd();
    }

    public void dx() {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.forceHideToast();
    }

    public long e() {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return 0L;
        }
        return adDownloadModel.getExpectFileLength();
    }

    public boolean ej() {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return false;
        }
        return adDownloadModel.isInExternalPublicDir();
    }

    public String em() {
        AdDownloadModel adDownloadModel = this.f35820s;
        return adDownloadModel == null ? "" : adDownloadModel.getDownloadUrl();
    }

    public Object ep() {
        AdDownloadEventConfig adDownloadEventConfig = this.f35819p;
        if (adDownloadEventConfig == null) {
            return null;
        }
        return adDownloadEventConfig.getExtraEventObject();
    }

    public boolean er() {
        AdDownloadEventConfig adDownloadEventConfig = this.f35819p;
        if (adDownloadEventConfig == null) {
            return false;
        }
        return adDownloadEventConfig.isEnableV3Event();
    }

    public boolean ew() {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return false;
        }
        return adDownloadModel.needIndependentProcess();
    }

    public com.ss.android.download.api.model.s f() {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getQuickAppModel();
    }

    public JSONObject fb() {
        AdDownloadEventConfig adDownloadEventConfig = this.f35819p;
        if (adDownloadEventConfig == null) {
            return null;
        }
        return adDownloadEventConfig.getExtraJson();
    }

    public long fd() {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return 0L;
        }
        return adDownloadModel.getExtraValue();
    }

    public String fl() {
        AdDownloadModel adDownloadModel = this.f35820s;
        return adDownloadModel == null ? "" : adDownloadModel.getMd5();
    }

    public JSONObject g() {
        AdDownloadEventConfig adDownloadEventConfig = this.f35819p;
        if (adDownloadEventConfig == null) {
            return null;
        }
        return adDownloadEventConfig.getParamsJson();
    }

    public int hd() {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return 2;
        }
        return adDownloadModel.getExecutorGroup();
    }

    public boolean i() {
        AdDownloadController adDownloadController = this.kf;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.enableOppoAutoDownload();
    }

    public String io() {
        AdDownloadEventConfig adDownloadEventConfig = this.f35819p;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getClickStartLabel();
    }

    public boolean j() {
        AdDownloadController adDownloadController = this.kf;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.isAutoDownloadOnCardShow();
    }

    public String je() {
        AdDownloadModel adDownloadModel = this.f35820s;
        return adDownloadModel == null ? "" : adDownloadModel.getStartToast();
    }

    public boolean jl() {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return true;
        }
        return adDownloadModel.enablePause();
    }

    public String ju() {
        AdDownloadModel adDownloadModel = this.f35820s;
        return adDownloadModel == null ? "" : adDownloadModel.getAppIcon();
    }

    public Object k() {
        AdDownloadController adDownloadController = this.kf;
        if (adDownloadController == null) {
            return null;
        }
        return adDownloadController.getExtraObject();
    }

    public boolean kz() {
        AdDownloadEventConfig adDownloadEventConfig = this.f35819p;
        if (adDownloadEventConfig == null) {
            return true;
        }
        return adDownloadEventConfig.isEnableClickEvent();
    }

    public Map<String, String> l() {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getHeaders();
    }

    public String ld() {
        AdDownloadModel adDownloadModel = this.f35820s;
        return adDownloadModel == null ? "" : adDownloadModel.getPackageName();
    }

    public String m() {
        AdDownloadEventConfig adDownloadEventConfig = this.f35819p;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getStorageDenyLabel();
    }

    public String o() {
        AdDownloadEventConfig adDownloadEventConfig = this.f35819p;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getClickPauseLabel();
    }

    public boolean pb() {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return false;
        }
        return adDownloadModel.autoInstallWithoutNotification();
    }

    public boolean qh() {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return com.ss.android.download.api.bl.a.ok(com.ss.android.socialbase.downloader.h.ok.ok(tg()), ah());
        }
        return adDownloadModel.shouldDownloadWithPatchApply();
    }

    public String qu() {
        AdDownloadModel adDownloadModel = this.f35820s;
        return adDownloadModel == null ? "" : adDownloadModel.getNotificationJumpUrl();
    }

    public boolean qx() {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return false;
        }
        return adDownloadModel.isInExternalPublicDir();
    }

    public boolean r() {
        AdDownloadController adDownloadController = this.kf;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.enableShowComplianceDialog();
    }

    public boolean rh() {
        AdDownloadController adDownloadController = this.kf;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.enableAH();
    }

    public int ry() {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return 0;
        }
        return adDownloadModel.getVersionCode();
    }

    public List<String> sg() {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getBackupUrls();
    }

    public String sj() {
        AdDownloadModel adDownloadModel = this.f35820s;
        return adDownloadModel == null ? "" : adDownloadModel.getStartToast();
    }

    public List<String> sr() {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getClickTrackUrl();
    }

    public boolean t() {
        AdDownloadController adDownloadController = this.kf;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.enableAM();
    }

    public String td() {
        AdDownloadEventConfig adDownloadEventConfig = this.f35819p;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getClickButtonTag();
    }

    public JSONObject tg() {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getDownloadSettings();
    }

    public String to() {
        AdDownloadModel adDownloadModel = this.f35820s;
        return adDownloadModel == null ? "" : adDownloadModel.getLogExtra();
    }

    public String tr() {
        AdDownloadModel adDownloadModel = this.f35820s;
        return adDownloadModel == null ? "" : adDownloadModel.getFilePath();
    }

    public String u() {
        AdDownloadEventConfig adDownloadEventConfig = this.f35819p;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getClickLabel();
    }

    public String ul() {
        AdDownloadEventConfig adDownloadEventConfig = this.f35819p;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getClickPauseLabel();
    }

    public long v() {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return 0L;
        }
        return adDownloadModel.getId();
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return com.bykv.ok.ok.ok.ok.a.b().i(0, bl.ok).h(1, Boolean.valueOf(bl.f35805a)).f(10000, 3).a();
    }

    public boolean vk() {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return true;
        }
        return adDownloadModel.isShowNotification();
    }

    public int vz() {
        AdDownloadEventConfig adDownloadEventConfig = this.f35819p;
        if (adDownloadEventConfig == null) {
            return 0;
        }
        return adDownloadEventConfig.getDownloadScene();
    }

    public void w() {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.forceWifi();
    }

    public boolean wv() {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return true;
        }
        return adDownloadModel.isShowToast();
    }

    public String x() {
        AdDownloadEventConfig adDownloadEventConfig = this.f35819p;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getRefer();
    }

    public int xh() {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return 1;
        }
        return adDownloadModel.getFunnelType();
    }

    public String xy() {
        AdDownloadModel adDownloadModel = this.f35820s;
        return adDownloadModel == null ? "" : adDownloadModel.getName();
    }

    public String y() {
        AdDownloadEventConfig adDownloadEventConfig = this.f35819p;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getClickInstallLabel();
    }

    public boolean yt() {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return false;
        }
        return adDownloadModel.isNeedWifi();
    }

    public int yz() {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return 0;
        }
        return adDownloadModel.getModelType();
    }

    public boolean z() {
        AdDownloadController adDownloadController = this.kf;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.enableNewActivity();
    }

    public String zz() {
        AdDownloadEventConfig adDownloadEventConfig = this.f35819p;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getClickItemTag();
    }

    private void k(boolean z3) {
        AdDownloadController adDownloadController = this.kf;
        if (adDownloadController == null) {
            return;
        }
        try {
            adDownloadController.setEnableOppoAutoDownload(z3);
        } catch (Throwable unused) {
        }
    }

    private void kf(int i4) {
        AdDownloadController adDownloadController = this.kf;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setDownloadMode(i4);
    }

    private void n(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        int intValue = ((Integer) map.get("downloadScene")).intValue();
        boolean booleanValue = ((Boolean) map.get("isEnableClickEvent")).booleanValue();
        boolean booleanValue2 = ((Boolean) map.get("isEnableV3Event")).booleanValue();
        JSONObject jSONObject = (JSONObject) map.get("extraEventObject");
        AdDownloadEventConfig.Builder paramsJson = new AdDownloadEventConfig.Builder().setClickButtonTag((String) map.get("clickButtonTag")).setClickItemTag((String) map.get("clickItemTag")).setClickLabel((String) map.get("clickLabel")).setClickStartLabel((String) map.get("clickStartLabel")).setClickContinueLabel((String) map.get("clickContinueLabel")).setClickPauseLabel((String) map.get("clickPauseLabel")).setStorageDenyLabel((String) map.get("storageDenyLabel")).setClickInstallLabel((String) map.get("clickInstallLabel")).setIsEnableClickEvent(booleanValue).setDownloadScene(intValue).setIsEnableV3Event(booleanValue2).setRefer((String) map.get("refer")).setExtraJson((JSONObject) map.get("extraJson")).setParamsJson((JSONObject) map.get("paramsJson"));
        this.f35817h = paramsJson;
        if (jSONObject != null) {
            paramsJson.setExtraEventObject(jSONObject);
        }
        this.f35819p = this.f35817h.build();
    }

    private void s(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        boolean booleanValue = ((Boolean) map.get("isEnableClickEvent")).booleanValue();
        boolean booleanValue2 = ((Boolean) map.get("isEnableV3Event")).booleanValue();
        JSONObject jSONObject = (JSONObject) map.get("extraEventObject");
        AdDownloadEventConfig.Builder isEnableV3Event = new AdDownloadEventConfig.Builder().setClickButtonTag((String) map.get("clickButtonTag")).setClickItemTag((String) map.get("clickItemTag")).setClickStartLabel((String) map.get("clickStartLabel")).setClickContinueLabel((String) map.get("clickContinueLabel")).setClickPauseLabel((String) map.get("clickPauseLabel")).setStorageDenyLabel((String) map.get("storageDenyLabel")).setClickInstallLabel((String) map.get("clickInstallLabel")).setIsEnableClickEvent(booleanValue).setIsEnableV3Event(booleanValue2);
        this.f35817h = isEnableV3Event;
        if (jSONObject != null) {
            isEnableV3Event.setExtraEventObject(jSONObject);
        }
        this.f35819p = this.f35817h.build();
    }

    public boolean h() {
        AdDownloadController adDownloadController = this.kf;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.shouldUseNewWebView();
    }

    public AdDownloadModel i(String str) {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setFileName(str);
    }

    public AdDownloadModel j(String str) {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setDownloadUrl(str);
    }

    public AdDownloadModel r(String str) {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setAppIcon(str);
    }

    public AdDownloadModel rh(String str) {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setMimeType(str);
    }

    public AdDownloadModel t(String str) {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setFilePath(str);
    }

    public AdDownloadModel x(String str) {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setVersionName(str);
    }

    public AdDownloadModel z(String str) {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setNotificationJumpUrl(str);
    }

    private void bl(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        int intValue = ((Integer) map.get("linkMode")).intValue();
        int intValue2 = ((Integer) map.get("downloadMode")).intValue();
        boolean booleanValue = ((Boolean) map.get("isEnableBackDialog")).booleanValue();
        boolean booleanValue2 = ((Boolean) map.get("isAddToDownloadManage")).booleanValue();
        Object obj = map.get("extraOperation");
        boolean booleanValue3 = ((Boolean) map.get("shouldUseNewWebView")).booleanValue();
        int intValue3 = ((Integer) map.get("interceptFlag")).intValue();
        Object obj2 = map.get("extraObject");
        boolean booleanValue4 = ((Boolean) map.get("enableShowComplianceDialog")).booleanValue();
        boolean booleanValue5 = ((Boolean) map.get("isAutoDownloadOnCardShow")).booleanValue();
        boolean booleanValue6 = ((Boolean) map.get("enableNewActivity")).booleanValue();
        boolean booleanValue7 = ((Boolean) map.get("isEnableAH")).booleanValue();
        boolean booleanValue8 = ((Boolean) map.get("isEnableAM")).booleanValue();
        AdDownloadController.Builder enableOppoAutoDownload = new AdDownloadController.Builder().setLinkMode(intValue).setDownloadMode(intValue2).setIsEnableBackDialog(booleanValue).setIsAddToDownloadManage(booleanValue2).setExtraOperation(obj).setShouldUseNewWebView(booleanValue3).setInterceptFlag(intValue3).setExtraJson((JSONObject) map.get("extraJson")).setExtraObject(obj2).setEnableShowComplianceDialog(booleanValue4).setIsAutoDownloadOnCardShow(booleanValue5).setEnableNewActivity(booleanValue6).setEnableAH(booleanValue7).setEnableAM(booleanValue8).setEnableOppoAutoDownload(((Boolean) map.get("isEnableOppoAutoDownload")).booleanValue());
        this.f35818n = enableOppoAutoDownload;
        this.kf = enableOppoAutoDownload.build();
    }

    public void h(String str) {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setStartToast(str);
    }

    public AdDownloadModel k(String str) {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setPackageName(str);
    }

    public int kf() {
        AdDownloadController adDownloadController = this.kf;
        if (adDownloadController == null) {
            return 1;
        }
        return adDownloadController.getDowloadChunkCount();
    }

    public int p() {
        AdDownloadController adDownloadController = this.kf;
        if (adDownloadController == null) {
            return 0;
        }
        return adDownloadController.getInterceptFlag();
    }

    public JSONObject q() {
        AdDownloadController adDownloadController = this.kf;
        if (adDownloadController == null) {
            return null;
        }
        return adDownloadController.getExtraJson();
    }

    private void kf(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        long longValue = ((Long) map.get("expectFileLength")).longValue();
        long longValue2 = ((Long) map.get("extraValue")).longValue();
        boolean booleanValue = ((Boolean) map.get("isAd")).booleanValue();
        int intValue = ((Integer) map.get("modelType")).intValue();
        String str = (String) map.get("mimeType");
        Map<String, String> map2 = (Map) map.get("headers");
        boolean booleanValue2 = ((Boolean) map.get("isShowToast")).booleanValue();
        boolean booleanValue3 = ((Boolean) map.get("needWifi")).booleanValue();
        String str2 = (String) map.get("fileName");
        int intValue2 = ((Integer) map.get("versionCode")).intValue();
        String str3 = (String) map.get("versionName");
        com.ss.android.download.api.model.s ok2 = new s.ok().ok((String) map.get("quickAppModelOpenUrl")).a((String) map.get("quickAppModelExtraData")).ok();
        int intValue3 = ((Integer) map.get("executorGroup")).intValue();
        String str4 = (String) map.get("startToast");
        String str5 = (String) map.get("sdkMonitorScene");
        boolean booleanValue4 = ((Boolean) map.get("autoInstall")).booleanValue();
        boolean booleanValue5 = ((Boolean) map.get("distinctDir")).booleanValue();
        boolean booleanValue6 = ((Boolean) map.get("enablePause")).booleanValue();
        long longValue3 = ((Long) map.get("id")).longValue();
        boolean booleanValue7 = ((Boolean) map.get("isShowNotification")).booleanValue();
        boolean booleanValue8 = ((Boolean) map.get("isAutoInstallWithoutNotification")).booleanValue();
        JSONObject jSONObject = (JSONObject) map.get("extraJson");
        JSONObject jSONObject2 = (JSONObject) map.get("downloadSettings");
        String str6 = (String) map.get("filePath");
        String str7 = (String) map.get("downloadUrl");
        String str8 = (String) map.get("appName");
        String str9 = (String) map.get("packageName");
        boolean booleanValue9 = ((Boolean) map.get("isNeedIndependentProcess")).booleanValue();
        String str10 = (String) map.get("openUrl");
        String str11 = (String) map.get("webTitle");
        String str12 = (String) map.get("webUrl");
        AdDownloadModel.Builder fileUriProvider = new AdDownloadModel.Builder().setExpectFileLength(longValue).setMd5((String) map.get("md5")).setId(longValue3).setExtraValue(longValue2).setIsAd(booleanValue).setModelType(intValue).setLogExtra((String) map.get("logExtra")).setAppIcon((String) map.get("appIcon")).setBackupUrls((List) map.get("backupUrls")).setNotificationJumpUrl((String) map.get("notificationJumpUrl")).setClickTrackUrl((List) map.get("clickTrackUrl")).setMimeType(str).setHeaders(map2).setIsShowToast(booleanValue2).setIsShowNotification(booleanValue7).setNeedWifi(booleanValue3).setFileName(str2).setVersionCode(intValue2).setVersionName(str3).setQuickAppModel(ok2).setAutoInstallWithoutNotification(booleanValue8).setExecutorGroup(intValue3).setStartToast(str4).setSdkMonitorScene(str5).setAutoInstall(booleanValue4).setDistinctDir(booleanValue5).setEnablePause(booleanValue6).setExtra(jSONObject).setFileUriProvider(new IDownloadFileUriProvider() { // from class: com.bytedance.sdk.openadsdk.downloadnew.s.2
            @Override // com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider
            public Uri getUriForFile(String str13, String str14) {
                return null;
            }
        });
        if (jSONObject2 != null) {
            fileUriProvider.setDownloadSettings(jSONObject2);
        }
        if (!TextUtils.isEmpty(str6)) {
            fileUriProvider.setFilePath(str6);
        }
        if (!TextUtils.isEmpty(str7)) {
            fileUriProvider.setDownloadUrl(str7);
        }
        if (!TextUtils.isEmpty(str8)) {
            fileUriProvider.setAppName(str8);
        }
        if (!TextUtils.isEmpty(str9)) {
            fileUriProvider.setPackageName(str9);
        }
        fileUriProvider.setNeedIndependentProcess(booleanValue9);
        fileUriProvider.setDeepLink(ok(longValue3, str10, str11, str12));
        this.f35820s = this.bl.build();
    }

    public AdDownloadModel h(boolean z3) {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setIsShowNotification(z3);
    }

    public <T> T ok(Class<T> cls, int i4, Map<String, Object> map) {
        DownloadModel s3;
        DownloadModel s4;
        DownloadEventConfig n4;
        DownloadController kf;
        DownloadModel s5;
        DownloadEventConfig n5;
        DownloadController kf2;
        DownloadEventConfig n6;
        DownloadController kf3;
        DownloadEventConfig n7;
        DownloadController kf4;
        switch (i4) {
            case 0:
                return (T) Boolean.valueOf(bl.ok(getActivity(map.get("activity")), h(map.get("exitInstallListener"))));
            case 1:
                return (T) bl.ok().kf();
            case 2:
                try {
                    return (T) Boolean.valueOf(bl.ok((String) map.get("tagIntercept"), (String) map.get("label"), new JSONObject((String) map.get("meta")), new HashMap()));
                } catch (JSONException unused) {
                    return (T) Boolean.FALSE;
                }
            case 3:
                bl.ok(((Integer) map.get("hid")).intValue());
                return null;
            case 4:
                AdDownloadModel adDownloadModel = this.f35820s;
                bl.ok().ok(adDownloadModel == null ? (String) map.get("downloadUrl") : adDownloadModel.getDownloadUrl(), ((Integer) map.get("hashCode")).intValue());
                return null;
            case 5:
                int intValue = ((Integer) map.get("hashCode")).intValue();
                AdDownloadModel adDownloadModel2 = this.f35820s;
                if (adDownloadModel2 == null) {
                    s3 = s(map.get("downloadModel"));
                } else {
                    s3 = s(adDownloadModel2);
                }
                bl.ok().ok(this.f35816a, intValue, bl(map.get("downloadStatusChangeListener")), s3);
                return null;
            case 6:
                AdDownloadModel adDownloadModel3 = this.f35820s;
                return (T) Boolean.valueOf(bl.ok(this.f35816a, adDownloadModel3 == null ? (String) map.get("downloadUrl") : adDownloadModel3.getDownloadUrl()));
            case 7:
                bl.a();
                return null;
            case 8:
                AdDownloadModel adDownloadModel4 = this.f35820s;
                bl.ok().ok(adDownloadModel4 == null ? (String) map.get("downloadUrl") : adDownloadModel4.getDownloadUrl(), ((Boolean) map.get("force")).booleanValue());
                return null;
            case 9:
                bl.ok(((Integer) map.get("id")).intValue(), (ITTDownloadAdapter.OnEventLogHandler) map.get("onEventLogHandler"));
                return null;
            case 10:
                bl.ok((String) map.get("downloadPath"));
                return null;
            case 11:
            case 20:
            case 21:
            case 22:
            case 43:
            case 77:
            case 126:
            case 138:
            default:
                return null;
            case 12:
                Uri uri = (Uri) map.get("uri");
                AdDownloadModel adDownloadModel5 = this.f35820s;
                if (adDownloadModel5 == null) {
                    s4 = s(map.get("downloadModel"));
                } else {
                    s4 = s(adDownloadModel5);
                }
                AdDownloadEventConfig adDownloadEventConfig = this.f35819p;
                if (adDownloadEventConfig == null) {
                    n4 = n(map.get("downloadEventConfig"));
                } else {
                    n4 = n(adDownloadEventConfig);
                }
                AdDownloadController adDownloadController = this.kf;
                if (adDownloadController == null) {
                    kf = kf(map.get("downloadController"));
                } else {
                    kf = kf(adDownloadController);
                }
                IDownloadButtonClickListener q3 = q(map.get("downloadButtonClickListener"));
                if (ok(q3)) {
                    return (T) Boolean.valueOf(bl.ok(this.f35816a, uri, s4, n4, kf, q3));
                }
                return (T) Boolean.valueOf(bl.ok(this.f35816a, uri, s4, n4, kf));
            case 13:
                int intValue2 = ((Integer) map.get("hashCode")).intValue();
                boolean booleanValue = ((Boolean) map.get("isDisableDialog")).booleanValue();
                String str = (String) map.get("userAgent");
                AdDownloadModel adDownloadModel6 = this.f35820s;
                if (adDownloadModel6 == null) {
                    s5 = s(map.get("downloadModel"));
                } else {
                    s5 = s(adDownloadModel6);
                }
                DownloadModel downloadModel = s5;
                AdDownloadEventConfig adDownloadEventConfig2 = this.f35819p;
                if (adDownloadEventConfig2 == null) {
                    n5 = n(map.get("downloadEventConfig"));
                } else {
                    n5 = n(adDownloadEventConfig2);
                }
                DownloadEventConfig downloadEventConfig = n5;
                AdDownloadController adDownloadController2 = this.kf;
                if (adDownloadController2 == null) {
                    kf2 = kf(map.get("downloadController"));
                } else {
                    kf2 = kf(adDownloadController2);
                }
                DownloadController downloadController = kf2;
                DownloadStatusChangeListener bl = bl(map.get("downloadStatusChangeListener"));
                IDownloadButtonClickListener q4 = q(map.get("downloadButtonClickListener"));
                if (ok(q4)) {
                    bl.ok().n().ok(this.f35816a, str, booleanValue, downloadModel, downloadEventConfig, downloadController, bl, intValue2, q4);
                    return null;
                }
                bl.ok().n().ok(this.f35816a, str, booleanValue, downloadModel, downloadEventConfig, downloadController, bl, intValue2);
                return null;
            case 14:
                AdDownloadModel adDownloadModel7 = this.f35820s;
                long longValue = adDownloadModel7 == null ? ((Long) map.get("id")).longValue() : adDownloadModel7.getId();
                AdDownloadModel adDownloadModel8 = this.f35820s;
                return (T) Boolean.valueOf(bl.ok().n().ok(this.f35816a, longValue, adDownloadModel8 == null ? (String) map.get("logExtra") : adDownloadModel8.getLogExtra(), (DownloadStatusChangeListener) null, ((Integer) map.get("hashCode")).intValue()));
            case 15:
                return (T) Boolean.valueOf(bl.ok((Uri) map.get("uri")));
            case 16:
                AdDownloadModel adDownloadModel9 = this.f35820s;
                String downloadUrl = adDownloadModel9 == null ? (String) map.get("downloadUrl") : adDownloadModel9.getDownloadUrl();
                AdDownloadModel adDownloadModel10 = this.f35820s;
                long longValue2 = adDownloadModel10 == null ? ((Long) map.get("id")).longValue() : adDownloadModel10.getId();
                int intValue3 = ((Integer) map.get("action_type_button")).intValue();
                AdDownloadEventConfig adDownloadEventConfig3 = this.f35819p;
                if (adDownloadEventConfig3 == null) {
                    n6 = n(map.get("downloadEventConfig"));
                } else {
                    n6 = n(adDownloadEventConfig3);
                }
                DownloadEventConfig downloadEventConfig2 = n6;
                AdDownloadController adDownloadController3 = this.kf;
                if (adDownloadController3 == null) {
                    kf3 = kf(map.get("downloadController"));
                } else {
                    kf3 = kf(adDownloadController3);
                }
                bl.ok().ok(downloadUrl, longValue2, intValue3, downloadEventConfig2, kf3);
                return null;
            case 17:
                AdDownloadModel adDownloadModel11 = this.f35820s;
                String downloadUrl2 = adDownloadModel11 == null ? (String) map.get("downloadUrl") : adDownloadModel11.getDownloadUrl();
                long longValue3 = ((Long) map.get("id")).longValue();
                int intValue4 = ((Integer) map.get("action_type_button")).intValue();
                AdDownloadEventConfig adDownloadEventConfig4 = this.f35819p;
                if (adDownloadEventConfig4 == null) {
                    n7 = n(map.get("downloadEventConfig"));
                } else {
                    n7 = n(adDownloadEventConfig4);
                }
                DownloadEventConfig downloadEventConfig3 = n7;
                AdDownloadController adDownloadController4 = this.kf;
                if (adDownloadController4 == null) {
                    kf4 = kf(map.get("downloadController"));
                } else {
                    kf4 = kf(adDownloadController4);
                }
                bl.ok().ok(downloadUrl2, longValue3, intValue4, downloadEventConfig3, kf4, p(map.get("itemClickListener")), q(map.get("downloadButtonClickListener")));
                return null;
            case 18:
                AdDownloadModel adDownloadModel12 = this.f35820s;
                return (T) Boolean.valueOf(bl.ok().n().ok(adDownloadModel12 == null ? ((Long) map.get("id")).longValue() : adDownloadModel12.getId(), ((Integer) map.get("hashCode")).intValue()));
            case 19:
                AdDownloadModel adDownloadModel13 = this.f35820s;
                return (T) Boolean.valueOf(bl.ok().n().ok(adDownloadModel13 == null ? ((Long) map.get("id")).longValue() : adDownloadModel13.getId()));
            case 23:
                if (((Boolean) map.get("mateIsEmpty")).booleanValue()) {
                    AdDownloadModel.Builder builder = new AdDownloadModel.Builder();
                    this.bl = builder;
                    this.f35820s = builder.build();
                    return null;
                }
                a(map);
                return null;
            case 24:
                ok((String) map.get("appIcon"), (String) map.get("appName"), (String) map.get("packageName"));
                return null;
            case 25:
                ok(((Integer) map.get("autoOpen")).intValue(), ((Integer) map.get("downloadMode")).intValue(), ((Boolean) map.get("isHaveDownloadSdkConfig")).booleanValue(), ((Boolean) map.get("isEnableAH")).booleanValue(), ((Boolean) map.get("isEnableAM")).booleanValue());
                return null;
            case 26:
                kf(((Integer) map.get("downloadMode")).intValue());
                return null;
            case 27:
                return (T) Integer.valueOf(qa());
            case 28:
                k(((Boolean) map.get("isEnableOppoAutoDownload")).booleanValue());
                return null;
            case 29:
                s(map);
                return null;
            case 30:
                a(((Integer) map.get("downloadScene")).intValue());
                return null;
            case 31:
                n(((Boolean) map.get("isShowToast")).booleanValue());
                return null;
            case 32:
                bl(map);
                return null;
            case 33:
                return (T) Integer.valueOf(ok());
            case 34:
                return (T) Boolean.valueOf(a());
            case 35:
                return (T) Boolean.valueOf(bl());
            case 36:
                return (T) s();
            case 37:
                return (T) Boolean.valueOf(n());
            case 38:
                return (T) Integer.valueOf(kf());
            case 39:
                return (T) Boolean.valueOf(h());
            case 40:
                return (T) Integer.valueOf(p());
            case 41:
                return (T) q();
            case 42:
                return (T) k();
            case 44:
                ok(((Integer) map.get("linkMode")).intValue());
                return null;
            case 45:
                return (T) Boolean.valueOf(r());
            case 46:
                ok(((Boolean) map.get("enableShowComplianceDialog")).booleanValue());
                return null;
            case 47:
                return (T) Boolean.valueOf(j());
            case 48:
                return (T) Boolean.valueOf(z());
            case 49:
                a(((Boolean) map.get("isAutoDownloadOnCardShow")).booleanValue());
                return null;
            case 50:
                bl(((Boolean) map.get("enableNewActivity")).booleanValue());
                return null;
            case 51:
                return (T) Boolean.valueOf(rh());
            case 52:
                return (T) Boolean.valueOf(t());
            case 53:
                ok(map.get("extraObject"));
                return null;
            case 54:
                ok((JSONObject) map.get("extraJson"));
                return null;
            case 55:
                return (T) Boolean.valueOf(i());
            case 56:
                n(map);
                return null;
            case 57:
                return (T) String.valueOf(x());
            case 58:
                return (T) String.valueOf(td());
            case 59:
                return (T) String.valueOf(zz());
            case 60:
                return (T) String.valueOf(u());
            case 61:
                return (T) String.valueOf(io());
            case 62:
                return (T) String.valueOf(ul());
            case 63:
                return (T) String.valueOf(o());
            case 64:
                return (T) String.valueOf(y());
            case 65:
                return (T) String.valueOf(m());
            case 66:
                return (T) ep();
            case 67:
                return (T) Integer.valueOf(vz());
            case 68:
                return (T) Boolean.valueOf(kz());
            case 69:
                return (T) Boolean.valueOf(er());
            case 70:
                return (T) fb();
            case 71:
                return (T) g();
            case 72:
                a(map.get("extraEventObject"));
                return null;
            case 73:
                ok((String) map.get("clickButtonTag"));
                return null;
            case 74:
                a((JSONObject) map.get("eventConfigExtraJson"));
                return null;
            case 75:
                bl((JSONObject) map.get("paramsJson"));
                return null;
            case 76:
                a((String) map.get("clickItemTag"));
                return null;
            case 78:
                bl((String) map.get("refer"));
                return null;
            case 79:
                s((String) map.get("quickAppEventTag"));
                return null;
            case 80:
                kf(map);
                return null;
            case 81:
                return (T) Long.valueOf(v());
            case 82:
                return (T) String.valueOf(fl());
            case 83:
                return (T) Long.valueOf(e());
            case 84:
                return (T) Long.valueOf(fd());
            case 85:
                return (T) String.valueOf(em());
            case 86:
                return (T) sg();
            case 87:
                return (T) String.valueOf(qu());
            case 88:
                return (T) String.valueOf(xy());
            case 89:
                return (T) String.valueOf(ah());
            case 90:
                return (T) l();
            case 91:
                return (T) Boolean.valueOf(wv());
            case 92:
                return (T) Boolean.valueOf(vk());
            case 93:
                return (T) Boolean.valueOf(yt());
            case 94:
                return (T) Boolean.valueOf(ej());
            case 95:
                return (T) Boolean.valueOf(qx());
            case 96:
                return (T) String.valueOf(tr());
            case 97:
                return (T) String.valueOf(cs());
            case 98:
                w();
                return null;
            case 99:
                return (T) tg();
            case 100:
                dx();
                return null;
            case 101:
                cf();
                return null;
            case 102:
                return (T) Boolean.valueOf(ew());
            case 103:
                return (T) Integer.valueOf(ry());
            case 104:
                return (T) String.valueOf(de());
            case 105:
                return (T) Boolean.valueOf(dn());
            case 106:
                return (T) String.valueOf(to());
            case 107:
                return (T) String.valueOf(ld());
            case 108:
                return (T) String.valueOf(ju());
            case 109:
                return (T) d();
            case 110:
                return (T) sr();
            case 111:
                return (T) c();
            case 112:
                return (T) Integer.valueOf(yz());
            case 113:
                return (T) f();
            case 114:
                return (T) Boolean.valueOf(pb());
            case 115:
                return (T) Boolean.valueOf(qh());
            case 116:
                return (T) Integer.valueOf(hd());
            case 117:
                return (T) Integer.valueOf(xh());
            case 118:
                return (T) String.valueOf(je());
            case 119:
                return (T) String.valueOf(sj());
            case 120:
                return (T) Boolean.valueOf(b());
            case 121:
                return (T) Boolean.valueOf(az());
            case 122:
                return (T) Boolean.valueOf(jl());
            case 123:
                n((String) map.get("md5"));
                return null;
            case 124:
                ok(((Long) map.get("expectFileLength")).longValue());
                return null;
            case 125:
                s(((Boolean) map.get("needWifi")).booleanValue());
                return null;
            case 127:
                a(((Long) map.get("extraValue")).longValue());
                return null;
            case 128:
                kf((String) map.get("appName"));
                return null;
            case 129:
                s((JSONObject) map.get("extraJson"));
                return null;
            case 130:
                h((String) map.get("startToast"));
                return null;
            case 131:
                p((String) map.get("sdkMonitorScene"));
                return null;
            case 132:
                bl(((Long) map.get("id")).longValue());
                return null;
            case 133:
                kf(((Boolean) map.get("isAd")).booleanValue());
                return null;
            case 134:
                bl(((Integer) map.get("modelType")).intValue());
                return null;
            case 135:
                q((String) map.get("logExtra"));
                return null;
            case 136:
                k((String) map.get("packageName"));
                return null;
            case 137:
                r((String) map.get("appIcon"));
                return null;
            case 139:
                ok((List) map.get("clickTrackUrl"));
                return null;
            case 140:
                j((String) map.get("downloadUrl"));
                return null;
            case 141:
                a((List) map.get("backupUrls"));
                return null;
            case 142:
                z((String) map.get("notificationJumpUrl"));
                return null;
            case 143:
                rh((String) map.get("mimeType"));
                return null;
            case 144:
                ok((Map) map.get("headers"));
                return null;
            case 145:
                h(((Boolean) map.get("isShowNotification")).booleanValue());
                return null;
            case 146:
                t((String) map.get("filePath"));
                return null;
            case 147:
                i((String) map.get("fileName"));
                return null;
            case 148:
                p(((Boolean) map.get("isNeedIndependentProcess")).booleanValue());
                return null;
            case 149:
                s(((Integer) map.get("versionCode")).intValue());
                return null;
            case 150:
                x((String) map.get("versionName"));
                return null;
            case 151:
                ok(new s.ok().ok((String) map.get("quickAppModelOpenUrl")).a((String) map.get("quickAppModelExtraData")).ok());
                return null;
            case 152:
                q(((Boolean) map.get("isAutoInstallWithoutNotification")).booleanValue());
                return null;
            case 153:
                n(((Integer) map.get("funnelType")).intValue());
                return null;
        }
    }

    public void p(String str) {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setSdkMonitorScene(str);
    }

    public AdDownloadModel q(String str) {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setLogExtra(str);
    }

    public AdDownloadModel p(boolean z3) {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setNeedIndependentProcess(z3);
    }

    public AdDownloadModel q(boolean z3) {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setAutoInstallWithoutNotification(z3);
    }

    public boolean a() {
        AdDownloadController adDownloadController = this.kf;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.isEnableBackDialog();
    }

    public void a(boolean z3) {
        AdDownloadController adDownloadController = this.kf;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setIsAutoDownloadOnCardShow(z3);
    }

    public void a(Object obj) {
        AdDownloadEventConfig adDownloadEventConfig = this.f35819p;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setExtraEventObject(obj);
    }

    public void a(JSONObject jSONObject) {
        AdDownloadEventConfig adDownloadEventConfig = this.f35819p;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setExtraJson(jSONObject);
    }

    public Object s() {
        AdDownloadController adDownloadController = this.kf;
        if (adDownloadController == null) {
            return null;
        }
        return adDownloadController.getExtraClickOperation();
    }

    public void a(String str) {
        AdDownloadEventConfig adDownloadEventConfig = this.f35819p;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setClickItemTag(str);
    }

    public void s(String str) {
        AdDownloadEventConfig adDownloadEventConfig = this.f35819p;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setQuickAppEventTag(str);
    }

    public void a(int i4) {
        AdDownloadEventConfig adDownloadEventConfig = this.f35819p;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setDownloadScene(i4);
    }

    public void s(boolean z3) {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setNeedWifi(z3);
    }

    public void a(long j4) {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setExtraValue(j4);
    }

    public void s(JSONObject jSONObject) {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setExtra(jSONObject);
    }

    public AdDownloadModel a(List<String> list) {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setBackupUrls(list);
    }

    public AdDownloadModel s(int i4) {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setVersionCode(i4);
    }

    public boolean n() {
        AdDownloadController adDownloadController = this.kf;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.isEnableMultipleDownload();
    }

    public boolean bl() {
        AdDownloadController adDownloadController = this.kf;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.isAddToDownloadManage();
    }

    public void n(String str) {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setMd5(str);
    }

    public void bl(boolean z3) {
        AdDownloadController adDownloadController = this.kf;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setEnableNewActivity(z3);
    }

    public void n(boolean z3) {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setIsShowToast(z3);
    }

    public void bl(JSONObject jSONObject) {
        AdDownloadEventConfig adDownloadEventConfig = this.f35819p;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setParamsJson(jSONObject);
    }

    public AdDownloadModel n(int i4) {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setFunnelType(i4);
    }

    public void bl(String str) {
        AdDownloadEventConfig adDownloadEventConfig = this.f35819p;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setRefer(str);
    }

    public AdDownloadModel bl(long j4) {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setId(j4);
    }

    public AdDownloadModel bl(int i4) {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setModelType(i4);
    }

    public void kf(String str) {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setAppName(str);
    }

    public AdDownloadModel kf(boolean z3) {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setIsAd(z3);
    }

    public void ok(Bundle bundle) {
        bl.ok(this.f35816a);
    }

    private AdDownloadModel.Builder ok(long j4, String str, boolean z3, boolean z4, String str2, JSONObject jSONObject, JSONObject jSONObject2, String str3, String str4, String str5, String str6, boolean z5, String str7, String str8, String str9) {
        AdDownloadModel.Builder fileUriProvider = new AdDownloadModel.Builder().setAdId(j4).setAppIcon(str).setIsShowNotification(z3).setAutoInstallWithoutNotification(z4).setLogExtra(str2).setExtra(jSONObject).setDistinctDir(true).setIsAd(true).setFileUriProvider(new IDownloadFileUriProvider() { // from class: com.bytedance.sdk.openadsdk.downloadnew.s.1
            @Override // com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider
            public Uri getUriForFile(String str10, String str11) {
                return null;
            }
        });
        if (jSONObject2 != null) {
            fileUriProvider.setDownloadSettings(jSONObject2);
        }
        if (!TextUtils.isEmpty(str3)) {
            fileUriProvider.setFilePath(str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            fileUriProvider.setDownloadUrl(str4);
        }
        if (!TextUtils.isEmpty(str5)) {
            fileUriProvider.setAppName(str5);
        }
        if (!TextUtils.isEmpty(str6)) {
            fileUriProvider.setPackageName(str6);
        }
        fileUriProvider.setNeedIndependentProcess(z5);
        fileUriProvider.setDeepLink(ok(j4, str7, str8, str9));
        return fileUriProvider;
    }

    private DeepLink ok(long j4, String str, String str2, String str3) {
        DeepLink deepLink = new DeepLink();
        deepLink.setId(j4);
        deepLink.setOpenUrl(str);
        deepLink.setWebTitle(str2);
        deepLink.setWebUrl(str3);
        return deepLink;
    }

    private void ok(String str, String str2, String str3) {
        AdDownloadModel.Builder builder = this.bl;
        if (builder == null) {
            return;
        }
        this.f35820s = builder.setAppIcon(str).setAppName(str2).setPackageName(str3).build();
    }

    private void ok(int i4, int i5, boolean z3, boolean z4, boolean z5) {
        AdDownloadController.Builder isAddToDownloadManage = new AdDownloadController.Builder().setLinkMode(i4).setDownloadMode(i5).setIsEnableBackDialog(true).setIsAddToDownloadManage(false);
        this.f35818n = isAddToDownloadManage;
        if (z3) {
            isAddToDownloadManage.setEnableAH(z4);
            this.f35818n.setEnableAM(z5);
        }
        this.kf = this.f35818n.build();
    }

    public int ok() {
        AdDownloadController adDownloadController = this.kf;
        if (adDownloadController == null) {
            return 0;
        }
        return adDownloadController.getLinkMode();
    }

    public void ok(int i4) {
        AdDownloadController adDownloadController = this.kf;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setLinkMode(i4);
    }

    public void ok(boolean z3) {
        AdDownloadController adDownloadController = this.kf;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setEnableShowComplianceDialog(z3);
    }

    public void ok(Object obj) {
        AdDownloadController adDownloadController = this.kf;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setExtraObject(obj);
    }

    public void ok(JSONObject jSONObject) {
        AdDownloadController adDownloadController = this.kf;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setExtraJson(jSONObject);
    }

    public void ok(String str) {
        AdDownloadEventConfig adDownloadEventConfig = this.f35819p;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setClickButtonTag(str);
    }

    public void ok(long j4) {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setExpectFileLength(j4);
    }

    public AdDownloadModel ok(List<String> list) {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setClickTrackUrl(list);
    }

    public AdDownloadModel ok(Map<String, String> map) {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setHeaders(map);
    }

    public AdDownloadModel ok(com.ss.android.download.api.model.s sVar) {
        AdDownloadModel adDownloadModel = this.f35820s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setQuickAppModel(sVar);
    }
}
