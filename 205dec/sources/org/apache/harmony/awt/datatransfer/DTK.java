package org.apache.harmony.awt.datatransfer;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.SystemFlavorMap;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DropTargetContext;
import java.awt.dnd.peer.DragSourceContextPeer;
import java.awt.dnd.peer.DropTargetContextPeer;
import java.nio.charset.Charset;
import org.apache.harmony.awt.ContextStorage;
import org.apache.harmony.awt.internal.nls.Messages;
import org.apache.harmony.misc.SystemUtils;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class DTK {
    protected final DataTransferThread dataTransferThread;
    private NativeClipboard nativeClipboard = null;
    private NativeClipboard nativeSelection = null;
    protected SystemFlavorMap systemFlavorMap;

    protected DTK() {
        DataTransferThread dataTransferThread = new DataTransferThread(this);
        this.dataTransferThread = dataTransferThread;
        dataTransferThread.start();
    }

    private static DTK createDTK() {
        String str;
        int os = SystemUtils.getOS();
        if (os == 1) {
            str = "org.apache.harmony.awt.datatransfer.windows.WinDTK";
        } else if (os != 2) {
            throw new RuntimeException(Messages.getString("awt.4E"));
        } else {
            str = "org.apache.harmony.awt.datatransfer.linux.LinuxDTK";
        }
        try {
            return (DTK) Class.forName(str).newInstance();
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
    }

    public static DTK getDTK() {
        synchronized (ContextStorage.getContextLock()) {
            if (ContextStorage.shutdownPending()) {
                return null;
            }
            DTK dtk = ContextStorage.getDTK();
            if (dtk == null) {
                dtk = createDTK();
                ContextStorage.setDTK(dtk);
            }
            return dtk;
        }
    }

    protected void appendSystemFlavorMap(SystemFlavorMap systemFlavorMap, DataFlavor dataFlavor, String str) {
        systemFlavorMap.addFlavorForUnencodedNative(str, dataFlavor);
        systemFlavorMap.addUnencodedNativeForFlavor(dataFlavor, str);
    }

    public abstract DragSourceContextPeer createDragSourceContextPeer(DragGestureEvent dragGestureEvent);

    public abstract DropTargetContextPeer createDropTargetContextPeer(DropTargetContext dropTargetContext);

    protected String[] getCharsets() {
        return new String[]{"UTF-16", "UTF-8", "unicode", "ISO-8859-1", "US-ASCII"};
    }

    public String getDefaultCharset() {
        return "unicode";
    }

    public NativeClipboard getNativeClipboard() {
        if (this.nativeClipboard == null) {
            this.nativeClipboard = newNativeClipboard();
        }
        return this.nativeClipboard;
    }

    public NativeClipboard getNativeSelection() {
        if (this.nativeSelection == null) {
            this.nativeSelection = newNativeSelection();
        }
        return this.nativeSelection;
    }

    public synchronized SystemFlavorMap getSystemFlavorMap() {
        return this.systemFlavorMap;
    }

    public abstract void initDragAndDrop();

    public void initSystemFlavorMap(SystemFlavorMap systemFlavorMap) {
        String[] charsets = getCharsets();
        appendSystemFlavorMap(systemFlavorMap, DataFlavor.stringFlavor, "text/plain");
        appendSystemFlavorMap(systemFlavorMap, charsets, "plain", "text/plain");
        appendSystemFlavorMap(systemFlavorMap, charsets, "html", "text/html");
        appendSystemFlavorMap(systemFlavorMap, DataProvider.urlFlavor, "application/x-java-url");
        appendSystemFlavorMap(systemFlavorMap, charsets, "uri-list", "application/x-java-url");
        appendSystemFlavorMap(systemFlavorMap, DataFlavor.javaFileListFlavor, "application/x-java-file-list");
        appendSystemFlavorMap(systemFlavorMap, DataFlavor.imageFlavor, "image/x-java-image");
    }

    protected abstract NativeClipboard newNativeClipboard();

    protected abstract NativeClipboard newNativeSelection();

    public abstract void runEventLoop();

    public synchronized void setSystemFlavorMap(SystemFlavorMap systemFlavorMap) {
        this.systemFlavorMap = systemFlavorMap;
    }

    protected void appendSystemFlavorMap(SystemFlavorMap systemFlavorMap, String[] strArr, String str, String str2) {
        TextFlavor.addUnicodeClasses(systemFlavorMap, str2, str);
        for (int i4 = 0; i4 < strArr.length; i4++) {
            if (strArr[i4] != null && Charset.isSupported(strArr[i4])) {
                TextFlavor.addCharsetClasses(systemFlavorMap, str2, str, strArr[i4]);
            }
        }
    }
}
