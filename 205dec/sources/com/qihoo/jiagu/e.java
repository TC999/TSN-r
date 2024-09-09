package com.qihoo.jiagu;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import android.util.Base64;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.qihoo.bugreport.CrashReport;
import com.qihoo.bugreport.javacrash.ExceptionHandleReporter;
import com.qihoo.bugreport.javacrash.ReportField;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.json.JSONObject;
import xyz.adscope.common.network.Headers;

/* loaded from: E:\TSN-r\205dec\93344.dex */
public final class e extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ boolean f41428a;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ JSONObject f41429b;

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ ExceptionHandleReporter f41430c;

    public e(ExceptionHandleReporter exceptionHandleReporter, boolean z3, JSONObject jSONObject) {
        this.f41430c = exceptionHandleReporter;
        this.f41428a = z3;
        this.f41429b = jSONObject;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Context context;
        boolean z3;
        boolean z4;
        String str;
        File file;
        Throwable th;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2;
        HttpResponse execute;
        Context context2;
        try {
            context = this.f41430c.f41411c;
            if (c.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
                z3 = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(1).isConnected();
            } else {
                z3 = false;
            }
            if (this.f41428a) {
                z4 = false;
            } else {
                context2 = this.f41430c.f41411c;
                z4 = c.c(context2, "opentestCrashCollect");
            }
            if (z3 || z4) {
                new d();
                JSONObject jSONObject = this.f41429b;
                if (jSONObject == null) {
                    return;
                }
                String jSONObject2 = jSONObject.toString();
                if (jSONObject2.length() == 0 || Build.VERSION.SDK_INT < 8) {
                    return;
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                gZIPOutputStream.write(jSONObject2.getBytes());
                gZIPOutputStream.flush();
                gZIPOutputStream.close();
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                byte[] bArr = new byte[16];
                new Random().nextBytes(bArr);
                Cipher cipher = Cipher.getInstance("RC4");
                cipher.init(1, new SecretKeySpec(bArr, "RC4"));
                byte[] update = cipher.update(byteArray);
                byte[] bArr2 = new byte[update.length + 16 + 4];
                System.arraycopy(new byte[]{(byte) 16, (byte) 0, (byte) 0, (byte) 0}, 0, bArr2, 0, 4);
                System.arraycopy(bArr, 0, bArr2, 4, 16);
                System.arraycopy(update, 0, bArr2, 20, update.length);
                String encodeToString = Base64.encodeToString(bArr2, 0);
                String encode = URLEncoder.encode(encodeToString, "UTF-8");
                String a4 = c.a(encode.getBytes());
                if (a4 == null) {
                    str = null;
                } else {
                    byte[] bytes = a4.getBytes();
                    byte[] bArr3 = new byte[16];
                    byte[] bArr4 = new byte[48];
                    new Random().nextBytes(bArr3);
                    byte[] bytes2 = c.a(bArr3).getBytes();
                    System.arraycopy(bytes, 16, bArr4, 0, 16);
                    System.arraycopy(bytes2, 0, bArr4, 16, 16);
                    System.arraycopy(bytes, 0, bArr4, 32, 16);
                    str = new String(bArr4);
                }
                if (z3) {
                    new c();
                    HttpPost httpPost = new HttpPost(b.a());
                    httpPost.addHeader("User-Agent", "Android");
                    httpPost.addHeader("Accept", Headers.VALUE_ACCEPT_ALL);
                    httpPost.addHeader("cpv", "3");
                    BasicHttpParams basicHttpParams = new BasicHttpParams();
                    HttpConnectionParams.setConnectionTimeout(basicHttpParams, b.b());
                    HttpConnectionParams.setSoTimeout(basicHttpParams, b.c());
                    DefaultHttpClient defaultHttpClient = new DefaultHttpClient(basicHttpParams);
                    ArrayList arrayList = new ArrayList(2);
                    arrayList.add(new BasicNameValuePair("c", encodeToString));
                    arrayList.add(new BasicNameValuePair("x", str));
                    boolean c4 = c.c(CrashReport.a(), "jg_qihoo_test_file");
                    if (c4) {
                        f.a("CRASH_REPORT", "crash_data:" + encodeToString);
                    }
                    try {
                        httpPost.setEntity(new UrlEncodedFormEntity(arrayList));
                    } catch (UnsupportedEncodingException e4) {
                    }
                    try {
                        defaultHttpClient.execute(httpPost).getStatusLine().getStatusCode();
                        if (c4) {
                            f.a("CRASH_REPORT", "response_code:" + execute.getStatusLine().getStatusCode());
                        }
                    } catch (IOException e5) {
                    }
                }
                if (!z4 || jSONObject == null || encode == null || str == null) {
                    return;
                }
                try {
                    if (!jSONObject.has(ReportField.ct.name())) {
                        return;
                    }
                    File file2 = new File(CrashReport.a().getFilesDir().getAbsolutePath() + "/crashCollect");
                    if (!file2.exists() && !file2.isDirectory()) {
                        file2.mkdirs();
                        d.a("chmod 777 " + file2.getAbsolutePath());
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("cpv=3").append("&c=").append(encode).append("&x=").append(str);
                    synchronized (d.class) {
                        try {
                            try {
                                fileOutputStream2 = new FileOutputStream(new File(file2 + TTPathConst.sSeparator + String.valueOf(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.ENGLISH).parse(jSONObject.getString(ReportField.ct.name())).getTime())));
                            } catch (Exception e6) {
                                fileOutputStream2 = null;
                            } catch (Throwable th2) {
                                th = th2;
                                fileOutputStream = null;
                            }
                            try {
                                fileOutputStream2.write(stringBuffer.toString().getBytes());
                                fileOutputStream2.flush();
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException e7) {
                                }
                                d.a("chmod 777 " + file.getAbsolutePath());
                            } catch (Exception e8) {
                                if (fileOutputStream2 != null) {
                                    try {
                                        fileOutputStream2.close();
                                    } catch (IOException e9) {
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                fileOutputStream = fileOutputStream2;
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e10) {
                                    }
                                }
                                throw th;
                            }
                        } catch (Exception e11) {
                        }
                    }
                } catch (Throwable th4) {
                }
            }
        } catch (Throwable th5) {
        }
    }
}
