package cn.jpush.android.aa;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f3903a;

    /* renamed from: b  reason: collision with root package name */
    private SharedPreferences.Editor f3904b;

    public b(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("cn.jpush.statistics", 0);
        this.f3903a = sharedPreferences;
        this.f3904b = sharedPreferences.edit();
    }

    public Map<String, Integer> a() {
        return this.f3903a.getAll();
    }

    @SuppressLint({"CommitPrefEdits"})
    public void a(String str) {
        this.f3904b.putInt(str, this.f3903a.getInt(str, 0) + 1);
        this.f3904b.apply();
    }

    public void b() {
        this.f3904b.clear();
        this.f3904b.apply();
    }
}
