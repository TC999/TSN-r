package com.amap.api.location;

import com.amap.api.location.AMapLocationClientOption;
import com.autonavi.aps.amapapi.utils.b;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class AMapLocationQualityReport implements Cloneable {
    public static final int GPS_STATUS_MODE_SAVING = 3;
    public static final int GPS_STATUS_NOGPSPERMISSION = 4;
    public static final int GPS_STATUS_NOGPSPROVIDER = 1;
    public static final int GPS_STATUS_OFF = 2;
    public static final int GPS_STATUS_OK = 0;

    /* renamed from: b  reason: collision with root package name */
    private boolean f10649b = false;

    /* renamed from: c  reason: collision with root package name */
    private int f10650c = 2;

    /* renamed from: d  reason: collision with root package name */
    private int f10651d = 0;

    /* renamed from: e  reason: collision with root package name */
    private String f10652e = "UNKNOWN";

    /* renamed from: f  reason: collision with root package name */
    private long f10653f = 0;

    /* renamed from: g  reason: collision with root package name */
    private boolean f10654g = false;

    /* renamed from: a  reason: collision with root package name */
    AMapLocationClientOption.AMapLocationMode f10648a = AMapLocationClientOption.AMapLocationMode.Hight_Accuracy;

    public String getAdviseMessage() {
        StringBuffer stringBuffer = new StringBuffer();
        AMapLocationClientOption.AMapLocationMode aMapLocationMode = this.f10648a;
        if (aMapLocationMode != AMapLocationClientOption.AMapLocationMode.Battery_Saving) {
            int i4 = this.f10650c;
            if (i4 != 0) {
                if (i4 == 1) {
                    stringBuffer.append("\u60a8\u7684\u8bbe\u5907\u6ca1\u6709GPS\u6a21\u5757\u6216\u8005GPS\u6a21\u5757\u5f02\u5e38\uff0c\u65e0\u6cd5\u8fdb\u884cGPS\u5b9a\u4f4d\n");
                } else if (i4 == 2) {
                    stringBuffer.append("\u60a8\u7684\u8bbe\u5907\u5173\u95ed\u4e86GPS\u5b9a\u4f4d\u529f\u80fd\uff0c\u5f00\u542fGPS\u5b9a\u4f4d\u529f\u80fd\u6709\u52a9\u4e8e\u63d0\u9ad8\u5b9a\u4f4d\u7684\u7cbe\u786e\u5ea6\n");
                } else if (i4 == 3) {
                    stringBuffer.append("\u60a8\u7684\u8bbe\u5907\u5f53\u524d\u8bbe\u7f6e\u7684\u5b9a\u4f4d\u6a21\u5f0f\u4e0d\u5305\u542bGPS\u5b9a\u4f4d\uff0c\u9009\u62e9\u5305\u542bGPS\u6a21\u5f0f\u7684\u5b9a\u4f4d\u6a21\u5f0f\u6709\u52a9\u4e8e\u63d0\u9ad8\u5b9a\u4f4d\u7684\u7cbe\u786e\u5ea6\n");
                } else if (i4 == 4) {
                    stringBuffer.append("\u60a8\u7684\u8bbe\u7f6e\u7981\u7528\u4e86GPS\u5b9a\u4f4d\u6743\u9650\uff0c\u5f00\u542fGPS\u5b9a\u4f4d\u6743\u9650\u6709\u52a9\u4e8e\u63d0\u9ad8\u5b9a\u4f4d\u7684\u7cbe\u786e\u5ea6\n");
                }
            } else if (aMapLocationMode == AMapLocationClientOption.AMapLocationMode.Device_Sensors && this.f10651d < 4) {
                stringBuffer.append("\u5f53\u524dGPS\u4fe1\u53f7\u5f31\uff0c\u4f4d\u7f6e\u66f4\u65b0\u53ef\u80fd\u4f1a\u5ef6\u8fdf\n");
            }
        }
        if (this.f10648a != AMapLocationClientOption.AMapLocationMode.Device_Sensors) {
            if ("DISCONNECTED".equals(this.f10652e)) {
                stringBuffer.append("\u60a8\u7684\u8bbe\u5907\u672a\u8fde\u63a5\u5230\u7f51\u7edc\uff0c\u65e0\u6cd5\u8fdb\u884c\u7f51\u7edc\u5b9a\u4f4d\n");
            } else if ("2G".equals(this.f10652e)) {
                stringBuffer.append("\u60a8\u7684\u8bbe\u5907\u7f51\u7edc\u72b6\u6001\u4e0d\u592a\u597d\uff0c\u7f51\u7edc\u5b9a\u4f4d\u53ef\u80fd\u4f1a\u6709\u5ef6\u8fdf\n");
            }
            if (!this.f10649b) {
                stringBuffer.append("\u60a8\u7684\u8bbe\u5907WIFI\u5f00\u5173\u5df2\u5173\u95ed\uff0c\u6253\u5f00WIFI\u5f00\u5173\u6709\u52a9\u4e8e\u63d0\u9ad8\u5b9a\u4f4d\u7684\u6210\u529f\u7387\n");
            }
        }
        return stringBuffer.toString();
    }

    public int getGPSSatellites() {
        return this.f10651d;
    }

    public int getGPSStatus() {
        return this.f10650c;
    }

    public long getNetUseTime() {
        return this.f10653f;
    }

    public String getNetworkType() {
        return this.f10652e;
    }

    public boolean isInstalledHighDangerMockApp() {
        return this.f10654g;
    }

    public boolean isWifiAble() {
        return this.f10649b;
    }

    public void setGPSSatellites(int i4) {
        this.f10651d = i4;
    }

    public void setGpsStatus(int i4) {
        this.f10650c = i4;
    }

    public void setInstallHighDangerMockApp(boolean z3) {
        this.f10654g = z3;
    }

    public void setLocationMode(AMapLocationClientOption.AMapLocationMode aMapLocationMode) {
        this.f10648a = aMapLocationMode;
    }

    public void setNetUseTime(long j4) {
        this.f10653f = j4;
    }

    public void setNetworkType(String str) {
        this.f10652e = str;
    }

    public void setWifiAble(boolean z3) {
        this.f10649b = z3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: clone */
    public AMapLocationQualityReport m17clone() {
        AMapLocationQualityReport aMapLocationQualityReport = new AMapLocationQualityReport();
        try {
            super.clone();
        } catch (Throwable unused) {
        }
        try {
            aMapLocationQualityReport.setGpsStatus(this.f10650c);
            aMapLocationQualityReport.setGPSSatellites(this.f10651d);
            aMapLocationQualityReport.setWifiAble(this.f10649b);
            aMapLocationQualityReport.setNetUseTime(this.f10653f);
            aMapLocationQualityReport.setNetworkType(this.f10652e);
            aMapLocationQualityReport.setLocationMode(this.f10648a);
            aMapLocationQualityReport.setInstallHighDangerMockApp(this.f10654g);
        } catch (Throwable th) {
            b.a(th, "AMapLocationQualityReport", "clone");
        }
        return aMapLocationQualityReport;
    }
}
