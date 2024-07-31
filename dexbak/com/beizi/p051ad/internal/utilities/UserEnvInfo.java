package com.beizi.p051ad.internal.utilities;

import com.beizi.p051ad.C2750R;
import com.beizi.p051ad.p056c.EnumType;

/* renamed from: com.beizi.ad.internal.utilities.UserEnvInfo */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class UserEnvInfo {
    private static UserEnvInfo sUserEnvInfoInstance;

    /* renamed from: ip */
    public String f10420ip;
    public EnumType.EnumC2814c isp = EnumType.EnumC2814c.ISP_OTHER;
    public boolean locationEnabled = true;
    private int mLocationDecimalDigits = -1;

    /* renamed from: net  reason: collision with root package name */
    public EnumType.EnumC2815d f47179net;

    private UserEnvInfo() {
    }

    public static UserEnvInfo getInstance() {
        UserEnvInfo userEnvInfo;
        synchronized (UserEnvInfo.class) {
            if (sUserEnvInfoInstance == null) {
                sUserEnvInfoInstance = new UserEnvInfo();
                HaoboLog.m49286v(HaoboLog.baseLogTag, HaoboLog.getString(C2750R.C2755string.init));
            }
            userEnvInfo = sUserEnvInfoInstance;
        }
        return userEnvInfo;
    }

    public int getLocationDecimalDigits() {
        return this.mLocationDecimalDigits;
    }

    public void setLocationDecimalDigits(int i) {
        if (i > 6) {
            this.mLocationDecimalDigits = 6;
            String str = HaoboLog.baseLogTag;
            HaoboLog.m49284w(str, "Out of range input " + i + ", set location digits after decimal to maximum 6");
        } else if (i >= -1) {
            this.mLocationDecimalDigits = i;
        } else {
            this.mLocationDecimalDigits = -1;
            String str2 = HaoboLog.baseLogTag;
            HaoboLog.m49284w(str2, "Negative input " + i + ", set location digits after decimal to default");
        }
    }
}
