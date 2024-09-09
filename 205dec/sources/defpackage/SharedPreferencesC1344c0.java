package defpackage;

import android.content.SharedPreferences;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: c0  reason: default package and case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\155424.dex */
public final class SharedPreferencesC1344c0 implements SharedPreferences {

    /* renamed from: a  reason: collision with root package name */
    public final ConcurrentHashMap f1467a;

    /* renamed from: b  reason: collision with root package name */
    public final HashSet f1468b;

    public SharedPreferencesC1344c0(InterfaceC1487y interfaceC1487y, String str) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.f1467a = concurrentHashMap;
        this.f1468b = new HashSet();
        Bundle i4 = ((C1485w) interfaceC1487y).i(str, new BinderC1342b0(this));
        if (i4.containsKey("map")) {
            concurrentHashMap.putAll((Map) i4.getSerializable("map"));
        }
    }

    @Override // android.content.SharedPreferences
    public final boolean contains(String str) {
        return this.f1467a.containsKey(str);
    }

    @Override // android.content.SharedPreferences
    public final SharedPreferences.Editor edit() {
        throw new UnsupportedOperationException("Read only implementation");
    }

    @Override // android.content.SharedPreferences
    public final Map getAll() {
        return new TreeMap(this.f1467a);
    }

    @Override // android.content.SharedPreferences
    public final boolean getBoolean(String str, boolean z3) {
        Boolean bool = (Boolean) this.f1467a.getOrDefault(str, Boolean.valueOf(z3));
        return bool != null ? bool.booleanValue() : z3;
    }

    @Override // android.content.SharedPreferences
    public final float getFloat(String str, float f4) {
        Float f5 = (Float) this.f1467a.getOrDefault(str, Float.valueOf(f4));
        return f5 != null ? f5.floatValue() : f4;
    }

    @Override // android.content.SharedPreferences
    public final int getInt(String str, int i4) {
        Integer num = (Integer) this.f1467a.getOrDefault(str, Integer.valueOf(i4));
        return num != null ? num.intValue() : i4;
    }

    @Override // android.content.SharedPreferences
    public final long getLong(String str, long j4) {
        Long l4 = (Long) this.f1467a.getOrDefault(str, Long.valueOf(j4));
        return l4 != null ? l4.longValue() : j4;
    }

    @Override // android.content.SharedPreferences
    public final String getString(String str, String str2) {
        String str3 = (String) this.f1467a.getOrDefault(str, str2);
        return str3 != null ? str3 : str2;
    }

    @Override // android.content.SharedPreferences
    public final Set getStringSet(String str, Set set) {
        Set set2 = (Set) this.f1467a.getOrDefault(str, set);
        return set2 != null ? set2 : set;
    }

    @Override // android.content.SharedPreferences
    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        synchronized (this.f1468b) {
            this.f1468b.add(onSharedPreferenceChangeListener);
        }
    }

    @Override // android.content.SharedPreferences
    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        synchronized (this.f1468b) {
            this.f1468b.remove(onSharedPreferenceChangeListener);
        }
    }
}
