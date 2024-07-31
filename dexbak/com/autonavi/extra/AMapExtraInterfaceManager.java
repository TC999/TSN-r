package com.autonavi.extra;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.autonavi.extra.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class AMapExtraInterfaceManager {

    /* renamed from: a */
    private List<AMapExtraInterfaceListener> f8428a = new ArrayList();

    /* renamed from: a */
    public final void m51145a() {
        synchronized (AMapExtraInterfaceManager.class) {
            List<AMapExtraInterfaceListener> list = this.f8428a;
            if (list != null) {
                list.add(null);
            }
        }
    }

    /* renamed from: b */
    public final void m51144b() {
        synchronized (AMapExtraInterfaceManager.class) {
            Iterator<AMapExtraInterfaceListener> it = this.f8428a.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    /* renamed from: c */
    public final void m51143c() {
        synchronized (AMapExtraInterfaceManager.class) {
            Iterator<AMapExtraInterfaceListener> it = this.f8428a.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    /* renamed from: d */
    public final void m51142d() {
        synchronized (AMapExtraInterfaceManager.class) {
            Iterator<AMapExtraInterfaceListener> it = this.f8428a.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    /* renamed from: e */
    public final void m51141e() {
        synchronized (AMapExtraInterfaceManager.class) {
            Iterator<AMapExtraInterfaceListener> it = this.f8428a.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    /* renamed from: f */
    public final void m51140f() {
        synchronized (AMapExtraInterfaceManager.class) {
            Iterator<AMapExtraInterfaceListener> it = this.f8428a.iterator();
            while (it.hasNext()) {
                it.next();
            }
            this.f8428a.clear();
        }
    }

    /* renamed from: g */
    public final String m51139g() {
        String stringBuffer;
        synchronized (AMapExtraInterfaceManager.class) {
            StringBuffer stringBuffer2 = new StringBuffer();
            for (AMapExtraInterfaceListener aMapExtraInterfaceListener : this.f8428a) {
                if (aMapExtraInterfaceListener != null) {
                    String m51147a = aMapExtraInterfaceListener.m51147a();
                    if (!TextUtils.isEmpty(m51147a)) {
                        stringBuffer2.append(m51147a);
                        if (!m51147a.endsWith(";")) {
                            stringBuffer2.append(";");
                        }
                    }
                }
            }
            stringBuffer = stringBuffer2.toString();
        }
        return stringBuffer;
    }

    /* renamed from: h */
    public final void m51138h() {
        synchronized (AMapExtraInterfaceManager.class) {
            Iterator<AMapExtraInterfaceListener> it = this.f8428a.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    /* renamed from: i */
    public final void m51137i() {
        synchronized (AMapExtraInterfaceManager.class) {
            Iterator<AMapExtraInterfaceListener> it = this.f8428a.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    /* renamed from: j */
    public final Object m51136j() {
        Object m51146b;
        synchronized (AMapExtraInterfaceManager.class) {
            for (AMapExtraInterfaceListener aMapExtraInterfaceListener : this.f8428a) {
                if (aMapExtraInterfaceListener != null && (m51146b = aMapExtraInterfaceListener.m51146b()) != null) {
                    return m51146b;
                }
            }
            return null;
        }
    }
}
