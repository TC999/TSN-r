package com.umeng.commonsdk.statistics.internal;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.l;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLHandshakeException;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: NetworkHelper.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class c {

    /* renamed from: e  reason: collision with root package name */
    private static boolean f53650e;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f53651f;

    /* renamed from: g  reason: collision with root package name */
    private static boolean f53652g;

    /* renamed from: a  reason: collision with root package name */
    private String f53653a = "10.0.0.172";

    /* renamed from: b  reason: collision with root package name */
    private int f53654b = 80;

    /* renamed from: c  reason: collision with root package name */
    private Context f53655c;

    /* renamed from: d  reason: collision with root package name */
    private b f53656d;

    public c(Context context) {
        this.f53655c = context;
    }

    private void b() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f53655c, "domain_p", "");
        String imprintProperty2 = UMEnvelopeBuild.imprintProperty(this.f53655c, "domain_s", "");
        if (!TextUtils.isEmpty(imprintProperty)) {
            UMServerURL.DEFAULT_URL = DataHelper.assembleURL(imprintProperty);
        }
        if (!TextUtils.isEmpty(imprintProperty2)) {
            UMServerURL.SECONDARY_URL = DataHelper.assembleURL(imprintProperty2);
        }
        String imprintProperty3 = UMEnvelopeBuild.imprintProperty(this.f53655c, "oversea_domain_p", "");
        String imprintProperty4 = UMEnvelopeBuild.imprintProperty(this.f53655c, "oversea_domain_s", "");
        if (!TextUtils.isEmpty(imprintProperty3)) {
            UMServerURL.OVERSEA_DEFAULT_URL = DataHelper.assembleURL(imprintProperty3);
        }
        if (!TextUtils.isEmpty(imprintProperty4)) {
            UMServerURL.OVERSEA_SECONDARY_URL = DataHelper.assembleURL(imprintProperty4);
        }
        AnalyticsConstants.APPLOG_URL_LIST = new String[]{UMServerURL.OVERSEA_DEFAULT_URL, UMServerURL.OVERSEA_SECONDARY_URL};
        if (TextUtils.isEmpty(com.umeng.commonsdk.statistics.b.f53553b)) {
            return;
        }
        if (com.umeng.commonsdk.statistics.b.f53553b.startsWith("460") || com.umeng.commonsdk.statistics.b.f53553b.startsWith("461")) {
            AnalyticsConstants.APPLOG_URL_LIST = new String[]{UMServerURL.DEFAULT_URL, UMServerURL.SECONDARY_URL};
        }
    }

    private void c() {
        if (f53652g) {
            return;
        }
        ImprintHandler.getImprintService(this.f53655c).registImprintCallback("cfgfd", new UMImprintChangeCallback() { // from class: com.umeng.commonsdk.statistics.internal.c.1
            @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
            public void onImprintValueChanged(String str, String str2) {
                if (FieldManager.b()) {
                    FieldManager.a().a(c.this.f53655c, str2);
                    UMRTLog.e("MobclickRT", "--->>> apply imprint change and exit: key=" + str + "; value= " + str2);
                    UMWorkDispatch.sendEvent(c.this.f53655c, 32788, com.umeng.commonsdk.internal.b.a(c.this.f53655c).a(), null);
                }
            }
        });
        f53652g = true;
    }

    private void d() {
        if (f53651f) {
            return;
        }
        UMRTLog.e("MobclickRT", "--->>> \u6ce8\u518c\u96f6\u53f7\u62a5\u6587 imprint \u5e94\u7b54\u5904\u7406\u56de\u8c03\u3002");
        ImprintHandler.getImprintService(this.f53655c).registPreProcessCallback("iscfg", new UMImprintPreProcessCallback() { // from class: com.umeng.commonsdk.statistics.internal.c.2
            @Override // com.umeng.commonsdk.statistics.internal.UMImprintPreProcessCallback
            public boolean onPreProcessImprintKey(String str, String str2) {
                UMRTLog.e("MobclickRT", "--->>> onImprintValueChanged: key=" + str + "; value= " + str2);
                FieldManager.a().a(c.this.f53655c);
                UMWorkDispatch.sendEvent(c.this.f53655c, 32784, com.umeng.commonsdk.internal.b.a(c.this.f53655c).a(), null);
                ImprintHandler.getImprintService(c.this.f53655c).a("iscfg");
                return true;
            }
        });
        ImprintHandler.getImprintService(this.f53655c).registImprintCallback("cfgfd", new UMImprintChangeCallback() { // from class: com.umeng.commonsdk.statistics.internal.c.3
            @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
            public void onImprintValueChanged(String str, String str2) {
                UMRTLog.e("MobclickRT", "--->>> first onImprintValueChanged: key=" + str + "; value= " + str2);
                FieldManager.a().a(c.this.f53655c, str2);
                UMWorkDispatch.sendEvent(c.this.f53655c, 32784, com.umeng.commonsdk.internal.b.a(c.this.f53655c).a(), null);
                if (FieldManager.allow("header_foreground_count")) {
                    UMRTLog.i("MobclickRT", "--->>> recv zcfg response: foregound count timer enabled.");
                    if (!UMWorkDispatch.eventHasExist()) {
                        UMWorkDispatch.sendEventEx(c.this.f53655c, 8213, CoreProtocol.getInstance(c.this.f53655c), null, 0L);
                    }
                }
                if (FieldManager.allow("header_first_resume")) {
                    UMRTLog.i("MobclickRT", "--->>> recv zcfg response: FirstResumeTrigger enabled.");
                    l.a(c.this.f53655c).b(c.this.f53655c);
                }
                ImprintHandler.getImprintService(c.this.f53655c).unregistImprintCallback("cfgfd", this);
            }
        });
        f53651f = true;
    }

    public void a(b bVar) {
        this.f53656d = bVar;
    }

    private void a() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f53655c, "domain_p", "");
        String imprintProperty2 = UMEnvelopeBuild.imprintProperty(this.f53655c, "domain_s", "");
        if (!TextUtils.isEmpty(imprintProperty)) {
            UMServerURL.DEFAULT_URL = DataHelper.assembleURL(imprintProperty);
        }
        if (!TextUtils.isEmpty(imprintProperty2)) {
            UMServerURL.SECONDARY_URL = DataHelper.assembleURL(imprintProperty2);
        }
        AnalyticsConstants.APPLOG_URL_LIST = new String[]{UMServerURL.DEFAULT_URL, UMServerURL.SECONDARY_URL};
    }

    public byte[] a(byte[] bArr, boolean z3, boolean z4, String str) {
        if (SdkVersion.SDK_TYPE == 0) {
            a();
        } else {
            UMServerURL.DEFAULT_URL = UMServerURL.OVERSEA_DEFAULT_URL;
            UMServerURL.SECONDARY_URL = UMServerURL.OVERSEA_SECONDARY_URL;
            b();
        }
        int i4 = 0;
        byte[] bArr2 = null;
        while (true) {
            String[] strArr = AnalyticsConstants.APPLOG_URL_LIST;
            if (i4 >= strArr.length) {
                break;
            }
            String str2 = strArr[i4];
            if (z4) {
                d();
            } else {
                c();
            }
            bArr2 = a(bArr, str2 + File.separator + str);
            if (bArr2 != null) {
                b bVar = this.f53656d;
                if (bVar != null) {
                    bVar.onRequestSucceed(z3);
                }
            } else {
                b bVar2 = this.f53656d;
                if (bVar2 != null) {
                    bVar2.onRequestFailed();
                }
                i4++;
            }
        }
        return bArr2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x0169: IF  (r6 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:85:0x0175, block:B:80:0x0169 */
    public byte[] a(byte[] bArr, String str) {
        HttpsURLConnection httpsURLConnection;
        OutputStream outputStream;
        OutputStream outputStream2;
        boolean z3;
        try {
            try {
                b bVar = this.f53656d;
                if (bVar != null) {
                    bVar.onRequestStart();
                }
                httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
                try {
                    z3 = true;
                    if (!f53650e) {
                        httpsURLConnection.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                        SSLContext sSLContext = SSLContext.getInstance("TLS");
                        sSLContext.init(null, null, new SecureRandom());
                        httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
                        f53650e = true;
                    }
                    httpsURLConnection.setRequestProperty("X-Umeng-UTC", String.valueOf(System.currentTimeMillis()));
                    httpsURLConnection.setRequestProperty("X-Umeng-Sdk", a.a(this.f53655c).b());
                    httpsURLConnection.setRequestProperty("Content-Type", a.a(this.f53655c).a());
                    httpsURLConnection.setRequestProperty("Msg-Type", "envelope/json");
                    httpsURLConnection.setRequestProperty("X-Umeng-Pro-Ver", "1.0.0");
                    httpsURLConnection.setRequestProperty("SM-IMP", "1");
                    httpsURLConnection.setRequestProperty("User-Agent", DeviceConfig.getCustomAgt());
                    httpsURLConnection.setConnectTimeout(30000);
                    httpsURLConnection.setReadTimeout(30000);
                    httpsURLConnection.setRequestMethod("POST");
                    httpsURLConnection.setDoOutput(true);
                    httpsURLConnection.setDoInput(true);
                    httpsURLConnection.setUseCaches(false);
                    outputStream = httpsURLConnection.getOutputStream();
                } catch (UnknownHostException unused) {
                    outputStream = null;
                } catch (SSLHandshakeException unused2) {
                    outputStream = null;
                } catch (Throwable unused3) {
                    outputStream = null;
                }
            } catch (UnknownHostException unused4) {
                httpsURLConnection = null;
                outputStream = null;
            } catch (SSLHandshakeException unused5) {
                httpsURLConnection = null;
                outputStream = null;
            } catch (Throwable unused6) {
                httpsURLConnection = null;
                outputStream = null;
            }
            try {
                outputStream.write(bArr);
                outputStream.flush();
                httpsURLConnection.connect();
                b bVar2 = this.f53656d;
                if (bVar2 != null) {
                    bVar2.onRequestEnd();
                }
                int responseCode = httpsURLConnection.getResponseCode();
                String headerField = httpsURLConnection.getHeaderField("Content-Type");
                if (TextUtils.isEmpty(headerField) || !headerField.equalsIgnoreCase("application/thrift")) {
                    z3 = false;
                }
                boolean z4 = AnalyticsConstants.UM_DEBUG;
                if (responseCode == 200 && z3) {
                    InputStream inputStream = httpsURLConnection.getInputStream();
                    byte[] readStreamToByteArray = HelperUtils.readStreamToByteArray(inputStream);
                    HelperUtils.safeClose(inputStream);
                    try {
                        outputStream.close();
                    } catch (Exception e4) {
                        UMCrashManager.reportCrash(this.f53655c, e4);
                    }
                    try {
                        httpsURLConnection.getInputStream().close();
                    } catch (IOException unused7) {
                    }
                    httpsURLConnection.disconnect();
                    return readStreamToByteArray;
                }
                try {
                    outputStream.close();
                } catch (Exception e5) {
                    UMCrashManager.reportCrash(this.f53655c, e5);
                }
                try {
                    httpsURLConnection.getInputStream().close();
                } catch (IOException unused8) {
                }
                httpsURLConnection.disconnect();
                return null;
            } catch (UnknownHostException unused9) {
                UMLog.aq("A_10200", 2, "\\|");
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Exception e6) {
                        UMCrashManager.reportCrash(this.f53655c, e6);
                    }
                }
                if (httpsURLConnection != null) {
                    try {
                        httpsURLConnection.getInputStream().close();
                    } catch (IOException unused10) {
                    }
                    httpsURLConnection.disconnect();
                }
                return null;
            } catch (SSLHandshakeException unused11) {
                UMLog.aq("A_10201", 2, "\\|");
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Exception e7) {
                        UMCrashManager.reportCrash(this.f53655c, e7);
                    }
                }
                if (httpsURLConnection != null) {
                    try {
                        httpsURLConnection.getInputStream().close();
                    } catch (IOException unused12) {
                    }
                    httpsURLConnection.disconnect();
                }
                return null;
            } catch (Throwable unused13) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Exception e8) {
                        UMCrashManager.reportCrash(this.f53655c, e8);
                    }
                }
                if (httpsURLConnection != null) {
                    try {
                        httpsURLConnection.getInputStream().close();
                    } catch (IOException unused14) {
                    }
                    httpsURLConnection.disconnect();
                }
                return null;
            }
        } catch (Throwable th) {
            if (outputStream2 != null) {
                try {
                    outputStream2.close();
                } catch (Exception e9) {
                    UMCrashManager.reportCrash(this.f53655c, e9);
                }
            }
            if (str != 0) {
                try {
                    str.getInputStream().close();
                } catch (IOException unused15) {
                }
                str.disconnect();
            }
            throw th;
        }
    }
}
