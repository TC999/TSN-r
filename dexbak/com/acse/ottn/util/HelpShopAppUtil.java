package com.acse.ottn.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.acse.ottn.C1239R;
import io.netty.handler.codec.http.HttpConstants;
import java.io.ObjectStreamException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
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
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Context getContext() {
        return mContext;
    }

    public static String getHmKey() {
        try {
            String m56086d = C1661ba.m56097a().m56086d("APP_KEY");
            if (TextUtils.isEmpty(m56086d) || m56086d == null) {
                m56086d = getAppIdFromMainfest("APP_KEY");
                C1661ba.m56097a().m56088b("APP_KEY", m56086d);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("APP_KEY =");
            sb.append(m56086d);
            C1694ra.m55917a("HelpShopAppUtil", sb.toString());
            return m56086d;
        } catch (Exception unused) {
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
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return printHexBinary(bArr);
    }

    private static void getWindowInfo() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) mContext.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        if (C1661ba.m56097a() != null) {
            C1661ba.m56097a().m56089b("screenWidth", i);
            C1661ba.m56097a().m56089b("screenHight", i2);
        }
    }

    public static void init(Context context) {
        mContext = context;
        getWindowInfo();
        getHmKey();
    }

    public static void playVideo(Context context) {
        MediaPlayer create = MediaPlayer.create(context, C1239R.raw.lucky_money);
        create.setVolume(0.3f, 0.3f);
        create.start();
    }

    private static String printHexBinary(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            sb.append(hexCode[(b >> 4) & 15]);
            sb.append(hexCode[b & 15]);
        }
        return sb.toString();
    }

    public static String randomSessionNewID() {
        String m56086d = C1661ba.m56097a().m56086d("sessionID");
        if (m56086d == null || "".equals(m56086d)) {
            String substring = C1712za.m55869c(String.valueOf((int) ((Math.random() * 9.9999999E7d) + 1.0d))).substring(0, 16);
            String hexString = Long.toHexString(new Long(System.currentTimeMillis()).longValue());
            String replace = String.format("%32s", "0" + hexString + substring).replace(HttpConstants.SP_CHAR, 'f');
            C1661ba.m56097a().m56088b("sessionID", replace);
            return replace;
        }
        return m56086d;
    }

    private Object readResolve() throws ObjectStreamException {
        return instance;
    }

    public static String sessionID() {
        String m56086d = C1661ba.m56097a().m56086d("sessionID");
        return TextUtils.isEmpty(m56086d) ? randomSessionNewID() : m56086d;
    }

    public static String sessionNewID() {
        return sessionID();
    }

    public Long createRandomNumber() {
        if (C1661ba.m56097a() == null) {
            return 14400L;
        }
        if (C1661ba.m56097a().m56087c("random_num").longValue() == 0) {
            C1661ba.m56097a().m56094a("random_num", new Random().nextInt(7200) + 10800);
        }
        return C1661ba.m56097a().m56087c("random_num");
    }

    public String getAppName() {
        return C1663ca.m56080c().m56081b();
    }
}
