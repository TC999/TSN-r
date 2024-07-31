package com.tencent.open.utils;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import com.stub.StubApp;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.open.p565a.C13003f;
import com.tencent.open.p565a.InterfaceC13004g;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
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

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.utils.i */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C13063i {

    /* renamed from: a */
    private static Map<String, C13063i> f37429a = Collections.synchronizedMap(new HashMap());

    /* renamed from: b */
    private static String f37430b = null;

    /* renamed from: c */
    private Context f37431c;

    /* renamed from: d */
    private String f37432d;

    /* renamed from: e */
    private JSONObject f37433e = null;

    /* renamed from: f */
    private long f37434f = 0;

    /* renamed from: g */
    private int f37435g = 0;

    /* renamed from: h */
    private boolean f37436h = true;

    private C13063i(Context context, String str) {
        this.f37431c = null;
        this.f37432d = null;
        this.f37431c = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f37432d = str;
        m15016a();
        m15009b();
    }

    /* renamed from: b */
    private void m15009b() {
        if (this.f37435g != 0) {
            m15005d("update thread is running, return");
            return;
        }
        this.f37435g = 1;
        final HashMap hashMap = new HashMap();
        hashMap.put("appid", this.f37432d);
        hashMap.put("status_os", Build.VERSION.RELEASE);
        hashMap.put("status_machine", C13058f.m15034a().m15029c(C13061g.m15027a()));
        hashMap.put("status_version", Build.VERSION.SDK);
        hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_VERSION, Constants.SDK_VERSION);
        hashMap.put("sdkp", "a");
        C13067l.m14976a(new Runnable() { // from class: com.tencent.open.utils.i.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    InterfaceC13004g m15212a = C13003f.m15216a().m15212a("https://cgi.connect.qq.com/qqconnectopen/openapi/policy_conf", hashMap);
                    String mo15207a = m15212a.mo15207a();
                    SLog.m15127i("openSDK_LOG.OpenConfig", "update: get config statusCode " + m15212a.mo15204d());
                    C13063i.this.m15010a(C13071m.m14933d(mo15207a));
                } catch (Exception e) {
                    SLog.m15128e("openSDK_LOG.OpenConfig", "get config error ", e);
                }
                C13063i.this.f37435g = 0;
            }
        });
    }

    /* renamed from: c */
    private String m15006c(String str) {
        InputStream open;
        String str2;
        String str3 = "";
        try {
            try {
                if (this.f37432d != null) {
                    str2 = str + "." + this.f37432d;
                } else {
                    str2 = str;
                }
                open = this.f37431c.openFileInput(str2);
            } catch (FileNotFoundException unused) {
                open = this.f37431c.getAssets().open(str);
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
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            throw th;
                        }
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        open.close();
                        bufferedReader.close();
                    }
                } catch (IOException e3) {
                    e3.printStackTrace();
                }
            }
            str3 = stringBuffer.toString();
            open.close();
            bufferedReader.close();
            return str3;
        } catch (IOException e4) {
            e4.printStackTrace();
            return "";
        }
    }

    /* renamed from: d */
    private void m15005d(String str) {
        if (this.f37436h) {
            SLog.m15123v("openSDK_LOG.OpenConfig", str + "; appid: " + this.f37432d);
        }
    }

    /* renamed from: a */
    public static C13063i m15015a(Context context, String str) {
        C13063i c13063i;
        synchronized (f37429a) {
            SLog.m15123v("openSDK_LOG.OpenConfig", "getInstance begin");
            if (str != null) {
                f37430b = str;
            }
            if (str == null && (str = f37430b) == null) {
                str = "0";
            }
            c13063i = f37429a.get(str);
            if (c13063i == null) {
                c13063i = new C13063i(context, str);
                f37429a.put(str, c13063i);
            }
            SLog.m15123v("openSDK_LOG.OpenConfig", "getInstance end");
        }
        return c13063i;
    }

    /* renamed from: b */
    public boolean m15008b(String str) {
        m15005d("get " + str);
        m15007c();
        Object opt = this.f37433e.opt(str);
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

    /* renamed from: a */
    private void m15016a() {
        try {
            this.f37433e = new JSONObject(m15006c("com.tencent.open.config.json"));
        } catch (JSONException unused) {
            this.f37433e = new JSONObject();
        }
    }

    /* renamed from: a */
    private void m15011a(String str, String str2) {
        try {
            if (this.f37432d != null) {
                str = str + "." + this.f37432d;
            }
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.f37431c.openFileOutput(str, 0), Charset.forName("UTF-8"));
            outputStreamWriter.write(str2);
            outputStreamWriter.flush();
            outputStreamWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    private void m15007c() {
        int optInt = this.f37433e.optInt("Common_frequency");
        if (optInt == 0) {
            optInt = 1;
        }
        if (SystemClock.elapsedRealtime() - this.f37434f >= optInt * 3600000) {
            m15009b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m15010a(JSONObject jSONObject) {
        m15005d("cgi back, do update");
        this.f37433e = jSONObject;
        m15011a("com.tencent.open.config.json", jSONObject.toString());
        this.f37434f = SystemClock.elapsedRealtime();
    }

    /* renamed from: a */
    public int m15012a(String str) {
        m15005d("get " + str);
        m15007c();
        return this.f37433e.optInt(str);
    }
}
