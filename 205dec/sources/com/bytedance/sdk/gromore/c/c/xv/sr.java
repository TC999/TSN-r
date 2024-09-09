package com.bytedance.sdk.gromore.c.c.xv;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr {
    public static Bundle c(com.bytedance.msdk.api.xv.c cVar) {
        Bundle bundle = new Bundle();
        if (cVar != null) {
            float amount = cVar.getAmount();
            String rewardName = cVar.getRewardName();
            Map<String, Object> customData = cVar.getCustomData();
            if (customData == null) {
                customData = new HashMap<>();
            }
            Object obj = customData.get("extraInfo");
            if (obj instanceof Bundle) {
                Bundle bundle2 = (Bundle) obj;
                bundle2.putFloat("reward_extra_key_reward_amount", amount);
                bundle2.putString("reward_extra_key_reward_name", rewardName);
                return bundle2;
            }
            bundle.putString("reward_extra_key_reward_name", rewardName);
            bundle.putFloat("reward_extra_key_reward_amount", amount);
            Object obj2 = customData.get("isGroMoreServerSideVerify");
            if (obj2 instanceof Boolean) {
                bundle.putBoolean("isGroMoreServerSideVerify", ((Boolean) obj2).booleanValue());
            }
            Object obj3 = customData.get("transId");
            if (obj3 instanceof String) {
                bundle.putString("transId", (String) obj3);
            }
            Object obj4 = customData.get("reason");
            if (obj4 instanceof Integer) {
                bundle.putInt("reason", ((Integer) obj4).intValue());
            }
            Object obj5 = customData.get("gromoreExtra");
            if (obj5 instanceof String) {
                bundle.putString("gromoreExtra", (String) obj5);
            }
            Object obj6 = customData.get("errorCode");
            if (obj6 instanceof Integer) {
                bundle.putInt("errorCode", ((Integer) obj6).intValue());
            }
            Object obj7 = customData.get("errorMsg");
            if (obj7 instanceof String) {
                bundle.putString("errorMsg", (String) obj7);
            }
            Object obj8 = customData.get("adnName");
            if (obj8 instanceof String) {
                bundle.putString("adnName", (String) obj8);
                return bundle;
            }
            return bundle;
        }
        return bundle;
    }
}
