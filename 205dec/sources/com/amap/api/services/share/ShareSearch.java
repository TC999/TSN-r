package com.amap.api.services.share;

import android.content.Context;
import com.amap.api.col.s.v0;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.LatLonSharePoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.interfaces.IShareSearch;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class ShareSearch {
    public static final int BusComfortable = 4;
    public static final int BusDefault = 0;
    public static final int BusLeaseChange = 2;
    public static final int BusLeaseWalk = 3;
    public static final int BusNoSubway = 5;
    public static final int BusSaveMoney = 1;
    public static final int DrivingAvoidCongestion = 4;
    public static final int DrivingDefault = 0;
    public static final int DrivingNoHighWay = 3;
    public static final int DrivingNoHighWayAvoidCongestion = 6;
    public static final int DrivingNoHighWaySaveMoney = 5;
    public static final int DrivingNoHighWaySaveMoneyAvoidCongestion = 8;
    public static final int DrivingSaveMoney = 1;
    public static final int DrivingSaveMoneyAvoidCongestion = 7;
    public static final int DrivingShortDistance = 2;
    public static final int NaviAvoidCongestion = 4;
    public static final int NaviDefault = 0;
    public static final int NaviNoHighWay = 3;
    public static final int NaviNoHighWayAvoidCongestion = 6;
    public static final int NaviNoHighWaySaveMoney = 5;
    public static final int NaviNoHighWaySaveMoneyAvoidCongestion = 8;
    public static final int NaviSaveMoney = 1;
    public static final int NaviSaveMoneyAvoidCongestion = 7;
    public static final int NaviShortDistance = 2;

    /* renamed from: a  reason: collision with root package name */
    private IShareSearch f11613a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface OnShareSearchListener {
        void onBusRouteShareUrlSearched(String str, int i4);

        void onDrivingRouteShareUrlSearched(String str, int i4);

        void onLocationShareUrlSearched(String str, int i4);

        void onNaviShareUrlSearched(String str, int i4);

        void onPoiShareUrlSearched(String str, int i4);

        void onWalkRouteShareUrlSearched(String str, int i4);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class ShareBusRouteQuery {

        /* renamed from: a  reason: collision with root package name */
        private ShareFromAndTo f11614a;

        /* renamed from: b  reason: collision with root package name */
        private int f11615b;

        public ShareBusRouteQuery(ShareFromAndTo shareFromAndTo, int i4) {
            this.f11614a = shareFromAndTo;
            this.f11615b = i4;
        }

        public int getBusMode() {
            return this.f11615b;
        }

        public ShareFromAndTo getShareFromAndTo() {
            return this.f11614a;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class ShareDrivingRouteQuery {

        /* renamed from: a  reason: collision with root package name */
        private ShareFromAndTo f11616a;

        /* renamed from: b  reason: collision with root package name */
        private int f11617b;

        public ShareDrivingRouteQuery(ShareFromAndTo shareFromAndTo, int i4) {
            this.f11616a = shareFromAndTo;
            this.f11617b = i4;
        }

        public int getDrivingMode() {
            return this.f11617b;
        }

        public ShareFromAndTo getShareFromAndTo() {
            return this.f11616a;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class ShareFromAndTo {

        /* renamed from: a  reason: collision with root package name */
        private LatLonPoint f11618a;

        /* renamed from: b  reason: collision with root package name */
        private LatLonPoint f11619b;

        /* renamed from: c  reason: collision with root package name */
        private String f11620c = "\u8d77\u70b9";

        /* renamed from: d  reason: collision with root package name */
        private String f11621d = "\u7ec8\u70b9";

        public ShareFromAndTo(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f11618a = latLonPoint;
            this.f11619b = latLonPoint2;
        }

        public LatLonPoint getFrom() {
            return this.f11618a;
        }

        public String getFromName() {
            return this.f11620c;
        }

        public LatLonPoint getTo() {
            return this.f11619b;
        }

        public String getToName() {
            return this.f11621d;
        }

        public void setFromName(String str) {
            this.f11620c = str;
        }

        public void setToName(String str) {
            this.f11621d = str;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class ShareNaviQuery {

        /* renamed from: a  reason: collision with root package name */
        private ShareFromAndTo f11622a;

        /* renamed from: b  reason: collision with root package name */
        private int f11623b;

        public ShareNaviQuery(ShareFromAndTo shareFromAndTo, int i4) {
            this.f11622a = shareFromAndTo;
            this.f11623b = i4;
        }

        public ShareFromAndTo getFromAndTo() {
            return this.f11622a;
        }

        public int getNaviMode() {
            return this.f11623b;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class ShareWalkRouteQuery {

        /* renamed from: a  reason: collision with root package name */
        private ShareFromAndTo f11624a;

        /* renamed from: b  reason: collision with root package name */
        private int f11625b;

        public ShareWalkRouteQuery(ShareFromAndTo shareFromAndTo, int i4) {
            this.f11624a = shareFromAndTo;
            this.f11625b = i4;
        }

        public ShareFromAndTo getShareFromAndTo() {
            return this.f11624a;
        }

        public int getWalkMode() {
            return this.f11625b;
        }
    }

    public ShareSearch(Context context) throws AMapException {
        if (this.f11613a == null) {
            try {
                this.f11613a = new v0(context);
            } catch (Exception e4) {
                e4.printStackTrace();
                if (e4 instanceof AMapException) {
                    throw ((AMapException) e4);
                }
            }
        }
    }

    public String searchBusRouteShareUrl(ShareBusRouteQuery shareBusRouteQuery) throws AMapException {
        IShareSearch iShareSearch = this.f11613a;
        if (iShareSearch != null) {
            iShareSearch.searchBusRouteShareUrl(shareBusRouteQuery);
            return null;
        }
        return null;
    }

    public void searchBusRouteShareUrlAsyn(ShareBusRouteQuery shareBusRouteQuery) {
        IShareSearch iShareSearch = this.f11613a;
        if (iShareSearch != null) {
            iShareSearch.searchBusRouteShareUrlAsyn(shareBusRouteQuery);
        }
    }

    public String searchDrivingRouteShareUrl(ShareDrivingRouteQuery shareDrivingRouteQuery) throws AMapException {
        IShareSearch iShareSearch = this.f11613a;
        if (iShareSearch != null) {
            iShareSearch.searchDrivingRouteShareUrl(shareDrivingRouteQuery);
            return null;
        }
        return null;
    }

    public void searchDrivingRouteShareUrlAsyn(ShareDrivingRouteQuery shareDrivingRouteQuery) {
        IShareSearch iShareSearch = this.f11613a;
        if (iShareSearch != null) {
            iShareSearch.searchDrivingRouteShareUrlAsyn(shareDrivingRouteQuery);
        }
    }

    public String searchLocationShareUrl(LatLonSharePoint latLonSharePoint) throws AMapException {
        IShareSearch iShareSearch = this.f11613a;
        if (iShareSearch != null) {
            iShareSearch.searchLocationShareUrl(latLonSharePoint);
            return null;
        }
        return null;
    }

    public void searchLocationShareUrlAsyn(LatLonSharePoint latLonSharePoint) {
        IShareSearch iShareSearch = this.f11613a;
        if (iShareSearch != null) {
            iShareSearch.searchLocationShareUrlAsyn(latLonSharePoint);
        }
    }

    public String searchNaviShareUrl(ShareNaviQuery shareNaviQuery) throws AMapException {
        IShareSearch iShareSearch = this.f11613a;
        if (iShareSearch != null) {
            iShareSearch.searchNaviShareUrl(shareNaviQuery);
            return null;
        }
        return null;
    }

    public void searchNaviShareUrlAsyn(ShareNaviQuery shareNaviQuery) {
        IShareSearch iShareSearch = this.f11613a;
        if (iShareSearch != null) {
            iShareSearch.searchNaviShareUrlAsyn(shareNaviQuery);
        }
    }

    public String searchPoiShareUrl(PoiItem poiItem) throws AMapException {
        IShareSearch iShareSearch = this.f11613a;
        if (iShareSearch != null) {
            iShareSearch.searchPoiShareUrl(poiItem);
            return null;
        }
        return null;
    }

    public void searchPoiShareUrlAsyn(PoiItem poiItem) {
        IShareSearch iShareSearch = this.f11613a;
        if (iShareSearch != null) {
            iShareSearch.searchPoiShareUrlAsyn(poiItem);
        }
    }

    public String searchWalkRouteShareUrl(ShareWalkRouteQuery shareWalkRouteQuery) throws AMapException {
        IShareSearch iShareSearch = this.f11613a;
        if (iShareSearch != null) {
            iShareSearch.searchWalkRouteShareUrl(shareWalkRouteQuery);
            return null;
        }
        return null;
    }

    public void searchWalkRouteShareUrlAsyn(ShareWalkRouteQuery shareWalkRouteQuery) {
        IShareSearch iShareSearch = this.f11613a;
        if (iShareSearch != null) {
            iShareSearch.searchWalkRouteShareUrlAsyn(shareWalkRouteQuery);
        }
    }

    public void setOnShareSearchListener(OnShareSearchListener onShareSearchListener) {
        IShareSearch iShareSearch = this.f11613a;
        if (iShareSearch != null) {
            iShareSearch.setOnShareSearchListener(onShareSearchListener);
        }
    }
}
