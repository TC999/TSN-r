package com.amap.api.col.p0463l;

import android.content.Context;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import master.flame.danmaku.danmaku.parser.IDataSource;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;

@EntityClass(m54740a = "update_item", m54739b = true)
/* renamed from: com.amap.api.col.3l.m0 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class UpdateItem extends DTInfo {

    /* renamed from: n */
    private String f4663n = "";

    /* renamed from: o */
    private Context f4664o;

    public UpdateItem() {
    }

    /* renamed from: l */
    private static String m54536l(JSONObject jSONObject, String str) throws JSONException {
        return (jSONObject == null || !jSONObject.has(str) || HttpUrl.PATH_SEGMENT_ENCODE_SET_URI.equals(jSONObject.getString(str))) ? "" : jSONObject.optString(str).trim();
    }

    /* renamed from: p */
    private void m54532p() {
        String m55707f0 = C1732a3.m55707f0(this.f4664o);
        this.f5030d = m55707f0 + this.f5039m + ".zip.tmp";
    }

    /* renamed from: k */
    public final String m54537k() {
        return this.f4663n;
    }

    /* renamed from: m */
    public final void m54535m(String str) {
        this.f4663n = str;
    }

    /* renamed from: n */
    public final void m54534n() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("title", this.f5027a);
            jSONObject2.put("code", this.f5029c);
            jSONObject2.put("url", this.f5028b);
            jSONObject2.put(TTDownloadField.TT_FILE_NAME, this.f5030d);
            jSONObject2.put("lLocalLength", this.f5032f);
            jSONObject2.put("lRemoteLength", this.f5033g);
            jSONObject2.put("mState", this.f5038l);
            jSONObject2.put(ConstantHelper.LOG_VS, this.f5031e);
            jSONObject2.put("localPath", this.f5034h);
            String str = this.f4663n;
            if (str != null) {
                jSONObject2.put("vMapFileNames", str);
            }
            jSONObject2.put("isSheng", this.f5035i);
            jSONObject2.put("mCompleteCode", this.f5036j);
            jSONObject2.put("mCityCode", this.f5037k);
            jSONObject2.put("pinyin", this.f5039m);
            jSONObject.put(IDataSource.f43973c, jSONObject2);
            File file = new File(this.f5030d + ".dt");
            file.delete();
            OutputStreamWriter outputStreamWriter = null;
            try {
                try {
                    OutputStreamWriter outputStreamWriter2 = new OutputStreamWriter(new FileOutputStream(file, true), "utf-8");
                    try {
                        outputStreamWriter2.write(jSONObject.toString());
                        try {
                            outputStreamWriter2.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } catch (IOException e2) {
                        e = e2;
                        outputStreamWriter = outputStreamWriter2;
                        SDKLogHandler.m53863p(e, "UpdateItem", "saveJSONObjectToFile");
                        e.printStackTrace();
                        if (outputStreamWriter != null) {
                            try {
                                outputStreamWriter.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        }
                    } catch (Throwable th) {
                        th = th;
                        outputStreamWriter = outputStreamWriter2;
                        if (outputStreamWriter != null) {
                            try {
                                outputStreamWriter.close();
                            } catch (IOException e4) {
                                e4.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e5) {
                    e = e5;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            SDKLogHandler.m53863p(th3, "UpdateItem", "saveJSONObjectToFile parseJson");
            th3.printStackTrace();
        }
    }

    /* renamed from: o */
    public final void m54533o(String str) {
        JSONObject jSONObject;
        if (str != null) {
            try {
                if ("".equals(str) || (jSONObject = new JSONObject(str).getJSONObject(IDataSource.f43973c)) == null) {
                    return;
                }
                this.f5027a = jSONObject.optString("title");
                this.f5029c = jSONObject.optString("code");
                this.f5028b = jSONObject.optString("url");
                this.f5030d = jSONObject.optString(TTDownloadField.TT_FILE_NAME);
                this.f5032f = jSONObject.optLong("lLocalLength");
                this.f5033g = jSONObject.optLong("lRemoteLength");
                this.f5038l = jSONObject.optInt("mState");
                this.f5031e = jSONObject.optString(ConstantHelper.LOG_VS);
                this.f5034h = jSONObject.optString("localPath");
                this.f4663n = jSONObject.optString("vMapFileNames");
                this.f5035i = jSONObject.optInt("isSheng");
                this.f5036j = jSONObject.optInt("mCompleteCode");
                this.f5037k = jSONObject.optString("mCityCode");
                String m54536l = m54536l(jSONObject, "pinyin");
                this.f5039m = m54536l;
                if ("".equals(m54536l)) {
                    String str2 = this.f5028b;
                    String substring = str2.substring(str2.lastIndexOf("/") + 1);
                    this.f5039m = substring.substring(0, substring.lastIndexOf("."));
                }
            } catch (Throwable th) {
                SDKLogHandler.m53863p(th, "UpdateItem", "readFileToJSONObject");
                th.printStackTrace();
            }
        }
    }

    public UpdateItem(OfflineMapCity offlineMapCity, Context context) {
        this.f4664o = context;
        this.f5027a = offlineMapCity.getCity();
        this.f5029c = offlineMapCity.getAdcode();
        this.f5028b = offlineMapCity.getUrl();
        this.f5033g = offlineMapCity.getSize();
        this.f5031e = offlineMapCity.getVersion();
        this.f5037k = offlineMapCity.getCode();
        this.f5035i = 0;
        this.f5038l = offlineMapCity.getState();
        this.f5036j = offlineMapCity.getcompleteCode();
        this.f5039m = offlineMapCity.getPinyin();
        m54532p();
    }

    public UpdateItem(OfflineMapProvince offlineMapProvince, Context context) {
        this.f4664o = context;
        this.f5027a = offlineMapProvince.getProvinceName();
        this.f5029c = offlineMapProvince.getProvinceCode();
        this.f5028b = offlineMapProvince.getUrl();
        this.f5033g = offlineMapProvince.getSize();
        this.f5031e = offlineMapProvince.getVersion();
        this.f5035i = 1;
        this.f5038l = offlineMapProvince.getState();
        this.f5036j = offlineMapProvince.getcompleteCode();
        this.f5039m = offlineMapProvince.getPinyin();
        m54532p();
    }
}
