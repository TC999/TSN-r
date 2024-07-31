package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.stub.StubApp;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

/* renamed from: com.kuaishou.weapon.p0.q */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7299q {

    /* renamed from: a */
    public static final int f24999a = 3;

    /* renamed from: b */
    private static C7299q f25000b = null;

    /* renamed from: g */
    private static final String f25001g = "1";

    /* renamed from: c */
    private volatile boolean f25002c = false;

    /* renamed from: d */
    private C7278dp f25003d;

    /* renamed from: e */
    private Context f25004e;

    /* renamed from: f */
    private C7304t f25005f;

    private C7299q(Context context) {
        this.f25004e = context;
        this.f25003d = C7278dp.m33920a(context);
        this.f25005f = C7304t.m33760a(context);
    }

    /* renamed from: d */
    private static void m33777d() {
        try {
            C7278dp m33921a = C7278dp.m33921a();
            if (m33921a != null) {
                m33921a.m33912b("W_S_V", "1");
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: c */
    public void m33778c() {
        for (C7303s c7303s : this.f25005f.m33763a()) {
            C7302r m33776a = C7302r.m33776a();
            if ((m33776a != null ? m33776a.m33765d(c7303s.f25021c) : null) == null) {
                m33788a(c7303s.f25019a, c7303s.f25022d, (PackageInfo) null);
            }
        }
    }

    /* renamed from: a */
    public static synchronized C7299q m33786a(Context context) {
        C7299q c7299q;
        synchronized (C7299q.class) {
            try {
                if (f25000b == null) {
                    f25000b = new C7299q(context);
                }
                c7299q = f25000b;
            } catch (Exception unused) {
                return null;
            }
        }
        return c7299q;
    }

    /* renamed from: b */
    public synchronized void m33781b() {
        try {
            if (this.f25002c) {
                return;
            }
            this.f25002c = true;
            for (C7303s c7303s : this.f25005f.m33763a()) {
                String str = null;
                try {
                    str = this.f25004e.getFilesDir().getCanonicalPath();
                } catch (Throwable unused) {
                }
                if (str != null) {
                    c7303s.f25031m = str + C7193bi.f24575j + c7303s.f25019a;
                    StringBuilder sb = new StringBuilder();
                    sb.append(c7303s.f25031m);
                    sb.append("/lib");
                    C7271dn.m33933c(sb.toString());
                    C7271dn.m33933c(c7303s.f25031m);
                }
            }
            this.f25005f.m33756b();
            if (!this.f25003d.m33913b(C7278dp.f24927d)) {
                this.f25003d.m33915a(C7278dp.f24927d, Boolean.TRUE, true);
            } else {
                this.f25005f.m33751c();
            }
            C7292n.m33830a().m33828a(new RunnableC7306u(this.f25004e, 1, false));
        } catch (Throwable unused2) {
        }
    }

    /* renamed from: a */
    public void m33789a() {
        m33777d();
        if (WeaponHI.isLoad) {
            m33781b();
        } else {
            WeaponHI.m34448iD();
        }
    }

    /* renamed from: a */
    public synchronized boolean m33788a(int i, String str, PackageInfo packageInfo) {
        return m33787a(i, str, null, false, packageInfo);
    }

    /* renamed from: a */
    private synchronized boolean m33787a(int i, String str, String str2, boolean z, PackageInfo packageInfo) {
        if (z) {
            if (this.f25005f.m33750c(i) != 1) {
                return false;
            }
        }
        C7303s m33762a = this.f25005f.m33762a(i);
        if (m33762a == null) {
            this.f25005f.m33754b(i, -1);
            return false;
        } else if (!C7271dn.m33939a(new File(m33762a.f25023e))) {
            this.f25005f.m33754b(i, -1);
            return false;
        } else {
            if (packageInfo != null) {
                m33762a.f25036r = packageInfo;
            }
            C7302r m33775a = C7302r.m33775a(StubApp.getOrigApplicationContext(this.f25004e.getApplicationContext()), true);
            if (!m33775a.m33771a(m33762a, false)) {
                this.f25005f.m33754b(i, -1);
                m33775a.m33770a(m33762a.f25023e);
                return false;
            }
            C7303s m33766c = m33775a.m33766c(m33762a.f25023e);
            m33766c.f25020b = 1;
            m33766c.f25034p = 1;
            this.f25005f.m33759a(m33766c);
            return true;
        }
    }

    /* renamed from: b */
    public void m33779b(String str) {
        C7302r m33776a;
        try {
            if (TextUtils.isEmpty(str) || (m33776a = C7302r.m33776a()) == null) {
                return;
            }
            m33776a.m33767b(str);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public void m33782a(String str, String str2) {
        this.f25005f.m33757a(str);
        File file = new File(str2);
        if (file.exists()) {
            file.delete();
        }
    }

    /* renamed from: a */
    public void m33783a(final String str) {
        try {
            C7292n.m33830a().m33828a(new Runnable() { // from class: com.kuaishou.weapon.p0.q.1
                @Override // java.lang.Runnable
                public void run() {
                    final C7302r m33775a;
                    try {
                        if (TextUtils.isEmpty(str) || (m33775a = C7302r.m33775a(StubApp.getOrigApplicationContext(C7299q.this.f25004e.getApplicationContext()), true)) == null) {
                            return;
                        }
                        final C7303s m33765d = m33775a.m33765d(str);
                        if (m33765d == null) {
                            C7303s m33752b = C7299q.this.f25005f.m33752b(str);
                            if (m33752b != null) {
                                C7299q.this.m33782a(str, m33752b.f25023e);
                                return;
                            }
                            return;
                        }
                        new Timer().schedule(new TimerTask() { // from class: com.kuaishou.weapon.p0.q.1.1
                            @Override // java.util.TimerTask, java.lang.Runnable
                            public void run() {
                                m33775a.m33767b(str);
                                C7299q.this.f25005f.m33757a(str);
                                File file = new File(m33765d.f25023e);
                                if (file.exists()) {
                                    file.delete();
                                }
                            }
                        }, TTAdConstant.AD_MAX_EVENT_TIME);
                        m33775a.m33767b(str);
                        C7299q.this.f25005f.m33757a(str);
                        File file = new File(m33765d.f25023e);
                        if (file.exists()) {
                            file.delete();
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public boolean m33784a(C7303s c7303s, String str, String str2) {
        C7302r m33775a;
        if (c7303s == null) {
            return false;
        }
        File file = new File(c7303s.f25023e);
        if (C7271dn.m33939a(file)) {
            try {
                if (!this.f25005f.m33755b(c7303s.f25019a)) {
                    this.f25005f.m33759a(c7303s);
                }
                m33775a = C7302r.m33775a(StubApp.getOrigApplicationContext(this.f25004e.getApplicationContext()), true);
                this.f25005f.m33761a(c7303s.f25019a, 1);
                m33779b(c7303s.f25021c);
            } catch (Throwable unused) {
            }
            if (!m33775a.m33771a(c7303s, true)) {
                file.delete();
                m33787a(c7303s.f25019a, c7303s.f25022d, null, true, null);
                this.f25005f.m33761a(c7303s.f25019a, 0);
                return false;
            }
            c7303s = m33775a.m33766c(c7303s.f25023e);
            if (c7303s == null) {
                this.f25005f.m33761a(c7303s.f25019a, 0);
                return false;
            }
            try {
                C7303s m33762a = this.f25005f.m33762a(c7303s.f25019a);
                File file2 = null;
                if (m33762a != null && !m33762a.f25022d.equals(c7303s.f25022d)) {
                    file2 = new File(m33762a.f25023e);
                }
                c7303s.f25020b = 1;
                c7303s.f25034p = 1;
                if (this.f25005f.m33759a(c7303s) > 0 && file2 != null && file2.exists()) {
                    file2.delete();
                }
                this.f25005f.m33761a(c7303s.f25019a, 0);
                return true;
            } catch (Throwable unused2) {
                return false;
            }
        }
        return false;
    }
}
