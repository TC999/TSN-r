package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;
import java.util.Vector;

/* renamed from: com.sun.mail.imap.protocol.m */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ListInfo {

    /* renamed from: g */
    public static final int f36149g = 1;

    /* renamed from: h */
    public static final int f36150h = 2;

    /* renamed from: i */
    public static final int f36151i = 3;

    /* renamed from: a */
    public String f36152a;

    /* renamed from: b */
    public char f36153b;

    /* renamed from: c */
    public boolean f36154c;

    /* renamed from: d */
    public boolean f36155d;

    /* renamed from: e */
    public int f36156e;

    /* renamed from: f */
    public String[] f36157f;

    public ListInfo(IMAPResponse iMAPResponse) throws ParsingException {
        this.f36152a = null;
        this.f36153b = '/';
        this.f36154c = true;
        this.f36155d = true;
        this.f36156e = 3;
        String[] m16118H = iMAPResponse.m16118H();
        Vector vector = new Vector();
        if (m16118H != null) {
            for (int i = 0; i < m16118H.length; i++) {
                if (m16118H[i].equalsIgnoreCase("\\Marked")) {
                    this.f36156e = 1;
                } else if (m16118H[i].equalsIgnoreCase("\\Unmarked")) {
                    this.f36156e = 2;
                } else if (m16118H[i].equalsIgnoreCase("\\Noselect")) {
                    this.f36155d = false;
                } else if (m16118H[i].equalsIgnoreCase("\\Noinferiors")) {
                    this.f36154c = false;
                }
                vector.addElement(m16118H[i]);
            }
        }
        String[] strArr = new String[vector.size()];
        this.f36157f = strArr;
        vector.copyInto(strArr);
        iMAPResponse.m16408B();
        if (iMAPResponse.m16389r() == 34) {
            char m16389r = (char) iMAPResponse.m16389r();
            this.f36153b = m16389r;
            if (m16389r == '\\') {
                this.f36153b = (char) iMAPResponse.m16389r();
            }
            iMAPResponse.m16409A(1);
        } else {
            iMAPResponse.m16409A(2);
        }
        iMAPResponse.m16408B();
        String m16390q = iMAPResponse.m16390q();
        this.f36152a = m16390q;
        this.f36152a = BASE64MailboxDecoder.m16226b(m16390q);
    }
}
