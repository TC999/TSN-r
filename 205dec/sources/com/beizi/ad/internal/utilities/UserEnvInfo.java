package com.beizi.ad.internal.utilities;

import com.beizi.ad.R;
import com.beizi.ad.c.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class UserEnvInfo {
    private static UserEnvInfo sUserEnvInfoInstance;
    public String ip;
    public e.c isp = e.c.ISP_OTHER;
    public boolean locationEnabled = true;
    private int mLocationDecimalDigits = -1;

    /* renamed from: net  reason: collision with root package name */
    public e.d f14022net;

    private UserEnvInfo() {
    }

    public static UserEnvInfo getInstance() {
        UserEnvInfo userEnvInfo;
        synchronized (UserEnvInfo.class) {
            if (sUserEnvInfoInstance == null) {
                sUserEnvInfoInstance = new UserEnvInfo();
                HaoboLog.v(HaoboLog.baseLogTag, HaoboLog.getString(R.string.init));
            }
            userEnvInfo = sUserEnvInfoInstance;
        }
        return userEnvInfo;
    }

    public int getLocationDecimalDigits() {
        return this.mLocationDecimalDigits;
    }

    public void setLocationDecimalDigits(int i4) {
        if (i4 > 6) {
            this.mLocationDecimalDigits = 6;
            String str = HaoboLog.baseLogTag;
            HaoboLog.w(str, "Out of range input " + i4 + ", set location digits after decimal to maximum 6");
        } else if (i4 >= -1) {
            this.mLocationDecimalDigits = i4;
        } else {
            this.mLocationDecimalDigits = -1;
            String str2 = HaoboLog.baseLogTag;
            HaoboLog.w(str2, "Negative input " + i4 + ", set location digits after decimal to default");
        }
    }
}
