package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;
import java.util.Vector;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ListInfo.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class m {

    /* renamed from: g  reason: collision with root package name */
    public static final int f50559g = 1;

    /* renamed from: h  reason: collision with root package name */
    public static final int f50560h = 2;

    /* renamed from: i  reason: collision with root package name */
    public static final int f50561i = 3;

    /* renamed from: a  reason: collision with root package name */
    public String f50562a;

    /* renamed from: b  reason: collision with root package name */
    public char f50563b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f50564c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f50565d;

    /* renamed from: e  reason: collision with root package name */
    public int f50566e;

    /* renamed from: f  reason: collision with root package name */
    public String[] f50567f;

    public m(i iVar) throws ParsingException {
        this.f50562a = null;
        this.f50563b = '/';
        this.f50564c = true;
        this.f50565d = true;
        this.f50566e = 3;
        String[] H = iVar.H();
        Vector vector = new Vector();
        if (H != null) {
            for (int i4 = 0; i4 < H.length; i4++) {
                if (H[i4].equalsIgnoreCase("\\Marked")) {
                    this.f50566e = 1;
                } else if (H[i4].equalsIgnoreCase("\\Unmarked")) {
                    this.f50566e = 2;
                } else if (H[i4].equalsIgnoreCase("\\Noselect")) {
                    this.f50565d = false;
                } else if (H[i4].equalsIgnoreCase("\\Noinferiors")) {
                    this.f50564c = false;
                }
                vector.addElement(H[i4]);
            }
        }
        String[] strArr = new String[vector.size()];
        this.f50567f = strArr;
        vector.copyInto(strArr);
        iVar.B();
        if (iVar.r() == 34) {
            char r3 = (char) iVar.r();
            this.f50563b = r3;
            if (r3 == '\\') {
                this.f50563b = (char) iVar.r();
            }
            iVar.A(1);
        } else {
            iVar.A(2);
        }
        iVar.B();
        String q3 = iVar.q();
        this.f50562a = q3;
        this.f50562a = a.b(q3);
    }
}
