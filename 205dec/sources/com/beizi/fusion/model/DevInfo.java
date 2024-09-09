package com.beizi.fusion.model;

import android.content.Context;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.beizi.fusion.BeiZis;
import com.beizi.fusion.g.ai;
import com.beizi.fusion.g.au;
import com.beizi.fusion.g.av;
import com.beizi.fusion.g.aw;
import com.beizi.fusion.g.t;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class DevInfo {
    private static final String KEY_SDK_UID_NEW = "SDK_UID_KEY_NEW";
    private static final String KEY_SDK_UID_ORIG = "SDK_UID_KEY";
    private static final int algorithmVersion = 1;
    private String cnOaid;
    private Context context;
    private String density;
    private String densityDpi;
    private String devType;
    private String gaid;
    private String honorOaid;
    private String language;
    private String msaOaid;
    private String oaid;
    private String resolution;
    private String romVersion;
    private String root;
    private String screenSize;
    private String sdkUID;
    private String sdkUIDOrig;
    private String smOaid;
    private String os = t.c();
    private String platform = "2";
    private String brand = t.a();
    private String model = t.b();

    public DevInfo(Context context) {
        this.context = context;
        this.sdkUID = au.a(context, "SDK_UID_KEY_NEW");
        this.sdkUIDOrig = au.a(context, "SDK_UID_KEY");
        this.devType = t.d(context);
        getScreenInformation(context);
        this.language = Locale.getDefault().getLanguage();
        this.root = aw.a();
        if ((BeiZis.getCustomController() == null || BeiZis.getCustomController().isCanUseGaid()) && !((Boolean) au.b(context, "isLimitTrackGaid", Boolean.FALSE)).booleanValue()) {
            this.gaid = (String) au.b(context, "__GAID__", "");
        }
        if (TextUtils.isEmpty(this.sdkUID)) {
            generateSdkUID(context, this.brand, this.model);
        }
        this.romVersion = getCurrentRomVersion();
    }

    private String generateCurrentTimeMillis() {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.clear();
        calendar.set(2020, 0, 1, 0, 0, 0);
        return String.valueOf(System.currentTimeMillis() - calendar.getTimeInMillis());
    }

    private String generateFourDigitRandom() {
        Random random = new Random();
        return "" + random.nextInt(10) + random.nextInt(10) + random.nextInt(10) + random.nextInt(10);
    }

    private void generateSdkUID(Context context, String str, String str2) {
        String generateFourDigitRandom = generateFourDigitRandom();
        String generateCurrentTimeMillis = generateCurrentTimeMillis();
        String str3 = str + "_" + str2 + "_" + aw.c(context) + "_1_" + generateFourDigitRandom + "_" + generateCurrentTimeMillis;
        String str4 = av.a(str3) + "_1_" + generateFourDigitRandom + "_" + generateCurrentTimeMillis;
        this.sdkUID = str4;
        au.a(context, "SDK_UID_KEY_NEW", str4);
    }

    private String getCurrentRomVersion() {
        try {
            ai a4 = ai.a();
            a4.b();
            return a4.c();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private void getScreenInformation(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            this.resolution = displayMetrics.widthPixels + "_" + displayMetrics.heightPixels;
            float f4 = ((float) displayMetrics.heightPixels) / displayMetrics.ydpi;
            float f5 = ((float) displayMetrics.widthPixels) / displayMetrics.xdpi;
            double sqrt = Math.sqrt((double) ((f5 * f5) + (f4 * f4)));
            double pow = Math.pow(10.0d, 2.0d);
            Object[] objArr = new Object[1];
            double round = Math.round(sqrt * pow);
            Double.isNaN(round);
            objArr[0] = Double.valueOf(round / pow);
            this.screenSize = String.format("%.2f", objArr);
            this.density = context.getResources().getDisplayMetrics().density + "";
            this.densityDpi = context.getResources().getDisplayMetrics().densityDpi + "";
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public String getBrand() {
        return this.brand;
    }

    public String getCnOaid() {
        return this.cnOaid;
    }

    public String getDensity() {
        return this.density;
    }

    public String getDensityDpi() {
        return this.densityDpi;
    }

    public String getDevType() {
        return this.devType;
    }

    public String getGaid() {
        return this.gaid;
    }

    public String getHonorOaid() {
        return this.honorOaid;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getModel() {
        return this.model;
    }

    public String getMsaOaid() {
        return this.msaOaid;
    }

    public String getOaid() {
        return this.oaid;
    }

    public String getOs() {
        return this.os;
    }

    public String getPlatform() {
        return this.platform;
    }

    public String getResolution() {
        return this.resolution;
    }

    public String getRomVersion() {
        return this.romVersion;
    }

    public String getRoot() {
        return this.root;
    }

    public String getScreenSize() {
        return this.screenSize;
    }

    public String getSdkUID() {
        return this.sdkUID;
    }

    public String getSdkUIDOrig() {
        return this.sdkUIDOrig;
    }

    public String getSmOaid() {
        return this.smOaid;
    }

    public void setBrand(String str) {
        this.brand = str;
    }

    public void setCnOaid(String str) {
        this.cnOaid = str;
    }

    public void setDensity(String str) {
        this.density = str;
    }

    public void setDensityDpi(String str) {
        this.densityDpi = str;
    }

    public void setDevType(String str) {
        this.devType = str;
    }

    public void setGaid(String str) {
        this.gaid = str;
    }

    public void setHonorOaid(String str) {
        this.honorOaid = str;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public void setMsaOaid(String str) {
        this.msaOaid = str;
    }

    public void setOaid(String str) {
        this.oaid = str;
    }

    public void setOs(String str) {
        this.os = str;
    }

    public void setPlatform(String str) {
        this.platform = str;
    }

    public void setResolution(String str) {
        this.resolution = str;
    }

    public void setRomVersion(String str) {
        this.romVersion = str;
    }

    public void setRoot(String str) {
        this.root = str;
    }

    public void setScreenSize(String str) {
        this.screenSize = str;
    }

    public void setSdkUID(String str) {
        this.sdkUID = str;
    }

    public void setSdkUIDOrig(String str) {
        this.sdkUIDOrig = str;
    }

    public void setSmOaid(String str) {
        this.smOaid = str;
    }
}
