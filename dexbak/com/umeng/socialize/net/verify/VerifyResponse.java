package com.umeng.socialize.net.verify;

import com.umeng.socialize.net.base.SocializeReseponse;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class VerifyResponse extends SocializeReseponse {

    /* renamed from: a */
    private int f39583a;

    /* renamed from: b */
    private boolean f39584b;

    public VerifyResponse(Integer num, JSONObject jSONObject) {
        super(null);
        this.f39583a = num.intValue();
        this.f39584b = false;
        parseJsonObject(jSONObject);
    }

    @Override // com.umeng.socialize.net.base.SocializeReseponse
    public boolean isHttpOK() {
        return this.f39583a == 200;
    }

    @Override // com.umeng.socialize.net.base.SocializeReseponse
    public boolean isOk() {
        return this.f39584b;
    }

    public void parseJsonObject(JSONObject jSONObject) {
        try {
            if (jSONObject.getString(CommonNetImpl.RESULT).startsWith("success")) {
                this.f39584b = true;
            } else {
                this.f39584b = false;
            }
        } catch (JSONException e) {
            SLog.error(UmengText.NET.PARSEERROR, e);
        }
    }
}
