package com.kwad.sdk.api.loader;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import java.io.File;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class k {
    private final String amA;
    private final String amB;
    private final String amC;
    private Resources amD;
    private ClassLoader amE;
    private IKsAdSDK amF;

    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    static class a {
        private int anN;
        private int anO;
        private String anP;
        private String anQ;
        private long anR;
        private int anS;
        private String anT;

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a ah(long j4) {
            this.anR = j4;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a bX(int i4) {
            this.anN = i4;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a bY(int i4) {
            this.anO = i4;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a bZ(int i4) {
            this.anS = i4;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a cm(String str) {
            this.anP = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a cn(String str) {
            this.anQ = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a co(String str) {
            this.anT = str;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("load_status", Integer.valueOf(this.anN));
                jSONObject.putOpt("update_count", Integer.valueOf(this.anO));
                jSONObject.putOpt("dynamic_version", this.anP);
                jSONObject.putOpt(DownloadModel.DOWNLOAD_URL, this.anQ);
                jSONObject.putOpt("duration_ms", Long.valueOf(this.anR));
                jSONObject.putOpt("error_code", Integer.valueOf(this.anS));
                jSONObject.putOpt("error_msg", this.anT);
            } catch (Exception unused) {
            }
            return jSONObject;
        }

        public final String toString() {
            return "MonitorInfo{load_status=" + this.anN + ", update_count=" + this.anO + ", dynamic_version='" + this.anP + "', download_url='" + this.anQ + "', duration_ms=" + this.anR + ", error_code=" + this.anS + ", error_msg='" + this.anT + "'}";
        }

        /* synthetic */ a(byte b4) {
            this();
        }
    }

    private k(String str, String str2, String str3) {
        this.amA = str;
        this.amB = str2;
        this.amC = str3;
    }

    private void Ag() {
        if (!TextUtils.isEmpty(this.amA)) {
            File file = new File(this.amA);
            if (!file.isFile() || !file.exists()) {
                throw new RuntimeException("mApk not a file");
            }
            return;
        }
        throw new RuntimeException("mApk is null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized k a(Context context, ClassLoader classLoader, String str) {
        k b4;
        synchronized (k.class) {
            try {
                b4 = b(context, classLoader, h.s(context, str), h.t(context, str), h.u(context, str));
            } catch (Throwable th) {
                com.kwad.sdk.api.c.m(th);
                return null;
            }
        }
        return b4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static k b(Context context, ClassLoader classLoader, String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                k kVar = new k(str, str2, str3);
                kVar.a(context, classLoader);
                return kVar;
            }
            throw new RuntimeException("mApk not a file");
        }
        throw new RuntimeException("mApk is null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Resources Ae() {
        return this.amD;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final IKsAdSDK Af() {
        return this.amF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ClassLoader getClassLoader() {
        return this.amE;
    }

    public final String toString() {
        return "ExternalPackage{mApk='" + this.amA + "', mDexDir='" + this.amB + "', mNativeLibDir='" + this.amC + "', mResource=" + this.amD + ", mClassLoader=" + this.amE + ", mKsSdk=" + this.amF + '}';
    }

    private void a(Context context, ClassLoader classLoader) {
        Ag();
        Resources a4 = q.a(context, context.getResources(), this.amA);
        ClassLoader a5 = e.a(context, classLoader, this.amA, this.amB, this.amC);
        IKsAdSDK a6 = Loader.a(a5);
        this.amD = a4;
        this.amE = a5;
        this.amF = a6;
        int sDKType = a6.getSDKType();
        if (sDKType == 1) {
            return;
        }
        throw new RuntimeException("sdkType error apiType: 1 , sdkType:" + sDKType);
    }
}
