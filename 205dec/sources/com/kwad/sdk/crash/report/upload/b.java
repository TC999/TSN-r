package com.kwad.sdk.crash.report.upload;

import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import cn.jpush.android.local.JPushConstants;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.crash.utils.h;
import com.kwad.sdk.utils.q;
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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b {
    private static void a(@NonNull File file, @NonNull String str, String str2, @NonNull Map<String, String> map, @NonNull a aVar) {
        DataInputStream dataInputStream;
        OutputStream outputStream;
        com.kwad.sdk.core.e.c.d("AdExceptionCollector", "uploadLogFile " + Thread.currentThread());
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        String uuid = UUID.randomUUID().toString();
        String name = file.getName();
        String str3 = JPushConstants.HTTPS_PRE + com.kwad.sdk.core.network.idc.a.DU().W("ulog", "ulog-sdk.gifshow.com") + "/rest/log/sdk/file/upload";
        int i4 = -1;
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
                httpURLConnection2.setRequestProperty("User-Agent", p.getUserAgent());
                httpURLConnection2.setRequestProperty("Charset", "UTF-8");
                httpURLConnection2.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + uuid);
                httpURLConnection2.setRequestProperty("Content-MD5", Base64.encodeToString(com.kwad.sdk.utils.a.gp(file.getPath()), 2));
                httpURLConnection2.setRequestProperty("file-type", "." + q.getExtension(file.getName()));
                httpURLConnection2.setRequestProperty("origin-name", name);
                httpURLConnection2.setRequestProperty("Cookie", "did=" + str);
                httpURLConnection2.connect();
                outputStream = httpURLConnection2.getOutputStream();
                try {
                    for (String str4 : map.keySet()) {
                        outputStream.write(e(str4, map.get(str4), uuid));
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
                        cVar.code = responseCode;
                        cVar.avq = responseCode;
                        if (responseCode == 200) {
                            cVar.avs = h.a(httpURLConnection2.getInputStream());
                            try {
                                if (new JSONObject(cVar.avs).optInt("result", -1) == 1) {
                                    aVar.Ic();
                                } else {
                                    e eVar = e.aHA;
                                    aVar.Ib();
                                }
                            } catch (JSONException unused) {
                                e eVar2 = e.aHB;
                                aVar.Ib();
                            }
                            com.kwad.sdk.core.e.c.d("AdExceptionCollector", "response.body= " + cVar.avs);
                        } else {
                            e eVar3 = e.aHz;
                            e.aHz.wn();
                            aVar.Ib();
                            com.kwad.sdk.core.network.idc.a DU = com.kwad.sdk.core.network.idc.a.DU();
                            int i5 = cVar.code;
                            if (i5 == 0) {
                                i5 = -1;
                            }
                            DU.a(str3, i5, (Throwable) null);
                        }
                        com.kwad.sdk.crash.utils.b.a(httpURLConnection2);
                    } catch (Exception e4) {
                        e = e4;
                        httpURLConnection = httpURLConnection2;
                        try {
                            e eVar4 = e.aHz;
                            e.getCause();
                            aVar.Ib();
                            com.kwad.sdk.core.network.idc.a DU2 = com.kwad.sdk.core.network.idc.a.DU();
                            int i6 = cVar.code;
                            if (i6 != 0) {
                                i4 = i6;
                            }
                            DU2.a(str3, i4, e);
                            com.kwad.sdk.core.e.c.printStackTrace(e);
                            com.kwad.sdk.crash.utils.b.a(httpURLConnection);
                            com.kwad.sdk.crash.utils.b.closeQuietly(dataInputStream);
                            com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                        } catch (Throwable th) {
                            th = th;
                            com.kwad.sdk.crash.utils.b.a(httpURLConnection);
                            com.kwad.sdk.crash.utils.b.closeQuietly(dataInputStream);
                            com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        httpURLConnection = httpURLConnection2;
                        com.kwad.sdk.crash.utils.b.a(httpURLConnection);
                        com.kwad.sdk.crash.utils.b.closeQuietly(dataInputStream);
                        com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                        throw th;
                    }
                } catch (Exception e5) {
                    e = e5;
                    dataInputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    dataInputStream = null;
                }
            } catch (Exception e6) {
                e = e6;
                dataInputStream = null;
                outputStream = null;
            } catch (Throwable th4) {
                th = th4;
                dataInputStream = null;
                outputStream = null;
            }
        } catch (Exception e7) {
            e = e7;
            dataInputStream = null;
            outputStream = null;
        } catch (Throwable th5) {
            th = th5;
            dataInputStream = null;
            outputStream = null;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(dataInputStream);
        com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
    }

    private static byte[] e(String str, String str2, String str3) {
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

    private static Map<String, String> a(f fVar) {
        HashMap hashMap = new HashMap();
        if (fVar == null) {
            return hashMap;
        }
        if (!TextUtils.isEmpty(fVar.aHL)) {
            hashMap.put("uploadToken", fVar.aHL);
        }
        if (!TextUtils.isEmpty(fVar.aHI)) {
            hashMap.put("sys", fVar.aHI);
        }
        if (!TextUtils.isEmpty(fVar.aHH)) {
            hashMap.put("did", fVar.aHH);
        }
        if (!TextUtils.isEmpty(fVar.aHF)) {
            hashMap.put("sid", fVar.aHF);
        }
        if (!TextUtils.isEmpty(fVar.aGe)) {
            hashMap.put("appver", fVar.aGe);
        }
        if (!TextUtils.isEmpty(fVar.mTaskId)) {
            hashMap.put("taskId", fVar.mTaskId);
        }
        if (!TextUtils.isEmpty(fVar.aHG)) {
            hashMap.put("token", fVar.aHG);
        }
        if (!TextUtils.isEmpty(fVar.aHE)) {
            hashMap.put("uid", fVar.aHE);
        }
        if (!TextUtils.isEmpty(fVar.aHJ)) {
            hashMap.put("extraInfo", fVar.aHJ);
        }
        return hashMap;
    }

    public static void a(File file, f fVar, a aVar) {
        a(file, fVar.aHH, fVar.aHG, a(fVar), aVar);
    }
}
