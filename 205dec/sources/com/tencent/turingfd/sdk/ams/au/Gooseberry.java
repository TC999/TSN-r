package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Gooseberry {

    /* renamed from: d  reason: collision with root package name */
    public static final String f52076d = Cextends.a(Cextends.f52250a1);

    /* renamed from: e  reason: collision with root package name */
    public static final long f52077e = TimeUnit.HOURS.toMillis(32);

    /* renamed from: f  reason: collision with root package name */
    public static final Gooseberry f52078f = new Gooseberry();

    /* renamed from: a  reason: collision with root package name */
    public volatile Cpackage f52079a = null;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicBoolean f52080b = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    public final ReentrantReadWriteLock f52081c = new ReentrantReadWriteLock();

    public void a(Cpackage cpackage, boolean z3) {
        BufferedOutputStream bufferedOutputStream;
        this.f52081c.writeLock().lock();
        if (z3) {
            try {
                Dorado dorado = new Dorado(128);
                cpackage.a(dorado);
                byte[] a4 = dorado.a();
                BufferedOutputStream bufferedOutputStream2 = null;
                try {
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(c()));
                } catch (Throwable unused) {
                }
                try {
                    bufferedOutputStream.write(a4);
                    bufferedOutputStream.flush();
                    Ccontinue.a(bufferedOutputStream);
                } catch (Throwable unused2) {
                    bufferedOutputStream2 = bufferedOutputStream;
                    Ccontinue.a(bufferedOutputStream2);
                }
            } finally {
                this.f52079a = cpackage;
                this.f52081c.writeLock().unlock();
            }
        }
    }

    public final Cpackage b() {
        Cpackage cpackage;
        this.f52081c.readLock().lock();
        try {
            if (this.f52080b.get()) {
                return this.f52079a;
            }
            synchronized (this.f52080b) {
                if (this.f52080b.get()) {
                    return this.f52079a;
                }
                try {
                    cpackage = new Cpackage();
                    cpackage.a(new Cygnus(Ccontinue.b(c())));
                } catch (Throwable unused) {
                    cpackage = null;
                }
                this.f52079a = cpackage;
                this.f52080b.set(true);
                return this.f52079a;
            }
        } finally {
            this.f52081c.readLock().unlock();
        }
    }

    public String c() {
        Context context;
        synchronized (Ctry.class) {
            context = Ctry.f52366a;
        }
        File dir = context.getDir("turingfd", 0);
        if (dir == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(dir.getAbsolutePath());
        String str = File.separator;
        sb.append(str);
        sb.append("12");
        File file = new File(sb.toString());
        if (file.exists() || file.mkdirs()) {
            return file.getAbsolutePath() + str + Betelnut.f51924a + "_au_1";
        }
        return "";
    }

    public Set<String> d() {
        String a4;
        if (!e()) {
            a4 = Cextends.a(Cextends.f52271h1);
        } else {
            a4 = a("p_l_h_l");
        }
        if (TextUtils.isEmpty(a4)) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Collections.addAll(hashSet, a4.split(","));
        return hashSet;
    }

    public final boolean e() {
        return b() != null;
    }

    public final String a(String str) {
        Cpackage b4;
        Map<String, String> map;
        if (str == null || (b4 = b()) == null || (map = b4.f52341i) == null) {
            return null;
        }
        return map.get(str);
    }

    public final boolean a(String str, boolean z3) {
        String a4 = a(str);
        if (a4 == null) {
            return z3;
        }
        try {
            return Integer.parseInt(a4) > 0;
        } catch (NumberFormatException unused) {
            return z3;
        }
    }

    public String a() {
        String a4;
        String[] split;
        String[] split2;
        if (!e()) {
            a4 = Cextends.a(Cextends.f52268g1);
        } else {
            a4 = a("a_f_ok_c");
        }
        String a5 = a("a_f_ok_s");
        HashSet hashSet = new HashSet();
        if (!TextUtils.isEmpty(a4)) {
            for (String str : a4.split(",")) {
                if (!TextUtils.isEmpty(str)) {
                    hashSet.add(str);
                }
            }
        }
        if (!TextUtils.isEmpty(a5) && Sagittarius.a()) {
            for (String str2 : a5.split(",")) {
                if (!TextUtils.isEmpty(str2)) {
                    hashSet.add(str2);
                }
            }
        }
        if (hashSet.size() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            String str3 = (String) it.next();
            if (sb.length() > 0) {
                sb.append(",");
            }
            sb.append(str3);
        }
        return sb.toString();
    }
}
