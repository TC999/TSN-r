package com.amap.api.services.busline;

import android.content.Context;
import com.amap.api.col.s.i0;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.interfaces.IBusLineSearch;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class BusLineSearch {
    public static final String EXTENSIONS_ALL = "all";
    public static final String EXTENSIONS_BASE = "base";

    /* renamed from: a  reason: collision with root package name */
    private IBusLineSearch f10908a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public interface OnBusLineSearchListener {
        void onBusLineSearched(BusLineResult busLineResult, int i4);
    }

    public BusLineSearch(Context context, BusLineQuery busLineQuery) throws AMapException {
        this.f10908a = null;
        try {
            this.f10908a = new i0(context, busLineQuery);
        } catch (Exception e4) {
            e4.printStackTrace();
            if (e4 instanceof AMapException) {
                throw ((AMapException) e4);
            }
        }
    }

    public BusLineQuery getQuery() {
        IBusLineSearch iBusLineSearch = this.f10908a;
        if (iBusLineSearch != null) {
            return iBusLineSearch.getQuery();
        }
        return null;
    }

    public BusLineResult searchBusLine() throws AMapException {
        IBusLineSearch iBusLineSearch = this.f10908a;
        if (iBusLineSearch != null) {
            return iBusLineSearch.searchBusLine();
        }
        return null;
    }

    public void searchBusLineAsyn() {
        IBusLineSearch iBusLineSearch = this.f10908a;
        if (iBusLineSearch != null) {
            iBusLineSearch.searchBusLineAsyn();
        }
    }

    public void setOnBusLineSearchListener(OnBusLineSearchListener onBusLineSearchListener) {
        IBusLineSearch iBusLineSearch = this.f10908a;
        if (iBusLineSearch != null) {
            iBusLineSearch.setOnBusLineSearchListener(onBusLineSearchListener);
        }
    }

    public void setQuery(BusLineQuery busLineQuery) {
        IBusLineSearch iBusLineSearch = this.f10908a;
        if (iBusLineSearch != null) {
            iBusLineSearch.setQuery(busLineQuery);
        }
    }
}
