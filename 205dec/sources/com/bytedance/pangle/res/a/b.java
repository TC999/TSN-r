package com.bytedance.pangle.res.a;

import java.io.IOException;
import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class b {

    /* renamed from: c  reason: collision with root package name */
    g f28910c;

    /* renamed from: i  reason: collision with root package name */
    private final h f28916i;

    /* renamed from: j  reason: collision with root package name */
    private final byte[] f28917j;

    /* renamed from: l  reason: collision with root package name */
    private int[] f28919l;

    /* renamed from: n  reason: collision with root package name */
    private boolean f28921n;

    /* renamed from: o  reason: collision with root package name */
    private int f28922o;

    /* renamed from: p  reason: collision with root package name */
    private int[] f28923p;

    /* renamed from: q  reason: collision with root package name */
    private int f28924q;

    /* renamed from: a  reason: collision with root package name */
    HashMap<Integer, Integer> f28908a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    boolean f28909b = false;

    /* renamed from: k  reason: collision with root package name */
    private boolean f28918k = false;

    /* renamed from: m  reason: collision with root package name */
    private final a f28920m = new a();

    /* renamed from: d  reason: collision with root package name */
    int f28911d = 0;

    /* renamed from: e  reason: collision with root package name */
    int f28912e = 1;

    /* renamed from: f  reason: collision with root package name */
    int f28913f = 2;

    /* renamed from: g  reason: collision with root package name */
    int f28914g = 3;

    /* renamed from: h  reason: collision with root package name */
    int f28915h = 4;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        int[] f28925a = new int[32];

        /* renamed from: b  reason: collision with root package name */
        int f28926b;

        /* renamed from: c  reason: collision with root package name */
        int f28927c;

        public final void a() {
            b();
            int i4 = this.f28926b;
            int[] iArr = this.f28925a;
            iArr[i4] = 0;
            iArr[i4 + 1] = 0;
            this.f28926b = i4 + 2;
            this.f28927c++;
        }

        final void b() {
            int[] iArr = this.f28925a;
            int length = iArr.length;
            int i4 = this.f28926b;
            int i5 = length - i4;
            if (i5 > 2) {
                return;
            }
            int[] iArr2 = new int[(iArr.length + i5) * 2];
            System.arraycopy(iArr, 0, iArr2, 0, i4);
            this.f28925a = iArr2;
        }
    }

    public b(byte[] bArr, h hVar) {
        this.f28916i = hVar;
        this.f28917j = bArr;
        c();
    }

    private void c() {
        this.f28922o = -1;
        this.f28923p = null;
        this.f28924q = -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:113:0x0295, code lost:
        throw new java.io.IOException("Invalid chunk type (" + r6 + ").");
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x012b, code lost:
        throw new java.io.IOException("Invalid resource ids size (" + r6 + ").");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d() {
        /*
            Method dump skipped, instructions count: 663
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.res.a.b.d():void");
    }

    public final void a() {
        if (this.f28918k) {
            this.f28918k = false;
            this.f28910c = null;
            this.f28919l = null;
            a aVar = this.f28920m;
            aVar.f28926b = 0;
            aVar.f28927c = 0;
            c();
        }
    }

    public final int b() {
        if (this.f28910c != null) {
            try {
                d();
                return this.f28922o;
            } catch (IOException e4) {
                a();
                throw e4;
            }
        }
        throw new RuntimeException("Parser is not opened.");
    }
}
