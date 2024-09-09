package org.apache.harmony.awt.internal.nls;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class Messages {
    private static ResourceBundle bundle;

    static {
        try {
            bundle = setLocale(Locale.getDefault(), "org.apache.harmony.awt.internal.nls.messages");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String format(String str, Object[] objArr) {
        int length;
        StringBuilder sb = new StringBuilder(str.length() + (objArr.length * 20));
        int length2 = objArr.length;
        String[] strArr = new String[length2];
        int i4 = 0;
        for (int i5 = 0; i5 < objArr.length; i5++) {
            if (objArr[i5] == null) {
                strArr[i5] = "<null>";
            } else {
                strArr[i5] = objArr[i5].toString();
            }
        }
        while (true) {
            int indexOf = str.indexOf(123, i4);
            if (indexOf < 0) {
                break;
            }
            if (indexOf != 0) {
                int i6 = indexOf - 1;
                if (str.charAt(i6) == '\\') {
                    if (indexOf != 1) {
                        sb.append(str.substring(i4, i6));
                    }
                    sb.append('{');
                    length = indexOf + 1;
                    i4 = length;
                }
            }
            if (indexOf > str.length() - 3) {
                sb.append(str.substring(i4, str.length()));
                length = str.length();
            } else {
                int i7 = indexOf + 1;
                byte digit = (byte) Character.digit(str.charAt(i7), 10);
                if (digit >= 0 && str.charAt(indexOf + 2) == '}') {
                    sb.append(str.substring(i4, indexOf));
                    if (digit >= length2) {
                        sb.append("<missing argument>");
                    } else {
                        sb.append(strArr[digit]);
                    }
                    length = indexOf + 3;
                } else {
                    sb.append(str.substring(i4, i7));
                    i4 = i7;
                }
            }
            i4 = length;
        }
        if (i4 < str.length()) {
            sb.append(str.substring(i4, str.length()));
        }
        return sb.toString();
    }

    public static String getString(String str) {
        ResourceBundle resourceBundle = bundle;
        if (resourceBundle == null) {
            return str;
        }
        try {
            return resourceBundle.getString(str);
        } catch (MissingResourceException unused) {
            return "Missing message: " + str;
        }
    }

    public static ResourceBundle setLocale(final Locale locale, final String str) {
        try {
            return (ResourceBundle) AccessController.doPrivileged(new PrivilegedAction<Object>() { // from class: org.apache.harmony.awt.internal.nls.Messages.1
                @Override // java.security.PrivilegedAction
                public Object run() {
                    String str2 = str;
                    Locale locale2 = locale;
                    ClassLoader classLoader = r3;
                    if (classLoader == null) {
                        classLoader = ClassLoader.getSystemClassLoader();
                    }
                    return ResourceBundle.getBundle(str2, locale2, classLoader);
                }
            });
        } catch (MissingResourceException unused) {
            return null;
        }
    }

    public static String getString(String str, Object obj) {
        return getString(str, new Object[]{obj});
    }

    public static String getString(String str, int i4) {
        return getString(str, new Object[]{Integer.toString(i4)});
    }

    public static String getString(String str, char c4) {
        return getString(str, new Object[]{String.valueOf(c4)});
    }

    public static String getString(String str, Object obj, Object obj2) {
        return getString(str, new Object[]{obj, obj2});
    }

    public static String getString(String str, Object[] objArr) {
        ResourceBundle resourceBundle = bundle;
        if (resourceBundle != null) {
            try {
                str = resourceBundle.getString(str);
            } catch (MissingResourceException unused) {
            }
        }
        return format(str, objArr);
    }
}
