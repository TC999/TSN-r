package cn.jpush.android.api;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class InAppSlotParams {

    /* renamed from: a  reason: collision with root package name */
    public int f4032a = 0;

    /* renamed from: b  reason: collision with root package name */
    public String f4033b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f4034c = "";

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        InAppSlotParams f4035a = new InAppSlotParams();

        public InAppSlotParams build() {
            return this.f4035a;
        }

        public Builder setAdEvent(String str) {
            this.f4035a.f4034c = str;
            return this;
        }

        public Builder setAdSlot(String str) {
            this.f4035a.f4033b = str;
            return this;
        }

        public Builder setSequence(int i4) {
            this.f4035a.f4032a = i4;
            return this;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public interface SLOT_KEY {
        public static final String EVENT = "event";
        public static final String SEQ = "sequence";
        public static final String SLOT = "slot";
    }

    public static Builder builder() {
        return new Builder();
    }

    public static InAppSlotParams parseJSONString(String str) {
        InAppSlotParams inAppSlotParams = new InAppSlotParams();
        try {
            JSONObject jSONObject = new JSONObject(str);
            inAppSlotParams.f4032a = jSONObject.optInt(SLOT_KEY.SEQ, 0);
            inAppSlotParams.f4033b = jSONObject.optString(SLOT_KEY.SLOT, "");
            inAppSlotParams.f4034c = jSONObject.optString("event", "");
        } catch (Throwable unused) {
        }
        return inAppSlotParams;
    }

    public String toJSONString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SLOT_KEY.SEQ, this.f4032a);
            jSONObject.put(SLOT_KEY.SLOT, this.f4033b);
            jSONObject.put("event", this.f4034c);
        } catch (JSONException unused) {
        }
        return jSONObject.toString();
    }

    public String toString() {
        return "InAppSlotParams{sequence=" + this.f4032a + ", adSlot='" + this.f4033b + "', adEvent='" + this.f4034c + "'}";
    }
}
