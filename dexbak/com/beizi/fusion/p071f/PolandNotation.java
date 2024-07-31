package com.beizi.fusion.p071f;

import java.util.Stack;
import org.slf4j.Marker;

/* renamed from: com.beizi.fusion.f.c */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class PolandNotation {
    /* renamed from: a */
    public static int m48517a(String str) {
        char charAt;
        Stack stack = new Stack();
        Stack stack2 = new Stack();
        int length = str.length();
        int i = 0;
        while (i < length) {
            char charAt2 = str.charAt(i);
            if (charAt2 >= '0' && charAt2 <= '9') {
                String str2 = "" + charAt2;
                while (true) {
                    int i2 = i + 1;
                    if (i2 >= length || (charAt = str.charAt(i2)) < '0' || charAt > '9') {
                        break;
                    }
                    str2 = str2 + charAt;
                    i = i2;
                }
                stack.push(str2);
            } else if (charAt2 == '(') {
                stack2.push("" + charAt2);
            } else if (charAt2 == ')') {
                while (!((String) stack2.peek()).equals("(")) {
                    stack.push("" + m48518a(Integer.parseInt((String) stack.pop()), (String) stack2.pop(), Integer.parseInt((String) stack.pop())));
                }
                stack2.pop();
            } else if (m48519a(charAt2)) {
                if (stack2.empty()) {
                    stack2.push("" + charAt2);
                } else {
                    String str3 = "" + charAt2;
                    if (m48516b(str3) > m48516b((String) stack2.peek())) {
                        stack2.push(str3);
                    } else {
                        while (!stack2.empty() && m48516b(str3) <= m48516b((String) stack2.peek())) {
                            stack.push("" + m48518a(Integer.parseInt((String) stack.pop()), (String) stack2.pop(), Integer.parseInt((String) stack.pop())));
                        }
                        stack2.push(str3);
                    }
                }
            } else {
                throw new RuntimeException("无法识别" + charAt2);
            }
            i++;
        }
        while (!stack2.empty()) {
            stack.push("" + m48518a(Integer.parseInt((String) stack.pop()), (String) stack2.pop(), Integer.parseInt((String) stack.pop())));
        }
        return Integer.parseInt((String) stack.pop());
    }

    /* renamed from: a */
    private static boolean m48519a(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '%';
    }

    /* renamed from: b */
    private static float m48516b(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 37:
                if (str.equals("%")) {
                    c = 0;
                    break;
                }
                break;
            case 40:
                if (str.equals("(")) {
                    c = 1;
                    break;
                }
                break;
            case 42:
                if (str.equals("*")) {
                    c = 2;
                    break;
                }
                break;
            case 43:
                if (str.equals(Marker.ANY_NON_NULL_MARKER)) {
                    c = 3;
                    break;
                }
                break;
            case 45:
                if (str.equals("-")) {
                    c = 4;
                    break;
                }
                break;
            case 47:
                if (str.equals("/")) {
                    c = 5;
                    break;
                }
                break;
        }
        switch (c) {
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

    /* renamed from: a */
    private static int m48518a(int i, String str, int i2) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case 37:
                if (str.equals("%")) {
                    c = 0;
                    break;
                }
                break;
            case 42:
                if (str.equals("*")) {
                    c = 1;
                    break;
                }
                break;
            case 43:
                if (str.equals(Marker.ANY_NON_NULL_MARKER)) {
                    c = 2;
                    break;
                }
                break;
            case 45:
                if (str.equals("-")) {
                    c = 3;
                    break;
                }
                break;
            case 47:
                if (str.equals("/")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return i % i2;
            case 1:
                return i * i2;
            case 2:
                return i + i2;
            case 3:
                return i - i2;
            case 4:
                return i / i2;
            default:
                return 0;
        }
    }
}
