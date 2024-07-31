package com.tencent.open.p565a;

import android.text.TextUtils;
import com.tencent.open.log.SLog;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import kotlin.text.Typography;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProGuard */
/* renamed from: com.tencent.open.a.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12998b implements InterfaceC12997a {

    /* renamed from: a */
    private int f37261a = 15000;

    /* renamed from: b */
    private int f37262b = 30000;

    /* renamed from: c */
    private final String f37263c;

    public C12998b(String str) {
        this.f37263c = str;
    }

    /* renamed from: b */
    private static void m15223b(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return;
        }
        try {
            httpURLConnection.disconnect();
        } catch (Exception unused) {
        }
    }

    @Override // com.tencent.open.p565a.InterfaceC12997a
    /* renamed from: a */
    public void mo15222a(long j, long j2) {
        if (j <= 0 || j2 <= 0) {
            return;
        }
        this.f37261a = (int) j;
        this.f37262b = (int) j2;
    }

    @Override // com.tencent.open.p565a.InterfaceC12997a
    /* renamed from: a */
    public InterfaceC13004g mo15220a(String str, String str2) throws IOException {
        SLog.m15127i("DefaultHttpServiceImpl", "get. ");
        if (!TextUtils.isEmpty(str2)) {
            int indexOf = str2.indexOf("?");
            if (indexOf == -1) {
                str = str + "?";
            } else if (indexOf != str.length() - 1) {
                str = str + "&";
            }
            str = str + str2;
        }
        return m15227a(str, str2.length());
    }

    @Override // com.tencent.open.p565a.InterfaceC12997a
    /* renamed from: a */
    public InterfaceC13004g mo15219a(String str, Map<String, String> map) throws IOException {
        SLog.m15127i("DefaultHttpServiceImpl", "post. ");
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (z) {
                z = false;
            } else {
                sb.append(Typography.f41567c);
            }
            sb.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            sb.append('=');
            sb.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        }
        String sb2 = sb.toString();
        return m15226a(str, sb2.length(), sb2);
    }

    @Override // com.tencent.open.p565a.InterfaceC12997a
    /* renamed from: a */
    public InterfaceC13004g mo15218a(String str, Map<String, String> map, Map<String, byte[]> map2) throws IOException {
        if (map2 != null && map2.size() > 0) {
            Iterator<Map.Entry<String, byte[]>> it = map2.entrySet().iterator();
            if (it.hasNext()) {
                Map.Entry<String, byte[]> next = it.next();
                return m15225a(str, map, next.getKey(), next.getValue());
            }
            return null;
        }
        return mo15219a(str, map);
    }

    /* renamed from: a */
    private void m15224a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection == null) {
            return;
        }
        httpURLConnection.setRequestProperty("User-Agent", this.f37263c);
        httpURLConnection.setConnectTimeout(this.f37261a);
        httpURLConnection.setReadTimeout(this.f37262b);
        httpURLConnection.setRequestProperty("Accept-Language", "zh-CN");
        httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
        httpURLConnection.setRequestProperty("Charset", "UTF-8");
    }

    /* renamed from: a */
    private InterfaceC13004g m15227a(String str, int i) throws IOException {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setRequestMethod("GET");
                m15224a(httpURLConnection);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(false);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.connect();
                if (httpURLConnection.getResponseCode() == 200) {
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read != -1) {
                                byteArrayOutputStream.write(bArr, 0, read);
                            } else {
                                C12999c c12999c = new C12999c(httpURLConnection, byteArrayOutputStream.toString(), httpURLConnection.getContentLength(), i, httpURLConnection.getResponseCode(), "");
                                m15228a(byteArrayOutputStream);
                                m15228a(inputStream);
                                m15223b(httpURLConnection);
                                return c12999c;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        m15228a(byteArrayOutputStream2);
                        m15228a(inputStream);
                        m15223b(httpURLConnection);
                        throw th;
                    }
                } else {
                    String responseMessage = httpURLConnection.getResponseMessage();
                    if (responseMessage == null) {
                        responseMessage = "请求失败 code:" + httpURLConnection.getResponseCode();
                    }
                    C12999c c12999c2 = new C12999c(httpURLConnection, "", httpURLConnection.getContentLength(), i, httpURLConnection.getResponseCode(), responseMessage);
                    m15228a((Closeable) null);
                    m15228a((Closeable) null);
                    m15223b(httpURLConnection);
                    return c12999c2;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = null;
            inputStream = null;
        }
    }

    /* renamed from: a */
    private InterfaceC13004g m15226a(String str, int i, String str2) throws IOException {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setRequestMethod("POST");
                m15224a(httpURLConnection);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestProperty("Content-Type", HttpHeaders.Values.APPLICATION_X_WWW_FORM_URLENCODED);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8");
                outputStreamWriter.write(str2);
                outputStreamWriter.flush();
                httpURLConnection.connect();
                int contentLength = httpURLConnection.getContentLength();
                if (httpURLConnection.getResponseCode() == 200) {
                    inputStream = httpURLConnection.getInputStream();
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream.read(bArr);
                            if (read != -1) {
                                byteArrayOutputStream.write(bArr, 0, read);
                            } else {
                                C12999c c12999c = new C12999c(httpURLConnection, byteArrayOutputStream.toString(), contentLength, i, httpURLConnection.getResponseCode(), "");
                                m15228a(byteArrayOutputStream);
                                m15228a(inputStream);
                                m15223b(httpURLConnection);
                                return c12999c;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                        m15228a(byteArrayOutputStream2);
                        m15228a(inputStream);
                        m15223b(httpURLConnection);
                        throw th;
                    }
                } else {
                    String responseMessage = httpURLConnection.getResponseMessage();
                    if (responseMessage == null) {
                        responseMessage = "Unknown fail: " + httpURLConnection.getResponseCode();
                    }
                    C12999c c12999c2 = new C12999c(httpURLConnection, "", 0, i, httpURLConnection.getResponseCode(), responseMessage);
                    m15228a((Closeable) null);
                    m15228a((Closeable) null);
                    m15223b(httpURLConnection);
                    return c12999c2;
                }
            } catch (Throwable th3) {
                th = th3;
                inputStream = null;
            }
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = null;
            inputStream = null;
        }
    }

    /* renamed from: a */
    public InterfaceC13004g m15225a(String str, Map<String, String> map, String str2, byte[] bArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream;
        DataOutputStream dataOutputStream;
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        int i;
        String str3;
        InputStream inputStream2;
        ByteArrayOutputStream byteArrayOutputStream2;
        DataOutputStream dataOutputStream2;
        Map<String, String> map2 = map;
        SLog.m15127i("DefaultHttpServiceImpl", "文件上传");
        String uuid = UUID.randomUUID().toString();
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setDoInput(true);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setInstanceFollowRedirects(false);
                httpURLConnection.setRequestProperty("Content-Type", HttpHeaders.Values.MULTIPART_FORM_DATA + ";boundary=" + uuid);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
            dataOutputStream = null;
            httpURLConnection = null;
        }
        try {
            m15224a(httpURLConnection);
            httpURLConnection.connect();
            DataOutputStream dataOutputStream3 = new DataOutputStream(httpURLConnection.getOutputStream());
            if (map2 != null) {
                try {
                    if (map.size() > 0) {
                        for (String str4 : map.keySet()) {
                            StringBuffer stringBuffer = new StringBuffer();
                            String encode = URLEncoder.encode(str4, "UTF-8");
                            String encode2 = URLEncoder.encode(map2.get(encode), "UTF-8");
                            stringBuffer.append("--");
                            stringBuffer.append(uuid);
                            stringBuffer.append("\r\n");
                            stringBuffer.append("Content-Disposition: form-data; name=\"");
                            stringBuffer.append(encode);
                            stringBuffer.append("\"");
                            stringBuffer.append("\r\n");
                            stringBuffer.append("\r\n");
                            stringBuffer.append(encode2);
                            stringBuffer.append("\r\n");
                            String stringBuffer2 = stringBuffer.toString();
                            SLog.m15127i("DefaultHttpServiceImpl", encode + "=" + stringBuffer2 + "##");
                            dataOutputStream3.write(stringBuffer2.getBytes());
                            map2 = map;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    dataOutputStream = dataOutputStream3;
                    byteArrayOutputStream = null;
                    inputStream = null;
                    m15228a(dataOutputStream);
                    m15228a(inputStream);
                    m15228a(byteArrayOutputStream);
                    m15223b(httpURLConnection);
                    throw th;
                }
            }
            if (bArr == null || bArr.length <= 0) {
                i = 0;
            } else {
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("--");
                stringBuffer3.append(uuid);
                stringBuffer3.append("\r\n");
                stringBuffer3.append("Content-Disposition: form-data; name=\"" + str2 + "\"; filename=\"" + str2 + "\"\r\n");
                StringBuilder sb = new StringBuilder();
                sb.append("Content-Type: application/octet-stream; charset=UTF-8");
                sb.append("\r\n");
                stringBuffer3.append(sb.toString());
                stringBuffer3.append("\r\n");
                dataOutputStream3.write(stringBuffer3.toString().getBytes());
                dataOutputStream3.write(bArr, 0, bArr.length);
                dataOutputStream3.write("\r\n".getBytes());
                byte[] bytes = ("--" + uuid + "--\r\n").getBytes();
                dataOutputStream3.write(bytes);
                int length = bytes.length + 0;
                dataOutputStream3.flush();
                i = length;
            }
            try {
                int responseCode = httpURLConnection.getResponseCode();
                SLog.m15127i("DefaultHttpServiceImpl", responseCode + "");
                if (responseCode == 200) {
                    InputStream inputStream3 = httpURLConnection.getInputStream();
                    try {
                        byteArrayOutputStream = new ByteArrayOutputStream();
                    } catch (Throwable th4) {
                        th = th4;
                        inputStream = inputStream3;
                        dataOutputStream = dataOutputStream3;
                        byteArrayOutputStream = null;
                    }
                    try {
                        byte[] bArr2 = new byte[1024];
                        while (true) {
                            int read = inputStream3.read(bArr2);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr2, 0, read);
                        }
                        str3 = byteArrayOutputStream.toString();
                        inputStream2 = inputStream3;
                        byteArrayOutputStream2 = byteArrayOutputStream;
                    } catch (Throwable th5) {
                        th = th5;
                        inputStream = inputStream3;
                        dataOutputStream = dataOutputStream3;
                        m15228a(dataOutputStream);
                        m15228a(inputStream);
                        m15228a(byteArrayOutputStream);
                        m15223b(httpURLConnection);
                        throw th;
                    }
                } else {
                    str3 = httpURLConnection.getResponseCode() + "";
                    inputStream2 = null;
                    byteArrayOutputStream2 = null;
                }
                try {
                    dataOutputStream2 = dataOutputStream3;
                } catch (Throwable th6) {
                    th = th6;
                    dataOutputStream2 = dataOutputStream3;
                }
            } catch (Throwable th7) {
                th = th7;
                dataOutputStream = dataOutputStream3;
                byteArrayOutputStream = null;
                inputStream = null;
                m15228a(dataOutputStream);
                m15228a(inputStream);
                m15228a(byteArrayOutputStream);
                m15223b(httpURLConnection);
                throw th;
            }
        } catch (Throwable th8) {
            th = th8;
            byteArrayOutputStream = null;
            dataOutputStream = null;
            inputStream = null;
            m15228a(dataOutputStream);
            m15228a(inputStream);
            m15228a(byteArrayOutputStream);
            m15223b(httpURLConnection);
            throw th;
        }
        try {
            C12999c c12999c = new C12999c(httpURLConnection, str3, httpURLConnection.getContentLength(), i, httpURLConnection.getResponseCode(), "");
            m15228a(dataOutputStream2);
            m15228a(inputStream2);
            m15228a(byteArrayOutputStream2);
            m15223b(httpURLConnection);
            return c12999c;
        } catch (Throwable th9) {
            th = th9;
            InputStream inputStream4 = inputStream2;
            dataOutputStream = dataOutputStream2;
            byteArrayOutputStream = byteArrayOutputStream2;
            inputStream = inputStream4;
            m15228a(dataOutputStream);
            m15228a(inputStream);
            m15228a(byteArrayOutputStream);
            m15223b(httpURLConnection);
            throw th;
        }
    }

    /* renamed from: a */
    private static void m15228a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }
}
