package com.autonavi.aps.amapapi.trans;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.amap.api.col.p0003l.e4;
import com.amap.api.col.p0003l.y6;
import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.aps.amapapi.utils.h;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: Parser.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private StringBuilder f11948a = new StringBuilder();

    /* renamed from: b  reason: collision with root package name */
    private AMapLocationClientOption f11949b = new AMapLocationClientOption();

    private static String b(String str) {
        return "[]".equals(str) ? "" : str;
    }

    public final void a(AMapLocationClientOption aMapLocationClientOption) {
        if (aMapLocationClientOption == null) {
            this.f11949b = new AMapLocationClientOption();
        } else {
            this.f11949b = aMapLocationClientOption;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x0291 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x029d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.autonavi.aps.amapapi.model.a a(com.autonavi.aps.amapapi.model.a r22, byte[] r23, com.autonavi.aps.amapapi.a r24) {
        /*
            Method dump skipped, instructions count: 686
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.trans.e.a(com.autonavi.aps.amapapi.model.a, byte[], com.autonavi.aps.amapapi.a):com.autonavi.aps.amapapi.model.a");
    }

    private void a(com.autonavi.aps.amapapi.model.a aVar, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            sb.append(" ");
        }
        if (!TextUtils.isEmpty(str2)) {
            a(str, str2, sb);
        }
        if (!TextUtils.isEmpty(str3)) {
            sb.append(str3);
            sb.append(" ");
        }
        if (!TextUtils.isEmpty(str4)) {
            sb.append(str4);
            sb.append(" ");
        }
        if (!TextUtils.isEmpty(str5)) {
            sb.append(str5);
            sb.append(" ");
        }
        if (!TextUtils.isEmpty(str6)) {
            a(str7, str6, sb, aVar);
        }
        Bundle bundle = new Bundle();
        bundle.putString("citycode", aVar.getCityCode());
        bundle.putString("desc", sb.toString());
        bundle.putString("adcode", aVar.getAdCode());
        aVar.setExtras(bundle);
        aVar.g(sb.toString());
        String adCode = aVar.getAdCode();
        if (adCode != null && adCode.trim().length() > 0 && this.f11949b.getGeoLanguage() != AMapLocationClientOption.GeoLanguage.EN) {
            aVar.setAddress(sb.toString().replace(" ", ""));
        } else {
            aVar.setAddress(sb.toString());
        }
    }

    private void a(String str, String str2, StringBuilder sb) {
        if (this.f11949b.getGeoLanguage() == AMapLocationClientOption.GeoLanguage.EN) {
            if (str2.equals(str)) {
                return;
            }
            sb.append(str2);
            sb.append(" ");
        } else if (str.contains("\u5e02") && str.equals(str2)) {
        } else {
            sb.append(str2);
            sb.append(" ");
        }
    }

    private void a(String str, String str2, StringBuilder sb, com.autonavi.aps.amapapi.model.a aVar) {
        if (!TextUtils.isEmpty(str) && this.f11949b.getGeoLanguage() != AMapLocationClientOption.GeoLanguage.EN) {
            sb.append("\u9760\u8fd1");
            sb.append(str2);
            sb.append(" ");
            aVar.setDescription("\u5728" + str2 + "\u9644\u8fd1");
            return;
        }
        sb.append("Near ".concat(String.valueOf(str2)));
        aVar.setDescription("Near ".concat(String.valueOf(str2)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0075, code lost:
        if (r3.length() <= 0) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0077, code lost:
        r10.setCity(r3);
        r4 = r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0081 A[Catch: all -> 0x0105, TryCatch #0 {all -> 0x0105, blocks: (B:3:0x0001, B:5:0x004e, B:7:0x0056, B:9:0x005e, B:12:0x0067, B:17:0x007b, B:19:0x0081, B:20:0x0085, B:23:0x00d1, B:25:0x00e3, B:27:0x00ef, B:28:0x00fe, B:14:0x0071, B:16:0x0077), top: B:31:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00d1 A[Catch: all -> 0x0105, TRY_ENTER, TryCatch #0 {all -> 0x0105, blocks: (B:3:0x0001, B:5:0x004e, B:7:0x0056, B:9:0x005e, B:12:0x0067, B:17:0x007b, B:19:0x0081, B:20:0x0085, B:23:0x00d1, B:25:0x00e3, B:27:0x00ef, B:28:0x00fe, B:14:0x0071, B:16:0x0077), top: B:31:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ef A[Catch: all -> 0x0105, TryCatch #0 {all -> 0x0105, blocks: (B:3:0x0001, B:5:0x004e, B:7:0x0056, B:9:0x005e, B:12:0x0067, B:17:0x007b, B:19:0x0081, B:20:0x0085, B:23:0x00d1, B:25:0x00e3, B:27:0x00ef, B:28:0x00fe, B:14:0x0071, B:16:0x0077), top: B:31:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.autonavi.aps.amapapi.model.a a(java.lang.String r14) {
        /*
            r13 = this;
            r0 = 0
            com.autonavi.aps.amapapi.model.a r10 = new com.autonavi.aps.amapapi.model.a     // Catch: java.lang.Throwable -> L105
            java.lang.String r1 = ""
            r10.<init>(r1)     // Catch: java.lang.Throwable -> L105
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L105
            r1.<init>(r14)     // Catch: java.lang.Throwable -> L105
            java.lang.String r14 = "regeocode"
            org.json.JSONObject r14 = r1.optJSONObject(r14)     // Catch: java.lang.Throwable -> L105
            java.lang.String r1 = "addressComponent"
            org.json.JSONObject r1 = r14.optJSONObject(r1)     // Catch: java.lang.Throwable -> L105
            java.lang.String r2 = "country"
            java.lang.String r2 = r1.optString(r2)     // Catch: java.lang.Throwable -> L105
            java.lang.String r2 = b(r2)     // Catch: java.lang.Throwable -> L105
            r10.setCountry(r2)     // Catch: java.lang.Throwable -> L105
            java.lang.String r2 = "province"
            java.lang.String r2 = r1.optString(r2)     // Catch: java.lang.Throwable -> L105
            java.lang.String r3 = b(r2)     // Catch: java.lang.Throwable -> L105
            r10.setProvince(r3)     // Catch: java.lang.Throwable -> L105
            java.lang.String r2 = "citycode"
            java.lang.String r2 = r1.optString(r2)     // Catch: java.lang.Throwable -> L105
            java.lang.String r2 = b(r2)     // Catch: java.lang.Throwable -> L105
            r10.setCityCode(r2)     // Catch: java.lang.Throwable -> L105
            java.lang.String r4 = "city"
            java.lang.String r4 = r1.optString(r4)     // Catch: java.lang.Throwable -> L105
            java.lang.String r5 = "010"
            boolean r5 = r2.endsWith(r5)     // Catch: java.lang.Throwable -> L105
            if (r5 != 0) goto L6f
            java.lang.String r5 = "021"
            boolean r5 = r2.endsWith(r5)     // Catch: java.lang.Throwable -> L105
            if (r5 != 0) goto L6f
            java.lang.String r5 = "022"
            boolean r5 = r2.endsWith(r5)     // Catch: java.lang.Throwable -> L105
            if (r5 != 0) goto L6f
            java.lang.String r5 = "023"
            boolean r2 = r2.endsWith(r5)     // Catch: java.lang.Throwable -> L105
            if (r2 == 0) goto L67
            goto L6f
        L67:
            java.lang.String r4 = b(r4)     // Catch: java.lang.Throwable -> L105
            r10.setCity(r4)     // Catch: java.lang.Throwable -> L105
            goto L7b
        L6f:
            if (r3 == 0) goto L7b
            int r2 = r3.length()     // Catch: java.lang.Throwable -> L105
            if (r2 <= 0) goto L7b
            r10.setCity(r3)     // Catch: java.lang.Throwable -> L105
            r4 = r3
        L7b:
            boolean r2 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L105
            if (r2 == 0) goto L85
            r10.setCity(r3)     // Catch: java.lang.Throwable -> L105
            r4 = r3
        L85:
            java.lang.String r2 = "district"
            java.lang.String r2 = r1.optString(r2)     // Catch: java.lang.Throwable -> L105
            java.lang.String r5 = b(r2)     // Catch: java.lang.Throwable -> L105
            r10.setDistrict(r5)     // Catch: java.lang.Throwable -> L105
            java.lang.String r2 = "adcode"
            java.lang.String r2 = r1.optString(r2)     // Catch: java.lang.Throwable -> L105
            java.lang.String r9 = b(r2)     // Catch: java.lang.Throwable -> L105
            r10.setAdCode(r9)     // Catch: java.lang.Throwable -> L105
            java.lang.String r2 = "streetNumber"
            org.json.JSONObject r1 = r1.optJSONObject(r2)     // Catch: java.lang.Throwable -> L105
            java.lang.String r2 = "street"
            java.lang.String r2 = r1.optString(r2)     // Catch: java.lang.Throwable -> L105
            java.lang.String r6 = b(r2)     // Catch: java.lang.Throwable -> L105
            r10.setStreet(r6)     // Catch: java.lang.Throwable -> L105
            r10.setRoad(r6)     // Catch: java.lang.Throwable -> L105
            java.lang.String r2 = "number"
            java.lang.String r1 = r1.optString(r2)     // Catch: java.lang.Throwable -> L105
            java.lang.String r7 = b(r1)     // Catch: java.lang.Throwable -> L105
            r10.setNumber(r7)     // Catch: java.lang.Throwable -> L105
            java.lang.String r1 = "pois"
            org.json.JSONArray r1 = r14.optJSONArray(r1)     // Catch: java.lang.Throwable -> L105
            int r2 = r1.length()     // Catch: java.lang.Throwable -> L105
            java.lang.String r8 = "name"
            r11 = 0
            if (r2 <= 0) goto Le2
            org.json.JSONObject r1 = r1.getJSONObject(r11)     // Catch: java.lang.Throwable -> L105
            java.lang.String r1 = r1.optString(r8)     // Catch: java.lang.Throwable -> L105
            java.lang.String r1 = b(r1)     // Catch: java.lang.Throwable -> L105
            r10.setPoiName(r1)     // Catch: java.lang.Throwable -> L105
            r12 = r1
            goto Le3
        Le2:
            r12 = r0
        Le3:
            java.lang.String r1 = "aois"
            org.json.JSONArray r14 = r14.optJSONArray(r1)     // Catch: java.lang.Throwable -> L105
            int r1 = r14.length()     // Catch: java.lang.Throwable -> L105
            if (r1 <= 0) goto Lfe
            org.json.JSONObject r14 = r14.getJSONObject(r11)     // Catch: java.lang.Throwable -> L105
            java.lang.String r14 = r14.optString(r8)     // Catch: java.lang.Throwable -> L105
            java.lang.String r14 = b(r14)     // Catch: java.lang.Throwable -> L105
            r10.setAoiName(r14)     // Catch: java.lang.Throwable -> L105
        Lfe:
            r1 = r13
            r2 = r10
            r8 = r12
            r1.a(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L105
            return r10
        L105:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.aps.amapapi.trans.e.a(java.lang.String):com.autonavi.aps.amapapi.model.a");
    }

    public final com.autonavi.aps.amapapi.model.a a(String str, Context context, y6 y6Var, com.autonavi.aps.amapapi.a aVar) {
        com.autonavi.aps.amapapi.model.a aVar2 = new com.autonavi.aps.amapapi.model.a("");
        aVar2.setErrorCode(7);
        StringBuffer stringBuffer = new StringBuffer();
        try {
            stringBuffer.append("#SHA1AndPackage#");
            stringBuffer.append(e4.i(context));
            String str2 = y6Var.f9525b.get("gsid").get(0);
            if (!TextUtils.isEmpty(str2)) {
                stringBuffer.append("#gsid#");
                stringBuffer.append(str2);
            }
            String str3 = y6Var.f9526c;
            if (!TextUtils.isEmpty(str3)) {
                stringBuffer.append("#csid#".concat(String.valueOf(str3)));
            }
        } catch (Throwable unused) {
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("status") || !jSONObject.has("info")) {
                aVar.f("#0702");
                StringBuilder sb = this.f11948a;
                sb.append("json is error:");
                sb.append(str);
                sb.append(stringBuffer);
                sb.append("#0702");
            }
            String string = jSONObject.getString("status");
            String string2 = jSONObject.getString("info");
            String string3 = jSONObject.getString("infocode");
            if ("0".equals(string)) {
                aVar.f("#0701");
                StringBuilder sb2 = this.f11948a;
                sb2.append("auth fail:");
                sb2.append(string2);
                sb2.append(stringBuffer);
                sb2.append("#0701");
                h.a(y6Var.f9527d, string3, string2);
            }
        } catch (Throwable th) {
            aVar.f("#0703");
            StringBuilder sb3 = this.f11948a;
            sb3.append("json exception error:");
            sb3.append(th.getMessage());
            sb3.append(stringBuffer);
            sb3.append("#0703");
            com.autonavi.aps.amapapi.utils.b.a(th, "parser", "paseAuthFailurJson");
        }
        aVar2.setLocationDetail(this.f11948a.toString());
        if (this.f11948a.length() > 0) {
            StringBuilder sb4 = this.f11948a;
            sb4.delete(0, sb4.length());
        }
        return aVar2;
    }

    private static void a(com.autonavi.aps.amapapi.model.a aVar, short s3) {
        if (!"-1".equals(aVar.d())) {
            if (s3 == -1) {
                s3 = 0;
            } else if (s3 == 0) {
                s3 = -1;
            }
            aVar.setConScenario(s3);
            return;
        }
        if (s3 == 101) {
            s3 = 100;
        }
        aVar.setConScenario(s3);
    }
}
