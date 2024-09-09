package com.kwad.sdk.core.scene;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.pangle.sdk.component.log.impl.core.monitor.EventMonitor;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.e.c;
import com.kwad.sdk.core.response.a.a;
import com.kwad.sdk.utils.u;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@KsJson
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class URLPackage extends a implements Serializable {
    public static final String KEY_AUTHOR_ID = "authorId";
    public static final String KEY_CHANNEL_ID = "channelId";
    private static final long serialVersionUID = -7365796297335816787L;
    public String identity;
    public transient JSONObject mJsonObjectParams;
    public int page;

    public URLPackage() {
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void afterParseJson(@Nullable JSONObject jSONObject) {
        super.afterParseJson(jSONObject);
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString(EventMonitor.V3_PARAMS);
        if (TextUtils.isEmpty(optString)) {
            return;
        }
        try {
            this.mJsonObjectParams = new JSONObject(optString);
        } catch (JSONException e4) {
            c.printStackTrace(e4);
        }
    }

    @Override // com.kwad.sdk.core.response.a.a
    public void afterToJson(JSONObject jSONObject) {
        super.afterToJson(jSONObject);
        JSONObject jSONObject2 = this.mJsonObjectParams;
        if (jSONObject2 != null) {
            u.putValue(jSONObject, EventMonitor.V3_PARAMS, jSONObject2.toString());
        }
    }

    public void putParams(String str, long j4) {
        if (this.mJsonObjectParams == null) {
            this.mJsonObjectParams = new JSONObject();
        }
        u.putValue(this.mJsonObjectParams, str, j4);
    }

    public URLPackage(@NonNull String str, int i4) {
        this.page = i4;
        this.identity = str;
    }

    public URLPackage(int i4) {
        this.page = i4;
        this.identity = String.valueOf(hashCode());
    }
}
