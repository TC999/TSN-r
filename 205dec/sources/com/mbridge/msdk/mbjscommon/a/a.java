package com.mbridge.msdk.mbjscommon.a;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.mbridge.msdk.foundation.db.i;
import com.mbridge.msdk.foundation.db.t;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import com.mbridge.msdk.foundation.entity.p;
import com.mbridge.msdk.foundation.same.net.f.d;
import com.mbridge.msdk.foundation.same.report.d.b;
import com.mbridge.msdk.foundation.same.report.e;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbjscommon.windvane.h;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: H5ReportManager.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    private static final String f40187c = "a";

    /* renamed from: d  reason: collision with root package name */
    private String f40190d = "handlerNativeResult";

    /* renamed from: a  reason: collision with root package name */
    int f40188a = 0;

    /* renamed from: b  reason: collision with root package name */
    int f40189b = 1;

    /* compiled from: H5ReportManager.java */
    /* renamed from: com.mbridge.msdk.mbjscommon.a.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    private static final class C0747a {

        /* renamed from: a  reason: collision with root package name */
        private static a f40192a = new a();
    }

    public static a a() {
        return C0747a.f40192a;
    }

    public final void a(Object obj, String str, JSONArray jSONArray, int i4) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        JSONObject optJSONObject3;
        JSONObject optJSONObject4;
        JSONObject optJSONObject5;
        JSONObject optJSONObject6;
        JSONObject optJSONObject7;
        JSONObject optJSONObject8;
        JSONObject optJSONObject9;
        JSONObject optJSONObject10;
        JSONObject optJSONObject11;
        int i5;
        try {
            if (jSONArray == null) {
                a(this.f40189b, "called reporter failed, params empty", obj);
                return;
            }
            int length = jSONArray.length();
            if (length == 0) {
                a(this.f40189b, "called reporter failed, params empty", obj);
                return;
            }
            if ("reportMessageR".equalsIgnoreCase(str)) {
                StringBuffer stringBuffer = new StringBuffer();
                int i6 = 0;
                while (true) {
                    i5 = length - 1;
                    if (i6 >= i5) {
                        break;
                    }
                    JSONObject optJSONObject12 = jSONArray.optJSONObject(i6);
                    if (optJSONObject12 != null) {
                        stringBuffer.append(optJSONObject12.optString(DomainCampaignEx.LOOPBACK_KEY));
                        stringBuffer.append("=");
                        stringBuffer.append(optJSONObject12.opt("value"));
                        stringBuffer.append("&");
                    }
                    i6++;
                }
                JSONObject optJSONObject13 = jSONArray.optJSONObject(i5);
                if (optJSONObject13 != null) {
                    stringBuffer.append(optJSONObject13.optString(DomainCampaignEx.LOOPBACK_KEY));
                    stringBuffer.append("=");
                    stringBuffer.append(optJSONObject13.opt("value"));
                }
                String stringBuffer2 = stringBuffer.toString();
                Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
                if (j4 != null && !TextUtils.isEmpty(stringBuffer2)) {
                    try {
                        new com.mbridge.msdk.foundation.same.report.d.a(j4).c(0, d.a().f39564a, e.a(stringBuffer2, j4), new b() { // from class: com.mbridge.msdk.mbjscommon.a.a.1
                            @Override // com.mbridge.msdk.foundation.same.report.d.b
                            public final void a(String str2) {
                                x.d(a.f40187c, str2);
                            }

                            @Override // com.mbridge.msdk.foundation.same.report.d.b
                            public final void b(String str2) {
                                x.d(a.f40187c, str2);
                            }
                        });
                    } catch (Exception e4) {
                        x.d(f40187c, e4.getMessage());
                    }
                }
            } else if ("reportMessageD".equalsIgnoreCase(str)) {
                String str2 = "";
                String string = (length <= 0 || (optJSONObject11 = jSONArray.optJSONObject(0)) == null) ? "" : optJSONObject11.getString("value");
                int i7 = (length <= 1 || (optJSONObject10 = jSONArray.optJSONObject(1)) == null) ? -1 : optJSONObject10.getInt("value");
                int i8 = (length <= 2 || (optJSONObject9 = jSONArray.optJSONObject(2)) == null) ? -1 : optJSONObject9.getInt("value");
                int i9 = (length <= 3 || (optJSONObject8 = jSONArray.optJSONObject(3)) == null) ? -1 : optJSONObject8.getInt("value");
                int i10 = (length <= 4 || (optJSONObject7 = jSONArray.optJSONObject(4)) == null) ? -1 : optJSONObject7.getInt("value");
                String string2 = (length <= 5 || (optJSONObject6 = jSONArray.optJSONObject(5)) == null) ? "" : optJSONObject6.getString("value");
                String string3 = (length <= 6 || (optJSONObject5 = jSONArray.optJSONObject(6)) == null) ? "" : optJSONObject5.getString("value");
                int i11 = (length <= 7 || (optJSONObject4 = jSONArray.optJSONObject(7)) == null) ? -1 : optJSONObject4.getInt("value");
                String string4 = (length <= 8 || (optJSONObject3 = jSONArray.optJSONObject(8)) == null) ? "" : optJSONObject3.getString("value");
                int i12 = (length <= 9 || (optJSONObject2 = jSONArray.optJSONObject(9)) == null) ? -1 : optJSONObject2.getInt("value");
                if (length > 10 && (optJSONObject = jSONArray.optJSONObject(10)) != null) {
                    str2 = optJSONObject.getString("value");
                }
                String str3 = str2;
                Context j5 = com.mbridge.msdk.foundation.controller.a.f().j();
                if (j5 != null) {
                    t.a(i.a(j5)).a(new p(string, i7, i8, i9, i10, string2, string3, i11, string4, i12, str3));
                }
            }
            a(this.f40188a, "called reporter success", obj);
        } catch (Throwable th) {
            x.a(f40187c, th.getMessage());
            a(this.f40189b, "exception: " + th.getMessage(), obj);
        }
    }

    private void a(int i4, String str, Object obj) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("code", i4);
            jSONObject.put("message", str);
            h.a().a(obj, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
        } catch (JSONException e4) {
            x.a(f40187c, e4.getMessage());
        } catch (Throwable th) {
            x.a(f40187c, th.getMessage());
        }
    }
}
