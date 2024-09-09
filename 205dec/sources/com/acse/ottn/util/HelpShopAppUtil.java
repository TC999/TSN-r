package com.acse.ottn.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.acse.ottn.R;
import com.acse.ottn.g1;
import com.acse.ottn.h1;
import com.acse.ottn.y2;
import com.acse.ottn.z1;
import java.io.ObjectStreamException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class HelpShopAppUtil {
    private static char[] hexCode = "0123456789ABCDEF".toCharArray();
    private static HelpShopAppUtil instance;
    private static Context mContext;

    private HelpShopAppUtil() {
    }

    private static String getAppIdFromMainfest(String str) {
        Bundle bundle;
        try {
            Context context = mContext;
            if (context == null) {
                return "S1_fa3451ccdb42c4383ce5dcd9ad74d919";
            }
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(mContext.getPackageName(), 128);
            if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                return bundle.getString(str);
            }
            return null;
        } catch (PackageManager.NameNotFoundException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static Context getContext() {
        return mContext;
    }

    public static String getHmKey() {
        try {
            String d4 = g1.a().d("APP_KEY");
            if (TextUtils.isEmpty(d4) || d4 == null) {
                d4 = getAppIdFromMainfest("APP_KEY");
                g1.a().b("APP_KEY", d4);
            }
            z1.a("HelpShopAppUtil", "APP_KEY =" + d4);
            return d4;
        } catch (Exception e4) {
            Log.d("TAG", e4.getMessage());
            return "S1_fa3451ccdb42c4383ce5dcd9ad74d919";
        }
    }

    public static HelpShopAppUtil getInstance() {
        if (instance == null) {
            synchronized (HelpShopAppUtil.class) {
                if (instance == null) {
                    instance = new HelpShopAppUtil();
                }
            }
        }
        return instance;
    }

    private static String getSessionId(String str) {
        byte[] bArr = new byte[0];
        try {
            bArr = MessageDigest.getInstance("MD5").digest(str.getBytes());
        } catch (NoSuchAlgorithmException e4) {
            e4.printStackTrace();
        }
        return printHexBinary(bArr);
    }

    private static void getWindowInfo() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) mContext.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i4 = displayMetrics.widthPixels;
        int i5 = displayMetrics.heightPixels;
        if (g1.a() != null) {
            g1.a().b("screenWidth", i4);
            g1.a().b("screenHight", i5);
        }
    }

    public static void init(Context context) {
        mContext = context;
        getWindowInfo();
        getHmKey();
    }

    public static void playVideo(Context context) {
        MediaPlayer create = MediaPlayer.create(context, R.raw.lucky_money);
        create.setVolume(0.3f, 0.3f);
        create.start();
    }

    private static String printHexBinary(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b4 : bArr) {
            sb.append(hexCode[(b4 >> 4) & 15]);
            sb.append(hexCode[b4 & 15]);
        }
        return sb.toString();
    }

    public static String randomSessionNewID() {
        String d4 = g1.a().d("sessionID");
        if (d4 == null || "".equals(d4)) {
            String substring = y2.c(String.valueOf((int) ((Math.random() * 9.9999999E7d) + 1.0d))).substring(0, 16);
            String hexString = Long.toHexString(new Long(System.currentTimeMillis()).longValue());
            String replace = String.format("%32s", "0" + hexString + substring).replace(' ', 'f');
            g1.a().b("sessionID", replace);
            return replace;
        }
        return d4;
    }

    private Object readResolve() throws ObjectStreamException {
        return instance;
    }

    public static String sessionID() {
        String d4 = g1.a().d("sessionID");
        return TextUtils.isEmpty(d4) ? randomSessionNewID() : d4;
    }

    public static String sessionNewID() {
        return sessionID();
    }

    public Long createRandomNumber() {
        if (g1.a() == null) {
            return 14400L;
        }
        if (g1.a().c("random_num").longValue() == 0) {
            g1.a().a("random_num", new Random().nextInt(7200) + 10800);
        }
        return g1.a().c("random_num");
    }

    public String getAppName() {
        return h1.c().b();
    }
}
