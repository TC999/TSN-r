package com.amap.api.col.p0003l;

import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: NativeCrashHandler.java */
/* renamed from: com.amap.api.col.3l.y5  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class y5 {

    /* compiled from: NativeCrashHandler.java */
    /* renamed from: com.amap.api.col.3l.y5$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        public static y5 f9523a = new y5();
    }

    private static JSONObject a(Thread thread) {
        if (thread == null || thread.getStackTrace() == null) {
            return null;
        }
        StackTraceElement[] stackTrace = thread.getStackTrace();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("threadId", thread.getId());
            jSONObject.put("threadName", thread.getName());
            jSONObject.put("threadGroup", thread.getThreadGroup());
            StringBuffer stringBuffer = new StringBuffer();
            for (StackTraceElement stackTraceElement : stackTrace) {
                stringBuffer.append(stackTraceElement);
                stringBuffer.append("<br />");
            }
            jSONObject.put("stacks", stringBuffer.toString());
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:1|(17:3|(3:6|(1:108)(2:17|(7:19|(1:21)|22|23|24|(2:26|(1:(3:30|(3:32|(3:35|(1:42)(2:39|40)|33)|44)(1:46)|45)(2:48|47)))(0)|(10:53|(1:55)|56|(4:59|(4:64|65|(4:67|(1:84)(1:75)|(2:79|80)|81)|85)|86|57)|89|90|91|92|93|(1:95)(3:96|97|(2:102|103)(2:100|101)))(1:51)))|4)|112|113|24|(0)(0)|(0)|53|(0)|56|(1:57)|89|90|91|92|93|(0)(0))|114|24|(0)(0)|(0)|53|(0)|56|(1:57)|89|90|91|92|93|(0)(0)) */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x015b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x015c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean b(android.content.Context r15, java.lang.String r16, java.lang.String r17, java.util.List<com.amap.api.col.p0003l.p4> r18, boolean r19, com.amap.api.col.p0003l.p4 r20) {
        /*
            Method dump skipped, instructions count: 368
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.y5.b(android.content.Context, java.lang.String, java.lang.String, java.util.List, boolean, com.amap.api.col.3l.p4):boolean");
    }
}
