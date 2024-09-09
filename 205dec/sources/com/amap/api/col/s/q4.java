package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.help.InputtipsQuery;
import com.amap.api.services.help.Tip;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: InputtipsHandler.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class q4 extends b4<InputtipsQuery, ArrayList<Tip>> {
    public q4(Context context, InputtipsQuery inputtipsQuery) {
        super(context, inputtipsQuery);
    }

    private static ArrayList<Tip> U(String str) throws AMapException {
        try {
            return r4.u0(new JSONObject(str));
        } catch (JSONException e4) {
            j4.i(e4, "InputtipsHandler", "paseJSON");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    public final /* synthetic */ Object I(String str) throws AMapException {
        return U(str);
    }

    @Override // com.amap.api.col.s.b4, com.amap.api.col.s.a3
    protected final String M() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json");
        String i4 = b4.i(((InputtipsQuery) this.f9630n).getKeyword());
        if (!TextUtils.isEmpty(i4)) {
            stringBuffer.append("&keywords=");
            stringBuffer.append(i4);
        }
        String city = ((InputtipsQuery) this.f9630n).getCity();
        if (!r4.s0(city)) {
            String i5 = b4.i(city);
            stringBuffer.append("&city=");
            stringBuffer.append(i5);
        }
        String type = ((InputtipsQuery) this.f9630n).getType();
        if (!r4.s0(type)) {
            String i6 = b4.i(type);
            stringBuffer.append("&type=");
            stringBuffer.append(i6);
        }
        if (((InputtipsQuery) this.f9630n).getCityLimit()) {
            stringBuffer.append("&citylimit=true");
        } else {
            stringBuffer.append("&citylimit=false");
        }
        LatLonPoint location = ((InputtipsQuery) this.f9630n).getLocation();
        if (location != null) {
            stringBuffer.append("&location=");
            stringBuffer.append(location.getLongitude());
            stringBuffer.append(",");
            stringBuffer.append(location.getLatitude());
        }
        stringBuffer.append("&key=");
        stringBuffer.append(x0.i(this.f9633q));
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.dz
    public final String h() {
        return i4.b() + "/assistant/inputtips?";
    }
}
