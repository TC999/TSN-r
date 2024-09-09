package com.sun.mail.util;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Properties;
import java.util.StringTokenizer;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class SocketFetcher {
    private SocketFetcher() {
    }

    private static void configureSSLSocket(Socket socket, Properties properties, String str) {
        if (socket instanceof SSLSocket) {
            SSLSocket sSLSocket = (SSLSocket) socket;
            String property = properties.getProperty(String.valueOf(str) + ".ssl.protocols", null);
            if (property != null) {
                sSLSocket.setEnabledProtocols(stringArray(property));
            } else {
                sSLSocket.setEnabledProtocols(new String[]{"TLSv1"});
            }
            String property2 = properties.getProperty(String.valueOf(str) + ".ssl.ciphersuites", null);
            if (property2 != null) {
                sSLSocket.setEnabledCipherSuites(stringArray(property2));
            }
        }
    }

    private static Socket createSocket(InetAddress inetAddress, int i4, String str, int i5, int i6, SocketFactory socketFactory, boolean z3) throws IOException {
        Socket socket;
        if (socketFactory != null) {
            socket = socketFactory.createSocket();
        } else if (z3) {
            socket = SSLSocketFactory.getDefault().createSocket();
        } else {
            socket = new Socket();
        }
        if (inetAddress != null) {
            socket.bind(new InetSocketAddress(inetAddress, i4));
        }
        if (i6 >= 0) {
            socket.connect(new InetSocketAddress(str, i5), i6);
        } else {
            socket.connect(new InetSocketAddress(str, i5));
        }
        return socket;
    }

    private static ClassLoader getContextClassLoader() {
        return (ClassLoader) AccessController.doPrivileged(new PrivilegedAction() { // from class: com.sun.mail.util.SocketFetcher.1
            @Override // java.security.PrivilegedAction
            public Object run() {
                try {
                    return Thread.currentThread().getContextClassLoader();
                } catch (SecurityException unused) {
                    return null;
                }
            }
        });
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:(22:81|82|83|8|(1:10)(1:80)|11|(16:75|76|77|14|(1:74)(1:18)|19|20|21|(13:23|(12:60|61|(1:27)(1:59)|28|29|30|31|(1:33)|(2:40|41)|(1:36)|37|38)|25|(0)(0)|28|29|30|31|(0)|(0)|(0)|37|38)|68|69|(0)|(0)|(0)|37|38)|13|14|(1:16)|74|19|20|21|(0)|68|69|(0)|(0)|(0)|37|38)|20|21|(0)|68|69|(0)|(0)|(0)|37|38) */
    /* JADX WARN: Can't wrap try/catch for region: R(13:23|(12:60|61|(1:27)(1:59)|28|29|30|31|(1:33)|(2:40|41)|(1:36)|37|38)|25|(0)(0)|28|29|30|31|(0)|(0)|(0)|37|38) */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ea, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00eb, code lost:
        r5 = r0;
        r0 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00f2, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00f3, code lost:
        r3 = r11;
        r5 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00fa, code lost:
        if ((r5 instanceof java.lang.reflect.InvocationTargetException) != false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00fc, code lost:
        r1 = ((java.lang.reflect.InvocationTargetException) r5).getTargetException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0105, code lost:
        if ((r1 instanceof java.lang.Exception) != false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0107, code lost:
        r5 = (java.lang.Exception) r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x010c, code lost:
        if ((r5 instanceof java.io.IOException) != false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0110, code lost:
        throw ((java.io.IOException) r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0111, code lost:
        r1 = new java.io.IOException("Couldn't connect using \"" + r3 + "\" socket factory to host, port: " + r18 + ", " + r0 + "; Exception: " + r5);
        r1.initCause(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0141, code lost:
        throw r1;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b3 A[Catch: Exception -> 0x00f2, SocketTimeoutException -> 0x0164, TRY_LEAVE, TryCatch #3 {SocketTimeoutException -> 0x0164, blocks: (B:29:0x00ad, B:31:0x00b3, B:33:0x00c7, B:42:0x00e2), top: B:84:0x00ad }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0155 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.net.Socket getSocket(java.lang.String r18, int r19, java.util.Properties r20, java.lang.String r21, boolean r22) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 360
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.mail.util.SocketFetcher.getSocket(java.lang.String, int, java.util.Properties, java.lang.String, boolean):java.net.Socket");
    }

    private static SocketFactory getSocketFactory(String str) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Class<?> cls = null;
        if (str == null || str.length() == 0) {
            return null;
        }
        ClassLoader contextClassLoader = getContextClassLoader();
        if (contextClassLoader != null) {
            try {
                cls = contextClassLoader.loadClass(str);
            } catch (ClassNotFoundException unused) {
            }
        }
        if (cls == null) {
            cls = Class.forName(str);
        }
        return (SocketFactory) cls.getMethod("getDefault", new Class[0]).invoke(new Object(), new Object[0]);
    }

    public static Socket startTLS(Socket socket) throws IOException {
        return startTLS(socket, new Properties(), "socket");
    }

    private static String[] stringArray(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str);
        ArrayList arrayList = new ArrayList();
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static Socket startTLS(Socket socket, Properties properties, String str) throws IOException {
        SSLSocketFactory sSLSocketFactory;
        String hostName = socket.getInetAddress().getHostName();
        int port = socket.getPort();
        try {
            SocketFactory socketFactory = getSocketFactory(properties.getProperty(String.valueOf(str) + ".socketFactory.class", null));
            if (socketFactory != null && (socketFactory instanceof SSLSocketFactory)) {
                sSLSocketFactory = (SSLSocketFactory) socketFactory;
            } else {
                sSLSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            }
            Socket createSocket = sSLSocketFactory.createSocket(socket, hostName, port, true);
            configureSSLSocket(createSocket, properties, str);
            return createSocket;
        } catch (Exception e4) {
            e = e4;
            if (e instanceof InvocationTargetException) {
                Throwable targetException = ((InvocationTargetException) e).getTargetException();
                if (targetException instanceof Exception) {
                    e = (Exception) targetException;
                }
            }
            if (e instanceof IOException) {
                throw ((IOException) e);
            }
            IOException iOException = new IOException("Exception in startTLS: host " + hostName + ", port " + port + "; Exception: " + e);
            iOException.initCause(e);
            throw iOException;
        }
    }

    public static Socket getSocket(String str, int i4, Properties properties, String str2) throws IOException {
        return getSocket(str, i4, properties, str2, false);
    }
}
