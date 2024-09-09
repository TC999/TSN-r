package com.qq.e.dl.f;

import android.os.Build;
import com.qq.e.dl.f.f;
import com.qq.e.dl.f.h;
import com.qq.e.dl.f.i;
import com.qq.e.dl.f.j;
import com.qq.e.dl.f.k;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class g {

    /* renamed from: c  reason: collision with root package name */
    static final boolean f46837c;

    /* renamed from: d  reason: collision with root package name */
    private static final Map<Integer, h.a> f46838d;

    /* renamed from: a  reason: collision with root package name */
    private Map<String, i> f46839a;

    /* renamed from: b  reason: collision with root package name */
    private List<h> f46840b;

    static {
        f46837c = Build.VERSION.SDK_INT > 21 && com.qq.e.comm.plugin.d0.a.d().f().a("dlans", 1) == 1;
        HashMap hashMap = new HashMap(10);
        f46838d = hashMap;
        hashMap.put(1, new a());
        f46838d.put(2, new f.b());
        f46838d.put(3, new o());
        f46838d.put(4, new n(n.f46875c));
        f46838d.put(5, new r());
        f46838d.put(6, new e());
        f46838d.put(7, new d());
        f46838d.put(8, new f.c());
        f46838d.put(9, new n(n.f46876d));
        f46838d.put(10, new n(n.f46877e));
        f46838d.put(11, new l());
    }

    public i a(String str) {
        Map<String, i> map = this.f46839a;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public void b() {
        Map<String, i> map = this.f46839a;
        if (map == null || map.size() == 0) {
            return;
        }
        for (Map.Entry<String, i> entry : this.f46839a.entrySet()) {
            entry.getValue().pause();
        }
    }

    public void c() {
        Map<String, i> map = this.f46839a;
        if (map == null || map.size() == 0) {
            return;
        }
        for (Map.Entry<String, i> entry : this.f46839a.entrySet()) {
            entry.getValue().resume();
        }
    }

    public void a(com.qq.e.dl.i.a[] aVarArr, com.qq.e.dl.l.h hVar) {
        if (aVarArr == null || aVarArr.length <= 0 || hVar == null) {
            return;
        }
        if (this.f46840b == null) {
            this.f46840b = new LinkedList();
        }
        for (com.qq.e.dl.i.a aVar : aVarArr) {
            h.a aVar2 = f46838d.get(Integer.valueOf(aVar.f46908a));
            if (aVar2 != null) {
                if (com.qq.e.dl.k.l.a(aVar.a())) {
                    hVar.a(aVar);
                }
                h a4 = aVar2.a(aVar, hVar);
                if (a4 != null) {
                    this.f46840b.add(a4);
                }
            }
        }
    }

    public void a() {
        List<h> list = this.f46840b;
        if (list == null || list.size() == 0) {
            return;
        }
        HashMap hashMap = new HashMap();
        for (h hVar : this.f46840b) {
            String str = hVar.f46842a.f46909b;
            i.a aVar = (i.a) hashMap.get(str);
            if (aVar == null) {
                aVar = f46837c ? new k.b(str) : new j.b(str);
                hashMap.put(str, aVar);
            }
            aVar.a(hVar);
        }
        HashMap hashMap2 = new HashMap(hashMap.size());
        for (Map.Entry entry : hashMap.entrySet()) {
            hashMap2.put(entry.getKey(), ((i.a) entry.getValue()).build());
        }
        this.f46839a = hashMap2;
        this.f46840b = null;
    }
}
