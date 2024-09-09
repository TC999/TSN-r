package com.beizi.fusion.update;

import android.content.Context;
import android.text.TextUtils;
import com.beizi.fusion.d.w;
import com.beizi.fusion.g.ad;
import com.beizi.fusion.g.au;
import com.beizi.fusion.g.d;
import com.beizi.fusion.g.z;
import com.beizi.fusion.model.GlobalConfig;
import com.beizi.fusion.model.IncentiveConfig;
import com.beizi.fusion.model.ResponseInfo;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: HeartResponse.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private Context f15117a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f15118b = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context, String str) {
        if (str == null) {
            return;
        }
        this.f15117a = context;
        a(str);
    }

    private void a(String str) {
        try {
            String b4 = d.b(ad.a(), str);
            if (TextUtils.isEmpty(b4)) {
                this.f15118b = false;
                return;
            }
            String b5 = z.b(b4);
            if (!TextUtils.isEmpty(b5) && !b5.equalsIgnoreCase("null")) {
                String str2 = (String) au.b(this.f15117a, "globalConfig", "");
                if ("".equals(str2)) {
                    au.a(this.f15117a, "globalConfig", (Object) d.a(ad.a(), b5));
                }
                String b6 = d.b(ad.a(), str2);
                GlobalConfig objectFromData = GlobalConfig.objectFromData(b5);
                GlobalConfig objectFromData2 = GlobalConfig.objectFromData(b6);
                if (objectFromData != null) {
                    ResponseInfo.getInstance(this.f15117a).setGlobalConfig(objectFromData);
                    if (!TextUtils.isEmpty(objectFromData.getConfigVersion())) {
                        if (objectFromData2 != null) {
                            objectFromData2.setConfigVersion(objectFromData.getConfigVersion());
                        }
                        if (ResponseInfo.getInstance(this.f15117a).getManager() == null) {
                            ResponseInfo.getInstance(this.f15117a).setConfigVersion(objectFromData.getConfigVersion());
                        }
                    }
                    if (objectFromData.getExpireTime() > 0) {
                        if (objectFromData2 != null) {
                            objectFromData2.setExpireTime(objectFromData.getExpireTime());
                        }
                        ResponseInfo.getInstance(this.f15117a).setExpireTime(objectFromData.getExpireTime());
                    }
                    if (objectFromData.getMaxValidTime() > 0) {
                        if (objectFromData2 != null) {
                            objectFromData2.setMaxValidTime(objectFromData.getMaxValidTime());
                        }
                        ResponseInfo.getInstance(this.f15117a).setMaxValidTime(objectFromData.getMaxValidTime());
                    }
                    if (objectFromData.getConfigurator() != null) {
                        if (objectFromData2 != null) {
                            objectFromData2.setConfigurator(objectFromData.getConfigurator());
                        }
                        if (ResponseInfo.getInstance(this.f15117a).getManager() == null) {
                            ResponseInfo.getInstance(this.f15117a).setConfigurator(objectFromData.getConfigurator());
                        }
                    }
                    if (objectFromData.getMessenger() != null) {
                        if (objectFromData2 != null) {
                            objectFromData2.setMessenger(objectFromData.getMessenger());
                        }
                        if (ResponseInfo.getInstance(this.f15117a).getManager() == null) {
                            ResponseInfo.getInstance(this.f15117a).setMessenger(objectFromData.getMessenger());
                        }
                    }
                    if (objectFromData.getManager() != null) {
                        if (objectFromData2 != null) {
                            objectFromData2.setManager(objectFromData.getManager());
                        }
                        if (ResponseInfo.getInstance(this.f15117a).getManager() == null) {
                            ResponseInfo.getInstance(this.f15117a).setManager(objectFromData.getManager());
                        }
                    }
                    if (objectFromData.getTaskConfig() != null) {
                        if (objectFromData2 != null) {
                            objectFromData2.setTaskConfig(objectFromData.getTaskConfig());
                        }
                        ResponseInfo.getInstance(this.f15117a).setTaskConfig(objectFromData.getTaskConfig());
                    }
                    if (objectFromData.getAdPlusConfig() != null) {
                        if (objectFromData2 != null) {
                            objectFromData2.setAdPlusConfig(objectFromData.getAdPlusConfig());
                        }
                        ResponseInfo.getInstance(this.f15117a).setAdPlusConfig(objectFromData.getAdPlusConfig());
                        w.a(this.f15117a);
                    }
                    IncentiveConfig incentiveConfig = objectFromData.getIncentiveConfig();
                    if (incentiveConfig != null) {
                        if (objectFromData2 != null) {
                            objectFromData2.setIncentiveConfig(incentiveConfig);
                        }
                        ResponseInfo.getInstance(this.f15117a).setIncentiveConfig(incentiveConfig);
                    }
                    if (!TextUtils.isEmpty(objectFromData.getCrashUrl())) {
                        if (objectFromData2 != null) {
                            objectFromData2.setCrashUrl(objectFromData.getCrashUrl());
                        }
                        ResponseInfo.getInstance(this.f15117a).setCrashUrl(objectFromData.getCrashUrl());
                    }
                    String objectToJson = GlobalConfig.objectToJson(objectFromData2);
                    if (TextUtils.isEmpty(objectToJson)) {
                        return;
                    }
                    au.a(this.f15117a, "globalConfig", (Object) d.a(ad.a(), objectToJson));
                    return;
                }
                return;
            }
            this.f15118b = false;
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public boolean a() {
        return this.f15118b;
    }
}
