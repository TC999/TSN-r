package com.bytedance.pangle.res;

import android.view.LayoutInflater;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.FieldUtils;

/* renamed from: com.bytedance.pangle.res.b */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6215b {
    /* renamed from: a */
    public static void m36965a(LayoutInflater layoutInflater) {
        try {
            FieldUtils.writeField(layoutInflater, "mFactory", (Object) null);
        } catch (Throwable unused) {
            ZeusLogger.m37077w(ZeusLogger.TAG_RESOURCES, "clearFactory failed.");
        }
        try {
            FieldUtils.writeField(layoutInflater, "mFactory2", (Object) null);
        } catch (Throwable unused2) {
            ZeusLogger.m37077w(ZeusLogger.TAG_RESOURCES, "clearFactory failed.");
        }
    }
}
