package com.sun.mail.imap;

import com.sun.mail.imap.protocol.w;
import java.util.Vector;
import javax.mail.Message;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: Utility.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class o {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: Utility.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface a {
        boolean a(g gVar);
    }

    private o() {
    }

    public static com.sun.mail.imap.protocol.o[] a(Message[] messageArr, a aVar) {
        Vector vector = new Vector(1);
        int i4 = 0;
        while (i4 < messageArr.length) {
            g gVar = (g) messageArr[i4];
            if (!gVar.isExpunged()) {
                int w3 = gVar.w();
                if (aVar == null || aVar.a(gVar)) {
                    com.sun.mail.imap.protocol.o oVar = new com.sun.mail.imap.protocol.o();
                    oVar.f50576a = w3;
                    while (true) {
                        i4++;
                        if (i4 >= messageArr.length) {
                            break;
                        }
                        g gVar2 = (g) messageArr[i4];
                        if (!gVar2.isExpunged()) {
                            int w4 = gVar2.w();
                            if (aVar == null || aVar.a(gVar2)) {
                                if (w4 != w3 + 1) {
                                    i4--;
                                    break;
                                }
                                w3 = w4;
                            }
                        }
                    }
                    oVar.f50577b = w3;
                    vector.addElement(oVar);
                }
            }
            i4++;
        }
        if (vector.isEmpty()) {
            return null;
        }
        com.sun.mail.imap.protocol.o[] oVarArr = new com.sun.mail.imap.protocol.o[vector.size()];
        vector.copyInto(oVarArr);
        return oVarArr;
    }

    public static w[] b(Message[] messageArr) {
        Vector vector = new Vector(1);
        int i4 = 0;
        while (i4 < messageArr.length) {
            g gVar = (g) messageArr[i4];
            if (!gVar.isExpunged()) {
                long x3 = gVar.x();
                w wVar = new w();
                wVar.f50601a = x3;
                while (true) {
                    i4++;
                    if (i4 < messageArr.length) {
                        g gVar2 = (g) messageArr[i4];
                        if (!gVar2.isExpunged()) {
                            long x4 = gVar2.x();
                            if (x4 != 1 + x3) {
                                i4--;
                                break;
                            }
                            x3 = x4;
                        }
                    } else {
                        break;
                    }
                }
                wVar.f50602b = x3;
                vector.addElement(wVar);
            }
            i4++;
        }
        if (vector.isEmpty()) {
            return null;
        }
        w[] wVarArr = new w[vector.size()];
        vector.copyInto(wVarArr);
        return wVarArr;
    }
}
