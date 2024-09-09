package com.amap.api.col.s;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.s.cf;
import com.amap.api.col.s.u4;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.cloud.CloudResult;
import com.amap.api.services.cloud.CloudSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.ICloudSearch;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: CloudSearchCore.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class k0 implements ICloudSearch {

    /* renamed from: a  reason: collision with root package name */
    private Context f9956a;

    /* renamed from: b  reason: collision with root package name */
    private CloudSearch.OnCloudSearchListener f9957b;

    /* renamed from: c  reason: collision with root package name */
    private CloudSearch.Query f9958c;

    /* renamed from: d  reason: collision with root package name */
    private int f9959d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap<Integer, CloudResult> f9960e;

    /* renamed from: f  reason: collision with root package name */
    private Handler f9961f;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: CloudSearchCore.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CloudSearch.Query f9962a;

        a(CloudSearch.Query query) {
            this.f9962a = query;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = u4.a().obtainMessage();
            try {
                try {
                    obtainMessage.arg1 = 12;
                    obtainMessage.what = 700;
                    u4.e eVar = new u4.e();
                    eVar.f10295b = k0.this.f9957b;
                    obtainMessage.obj = eVar;
                    eVar.f10294a = k0.this.e(this.f9962a);
                    obtainMessage.arg2 = 1000;
                } catch (AMapException e4) {
                    obtainMessage.arg2 = e4.getErrorCode();
                }
            } finally {
                k0.this.f9961f.sendMessage(obtainMessage);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: CloudSearchCore.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f9964a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f9965b;

        b(String str, String str2) {
            this.f9964a = str;
            this.f9965b = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = u4.a().obtainMessage();
            try {
                try {
                    obtainMessage.arg1 = 12;
                    obtainMessage.what = 701;
                    u4.d dVar = new u4.d();
                    dVar.f10293b = k0.this.f9957b;
                    obtainMessage.obj = dVar;
                    dVar.f10292a = k0.this.b(this.f9964a, this.f9965b);
                    obtainMessage.arg2 = 1000;
                } catch (AMapException e4) {
                    obtainMessage.arg2 = e4.getErrorCode();
                }
            } finally {
                k0.this.f9961f.sendMessage(obtainMessage);
            }
        }
    }

    public k0(Context context) throws AMapException {
        h1 a4 = cf.a(context, i4.a(false));
        if (a4.f9876a == cf.c.SuccessCode) {
            this.f9956a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f9961f = u4.a();
            return;
        }
        String str = a4.f9877b;
        throw new AMapException(str, 1, str, a4.f9876a.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CloudItemDetail b(String str, String str2) throws AMapException {
        if (str != null && !str.trim().equals("")) {
            if (str2 != null && !str2.trim().equals("")) {
                try {
                    return new g4(this.f9956a, new j(str, str2)).O();
                } catch (Throwable th) {
                    j4.i(th, "CloudSearch", "searchCloudDetail");
                    if (!(th instanceof AMapException)) {
                        th.printStackTrace();
                        return null;
                    }
                    throw th;
                }
            }
            throw new AMapException("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
        }
        throw new AMapException("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
    }

    private CloudResult c(int i4) {
        if (i(i4)) {
            return this.f9960e.get(Integer.valueOf(i4));
        }
        throw new IllegalArgumentException("page out of range");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v13, types: [com.amap.api.services.cloud.CloudResult] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    public CloudResult e(CloudSearch.Query query) throws AMapException {
        CloudResult cloudResult = null;
        try {
        } catch (Throwable th) {
            th = th;
        }
        if (j(query)) {
            if (!query.queryEquals(this.f9958c)) {
                this.f9959d = 0;
                this.f9958c = query.m33clone();
                HashMap<Integer, CloudResult> hashMap = this.f9960e;
                if (hashMap != null) {
                    hashMap.clear();
                }
            }
            ?? r12 = this.f9959d;
            try {
            } catch (Throwable th2) {
                th = th2;
                cloudResult = r12;
                j4.i(th, "CloudSearch", "searchCloud");
                if (!(th instanceof AMapException)) {
                    th.printStackTrace();
                    return cloudResult;
                }
                throw th;
            }
            if (r12 == 0) {
                CloudResult O = new h4(this.f9956a, query).O();
                g(O, query);
                r12 = O;
            } else {
                cloudResult = c(query.getPageNum());
                if (cloudResult == null) {
                    CloudResult O2 = new h4(this.f9956a, query).O();
                    this.f9960e.put(Integer.valueOf(query.getPageNum()), O2);
                    r12 = O2;
                }
                return cloudResult;
            }
            return r12;
        }
        throw new AMapException("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
    }

    private void g(CloudResult cloudResult, CloudSearch.Query query) {
        HashMap<Integer, CloudResult> hashMap = new HashMap<>();
        this.f9960e = hashMap;
        if (this.f9959d > 0) {
            hashMap.put(Integer.valueOf(query.getPageNum()), cloudResult);
        }
    }

    private boolean i(int i4) {
        return i4 <= this.f9959d && i4 > 0;
    }

    private static boolean j(CloudSearch.Query query) {
        if (query == null || j4.j(query.getTableID()) || query.getBound() == null) {
            return false;
        }
        if (query.getBound() != null && query.getBound().getShape().equals("Bound") && query.getBound().getCenter() == null) {
            return false;
        }
        if (query.getBound() != null && query.getBound().getShape().equals("Rectangle")) {
            LatLonPoint lowerLeft = query.getBound().getLowerLeft();
            LatLonPoint upperRight = query.getBound().getUpperRight();
            if (lowerLeft == null || upperRight == null || lowerLeft.getLatitude() >= upperRight.getLatitude() || lowerLeft.getLongitude() >= upperRight.getLongitude()) {
                return false;
            }
        }
        if (query.getBound() == null || !query.getBound().getShape().equals("Polygon")) {
            return true;
        }
        List<LatLonPoint> polyGonList = query.getBound().getPolyGonList();
        for (int i4 = 0; i4 < polyGonList.size(); i4++) {
            if (polyGonList.get(i4) == null) {
                return false;
            }
        }
        return true;
    }

    @Override // com.amap.api.services.interfaces.ICloudSearch
    public final void searchCloudAsyn(CloudSearch.Query query) {
        try {
            y.a().b(new a(query));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.ICloudSearch
    public final void searchCloudDetailAsyn(String str, String str2) {
        try {
            y.a().b(new b(str, str2));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.ICloudSearch
    public final void setOnCloudSearchListener(CloudSearch.OnCloudSearchListener onCloudSearchListener) {
        this.f9957b = onCloudSearchListener;
    }
}
