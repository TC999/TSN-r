package javax.mail.internet;

import javax.mail.Session;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
class UniqueValue {

    /* renamed from: id */
    private static int f40797id;

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
        int i;
        synchronized (UniqueValue.class) {
            i = f40797id;
            f40797id = i + 1;
        }
        return i;
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
