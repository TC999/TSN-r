package com.bytedance.sdk.openadsdk.core.eq;

import android.text.TextUtils;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c implements Comparable<c> {

        /* renamed from: c  reason: collision with root package name */
        private long f33324c;

        /* renamed from: w  reason: collision with root package name */
        private String f33325w;

        public c(String str, long j4) {
            this.f33325w = str;
            this.f33324c = j4;
        }

        @Override // java.lang.Comparable
        /* renamed from: c */
        public int compareTo(c cVar) {
            if (cVar == null) {
                return 1;
            }
            long j4 = this.f33324c;
            long j5 = cVar.f33324c;
            if (j4 > j5) {
                return 1;
            }
            return j4 == j5 ? 0 : -1;
        }
    }

    public static void c(com.bytedance.sdk.openadsdk.core.u.c cVar, int i4, int i5) {
        if (cVar == null || cVar.w() == null || i5 <= 0) {
            return;
        }
        List<com.bytedance.sdk.openadsdk.core.u.me> w3 = cVar.w();
        int size = w3.size();
        try {
            com.bytedance.sdk.component.f.c c4 = ba.c(i4 + "_prefetch");
            delete(i4, i5, c4, size);
            for (com.bytedance.sdk.openadsdk.core.u.me meVar : w3) {
                String u3 = meVar.u();
                String w4 = com.bytedance.sdk.component.utils.c.w(meVar.mo().toString());
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("pre_fetch_time", System.currentTimeMillis());
                jSONObject.put("message", w4);
                c4.c(u3, jSONObject.toString());
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static boolean c(int i4) {
        return i4 == 3 || i4 == 7 || i4 == 8;
    }

    private static void delete(int i4, int i5, com.bytedance.sdk.component.f.c cVar, int i6) {
        if (cVar == null) {
            return;
        }
        try {
            Map<String, ?> c4 = cVar.c();
            if (c4 != null && c4.size() != 0) {
                int size = c4.size();
                if (c(i4)) {
                    if (size > 1) {
                        cVar.w();
                    }
                } else if (i6 >= i5) {
                    cVar.w();
                } else {
                    int i7 = size + i6;
                    if (i7 > i5) {
                        PriorityQueue priorityQueue = new PriorityQueue();
                        for (Map.Entry<String, ?> entry : c4.entrySet()) {
                            String str = (String) entry.getValue();
                            JSONObject jSONObject = null;
                            if (str != null && str.contains("pre_fetch_time")) {
                                jSONObject = new JSONObject(str);
                            } else if (str != null) {
                                jSONObject = new JSONObject(com.bytedance.sdk.component.utils.c.xv(str));
                            }
                            if (jSONObject != null) {
                                priorityQueue.add(new c(entry.getKey(), jSONObject.optLong("pre_fetch_time")));
                            }
                        }
                        int size2 = priorityQueue.size();
                        com.bytedance.sdk.component.utils.a.w("prefetch", "queueSize:" + size2 + " savingListSize:" + i6 + " maxSaveCnt:" + i5 + " savedLocalSize:" + size);
                        int i8 = i7 - i5;
                        if (size2 == 0 || size2 < i8) {
                            cVar.w();
                            return;
                        }
                        for (int i9 = 0; i9 < i8; i9++) {
                            c cVar2 = (c) priorityQueue.poll();
                            if (cVar2 != null) {
                                cVar.c(cVar2.f33325w);
                            }
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static com.bytedance.sdk.openadsdk.core.u.me c(String str, int i4) {
        if (com.bytedance.sdk.openadsdk.core.ls.w().i() <= 0) {
            return null;
        }
        com.bytedance.sdk.component.f.c c4 = ba.c(i4 + "_prefetch");
        String w3 = c4.w(str, (String) null);
        if (!TextUtils.isEmpty(w3)) {
            try {
                if (w3.contains("pre_fetch_time")) {
                    w3 = new JSONObject(w3).optString("message");
                }
                com.bytedance.sdk.openadsdk.core.u.me c5 = com.bytedance.sdk.openadsdk.core.w.c(new JSONObject(com.bytedance.sdk.component.utils.c.xv(w3)));
                c4.c(str);
                return c5;
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
