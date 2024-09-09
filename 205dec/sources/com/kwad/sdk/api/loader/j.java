package com.kwad.sdk.api.loader;

import com.kwad.sdk.api.loader.a;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class j {
    public static int ams;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a {
        private int amt;
        private int amu;
        private String amv;
        private String amw;
        private long amx;
        private int amy;
        private String amz;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a aa(long j4) {
            this.amx = j4;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a bX(int i4) {
            this.amt = i4;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a bY(int i4) {
            this.amu = i4;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a bZ(int i4) {
            this.amy = i4;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a cd(String str) {
            this.amv = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a ce(String str) {
            this.amw = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a cf(String str) {
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

        /* synthetic */ a(byte b4) {
            this();
        }
    }

    public static void a(a.C0681a c0681a) {
        ams++;
        a(1, c0681a, 0L, 0, "");
    }

    public static void b(a.C0681a c0681a) {
        a(5, c0681a, 0L, 0, "");
    }

    public static void b(a.C0681a c0681a, long j4) {
        a(6, c0681a, j4, 0, "");
    }

    public static void a(a.C0681a c0681a, long j4) {
        a(2, c0681a, j4, 0, "");
    }

    public static void b(a.C0681a c0681a, int i4, String str) {
        a(7, c0681a, 0L, i4, str);
    }

    public static void a(a.C0681a c0681a, long j4, String str) {
        a(3, c0681a, j4, 0, str);
    }

    public static void a(a.C0681a c0681a, int i4, String str) {
        a(4, c0681a, 0L, i4, str);
    }

    private static void a(int i4, a.C0681a c0681a, long j4, int i5, String str) {
        if (c0681a == null) {
            return;
        }
        try {
            JSONObject json = new a((byte) 0).bX(i4).bY(ams).cd(c0681a.sdkVersion).ce(c0681a.alX).aa(j4).bZ(i5).cf(str).toJson();
            a.a.a(json);
            com.kwad.sdk.api.c.f("reportDynamicUpdate", json);
        } catch (Throwable unused) {
        }
    }
}
