package com.kwad.sdk.collector.model.jni;

import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.kwad.sdk.collector.AppStatusNative;
import com.kwad.sdk.collector.model.d;
import com.kwad.sdk.service.c;
import com.kwad.sdk.utils.t;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@Keep
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class RulesTargetNative extends NativeObject implements d {
    private static final long serialVersionUID = -4726982809581153390L;

    public RulesTargetNative() {
        this.mPtr = AppStatusNative.nativeCreateRulesTarget();
    }

    @Override // com.kwad.sdk.collector.model.jni.NativeObject
    public void destroy() {
        long j4 = this.mPtr;
        if (j4 != 0) {
            AppStatusNative.nativeDeleteRulesTarget(j4);
            this.mPtr = 0L;
        }
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            AppStatusNative.rulesTargetSetPackageName(this, jSONObject.optString("packageName"));
            JSONArray optJSONArray = jSONObject.optJSONArray("paths");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                String[] strArr = new String[length];
                for (int i4 = 0; i4 < length; i4++) {
                    strArr[i4] = optJSONArray.getString(i4);
                }
                AppStatusNative.rulesTargetSetPaths(this, strArr);
            }
        } catch (Exception e4) {
            c.gatherException(e4);
            com.kwad.sdk.core.e.c.printStackTrace(e4);
        }
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "packageName", AppStatusNative.rulesTargetGetPackageName(this));
        t.putValue(jSONObject, "paths", Arrays.asList(AppStatusNative.rulesTargetGetPaths(this)));
        return jSONObject;
    }

    public RulesTargetNative(long j4) {
        this.mPtr = j4;
    }
}
