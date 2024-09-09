package com.tencent.open.log;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.tencent.open.log.d;
import com.tencent.open.utils.m;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static SimpleDateFormat f51768a = d.C1045d.a("yy.MM.dd.HH");

    /* renamed from: g  reason: collision with root package name */
    private File f51774g;

    /* renamed from: b  reason: collision with root package name */
    private String f51769b = "Tracer.File";

    /* renamed from: c  reason: collision with root package name */
    private int f51770c = Integer.MAX_VALUE;

    /* renamed from: d  reason: collision with root package name */
    private int f51771d = Integer.MAX_VALUE;

    /* renamed from: e  reason: collision with root package name */
    private int f51772e = 4096;

    /* renamed from: f  reason: collision with root package name */
    private long f51773f = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;

    /* renamed from: h  reason: collision with root package name */
    private int f51775h = 10;

    /* renamed from: i  reason: collision with root package name */
    private String f51776i = ".log";

    /* renamed from: j  reason: collision with root package name */
    private long f51777j = Long.MAX_VALUE;

    public b(File file, int i4, int i5, int i6, String str, long j4, int i7, String str2, long j5) {
        a(file);
        b(i4);
        a(i5);
        c(i6);
        a(str);
        b(j4);
        d(i7);
        b(str2);
        c(j5);
    }

    private String c(String str) {
        return "com.tencent.mobileqq_connectSdk." + str + ".log";
    }

    private File d(long j4) {
        String c4 = c(a(j4));
        String b4 = m.b();
        if (!TextUtils.isEmpty(b4) || b4 != null) {
            try {
                File file = new File(b4, c.f51792o);
                if (!file.exists()) {
                    file.mkdirs();
                }
                return new File(file, c4);
            } catch (Exception e4) {
                SLog.e("openSDK_LOG", "getWorkFile,get app specific file exception:", e4);
            }
        }
        return null;
    }

    public File a() {
        return d(System.currentTimeMillis());
    }

    public String b() {
        return this.f51769b;
    }

    public static String a(long j4) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j4);
        return new SimpleDateFormat("yy.MM.dd.HH").format(calendar.getTime());
    }

    public void b(int i4) {
        this.f51771d = i4;
    }

    public int c() {
        return this.f51772e;
    }

    public void b(long j4) {
        this.f51773f = j4;
    }

    public void c(int i4) {
        this.f51772e = i4;
    }

    public void b(String str) {
        this.f51776i = str;
    }

    public void c(long j4) {
        this.f51777j = j4;
    }

    public void a(String str) {
        this.f51769b = str;
    }

    public void a(int i4) {
        this.f51770c = i4;
    }

    public void a(File file) {
        this.f51774g = file;
    }

    public int d() {
        return this.f51775h;
    }

    public void d(int i4) {
        this.f51775h = i4;
    }
}
