package com.amap.api.services.routepoisearch;

import android.content.Context;
import com.amap.api.col.s.s0;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IRoutePOISearch;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class RoutePOISearch {
    public static final int DrivingAvoidCongestion = 4;
    public static final int DrivingDefault = 0;
    public static final int DrivingNoExpressways = 3;
    public static final int DrivingNoHighAvoidCongestionSaveMoney = 9;
    public static final int DrivingNoHighWay = 6;
    public static final int DrivingNoHighWaySaveMoney = 7;
    public static final int DrivingSaveMoney = 1;
    public static final int DrivingSaveMoneyAvoidCongestion = 8;
    public static final int DrivingShortDistance = 2;

    /* renamed from: a  reason: collision with root package name */
    private IRoutePOISearch f11602a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface OnRoutePOISearchListener {
        void onRoutePoiSearched(RoutePOISearchResult routePOISearchResult, int i4);
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public enum RoutePOISearchType {
        TypeGasStation,
        TypeMaintenanceStation,
        TypeATM,
        TypeToilet,
        TypeFillingStation,
        TypeServiceArea,
        TypeChargeStation,
        TypeFood,
        TypeHotel
    }

    public RoutePOISearch(Context context, RoutePOISearchQuery routePOISearchQuery) throws AMapException {
        if (this.f11602a == null) {
            try {
                this.f11602a = new s0(context, routePOISearchQuery);
            } catch (Exception e4) {
                e4.printStackTrace();
                if (e4 instanceof AMapException) {
                    throw ((AMapException) e4);
                }
            }
        }
    }

    public RoutePOISearchResult searchRoutePOI() throws AMapException {
        IRoutePOISearch iRoutePOISearch = this.f11602a;
        if (iRoutePOISearch != null) {
            return iRoutePOISearch.searchRoutePOI();
        }
        return null;
    }

    public void searchRoutePOIAsyn() {
        IRoutePOISearch iRoutePOISearch = this.f11602a;
        if (iRoutePOISearch != null) {
            iRoutePOISearch.searchRoutePOIAsyn();
        }
    }

    public void setPoiSearchListener(OnRoutePOISearchListener onRoutePOISearchListener) {
        IRoutePOISearch iRoutePOISearch = this.f11602a;
        if (iRoutePOISearch != null) {
            iRoutePOISearch.setRoutePOISearchListener(onRoutePOISearchListener);
        }
    }

    public void setQuery(RoutePOISearchQuery routePOISearchQuery) {
        IRoutePOISearch iRoutePOISearch = this.f11602a;
        if (iRoutePOISearch != null) {
            iRoutePOISearch.setQuery(routePOISearchQuery);
        }
    }
}
