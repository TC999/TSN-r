package com.tencent.open.log;

import android.text.TextUtils;
import com.tencent.open.log.C13039d;
import com.tencent.open.utils.C13071m;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.log.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C13037b {

    /* renamed from: a */
    private static SimpleDateFormat f37368a = C13039d.C13043d.m15073a("yy.MM.dd.HH");

    /* renamed from: g */
    private File f37374g;

    /* renamed from: b */
    private String f37369b = "Tracer.File";

    /* renamed from: c */
    private int f37370c = Integer.MAX_VALUE;

    /* renamed from: d */
    private int f37371d = Integer.MAX_VALUE;

    /* renamed from: e */
    private int f37372e = 4096;

    /* renamed from: f */
    private long f37373f = 10000;

    /* renamed from: h */
    private int f37375h = 10;

    /* renamed from: i */
    private String f37376i = ".log";

    /* renamed from: j */
    private long f37377j = Long.MAX_VALUE;

    public C13037b(File file, int i, int i2, int i3, String str, long j, int i4, String str2, long j2) {
        m15099a(file);
        m15096b(i);
        m15101a(i2);
        m15092c(i3);
        m15098a(str);
        m15095b(j);
        m15088d(i4);
        m15094b(str2);
        m15091c(j2);
    }

    /* renamed from: c */
    private String m15090c(String str) {
        return "com.tencent.mobileqq_connectSdk." + str + ".log";
    }

    /* renamed from: d */
    private File m15087d(long j) {
        String m15090c = m15090c(m15100a(j));
        String m14946b = C13071m.m14946b();
        if (!TextUtils.isEmpty(m14946b) || m14946b != null) {
            try {
                File file = new File(m14946b, C13038c.f37392o);
                if (!file.exists()) {
                    file.mkdirs();
                }
                return new File(file, m15090c);
            } catch (Exception e) {
                SLog.m15128e(SLog.TAG, "getWorkFile,get app specific file exception:", e);
            }
        }
        return null;
    }

    /* renamed from: a */
    public File m15102a() {
        return m15087d(System.currentTimeMillis());
    }

    /* renamed from: b */
    public String m15097b() {
        return this.f37369b;
    }

    /* renamed from: a */
    public static String m15100a(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return new SimpleDateFormat("yy.MM.dd.HH").format(calendar.getTime());
    }

    /* renamed from: b */
    public void m15096b(int i) {
        this.f37371d = i;
    }

    /* renamed from: c */
    public int m15093c() {
        return this.f37372e;
    }

    /* renamed from: b */
    public void m15095b(long j) {
        this.f37373f = j;
    }

    /* renamed from: c */
    public void m15092c(int i) {
        this.f37372e = i;
    }

    /* renamed from: b */
    public void m15094b(String str) {
        this.f37376i = str;
    }

    /* renamed from: c */
    public void m15091c(long j) {
        this.f37377j = j;
    }

    /* renamed from: a */
    public void m15098a(String str) {
        this.f37369b = str;
    }

    /* renamed from: a */
    public void m15101a(int i) {
        this.f37370c = i;
    }

    /* renamed from: a */
    public void m15099a(File file) {
        this.f37374g = file;
    }

    /* renamed from: d */
    public int m15089d() {
        return this.f37375h;
    }

    /* renamed from: d */
    public void m15088d(int i) {
        this.f37375h = i;
    }
}
