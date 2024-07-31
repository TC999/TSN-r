package com.kwad.sdk.collector.model.jni;

import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.collector.AppStatusNative;
import com.kwad.sdk.collector.model.InterfaceC9810d;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.service.C10974c;
import com.kwad.sdk.utils.C11126t;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;

@Keep
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class RulesTargetNative extends NativeObject implements InterfaceC9810d {
    private static final long serialVersionUID = -4726982809581153390L;

    public RulesTargetNative() {
        this.mPtr = AppStatusNative.nativeCreateRulesTarget();
    }

    @Override // com.kwad.sdk.collector.model.jni.NativeObject
    public void destroy() {
        long j = this.mPtr;
        if (j != 0) {
            AppStatusNative.nativeDeleteRulesTarget(j);
            this.mPtr = 0L;
        }
    }

    @Override // com.kwad.sdk.core.InterfaceC9914b
    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            AppStatusNative.rulesTargetSetPackageName(this, jSONObject.optString(TTDownloadField.TT_PACKAGE_NAME));
            JSONArray optJSONArray = jSONObject.optJSONArray("paths");
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                String[] strArr = new String[length];
                for (int i = 0; i < length; i++) {
                    strArr[i] = optJSONArray.getString(i);
                }
                AppStatusNative.rulesTargetSetPaths(this, strArr);
            }
        } catch (Exception e) {
            C10974c.gatherException(e);
            C10331c.printStackTrace(e);
        }
    }

    @Override // com.kwad.sdk.core.InterfaceC9914b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        C11126t.putValue(jSONObject, TTDownloadField.TT_PACKAGE_NAME, AppStatusNative.rulesTargetGetPackageName(this));
        C11126t.putValue(jSONObject, "paths", Arrays.asList(AppStatusNative.rulesTargetGetPaths(this)));
        return jSONObject;
    }

    public RulesTargetNative(long j) {
        this.mPtr = j;
    }
}
