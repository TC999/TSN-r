package com.bytedance.sdk.openadsdk.downloadnew;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.EventListener;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.api.p134ok.C6309h;
import com.bytedance.sdk.openadsdk.api.p134ok.C6310kf;
import com.bytedance.sdk.openadsdk.api.p134ok.C6311n;
import com.bytedance.sdk.openadsdk.downloadnew.core.ExitInstallListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTDownloadAdapter;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.clj.fastble.BleManager;
import com.p521ss.android.download.api.config.IDownloadButtonClickListener;
import com.p521ss.android.download.api.config.OnItemClickListener;
import com.p521ss.android.download.api.download.DownloadController;
import com.p521ss.android.download.api.download.DownloadEventConfig;
import com.p521ss.android.download.api.download.DownloadModel;
import com.p521ss.android.download.api.download.DownloadStatusChangeListener;
import com.p521ss.android.download.api.model.C11988s;
import com.p521ss.android.download.api.model.DeepLink;
import com.p521ss.android.download.api.p523bl.C11951a;
import com.p521ss.android.downloadad.api.download.AdDownloadController;
import com.p521ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.p521ss.android.downloadad.api.download.AdDownloadModel;
import com.p521ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.downloadnew.s */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6410s implements Bridge {

    /* renamed from: ok */
    private static volatile C6410s f22561ok;

    /* renamed from: a */
    private final Context f22562a;

    /* renamed from: bl */
    private AdDownloadModel.Builder f22563bl;

    /* renamed from: h */
    private AdDownloadEventConfig.Builder f22564h;

    /* renamed from: kf */
    private AdDownloadController f22565kf;

    /* renamed from: n */
    private AdDownloadController.Builder f22566n;

    /* renamed from: p */
    private AdDownloadEventConfig f22567p;

    /* renamed from: s */
    private AdDownloadModel f22568s;

    private C6410s(Context context) {
        this.f22562a = context;
    }

    /* renamed from: a */
    private void m36461a(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        AdDownloadModel.Builder m36391ok = m36391ok(((Long) map.get("id")).longValue(), (String) map.get(TTDownloadField.TT_APP_ICON), ((Boolean) map.get(TTDownloadField.TT_IS_SHOW_NOTIFICATION)).booleanValue(), ((Boolean) map.get(TTDownloadField.TT_IS_AUTO_INSTALL_WITHOUT_NOTIFICATION)).booleanValue(), (String) map.get(TTDownloadField.TT_LOG_EXTRA), (JSONObject) map.get(TTDownloadField.TT_EXTRA_JSON), (JSONObject) map.get(TTDownloadField.TT_DOWNLOAD_SETTINGS), (String) map.get(TTDownloadField.TT_FILE_PATH), (String) map.get(TTDownloadField.TT_DOWNLOAD_URL), (String) map.get("appName"), (String) map.get(TTDownloadField.TT_PACKAGE_NAME), ((Boolean) map.get(TTDownloadField.TT_IS_NEED_INDEPENDENT_PROCESS)).booleanValue(), (String) map.get(TTDownloadField.TT_OPEN_URL), (String) map.get(TTDownloadField.TT_WEB_TITLE), (String) map.get(TTDownloadField.TT_WEB_URL));
        this.f22563bl = m36391ok;
        this.f22568s = m36391ok.build();
    }

    /* renamed from: bl */
    private DownloadStatusChangeListener m36452bl(Object obj) {
        if (obj instanceof DownloadStatusChangeListener) {
            return (DownloadStatusChangeListener) obj;
        }
        if (obj instanceof EventListener) {
            return new C6311n((EventListener) obj);
        }
        return null;
    }

    private Activity getActivity(Object obj) {
        if (obj instanceof Activity) {
            return (Activity) obj;
        }
        return null;
    }

    /* renamed from: h */
    private ExitInstallListener m36428h(Object obj) {
        if (obj instanceof ExitInstallListener) {
            return (ExitInstallListener) obj;
        }
        return null;
    }

    /* renamed from: kf */
    private DownloadController m36411kf(Object obj) {
        if (obj instanceof DownloadController) {
            return (DownloadController) obj;
        }
        return null;
    }

    /* renamed from: n */
    private DownloadEventConfig m36401n(Object obj) {
        if (obj instanceof DownloadEventConfig) {
            return (DownloadEventConfig) obj;
        }
        return null;
    }

    /* renamed from: ok */
    public static C6410s m36390ok(Context context) {
        if (f22561ok == null) {
            synchronized (C6410s.class) {
                if (f22561ok == null) {
                    f22561ok = new C6410s(context);
                }
            }
        }
        return f22561ok;
    }

    /* renamed from: ok */
    private static boolean m36388ok(IDownloadButtonClickListener iDownloadButtonClickListener) {
        return iDownloadButtonClickListener != null;
    }

    /* renamed from: p */
    private OnItemClickListener m36377p(Object obj) {
        if (obj instanceof OnItemClickListener) {
            return (OnItemClickListener) obj;
        }
        if (obj instanceof EventListener) {
            return new C6309h((EventListener) obj);
        }
        return null;
    }

    /* renamed from: q */
    private IDownloadButtonClickListener m36372q(Object obj) {
        if (obj instanceof IDownloadButtonClickListener) {
            return (IDownloadButtonClickListener) obj;
        }
        if (obj instanceof EventListener) {
            return new C6310kf((EventListener) obj);
        }
        return null;
    }

    /* renamed from: qa */
    private int m36369qa() {
        AdDownloadController adDownloadController = this.f22565kf;
        if (adDownloadController == null) {
            return 0;
        }
        return adDownloadController.getDownloadMode();
    }

    /* renamed from: s */
    private DownloadModel m36358s(Object obj) {
        if (obj instanceof DownloadModel) {
            return (DownloadModel) obj;
        }
        return null;
    }

    /* renamed from: ah */
    public String m36458ah() {
        AdDownloadModel adDownloadModel = this.f22568s;
        return adDownloadModel == null ? "" : adDownloadModel.getMimeType();
    }

    /* renamed from: az */
    public boolean m36457az() {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return false;
        }
        return adDownloadModel.distinctDir();
    }

    /* renamed from: b */
    public boolean m36456b() {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return true;
        }
        return adDownloadModel.isAutoInstall();
    }

    /* renamed from: c */
    public JSONObject m36447c() {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getExtra();
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        Map<String, Object> hashMap;
        if (i == 20) {
            m36389ok((Bundle) valueSet.objectValue(0, Bundle.class));
            return null;
        }
        if (valueSet != null && valueSet.objectValue(0, Map.class) != null) {
            hashMap = (Map) valueSet.objectValue(0, Map.class);
        } else {
            hashMap = new HashMap<>();
        }
        return (T) m36386ok(cls, i, hashMap);
    }

    /* renamed from: cf */
    public void m36446cf() {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.forceHideNotification();
    }

    /* renamed from: cs */
    public String m36445cs() {
        AdDownloadModel adDownloadModel = this.f22568s;
        return adDownloadModel == null ? "" : adDownloadModel.getFileName();
    }

    /* renamed from: d */
    public DeepLink m36444d() {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getDeepLink();
    }

    /* renamed from: de */
    public String m36443de() {
        AdDownloadModel adDownloadModel = this.f22568s;
        return adDownloadModel == null ? "" : adDownloadModel.getVersionName();
    }

    /* renamed from: dn */
    public boolean m36442dn() {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return true;
        }
        return adDownloadModel.isAd();
    }

    /* renamed from: dx */
    public void m36441dx() {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.forceHideToast();
    }

    /* renamed from: e */
    public long m36440e() {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return 0L;
        }
        return adDownloadModel.getExpectFileLength();
    }

    /* renamed from: ej */
    public boolean m36439ej() {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return false;
        }
        return adDownloadModel.isInExternalPublicDir();
    }

    /* renamed from: em */
    public String m36438em() {
        AdDownloadModel adDownloadModel = this.f22568s;
        return adDownloadModel == null ? "" : adDownloadModel.getDownloadUrl();
    }

    /* renamed from: ep */
    public Object m36437ep() {
        AdDownloadEventConfig adDownloadEventConfig = this.f22567p;
        if (adDownloadEventConfig == null) {
            return null;
        }
        return adDownloadEventConfig.getExtraEventObject();
    }

    /* renamed from: er */
    public boolean m36436er() {
        AdDownloadEventConfig adDownloadEventConfig = this.f22567p;
        if (adDownloadEventConfig == null) {
            return false;
        }
        return adDownloadEventConfig.isEnableV3Event();
    }

    /* renamed from: ew */
    public boolean m36435ew() {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return false;
        }
        return adDownloadModel.needIndependentProcess();
    }

    /* renamed from: f */
    public C11988s m36434f() {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getQuickAppModel();
    }

    /* renamed from: fb */
    public JSONObject m36433fb() {
        AdDownloadEventConfig adDownloadEventConfig = this.f22567p;
        if (adDownloadEventConfig == null) {
            return null;
        }
        return adDownloadEventConfig.getExtraJson();
    }

    /* renamed from: fd */
    public long m36432fd() {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return 0L;
        }
        return adDownloadModel.getExtraValue();
    }

    /* renamed from: fl */
    public String m36431fl() {
        AdDownloadModel adDownloadModel = this.f22568s;
        return adDownloadModel == null ? "" : adDownloadModel.getMd5();
    }

    /* renamed from: g */
    public JSONObject m36430g() {
        AdDownloadEventConfig adDownloadEventConfig = this.f22567p;
        if (adDownloadEventConfig == null) {
            return null;
        }
        return adDownloadEventConfig.getParamsJson();
    }

    /* renamed from: hd */
    public int m36425hd() {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return 2;
        }
        return adDownloadModel.getExecutorGroup();
    }

    /* renamed from: i */
    public boolean m36424i() {
        AdDownloadController adDownloadController = this.f22565kf;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.enableOppoAutoDownload();
    }

    /* renamed from: io */
    public String m36422io() {
        AdDownloadEventConfig adDownloadEventConfig = this.f22567p;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getClickStartLabel();
    }

    /* renamed from: j */
    public boolean m36421j() {
        AdDownloadController adDownloadController = this.f22565kf;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.isAutoDownloadOnCardShow();
    }

    /* renamed from: je */
    public String m36419je() {
        AdDownloadModel adDownloadModel = this.f22568s;
        return adDownloadModel == null ? "" : adDownloadModel.getStartToast();
    }

    /* renamed from: jl */
    public boolean m36418jl() {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return true;
        }
        return adDownloadModel.enablePause();
    }

    /* renamed from: ju */
    public String m36417ju() {
        AdDownloadModel adDownloadModel = this.f22568s;
        return adDownloadModel == null ? "" : adDownloadModel.getAppIcon();
    }

    /* renamed from: k */
    public Object m36416k() {
        AdDownloadController adDownloadController = this.f22565kf;
        if (adDownloadController == null) {
            return null;
        }
        return adDownloadController.getExtraObject();
    }

    /* renamed from: kz */
    public boolean m36407kz() {
        AdDownloadEventConfig adDownloadEventConfig = this.f22567p;
        if (adDownloadEventConfig == null) {
            return true;
        }
        return adDownloadEventConfig.isEnableClickEvent();
    }

    /* renamed from: l */
    public Map<String, String> m36406l() {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getHeaders();
    }

    /* renamed from: ld */
    public String m36405ld() {
        AdDownloadModel adDownloadModel = this.f22568s;
        return adDownloadModel == null ? "" : adDownloadModel.getPackageName();
    }

    /* renamed from: m */
    public String m36404m() {
        AdDownloadEventConfig adDownloadEventConfig = this.f22567p;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getStorageDenyLabel();
    }

    /* renamed from: o */
    public String m36397o() {
        AdDownloadEventConfig adDownloadEventConfig = this.f22567p;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getClickPauseLabel();
    }

    /* renamed from: pb */
    public boolean m36374pb() {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return false;
        }
        return adDownloadModel.autoInstallWithoutNotification();
    }

    /* renamed from: qh */
    public boolean m36368qh() {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return C11951a.m19664ok(C12534ok.m17589ok(m36347tg()), m36458ah());
        }
        return adDownloadModel.shouldDownloadWithPatchApply();
    }

    /* renamed from: qu */
    public String m36367qu() {
        AdDownloadModel adDownloadModel = this.f22568s;
        return adDownloadModel == null ? "" : adDownloadModel.getNotificationJumpUrl();
    }

    /* renamed from: qx */
    public boolean m36366qx() {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return false;
        }
        return adDownloadModel.isInExternalPublicDir();
    }

    /* renamed from: r */
    public boolean m36365r() {
        AdDownloadController adDownloadController = this.f22565kf;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.enableShowComplianceDialog();
    }

    /* renamed from: rh */
    public boolean m36363rh() {
        AdDownloadController adDownloadController = this.f22565kf;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.enableAH();
    }

    /* renamed from: ry */
    public int m36361ry() {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return 0;
        }
        return adDownloadModel.getVersionCode();
    }

    /* renamed from: sg */
    public List<String> m36353sg() {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getBackupUrls();
    }

    /* renamed from: sj */
    public String m36352sj() {
        AdDownloadModel adDownloadModel = this.f22568s;
        return adDownloadModel == null ? "" : adDownloadModel.getStartToast();
    }

    /* renamed from: sr */
    public List<String> m36351sr() {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getClickTrackUrl();
    }

    /* renamed from: t */
    public boolean m36350t() {
        AdDownloadController adDownloadController = this.f22565kf;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.enableAM();
    }

    /* renamed from: td */
    public String m36348td() {
        AdDownloadEventConfig adDownloadEventConfig = this.f22567p;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getClickButtonTag();
    }

    /* renamed from: tg */
    public JSONObject m36347tg() {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.getDownloadSettings();
    }

    /* renamed from: to */
    public String m36346to() {
        AdDownloadModel adDownloadModel = this.f22568s;
        return adDownloadModel == null ? "" : adDownloadModel.getLogExtra();
    }

    /* renamed from: tr */
    public String m36345tr() {
        AdDownloadModel adDownloadModel = this.f22568s;
        return adDownloadModel == null ? "" : adDownloadModel.getFilePath();
    }

    /* renamed from: u */
    public String m36344u() {
        AdDownloadEventConfig adDownloadEventConfig = this.f22567p;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getClickLabel();
    }

    /* renamed from: ul */
    public String m36343ul() {
        AdDownloadEventConfig adDownloadEventConfig = this.f22567p;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getClickPauseLabel();
    }

    /* renamed from: v */
    public long m36342v() {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return 0L;
        }
        return adDownloadModel.getId();
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return C5930a.m37925b().m37918i(0, C6391bl.f22541ok).m37919h(1, Boolean.valueOf(C6391bl.f22536a)).m37921f(BleManager.f22896l, 3).m37926a();
    }

    /* renamed from: vk */
    public boolean m36341vk() {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return true;
        }
        return adDownloadModel.isShowNotification();
    }

    /* renamed from: vz */
    public int m36340vz() {
        AdDownloadEventConfig adDownloadEventConfig = this.f22567p;
        if (adDownloadEventConfig == null) {
            return 0;
        }
        return adDownloadEventConfig.getDownloadScene();
    }

    /* renamed from: w */
    public void m36339w() {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.forceWifi();
    }

    /* renamed from: wv */
    public boolean m36338wv() {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return true;
        }
        return adDownloadModel.isShowToast();
    }

    /* renamed from: x */
    public String m36337x() {
        AdDownloadEventConfig adDownloadEventConfig = this.f22567p;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getRefer();
    }

    /* renamed from: xh */
    public int m36335xh() {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return 1;
        }
        return adDownloadModel.getFunnelType();
    }

    /* renamed from: xy */
    public String m36334xy() {
        AdDownloadModel adDownloadModel = this.f22568s;
        return adDownloadModel == null ? "" : adDownloadModel.getName();
    }

    /* renamed from: y */
    public String m36333y() {
        AdDownloadEventConfig adDownloadEventConfig = this.f22567p;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getClickInstallLabel();
    }

    /* renamed from: yt */
    public boolean m36332yt() {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return false;
        }
        return adDownloadModel.isNeedWifi();
    }

    /* renamed from: yz */
    public int m36331yz() {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return 0;
        }
        return adDownloadModel.getModelType();
    }

    /* renamed from: z */
    public boolean m36330z() {
        AdDownloadController adDownloadController = this.f22565kf;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.enableNewActivity();
    }

    /* renamed from: zz */
    public String m36328zz() {
        AdDownloadEventConfig adDownloadEventConfig = this.f22567p;
        return adDownloadEventConfig == null ? "" : adDownloadEventConfig.getClickItemTag();
    }

    /* renamed from: k */
    private void m36414k(boolean z) {
        AdDownloadController adDownloadController = this.f22565kf;
        if (adDownloadController == null) {
            return;
        }
        try {
            adDownloadController.setEnableOppoAutoDownload(z);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: kf */
    private void m36412kf(int i) {
        AdDownloadController adDownloadController = this.f22565kf;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setDownloadMode(i);
    }

    /* renamed from: n */
    private void m36399n(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        int intValue = ((Integer) map.get(TTDownloadField.TT_DOWNLOAD_SCENE)).intValue();
        boolean booleanValue = ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_CLICK_EVENT)).booleanValue();
        boolean booleanValue2 = ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_V3_EVENT)).booleanValue();
        JSONObject jSONObject = (JSONObject) map.get(TTDownloadField.TT_EXTRA_EVENT_OBJECT);
        AdDownloadEventConfig.Builder paramsJson = new AdDownloadEventConfig.Builder().setClickButtonTag((String) map.get(TTDownloadField.TT_CLICK_BUTTON_TAG)).setClickItemTag((String) map.get(TTDownloadField.TT_CLICK_ITEM_TAG)).setClickLabel((String) map.get(TTDownloadField.TT_CLICK_LABEL)).setClickStartLabel((String) map.get(TTDownloadField.TT_LABEL_CLICK_START)).setClickContinueLabel((String) map.get(TTDownloadField.TT_LABEL_CLICK_CONTINUE)).setClickPauseLabel((String) map.get(TTDownloadField.TT_LABEL_CLICK_PAUSE)).setStorageDenyLabel((String) map.get(TTDownloadField.TT_LABEL_STORAGE_DENY)).setClickInstallLabel((String) map.get(TTDownloadField.TT_LABEL_CLICK_INSTALL)).setIsEnableClickEvent(booleanValue).setDownloadScene(intValue).setIsEnableV3Event(booleanValue2).setRefer((String) map.get(TTDownloadField.TT_REFER)).setExtraJson((JSONObject) map.get(TTDownloadField.TT_EXTRA_JSON)).setParamsJson((JSONObject) map.get(TTDownloadField.TT_PARAMS_JSON));
        this.f22564h = paramsJson;
        if (jSONObject != null) {
            paramsJson.setExtraEventObject(jSONObject);
        }
        this.f22567p = this.f22564h.build();
    }

    /* renamed from: s */
    private void m36356s(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        boolean booleanValue = ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_CLICK_EVENT)).booleanValue();
        boolean booleanValue2 = ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_V3_EVENT)).booleanValue();
        JSONObject jSONObject = (JSONObject) map.get(TTDownloadField.TT_EXTRA_EVENT_OBJECT);
        AdDownloadEventConfig.Builder isEnableV3Event = new AdDownloadEventConfig.Builder().setClickButtonTag((String) map.get(TTDownloadField.TT_CLICK_BUTTON_TAG)).setClickItemTag((String) map.get(TTDownloadField.TT_CLICK_ITEM_TAG)).setClickStartLabel((String) map.get(TTDownloadField.TT_LABEL_CLICK_START)).setClickContinueLabel((String) map.get(TTDownloadField.TT_LABEL_CLICK_CONTINUE)).setClickPauseLabel((String) map.get(TTDownloadField.TT_LABEL_CLICK_PAUSE)).setStorageDenyLabel((String) map.get(TTDownloadField.TT_LABEL_STORAGE_DENY)).setClickInstallLabel((String) map.get(TTDownloadField.TT_LABEL_CLICK_INSTALL)).setIsEnableClickEvent(booleanValue).setIsEnableV3Event(booleanValue2);
        this.f22564h = isEnableV3Event;
        if (jSONObject != null) {
            isEnableV3Event.setExtraEventObject(jSONObject);
        }
        this.f22567p = this.f22564h.build();
    }

    /* renamed from: h */
    public boolean m36429h() {
        AdDownloadController adDownloadController = this.f22565kf;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.shouldUseNewWebView();
    }

    /* renamed from: i */
    public AdDownloadModel m36423i(String str) {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setFileName(str);
    }

    /* renamed from: j */
    public AdDownloadModel m36420j(String str) {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setDownloadUrl(str);
    }

    /* renamed from: r */
    public AdDownloadModel m36364r(String str) {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setAppIcon(str);
    }

    /* renamed from: rh */
    public AdDownloadModel m36362rh(String str) {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setMimeType(str);
    }

    /* renamed from: t */
    public AdDownloadModel m36349t(String str) {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setFilePath(str);
    }

    /* renamed from: x */
    public AdDownloadModel m36336x(String str) {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setVersionName(str);
    }

    /* renamed from: z */
    public AdDownloadModel m36329z(String str) {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setNotificationJumpUrl(str);
    }

    /* renamed from: bl */
    private void m36450bl(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        int intValue = ((Integer) map.get(TTDownloadField.TT_LINK_MODE)).intValue();
        int intValue2 = ((Integer) map.get(TTDownloadField.TT_DOWNLOAD_MODE)).intValue();
        boolean booleanValue = ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_BACK_DIALOG)).booleanValue();
        boolean booleanValue2 = ((Boolean) map.get(TTDownloadField.TT_IS_ADD_TO_DOWNLOAD_MANAGE)).booleanValue();
        Object obj = map.get(TTDownloadField.TT_EXTRA_OPERATION);
        boolean booleanValue3 = ((Boolean) map.get(TTDownloadField.TT_SHOULD_USE_NEW_WEB_VIEW)).booleanValue();
        int intValue3 = ((Integer) map.get(TTDownloadField.TT_INTERCEPT_FLAG)).intValue();
        Object obj2 = map.get(TTDownloadField.TT_EXTRA_OBJECT);
        boolean booleanValue4 = ((Boolean) map.get(TTDownloadField.TT_ENABLE_SHOW_COMPLIANCE_DIALOG)).booleanValue();
        boolean booleanValue5 = ((Boolean) map.get(TTDownloadField.TT_IS_AUTO_DOWNLOAD_ON_CARD_SHOW)).booleanValue();
        boolean booleanValue6 = ((Boolean) map.get(TTDownloadField.TT_ENABLE_NEW_ACTIVITY)).booleanValue();
        boolean booleanValue7 = ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_AH)).booleanValue();
        boolean booleanValue8 = ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_AM)).booleanValue();
        AdDownloadController.Builder enableOppoAutoDownload = new AdDownloadController.Builder().setLinkMode(intValue).setDownloadMode(intValue2).setIsEnableBackDialog(booleanValue).setIsAddToDownloadManage(booleanValue2).setExtraOperation(obj).setShouldUseNewWebView(booleanValue3).setInterceptFlag(intValue3).setExtraJson((JSONObject) map.get(TTDownloadField.TT_EXTRA_JSON)).setExtraObject(obj2).setEnableShowComplianceDialog(booleanValue4).setIsAutoDownloadOnCardShow(booleanValue5).setEnableNewActivity(booleanValue6).setEnableAH(booleanValue7).setEnableAM(booleanValue8).setEnableOppoAutoDownload(((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_OPPO_AUTO_DOWNLOAD)).booleanValue());
        this.f22566n = enableOppoAutoDownload;
        this.f22565kf = enableOppoAutoDownload.build();
    }

    /* renamed from: h */
    public void m36427h(String str) {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setStartToast(str);
    }

    /* renamed from: k */
    public AdDownloadModel m36415k(String str) {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setPackageName(str);
    }

    /* renamed from: kf */
    public int m36413kf() {
        AdDownloadController adDownloadController = this.f22565kf;
        if (adDownloadController == null) {
            return 1;
        }
        return adDownloadController.getDowloadChunkCount();
    }

    /* renamed from: p */
    public int m36378p() {
        AdDownloadController adDownloadController = this.f22565kf;
        if (adDownloadController == null) {
            return 0;
        }
        return adDownloadController.getInterceptFlag();
    }

    /* renamed from: q */
    public JSONObject m36373q() {
        AdDownloadController adDownloadController = this.f22565kf;
        if (adDownloadController == null) {
            return null;
        }
        return adDownloadController.getExtraJson();
    }

    /* renamed from: kf */
    private void m36409kf(Map<String, Object> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        long longValue = ((Long) map.get(TTDownloadField.TT_EXPECT_FILE_LENGTH)).longValue();
        long longValue2 = ((Long) map.get(TTDownloadField.TT_EXTRA_VALUE)).longValue();
        boolean booleanValue = ((Boolean) map.get(TTDownloadField.TT_IS_AD)).booleanValue();
        int intValue = ((Integer) map.get(TTDownloadField.TT_MODEL_TYPE)).intValue();
        String str = (String) map.get(TTDownloadField.TT_MIME_TYPE);
        Map<String, String> map2 = (Map) map.get(TTDownloadField.TT_HEADERS);
        boolean booleanValue2 = ((Boolean) map.get(TTDownloadField.TT_IS_SHOW_TOAST)).booleanValue();
        boolean booleanValue3 = ((Boolean) map.get(TTDownloadField.TT_NEED_WIFI)).booleanValue();
        String str2 = (String) map.get(TTDownloadField.TT_FILE_NAME);
        int intValue2 = ((Integer) map.get(TTDownloadField.TT_VERSION_CODE)).intValue();
        String str3 = (String) map.get(TTDownloadField.TT_VERSION_NAME);
        C11988s m19535ok = new C11988s.C11989ok().m19533ok((String) map.get(TTDownloadField.TT_QUICK_APP_MODEL_OPEN_URL)).m19536a((String) map.get(TTDownloadField.TT_QUICK_APP_MODEL_EXTRA_DATA)).m19535ok();
        int intValue3 = ((Integer) map.get(TTDownloadField.TT_EXECUTOR_GROUP)).intValue();
        String str4 = (String) map.get(TTDownloadField.TT_START_TOAST);
        String str5 = (String) map.get(TTDownloadField.TT_SDK_MONITOR_SCENE);
        boolean booleanValue4 = ((Boolean) map.get(TTDownloadField.TT_AUTO_INSTALL)).booleanValue();
        boolean booleanValue5 = ((Boolean) map.get(TTDownloadField.TT_DISTINCT_DIR)).booleanValue();
        boolean booleanValue6 = ((Boolean) map.get(TTDownloadField.TT_ENABLE_PAUSE)).booleanValue();
        long longValue3 = ((Long) map.get("id")).longValue();
        boolean booleanValue7 = ((Boolean) map.get(TTDownloadField.TT_IS_SHOW_NOTIFICATION)).booleanValue();
        boolean booleanValue8 = ((Boolean) map.get(TTDownloadField.TT_IS_AUTO_INSTALL_WITHOUT_NOTIFICATION)).booleanValue();
        JSONObject jSONObject = (JSONObject) map.get(TTDownloadField.TT_EXTRA_JSON);
        JSONObject jSONObject2 = (JSONObject) map.get(TTDownloadField.TT_DOWNLOAD_SETTINGS);
        String str6 = (String) map.get(TTDownloadField.TT_FILE_PATH);
        String str7 = (String) map.get(TTDownloadField.TT_DOWNLOAD_URL);
        String str8 = (String) map.get("appName");
        String str9 = (String) map.get(TTDownloadField.TT_PACKAGE_NAME);
        boolean booleanValue9 = ((Boolean) map.get(TTDownloadField.TT_IS_NEED_INDEPENDENT_PROCESS)).booleanValue();
        String str10 = (String) map.get(TTDownloadField.TT_OPEN_URL);
        String str11 = (String) map.get(TTDownloadField.TT_WEB_TITLE);
        String str12 = (String) map.get(TTDownloadField.TT_WEB_URL);
        AdDownloadModel.Builder fileUriProvider = new AdDownloadModel.Builder().setExpectFileLength(longValue).setMd5((String) map.get("md5")).setId(longValue3).setExtraValue(longValue2).setIsAd(booleanValue).setModelType(intValue).setLogExtra((String) map.get(TTDownloadField.TT_LOG_EXTRA)).setAppIcon((String) map.get(TTDownloadField.TT_APP_ICON)).setBackupUrls((List) map.get(TTDownloadField.TT_BACK_UP_URLS)).setNotificationJumpUrl((String) map.get(TTDownloadField.TT_NOTIFICATION_JUMP_URL)).setClickTrackUrl((List) map.get(TTDownloadField.TT_CLICK_TRACK_URL)).setMimeType(str).setHeaders(map2).setIsShowToast(booleanValue2).setIsShowNotification(booleanValue7).setNeedWifi(booleanValue3).setFileName(str2).setVersionCode(intValue2).setVersionName(str3).setQuickAppModel(m19535ok).setAutoInstallWithoutNotification(booleanValue8).setExecutorGroup(intValue3).setStartToast(str4).setSdkMonitorScene(str5).setAutoInstall(booleanValue4).setDistinctDir(booleanValue5).setEnablePause(booleanValue6).setExtra(jSONObject).setFileUriProvider(new IDownloadFileUriProvider() { // from class: com.bytedance.sdk.openadsdk.downloadnew.s.2
            @Override // com.p521ss.android.socialbase.downloader.depend.IDownloadFileUriProvider
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
        fileUriProvider.setDeepLink(m36392ok(longValue3, str10, str11, str12));
        this.f22568s = this.f22563bl.build();
    }

    /* renamed from: h */
    public AdDownloadModel m36426h(boolean z) {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setIsShowNotification(z);
    }

    /* renamed from: ok */
    public <T> T m36386ok(Class<T> cls, int i, Map<String, Object> map) {
        DownloadModel m36358s;
        DownloadModel m36358s2;
        DownloadEventConfig m36401n;
        DownloadController m36411kf;
        DownloadModel m36358s3;
        DownloadEventConfig m36401n2;
        DownloadController m36411kf2;
        DownloadEventConfig m36401n3;
        DownloadController m36411kf3;
        DownloadEventConfig m36401n4;
        DownloadController m36411kf4;
        switch (i) {
            case 0:
                return (T) Boolean.valueOf(C6391bl.m36483ok(getActivity(map.get(TTDownloadField.TT_ACTIVITY)), m36428h(map.get(TTDownloadField.TT_EXIT_INSTALL_LISTENER))));
            case 1:
                return (T) C6391bl.m36486ok().m18575kf();
            case 2:
                try {
                    return (T) Boolean.valueOf(C6391bl.m36474ok((String) map.get(TTDownloadField.TT_TAG_INTERCEPT), (String) map.get(TTDownloadField.TT_LABEL), new JSONObject((String) map.get(TTDownloadField.TT_META)), new HashMap()));
                } catch (JSONException unused) {
                    return (T) Boolean.FALSE;
                }
            case 3:
                C6391bl.m36485ok(((Integer) map.get(TTDownloadField.TT_HID)).intValue());
                return null;
            case 4:
                AdDownloadModel adDownloadModel = this.f22568s;
                C6391bl.m36486ok().m18567ok(adDownloadModel == null ? (String) map.get(TTDownloadField.TT_DOWNLOAD_URL) : adDownloadModel.getDownloadUrl(), ((Integer) map.get(TTDownloadField.TT_HASHCODE)).intValue());
                return null;
            case 5:
                int intValue = ((Integer) map.get(TTDownloadField.TT_HASHCODE)).intValue();
                AdDownloadModel adDownloadModel2 = this.f22568s;
                if (adDownloadModel2 == null) {
                    m36358s = m36358s(map.get(TTDownloadField.TT_DOWNLOAD_MODEL));
                } else {
                    m36358s = m36358s(adDownloadModel2);
                }
                C6391bl.m36486ok().m18571ok(this.f22562a, intValue, m36452bl(map.get(TTDownloadField.TT_DOWNLOAD_STATUSCHANGE_LISTENER)), m36358s);
                return null;
            case 6:
                AdDownloadModel adDownloadModel3 = this.f22568s;
                return (T) Boolean.valueOf(C6391bl.m36479ok(this.f22562a, adDownloadModel3 == null ? (String) map.get(TTDownloadField.TT_DOWNLOAD_URL) : adDownloadModel3.getDownloadUrl()));
            case 7:
                C6391bl.m36494a();
                return null;
            case 8:
                AdDownloadModel adDownloadModel4 = this.f22568s;
                C6391bl.m36486ok().m18562ok(adDownloadModel4 == null ? (String) map.get(TTDownloadField.TT_DOWNLOAD_URL) : adDownloadModel4.getDownloadUrl(), ((Boolean) map.get(TTDownloadField.TT_FORCE)).booleanValue());
                return null;
            case 9:
                C6391bl.m36484ok(((Integer) map.get("id")).intValue(), (ITTDownloadAdapter.OnEventLogHandler) map.get(TTDownloadField.TT_ONEVENT_LOG_HANDLER));
                return null;
            case 10:
                C6391bl.m36475ok((String) map.get(TTDownloadField.TT_DOWNLOAD_PATH));
                return null;
            case 11:
            case 20:
            case 21:
            case 22:
            case 43:
            case 77:
            case 126:
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_DEEP_LINK /* 138 */:
            default:
                return null;
            case 12:
                Uri uri = (Uri) map.get("uri");
                AdDownloadModel adDownloadModel5 = this.f22568s;
                if (adDownloadModel5 == null) {
                    m36358s2 = m36358s(map.get(TTDownloadField.TT_DOWNLOAD_MODEL));
                } else {
                    m36358s2 = m36358s(adDownloadModel5);
                }
                AdDownloadEventConfig adDownloadEventConfig = this.f22567p;
                if (adDownloadEventConfig == null) {
                    m36401n = m36401n(map.get(TTDownloadField.TT_DOWNLOAD_EVENT_CONFIG));
                } else {
                    m36401n = m36401n(adDownloadEventConfig);
                }
                AdDownloadController adDownloadController = this.f22565kf;
                if (adDownloadController == null) {
                    m36411kf = m36411kf(map.get(TTDownloadField.TT_DOWNLOAD_CONTROLLER));
                } else {
                    m36411kf = m36411kf(adDownloadController);
                }
                IDownloadButtonClickListener m36372q = m36372q(map.get(TTDownloadField.TT_DOWNLOAD_BUTTON_CLICK_LISTENER));
                if (m36388ok(m36372q)) {
                    return (T) Boolean.valueOf(C6391bl.m36480ok(this.f22562a, uri, m36358s2, m36401n, m36411kf, m36372q));
                }
                return (T) Boolean.valueOf(C6391bl.m36481ok(this.f22562a, uri, m36358s2, m36401n, m36411kf));
            case 13:
                int intValue2 = ((Integer) map.get(TTDownloadField.TT_HASHCODE)).intValue();
                boolean booleanValue = ((Boolean) map.get(TTDownloadField.TT_IS_DISABLE_DIALOG)).booleanValue();
                String str = (String) map.get(TTDownloadField.TT_USERAGENT);
                AdDownloadModel adDownloadModel6 = this.f22568s;
                if (adDownloadModel6 == null) {
                    m36358s3 = m36358s(map.get(TTDownloadField.TT_DOWNLOAD_MODEL));
                } else {
                    m36358s3 = m36358s(adDownloadModel6);
                }
                DownloadModel downloadModel = m36358s3;
                AdDownloadEventConfig adDownloadEventConfig2 = this.f22567p;
                if (adDownloadEventConfig2 == null) {
                    m36401n2 = m36401n(map.get(TTDownloadField.TT_DOWNLOAD_EVENT_CONFIG));
                } else {
                    m36401n2 = m36401n(adDownloadEventConfig2);
                }
                DownloadEventConfig downloadEventConfig = m36401n2;
                AdDownloadController adDownloadController2 = this.f22565kf;
                if (adDownloadController2 == null) {
                    m36411kf2 = m36411kf(map.get(TTDownloadField.TT_DOWNLOAD_CONTROLLER));
                } else {
                    m36411kf2 = m36411kf(adDownloadController2);
                }
                DownloadController downloadController = m36411kf2;
                DownloadStatusChangeListener m36452bl = m36452bl(map.get(TTDownloadField.TT_DOWNLOAD_STATUSCHANGE_LISTENER));
                IDownloadButtonClickListener m36372q2 = m36372q(map.get(TTDownloadField.TT_DOWNLOAD_BUTTON_CLICK_LISTENER));
                if (m36388ok(m36372q2)) {
                    C6391bl.m36486ok().m18574n().mo19415ok(this.f22562a, str, booleanValue, downloadModel, downloadEventConfig, downloadController, m36452bl, intValue2, m36372q2);
                    return null;
                }
                C6391bl.m36486ok().m18574n().mo19416ok(this.f22562a, str, booleanValue, downloadModel, downloadEventConfig, downloadController, m36452bl, intValue2);
                return null;
            case 14:
                AdDownloadModel adDownloadModel7 = this.f22568s;
                long longValue = adDownloadModel7 == null ? ((Long) map.get("id")).longValue() : adDownloadModel7.getId();
                AdDownloadModel adDownloadModel8 = this.f22568s;
                return (T) Boolean.valueOf(C6391bl.m36486ok().m18574n().mo19419ok(this.f22562a, longValue, adDownloadModel8 == null ? (String) map.get(TTDownloadField.TT_LOG_EXTRA) : adDownloadModel8.getLogExtra(), (DownloadStatusChangeListener) null, ((Integer) map.get(TTDownloadField.TT_HASHCODE)).intValue()));
            case 15:
                return (T) Boolean.valueOf(C6391bl.m36477ok((Uri) map.get("uri")));
            case 16:
                AdDownloadModel adDownloadModel9 = this.f22568s;
                String downloadUrl = adDownloadModel9 == null ? (String) map.get(TTDownloadField.TT_DOWNLOAD_URL) : adDownloadModel9.getDownloadUrl();
                AdDownloadModel adDownloadModel10 = this.f22568s;
                long longValue2 = adDownloadModel10 == null ? ((Long) map.get("id")).longValue() : adDownloadModel10.getId();
                int intValue3 = ((Integer) map.get(TTDownloadField.TT_ACTION_TYPE_BUTTON)).intValue();
                AdDownloadEventConfig adDownloadEventConfig3 = this.f22567p;
                if (adDownloadEventConfig3 == null) {
                    m36401n3 = m36401n(map.get(TTDownloadField.TT_DOWNLOAD_EVENT_CONFIG));
                } else {
                    m36401n3 = m36401n(adDownloadEventConfig3);
                }
                DownloadEventConfig downloadEventConfig2 = m36401n3;
                AdDownloadController adDownloadController3 = this.f22565kf;
                if (adDownloadController3 == null) {
                    m36411kf3 = m36411kf(map.get(TTDownloadField.TT_DOWNLOAD_CONTROLLER));
                } else {
                    m36411kf3 = m36411kf(adDownloadController3);
                }
                C6391bl.m36486ok().m18566ok(downloadUrl, longValue2, intValue3, downloadEventConfig2, m36411kf3);
                return null;
            case 17:
                AdDownloadModel adDownloadModel11 = this.f22568s;
                String downloadUrl2 = adDownloadModel11 == null ? (String) map.get(TTDownloadField.TT_DOWNLOAD_URL) : adDownloadModel11.getDownloadUrl();
                long longValue3 = ((Long) map.get("id")).longValue();
                int intValue4 = ((Integer) map.get(TTDownloadField.TT_ACTION_TYPE_BUTTON)).intValue();
                AdDownloadEventConfig adDownloadEventConfig4 = this.f22567p;
                if (adDownloadEventConfig4 == null) {
                    m36401n4 = m36401n(map.get(TTDownloadField.TT_DOWNLOAD_EVENT_CONFIG));
                } else {
                    m36401n4 = m36401n(adDownloadEventConfig4);
                }
                DownloadEventConfig downloadEventConfig3 = m36401n4;
                AdDownloadController adDownloadController4 = this.f22565kf;
                if (adDownloadController4 == null) {
                    m36411kf4 = m36411kf(map.get(TTDownloadField.TT_DOWNLOAD_CONTROLLER));
                } else {
                    m36411kf4 = m36411kf(adDownloadController4);
                }
                C6391bl.m36486ok().m18564ok(downloadUrl2, longValue3, intValue4, downloadEventConfig3, m36411kf4, m36377p(map.get(TTDownloadField.TT_ITEM_CLICK_LISTENER)), m36372q(map.get(TTDownloadField.TT_DOWNLOAD_BUTTON_CLICK_LISTENER)));
                return null;
            case 18:
                AdDownloadModel adDownloadModel12 = this.f22568s;
                return (T) Boolean.valueOf(C6391bl.m36486ok().m18574n().mo19421ok(adDownloadModel12 == null ? ((Long) map.get("id")).longValue() : adDownloadModel12.getId(), ((Integer) map.get(TTDownloadField.TT_HASHCODE)).intValue()));
            case 19:
                AdDownloadModel adDownloadModel13 = this.f22568s;
                return (T) Boolean.valueOf(C6391bl.m36486ok().m18574n().mo19422ok(adDownloadModel13 == null ? ((Long) map.get("id")).longValue() : adDownloadModel13.getId()));
            case 23:
                if (((Boolean) map.get(TTDownloadField.TT_MATE_IS_EMPTY)).booleanValue()) {
                    AdDownloadModel.Builder builder = new AdDownloadModel.Builder();
                    this.f22563bl = builder;
                    this.f22568s = builder.build();
                    return null;
                }
                m36461a(map);
                return null;
            case 24:
                m36383ok((String) map.get(TTDownloadField.TT_APP_ICON), (String) map.get("appName"), (String) map.get(TTDownloadField.TT_PACKAGE_NAME));
                return null;
            case 25:
                m36394ok(((Integer) map.get(TTDownloadField.TT_AUTO_OPEN)).intValue(), ((Integer) map.get(TTDownloadField.TT_DOWNLOAD_MODE)).intValue(), ((Boolean) map.get(TTDownloadField.TT_IS_HAVE_DOWNLOAD_SDK_CONFIG)).booleanValue(), ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_AH)).booleanValue(), ((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_AM)).booleanValue());
                return null;
            case 26:
                m36412kf(((Integer) map.get(TTDownloadField.TT_DOWNLOAD_MODE)).intValue());
                return null;
            case 27:
                return (T) Integer.valueOf(m36369qa());
            case 28:
                m36414k(((Boolean) map.get(TTDownloadField.TT_IS_ENABLE_OPPO_AUTO_DOWNLOAD)).booleanValue());
                return null;
            case 29:
                m36356s(map);
                return null;
            case 30:
                m36466a(((Integer) map.get(TTDownloadField.TT_DOWNLOAD_SCENE)).intValue());
                return null;
            case 31:
                m36398n(((Boolean) map.get(TTDownloadField.TT_IS_SHOW_TOAST)).booleanValue());
                return null;
            case 32:
                m36450bl(map);
                return null;
            case 33:
                return (T) Integer.valueOf(m36396ok());
            case 34:
                return (T) Boolean.valueOf(m36467a());
            case 35:
                return (T) Boolean.valueOf(m36455bl());
            case 36:
                return (T) m36360s();
            case 37:
                return (T) Boolean.valueOf(m36403n());
            case 38:
                return (T) Integer.valueOf(m36413kf());
            case 39:
                return (T) Boolean.valueOf(m36429h());
            case 40:
                return (T) Integer.valueOf(m36378p());
            case 41:
                return (T) m36373q();
            case 42:
                return (T) m36416k();
            case 44:
                m36395ok(((Integer) map.get(TTDownloadField.TT_LINK_MODE)).intValue());
                return null;
            case 45:
                return (T) Boolean.valueOf(m36365r());
            case 46:
                m36379ok(((Boolean) map.get(TTDownloadField.TT_ENABLE_SHOW_COMPLIANCE_DIALOG)).booleanValue());
                return null;
            case 47:
                return (T) Boolean.valueOf(m36421j());
            case 48:
                return (T) Boolean.valueOf(m36330z());
            case 49:
                m36459a(((Boolean) map.get(TTDownloadField.TT_IS_AUTO_DOWNLOAD_ON_CARD_SHOW)).booleanValue());
                return null;
            case 50:
                m36448bl(((Boolean) map.get(TTDownloadField.TT_ENABLE_NEW_ACTIVITY)).booleanValue());
                return null;
            case 51:
                return (T) Boolean.valueOf(m36363rh());
            case 52:
                return (T) Boolean.valueOf(m36350t());
            case 53:
                m36385ok(map.get(TTDownloadField.TT_EXTRA_OBJECT));
                return null;
            case 54:
                m36380ok((JSONObject) map.get(TTDownloadField.TT_EXTRA_JSON));
                return null;
            case 55:
                return (T) Boolean.valueOf(m36424i());
            case 56:
                m36399n(map);
                return null;
            case 57:
                return (T) String.valueOf(m36337x());
            case 58:
                return (T) String.valueOf(m36348td());
            case 59:
                return (T) String.valueOf(m36328zz());
            case 60:
                return (T) String.valueOf(m36344u());
            case 61:
                return (T) String.valueOf(m36422io());
            case 62:
                return (T) String.valueOf(m36343ul());
            case 63:
                return (T) String.valueOf(m36397o());
            case 64:
                return (T) String.valueOf(m36333y());
            case 65:
                return (T) String.valueOf(m36404m());
            case 66:
                return (T) m36437ep();
            case 67:
                return (T) Integer.valueOf(m36340vz());
            case 68:
                return (T) Boolean.valueOf(m36407kz());
            case 69:
                return (T) Boolean.valueOf(m36436er());
            case 70:
                return (T) m36433fb();
            case 71:
                return (T) m36430g();
            case 72:
                m36464a(map.get(TTDownloadField.TT_EXTRA_EVENT_OBJECT));
                return null;
            case 73:
                m36384ok((String) map.get(TTDownloadField.TT_CLICK_BUTTON_TAG));
                return null;
            case 74:
                m36460a((JSONObject) map.get(TTDownloadField.TT_EVENT_CONFIG_EXTRA_JSON));
                return null;
            case 75:
                m36449bl((JSONObject) map.get(TTDownloadField.TT_PARAMS_JSON));
                return null;
            case 76:
                m36463a((String) map.get(TTDownloadField.TT_CLICK_ITEM_TAG));
                return null;
            case 78:
                m36451bl((String) map.get(TTDownloadField.TT_REFER));
                return null;
            case 79:
                m36357s((String) map.get(TTDownloadField.TT_QUICK_APP_EVENT_TAG));
                return null;
            case 80:
                m36409kf(map);
                return null;
            case 81:
                return (T) Long.valueOf(m36342v());
            case 82:
                return (T) String.valueOf(m36431fl());
            case 83:
                return (T) Long.valueOf(m36440e());
            case 84:
                return (T) Long.valueOf(m36432fd());
            case 85:
                return (T) String.valueOf(m36438em());
            case 86:
                return (T) m36353sg();
            case 87:
                return (T) String.valueOf(m36367qu());
            case 88:
                return (T) String.valueOf(m36334xy());
            case 89:
                return (T) String.valueOf(m36458ah());
            case 90:
                return (T) m36406l();
            case 91:
                return (T) Boolean.valueOf(m36338wv());
            case 92:
                return (T) Boolean.valueOf(m36341vk());
            case 93:
                return (T) Boolean.valueOf(m36332yt());
            case 94:
                return (T) Boolean.valueOf(m36439ej());
            case 95:
                return (T) Boolean.valueOf(m36366qx());
            case 96:
                return (T) String.valueOf(m36345tr());
            case 97:
                return (T) String.valueOf(m36445cs());
            case 98:
                m36339w();
                return null;
            case 99:
                return (T) m36347tg();
            case 100:
                m36441dx();
                return null;
            case 101:
                m36446cf();
                return null;
            case 102:
                return (T) Boolean.valueOf(m36435ew());
            case 103:
                return (T) Integer.valueOf(m36361ry());
            case 104:
                return (T) String.valueOf(m36443de());
            case 105:
                return (T) Boolean.valueOf(m36442dn());
            case 106:
                return (T) String.valueOf(m36346to());
            case 107:
                return (T) String.valueOf(m36405ld());
            case 108:
                return (T) String.valueOf(m36417ju());
            case 109:
                return (T) m36444d();
            case 110:
                return (T) m36351sr();
            case 111:
                return (T) m36447c();
            case 112:
                return (T) Integer.valueOf(m36331yz());
            case 113:
                return (T) m36434f();
            case 114:
                return (T) Boolean.valueOf(m36374pb());
            case 115:
                return (T) Boolean.valueOf(m36368qh());
            case 116:
                return (T) Integer.valueOf(m36425hd());
            case 117:
                return (T) Integer.valueOf(m36335xh());
            case 118:
                return (T) String.valueOf(m36419je());
            case 119:
                return (T) String.valueOf(m36352sj());
            case 120:
                return (T) Boolean.valueOf(m36456b());
            case 121:
                return (T) Boolean.valueOf(m36457az());
            case 122:
                return (T) Boolean.valueOf(m36418jl());
            case 123:
                m36400n((String) map.get("md5"));
                return null;
            case 124:
                m36393ok(((Long) map.get(TTDownloadField.TT_EXPECT_FILE_LENGTH)).longValue());
                return null;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NEED_WIFI /* 125 */:
                m36354s(((Boolean) map.get(TTDownloadField.TT_NEED_WIFI)).booleanValue());
                return null;
            case 127:
                m36465a(((Long) map.get(TTDownloadField.TT_EXTRA_VALUE)).longValue());
                return null;
            case 128:
                m36410kf((String) map.get("appName"));
                return null;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_EXTRA /* 129 */:
                m36355s((JSONObject) map.get(TTDownloadField.TT_EXTRA_JSON));
                return null;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_START_TOAST /* 130 */:
                m36427h((String) map.get(TTDownloadField.TT_START_TOAST));
                return null;
            case 131:
                m36376p((String) map.get(TTDownloadField.TT_SDK_MONITOR_SCENE));
                return null;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_ID /* 132 */:
                m36453bl(((Long) map.get("id")).longValue());
                return null;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_IS_AD /* 133 */:
                m36408kf(((Boolean) map.get(TTDownloadField.TT_IS_AD)).booleanValue());
                return null;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MODEL_TYPE /* 134 */:
                m36454bl(((Integer) map.get(TTDownloadField.TT_MODEL_TYPE)).intValue());
                return null;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_LOG_EXTRA /* 135 */:
                m36371q((String) map.get(TTDownloadField.TT_LOG_EXTRA));
                return null;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_PACKAGE_NAME /* 136 */:
                m36415k((String) map.get(TTDownloadField.TT_PACKAGE_NAME));
                return null;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_APP_ICON /* 137 */:
                m36364r((String) map.get(TTDownloadField.TT_APP_ICON));
                return null;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_CLICK_TRACK_URL /* 139 */:
                m36382ok((List) map.get(TTDownloadField.TT_CLICK_TRACK_URL));
                return null;
            case 140:
                m36420j((String) map.get(TTDownloadField.TT_DOWNLOAD_URL));
                return null;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_BACKUP_URLS /* 141 */:
                m36462a((List) map.get(TTDownloadField.TT_BACK_UP_URLS));
                return null;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_NOTIFICATION_JUMP_URL /* 142 */:
                m36329z((String) map.get(TTDownloadField.TT_NOTIFICATION_JUMP_URL));
                return null;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_MIME_TYPE /* 143 */:
                m36362rh((String) map.get(TTDownloadField.TT_MIME_TYPE));
                return null;
            case 144:
                m36381ok((Map) map.get(TTDownloadField.TT_HEADERS));
                return null;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_IS_SHOW_NOTIFICATION /* 145 */:
                m36426h(((Boolean) map.get(TTDownloadField.TT_IS_SHOW_NOTIFICATION)).booleanValue());
                return null;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_FILE_PATH /* 146 */:
                m36349t((String) map.get(TTDownloadField.TT_FILE_PATH));
                return null;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_FILE_NAME /* 147 */:
                m36423i((String) map.get(TTDownloadField.TT_FILE_NAME));
                return null;
            case 148:
                m36375p(((Boolean) map.get(TTDownloadField.TT_IS_NEED_INDEPENDENT_PROCESS)).booleanValue());
                return null;
            case 149:
                m36359s(((Integer) map.get(TTDownloadField.TT_VERSION_CODE)).intValue());
                return null;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_NAME /* 150 */:
                m36336x((String) map.get(TTDownloadField.TT_VERSION_NAME));
                return null;
            case 151:
                m36387ok(new C11988s.C11989ok().m19533ok((String) map.get(TTDownloadField.TT_QUICK_APP_MODEL_OPEN_URL)).m19536a((String) map.get(TTDownloadField.TT_QUICK_APP_MODEL_EXTRA_DATA)).m19535ok());
                return null;
            case TTDownloadField.CALL_DOWNLOAD_MODEL_SET_AUTO_INSTALL_WITHOUT_NOTIFICATION /* 152 */:
                m36370q(((Boolean) map.get(TTDownloadField.TT_IS_AUTO_INSTALL_WITHOUT_NOTIFICATION)).booleanValue());
                return null;
            case 153:
                m36402n(((Integer) map.get(TTDownloadField.TT_FUNNEL_TYPE)).intValue());
                return null;
        }
    }

    /* renamed from: p */
    public void m36376p(String str) {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setSdkMonitorScene(str);
    }

    /* renamed from: q */
    public AdDownloadModel m36371q(String str) {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setLogExtra(str);
    }

    /* renamed from: p */
    public AdDownloadModel m36375p(boolean z) {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setNeedIndependentProcess(z);
    }

    /* renamed from: q */
    public AdDownloadModel m36370q(boolean z) {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setAutoInstallWithoutNotification(z);
    }

    /* renamed from: a */
    public boolean m36467a() {
        AdDownloadController adDownloadController = this.f22565kf;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.isEnableBackDialog();
    }

    /* renamed from: a */
    public void m36459a(boolean z) {
        AdDownloadController adDownloadController = this.f22565kf;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setIsAutoDownloadOnCardShow(z);
    }

    /* renamed from: a */
    public void m36464a(Object obj) {
        AdDownloadEventConfig adDownloadEventConfig = this.f22567p;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setExtraEventObject(obj);
    }

    /* renamed from: a */
    public void m36460a(JSONObject jSONObject) {
        AdDownloadEventConfig adDownloadEventConfig = this.f22567p;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setExtraJson(jSONObject);
    }

    /* renamed from: s */
    public Object m36360s() {
        AdDownloadController adDownloadController = this.f22565kf;
        if (adDownloadController == null) {
            return null;
        }
        return adDownloadController.getExtraClickOperation();
    }

    /* renamed from: a */
    public void m36463a(String str) {
        AdDownloadEventConfig adDownloadEventConfig = this.f22567p;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setClickItemTag(str);
    }

    /* renamed from: s */
    public void m36357s(String str) {
        AdDownloadEventConfig adDownloadEventConfig = this.f22567p;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setQuickAppEventTag(str);
    }

    /* renamed from: a */
    public void m36466a(int i) {
        AdDownloadEventConfig adDownloadEventConfig = this.f22567p;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setDownloadScene(i);
    }

    /* renamed from: s */
    public void m36354s(boolean z) {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setNeedWifi(z);
    }

    /* renamed from: a */
    public void m36465a(long j) {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setExtraValue(j);
    }

    /* renamed from: s */
    public void m36355s(JSONObject jSONObject) {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setExtra(jSONObject);
    }

    /* renamed from: a */
    public AdDownloadModel m36462a(List<String> list) {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setBackupUrls(list);
    }

    /* renamed from: s */
    public AdDownloadModel m36359s(int i) {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setVersionCode(i);
    }

    /* renamed from: n */
    public boolean m36403n() {
        AdDownloadController adDownloadController = this.f22565kf;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.isEnableMultipleDownload();
    }

    /* renamed from: bl */
    public boolean m36455bl() {
        AdDownloadController adDownloadController = this.f22565kf;
        if (adDownloadController == null) {
            return false;
        }
        return adDownloadController.isAddToDownloadManage();
    }

    /* renamed from: n */
    public void m36400n(String str) {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setMd5(str);
    }

    /* renamed from: bl */
    public void m36448bl(boolean z) {
        AdDownloadController adDownloadController = this.f22565kf;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setEnableNewActivity(z);
    }

    /* renamed from: n */
    public void m36398n(boolean z) {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setIsShowToast(z);
    }

    /* renamed from: bl */
    public void m36449bl(JSONObject jSONObject) {
        AdDownloadEventConfig adDownloadEventConfig = this.f22567p;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setParamsJson(jSONObject);
    }

    /* renamed from: n */
    public AdDownloadModel m36402n(int i) {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setFunnelType(i);
    }

    /* renamed from: bl */
    public void m36451bl(String str) {
        AdDownloadEventConfig adDownloadEventConfig = this.f22567p;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setRefer(str);
    }

    /* renamed from: bl */
    public AdDownloadModel m36453bl(long j) {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setId(j);
    }

    /* renamed from: bl */
    public AdDownloadModel m36454bl(int i) {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setModelType(i);
    }

    /* renamed from: kf */
    public void m36410kf(String str) {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setAppName(str);
    }

    /* renamed from: kf */
    public AdDownloadModel m36408kf(boolean z) {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setIsAd(z);
    }

    /* renamed from: ok */
    public void m36389ok(Bundle bundle) {
        C6391bl.m36482ok(this.f22562a);
    }

    /* renamed from: ok */
    private AdDownloadModel.Builder m36391ok(long j, String str, boolean z, boolean z2, String str2, JSONObject jSONObject, JSONObject jSONObject2, String str3, String str4, String str5, String str6, boolean z3, String str7, String str8, String str9) {
        AdDownloadModel.Builder fileUriProvider = new AdDownloadModel.Builder().setAdId(j).setAppIcon(str).setIsShowNotification(z).setAutoInstallWithoutNotification(z2).setLogExtra(str2).setExtra(jSONObject).setDistinctDir(true).setIsAd(true).setFileUriProvider(new IDownloadFileUriProvider() { // from class: com.bytedance.sdk.openadsdk.downloadnew.s.1
            @Override // com.p521ss.android.socialbase.downloader.depend.IDownloadFileUriProvider
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
        fileUriProvider.setNeedIndependentProcess(z3);
        fileUriProvider.setDeepLink(m36392ok(j, str7, str8, str9));
        return fileUriProvider;
    }

    /* renamed from: ok */
    private DeepLink m36392ok(long j, String str, String str2, String str3) {
        DeepLink deepLink = new DeepLink();
        deepLink.setId(j);
        deepLink.setOpenUrl(str);
        deepLink.setWebTitle(str2);
        deepLink.setWebUrl(str3);
        return deepLink;
    }

    /* renamed from: ok */
    private void m36383ok(String str, String str2, String str3) {
        AdDownloadModel.Builder builder = this.f22563bl;
        if (builder == null) {
            return;
        }
        this.f22568s = builder.setAppIcon(str).setAppName(str2).setPackageName(str3).build();
    }

    /* renamed from: ok */
    private void m36394ok(int i, int i2, boolean z, boolean z2, boolean z3) {
        AdDownloadController.Builder isAddToDownloadManage = new AdDownloadController.Builder().setLinkMode(i).setDownloadMode(i2).setIsEnableBackDialog(true).setIsAddToDownloadManage(false);
        this.f22566n = isAddToDownloadManage;
        if (z) {
            isAddToDownloadManage.setEnableAH(z2);
            this.f22566n.setEnableAM(z3);
        }
        this.f22565kf = this.f22566n.build();
    }

    /* renamed from: ok */
    public int m36396ok() {
        AdDownloadController adDownloadController = this.f22565kf;
        if (adDownloadController == null) {
            return 0;
        }
        return adDownloadController.getLinkMode();
    }

    /* renamed from: ok */
    public void m36395ok(int i) {
        AdDownloadController adDownloadController = this.f22565kf;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setLinkMode(i);
    }

    /* renamed from: ok */
    public void m36379ok(boolean z) {
        AdDownloadController adDownloadController = this.f22565kf;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setEnableShowComplianceDialog(z);
    }

    /* renamed from: ok */
    public void m36385ok(Object obj) {
        AdDownloadController adDownloadController = this.f22565kf;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setExtraObject(obj);
    }

    /* renamed from: ok */
    public void m36380ok(JSONObject jSONObject) {
        AdDownloadController adDownloadController = this.f22565kf;
        if (adDownloadController == null) {
            return;
        }
        adDownloadController.setExtraJson(jSONObject);
    }

    /* renamed from: ok */
    public void m36384ok(String str) {
        AdDownloadEventConfig adDownloadEventConfig = this.f22567p;
        if (adDownloadEventConfig == null) {
            return;
        }
        adDownloadEventConfig.setClickButtonTag(str);
    }

    /* renamed from: ok */
    public void m36393ok(long j) {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return;
        }
        adDownloadModel.setExpectFileLength(j);
    }

    /* renamed from: ok */
    public AdDownloadModel m36382ok(List<String> list) {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setClickTrackUrl(list);
    }

    /* renamed from: ok */
    public AdDownloadModel m36381ok(Map<String, String> map) {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setHeaders(map);
    }

    /* renamed from: ok */
    public AdDownloadModel m36387ok(C11988s c11988s) {
        AdDownloadModel adDownloadModel = this.f22568s;
        if (adDownloadModel == null) {
            return null;
        }
        return adDownloadModel.setQuickAppModel(c11988s);
    }
}
