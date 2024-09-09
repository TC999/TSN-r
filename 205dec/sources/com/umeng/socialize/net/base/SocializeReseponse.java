package com.umeng.socialize.net.base;

import android.text.TextUtils;
import com.umeng.socialize.net.utils.UResponse;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class SocializeReseponse extends UResponse {
    protected static final String TAG = "SocializeReseponse";
    private int mHttpCode;
    protected JSONObject mJsonData;
    public String mMsg;
    public int mStCode;

    public SocializeReseponse(JSONObject jSONObject) {
        super(jSONObject);
        this.mStCode = -103;
        this.mJsonData = parseStatus(jSONObject);
        parseJsonObject();
    }

    private void parseErrorMsg(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                JSONObject jSONObject2 = jSONObject.getJSONObject(keys.next());
                if (TextUtils.isEmpty(jSONObject2.getString("msg"))) {
                    jSONObject2.getJSONObject("data").getString("platform_error");
                }
            }
        } catch (Exception e4) {
            SLog.error(e4);
        }
    }

    public JSONObject getJsonData() {
        return this.mJsonData;
    }

    public boolean isHttpOK() {
        return this.mHttpCode == 200;
    }

    public boolean isOk() {
        return this.mStCode == 200;
    }

    public void parseJsonObject() {
    }

    public JSONObject parseStatus(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            int optInt = jSONObject.optInt("st", 1998);
            this.mStCode = optInt;
            if (optInt == 0) {
                return null;
            }
            this.mMsg = jSONObject.optString("msg", "");
            String optString = jSONObject.optString("data", null);
            if (TextUtils.isEmpty(optString)) {
                return null;
            }
            if (this.mStCode != 200) {
                parseErrorMsg(optString);
            }
            return new JSONObject(optString);
        } catch (JSONException e4) {
            SLog.error(UmengText.NET.PARSEERROR, e4);
            return null;
        }
    }

    public SocializeReseponse(Integer num, JSONObject jSONObject) {
        this(jSONObject);
        this.mHttpCode = num == null ? -1 : num.intValue();
    }
}
