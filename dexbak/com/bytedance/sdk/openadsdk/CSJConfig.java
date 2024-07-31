package com.bytedance.sdk.openadsdk;

import com.bytedance.sdk.openadsdk.mediation.init.IMediationConfig;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class CSJConfig implements AdConfig {

    /* renamed from: a */
    private String f22301a;

    /* renamed from: bl */
    private boolean f22302bl;

    /* renamed from: h */
    private boolean f22303h;

    /* renamed from: i */
    private int f22304i;

    /* renamed from: j */
    private Map<String, Object> f22305j = new HashMap();

    /* renamed from: k */
    private boolean f22306k;

    /* renamed from: kf */
    private int f22307kf;

    /* renamed from: n */
    private String f22308n;

    /* renamed from: ok */
    private String f22309ok;

    /* renamed from: p */
    private boolean f22310p;

    /* renamed from: q */
    private int[] f22311q;

    /* renamed from: r */
    private boolean f22312r;

    /* renamed from: rh */
    private int f22313rh;

    /* renamed from: s */
    private String f22314s;

    /* renamed from: t */
    private int f22315t;

    /* renamed from: td */
    private IMediationConfig f22316td;

    /* renamed from: x */
    private boolean f22317x;

    /* renamed from: z */
    private TTCustomController f22318z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bytedance.sdk.openadsdk.CSJConfig$ok */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C6264ok {

        /* renamed from: a */
        private String f22319a;

        /* renamed from: i */
        private boolean f22322i;

        /* renamed from: j */
        private TTCustomController f22323j;

        /* renamed from: n */
        private String f22326n;

        /* renamed from: ok */
        private String f22327ok;

        /* renamed from: q */
        private int[] f22329q;

        /* renamed from: s */
        private String f22332s;

        /* renamed from: x */
        private IMediationConfig f22334x;

        /* renamed from: z */
        private int f22335z;

        /* renamed from: bl */
        private boolean f22320bl = false;

        /* renamed from: kf */
        private int f22325kf = 0;

        /* renamed from: h */
        private boolean f22321h = true;

        /* renamed from: p */
        private boolean f22328p = false;

        /* renamed from: k */
        private boolean f22324k = true;

        /* renamed from: r */
        private boolean f22330r = false;

        /* renamed from: rh */
        private int f22331rh = 2;

        /* renamed from: t */
        private int f22333t = 0;

        /* renamed from: a */
        public C6264ok m36829a(String str) {
            this.f22319a = str;
            return this;
        }

        /* renamed from: bl */
        public C6264ok m36825bl(String str) {
            this.f22332s = str;
            return this;
        }

        /* renamed from: kf */
        public C6264ok m36818kf(boolean z) {
            this.f22322i = z;
            return this;
        }

        /* renamed from: n */
        public C6264ok m36816n(boolean z) {
            this.f22330r = z;
            return this;
        }

        /* renamed from: ok */
        public C6264ok m36811ok(String str) {
            this.f22327ok = str;
            return this;
        }

        /* renamed from: s */
        public C6264ok m36802s(String str) {
            this.f22326n = str;
            return this;
        }

        /* renamed from: a */
        public C6264ok m36828a(boolean z) {
            this.f22321h = z;
            return this;
        }

        /* renamed from: bl */
        public C6264ok m36824bl(boolean z) {
            this.f22328p = z;
            return this;
        }

        /* renamed from: ok */
        public C6264ok m36810ok(boolean z) {
            this.f22320bl = z;
            return this;
        }

        /* renamed from: s */
        public C6264ok m36801s(boolean z) {
            this.f22324k = z;
            return this;
        }

        /* renamed from: a */
        public C6264ok m36831a(int i) {
            this.f22335z = i;
            return this;
        }

        /* renamed from: bl */
        public C6264ok m36827bl(int i) {
            this.f22331rh = i;
            return this;
        }

        /* renamed from: ok */
        public C6264ok m36815ok(int i) {
            this.f22325kf = i;
            return this;
        }

        /* renamed from: s */
        public C6264ok m36804s(int i) {
            this.f22333t = i;
            return this;
        }

        /* renamed from: ok */
        public C6264ok m36809ok(int... iArr) {
            this.f22329q = iArr;
            return this;
        }

        /* renamed from: ok */
        public C6264ok m36813ok(TTCustomController tTCustomController) {
            this.f22323j = tTCustomController;
            return this;
        }

        /* renamed from: ok */
        public C6264ok m36812ok(IMediationConfig iMediationConfig) {
            this.f22334x = iMediationConfig;
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CSJConfig(C6264ok c6264ok) {
        this.f22302bl = false;
        this.f22307kf = 0;
        this.f22303h = true;
        this.f22310p = false;
        this.f22306k = true;
        this.f22312r = false;
        this.f22309ok = c6264ok.f22327ok;
        this.f22301a = c6264ok.f22319a;
        this.f22302bl = c6264ok.f22320bl;
        this.f22314s = c6264ok.f22332s;
        this.f22308n = c6264ok.f22326n;
        this.f22307kf = c6264ok.f22325kf;
        this.f22303h = c6264ok.f22321h;
        this.f22310p = c6264ok.f22328p;
        this.f22311q = c6264ok.f22329q;
        this.f22306k = c6264ok.f22324k;
        this.f22312r = c6264ok.f22330r;
        this.f22318z = c6264ok.f22323j;
        this.f22313rh = c6264ok.f22335z;
        this.f22304i = c6264ok.f22333t;
        this.f22315t = c6264ok.f22331rh;
        this.f22317x = c6264ok.f22322i;
        this.f22316td = c6264ok.f22334x;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getAgeGroup() {
        return this.f22304i;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getAppId() {
        return this.f22309ok;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getAppName() {
        return this.f22301a;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public TTCustomController getCustomController() {
        return this.f22318z;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getData() {
        return this.f22308n;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int[] getDirectDownloadNetworkType() {
        return this.f22311q;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    @Deprecated
    public Object getExtra(String str) {
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public String getKeywords() {
        return this.f22314s;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public IMediationConfig getMediationConfig() {
        return this.f22316td;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getPluginUpdateConfig() {
        return this.f22315t;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getThemeStatus() {
        return this.f22313rh;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public int getTitleBarTheme() {
        return this.f22307kf;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isAllowShowNotify() {
        return this.f22303h;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isDebug() {
        return this.f22310p;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isPaid() {
        return this.f22302bl;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isSupportMultiProcess() {
        return this.f22312r;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isUseMediation() {
        return this.f22317x;
    }

    @Override // com.bytedance.sdk.openadsdk.AdConfig
    public boolean isUseTextureView() {
        return this.f22306k;
    }

    public void setAgeGroup(int i) {
        this.f22304i = i;
    }

    public void setAllowShowNotify(boolean z) {
        this.f22303h = z;
    }

    public void setAppId(String str) {
        this.f22309ok = str;
    }

    public void setAppName(String str) {
        this.f22301a = str;
    }

    public void setCustomController(TTCustomController tTCustomController) {
        this.f22318z = tTCustomController;
    }

    public void setData(String str) {
        this.f22308n = str;
    }

    public void setDebug(boolean z) {
        this.f22310p = z;
    }

    public void setDirectDownloadNetworkType(int... iArr) {
        this.f22311q = iArr;
    }

    public void setKeywords(String str) {
        this.f22314s = str;
    }

    public void setPaid(boolean z) {
        this.f22302bl = z;
    }

    public void setSupportMultiProcess(boolean z) {
        this.f22312r = z;
    }

    public void setThemeStatus(int i) {
        this.f22313rh = i;
    }

    public void setTitleBarTheme(int i) {
        this.f22307kf = i;
    }

    public void setUseTextureView(boolean z) {
        this.f22306k = z;
    }
}
