package com.tencent.turingfd.sdk.ams.au;

import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/* compiled from: A */
/* renamed from: com.tencent.turingfd.sdk.ams.au.public  reason: invalid class name */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Cpublic {

    /* renamed from: j  reason: collision with root package name */
    public static final String[] f52345j = {"px", "dp", "sp", "pt", "in", "mm"};

    /* renamed from: a  reason: collision with root package name */
    public Cnative f52346a;

    /* renamed from: b  reason: collision with root package name */
    public Map<String, String> f52347b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public byte[] f52348c;

    /* renamed from: d  reason: collision with root package name */
    public String[] f52349d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f52350e;

    /* renamed from: f  reason: collision with root package name */
    public int f52351f;

    /* renamed from: g  reason: collision with root package name */
    public int f52352g;

    /* renamed from: h  reason: collision with root package name */
    public int f52353h;

    /* renamed from: i  reason: collision with root package name */
    public int f52354i;

    public Document a(InputStream inputStream) throws IOException, ParserConfigurationException {
        String b4;
        String str;
        Element createElementNS;
        String format;
        byte[] bArr;
        Cnative cnative = new Cnative();
        this.f52346a = cnative;
        byte[] bArr2 = new byte[inputStream.available()];
        this.f52348c = bArr2;
        inputStream.read(bArr2);
        inputStream.close();
        while (true) {
            int i4 = this.f52354i;
            if (i4 < this.f52348c.length) {
                int a4 = a(i4);
                int i5 = -1;
                if (a4 == -1) {
                    this.f52346a.getClass();
                } else if (a4 == 524291) {
                    Cnative cnative2 = this.f52346a;
                    Document newDocument = cnative2.f52330c.newDocument();
                    cnative2.f52329b = newDocument;
                    cnative2.f52328a.push(newDocument);
                    this.f52354i += 8;
                } else if (a4 == 524672) {
                    int a5 = a(this.f52354i + 4);
                    int i6 = (a5 / 4) - 2;
                    this.f52353h = i6;
                    this.f52350e = new int[i6];
                    for (int i7 = 0; i7 < this.f52353h; i7++) {
                        this.f52350e[i7] = a(((i7 + 2) * 4) + this.f52354i);
                    }
                    this.f52354i += a5;
                } else if (a4 != 1835009) {
                    switch (a4) {
                        case 1048832:
                            a(true);
                            continue;
                        case 1048833:
                            a(false);
                            continue;
                        case 1048834:
                            int a6 = a(this.f52354i + 16);
                            int a7 = a(this.f52354i + 20);
                            int i8 = this.f52354i + 28;
                            byte[] bArr3 = this.f52348c;
                            int i9 = (65280 & (bArr3[i8 + 1] << 8)) | ((bArr3[i8 + 0] << 0) & 255);
                            String b5 = b(a7);
                            if (a6 == -1) {
                                str = b5;
                                b4 = "";
                            } else {
                                b4 = b(a6);
                                str = this.f52347b.containsKey(b4) ? this.f52347b.get(b4) + ':' + b5 : b5;
                            }
                            this.f52354i += 36;
                            Ccase[] ccaseArr = new Ccase[i9];
                            int i10 = 0;
                            while (i10 < i9) {
                                int a8 = a(this.f52354i);
                                int a9 = a(this.f52354i + 4);
                                int a10 = a(this.f52354i + 8);
                                int a11 = a(this.f52354i + 12);
                                int a12 = a(this.f52354i + 16);
                                Ccase ccase = new Ccase();
                                ccase.f52224a = b(a9);
                                if (a8 == i5) {
                                    ccase.f52226c = null;
                                    ccase.f52225b = null;
                                } else {
                                    String b6 = b(a8);
                                    if (this.f52347b.containsKey(b6)) {
                                        ccase.f52226c = b6;
                                        ccase.f52225b = this.f52347b.get(b6);
                                    }
                                }
                                if (a10 == i5) {
                                    switch (a11) {
                                        case 16777224:
                                            format = String.format("@id/0x%08X", Integer.valueOf(a12));
                                            break;
                                        case 33554440:
                                            format = String.format("?id/0x%08X", Integer.valueOf(a12));
                                            break;
                                        case 50331656:
                                            format = b(a12);
                                            break;
                                        case 67108872:
                                            format = Float.toString(Float.intBitsToFloat(a12));
                                            break;
                                        case 83886088:
                                            format = Integer.toString(a12 >> 8) + f52345j[a12 & 255];
                                            break;
                                        case 100663304:
                                            double d4 = a12;
                                            Double.isNaN(d4);
                                            format = new DecimalFormat("#.##%").format(d4 / 2.147483647E9d);
                                            break;
                                        case 268435464:
                                        case 285212680:
                                            format = Integer.toString(a12);
                                            break;
                                        case 301989896:
                                            format = Boolean.toString(a12 != 0);
                                            break;
                                        case 469762056:
                                        case 486539272:
                                            format = String.format("#%08X", Integer.valueOf(a12));
                                            break;
                                        default:
                                            format = String.format("%08X/0x%08X", Integer.valueOf(a11), Integer.valueOf(a12));
                                            break;
                                    }
                                    ccase.f52227d = format;
                                } else {
                                    ccase.f52227d = b(a10);
                                }
                                ccaseArr[i10] = ccase;
                                this.f52354i += 20;
                                i10++;
                                i5 = -1;
                            }
                            Cnative cnative3 = this.f52346a;
                            cnative3.getClass();
                            if (b4 == null || "".equals(b4)) {
                                createElementNS = cnative3.f52329b.createElement(b5);
                            } else {
                                createElementNS = cnative3.f52329b.createElementNS(b4, str);
                            }
                            for (int i11 = 0; i11 < i9; i11++) {
                                Ccase ccase2 = ccaseArr[i11];
                                String str2 = ccase2.f52226c;
                                if (str2 == null || "".equals(str2)) {
                                    createElementNS.setAttribute(ccase2.f52224a, ccase2.f52227d);
                                } else {
                                    createElementNS.setAttributeNS(ccase2.f52226c, ccase2.f52225b + ':' + ccase2.f52224a, ccase2.f52227d);
                                }
                            }
                            cnative3.f52328a.peek().appendChild(createElementNS);
                            cnative3.f52328a.push(createElementNS);
                            continue;
                        case 1048835:
                            int a13 = a(this.f52354i + 16);
                            b(a(this.f52354i + 20));
                            if (a13 != -1) {
                                b(a13);
                            }
                            this.f52346a.f52328a.pop();
                            this.f52354i += 24;
                            continue;
                        case 1048836:
                            String b7 = b(a(this.f52354i + 16));
                            Cnative cnative4 = this.f52346a;
                            cnative4.f52328a.peek().appendChild(cnative4.f52329b.createCDATASection(b7));
                            this.f52354i += 28;
                            continue;
                        default:
                            this.f52354i += 4;
                            continue;
                    }
                } else {
                    int a14 = a(this.f52354i + 4);
                    this.f52351f = a(this.f52354i + 8);
                    this.f52352g = a(this.f52354i + 12);
                    int i12 = this.f52354i;
                    int a15 = a(i12 + 20) + i12;
                    int a16 = a(this.f52354i + 24);
                    this.f52349d = new String[this.f52351f];
                    for (int i13 = 0; i13 < this.f52351f; i13++) {
                        int a17 = a(((i13 + 7) * 4) + this.f52354i) + a15;
                        String[] strArr = this.f52349d;
                        byte[] bArr4 = this.f52348c;
                        int i14 = a17 + 1;
                        if (bArr4[i14] == bArr4[a17]) {
                            int i15 = bArr4[a17];
                            bArr = new byte[i15];
                            for (int i16 = 0; i16 < i15; i16++) {
                                bArr[i16] = this.f52348c[a17 + 2 + i16];
                            }
                        } else {
                            int i17 = (bArr4[a17] & 255) | ((bArr4[i14] << 8) & 65280);
                            bArr = new byte[i17];
                            for (int i18 = 0; i18 < i17; i18++) {
                                bArr[i18] = this.f52348c[(i18 * 2) + a17 + 2];
                            }
                        }
                        strArr[i13] = new String(bArr);
                    }
                    if (a16 > 0) {
                        for (int i19 = 0; i19 < this.f52352g; i19++) {
                        }
                    }
                    this.f52354i += a14;
                }
            } else {
                this.f52346a.getClass();
                return cnative.f52329b;
            }
        }
    }

    public final String b(int i4) {
        if (i4 < 0 || i4 >= this.f52351f) {
            return null;
        }
        return this.f52349d[i4];
    }

    public final void a(boolean z3) {
        int a4 = a(this.f52354i + 16);
        String b4 = b(a(this.f52354i + 20));
        String b5 = b(a4);
        if (z3) {
            this.f52346a.getClass();
            this.f52347b.put(b4, b5);
        } else {
            this.f52346a.getClass();
            this.f52347b.remove(b4);
        }
        this.f52354i += 24;
    }

    public final int a(int i4) {
        byte[] bArr = this.f52348c;
        return ((bArr[i4 + 0] << 0) & 255) | ((bArr[i4 + 3] << 24) & (-16777216)) | ((bArr[i4 + 2] << 16) & 16711680) | ((bArr[i4 + 1] << 8) & 65280);
    }
}
