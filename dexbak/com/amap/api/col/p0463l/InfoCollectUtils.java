package com.amap.api.col.p0463l;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.maps.model.LatLng;
import java.lang.ref.WeakReference;
import java.util.Hashtable;

/* renamed from: com.amap.api.col.3l.o2 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class InfoCollectUtils {

    /* renamed from: c */
    private static boolean f4769c;

    /* renamed from: d */
    private static volatile InfoCollectUtils f4770d;

    /* renamed from: a */
    private Hashtable<String, String> f4771a = new Hashtable<>();

    /* renamed from: b */
    private WeakReference<Context> f4772b = null;

    private InfoCollectUtils() {
    }

    /* renamed from: a */
    public static InfoCollectUtils m54411a() {
        if (f4770d == null) {
            synchronized (InfoCollectUtils.class) {
                if (f4770d == null) {
                    f4770d = new InfoCollectUtils();
                }
            }
        }
        return f4770d;
    }

    /* renamed from: d */
    private void m54408d(String str) {
        Hashtable<String, String> hashtable;
        if (str == null || (hashtable = this.f4771a) == null) {
            return;
        }
        synchronized (hashtable) {
            String m54583d = C1849l4.m54583d(str);
            Hashtable<String, String> hashtable2 = this.f4771a;
            if (hashtable2 != null && !hashtable2.contains(m54583d)) {
                this.f4771a.put(m54583d, str);
            }
            if (m54403i()) {
                m54404h();
            }
        }
    }

    /* renamed from: e */
    public static void m54407e(boolean z) {
        f4769c = z;
    }

    /* renamed from: f */
    public static void m54406f() {
        if (f4770d != null) {
            if (f4770d.f4771a != null && f4770d.f4771a.size() > 0) {
                synchronized (f4770d.f4771a) {
                    f4770d.m54404h();
                    if (f4770d.f4772b != null) {
                        f4770d.f4772b.clear();
                    }
                }
            }
            f4770d = null;
        }
        m54407e(false);
    }

    /* renamed from: g */
    public static boolean m54405g() {
        return f4769c;
    }

    /* renamed from: h */
    private void m54404h() {
        WeakReference<Context> weakReference;
        if (!f4769c) {
            this.f4771a.clear();
        } else if (this.f4771a != null) {
            StringBuffer stringBuffer = new StringBuffer();
            int i = 0;
            int size = this.f4771a.size();
            if (size > 0) {
                stringBuffer.append("[");
                for (String str : this.f4771a.values()) {
                    i++;
                    stringBuffer.append(str);
                    if (i < size) {
                        stringBuffer.append(",");
                    }
                }
                stringBuffer.append("]");
                String stringBuffer2 = stringBuffer.toString();
                if (!TextUtils.isEmpty(stringBuffer2) && (weakReference = this.f4772b) != null && weakReference.get() != null) {
                    MarkInfoManager.m55447a(stringBuffer2, this.f4772b.get());
                }
            }
            this.f4771a.clear();
        }
    }

    /* renamed from: i */
    private boolean m54403i() {
        Hashtable<String, String> hashtable = this.f4771a;
        return hashtable != null && hashtable.size() > 20;
    }

    /* renamed from: b */
    public final void m54410b(Context context) {
        if (context != null) {
            this.f4772b = new WeakReference<>(context);
        }
    }

    /* renamed from: c */
    public final void m54409c(LatLng latLng, String str, String str2) {
        if (!f4769c) {
            this.f4771a.clear();
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
            m54408d(stringBuffer.toString());
        }
    }
}
