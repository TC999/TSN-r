package com.bytedance.sdk.openadsdk.downloadnew;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.api.c.f;
import com.bytedance.sdk.openadsdk.api.c.r;
import com.bytedance.sdk.openadsdk.api.c.ux;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.ss.android.download.api.config.IDownloadButtonClickListener;
import com.ss.android.download.api.config.OnItemClickListener;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.download.DownloadStatusChangeListener;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.download.api.model.sr;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class sr implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private static volatile sr f35821c;
    private AdDownloadEventConfig ev;

    /* renamed from: f  reason: collision with root package name */
    private AdDownloadController f35822f;

    /* renamed from: r  reason: collision with root package name */
    private AdDownloadEventConfig.Builder f35823r;
    private AdDownloadModel sr;
    private AdDownloadController.Builder ux;

    /* renamed from: w  reason: collision with root package name */
    private final Context f35824w;
    private AdDownloadModel.Builder xv;

    private sr(Context context) {
        this.f35824w = context;
    }

    public static sr c(Context context) {
        if (f35821c == null) {
            synchronized (sr.class) {
                if (f35821c == null) {
                    f35821c = new sr(context);
                }
            }
        }
        return f35821c;
    }

    private static boolean c(IDownloadButtonClickListener iDownloadButtonClickListener) {
        return iDownloadButtonClickListener != null;
    }

    private OnItemClickListener ev(Object obj) {
        if (obj instanceof OnItemClickListener) {
            return (OnItemClickListener) obj;
        }
        if (obj instanceof EventListener) {
            return new r((EventListener) obj);
        }
        return null;
    }

    private DownloadController f(Object obj) {
        if (obj instanceof DownloadController) {
            return (DownloadController) obj;
        }
        return null;
    }

    private IDownloadButtonClickListener gd(Object obj) {
        if (obj instanceof IDownloadButtonClickListener) {
            return (IDownloadButtonClickListener) obj;
        }
        if (obj instanceof EventListener) {
            return new f((EventListener) obj);
        }
        return null;
    }

    private Activity getActivity(Object obj) {
        if (obj instanceof Activity) {
            return (Activity) obj;
        }
        return null;
    }

    private ExitInstallListener r(Object obj) {
        if (obj instanceof ExitInstallListener) {
            return (ExitInstallListener) obj;
        }
        return null;
    }

    private int rh() {
        AdDownloadController adDownloadController = this.f35822f;
        if (adDownloadController == null) {
            return 0;
        }
        return adDownloadController.getDownloadMode();
    }

    private DownloadModel sr(Object obj) {
        if (obj instanceof DownloadModel) {
            return (DownloadModel) obj;
        }
        return null;
    }

    private DownloadEventConfig ux(Object obj) {
        if (obj instanceof DownloadEventConfig) {
            return (DownloadEventConfig) obj;
        }
        return null;
    }

    private void w(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        AdDownloadModel.Builder c4 = c(((Long) map.get("id")).longValue(), (String) map.get("appIcon"), ((Boolean) map.get("isShowNotification")).booleanValue(), ((Boolean) map.get("isAutoInstallWithoutNotification")).booleanValue(), (String) map.get("logExtra"), (JSONObject) map.get("extraJson"), (JSONObject) map.get("downloadSettings"), (String) map.get("filePath"), (String) map.get("downloadUrl"), (String) map.get("appName"), (String) map.get("packageName"), ((Boolean) map.get("isNeedIndependentProcess")).booleanValue(), (String) map.get("openUrl"), (String) map.get("webTitle"), (String) map.get("webUrl"));
        this.xv = c4;
        this.sr = c4.build();
    }

    private DownloadStatusChangeListener xv(Object obj) {
        if (obj instanceof DownloadStatusChangeListener) {
            return (DownloadStatusChangeListener) obj;
        }
        if (obj instanceof EventListener) {
            return new ux((EventListener) obj);
        }
        return null;
    }

    public boolean a() {
        AdDownloadController adDownloadController = this.f35822f;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.isAutoDownloadOnCardShow();
    }

    public boolean au() {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return false;
        }
        return adDownloadModel.isInExternalPublicDir();
    }

    public void b() {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.forceWifi();
    }

    public boolean ba() {
        AdDownloadEventConfig adDownloadEventConfig = this.ev;
        if (adDownloadEventConfig == null) {
            return false;
        }
        return adDownloadEventConfig.isEnableV3Event();
    }

    public JSONObject be() {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getExtra();
    }

    public String bj() {
        AdDownloadModel adDownloadModel = this.sr;
        return adDownloadModel == null ? "" : adDownloadModel.getFilePath();
    }

    public boolean bk() {
        AdDownloadController adDownloadController = this.f35822f;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.enableNewActivity();
    }

    public String bm() {
        AdDownloadModel adDownloadModel = this.sr;
        return adDownloadModel == null ? "" : adDownloadModel.getFileName();
    }

    public com.ss.android.download.api.model.sr bs() {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getQuickAppModel();
    }

    public String bw() {
        AdDownloadModel adDownloadModel = this.sr;
        return adDownloadModel == null ? "" : adDownloadModel.getNotificationJumpUrl();
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        Map<String, Object> hashMap;
        if (i4 == 20) {
            c((Bundle) valueSet.objectValue(0, Bundle.class));
            return null;
        }
        if (valueSet != null && valueSet.objectValue(0, Map.class) != null) {
            hashMap = (Map) valueSet.objectValue(0, Map.class);
        } else {
            hashMap = new HashMap<>();
        }
        return (T) c(cls, i4, hashMap);
    }

    public int ck() {
        AdDownloadEventConfig adDownloadEventConfig = this.ev;
        if (adDownloadEventConfig == null) {
            return 0;
        }
        return adDownloadEventConfig.getDownloadScene();
    }

    public int e() {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return 1;
        }
        return adDownloadModel.getFunnelType();
    }

    public boolean eb() {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return true;
        }
        return adDownloadModel.enablePause();
    }

    public JSONObject eq() {
        AdDownloadEventConfig adDownloadEventConfig = this.ev;
        if (adDownloadEventConfig == null) {
            return null;
        }
        return adDownloadEventConfig.getParamsJson();
    }

    public List<String> eu() {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getClickTrackUrl();
    }

    public String fm() {
        AdDownloadModel adDownloadModel = this.sr;
        return adDownloadModel == null ? "" : adDownloadModel.getLogExtra();
    }

    public boolean fp() {
        AdDownloadController adDownloadController = this.f35822f;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.enableOppoAutoDownload();
    }

    public String fz() {
        AdDownloadEventConfig adDownloadEventConfig = this.ev;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getClickItemTag();
    }

    public int g() {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return 0;
        }
        return adDownloadModel.getModelType();
    }

    public String gb() {
        AdDownloadEventConfig adDownloadEventConfig = this.ev;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getStorageDenyLabel();
    }

    public String ge() {
        AdDownloadModel adDownloadModel = this.sr;
        return adDownloadModel == null ? "" : adDownloadModel.getAppIcon();
    }

    public Map<String, String> gw() {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getHeaders();
    }

    public String h() {
        AdDownloadModel adDownloadModel = this.sr;
        return adDownloadModel == null ? "" : adDownloadModel.getVersionName();
    }

    public String i() {
        AdDownloadEventConfig adDownloadEventConfig = this.ev;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getClickStartLabel();
    }

    public String ia() {
        AdDownloadEventConfig adDownloadEventConfig = this.ev;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getRefer();
    }

    public String j() {
        AdDownloadEventConfig adDownloadEventConfig = this.ev;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getClickPauseLabel();
    }

    public boolean k() {
        AdDownloadController adDownloadController = this.f35822f;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.enableShowComplianceDialog();
    }

    public String kk() {
        AdDownloadModel adDownloadModel = this.sr;
        return adDownloadModel == null ? "" : adDownloadModel.getStartToast();
    }

    public boolean lf() {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return false;
        }
        return adDownloadModel.autoInstallWithoutNotification();
    }

    public String ls() {
        AdDownloadEventConfig adDownloadEventConfig = this.ev;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getClickInstallLabel();
    }

    public String m() {
        AdDownloadModel adDownloadModel = this.sr;
        return adDownloadModel == null ? "" : adDownloadModel.getMimeType();
    }

    public long me() {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return 0L;
        }
        return adDownloadModel.getId();
    }

    public boolean mt() {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return false;
        }
        return adDownloadModel.isNeedWifi();
    }

    public int mu() {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return 2;
        }
        return adDownloadModel.getExecutorGroup();
    }

    public Object n() {
        AdDownloadEventConfig adDownloadEventConfig = this.ev;
        if (adDownloadEventConfig == null) {
            return null;
        }
        return adDownloadEventConfig.getExtraEventObject();
    }

    public boolean ng() {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return false;
        }
        return adDownloadModel.needIndependentProcess();
    }

    public boolean oh() {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return true;
        }
        return adDownloadModel.isAd();
    }

    public int ok() {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return 0;
        }
        return adDownloadModel.getVersionCode();
    }

    public boolean oo() {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return false;
        }
        return adDownloadModel.isInExternalPublicDir();
    }

    public void ox() {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.forceHideToast();
    }

    public Object p() {
        AdDownloadController adDownloadController = this.f35822f;
        if (adDownloadController == null) {
            return null;
        }
        return adDownloadController.getExtraObject();
    }

    public List<String> pr() {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getBackupUrls();
    }

    public String q() {
        AdDownloadEventConfig adDownloadEventConfig = this.ev;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getClickPauseLabel();
    }

    public String s() {
        AdDownloadEventConfig adDownloadEventConfig = this.ev;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getClickButtonTag();
    }

    public boolean t() {
        AdDownloadController adDownloadController = this.f35822f;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.enableAH();
    }

    public DeepLink ta() {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getDeepLink();
    }

    public String te() {
        AdDownloadModel adDownloadModel = this.sr;
        return adDownloadModel == null ? "" : adDownloadModel.getPackageName();
    }

    public String tl() {
        AdDownloadModel adDownloadModel = this.sr;
        return adDownloadModel == null ? "" : adDownloadModel.getStartToast();
    }

    public String u() {
        AdDownloadEventConfig adDownloadEventConfig = this.ev;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getClickLabel();
    }

    public boolean up() {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return true;
        }
        return adDownloadModel.isShowNotification();
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return b.a().i(0, xv.f35829c).h(1, Boolean.valueOf(xv.f35832w)).e(10000, 3).l();
    }

    public boolean vc() {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return true;
        }
        return adDownloadModel.isShowToast();
    }

    public JSONObject wo() {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getDownloadSettings();
    }

    public String wv() {
        AdDownloadModel adDownloadModel = this.sr;
        return adDownloadModel == null ? "" : adDownloadModel.getMd5();
    }

    public String wx() {
        AdDownloadModel adDownloadModel = this.sr;
        return adDownloadModel == null ? "" : adDownloadModel.getDownloadUrl();
    }

    public String x() {
        AdDownloadModel adDownloadModel = this.sr;
        return adDownloadModel == null ? "" : adDownloadModel.getName();
    }

    public boolean xg() {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return com.ss.android.download.api.xv.w.c(com.ss.android.socialbase.downloader.r.c.c(wo()), m());
        }
        return adDownloadModel.shouldDownloadWithPatchApply();
    }

    public long xk() {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return 0L;
        }
        return adDownloadModel.getExpectFileLength();
    }

    public void xu() {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.forceHideNotification();
    }

    public JSONObject y() {
        AdDownloadEventConfig adDownloadEventConfig = this.ev;
        if (adDownloadEventConfig == null) {
            return null;
        }
        return adDownloadEventConfig.getExtraJson();
    }

    public boolean ys() {
        AdDownloadController adDownloadController = this.f35822f;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.enableAM();
    }

    public long yu() {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return 0L;
        }
        return adDownloadModel.getExtraValue();
    }

    public boolean z() {
        AdDownloadEventConfig adDownloadEventConfig = this.ev;
        if (adDownloadEventConfig == null) {
            return true;
        }
        return adDownloadEventConfig.isEnableClickEvent();
    }

    public boolean zr() {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return true;
        }
        return adDownloadModel.isAutoInstall();
    }

    public boolean zt() {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return false;
        }
        return adDownloadModel.distinctDir();
    }

    private void f(int i4) {
        AdDownloadController adDownloadController = this.f35822f;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setDownloadMode(i4);
    }

    private void p(boolean z3) {
        AdDownloadController adDownloadController = this.f35822f;
        if (adDownloadController == null) {
            return;
        }
        try {
            adDownloadController.setEnableOppoAutoDownload(z3);
        } catch (Throwable unused) {
        }
    }

    private void sr(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        boolean booleanValue = ((Boolean) map.get("isEnableClickEvent")).booleanValue();
        boolean booleanValue2 = ((Boolean) map.get("isEnableV3Event")).booleanValue();
        JSONObject jSONObject = (JSONObject) map.get("extraEventObject");
        AdDownloadEventConfig.Builder isEnableV3Event = new AdDownloadEventConfig.Builder().setClickButtonTag((String) map.get("clickButtonTag")).setClickItemTag((String) map.get("clickItemTag")).setClickStartLabel((String) map.get("clickStartLabel")).setClickContinueLabel((String) map.get("clickContinueLabel")).setClickPauseLabel((String) map.get("clickPauseLabel")).setStorageDenyLabel((String) map.get("storageDenyLabel")).setClickInstallLabel((String) map.get("clickInstallLabel")).setIsEnableClickEvent(booleanValue).setIsEnableV3Event(booleanValue2);
        this.f35823r = isEnableV3Event;
        if (jSONObject != null) {
            isEnableV3Event.setExtraEventObject(jSONObject);
        }
        this.ev = this.f35823r.build();
    }

    private void ux(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        int intValue = ((Integer) map.get("downloadScene")).intValue();
        boolean booleanValue = ((Boolean) map.get("isEnableClickEvent")).booleanValue();
        boolean booleanValue2 = ((Boolean) map.get("isEnableV3Event")).booleanValue();
        JSONObject jSONObject = (JSONObject) map.get("extraEventObject");
        AdDownloadEventConfig.Builder paramsJson = new AdDownloadEventConfig.Builder().setClickButtonTag((String) map.get("clickButtonTag")).setClickItemTag((String) map.get("clickItemTag")).setClickLabel((String) map.get("clickLabel")).setClickStartLabel((String) map.get("clickStartLabel")).setClickContinueLabel((String) map.get("clickContinueLabel")).setClickPauseLabel((String) map.get("clickPauseLabel")).setStorageDenyLabel((String) map.get("storageDenyLabel")).setClickInstallLabel((String) map.get("clickInstallLabel")).setIsEnableClickEvent(booleanValue).setDownloadScene(intValue).setIsEnableV3Event(booleanValue2).setRefer((String) map.get("refer")).setExtraJson((JSONObject) map.get("extraJson")).setParamsJson((JSONObject) map.get("paramsJson"));
        this.f35823r = paramsJson;
        if (jSONObject != null) {
            paramsJson.setExtraEventObject(jSONObject);
        }
        this.ev = this.f35823r.build();
    }

    public AdDownloadModel a(String str) {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setDownloadUrl(str);
    }

    public AdDownloadModel bk(String str) {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setNotificationJumpUrl(str);
    }

    public AdDownloadModel fp(String str) {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setFileName(str);
    }

    public AdDownloadModel ia(String str) {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setVersionName(str);
    }

    public AdDownloadModel k(String str) {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setAppIcon(str);
    }

    public boolean r() {
        AdDownloadController adDownloadController = this.f35822f;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.shouldUseNewWebView();
    }

    public AdDownloadModel t(String str) {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setMimeType(str);
    }

    public AdDownloadModel ys(String str) {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setFilePath(str);
    }

    private void xv(Map<String, Object> map) {
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
        this.ux = enableOppoAutoDownload;
        this.f35822f = enableOppoAutoDownload.build();
    }

    public int ev() {
        AdDownloadController adDownloadController = this.f35822f;
        if (adDownloadController == null) {
            return 0;
        }
        return adDownloadController.getInterceptFlag();
    }

    public int f() {
        AdDownloadController adDownloadController = this.f35822f;
        if (adDownloadController == null) {
            return 1;
        }
        return adDownloadController.getDowloadChunkCount();
    }

    public JSONObject gd() {
        AdDownloadController adDownloadController = this.f35822f;
        if (adDownloadController == null) {
            return null;
        }
        return adDownloadController.getExtraJson();
    }

    public AdDownloadModel p(String str) {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setPackageName(str);
    }

    public void r(String str) {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setStartToast(str);
    }

    private void f(Map<String, Object> map) {
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
        com.ss.android.download.api.model.sr c4 = new sr.c().c((String) map.get("quickAppModelOpenUrl")).w((String) map.get("quickAppModelExtraData")).c();
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
        AdDownloadModel.Builder fileUriProvider = new AdDownloadModel.Builder().setExpectFileLength(longValue).setMd5((String) map.get("md5")).setId(longValue3).setExtraValue(longValue2).setIsAd(booleanValue).setModelType(intValue).setLogExtra((String) map.get("logExtra")).setAppIcon((String) map.get("appIcon")).setBackupUrls((List) map.get("backupUrls")).setNotificationJumpUrl((String) map.get("notificationJumpUrl")).setClickTrackUrl((List) map.get("clickTrackUrl")).setMimeType(str).setHeaders(map2).setIsShowToast(booleanValue2).setIsShowNotification(booleanValue7).setNeedWifi(booleanValue3).setFileName(str2).setVersionCode(intValue2).setVersionName(str3).setQuickAppModel(c4).setAutoInstallWithoutNotification(booleanValue8).setExecutorGroup(intValue3).setStartToast(str4).setSdkMonitorScene(str5).setAutoInstall(booleanValue4).setDistinctDir(booleanValue5).setEnablePause(booleanValue6).setExtra(jSONObject).setFileUriProvider(new IDownloadFileUriProvider() { // from class: com.bytedance.sdk.openadsdk.downloadnew.sr.2
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
        fileUriProvider.setDeepLink(c(longValue3, str10, str11, str12));
        this.sr = this.xv.build();
    }

    public <T> T c(Class<T> cls, int i4, Map<String, Object> map) {
        DownloadModel sr;
        DownloadModel sr2;
        DownloadEventConfig ux;
        DownloadController f4;
        DownloadModel sr3;
        DownloadEventConfig ux2;
        DownloadController f5;
        DownloadEventConfig ux3;
        DownloadController f6;
        DownloadEventConfig ux4;
        DownloadController f7;
        switch (i4) {
            case 0:
                return (T) Boolean.valueOf(xv.c(getActivity(map.get("activity")), r(map.get("exitInstallListener"))));
            case 1:
                return (T) xv.c().f();
            case 2:
                try {
                    return (T) Boolean.valueOf(xv.c((String) map.get("tagIntercept"), (String) map.get("label"), new JSONObject((String) map.get("meta")), new HashMap()));
                } catch (JSONException unused) {
                    return (T) Boolean.FALSE;
                }
            case 3:
                xv.c(((Integer) map.get("hid")).intValue());
                return null;
            case 4:
                AdDownloadModel adDownloadModel = this.sr;
                xv.c().c(adDownloadModel == null ? (String) map.get("downloadUrl") : adDownloadModel.getDownloadUrl(), ((Integer) map.get("hashCode")).intValue());
                return null;
            case 5:
                int intValue = ((Integer) map.get("hashCode")).intValue();
                AdDownloadModel adDownloadModel2 = this.sr;
                if (adDownloadModel2 == null) {
                    sr = sr(map.get("downloadModel"));
                } else {
                    sr = sr(adDownloadModel2);
                }
                xv.c().c(this.f35824w, intValue, xv(map.get("downloadStatusChangeListener")), sr);
                return null;
            case 6:
                AdDownloadModel adDownloadModel3 = this.sr;
                return (T) Boolean.valueOf(xv.c(this.f35824w, adDownloadModel3 == null ? (String) map.get("downloadUrl") : adDownloadModel3.getDownloadUrl()));
            case 7:
                xv.w();
                return null;
            case 8:
                AdDownloadModel adDownloadModel4 = this.sr;
                xv.c().c(adDownloadModel4 == null ? (String) map.get("downloadUrl") : adDownloadModel4.getDownloadUrl(), ((Boolean) map.get("force")).booleanValue());
                return null;
            case 9:
                xv.c(((Integer) map.get("id")).intValue(), (ITTDownloadAdapter.OnEventLogHandler) map.get("onEventLogHandler"));
                return null;
            case 10:
                xv.c((String) map.get("downloadPath"));
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
                AdDownloadModel adDownloadModel5 = this.sr;
                if (adDownloadModel5 == null) {
                    sr2 = sr(map.get("downloadModel"));
                } else {
                    sr2 = sr(adDownloadModel5);
                }
                AdDownloadEventConfig adDownloadEventConfig = this.ev;
                if (adDownloadEventConfig == null) {
                    ux = ux(map.get("downloadEventConfig"));
                } else {
                    ux = ux(adDownloadEventConfig);
                }
                AdDownloadController adDownloadController = this.f35822f;
                if (adDownloadController == null) {
                    f4 = f(map.get("downloadController"));
                } else {
                    f4 = f(adDownloadController);
                }
                IDownloadButtonClickListener gd = gd(map.get("downloadButtonClickListener"));
                if (c(gd)) {
                    return (T) Boolean.valueOf(xv.c(this.f35824w, uri, sr2, ux, f4, gd));
                }
                return (T) Boolean.valueOf(xv.c(this.f35824w, uri, sr2, ux, f4));
            case 13:
                int intValue2 = ((Integer) map.get("hashCode")).intValue();
                boolean booleanValue = ((Boolean) map.get("isDisableDialog")).booleanValue();
                String str = (String) map.get("userAgent");
                AdDownloadModel adDownloadModel6 = this.sr;
                if (adDownloadModel6 == null) {
                    sr3 = sr(map.get("downloadModel"));
                } else {
                    sr3 = sr(adDownloadModel6);
                }
                DownloadModel downloadModel = sr3;
                AdDownloadEventConfig adDownloadEventConfig2 = this.ev;
                if (adDownloadEventConfig2 == null) {
                    ux2 = ux(map.get("downloadEventConfig"));
                } else {
                    ux2 = ux(adDownloadEventConfig2);
                }
                DownloadEventConfig downloadEventConfig = ux2;
                AdDownloadController adDownloadController2 = this.f35822f;
                if (adDownloadController2 == null) {
                    f5 = f(map.get("downloadController"));
                } else {
                    f5 = f(adDownloadController2);
                }
                DownloadController downloadController = f5;
                DownloadStatusChangeListener xv = xv(map.get("downloadStatusChangeListener"));
                IDownloadButtonClickListener gd2 = gd(map.get("downloadButtonClickListener"));
                if (c(gd2)) {
                    xv.c().ux().c(this.f35824w, str, booleanValue, downloadModel, downloadEventConfig, downloadController, xv, intValue2, gd2);
                    return null;
                }
                xv.c().ux().c(this.f35824w, str, booleanValue, downloadModel, downloadEventConfig, downloadController, xv, intValue2);
                return null;
            case 14:
                AdDownloadModel adDownloadModel7 = this.sr;
                long longValue = adDownloadModel7 == null ? ((Long) map.get("id")).longValue() : adDownloadModel7.getId();
                AdDownloadModel adDownloadModel8 = this.sr;
                return (T) Boolean.valueOf(xv.c().ux().c(this.f35824w, longValue, adDownloadModel8 == null ? (String) map.get("logExtra") : adDownloadModel8.getLogExtra(), (DownloadStatusChangeListener) null, ((Integer) map.get("hashCode")).intValue()));
            case 15:
                return (T) Boolean.valueOf(xv.c((Uri) map.get("uri")));
            case 16:
                AdDownloadModel adDownloadModel9 = this.sr;
                String downloadUrl = adDownloadModel9 == null ? (String) map.get("downloadUrl") : adDownloadModel9.getDownloadUrl();
                AdDownloadModel adDownloadModel10 = this.sr;
                long longValue2 = adDownloadModel10 == null ? ((Long) map.get("id")).longValue() : adDownloadModel10.getId();
                int intValue3 = ((Integer) map.get("action_type_button")).intValue();
                AdDownloadEventConfig adDownloadEventConfig3 = this.ev;
                if (adDownloadEventConfig3 == null) {
                    ux3 = ux(map.get("downloadEventConfig"));
                } else {
                    ux3 = ux(adDownloadEventConfig3);
                }
                DownloadEventConfig downloadEventConfig2 = ux3;
                AdDownloadController adDownloadController3 = this.f35822f;
                if (adDownloadController3 == null) {
                    f6 = f(map.get("downloadController"));
                } else {
                    f6 = f(adDownloadController3);
                }
                xv.c().c(downloadUrl, longValue2, intValue3, downloadEventConfig2, f6);
                return null;
            case 17:
                AdDownloadModel adDownloadModel11 = this.sr;
                String downloadUrl2 = adDownloadModel11 == null ? (String) map.get("downloadUrl") : adDownloadModel11.getDownloadUrl();
                long longValue3 = ((Long) map.get("id")).longValue();
                int intValue4 = ((Integer) map.get("action_type_button")).intValue();
                AdDownloadEventConfig adDownloadEventConfig4 = this.ev;
                if (adDownloadEventConfig4 == null) {
                    ux4 = ux(map.get("downloadEventConfig"));
                } else {
                    ux4 = ux(adDownloadEventConfig4);
                }
                DownloadEventConfig downloadEventConfig3 = ux4;
                AdDownloadController adDownloadController4 = this.f35822f;
                if (adDownloadController4 == null) {
                    f7 = f(map.get("downloadController"));
                } else {
                    f7 = f(adDownloadController4);
                }
                xv.c().c(downloadUrl2, longValue3, intValue4, downloadEventConfig3, f7, ev(map.get("itemClickListener")), gd(map.get("downloadButtonClickListener")));
                return null;
            case 18:
                AdDownloadModel adDownloadModel12 = this.sr;
                return (T) Boolean.valueOf(xv.c().ux().c(adDownloadModel12 == null ? ((Long) map.get("id")).longValue() : adDownloadModel12.getId(), ((Integer) map.get("hashCode")).intValue()));
            case 19:
                AdDownloadModel adDownloadModel13 = this.sr;
                return (T) Boolean.valueOf(xv.c().ux().c(adDownloadModel13 == null ? ((Long) map.get("id")).longValue() : adDownloadModel13.getId()));
            case 23:
                if (((Boolean) map.get("mateIsEmpty")).booleanValue()) {
                    AdDownloadModel.Builder builder = new AdDownloadModel.Builder();
                    this.xv = builder;
                    this.sr = builder.build();
                    return null;
                }
                w(map);
                return null;
            case 24:
                c((String) map.get("appIcon"), (String) map.get("appName"), (String) map.get("packageName"));
                return null;
            case 25:
                c(((Integer) map.get("autoOpen")).intValue(), ((Integer) map.get("downloadMode")).intValue(), ((Boolean) map.get("isHaveDownloadSdkConfig")).booleanValue(), ((Boolean) map.get("isEnableAH")).booleanValue(), ((Boolean) map.get("isEnableAM")).booleanValue());
                return null;
            case 26:
                f(((Integer) map.get("downloadMode")).intValue());
                return null;
            case 27:
                return (T) Integer.valueOf(rh());
            case 28:
                p(((Boolean) map.get("isEnableOppoAutoDownload")).booleanValue());
                return null;
            case 29:
                sr(map);
                return null;
            case 30:
                w(((Integer) map.get("downloadScene")).intValue());
                return null;
            case 31:
                ux(((Boolean) map.get("isShowToast")).booleanValue());
                return null;
            case 32:
                xv(map);
                return null;
            case 33:
                return (T) Integer.valueOf(c());
            case 34:
                return (T) Boolean.valueOf(w());
            case 35:
                return (T) Boolean.valueOf(xv());
            case 36:
                return (T) sr();
            case 37:
                return (T) Boolean.valueOf(ux());
            case 38:
                return (T) Integer.valueOf(f());
            case 39:
                return (T) Boolean.valueOf(r());
            case 40:
                return (T) Integer.valueOf(ev());
            case 41:
                return (T) gd();
            case 42:
                return (T) p();
            case 44:
                c(((Integer) map.get("linkMode")).intValue());
                return null;
            case 45:
                return (T) Boolean.valueOf(k());
            case 46:
                c(((Boolean) map.get("enableShowComplianceDialog")).booleanValue());
                return null;
            case 47:
                return (T) Boolean.valueOf(a());
            case 48:
                return (T) Boolean.valueOf(bk());
            case 49:
                w(((Boolean) map.get("isAutoDownloadOnCardShow")).booleanValue());
                return null;
            case 50:
                xv(((Boolean) map.get("enableNewActivity")).booleanValue());
                return null;
            case 51:
                return (T) Boolean.valueOf(t());
            case 52:
                return (T) Boolean.valueOf(ys());
            case 53:
                c(map.get("extraObject"));
                return null;
            case 54:
                c((JSONObject) map.get("extraJson"));
                return null;
            case 55:
                return (T) Boolean.valueOf(fp());
            case 56:
                ux(map);
                return null;
            case 57:
                return (T) String.valueOf(ia());
            case 58:
                return (T) String.valueOf(s());
            case 59:
                return (T) String.valueOf(fz());
            case 60:
                return (T) String.valueOf(u());
            case 61:
                return (T) String.valueOf(i());
            case 62:
                return (T) String.valueOf(q());
            case 63:
                return (T) String.valueOf(j());
            case 64:
                return (T) String.valueOf(ls());
            case 65:
                return (T) String.valueOf(gb());
            case 66:
                return (T) n();
            case 67:
                return (T) Integer.valueOf(ck());
            case 68:
                return (T) Boolean.valueOf(z());
            case 69:
                return (T) Boolean.valueOf(ba());
            case 70:
                return (T) y();
            case 71:
                return (T) eq();
            case 72:
                w(map.get("extraEventObject"));
                return null;
            case 73:
                c((String) map.get("clickButtonTag"));
                return null;
            case 74:
                w((JSONObject) map.get("eventConfigExtraJson"));
                return null;
            case 75:
                xv((JSONObject) map.get("paramsJson"));
                return null;
            case 76:
                w((String) map.get("clickItemTag"));
                return null;
            case 78:
                xv((String) map.get("refer"));
                return null;
            case 79:
                sr((String) map.get("quickAppEventTag"));
                return null;
            case 80:
                f(map);
                return null;
            case 81:
                return (T) Long.valueOf(me());
            case 82:
                return (T) String.valueOf(wv());
            case 83:
                return (T) Long.valueOf(xk());
            case 84:
                return (T) Long.valueOf(yu());
            case 85:
                return (T) String.valueOf(wx());
            case 86:
                return (T) pr();
            case 87:
                return (T) String.valueOf(bw());
            case 88:
                return (T) String.valueOf(x());
            case 89:
                return (T) String.valueOf(m());
            case 90:
                return (T) gw();
            case 91:
                return (T) Boolean.valueOf(vc());
            case 92:
                return (T) Boolean.valueOf(up());
            case 93:
                return (T) Boolean.valueOf(mt());
            case 94:
                return (T) Boolean.valueOf(oo());
            case 95:
                return (T) Boolean.valueOf(au());
            case 96:
                return (T) String.valueOf(bj());
            case 97:
                return (T) String.valueOf(bm());
            case 98:
                b();
                return null;
            case 99:
                return (T) wo();
            case 100:
                ox();
                return null;
            case 101:
                xu();
                return null;
            case 102:
                return (T) Boolean.valueOf(ng());
            case 103:
                return (T) Integer.valueOf(ok());
            case 104:
                return (T) String.valueOf(h());
            case 105:
                return (T) Boolean.valueOf(oh());
            case 106:
                return (T) String.valueOf(fm());
            case 107:
                return (T) String.valueOf(te());
            case 108:
                return (T) String.valueOf(ge());
            case 109:
                return (T) ta();
            case 110:
                return (T) eu();
            case 111:
                return (T) be();
            case 112:
                return (T) Integer.valueOf(g());
            case 113:
                return (T) bs();
            case 114:
                return (T) Boolean.valueOf(lf());
            case 115:
                return (T) Boolean.valueOf(xg());
            case 116:
                return (T) Integer.valueOf(mu());
            case 117:
                return (T) Integer.valueOf(e());
            case 118:
                return (T) String.valueOf(tl());
            case 119:
                return (T) String.valueOf(kk());
            case 120:
                return (T) Boolean.valueOf(zr());
            case 121:
                return (T) Boolean.valueOf(zt());
            case 122:
                return (T) Boolean.valueOf(eb());
            case 123:
                ux((String) map.get("md5"));
                return null;
            case 124:
                c(((Long) map.get("expectFileLength")).longValue());
                return null;
            case 125:
                sr(((Boolean) map.get("needWifi")).booleanValue());
                return null;
            case 127:
                w(((Long) map.get("extraValue")).longValue());
                return null;
            case 128:
                f((String) map.get("appName"));
                return null;
            case 129:
                sr((JSONObject) map.get("extraJson"));
                return null;
            case 130:
                r((String) map.get("startToast"));
                return null;
            case 131:
                ev((String) map.get("sdkMonitorScene"));
                return null;
            case 132:
                xv(((Long) map.get("id")).longValue());
                return null;
            case 133:
                f(((Boolean) map.get("isAd")).booleanValue());
                return null;
            case 134:
                xv(((Integer) map.get("modelType")).intValue());
                return null;
            case 135:
                gd((String) map.get("logExtra"));
                return null;
            case 136:
                p((String) map.get("packageName"));
                return null;
            case 137:
                k((String) map.get("appIcon"));
                return null;
            case 139:
                c((List) map.get("clickTrackUrl"));
                return null;
            case 140:
                a((String) map.get("downloadUrl"));
                return null;
            case 141:
                w((List) map.get("backupUrls"));
                return null;
            case 142:
                bk((String) map.get("notificationJumpUrl"));
                return null;
            case 143:
                t((String) map.get("mimeType"));
                return null;
            case 144:
                c((Map) map.get("headers"));
                return null;
            case 145:
                r(((Boolean) map.get("isShowNotification")).booleanValue());
                return null;
            case 146:
                ys((String) map.get("filePath"));
                return null;
            case 147:
                fp((String) map.get("fileName"));
                return null;
            case 148:
                ev(((Boolean) map.get("isNeedIndependentProcess")).booleanValue());
                return null;
            case 149:
                sr(((Integer) map.get("versionCode")).intValue());
                return null;
            case 150:
                ia((String) map.get("versionName"));
                return null;
            case 151:
                c(new sr.c().c((String) map.get("quickAppModelOpenUrl")).w((String) map.get("quickAppModelExtraData")).c());
                return null;
            case 152:
                gd(((Boolean) map.get("isAutoInstallWithoutNotification")).booleanValue());
                return null;
            case 153:
                ux(((Integer) map.get("funnelType")).intValue());
                return null;
        }
    }

    public void ev(String str) {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setSdkMonitorScene(str);
    }

    public AdDownloadModel gd(String str) {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setLogExtra(str);
    }

    public AdDownloadModel r(boolean z3) {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setIsShowNotification(z3);
    }

    public AdDownloadModel ev(boolean z3) {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setNeedIndependentProcess(z3);
    }

    public AdDownloadModel gd(boolean z3) {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setAutoInstallWithoutNotification(z3);
    }

    public boolean w() {
        AdDownloadController adDownloadController = this.f35822f;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.isEnableBackDialog();
    }

    public void w(boolean z3) {
        AdDownloadController adDownloadController = this.f35822f;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setIsAutoDownloadOnCardShow(z3);
    }

    public void w(Object obj) {
        AdDownloadEventConfig adDownloadEventConfig = this.ev;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setExtraEventObject(obj);
    }

    public void w(JSONObject jSONObject) {
        AdDownloadEventConfig adDownloadEventConfig = this.ev;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setExtraJson(jSONObject);
    }

    public Object sr() {
        AdDownloadController adDownloadController = this.f35822f;
        if (adDownloadController == null) {
            return null;
        }
        return adDownloadController.getExtraClickOperation();
    }

    public void w(String str) {
        AdDownloadEventConfig adDownloadEventConfig = this.ev;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setClickItemTag(str);
    }

    public void sr(String str) {
        AdDownloadEventConfig adDownloadEventConfig = this.ev;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setQuickAppEventTag(str);
    }

    public void w(int i4) {
        AdDownloadEventConfig adDownloadEventConfig = this.ev;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setDownloadScene(i4);
    }

    public void sr(boolean z3) {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setNeedWifi(z3);
    }

    public void w(long j4) {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setExtraValue(j4);
    }

    public void sr(JSONObject jSONObject) {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setExtra(jSONObject);
    }

    public AdDownloadModel w(List<String> list) {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setBackupUrls(list);
    }

    public AdDownloadModel sr(int i4) {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setVersionCode(i4);
    }

    public boolean ux() {
        AdDownloadController adDownloadController = this.f35822f;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.isEnableMultipleDownload();
    }

    public void ux(String str) {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setMd5(str);
    }

    public boolean xv() {
        AdDownloadController adDownloadController = this.f35822f;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.isAddToDownloadManage();
    }

    public void ux(boolean z3) {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setIsShowToast(z3);
    }

    public void xv(boolean z3) {
        AdDownloadController adDownloadController = this.f35822f;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setEnableNewActivity(z3);
    }

    public AdDownloadModel ux(int i4) {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setFunnelType(i4);
    }

    public void xv(JSONObject jSONObject) {
        AdDownloadEventConfig adDownloadEventConfig = this.ev;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setParamsJson(jSONObject);
    }

    public void xv(String str) {
        AdDownloadEventConfig adDownloadEventConfig = this.ev;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setRefer(str);
    }

    public AdDownloadModel xv(long j4) {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setId(j4);
    }

    public AdDownloadModel xv(int i4) {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setModelType(i4);
    }

    public void f(String str) {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setAppName(str);
    }

    public AdDownloadModel f(boolean z3) {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setIsAd(z3);
    }

    public void c(Bundle bundle) {
        xv.c(this.f35824w);
    }

    private AdDownloadModel.Builder c(long j4, String str, boolean z3, boolean z4, String str2, JSONObject jSONObject, JSONObject jSONObject2, String str3, String str4, String str5, String str6, boolean z5, String str7, String str8, String str9) {
        AdDownloadModel.Builder fileUriProvider = new AdDownloadModel.Builder().setAdId(j4).setAppIcon(str).setIsShowNotification(z3).setAutoInstallWithoutNotification(z4).setLogExtra(str2).setExtra(jSONObject).setDistinctDir(true).setIsAd(true).setFileUriProvider(new IDownloadFileUriProvider() { // from class: com.bytedance.sdk.openadsdk.downloadnew.sr.1
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
        fileUriProvider.setDeepLink(c(j4, str7, str8, str9));
        return fileUriProvider;
    }

    private DeepLink c(long j4, String str, String str2, String str3) {
        DeepLink deepLink = new DeepLink();
        deepLink.setId(j4);
        deepLink.setOpenUrl(str);
        deepLink.setWebTitle(str2);
        deepLink.setWebUrl(str3);
        return deepLink;
    }

    private void c(String str, String str2, String str3) {
        AdDownloadModel.Builder builder = this.xv;
        if (builder == null) {
            return;
        }
        this.sr = builder.setAppIcon(str).setAppName(str2).setPackageName(str3).build();
    }

    private void c(int i4, int i5, boolean z3, boolean z4, boolean z5) {
        AdDownloadController.Builder isAddToDownloadManage = new AdDownloadController.Builder().setLinkMode(i4).setDownloadMode(i5).setIsEnableBackDialog(true).setIsAddToDownloadManage(false);
        this.ux = isAddToDownloadManage;
        if (z3) {
            isAddToDownloadManage.setEnableAH(z4);
            this.ux.setEnableAM(z5);
        }
        this.f35822f = this.ux.build();
    }

    public int c() {
        AdDownloadController adDownloadController = this.f35822f;
        if (adDownloadController == null) {
            return 0;
        }
        return adDownloadController.getLinkMode();
    }

    public void c(int i4) {
        AdDownloadController adDownloadController = this.f35822f;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setLinkMode(i4);
    }

    public void c(boolean z3) {
        AdDownloadController adDownloadController = this.f35822f;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setEnableShowComplianceDialog(z3);
    }

    public void c(Object obj) {
        AdDownloadController adDownloadController = this.f35822f;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setExtraObject(obj);
    }

    public void c(JSONObject jSONObject) {
        AdDownloadController adDownloadController = this.f35822f;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setExtraJson(jSONObject);
    }

    public void c(String str) {
        AdDownloadEventConfig adDownloadEventConfig = this.ev;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setClickButtonTag(str);
    }

    public void c(long j4) {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setExpectFileLength(j4);
    }

    public AdDownloadModel c(List<String> list) {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setClickTrackUrl(list);
    }

    public AdDownloadModel c(Map<String, String> map) {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setHeaders(map);
    }

    public AdDownloadModel c(com.ss.android.download.api.model.sr srVar) {
        AdDownloadModel adDownloadModel = this.sr;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setQuickAppModel(srVar);
    }
}
