package com.p521ss.android.download.api.download;

import org.json.JSONObject;

@Deprecated
/* renamed from: com.ss.android.download.api.download.bl */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C11975bl implements DownloadEventConfig {

    /* renamed from: a */
    private boolean f33817a;

    /* renamed from: bl */
    private String f33818bl;

    /* renamed from: h */
    private String f33819h;

    /* renamed from: i */
    private String f33820i;

    /* renamed from: j */
    private Object f33821j;

    /* renamed from: k */
    private String f33822k;

    /* renamed from: kf */
    private String f33823kf;

    /* renamed from: n */
    private String f33824n;

    /* renamed from: ok */
    private String f33825ok;

    /* renamed from: p */
    private String f33826p;

    /* renamed from: q */
    private String f33827q;

    /* renamed from: r */
    private String f33828r;

    /* renamed from: rh */
    private boolean f33829rh;

    /* renamed from: s */
    private String f33830s;

    /* renamed from: t */
    private boolean f33831t;

    /* renamed from: x */
    private String f33832x;

    /* renamed from: z */
    private boolean f33833z;

    /* renamed from: com.ss.android.download.api.download.bl$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static final class C11977ok {

        /* renamed from: a */
        private boolean f33834a;

        /* renamed from: bl */
        private String f33835bl;

        /* renamed from: h */
        private String f33836h;

        /* renamed from: i */
        private String f33837i;

        /* renamed from: j */
        private Object f33838j;

        /* renamed from: k */
        private String f33839k;

        /* renamed from: kf */
        private String f33840kf;

        /* renamed from: n */
        private String f33841n;

        /* renamed from: ok */
        private String f33842ok;

        /* renamed from: p */
        private String f33843p;

        /* renamed from: q */
        private String f33844q;

        /* renamed from: r */
        private String f33845r;

        /* renamed from: rh */
        private boolean f33846rh;

        /* renamed from: s */
        private String f33847s;

        /* renamed from: t */
        private boolean f33848t;

        /* renamed from: x */
        private String f33849x;

        /* renamed from: z */
        private boolean f33850z;

        /* renamed from: ok */
        public C11975bl m19626ok() {
            return new C11975bl(this);
        }
    }

    @Override // com.p521ss.android.download.api.download.DownloadEventConfig
    public String getClickButtonTag() {
        return this.f33825ok;
    }

    @Override // com.p521ss.android.download.api.download.DownloadEventConfig
    public String getClickContinueLabel() {
        return this.f33823kf;
    }

    @Override // com.p521ss.android.download.api.download.DownloadEventConfig
    public String getClickInstallLabel() {
        return this.f33819h;
    }

    @Override // com.p521ss.android.download.api.download.DownloadEventConfig
    public String getClickItemTag() {
        return null;
    }

    @Override // com.p521ss.android.download.api.download.DownloadEventConfig
    public String getClickLabel() {
        return this.f33818bl;
    }

    @Override // com.p521ss.android.download.api.download.DownloadEventConfig
    public String getClickPauseLabel() {
        return this.f33824n;
    }

    @Override // com.p521ss.android.download.api.download.DownloadEventConfig
    public String getClickStartLabel() {
        return this.f33830s;
    }

    @Override // com.p521ss.android.download.api.download.DownloadEventConfig
    public int getDownloadScene() {
        return 0;
    }

    @Override // com.p521ss.android.download.api.download.DownloadEventConfig
    public Object getExtraEventObject() {
        return this.f33821j;
    }

    @Override // com.p521ss.android.download.api.download.DownloadEventConfig
    public JSONObject getExtraJson() {
        return null;
    }

    @Override // com.p521ss.android.download.api.download.DownloadEventConfig
    public JSONObject getParamsJson() {
        return null;
    }

    @Override // com.p521ss.android.download.api.download.DownloadEventConfig
    public String getRefer() {
        return this.f33832x;
    }

    @Override // com.p521ss.android.download.api.download.DownloadEventConfig
    public String getStorageDenyLabel() {
        return this.f33822k;
    }

    @Override // com.p521ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableClickEvent() {
        return this.f33817a;
    }

    @Override // com.p521ss.android.download.api.download.DownloadEventConfig
    public boolean isEnableV3Event() {
        return this.f33833z;
    }

    @Override // com.p521ss.android.download.api.download.DownloadEventConfig
    public void setDownloadScene(int i) {
    }

    @Override // com.p521ss.android.download.api.download.DownloadEventConfig
    public void setRefer(String str) {
    }

    public C11975bl() {
    }

    private C11975bl(C11977ok c11977ok) {
        this.f33825ok = c11977ok.f33842ok;
        this.f33817a = c11977ok.f33834a;
        this.f33818bl = c11977ok.f33835bl;
        this.f33830s = c11977ok.f33847s;
        this.f33824n = c11977ok.f33841n;
        this.f33823kf = c11977ok.f33840kf;
        this.f33819h = c11977ok.f33836h;
        this.f33826p = c11977ok.f33843p;
        this.f33827q = c11977ok.f33844q;
        this.f33822k = c11977ok.f33839k;
        this.f33828r = c11977ok.f33845r;
        this.f33821j = c11977ok.f33838j;
        this.f33833z = c11977ok.f33850z;
        this.f33829rh = c11977ok.f33846rh;
        this.f33831t = c11977ok.f33848t;
        this.f33820i = c11977ok.f33837i;
        this.f33832x = c11977ok.f33849x;
    }
}
