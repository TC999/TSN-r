package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.p408a.C10482a;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class InstallActivateReminderConfigItem extends AbstractC10254b<InstallActivateReminderConfig> {

    @KsJson
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class InstallActivateReminderConfig extends C10482a implements Serializable {
        private static final long serialVersionUID = -6457271849826128465L;
        public int noticeTotalCount = 3;
        public int perAppNoticeCount = 2;
        public int noticeAppearTime = 15000;
        public int noticeContinueTime = 15000;
    }

    public InstallActivateReminderConfigItem() {
        super("installActivateReminderConfig", new InstallActivateReminderConfig());
    }

    @Override // com.kwad.sdk.core.config.item.AbstractC10254b
    /* renamed from: a */
    public final void mo26480a(@NonNull SharedPreferences sharedPreferences) {
        InstallActivateReminderConfig value = getValue();
        if (value == null) {
            value = new InstallActivateReminderConfig();
        }
        JSONObject jSONObject = null;
        try {
            jSONObject = new JSONObject(sharedPreferences.getString(getKey(), ""));
        } catch (JSONException e) {
            C10331c.printStackTraceOnly(e);
        }
        if (jSONObject != null) {
            value.parseJson(jSONObject);
        }
        setValue(value);
    }

    @Override // com.kwad.sdk.core.config.item.AbstractC10254b
    /* renamed from: b */
    public final void mo26479b(@NonNull SharedPreferences.Editor editor) {
        if (getValue() != null && getValue().toJson() != null) {
            editor.putString(getKey(), getValue().toJson().toString());
        } else {
            editor.putString(getKey(), "");
        }
    }

    @Override // com.kwad.sdk.core.config.item.AbstractC10254b
    /* renamed from: k */
    public final void mo26478k(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(getKey())) != null) {
            InstallActivateReminderConfig installActivateReminderConfig = new InstallActivateReminderConfig();
            installActivateReminderConfig.parseJson(optJSONObject);
            setValue(installActivateReminderConfig);
            return;
        }
        setValue(m26495CH());
    }
}
