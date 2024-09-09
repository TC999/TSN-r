package com.bytedance.msdk.sr;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.bytedance.msdk.c.ux;
import com.bytedance.msdk.core.k.p;
import com.bytedance.msdk.xv.r;
import com.stub.StubApp;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {

    /* renamed from: c  reason: collision with root package name */
    private static final Map<String, Boolean> f28403c = new ConcurrentHashMap();

    static final synchronized void c(String str) {
        synchronized (w.class) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            f28403c.put(str, Boolean.TRUE);
        }
    }

    public static final synchronized boolean w(String str) {
        synchronized (w.class) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Boolean bool = f28403c.get(str);
            if (bool == null) {
                return false;
            }
            return bool.booleanValue();
        }
    }

    public static synchronized void c(Context context) {
        synchronized (w.class) {
            List<com.bytedance.msdk.core.k.c> w3 = com.bytedance.msdk.ux.c.c.p().w();
            if (w3 != null) {
                for (com.bytedance.msdk.core.k.c cVar : w3) {
                    final com.bytedance.msdk.api.sr.c.w.xv.w xv = cVar.xv();
                    try {
                        if (!w(cVar.ux())) {
                            c(context, xv, new com.bytedance.msdk.adapter.c.w() { // from class: com.bytedance.msdk.sr.w.1
                                @Override // com.bytedance.msdk.adapter.c.w
                                public void c() {
                                    com.bytedance.msdk.sr.w.c.c(com.bytedance.msdk.api.sr.c.w.xv.w.this.w(), new Pair(Boolean.TRUE, ""));
                                }

                                @Override // com.bytedance.msdk.adapter.c.w
                                public void c(@NonNull com.bytedance.msdk.api.c cVar2) {
                                    if (cVar2 != null) {
                                        String w4 = com.bytedance.msdk.api.sr.c.w.xv.w.this.w();
                                        Boolean bool = Boolean.FALSE;
                                        com.bytedance.msdk.sr.w.c.c(w4, new Pair(bool, "errorCode = " + cVar2.f27444c + " errorMessage = " + cVar2.f27445w));
                                    }
                                }
                            });
                            c(cVar.ux());
                        }
                    } catch (Exception e4) {
                        e4.printStackTrace();
                        com.bytedance.msdk.sr.w.c.c(xv.w(), new Pair(Boolean.FALSE, e4.toString()));
                        r.c(xv.w(), (ux) null, (com.bytedance.msdk.api.c.w) null, (p) null, new com.bytedance.msdk.api.c(49013, e4.toString()));
                    }
                }
            } else {
                r.c("", (ux) null, (com.bytedance.msdk.api.c.w) null, (p) null, new com.bytedance.msdk.api.c(49013, "\u83b7\u53d6\u7684\u81ea\u5b9a\u4e49Adapter\u603b\u914d\u7f6e\u4e3anull"));
            }
        }
    }

    public static boolean w(Class<?> cls, Class<?> cls2) {
        for (Class<? super Object> superclass = cls.getSuperclass(); superclass != null; superclass = superclass.getSuperclass()) {
            if (superclass == cls2) {
                return true;
            }
        }
        return false;
    }

    private static com.bytedance.msdk.api.sr.c.w.f.c c(com.bytedance.msdk.api.sr.c.w.xv.w wVar, com.bytedance.msdk.adapter.c.w wVar2) {
        com.bytedance.msdk.api.sr.c.w.f.c c4 = com.bytedance.msdk.sr.w.c.sr().c(wVar.w());
        if (c4 == null) {
            if (com.bytedance.msdk.core.bk.c.c().xv()) {
                c4 = new com.bytedance.msdk.adapter.xv.c.w();
            } else if (c((Class<?>) null)) {
                try {
                    Object newInstance = Class.forName(wVar.xv()).newInstance();
                    if (newInstance instanceof com.bytedance.msdk.api.sr.c.w.f.c) {
                        c4 = (com.bytedance.msdk.api.sr.c.w.f.c) newInstance;
                    }
                } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e4) {
                    e4.printStackTrace();
                }
            }
            com.bytedance.msdk.sr.w.c.sr().c(wVar.w(), c4);
        }
        return c4;
    }

    private static void c(Context context, com.bytedance.msdk.api.sr.c.w.xv.w wVar, com.bytedance.msdk.adapter.c.w wVar2) throws Exception {
        if (wVar == null || TextUtils.isEmpty(wVar.xv())) {
            if (wVar == null) {
                throw new Exception("\u81ea\u5b9a\u4e49ADN\u521d\u59cb\u5316\u5931\u8d25\uff0c\u83b7\u53d6\u7684\u81ea\u5b9a\u4e49Adapter\u5355\u6761\u914d\u7f6e\u4e3anull");
            }
            throw new Exception("\u81ea\u5b9a\u4e49ADN\u521d\u59cb\u5316\u5931\u8d25\uff0c\u83b7\u53d6\u7684\u81ea\u5b9a\u4e49Adapter\u5355\u6761\u914d\u7f6e\u521d\u59cb\u5316\u7c7b\u540d\u4e3a\u7a7a");
        }
        com.bytedance.msdk.api.sr.c.w.f.c c4 = c(wVar, wVar2);
        if (c4 != null) {
            if (!c4.sr()) {
                c(context, wVar, c4);
            }
            wVar2.c();
            return;
        }
        throw new Exception("GMCustomAdapterConfiguration is null");
    }

    private static void c(Context context, com.bytedance.msdk.api.sr.c.w.xv.w wVar, com.bytedance.msdk.api.sr.c.w.f.c cVar) {
        if (context == null) {
            r.c(wVar.w(), (ux) null, (com.bytedance.msdk.api.c.w) null, (p) null, new com.bytedance.msdk.api.c(49013, "context\u4e3anull"));
            return;
        }
        try {
            cVar.w(StubApp.getOrigApplicationContext(context.getApplicationContext()), wVar, com.bytedance.msdk.core.w.k().me());
        } catch (Exception e4) {
            String w3 = wVar.w();
            r.c(w3, (ux) null, (com.bytedance.msdk.api.c.w) null, (p) null, new com.bytedance.msdk.api.c(49013, "\u8c03\u7528\u81ea\u5b9a\u4e49Adapter\u521d\u59cb\u5316\u65b9\u6cd5\u51fa\u73b0\u5f02\u5e38 " + e4.getClass().getName()));
            e4.printStackTrace();
        }
    }

    private static boolean c(Class<?> cls) {
        String c4;
        if (!w(cls, com.bytedance.msdk.api.sr.c.w.f.c.class)) {
            c4 = "\u81ea\u5b9a\u4e49ADN\u521d\u59cb\u5316\u5931\u8d25  ---------  \u521d\u59cb\u5316\u7c7b " + cls.getSimpleName() + " \u9700\u8981\u7ee7\u627f\u81ea\u81ea\u5b9a\u4e49ADN\u7684\u521d\u59cb\u5316Adapter\u7c7b " + com.bytedance.msdk.api.sr.c.w.f.c.class.getSimpleName();
        } else {
            c4 = c(cls, com.bytedance.msdk.api.sr.c.w.f.c.class);
        }
        if (TextUtils.isEmpty(c4)) {
            return true;
        }
        com.bytedance.msdk.adapter.sr.xv.sr("TTMediationSDK_SDK_Init", c4);
        r.c("", (ux) null, (com.bytedance.msdk.api.c.w) null, (p) null, new com.bytedance.msdk.api.c(49013, c4));
        return false;
    }

    public static String c(Class<?> cls, Class<?> cls2) {
        Method[] methods;
        for (Method method : cls2.getMethods()) {
            HashSet hashSet = new HashSet();
            for (Method method2 : Object.class.getMethods()) {
                hashSet.add(method2.getName());
            }
            if (!hashSet.contains(method.getName())) {
                try {
                    cls.getMethod(method.getName(), method.getParameterTypes());
                } catch (NoSuchMethodException e4) {
                    e4.printStackTrace();
                    return "\u81ea\u5b9a\u4e49ADN\u6821\u9a8cAPI\u5931\u8d25\u63a5\u5165API\u4e0d\u7b26\u5408\u7248\u672c\u9700\u6c42\uff0c\u4e0d\u7b26\u5408\u7684API\u7684\u65b9\u6cd5\u540d\u4e3a " + method.getName();
                }
            }
        }
        return "";
    }

    public static synchronized void c(Context context, String str) {
        synchronized (w.class) {
            if (!w(str)) {
                c(context);
            }
        }
    }
}
