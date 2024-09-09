package io.netty.handler.ssl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SNIHostName;
import javax.net.ssl.SNIMatcher;
import javax.net.ssl.SNIServerName;
import javax.net.ssl.SSLParameters;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
final class Java8SslUtils {
    private Java8SslUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean checkSniHostnameMatch(Collection<?> collection, byte[] bArr) {
        if (collection == null || collection.isEmpty()) {
            return true;
        }
        SNIHostName sNIHostName = new SNIHostName(bArr);
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            SNIMatcher sNIMatcher = (SNIMatcher) it.next();
            if (sNIMatcher.getType() == 0 && sNIMatcher.matches(sNIHostName)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List getSniHostName(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            return Collections.singletonList(new SNIHostName(bArr));
        }
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<String> getSniHostNames(SSLParameters sSLParameters) {
        List<SNIServerName> serverNames = sSLParameters.getServerNames();
        if (serverNames != null && !serverNames.isEmpty()) {
            ArrayList arrayList = new ArrayList(serverNames.size());
            for (SNIServerName sNIServerName : serverNames) {
                if (sNIServerName instanceof SNIHostName) {
                    arrayList.add(((SNIHostName) sNIServerName).getAsciiName());
                } else {
                    throw new IllegalArgumentException("Only " + SNIHostName.class.getName() + " instances are supported, but found: " + sNIServerName);
                }
            }
            return arrayList;
        }
        return Collections.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean getUseCipherSuitesOrder(SSLParameters sSLParameters) {
        return sSLParameters.getUseCipherSuitesOrder();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setSNIMatchers(SSLParameters sSLParameters, Collection<?> collection) {
        sSLParameters.setSNIMatchers(collection);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setSniHostNames(SSLParameters sSLParameters, List<String> list) {
        sSLParameters.setServerNames(getSniHostNames(list));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setUseCipherSuitesOrder(SSLParameters sSLParameters, boolean z3) {
        sSLParameters.setUseCipherSuitesOrder(z3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List getSniHostNames(List<String> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList(list.size());
            for (String str : list) {
                arrayList.add(new SNIHostName(str));
            }
            return arrayList;
        }
        return Collections.emptyList();
    }
}
