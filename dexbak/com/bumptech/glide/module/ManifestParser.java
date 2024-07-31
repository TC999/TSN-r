package com.bumptech.glide.module;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@Deprecated
/* renamed from: com.bumptech.glide.module.e */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class ManifestParser {

    /* renamed from: b */
    private static final String f14308b = "ManifestParser";

    /* renamed from: c */
    private static final String f14309c = "GlideModule";

    /* renamed from: a */
    private final Context f14310a;

    public ManifestParser(Context context) {
        this.f14310a = context;
    }

    /* renamed from: b */
    private static GlideModule m44708b(String str) {
        try {
            Class<?> cls = Class.forName(str);
            Object obj = null;
            try {
                obj = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (IllegalAccessException e) {
                m44707c(cls, e);
            } catch (InstantiationException e2) {
                m44707c(cls, e2);
            } catch (NoSuchMethodException e3) {
                m44707c(cls, e3);
            } catch (InvocationTargetException e4) {
                m44707c(cls, e4);
            }
            if (obj instanceof GlideModule) {
                return (GlideModule) obj;
            }
            throw new RuntimeException("Expected instanceof GlideModule, but found: " + obj);
        } catch (ClassNotFoundException e5) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e5);
        }
    }

    /* renamed from: c */
    private static void m44707c(Class<?> cls, Exception exc) {
        throw new RuntimeException("Unable to instantiate GlideModule implementation for " + cls, exc);
    }

    /* renamed from: a */
    public List<GlideModule> m44709a() {
        if (Log.isLoggable(f14308b, 3)) {
            Log.d(f14308b, "Loading Glide modules");
        }
        ArrayList arrayList = new ArrayList();
        try {
            ApplicationInfo applicationInfo = this.f14310a.getPackageManager().getApplicationInfo(this.f14310a.getPackageName(), 128);
            if (applicationInfo.metaData == null) {
                if (Log.isLoggable(f14308b, 3)) {
                    Log.d(f14308b, "Got null app info metadata");
                }
                return arrayList;
            }
            if (Log.isLoggable(f14308b, 2)) {
                Log.v(f14308b, "Got app info metadata: " + applicationInfo.metaData);
            }
            for (String str : applicationInfo.metaData.keySet()) {
                if (f14309c.equals(applicationInfo.metaData.get(str))) {
                    arrayList.add(m44708b(str));
                    if (Log.isLoggable(f14308b, 3)) {
                        Log.d(f14308b, "Loaded Glide module: " + str);
                    }
                }
            }
            if (Log.isLoggable(f14308b, 3)) {
                Log.d(f14308b, "Finished loading Glide modules");
            }
            return arrayList;
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("Unable to find metadata to parse GlideModules", e);
        }
    }
}
