package com.bytedance.sdk.openadsdk.core.eq;

import android.content.Context;
import android.hardware.usb.UsbAccessory;
import android.hardware.usb.UsbManager;
import android.net.ConnectivityManager;
import android.os.Build;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.bytedance.sdk.component.panglearmor.c.sr;
import com.bytedance.sdk.openadsdk.core.u.wo;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class q {

    /* renamed from: c  reason: collision with root package name */
    public static int f33288c = 0;
    private static int sr = 300;
    private static sr.c ux = null;

    /* renamed from: w  reason: collision with root package name */
    public static int f33289w = 1;
    public static int xv = 2;

    public static void c() {
        gd();
        sr();
        if (com.bytedance.sdk.openadsdk.core.ls.w().mt()) {
            ux();
            xv();
            r();
        }
    }

    @DungeonFlag
    public static void ev() {
        com.bytedance.sdk.openadsdk.n.f.w(new com.bytedance.sdk.component.gd.p("rep_hdw") { // from class: com.bytedance.sdk.openadsdk.core.eq.q.3
            @Override // java.lang.Runnable
            public void run() {
                final JSONObject xv2 = com.bytedance.sdk.component.panglearmor.f.xv();
                if (xv2 != null) {
                    com.bytedance.sdk.openadsdk.core.fz.a.c().w(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.eq.q.3.1
                        @Override // com.bytedance.sdk.openadsdk.p.c.c
                        public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                            return com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c("device_hardware").w(xv2.toString());
                        }
                    }, "device_hardware");
                }
                final String w3 = com.bytedance.sdk.component.panglearmor.f.w();
                if (TextUtils.isEmpty(w3)) {
                    return;
                }
                com.bytedance.sdk.openadsdk.core.fz.a.c().w(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.eq.q.3.2
                    @Override // com.bytedance.sdk.openadsdk.p.c.c
                    public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                        return com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c("activation_time").w(w3);
                    }
                }, "activation_time");
            }
        });
    }

    public static boolean f() {
        try {
            return com.bytedance.sdk.component.panglearmor.sr.c(com.bytedance.sdk.openadsdk.core.ls.w().r());
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static String gd() {
        wo c4;
        try {
            if (!com.bytedance.sdk.openadsdk.core.ls.w().xq() || (c4 = com.bytedance.sdk.openadsdk.core.y.c.c(com.bytedance.sdk.openadsdk.core.ls.getContext()).c()) == null) {
                return null;
            }
            return c4.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean k() {
        try {
            TelephonyManager c4 = com.bytedance.sdk.openadsdk.core.i.c();
            if (c4 == null) {
                return false;
            }
            if (Build.VERSION.SDK_INT < 26) {
                return c4.getSimState() == 5 && c4.getDataState() != 0;
            } else if (c4.isDataEnabled()) {
                return true;
            } else {
                TelephonyManager createForSubscriptionId = c4.createForSubscriptionId(SubscriptionManager.getDefaultSubscriptionId());
                return createForSubscriptionId != null && createForSubscriptionId.isDataEnabled();
            }
        } catch (Exception unused) {
            return false;
        }
    }

    public static String p() {
        return com.bytedance.sdk.component.panglearmor.f.sr();
    }

    public static void r() {
        Context context = com.bytedance.sdk.openadsdk.core.ls.getContext();
        if (context != null) {
            JSONObject jSONObject = new JSONObject();
            com.bytedance.sdk.openadsdk.core.y.c.xv c4 = com.bytedance.sdk.openadsdk.core.y.c.xv.c(context);
            try {
                jSONObject.put("access_perm", com.bytedance.sdk.openadsdk.core.j.w.c(context, "android.permission.ACCESS_NETWORK_STATE"));
                jSONObject.put("change_perm", com.bytedance.sdk.openadsdk.core.j.w.c(context, "android.permission.CHANGE_NETWORK_STATE"));
                jSONObject.put("sim", com.bytedance.sdk.openadsdk.core.y.c.ux.c());
                int c5 = c4.c();
                jSONObject.put("network", c5);
                if (c5 == 1) {
                    jSONObject.put("cellular", c((ConnectivityManager) context.getSystemService("connectivity"), jSONObject));
                    jSONObject.put("cellular2", k());
                }
                c(jSONObject.toString(), "uaid_info");
            } catch (Throwable unused) {
            }
        }
    }

    public static String sr() {
        try {
            return com.bytedance.sdk.component.panglearmor.f.c();
        } catch (Throwable th) {
            th.printStackTrace();
            return c(th);
        }
    }

    public static void ux() {
        String[] ju = com.bytedance.sdk.openadsdk.core.ls.w().ju();
        if (ju == null || ju.length <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : ju) {
            try {
                Class.forName(str);
                arrayList.add(str);
            } catch (ClassNotFoundException unused) {
            }
        }
        if (arrayList.size() > 0) {
            c(arrayList);
        }
    }

    public static JSONArray w() {
        UsbAccessory[] accessoryList = ((UsbManager) com.bytedance.sdk.openadsdk.core.ls.getContext().getSystemService("usb")).getAccessoryList();
        JSONArray jSONArray = new JSONArray();
        if (accessoryList != null) {
            for (UsbAccessory usbAccessory : accessoryList) {
                if (usbAccessory != null) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("manufacturer", usbAccessory.getManufacturer());
                        jSONObject.put("model", usbAccessory.getModel());
                        jSONObject.put("desc", usbAccessory.getDescription());
                        jSONObject.put("uri", usbAccessory.getUri());
                        jSONArray.put(jSONObject);
                    } catch (JSONException e4) {
                        e4.printStackTrace();
                    }
                }
            }
        }
        return jSONArray;
    }

    public static void xv() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray w3 = w();
            if (w3.length() > 0) {
                jSONObject.put("usb", w3);
            }
            JSONObject jSONObject2 = new JSONObject();
            ClassLoader classLoader = Class.forName("com.bytedance.sdk.openadsdk.TTFileProvider").getClassLoader();
            if (classLoader != null) {
                jSONObject2.put("loader", classLoader.getClass().getName());
                Class<? super Object> superclass = classLoader.getClass().getSuperclass();
                while (true) {
                    if (superclass == null || superclass.getName().equals("java.lang.Object")) {
                        break;
                    } else if (superclass.getName().equals("dalvik.system.BaseDexClassLoader")) {
                        c(classLoader, superclass, jSONObject2);
                        break;
                    } else {
                        superclass = superclass.getSuperclass();
                    }
                }
            }
            jSONObject.put("control", jSONObject2);
        } catch (Throwable unused) {
        }
        if (jSONObject.length() > 0) {
            c(jSONObject.toString(), "pangle_check");
        }
    }

    private static void c(ClassLoader classLoader, Class<?> cls, JSONObject jSONObject) throws Exception {
        Field declaredField = cls.getDeclaredField("pathList");
        declaredField.setAccessible(true);
        Object obj = declaredField.get(classLoader);
        if (obj != null) {
            Field declaredField2 = obj.getClass().getDeclaredField("dexElements");
            declaredField2.setAccessible(true);
            Object[] objArr = (Object[]) declaredField2.get(obj);
            if (objArr != null) {
                jSONObject.put("size", objArr.length);
                StringBuilder sb = new StringBuilder();
                for (Object obj2 : objArr) {
                    Field declaredField3 = obj2.getClass().getDeclaredField("dexFile");
                    declaredField3.setAccessible(true);
                    Object obj3 = declaredField3.get(obj2);
                    if (obj3 != null && !obj3.toString().startsWith("/data/app")) {
                        sb.append(obj3);
                        sb.append(";");
                    }
                }
                jSONObject.put("dexPathList", sb);
            }
        }
    }

    public static void c(final String str, final String str2) {
        com.bytedance.sdk.openadsdk.core.fz.a.c().w(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.eq.q.1
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() {
                return com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c(str2).w(str);
            }
        }, str2);
    }

    public static void c(MotionEvent motionEvent) {
        try {
            com.bytedance.sdk.component.panglearmor.f.c(motionEvent);
        } catch (Throwable unused) {
        }
    }

    public static String c(String str, long j4, int i4, boolean z3) {
        try {
            return com.bytedance.sdk.component.panglearmor.f.c(str, j4, i4, z3);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void c(long j4, int i4) {
        try {
            com.bytedance.sdk.component.panglearmor.f.c(j4, i4);
        } catch (Throwable unused) {
        }
    }

    public static int c(String str) {
        int i4 = f33288c;
        if (str != null && !str.isEmpty()) {
            int indexOf = str.indexOf("_");
            if (indexOf <= 0) {
                return xv;
            }
            String substring = str.substring(0, indexOf);
            String substring2 = str.substring(indexOf + 1);
            int indexOf2 = substring2.indexOf("_");
            if (indexOf2 <= 0) {
                return xv;
            }
            String substring3 = substring2.substring(0, indexOf2);
            String substring4 = substring2.substring(indexOf2 + 1);
            long longValue = Long.valueOf(substring).longValue() - Long.valueOf(substring3).longValue();
            try {
                if (!com.bytedance.sdk.component.panglearmor.sr.c(substring3 + "_" + com.bytedance.sdk.openadsdk.core.i.xv(), substring4)) {
                    i4 = xv;
                } else if (Math.abs(longValue) > sr) {
                    i4 = f33289w;
                }
                return i4;
            } catch (Throwable unused) {
                return f33288c;
            }
        }
        return xv;
    }

    public static String c(Throwable th) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("stts", 3);
            jSONObject.put("exception:", th.toString());
            jSONObject.put("stacktrace:", Arrays.toString(th.getStackTrace()));
            jSONObject.put("cause:", String.valueOf(th.getCause()));
            return Base64.encodeToString(jSONObject.toString().getBytes("UTF-8"), 0);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return "eyJzdHRzIjozfQ==";
        }
    }

    private static void c(final List<String> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.fz.a.c().w(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.eq.q.2
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("clz", list.toString());
                return com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c("pangle_clz_found").w(jSONObject.toString());
            }
        }, "pangle_clz_found");
    }

    private static boolean c(ConnectivityManager connectivityManager, JSONObject jSONObject) {
        try {
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(connectivityManager, new Object[0])).booleanValue();
        } catch (Exception e4) {
            if (jSONObject != null) {
                try {
                    jSONObject.put("exception", "" + e4.getMessage());
                } catch (Throwable unused) {
                }
            }
            return false;
        }
    }

    public static void c(final JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.fz.a.c().w(new com.bytedance.sdk.openadsdk.p.c.c() { // from class: com.bytedance.sdk.openadsdk.core.eq.q.4
            @Override // com.bytedance.sdk.openadsdk.p.c.c
            public com.bytedance.sdk.openadsdk.core.fz.c.c c() throws Exception {
                com.bytedance.sdk.component.utils.a.w("HARLOG", "automatic " + jSONObject);
                return com.bytedance.sdk.openadsdk.core.fz.c.xv.w().c("har_automatic").w(jSONObject.toString());
            }
        }, "har_automatic");
    }

    public static void c(int i4, final int i5) {
        if (com.bytedance.sdk.component.panglearmor.f.ux() == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean w3 = com.bytedance.sdk.component.panglearmor.c.ux.c().w();
        long ux2 = com.bytedance.sdk.component.panglearmor.c.ux.c().ux();
        boolean z3 = ((long) (i4 - 1)) % ux2 == 0;
        boolean z4 = currentTimeMillis - com.bytedance.sdk.component.panglearmor.c.sr.c().sr() > com.bytedance.sdk.component.panglearmor.c.ux.c().sr();
        boolean xv2 = com.bytedance.sdk.component.panglearmor.c.sr.c().xv();
        com.bytedance.sdk.component.utils.a.w("HARLOG", "sensor enalbe = " + w3 + ", count = " + z3 + ", show interval = " + ux2 + ", time interval = " + com.bytedance.sdk.component.panglearmor.c.ux.c().sr() + ", expire = " + com.bytedance.sdk.component.panglearmor.c.ux.c().xv() + ", azimuth_unit = " + com.bytedance.sdk.component.panglearmor.c.ux.c().f() + ", angle_unit = " + com.bytedance.sdk.component.panglearmor.c.ux.c().r() + ", isRegister = " + xv2);
        if (z3 && z4 && w3 && !xv2 && com.bytedance.sdk.component.panglearmor.c.sr.c().w() && ux == null) {
            ux = new sr.c() { // from class: com.bytedance.sdk.openadsdk.core.eq.q.5
                @Override // com.bytedance.sdk.component.panglearmor.c.sr.c
                public void c(JSONObject jSONObject) {
                    if (jSONObject != null) {
                        try {
                            jSONObject.put("scene", i5);
                        } catch (JSONException unused) {
                        }
                        q.c(jSONObject);
                    }
                }
            };
            com.bytedance.sdk.component.panglearmor.c.sr.c().c(ux);
        }
    }
}
