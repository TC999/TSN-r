package com.amap.api.col.p047s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.routepoisearch.RoutePOIItem;
import com.amap.api.services.routepoisearch.RoutePOISearch;
import com.amap.api.services.routepoisearch.RoutePOISearchQuery;
import com.amap.api.services.routepoisearch.RoutePOISearchResult;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.s.u */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class RoutePOISearchHandler extends BasicLBSRestHandler<RoutePOISearchQuery, RoutePOISearchResult> {

    /* compiled from: RoutePOISearchHandler.java */
    /* renamed from: com.amap.api.col.s.u$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    static /* synthetic */ class C2155a {

        /* renamed from: a */
        static final /* synthetic */ int[] f6525a;

        static {
            int[] iArr = new int[RoutePOISearch.RoutePOISearchType.values().length];
            f6525a = iArr;
            try {
                iArr[RoutePOISearch.RoutePOISearchType.TypeGasStation.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6525a[RoutePOISearch.RoutePOISearchType.TypeMaintenanceStation.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6525a[RoutePOISearch.RoutePOISearchType.TypeATM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6525a[RoutePOISearch.RoutePOISearchType.TypeToilet.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6525a[RoutePOISearch.RoutePOISearchType.TypeFillingStation.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f6525a[RoutePOISearch.RoutePOISearchType.TypeServiceArea.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f6525a[RoutePOISearch.RoutePOISearchType.TypeChargeStation.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f6525a[RoutePOISearch.RoutePOISearchType.TypeFood.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f6525a[RoutePOISearch.RoutePOISearchType.TypeHotel.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public RoutePOISearchHandler(Context context, RoutePOISearchQuery routePOISearchQuery) {
        super(context, routePOISearchQuery);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler
    /* renamed from: U */
    public RoutePOISearchResult mo52183I(String str) throws AMapException {
        ArrayList<RoutePOIItem> arrayList = new ArrayList<>();
        try {
            arrayList = JSONHelper.m52481w0(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new RoutePOISearchResult(arrayList, (RoutePOISearchQuery) this.f5880n);
    }

    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler
    /* renamed from: M */
    protected final String mo52182M() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(C2199x0.m52327i(this.f5883q));
        stringBuffer.append("&range=");
        StringBuilder sb = new StringBuilder();
        sb.append(((RoutePOISearchQuery) this.f5880n).getRange());
        stringBuffer.append(sb.toString());
        String str = "";
        try {
            switch (C2155a.f6525a[((RoutePOISearchQuery) this.f5880n).getSearchType().ordinal()]) {
                case 1:
                    str = "010100";
                    break;
                case 2:
                    str = "030000";
                    break;
                case 3:
                    str = "160300";
                    break;
                case 4:
                    str = "200300";
                    break;
                case 5:
                    str = "010300";
                    break;
                case 6:
                    str = "180300";
                    break;
                case 7:
                    str = "011100";
                    break;
                case 8:
                    str = "050000";
                    break;
                case 9:
                    str = "100000";
                    break;
            }
        } catch (Exception unused) {
        }
        if (((RoutePOISearchQuery) this.f5880n).getPolylines() != null && ((RoutePOISearchQuery) this.f5880n).getPolylines().size() > 0) {
            stringBuffer.append("&polyline=");
            stringBuffer.append(C2082j4.m52828f(((RoutePOISearchQuery) this.f5880n).getPolylines()));
        } else {
            stringBuffer.append("&origin=");
            stringBuffer.append(C2082j4.m52830d(((RoutePOISearchQuery) this.f5880n).getFrom()));
            stringBuffer.append("&destination=");
            stringBuffer.append(C2082j4.m52830d(((RoutePOISearchQuery) this.f5880n).getTo()));
            stringBuffer.append("&strategy=");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(((RoutePOISearchQuery) this.f5880n).getMode());
            stringBuffer.append(sb2.toString());
        }
        String channel = ((RoutePOISearchQuery) this.f5880n).getChannel();
        if (!TextUtils.isEmpty(channel)) {
            stringBuffer.append("&channel=");
            stringBuffer.append(channel);
        }
        stringBuffer.append("&types=");
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: h */
    public final String mo52180h() {
        return C2077i4.m52894b() + "/place/route?";
    }
}
