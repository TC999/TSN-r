package com.bytedance.sdk.openadsdk.api.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.download.api.model.DeepLink;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv implements Bridge {

    /* renamed from: c  reason: collision with root package name */
    private DownloadModel f31399c;

    public xv(DownloadModel downloadModel) {
        this.f31399c = downloadModel;
    }

    public boolean a() {
        DownloadModel downloadModel = this.f31399c;
        if (downloadModel != null) {
            return downloadModel.isShowNotification();
        }
        return false;
    }

    public DeepLink ba() {
        DownloadModel downloadModel = this.f31399c;
        if (downloadModel != null) {
            return downloadModel.getDeepLink();
        }
        return null;
    }

    public boolean bk() {
        DownloadModel downloadModel = this.f31399c;
        if (downloadModel != null) {
            return downloadModel.isNeedWifi();
        }
        return false;
    }

    public int bw() {
        DownloadModel downloadModel = this.f31399c;
        if (downloadModel != null) {
            return downloadModel.getFunnelType();
        }
        return 0;
    }

    public String c() {
        DownloadModel downloadModel = this.f31399c;
        if (downloadModel != null) {
            return downloadModel.getDownloadUrl();
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Caller
    public <T> T call(int i4, ValueSet valueSet, Class<T> cls) {
        switch (i4) {
            case 223417:
                s();
                return null;
            case 223419:
                u();
                return null;
            case 223420:
                i();
                return null;
            case 223430:
                if (valueSet != null) {
                    return (T) c((String) valueSet.objectValue(223431, String.class));
                }
                return null;
            default:
                return null;
        }
    }

    public String ck() {
        DownloadModel downloadModel = this.f31399c;
        if (downloadModel != null) {
            return downloadModel.getPackageName();
        }
        return null;
    }

    public JSONObject eq() {
        DownloadModel downloadModel = this.f31399c;
        if (downloadModel != null) {
            return downloadModel.getExtra();
        }
        return null;
    }

    public String ev() {
        DownloadModel downloadModel = this.f31399c;
        if (downloadModel != null) {
            return downloadModel.getName();
        }
        return null;
    }

    public long f() {
        DownloadModel downloadModel = this.f31399c;
        if (downloadModel != null) {
            return downloadModel.getExpectFileLength();
        }
        return 0L;
    }

    public String fp() {
        DownloadModel downloadModel = this.f31399c;
        if (downloadModel != null) {
            return downloadModel.getFilePath();
        }
        return null;
    }

    public JSONObject fz() {
        DownloadModel downloadModel = this.f31399c;
        if (downloadModel != null) {
            return downloadModel.getDownloadSettings();
        }
        return null;
    }

    public boolean gb() {
        DownloadModel downloadModel = this.f31399c;
        if (downloadModel != null) {
            return downloadModel.isAd();
        }
        return false;
    }

    public String gd() {
        DownloadModel downloadModel = this.f31399c;
        if (downloadModel != null) {
            return downloadModel.getMimeType();
        }
        return null;
    }

    public boolean gw() {
        DownloadModel downloadModel = this.f31399c;
        if (downloadModel != null) {
            return downloadModel.isAutoInstall();
        }
        return false;
    }

    public void i() {
        DownloadModel downloadModel = this.f31399c;
        if (downloadModel != null) {
            downloadModel.forceHideNotification();
        }
    }

    public String ia() {
        DownloadModel downloadModel = this.f31399c;
        if (downloadModel != null) {
            return downloadModel.getFileName();
        }
        return null;
    }

    public int j() {
        DownloadModel downloadModel = this.f31399c;
        if (downloadModel != null) {
            return downloadModel.getVersionCode();
        }
        return 0;
    }

    public boolean k() {
        DownloadModel downloadModel = this.f31399c;
        if (downloadModel != null) {
            return downloadModel.isShowToast();
        }
        return false;
    }

    public String ls() {
        DownloadModel downloadModel = this.f31399c;
        if (downloadModel != null) {
            return downloadModel.getVersionName();
        }
        return null;
    }

    public String m() {
        DownloadModel downloadModel = this.f31399c;
        if (downloadModel != null) {
            return downloadModel.getSdkMonitorScene();
        }
        return null;
    }

    public int me() {
        DownloadModel downloadModel = this.f31399c;
        if (downloadModel != null) {
            return downloadModel.getModelType();
        }
        return 0;
    }

    public String n() {
        DownloadModel downloadModel = this.f31399c;
        if (downloadModel != null) {
            return downloadModel.getLogExtra();
        }
        return null;
    }

    public Map<String, String> p() {
        DownloadModel downloadModel = this.f31399c;
        if (downloadModel != null) {
            return downloadModel.getHeaders();
        }
        return null;
    }

    public int pr() {
        DownloadModel downloadModel = this.f31399c;
        if (downloadModel != null) {
            return downloadModel.getExecutorGroup();
        }
        return 0;
    }

    public boolean q() {
        DownloadModel downloadModel = this.f31399c;
        if (downloadModel != null) {
            return downloadModel.needIndependentProcess();
        }
        return false;
    }

    public long r() {
        DownloadModel downloadModel = this.f31399c;
        if (downloadModel != null) {
            return downloadModel.getExtraValue();
        }
        return 0L;
    }

    public void s() {
        DownloadModel downloadModel = this.f31399c;
        if (downloadModel != null) {
            downloadModel.forceWifi();
        }
    }

    public long sr() {
        DownloadModel downloadModel = this.f31399c;
        if (downloadModel != null) {
            return downloadModel.getId();
        }
        return 0L;
    }

    public boolean t() {
        DownloadModel downloadModel = this.f31399c;
        if (downloadModel != null) {
            return downloadModel.isInExternalPublicDir();
        }
        return false;
    }

    public void u() {
        DownloadModel downloadModel = this.f31399c;
        if (downloadModel != null) {
            downloadModel.forceHideToast();
        }
    }

    public boolean up() {
        DownloadModel downloadModel = this.f31399c;
        if (downloadModel != null) {
            return downloadModel.enablePause();
        }
        return false;
    }

    public String ux() {
        DownloadModel downloadModel = this.f31399c;
        if (downloadModel != null) {
            return downloadModel.getMd5();
        }
        return null;
    }

    @Override // com.bykv.vk.openvk.api.proto.Bridge
    public ValueSet values() {
        return b.a().i(223400, c()).h(223401, w()).i(223402, xv()).f(223403, sr()).i(223404, ux()).f(223405, f()).f(223406, r()).i(223407, ev()).i(223408, gd()).h(223409, p()).j(223410, k()).j(223411, a()).j(223412, bk()).j(223413, t()).j(223414, ys()).i(223415, fp()).i(223416, ia()).h(223418, fz()).j(223421, q()).e(223422, j()).i(223423, ls()).j(223424, gb()).i(223425, n()).i(223426, ck()).i(223427, z()).h(223428, ba()).h(223429, y()).h(223430, eq()).e(223431, me()).h(223432, wv()).j(223433, xk()).h(223434, yu()).j(223435, wx()).e(223436, pr()).e(223437, bw()).i(223438, x()).i(223432, m()).j(223433, gw()).j(223434, vc()).j(223435, up()).l();
    }

    public boolean vc() {
        DownloadModel downloadModel = this.f31399c;
        if (downloadModel != null) {
            return downloadModel.distinctDir();
        }
        return false;
    }

    public List<String> w() {
        DownloadModel downloadModel = this.f31399c;
        if (downloadModel != null) {
            return downloadModel.getBackupUrls();
        }
        return null;
    }

    public com.ss.android.download.api.model.sr wv() {
        DownloadModel downloadModel = this.f31399c;
        if (downloadModel != null) {
            return downloadModel.getQuickAppModel();
        }
        return null;
    }

    public boolean wx() {
        DownloadModel downloadModel = this.f31399c;
        if (downloadModel != null) {
            return downloadModel.shouldDownloadWithPatchApply();
        }
        return false;
    }

    public String x() {
        DownloadModel downloadModel = this.f31399c;
        if (downloadModel != null) {
            return downloadModel.getStartToast();
        }
        return null;
    }

    public boolean xk() {
        DownloadModel downloadModel = this.f31399c;
        if (downloadModel != null) {
            return downloadModel.autoInstallWithoutNotification();
        }
        return false;
    }

    public String xv() {
        DownloadModel downloadModel = this.f31399c;
        if (downloadModel != null) {
            return downloadModel.getNotificationJumpUrl();
        }
        return null;
    }

    public List<String> y() {
        DownloadModel downloadModel = this.f31399c;
        if (downloadModel != null) {
            return downloadModel.getClickTrackUrl();
        }
        return null;
    }

    public boolean ys() {
        DownloadModel downloadModel = this.f31399c;
        if (downloadModel != null) {
            return downloadModel.isVisibleInDownloadsUi();
        }
        return false;
    }

    public IDownloadFileUriProvider yu() {
        DownloadModel downloadModel = this.f31399c;
        if (downloadModel != null) {
            return downloadModel.getDownloadFileUriProvider();
        }
        return null;
    }

    public String z() {
        DownloadModel downloadModel = this.f31399c;
        if (downloadModel != null) {
            return downloadModel.getAppIcon();
        }
        return null;
    }

    public DownloadModel c(String str) {
        DownloadModel downloadModel = this.f31399c;
        if (downloadModel != null) {
            return downloadModel.setFilePath(str);
        }
        return null;
    }
}
