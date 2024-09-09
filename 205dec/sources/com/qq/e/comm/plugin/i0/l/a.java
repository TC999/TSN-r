package com.qq.e.comm.plugin.i0.l;

import android.util.Log;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.g0;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a {

    /* renamed from: g  reason: collision with root package name */
    private static final String f44238g = f.class.getSimpleName();

    /* renamed from: h  reason: collision with root package name */
    private static final a f44239h = new a();

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, b> f44240a = new ConcurrentHashMap();

    /* renamed from: b  reason: collision with root package name */
    private final AtomicBoolean f44241b = new AtomicBoolean(false);

    /* renamed from: c  reason: collision with root package name */
    private final AtomicBoolean f44242c = new AtomicBoolean(false);

    /* renamed from: d  reason: collision with root package name */
    private final AtomicBoolean f44243d = new AtomicBoolean(true);

    /* renamed from: e  reason: collision with root package name */
    private volatile int f44244e = -1;

    /* renamed from: f  reason: collision with root package name */
    private volatile int f44245f = -1;

    private a() {
    }

    private void a(b bVar, b bVar2) {
        pro.getVresult(MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG, 0, this, bVar, bVar2);
    }

    public static a b() {
        return f44239h;
    }

    private boolean c(String str) {
        b bVar;
        long a4 = com.qq.e.comm.plugin.d0.a.d().f().a("ecdrt", 0) * 1000;
        return a4 > 0 && (bVar = this.f44240a.get(str)) != null && (System.currentTimeMillis() - bVar.f44249d) - (bVar.f44248c * 1000) > a4;
    }

    private void d(String str) {
        com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
        dVar.a("data", str);
        v.a(9130079, null, 1, null, dVar);
    }

    public void a(boolean z3) {
        pro.getVresult(224, 0, this, Boolean.valueOf(z3));
    }

    private boolean b(String str) {
        b bVar = this.f44240a.get(str);
        if (bVar != null) {
            double d4 = bVar.f44248c * 1000;
            Double.isNaN(d4);
            if (System.currentTimeMillis() - bVar.f44249d > d4 * 0.8d) {
                return true;
            }
        }
        return false;
    }

    private boolean a() {
        if (this.f44245f < 0) {
            this.f44245f = com.qq.e.comm.plugin.d0.a.d().f().a("prhcdr", 0);
        }
        return this.f44245f > 0;
    }

    private void a(Exception exc) {
        com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
        dVar.a("data", Log.getStackTraceString(exc));
        v.a(9130079, null, 2, null, dVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public List<String> a(String str) {
        b bVar = this.f44240a.get(str);
        boolean compareAndSet = this.f44243d.compareAndSet(true, false);
        ?? r12 = compareAndSet;
        if (compareAndSet) {
            r12 = compareAndSet;
            if (f.c().m()) {
                r12 = 2;
            }
        }
        int f4 = (r12 * 10) + f.c().f();
        String str2 = f44238g;
        d1.a(str2, "track enum code is " + f4);
        if (bVar != null) {
            if (bVar.f44250e == 3 && f.c().b() <= 1 && f.c().t()) {
                bVar.f44250e = 2;
                if (this.f44244e < 0) {
                    this.f44244e = com.qq.e.comm.plugin.d0.a.d().f().a("fsdcht", 5);
                }
                bVar.f44248c = this.f44244e;
            }
            ArrayList arrayList = new ArrayList(bVar.a());
            boolean b4 = b(str);
            if (b4) {
                String str3 = f44238g;
                d1.a(str3, "dns is expired, host: " + str + ", updateTime: " + bVar.f44249d + ", ttl: " + bVar.f44248c);
                if (f.c().b() > 1) {
                    f.c().a(false);
                    if (c(str)) {
                        this.f44240a.remove(str);
                    }
                } else if (f.c().t()) {
                    this.f44240a.remove(str);
                    f.c().q();
                }
            }
            c.a(f4, b4, str);
            return arrayList;
        }
        c.a(f4, str);
        return null;
    }

    public void a(String str, List<String> list, long j4, int i4) {
        b bVar = this.f44240a.get(str);
        if (bVar != null && bVar.f44250e == 1 && i4 == 2) {
            String str2 = f44238g;
            d1.a(str2, "no need to update cache: " + bVar);
            return;
        }
        synchronized (this) {
            b bVar2 = this.f44240a.get(str);
            if (bVar2 != null && bVar2.f44250e == 1 && i4 == 2) {
                String str3 = f44238g;
                d1.a(str3, "no need to update cache: " + bVar2);
            }
            String str4 = f44238g;
            StringBuilder sb = new StringBuilder();
            sb.append("update cache, host: ");
            sb.append(str);
            sb.append(", ipList: ");
            sb.append(list);
            sb.append(", ttl: ");
            sb.append(j4);
            sb.append("s, from: ");
            sb.append(i4 == 1 ? "httpdns" : "systemdns");
            d1.a(str4, sb.toString());
            b bVar3 = new b();
            bVar3.f44246a = str;
            bVar3.f44248c = j4;
            bVar3.f44249d = System.currentTimeMillis();
            CopyOnWriteArrayList<g0> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            for (String str5 : list) {
                copyOnWriteArrayList.add(new g0(str5));
            }
            bVar3.f44247b = copyOnWriteArrayList;
            bVar3.f44250e = i4;
            this.f44240a.put(str, bVar3);
            a(bVar2, bVar3);
        }
    }
}
