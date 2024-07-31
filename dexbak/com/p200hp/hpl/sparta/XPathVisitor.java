package com.p200hp.hpl.sparta;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.hp.hpl.sparta.j */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class XPathVisitor {

    /* renamed from: c */
    private static final Integer f23883c = new Integer(1);

    /* renamed from: d */
    private static final Integer f23884d = new Integer(2);

    /* renamed from: e */
    private static final Integer f23885e = new Integer(3);

    /* renamed from: f */
    private static final Integer f23886f = new Integer(4);

    /* renamed from: g */
    private static final Integer f23887g = new Integer(5);

    /* renamed from: h */
    private static final Integer f23888h = new Integer(6);

    /* renamed from: i */
    private static final Integer f23889i = new Integer(7);

    /* renamed from: j */
    private static final Integer f23890j = new Integer(8);

    /* renamed from: k */
    private static final Integer f23891k = new Integer(9);

    /* renamed from: l */
    private static final Integer f23892l = new Integer(10);

    /* renamed from: a */
    private final Vector f23893a = new Vector();

    /* renamed from: b */
    private Hashtable f23894b = new Hashtable();

    /* renamed from: c */
    private static Integer m35231c(Node node) {
        return new Integer(System.identityHashCode(node));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m35233a(Node node, int i) {
        Integer num;
        this.f23893a.addElement(node);
        switch (i) {
            case 1:
                num = f23883c;
                break;
            case 2:
                num = f23884d;
                break;
            case 3:
                num = f23885e;
                break;
            case 4:
                num = f23886f;
                break;
            case 5:
                num = f23887g;
                break;
            case 6:
                num = f23888h;
                break;
            case 7:
                num = f23889i;
                break;
            case 8:
                num = f23890j;
                break;
            case 9:
                num = f23891k;
                break;
            case 10:
                num = f23892l;
                break;
            default:
                num = new Integer(i);
                break;
        }
        this.f23894b.put(m35231c(node), num);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m35232b(String str) {
        this.f23893a.addElement(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public Enumeration m35230d() {
        return this.f23893a.elements();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public int m35229e(Node node) {
        return ((Integer) this.f23894b.get(m35231c(node))).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public void m35228f() {
        this.f23893a.removeAllElements();
        this.f23894b.clear();
    }

    public String toString() {
        try {
            StringBuffer stringBuffer = new StringBuffer("{ ");
            Enumeration elements = this.f23893a.elements();
            while (elements.hasMoreElements()) {
                Object nextElement = elements.nextElement();
                if (nextElement instanceof String) {
                    stringBuffer.append("String(" + nextElement + ") ");
                } else {
                    Node node = (Node) nextElement;
                    stringBuffer.append("Node(" + node.m35235q() + ")[" + this.f23894b.get(m35231c(node)) + "] ");
                }
            }
            stringBuffer.append("}");
            return stringBuffer.toString();
        } catch (IOException e) {
            return e.toString();
        }
    }
}
