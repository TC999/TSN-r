package org.apache.harmony.awt.datatransfer;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.SystemFlavorMap;
import java.io.InputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class TextFlavor {
    public static final Class[] unicodeTextClasses = {String.class, Reader.class, CharBuffer.class, char[].class};
    public static final Class[] charsetTextClasses = {InputStream.class, ByteBuffer.class, byte[].class};

    public static void addCharsetClasses(SystemFlavorMap systemFlavorMap, String str, String str2, String str3) {
        Class[] clsArr;
        String str4;
        int i4 = 0;
        while (true) {
            if (i4 >= charsetTextClasses.length) {
                return;
            }
            DataFlavor dataFlavor = new DataFlavor(String.valueOf(str4) + (";class=\"" + clsArr[i4].getName() + "\";charset=\"" + str3 + "\""), "text/" + str2);
            systemFlavorMap.addFlavorForUnencodedNative(str, dataFlavor);
            systemFlavorMap.addUnencodedNativeForFlavor(dataFlavor, str);
            i4++;
        }
    }

    public static void addUnicodeClasses(SystemFlavorMap systemFlavorMap, String str, String str2) {
        Class[] clsArr;
        String str3;
        int i4 = 0;
        while (true) {
            if (i4 >= unicodeTextClasses.length) {
                return;
            }
            DataFlavor dataFlavor = new DataFlavor(String.valueOf(str3) + (";class=\"" + clsArr[i4].getName() + "\""), "text/" + str2);
            systemFlavorMap.addFlavorForUnencodedNative(str, dataFlavor);
            systemFlavorMap.addUnencodedNativeForFlavor(dataFlavor, str);
            i4++;
        }
    }
}
