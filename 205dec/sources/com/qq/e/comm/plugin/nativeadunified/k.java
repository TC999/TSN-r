package com.qq.e.comm.plugin.nativeadunified;

import android.content.Context;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.adevent.ADEvent;
import com.qq.e.comm.adevent.ADListener;
import com.qq.e.comm.constants.LoadAdParams;
import com.qq.e.comm.pi.NUADI;
import com.qq.e.comm.plugin.e0.d.a;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.mediation.interfaces.BaseNativeUnifiedAd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import qa.fg.ck;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class k extends com.qq.e.comm.plugin.e0.d.a<BaseNativeUnifiedAd> implements NUADI {
    private static String A;

    /* renamed from: t  reason: collision with root package name */
    private ADListener f44959t;

    /* renamed from: u  reason: collision with root package name */
    private int f44960u;

    /* renamed from: v  reason: collision with root package name */
    private Map<BaseNativeUnifiedAd, d> f44961v;

    /* renamed from: w  reason: collision with root package name */
    private List<String> f44962w;

    /* renamed from: x  reason: collision with root package name */
    private int f44963x;

    /* renamed from: y  reason: collision with root package name */
    private int f44964y;

    /* renamed from: z  reason: collision with root package name */
    private String f44965z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements a.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f44966a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f44967b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ BaseNativeUnifiedAd f44968c;

        a(int i4, long j4, BaseNativeUnifiedAd baseNativeUnifiedAd) {
            this.f44966a = i4;
            this.f44967b = j4;
            this.f44968c = baseNativeUnifiedAd;
        }

        @Override // com.qq.e.comm.plugin.e0.d.a.b
        public void a(ADEvent aDEvent) {
            k.this.a(com.qq.e.comm.plugin.b.g.NATIVEUNIFIEDAD, this.f44966a, this.f44967b, (long) this.f44968c);
            k.this.f(this.f44968c);
        }

        @Override // com.qq.e.comm.plugin.e0.d.a.b
        public void b() {
            k.this.c(this.f44968c, 70342);
        }

        @Override // com.qq.e.comm.plugin.e0.d.a.b
        public void c(ADEvent aDEvent) {
            k.this.a(com.qq.e.comm.plugin.b.g.NATIVEUNIFIEDAD, this.f44966a, this.f44967b, (long) this.f44968c);
            k.this.a((k) this.f44968c, aDEvent);
        }

        @Override // com.qq.e.comm.plugin.e0.d.a.b
        public void d() {
        }

        @Override // com.qq.e.comm.plugin.e0.d.a.b
        public void d(ADEvent aDEvent) {
            if (k.this.f44959t == null) {
                return;
            }
            k.this.f44959t.onADEvent(aDEvent);
        }

        @Override // com.qq.e.comm.plugin.e0.d.a.b
        public void e() {
        }

        @Override // com.qq.e.comm.plugin.e0.d.a.b
        public void b(ADEvent aDEvent) {
            com.qq.e.comm.plugin.e0.d.g.a(aDEvent, k.A, com.qq.e.comm.plugin.b.g.NATIVEUNIFIEDAD, this.f44968c);
        }

        @Override // com.qq.e.comm.plugin.e0.d.a.b
        public void a() {
            com.qq.e.comm.plugin.e0.d.g.a(this.f44968c, 1143007);
        }

        @Override // com.qq.e.comm.plugin.e0.d.a.b
        public void c() {
            k.this.d(this.f44968c, 70332);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b implements a.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ BaseNativeUnifiedAd f44970a;

        b(BaseNativeUnifiedAd baseNativeUnifiedAd) {
            this.f44970a = baseNativeUnifiedAd;
        }

        @Override // com.qq.e.comm.plugin.e0.d.a.b
        public void a() {
            com.qq.e.comm.plugin.e0.d.g.a(this.f44970a, 1143007);
        }

        @Override // com.qq.e.comm.plugin.e0.d.a.b
        public void a(ADEvent aDEvent) {
        }

        @Override // com.qq.e.comm.plugin.e0.d.a.b
        public void b() {
            k.this.c(this.f44970a, 70342);
        }

        @Override // com.qq.e.comm.plugin.e0.d.a.b
        public void c() {
            k.this.d(this.f44970a, 70332);
        }

        @Override // com.qq.e.comm.plugin.e0.d.a.b
        public void c(ADEvent aDEvent) {
        }

        @Override // com.qq.e.comm.plugin.e0.d.a.b
        public void d() {
        }

        @Override // com.qq.e.comm.plugin.e0.d.a.b
        public void d(ADEvent aDEvent) {
        }

        @Override // com.qq.e.comm.plugin.e0.d.a.b
        public void e() {
        }

        @Override // com.qq.e.comm.plugin.e0.d.a.b
        public void b(ADEvent aDEvent) {
            com.qq.e.comm.plugin.e0.d.g.a(aDEvent, k.A, com.qq.e.comm.plugin.b.g.NATIVEUNIFIEDAD, this.f44970a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class c implements ADListener {

        /* renamed from: a  reason: collision with root package name */
        private ADListener f44972a;

        /* renamed from: b  reason: collision with root package name */
        private a.b f44973b;

        public c(a.b bVar) {
            this.f44973b = bVar;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(ADListener aDListener) {
            this.f44972a = aDListener;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            d1.a("Unified evt" + aDEvent.getType(), new Object[0]);
            this.f44972a.onADEvent(aDEvent);
            if (aDEvent.getType() == 105) {
                this.f44973b.b();
            } else if (aDEvent.getType() == 103) {
                this.f44973b.c();
            } else if (aDEvent.getType() == 407) {
                this.f44973b.a();
            }
            switch (aDEvent.getType()) {
                case 401:
                case 402:
                case 403:
                case 404:
                case 405:
                case 406:
                    this.f44973b.b(aDEvent);
                    return;
                default:
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class d implements ADListener {

        /* renamed from: a  reason: collision with root package name */
        private a.b f44974a;

        /* renamed from: b  reason: collision with root package name */
        private Queue<ADEvent> f44975b = new LinkedList();

        public d(a.b bVar) {
            this.f44974a = bVar;
        }

        Queue<ADEvent> a() {
            return this.f44975b;
        }

        @Override // com.qq.e.comm.adevent.ADListener
        public void onADEvent(ADEvent aDEvent) {
            if (aDEvent.getType() == 101) {
                this.f44974a.c(aDEvent);
            } else if (aDEvent.getType() == 100) {
                this.f44975b.offer(aDEvent);
                this.f44974a.a(aDEvent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Context context, String str, String str2, ADListener aDListener) {
        super(context, str2);
        this.f44961v = new HashMap();
        this.f44964y = -1;
        this.f44959t = aDListener;
        A = str2;
    }

    @Override // com.qq.e.comm.pi.NUADI
    public String getAdNetWorkName() {
        return k();
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void loadData(int i4) {
        this.f44960u = i4;
        l();
    }

    protected void p() {
        ADListener aDListener = this.f44959t;
        if (aDListener != null) {
            aDListener.onADEvent(new ADEvent(101, 5004));
        }
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void setCategories(List<String> list) {
        this.f44962w = list;
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void setMaxVideoDuration(int i4) {
        this.f44964y = i4;
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void setMinVideoDuration(int i4) {
        this.f44963x = i4;
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void setVastClassName(String str) {
        this.f44965z = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.e0.d.a
    /* renamed from: c */
    public BaseNativeUnifiedAd b(com.qq.e.comm.plugin.e0.e.d dVar) {
        if (dVar == null) {
            return null;
        }
        try {
            return com.qq.e.comm.plugin.nativeadunified.b.a(dVar.e(), this.f42771f, dVar.b(), dVar.p(), dVar.j());
        } catch (Exception e4) {
            a(70352, dVar);
            e4.printStackTrace();
            return null;
        }
    }

    @Override // com.qq.e.comm.pi.NUADI
    public void loadData(int i4, LoadAdParams loadAdParams) {
        loadData(i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.e0.d.a
    /* renamed from: b */
    public String d(BaseNativeUnifiedAd baseNativeUnifiedAd) {
        if (b()) {
            return baseNativeUnifiedAd.getReqId();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.e0.d.a
    /* renamed from: c */
    public void e(BaseNativeUnifiedAd baseNativeUnifiedAd) {
        d dVar;
        a(com.qq.e.comm.plugin.b.g.NATIVEUNIFIEDAD);
        if (baseNativeUnifiedAd != null && (dVar = this.f44961v.get(baseNativeUnifiedAd)) != null) {
            baseNativeUnifiedAd.setECPMLevel(getECPMLevel());
            for (ADEvent aDEvent : dVar.a()) {
                if (aDEvent.getType() == 100) {
                    aDEvent = new ADEvent(100, a(a(aDEvent), baseNativeUnifiedAd));
                }
                this.f44959t.onADEvent(aDEvent);
            }
            return;
        }
        p();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.e0.d.a
    /* renamed from: a */
    public void b(BaseNativeUnifiedAd baseNativeUnifiedAd, int i4) {
        d dVar = new d(new a(i4, System.currentTimeMillis(), baseNativeUnifiedAd));
        this.f44961v.put(baseNativeUnifiedAd, dVar);
        baseNativeUnifiedAd.setAdListener(dVar);
        List<String> list = this.f44962w;
        if (list != null) {
            baseNativeUnifiedAd.setCategories(list);
        }
        int i5 = this.f44963x;
        if (i5 > 0) {
            baseNativeUnifiedAd.setMinVideoDuration(i5);
        }
        int i6 = this.f44964y;
        if (i6 >= 0) {
            baseNativeUnifiedAd.setMaxVideoDuration(i6);
        }
        if (baseNativeUnifiedAd instanceof com.qq.e.comm.plugin.e0.c) {
            ((com.qq.e.comm.plugin.e0.c) baseNativeUnifiedAd).setVastClassName(this.f44965z);
        }
        ck.a(baseNativeUnifiedAd, this.f44960u);
        d1.a(baseNativeUnifiedAd.getClass().getSimpleName() + " load Ad", new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.e0.d.a
    /* renamed from: a */
    public void b(BaseNativeUnifiedAd baseNativeUnifiedAd, int i4, String str) {
        baseNativeUnifiedAd.setPayload(str);
        b(baseNativeUnifiedAd, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.e0.d.a
    public int a(BaseNativeUnifiedAd baseNativeUnifiedAd) {
        return baseNativeUnifiedAd.getECPM();
    }

    private List<NativeUnifiedADData> a(List<NativeUnifiedADData> list, BaseNativeUnifiedAd baseNativeUnifiedAd) {
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (NativeUnifiedADData nativeUnifiedADData : list) {
            arrayList.add(com.qq.e.comm.plugin.nativeadunified.b.a(nativeUnifiedADData, new c(new b(baseNativeUnifiedAd))));
        }
        return arrayList;
    }

    private List<NativeUnifiedADData> a(ADEvent aDEvent) {
        List<NativeUnifiedADData> list;
        return (aDEvent == null || aDEvent.getType() != 100 || (list = (List) aDEvent.getParam(List.class)) == null || list.size() < 1 || !(list.get(0) instanceof NativeUnifiedADData)) ? new ArrayList() : list;
    }
}
