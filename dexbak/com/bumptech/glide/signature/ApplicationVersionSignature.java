package com.bumptech.glide.signature;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.Key;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* renamed from: com.bumptech.glide.signature.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class ApplicationVersionSignature {

    /* renamed from: a */
    private static final String f14524a = "AppVersionSignature";

    /* renamed from: b */
    private static final ConcurrentMap<String, Key> f14525b = new ConcurrentHashMap();

    private ApplicationVersionSignature() {
    }

    @Nullable
    /* renamed from: a */
    private static PackageInfo m44438a(@NonNull Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(f14524a, "Cannot resolve info for" + context.getPackageName(), e);
            return null;
        }
    }

    @NonNull
    /* renamed from: b */
    private static String m44437b(@Nullable PackageInfo packageInfo) {
        if (packageInfo != null) {
            return String.valueOf(packageInfo.versionCode);
        }
        return UUID.randomUUID().toString();
    }

    @NonNull
    /* renamed from: c */
    public static Key m44436c(@NonNull Context context) {
        String packageName = context.getPackageName();
        ConcurrentMap<String, Key> concurrentMap = f14525b;
        Key key = concurrentMap.get(packageName);
        if (key == null) {
            Key m44435d = m44435d(context);
            Key putIfAbsent = concurrentMap.putIfAbsent(packageName, m44435d);
            return putIfAbsent == null ? m44435d : putIfAbsent;
        }
        return key;
    }

    @NonNull
    /* renamed from: d */
    private static Key m44435d(@NonNull Context context) {
        return new ObjectKey(m44437b(m44438a(context)));
    }

    @VisibleForTesting
    /* renamed from: e */
    static void m44434e() {
        f14525b.clear();
    }
}
