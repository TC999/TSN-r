package com.kwad.sdk.p437i;

import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.baidu.mobads.sdk.internal.C2594an;
import com.clj.fastble.BleManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.kwad.sdk.i.l */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C10803l {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static int aJu;

    /* renamed from: com.kwad.sdk.i.l$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC10804a {
        void onSuccess();
    }

    C10803l() {
    }

    @WorkerThread
    /* renamed from: a */
    public static void m24800a(List<C10802k> list, InterfaceC10804a interfaceC10804a) {
        if (aJu > 10) {
            C10800j.logE("LogReportUtil", "request error");
            return;
        }
        C10795g m24840Jg = C10796h.m24844Jc().m24840Jg();
        Map<String, String> requestHeader = m24840Jg.getRequestHeader();
        JSONObject m24856Jb = m24840Jg.m24856Jb();
        C10789c.putValue(m24856Jb, "actionList", list);
        C10789c.putValue(m24856Jb, CampaignEx.JSON_KEY_TIMESTAMP, System.currentTimeMillis());
        m24802a(m24840Jg.m24857Ja(), requestHeader, m24799a(requestHeader, m24856Jb), interfaceC10804a);
    }

    /* renamed from: c */
    private static String m24797c(Map<String, String> map, String str) {
        C10795g m24840Jg = C10796h.m24844Jc().m24840Jg();
        JSONObject jSONObject = new JSONObject();
        C10789c.putValue(jSONObject, ConstantHelper.LOG_VS, m24840Jg.getSdkVersion());
        C10789c.putValue(jSONObject, "appId", m24840Jg.getAppId());
        C10789c.putValue(jSONObject, "message", C10787a.m24867al(str));
        C10787a.m24868a(m24840Jg.m24857Ja(), map, jSONObject.toString());
        return jSONObject.toString();
    }

    /* renamed from: c */
    private static String m24798c(InputStream inputStream) {
        InputStreamReader inputStreamReader;
        Throwable th;
        BufferedReader bufferedReader;
        try {
            inputStreamReader = new InputStreamReader(inputStream);
            try {
                bufferedReader = new BufferedReader(inputStreamReader, 1024);
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = null;
            }
        } catch (Throwable th3) {
            inputStreamReader = null;
            th = th3;
            bufferedReader = null;
        }
        try {
            String m24803a = m24803a(bufferedReader);
            C10800j.closeQuietly(bufferedReader);
            C10800j.closeQuietly(inputStreamReader);
            return m24803a;
        } catch (Throwable th4) {
            th = th4;
            C10800j.closeQuietly(bufferedReader);
            C10800j.closeQuietly(inputStreamReader);
            throw th;
        }
    }

    /* renamed from: a */
    private static String m24799a(Map<String, String> map, JSONObject jSONObject) {
        if (C10796h.m24844Jc().m24840Jg().m24858IZ()) {
            return jSONObject.toString();
        }
        return m24797c(map, jSONObject.toString());
    }

    /* renamed from: a */
    private static void m24802a(String str, Map<String, String> map, String str2, InterfaceC10804a interfaceC10804a) {
        Closeable closeable;
        HttpURLConnection httpURLConnection = null;
        OutputStream outputStream = null;
        httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setRequestMethod("POST");
                httpURLConnection2.setRequestProperty("Content-Type", C2594an.f8583d);
                httpURLConnection2.setConnectTimeout(BleManager.f22896l);
                httpURLConnection2.setReadTimeout(30000);
                httpURLConnection2.setUseCaches(false);
                m24801a(httpURLConnection2, map);
                httpURLConnection2.connect();
                if (!TextUtils.isEmpty(str2)) {
                    outputStream = httpURLConnection2.getOutputStream();
                    outputStream.write(str2.getBytes());
                    outputStream.flush();
                }
                if (httpURLConnection2.getResponseCode() == 200) {
                    String m24804a = m24804a(httpURLConnection2.getInputStream());
                    C10800j.m24812Jn();
                    if (!TextUtils.isEmpty(m24804a)) {
                        if (new JSONObject(m24804a).optInt(CommonNetImpl.RESULT) == 1) {
                            aJu = 0;
                            interfaceC10804a.onSuccess();
                        } else {
                            aJu++;
                            C10800j.m24812Jn();
                        }
                    } else {
                        aJu++;
                        C10800j.m24812Jn();
                    }
                } else {
                    aJu++;
                    C10800j.m24812Jn();
                }
                C10800j.m24809a(httpURLConnection2);
                C10800j.closeQuietly(outputStream);
            } catch (Exception unused) {
                httpURLConnection = httpURLConnection2;
                closeable = null;
                try {
                    aJu++;
                    C10800j.m24813Jm();
                    C10800j.m24809a(httpURLConnection);
                    C10800j.closeQuietly(closeable);
                } catch (Throwable th) {
                    th = th;
                    C10800j.m24809a(httpURLConnection);
                    C10800j.closeQuietly(closeable);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                httpURLConnection = httpURLConnection2;
                closeable = null;
                C10800j.m24809a(httpURLConnection);
                C10800j.closeQuietly(closeable);
                throw th;
            }
        } catch (Exception unused2) {
            closeable = null;
        } catch (Throwable th3) {
            th = th3;
            closeable = null;
        }
    }

    /* renamed from: a */
    private static void m24801a(HttpURLConnection httpURLConnection, Map<String, String> map) {
        if (map == null || httpURLConnection == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            httpURLConnection.setRequestProperty(entry.getKey(), entry.getValue());
        }
    }

    /* renamed from: a */
    private static String m24803a(Reader reader) {
        StringWriter stringWriter;
        Throwable th;
        StringWriter stringWriter2 = new StringWriter();
        try {
            stringWriter = new StringWriter();
        } catch (Throwable th2) {
            stringWriter = stringWriter2;
            th = th2;
        }
        try {
            char[] cArr = new char[1024];
            while (true) {
                int read = reader.read(cArr);
                if (read != -1) {
                    stringWriter.write(cArr, 0, read);
                } else {
                    String stringWriter3 = stringWriter.toString();
                    C10800j.closeQuietly(reader);
                    C10800j.closeQuietly(stringWriter);
                    return stringWriter3;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            C10800j.closeQuietly(reader);
            C10800j.closeQuietly(stringWriter);
            throw th;
        }
    }

    /* renamed from: a */
    private static String m24804a(InputStream inputStream) {
        try {
            try {
                return m24798c(inputStream);
            } catch (IOException unused) {
                C10800j.m24813Jm();
                C10800j.closeQuietly(inputStream);
                return null;
            }
        } finally {
            C10800j.closeQuietly(inputStream);
        }
    }
}
