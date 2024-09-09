package com.amap.api.col.p0003l;

import android.content.Context;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: UpdateItem.java */
@hk(a = "update_item", b = true)
/* renamed from: com.amap.api.col.3l.m0  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class m0 extends p0 {

    /* renamed from: n  reason: collision with root package name */
    private String f8323n = "";

    /* renamed from: o  reason: collision with root package name */
    private Context f8324o;

    public m0() {
    }

    private static String l(JSONObject jSONObject, String str) throws JSONException {
        return (jSONObject == null || !jSONObject.has(str) || "[]".equals(jSONObject.getString(str))) ? "" : jSONObject.optString(str).trim();
    }

    private void p() {
        String f02 = a3.f0(this.f8324o);
        this.f8583d = f02 + this.f8592m + ".zip.tmp";
    }

    public final String k() {
        return this.f8323n;
    }

    public final void m(String str) {
        this.f8323n = str;
    }

    public final void n() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("title", this.f8580a);
            jSONObject2.put("code", this.f8582c);
            jSONObject2.put("url", this.f8581b);
            jSONObject2.put("fileName", this.f8583d);
            jSONObject2.put("lLocalLength", this.f8585f);
            jSONObject2.put("lRemoteLength", this.f8586g);
            jSONObject2.put("mState", this.f8591l);
            jSONObject2.put("version", this.f8584e);
            jSONObject2.put("localPath", this.f8587h);
            String str = this.f8323n;
            if (str != null) {
                jSONObject2.put("vMapFileNames", str);
            }
            jSONObject2.put("isSheng", this.f8588i);
            jSONObject2.put("mCompleteCode", this.f8589j);
            jSONObject2.put("mCityCode", this.f8590k);
            jSONObject2.put("pinyin", this.f8592m);
            jSONObject.put("file", jSONObject2);
            File file = new File(this.f8583d + ".dt");
            file.delete();
            OutputStreamWriter outputStreamWriter = null;
            try {
                try {
                    OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(new FileOutputStream(file, true), "utf-8");
                    try {
                        outputStreamWriter2.write(jSONObject.toString());
                        try {
                            outputStreamWriter2.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    } catch (IOException e5) {
                        e = e5;
                        outputStreamWriter = outputStreamWriter2;
                        u5.p(e, "UpdateItem", "saveJSONObjectToFile");
                        e.printStackTrace();
                        if (outputStreamWriter != null) {
                            try {
                                outputStreamWriter.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        outputStreamWriter = outputStreamWriter2;
                        if (outputStreamWriter != null) {
                            try {
                                outputStreamWriter.close();
                            } catch (IOException e7) {
                                e7.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e8) {
                    e = e8;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            u5.p(th3, "UpdateItem", "saveJSONObjectToFile parseJson");
            th3.printStackTrace();
        }
    }

    public final void o(String str) {
        JSONObject jSONObject;
        if (str != null) {
            try {
                if ("".equals(str) || (jSONObject = new JSONObject(str).getJSONObject("file")) == null) {
                    return;
                }
                this.f8580a = jSONObject.optString("title");
                this.f8582c = jSONObject.optString("code");
                this.f8581b = jSONObject.optString("url");
                this.f8583d = jSONObject.optString("fileName");
                this.f8585f = jSONObject.optLong("lLocalLength");
                this.f8586g = jSONObject.optLong("lRemoteLength");
                this.f8591l = jSONObject.optInt("mState");
                this.f8584e = jSONObject.optString("version");
                this.f8587h = jSONObject.optString("localPath");
                this.f8323n = jSONObject.optString("vMapFileNames");
                this.f8588i = jSONObject.optInt("isSheng");
                this.f8589j = jSONObject.optInt("mCompleteCode");
                this.f8590k = jSONObject.optString("mCityCode");
                String l4 = l(jSONObject, "pinyin");
                this.f8592m = l4;
                if ("".equals(l4)) {
                    String str2 = this.f8581b;
                    String substring = str2.substring(str2.lastIndexOf(TTPathConst.sSeparator) + 1);
                    this.f8592m = substring.substring(0, substring.lastIndexOf("."));
                }
            } catch (Throwable th) {
                u5.p(th, "UpdateItem", "readFileToJSONObject");
                th.printStackTrace();
            }
        }
    }

    public m0(OfflineMapCity offlineMapCity, Context context) {
        this.f8324o = context;
        this.f8580a = offlineMapCity.getCity();
        this.f8582c = offlineMapCity.getAdcode();
        this.f8581b = offlineMapCity.getUrl();
        this.f8586g = offlineMapCity.getSize();
        this.f8584e = offlineMapCity.getVersion();
        this.f8590k = offlineMapCity.getCode();
        this.f8588i = 0;
        this.f8591l = offlineMapCity.getState();
        this.f8589j = offlineMapCity.getcompleteCode();
        this.f8592m = offlineMapCity.getPinyin();
        p();
    }

    public m0(OfflineMapProvince offlineMapProvince, Context context) {
        this.f8324o = context;
        this.f8580a = offlineMapProvince.getProvinceName();
        this.f8582c = offlineMapProvince.getProvinceCode();
        this.f8581b = offlineMapProvince.getUrl();
        this.f8586g = offlineMapProvince.getSize();
        this.f8584e = offlineMapProvince.getVersion();
        this.f8588i = 1;
        this.f8591l = offlineMapProvince.getState();
        this.f8589j = offlineMapProvince.getcompleteCode();
        this.f8592m = offlineMapProvince.getPinyin();
        p();
    }
}
