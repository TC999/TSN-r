package com.autonavi.extra;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AMapExtraInterfaceManager.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private List<a> f12061a = new ArrayList();

    public final void a() {
        synchronized (b.class) {
            List<a> list = this.f12061a;
            if (list != null) {
                list.add(null);
            }
        }
    }

    public final void b() {
        synchronized (b.class) {
            Iterator<a> it = this.f12061a.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public final void c() {
        synchronized (b.class) {
            Iterator<a> it = this.f12061a.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public final void d() {
        synchronized (b.class) {
            Iterator<a> it = this.f12061a.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public final void e() {
        synchronized (b.class) {
            Iterator<a> it = this.f12061a.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public final void f() {
        synchronized (b.class) {
            Iterator<a> it = this.f12061a.iterator();
            while (it.hasNext()) {
                it.next();
            }
            this.f12061a.clear();
        }
    }

    public final String g() {
        String stringBuffer;
        synchronized (b.class) {
            StringBuffer stringBuffer2 = new StringBuffer();
            for (a aVar : this.f12061a) {
                if (aVar != null) {
                    String a4 = aVar.a();
                    if (!TextUtils.isEmpty(a4)) {
                        stringBuffer2.append(a4);
                        if (!a4.endsWith(";")) {
                            stringBuffer2.append(";");
                        }
                    }
                }
            }
            stringBuffer = stringBuffer2.toString();
        }
        return stringBuffer;
    }

    public final void h() {
        synchronized (b.class) {
            Iterator<a> it = this.f12061a.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public final void i() {
        synchronized (b.class) {
            Iterator<a> it = this.f12061a.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public final Object j() {
        Object b4;
        synchronized (b.class) {
            for (a aVar : this.f12061a) {
                if (aVar != null && (b4 = aVar.b()) != null) {
                    return b4;
                }
            }
            return null;
        }
    }
}
