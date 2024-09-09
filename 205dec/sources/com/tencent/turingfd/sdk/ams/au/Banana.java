package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Banana {

    /* renamed from: a  reason: collision with root package name */
    public static final String f51900a = Cextends.a(Cextends.Z0);

    /* renamed from: b  reason: collision with root package name */
    public static Cumquat f51901b;

    /* renamed from: c  reason: collision with root package name */
    public static final AtomicReference<Bennet> f51902c;

    /* compiled from: A */
    /* renamed from: com.tencent.turingfd.sdk.ams.au.Banana$do  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class Cdo implements Callable<Bennet> {

        /* renamed from: d  reason: collision with root package name */
        public static final HashMap<String, FutureTask<Bennet>> f51903d = new HashMap<>();

        /* renamed from: a  reason: collision with root package name */
        public final String f51904a;

        /* renamed from: b  reason: collision with root package name */
        public final Map<Integer, String> f51905b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f51906c;

        /* compiled from: A */
        /* renamed from: com.tencent.turingfd.sdk.ams.au.Banana$do$do  reason: invalid class name and collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        public class C1047do implements Comparator<Integer> {
            public C1047do(Cdo cdo) {
            }

            @Override // java.util.Comparator
            public int compare(Integer num, Integer num2) {
                return num.intValue() - num2.intValue();
            }
        }

        public Cdo(Map<Integer, String> map, boolean z3) {
            this.f51905b = map;
            this.f51906c = z3;
            if (map != null && !map.isEmpty()) {
                TreeMap treeMap = new TreeMap(new C1047do(this));
                treeMap.putAll(map);
                StringBuilder sb = new StringBuilder();
                for (Integer num : treeMap.keySet()) {
                    sb.append((String) treeMap.get(num));
                }
                this.f51904a = sb.toString();
                return;
            }
            this.f51904a = "";
        }

        public synchronized FutureTask<Bennet> a() {
            FutureTask<Bennet> futureTask;
            HashMap<String, FutureTask<Bennet>> hashMap = f51903d;
            futureTask = hashMap.get(this.f51904a);
            if (futureTask == null || futureTask.isDone()) {
                futureTask = new FutureTask<>(this);
                Cfinally.f52315a.submit(futureTask);
                hashMap.put(this.f51904a, futureTask);
            }
            return futureTask;
        }

        @Override // java.util.concurrent.Callable
        public Bennet call() throws Exception {
            Context context;
            synchronized (Ctry.class) {
                context = Ctry.f52366a;
            }
            Avocado avocado = new Avocado();
            try {
                Grape.f52082g.a(context);
                avocado.f51895b = 1;
                avocado.f51898e = System.currentTimeMillis();
                byte[] a4 = Banana.a(context, this.f51905b, avocado, this.f51906c);
                avocado.f51899f = System.currentTimeMillis();
                avocado.f51896c = a4.length;
                Bennet a5 = Banana.a(context, a4, avocado);
                Banana.a(context, a5);
                Banana.a(context, avocado);
                return a5;
            } catch (Throwable unused) {
                return new Bennet(-10015);
            }
        }
    }

    static {
        Cextends.a(Cextends.f52259d1);
        f51902c = new AtomicReference<>(null);
    }

    public static Bennet a(Context context, byte[] bArr, Avocado avocado) {
        if (bArr.length == 0) {
            return new Bennet(-1000);
        }
        Herbaceous a4 = Guava.f52091b.a(5, bArr, 8123, 18123, null);
        int i4 = a4.f52097a;
        if (i4 != 0) {
            return new Bennet(i4);
        }
        byte[] bArr2 = a4.f52100d;
        try {
            Berry berry = new Berry();
            berry.f51918c = -999;
            if (avocado.f51895b == 1) {
                berry = (Berry) Mangosteen.a(berry, bArr2);
            } else {
                berry.a(new Cygnus(bArr2));
            }
            if (berry == null) {
                return new Bennet(-1002);
            }
            int i5 = berry.f51918c;
            if (i5 == 0) {
                if (TextUtils.isEmpty(berry.f51919d)) {
                    return new Bennet(-1001);
                }
                Blackberry.a(berry.f51923h, berry.f51922g);
                int seconds = (int) TimeUnit.MINUTES.toSeconds(10L);
                if (berry.f51920e < 0) {
                    berry.f51920e = seconds;
                }
                return new Bennet(0, berry.f51919d, System.currentTimeMillis(), berry.f51920e * 1000, berry.f51921f, berry.f51922g);
            }
            return new Bennet((-2000) - i5);
        } catch (Throwable unused) {
            return new Bennet(-999);
        }
    }

    public static void a(Context context, Avocado avocado) {
        long j4;
        StringBuilder a4 = Almond.a("5_");
        a4.append(avocado.f51895b);
        a4.append("_");
        a4.append(avocado.f51897d);
        a4.append("_");
        a4.append(System.currentTimeMillis() - avocado.f51894a);
        a4.append("_");
        a4.append(avocado.f51896c);
        a4.append("_");
        long j5 = avocado.f51898e;
        if (j5 >= 0) {
            long j6 = avocado.f51899f;
            if (j6 >= j5) {
                j4 = j6 - j5;
                a4.append(j4);
                String sb = a4.toString();
                String str = Ginkgo.f52072b;
                HashMap hashMap = new HashMap();
                hashMap.put("703", sb);
                Ginkgo.a(context, hashMap);
            }
        }
        j4 = -1;
        a4.append(j4);
        String sb2 = a4.toString();
        String str2 = Ginkgo.f52072b;
        HashMap hashMap2 = new HashMap();
        hashMap2.put("703", sb2);
        Ginkgo.a(context, hashMap2);
    }

    public static String a(Context context, int i4, Cprivate cprivate, boolean z3) {
        String str;
        SparseArray<Object> h89_DEE08458D4E8C7EA;
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder();
        str = "";
        sb.append("");
        sb.append(i4);
        hashMap.put("3", sb.toString());
        if (i4 == 17 || i4 == 40) {
            long currentTimeMillis = System.currentTimeMillis();
            List<String> a4 = Scorpius.a(f51901b.f51984d);
            cprivate.a(-i4, System.currentTimeMillis() - currentTimeMillis);
            HashSet hashSet = new HashSet();
            if (!Cwhile.a(a4)) {
                hashSet.addAll(a4);
            }
            if (i4 == 17 && z3) {
                Set<String> d4 = Gooseberry.f52078f.d();
                if (d4 != null) {
                    hashSet.addAll(d4);
                }
                hashSet.add(context.getPackageName());
            }
            hashMap.put("3005", z3 ? "1" : "0");
            if (hashSet.size() > 0) {
                hashMap.put("277", Scorpius.a(hashSet));
            }
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        try {
            h89_DEE08458D4E8C7EA = TNative$aa.h89_DEE08458D4E8C7EA(new SparseArray(), context, hashMap, 0);
        } catch (Throwable unused) {
        }
        if (Norma.b(h89_DEE08458D4E8C7EA) != 0) {
            return "";
        }
        String str2 = (String) Norma.a(h89_DEE08458D4E8C7EA, 205, String.class);
        int i5 = Cherry.f51967a;
        str = str2 != null ? str2 : "";
        cprivate.f52342a.put(Integer.valueOf(i4), Long.valueOf(System.currentTimeMillis() - currentTimeMillis2));
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:140:0x035b, code lost:
        if (android.text.TextUtils.isEmpty(r0) != false) goto L399;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0465  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x048e  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x04ef  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x04fc  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0591  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0594  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x05a8  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x05af  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x05b7  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x05c2  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x05c9  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x05d1  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x05de  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0604 A[Catch: all -> 0x0650, TryCatch #12 {all -> 0x0650, blocks: (B:244:0x05f8, B:246:0x0604, B:250:0x0623, B:251:0x062a, B:253:0x0635, B:255:0x063d, B:256:0x064c), top: B:371:0x05f8 }] */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0662  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x066f  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x07b7  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x07d4  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x07fb  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x081a  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x0840  */
    /* JADX WARN: Removed duplicated region for block: B:335:0x087b  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x08c5  */
    /* JADX WARN: Removed duplicated region for block: B:344:0x08df  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x0514 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:369:0x04ab A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v33 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] a(android.content.Context r19, java.util.Map r20, com.tencent.turingfd.sdk.ams.au.Avocado r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 2323
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.turingfd.sdk.ams.au.Banana.a(android.content.Context, java.util.Map, com.tencent.turingfd.sdk.ams.au.Avocado, boolean):byte[]");
    }

    public static Bennet a(Context context) {
        long j4;
        int i4;
        Context context2;
        AtomicReference<Bennet> atomicReference = f51902c;
        synchronized (atomicReference) {
            Bennet bennet = atomicReference.get();
            if (bennet == null) {
                String b4 = Ginkgo.b(context, "1001");
                if (TextUtils.isEmpty(b4)) {
                    return null;
                }
                long j5 = 0;
                try {
                    j4 = Long.parseLong(Ginkgo.b(context, "1002"));
                } catch (Throwable unused) {
                    j4 = 0;
                }
                try {
                    j5 = Long.parseLong(Ginkgo.b(context, "1003"));
                } catch (Throwable unused2) {
                }
                long j6 = j5;
                try {
                    i4 = Integer.parseInt(Ginkgo.b(context, "1004"));
                } catch (Throwable unused3) {
                    i4 = 0;
                }
                synchronized (Ctry.class) {
                    context2 = Ctry.f52366a;
                }
                bennet = new Bennet(0, b4, j4, j6, i4, Ginkgo.b(context2, "1005"));
                f51902c.set(bennet);
            }
            return bennet;
        }
    }

    public static void a(Context context, Bennet bennet) {
        AtomicReference<Bennet> atomicReference = f51902c;
        synchronized (atomicReference) {
            if (bennet.f51907a != 0) {
                return;
            }
            atomicReference.set(bennet);
            String str = Ginkgo.f52072b;
            if (TextUtils.isEmpty(bennet.f51908b)) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("1001", bennet.f51908b);
            hashMap.put("1002", String.valueOf(bennet.f51909c));
            hashMap.put("1003", String.valueOf(bennet.f51910d));
            hashMap.put("1004", String.valueOf(bennet.f51911e));
            String str2 = bennet.f51912f;
            int i4 = Cherry.f51967a;
            if (str2 == null) {
                str2 = "";
            }
            hashMap.put("1005", str2);
            Ginkgo.a(context, hashMap);
        }
    }
}
