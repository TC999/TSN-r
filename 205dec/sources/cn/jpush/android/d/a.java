package cn.jpush.android.d;

import android.text.TextUtils;
import cn.jpush.android.api.JThirdPlatFormInterface;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a implements Serializable {
    private static final long serialVersionUID = -942487107643335186L;

    /* renamed from: a  reason: collision with root package name */
    public String f4120a;

    /* renamed from: b  reason: collision with root package name */
    public String f4121b;

    public a() {
    }

    public a(d dVar) {
        this.f4120a = dVar.f4127d;
        this.f4121b = dVar.f4131h;
    }

    public a(String str, String str2) {
        this.f4120a = str;
        this.f4121b = str2;
    }

    public static a a(JSONObject jSONObject) {
        return new a(jSONObject.optString(JThirdPlatFormInterface.KEY_MSG_ID), jSONObject.optString("override_msg_id"));
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(JThirdPlatFormInterface.KEY_MSG_ID, this.f4120a);
            jSONObject.put("override_msg_id", this.f4121b);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (TextUtils.isEmpty(this.f4120a) || TextUtils.isEmpty(aVar.f4120a) || !TextUtils.equals(this.f4120a, aVar.f4120a)) {
                return false;
            }
            if (TextUtils.isEmpty(this.f4121b) && TextUtils.isEmpty(aVar.f4121b)) {
                return true;
            }
            return (TextUtils.isEmpty(this.f4121b) || TextUtils.isEmpty(aVar.f4121b) || !TextUtils.equals(this.f4121b, aVar.f4121b)) ? false : true;
        }
        return false;
    }

    public String toString() {
        return "msg_id = " + this.f4120a + ",  override_msg_id = " + this.f4121b;
    }
}
