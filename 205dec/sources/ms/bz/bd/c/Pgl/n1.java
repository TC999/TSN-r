package ms.bz.bd.c.Pgl;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class n1 {
    static {
        String str = (String) pblk.a(16777217, 0, 0L, "614eff", new byte[]{28, 111, 6, 79, 100});
    }

    public static String a(String str) {
        return (str == null || str.length() <= 0) ? "" : str.trim().replace('\'', ' ').replace('\"', ' ').replace('\r', ' ').replace('\n', ' ');
    }
}
