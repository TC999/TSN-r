package com.bytedance.sdk.openadsdk.api.ok;

import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class bl implements Bridge {
    private DownloadModel ok;

    public bl(DownloadModel downloadModel) {
        this.ok = downloadModel;
    }

    public List<String> a() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getBackupUrls();
        }
        return null;
    }

    public String ah() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getSdkMonitorScene();
        }
        return null;
    }

    public String bl() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getNotificationJumpUrl();
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        switch (i4) {
            case 223417:
                td();
                return null;
            case 223419:
                u();
                return null;
            case 223420:
                io();
                return null;
            case 223430:
                if (valueSet != null) {
                    return (T) ok((String) valueSet.objectValue(223431, String.class));
                }
                return null;
            default:
                return null;
        }
    }

    public boolean e() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.autoInstallWithoutNotification();
        }
        return false;
    }

    public boolean em() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.shouldDownloadWithPatchApply();
        }
        return false;
    }

    public String ep() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getLogExtra();
        }
        return null;
    }

    public DeepLink er() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getDeepLink();
        }
        return null;
    }

    public List<String> fb() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getClickTrackUrl();
        }
        return null;
    }

    public IDownloadFileUriProvider fd() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getDownloadFileUriProvider();
        }
        return null;
    }

    public com.ss.android.download.api.model.s fl() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getQuickAppModel();
        }
        return null;
    }

    public JSONObject g() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getExtra();
        }
        return null;
    }

    public long h() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getExtraValue();
        }
        return 0L;
    }

    public String i() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getFilePath();
        }
        return null;
    }

    public void io() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            downloadModel.forceHideNotification();
        }
    }

    public boolean j() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.isShowNotification();
        }
        return false;
    }

    public Map<String, String> k() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getHeaders();
        }
        return null;
    }

    public long kf() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getExpectFileLength();
        }
        return 0L;
    }

    public String kz() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getAppIcon();
        }
        return null;
    }

    public boolean l() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.isAutoInstall();
        }
        return false;
    }

    public boolean m() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.isAd();
        }
        return false;
    }

    public String n() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getMd5();
        }
        return null;
    }

    public int o() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getVersionCode();
        }
        return 0;
    }

    public String ok() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getDownloadUrl();
        }
        return null;
    }

    public String p() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getName();
        }
        return null;
    }

    public String q() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getMimeType();
        }
        return null;
    }

    public int qu() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getFunnelType();
        }
        return 0;
    }

    public boolean r() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.isShowToast();
        }
        return false;
    }

    public boolean rh() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.isInExternalPublicDir();
        }
        return false;
    }

    public long s() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getId();
        }
        return 0L;
    }

    public int sg() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getExecutorGroup();
        }
        return 0;
    }

    public boolean t() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.isVisibleInDownloadsUi();
        }
        return false;
    }

    public void td() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            downloadModel.forceWifi();
        }
    }

    public void u() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            downloadModel.forceHideToast();
        }
    }

    public boolean ul() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.needIndependentProcess();
        }
        return false;
    }

    public int v() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getModelType();
        }
        return 0;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return com.bykv.ok.ok.ok.ok.a.b().i(223400, ok()).h(223401, a()).i(223402, bl()).g(223403, s()).i(223404, n()).g(223405, kf()).g(223406, h()).i(223407, p()).i(223408, q()).h(223409, k()).j(223410, r()).j(223411, j()).j(223412, z()).j(223413, rh()).j(223414, t()).i(223415, i()).i(223416, x()).h(223418, zz()).j(223421, ul()).f(223422, o()).i(223423, y()).j(223424, m()).i(223425, ep()).i(223426, vz()).i(223427, kz()).h(223428, er()).h(223429, fb()).h(223430, g()).f(223431, v()).h(223432, fl()).j(223433, e()).h(223434, fd()).j(223435, em()).f(223436, sg()).f(223437, qu()).i(223438, xy()).i(223432, ah()).j(223433, l()).j(223434, wv()).j(223435, vk()).a();
    }

    public boolean vk() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.enablePause();
        }
        return false;
    }

    public String vz() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getPackageName();
        }
        return null;
    }

    public boolean wv() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.distinctDir();
        }
        return false;
    }

    public String x() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getFileName();
        }
        return null;
    }

    public String xy() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getStartToast();
        }
        return null;
    }

    public String y() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getVersionName();
        }
        return null;
    }

    public boolean z() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.isNeedWifi();
        }
        return false;
    }

    public JSONObject zz() {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.getDownloadSettings();
        }
        return null;
    }

    public DownloadModel ok(String str) {
        DownloadModel downloadModel = this.ok;
        if (downloadModel != null) {
            return downloadModel.setFilePath(str);
        }
        return null;
    }
}
