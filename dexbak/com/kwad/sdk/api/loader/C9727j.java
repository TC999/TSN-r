package com.kwad.sdk.api.loader;

import com.kwad.sdk.api.C9702c;
import com.kwad.sdk.api.loader.C9712a;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import org.json.JSONObject;
import p011a.R8$$SyntheticClass;

/* renamed from: com.kwad.sdk.api.loader.j */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9727j {
    public static int ams;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.api.loader.j$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9728a {
        private int amt;
        private int amu;
        private String amv;
        private String amw;
        private long amx;
        private int amy;
        private String amz;

        private C9728a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: aa */
        public C9728a m27904aa(long j) {
            this.amx = j;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: bX */
        public C9728a m27901bX(int i) {
            this.amt = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: bY */
        public C9728a m27900bY(int i) {
            this.amu = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: bZ */
        public C9728a m27899bZ(int i) {
            this.amy = i;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: cd */
        public C9728a m27896cd(String str) {
            this.amv = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: ce */
        public C9728a m27895ce(String str) {
            this.amw = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: cf */
        public C9728a m27894cf(String str) {
            this.amz = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("load_status", Integer.valueOf(this.amt));
                jSONObject.putOpt("update_count", Integer.valueOf(this.amu));
                jSONObject.putOpt("dynamic_version", this.amv);
                jSONObject.putOpt(DownloadModel.DOWNLOAD_URL, this.amw);
                jSONObject.putOpt("duration_ms", Long.valueOf(this.amx));
                jSONObject.putOpt("error_code", Integer.valueOf(this.amy));
                jSONObject.putOpt("error_msg", this.amz);
            } catch (Exception unused) {
            }
            return jSONObject;
        }

        public final String toString() {
            return "MonitorInfo{load_status=" + this.amt + ", update_count=" + this.amu + ", dynamic_version='" + this.amv + "', download_url='" + this.amw + "', duration_ms=" + this.amx + ", error_code=" + this.amy + ", error_msg='" + this.amz + "'}";
        }

        /* synthetic */ C9728a(byte b) {
            this();
        }
    }

    /* renamed from: a */
    public static void m27915a(C9712a.C9713a c9713a) {
        ams++;
        m27916a(1, c9713a, 0L, 0, "");
    }

    /* renamed from: b */
    public static void m27911b(C9712a.C9713a c9713a) {
        m27916a(5, c9713a, 0L, 0, "");
    }

    /* renamed from: b */
    public static void m27909b(C9712a.C9713a c9713a, long j) {
        m27916a(6, c9713a, j, 0, "");
    }

    /* renamed from: a */
    public static void m27913a(C9712a.C9713a c9713a, long j) {
        m27916a(2, c9713a, j, 0, "");
    }

    /* renamed from: b */
    public static void m27910b(C9712a.C9713a c9713a, int i, String str) {
        m27916a(7, c9713a, 0L, i, str);
    }

    /* renamed from: a */
    public static void m27912a(C9712a.C9713a c9713a, long j, String str) {
        m27916a(3, c9713a, j, 0, str);
    }

    /* renamed from: a */
    public static void m27914a(C9712a.C9713a c9713a, int i, String str) {
        m27916a(4, c9713a, 0L, i, str);
    }

    /* renamed from: a */
    private static void m27916a(int i, C9712a.C9713a c9713a, long j, int i2, String str) {
        if (c9713a == null) {
            return;
        }
        try {
            JSONObject json = new C9728a((byte) 0).m27901bX(i).m27900bY(ams).m27896cd(c9713a.sdkVersion).m27895ce(c9713a.alX).m27904aa(j).m27899bZ(i2).m27894cf(str).toJson();
            R8$$SyntheticClass.m60055a(json);
            C9702c.m28017f("reportDynamicUpdate", json);
        } catch (Throwable unused) {
        }
    }
}
