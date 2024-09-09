package com.bytedance.embedapplog.util;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class UriConfig {
    public static final String PATH_AB = "/service/2/abtest_config/";
    public static final String PATH_CONFIG = "/service/2/log_settings/";
    public static final String PATH_REGISTER = "/service/2/device_register_only/";
    public static final String PATH_SEND = "/service/2/app_log/";

    /* renamed from: c  reason: collision with root package name */
    private final String f26815c;

    /* renamed from: f  reason: collision with root package name */
    private final String f26816f;

    /* renamed from: r  reason: collision with root package name */
    private final String f26817r;
    private final String sr;
    private final String ux;

    /* renamed from: w  reason: collision with root package name */
    private final String[] f26818w;
    private final String[] xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c {

        /* renamed from: c  reason: collision with root package name */
        private String f26819c;

        /* renamed from: f  reason: collision with root package name */
        private String f26820f;

        /* renamed from: r  reason: collision with root package name */
        private String f26821r;
        private String sr;
        private String ux;

        /* renamed from: w  reason: collision with root package name */
        private String[] f26822w;
        private String[] xv;

        public c c(String str) {
            this.f26819c = str;
            return this;
        }

        public c sr(String str) {
            this.f26821r = str;
            return this;
        }

        public c w(String[] strArr) {
            this.xv = strArr;
            return this;
        }

        public c xv(String str) {
            this.ux = str;
            return this;
        }

        public c c(String[] strArr) {
            this.f26822w = strArr;
            return this;
        }

        public c w(String str) {
            this.sr = str;
            return this;
        }

        public UriConfig c() {
            return new UriConfig(this);
        }
    }

    public static UriConfig createUriConfig(int i4) {
        return com.bytedance.embedapplog.util.c.c(i4);
    }

    public String getAbUri() {
        return this.ux;
    }

    public String getMonitorUri() {
        return this.f26817r;
    }

    public String getProfileUri() {
        return this.f26816f;
    }

    public String[] getRealUris() {
        return this.xv;
    }

    public String getRegisterUri() {
        return this.f26815c;
    }

    public String[] getSendUris() {
        return this.f26818w;
    }

    public String getSettingUri() {
        return this.sr;
    }

    private UriConfig(c cVar) {
        this.f26815c = cVar.f26819c;
        this.f26818w = cVar.f26822w;
        this.xv = cVar.xv;
        this.sr = cVar.sr;
        this.ux = cVar.ux;
        this.f26816f = cVar.f26820f;
        this.f26817r = cVar.f26821r;
    }
}
