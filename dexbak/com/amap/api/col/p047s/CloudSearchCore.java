package com.amap.api.col.p047s;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.amap.api.col.p047s.C2033cf;
import com.amap.api.col.p047s.MessageHandler;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.cloud.CloudResult;
import com.amap.api.services.cloud.CloudSearch;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.interfaces.ICloudSearch;
import com.stub.StubApp;
import java.util.HashMap;
import java.util.List;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/* renamed from: com.amap.api.col.s.k0 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class CloudSearchCore implements ICloudSearch {

    /* renamed from: a */
    private Context f6228a;

    /* renamed from: b */
    private CloudSearch.OnCloudSearchListener f6229b;

    /* renamed from: c */
    private CloudSearch.Query f6230c;

    /* renamed from: d */
    private int f6231d;

    /* renamed from: e */
    private HashMap<Integer, CloudResult> f6232e;

    /* renamed from: f */
    private Handler f6233f;

    /* compiled from: CloudSearchCore.java */
    /* renamed from: com.amap.api.col.s.k0$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class RunnableC2083a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ CloudSearch.Query f6234a;

        RunnableC2083a(CloudSearch.Query query) {
            this.f6234a = query;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = MessageHandler.m52418a().obtainMessage();
            try {
                try {
                    obtainMessage.arg1 = 12;
                    obtainMessage.what = 700;
                    MessageHandler.C2170e c2170e = new MessageHandler.C2170e();
                    c2170e.f6567b = CloudSearchCore.this.f6229b;
                    obtainMessage.obj = c2170e;
                    c2170e.f6566a = CloudSearchCore.this.m52814e(this.f6234a);
                    obtainMessage.arg2 = 1000;
                } catch (AMapException e) {
                    obtainMessage.arg2 = e.getErrorCode();
                }
            } finally {
                CloudSearchCore.this.f6233f.sendMessage(obtainMessage);
            }
        }
    }

    /* compiled from: CloudSearchCore.java */
    /* renamed from: com.amap.api.col.s.k0$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class RunnableC2084b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f6236a;

        /* renamed from: b */
        final /* synthetic */ String f6237b;

        RunnableC2084b(String str, String str2) {
            this.f6236a = str;
            this.f6237b = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Message obtainMessage = MessageHandler.m52418a().obtainMessage();
            try {
                try {
                    obtainMessage.arg1 = 12;
                    obtainMessage.what = IMediaPlayer.MEDIA_INFO_BUFFERING_START;
                    MessageHandler.C2169d c2169d = new MessageHandler.C2169d();
                    c2169d.f6565b = CloudSearchCore.this.f6229b;
                    obtainMessage.obj = c2169d;
                    c2169d.f6564a = CloudSearchCore.this.m52817b(this.f6236a, this.f6237b);
                    obtainMessage.arg2 = 1000;
                } catch (AMapException e) {
                    obtainMessage.arg2 = e.getErrorCode();
                }
            } finally {
                CloudSearchCore.this.f6233f.sendMessage(obtainMessage);
            }
        }
    }

    public CloudSearchCore(Context context) throws AMapException {
        C2066h1 m53127a = C2033cf.m53127a(context, C2077i4.m52895a(false));
        if (m53127a.f6148a == C2033cf.EnumC2036c.SuccessCode) {
            this.f6228a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            this.f6233f = MessageHandler.m52418a();
            return;
        }
        String str = m53127a.f6149b;
        throw new AMapException(str, 1, str, m53127a.f6148a.m53102a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public CloudItemDetail m52817b(String str, String str2) throws AMapException {
        if (str != null && !str.trim().equals("")) {
            if (str2 != null && !str2.trim().equals("")) {
                try {
                    return new CloudSearchIdHandler(this.f6228a, new QueryIDInternal(str, str2)).m53251O();
                } catch (Throwable th) {
                    C2082j4.m52825i(th, "CloudSearch", "searchCloudDetail");
                    if (!(th instanceof AMapException)) {
                        th.printStackTrace();
                        return null;
                    }
                    throw th;
                }
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    /* renamed from: c */
    private CloudResult m52816c(int i) {
        if (m52810i(i)) {
            return this.f6232e.get(Integer.valueOf(i));
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
    /* renamed from: e */
    public CloudResult m52814e(CloudSearch.Query query) throws AMapException {
        CloudResult cloudResult = null;
        try {
        } catch (Throwable th) {
            th = th;
        }
        if (m52809j(query)) {
            if (!query.queryEquals(this.f6230c)) {
                this.f6231d = 0;
                this.f6230c = query.m60112clone();
                HashMap<Integer, CloudResult> hashMap = this.f6232e;
                if (hashMap != null) {
                    hashMap.clear();
                }
            }
            ?? r1 = this.f6231d;
            try {
            } catch (Throwable th2) {
                th = th2;
                cloudResult = r1;
                C2082j4.m52825i(th, "CloudSearch", "searchCloud");
                if (!(th instanceof AMapException)) {
                    th.printStackTrace();
                    return cloudResult;
                }
                throw th;
            }
            if (r1 == 0) {
                CloudResult m53251O = new CloudSearchKeywordsHandler(this.f6228a, query).m53251O();
                m52812g(m53251O, query);
                r1 = m53251O;
            } else {
                cloudResult = m52816c(query.getPageNum());
                if (cloudResult == null) {
                    CloudResult m53251O2 = new CloudSearchKeywordsHandler(this.f6228a, query).m53251O();
                    this.f6232e.put(Integer.valueOf(query.getPageNum()), m53251O2);
                    r1 = m53251O2;
                }
                return cloudResult;
            }
            return r1;
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    /* renamed from: g */
    private void m52812g(CloudResult cloudResult, CloudSearch.Query query) {
        HashMap<Integer, CloudResult> hashMap = new HashMap<>();
        this.f6232e = hashMap;
        if (this.f6231d > 0) {
            hashMap.put(Integer.valueOf(query.getPageNum()), cloudResult);
        }
    }

    /* renamed from: i */
    private boolean m52810i(int i) {
        return i <= this.f6231d && i > 0;
    }

    /* renamed from: j */
    private static boolean m52809j(CloudSearch.Query query) {
        if (query == null || C2082j4.m52824j(query.getTableID()) || query.getBound() == null) {
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
        for (int i = 0; i < polyGonList.size(); i++) {
            if (polyGonList.get(i) == null) {
                return false;
            }
        }
        return true;
    }

    @Override // com.amap.api.services.interfaces.ICloudSearch
    public final void searchCloudAsyn(CloudSearch.Query query) {
        try {
            ThreadPoolExecutorUtil.m52255a().m52254b(new RunnableC2083a(query));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.ICloudSearch
    public final void searchCloudDetailAsyn(String str, String str2) {
        try {
            ThreadPoolExecutorUtil.m52255a().m52254b(new RunnableC2084b(str, str2));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.ICloudSearch
    public final void setOnCloudSearchListener(CloudSearch.OnCloudSearchListener onCloudSearchListener) {
        this.f6229b = onCloudSearchListener;
    }
}
