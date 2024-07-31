package com.amap.api.col.p047s;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import com.amap.api.col.p047s.C2033cf;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.LatLonSharePoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.interfaces.IShareSearch;
import com.amap.api.services.share.ShareSearch;

/* renamed from: com.amap.api.col.s.v0 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class ShareSearchCore implements IShareSearch {

    /* renamed from: c */
    private static String f6589c = "http://wb.amap.com/?r=%f,%f,%s,%f,%f,%s,%d,%d,%d,%s,%s,%s&sourceapplication=openapi/0";

    /* renamed from: d */
    private static String f6590d = "http://wb.amap.com/?q=%f,%f,%s&sourceapplication=openapi/0";

    /* renamed from: e */
    private static String f6591e = "http://wb.amap.com/?n=%f,%f,%f,%f,%d&sourceapplication=openapi/0";

    /* renamed from: f */
    private static String f6592f = "http://wb.amap.com/?p=%s,%f,%f,%s,%s&sourceapplication=openapi/0";

    /* renamed from: g */
    private static final String f6593g = "";

    /* renamed from: a */
    private Context f6594a;

    /* renamed from: b */
    private ShareSearch.OnShareSearchListener f6595b;

    /* compiled from: ShareSearchCore.java */
    /* renamed from: com.amap.api.col.s.v0$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class RunnableC2181a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ PoiItem f6596a;

        RunnableC2181a(PoiItem poiItem) {
            this.f6596a = poiItem;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (ShareSearchCore.this.f6595b == null) {
                return;
            }
            Message obtainMessage = MessageHandler.m52418a().obtainMessage();
            obtainMessage.arg1 = 11;
            obtainMessage.what = 1100;
            obtainMessage.obj = ShareSearchCore.this.f6595b;
            try {
                try {
                    String searchPoiShareUrl = ShareSearchCore.this.searchPoiShareUrl(this.f6596a);
                    Bundle bundle = new Bundle();
                    bundle.putString("shareurlkey", searchPoiShareUrl);
                    obtainMessage.setData(bundle);
                    obtainMessage.arg2 = 1000;
                } catch (AMapException e) {
                    obtainMessage.arg2 = e.getErrorCode();
                }
            } finally {
                MessageHandler.m52418a().sendMessage(obtainMessage);
            }
        }
    }

    /* compiled from: ShareSearchCore.java */
    /* renamed from: com.amap.api.col.s.v0$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class RunnableC2182b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ ShareSearch.ShareBusRouteQuery f6598a;

        RunnableC2182b(ShareSearch.ShareBusRouteQuery shareBusRouteQuery) {
            this.f6598a = shareBusRouteQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (ShareSearchCore.this.f6595b == null) {
                return;
            }
            Message obtainMessage = MessageHandler.m52418a().obtainMessage();
            obtainMessage.arg1 = 11;
            obtainMessage.what = AMapException.CODE_AMAP_ENGINE_RETURN_TIMEOUT;
            obtainMessage.obj = ShareSearchCore.this.f6595b;
            try {
                try {
                    String searchBusRouteShareUrl = ShareSearchCore.this.searchBusRouteShareUrl(this.f6598a);
                    Bundle bundle = new Bundle();
                    bundle.putString("shareurlkey", searchBusRouteShareUrl);
                    obtainMessage.setData(bundle);
                    obtainMessage.arg2 = 1000;
                } catch (AMapException e) {
                    obtainMessage.arg2 = e.getErrorCode();
                }
            } finally {
                MessageHandler.m52418a().sendMessage(obtainMessage);
            }
        }
    }

    /* compiled from: ShareSearchCore.java */
    /* renamed from: com.amap.api.col.s.v0$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class RunnableC2183c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ ShareSearch.ShareWalkRouteQuery f6600a;

        RunnableC2183c(ShareSearch.ShareWalkRouteQuery shareWalkRouteQuery) {
            this.f6600a = shareWalkRouteQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (ShareSearchCore.this.f6595b == null) {
                return;
            }
            Message obtainMessage = MessageHandler.m52418a().obtainMessage();
            obtainMessage.arg1 = 11;
            obtainMessage.what = 1105;
            obtainMessage.obj = ShareSearchCore.this.f6595b;
            try {
                try {
                    String searchWalkRouteShareUrl = ShareSearchCore.this.searchWalkRouteShareUrl(this.f6600a);
                    Bundle bundle = new Bundle();
                    bundle.putString("shareurlkey", searchWalkRouteShareUrl);
                    obtainMessage.setData(bundle);
                    obtainMessage.arg2 = 1000;
                } catch (AMapException e) {
                    obtainMessage.arg2 = e.getErrorCode();
                }
            } finally {
                MessageHandler.m52418a().sendMessage(obtainMessage);
            }
        }
    }

    /* compiled from: ShareSearchCore.java */
    /* renamed from: com.amap.api.col.s.v0$d */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class RunnableC2184d implements Runnable {

        /* renamed from: a */
        final /* synthetic */ ShareSearch.ShareDrivingRouteQuery f6602a;

        RunnableC2184d(ShareSearch.ShareDrivingRouteQuery shareDrivingRouteQuery) {
            this.f6602a = shareDrivingRouteQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (ShareSearchCore.this.f6595b == null) {
                return;
            }
            Message obtainMessage = MessageHandler.m52418a().obtainMessage();
            obtainMessage.arg1 = 11;
            obtainMessage.what = 1104;
            obtainMessage.obj = ShareSearchCore.this.f6595b;
            try {
                try {
                    String searchDrivingRouteShareUrl = ShareSearchCore.this.searchDrivingRouteShareUrl(this.f6602a);
                    Bundle bundle = new Bundle();
                    bundle.putString("shareurlkey", searchDrivingRouteShareUrl);
                    obtainMessage.setData(bundle);
                    obtainMessage.arg2 = 1000;
                } catch (AMapException e) {
                    obtainMessage.arg2 = e.getErrorCode();
                }
            } finally {
                MessageHandler.m52418a().sendMessage(obtainMessage);
            }
        }
    }

    /* compiled from: ShareSearchCore.java */
    /* renamed from: com.amap.api.col.s.v0$e */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class RunnableC2185e implements Runnable {

        /* renamed from: a */
        final /* synthetic */ ShareSearch.ShareNaviQuery f6604a;

        RunnableC2185e(ShareSearch.ShareNaviQuery shareNaviQuery) {
            this.f6604a = shareNaviQuery;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (ShareSearchCore.this.f6595b == null) {
                return;
            }
            Message obtainMessage = MessageHandler.m52418a().obtainMessage();
            obtainMessage.arg1 = 11;
            obtainMessage.what = AMapException.CODE_AMAP_ENGINE_CONNECT_TIMEOUT;
            obtainMessage.obj = ShareSearchCore.this.f6595b;
            try {
                try {
                    String searchNaviShareUrl = ShareSearchCore.this.searchNaviShareUrl(this.f6604a);
                    Bundle bundle = new Bundle();
                    bundle.putString("shareurlkey", searchNaviShareUrl);
                    obtainMessage.setData(bundle);
                    obtainMessage.arg2 = 1000;
                } catch (AMapException e) {
                    obtainMessage.arg2 = e.getErrorCode();
                }
            } finally {
                MessageHandler.m52418a().sendMessage(obtainMessage);
            }
        }
    }

    /* compiled from: ShareSearchCore.java */
    /* renamed from: com.amap.api.col.s.v0$f */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    final class RunnableC2186f implements Runnable {

        /* renamed from: a */
        final /* synthetic */ LatLonSharePoint f6606a;

        RunnableC2186f(LatLonSharePoint latLonSharePoint) {
            this.f6606a = latLonSharePoint;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (ShareSearchCore.this.f6595b == null) {
                return;
            }
            Message obtainMessage = MessageHandler.m52418a().obtainMessage();
            obtainMessage.arg1 = 11;
            obtainMessage.what = AMapException.CODE_AMAP_ENGINE_RESPONSE_DATA_ERROR;
            obtainMessage.obj = ShareSearchCore.this.f6595b;
            try {
                try {
                    String searchLocationShareUrl = ShareSearchCore.this.searchLocationShareUrl(this.f6606a);
                    Bundle bundle = new Bundle();
                    bundle.putString("shareurlkey", searchLocationShareUrl);
                    obtainMessage.setData(bundle);
                    obtainMessage.arg2 = 1000;
                } catch (AMapException e) {
                    obtainMessage.arg2 = e.getErrorCode();
                }
            } finally {
                MessageHandler.m52418a().sendMessage(obtainMessage);
            }
        }
    }

    public ShareSearchCore(Context context) throws AMapException {
        C2066h1 m53127a = C2033cf.m53127a(context, C2077i4.m52895a(false));
        if (m53127a.f6148a == C2033cf.EnumC2036c.SuccessCode) {
            this.f6594a = context;
        } else {
            String str = m53127a.f6149b;
            throw new AMapException(str, 1, str, m53127a.f6148a.m53102a());
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
                    String str = f6589c;
                    String str2 = f6593g;
                    return new ShareUrlSearchHandler(this.f6594a, String.format(str, Double.valueOf(from.getLatitude()), Double.valueOf(from.getLongitude()), fromName, Double.valueOf(to.getLatitude()), Double.valueOf(to.getLongitude()), toName, Integer.valueOf(busMode), 1, 0, str2, str2, str2)).m53251O();
                }
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            C2082j4.m52825i(e, "ShareSearch", "searchBusRouteShareUrl");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchBusRouteShareUrlAsyn(ShareSearch.ShareBusRouteQuery shareBusRouteQuery) {
        try {
            ThreadPoolExecutorUtil.m52255a().m52254b(new RunnableC2182b(shareBusRouteQuery));
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
                    String str = f6589c;
                    String str2 = f6593g;
                    return new ShareUrlSearchHandler(this.f6594a, String.format(str, Double.valueOf(from.getLatitude()), Double.valueOf(from.getLongitude()), fromName, Double.valueOf(to.getLatitude()), Double.valueOf(to.getLongitude()), toName, Integer.valueOf(drivingMode), 0, 0, str2, str2, str2)).m53251O();
                }
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            C2082j4.m52825i(e, "ShareSearch", "searchDrivingRouteShareUrl");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchDrivingRouteShareUrlAsyn(ShareSearch.ShareDrivingRouteQuery shareDrivingRouteQuery) {
        try {
            ThreadPoolExecutorUtil.m52255a().m52254b(new RunnableC2184d(shareDrivingRouteQuery));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final String searchLocationShareUrl(LatLonSharePoint latLonSharePoint) throws AMapException {
        try {
            if (latLonSharePoint != null) {
                return new ShareUrlSearchHandler(this.f6594a, String.format(f6590d, Double.valueOf(latLonSharePoint.getLatitude()), Double.valueOf(latLonSharePoint.getLongitude()), latLonSharePoint.getSharePointName())).m53251O();
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            C2082j4.m52825i(e, "ShareSearch", "searchLocationShareUrl");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchLocationShareUrlAsyn(LatLonSharePoint latLonSharePoint) {
        try {
            ThreadPoolExecutorUtil.m52255a().m52254b(new RunnableC2186f(latLonSharePoint));
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
                        format = String.format(f6591e, null, null, Double.valueOf(to.getLatitude()), Double.valueOf(to.getLongitude()), Integer.valueOf(naviMode));
                    } else {
                        format = String.format(f6591e, Double.valueOf(from.getLatitude()), Double.valueOf(from.getLongitude()), Double.valueOf(to.getLatitude()), Double.valueOf(to.getLongitude()), Integer.valueOf(naviMode));
                    }
                    return new ShareUrlSearchHandler(this.f6594a, format).m53251O();
                }
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            C2082j4.m52825i(e, "ShareSearch", "searchNaviShareUrl");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchNaviShareUrlAsyn(ShareSearch.ShareNaviQuery shareNaviQuery) {
        try {
            ThreadPoolExecutorUtil.m52255a().m52254b(new RunnableC2185e(shareNaviQuery));
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
                    return new ShareUrlSearchHandler(this.f6594a, String.format(f6592f, poiItem.getPoiId(), Double.valueOf(latLonPoint.getLatitude()), Double.valueOf(latLonPoint.getLongitude()), poiItem.getTitle(), poiItem.getSnippet())).m53251O();
                }
            } catch (AMapException e) {
                C2082j4.m52825i(e, "ShareSearch", "searchPoiShareUrl");
                throw e;
            }
        }
        throw new AMapException("无效的参数 - IllegalArgumentException");
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchPoiShareUrlAsyn(PoiItem poiItem) {
        try {
            ThreadPoolExecutorUtil.m52255a().m52254b(new RunnableC2181a(poiItem));
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
                    String str = f6589c;
                    String str2 = f6593g;
                    return new ShareUrlSearchHandler(this.f6594a, String.format(str, Double.valueOf(from.getLatitude()), Double.valueOf(from.getLongitude()), fromName, Double.valueOf(to.getLatitude()), Double.valueOf(to.getLongitude()), toName, Integer.valueOf(walkMode), 2, 0, str2, str2, str2)).m53251O();
                }
                throw new AMapException("无效的参数 - IllegalArgumentException");
            }
            throw new AMapException("无效的参数 - IllegalArgumentException");
        } catch (AMapException e) {
            C2082j4.m52825i(e, "ShareSearch", "searchWalkRouteShareUrl");
            throw e;
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void searchWalkRouteShareUrlAsyn(ShareSearch.ShareWalkRouteQuery shareWalkRouteQuery) {
        try {
            ThreadPoolExecutorUtil.m52255a().m52254b(new RunnableC2183c(shareWalkRouteQuery));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.amap.api.services.interfaces.IShareSearch
    public final void setOnShareSearchListener(ShareSearch.OnShareSearchListener onShareSearchListener) {
        this.f6595b = onShareSearchListener;
    }
}
