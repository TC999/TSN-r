package com.umeng.socialize.net;

import com.umeng.socialize.net.base.SocializeReseponse;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ActionBarResponse extends SocializeReseponse {
    public int mCommentCount;
    public String mEntityKey;
    public int mFavorite;
    public int mFirstTime;
    public int mLikeCount;
    public int mPv;
    public int mShareCount;
    public String mSid;
    public String mUid;
    public String mUk;

    public ActionBarResponse(Integer num, JSONObject jSONObject) {
        super(jSONObject);
    }

    @Override // com.umeng.socialize.net.base.SocializeReseponse
    public void parseJsonObject() {
        JSONObject jSONObject = this.mJsonData;
        if (jSONObject == null) {
            SLog.I(UmengText.NET.JSONNULL);
            return;
        }
        try {
            if (jSONObject.has("cm")) {
                this.mCommentCount = jSONObject.getInt("cm");
            }
            if (jSONObject.has("ek")) {
                this.mEntityKey = jSONObject.getString("ek");
            }
            if (jSONObject.has("ft")) {
                this.mFirstTime = jSONObject.getInt("ft");
            }
            if (jSONObject.has("fr")) {
                this.mFavorite = jSONObject.optInt("fr", 0);
            }
            if (jSONObject.has("lk")) {
                this.mLikeCount = jSONObject.getInt("lk");
            }
            if (jSONObject.has("pv")) {
                this.mPv = jSONObject.getInt("pv");
            }
            if (jSONObject.has("sid")) {
                this.mSid = jSONObject.getString("sid");
            }
            if (jSONObject.has("uid")) {
                this.mUid = jSONObject.getString("uid");
            }
            if (jSONObject.has("sn")) {
                this.mShareCount = jSONObject.getInt("sn");
            }
        } catch (JSONException e4) {
            SLog.error(UmengText.NET.PARSEERROR, e4);
        }
    }
}
