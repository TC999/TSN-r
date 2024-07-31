package com.p521ss.android.downloadlib.addownload.p528a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.p521ss.android.download.api.download.DownloadController;
import com.p521ss.android.download.api.download.DownloadEventConfig;
import com.p521ss.android.download.api.download.DownloadModel;
import com.p521ss.android.downloadad.api.download.AdDownloadController;
import com.p521ss.android.downloadad.api.download.AdDownloadEventConfig;
import com.p521ss.android.downloadad.api.download.AdDownloadModel;
import com.p521ss.android.downloadad.api.p526ok.C11998a;
import com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.addownload.a.n */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12035n implements InterfaceC11999ok {

    /* renamed from: a */
    public DownloadModel f34076a;

    /* renamed from: bl */
    public DownloadEventConfig f34077bl;

    /* renamed from: n */
    public C11998a f34078n;

    /* renamed from: ok */
    public long f34079ok;

    /* renamed from: s */
    public DownloadController f34080s;

    public C12035n() {
    }

    @Override // com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok
    /* renamed from: a */
    public long mo19309a() {
        return this.f34076a.getId();
    }

    @Override // com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok
    /* renamed from: bl */
    public boolean mo19308bl() {
        return this.f34076a.isAd();
    }

    @Override // com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok
    /* renamed from: h */
    public JSONObject mo19307h() {
        return this.f34076a.getExtra();
    }

    @Override // com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok
    /* renamed from: i */
    public JSONObject mo19306i() {
        return this.f34077bl.getExtraJson();
    }

    @Override // com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok
    /* renamed from: io */
    public DownloadModel mo19305io() {
        return this.f34076a;
    }

    @Override // com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok
    /* renamed from: j */
    public long mo19304j() {
        return this.f34076a.getExtraValue();
    }

    @Override // com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok
    /* renamed from: k */
    public String mo19303k() {
        return this.f34077bl.getClickButtonTag();
    }

    @Override // com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok
    /* renamed from: kf */
    public String mo19302kf() {
        if (this.f34076a.getDeepLink() != null) {
            return this.f34076a.getDeepLink().getOpenUrl();
        }
        return null;
    }

    /* renamed from: m */
    public boolean m19301m() {
        if (m19287y()) {
            return false;
        }
        if (this.f34076a.isAd()) {
            DownloadModel downloadModel = this.f34076a;
            return (downloadModel instanceof AdDownloadModel) && !TextUtils.isEmpty(downloadModel.getLogExtra()) && (this.f34077bl instanceof AdDownloadEventConfig) && (this.f34080s instanceof AdDownloadController);
        }
        return this.f34076a instanceof AdDownloadModel;
    }

    @Override // com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok
    /* renamed from: n */
    public String mo19300n() {
        return this.f34076a.getPackageName();
    }

    @Override // com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok
    /* renamed from: o */
    public DownloadController mo19299o() {
        return this.f34080s;
    }

    @Override // com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok
    /* renamed from: ok */
    public String mo19298ok() {
        return this.f34076a.getDownloadUrl();
    }

    @Override // com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok
    /* renamed from: p */
    public int mo19297p() {
        if (this.f34080s.getDownloadMode() == 2) {
            return 2;
        }
        return this.f34076a.getFunnelType();
    }

    @Override // com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok
    /* renamed from: q */
    public String mo19296q() {
        return this.f34077bl.getRefer();
    }

    @Override // com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok
    /* renamed from: r */
    public JSONObject mo19295r() {
        return this.f34077bl.getParamsJson();
    }

    @Override // com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok
    /* renamed from: rh */
    public List<String> mo19294rh() {
        return this.f34076a.getClickTrackUrl();
    }

    @Override // com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok
    /* renamed from: s */
    public String mo19293s() {
        return this.f34076a.getLogExtra();
    }

    @Override // com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok
    /* renamed from: t */
    public Object mo19292t() {
        return this.f34077bl.getExtraEventObject();
    }

    @Override // com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok
    /* renamed from: td */
    public JSONObject mo19291td() {
        return this.f34076a.getDownloadSettings();
    }

    @Override // com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok
    /* renamed from: u */
    public int mo19290u() {
        return this.f34077bl.getDownloadScene();
    }

    @Override // com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok
    /* renamed from: ul */
    public DownloadEventConfig mo19289ul() {
        return this.f34077bl;
    }

    @Override // com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok
    /* renamed from: x */
    public boolean mo19288x() {
        return this.f34080s.enableNewActivity();
    }

    /* renamed from: y */
    public boolean m19287y() {
        DownloadModel downloadModel;
        if (this.f34079ok == 0 || (downloadModel = this.f34076a) == null || this.f34077bl == null || this.f34080s == null) {
            return true;
        }
        return downloadModel.isAd() && this.f34079ok <= 0;
    }

    @Override // com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok
    /* renamed from: z */
    public boolean mo19286z() {
        return this.f34077bl.isEnableV3Event();
    }

    @Override // com.p521ss.android.downloadad.api.p526ok.InterfaceC11999ok
    /* renamed from: zz */
    public int mo19285zz() {
        return 0;
    }

    public C12035n(long j, @NonNull DownloadModel downloadModel, @NonNull DownloadEventConfig downloadEventConfig, @NonNull DownloadController downloadController) {
        this.f34079ok = j;
        this.f34076a = downloadModel;
        this.f34077bl = downloadEventConfig;
        this.f34080s = downloadController;
    }
}
