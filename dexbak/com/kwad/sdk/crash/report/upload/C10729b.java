package com.kwad.sdk.crash.report.upload;

import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.core.network.C10415c;
import com.kwad.sdk.core.network.C10440p;
import com.kwad.sdk.core.network.idc.C10425a;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.crash.utils.C10738b;
import com.kwad.sdk.crash.utils.C10747h;
import com.kwad.sdk.utils.C10977a;
import com.kwad.sdk.utils.C11122q;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.crash.report.upload.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10729b {
    /* renamed from: a */
    private static void m25018a(@NonNull File file, @NonNull String str, String str2, @NonNull Map<String, String> map, @NonNull InterfaceC10728a interfaceC10728a) {
        DataInputStream dataInputStream;
        OutputStream outputStream;
        C10331c.m26254d("AdExceptionCollector", "uploadLogFile " + Thread.currentThread());
        C10415c c10415c = new C10415c();
        String uuid = UUID.randomUUID().toString();
        String name = file.getName();
        String str3 = "https://" + C10425a.m26107DU().m26103W("ulog", "ulog-sdk.gifshow.com") + "/rest/log/sdk/file/upload";
        int i = -1;
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str3).openConnection();
            try {
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.setConnectTimeout(5000);
                httpURLConnection2.setReadTimeout(5000);
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.setRequestMethod("POST");
                httpURLConnection2.setRequestProperty("connection", "Keep-Alive");
                httpURLConnection2.setRequestProperty("User-Agent", C10440p.getUserAgent());
                httpURLConnection2.setRequestProperty("Charset", "UTF-8");
                httpURLConnection2.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + uuid);
                httpURLConnection2.setRequestProperty(HttpHeaders.Names.CONTENT_MD5, Base64.encodeToString(C10977a.m24266gp(file.getPath()), 2));
                httpURLConnection2.setRequestProperty("file-type", "." + C11122q.getExtension(file.getName()));
                httpURLConnection2.setRequestProperty("origin-name", name);
                httpURLConnection2.setRequestProperty(HttpHeaders.Names.COOKIE, "did=" + str);
                httpURLConnection2.connect();
                outputStream = httpURLConnection2.getOutputStream();
                try {
                    for (String str4 : map.keySet()) {
                        outputStream.write(m25017e(str4, map.get(str4), uuid));
                    }
                    byte[] bytes = ("\r\n--" + uuid + "--\r\n").getBytes();
                    StringBuilder sb = new StringBuilder();
                    sb.append("--");
                    sb.append(uuid);
                    sb.append("\r\n");
                    sb.append("Content-Disposition: form-data;name=\"file\";filename=\"" + name + "\"\r\n");
                    sb.append("Content-Type: application/octet-stream\r\n\r\n");
                    outputStream.write(sb.toString().getBytes());
                    dataInputStream = new DataInputStream(new FileInputStream(file));
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = dataInputStream.read(bArr);
                            if (read == -1) {
                                break;
                            }
                            outputStream.write(bArr, 0, read);
                        }
                        outputStream.write("\r\n".getBytes());
                        outputStream.write(bytes);
                        outputStream.flush();
                        int responseCode = httpURLConnection2.getResponseCode();
                        c10415c.code = responseCode;
                        c10415c.avq = responseCode;
                        if (responseCode == 200) {
                            c10415c.avs = C10747h.m24953a(httpURLConnection2.getInputStream());
                            try {
                                if (new JSONObject(c10415c.avs).optInt(CommonNetImpl.RESULT, -1) == 1) {
                                    interfaceC10728a.mo25010Ic();
                                } else {
                                    C10735e c10735e = C10735e.aHA;
                                    interfaceC10728a.mo25011Ib();
                                }
                            } catch (JSONException unused) {
                                C10735e c10735e2 = C10735e.aHB;
                                interfaceC10728a.mo25011Ib();
                            }
                            C10331c.m26254d("AdExceptionCollector", "response.body= " + c10415c.avs);
                        } else {
                            C10735e c10735e3 = C10735e.aHz;
                            C10735e.aHz.m25009wn();
                            interfaceC10728a.mo25011Ib();
                            C10425a m26107DU = C10425a.m26107DU();
                            int i2 = c10415c.code;
                            if (i2 == 0) {
                                i2 = -1;
                            }
                            m26107DU.m26095a(str3, i2, (Throwable) null);
                        }
                        C10738b.m25007a(httpURLConnection2);
                    } catch (Exception e) {
                        e = e;
                        httpURLConnection = httpURLConnection2;
                        try {
                            C10735e c10735e4 = C10735e.aHz;
                            e.getCause();
                            interfaceC10728a.mo25011Ib();
                            C10425a m26107DU2 = C10425a.m26107DU();
                            int i3 = c10415c.code;
                            if (i3 != 0) {
                                i = i3;
                            }
                            m26107DU2.m26095a(str3, i, e);
                            C10331c.printStackTrace(e);
                            C10738b.m25007a(httpURLConnection);
                            C10738b.closeQuietly(dataInputStream);
                            C10738b.closeQuietly(outputStream);
                        } catch (Throwable th) {
                            th = th;
                            C10738b.m25007a(httpURLConnection);
                            C10738b.closeQuietly(dataInputStream);
                            C10738b.closeQuietly(outputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        httpURLConnection = httpURLConnection2;
                        C10738b.m25007a(httpURLConnection);
                        C10738b.closeQuietly(dataInputStream);
                        C10738b.closeQuietly(outputStream);
                        throw th;
                    }
                } catch (Exception e2) {
                    e = e2;
                    dataInputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    dataInputStream = null;
                }
            } catch (Exception e3) {
                e = e3;
                dataInputStream = null;
                outputStream = null;
            } catch (Throwable th4) {
                th = th4;
                dataInputStream = null;
                outputStream = null;
            }
        } catch (Exception e4) {
            e = e4;
            dataInputStream = null;
            outputStream = null;
        } catch (Throwable th5) {
            th = th5;
            dataInputStream = null;
            outputStream = null;
        }
        C10738b.closeQuietly(dataInputStream);
        C10738b.closeQuietly(outputStream);
    }

    /* renamed from: e */
    private static byte[] m25017e(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("--");
        sb.append(str3);
        sb.append("\r\n");
        sb.append("Content-Disposition: form-data; name=\"" + str + "\"");
        sb.append("\r\n");
        sb.append("Content-Length: " + str2.length());
        sb.append("\r\n");
        sb.append("\r\n");
        sb.append(str2);
        sb.append("\r\n");
        return sb.toString().getBytes();
    }

    /* renamed from: a */
    private static Map<String, String> m25020a(C10736f c10736f) {
        HashMap hashMap = new HashMap();
        if (c10736f == null) {
            return hashMap;
        }
        if (!TextUtils.isEmpty(c10736f.aHL)) {
            hashMap.put("uploadToken", c10736f.aHL);
        }
        if (!TextUtils.isEmpty(c10736f.aHI)) {
            hashMap.put(NotificationCompat.CATEGORY_SYSTEM, c10736f.aHI);
        }
        if (!TextUtils.isEmpty(c10736f.aHH)) {
            hashMap.put("did", c10736f.aHH);
        }
        if (!TextUtils.isEmpty(c10736f.aHF)) {
            hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_SID, c10736f.aHF);
        }
        if (!TextUtils.isEmpty(c10736f.aGe)) {
            hashMap.put("appver", c10736f.aGe);
        }
        if (!TextUtils.isEmpty(c10736f.mTaskId)) {
            hashMap.put("taskId", c10736f.mTaskId);
        }
        if (!TextUtils.isEmpty(c10736f.aHG)) {
            hashMap.put(BidResponsed.KEY_TOKEN, c10736f.aHG);
        }
        if (!TextUtils.isEmpty(c10736f.aHE)) {
            hashMap.put("uid", c10736f.aHE);
        }
        if (!TextUtils.isEmpty(c10736f.aHJ)) {
            hashMap.put(MediationConstant.KEY_EXTRA_INFO, c10736f.aHJ);
        }
        return hashMap;
    }

    /* renamed from: a */
    public static void m25019a(File file, C10736f c10736f, InterfaceC10728a interfaceC10728a) {
        m25018a(file, c10736f.aHH, c10736f.aHG, m25020a(c10736f), interfaceC10728a);
    }
}
