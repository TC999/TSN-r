package com.bumptech.glide.module;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ManifestParser.java */
@Deprecated
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class e {

    /* renamed from: b  reason: collision with root package name */
    private static final String f17625b = "ManifestParser";

    /* renamed from: c  reason: collision with root package name */
    private static final String f17626c = "GlideModule";

    /* renamed from: a  reason: collision with root package name */
    private final Context f17627a;

    public e(Context context) {
        this.f17627a = context;
    }

    private static c b(String str) {
        try {
            Class<?> cls = Class.forName(str);
            Object obj = null;
            try {
                obj = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (IllegalAccessException e4) {
                c(cls, e4);
            } catch (InstantiationException e5) {
                c(cls, e5);
            } catch (NoSuchMethodException e6) {
                c(cls, e6);
            } catch (InvocationTargetException e7) {
                c(cls, e7);
            }
            if (obj instanceof c) {
                return (c) obj;
            }
            throw new RuntimeException("Expected instanceof GlideModule, but found: " + obj);
        } catch (ClassNotFoundException e8) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e8);
        }
    }

    private static void c(Class<?> cls, Exception exc) {
        throw new RuntimeException("Unable to instantiate GlideModule implementation for " + cls, exc);
    }

    public List<c> a() {
        if (Log.isLoggable("ManifestParser", 3)) {
            Log.d("ManifestParser", "Loading Glide modules");
        }
        ArrayList arrayList = new ArrayList();
        try {
            ApplicationInfo applicationInfo = this.f17627a.getPackageManager().getApplicationInfo(this.f17627a.getPackageName(), 128);
            if (applicationInfo.metaData == null) {
                if (Log.isLoggable("ManifestParser", 3)) {
                    Log.d("ManifestParser", "Got null app info metadata");
                }
                return arrayList;
            }
            if (Log.isLoggable("ManifestParser", 2)) {
                Log.v("ManifestParser", "Got app info metadata: " + applicationInfo.metaData);
            }
            for (String str : applicationInfo.metaData.keySet()) {
                if ("GlideModule".equals(applicationInfo.metaData.get(str))) {
                    arrayList.add(b(str));
                    if (Log.isLoggable("ManifestParser", 3)) {
                        Log.d("ManifestParser", "Loaded Glide module: " + str);
                    }
                }
            }
            if (Log.isLoggable("ManifestParser", 3)) {
                Log.d("ManifestParser", "Finished loading Glide modules");
            }
            return arrayList;
        } catch (PackageManager.NameNotFoundException e4) {
            throw new RuntimeException("Unable to find metadata to parse GlideModules", e4);
        }
    }
}
