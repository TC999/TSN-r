package com.amap.api.services.share;

import android.content.Context;
import com.amap.api.col.p047s.ShareSearchCore;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.LatLonSharePoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.interfaces.IShareSearch;
import com.bxkj.competition.score.teacher.ScoreMenu;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
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

    /* renamed from: a */
    private IShareSearch f7919a;

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public interface OnShareSearchListener {
        void onBusRouteShareUrlSearched(String str, int i);

        void onDrivingRouteShareUrlSearched(String str, int i);

        void onLocationShareUrlSearched(String str, int i);

        void onNaviShareUrlSearched(String str, int i);

        void onPoiShareUrlSearched(String str, int i);

        void onWalkRouteShareUrlSearched(String str, int i);
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class ShareBusRouteQuery {

        /* renamed from: a */
        private ShareFromAndTo f7920a;

        /* renamed from: b */
        private int f7921b;

        public ShareBusRouteQuery(ShareFromAndTo shareFromAndTo, int i) {
            this.f7920a = shareFromAndTo;
            this.f7921b = i;
        }

        public int getBusMode() {
            return this.f7921b;
        }

        public ShareFromAndTo getShareFromAndTo() {
            return this.f7920a;
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class ShareDrivingRouteQuery {

        /* renamed from: a */
        private ShareFromAndTo f7922a;

        /* renamed from: b */
        private int f7923b;

        public ShareDrivingRouteQuery(ShareFromAndTo shareFromAndTo, int i) {
            this.f7922a = shareFromAndTo;
            this.f7923b = i;
        }

        public int getDrivingMode() {
            return this.f7923b;
        }

        public ShareFromAndTo getShareFromAndTo() {
            return this.f7922a;
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class ShareFromAndTo {

        /* renamed from: a */
        private LatLonPoint f7924a;

        /* renamed from: b */
        private LatLonPoint f7925b;

        /* renamed from: c */
        private String f7926c = ScoreMenu.START;

        /* renamed from: d */
        private String f7927d = "终点";

        public ShareFromAndTo(LatLonPoint latLonPoint, LatLonPoint latLonPoint2) {
            this.f7924a = latLonPoint;
            this.f7925b = latLonPoint2;
        }

        public LatLonPoint getFrom() {
            return this.f7924a;
        }

        public String getFromName() {
            return this.f7926c;
        }

        public LatLonPoint getTo() {
            return this.f7925b;
        }

        public String getToName() {
            return this.f7927d;
        }

        public void setFromName(String str) {
            this.f7926c = str;
        }

        public void setToName(String str) {
            this.f7927d = str;
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class ShareNaviQuery {

        /* renamed from: a */
        private ShareFromAndTo f7928a;

        /* renamed from: b */
        private int f7929b;

        public ShareNaviQuery(ShareFromAndTo shareFromAndTo, int i) {
            this.f7928a = shareFromAndTo;
            this.f7929b = i;
        }

        public ShareFromAndTo getFromAndTo() {
            return this.f7928a;
        }

        public int getNaviMode() {
            return this.f7929b;
        }
    }

    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class ShareWalkRouteQuery {

        /* renamed from: a */
        private ShareFromAndTo f7930a;

        /* renamed from: b */
        private int f7931b;

        public ShareWalkRouteQuery(ShareFromAndTo shareFromAndTo, int i) {
            this.f7930a = shareFromAndTo;
            this.f7931b = i;
        }

        public ShareFromAndTo getShareFromAndTo() {
            return this.f7930a;
        }

        public int getWalkMode() {
            return this.f7931b;
        }
    }

    public ShareSearch(Context context) throws AMapException {
        if (this.f7919a == null) {
            try {
                this.f7919a = new ShareSearchCore(context);
            } catch (Exception e) {
                e.printStackTrace();
                if (e instanceof AMapException) {
                    throw ((AMapException) e);
                }
            }
        }
    }

    public String searchBusRouteShareUrl(ShareBusRouteQuery shareBusRouteQuery) throws AMapException {
        IShareSearch iShareSearch = this.f7919a;
        if (iShareSearch != null) {
            iShareSearch.searchBusRouteShareUrl(shareBusRouteQuery);
            return null;
        }
        return null;
    }

    public void searchBusRouteShareUrlAsyn(ShareBusRouteQuery shareBusRouteQuery) {
        IShareSearch iShareSearch = this.f7919a;
        if (iShareSearch != null) {
            iShareSearch.searchBusRouteShareUrlAsyn(shareBusRouteQuery);
        }
    }

    public String searchDrivingRouteShareUrl(ShareDrivingRouteQuery shareDrivingRouteQuery) throws AMapException {
        IShareSearch iShareSearch = this.f7919a;
        if (iShareSearch != null) {
            iShareSearch.searchDrivingRouteShareUrl(shareDrivingRouteQuery);
            return null;
        }
        return null;
    }

    public void searchDrivingRouteShareUrlAsyn(ShareDrivingRouteQuery shareDrivingRouteQuery) {
        IShareSearch iShareSearch = this.f7919a;
        if (iShareSearch != null) {
            iShareSearch.searchDrivingRouteShareUrlAsyn(shareDrivingRouteQuery);
        }
    }

    public String searchLocationShareUrl(LatLonSharePoint latLonSharePoint) throws AMapException {
        IShareSearch iShareSearch = this.f7919a;
        if (iShareSearch != null) {
            iShareSearch.searchLocationShareUrl(latLonSharePoint);
            return null;
        }
        return null;
    }

    public void searchLocationShareUrlAsyn(LatLonSharePoint latLonSharePoint) {
        IShareSearch iShareSearch = this.f7919a;
        if (iShareSearch != null) {
            iShareSearch.searchLocationShareUrlAsyn(latLonSharePoint);
        }
    }

    public String searchNaviShareUrl(ShareNaviQuery shareNaviQuery) throws AMapException {
        IShareSearch iShareSearch = this.f7919a;
        if (iShareSearch != null) {
            iShareSearch.searchNaviShareUrl(shareNaviQuery);
            return null;
        }
        return null;
    }

    public void searchNaviShareUrlAsyn(ShareNaviQuery shareNaviQuery) {
        IShareSearch iShareSearch = this.f7919a;
        if (iShareSearch != null) {
            iShareSearch.searchNaviShareUrlAsyn(shareNaviQuery);
        }
    }

    public String searchPoiShareUrl(PoiItem poiItem) throws AMapException {
        IShareSearch iShareSearch = this.f7919a;
        if (iShareSearch != null) {
            iShareSearch.searchPoiShareUrl(poiItem);
            return null;
        }
        return null;
    }

    public void searchPoiShareUrlAsyn(PoiItem poiItem) {
        IShareSearch iShareSearch = this.f7919a;
        if (iShareSearch != null) {
            iShareSearch.searchPoiShareUrlAsyn(poiItem);
        }
    }

    public String searchWalkRouteShareUrl(ShareWalkRouteQuery shareWalkRouteQuery) throws AMapException {
        IShareSearch iShareSearch = this.f7919a;
        if (iShareSearch != null) {
            iShareSearch.searchWalkRouteShareUrl(shareWalkRouteQuery);
            return null;
        }
        return null;
    }

    public void searchWalkRouteShareUrlAsyn(ShareWalkRouteQuery shareWalkRouteQuery) {
        IShareSearch iShareSearch = this.f7919a;
        if (iShareSearch != null) {
            iShareSearch.searchWalkRouteShareUrlAsyn(shareWalkRouteQuery);
        }
    }

    public void setOnShareSearchListener(OnShareSearchListener onShareSearchListener) {
        IShareSearch iShareSearch = this.f7919a;
        if (iShareSearch != null) {
            iShareSearch.setOnShareSearchListener(onShareSearchListener);
        }
    }
}
