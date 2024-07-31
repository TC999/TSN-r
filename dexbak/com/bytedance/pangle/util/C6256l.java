package com.bytedance.pangle.util;

import android.content.SharedPreferences;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import java.util.Locale;

/* renamed from: com.bytedance.pangle.util.l */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class C6256l {

    /* renamed from: b */
    private static volatile C6256l f22241b;

    /* renamed from: a */
    public SharedPreferences f22242a = Zeus.getAppApplication().getSharedPreferences("pangle_meta_data_sp", 0);

    private C6256l() {
    }

    /* renamed from: a */
    public static C6256l m36869a() {
        if (f22241b == null) {
            synchronized (C6256l.class) {
                if (f22241b == null) {
                    f22241b = new C6256l();
                }
            }
        }
        return f22241b;
    }

    /* renamed from: b */
    public final String m36864b(String str) {
        String string = this.f22242a.getString("HOST_IDENTITY_".concat(String.valueOf(str)), "");
        ZeusLogger.m37081i(ZeusLogger.TAG_INIT, "ZeusSpUtils getHostIdentity pluginPKg = " + str + ", hostIdentity = " + string);
        return string;
    }

    /* renamed from: c */
    public final void m36860c(String str, int i, boolean z) {
        SharedPreferences.Editor edit = this.f22242a.edit();
        edit.putBoolean("dex_remove_state_" + str + "_" + i, z);
        edit.apply();
    }

    /* renamed from: b */
    public final void m36861b(String str, int i, boolean z) {
        SharedPreferences.Editor edit = this.f22242a.edit();
        edit.putBoolean("dex_opt_state_" + str + "_" + i, z);
        edit.apply();
    }

    /* renamed from: a */
    public final int m36868a(String str) {
        int i = this.f22242a.getInt("PLUGIN_API_VERSION_".concat(String.valueOf(str)), 0);
        ZeusLogger.m37081i(ZeusLogger.TAG_INIT, "ZeusSpUtils getPluginApiVersion pluginPKg = " + str + ", pluginApiVersion = " + i);
        return i;
    }

    /* renamed from: b */
    public final int m36863b(String str, int i) {
        return this.f22242a.getInt("remove_entry_flag_" + str + "_" + i, 0);
    }

    /* renamed from: a */
    public final void m36865a(String str, int i, boolean z) {
        SharedPreferences.Editor edit = this.f22242a.edit();
        String str2 = "INSTALLED_" + str + "-" + i;
        if (z) {
            edit.putBoolean(str2, true);
        } else {
            edit.remove(str2);
        }
        edit.apply();
    }

    /* renamed from: b */
    public final int m36862b(String str, int i, String str2) {
        return this.f22242a.getInt(str2 + "_failed_count_when_rm_entry_" + str + "_" + i, 0);
    }

    /* renamed from: a */
    public final boolean m36867a(String str, int i) {
        return this.f22242a.getBoolean(String.format(Locale.getDefault(), "INSTALLED_%s-%d", str, Integer.valueOf(i)), false);
    }

    /* renamed from: a */
    public final void m36866a(String str, int i, String str2) {
        int m36862b = m36862b(str, i, str2);
        SharedPreferences.Editor edit = this.f22242a.edit();
        edit.putInt(str2 + "_failed_count_when_rm_entry_" + str + "_" + i, m36862b + 1);
        edit.apply();
    }
}
