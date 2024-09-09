package com.tencent.open.utils;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import com.stub.StubApp;
import com.tencent.open.log.SLog;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private static Map<String, i> f51829a = Collections.synchronizedMap(new HashMap());

    /* renamed from: b  reason: collision with root package name */
    private static String f51830b = null;

    /* renamed from: c  reason: collision with root package name */
    private Context f51831c;

    /* renamed from: d  reason: collision with root package name */
    private String f51832d;

    /* renamed from: e  reason: collision with root package name */
    private JSONObject f51833e = null;

    /* renamed from: f  reason: collision with root package name */
    private long f51834f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f51835g = 0;

    /* renamed from: h  reason: collision with root package name */
    private boolean f51836h = true;

    private i(Context context, String str) {
        this.f51831c = null;
        this.f51832d = null;
        this.f51831c = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f51832d = str;
        a();
        b();
    }

    private void b() {
        if (this.f51835g != 0) {
            d("update thread is running, return");
            return;
        }
        this.f51835g = 1;
        final HashMap hashMap = new HashMap();
        hashMap.put("appid", this.f51832d);
        hashMap.put("status_os", Build.VERSION.RELEASE);
        hashMap.put("status_machine", f.a().c(g.a()));
        hashMap.put("status_version", Build.VERSION.SDK);
        hashMap.put("sdkv", "3.5.13.lite");
        hashMap.put("sdkp", "a");
        l.a(new Runnable() { // from class: com.tencent.open.utils.i.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.tencent.open.a.g a4 = com.tencent.open.a.f.a().a("https://cgi.connect.qq.com/qqconnectopen/openapi/policy_conf", hashMap);
                    String a5 = a4.a();
                    SLog.i("openSDK_LOG.OpenConfig", "update: get config statusCode " + a4.d());
                    i.this.a(m.d(a5));
                } catch (Exception e4) {
                    SLog.e("openSDK_LOG.OpenConfig", "get config error ", e4);
                }
                i.this.f51835g = 0;
            }
        });
    }

    private String c(String str) {
        InputStream open;
        String str2;
        String str3 = "";
        try {
            try {
                if (this.f51832d != null) {
                    str2 = str + "." + this.f51832d;
                } else {
                    str2 = str;
                }
                open = this.f51831c.openFileInput(str2);
            } catch (FileNotFoundException unused) {
                open = this.f51831c.getAssets().open(str);
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open, Charset.forName("UTF-8")));
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                try {
                    try {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(readLine);
                        } catch (Throwable th) {
                            try {
                                open.close();
                                bufferedReader.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                            throw th;
                        }
                    } catch (IOException e5) {
                        e5.printStackTrace();
                        open.close();
                        bufferedReader.close();
                    }
                } catch (IOException e6) {
                    e6.printStackTrace();
                }
            }
            str3 = stringBuffer.toString();
            open.close();
            bufferedReader.close();
            return str3;
        } catch (IOException e7) {
            e7.printStackTrace();
            return "";
        }
    }

    private void d(String str) {
        if (this.f51836h) {
            SLog.v("openSDK_LOG.OpenConfig", str + "; appid: " + this.f51832d);
        }
    }

    public static i a(Context context, String str) {
        i iVar;
        synchronized (f51829a) {
            SLog.v("openSDK_LOG.OpenConfig", "getInstance begin");
            if (str != null) {
                f51830b = str;
            }
            if (str == null && (str = f51830b) == null) {
                str = "0";
            }
            iVar = f51829a.get(str);
            if (iVar == null) {
                iVar = new i(context, str);
                f51829a.put(str, iVar);
            }
            SLog.v("openSDK_LOG.OpenConfig", "getInstance end");
        }
        return iVar;
    }

    public boolean b(String str) {
        d("get " + str);
        c();
        Object opt = this.f51833e.opt(str);
        if (opt == null) {
            return false;
        }
        if (opt instanceof Integer) {
            return !opt.equals(0);
        }
        if (opt instanceof Boolean) {
            return ((Boolean) opt).booleanValue();
        }
        return false;
    }

    private void a() {
        try {
            this.f51833e = new JSONObject(c("com.tencent.open.config.json"));
        } catch (JSONException unused) {
            this.f51833e = new JSONObject();
        }
    }

    private void a(String str, String str2) {
        try {
            if (this.f51832d != null) {
                str = str + "." + this.f51832d;
            }
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.f51831c.openFileOutput(str, 0), Charset.forName("UTF-8"));
            outputStreamWriter.write(str2);
            outputStreamWriter.flush();
            outputStreamWriter.close();
        } catch (IOException e4) {
            e4.printStackTrace();
        }
    }

    private void c() {
        int optInt = this.f51833e.optInt("Common_frequency");
        if (optInt == 0) {
            optInt = 1;
        }
        if (SystemClock.elapsedRealtime() - this.f51834f >= optInt * 3600000) {
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        d("cgi back, do update");
        this.f51833e = jSONObject;
        a("com.tencent.open.config.json", jSONObject.toString());
        this.f51834f = SystemClock.elapsedRealtime();
    }

    public int a(String str) {
        d("get " + str);
        c();
        return this.f51833e.optInt(str);
    }
}
