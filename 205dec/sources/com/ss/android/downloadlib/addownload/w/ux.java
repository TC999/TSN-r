package com.ss.android.downloadlib.addownload.w;

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

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class ux implements com.ss.android.downloadad.api.c.c {

    /* renamed from: c  reason: collision with root package name */
    public long f48722c;
    public DownloadController sr;
    public com.ss.android.downloadad.api.c.w ux;

    /* renamed from: w  reason: collision with root package name */
    public DownloadModel f48723w;
    public DownloadEventConfig xv;

    public ux() {
    }

    @Override // com.ss.android.downloadad.api.c.c
    public long a() {
        return this.f48723w.getExtraValue();
    }

    @Override // com.ss.android.downloadad.api.c.c
    public boolean bk() {
        return this.xv.isEnableV3Event();
    }

    @Override // com.ss.android.downloadad.api.c.c
    public String c() {
        return this.f48723w.getDownloadUrl();
    }

    @Override // com.ss.android.downloadad.api.c.c
    public int ev() {
        if (this.sr.getDownloadMode() == 2) {
            return 2;
        }
        return this.f48723w.getFunnelType();
    }

    @Override // com.ss.android.downloadad.api.c.c
    public String f() {
        if (this.f48723w.getDeepLink() != null) {
            return this.f48723w.getDeepLink().getOpenUrl();
        }
        return null;
    }

    @Override // com.ss.android.downloadad.api.c.c
    public JSONObject fp() {
        return this.xv.getExtraJson();
    }

    @Override // com.ss.android.downloadad.api.c.c
    public int fz() {
        return 0;
    }

    public boolean gb() {
        if (ls()) {
            return false;
        }
        if (this.f48723w.isAd()) {
            DownloadModel downloadModel = this.f48723w;
            return (downloadModel instanceof AdDownloadModel) && !TextUtils.isEmpty(downloadModel.getLogExtra()) && (this.xv instanceof AdDownloadEventConfig) && (this.sr instanceof AdDownloadController);
        }
        return this.f48723w instanceof AdDownloadModel;
    }

    @Override // com.ss.android.downloadad.api.c.c
    public String gd() {
        return this.xv.getRefer();
    }

    @Override // com.ss.android.downloadad.api.c.c
    public DownloadModel i() {
        return this.f48723w;
    }

    @Override // com.ss.android.downloadad.api.c.c
    public boolean ia() {
        return this.sr.enableNewActivity();
    }

    @Override // com.ss.android.downloadad.api.c.c
    public DownloadController j() {
        return this.sr;
    }

    @Override // com.ss.android.downloadad.api.c.c
    public JSONObject k() {
        return this.xv.getParamsJson();
    }

    public boolean ls() {
        DownloadModel downloadModel;
        if (this.f48722c == 0 || (downloadModel = this.f48723w) == null || this.xv == null || this.sr == null) {
            return true;
        }
        return downloadModel.isAd() && this.f48722c <= 0;
    }

    @Override // com.ss.android.downloadad.api.c.c
    public String p() {
        return this.xv.getClickButtonTag();
    }

    @Override // com.ss.android.downloadad.api.c.c
    public DownloadEventConfig q() {
        return this.xv;
    }

    @Override // com.ss.android.downloadad.api.c.c
    public JSONObject r() {
        return this.f48723w.getExtra();
    }

    @Override // com.ss.android.downloadad.api.c.c
    public JSONObject s() {
        return this.f48723w.getDownloadSettings();
    }

    @Override // com.ss.android.downloadad.api.c.c
    public String sr() {
        return this.f48723w.getLogExtra();
    }

    @Override // com.ss.android.downloadad.api.c.c
    public List<String> t() {
        return this.f48723w.getClickTrackUrl();
    }

    @Override // com.ss.android.downloadad.api.c.c
    public int u() {
        return this.xv.getDownloadScene();
    }

    @Override // com.ss.android.downloadad.api.c.c
    public String ux() {
        return this.f48723w.getPackageName();
    }

    @Override // com.ss.android.downloadad.api.c.c
    public long w() {
        return this.f48723w.getId();
    }

    @Override // com.ss.android.downloadad.api.c.c
    public boolean xv() {
        return this.f48723w.isAd();
    }

    @Override // com.ss.android.downloadad.api.c.c
    public Object ys() {
        return this.xv.getExtraEventObject();
    }

    public ux(long j4, @NonNull DownloadModel downloadModel, @NonNull DownloadEventConfig downloadEventConfig, @NonNull DownloadController downloadController) {
        this.f48722c = j4;
        this.f48723w = downloadModel;
        this.xv = downloadEventConfig;
        this.sr = downloadController;
    }
}
