package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class ak {
    private static final String A = "b3JnLnNhbmRyb3Byb3h5LmRyb255";
    private static final String B = "aW8ueHVkd29mdGVuY2VudG1t";
    private static final String C = "Y29tLmp0anNiLnZpcnR1YWxkd3Nx";
    private static final String D = "Y29tLnR4eS5hbnl3aGVyZQ==";
    private static final String E = "Y29tLmRpbmd3ZWkueHVuaWpp";
    private static final String F = "bWUud2Vpc2h1LmV4cA==";
    private static final String G = "Y29tLnZhcmlhYmxlLmFwa2hvb2s=";
    private static final String H = "ZXUuZmFpcmNvZGUueGx1YQ==";
    private static final String I = "Y29tLnRvcGpvaG53dS5tYWdpc2s=";
    private static final String J = "Y29tLndpbmQuY290dGVy";
    private static final String K = "bW9iaS5hY3BtLmluc3BlY2thZ2U=";

    /* renamed from: a  reason: collision with root package name */
    private static final String f38002a = "Y29tLmdpdGh1Yi51aWF1dG9tYXRvcg==";

    /* renamed from: b  reason: collision with root package name */
    private static final String f38003b = "Y29tLmJ1c2NvZGUud2hhdHNpbnB1dA==";

    /* renamed from: c  reason: collision with root package name */
    private static final String f38004c = "b3JnLmF1dG9qcy5hdXRvanM=";

    /* renamed from: d  reason: collision with root package name */
    private static final String f38005d = "ZGUucm9idi5hbmRyb2lkLnhwb3NlZC5pbnN0YWxsZXI=";

    /* renamed from: e  reason: collision with root package name */
    private static final String f38006e = "Y29tLnNhbmZlbmdhbmRyb2lkLmRhdGFmaWx0ZXI=";

    /* renamed from: f  reason: collision with root package name */
    private static final String f38007f = "aXQuZXZpbHNvY2tldC5kc3Bsb2l0";

    /* renamed from: g  reason: collision with root package name */
    private static final String f38008g = "dWsuZGlnaXRhbHNxdWlkLm5ldHNwb29mZXI=";

    /* renamed from: h  reason: collision with root package name */
    private static final String f38009h = "Y29tLm13ci5keg==";

    /* renamed from: i  reason: collision with root package name */
    private static final String f38010i = "Y29tLm1ldGFzcGxvaXQuc3RhZ2U=";

    /* renamed from: j  reason: collision with root package name */
    private static final String f38011j = "Y29tLng4enMuc2FuZGJveA==";

    /* renamed from: k  reason: collision with root package name */
    private static final String f38012k = "Y29tLmYxcGxheWVy";

    /* renamed from: l  reason: collision with root package name */
    private static final String f38013l = "Y29tLmNvZmZhY2UuaXZhZGVy";

    /* renamed from: m  reason: collision with root package name */
    private static final String f38014m = "Y29tLmRldmljZS5lbXVsYXRvci5wcnA=";

    /* renamed from: n  reason: collision with root package name */
    private static final String f38015n = "Y29tLnVuaXF1ZS5tb2JpbGVmYWtlcg==";

    /* renamed from: o  reason: collision with root package name */
    private static final String f38016o = "bmV0LmdkaS5tb2R1bGUuYXBweA==";

    /* renamed from: p  reason: collision with root package name */
    private static final String f38017p = "b3JnLm1va2VlLm1rc2V0dGluZ3M=";

    /* renamed from: q  reason: collision with root package name */
    private static final String f38018q = "Y29tLm1pbmkubGl2ZS5saXZl";

    /* renamed from: r  reason: collision with root package name */
    private static final String f38019r = "dG9wLm5pdW5haWp1bi5ibGFja2JveGEzMg==";

    /* renamed from: s  reason: collision with root package name */
    private static final String f38020s = "dG9wLm5pdW5haWp1bi5ibGFja2JveGE2NA==";

    /* renamed from: t  reason: collision with root package name */
    private static final String f38021t = "dG9wLm5pdW5haWp1bi5ibGFja2RleGEzMg==";

    /* renamed from: u  reason: collision with root package name */
    private static final String f38022u = "dG9wLm5pdW5haWp1bi5ibGFja2RleGE2NA==";

    /* renamed from: v  reason: collision with root package name */
    private static final String f38023v = "aW8udmlydHVhbGFwcC5zYW5kdnhwb3NlZDMy";

    /* renamed from: w  reason: collision with root package name */
    private static final String f38024w = "aW8udmlydHVhbGFwcC5zYW5kdnhwb3NlZDY0";

    /* renamed from: x  reason: collision with root package name */
    private static final String f38025x = "enBwLndqeS56cG9zZWQuaW5zdGFsbGVy";

    /* renamed from: y  reason: collision with root package name */
    private static final String f38026y = "Y29tLnNrLnNwcm9tb3Rlcg==";

    /* renamed from: z  reason: collision with root package name */
    private static final String f38027z = "Y29tLnNlc2FtZS5wcm94eQ==";

    private JSONObject n(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (a(context, "aXQuZXZpbHNvY2tldC5kc3Bsb2l0")) {
                jSONObject.put("0", 1);
            }
            if (a(context, "dWsuZGlnaXRhbHNxdWlkLm5ldHNwb29mZXI=")) {
                jSONObject.put("1", 1);
            }
            if (a(context, "Y29tLm13ci5keg==")) {
                jSONObject.put("2", 1);
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private JSONObject o(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (a(context, "Y29tLmdpdGh1Yi51aWF1dG9tYXRvcg==")) {
                jSONObject.put("0", 1);
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private JSONObject p(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (a(context, "Y29tLng4enMuc2FuZGJveA==")) {
                jSONObject.put("0", 1);
            }
            if (a(context, "Y29tLmYxcGxheWVy")) {
                jSONObject.put("1", 1);
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private JSONObject q(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (a(context, "Y29tLmNvZmZhY2UuaXZhZGVy")) {
                jSONObject.put("0", 1);
            }
            if (a(context, "Y29tLmRldmljZS5lbXVsYXRvci5wcnA=")) {
                jSONObject.put("1", 1);
            }
            if (a(context, "Y29tLnVuaXF1ZS5tb2JpbGVmYWtlcg==")) {
                jSONObject.put("2", 1);
            }
            if (a(context, "bmV0LmdkaS5tb2R1bGUuYXBweA==")) {
                jSONObject.put("3", 1);
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    private JSONObject r(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (a(context, "b3JnLm1va2VlLm1rc2V0dGluZ3M=")) {
                jSONObject.put("0", 1);
            }
            if (a(context, "Y29tLm1pbmkubGl2ZS5saXZl")) {
                jSONObject.put("1", 1);
            }
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            int i4 = 1;
            jSONObject.put("0", a(context, "Y29tLmdpdGh1Yi51aWF1dG9tYXRvcg==") ? 1 : 0);
            jSONObject.put("1", a(context, "Y29tLmJ1c2NvZGUud2hhdHNpbnB1dA==") ? 1 : 0);
            jSONObject.put("2", a(context, "b3JnLmF1dG9qcy5hdXRvanM=") ? 1 : 0);
            jSONObject.put("3", a(context, "ZGUucm9idi5hbmRyb2lkLnhwb3NlZC5pbnN0YWxsZXI=") ? 1 : 0);
            if (!a(context, "Y29tLnNhbmZlbmdhbmRyb2lkLmRhdGFmaWx0ZXI=")) {
                i4 = 0;
            }
            jSONObject.put("4", i4);
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public int b(Context context) {
        return a(context, "Y29tLm1ldGFzcGxvaXQuc3RhZ2U=") ? 1 : 0;
    }

    public JSONObject c(Context context) {
        try {
            JSONObject o4 = o(context);
            if (o4 != null) {
                if (o4.length() > 0) {
                    return o4;
                }
                return null;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject d(Context context) {
        try {
            JSONObject n4 = n(context);
            if (n4 != null) {
                if (n4.length() > 0) {
                    return n4;
                }
                return null;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject e(Context context) {
        try {
            JSONObject p3 = p(context);
            if (p3 != null) {
                if (p3.length() > 0) {
                    return p3;
                }
                return null;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject f(Context context) {
        try {
            JSONObject q3 = q(context);
            if (q3 != null) {
                if (q3.length() > 0) {
                    return q3;
                }
                return null;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject g(Context context) {
        try {
            JSONObject r3 = r(context);
            if (r3 != null) {
                if (r3.length() > 0) {
                    return r3;
                }
                return null;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject h(Context context) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add("dG9wLm5pdW5haWp1bi5ibGFja2JveGEzMg==");
            arrayList.add("dG9wLm5pdW5haWp1bi5ibGFja2JveGE2NA==");
            JSONObject a4 = a(context, arrayList);
            if (a4 != null) {
                if (a4.length() > 0) {
                    return a4;
                }
                return null;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject i(Context context) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add("aW8udmlydHVhbGFwcC5zYW5kdnhwb3NlZDMy");
            arrayList.add("aW8udmlydHVhbGFwcC5zYW5kdnhwb3NlZDY0");
            arrayList.add("Y29tLndpbmQuY290dGVy");
            arrayList.add("bW9iaS5hY3BtLmluc3BlY2thZ2U=");
            JSONObject a4 = a(context, arrayList);
            if (a4 != null) {
                if (a4.length() > 0) {
                    return a4;
                }
                return null;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject j(Context context) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add("enBwLndqeS56cG9zZWQuaW5zdGFsbGVy");
            arrayList.add("Y29tLnNrLnNwcm9tb3Rlcg==");
            arrayList.add("Y29tLnZhcmlhYmxlLmFwa2hvb2s=");
            arrayList.add("ZXUuZmFpcmNvZGUueGx1YQ==");
            arrayList.add("Y29tLnRvcGpvaG53dS5tYWdpc2s=");
            JSONObject a4 = a(context, arrayList);
            if (a4 != null) {
                if (a4.length() > 0) {
                    return a4;
                }
                return null;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject k(Context context) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add("Y29tLnNlc2FtZS5wcm94eQ==");
            arrayList.add("b3JnLnNhbmRyb3Byb3h5LmRyb255");
            JSONObject a4 = a(context, arrayList);
            if (a4 != null) {
                if (a4.length() > 0) {
                    return a4;
                }
                return null;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject l(Context context) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add("aW8ueHVkd29mdGVuY2VudG1t");
            arrayList.add("Y29tLmp0anNiLnZpcnR1YWxkd3Nx");
            arrayList.add("Y29tLnR4eS5hbnl3aGVyZQ==");
            arrayList.add("Y29tLmRpbmd3ZWkueHVuaWpp");
            arrayList.add("bWUud2Vpc2h1LmV4cA==");
            JSONObject a4 = a(context, arrayList);
            if (a4 != null) {
                if (a4.length() > 0) {
                    return a4;
                }
                return null;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public JSONObject m(Context context) {
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add("dG9wLm5pdW5haWp1bi5ibGFja2RleGEzMg==");
            arrayList.add("dG9wLm5pdW5haWp1bi5ibGFja2RleGE2NA==");
            JSONObject a4 = a(context, arrayList);
            if (a4 != null) {
                if (a4.length() > 0) {
                    return a4;
                }
                return null;
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private static boolean a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (!str.contains(".")) {
                str = new String(c.a(str.getBytes(), 2));
            }
            context.getPackageManager().getApplicationInfo(str, 0);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private JSONObject a(Context context, List<String> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    JSONObject jSONObject = new JSONObject();
                    for (int i4 = 0; i4 < list.size(); i4++) {
                        if (a(context, list.get(i4))) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(i4);
                            jSONObject.put(sb.toString(), 1);
                        }
                    }
                    return jSONObject;
                }
                return null;
            } catch (Exception unused) {
                return null;
            }
        }
        return null;
    }

    public static String a() {
        try {
            StringBuilder sb = new StringBuilder();
            String[] strArr = {"/data/dalvik-cache/xposed_XResourcesSuperClass.dex", "data/dalvik-cache/xposed_XTypedArraySuperClass.dex", "/system/bin/androVM-prop", "/system/bin/nemuVM-prop", "/system/bin/ldmountsf", "/system/bin/noxspeedup", "/system/bin/nox-vbox-sf", "/system/bin/nox-prop", "/dev/qemu_pipe", "/dev/socket/qemud", "/system/lib/libc_malloc_debug_qemu.so", "/sys/qemu_trace", "/system/bin/qemu-props", "/dev/socket/genyd", "/dev/socket/baseband_genyd", "/system/bin/ttVM-prop", "/system/bin/3btrans", "/system/bin/droid4x-prop", "/ueventd.nox.rc", "/init.nox.rc"};
            for (int i4 = 0; i4 < 20; i4++) {
                if (new File(strArr[i4]).exists()) {
                    sb.append("1");
                } else {
                    sb.append("0");
                }
            }
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }
}
