package com.amap.api.col.s;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import com.amap.api.col.s.cf;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.LatLonSharePoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.interfaces.IShareSearch;
import com.amap.api.services.share.ShareSearch;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: ShareSearchCore.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class v0 implements IShareSearch {

    /* renamed from: c  reason: collision with root package name */
    private static String f10317c = "http://wb.amap.com/?r=%f,%f,%s,%f,%f,%s,%d,%d,%d,%s,%s,%s&sourceapplication=openapi/0";

    /* renamed from: d  reason: collision with root package name */
    private static String f10318d = "http://wb.amap.com/?q=%f,%f,%s&sourceapplication=openapi/0";

    /* renamed from: e  reason: collision with root package name */
    private static String f10319e = "http://wb.amap.com/?n=%f,%f,%f,%f,%d&sourceapplication=openapi/0";

    /* renamed from: f  reason: collision with root package name */
    private static String f10320f = "http://wb.amap.com/?p=%s,%f,%f,%s,%s&sourceapplication=openapi/0";

    /* renamed from: g  reason: collision with root package name */
    private static final String f10321g = "";

    /* renamed from: a  reason: collision with root package name */
    private Context f10322a;

    /* renamed from: b  reason: collision with root package name */
    private ShareSearch.OnShareSearchListener f10323b;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: ShareSearchCore.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ PoiItem f10324a;

        a(PoiItem poiItem) {
            this.f10324a = poiItem;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (v0.this.f10323b == null) {
                return;
            }
            Message obtainMessage = u4.a().obtainMessage();
            obtainMessage.arg1 = 11;
            obtainMessage.what = 1100;
            obtainMessage.obj = v0.this.f10323b;
            try {
                try {
                    String searchPoiShareUrl = v0.this.searchPoiShareUrl(this.f10324a);
                    Bundle bundle = new Bundle();
                    bundle.putString("shareurlkey", searchPoiShareUrl);
                    obtainMessage.setData(bundle);
                    obtainMessage.arg2 = 1000;
                } catch (AMapException e4) {
                    obtainMessage.arg2 = e4.getErrorCode();
                }
            } finally {
                u4.a().sendMessage(obtainMessage);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: ShareSearchCore.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ShareSearch.ShareBusRouteQuery f10326a;

        b(ShareSearch.ShareBusRouteQuery shareBusRouteQuery) {
            this.f10326a = shareBusRouteQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (v0.this.f10323b == null) {
                return;
            }
            Message obtainMessage = u4.a().obtainMessage();
            obtainMessage.arg1 = 11;
            obtainMessage.what = 1103;
            obtainMessage.obj = v0.this.f10323b;
            try {
                try {
                    String searchBusRouteShareUrl = v0.this.searchBusRouteShareUrl(this.f10326a);
                    Bundle bundle = new Bundle();
                    bundle.putString("shareurlkey", searchBusRouteShareUrl);
                    obtainMessage.setData(bundle);
                    obtainMessage.arg2 = 1000;
                } catch (AMapException e4) {
                    obtainMessage.arg2 = e4.getErrorCode();
                }
            } finally {
                u4.a().sendMessage(obtainMessage);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: ShareSearchCore.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ShareSearch.ShareWalkRouteQuery f10328a;

        c(ShareSearch.ShareWalkRouteQuery shareWalkRouteQuery) {
            this.f10328a = shareWalkRouteQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (v0.this.f10323b == null) {
                return;
            }
            Message obtainMessage = u4.a().obtainMessage();
            obtainMessage.arg1 = 11;
            obtainMessage.what = 1105;
            obtainMessage.obj = v0.this.f10323b;
            try {
                try {
                    String searchWalkRouteShareUrl = v0.this.searchWalkRouteShareUrl(this.f10328a);
                    Bundle bundle = new Bundle();
                    bundle.putString("shareurlkey", searchWalkRouteShareUrl);
                    obtainMessage.setData(bundle);
                    obtainMessage.arg2 = 1000;
                } catch (AMapException e4) {
                    obtainMessage.arg2 = e4.getErrorCode();
                }
            } finally {
                u4.a().sendMessage(obtainMessage);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: ShareSearchCore.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ShareSearch.ShareDrivingRouteQuery f10330a;

        d(ShareSearch.ShareDrivingRouteQuery shareDrivingRouteQuery) {
            this.f10330a = shareDrivingRouteQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (v0.this.f10323b == null) {
                return;
            }
            Message obtainMessage = u4.a().obtainMessage();
            obtainMessage.arg1 = 11;
            obtainMessage.what = 1104;
            obtainMessage.obj = v0.this.f10323b;
            try {
                try {
                    String searchDrivingRouteShareUrl = v0.this.searchDrivingRouteShareUrl(this.f10330a);
                    Bundle bundle = new Bundle();
                    bundle.putString("shareurlkey", searchDrivingRouteShareUrl);
                    obtainMessage.setData(bundle);
                    obtainMessage.arg2 = 1000;
                } catch (AMapException e4) {
                    obtainMessage.arg2 = e4.getErrorCode();
                }
            } finally {
                u4.a().sendMessage(obtainMessage);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: ShareSearchCore.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ShareSearch.ShareNaviQuery f10332a;

        e(ShareSearch.ShareNaviQuery shareNaviQuery) {
            this.f10332a = shareNaviQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (v0.this.f10323b == null) {
                return;
            }
            Message obtainMessage = u4.a().obtainMessage();
            obtainMessage.arg1 = 11;
            obtainMessage.what = 1102;
            obtainMessage.obj = v0.this.f10323b;
            try {
                try {
                    String searchNaviShareUrl = v0.this.searchNaviShareUrl(this.f10332a);
                    Bundle bundle = new Bundle();
                    bundle.putString("shareurlkey", searchNaviShareUrl);
                    obtainMessage.setData(bundle);
                    obtainMessage.arg2 = 1000;
                } catch (AMapException e4) {
                    obtainMessage.arg2 = e4.getErrorCode();
                }
            } finally {
                u4.a().sendMessage(obtainMessage);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: ShareSearchCore.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LatLonSharePoint f10334a;

        f(LatLonSharePoint latLonSharePoint) {
            this.f10334a = latLonSharePoint;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (v0.this.f10323b == null) {
                return;
            }
            Message obtainMessage = u4.a().obtainMessage();
            obtainMessage.arg1 = 11;
            obtainMessage.what = 1101;
            obtainMessage.obj = v0.this.f10323b;
            try {
                try {
                    String searchLocationShareUrl = v0.this.searchLocationShareUrl(this.f10334a);
                    Bundle bundle = new Bundle();
                    bundle.putString("shareurlkey", searchLocationShareUrl);
                    obtainMessage.setData(bundle);
                    obtainMessage.arg2 = 1000;
                } catch (AMapException e4) {
                    obtainMessage.arg2 = e4.getErrorCode();
                }
            } finally {
                u4.a().sendMessage(obtainMessage);
            }
        }
    }

    public v0(Context context) throws AMapException {
        h1 a4 = cf.a(context, i4.a(false));
        if (a4.f9876a == cf.c.SuccessCode) {
            this.f10322a = context;
        } else {
            String str = a4.f9877b;
            throw new AMapException(str, 1, str, a4.f9876a.a());
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final String searchBusRouteShareUrl(ShareSearch.ShareBusRouteQuery shareBusRouteQuery) throws AMapException {
        try {
            if (shareBusRouteQuery != null) {
                int busMode = shareBusRouteQuery.getBusMode();
                ShareSearch.ShareFromAndTo shareFromAndTo = shareBusRouteQuery.getShareFromAndTo();
                if (shareFromAndTo.getFrom() != null && shareFromAndTo.getTo() != null) {
                    LatLonPoint from = shareFromAndTo.getFrom();
                    LatLonPoint to = shareFromAndTo.getTo();
                    String fromName = shareFromAndTo.getFromName();
                    String toName = shareFromAndTo.getToName();
                    String str = f10317c;
                    String str2 = f10321g;
                    return new v(this.f10322a, String.format(str, Double.valueOf(from.getLatitude()), Double.valueOf(from.getLongitude()), fromName, Double.valueOf(to.getLatitude()), Double.valueOf(to.getLongitude()), toName, Integer.valueOf(busMode), 1, 0, str2, str2, str2)).O();
                }
                throw new AMapException("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
            }
            throw new AMapException("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
        } catch (AMapException e4) {
            j4.i(e4, "ShareSearch", "searchBusRouteShareUrl");
            throw e4;
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchBusRouteShareUrlAsyn(ShareSearch.ShareBusRouteQuery shareBusRouteQuery) {
        try {
            y.a().b(new b(shareBusRouteQuery));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final String searchDrivingRouteShareUrl(ShareSearch.ShareDrivingRouteQuery shareDrivingRouteQuery) throws AMapException {
        try {
            if (shareDrivingRouteQuery != null) {
                int drivingMode = shareDrivingRouteQuery.getDrivingMode();
                ShareSearch.ShareFromAndTo shareFromAndTo = shareDrivingRouteQuery.getShareFromAndTo();
                if (shareFromAndTo.getFrom() != null && shareFromAndTo.getTo() != null) {
                    LatLonPoint from = shareFromAndTo.getFrom();
                    LatLonPoint to = shareFromAndTo.getTo();
                    String fromName = shareFromAndTo.getFromName();
                    String toName = shareFromAndTo.getToName();
                    String str = f10317c;
                    String str2 = f10321g;
                    return new v(this.f10322a, String.format(str, Double.valueOf(from.getLatitude()), Double.valueOf(from.getLongitude()), fromName, Double.valueOf(to.getLatitude()), Double.valueOf(to.getLongitude()), toName, Integer.valueOf(drivingMode), 0, 0, str2, str2, str2)).O();
                }
                throw new AMapException("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
            }
            throw new AMapException("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
        } catch (AMapException e4) {
            j4.i(e4, "ShareSearch", "searchDrivingRouteShareUrl");
            throw e4;
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchDrivingRouteShareUrlAsyn(ShareSearch.ShareDrivingRouteQuery shareDrivingRouteQuery) {
        try {
            y.a().b(new d(shareDrivingRouteQuery));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final String searchLocationShareUrl(LatLonSharePoint latLonSharePoint) throws AMapException {
        try {
            if (latLonSharePoint != null) {
                return new v(this.f10322a, String.format(f10318d, Double.valueOf(latLonSharePoint.getLatitude()), Double.valueOf(latLonSharePoint.getLongitude()), latLonSharePoint.getSharePointName())).O();
            }
            throw new AMapException("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
        } catch (AMapException e4) {
            j4.i(e4, "ShareSearch", "searchLocationShareUrl");
            throw e4;
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchLocationShareUrlAsyn(LatLonSharePoint latLonSharePoint) {
        try {
            y.a().b(new f(latLonSharePoint));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final String searchNaviShareUrl(ShareSearch.ShareNaviQuery shareNaviQuery) throws AMapException {
        String format;
        try {
            if (shareNaviQuery != null) {
                ShareSearch.ShareFromAndTo fromAndTo = shareNaviQuery.getFromAndTo();
                if (fromAndTo.getTo() != null) {
                    LatLonPoint from = fromAndTo.getFrom();
                    LatLonPoint to = fromAndTo.getTo();
                    int naviMode = shareNaviQuery.getNaviMode();
                    if (fromAndTo.getFrom() == null) {
                        format = String.format(f10319e, null, null, Double.valueOf(to.getLatitude()), Double.valueOf(to.getLongitude()), Integer.valueOf(naviMode));
                    } else {
                        format = String.format(f10319e, Double.valueOf(from.getLatitude()), Double.valueOf(from.getLongitude()), Double.valueOf(to.getLatitude()), Double.valueOf(to.getLongitude()), Integer.valueOf(naviMode));
                    }
                    return new v(this.f10322a, format).O();
                }
                throw new AMapException("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
            }
            throw new AMapException("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
        } catch (AMapException e4) {
            j4.i(e4, "ShareSearch", "searchNaviShareUrl");
            throw e4;
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchNaviShareUrlAsyn(ShareSearch.ShareNaviQuery shareNaviQuery) {
        try {
            y.a().b(new e(shareNaviQuery));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final String searchPoiShareUrl(PoiItem poiItem) throws AMapException {
        if (poiItem != null) {
            try {
                if (poiItem.getLatLonPoint() != null) {
                    LatLonPoint latLonPoint = poiItem.getLatLonPoint();
                    return new v(this.f10322a, String.format(f10320f, poiItem.getPoiId(), Double.valueOf(latLonPoint.getLatitude()), Double.valueOf(latLonPoint.getLongitude()), poiItem.getTitle(), poiItem.getSnippet())).O();
                }
            } catch (AMapException e4) {
                j4.i(e4, "ShareSearch", "searchPoiShareUrl");
                throw e4;
            }
        }
        throw new AMapException("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchPoiShareUrlAsyn(PoiItem poiItem) {
        try {
            y.a().b(new a(poiItem));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final String searchWalkRouteShareUrl(ShareSearch.ShareWalkRouteQuery shareWalkRouteQuery) throws AMapException {
        try {
            if (shareWalkRouteQuery != null) {
                int walkMode = shareWalkRouteQuery.getWalkMode();
                ShareSearch.ShareFromAndTo shareFromAndTo = shareWalkRouteQuery.getShareFromAndTo();
                if (shareFromAndTo.getFrom() != null && shareFromAndTo.getTo() != null) {
                    LatLonPoint from = shareFromAndTo.getFrom();
                    LatLonPoint to = shareFromAndTo.getTo();
                    String fromName = shareFromAndTo.getFromName();
                    String toName = shareFromAndTo.getToName();
                    String str = f10317c;
                    String str2 = f10321g;
                    return new v(this.f10322a, String.format(str, Double.valueOf(from.getLatitude()), Double.valueOf(from.getLongitude()), fromName, Double.valueOf(to.getLatitude()), Double.valueOf(to.getLongitude()), toName, Integer.valueOf(walkMode), 2, 0, str2, str2, str2)).O();
                }
                throw new AMapException("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
            }
            throw new AMapException("\u65e0\u6548\u7684\u53c2\u6570 - IllegalArgumentException");
        } catch (AMapException e4) {
            j4.i(e4, "ShareSearch", "searchWalkRouteShareUrl");
            throw e4;
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchWalkRouteShareUrlAsyn(ShareSearch.ShareWalkRouteQuery shareWalkRouteQuery) {
        try {
            y.a().b(new c(shareWalkRouteQuery));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void setOnShareSearchListener(ShareSearch.OnShareSearchListener onShareSearchListener) {
        this.f10323b = onShareSearchListener;
    }
}
