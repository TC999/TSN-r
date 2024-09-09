package cn.jiguang.cg;

import android.content.Context;
import cn.jiguang.bq.d;
import cn.jiguang.d.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public abstract class a {

    /* renamed from: b  reason: collision with root package name */
    private static String f3401b = UUID.randomUUID().toString();

    /* renamed from: a  reason: collision with root package name */
    private String f3402a;

    /* renamed from: c  reason: collision with root package name */
    private String f3403c = UUID.randomUUID().toString();

    /* renamed from: d  reason: collision with root package name */
    private long f3404d;

    public a(Context context, String str) {
        this.f3402a = str;
        this.f3404d = context == null ? System.currentTimeMillis() / 1000 : b.b(context);
    }

    public abstract JSONObject a();

    public JSONObject b() {
        JSONObject a4 = a();
        if (a4 != null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("moniter_type", this.f3402a);
                jSONObject.put("uuid", f3401b);
                jSONObject.put("moniter_id", this.f3403c);
                jSONObject.put(CampaignEx.JSON_KEY_TIMESTAMP, this.f3404d);
                jSONObject.put("extra", a4);
                return jSONObject;
            } catch (JSONException e4) {
                d.c("BaseMoniter", "build baseMoniter data error" + e4.getMessage());
                return null;
            }
        }
        return null;
    }

    public String c() {
        return this.f3403c;
    }
}
