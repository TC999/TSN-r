package com.kwad.sdk.core.config.item;

import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.utils.C11126t;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class TipsConfigItem extends AbstractC10254b<TipConfigData> {

    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class TipConfigData implements InterfaceC9914b, Serializable {
        private static final long serialVersionUID = 268961350883157950L;
        private String tipInfo;
        private transient Map<String, String> tipMap = new HashMap();
        private int tipShowSwitch;

        private void genTipMap(JSONObject jSONObject) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                this.tipMap.put(next, jSONObject.optString(next, ""));
            }
        }

        @Nullable
        public String getTipInfoData() {
            return this.tipInfo;
        }

        public int getTipShowSwitch() {
            return this.tipShowSwitch;
        }

        public String getTips(String str) {
            return this.tipMap.get(str);
        }

        public boolean isShowTips() {
            return this.tipShowSwitch == 0;
        }

        @Override // com.kwad.sdk.core.InterfaceC9914b
        public void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            setTipInfoData(jSONObject.optString("tipInfo"));
            this.tipShowSwitch = jSONObject.optInt("tipShowSwitch", 0);
        }

        public void setTipInfoData(String str) {
            this.tipInfo = str;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str) || "null".equalsIgnoreCase(str)) {
                return;
            }
            try {
                genTipMap(new JSONObject(str));
            } catch (Exception e) {
                C10331c.printStackTraceOnly(e);
            }
        }

        public void setTipShowSwitch(int i) {
            this.tipShowSwitch = i;
        }

        @Override // com.kwad.sdk.core.InterfaceC9914b
        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            C11126t.putValue(jSONObject, "tipShowSwitch", this.tipShowSwitch);
            C11126t.putValue(jSONObject, "tipInfo", this.tipInfo);
            return jSONObject;
        }
    }

    public TipsConfigItem() {
        super("tipConfig", new TipConfigData());
    }

    @Override // com.kwad.sdk.core.config.item.AbstractC10254b
    /* renamed from: a */
    public final void mo26480a(@NonNull SharedPreferences sharedPreferences) {
        TipConfigData value = getValue();
        if (value == null) {
            value = new TipConfigData();
        }
        value.setTipShowSwitch(sharedPreferences.getInt("tipsSwitch", 0));
        value.setTipInfoData(sharedPreferences.getString("tipsInfo", ""));
        setValue(value);
    }

    @Override // com.kwad.sdk.core.config.item.AbstractC10254b
    /* renamed from: b */
    public final void mo26479b(@NonNull SharedPreferences.Editor editor) {
        editor.putInt("tipsSwitch", getValue().getTipShowSwitch());
        if (getValue().getTipInfoData() != null) {
            editor.putString("tipsInfo", getValue().getTipInfoData());
        } else {
            editor.putString("tipsInfo", "");
        }
    }

    @Override // com.kwad.sdk.core.config.item.AbstractC10254b
    /* renamed from: k */
    public final void mo26478k(JSONObject jSONObject) {
        JSONObject optJSONObject;
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject(getKey())) != null) {
            TipConfigData tipConfigData = new TipConfigData();
            tipConfigData.parseJson(optJSONObject);
            setValue(tipConfigData);
            return;
        }
        setValue(m26495CH());
    }
}
