package com.umeng.socialize.net.verify;

import com.umeng.socialize.net.base.SocializeReseponse;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class VerifyResponse extends SocializeReseponse {

    /* renamed from: a  reason: collision with root package name */
    private int f54157a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f54158b;

    public VerifyResponse(Integer num, JSONObject jSONObject) {
        super(null);
        this.f54157a = num.intValue();
        this.f54158b = false;
        parseJsonObject(jSONObject);
    }

    @Override // com.umeng.socialize.net.base.SocializeReseponse
    public boolean isHttpOK() {
        return this.f54157a == 200;
    }

    @Override // com.umeng.socialize.net.base.SocializeReseponse
    public boolean isOk() {
        return this.f54158b;
    }

    public void parseJsonObject(JSONObject jSONObject) {
        try {
            if (jSONObject.getString("result").startsWith("success")) {
                this.f54158b = true;
            } else {
                this.f54158b = false;
            }
        } catch (JSONException e4) {
            SLog.error(UmengText.NET.PARSEERROR, e4);
        }
    }
}
