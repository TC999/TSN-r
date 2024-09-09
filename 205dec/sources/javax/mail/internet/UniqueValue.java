package javax.mail.internet;

import javax.mail.Session;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
class UniqueValue {
    private static int id;

    UniqueValue() {
    }

    public static String getUniqueBoundaryValue() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("----=_Part_");
        stringBuffer.append(getUniqueId());
        stringBuffer.append("_");
        stringBuffer.append(stringBuffer.hashCode());
        stringBuffer.append('.');
        stringBuffer.append(System.currentTimeMillis());
        return stringBuffer.toString();
    }

    private static synchronized int getUniqueId() {
        int i4;
        synchronized (UniqueValue.class) {
            i4 = id;
            id = i4 + 1;
        }
        return i4;
    }

    public static String getUniqueMessageIDValue(Session session) {
        InternetAddress localAddress = InternetAddress.getLocalAddress(session);
        String address = localAddress != null ? localAddress.getAddress() : "javamailuser@localhost";
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(stringBuffer.hashCode());
        stringBuffer.append('.');
        stringBuffer.append(getUniqueId());
        stringBuffer.append('.');
        stringBuffer.append(System.currentTimeMillis());
        stringBuffer.append('.');
        stringBuffer.append("JavaMail.");
        stringBuffer.append(address);
        return stringBuffer.toString();
    }
}
