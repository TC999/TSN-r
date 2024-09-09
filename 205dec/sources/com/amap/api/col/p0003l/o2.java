package com.amap.api.col.p0003l;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.maps.model.LatLng;
import java.lang.ref.WeakReference;
import java.util.Hashtable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: InfoCollectUtils.java */
/* renamed from: com.amap.api.col.3l.o2  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class o2 {

    /* renamed from: c  reason: collision with root package name */
    private static boolean f8439c;

    /* renamed from: d  reason: collision with root package name */
    private static volatile o2 f8440d;

    /* renamed from: a  reason: collision with root package name */
    private Hashtable<String, String> f8441a = new Hashtable<>();

    /* renamed from: b  reason: collision with root package name */
    private WeakReference<Context> f8442b = null;

    private o2() {
    }

    public static o2 a() {
        if (f8440d == null) {
            synchronized (o2.class) {
                if (f8440d == null) {
                    f8440d = new o2();
                }
            }
        }
        return f8440d;
    }

    private void d(String str) {
        Hashtable<String, String> hashtable;
        if (str == null || (hashtable = this.f8441a) == null) {
            return;
        }
        synchronized (hashtable) {
            String d4 = m4.d(str);
            Hashtable<String, String> hashtable2 = this.f8441a;
            if (hashtable2 != null && !hashtable2.contains(d4)) {
                this.f8441a.put(d4, str);
            }
            if (i()) {
                h();
            }
        }
    }

    public static void e(boolean z3) {
        f8439c = z3;
    }

    public static void f() {
        if (f8440d != null) {
            if (f8440d.f8441a != null && f8440d.f8441a.size() > 0) {
                synchronized (f8440d.f8441a) {
                    f8440d.h();
                    if (f8440d.f8442b != null) {
                        f8440d.f8442b.clear();
                    }
                }
            }
            f8440d = null;
        }
        e(false);
    }

    public static boolean g() {
        return f8439c;
    }

    private void h() {
        WeakReference<Context> weakReference;
        if (!f8439c) {
            this.f8441a.clear();
        } else if (this.f8441a != null) {
            StringBuffer stringBuffer = new StringBuffer();
            int i4 = 0;
            int size = this.f8441a.size();
            if (size > 0) {
                stringBuffer.append("[");
                for (String str : this.f8441a.values()) {
                    i4++;
                    stringBuffer.append(str);
                    if (i4 < size) {
                        stringBuffer.append(",");
                    }
                }
                stringBuffer.append("]");
                String stringBuffer2 = stringBuffer.toString();
                if (!TextUtils.isEmpty(stringBuffer2) && (weakReference = this.f8442b) != null && weakReference.get() != null) {
                    d7.a(stringBuffer2, this.f8442b.get());
                }
            }
            this.f8441a.clear();
        }
    }

    private boolean i() {
        Hashtable<String, String> hashtable = this.f8441a;
        return hashtable != null && hashtable.size() > 20;
    }

    public final void b(Context context) {
        if (context != null) {
            this.f8442b = new WeakReference<>(context);
        }
    }

    public final void c(LatLng latLng, String str, String str2) {
        if (!f8439c) {
            this.f8441a.clear();
        } else if (latLng == null || TextUtils.isEmpty(str)) {
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("{");
            stringBuffer.append("\"lon\":");
            stringBuffer.append(latLng.longitude);
            stringBuffer.append(",");
            stringBuffer.append("\"lat\":");
            stringBuffer.append(latLng.latitude);
            stringBuffer.append(",");
            stringBuffer.append("\"title\":\"");
            stringBuffer.append(str);
            stringBuffer.append("\",");
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
            }
            stringBuffer.append("\"snippet\":\"");
            stringBuffer.append(str2);
            stringBuffer.append("\"");
            stringBuffer.append("}");
            d(stringBuffer.toString());
        }
    }
}
