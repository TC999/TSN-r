package ms.bz.bd.c.Pgl;

import android.content.Context;
import com.bytedance.sdk.component.gd.sr.xv;
import java.io.File;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import ms.bz.bd.c.Pgl.pblt;

/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class pblu {

    /* renamed from: a  reason: collision with root package name */
    protected final Set<String> f61443a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    protected final pblt.pblb f61444b;

    /* renamed from: c  reason: collision with root package name */
    protected final pblt.pgla f61445c;

    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class pgla implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f61446a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f61447b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f61448c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ pblt.pblc f61449d;

        pgla(Context context, String str, String str2, pblt.pblc pblcVar) {
            this.f61446a = context;
            this.f61447b = str;
            this.f61448c = str2;
            this.f61449d = pblcVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                pblu.this.e(this.f61446a, this.f61447b, this.f61448c);
                this.f61449d.c();
            } catch (UnsatisfiedLinkError | pbls e4) {
                this.f61449d.c(e4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public pblu(pblt.pblb pblbVar, pblt.pgla pglaVar) {
        this.f61444b = pblbVar;
        this.f61445c = pglaVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a3, code lost:
        if (r5.length > 0) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void e(android.content.Context r13, java.lang.String r14, java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 241
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ms.bz.bd.c.Pgl.pblu.e(android.content.Context, java.lang.String, java.lang.String):void");
    }

    protected File a(Context context) {
        return com.bytedance.sdk.openadsdk.api.plugin.w.c(context, "lib", 0);
    }

    protected File b(Context context, String str, String str2) {
        String a4 = ((pblw) this.f61444b).a(str);
        if (pblt.b(str2)) {
            return new File(a(context), a4);
        }
        File a5 = a(context);
        return new File(a5, a4 + "." + str2);
    }

    public void c(Context context, String str, String str2, pblt.pblc pblcVar) {
        if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        }
        if (pblt.b(str)) {
            throw new IllegalArgumentException("Given library is either null or empty");
        }
        String.format(Locale.US, "Beginning load of %s...", str);
        if (pblcVar == null) {
            e(context, str, str2);
        } else {
            new xv(new pgla(context, str, str2, pblcVar), "bd/c/Pgl/pblu").start();
        }
    }
}
