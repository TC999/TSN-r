package ms.bz.bd.c.Pgl;

import java.util.Arrays;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class pbls extends RuntimeException {
    public pbls(String str, String[] strArr, String[] strArr2) {
        super("Could not find '" + str + "'. Looked for: " + Arrays.toString(strArr) + ", but only found: " + Arrays.toString(strArr2) + ".");
    }
}
