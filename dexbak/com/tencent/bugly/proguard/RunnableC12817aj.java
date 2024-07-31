package com.tencent.bugly.proguard;

import android.content.Context;
import android.os.Process;
import android.util.Pair;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.tencent.p562mm.opensdk.constants.ConstantsAPI;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.aj */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class RunnableC12817aj implements Runnable {

    /* renamed from: a */
    protected int f36522a;

    /* renamed from: b */
    protected long f36523b;

    /* renamed from: c */
    protected long f36524c;

    /* renamed from: d */
    private int f36525d;

    /* renamed from: e */
    private int f36526e;

    /* renamed from: f */
    private final Context f36527f;

    /* renamed from: g */
    private final int f36528g;

    /* renamed from: h */
    private final byte[] f36529h;

    /* renamed from: i */
    private final C12786aa f36530i;

    /* renamed from: j */
    private final C12803ac f36531j;

    /* renamed from: k */
    private final C12807af f36532k;

    /* renamed from: l */
    private final C12814ai f36533l;

    /* renamed from: m */
    private final int f36534m;

    /* renamed from: n */
    private final InterfaceC12813ah f36535n;

    /* renamed from: o */
    private final InterfaceC12813ah f36536o;

    /* renamed from: p */
    private String f36537p;

    /* renamed from: q */
    private final String f36538q;

    /* renamed from: r */
    private final Map<String, String> f36539r;

    /* renamed from: s */
    private boolean f36540s;

    public RunnableC12817aj(Context context, int i, int i2, byte[] bArr, String str, String str2, InterfaceC12813ah interfaceC12813ah, boolean z) {
        this(context, i, i2, bArr, str, str2, interfaceC12813ah, 2, 30000, z);
    }

    /* renamed from: a */
    private static void m15893a(String str) {
        C12820al.m15872e("[Upload] Failed to upload(%d): %s", 1, str);
    }

    /* renamed from: b */
    public final void m15889b(long j) {
        this.f36524c += j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        C12803ac c12803ac;
        Pair pair;
        boolean booleanValue;
        try {
            this.f36522a = 0;
            this.f36523b = 0L;
            this.f36524c = 0L;
            if (C12787ab.m15968c(this.f36527f) == null) {
                str = "network is not available";
            } else {
                byte[] bArr = this.f36529h;
                if (bArr != null && bArr.length != 0) {
                    if (this.f36527f != null && this.f36530i != null && (c12803ac = this.f36531j) != null && this.f36532k != null) {
                        str = c12803ac.m15941c() == null ? "illegal local strategy" : null;
                    }
                    str = "illegal access error";
                }
                str = "request package is empty!";
            }
            if (str != null) {
                m15891a(false, 0, str);
                return;
            }
            byte[] m15825a = C12828ap.m15825a(this.f36529h);
            if (m15825a == null) {
                m15891a(false, 0, "failed to zip request body");
                return;
            }
            HashMap hashMap = new HashMap(10);
            hashMap.put("tls", "1");
            hashMap.put("prodId", this.f36530i.m15998e());
            hashMap.put("bundleId", this.f36530i.f36450c);
            hashMap.put("appVer", this.f36530i.f36462o);
            Map<String, String> map = this.f36539r;
            if (map != null) {
                hashMap.putAll(map);
            }
            hashMap.put("cmd", Integer.toString(this.f36528g));
            hashMap.put(ConstantsAPI.Token.WX_TOKEN_PLATFORMID_KEY, Byte.toString((byte) 1));
            hashMap.put("sdkVer", this.f36530i.f36455h);
            hashMap.put("strategylastUpdateTime", Long.toString(this.f36531j.m15941c().f36305o));
            this.f36533l.m15910a(this.f36534m, System.currentTimeMillis());
            String str2 = this.f36537p;
            this.f36531j.m15941c();
            int i = 0;
            int i2 = 0;
            while (true) {
                int i3 = i + 1;
                if (i < this.f36525d) {
                    if (i3 > 1) {
                        C12820al.m15873d("[Upload] Failed to upload last time, wait and try(%d) again.", Integer.valueOf(i3));
                        C12828ap.m15822b(this.f36526e);
                        if (i3 == this.f36525d) {
                            C12820al.m15873d("[Upload] Use the back-up url at the last time: %s", this.f36538q);
                            str2 = this.f36538q;
                        }
                    }
                    C12820al.m15874c("[Upload] Send %d bytes", Integer.valueOf(m15825a.length));
                    str2 = m15888b(str2);
                    C12820al.m15874c("[Upload] Upload to %s with cmd %d (pid=%d | tid=%d).", str2, Integer.valueOf(this.f36528g), Integer.valueOf(Process.myPid()), Integer.valueOf(Process.myTid()));
                    byte[] m15927a = this.f36532k.m15927a(str2, m15825a, this, hashMap);
                    Map<String, String> map2 = this.f36532k.f36489c;
                    Pair<Boolean, Boolean> m15890a = m15890a(m15927a, map2);
                    if (!((Boolean) m15890a.first).booleanValue()) {
                        booleanValue = ((Boolean) m15890a.second).booleanValue();
                    } else {
                        Pair<Boolean, Boolean> m15892a = m15892a(map2);
                        if (!((Boolean) m15892a.first).booleanValue()) {
                            booleanValue = ((Boolean) m15892a.second).booleanValue();
                        } else {
                            byte[] m15814b = C12828ap.m15814b(m15927a);
                            if (m15814b != null) {
                                m15927a = m15814b;
                            }
                            C12885br m15930a = C12806ae.m15930a(m15927a);
                            if (m15930a == null) {
                                m15891a(false, 1, "failed to decode response package");
                                Boolean bool = Boolean.FALSE;
                                pair = new Pair(bool, bool);
                            } else {
                                Object[] objArr = new Object[2];
                                objArr[0] = Integer.valueOf(m15930a.f36812b);
                                byte[] bArr2 = m15930a.f36813c;
                                objArr[1] = Integer.valueOf(bArr2 == null ? 0 : bArr2.length);
                                C12820al.m15874c("[Upload] Response cmd is: %d, length of sBuffer is: %d", objArr);
                                if (!m15894a(m15930a, this.f36530i, this.f36531j)) {
                                    m15891a(false, 2, "failed to process response package");
                                    Boolean bool2 = Boolean.FALSE;
                                    pair = new Pair(bool2, bool2);
                                } else {
                                    m15891a(true, 2, "successfully uploaded");
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
                    i = i3;
                    i2 = 1;
                } else {
                    m15891a(false, i2, "failed after many attempts");
                    return;
                }
            }
        } catch (Throwable th) {
            if (C12820al.m15877a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public RunnableC12817aj(Context context, int i, int i2, byte[] bArr, String str, String str2, InterfaceC12813ah interfaceC12813ah, int i3, int i4, boolean z) {
        this.f36525d = 2;
        this.f36526e = 30000;
        this.f36537p = null;
        this.f36522a = 0;
        this.f36523b = 0L;
        this.f36524c = 0L;
        this.f36540s = false;
        this.f36527f = context;
        this.f36530i = C12786aa.m16009a(context);
        this.f36529h = bArr;
        this.f36531j = C12803ac.m15950a();
        if (C12807af.f36487a == null) {
            C12807af.f36487a = new C12807af(context);
        }
        this.f36532k = C12807af.f36487a;
        C12814ai m15913a = C12814ai.m15913a();
        this.f36533l = m15913a;
        this.f36534m = i;
        this.f36537p = str;
        this.f36538q = str2;
        this.f36535n = interfaceC12813ah;
        this.f36536o = m15913a.f36506a;
        this.f36528g = i2;
        if (i3 > 0) {
            this.f36525d = i3;
        }
        if (i4 > 0) {
            this.f36526e = i4;
        }
        this.f36540s = z;
        this.f36539r = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m15891a(boolean r5, int r6, java.lang.String r7) {
        /*
            r4 = this;
            int r0 = r4.f36528g
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
            com.tencent.bugly.proguard.C12820al.m15878a(r0, r6)
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
            com.tencent.bugly.proguard.C12820al.m15872e(r6, r3)
        L3d:
            long r0 = r4.f36523b
            long r2 = r4.f36524c
            long r0 = r0 + r2
            r2 = 0
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 <= 0) goto L5d
            com.tencent.bugly.proguard.ai r6 = r4.f36533l
            boolean r0 = r4.f36540s
            long r0 = r6.m15899a(r0)
            long r2 = r4.f36523b
            long r0 = r0 + r2
            long r2 = r4.f36524c
            long r0 = r0 + r2
            com.tencent.bugly.proguard.ai r6 = r4.f36533l
            boolean r2 = r4.f36540s
            r6.m15906a(r0, r2)
        L5d:
            com.tencent.bugly.proguard.ah r6 = r4.f36535n
            if (r6 == 0) goto L64
            r6.mo15546a(r5, r7)
        L64:
            com.tencent.bugly.proguard.ah r6 = r4.f36536o
            if (r6 == 0) goto L6b
            r6.mo15546a(r5, r7)
        L6b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.RunnableC12817aj.m15891a(boolean, int, java.lang.String):void");
    }

    /* renamed from: b */
    private static String m15888b(String str) {
        if (C12828ap.m15817b(str)) {
            return str;
        }
        try {
            return String.format("%s?aid=%s", str, UUID.randomUUID().toString());
        } catch (Throwable th) {
            C12820al.m15877a(th);
            return str;
        }
    }

    /* renamed from: a */
    private static boolean m15894a(C12885br c12885br, C12786aa c12786aa, C12803ac c12803ac) {
        if (c12885br == null) {
            C12820al.m15873d("resp == null!", new Object[0]);
            return false;
        }
        byte b = c12885br.f36811a;
        if (b != 0) {
            C12820al.m15872e("resp result error %d", Byte.valueOf(b));
            return false;
        }
        try {
            if (!C12828ap.m15817b(c12885br.f36817g) && !C12786aa.m16005b().m15991i().equals(c12885br.f36817g)) {
                C12920w.m15509a().m15504a(C12803ac.f36477a, ConstantHelper.LOG_DE, c12885br.f36817g.getBytes("UTF-8"), true);
                c12786aa.m15999d(c12885br.f36817g);
            }
        } catch (Throwable th) {
            C12820al.m15877a(th);
        }
        c12786aa.f36460m = c12885br.f36815e;
        int i = c12885br.f36812b;
        if (i == 510) {
            byte[] bArr = c12885br.f36813c;
            if (bArr == null) {
                C12820al.m15872e("[Upload] Strategy data is null. Response cmd: %d", Integer.valueOf(i));
                return false;
            }
            C12887bt c12887bt = (C12887bt) C12806ae.m15929a(bArr, C12887bt.class);
            if (c12887bt == null) {
                C12820al.m15872e("[Upload] Failed to decode strategy from server. Response cmd: %d", Integer.valueOf(c12885br.f36812b));
                return false;
            }
            c12803ac.m15945a(c12887bt);
        }
        return true;
    }

    /* renamed from: a */
    private Pair<Boolean, Boolean> m15890a(byte[] bArr, Map<String, String> map) {
        if (bArr == null) {
            m15893a("Failed to upload for no response!");
            return new Pair<>(Boolean.FALSE, Boolean.TRUE);
        }
        C12820al.m15874c("[Upload] Received %d bytes", Integer.valueOf(bArr.length));
        if (bArr.length == 0) {
            m15891a(false, 1, "response data from server is empty");
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    C12820al.m15874c("[Upload] HTTP headers from server: key = %s, value = %s", entry.getKey(), entry.getValue());
                }
            }
            Boolean bool = Boolean.FALSE;
            return new Pair<>(bool, bool);
        }
        Boolean bool2 = Boolean.TRUE;
        return new Pair<>(bool2, bool2);
    }

    /* renamed from: a */
    public final void m15895a(long j) {
        this.f36522a++;
        this.f36523b += j;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ba  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.util.Pair<java.lang.Boolean, java.lang.Boolean> m15892a(java.util.Map<java.lang.String, java.lang.String> r8) {
        /*
            Method dump skipped, instructions count: 293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.proguard.RunnableC12817aj.m15892a(java.util.Map):android.util.Pair");
    }
}
