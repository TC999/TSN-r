package com.qq.e.dl.l.m.b;

import com.qq.e.dl.k.g;
import com.qq.e.dl.k.n;
import com.qq.e.dl.l.h;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public abstract class a extends h {
    public a(com.qq.e.dl.a aVar) {
        super(aVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private boolean c(String str, g gVar) {
        char c4;
        int hashCode = str.hashCode();
        if (hashCode != 1571) {
            switch (hashCode) {
                case 1753:
                    if (str.equals("70")) {
                        c4 = 6;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case 1754:
                    if (str.equals("71")) {
                        c4 = 0;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case 1755:
                    if (str.equals("72")) {
                        c4 = 1;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case 1756:
                    if (str.equals("73")) {
                        c4 = 2;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case 1757:
                    if (str.equals("74")) {
                        c4 = 5;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                case 1758:
                    if (str.equals("75")) {
                        c4 = 3;
                        break;
                    }
                    c4 = '\uffff';
                    break;
                default:
                    c4 = '\uffff';
                    break;
            }
        } else {
            if (str.equals("14")) {
                c4 = 4;
            }
            c4 = '\uffff';
        }
        switch (c4) {
            case 0:
                a(gVar.toString());
                break;
            case 1:
                l(gVar.b(new JSONObject[0]));
                break;
            case 2:
                k(n.a(gVar));
                break;
            case 3:
                j(gVar.b(new JSONObject[0]));
                break;
            case 4:
                i(n.b(gVar));
                break;
            case 5:
                m(gVar.b(new JSONObject[0]));
                break;
            case 6:
                a((gVar.b(new JSONObject[0]) & 1) == 1);
                break;
            default:
                return false;
        }
        return true;
    }

    protected abstract void a(CharSequence charSequence);

    protected abstract void a(boolean z3);

    @Override // com.qq.e.dl.l.h
    public boolean a(String str, g gVar) {
        return c(str, gVar) || super.a(str, gVar);
    }

    protected abstract void i(int i4);

    protected abstract void j(int i4);

    protected abstract void k(int i4);

    protected abstract void l(int i4);

    protected abstract void m(int i4);
}
