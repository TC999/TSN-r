package com.bytedance.sdk.openadsdk.api.p134ok;

import com.bykv.p106ok.p107ok.p108ok.p109ok.C5930a;
import com.bykv.p110vk.openvk.api.proto.Bridge;
import com.bykv.p110vk.openvk.api.proto.ValueSet;
import com.bytedance.sdk.openadsdk.downloadnew.core.ValueSetConstants;
import com.p521ss.android.download.api.download.DownloadModel;
import com.p521ss.android.download.api.model.C11988s;
import com.p521ss.android.download.api.model.DeepLink;
import com.p521ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.bytedance.sdk.openadsdk.api.ok.bl */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6308bl implements Bridge {

    /* renamed from: ok */
    private DownloadModel f22424ok;

    public C6308bl(DownloadModel downloadModel) {
        this.f22424ok = downloadModel;
    }

    /* renamed from: a */
    public List<String> m36740a() {
        DownloadModel downloadModel = this.f22424ok;
        if (downloadModel != null) {
            return downloadModel.getBackupUrls();
        }
        return null;
    }

    /* renamed from: ah */
    public String m36738ah() {
        DownloadModel downloadModel = this.f22424ok;
        if (downloadModel != null) {
            return downloadModel.getSdkMonitorScene();
        }
        return null;
    }

    /* renamed from: bl */
    public String m36737bl() {
        DownloadModel downloadModel = this.f22424ok;
        if (downloadModel != null) {
            return downloadModel.getNotificationJumpUrl();
        }
        return null;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Caller
    public <T> T call(int i, ValueSet valueSet, Class<T> cls) {
        switch (i) {
            case ValueSetConstants.VALUE_DOWNLOAD_MODE_FORCE_WIFI /* 223417 */:
                m36699td();
                return null;
            case ValueSetConstants.VALUE_DOWNLOAD_MODE_FORCE_HIDE_TOAST /* 223419 */:
                m36698u();
                return null;
            case ValueSetConstants.VALUE_DOWNLOAD_MODE_FORCE_HIDE_NOTIFICATION /* 223420 */:
                m36726io();
                return null;
            case 223430:
                if (valueSet != null) {
                    return (T) m36709ok((String) valueSet.objectValue(223431, String.class));
                }
                return null;
            default:
                return null;
        }
    }

    /* renamed from: e */
    public boolean m36736e() {
        DownloadModel downloadModel = this.f22424ok;
        if (downloadModel != null) {
            return downloadModel.autoInstallWithoutNotification();
        }
        return false;
    }

    /* renamed from: em */
    public boolean m36735em() {
        DownloadModel downloadModel = this.f22424ok;
        if (downloadModel != null) {
            return downloadModel.shouldDownloadWithPatchApply();
        }
        return false;
    }

    /* renamed from: ep */
    public String m36734ep() {
        DownloadModel downloadModel = this.f22424ok;
        if (downloadModel != null) {
            return downloadModel.getLogExtra();
        }
        return null;
    }

    /* renamed from: er */
    public DeepLink m36733er() {
        DownloadModel downloadModel = this.f22424ok;
        if (downloadModel != null) {
            return downloadModel.getDeepLink();
        }
        return null;
    }

    /* renamed from: fb */
    public List<String> m36732fb() {
        DownloadModel downloadModel = this.f22424ok;
        if (downloadModel != null) {
            return downloadModel.getClickTrackUrl();
        }
        return null;
    }

    /* renamed from: fd */
    public IDownloadFileUriProvider m36731fd() {
        DownloadModel downloadModel = this.f22424ok;
        if (downloadModel != null) {
            return downloadModel.getDownloadFileUriProvider();
        }
        return null;
    }

    /* renamed from: fl */
    public C11988s m36730fl() {
        DownloadModel downloadModel = this.f22424ok;
        if (downloadModel != null) {
            return downloadModel.getQuickAppModel();
        }
        return null;
    }

    /* renamed from: g */
    public JSONObject m36729g() {
        DownloadModel downloadModel = this.f22424ok;
        if (downloadModel != null) {
            return downloadModel.getExtra();
        }
        return null;
    }

    /* renamed from: h */
    public long m36728h() {
        DownloadModel downloadModel = this.f22424ok;
        if (downloadModel != null) {
            return downloadModel.getExtraValue();
        }
        return 0L;
    }

    /* renamed from: i */
    public String m36727i() {
        DownloadModel downloadModel = this.f22424ok;
        if (downloadModel != null) {
            return downloadModel.getFilePath();
        }
        return null;
    }

    /* renamed from: io */
    public void m36726io() {
        DownloadModel downloadModel = this.f22424ok;
        if (downloadModel != null) {
            downloadModel.forceHideNotification();
        }
    }

    /* renamed from: j */
    public boolean m36725j() {
        DownloadModel downloadModel = this.f22424ok;
        if (downloadModel != null) {
            return downloadModel.isShowNotification();
        }
        return false;
    }

    /* renamed from: k */
    public Map<String, String> m36724k() {
        DownloadModel downloadModel = this.f22424ok;
        if (downloadModel != null) {
            return downloadModel.getHeaders();
        }
        return null;
    }

    /* renamed from: kf */
    public long m36723kf() {
        DownloadModel downloadModel = this.f22424ok;
        if (downloadModel != null) {
            return downloadModel.getExpectFileLength();
        }
        return 0L;
    }

    /* renamed from: kz */
    public String m36722kz() {
        DownloadModel downloadModel = this.f22424ok;
        if (downloadModel != null) {
            return downloadModel.getAppIcon();
        }
        return null;
    }

    /* renamed from: l */
    public boolean m36721l() {
        DownloadModel downloadModel = this.f22424ok;
        if (downloadModel != null) {
            return downloadModel.isAutoInstall();
        }
        return false;
    }

    /* renamed from: m */
    public boolean m36720m() {
        DownloadModel downloadModel = this.f22424ok;
        if (downloadModel != null) {
            return downloadModel.isAd();
        }
        return false;
    }

    /* renamed from: n */
    public String m36719n() {
        DownloadModel downloadModel = this.f22424ok;
        if (downloadModel != null) {
            return downloadModel.getMd5();
        }
        return null;
    }

    /* renamed from: o */
    public int m36718o() {
        DownloadModel downloadModel = this.f22424ok;
        if (downloadModel != null) {
            return downloadModel.getVersionCode();
        }
        return 0;
    }

    /* renamed from: ok */
    public String m36717ok() {
        DownloadModel downloadModel = this.f22424ok;
        if (downloadModel != null) {
            return downloadModel.getDownloadUrl();
        }
        return null;
    }

    /* renamed from: p */
    public String m36707p() {
        DownloadModel downloadModel = this.f22424ok;
        if (downloadModel != null) {
            return downloadModel.getName();
        }
        return null;
    }

    /* renamed from: q */
    public String m36706q() {
        DownloadModel downloadModel = this.f22424ok;
        if (downloadModel != null) {
            return downloadModel.getMimeType();
        }
        return null;
    }

    /* renamed from: qu */
    public int m36705qu() {
        DownloadModel downloadModel = this.f22424ok;
        if (downloadModel != null) {
            return downloadModel.getFunnelType();
        }
        return 0;
    }

    /* renamed from: r */
    public boolean m36704r() {
        DownloadModel downloadModel = this.f22424ok;
        if (downloadModel != null) {
            return downloadModel.isShowToast();
        }
        return false;
    }

    /* renamed from: rh */
    public boolean m36703rh() {
        DownloadModel downloadModel = this.f22424ok;
        if (downloadModel != null) {
            return downloadModel.isInExternalPublicDir();
        }
        return false;
    }

    /* renamed from: s */
    public long m36702s() {
        DownloadModel downloadModel = this.f22424ok;
        if (downloadModel != null) {
            return downloadModel.getId();
        }
        return 0L;
    }

    /* renamed from: sg */
    public int m36701sg() {
        DownloadModel downloadModel = this.f22424ok;
        if (downloadModel != null) {
            return downloadModel.getExecutorGroup();
        }
        return 0;
    }

    /* renamed from: t */
    public boolean m36700t() {
        DownloadModel downloadModel = this.f22424ok;
        if (downloadModel != null) {
            return downloadModel.isVisibleInDownloadsUi();
        }
        return false;
    }

    /* renamed from: td */
    public void m36699td() {
        DownloadModel downloadModel = this.f22424ok;
        if (downloadModel != null) {
            downloadModel.forceWifi();
        }
    }

    /* renamed from: u */
    public void m36698u() {
        DownloadModel downloadModel = this.f22424ok;
        if (downloadModel != null) {
            downloadModel.forceHideToast();
        }
    }

    /* renamed from: ul */
    public boolean m36697ul() {
        DownloadModel downloadModel = this.f22424ok;
        if (downloadModel != null) {
            return downloadModel.needIndependentProcess();
        }
        return false;
    }

    /* renamed from: v */
    public int m36696v() {
        DownloadModel downloadModel = this.f22424ok;
        if (downloadModel != null) {
            return downloadModel.getModelType();
        }
        return 0;
    }

    @Override // com.bykv.p110vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return C5930a.m37925b().m37918i(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_DOWNLOAD_URL, m36717ok()).m37919h(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_BACKUP_URLS, m36740a()).m37918i(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_NOTIFICATION_JUMP_URL, m36737bl()).m37920g(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_ID, m36702s()).m37918i(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_MD5, m36719n()).m37920g(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_EXPECT_FILE_LENGTH, m36723kf()).m37920g(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_EXTRA_VALUE, m36728h()).m37918i(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_NAME, m36707p()).m37918i(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_MIME_TYPE, m36706q()).m37919h(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_HEADERS, m36724k()).m37917j(ValueSetConstants.VALUE_DOWNLOAD_MODE_IS_SHOW_TOAST, m36704r()).m37917j(ValueSetConstants.VALUE_DOWNLOAD_MODE_IS_SHOW_NOTIFICATION, m36725j()).m37917j(ValueSetConstants.VALUE_DOWNLOAD_MODE_IS_NEED_WIFI, m36689z()).m37917j(ValueSetConstants.VALUE_DOWNLOAD_MODE_IS_IN_EXTERNAL_PUBLIC_DIR, m36703rh()).m37917j(ValueSetConstants.VALUE_DOWNLOAD_MODE_IS_VISIBLE_IN_DOWNLOADS_UI, m36700t()).m37918i(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_FILE_PATH, m36727i()).m37918i(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_FILE_NAME, m36692x()).m37919h(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_DOWNLOAD_SETTINGS, m36688zz()).m37917j(ValueSetConstants.VALUE_DOWNLOAD_MODE_NEED_INDEPENDENT_PROCESS, m36697ul()).m37921f(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_VERSION_CODE, m36718o()).m37918i(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_VERSION_NAME, m36690y()).m37917j(ValueSetConstants.VALUE_DOWNLOAD_MODE_IS_AD, m36720m()).m37918i(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_LOG_EXTRA, m36734ep()).m37918i(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_PACKAGE_NAME, m36694vz()).m37918i(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_APP_ICON, m36722kz()).m37919h(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_DEEP_LINK, m36733er()).m37919h(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_CLICK_TRACK_URL, m36732fb()).m37919h(223430, m36729g()).m37921f(223431, m36696v()).m37919h(223432, m36730fl()).m37917j(223433, m36736e()).m37919h(223434, m36731fd()).m37917j(223435, m36735em()).m37921f(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_EXECUTOR_GROUP, m36701sg()).m37921f(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_FUNNEL_TYPE, m36705qu()).m37918i(ValueSetConstants.VALUE_DOWNLOAD_MODE_GET_START_TOAST, m36691xy()).m37918i(223432, m36738ah()).m37917j(223433, m36721l()).m37917j(223434, m36693wv()).m37917j(223435, m36695vk()).m37926a();
    }

    /* renamed from: vk */
    public boolean m36695vk() {
        DownloadModel downloadModel = this.f22424ok;
        if (downloadModel != null) {
            return downloadModel.enablePause();
        }
        return false;
    }

    /* renamed from: vz */
    public String m36694vz() {
        DownloadModel downloadModel = this.f22424ok;
        if (downloadModel != null) {
            return downloadModel.getPackageName();
        }
        return null;
    }

    /* renamed from: wv */
    public boolean m36693wv() {
        DownloadModel downloadModel = this.f22424ok;
        if (downloadModel != null) {
            return downloadModel.distinctDir();
        }
        return false;
    }

    /* renamed from: x */
    public String m36692x() {
        DownloadModel downloadModel = this.f22424ok;
        if (downloadModel != null) {
            return downloadModel.getFileName();
        }
        return null;
    }

    /* renamed from: xy */
    public String m36691xy() {
        DownloadModel downloadModel = this.f22424ok;
        if (downloadModel != null) {
            return downloadModel.getStartToast();
        }
        return null;
    }

    /* renamed from: y */
    public String m36690y() {
        DownloadModel downloadModel = this.f22424ok;
        if (downloadModel != null) {
            return downloadModel.getVersionName();
        }
        return null;
    }

    /* renamed from: z */
    public boolean m36689z() {
        DownloadModel downloadModel = this.f22424ok;
        if (downloadModel != null) {
            return downloadModel.isNeedWifi();
        }
        return false;
    }

    /* renamed from: zz */
    public JSONObject m36688zz() {
        DownloadModel downloadModel = this.f22424ok;
        if (downloadModel != null) {
            return downloadModel.getDownloadSettings();
        }
        return null;
    }

    /* renamed from: ok */
    public DownloadModel m36709ok(String str) {
        DownloadModel downloadModel = this.f22424ok;
        if (downloadModel != null) {
            return downloadModel.setFilePath(str);
        }
        return null;
    }
}
