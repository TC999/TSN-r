package com.amap.api.col.p0003l;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.maps.model.LatLng;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: TraceResultPool.java */
/* renamed from: com.amap.api.col.3l.c4  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class c4 {

    /* renamed from: b  reason: collision with root package name */
    private static volatile c4 f7306b;

    /* renamed from: a  reason: collision with root package name */
    private Map<String, a> f7307a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: TraceResultPool.java */
    /* renamed from: com.amap.api.col.3l.c4$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    class a {

        /* renamed from: a  reason: collision with root package name */
        private int f7308a;

        /* renamed from: b  reason: collision with root package name */
        private int f7309b;

        /* renamed from: d  reason: collision with root package name */
        private int f7311d;

        /* renamed from: f  reason: collision with root package name */
        private HashMap<Integer, List<LatLng>> f7313f;

        /* renamed from: c  reason: collision with root package name */
        private int f7310c = 0;

        /* renamed from: e  reason: collision with root package name */
        private int f7312e = 0;

        /* renamed from: g  reason: collision with root package name */
        private List<LatLng> f7314g = new ArrayList();

        public a(int i4, int i5, int i6, HashMap<Integer, List<LatLng>> hashMap) {
            this.f7308a = 0;
            this.f7309b = 0;
            this.f7311d = 0;
            this.f7308a = i5;
            this.f7313f = hashMap;
            this.f7309b = i4;
            this.f7311d = i6;
        }

        private void c(Handler handler, List<LatLng> list) {
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.obj = list;
            obtainMessage.what = 100;
            obtainMessage.arg1 = this.f7310c;
            Bundle bundle = new Bundle();
            bundle.putInt("lineID", this.f7309b);
            obtainMessage.setData(bundle);
            handler.sendMessage(obtainMessage);
            this.f7310c++;
            this.f7312e++;
        }

        private void d(Handler handler) {
            if (this.f7312e > 0) {
                int a4 = z3.a(this.f7314g);
                Message obtainMessage = handler.obtainMessage();
                obtainMessage.obj = this.f7314g;
                obtainMessage.what = 101;
                obtainMessage.arg1 = a4;
                obtainMessage.arg2 = this.f7311d;
                Bundle bundle = new Bundle();
                bundle.putInt("lineID", this.f7309b);
                obtainMessage.setData(bundle);
                handler.sendMessage(obtainMessage);
                return;
            }
            c4.c(handler, this.f7309b, "\u8f68\u8ff9\u70b9\u592a\u5c11\u6216\u8ddd\u79bb\u592a\u8fd1,\u8f68\u8ff9\u7ea0\u504f\u5931\u8d25");
        }

        public final HashMap<Integer, List<LatLng>> a() {
            return this.f7313f;
        }

        public final void b(Handler handler) {
            List<LatLng> list;
            for (int i4 = this.f7310c; i4 <= this.f7308a && (list = this.f7313f.get(Integer.valueOf(i4))) != null; i4++) {
                this.f7314g.addAll(list);
                c(handler, list);
            }
            if (this.f7310c == this.f7308a + 1) {
                d(handler);
            }
        }
    }

    public c4() {
        this.f7307a = null;
        this.f7307a = Collections.synchronizedMap(new HashMap());
    }

    public static c4 b() {
        if (f7306b == null) {
            synchronized (c4.class) {
                if (f7306b == null) {
                    f7306b = new c4();
                }
            }
        }
        return f7306b;
    }

    public static void c(Handler handler, int i4, String str) {
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.obj = str;
        obtainMessage.what = 102;
        Bundle bundle = new Bundle();
        bundle.putInt("lineID", i4);
        obtainMessage.setData(bundle);
        handler.sendMessage(obtainMessage);
    }

    public final synchronized a a(String str) {
        Map<String, a> map = this.f7307a;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    public final synchronized void d(String str, int i4, int i5, int i6) {
        Map<String, a> map = this.f7307a;
        if (map != null) {
            map.put(str, new a(i4, i5, i6, new HashMap(16)));
        }
    }

    public final synchronized void e(String str, int i4, List<LatLng> list) {
        Map<String, a> map = this.f7307a;
        if (map != null) {
            map.get(str).a().put(Integer.valueOf(i4), list);
        }
    }
}
