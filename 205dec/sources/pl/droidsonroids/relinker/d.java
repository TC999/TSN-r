package pl.droidsonroids.relinker;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import pl.droidsonroids.relinker.c;

/* compiled from: ReLinkerInstance.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public class d {

    /* renamed from: g  reason: collision with root package name */
    private static final String f61893g = "lib";

    /* renamed from: a  reason: collision with root package name */
    protected final Set<String> f61894a;

    /* renamed from: b  reason: collision with root package name */
    protected final c.b f61895b;

    /* renamed from: c  reason: collision with root package name */
    protected final c.a f61896c;

    /* renamed from: d  reason: collision with root package name */
    protected boolean f61897d;

    /* renamed from: e  reason: collision with root package name */
    protected boolean f61898e;

    /* renamed from: f  reason: collision with root package name */
    protected c.d f61899f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReLinkerInstance.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f61900a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f61901b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f61902c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ c.InterfaceC1254c f61903d;

        a(Context context, String str, String str2, c.InterfaceC1254c interfaceC1254c) {
            this.f61900a = context;
            this.f61901b = str;
            this.f61902c = str2;
            this.f61903d = interfaceC1254c;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.this.j(this.f61900a, this.f61901b, this.f61902c);
                this.f61903d.success();
            } catch (UnsatisfiedLinkError e4) {
                this.f61903d.a(e4);
            } catch (MissingLibraryException e5) {
                this.f61903d.a(e5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReLinkerInstance.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public class b implements FilenameFilter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f61905a;

        b(String str) {
            this.f61905a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.startsWith(this.f61905a);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public d() {
        this(new e(), new pl.droidsonroids.relinker.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Context context, String str, String str2) {
        pl.droidsonroids.relinker.elf.f fVar;
        if (this.f61894a.contains(str) && !this.f61897d) {
            m("%s already loaded previously!", str);
            return;
        }
        try {
            this.f61895b.loadLibrary(str);
            this.f61894a.add(str);
            m("%s (%s) was loaded normally!", str, str2);
        } catch (UnsatisfiedLinkError e4) {
            m("Loading the library normally failed: %s", Log.getStackTraceString(e4));
            m("%s (%s) was not loaded normally, re-linking...", str, str2);
            File e5 = e(context, str, str2);
            if (!e5.exists() || this.f61897d) {
                if (this.f61897d) {
                    m("Forcing a re-link of %s (%s)...", str, str2);
                }
                b(context, str, str2);
                this.f61896c.a(context, this.f61895b.c(), this.f61895b.a(str), e5, this);
            }
            try {
                if (this.f61898e) {
                    pl.droidsonroids.relinker.elf.f fVar2 = null;
                    try {
                        fVar = new pl.droidsonroids.relinker.elf.f(e5);
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        List<String> c4 = fVar.c();
                        fVar.close();
                        for (String str3 : c4) {
                            f(context, this.f61895b.b(str3));
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fVar2 = fVar;
                        fVar2.close();
                        throw th;
                    }
                }
            } catch (IOException unused) {
            }
            this.f61895b.d(e5.getAbsolutePath());
            this.f61894a.add(str);
            m("%s (%s) was re-linked!", str, str2);
        }
    }

    protected void b(Context context, String str, String str2) {
        File d4 = d(context);
        File e4 = e(context, str, str2);
        File[] listFiles = d4.listFiles(new b(this.f61895b.a(str)));
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            if (this.f61897d || !file.getAbsolutePath().equals(e4.getAbsolutePath())) {
                file.delete();
            }
        }
    }

    public d c() {
        this.f61897d = true;
        return this;
    }

    protected File d(Context context) {
        return context.getDir(f61893g, 0);
    }

    protected File e(Context context, String str, String str2) {
        String a4 = this.f61895b.a(str);
        if (f.a(str2)) {
            return new File(d(context), a4);
        }
        File d4 = d(context);
        return new File(d4, a4 + "." + str2);
    }

    public void f(Context context, String str) {
        h(context, str, null, null);
    }

    public void g(Context context, String str, String str2) {
        h(context, str, str2, null);
    }

    public void h(Context context, String str, String str2, c.InterfaceC1254c interfaceC1254c) {
        if (context != null) {
            if (!f.a(str)) {
                m("Beginning load of %s...", str);
                if (interfaceC1254c == null) {
                    j(context, str, str2);
                    return;
                } else {
                    new Thread(new a(context, str, str2, interfaceC1254c)).start();
                    return;
                }
            }
            throw new IllegalArgumentException("Given library is either null or empty");
        }
        throw new IllegalArgumentException("Given context is null");
    }

    public void i(Context context, String str, c.InterfaceC1254c interfaceC1254c) {
        h(context, str, null, interfaceC1254c);
    }

    public d k(c.d dVar) {
        this.f61899f = dVar;
        return this;
    }

    public void l(String str) {
        c.d dVar = this.f61899f;
        if (dVar != null) {
            dVar.log(str);
        }
    }

    public void m(String str, Object... objArr) {
        l(String.format(Locale.US, str, objArr));
    }

    public d n() {
        this.f61898e = true;
        return this;
    }

    protected d(c.b bVar, c.a aVar) {
        this.f61894a = new HashSet();
        if (bVar == null) {
            throw new IllegalArgumentException("Cannot pass null library loader");
        }
        if (aVar != null) {
            this.f61895b = bVar;
            this.f61896c = aVar;
            return;
        }
        throw new IllegalArgumentException("Cannot pass null library installer");
    }
}
