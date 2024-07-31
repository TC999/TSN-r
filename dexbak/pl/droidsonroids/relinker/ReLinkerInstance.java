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
import pl.droidsonroids.relinker.ReLinker;
import pl.droidsonroids.relinker.elf.ElfParser;

/* renamed from: pl.droidsonroids.relinker.d */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class ReLinkerInstance {

    /* renamed from: g */
    private static final String f44480g = "lib";

    /* renamed from: a */
    protected final Set<String> f44481a;

    /* renamed from: b */
    protected final ReLinker.InterfaceC15463b f44482b;

    /* renamed from: c */
    protected final ReLinker.InterfaceC15462a f44483c;

    /* renamed from: d */
    protected boolean f44484d;

    /* renamed from: e */
    protected boolean f44485e;

    /* renamed from: f */
    protected ReLinker.InterfaceC15465d f44486f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReLinkerInstance.java */
    /* renamed from: pl.droidsonroids.relinker.d$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class RunnableC15466a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f44487a;

        /* renamed from: b */
        final /* synthetic */ String f44488b;

        /* renamed from: c */
        final /* synthetic */ String f44489c;

        /* renamed from: d */
        final /* synthetic */ ReLinker.InterfaceC15464c f44490d;

        RunnableC15466a(Context context, String str, String str2, ReLinker.InterfaceC15464c interfaceC15464c) {
            this.f44487a = context;
            this.f44488b = str;
            this.f44489c = str2;
            this.f44490d = interfaceC15464c;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ReLinkerInstance.this.m2340j(this.f44487a, this.f44488b, this.f44489c);
                this.f44490d.success();
            } catch (UnsatisfiedLinkError e) {
                this.f44490d.m2350a(e);
            } catch (MissingLibraryException e2) {
                this.f44490d.m2350a(e2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ReLinkerInstance.java */
    /* renamed from: pl.droidsonroids.relinker.d$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15467b implements FilenameFilter {

        /* renamed from: a */
        final /* synthetic */ String f44492a;

        C15467b(String str) {
            this.f44492a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.startsWith(this.f44492a);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ReLinkerInstance() {
        this(new SystemLibraryLoader(), new ApkLibraryInstaller());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m2340j(Context context, String str, String str2) {
        ElfParser elfParser;
        if (this.f44481a.contains(str) && !this.f44484d) {
            m2337m("%s already loaded previously!", str);
            return;
        }
        try {
            this.f44482b.loadLibrary(str);
            this.f44481a.add(str);
            m2337m("%s (%s) was loaded normally!", str, str2);
        } catch (UnsatisfiedLinkError e) {
            m2337m("Loading the library normally failed: %s", Log.getStackTraceString(e));
            m2337m("%s (%s) was not loaded normally, re-linking...", str, str2);
            File m2345e = m2345e(context, str, str2);
            if (!m2345e.exists() || this.f44484d) {
                if (this.f44484d) {
                    m2337m("Forcing a re-link of %s (%s)...", str, str2);
                }
                m2348b(context, str, str2);
                this.f44483c.mo2351a(context, this.f44482b.mo2333c(), this.f44482b.mo2335a(str), m2345e, this);
            }
            try {
                if (this.f44485e) {
                    ElfParser elfParser2 = null;
                    try {
                        elfParser = new ElfParser(m2345e);
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        List<String> m2326c = elfParser.m2326c();
                        elfParser.close();
                        for (String str3 : m2326c) {
                            m2344f(context, this.f44482b.mo2334b(str3));
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        elfParser2 = elfParser;
                        elfParser2.close();
                        throw th;
                    }
                }
            } catch (IOException unused) {
            }
            this.f44482b.mo2332d(m2345e.getAbsolutePath());
            this.f44481a.add(str);
            m2337m("%s (%s) was re-linked!", str, str2);
        }
    }

    /* renamed from: b */
    protected void m2348b(Context context, String str, String str2) {
        File m2346d = m2346d(context);
        File m2345e = m2345e(context, str, str2);
        File[] listFiles = m2346d.listFiles(new C15467b(this.f44482b.mo2335a(str)));
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            if (this.f44484d || !file.getAbsolutePath().equals(m2345e.getAbsolutePath())) {
                file.delete();
            }
        }
    }

    /* renamed from: c */
    public ReLinkerInstance m2347c() {
        this.f44484d = true;
        return this;
    }

    /* renamed from: d */
    protected File m2346d(Context context) {
        return context.getDir(f44480g, 0);
    }

    /* renamed from: e */
    protected File m2345e(Context context, String str, String str2) {
        String mo2335a = this.f44482b.mo2335a(str);
        if (TextUtils.m2319a(str2)) {
            return new File(m2346d(context), mo2335a);
        }
        File m2346d = m2346d(context);
        return new File(m2346d, mo2335a + "." + str2);
    }

    /* renamed from: f */
    public void m2344f(Context context, String str) {
        m2342h(context, str, null, null);
    }

    /* renamed from: g */
    public void m2343g(Context context, String str, String str2) {
        m2342h(context, str, str2, null);
    }

    /* renamed from: h */
    public void m2342h(Context context, String str, String str2, ReLinker.InterfaceC15464c interfaceC15464c) {
        if (context != null) {
            if (!TextUtils.m2319a(str)) {
                m2337m("Beginning load of %s...", str);
                if (interfaceC15464c == null) {
                    m2340j(context, str, str2);
                    return;
                } else {
                    new Thread(new RunnableC15466a(context, str, str2, interfaceC15464c)).start();
                    return;
                }
            }
            throw new IllegalArgumentException("Given library is either null or empty");
        }
        throw new IllegalArgumentException("Given context is null");
    }

    /* renamed from: i */
    public void m2341i(Context context, String str, ReLinker.InterfaceC15464c interfaceC15464c) {
        m2342h(context, str, null, interfaceC15464c);
    }

    /* renamed from: k */
    public ReLinkerInstance m2339k(ReLinker.InterfaceC15465d interfaceC15465d) {
        this.f44486f = interfaceC15465d;
        return this;
    }

    /* renamed from: l */
    public void m2338l(String str) {
        ReLinker.InterfaceC15465d interfaceC15465d = this.f44486f;
        if (interfaceC15465d != null) {
            interfaceC15465d.log(str);
        }
    }

    /* renamed from: m */
    public void m2337m(String str, Object... objArr) {
        m2338l(String.format(Locale.US, str, objArr));
    }

    /* renamed from: n */
    public ReLinkerInstance m2336n() {
        this.f44485e = true;
        return this;
    }

    protected ReLinkerInstance(ReLinker.InterfaceC15463b interfaceC15463b, ReLinker.InterfaceC15462a interfaceC15462a) {
        this.f44481a = new HashSet();
        if (interfaceC15463b == null) {
            throw new IllegalArgumentException("Cannot pass null library loader");
        }
        if (interfaceC15462a != null) {
            this.f44482b = interfaceC15463b;
            this.f44483c = interfaceC15462a;
            return;
        }
        throw new IllegalArgumentException("Cannot pass null library installer");
    }
}
