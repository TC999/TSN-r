package cn.bingoogolapple.qrcode.zbar;

import java.util.ArrayList;
import java.util.List;

/* renamed from: cn.bingoogolapple.qrcode.zbar.a */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class BarcodeFormat {

    /* renamed from: c */
    public static final BarcodeFormat f1632c = new BarcodeFormat(0, "NONE");

    /* renamed from: d */
    public static final BarcodeFormat f1633d;

    /* renamed from: e */
    public static final BarcodeFormat f1634e;

    /* renamed from: f */
    public static final BarcodeFormat f1635f;

    /* renamed from: g */
    public static final BarcodeFormat f1636g;

    /* renamed from: h */
    public static final BarcodeFormat f1637h;

    /* renamed from: i */
    public static final BarcodeFormat f1638i;

    /* renamed from: j */
    public static final BarcodeFormat f1639j;

    /* renamed from: k */
    public static final BarcodeFormat f1640k;

    /* renamed from: l */
    public static final BarcodeFormat f1641l;

    /* renamed from: m */
    public static final BarcodeFormat f1642m;

    /* renamed from: n */
    public static final BarcodeFormat f1643n;

    /* renamed from: o */
    public static final BarcodeFormat f1644o;

    /* renamed from: p */
    public static final BarcodeFormat f1645p;

    /* renamed from: q */
    public static final BarcodeFormat f1646q;

    /* renamed from: r */
    public static final BarcodeFormat f1647r;

    /* renamed from: s */
    public static final BarcodeFormat f1648s;

    /* renamed from: t */
    static final List<BarcodeFormat> f1649t;

    /* renamed from: u */
    static final List<BarcodeFormat> f1650u;

    /* renamed from: v */
    static final List<BarcodeFormat> f1651v;

    /* renamed from: w */
    static final List<BarcodeFormat> f1652w;

    /* renamed from: a */
    private int f1653a;

    /* renamed from: b */
    private String f1654b;

    static {
        BarcodeFormat barcodeFormat = new BarcodeFormat(1, "PARTIAL");
        f1633d = barcodeFormat;
        BarcodeFormat barcodeFormat2 = new BarcodeFormat(8, "EAN8");
        f1634e = barcodeFormat2;
        BarcodeFormat barcodeFormat3 = new BarcodeFormat(9, "UPCE");
        f1635f = barcodeFormat3;
        f1636g = new BarcodeFormat(10, "ISBN10");
        BarcodeFormat barcodeFormat4 = new BarcodeFormat(12, "UPCA");
        f1637h = barcodeFormat4;
        BarcodeFormat barcodeFormat5 = new BarcodeFormat(13, "EAN13");
        f1638i = barcodeFormat5;
        BarcodeFormat barcodeFormat6 = new BarcodeFormat(14, "ISBN13");
        f1639j = barcodeFormat6;
        BarcodeFormat barcodeFormat7 = new BarcodeFormat(25, "I25");
        f1640k = barcodeFormat7;
        f1641l = new BarcodeFormat(34, "DATABAR");
        BarcodeFormat barcodeFormat8 = new BarcodeFormat(35, "DATABAR_EXP");
        f1642m = barcodeFormat8;
        BarcodeFormat barcodeFormat9 = new BarcodeFormat(38, "CODABAR");
        f1643n = barcodeFormat9;
        BarcodeFormat barcodeFormat10 = new BarcodeFormat(39, "CODE39");
        f1644o = barcodeFormat10;
        BarcodeFormat barcodeFormat11 = new BarcodeFormat(57, "PDF417");
        f1645p = barcodeFormat11;
        BarcodeFormat barcodeFormat12 = new BarcodeFormat(64, "QRCODE");
        f1646q = barcodeFormat12;
        BarcodeFormat barcodeFormat13 = new BarcodeFormat(93, "CODE93");
        f1647r = barcodeFormat13;
        BarcodeFormat barcodeFormat14 = new BarcodeFormat(128, "CODE128");
        f1648s = barcodeFormat14;
        ArrayList arrayList = new ArrayList();
        f1649t = arrayList;
        arrayList.add(barcodeFormat);
        arrayList.add(barcodeFormat2);
        arrayList.add(barcodeFormat3);
        arrayList.add(barcodeFormat4);
        arrayList.add(barcodeFormat5);
        arrayList.add(barcodeFormat6);
        arrayList.add(barcodeFormat7);
        arrayList.add(barcodeFormat8);
        arrayList.add(barcodeFormat9);
        arrayList.add(barcodeFormat10);
        arrayList.add(barcodeFormat11);
        arrayList.add(barcodeFormat12);
        arrayList.add(barcodeFormat13);
        arrayList.add(barcodeFormat14);
        ArrayList arrayList2 = new ArrayList();
        f1650u = arrayList2;
        arrayList2.add(barcodeFormat);
        arrayList2.add(barcodeFormat2);
        arrayList2.add(barcodeFormat3);
        arrayList2.add(barcodeFormat4);
        arrayList2.add(barcodeFormat5);
        arrayList2.add(barcodeFormat6);
        arrayList2.add(barcodeFormat7);
        arrayList2.add(barcodeFormat8);
        arrayList2.add(barcodeFormat9);
        arrayList2.add(barcodeFormat10);
        arrayList2.add(barcodeFormat11);
        arrayList2.add(barcodeFormat13);
        arrayList2.add(barcodeFormat14);
        ArrayList arrayList3 = new ArrayList();
        f1651v = arrayList3;
        arrayList3.add(barcodeFormat11);
        arrayList3.add(barcodeFormat12);
        ArrayList arrayList4 = new ArrayList();
        f1652w = arrayList4;
        arrayList4.add(barcodeFormat12);
        arrayList4.add(barcodeFormat6);
        arrayList4.add(barcodeFormat4);
        arrayList4.add(barcodeFormat5);
        arrayList4.add(barcodeFormat14);
    }

    private BarcodeFormat(int i, String str) {
        this.f1653a = i;
        this.f1654b = str;
    }

    /* renamed from: a */
    public static BarcodeFormat m57936a(int i) {
        for (BarcodeFormat barcodeFormat : f1649t) {
            if (barcodeFormat.m57935b() == i) {
                return barcodeFormat;
            }
        }
        return f1632c;
    }

    /* renamed from: b */
    public int m57935b() {
        return this.f1653a;
    }

    /* renamed from: c */
    public String m57934c() {
        return this.f1654b;
    }
}
