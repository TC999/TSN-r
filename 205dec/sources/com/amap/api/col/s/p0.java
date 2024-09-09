package com.amap.api.col.s;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.amap.api.col.s.cf;
import com.amap.api.col.s.u4;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.INearbySearch;
import com.amap.api.services.nearby.NearbySearch;
import com.amap.api.services.nearby.NearbySearchResult;
import com.amap.api.services.nearby.UploadInfo;
import com.amap.api.services.nearby.UploadInfoCallback;
import com.stub.StubApp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: NearbySearchCore.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class p0 implements INearbySearch {

    /* renamed from: l  reason: collision with root package name */
    private static long f10066l;

    /* renamed from: b  reason: collision with root package name */
    private String f10068b;

    /* renamed from: c  reason: collision with root package name */
    private Context f10069c;

    /* renamed from: d  reason: collision with root package name */
    private u4 f10070d;

    /* renamed from: e  reason: collision with root package name */
    private ExecutorService f10071e;

    /* renamed from: j  reason: collision with root package name */
    private UploadInfoCallback f10076j;

    /* renamed from: k  reason: collision with root package name */
    private TimerTask f10077k;

    /* renamed from: a  reason: collision with root package name */
    private List<NearbySearch.NearbyListener> f10067a = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private LatLonPoint f10072f = null;

    /* renamed from: g  reason: collision with root package name */
    private String f10073g = null;

    /* renamed from: h  reason: collision with root package name */
    private boolean f10074h = false;

    /* renamed from: i  reason: collision with root package name */
    private Timer f10075i = new Timer();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: NearbySearchCore.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = p0.this.f10070d.obtainMessage();
            obtainMessage.arg1 = 8;
            obtainMessage.obj = p0.this.f10067a;
            try {
                try {
                    p0.this.a();
                    obtainMessage.what = 1000;
                    if (p0.this.f10070d == null) {
                        return;
                    }
                } catch (AMapException e4) {
                    obtainMessage.what = e4.getErrorCode();
                    j4.i(e4, "NearbySearch", "clearUserInfoAsyn");
                    if (p0.this.f10070d == null) {
                        return;
                    }
                }
                p0.this.f10070d.sendMessage(obtainMessage);
            } catch (Throwable th) {
                if (p0.this.f10070d != null) {
                    p0.this.f10070d.sendMessage(obtainMessage);
                }
                throw th;
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: NearbySearchCore.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ UploadInfo f10079a;

        b(UploadInfo uploadInfo) {
            this.f10079a = uploadInfo;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                Message obtainMessage = p0.this.f10070d.obtainMessage();
                obtainMessage.arg1 = 10;
                obtainMessage.obj = p0.this.f10067a;
                obtainMessage.what = p0.this.c(this.f10079a);
                p0.this.f10070d.sendMessage(obtainMessage);
            } catch (Throwable th) {
                j4.i(th, "NearbySearch", "uploadNearbyInfoAsyn");
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: NearbySearchCore.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ NearbySearch.NearbyQuery f10081a;

        c(NearbySearch.NearbyQuery nearbyQuery) {
            this.f10081a = nearbyQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = p0.this.f10070d.obtainMessage();
            obtainMessage.arg1 = 9;
            u4.g gVar = new u4.g();
            gVar.f10298a = p0.this.f10067a;
            obtainMessage.obj = gVar;
            try {
                try {
                    gVar.f10299b = p0.this.searchNearbyInfo(this.f10081a);
                    obtainMessage.what = 1000;
                    if (p0.this.f10070d == null) {
                        return;
                    }
                } catch (AMapException e4) {
                    obtainMessage.what = e4.getErrorCode();
                    j4.i(e4, "NearbySearch", "searchNearbyInfoAsyn");
                    if (p0.this.f10070d == null) {
                        return;
                    }
                }
                p0.this.f10070d.sendMessage(obtainMessage);
            } catch (Throwable th) {
                if (p0.this.f10070d != null) {
                    p0.this.f10070d.sendMessage(obtainMessage);
                }
                throw th;
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: NearbySearchCore.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    private class d extends TimerTask {
        private d() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            try {
                if (p0.this.f10076j != null) {
                    int h4 = p0.this.h(p0.this.f10076j.OnUploadInfoCallback());
                    Message obtainMessage = p0.this.f10070d.obtainMessage();
                    obtainMessage.arg1 = 10;
                    obtainMessage.obj = p0.this.f10067a;
                    obtainMessage.what = h4;
                    p0.this.f10070d.sendMessage(obtainMessage);
                }
            } catch (Throwable th) {
                j4.i(th, "NearbySearch", "UpdateDataTask");
            }
        }

        /* synthetic */ d(p0 p0Var, byte b4) {
            this();
        }
    }

    public p0(Context context) throws AMapException {
        h1 a4 = cf.a(context, i4.a(false));
        if (a4.f9876a == cf.c.SuccessCode) {
            this.f10069c = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f10070d = u4.a();
            return;
        }
        String str = a4.f9877b;
        throw new AMapException(str, 1, str, a4.f9876a.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a() throws AMapException {
        try {
            if (!this.f10074h) {
                if (f(this.f10068b)) {
                    s4.d(this.f10069c);
                    return new v4(this.f10069c, this.f10068b).O().intValue();
                }
                throw new AMapException("USERID\u975e\u6cd5");
            }
            throw new AMapException("\u5df2\u5f00\u542f\u81ea\u52a8\u4e0a\u4f20");
        } catch (AMapException e4) {
            throw e4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int c(UploadInfo uploadInfo) {
        if (this.f10074h) {
            return 2200;
        }
        return h(uploadInfo);
    }

    private static boolean e(NearbySearch.NearbyQuery nearbyQuery) {
        return (nearbyQuery == null || nearbyQuery.getCenterPoint() == null) ? false : true;
    }

    private static boolean f(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("^[a-z0-9A-Z_-]{1,32}$").matcher(str).find();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int h(UploadInfo uploadInfo) {
        try {
            s4.d(this.f10069c);
            if (uploadInfo == null) {
                return 2202;
            }
            long time = new Date().getTime();
            if (time - f10066l < 6500) {
                return 2203;
            }
            f10066l = time;
            String userID = uploadInfo.getUserID();
            if (f(userID)) {
                if (TextUtils.isEmpty(this.f10073g)) {
                    this.f10073g = userID;
                }
                if (userID.equals(this.f10073g)) {
                    LatLonPoint point = uploadInfo.getPoint();
                    if (point != null && !point.equals(this.f10072f)) {
                        new com.amap.api.col.s.c(this.f10069c, uploadInfo).O();
                        this.f10072f = point.copy();
                        return 1000;
                    }
                    return 2204;
                }
                return 2201;
            }
            return 2201;
        } catch (AMapException e4) {
            return e4.getErrorCode();
        } catch (Throwable unused) {
            return 1900;
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final synchronized void addNearbyListener(NearbySearch.NearbyListener nearbyListener) {
        try {
            this.f10067a.add(nearbyListener);
        } catch (Throwable th) {
            j4.i(th, "NearbySearch", "addNearbyListener");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final void clearUserInfoAsyn() {
        try {
            y.a().b(new a());
        } catch (Throwable th) {
            j4.i(th, "NearbySearch", "clearUserInfoAsynThrowable");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final synchronized void destroy() {
        try {
            this.f10075i.cancel();
        } catch (Throwable th) {
            j4.i(th, "NearbySearch", "destryoy");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final synchronized void removeNearbyListener(NearbySearch.NearbyListener nearbyListener) {
        if (nearbyListener == null) {
            return;
        }
        try {
            this.f10067a.remove(nearbyListener);
        } catch (Throwable th) {
            j4.i(th, "NearbySearch", "removeNearbyListener");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final NearbySearchResult searchNearbyInfo(NearbySearch.NearbyQuery nearbyQuery) throws AMapException {
        try {
            s4.d(this.f10069c);
            if (e(nearbyQuery)) {
                return new com.amap.api.col.s.b(this.f10069c, nearbyQuery).O();
            }
            throw new AMapException("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
        } catch (AMapException e4) {
            throw e4;
        } catch (Throwable th) {
            j4.i(th, "NearbySearch", "searchNearbyInfo");
            throw new AMapException("\u672a\u77e5\u9519\u8bef");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final void searchNearbyInfoAsyn(NearbySearch.NearbyQuery nearbyQuery) {
        try {
            y.a().b(new c(nearbyQuery));
        } catch (Throwable th) {
            j4.i(th, "NearbySearch", "searchNearbyInfoAsynThrowable");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final void setUserID(String str) {
        this.f10068b = str;
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final synchronized void startUploadNearbyInfoAuto(UploadInfoCallback uploadInfoCallback, int i4) {
        TimerTask timerTask;
        if (i4 < 7000) {
            i4 = 7000;
        }
        try {
            this.f10076j = uploadInfoCallback;
            if (this.f10074h && (timerTask = this.f10077k) != null) {
                timerTask.cancel();
            }
            this.f10074h = true;
            d dVar = new d(this, (byte) 0);
            this.f10077k = dVar;
            this.f10075i.schedule(dVar, 0L, i4);
        } catch (Throwable th) {
            j4.i(th, "NearbySearch", "startUploadNearbyInfoAuto");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final synchronized void stopUploadNearbyInfoAuto() {
        try {
            TimerTask timerTask = this.f10077k;
            if (timerTask != null) {
                timerTask.cancel();
            }
            this.f10074h = false;
            this.f10077k = null;
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final void uploadNearbyInfoAsyn(UploadInfo uploadInfo) {
        if (this.f10071e == null) {
            this.f10071e = Executors.newSingleThreadExecutor();
        }
        this.f10071e.submit(new b(uploadInfo));
    }
}
