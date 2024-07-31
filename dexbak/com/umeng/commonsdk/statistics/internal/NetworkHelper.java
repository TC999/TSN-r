package com.umeng.commonsdk.statistics.internal;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.AutoViewPageTracker;
import com.umeng.analytics.pro.CoreProtocolImpl;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.UMInternalConfig;
import com.umeng.commonsdk.internal.UMInternalData;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.EnvelopeManager;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.utils.UMConstant;
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

/* renamed from: com.umeng.commonsdk.statistics.internal.c */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class NetworkHelper {

    /* renamed from: e */
    private static boolean f39015e;

    /* renamed from: f */
    private static boolean f39016f;

    /* renamed from: g */
    private static boolean f39017g;

    /* renamed from: a */
    private String f39018a = "10.0.0.172";

    /* renamed from: b */
    private int f39019b = 80;

    /* renamed from: c */
    private Context f39020c;

    /* renamed from: d */
    private IRequestStat f39021d;

    public NetworkHelper(Context context) {
        this.f39020c = context;
    }

    /* renamed from: b */
    private void m13671b() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f39020c, "domain_p", "");
        String imprintProperty2 = UMEnvelopeBuild.imprintProperty(this.f39020c, "domain_s", "");
        if (!TextUtils.isEmpty(imprintProperty)) {
            UMServerURL.DEFAULT_URL = DataHelper.assembleURL(imprintProperty);
        }
        if (!TextUtils.isEmpty(imprintProperty2)) {
            UMServerURL.SECONDARY_URL = DataHelper.assembleURL(imprintProperty2);
        }
        String imprintProperty3 = UMEnvelopeBuild.imprintProperty(this.f39020c, "oversea_domain_p", "");
        String imprintProperty4 = UMEnvelopeBuild.imprintProperty(this.f39020c, "oversea_domain_s", "");
        if (!TextUtils.isEmpty(imprintProperty3)) {
            UMServerURL.OVERSEA_DEFAULT_URL = DataHelper.assembleURL(imprintProperty3);
        }
        if (!TextUtils.isEmpty(imprintProperty4)) {
            UMServerURL.OVERSEA_SECONDARY_URL = DataHelper.assembleURL(imprintProperty4);
        }
        AnalyticsConstants.APPLOG_URL_LIST = new String[]{UMServerURL.OVERSEA_DEFAULT_URL, UMServerURL.OVERSEA_SECONDARY_URL};
        if (TextUtils.isEmpty(EnvelopeManager.f38918b)) {
            return;
        }
        if (EnvelopeManager.f38918b.startsWith("460") || EnvelopeManager.f38918b.startsWith("461")) {
            AnalyticsConstants.APPLOG_URL_LIST = new String[]{UMServerURL.DEFAULT_URL, UMServerURL.SECONDARY_URL};
        }
    }

    /* renamed from: c */
    private void m13670c() {
        if (f39017g) {
            return;
        }
        ImprintHandler.getImprintService(this.f39020c).registImprintCallback(AnalyticsConstants.CFG_FIELD_KEY, new UMImprintChangeCallback() { // from class: com.umeng.commonsdk.statistics.internal.c.1
            @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
            public void onImprintValueChanged(String str, String str2) {
                if (FieldManager.m14032b()) {
                    FieldManager.m14036a().m14034a(NetworkHelper.this.f39020c, str2);
                    UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> apply imprint change and exit: key=" + str + "; value= " + str2);
                    UMWorkDispatch.sendEvent(NetworkHelper.this.f39020c, UMInternalConfig.f38811w, UMInternalData.m13974a(NetworkHelper.this.f39020c).m13975a(), null);
                }
            }
        });
        f39017g = true;
    }

    /* renamed from: d */
    private void m13669d() {
        if (f39016f) {
            return;
        }
        UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> 注册零号报文 imprint 应答处理回调。");
        ImprintHandler.getImprintService(this.f39020c).registPreProcessCallback(AnalyticsConstants.ZERO_RESPONSE_FLAG, new UMImprintPreProcessCallback() { // from class: com.umeng.commonsdk.statistics.internal.c.2
            @Override // com.umeng.commonsdk.statistics.internal.UMImprintPreProcessCallback
            public boolean onPreProcessImprintKey(String str, String str2) {
                UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> onImprintValueChanged: key=" + str + "; value= " + str2);
                FieldManager.m14036a().m14035a(NetworkHelper.this.f39020c);
                UMWorkDispatch.sendEvent(NetworkHelper.this.f39020c, UMInternalConfig.f38807s, UMInternalData.m13974a(NetworkHelper.this.f39020c).m13975a(), null);
                ImprintHandler.getImprintService(NetworkHelper.this.f39020c).m13735a(AnalyticsConstants.ZERO_RESPONSE_FLAG);
                return true;
            }
        });
        ImprintHandler.getImprintService(this.f39020c).registImprintCallback(AnalyticsConstants.CFG_FIELD_KEY, new UMImprintChangeCallback() { // from class: com.umeng.commonsdk.statistics.internal.c.3
            @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
            public void onImprintValueChanged(String str, String str2) {
                UMRTLog.m14009e(UMRTLog.RTLOG_TAG, "--->>> first onImprintValueChanged: key=" + str + "; value= " + str2);
                FieldManager.m14036a().m14034a(NetworkHelper.this.f39020c, str2);
                UMWorkDispatch.sendEvent(NetworkHelper.this.f39020c, UMInternalConfig.f38807s, UMInternalData.m13974a(NetworkHelper.this.f39020c).m13975a(), null);
                if (FieldManager.allow(UMConstant.f39159E)) {
                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> recv zcfg response: foregound count timer enabled.");
                    if (!UMWorkDispatch.eventHasExist()) {
                        UMWorkDispatch.sendEventEx(NetworkHelper.this.f39020c, CoreProtocolImpl.C13167a.f38396E, CoreProtocol.getInstance(NetworkHelper.this.f39020c), null, 0L);
                    }
                }
                if (FieldManager.allow(UMConstant.f39160F)) {
                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> recv zcfg response: FirstResumeTrigger enabled.");
                    AutoViewPageTracker.m14308a(NetworkHelper.this.f39020c).m14301b(NetworkHelper.this.f39020c);
                }
                ImprintHandler.getImprintService(NetworkHelper.this.f39020c).unregistImprintCallback(AnalyticsConstants.CFG_FIELD_KEY, this);
            }
        });
        f39016f = true;
    }

    /* renamed from: a */
    public void m13675a(IRequestStat iRequestStat) {
        this.f39021d = iRequestStat;
    }

    /* renamed from: a */
    private void m13676a() {
        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f39020c, "domain_p", "");
        String imprintProperty2 = UMEnvelopeBuild.imprintProperty(this.f39020c, "domain_s", "");
        if (!TextUtils.isEmpty(imprintProperty)) {
            UMServerURL.DEFAULT_URL = DataHelper.assembleURL(imprintProperty);
        }
        if (!TextUtils.isEmpty(imprintProperty2)) {
            UMServerURL.SECONDARY_URL = DataHelper.assembleURL(imprintProperty2);
        }
        AnalyticsConstants.APPLOG_URL_LIST = new String[]{UMServerURL.DEFAULT_URL, UMServerURL.SECONDARY_URL};
    }

    /* renamed from: a */
    public byte[] m13672a(byte[] bArr, boolean z, boolean z2, String str) {
        if (SdkVersion.SDK_TYPE == 0) {
            m13676a();
        } else {
            UMServerURL.DEFAULT_URL = UMServerURL.OVERSEA_DEFAULT_URL;
            UMServerURL.SECONDARY_URL = UMServerURL.OVERSEA_SECONDARY_URL;
            m13671b();
        }
        int i = 0;
        byte[] bArr2 = null;
        while (true) {
            String[] strArr = AnalyticsConstants.APPLOG_URL_LIST;
            if (i >= strArr.length) {
                break;
            }
            String str2 = strArr[i];
            if (z2) {
                m13669d();
            } else {
                m13670c();
            }
            bArr2 = m13673a(bArr, str2 + File.separator + str);
            if (bArr2 != null) {
                IRequestStat iRequestStat = this.f39021d;
                if (iRequestStat != null) {
                    iRequestStat.onRequestSucceed(z);
                }
            } else {
                IRequestStat iRequestStat2 = this.f39021d;
                if (iRequestStat2 != null) {
                    iRequestStat2.onRequestFailed();
                }
                i++;
            }
        }
        return bArr2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 6, insn: 0x0169: IF  (r6 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:85:0x0175, block:B:80:0x0169 */
    /* renamed from: a */
    public byte[] m13673a(byte[] bArr, String str) {
        HttpsURLConnection httpsURLConnection;
        OutputStream outputStream;
        OutputStream outputStream2;
        boolean z;
        try {
            try {
                IRequestStat iRequestStat = this.f39021d;
                if (iRequestStat != null) {
                    iRequestStat.onRequestStart();
                }
                httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
                try {
                    z = true;
                    if (!f39015e) {
                        httpsURLConnection.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
                        SSLContext sSLContext = SSLContext.getInstance("TLS");
                        sSLContext.init(null, null, new SecureRandom());
                        httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
                        f39015e = true;
                    }
                    httpsURLConnection.setRequestProperty("X-Umeng-UTC", String.valueOf(System.currentTimeMillis()));
                    httpsURLConnection.setRequestProperty("X-Umeng-Sdk", HeaderHelper.m13686a(this.f39020c).m13684b());
                    httpsURLConnection.setRequestProperty("Content-Type", HeaderHelper.m13686a(this.f39020c).m13687a());
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
                IRequestStat iRequestStat2 = this.f39021d;
                if (iRequestStat2 != null) {
                    iRequestStat2.onRequestEnd();
                }
                int responseCode = httpsURLConnection.getResponseCode();
                String headerField = httpsURLConnection.getHeaderField("Content-Type");
                if (TextUtils.isEmpty(headerField) || !headerField.equalsIgnoreCase("application/thrift")) {
                    z = false;
                }
                boolean z2 = AnalyticsConstants.UM_DEBUG;
                if (responseCode == 200 && z) {
                    InputStream inputStream = httpsURLConnection.getInputStream();
                    byte[] readStreamToByteArray = HelperUtils.readStreamToByteArray(inputStream);
                    HelperUtils.safeClose(inputStream);
                    try {
                        outputStream.close();
                    } catch (Exception e) {
                        UMCrashManager.reportCrash(this.f39020c, e);
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
                } catch (Exception e2) {
                    UMCrashManager.reportCrash(this.f39020c, e2);
                }
                try {
                    httpsURLConnection.getInputStream().close();
                } catch (IOException unused8) {
                }
                httpsURLConnection.disconnect();
                return null;
            } catch (UnknownHostException unused9) {
                UMLog.m14015aq("A_10200", 2, "\\|");
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Exception e3) {
                        UMCrashManager.reportCrash(this.f39020c, e3);
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
                UMLog.m14015aq("A_10201", 2, "\\|");
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Exception e4) {
                        UMCrashManager.reportCrash(this.f39020c, e4);
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
                    } catch (Exception e5) {
                        UMCrashManager.reportCrash(this.f39020c, e5);
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
                } catch (Exception e6) {
                    UMCrashManager.reportCrash(this.f39020c, e6);
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
