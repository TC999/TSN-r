package com.sun.mail.imap.protocol;

import io.netty.util.internal.StringUtil;
import java.util.Vector;

/* renamed from: com.sun.mail.imap.protocol.o */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class MessageSet {

    /* renamed from: a */
    public int f36166a;

    /* renamed from: b */
    public int f36167b;

    public MessageSet() {
    }

    /* renamed from: a */
    public static MessageSet[] m16113a(int[] iArr) {
        Vector vector = new Vector();
        int i = 0;
        while (i < iArr.length) {
            MessageSet messageSet = new MessageSet();
            messageSet.f36166a = iArr[i];
            do {
                i++;
                if (i >= iArr.length) {
                    break;
                }
                int i2 = i - 1;
                messageSet.f36167b = iArr[i2];
                vector.addElement(messageSet);
                i = i2 + 1;
            } while (iArr[i] == iArr[i - 1] + 1);
            int i22 = i - 1;
            messageSet.f36167b = iArr[i22];
            vector.addElement(messageSet);
            i = i22 + 1;
        }
        MessageSet[] messageSetArr = new MessageSet[vector.size()];
        vector.copyInto(messageSetArr);
        return messageSetArr;
    }

    /* renamed from: c */
    public static int m16111c(MessageSet[] messageSetArr) {
        if (messageSetArr == null) {
            return 0;
        }
        int i = 0;
        for (MessageSet messageSet : messageSetArr) {
            i += messageSet.m16112b();
        }
        return i;
    }

    /* renamed from: d */
    public static String m16110d(MessageSet[] messageSetArr) {
        if (messageSetArr == null || messageSetArr.length == 0) {
            return null;
        }
        int i = 0;
        StringBuffer stringBuffer = new StringBuffer();
        int length = messageSetArr.length;
        while (true) {
            int i2 = messageSetArr[i].f36166a;
            int i3 = messageSetArr[i].f36167b;
            if (i3 > i2) {
                stringBuffer.append(i2);
                stringBuffer.append(':');
                stringBuffer.append(i3);
            } else {
                stringBuffer.append(i2);
            }
            i++;
            if (i >= length) {
                return stringBuffer.toString();
            }
            stringBuffer.append(StringUtil.COMMA);
        }
    }

    /* renamed from: b */
    public int m16112b() {
        return (this.f36167b - this.f36166a) + 1;
    }

    public MessageSet(int i, int i2) {
        this.f36166a = i;
        this.f36167b = i2;
    }
}
