package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.turingfd.sdk.ams.au.Date;
import java.util.HashMap;
import java.util.Map;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Ginkgo {

    /* renamed from: b  reason: collision with root package name */
    public static final String f52072b;

    /* renamed from: a  reason: collision with root package name */
    public final Handler f52073a;

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.Ginkgo$do  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class Cdo implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f52074c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Map f52075d;

        public Cdo(Ginkgo ginkgo, Context context, Map map) {
            this.f52074c = context;
            this.f52075d = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            Ginkgo.a(this.f52074c, this.f52075d);
        }
    }

    static {
        StringBuilder a4 = Almond.a("turingfd_conf_");
        a4.append(Betelnut.f51924a);
        a4.append("_");
        a4.append("au");
        f52072b = a4.toString();
    }

    public Ginkgo(Handler handler) {
        this.f52073a = handler;
    }

    public static String b(Context context, String str) {
        SharedPreferences sharedPreferences;
        try {
            sharedPreferences = context.getSharedPreferences(f52072b, 0);
        } catch (Throwable unused) {
            sharedPreferences = null;
        }
        if (sharedPreferences == null) {
            return "";
        }
        String string = sharedPreferences.getString(str, "");
        if (TextUtils.isEmpty(string)) {
            return string;
        }
        try {
            int i4 = Cherry.f51967a;
            int length = string.length() / 2;
            byte[] bArr = new byte[length];
            char[] charArray = string.toUpperCase().toCharArray();
            for (int i5 = 0; i5 < length; i5++) {
                int i6 = i5 * 2;
                bArr[i5] = (byte) (((byte) "0123456789ABCDEF".indexOf(charArray[i6 + 1])) | (((byte) "0123456789ABCDEF".indexOf(charArray[i6])) << 4));
            }
            return Cherry.a(Creturn.a(bArr, Creturn.a()), "UTF-8");
        } catch (Throwable unused2) {
            return "";
        }
    }

    public Date a(Context context) {
        try {
            String b4 = b(context, "101");
            if (TextUtils.isEmpty(b4)) {
                return Date.a(1);
            }
            long j4 = 0;
            try {
                j4 = Long.valueOf(b(context, "102")).longValue();
            } catch (Throwable unused) {
            }
            String b5 = b(context, "104");
            String b6 = b(context, "105");
            String b7 = b(context, "106");
            String b8 = b(context, "110");
            Date.Cdo cdo = new Date.Cdo(0);
            cdo.f52027b = j4;
            cdo.f52026a = b4;
            cdo.f52029d = b5;
            cdo.f52030e = b6;
            cdo.f52031f = b7;
            cdo.f52032g = b8;
            return new Date(cdo);
        } catch (Throwable unused2) {
            return Date.a(1);
        }
    }

    public void c(Context context, long j4) {
        a(context, "503", "" + j4, true);
    }

    public void b(Context context, long j4) {
        HashMap hashMap = new HashMap();
        hashMap.put("902", "" + j4);
        a(context, hashMap);
    }

    public void a(Context context, long j4) {
        if (j4 >= Long.MAX_VALUE) {
            j4 = Long.MAX_VALUE;
        }
        a(context, "401", "" + j4, true);
    }

    public GalacticCore<Long> a(Context context, int i4) {
        System.currentTimeMillis();
        GalacticCore<Long> galacticCore = new GalacticCore<>(i4);
        for (String str : b(context, "402").split("_")) {
            try {
                galacticCore.a(Long.valueOf(Long.valueOf(str).longValue()));
            } catch (NumberFormatException unused) {
            }
        }
        return galacticCore;
    }

    public static void a(Context context, Map<String, String> map) {
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        try {
            sharedPreferences = context.getSharedPreferences(f52072b, 0);
        } catch (Throwable unused) {
            sharedPreferences = null;
        }
        if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
            return;
        }
        for (String str : map.keySet()) {
            try {
                edit.putString(str, Cherry.a(Creturn.b(map.get(str).getBytes(), Creturn.a())));
            } catch (Throwable unused2) {
            }
        }
        try {
            edit.commit();
        } catch (Throwable unused3) {
        }
    }

    public final void a(Context context, String str, String str2, boolean z3) {
        HashMap hashMap = new HashMap();
        hashMap.put(str, str2);
        a(context, hashMap, z3);
    }

    public final void a(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(str, str2);
        a(context, (Map<String, String>) hashMap, false);
    }

    public final void a(Context context, Map<String, String> map, boolean z3) {
        if (z3) {
            a(context, map);
        } else {
            this.f52073a.post(new Cdo(this, context, map));
        }
    }

    public final long a(Context context, String str) {
        try {
            return Long.valueOf(b(context, str)).longValue();
        } catch (Throwable unused) {
            return 0L;
        }
    }
}
