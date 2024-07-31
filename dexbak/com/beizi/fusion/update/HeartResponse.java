package com.beizi.fusion.update;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.model.GlobalConfig;
import com.beizi.fusion.model.IncentiveConfig;
import com.beizi.fusion.model.ResponseInfo;
import com.beizi.fusion.p066d.selfAdManagerHolder;
import com.beizi.fusion.p072g.AesUtils;
import com.beizi.fusion.p072g.C3112ad;
import com.beizi.fusion.p072g.C3137at;
import com.beizi.fusion.p072g.GzipUtil;

/* renamed from: com.beizi.fusion.update.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class HeartResponse {

    /* renamed from: a */
    private Context f11533a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HeartResponse(Context context, String str) {
        if (str == null) {
            return;
        }
        this.f11533a = context;
        m48108a(str);
    }

    /* renamed from: a */
    private void m48108a(String str) {
        String m48269b = AesUtils.m48269b(C3112ad.m48504a(), str);
        if (TextUtils.isEmpty(m48269b)) {
            return;
        }
        try {
            String m48151b = GzipUtil.m48151b(m48269b);
            String str2 = (String) C3137at.m48313b(this.f11533a, "globalConfig", "");
            if ("".equals(str2)) {
                C3137at.m48315a(this.f11533a, "globalConfig", (Object) AesUtils.m48270a(C3112ad.m48504a(), m48151b));
            }
            String m48269b2 = AesUtils.m48269b(C3112ad.m48504a(), str2);
            GlobalConfig objectFromData = GlobalConfig.objectFromData(m48151b);
            GlobalConfig objectFromData2 = GlobalConfig.objectFromData(m48269b2);
            if (objectFromData != null) {
                ResponseInfo.getInstance(this.f11533a).setGlobalConfig(objectFromData);
                if (!TextUtils.isEmpty(objectFromData.getConfigVersion())) {
                    if (objectFromData2 != null) {
                        objectFromData2.setConfigVersion(objectFromData.getConfigVersion());
                    }
                    if (ResponseInfo.getInstance(this.f11533a).getManager() == null) {
                        ResponseInfo.getInstance(this.f11533a).setConfigVersion(objectFromData.getConfigVersion());
                    }
                }
                if (objectFromData.getExpireTime() > 0) {
                    if (objectFromData2 != null) {
                        objectFromData2.setExpireTime(objectFromData.getExpireTime());
                    }
                    ResponseInfo.getInstance(this.f11533a).setExpireTime(objectFromData.getExpireTime());
                }
                if (objectFromData.getMaxValidTime() > 0) {
                    if (objectFromData2 != null) {
                        objectFromData2.setMaxValidTime(objectFromData.getMaxValidTime());
                    }
                    ResponseInfo.getInstance(this.f11533a).setMaxValidTime(objectFromData.getMaxValidTime());
                }
                if (objectFromData.getConfigurator() != null) {
                    if (objectFromData2 != null) {
                        objectFromData2.setConfigurator(objectFromData.getConfigurator());
                    }
                    if (ResponseInfo.getInstance(this.f11533a).getManager() == null) {
                        ResponseInfo.getInstance(this.f11533a).setConfigurator(objectFromData.getConfigurator());
                    }
                }
                if (objectFromData.getMessenger() != null) {
                    if (objectFromData2 != null) {
                        objectFromData2.setMessenger(objectFromData.getMessenger());
                    }
                    if (ResponseInfo.getInstance(this.f11533a).getManager() == null) {
                        ResponseInfo.getInstance(this.f11533a).setMessenger(objectFromData.getMessenger());
                    }
                }
                if (objectFromData.getManager() != null) {
                    if (objectFromData2 != null) {
                        objectFromData2.setManager(objectFromData.getManager());
                    }
                    if (ResponseInfo.getInstance(this.f11533a).getManager() == null) {
                        ResponseInfo.getInstance(this.f11533a).setManager(objectFromData.getManager());
                    }
                }
                if (objectFromData.getTaskConfig() != null) {
                    if (objectFromData2 != null) {
                        objectFromData2.setTaskConfig(objectFromData.getTaskConfig());
                    }
                    ResponseInfo.getInstance(this.f11533a).setTaskConfig(objectFromData.getTaskConfig());
                }
                if (objectFromData.getAdPlusConfig() != null) {
                    if (objectFromData2 != null) {
                        objectFromData2.setAdPlusConfig(objectFromData.getAdPlusConfig());
                    }
                    ResponseInfo.getInstance(this.f11533a).setAdPlusConfig(objectFromData.getAdPlusConfig());
                    selfAdManagerHolder.m48577a(this.f11533a);
                }
                IncentiveConfig incentiveConfig = objectFromData.getIncentiveConfig();
                if (incentiveConfig != null) {
                    if (objectFromData2 != null) {
                        objectFromData2.setIncentiveConfig(incentiveConfig);
                    }
                    ResponseInfo.getInstance(this.f11533a).setIncentiveConfig(incentiveConfig);
                    selfAdManagerHolder.m48576a(this.f11533a, incentiveConfig);
                }
                if (!TextUtils.isEmpty(objectFromData.getCrashUrl())) {
                    if (objectFromData2 != null) {
                        objectFromData2.setCrashUrl(objectFromData.getCrashUrl());
                    }
                    ResponseInfo.getInstance(this.f11533a).setCrashUrl(objectFromData.getCrashUrl());
                }
                String objectToJson = GlobalConfig.objectToJson(objectFromData2);
                if (TextUtils.isEmpty(objectToJson)) {
                    return;
                }
                C3137at.m48315a(this.f11533a, "globalConfig", (Object) AesUtils.m48270a(C3112ad.m48504a(), objectToJson));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
