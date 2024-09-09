package com.hp.hpl.sparta;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* compiled from: XPathVisitor.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class j {

    /* renamed from: c  reason: collision with root package name */
    private static final Integer f37385c = new Integer(1);

    /* renamed from: d  reason: collision with root package name */
    private static final Integer f37386d = new Integer(2);

    /* renamed from: e  reason: collision with root package name */
    private static final Integer f37387e = new Integer(3);

    /* renamed from: f  reason: collision with root package name */
    private static final Integer f37388f = new Integer(4);

    /* renamed from: g  reason: collision with root package name */
    private static final Integer f37389g = new Integer(5);

    /* renamed from: h  reason: collision with root package name */
    private static final Integer f37390h = new Integer(6);

    /* renamed from: i  reason: collision with root package name */
    private static final Integer f37391i = new Integer(7);

    /* renamed from: j  reason: collision with root package name */
    private static final Integer f37392j = new Integer(8);

    /* renamed from: k  reason: collision with root package name */
    private static final Integer f37393k = new Integer(9);

    /* renamed from: l  reason: collision with root package name */
    private static final Integer f37394l = new Integer(10);

    /* renamed from: a  reason: collision with root package name */
    private final Vector f37395a = new Vector();

    /* renamed from: b  reason: collision with root package name */
    private Hashtable f37396b = new Hashtable();

    private static Integer c(i iVar) {
        return new Integer(System.identityHashCode(iVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(i iVar, int i4) {
        Integer num;
        this.f37395a.addElement(iVar);
        switch (i4) {
            case 1:
                num = f37385c;
                break;
            case 2:
                num = f37386d;
                break;
            case 3:
                num = f37387e;
                break;
            case 4:
                num = f37388f;
                break;
            case 5:
                num = f37389g;
                break;
            case 6:
                num = f37390h;
                break;
            case 7:
                num = f37391i;
                break;
            case 8:
                num = f37392j;
                break;
            case 9:
                num = f37393k;
                break;
            case 10:
                num = f37394l;
                break;
            default:
                num = new Integer(i4);
                break;
        }
        this.f37396b.put(c(iVar), num);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str) {
        this.f37395a.addElement(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Enumeration d() {
        return this.f37395a.elements();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e(i iVar) {
        return ((Integer) this.f37396b.get(c(iVar))).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        this.f37395a.removeAllElements();
        this.f37396b.clear();
    }

    public String toString() {
        try {
            StringBuffer stringBuffer = new StringBuffer("{ ");
            Enumeration elements = this.f37395a.elements();
            while (elements.hasMoreElements()) {
                Object nextElement = elements.nextElement();
                if (nextElement instanceof String) {
                    stringBuffer.append("String(" + nextElement + ") ");
                } else {
                    i iVar = (i) nextElement;
                    stringBuffer.append("Node(" + iVar.q() + ")[" + this.f37396b.get(c(iVar)) + "] ");
                }
            }
            stringBuffer.append("}");
            return stringBuffer.toString();
        } catch (IOException e4) {
            return e4.toString();
        }
    }
}
