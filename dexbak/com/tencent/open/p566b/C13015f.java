package com.tencent.open.p566b;

import com.tencent.open.utils.C13061g;
import com.tencent.open.utils.C13063i;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.b.f */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C13015f {
    /* renamed from: a */
    public static int m15170a(String str) {
        int m15012a;
        if (C13061g.m15027a() == null || (m15012a = C13063i.m15015a(C13061g.m15027a(), str).m15012a("Common_BusinessReportFrequency")) == 0) {
            return 100;
        }
        return m15012a;
    }

    /* renamed from: a */
    public static int m15171a() {
        int m15012a = C13063i.m15015a(C13061g.m15027a(), (String) null).m15012a("Common_HttpRetryCount");
        if (m15012a == 0) {
            return 2;
        }
        return m15012a;
    }
}
