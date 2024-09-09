package com.amap.api.col.s;

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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: RoutePOISearchHandler.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class u extends b4<RoutePOISearchQuery, RoutePOISearchResult> {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: RoutePOISearchHandler.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f10253a;

        static {
            int[] iArr = new int[RoutePOISearch.RoutePOISearchType.values().length];
            f10253a = iArr;
            try {
                iArr[RoutePOISearch.RoutePOISearchType.TypeGasStation.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10253a[RoutePOISearch.RoutePOISearchType.TypeMaintenanceStation.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10253a[RoutePOISearch.RoutePOISearchType.TypeATM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f10253a[RoutePOISearch.RoutePOISearchType.TypeToilet.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f10253a[RoutePOISearch.RoutePOISearchType.TypeFillingStation.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f10253a[RoutePOISearch.RoutePOISearchType.TypeServiceArea.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f10253a[RoutePOISearch.RoutePOISearchType.TypeChargeStation.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f10253a[RoutePOISearch.RoutePOISearchType.TypeFood.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f10253a[RoutePOISearch.RoutePOISearchType.TypeHotel.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public u(Context context, RoutePOISearchQuery routePOISearchQuery) {
        super(context, routePOISearchQuery);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    /* renamed from: U */
    public RoutePOISearchResult I(String str) throws AMapException {
        ArrayList<RoutePOIItem> arrayList = new ArrayList<>();
        try {
            arrayList = r4.w0(new JSONObject(str));
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return new RoutePOISearchResult(arrayList, (RoutePOISearchQuery) this.f9630n);
    }

    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    protected final String M() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(x0.i(this.f9633q));
        stringBuffer.append("&range=");
        StringBuilder sb = new StringBuilder();
        sb.append(((RoutePOISearchQuery) this.f9630n).getRange());
        stringBuffer.append(sb.toString());
        String str = "";
        try {
            switch (a.f10253a[((RoutePOISearchQuery) this.f9630n).getSearchType().ordinal()]) {
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
        if (((RoutePOISearchQuery) this.f9630n).getPolylines() != null && ((RoutePOISearchQuery) this.f9630n).getPolylines().size() > 0) {
            stringBuffer.append("&polyline=");
            stringBuffer.append(j4.f(((RoutePOISearchQuery) this.f9630n).getPolylines()));
        } else {
            stringBuffer.append("&origin=");
            stringBuffer.append(j4.d(((RoutePOISearchQuery) this.f9630n).getFrom()));
            stringBuffer.append("&destination=");
            stringBuffer.append(j4.d(((RoutePOISearchQuery) this.f9630n).getTo()));
            stringBuffer.append("&strategy=");
            StringBuilder sb2 = new StringBuilder();
            sb2.append(((RoutePOISearchQuery) this.f9630n).getMode());
            stringBuffer.append(sb2.toString());
        }
        String channel = ((RoutePOISearchQuery) this.f9630n).getChannel();
        if (!TextUtils.isEmpty(channel)) {
            stringBuffer.append("&channel=");
            stringBuffer.append(channel);
        }
        stringBuffer.append("&types=");
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dz
    public final String h() {
        return i4.b() + "/place/route?";
    }
}
