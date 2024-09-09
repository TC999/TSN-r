package com.bytedance.c.w.c;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.c.w.b;
import com.bytedance.c.w.xv;
import com.bytedance.sdk.openadsdk.api.plugin.w;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f {

    /* renamed from: g  reason: collision with root package name */
    static volatile boolean f26509g = true;

    /* renamed from: a  reason: collision with root package name */
    private a f26510a;

    /* renamed from: b  reason: collision with root package name */
    private c f26511b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f26512c;

    /* renamed from: d  reason: collision with root package name */
    private volatile long f26513d;

    /* renamed from: e  reason: collision with root package name */
    private volatile boolean f26514e = false;

    /* renamed from: f  reason: collision with root package name */
    private final SharedPreferences f26515f;

    public f(Context context) {
        if (context != null && (context instanceof Application)) {
            this.f26512c = context;
            SharedPreferences w3 = w.w(context, "anr_monitor_table", 0);
            this.f26515f = w3;
            this.f26513d = w3.getLong("trace_anr_happen_time", 0L);
            return;
        }
        throw new IllegalArgumentException("context must not be null or not application");
    }

    private String a(BufferedReader bufferedReader) throws IOException {
        if (bufferedReader == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null || readLine.trim().length() <= 0) {
                break;
            }
            sb.append(readLine);
            sb.append("\n");
        }
        return sb.toString();
    }

    private static void d(String str) {
        for (com.bytedance.c.w.c cVar : com.bytedance.c.w.d.k().g()) {
            cVar.a(xv.ANR, str, null);
        }
    }

    private Object[] f(BufferedReader bufferedReader, Pattern... patternArr) throws IOException {
        if (bufferedReader != null && patternArr != null && patternArr.length > 0) {
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    int length = patternArr.length;
                    int i4 = 0;
                    while (true) {
                        if (i4 < length) {
                            Pattern pattern = patternArr[i4];
                            if (pattern.matcher(readLine).matches()) {
                                return new Object[]{pattern, readLine};
                            }
                            i4++;
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [boolean] */
    public JSONObject b(String str, int i4, String str2) {
        BufferedReader bufferedReader;
        int i5;
        Closeable closeable = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            ?? canRead = file.canRead();
            try {
                if (canRead != 0) {
                    try {
                        bufferedReader = new BufferedReader(new FileReader(file));
                    } catch (Exception e4) {
                        e = e4;
                        bufferedReader = null;
                    } catch (Throwable th) {
                        th = th;
                        b.g.a(closeable);
                        throw th;
                    }
                    try {
                        Pattern compile = Pattern.compile("-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}");
                        Pattern compile2 = Pattern.compile("-{5}\\send\\s\\d+\\s-{5}");
                        Pattern compile3 = Pattern.compile("Cmd\\sline:\\s(\\S+)");
                        Pattern compile4 = Pattern.compile("\".+\"\\s(daemon\\s){0,1}prio=\\d+\\stid=\\d+\\s.*");
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
                        boolean z3 = false;
                        Object[] f4 = f(bufferedReader, compile);
                        if (f4 == null) {
                            b.g.a(bufferedReader);
                            return null;
                        }
                        long parseLong = Long.parseLong(f4[1].toString().split("\\s")[2]);
                        long time = simpleDateFormat.parse(f4[1].toString().split("\\s")[4] + " " + f4[1].toString().split("\\s")[5]).getTime();
                        Object[] f5 = f(bufferedReader, compile3);
                        if (f5 == null) {
                            b.g.a(bufferedReader);
                            return null;
                        }
                        String str3 = f5[1].toString().split("\\s")[2];
                        if (parseLong == i4 && str3.equalsIgnoreCase(str2)) {
                            if (this.f26513d != 0 && Math.abs(this.f26513d - time) < 20000) {
                                b.g.a(bufferedReader);
                                return null;
                            }
                            this.f26513d = time;
                            SharedPreferences sharedPreferences = this.f26515f;
                            if (sharedPreferences != null) {
                                sharedPreferences.edit().putLong("trace_anr_happen_time", this.f26513d).apply();
                            }
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("anrTime", time);
                            while (true) {
                                Object[] f6 = f(bufferedReader, compile2, compile4);
                                if (f6 == null || f6[0] != compile4) {
                                    break;
                                }
                                Matcher matcher = Pattern.compile("\".+\"").matcher(f6[1].toString());
                                String substring = matcher.find() ? matcher.group().substring(1, matcher.group().length() - 1) : "";
                                Matcher matcher2 = Pattern.compile("tid=\\d+").matcher(f6[1].toString());
                                if (matcher2.find()) {
                                    String group = matcher2.group();
                                    i5 = Integer.parseInt(group.substring(group.indexOf("=") + 1));
                                } else {
                                    i5 = -1;
                                }
                                String a4 = a(bufferedReader);
                                if (i5 != -1 && !TextUtils.isEmpty(substring) && !TextUtils.isEmpty(a4) && substring.equalsIgnoreCase("main")) {
                                    jSONObject.put("mainStackFromTrace", a4);
                                    z3 = true;
                                    break;
                                }
                            }
                            if (!z3) {
                                b.g.a(bufferedReader);
                                return null;
                            }
                            jSONObject.put("thread_number", 1);
                            b.g.a(bufferedReader);
                            return jSONObject;
                        }
                        b.g.a(bufferedReader);
                        return null;
                    } catch (Exception e5) {
                        e = e5;
                        e.printStackTrace();
                        b.g.a(bufferedReader);
                        return null;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                closeable = canRead;
            }
        }
        return null;
    }

    public void c() {
        if (this.f26514e) {
            return;
        }
        if (Build.VERSION.SDK_INT < 21) {
            a aVar = new a(this, "/data/anr/", 8);
            this.f26510a = aVar;
            aVar.startWatching();
        } else {
            this.f26511b = new c(this);
        }
        this.f26514e = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e(int i4, String str, int i5) {
        JSONObject jSONObject;
        JSONObject b4;
        try {
            jSONObject = d.b(f26509g);
        } catch (Throwable th) {
            th.printStackTrace();
            jSONObject = null;
        }
        String a4 = d.a(this.f26512c, i5);
        if (TextUtils.isEmpty(a4)) {
            return false;
        }
        try {
            com.bytedance.c.w.e e4 = com.bytedance.c.w.d.k().e();
            if (e4 != null) {
                if (e4.c()) {
                    if (i4 == 200 && (b4 = b(str, Process.myPid(), this.f26512c.getPackageName())) != null && b4.length() > 0) {
                        jSONObject = b4;
                    }
                    if (jSONObject != null && jSONObject.length() > 0) {
                        try {
                            jSONObject.put("pid", Process.myPid());
                            jSONObject.put("package", this.f26512c.getPackageName());
                            jSONObject.put("is_remote_process", 0);
                            com.bytedance.c.w.xv.a aVar = new com.bytedance.c.w.xv.a(new JSONObject());
                            aVar.k("data", jSONObject.toString());
                            aVar.k("is_anr", 1);
                            aVar.k(CampaignEx.JSON_KEY_TIMESTAMP, Long.valueOf(System.currentTimeMillis()));
                            aVar.k("event_type", "anr");
                            aVar.k("anr_time", Long.valueOf(System.currentTimeMillis()));
                            aVar.k("crash_time", Long.valueOf(System.currentTimeMillis()));
                            aVar.k("anr_info", a4);
                            com.bytedance.c.w.ux.c.e a5 = com.bytedance.c.w.ux.c.e.a();
                            xv xvVar = xv.ANR;
                            com.bytedance.c.w.xv.a c4 = a5.c(xvVar, aVar);
                            b.m.d(this.f26512c, xvVar.c(), null);
                            com.bytedance.c.w.r.a.a().c(c4.j());
                            d(a4);
                        } catch (Throwable th2) {
                            b.k.c(th2);
                        }
                    }
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }
}
