package com.kwad.components.core.webview.jshandler;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.utils.C11040ba;
import com.kwad.sdk.utils.C11126t;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.umeng.analytics.pro.UMCommonContent;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.jshandler.q */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9170q implements SensorEventListener, InterfaceC10625a {

    /* renamed from: Wi */
    private Map<Integer, InterfaceC10627c> f29258Wi = new ConcurrentHashMap();

    /* renamed from: com.kwad.components.core.webview.jshandler.q$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9172a extends C10482a {

        /* renamed from: Wl */
        public int f29261Wl;

        /* renamed from: Wm */
        public ArrayList<Float> f29262Wm;
        public int accuracy;
        public long timestamp;
        public int type;

        @Override // com.kwad.sdk.core.response.p408a.C10482a, com.kwad.sdk.core.InterfaceC9914b
        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.type = jSONObject.optInt("type");
            this.f29261Wl = jSONObject.optInt(UMCommonContent.f37794aX);
            this.timestamp = jSONObject.optLong(CampaignEx.JSON_KEY_TIMESTAMP);
            this.accuracy = jSONObject.optInt("accuracy");
            JSONArray optJSONArray = jSONObject.optJSONArray("values");
            ArrayList<Float> arrayList = new ArrayList<>();
            if (optJSONArray == null) {
                this.f29262Wm = arrayList;
                return;
            }
            for (int i = 0; i < optJSONArray.length(); i++) {
                try {
                    Object obj = optJSONArray.get(i);
                    if (obj != null) {
                        arrayList.add((Float) obj);
                    }
                } catch (Throwable unused) {
                }
            }
            this.f29262Wm = arrayList;
        }

        @Override // com.kwad.sdk.core.response.p408a.C10482a, com.kwad.sdk.core.InterfaceC9914b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            int i = this.type;
            if (i != 0) {
                C11126t.putValue(jSONObject, "type", i);
            }
            int i2 = this.f29261Wl;
            if (i2 != 0) {
                C11126t.putValue(jSONObject, UMCommonContent.f37794aX, i2);
            }
            long j = this.timestamp;
            if (j != 0) {
                C11126t.putValue(jSONObject, CampaignEx.JSON_KEY_TIMESTAMP, j);
            }
            int i3 = this.accuracy;
            if (i3 != 0) {
                C11126t.putValue(jSONObject, "accuracy", i3);
            }
            if (!this.f29262Wm.isEmpty()) {
                C11126t.putValue(jSONObject, "values", this.f29262Wm);
            }
            return jSONObject;
        }
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        if (!TextUtils.isEmpty(str)) {
            C9172a c9172a = new C9172a();
            try {
                c9172a.parseJson(new JSONObject(str));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            this.f29258Wi.put(Integer.valueOf(c9172a.type), interfaceC10627c);
            m29220a(c9172a.type, c9172a.f29261Wl, interfaceC10627c);
            return;
        }
        interfaceC10627c.onError(-1, "data is empty");
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "registerSensorListener";
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
        C11040ba.m23973MB().m23971a(this);
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        m29219a(sensorEvent);
    }

    /* renamed from: a */
    private void m29220a(int i, int i2, final InterfaceC10627c interfaceC10627c) {
        C11040ba.m23973MB().m23972a(i, i2, this, new C11040ba.InterfaceC11042b() { // from class: com.kwad.components.core.webview.jshandler.q.1
            @Override // com.kwad.sdk.utils.C11040ba.InterfaceC11042b
            public final void onFailed() {
                interfaceC10627c.onError(-1, "sensor is not support");
            }
        });
    }

    /* renamed from: a */
    private void m29219a(SensorEvent sensorEvent) {
        int type = sensorEvent.sensor.getType();
        if (type == 4) {
            type = 2;
        } else if (type == 10) {
            type = 1;
        }
        InterfaceC10627c interfaceC10627c = this.f29258Wi.get(Integer.valueOf(type));
        if (interfaceC10627c == null) {
            return;
        }
        ArrayList<Float> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            float[] fArr = sensorEvent.values;
            if (i < fArr.length) {
                arrayList.add(Float.valueOf(fArr[i]));
                i++;
            } else {
                C9172a c9172a = new C9172a();
                c9172a.f29262Wm = arrayList;
                c9172a.timestamp = sensorEvent.timestamp;
                c9172a.accuracy = sensorEvent.accuracy;
                interfaceC10627c.mo25251a(c9172a);
                return;
            }
        }
    }
}
