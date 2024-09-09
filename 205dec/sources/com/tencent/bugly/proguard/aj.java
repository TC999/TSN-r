package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import android.util.Pair;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class aj implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    protected int f50896a;

    /* renamed from: b  reason: collision with root package name */
    protected long f50897b;

    /* renamed from: c  reason: collision with root package name */
    protected long f50898c;

    /* renamed from: d  reason: collision with root package name */
    private int f50899d;

    /* renamed from: e  reason: collision with root package name */
    private int f50900e;

    /* renamed from: f  reason: collision with root package name */
    private final Context f50901f;

    /* renamed from: g  reason: collision with root package name */
    private final int f50902g;

    /* renamed from: h  reason: collision with root package name */
    private final byte[] f50903h;

    /* renamed from: i  reason: collision with root package name */
    private final aa f50904i;

    /* renamed from: j  reason: collision with root package name */
    private final ac f50905j;

    /* renamed from: k  reason: collision with root package name */
    private final af f50906k;

    /* renamed from: l  reason: collision with root package name */
    private final ai f50907l;

    /* renamed from: m  reason: collision with root package name */
    private final int f50908m;

    /* renamed from: n  reason: collision with root package name */
    private final ah f50909n;

    /* renamed from: o  reason: collision with root package name */
    private final ah f50910o;

    /* renamed from: p  reason: collision with root package name */
    private String f50911p;

    /* renamed from: q  reason: collision with root package name */
    private final String f50912q;

    /* renamed from: r  reason: collision with root package name */
    private final Map<String, String> f50913r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f50914s;

    public aj(Context context, int i4, int i5, byte[] bArr, String str, String str2, ah ahVar, boolean z3) {
        this(context, i4, i5, bArr, str, str2, ahVar, 2, 30000, z3);
    }

    private static void a(String str) {
        al.e("[Upload] Failed to upload(%d): %s", 1, str);
    }

    public final void b(long j4) {
        this.f50898c += j4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        ac acVar;
        Pair pair;
        boolean booleanValue;
        try {
            this.f50896a = 0;
            this.f50897b = 0L;
            this.f50898c = 0L;
            if (ab.c(this.f50901f) == null) {
                str = "network is not available";
            } else {
                byte[] bArr = this.f50903h;
                if (bArr != null && bArr.length != 0) {
                    if (this.f50901f != null && this.f50904i != null && (acVar = this.f50905j) != null && this.f50906k != null) {
                        str = acVar.c() == null ? "illegal local strategy" : null;
                    }
                    str = "illegal access error";
                }
                str = "request package is empty!";
            }
            if (str != null) {
                a(false, 0, str);
                return;
            }
            byte[] a4 = ap.a(this.f50903h);
            if (a4 == null) {
                a(false, 0, "failed to zip request body");
                return;
            }
            HashMap hashMap = new HashMap(10);
            hashMap.put(LiveConfigKey.TLS, "1");
            hashMap.put("prodId", this.f50904i.e());
            hashMap.put("bundleId", this.f50904i.f50824c);
            hashMap.put("appVer", this.f50904i.f50836o);
            Map<String, String> map = this.f50913r;
            if (map != null) {
                hashMap.putAll(map);
            }
            hashMap.put("cmd", Integer.toString(this.f50902g));
            hashMap.put("platformId", Byte.toString((byte) 1));
            hashMap.put("sdkVer", this.f50904i.f50829h);
            hashMap.put("strategylastUpdateTime", Long.toString(this.f50905j.c().f50755o));
            this.f50907l.a(this.f50908m, System.currentTimeMillis());
            String str2 = this.f50911p;
            this.f50905j.c();
            int i4 = 0;
            int i5 = 0;
            while (true) {
                int i6 = i4 + 1;
                if (i4 < this.f50899d) {
                    if (i6 > 1) {
                        al.d("[Upload] Failed to upload last time, wait and try(%d) again.", Integer.valueOf(i6));
                        ap.b(this.f50900e);
                        if (i6 == this.f50899d) {
                            al.d("[Upload] Use the back-up url at the last time: %s", this.f50912q);
                            str2 = this.f50912q;
                        }
                    }
                    al.c("[Upload] Send %d bytes", Integer.valueOf(a4.length));
                    str2 = b(str2);
                    al.c("[Upload] Upload to %s with cmd %d (pid=%d | tid=%d).", str2, Integer.valueOf(this.f50902g), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                    byte[] a5 = this.f50906k.a(str2, a4, this, hashMap);
                    Map<String, String> map2 = this.f50906k.f50863c;
                    Pair<Boolean, Boolean> a6 = a(a5, map2);
                    if (!((Boolean) a6.first).booleanValue()) {
                        booleanValue = ((Boolean) a6.second).booleanValue();
                    } else {
                        Pair<Boolean, Boolean> a7 = a(map2);
                        if (!((Boolean) a7.first).booleanValue()) {
                            booleanValue = ((Boolean) a7.second).booleanValue();
                        } else {
                            byte[] b4 = ap.b(a5);
                            if (b4 != null) {
                                a5 = b4;
                            }
                            br a8 = ae.a(a5);
                            if (a8 == null) {
                                a(false, 1, "failed to decode response package");
                                Boolean bool = Boolean.FALSE;
                                pair = new Pair(bool, bool);
                            } else {
                                Object[] objArr = new Object[2];
                                objArr[0] = Integer.valueOf(a8.f51179b);
                                byte[] bArr2 = a8.f51180c;
                                objArr[1] = Integer.valueOf(bArr2 == null ? 0 : bArr2.length);
                                al.c("[Upload] Response cmd is: %d, length of sBuffer is: %d", objArr);
                                if (!a(a8, this.f50904i, this.f50905j)) {
                                    a(false, 2, "failed to process response package");
                                    Boolean bool2 = Boolean.FALSE;
                                    pair = new Pair(bool2, bool2);
                                } else {
                                    a(true, 2, "successfully uploaded");
                                    Boolean bool3 = Boolean.TRUE;
                                    pair = new Pair(bool3, bool3);
                                }
                            }
                            booleanValue = !((Boolean) pair.first).booleanValue() ? ((Boolean) pair.second).booleanValue() : false;
                        }
                    }
                    if (!booleanValue) {
                        return;
                    }
                    i4 = i6;
                    i5 = 1;
                } else {
                    a(false, i5, "failed after many attempts");
                    return;
                }
            }
        } catch (Throwable th) {
            if (al.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public aj(Context context, int i4, int i5, byte[] bArr, String str, String str2, ah ahVar, int i6, int i7, boolean z3) {
        this.f50899d = 2;
        this.f50900e = 30000;
        this.f50911p = null;
        this.f50896a = 0;
        this.f50897b = 0L;
        this.f50898c = 0L;
        this.f50914s = false;
        this.f50901f = context;
        this.f50904i = aa.a(context);
        this.f50903h = bArr;
        this.f50905j = ac.a();
        if (af.f50861a == null) {
            af.f50861a = new af(context);
        }
        this.f50906k = af.f50861a;
        ai a4 = ai.a();
        this.f50907l = a4;
        this.f50908m = i4;
        this.f50911p = str;
        this.f50912q = str2;
        this.f50909n = ahVar;
        this.f50910o = a4.f50880a;
        this.f50902g = i5;
        if (i6 > 0) {
            this.f50899d = i6;
        }
        if (i7 > 0) {
            this.f50900e = i7;
        }
        this.f50914s = z3;
        this.f50913r = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(boolean r5, int r6, java.lang.String r7) {
        /*
            r4 = this;
            int r0 = r4.f50902g
            r1 = 630(0x276, float:8.83E-43)
            if (r0 == r1) goto L1a
            r1 = 640(0x280, float:8.97E-43)
            if (r0 == r1) goto L17
            r1 = 830(0x33e, float:1.163E-42)
            if (r0 == r1) goto L1a
            r1 = 840(0x348, float:1.177E-42)
            if (r0 == r1) goto L17
            java.lang.String r0 = java.lang.String.valueOf(r0)
            goto L1c
        L17:
            java.lang.String r0 = "userinfo"
            goto L1c
        L1a:
            java.lang.String r0 = "crash"
        L1c:
            r1 = 1
            r2 = 0
            if (r5 == 0) goto L2a
            java.lang.Object[] r6 = new java.lang.Object[r1]
            r6[r2] = r0
            java.lang.String r0 = "[Upload] Success: %s"
            com.tencent.bugly.proguard.al.a(r0, r6)
            goto L3d
        L2a:
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r3[r2] = r6
            r3[r1] = r0
            r6 = 2
            r3[r6] = r7
            java.lang.String r6 = "[Upload] Failed to upload(%d) %s: %s"
            com.tencent.bugly.proguard.al.e(r6, r3)
        L3d:
            long r0 = r4.f50897b
            long r2 = r4.f50898c
            long r0 = r0 + r2
            r2 = 0
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 <= 0) goto L5d
            com.tencent.bugly.proguard.ai r6 = r4.f50907l
            boolean r0 = r4.f50914s
            long r0 = r6.a(r0)
            long r2 = r4.f50897b
            long r0 = r0 + r2
            long r2 = r4.f50898c
            long r0 = r0 + r2
            com.tencent.bugly.proguard.ai r6 = r4.f50907l
            boolean r2 = r4.f50914s
            r6.a(r0, r2)
        L5d:
            com.tencent.bugly.proguard.ah r6 = r4.f50909n
            if (r6 == 0) goto L64
            r6.a(r5, r7)
        L64:
            com.tencent.bugly.proguard.ah r6 = r4.f50910o
            if (r6 == 0) goto L6b
            r6.a(r5, r7)
        L6b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.aj.a(boolean, int, java.lang.String):void");
    }

    private static String b(String str) {
        if (ap.b(str)) {
            return str;
        }
        try {
            return String.format("%s?aid=%s", str, UUID.randomUUID().toString());
        } catch (Throwable th) {
            al.a(th);
            return str;
        }
    }

    private static boolean a(br brVar, aa aaVar, ac acVar) {
        if (brVar == null) {
            al.d("resp == null!", new Object[0]);
            return false;
        }
        byte b4 = brVar.f51178a;
        if (b4 != 0) {
            al.e("resp result error %d", Byte.valueOf(b4));
            return false;
        }
        try {
            if (!ap.b(brVar.f51184g) && !aa.b().i().equals(brVar.f51184g)) {
                w.a().a(ac.f50851a, "device", brVar.f51184g.getBytes("UTF-8"), true);
                aaVar.d(brVar.f51184g);
            }
        } catch (Throwable th) {
            al.a(th);
        }
        aaVar.f50834m = brVar.f51182e;
        int i4 = brVar.f51179b;
        if (i4 == 510) {
            byte[] bArr = brVar.f51180c;
            if (bArr == null) {
                al.e("[Upload] Strategy data is null. Response cmd: %d", Integer.valueOf(i4));
                return false;
            }
            bt btVar = (bt) ae.a(bArr, bt.class);
            if (btVar == null) {
                al.e("[Upload] Failed to decode strategy from server. Response cmd: %d", Integer.valueOf(brVar.f51179b));
                return false;
            }
            acVar.a(btVar);
        }
        return true;
    }

    private Pair<Boolean, Boolean> a(byte[] bArr, Map<String, String> map) {
        if (bArr == null) {
            a("Failed to upload for no response!");
            return new Pair<>(Boolean.FALSE, Boolean.TRUE);
        }
        al.c("[Upload] Received %d bytes", Integer.valueOf(bArr.length));
        if (bArr.length == 0) {
            a(false, 1, "response data from server is empty");
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    al.c("[Upload] HTTP headers from server: key = %s, value = %s", entry.getKey(), entry.getValue());
                }
            }
            Boolean bool = Boolean.FALSE;
            return new Pair<>(bool, bool);
        }
        Boolean bool2 = Boolean.TRUE;
        return new Pair<>(bool2, bool2);
    }

    public final void a(long j4) {
        this.f50896a++;
        this.f50897b += j4;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.util.Pair<java.lang.Boolean, java.lang.Boolean> a(java.util.Map<java.lang.String, java.lang.String> r8) {
        /*
            Method dump skipped, instructions count: 293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.aj.a(java.util.Map):android.util.Pair");
    }
}
