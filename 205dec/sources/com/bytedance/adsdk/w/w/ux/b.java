package com.bytedance.adsdk.w.w.ux;

import com.bytedance.adsdk.w.w.sr.sr;
import com.bytedance.adsdk.w.w.sr.xv;
import com.bytedance.adsdk.w.w.w.c.c;
import com.bytedance.adsdk.w.w.w.c.d;
import com.bytedance.adsdk.w.w.w.c.e;
import com.bytedance.adsdk.w.w.w.c.g;
import com.bytedance.adsdk.w.w.w.c.h;
import com.bytedance.adsdk.w.w.w.c.j;
import com.bytedance.adsdk.w.w.w.c.k;
import com.bytedance.adsdk.w.w.w.c.o;
import com.bytedance.adsdk.w.w.w.c.p;
import com.bytedance.adsdk.w.w.w.c.q;
import com.bytedance.adsdk.w.w.w.c.s;
import com.bytedance.adsdk.w.w.w.c.t;
import com.bytedance.adsdk.w.w.w.c.u;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f26448a;

        static {
            int[] iArr = new int[xv.values().length];
            f26448a = iArr;
            try {
                iArr[xv.MINUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26448a[xv.PLUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f26448a[xv.DIVISION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f26448a[xv.MULTI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f26448a[xv.MOD.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f26448a[xv.EQ.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f26448a[xv.NOT_EQ.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f26448a[xv.GT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f26448a[xv.LT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f26448a[xv.GT_EQ.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f26448a[xv.LT_EQ.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f26448a[xv.DOUBLE_AMP.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f26448a[xv.DOUBLE_BAR.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    private static Deque<r0.a> a(Deque<r0.a> deque) {
        LinkedList linkedList = new LinkedList();
        for (r0.a aVar : deque) {
            if (linkedList.isEmpty()) {
                linkedList.addLast(aVar);
            } else if (((r0.a) linkedList.peekLast()).c() == xv.COLON) {
                linkedList.pollLast();
                r0.a aVar2 = (r0.a) linkedList.pollLast();
                if (((r0.a) linkedList.pollLast()).c() == xv.QUESTION) {
                    g gVar = new g();
                    gVar.a((r0.a) linkedList.pollLast());
                    gVar.b(aVar2);
                    gVar.c(aVar);
                    linkedList.addLast(gVar);
                } else {
                    throw new IllegalStateException();
                }
            } else {
                linkedList.addLast(aVar);
            }
        }
        return linkedList;
    }

    public static r0.a b(List<r0.a> list, String str, int i4) {
        f(list, str, i4);
        Deque<r0.a> a4 = a(e(list, str, i4));
        if (a4.size() == 1) {
            return a4.getFirst();
        }
        throw new IllegalStateException();
    }

    private static r0.a c(r0.a aVar, r0.a aVar2, r0.a aVar3) {
        j kVar;
        switch (a.f26448a[((xv) aVar2.c()).ordinal()]) {
            case 1:
                kVar = new k();
                break;
            case 2:
                kVar = new o();
                break;
            case 3:
                kVar = new c();
                break;
            case 4:
                kVar = new com.bytedance.adsdk.w.w.w.c.b();
                break;
            case 5:
                kVar = new com.bytedance.adsdk.w.w.w.c.a();
                break;
            case 6:
                kVar = new p();
                break;
            case 7:
                kVar = new q();
                break;
            case 8:
                kVar = new e();
                break;
            case 9:
                kVar = new h();
                break;
            case 10:
                kVar = new s();
                break;
            case 11:
                kVar = new d();
                break;
            case 12:
                kVar = new t();
                break;
            case 13:
                kVar = new u();
                break;
            default:
                throw new UnsupportedOperationException(aVar2.c().toString());
        }
        kVar.a(aVar);
        kVar.b(aVar3);
        return kVar;
    }

    public static boolean d(Object obj) {
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Boolean) || ((Boolean) obj).booleanValue()) {
            return !(obj instanceof Number) || ((Number) obj).floatValue() >= 0.0f;
        }
        return false;
    }

    private static Deque<r0.a> e(List<r0.a> list, String str, int i4) {
        LinkedList<r0.a> linkedList = new LinkedList(list);
        int i5 = 5;
        while (i5 >= 1) {
            LinkedList linkedList2 = new LinkedList();
            for (r0.a aVar : linkedList) {
                if (linkedList2.isEmpty()) {
                    linkedList2.addLast(aVar);
                } else if (xv.c(((r0.a) linkedList2.peekLast()).c()) && ((xv) ((r0.a) linkedList2.peekLast()).c()).w() == i5) {
                    r0.a aVar2 = (r0.a) linkedList2.pollLast();
                    r0.a aVar3 = (r0.a) linkedList2.pollLast();
                    if (!xv.c(aVar3.c()) && !xv.c(aVar.c())) {
                        linkedList2.addLast(c(aVar3, aVar2, aVar));
                    } else {
                        throw new IllegalArgumentException(str.substring(0, i4));
                    }
                } else {
                    linkedList2.addLast(aVar);
                }
            }
            i5--;
            linkedList = linkedList2;
        }
        return linkedList;
    }

    private static void f(List<r0.a> list, String str, int i4) {
        for (r0.a aVar : list) {
            if (sr.c(aVar.c())) {
                throw new IllegalArgumentException(str.substring(0, i4));
            }
        }
    }
}
