package com.amap.api.col.p047s;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.amap.api.col.p047s.C2033cf;
import com.amap.api.col.p047s.MessageHandler;
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

/* renamed from: com.amap.api.col.s.p0 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class NearbySearchCore implements INearbySearch {

    /* renamed from: l */
    private static long f6338l;

    /* renamed from: b */
    private String f6340b;

    /* renamed from: c */
    private Context f6341c;

    /* renamed from: d */
    private MessageHandler f6342d;

    /* renamed from: e */
    private ExecutorService f6343e;

    /* renamed from: j */
    private UploadInfoCallback f6348j;

    /* renamed from: k */
    private TimerTask f6349k;

    /* renamed from: a */
    private List<NearbySearch.NearbyListener> f6339a = new ArrayList();

    /* renamed from: f */
    private LatLonPoint f6344f = null;

    /* renamed from: g */
    private String f6345g = null;

    /* renamed from: h */
    private boolean f6346h = false;

    /* renamed from: i */
    private Timer f6347i = new Timer();

    /* compiled from: NearbySearchCore.java */
    /* renamed from: com.amap.api.col.s.p0$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class RunnableC2111a implements Runnable {
        RunnableC2111a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = NearbySearchCore.this.f6342d.obtainMessage();
            obtainMessage.arg1 = 8;
            obtainMessage.obj = NearbySearchCore.this.f6339a;
            try {
                try {
                    NearbySearchCore.this.m52705a();
                    obtainMessage.what = 1000;
                    if (NearbySearchCore.this.f6342d == null) {
                        return;
                    }
                } catch (AMapException e) {
                    obtainMessage.what = e.getErrorCode();
                    C2082j4.m52825i(e, "NearbySearch", "clearUserInfoAsyn");
                    if (NearbySearchCore.this.f6342d == null) {
                        return;
                    }
                }
                NearbySearchCore.this.f6342d.sendMessage(obtainMessage);
            } catch (Throwable th) {
                if (NearbySearchCore.this.f6342d != null) {
                    NearbySearchCore.this.f6342d.sendMessage(obtainMessage);
                }
                throw th;
            }
        }
    }

    /* compiled from: NearbySearchCore.java */
    /* renamed from: com.amap.api.col.s.p0$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class RunnableC2112b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ UploadInfo f6351a;

        RunnableC2112b(UploadInfo uploadInfo) {
            this.f6351a = uploadInfo;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                Message obtainMessage = NearbySearchCore.this.f6342d.obtainMessage();
                obtainMessage.arg1 = 10;
                obtainMessage.obj = NearbySearchCore.this.f6339a;
                obtainMessage.what = NearbySearchCore.this.m52703c(this.f6351a);
                NearbySearchCore.this.f6342d.sendMessage(obtainMessage);
            } catch (Throwable th) {
                C2082j4.m52825i(th, "NearbySearch", "uploadNearbyInfoAsyn");
            }
        }
    }

    /* compiled from: NearbySearchCore.java */
    /* renamed from: com.amap.api.col.s.p0$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class RunnableC2113c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ NearbySearch.NearbyQuery f6353a;

        RunnableC2113c(NearbySearch.NearbyQuery nearbyQuery) {
            this.f6353a = nearbyQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = NearbySearchCore.this.f6342d.obtainMessage();
            obtainMessage.arg1 = 9;
            MessageHandler.C2172g c2172g = new MessageHandler.C2172g();
            c2172g.f6570a = NearbySearchCore.this.f6339a;
            obtainMessage.obj = c2172g;
            try {
                try {
                    c2172g.f6571b = NearbySearchCore.this.searchNearbyInfo(this.f6353a);
                    obtainMessage.what = 1000;
                    if (NearbySearchCore.this.f6342d == null) {
                        return;
                    }
                } catch (AMapException e) {
                    obtainMessage.what = e.getErrorCode();
                    C2082j4.m52825i(e, "NearbySearch", "searchNearbyInfoAsyn");
                    if (NearbySearchCore.this.f6342d == null) {
                        return;
                    }
                }
                NearbySearchCore.this.f6342d.sendMessage(obtainMessage);
            } catch (Throwable th) {
                if (NearbySearchCore.this.f6342d != null) {
                    NearbySearchCore.this.f6342d.sendMessage(obtainMessage);
                }
                throw th;
            }
        }
    }

    /* compiled from: NearbySearchCore.java */
    /* renamed from: com.amap.api.col.s.p0$d */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    private class C2114d extends TimerTask {
        private C2114d() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            try {
                if (NearbySearchCore.this.f6348j != null) {
                    int m52698h = NearbySearchCore.this.m52698h(NearbySearchCore.this.f6348j.OnUploadInfoCallback());
                    Message obtainMessage = NearbySearchCore.this.f6342d.obtainMessage();
                    obtainMessage.arg1 = 10;
                    obtainMessage.obj = NearbySearchCore.this.f6339a;
                    obtainMessage.what = m52698h;
                    NearbySearchCore.this.f6342d.sendMessage(obtainMessage);
                }
            } catch (Throwable th) {
                C2082j4.m52825i(th, "NearbySearch", "UpdateDataTask");
            }
        }

        /* synthetic */ C2114d(NearbySearchCore nearbySearchCore, byte b) {
            this();
        }
    }

    public NearbySearchCore(Context context) throws AMapException {
        C2066h1 m53127a = C2033cf.m53127a(context, C2077i4.m52895a(false));
        if (m53127a.f6148a == C2033cf.EnumC2036c.SuccessCode) {
            this.f6341c = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f6342d = MessageHandler.m52418a();
            return;
        }
        String str = m53127a.f6149b;
        throw new AMapException(str, 1, str, m53127a.f6148a.m53102a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public int m52705a() throws AMapException {
        try {
            if (!this.f6346h) {
                if (m52700f(this.f6340b)) {
                    ManifestConfig.m52460d(this.f6341c);
                    return new NearbyDeleteHandler(this.f6341c, this.f6340b).m53251O().intValue();
                }
                throw new AMapException(AMapException.AMAP_CLIENT_USERID_ILLEGAL);
            }
            throw new AMapException(AMapException.AMAP_CLIENT_UPLOADAUTO_STARTED_ERROR);
        } catch (AMapException e) {
            throw e;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public int m52703c(UploadInfo uploadInfo) {
        return this.f6346h ? AMapException.CODE_AMAP_CLIENT_UPLOADAUTO_STARTED_ERROR : m52698h(uploadInfo);
    }

    /* renamed from: e */
    private static boolean m52701e(NearbySearch.NearbyQuery nearbyQuery) {
        return (nearbyQuery == null || nearbyQuery.getCenterPoint() == null) ? false : true;
    }

    /* renamed from: f */
    private static boolean m52700f(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("^[a-z0-9A-Z_-]{1,32}$").matcher(str).find();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public int m52698h(UploadInfo uploadInfo) {
        try {
            ManifestConfig.m52460d(this.f6341c);
            if (uploadInfo == null) {
                return AMapException.CODE_AMAP_CLIENT_NEARBY_NULL_RESULT;
            }
            long time = new Date().getTime();
            if (time - f6338l < 6500) {
                return AMapException.CODE_AMAP_CLIENT_UPLOAD_TOO_FREQUENT;
            }
            f6338l = time;
            String userID = uploadInfo.getUserID();
            if (m52700f(userID)) {
                if (TextUtils.isEmpty(this.f6345g)) {
                    this.f6345g = userID;
                }
                if (userID.equals(this.f6345g)) {
                    LatLonPoint point = uploadInfo.getPoint();
                    if (point != null && !point.equals(this.f6344f)) {
                        new NearbyUpdateHandler(this.f6341c, uploadInfo).m53251O();
                        this.f6344f = point.copy();
                        return 1000;
                    }
                    return AMapException.CODE_AMAP_CLIENT_UPLOAD_LOCATION_ERROR;
                }
                return AMapException.CODE_AMAP_CLIENT_USERID_ILLEGAL;
            }
            return AMapException.CODE_AMAP_CLIENT_USERID_ILLEGAL;
        } catch (AMapException e) {
            return e.getErrorCode();
        } catch (Throwable unused) {
            return 1900;
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final synchronized void addNearbyListener(NearbySearch.NearbyListener nearbyListener) {
        try {
            this.f6339a.add(nearbyListener);
        } catch (Throwable th) {
            C2082j4.m52825i(th, "NearbySearch", "addNearbyListener");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final void clearUserInfoAsyn() {
        try {
            ThreadPoolExecutorUtil.m52255a().m52254b(new RunnableC2111a());
        } catch (Throwable th) {
            C2082j4.m52825i(th, "NearbySearch", "clearUserInfoAsynThrowable");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final synchronized void destroy() {
        try {
            this.f6347i.cancel();
        } catch (Throwable th) {
            C2082j4.m52825i(th, "NearbySearch", "destryoy");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final synchronized void removeNearbyListener(NearbySearch.NearbyListener nearbyListener) {
        if (nearbyListener == null) {
            return;
        }
        try {
            this.f6339a.remove(nearbyListener);
        } catch (Throwable th) {
            C2082j4.m52825i(th, "NearbySearch", "removeNearbyListener");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final NearbySearchResult searchNearbyInfo(NearbySearch.NearbyQuery nearbyQuery) throws AMapException {
        try {
            ManifestConfig.m52460d(this.f6341c);
            if (m52701e(nearbyQuery)) {
                return new NearbySearchHandler(this.f6341c, nearbyQuery).m53251O();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            throw e;
        } catch (Throwable th) {
            C2082j4.m52825i(th, "NearbySearch", "searchNearbyInfo");
            throw new AMapException(AMapException.AMAP_CLIENT_UNKNOWN_ERROR);
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final void searchNearbyInfoAsyn(NearbySearch.NearbyQuery nearbyQuery) {
        try {
            ThreadPoolExecutorUtil.m52255a().m52254b(new RunnableC2113c(nearbyQuery));
        } catch (Throwable th) {
            C2082j4.m52825i(th, "NearbySearch", "searchNearbyInfoAsynThrowable");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final void setUserID(String str) {
        this.f6340b = str;
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final synchronized void startUploadNearbyInfoAuto(UploadInfoCallback uploadInfoCallback, int i) {
        TimerTask timerTask;
        if (i < 7000) {
            i = 7000;
        }
        try {
            this.f6348j = uploadInfoCallback;
            if (this.f6346h && (timerTask = this.f6349k) != null) {
                timerTask.cancel();
            }
            this.f6346h = true;
            C2114d c2114d = new C2114d(this, (byte) 0);
            this.f6349k = c2114d;
            this.f6347i.schedule(c2114d, 0L, i);
        } catch (Throwable th) {
            C2082j4.m52825i(th, "NearbySearch", "startUploadNearbyInfoAuto");
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final synchronized void stopUploadNearbyInfoAuto() {
        try {
            TimerTask timerTask = this.f6349k;
            if (timerTask != null) {
                timerTask.cancel();
            }
            this.f6346h = false;
            this.f6349k = null;
        }
    }

    @Override // com.amap.api.services.interfaces.INearbySearch
    public final void uploadNearbyInfoAsyn(UploadInfo uploadInfo) {
        if (this.f6343e == null) {
            this.f6343e = Executors.newSingleThreadExecutor();
        }
        this.f6343e.submit(new RunnableC2112b(uploadInfo));
    }
}
