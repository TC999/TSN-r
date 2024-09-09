package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class p {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static ev c(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.xv.r rVar, com.bytedance.sdk.component.adexpress.dynamic.xv.p pVar, com.bytedance.sdk.component.adexpress.w.bk bkVar) {
        if (context == null || dynamicBaseWidget == null || rVar == null) {
            return null;
        }
        String m4 = rVar.m();
        String q3 = bkVar.q();
        m4.hashCode();
        char c4 = '\uffff';
        switch (m4.hashCode()) {
            case 48:
                if (m4.equals("0")) {
                    c4 = 0;
                    break;
                }
                break;
            case 49:
                if (m4.equals("1")) {
                    c4 = 1;
                    break;
                }
                break;
            case 50:
                if (m4.equals("2")) {
                    c4 = 2;
                    break;
                }
                break;
            case 53:
                if (m4.equals("5")) {
                    c4 = 3;
                    break;
                }
                break;
            case 54:
                if (m4.equals("6")) {
                    c4 = 4;
                    break;
                }
                break;
            case 55:
                if (m4.equals("7")) {
                    c4 = 5;
                    break;
                }
                break;
            case 56:
                if (m4.equals("8")) {
                    c4 = 6;
                    break;
                }
                break;
            case 57:
                if (m4.equals("9")) {
                    c4 = 7;
                    break;
                }
                break;
            case 1567:
                if (m4.equals("10")) {
                    c4 = '\b';
                    break;
                }
                break;
            case 1568:
                if (m4.equals("11")) {
                    c4 = '\t';
                    break;
                }
                break;
            case 1569:
                if (m4.equals("12")) {
                    c4 = '\n';
                    break;
                }
                break;
            case 1570:
                if (m4.equals("13")) {
                    c4 = 11;
                    break;
                }
                break;
            case 1571:
                if (m4.equals("14")) {
                    c4 = '\f';
                    break;
                }
                break;
            case 1573:
                if (m4.equals("16")) {
                    c4 = '\r';
                    break;
                }
                break;
            case 1574:
                if (m4.equals("17")) {
                    c4 = 14;
                    break;
                }
                break;
            case 1575:
                if (m4.equals("18")) {
                    c4 = 15;
                    break;
                }
                break;
            case 1598:
                if (m4.equals("20")) {
                    c4 = 16;
                    break;
                }
                break;
            case 1600:
                if (m4.equals("22")) {
                    c4 = 17;
                    break;
                }
                break;
            case 1601:
                if (m4.equals("23")) {
                    c4 = 18;
                    break;
                }
                break;
            case 1602:
                if (m4.equals("24")) {
                    c4 = 19;
                    break;
                }
                break;
            case 1603:
                if (m4.equals("25")) {
                    c4 = 20;
                    break;
                }
                break;
            case 1607:
                if (m4.equals("29")) {
                    c4 = 21;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return new f(context, dynamicBaseWidget, rVar);
            case 1:
                break;
            case 2:
                return new xv(context, dynamicBaseWidget, rVar);
            case 3:
                if (rVar.vc() == 1) {
                    return new fz(context, dynamicBaseWidget, rVar, rVar.ok());
                }
                return new ia(context, dynamicBaseWidget, rVar);
            case 4:
            case '\t':
                return new t(context, dynamicBaseWidget, rVar);
            case 5:
            case '\f':
                return new a(context, dynamicBaseWidget, rVar);
            case 6:
                return new bk(context, dynamicBaseWidget, rVar);
            case 7:
            case '\r':
                return new ys(context, dynamicBaseWidget, rVar, m4, pVar.c(), pVar.w(), pVar.sr());
            case '\b':
                return new ux(context, dynamicBaseWidget, rVar);
            case '\n':
                return new ia(context, dynamicBaseWidget, rVar);
            case 11:
                return new fz(context, dynamicBaseWidget, rVar);
            case 14:
            case 15:
                return new i(context, dynamicBaseWidget, rVar, m4, pVar);
            case 16:
                return new w(context, dynamicBaseWidget, rVar);
            case 17:
                if (com.bytedance.sdk.component.adexpress.sr.c()) {
                    return new s(context, dynamicBaseWidget, rVar);
                }
                return new u(context, dynamicBaseWidget, rVar);
            case 18:
                if (com.bytedance.sdk.component.adexpress.sr.c()) {
                    return new k(context, dynamicBaseWidget, rVar, q3 + "static/lotties/202327swiper-up-star/click.json");
                }
                return null;
            case 19:
                if (com.bytedance.sdk.component.adexpress.sr.c()) {
                    return new c(context, dynamicBaseWidget, rVar);
                }
                return new s(context, dynamicBaseWidget, rVar);
            case 20:
                if (com.bytedance.sdk.component.adexpress.sr.c()) {
                    new k(context, dynamicBaseWidget, rVar, q3 + "static/lotties/gesture-slide.json");
                    break;
                }
                break;
            case 21:
                return new r(context, dynamicBaseWidget, rVar, pVar.c(), pVar.w(), pVar.sr());
            default:
                return null;
        }
        return new sr(context, dynamicBaseWidget, rVar);
    }
}
