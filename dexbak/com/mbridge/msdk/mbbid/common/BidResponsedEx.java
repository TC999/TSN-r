package com.mbridge.msdk.mbbid.common;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.mbbid.out.BidResponsed;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class BidResponsedEx extends BidResponsed {
    public static final String KEY_CID = "cid";
    public static final String KEY_MACORS = "macors";
    public static final String TAG = "BidResponsedEx";
    private String cid;

    public static String decodePrice(String str) {
        return str;
    }

    public static BidResponsedEx parseBidResponsedEx(JSONObject jSONObject, String str) {
        BidResponsedEx bidResponsedEx;
        BidResponsedEx bidResponsedEx2 = null;
        if (jSONObject != null) {
            try {
                bidResponsedEx = new BidResponsedEx();
            } catch (Throwable th) {
                th = th;
            }
            try {
                bidResponsedEx.setBidId(jSONObject.optString(BidResponsed.KEY_BID_ID));
                bidResponsedEx.setCur(jSONObject.optString(BidResponsed.KEY_CUR));
                bidResponsedEx.setPrice(jSONObject.optString(BidResponsed.KEY_PRICE));
                bidResponsedEx.setCid(jSONObject.optString(KEY_CID));
                bidResponsedEx.setBidToken(jSONObject.optString(BidResponsed.KEY_TOKEN));
                JSONObject optJSONObject = jSONObject.optJSONObject(KEY_MACORS);
                String optString = jSONObject.optString(BidResponsed.KEY_LN);
                String optString2 = jSONObject.optString(BidResponsed.KEY_WN);
                if (optJSONObject != null && optJSONObject.length() > 0) {
                    Iterator<String> keys = optJSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        String string = optJSONObject.getString(next);
                        optString = replaceUrl(optString, next, string);
                        optString2 = replaceUrl(optString2, next, string);
                    }
                }
                bidResponsedEx.setLn(optString);
                bidResponsedEx.setWn(optString2);
                return bidResponsedEx;
            } catch (Throwable th2) {
                th = th2;
                bidResponsedEx2 = bidResponsedEx;
                SameLogTool.m21733d(TAG, th.getMessage());
                return bidResponsedEx2;
            }
        }
        return null;
    }

    private static String replaceUrl(String str, String str2, String str3) {
        try {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
                return str;
            }
            return str.replaceAll("\\{" + str2 + "\\}", str3);
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public String getCid() {
        return this.cid;
    }

    public void setCid(String str) {
        this.cid = str;
    }

    public void setLn(String str) {
        this.f31244ln = str;
    }

    public void setWn(String str) {
        this.f31245wn = str;
    }
}
