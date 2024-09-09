package com.bytedance.pangle.res;

import android.view.LayoutInflater;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.FieldUtils;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class b {
    public static void a(LayoutInflater layoutInflater) {
        try {
            FieldUtils.writeField(layoutInflater, "mFactory", (Object) null);
        } catch (Throwable unused) {
            ZeusLogger.w("Zeus/resources_pangle", "clearFactory failed.");
        }
        try {
            FieldUtils.writeField(layoutInflater, "mFactory2", (Object) null);
        } catch (Throwable unused2) {
            ZeusLogger.w("Zeus/resources_pangle", "clearFactory failed.");
        }
    }
}
