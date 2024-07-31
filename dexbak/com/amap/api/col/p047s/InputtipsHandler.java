package com.amap.api.col.p047s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.help.InputtipsQuery;
import com.amap.api.services.help.Tip;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.s.q4 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class InputtipsHandler extends BasicLBSRestHandler<InputtipsQuery, ArrayList<Tip>> {
    public InputtipsHandler(Context context, InputtipsQuery inputtipsQuery) {
        super(context, inputtipsQuery);
    }

    /* renamed from: U */
    private static ArrayList<Tip> m52643U(String str) throws AMapException {
        try {
            return JSONHelper.m52485u0(new JSONObject(str));
        } catch (JSONException e) {
            C2082j4.m52825i(e, "InputtipsHandler", "paseJSON");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler
    /* renamed from: I */
    public final /* synthetic */ Object mo52183I(String str) throws AMapException {
        return m52643U(str);
    }

    @Override // com.amap.api.col.p047s.BasicLBSRestHandler, com.amap.api.col.p047s.BasicHandler
    /* renamed from: M */
    protected final String mo52182M() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json");
        String m53218i = BasicLBSRestHandler.m53218i(((InputtipsQuery) this.f5880n).getKeyword());
        if (!TextUtils.isEmpty(m53218i)) {
            stringBuffer.append("&keywords=");
            stringBuffer.append(m53218i);
        }
        String city = ((InputtipsQuery) this.f5880n).getCity();
        if (!JSONHelper.m52489s0(city)) {
            String m53218i2 = BasicLBSRestHandler.m53218i(city);
            stringBuffer.append("&city=");
            stringBuffer.append(m53218i2);
        }
        String type = ((InputtipsQuery) this.f5880n).getType();
        if (!JSONHelper.m52489s0(type)) {
            String m53218i3 = BasicLBSRestHandler.m53218i(type);
            stringBuffer.append("&type=");
            stringBuffer.append(m53218i3);
        }
        if (((InputtipsQuery) this.f5880n).getCityLimit()) {
            stringBuffer.append("&citylimit=true");
        } else {
            stringBuffer.append("&citylimit=false");
        }
        LatLonPoint location = ((InputtipsQuery) this.f5880n).getLocation();
        if (location != null) {
            stringBuffer.append("&location=");
            stringBuffer.append(location.getLongitude());
            stringBuffer.append(",");
            stringBuffer.append(location.getLatitude());
        }
        stringBuffer.append("&key=");
        stringBuffer.append(C2199x0.m52327i(this.f5883q));
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.p047s.AbstractC2044dz
    /* renamed from: h */
    public final String mo52180h() {
        return C2077i4.m52894b() + "/assistant/inputtips?";
    }
}
