package com.ss.android.download.api.download;

import org.json.JSONObject;

@Deprecated
/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class xv implements DownloadEventConfig {

    /* renamed from: a  reason: collision with root package name */
    private Object f48185a;
    private boolean bk;

    /* renamed from: c  reason: collision with root package name */
    private String f48186c;
    private String ev;

    /* renamed from: f  reason: collision with root package name */
    private String f48187f;
    private String fp;
    private String gd;
    private String ia;

    /* renamed from: k  reason: collision with root package name */
    private String f48188k;

    /* renamed from: p  reason: collision with root package name */
    private String f48189p;

    /* renamed from: r  reason: collision with root package name */
    private String f48190r;
    private String sr;

    /* renamed from: t  reason: collision with root package name */
    private boolean f48191t;
    private String ux;

    /* renamed from: w  reason: collision with root package name */
    private boolean f48192w;
    private String xv;
    private boolean ys;

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private Object f48193a;
        private boolean bk;

        /* renamed from: c  reason: collision with root package name */
        private String f48194c;
        private String ev;

        /* renamed from: f  reason: collision with root package name */
        private String f48195f;
        private String fp;
        private String gd;
        private String ia;

        /* renamed from: k  reason: collision with root package name */
        private String f48196k;

        /* renamed from: p  reason: collision with root package name */
        private String f48197p;

        /* renamed from: r  reason: collision with root package name */
        private String f48198r;
        private String sr;

        /* renamed from: t  reason: collision with root package name */
        private boolean f48199t;
        private String ux;

        /* renamed from: w  reason: collision with root package name */
        private boolean f48200w;
        private String xv;
        private boolean ys;

        public xv c() {
            return new xv(this);
        }
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickButtonTag() {
        return this.f48186c;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickContinueLabel() {
        return this.f48187f;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickInstallLabel() {
        return this.f48190r;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickItemTag() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickLabel() {
        return this.xv;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickPauseLabel() {
        return this.ux;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickStartLabel() {
        return this.sr;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public int getDownloadScene() {
        return 0;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public Object getExtraEventObject() {
        return this.f48185a;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public JSONObject getExtraJson() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public JSONObject getParamsJson() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getRefer() {
        return this.ia;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getStorageDenyLabel() {
        return this.f48189p;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableClickEvent() {
        return this.f48192w;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableV3Event() {
        return this.bk;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public void setDownloadScene(int i4) {
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public void setRefer(String str) {
    }

    public xv() {
    }

    private xv(c cVar) {
        this.f48186c = cVar.f48194c;
        this.f48192w = cVar.f48200w;
        this.xv = cVar.xv;
        this.sr = cVar.sr;
        this.ux = cVar.ux;
        this.f48187f = cVar.f48195f;
        this.f48190r = cVar.f48198r;
        this.ev = cVar.ev;
        this.gd = cVar.gd;
        this.f48189p = cVar.f48197p;
        this.f48188k = cVar.f48196k;
        this.f48185a = cVar.f48193a;
        this.bk = cVar.bk;
        this.f48191t = cVar.f48199t;
        this.ys = cVar.ys;
        this.fp = cVar.fp;
        this.ia = cVar.ia;
    }
}
