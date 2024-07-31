package com.clj.fastble.scan;

import java.util.UUID;

/* renamed from: com.clj.fastble.scan.b */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class BleScanRuleConfig {

    /* renamed from: a */
    private UUID[] f23032a = null;

    /* renamed from: b */
    private String[] f23033b = null;

    /* renamed from: c */
    private String f23034c = null;

    /* renamed from: d */
    private boolean f23035d = false;

    /* renamed from: e */
    private boolean f23036e = false;

    /* renamed from: f */
    private long f23037f = 10000;

    /* compiled from: BleScanRuleConfig.java */
    /* renamed from: com.clj.fastble.scan.b$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public static class C6532a {

        /* renamed from: a */
        private UUID[] f23038a = null;

        /* renamed from: b */
        private String[] f23039b = null;

        /* renamed from: c */
        private String f23040c = null;

        /* renamed from: d */
        private boolean f23041d = false;

        /* renamed from: e */
        private boolean f23042e = false;

        /* renamed from: f */
        private long f23043f = 10000;

        /* renamed from: a */
        void m35979a(BleScanRuleConfig bleScanRuleConfig) {
            bleScanRuleConfig.f23032a = this.f23038a;
            bleScanRuleConfig.f23033b = this.f23039b;
            bleScanRuleConfig.f23034c = this.f23040c;
            bleScanRuleConfig.f23035d = this.f23041d;
            bleScanRuleConfig.f23036e = this.f23042e;
            bleScanRuleConfig.f23037f = this.f23043f;
        }

        /* renamed from: b */
        public BleScanRuleConfig m35978b() {
            BleScanRuleConfig bleScanRuleConfig = new BleScanRuleConfig();
            m35979a(bleScanRuleConfig);
            return bleScanRuleConfig;
        }

        /* renamed from: c */
        public C6532a m35977c(boolean z) {
            this.f23041d = z;
            return this;
        }

        /* renamed from: d */
        public C6532a m35976d(String str) {
            this.f23040c = str;
            return this;
        }

        /* renamed from: e */
        public C6532a m35975e(boolean z, String... strArr) {
            this.f23042e = z;
            this.f23039b = strArr;
            return this;
        }

        /* renamed from: f */
        public C6532a m35974f(long j) {
            this.f23043f = j;
            return this;
        }

        /* renamed from: g */
        public C6532a m35973g(UUID[] uuidArr) {
            this.f23038a = uuidArr;
            return this;
        }
    }

    /* renamed from: g */
    public String m35985g() {
        return this.f23034c;
    }

    /* renamed from: h */
    public String[] m35984h() {
        return this.f23033b;
    }

    /* renamed from: i */
    public long m35983i() {
        return this.f23037f;
    }

    /* renamed from: j */
    public UUID[] m35982j() {
        return this.f23032a;
    }

    /* renamed from: k */
    public boolean m35981k() {
        return this.f23035d;
    }

    /* renamed from: l */
    public boolean m35980l() {
        return this.f23036e;
    }
}
