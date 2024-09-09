package ms.bz.bd.c.Pgl;

import android.content.Context;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class pblt {

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface pblb {
    }

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface pblc {
        void c();

        void c(Throwable th);
    }

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface pgla {
    }

    public static void a(Context context, String str) {
        new pblu(new pblw(), new pblr()).c(context, str, null, null);
    }

    public static boolean b(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }
}
