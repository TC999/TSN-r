package org.apache.harmony.awt.datatransfer;

import java.awt.Image;
import java.awt.Point;
import java.awt.color.ColorSpace;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.SystemFlavorMap;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.image.BufferedImage;
import java.awt.image.ComponentColorModel;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBufferInt;
import java.awt.image.DataBufferUShort;
import java.awt.image.DirectColorModel;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.Reader;
import java.io.StringReader;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import org.apache.harmony.awt.internal.nls.Messages;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class DataProxy implements Transferable {
    private final DataProvider data;
    private final SystemFlavorMap flavorMap = SystemFlavorMap.getDefaultFlavorMap();
    public static final Class[] unicodeTextClasses = {String.class, Reader.class, CharBuffer.class, char[].class};
    public static final Class[] charsetTextClasses = {byte[].class, ByteBuffer.class, InputStream.class};

    public DataProxy(DataProvider dataProvider) {
        this.data = dataProvider;
    }

    private BufferedImage createBufferedImage(RawBitmap rawBitmap) {
        Object obj;
        DirectColorModel directColorModel;
        WritableRaster createPackedRaster;
        int[] iArr;
        if (rawBitmap != null && (obj = rawBitmap.buffer) != null && rawBitmap.width > 0 && rawBitmap.height > 0) {
            int i = rawBitmap.bits;
            if (i == 32 && (obj instanceof int[])) {
                if (!isRGB(rawBitmap) && !isBGR(rawBitmap)) {
                    return null;
                }
                int[] iArr2 = {rawBitmap.rMask, rawBitmap.gMask, rawBitmap.bMask};
                int[] iArr3 = (int[]) rawBitmap.buffer;
                directColorModel = new DirectColorModel(24, rawBitmap.rMask, rawBitmap.gMask, rawBitmap.bMask);
                createPackedRaster = Raster.createPackedRaster(new DataBufferInt(iArr3, iArr3.length), rawBitmap.width, rawBitmap.height, rawBitmap.stride, iArr2, (Point) null);
            } else if (i == 24 && (obj instanceof byte[])) {
                int[] iArr4 = {8, 8, 8};
                if (isRGB(rawBitmap)) {
                    iArr = new int[]{0, 1, 2};
                } else if (!isBGR(rawBitmap)) {
                    return null;
                } else {
                    iArr = new int[]{2, 1};
                }
                int[] iArr5 = iArr;
                byte[] bArr = (byte[]) rawBitmap.buffer;
                directColorModel = new ComponentColorModel(ColorSpace.getInstance(1000), iArr4, false, false, 1, 0);
                createPackedRaster = Raster.createInterleavedRaster(new DataBufferByte(bArr, bArr.length), rawBitmap.width, rawBitmap.height, rawBitmap.stride, 3, iArr5, (Point) null);
            } else if ((i == 16 || i == 15) && (obj instanceof short[])) {
                int[] iArr6 = {rawBitmap.rMask, rawBitmap.gMask, rawBitmap.bMask};
                short[] sArr = (short[]) obj;
                directColorModel = new DirectColorModel(rawBitmap.bits, rawBitmap.rMask, rawBitmap.gMask, rawBitmap.bMask);
                createPackedRaster = Raster.createPackedRaster(new DataBufferUShort(sArr, sArr.length), rawBitmap.width, rawBitmap.height, rawBitmap.stride, iArr6, (Point) null);
            } else {
                createPackedRaster = null;
                directColorModel = null;
            }
            if (directColorModel != null && createPackedRaster != null) {
                return new BufferedImage(directColorModel, createPackedRaster, false, (Hashtable) null);
            }
        }
        return null;
    }

    private String getCharset(DataFlavor dataFlavor) {
        return dataFlavor.getParameter("charset");
    }

    private Object getFileList(DataFlavor dataFlavor) throws IOException, UnsupportedFlavorException {
        if (this.data.isNativeFormatAvailable("application/x-java-file-list")) {
            String[] fileList = this.data.getFileList();
            if (fileList != null) {
                return Arrays.asList(fileList);
            }
            throw new IOException(Messages.getString("awt.4F"));
        }
        throw new UnsupportedFlavorException(dataFlavor);
    }

    private Object getHTML(DataFlavor dataFlavor) throws IOException, UnsupportedFlavorException {
        if (this.data.isNativeFormatAvailable("text/html")) {
            String html = this.data.getHTML();
            if (html != null) {
                return getTextRepresentation(html, dataFlavor);
            }
            throw new IOException(Messages.getString("awt.4F"));
        }
        throw new UnsupportedFlavorException(dataFlavor);
    }

    private Image getImage(DataFlavor dataFlavor) throws IOException, UnsupportedFlavorException {
        if (this.data.isNativeFormatAvailable("image/x-java-image")) {
            RawBitmap rawBitmap = this.data.getRawBitmap();
            if (rawBitmap != null) {
                return createBufferedImage(rawBitmap);
            }
            throw new IOException(Messages.getString("awt.4F"));
        }
        throw new UnsupportedFlavorException(dataFlavor);
    }

    private Object getPlainText(DataFlavor dataFlavor) throws IOException, UnsupportedFlavorException {
        if (this.data.isNativeFormatAvailable("text/plain")) {
            String text = this.data.getText();
            if (text != null) {
                return getTextRepresentation(text, dataFlavor);
            }
            throw new IOException(Messages.getString("awt.4F"));
        }
        throw new UnsupportedFlavorException(dataFlavor);
    }

    private Object getSerializedObject(DataFlavor dataFlavor) throws IOException, UnsupportedFlavorException {
        String encodeDataFlavor = SystemFlavorMap.encodeDataFlavor(dataFlavor);
        if (encodeDataFlavor != null && this.data.isNativeFormatAvailable(encodeDataFlavor)) {
            byte[] serializedObject = this.data.getSerializedObject(dataFlavor.getRepresentationClass());
            if (serializedObject != null) {
                try {
                    return new ObjectInputStream(new ByteArrayInputStream(serializedObject)).readObject();
                } catch (ClassNotFoundException e) {
                    throw new IOException(e.getMessage());
                }
            }
            throw new IOException(Messages.getString("awt.4F"));
        }
        throw new UnsupportedFlavorException(dataFlavor);
    }

    private Object getTextRepresentation(String str, DataFlavor dataFlavor) throws UnsupportedFlavorException, IOException {
        if (dataFlavor.getRepresentationClass() == String.class) {
            return str;
        }
        if (dataFlavor.isRepresentationClassReader()) {
            return new StringReader(str);
        }
        if (dataFlavor.isRepresentationClassCharBuffer()) {
            return CharBuffer.wrap(str);
        }
        if (dataFlavor.getRepresentationClass() == char[].class) {
            char[] cArr = new char[str.length()];
            str.getChars(0, str.length(), cArr, 0);
            return cArr;
        }
        String charset = getCharset(dataFlavor);
        if (dataFlavor.getRepresentationClass() == byte[].class) {
            return str.getBytes(charset);
        }
        if (dataFlavor.isRepresentationClassByteBuffer()) {
            return ByteBuffer.wrap(str.getBytes(charset));
        }
        if (dataFlavor.isRepresentationClassInputStream()) {
            return new ByteArrayInputStream(str.getBytes(charset));
        }
        throw new UnsupportedFlavorException(dataFlavor);
    }

    private Object getURL(DataFlavor dataFlavor) throws IOException, UnsupportedFlavorException {
        if (this.data.isNativeFormatAvailable("application/x-java-url")) {
            String url = this.data.getURL();
            if (url != null) {
                URL url2 = new URL(url);
                if (dataFlavor.getRepresentationClass().isAssignableFrom(URL.class)) {
                    return url2;
                }
                if (dataFlavor.isFlavorTextType()) {
                    return getTextRepresentation(url2.toString(), dataFlavor);
                }
                throw new UnsupportedFlavorException(dataFlavor);
            }
            throw new IOException(Messages.getString("awt.4F"));
        }
        throw new UnsupportedFlavorException(dataFlavor);
    }

    private boolean isBGR(RawBitmap rawBitmap) {
        return rawBitmap.rMask == 255 && rawBitmap.gMask == 65280 && rawBitmap.bMask == 16711680;
    }

    private boolean isRGB(RawBitmap rawBitmap) {
        return rawBitmap.rMask == 16711680 && rawBitmap.gMask == 65280 && rawBitmap.bMask == 255;
    }

    public DataProvider getDataProvider() {
        return this.data;
    }

    public Object getTransferData(DataFlavor dataFlavor) throws UnsupportedFlavorException, IOException {
        String str = String.valueOf(dataFlavor.getPrimaryType()) + "/" + dataFlavor.getSubType();
        if (dataFlavor.isFlavorTextType()) {
            if (str.equalsIgnoreCase("text/html")) {
                return getHTML(dataFlavor);
            }
            if (str.equalsIgnoreCase(DataProvider.TYPE_URILIST)) {
                return getURL(dataFlavor);
            }
            return getPlainText(dataFlavor);
        } else if (dataFlavor.isFlavorJavaFileListType()) {
            return getFileList(dataFlavor);
        } else {
            if (dataFlavor.isFlavorSerializedObjectType()) {
                return getSerializedObject(dataFlavor);
            }
            if (dataFlavor.equals(DataProvider.urlFlavor)) {
                return getURL(dataFlavor);
            }
            if (str.equalsIgnoreCase("image/x-java-image") && Image.class.isAssignableFrom(dataFlavor.getRepresentationClass())) {
                return getImage(dataFlavor);
            }
            throw new UnsupportedFlavorException(dataFlavor);
        }
    }

    public DataFlavor[] getTransferDataFlavors() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.data.getNativeFormats()) {
            for (DataFlavor dataFlavor : this.flavorMap.getFlavorsForNative(str)) {
                if (!arrayList.contains(dataFlavor)) {
                    arrayList.add(dataFlavor);
                }
            }
        }
        return (DataFlavor[]) arrayList.toArray(new DataFlavor[arrayList.size()]);
    }

    public boolean isDataFlavorSupported(DataFlavor dataFlavor) {
        for (DataFlavor dataFlavor2 : getTransferDataFlavors()) {
            if (dataFlavor2.equals(dataFlavor)) {
                return true;
            }
        }
        return false;
    }
}
