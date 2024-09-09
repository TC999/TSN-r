package com.kwad.components.core.e.b;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kwad.components.core.e.b.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class C0628a {
        private static final c Kb = c.a(new int[]{7, 8, 4, 2, 0, 3, 6, 9, 1, 8});
    }

    public static long ac(String str) {
        return nn().ad(str);
    }

    private static c nn() {
        return C0628a.Kb;
    }

    public static String t(long j4) {
        String u3 = nn().u(j4);
        return u3.endsWith("=") ? u3.replace("=", "") : u3;
    }
}
