package javax.activation;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.net.URL;
import myjava.awt.datatransfer.DataFlavor;
import myjava.awt.datatransfer.Transferable;
import myjava.awt.datatransfer.UnsupportedFlavorException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class DataHandler implements Transferable {
    private static final DataFlavor[] emptyFlavors = new DataFlavor[0];
    private static DataContentHandlerFactory factory;
    private CommandMap currentCommandMap;
    private DataContentHandler dataContentHandler;
    private DataSource dataSource;
    private DataContentHandler factoryDCH;
    private DataSource objDataSource;
    private Object object;
    private String objectMimeType;
    private DataContentHandlerFactory oldFactory;
    private String shortType;
    private DataFlavor[] transferFlavors;

    public DataHandler(DataSource dataSource) {
        this.objDataSource = null;
        this.object = null;
        this.objectMimeType = null;
        this.currentCommandMap = null;
        this.transferFlavors = emptyFlavors;
        this.dataContentHandler = null;
        this.factoryDCH = null;
        this.shortType = null;
        this.dataSource = dataSource;
        this.oldFactory = factory;
    }

    private synchronized String getBaseType() {
        if (this.shortType == null) {
            String contentType = getContentType();
            try {
                this.shortType = new MimeType(contentType).getBaseType();
            } catch (MimeTypeParseException unused) {
                this.shortType = contentType;
            }
        }
        return this.shortType;
    }

    private synchronized CommandMap getCommandMap() {
        CommandMap commandMap = this.currentCommandMap;
        if (commandMap != null) {
            return commandMap;
        }
        return CommandMap.getDefaultCommandMap();
    }

    private synchronized DataContentHandler getDataContentHandler() {
        DataContentHandlerFactory dataContentHandlerFactory;
        DataContentHandlerFactory dataContentHandlerFactory2 = factory;
        if (dataContentHandlerFactory2 != this.oldFactory) {
            this.oldFactory = dataContentHandlerFactory2;
            this.factoryDCH = null;
            this.dataContentHandler = null;
            this.transferFlavors = emptyFlavors;
        }
        DataContentHandler dataContentHandler = this.dataContentHandler;
        if (dataContentHandler != null) {
            return dataContentHandler;
        }
        String baseType = getBaseType();
        if (this.factoryDCH == null && (dataContentHandlerFactory = factory) != null) {
            this.factoryDCH = dataContentHandlerFactory.createDataContentHandler(baseType);
        }
        DataContentHandler dataContentHandler2 = this.factoryDCH;
        if (dataContentHandler2 != null) {
            this.dataContentHandler = dataContentHandler2;
        }
        if (this.dataContentHandler == null) {
            if (this.dataSource != null) {
                this.dataContentHandler = getCommandMap().createDataContentHandler(baseType, this.dataSource);
            } else {
                this.dataContentHandler = getCommandMap().createDataContentHandler(baseType);
            }
        }
        DataSource dataSource = this.dataSource;
        if (dataSource != null) {
            this.dataContentHandler = new DataSourceDataContentHandler(this.dataContentHandler, dataSource);
        } else {
            this.dataContentHandler = new ObjectDataContentHandler(this.dataContentHandler, this.object, this.objectMimeType);
        }
        return this.dataContentHandler;
    }

    public static synchronized void setDataContentHandlerFactory(DataContentHandlerFactory dataContentHandlerFactory) {
        synchronized (DataHandler.class) {
            if (factory == null) {
                SecurityManager securityManager = System.getSecurityManager();
                if (securityManager != null) {
                    try {
                        securityManager.checkSetFactory();
                    } catch (SecurityException e4) {
                        if (DataHandler.class.getClassLoader() != dataContentHandlerFactory.getClass().getClassLoader()) {
                            throw e4;
                        }
                    }
                }
                factory = dataContentHandlerFactory;
            } else {
                throw new Error("DataContentHandlerFactory already defined");
            }
        }
    }

    public CommandInfo[] getAllCommands() {
        if (this.dataSource != null) {
            return getCommandMap().getAllCommands(getBaseType(), this.dataSource);
        }
        return getCommandMap().getAllCommands(getBaseType());
    }

    public Object getBean(CommandInfo commandInfo) {
        try {
            ClassLoader contextClassLoader = SecuritySupport.getContextClassLoader();
            if (contextClassLoader == null) {
                contextClassLoader = getClass().getClassLoader();
            }
            return commandInfo.getCommandObject(this, contextClassLoader);
        } catch (IOException | ClassNotFoundException unused) {
            return null;
        }
    }

    public CommandInfo getCommand(String str) {
        if (this.dataSource != null) {
            return getCommandMap().getCommand(getBaseType(), str, this.dataSource);
        }
        return getCommandMap().getCommand(getBaseType(), str);
    }

    public Object getContent() throws IOException {
        Object obj = this.object;
        return obj != null ? obj : getDataContentHandler().getContent(getDataSource());
    }

    public String getContentType() {
        DataSource dataSource = this.dataSource;
        if (dataSource != null) {
            return dataSource.getContentType();
        }
        return this.objectMimeType;
    }

    public DataSource getDataSource() {
        DataSource dataSource = this.dataSource;
        if (dataSource == null) {
            if (this.objDataSource == null) {
                this.objDataSource = new DataHandlerDataSource(this);
            }
            return this.objDataSource;
        }
        return dataSource;
    }

    public InputStream getInputStream() throws IOException {
        DataSource dataSource = this.dataSource;
        if (dataSource != null) {
            return dataSource.getInputStream();
        }
        final DataContentHandler dataContentHandler = getDataContentHandler();
        if (dataContentHandler != null) {
            if ((dataContentHandler instanceof ObjectDataContentHandler) && ((ObjectDataContentHandler) dataContentHandler).getDCH() == null) {
                throw new UnsupportedDataTypeException("no object DCH for MIME type " + getBaseType());
            }
            final PipedOutputStream pipedOutputStream = new PipedOutputStream();
            PipedInputStream pipedInputStream = new PipedInputStream(pipedOutputStream);
            new Thread(new Runnable() { // from class: javax.activation.DataHandler.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        dataContentHandler.writeTo(DataHandler.this.object, DataHandler.this.objectMimeType, pipedOutputStream);
                    } catch (IOException unused) {
                    } catch (Throwable th) {
                        try {
                            pipedOutputStream.close();
                        } catch (IOException unused2) {
                        }
                        throw th;
                    }
                    try {
                        pipedOutputStream.close();
                    } catch (IOException unused3) {
                    }
                }
            }, "DataHandler.getInputStream").start();
            return pipedInputStream;
        }
        throw new UnsupportedDataTypeException("no DCH for MIME type " + getBaseType());
    }

    public String getName() {
        DataSource dataSource = this.dataSource;
        if (dataSource != null) {
            return dataSource.getName();
        }
        return null;
    }

    public OutputStream getOutputStream() throws IOException {
        DataSource dataSource = this.dataSource;
        if (dataSource != null) {
            return dataSource.getOutputStream();
        }
        return null;
    }

    public CommandInfo[] getPreferredCommands() {
        if (this.dataSource != null) {
            return getCommandMap().getPreferredCommands(getBaseType(), this.dataSource);
        }
        return getCommandMap().getPreferredCommands(getBaseType());
    }

    @Override // myjava.awt.datatransfer.Transferable
    public Object getTransferData(DataFlavor dataFlavor) throws UnsupportedFlavorException, IOException {
        return getDataContentHandler().getTransferData(dataFlavor, this.dataSource);
    }

    @Override // myjava.awt.datatransfer.Transferable
    public synchronized DataFlavor[] getTransferDataFlavors() {
        if (factory != this.oldFactory) {
            this.transferFlavors = emptyFlavors;
        }
        if (this.transferFlavors == emptyFlavors) {
            this.transferFlavors = getDataContentHandler().getTransferDataFlavors();
        }
        return this.transferFlavors;
    }

    @Override // myjava.awt.datatransfer.Transferable
    public boolean isDataFlavorSupported(DataFlavor dataFlavor) {
        for (DataFlavor dataFlavor2 : getTransferDataFlavors()) {
            if (dataFlavor2.equals(dataFlavor)) {
                return true;
            }
        }
        return false;
    }

    public synchronized void setCommandMap(CommandMap commandMap) {
        if (commandMap != this.currentCommandMap || commandMap == null) {
            this.transferFlavors = emptyFlavors;
            this.dataContentHandler = null;
            this.currentCommandMap = commandMap;
        }
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        DataSource dataSource = this.dataSource;
        if (dataSource != null) {
            byte[] bArr = new byte[8192];
            InputStream inputStream = dataSource.getInputStream();
            while (true) {
                try {
                    int read = inputStream.read(bArr);
                    if (read <= 0) {
                        return;
                    }
                    outputStream.write(bArr, 0, read);
                } finally {
                    inputStream.close();
                }
            }
        } else {
            getDataContentHandler().writeTo(this.object, this.objectMimeType, outputStream);
        }
    }

    public DataHandler(Object obj, String str) {
        this.dataSource = null;
        this.objDataSource = null;
        this.currentCommandMap = null;
        this.transferFlavors = emptyFlavors;
        this.dataContentHandler = null;
        this.factoryDCH = null;
        this.shortType = null;
        this.object = obj;
        this.objectMimeType = str;
        this.oldFactory = factory;
    }

    public DataHandler(URL url) {
        this.dataSource = null;
        this.objDataSource = null;
        this.object = null;
        this.objectMimeType = null;
        this.currentCommandMap = null;
        this.transferFlavors = emptyFlavors;
        this.dataContentHandler = null;
        this.factoryDCH = null;
        this.oldFactory = null;
        this.shortType = null;
        this.dataSource = new URLDataSource(url);
        this.oldFactory = factory;
    }
}
