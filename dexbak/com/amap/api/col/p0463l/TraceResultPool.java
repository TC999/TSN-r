package com.amap.api.col.p0463l;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.maps.model.LatLng;
import com.amap.api.trace.LBSTraceClient;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.amap.api.col.3l.c4 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class TraceResultPool {

    /* renamed from: b */
    private static volatile TraceResultPool f3724b;

    /* renamed from: a */
    private Map<String, C1755a> f3725a;

    /* compiled from: TraceResultPool.java */
    /* renamed from: com.amap.api.col.3l.c4$a */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    class C1755a {

        /* renamed from: a */
        private int f3726a;

        /* renamed from: b */
        private int f3727b;

        /* renamed from: d */
        private int f3729d;

        /* renamed from: f */
        private HashMap<Integer, List<LatLng>> f3731f;

        /* renamed from: c */
        private int f3728c = 0;

        /* renamed from: e */
        private int f3730e = 0;

        /* renamed from: g */
        private List<LatLng> f3732g = new ArrayList();

        public C1755a(int i, int i2, int i3, HashMap<Integer, List<LatLng>> hashMap) {
            this.f3726a = 0;
            this.f3727b = 0;
            this.f3729d = 0;
            this.f3726a = i2;
            this.f3731f = hashMap;
            this.f3727b = i;
            this.f3729d = i3;
        }

        /* renamed from: c */
        private void m55472c(Handler handler, List<LatLng> list) {
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.obj = list;
            obtainMessage.what = 100;
            obtainMessage.arg1 = this.f3728c;
            Bundle bundle = new Bundle();
            bundle.putInt("lineID", this.f3727b);
            obtainMessage.setData(bundle);
            handler.sendMessage(obtainMessage);
            this.f3728c++;
            this.f3730e++;
        }

        /* renamed from: d */
        private void m55471d(Handler handler) {
            if (this.f3730e > 0) {
                int m53335a = CoreUtil.m53335a(this.f3732g);
                Message obtainMessage = handler.obtainMessage();
                obtainMessage.obj = this.f3732g;
                obtainMessage.what = 101;
                obtainMessage.arg1 = m53335a;
                obtainMessage.arg2 = this.f3729d;
                Bundle bundle = new Bundle();
                bundle.putInt("lineID", this.f3727b);
                obtainMessage.setData(bundle);
                handler.sendMessage(obtainMessage);
                return;
            }
            TraceResultPool.m55477c(handler, this.f3727b, LBSTraceClient.MIN_GRASP_POINT_ERROR);
        }

        /* renamed from: a */
        public final HashMap<Integer, List<LatLng>> m55474a() {
            return this.f3731f;
        }

        /* renamed from: b */
        public final void m55473b(Handler handler) {
            List<LatLng> list;
            for (int i = this.f3728c; i <= this.f3726a && (list = this.f3731f.get(Integer.valueOf(i))) != null; i++) {
                this.f3732g.addAll(list);
                m55472c(handler, list);
            }
            if (this.f3728c == this.f3726a + 1) {
                m55471d(handler);
            }
        }
    }

    public TraceResultPool() {
        this.f3725a = null;
        this.f3725a = Collections.synchronizedMap(new HashMap());
    }

    /* renamed from: b */
    public static TraceResultPool m55478b() {
        if (f3724b == null) {
            synchronized (TraceResultPool.class) {
                if (f3724b == null) {
                    f3724b = new TraceResultPool();
                }
            }
        }
        return f3724b;
    }

    /* renamed from: c */
    public static void m55477c(Handler handler, int i, String str) {
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.obj = str;
        obtainMessage.what = 102;
        Bundle bundle = new Bundle();
        bundle.putInt("lineID", i);
        obtainMessage.setData(bundle);
        handler.sendMessage(obtainMessage);
    }

    /* renamed from: a */
    public final synchronized C1755a m55479a(String str) {
        Map<String, C1755a> map = this.f3725a;
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    /* renamed from: d */
    public final synchronized void m55476d(String str, int i, int i2, int i3) {
        Map<String, C1755a> map = this.f3725a;
        if (map != null) {
            map.put(str, new C1755a(i, i2, i3, new HashMap(16)));
        }
    }

    /* renamed from: e */
    public final synchronized void m55475e(String str, int i, List<LatLng> list) {
        Map<String, C1755a> map = this.f3725a;
        if (map != null) {
            map.get(str).m55474a().put(Integer.valueOf(i), list);
        }
    }
}
