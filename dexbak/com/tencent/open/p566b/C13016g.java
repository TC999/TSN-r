package com.tencent.open.p566b;

import android.content.Context;
import com.tencent.open.utils.C13061g;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.b.g */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C13016g {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static void m15169a() {
        Context m15027a = C13061g.m15027a();
        if (m15027a == null) {
            return;
        }
        m15027a.deleteDatabase("sdk_report.db");
    }

    /* renamed from: a */
    public static void m15168a(String str) {
    }

    /* renamed from: a */
    public static void m15167a(String str, List<Serializable> list) {
    }

    /* renamed from: b */
    public static List<Serializable> m15166b(String str) {
        return Collections.synchronizedList(new ArrayList());
    }
}
