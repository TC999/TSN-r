package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.util.Log;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitorUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class pbln extends pblm {

    /* renamed from: b  reason: collision with root package name */
    private SDKMonitor f61437b;

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class pgla implements SDKMonitor.IGetExtendParams {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ JSONObject f61438a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f61439b;

        pgla(pbln pblnVar, JSONObject jSONObject, String str) {
            this.f61438a = jSONObject;
            this.f61439b = str;
        }
    }

    @Override // ms.bz.bd.c.Pgl.pblm
    public void d(long j4, long j5, String str, String str2, String str3, int i4, JSONObject jSONObject) {
        SDKMonitor sDKMonitor = this.f61437b;
        if (sDKMonitor == null) {
            return;
        }
        sDKMonitor.monitorSLA(j4, j5, str, str2, str3, i4, (JSONObject) null);
    }

    @Override // ms.bz.bd.c.Pgl.pblm
    public void e(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        String str2 = (String) pblk.a(16777217, 0, 0L, "350961", new byte[]{17, 59, 66, 95, 13, 39, 34, 49, 119, 108, 44, 35, 111, 66, 14, 11, 49, 26, 96, 110, 39, 37, 3, 94, 12, 52, 38, 29, 98, 108, 44, 54, 78, 72, 73, 107, 125, 89, 33});
        if (this.f61437b == null) {
            return;
        }
        try {
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put((String) pblk.a(16777217, 0, 0L, "d53176", new byte[]{102, 50, 82, 83, 1, 34, 98, 26, 99, 108, 112}), str);
            jSONObject4.put((String) pblk.a(16777217, 0, 0L, "df6a92", new byte[]{118, 101, 81, 16, 1, 42, 117, 94}), jSONObject);
            jSONObject4.put((String) pblk.a(16777217, 0, 0L, "ac42b6", new byte[]{125, 100, 83, 84, 84, 34}), jSONObject2);
            jSONObject4.put((String) pblk.a(16777217, 0, 0L, "6eceda", new byte[]{43, 104, 23, 52, 67, 98, 39}), jSONObject3);
            jSONObject4.toString();
            Log.e((String) pblk.a(16777217, 0, 0L, "39be16", new byte[]{15, 30, 37, 48, 61, 4, 19}), jSONObject4.toString());
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        if (jSONObject.length() > 0 || jSONObject2.length() > 0) {
            this.f61437b.monitorEvent(str, jSONObject, jSONObject2, jSONObject3);
        }
    }

    @Override // ms.bz.bd.c.Pgl.pblm
    public boolean g(String str) {
        JSONObject jSONObject;
        String str2;
        String str3;
        ArrayList arrayList;
        ArrayList arrayList2;
        Context c4 = ms.bz.bd.c.Pgl.pgla.a().c();
        String str4 = null;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException unused) {
            String str5 = (String) pblk.a(16777217, 0, 0L, "47cc6c", new byte[]{54, 48, 29});
            jSONObject = null;
        }
        if (jSONObject == null) {
            return false;
        }
        try {
            str3 = jSONObject.getString((String) pblk.a(16777217, 0, 0L, "65d774", new byte[]{52, 51, 28, 124, 9, 42, 49}));
            try {
                str4 = jSONObject.getString((String) pblk.a(16777217, 0, 0L, "f67a5b", new byte[]{Byte.MAX_VALUE, 59, 87, 1, 53, 116, 108, 19}));
                arrayList = new ArrayList();
                arrayList2 = new ArrayList();
                JSONArray jSONArray = jSONObject.getJSONArray((String) pblk.a(16777217, 0, 0L, "2fda7f", new byte[]{32, 107, 25, 19, 1, 118, 4, 117, 25, 34}));
                JSONArray jSONArray2 = jSONObject.getJSONArray((String) pblk.a(16777217, 0, 0L, "944042", new byte[]{58, 51, 87, 75, 25, 49, 15, 39, 73, 115}));
                for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                    arrayList.add(jSONArray.getString(i4));
                }
                for (int i5 = 0; i5 < jSONArray2.length(); i5++) {
                    arrayList2.add(jSONArray2.getString(i5));
                }
            } catch (JSONException unused2) {
                str2 = str4;
                str4 = str3;
                String str6 = (String) pblk.a(16777217, 0, 0L, "de1fe6", new byte[]{102, 98, 79, 45, 83});
                str3 = str4;
                str4 = str2;
                jSONObject.remove((String) pblk.a(16777217, 0, 0L, "447615", new byte[]{38, 57, 74, 68, 7, 37, 2, 39, 74, 117}));
                jSONObject.remove((String) pblk.a(16777217, 0, 0L, "9f1ac7", new byte[]{58, 97, 82, 26, 78, 52, 15, 117, 76, 34}));
                SDKMonitorUtils.initMonitor(c4, str3, jSONObject, new pgla(this, jSONObject, str4));
                this.f61437b = SDKMonitorUtils.getInstance(str3);
                return true;
            }
        } catch (JSONException unused3) {
            str2 = null;
        }
        if (arrayList.size() <= 0 || arrayList2.size() <= 0) {
            return false;
        }
        SDKMonitorUtils.setConfigUrl(str3, arrayList);
        SDKMonitorUtils.setDefaultReportUrl(str3, arrayList2);
        jSONObject.remove((String) pblk.a(16777217, 0, 0L, "447615", new byte[]{38, 57, 74, 68, 7, 37, 2, 39, 74, 117}));
        jSONObject.remove((String) pblk.a(16777217, 0, 0L, "9f1ac7", new byte[]{58, 97, 82, 26, 78, 52, 15, 117, 76, 34}));
        SDKMonitorUtils.initMonitor(c4, str3, jSONObject, new pgla(this, jSONObject, str4));
        this.f61437b = SDKMonitorUtils.getInstance(str3);
        return true;
    }

    @Override // ms.bz.bd.c.Pgl.pblm
    public void h(long j4, long j5, String str, String str2, String str3, int i4, JSONObject jSONObject) {
        SDKMonitor sDKMonitor = this.f61437b;
        if (sDKMonitor == null) {
            return;
        }
        sDKMonitor.monitorApiError(j4, j5, str, str2, str3, i4, (JSONObject) null);
    }
}
