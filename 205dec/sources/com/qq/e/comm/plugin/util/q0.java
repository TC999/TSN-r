package com.qq.e.comm.plugin.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class q0 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f46570a = "q0";

    /* renamed from: b  reason: collision with root package name */
    private static volatile b f46571b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public String f46572a;

        /* renamed from: b  reason: collision with root package name */
        public String[] f46573b;

        /* renamed from: c  reason: collision with root package name */
        public String f46574c;

        /* renamed from: d  reason: collision with root package name */
        public long f46575d;

        private b() {
        }
    }

    public static long a() {
        return 15L;
    }

    public static Intent a(Context context, String str, long j4) {
        if (TextUtils.isEmpty(str) || !a(j4)) {
            return null;
        }
        String[] strArr = f46571b.f46573b;
        String str2 = f46571b.f46574c;
        if (strArr != null) {
            for (String str3 : strArr) {
                if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
                    String format = String.format(str2, str);
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(format));
                    intent.setPackage(str3);
                    intent.addFlags(268435456);
                    Intent a4 = a(context, intent);
                    if (a4 != null) {
                        d1.a("gdt_tag_appstore", "pkgName=%s, uri=%s", str3, format);
                        return a4;
                    }
                }
            }
            return null;
        }
        return null;
    }

    private static boolean b(long j4) {
        if (j4 <= 0) {
            return false;
        }
        if (f46571b == null) {
            d();
        }
        return f46571b != null && f46571b.f46575d == j4;
    }

    public static String[] c() {
        if (f46571b == null) {
            d();
        }
        if (f46571b == null) {
            return null;
        }
        return f46571b.f46573b;
    }

    private static synchronized void d() {
        byte[] decode;
        synchronized (q0.class) {
            if (f46571b != null) {
                return;
            }
            String c4 = com.qq.e.comm.plugin.d0.a.d().f().c("smfs");
            if (TextUtils.isEmpty(c4) && (decode = Base64.decode("W3sibSI6MSwibiI6IkhVQVdFSSIsInAiOiJjb20uaHVhd2VpLmFwcG1hcmtldCJ9LHsibSI6MiwibiI6IlhJQU9NSSIsInAiOiJjb20ueGlhb21pLm1hcmtldCJ9LHsibSI6NCwibiI6Ik9QUE8iLCJwIjoiY29tLm9wcG8ubWFya2V0LGNvbS5oZXl0YXAubWFya2V0In0seyJtIjo4LCJuIjoiVklWTyIsInAiOiJjb20uYmJrLmFwcHN0b3JlIn0seyJtIjoxNiwibiI6IkhPTk9SIiwicCI6ImNvbS5odWF3ZWkuYXBwbWFya2V0In0seyJtIjozMiwibiI6IlNBTVNVTkciLCJwIjoiY29tLnNlYy5hbmRyb2lkLmFwcC5zYW1zdW5nYXBwcyIsInUiOiJzYW1zdW5nYXBwczovL1Byb2R1Y3REZXRhaWwvJXMifSx7Im0iOjY0LCJuIjoiTUVJWlUiLCJwIjoiY29tLm1laXp1Lm1zdG9yZSJ9LHsibSI6MTI4LCJuIjoiWlRFIiwicCI6Inp0ZS5jb20ubWFya2V0In0seyJtIjoyNTYsIm4iOiJSRURNSSIsInAiOiJjb20ueGlhb21pLm1hcmtldCJ9LHsibSI6NTEyLCJuIjoiTlVCSUEiLCJwIjoiY29tLm51YmlhLm5lb3N0b3JlIn0seyJtIjoxMDI0LCJuIjoiUkVBTE1FIiwicCI6ImNvbS5vcHBvLm1hcmtldCxjb20uaGV5dGFwLm1hcmtldCJ9LHsibSI6MjA0OCwibiI6Ik9ORVBMVVMiLCJwIjoiY29tLm9wcG8ubWFya2V0LGNvbS5oZXl0YXAubWFya2V0In0seyJtIjo0MDk2LCJuIjoiMzYwIiwicCI6ImNvbS5xaWhvby5hcHBzdG9yZSxjb20ubWFya2V0LmNoZW54aWFuZyJ9XQ==", 0)) != null) {
                c4 = new String(decode, com.qq.e.comm.plugin.k.a.f44515a);
            }
            try {
                JSONArray jSONArray = new JSONArray(c4);
                int length = jSONArray.length();
                for (int i4 = 0; i4 < length; i4++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i4);
                    if (optJSONObject != null) {
                        b bVar = new b();
                        bVar.f46572a = optJSONObject.optString("n");
                        String optString = optJSONObject.optString("p");
                        if (optString != null) {
                            bVar.f46573b = optString.split(",");
                        }
                        bVar.f46574c = optJSONObject.optString("u", "market://details?id=%s");
                        bVar.f46575d = optJSONObject.optLong("m");
                        if (TextUtils.isEmpty(bVar.f46572a)) {
                            continue;
                        } else {
                            String[] split = bVar.f46572a.split(",");
                            if (split.length > 0) {
                                for (String str : split) {
                                    if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase(Build.MANUFACTURER)) {
                                        f46571b = bVar;
                                        return;
                                    }
                                }
                                continue;
                            } else {
                                continue;
                            }
                        }
                    }
                }
            } catch (JSONException e4) {
                d1.a(f46570a, e4.getMessage());
            }
        }
    }

    public static boolean e() {
        return b(8L);
    }

    public static long b() {
        if (f46571b == null) {
            d();
        }
        if (f46571b == null) {
            return 0L;
        }
        return f46571b.f46575d;
    }

    private static Intent a(Context context, Intent intent) {
        if (context.getPackageManager().resolveActivity(intent, 65536) != null) {
            return intent;
        }
        return null;
    }

    public static boolean a(long j4) {
        if (j4 <= 0) {
            return false;
        }
        if (f46571b == null) {
            d();
        }
        return f46571b != null && (j4 & f46571b.f46575d) > 0;
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (f46571b == null) {
            d();
        }
        if (f46571b == null || TextUtils.isEmpty(f46571b.f46574c)) {
            return null;
        }
        return String.format(f46571b.f46574c, str);
    }
}
