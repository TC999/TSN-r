package org.apache.harmony.awt.datatransfer;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.SystemFlavorMap;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class DataSnapshot implements DataProvider {
    private final String[] fileList;
    private final String html;
    private final String[] nativeFormats;
    private final RawBitmap rawBitmap;
    private final Map<Class<?>, byte[]> serializedObjects = Collections.synchronizedMap(new HashMap());
    private final String text;
    private final String url;

    public DataSnapshot(DataProvider dataProvider) {
        Class<?> representationClass;
        byte[] serializedObject;
        this.nativeFormats = dataProvider.getNativeFormats();
        this.text = dataProvider.getText();
        this.fileList = dataProvider.getFileList();
        this.url = dataProvider.getURL();
        this.html = dataProvider.getHTML();
        this.rawBitmap = dataProvider.getRawBitmap();
        int i4 = 0;
        while (true) {
            String[] strArr = this.nativeFormats;
            if (i4 >= strArr.length) {
                return;
            }
            DataFlavor dataFlavor = null;
            try {
                dataFlavor = SystemFlavorMap.decodeDataFlavor(strArr[i4]);
            } catch (ClassNotFoundException unused) {
            }
            if (dataFlavor != null && (serializedObject = dataProvider.getSerializedObject((representationClass = dataFlavor.getRepresentationClass()))) != null) {
                this.serializedObjects.put(representationClass, serializedObject);
            }
            i4++;
        }
    }

    @Override // org.apache.harmony.awt.datatransfer.DataProvider
    public String[] getFileList() {
        return this.fileList;
    }

    @Override // org.apache.harmony.awt.datatransfer.DataProvider
    public String getHTML() {
        return this.html;
    }

    @Override // org.apache.harmony.awt.datatransfer.DataProvider
    public String[] getNativeFormats() {
        return this.nativeFormats;
    }

    @Override // org.apache.harmony.awt.datatransfer.DataProvider
    public RawBitmap getRawBitmap() {
        return this.rawBitmap;
    }

    public short[] getRawBitmapBuffer16() {
        RawBitmap rawBitmap = this.rawBitmap;
        if (rawBitmap != null) {
            Object obj = rawBitmap.buffer;
            if (obj instanceof short[]) {
                return (short[]) obj;
            }
        }
        return null;
    }

    public int[] getRawBitmapBuffer32() {
        RawBitmap rawBitmap = this.rawBitmap;
        if (rawBitmap != null) {
            Object obj = rawBitmap.buffer;
            if (obj instanceof int[]) {
                return (int[]) obj;
            }
        }
        return null;
    }

    public byte[] getRawBitmapBuffer8() {
        RawBitmap rawBitmap = this.rawBitmap;
        if (rawBitmap != null) {
            Object obj = rawBitmap.buffer;
            if (obj instanceof byte[]) {
                return (byte[]) obj;
            }
        }
        return null;
    }

    public int[] getRawBitmapHeader() {
        RawBitmap rawBitmap = this.rawBitmap;
        if (rawBitmap != null) {
            return rawBitmap.getHeader();
        }
        return null;
    }

    @Override // org.apache.harmony.awt.datatransfer.DataProvider
    public byte[] getSerializedObject(Class<?> cls) {
        return this.serializedObjects.get(cls);
    }

    @Override // org.apache.harmony.awt.datatransfer.DataProvider
    public String getText() {
        return this.text;
    }

    @Override // org.apache.harmony.awt.datatransfer.DataProvider
    public String getURL() {
        return this.url;
    }

    @Override // org.apache.harmony.awt.datatransfer.DataProvider
    public boolean isNativeFormatAvailable(String str) {
        if (str == null) {
            return false;
        }
        if (str.equals("text/plain")) {
            return this.text != null;
        } else if (str.equals("application/x-java-file-list")) {
            return this.fileList != null;
        } else if (str.equals("application/x-java-url")) {
            return this.url != null;
        } else if (str.equals("text/html")) {
            return this.html != null;
        } else if (str.equals("image/x-java-image")) {
            return this.rawBitmap != null;
        } else {
            try {
                return this.serializedObjects.containsKey(SystemFlavorMap.decodeDataFlavor(str).getRepresentationClass());
            } catch (Exception unused) {
                return false;
            }
        }
    }

    public byte[] getSerializedObject(String str) {
        try {
            return getSerializedObject(SystemFlavorMap.decodeDataFlavor(str).getRepresentationClass());
        } catch (Exception unused) {
            return null;
        }
    }
}
