package com.ss.android.download.api.download;

import org.json.JSONObject;

@Deprecated
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class bl implements DownloadEventConfig {

    /* renamed from: a  reason: collision with root package name */
    private boolean f48159a;
    private String bl;

    /* renamed from: h  reason: collision with root package name */
    private String f48160h;

    /* renamed from: i  reason: collision with root package name */
    private String f48161i;

    /* renamed from: j  reason: collision with root package name */
    private Object f48162j;

    /* renamed from: k  reason: collision with root package name */
    private String f48163k;
    private String kf;

    /* renamed from: n  reason: collision with root package name */
    private String f48164n;
    private String ok;

    /* renamed from: p  reason: collision with root package name */
    private String f48165p;

    /* renamed from: q  reason: collision with root package name */
    private String f48166q;

    /* renamed from: r  reason: collision with root package name */
    private String f48167r;
    private boolean rh;

    /* renamed from: s  reason: collision with root package name */
    private String f48168s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f48169t;

    /* renamed from: x  reason: collision with root package name */
    private String f48170x;

    /* renamed from: z  reason: collision with root package name */
    private boolean f48171z;

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static final class ok {

        /* renamed from: a  reason: collision with root package name */
        private boolean f48172a;
        private String bl;

        /* renamed from: h  reason: collision with root package name */
        private String f48173h;

        /* renamed from: i  reason: collision with root package name */
        private String f48174i;

        /* renamed from: j  reason: collision with root package name */
        private Object f48175j;

        /* renamed from: k  reason: collision with root package name */
        private String f48176k;
        private String kf;

        /* renamed from: n  reason: collision with root package name */
        private String f48177n;
        private String ok;

        /* renamed from: p  reason: collision with root package name */
        private String f48178p;

        /* renamed from: q  reason: collision with root package name */
        private String f48179q;

        /* renamed from: r  reason: collision with root package name */
        private String f48180r;
        private boolean rh;

        /* renamed from: s  reason: collision with root package name */
        private String f48181s;

        /* renamed from: t  reason: collision with root package name */
        private boolean f48182t;

        /* renamed from: x  reason: collision with root package name */
        private String f48183x;

        /* renamed from: z  reason: collision with root package name */
        private boolean f48184z;

        public bl ok() {
            return new bl(this);
        }
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickButtonTag() {
        return this.ok;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickContinueLabel() {
        return this.kf;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickInstallLabel() {
        return this.f48160h;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickItemTag() {
        return null;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickLabel() {
        return this.bl;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickPauseLabel() {
        return this.f48164n;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getClickStartLabel() {
        return this.f48168s;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public int getDownloadScene() {
        return 0;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public Object getExtraEventObject() {
        return this.f48162j;
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
        return this.f48170x;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public String getStorageDenyLabel() {
        return this.f48163k;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableClickEvent() {
        return this.f48159a;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableV3Event() {
        return this.f48171z;
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public void setDownloadScene(int i4) {
    }

    @Override // com.ss.android.download.api.download.DownloadEventConfig
    public void setRefer(String str) {
    }

    public bl() {
    }

    private bl(ok okVar) {
        this.ok = okVar.ok;
        this.f48159a = okVar.f48172a;
        this.bl = okVar.bl;
        this.f48168s = okVar.f48181s;
        this.f48164n = okVar.f48177n;
        this.kf = okVar.kf;
        this.f48160h = okVar.f48173h;
        this.f48165p = okVar.f48178p;
        this.f48166q = okVar.f48179q;
        this.f48163k = okVar.f48176k;
        this.f48167r = okVar.f48180r;
        this.f48162j = okVar.f48175j;
        this.f48171z = okVar.f48184z;
        this.rh = okVar.rh;
        this.f48169t = okVar.f48182t;
        this.f48161i = okVar.f48174i;
        this.f48170x = okVar.f48183x;
    }
}
