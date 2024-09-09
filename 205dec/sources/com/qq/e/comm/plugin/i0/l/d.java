package com.qq.e.comm.plugin.i0.l;

import android.net.InetAddresses;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import com.qq.e.comm.plugin.util.d1;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d extends LinkedHashMap {

    /* renamed from: i  reason: collision with root package name */
    private static final String f44251i = f.class.getSimpleName();

    /* renamed from: j  reason: collision with root package name */
    private static Field f44252j;

    /* renamed from: k  reason: collision with root package name */
    private static Field f44253k;

    /* renamed from: l  reason: collision with root package name */
    private static Method f44254l;

    /* renamed from: m  reason: collision with root package name */
    private static Method f44255m;

    /* renamed from: c  reason: collision with root package name */
    private Field f44256c;

    /* renamed from: d  reason: collision with root package name */
    private final Field f44257d;

    /* renamed from: e  reason: collision with root package name */
    private final Field f44258e;

    /* renamed from: f  reason: collision with root package name */
    private Constructor<?> f44259f;

    /* renamed from: g  reason: collision with root package name */
    private final CopyOnWriteArraySet<String> f44260g;

    /* renamed from: h  reason: collision with root package name */
    private long f44261h;

    public d() throws Exception {
        try {
            Field declaredField = Class.forName("java.net.AddressCache$AddressCacheKey").getDeclaredField("mHostname");
            declaredField.setAccessible(true);
            this.f44256c = declaredField;
        } catch (Throwable unused) {
        }
        Class<?> cls = Class.forName("java.net.AddressCache$AddressCacheEntry");
        Field declaredField2 = cls.getDeclaredField("value");
        declaredField2.setAccessible(true);
        this.f44257d = declaredField2;
        Field declaredField3 = cls.getDeclaredField("expiryNanos");
        declaredField3.setAccessible(true);
        this.f44258e = declaredField3;
        try {
            Constructor<?> declaredConstructor = cls.getDeclaredConstructor(Object.class);
            declaredConstructor.setAccessible(true);
            this.f44259f = declaredConstructor;
        } catch (Exception unused2) {
            Constructor<?> declaredConstructor2 = cls.getDeclaredConstructor(Object.class, Long.TYPE);
            declaredConstructor2.setAccessible(true);
            this.f44259f = declaredConstructor2;
        }
        try {
            Field declaredField4 = InetAddress.class.getDeclaredField("hostName");
            declaredField4.setAccessible(true);
            f44252j = declaredField4;
        } catch (Exception unused3) {
            Field declaredField5 = Class.forName("java.net.InetAddress$InetAddressHolder").getDeclaredField("hostName");
            declaredField5.setAccessible(true);
            f44253k = declaredField5;
            Method declaredMethod = InetAddress.class.getDeclaredMethod("holder", new Class[0]);
            declaredMethod.setAccessible(true);
            f44254l = declaredMethod;
        }
        this.f44260g = new CopyOnWriteArraySet<>(f.c().g());
    }

    private static String a(InetAddress... inetAddressArr) {
        return "";
    }

    private static InetAddress[] a(String str, List<String> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : list) {
            if (a(str2)) {
                try {
                    InetAddress byName = InetAddress.getByName(str2);
                    if (byName != null) {
                        if (f44252j != null) {
                            f44252j.set(byName, str);
                        } else if (f44253k != null && f44254l != null) {
                            f44253k.set(f44254l.invoke(byName, new Object[0]), str);
                        }
                        arrayList.add(byName);
                    } else {
                        String str3 = f44251i;
                        d1.a(str3, "getByName null, ip: " + str2);
                    }
                } catch (Exception e4) {
                    String str4 = f44251i;
                    d1.a(str4, "getByName failed, ip: " + str2, e4);
                }
            }
        }
        String str5 = f44251i;
        d1.a(str5, "getInetAddresses, ipSize: " + list.size() + ", ips: " + list + ", InetAddressSize: " + arrayList.size() + ", InetAddresses: " + a((InetAddress[]) arrayList.toArray(new InetAddress[0])));
        if (arrayList.size() == 0) {
            return null;
        }
        return (InetAddress[]) arrayList.toArray(new InetAddress[0]);
    }

    private static InetAddress[] b(String str) {
        List<String> a4 = a.b().a(str);
        if (a4 == null || a4.size() <= 0) {
            return null;
        }
        return a(str, a4);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        String str;
        Object newInstance;
        try {
            if (this.f44256c != null) {
                obj = this.f44256c.get(obj);
            }
            str = (String) obj;
        } catch (Exception e4) {
            String str2 = f44251i;
            d1.a(str2, "return AddressCacheEntry failed " + Log.getStackTraceString(e4));
        }
        if (!TextUtils.isEmpty(str) && this.f44260g.contains(str)) {
            InetAddress[] b4 = b(str);
            if (b4 != null && b4.length > 0) {
                if (this.f44259f.getParameterTypes().length == 1) {
                    newInstance = this.f44259f.newInstance(b4);
                } else {
                    newInstance = this.f44259f.newInstance(b4, Long.MAX_VALUE);
                }
                this.f44258e.set(newInstance, Long.MAX_VALUE);
                String str3 = f44251i;
                d1.a(str3, "host hit cache: " + str);
                return newInstance;
            }
            if (f.c().b() > 1) {
                f.c().a(false);
            }
            this.f44261h = SystemClock.elapsedRealtime();
            return null;
        }
        String str4 = f44251i;
        d1.a(str4, "not support prefetch host: " + str);
        return null;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        String str;
        try {
            if (this.f44256c != null) {
                obj = this.f44256c.get(obj);
            }
            str = (String) obj;
        } catch (Exception e4) {
            d1.a(f44251i, "update system dns cache failed", e4);
        }
        if (!TextUtils.isEmpty(str) && this.f44260g.contains(str)) {
            Object obj3 = this.f44257d.get(obj2);
            if (obj3 instanceof InetAddress[]) {
                InetAddress[] inetAddressArr = (InetAddress[]) obj3;
                long elapsedRealtime = SystemClock.elapsedRealtime() - this.f44261h;
                String str2 = f44251i;
                d1.a(str2, "[systemdns] " + str + " ===> " + a(inetAddressArr) + ", cost: " + elapsedRealtime + "ms");
                List<String> b4 = b(inetAddressArr);
                long d4 = (long) f.c().d();
                if (b4 != null && b4.size() > 0) {
                    a.b().a(str, b4, d4, 2);
                }
            }
            return null;
        }
        String str3 = f44251i;
        d1.a(str3, "not support prefetch host: " + str);
        return null;
    }

    private List<String> b(InetAddress[] inetAddressArr) {
        if (inetAddressArr == null || inetAddressArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (InetAddress inetAddress : inetAddressArr) {
            if (inetAddress != null) {
                String hostAddress = inetAddress.getHostAddress();
                if (!TextUtils.isEmpty(hostAddress)) {
                    arrayList.add(hostAddress);
                }
            }
        }
        return arrayList;
    }

    public static boolean a(String str) {
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                return InetAddresses.isNumericAddress(str);
            }
            if (f44255m == null) {
                Method declaredMethod = InetAddress.class.getDeclaredMethod("isNumeric", String.class);
                declaredMethod.setAccessible(true);
                f44255m = declaredMethod;
            }
            return ((Boolean) f44255m.invoke(null, str)).booleanValue();
        } catch (Exception e4) {
            d1.a(f44251i, "invoke isNumeric failed", e4);
            return Patterns.IP_ADDRESS.matcher(str).matches();
        }
    }
}
