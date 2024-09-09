package com.beizi.fusion.f;

import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.util.Stack;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: PolandNotation.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class c {
    public static int a(String str) {
        char charAt;
        Stack stack = new Stack();
        Stack stack2 = new Stack();
        int length = str.length();
        int i4 = 0;
        while (i4 < length) {
            char charAt2 = str.charAt(i4);
            if (charAt2 >= '0' && charAt2 <= '9') {
                String str2 = "" + charAt2;
                while (true) {
                    int i5 = i4 + 1;
                    if (i5 >= length || (charAt = str.charAt(i5)) < '0' || charAt > '9') {
                        break;
                    }
                    str2 = str2 + charAt;
                    i4 = i5;
                }
                stack.push(str2);
            } else if (charAt2 == '(') {
                stack2.push("" + charAt2);
            } else if (charAt2 == ')') {
                while (!((String) stack2.peek()).equals("(")) {
                    stack.push("" + a(Integer.parseInt((String) stack.pop()), (String) stack2.pop(), Integer.parseInt((String) stack.pop())));
                }
                stack2.pop();
            } else if (a(charAt2)) {
                if (stack2.empty()) {
                    stack2.push("" + charAt2);
                } else {
                    String str3 = "" + charAt2;
                    if (b(str3) > b((String) stack2.peek())) {
                        stack2.push(str3);
                    } else {
                        while (!stack2.empty() && b(str3) <= b((String) stack2.peek())) {
                            stack.push("" + a(Integer.parseInt((String) stack.pop()), (String) stack2.pop(), Integer.parseInt((String) stack.pop())));
                        }
                        stack2.push(str3);
                    }
                }
            } else {
                throw new RuntimeException("\u65e0\u6cd5\u8bc6\u522b" + charAt2);
            }
            i4++;
        }
        while (!stack2.empty()) {
            stack.push("" + a(Integer.parseInt((String) stack.pop()), (String) stack2.pop(), Integer.parseInt((String) stack.pop())));
        }
        return Integer.parseInt((String) stack.pop());
    }

    private static boolean a(char c4) {
        return c4 == '+' || c4 == '-' || c4 == '*' || c4 == '/' || c4 == '%';
    }

    private static float b(String str) {
        str.hashCode();
        char c4 = '\uffff';
        switch (str.hashCode()) {
            case 37:
                if (str.equals("%")) {
                    c4 = 0;
                    break;
                }
                break;
            case 40:
                if (str.equals("(")) {
                    c4 = 1;
                    break;
                }
                break;
            case 42:
                if (str.equals("*")) {
                    c4 = 2;
                    break;
                }
                break;
            case 43:
                if (str.equals("+")) {
                    c4 = 3;
                    break;
                }
                break;
            case 45:
                if (str.equals("-")) {
                    c4 = 4;
                    break;
                }
                break;
            case 47:
                if (str.equals(TTPathConst.sSeparator)) {
                    c4 = 5;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
            case 2:
            case 5:
                return 2.0f;
            case 1:
                return 0.0f;
            case 3:
            case 4:
                return 1.0f;
            default:
                return -1.0f;
        }
    }

    private static int a(int i4, String str, int i5) {
        str.hashCode();
        char c4 = '\uffff';
        switch (str.hashCode()) {
            case 37:
                if (str.equals("%")) {
                    c4 = 0;
                    break;
                }
                break;
            case 42:
                if (str.equals("*")) {
                    c4 = 1;
                    break;
                }
                break;
            case 43:
                if (str.equals("+")) {
                    c4 = 2;
                    break;
                }
                break;
            case 45:
                if (str.equals("-")) {
                    c4 = 3;
                    break;
                }
                break;
            case 47:
                if (str.equals(TTPathConst.sSeparator)) {
                    c4 = 4;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return i4 % i5;
            case 1:
                return i4 * i5;
            case 2:
                return i4 + i5;
            case 3:
                return i4 - i5;
            case 4:
                return i4 / i5;
            default:
                return 0;
        }
    }
}
