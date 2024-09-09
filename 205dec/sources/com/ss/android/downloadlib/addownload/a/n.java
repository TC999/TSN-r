package com.ss.android.downloadlib.addownload.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.download.DownloadController;
import com.ss.android.download.api.download.DownloadEventConfig;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadad.api.download.AdDownloadController;
import com.ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.ss.android.downloadad.api.download.AdDownloadModel;
import java.util.List;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class n implements com.ss.android.downloadad.api.ok.ok {

    /* renamed from: a  reason: collision with root package name */
    public DownloadModel f48371a;
    public DownloadEventConfig bl;

    /* renamed from: n  reason: collision with root package name */
    public com.ss.android.downloadad.api.ok.a f48372n;
    public long ok;

    /* renamed from: s  reason: collision with root package name */
    public DownloadController f48373s;

    public n() {
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public long a() {
        return this.f48371a.getId();
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public boolean bl() {
        return this.f48371a.isAd();
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public JSONObject h() {
        return this.f48371a.getExtra();
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public JSONObject i() {
        return this.bl.getExtraJson();
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public DownloadModel io() {
        return this.f48371a;
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public long j() {
        return this.f48371a.getExtraValue();
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public String k() {
        return this.bl.getClickButtonTag();
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public String kf() {
        if (this.f48371a.getDeepLink() != null) {
            return this.f48371a.getDeepLink().getOpenUrl();
        }
        return null;
    }

    public boolean m() {
        if (y()) {
            return false;
        }
        if (this.f48371a.isAd()) {
            DownloadModel downloadModel = this.f48371a;
            return (downloadModel instanceof AdDownloadModel) && !TextUtils.isEmpty(downloadModel.getLogExtra()) && (this.bl instanceof AdDownloadEventConfig) && (this.f48373s instanceof AdDownloadController);
        }
        return this.f48371a instanceof AdDownloadModel;
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public String n() {
        return this.f48371a.getPackageName();
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public DownloadController o() {
        return this.f48373s;
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public String ok() {
        return this.f48371a.getDownloadUrl();
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public int p() {
        if (this.f48373s.getDownloadMode() == 2) {
            return 2;
        }
        return this.f48371a.getFunnelType();
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public String q() {
        return this.bl.getRefer();
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public JSONObject r() {
        return this.bl.getParamsJson();
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public List<String> rh() {
        return this.f48371a.getClickTrackUrl();
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public String s() {
        return this.f48371a.getLogExtra();
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public Object t() {
        return this.bl.getExtraEventObject();
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public JSONObject td() {
        return this.f48371a.getDownloadSettings();
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public int u() {
        return this.bl.getDownloadScene();
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public DownloadEventConfig ul() {
        return this.bl;
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public boolean x() {
        return this.f48373s.enableNewActivity();
    }

    public boolean y() {
        DownloadModel downloadModel;
        if (this.ok == 0 || (downloadModel = this.f48371a) == null || this.bl == null || this.f48373s == null) {
            return true;
        }
        return downloadModel.isAd() && this.ok <= 0;
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public boolean z() {
        return this.bl.isEnableV3Event();
    }

    @Override // com.ss.android.downloadad.api.ok.ok
    public int zz() {
        return 0;
    }

    public n(long j4, @NonNull DownloadModel downloadModel, @NonNull DownloadEventConfig downloadEventConfig, @NonNull DownloadController downloadController) {
        this.ok = j4;
        this.f48371a = downloadModel;
        this.bl = downloadEventConfig;
        this.f48373s = downloadController;
    }
}
