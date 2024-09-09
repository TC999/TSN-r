package ms.bz.bd.c.Pgl;

import android.content.Context;
import com.stub.StubApp;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class pgla {

    /* renamed from: b  reason: collision with root package name */
    private static final pgla f61454b = new pgla();

    /* renamed from: a  reason: collision with root package name */
    private Context f61455a;

    public static pgla a() {
        return f61454b;
    }

    public void b(Context context) {
        this.f61455a = context != null ? StubApp.getOrigApplicationContext(context.getApplicationContext()) : null;
    }

    public Context c() {
        return this.f61455a;
    }
}
