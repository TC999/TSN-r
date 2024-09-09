package cn.jiguang.bv;

import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import cn.jiguang.internal.JConstants;
import com.bytedance.embedapplog.GameReportHelper;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static String f2930a;

    /* renamed from: b  reason: collision with root package name */
    private static AtomicBoolean f2931b;

    /* JADX WARN: Removed duplicated region for block: B:16:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(android.content.Context r28, cn.jiguang.ca.a r29) {
        /*
            Method dump skipped, instructions count: 739
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.bv.c.a(android.content.Context, cn.jiguang.ca.a):int");
    }

    public static void a(Context context) {
        cn.jiguang.g.b.a(context, cn.jiguang.g.a.ak().a((cn.jiguang.g.a<String>) null), cn.jiguang.g.a.al().a((cn.jiguang.g.a<String>) null), cn.jiguang.g.a.d(false).a((cn.jiguang.g.a<String>) null), cn.jiguang.g.a.d(true).a((cn.jiguang.g.a<String>) null), cn.jiguang.g.a.ap().a((cn.jiguang.g.a<String>) null), cn.jiguang.g.a.am().a((cn.jiguang.g.a<Boolean>) null), cn.jiguang.g.a.an().a((cn.jiguang.g.a<Long>) null), cn.jiguang.g.a.b(true).a((cn.jiguang.g.a<String>) null), cn.jiguang.g.a.b(false).a((cn.jiguang.g.a<String>) null), cn.jiguang.g.a.c(true).a((cn.jiguang.g.a<String>) null), cn.jiguang.g.a.c(false).a((cn.jiguang.g.a<String>) null));
        cn.jiguang.g.b.a(context, cn.jiguang.g.a.x().a((cn.jiguang.g.a<Long>) null), cn.jiguang.g.a.y().a((cn.jiguang.g.a<String>) null), cn.jiguang.g.a.A().a((cn.jiguang.g.a<String>) null));
    }

    public static void a(Context context, int i4) {
        a(context, i4, true);
    }

    public static void a(Context context, int i4, boolean z3) {
        String str;
        StringBuilder sb;
        String str2;
        if (z3) {
            String a4 = cn.jiguang.cc.d.a(i4);
            cn.jiguang.bq.d.n("ConnectingHelper", "Register Failed with server error - code:" + i4);
            if (!TextUtils.isEmpty(a4)) {
                cn.jiguang.bq.d.k("ConnectingHelper", "Local error description: " + a4);
            }
            cn.jiguang.bx.b.a().a(context, 0, i4, a4);
        }
        String e4 = cn.jiguang.d.a.e(context);
        if (i4 != 11) {
            if (i4 == 1012) {
                a(context);
                return;
            }
            if (i4 != 10001) {
                switch (i4) {
                    case 1005:
                        sb = new StringBuilder();
                        sb.append("\u5305\u540d: ");
                        sb.append(context.getPackageName());
                        sb.append(" \u4e0e AppKey:");
                        sb.append(e4);
                        str2 = "\u4e0d\u5339\u914d";
                        break;
                    case 1006:
                        sb = new StringBuilder();
                        sb.append("\u5305\u540d: ");
                        sb.append(context.getPackageName());
                        str2 = " \u4e0d\u5b58\u5728";
                        break;
                    case 1007:
                        cn.jiguang.bq.d.f("ConnectingHelper", "IMEI is duplicated reported by server. Give up now. ");
                        return;
                    case 1008:
                        sb = new StringBuilder();
                        sb.append(" AppKey:");
                        sb.append(e4);
                        str2 = " \u662f\u65e0\u6548\u7684AppKey,\u8bf7\u786e\u8ba4\u4e0eJIGUANG web\u7aef\u7684AppKey\u4e00\u81f4";
                        break;
                    case 1009:
                        sb = new StringBuilder();
                        sb.append(" AppKey:");
                        sb.append(e4);
                        str2 = " \u975eandroid AppKey";
                        break;
                    default:
                        cn.jiguang.bq.d.h("ConnectingHelper", "Unhandled server response error code - " + i4);
                        return;
                }
                sb.append(str2);
                str = sb.toString();
            } else {
                str = " \u672a\u5728manifest\u4e2d\u914d\u7f6eAppKey";
            }
            cn.jiguang.f.a.a(context, str, -1);
        }
    }

    private static void a(final Context context, final long j4) {
        if (j4 > 0) {
            cn.jiguang.bt.b.c(new cn.jiguang.cm.b() { // from class: cn.jiguang.bv.c.1
                /* JADX WARN: Removed duplicated region for block: B:25:0x011d A[Catch: all -> 0x0147, TRY_LEAVE, TryCatch #0 {all -> 0x0147, blocks: (B:12:0x0071, B:15:0x008b, B:16:0x0097, B:25:0x011d, B:17:0x009e, B:19:0x00da, B:21:0x00e6, B:22:0x00f8), top: B:28:0x0071 }] */
                /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
                @Override // cn.jiguang.cm.b
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void a() {
                    /*
                        Method dump skipped, instructions count: 328
                        To view this dump change 'Code comments level' option to 'DEBUG'
                    */
                    throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.bv.c.AnonymousClass1.a():void");
                }
            }, new int[0]);
        }
    }

    public static void a(Context context, boolean z3) {
        cn.jiguang.bq.d.c("ConnectingHelper", "setUseTcpSsl state: " + z3);
        cn.jiguang.g.b.a(context, cn.jiguang.g.a.i().a((cn.jiguang.g.a<Boolean>) Boolean.valueOf(z3)));
    }

    public static void a(boolean z3) {
        cn.jiguang.bq.d.c("ConnectingHelper", "changeLocalTcpSslState, state: " + z3);
        AtomicBoolean atomicBoolean = f2931b;
        if (atomicBoolean == null) {
            f2931b = new AtomicBoolean(z3);
        } else {
            atomicBoolean.set(z3);
        }
    }

    private static synchronized byte[] a(String str, int i4, byte[] bArr, boolean z3, int i5) {
        byte[] b4;
        synchronized (c.class) {
            if (TextUtils.isEmpty(str) || str.length() != 2 || bArr == null || bArr.length == 0) {
                throw new IllegalArgumentException("flag or body length error");
            }
            cn.jiguang.cc.b bVar = new cn.jiguang.cc.b(300);
            bVar.b(0);
            bVar.a(str.getBytes());
            bVar.a(i4);
            bVar.b(i5);
            bVar.a(bArr);
            bVar.b(bVar.a(), 0);
            bVar.a((int) ((byte) ((z3 ? (byte) 1 : (byte) 0) | 16)), 4);
            b4 = bVar.b();
        }
        return b4;
    }

    public static byte[] a(String str, String str2) {
        boolean z3;
        byte[] a4;
        byte[] i4 = cn.jiguang.f.g.i(str2);
        try {
            a4 = cn.jiguang.f.i.a(i4);
        } catch (IOException unused) {
        }
        if (a4.length < i4.length) {
            i4 = a4;
            z3 = true;
            int length = i4.length;
            int a5 = cn.jiguang.cn.g.a();
            String a6 = cn.jiguang.cn.g.a(a5);
            return a(str, a5, cn.jiguang.cn.g.a(i4, a6, a6.substring(0, 16), true), z3, length);
        }
        z3 = false;
        int length2 = i4.length;
        int a52 = cn.jiguang.cn.g.a();
        String a62 = cn.jiguang.cn.g.a(a52);
        return a(str, a52, cn.jiguang.cn.g.a(i4, a62, a62.substring(0, 16), true), z3, length2);
    }

    public static byte[] a(DatagramSocket datagramSocket, DatagramPacket datagramPacket) {
        datagramSocket.setSoTimeout(6000);
        datagramSocket.send(datagramPacket);
        DatagramPacket datagramPacket2 = new DatagramPacket(new byte[1024], 1024);
        cn.jiguang.bq.d.d("ConnectingHelper", "udp Receiving...");
        datagramSocket.receive(datagramPacket2);
        int length = datagramPacket2.getLength();
        byte[] bArr = new byte[length];
        System.arraycopy(datagramPacket2.getData(), 0, bArr, 0, length);
        return bArr;
    }

    public static byte[] a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            throw new cn.jiguang.bx.f(4, "response is empty!");
        }
        try {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.getShort();
            wrap.getShort();
            int i4 = wrap.getInt();
            int i5 = i4 >>> 24;
            long j4 = i4 & 16777215;
            wrap.getShort();
            int remaining = wrap.remaining();
            byte[] bArr2 = new byte[remaining];
            wrap.get(bArr2, 0, remaining);
            if (j4 != 0) {
                String a4 = cn.jiguang.cn.g.a(j4);
                try {
                    bArr2 = cn.jiguang.cn.g.a(bArr2, a4, a4.substring(0, 16), false);
                    if (bArr2 == null) {
                        throw new cn.jiguang.bx.f(5, "decrypt response error");
                    }
                } catch (Exception unused) {
                    throw new cn.jiguang.bx.f(5, "decrypt response error");
                }
            }
            if ((i5 & 1) == 1) {
                try {
                    return cn.jiguang.f.i.b(bArr2);
                } catch (IOException unused2) {
                    return bArr2;
                }
            }
            return bArr2;
        } catch (Throwable th) {
            throw new cn.jiguang.bx.f(4, "parse head error:" + th.getMessage());
        }
    }

    public static int b(Context context, cn.jiguang.ca.a aVar) {
        ByteBuffer a4;
        Object obj;
        String e4 = e(context);
        String str = cn.jiguang.cc.a.a(context).f3239a;
        String f4 = f(context);
        String g4 = g(context);
        long b4 = cn.jiguang.bx.b.a().b();
        String d4 = cn.jiguang.d.a.d(context);
        cn.jiguang.bq.d.c("ConnectingHelper", "Register with: \n key:" + e4 + "\n apkVersion:" + str + "\n clientInfo:" + f4 + "\n extKey:" + g4 + "\n reg business:" + b4 + "\n accountId:" + d4);
        byte[] a5 = cn.jiguang.bz.b.a(context, cn.jiguang.bz.b.a(c(context), e4, str, f4, g4, b4, d4));
        cn.jiguang.cf.b a6 = cn.jiguang.cf.b.a();
        StringBuilder sb = new StringBuilder();
        sb.append(aVar.f3213h);
        sb.append(":");
        sb.append(aVar.f3214i);
        a6.b(sb.toString(), GameReportHelper.REGISTER, (long) a5.length);
        if (aVar.a(a5) != 0) {
            cn.jiguang.bq.d.k("ConnectingHelper", "Register failed - send reg info failed");
            return -2;
        }
        try {
            Pair<cn.jiguang.bz.c, ByteBuffer> a7 = cn.jiguang.bz.a.a(context, aVar.a(20000).array(), "");
            if (a7 == null || (obj = a7.first) == null || a7.second == null || ((cn.jiguang.bz.c) obj).f3170c != 0) {
                cn.jiguang.bq.d.j("ConnectingHelper", "Register failed - can't parse a Register Response");
                cn.jiguang.cf.b.a().c(aVar.f3213h + ":" + aVar.f3214i, "unknown_register", a4.array().length);
                return -4;
            }
            cn.jiguang.cf.b.a().c(aVar.f3213h + ":" + aVar.f3214i, GameReportHelper.REGISTER, a4.array().length);
            cn.jiguang.bz.e eVar = new cn.jiguang.bz.e((cn.jiguang.bz.c) a7.first, (ByteBuffer) a7.second);
            cn.jiguang.bq.d.c("ConnectingHelper", "register response:" + eVar);
            int i4 = eVar.f3185a;
            cn.jiguang.g.b.a(context, cn.jiguang.g.a.aa().a((cn.jiguang.g.a<Integer>) Integer.valueOf(i4)));
            if (i4 == 0) {
                long j4 = eVar.f3186b;
                String str2 = eVar.f3187c;
                String str3 = eVar.f3188d;
                String str4 = eVar.f3189e;
                cn.jiguang.bq.d.h("ConnectingHelper", "Register succeed - juid:" + j4 + ", registrationId:" + str3 + ", deviceId:" + str4);
                if (cn.jiguang.f.g.a(str3) || 0 == j4) {
                    cn.jiguang.bq.d.n("ConnectingHelper", "Unexpected: registrationId/juid should not be empty. ");
                    return -5;
                }
                cn.jiguang.bt.b.a(context, str4);
                cn.jiguang.bt.b.a(context, j4, str2, str3);
                cn.jiguang.bm.e.b(context, j4, str3);
                new cn.jiguang.cc.c().e(f2930a).b(context);
            }
            return i4;
        } catch (cn.jiguang.bx.f e5) {
            cn.jiguang.bq.d.k("ConnectingHelper", "Register failed - recv msg failed with error:" + e5);
            return -3;
        }
    }

    private static String b(String str, String str2) {
        return !cn.jiguang.f.g.a(str) ? str : str2;
    }

    public static void b(Context context) {
        cn.jiguang.g.b.a(context, cn.jiguang.g.a.c(true).a((cn.jiguang.g.a<String>) null), cn.jiguang.g.a.c(false).a((cn.jiguang.g.a<String>) null));
    }

    public static synchronized long c(Context context) {
        long j4;
        synchronized (c.class) {
            long longValue = ((Long) cn.jiguang.g.b.a(context, cn.jiguang.g.a.ai())).longValue();
            if (longValue == -1) {
                longValue = Math.abs(new SecureRandom().nextInt(10000));
            }
            j4 = (longValue + (longValue % 2 == 0 ? 1L : 2L)) % 10000;
            cn.jiguang.g.b.a(context, cn.jiguang.g.a.ai().a((cn.jiguang.g.a<Long>) Long.valueOf(j4)));
        }
        return j4;
    }

    public static synchronized boolean d(Context context) {
        boolean z3;
        synchronized (c.class) {
            if (f2931b == null) {
                if (context == null) {
                    context = JConstants.getAppContext(null);
                }
                boolean booleanValue = ((Boolean) cn.jiguang.g.b.a(context, cn.jiguang.g.a.i())).booleanValue();
                if (booleanValue) {
                    booleanValue = !TextUtils.isEmpty(cn.jiguang.bk.h.a());
                }
                f2931b = new AtomicBoolean(booleanValue);
                cn.jiguang.bq.d.c("ConnectingHelper", "use tcp ssl state: " + f2931b.get());
            }
            z3 = f2931b.get();
        }
        return z3;
    }

    private static String e(Context context) {
        String a4 = cn.jiguang.cc.e.a(context);
        f2930a = a4;
        String str = cn.jiguang.cc.a.a(context).f3253o;
        return b(a4, " ") + "$$" + b(str, " ") + "$$" + context.getPackageName() + "$$" + cn.jiguang.d.a.e(context);
    }

    private static String f(Context context) {
        String e4 = cn.jiguang.bx.b.a().e();
        cn.jiguang.bq.d.c("ConnectingHelper", "regVersion:" + e4);
        cn.jiguang.cc.a a4 = cn.jiguang.cc.a.a(context);
        return b(a4.f3240b, " ") + "$$" + b(a4.f3241c, " ") + "$$" + b(a4.f3242d, " ") + "$$" + b(a4.f3243e, " ") + "$$" + b(cn.jiguang.d.a.g(context), " ") + "$$" + e4 + "$$" + a4.f3245g + "$$" + a4.f3246h + "$$" + a4.f3250l + "$$" + a4.f3255q + "&" + a4.f3256r;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:22:0x00a2
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    private static java.lang.String g(android.content.Context r17) {
        /*
            Method dump skipped, instructions count: 294
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.bv.c.g(android.content.Context):java.lang.String");
    }

    private static String h(Context context) {
        String str = JConstants.testCountry;
        return !TextUtils.isEmpty(str) ? str : cn.jiguang.f.a.n(context);
    }
}
