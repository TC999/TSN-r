package cn.bingoogolapple.qrcode.zbar;

import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: BarcodeFormat.java */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: c  reason: collision with root package name */
    public static final a f1619c = new a(0, "NONE");

    /* renamed from: d  reason: collision with root package name */
    public static final a f1620d;

    /* renamed from: e  reason: collision with root package name */
    public static final a f1621e;

    /* renamed from: f  reason: collision with root package name */
    public static final a f1622f;

    /* renamed from: g  reason: collision with root package name */
    public static final a f1623g;

    /* renamed from: h  reason: collision with root package name */
    public static final a f1624h;

    /* renamed from: i  reason: collision with root package name */
    public static final a f1625i;

    /* renamed from: j  reason: collision with root package name */
    public static final a f1626j;

    /* renamed from: k  reason: collision with root package name */
    public static final a f1627k;

    /* renamed from: l  reason: collision with root package name */
    public static final a f1628l;

    /* renamed from: m  reason: collision with root package name */
    public static final a f1629m;

    /* renamed from: n  reason: collision with root package name */
    public static final a f1630n;

    /* renamed from: o  reason: collision with root package name */
    public static final a f1631o;

    /* renamed from: p  reason: collision with root package name */
    public static final a f1632p;

    /* renamed from: q  reason: collision with root package name */
    public static final a f1633q;

    /* renamed from: r  reason: collision with root package name */
    public static final a f1634r;

    /* renamed from: s  reason: collision with root package name */
    public static final a f1635s;

    /* renamed from: t  reason: collision with root package name */
    static final List<a> f1636t;

    /* renamed from: u  reason: collision with root package name */
    static final List<a> f1637u;

    /* renamed from: v  reason: collision with root package name */
    static final List<a> f1638v;

    /* renamed from: w  reason: collision with root package name */
    static final List<a> f1639w;

    /* renamed from: a  reason: collision with root package name */
    private int f1640a;

    /* renamed from: b  reason: collision with root package name */
    private String f1641b;

    static {
        a aVar = new a(1, "PARTIAL");
        f1620d = aVar;
        a aVar2 = new a(8, "EAN8");
        f1621e = aVar2;
        a aVar3 = new a(9, "UPCE");
        f1622f = aVar3;
        f1623g = new a(10, "ISBN10");
        a aVar4 = new a(12, "UPCA");
        f1624h = aVar4;
        a aVar5 = new a(13, "EAN13");
        f1625i = aVar5;
        a aVar6 = new a(14, "ISBN13");
        f1626j = aVar6;
        a aVar7 = new a(25, "I25");
        f1627k = aVar7;
        f1628l = new a(34, "DATABAR");
        a aVar8 = new a(35, "DATABAR_EXP");
        f1629m = aVar8;
        a aVar9 = new a(38, "CODABAR");
        f1630n = aVar9;
        a aVar10 = new a(39, "CODE39");
        f1631o = aVar10;
        a aVar11 = new a(57, "PDF417");
        f1632p = aVar11;
        a aVar12 = new a(64, "QRCODE");
        f1633q = aVar12;
        a aVar13 = new a(93, "CODE93");
        f1634r = aVar13;
        a aVar14 = new a(128, "CODE128");
        f1635s = aVar14;
        ArrayList arrayList = new ArrayList();
        f1636t = arrayList;
        arrayList.add(aVar);
        arrayList.add(aVar2);
        arrayList.add(aVar3);
        arrayList.add(aVar4);
        arrayList.add(aVar5);
        arrayList.add(aVar6);
        arrayList.add(aVar7);
        arrayList.add(aVar8);
        arrayList.add(aVar9);
        arrayList.add(aVar10);
        arrayList.add(aVar11);
        arrayList.add(aVar12);
        arrayList.add(aVar13);
        arrayList.add(aVar14);
        ArrayList arrayList2 = new ArrayList();
        f1637u = arrayList2;
        arrayList2.add(aVar);
        arrayList2.add(aVar2);
        arrayList2.add(aVar3);
        arrayList2.add(aVar4);
        arrayList2.add(aVar5);
        arrayList2.add(aVar6);
        arrayList2.add(aVar7);
        arrayList2.add(aVar8);
        arrayList2.add(aVar9);
        arrayList2.add(aVar10);
        arrayList2.add(aVar11);
        arrayList2.add(aVar13);
        arrayList2.add(aVar14);
        ArrayList arrayList3 = new ArrayList();
        f1638v = arrayList3;
        arrayList3.add(aVar11);
        arrayList3.add(aVar12);
        ArrayList arrayList4 = new ArrayList();
        f1639w = arrayList4;
        arrayList4.add(aVar12);
        arrayList4.add(aVar6);
        arrayList4.add(aVar4);
        arrayList4.add(aVar5);
        arrayList4.add(aVar14);
    }

    private a(int i4, String str) {
        this.f1640a = i4;
        this.f1641b = str;
    }

    public static a a(int i4) {
        for (a aVar : f1636t) {
            if (aVar.b() == i4) {
                return aVar;
            }
        }
        return f1619c;
    }

    public int b() {
        return this.f1640a;
    }

    public String c() {
        return this.f1641b;
    }
}
