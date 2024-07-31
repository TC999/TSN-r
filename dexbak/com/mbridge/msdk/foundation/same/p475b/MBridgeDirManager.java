package com.mbridge.msdk.foundation.same.p475b;

import android.util.Log;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.foundation.tools.SameSDCardTool;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.mbridge.msdk.foundation.same.b.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class MBridgeDirManager {

    /* renamed from: c */
    private static MBridgeDirManager f30643c;

    /* renamed from: a */
    private DirectoryContext f30644a;

    /* renamed from: b */
    private ArrayList<C11319a> f30645b = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: MBridgeDirManager.java */
    /* renamed from: com.mbridge.msdk.foundation.same.b.e$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C11319a {

        /* renamed from: a */
        public MBridgeDir f30646a;

        /* renamed from: b */
        public File f30647b;

        public C11319a(MBridgeDir mBridgeDir, File file) {
            this.f30646a = mBridgeDir;
            this.f30647b = file;
        }
    }

    private MBridgeDirManager(DirectoryContext directoryContext) {
        this.f30644a = directoryContext;
    }

    /* renamed from: a */
    public static synchronized void m22350a(DirectoryContext directoryContext) {
        synchronized (MBridgeDirManager.class) {
            if (f30643c == null) {
                f30643c = new MBridgeDirManager(directoryContext);
            }
        }
    }

    /* renamed from: b */
    public static String m22347b(MBridgeDir mBridgeDir) {
        File m22349a = m22349a(mBridgeDir);
        if (m22349a != null) {
            return m22349a.getAbsolutePath();
        }
        return null;
    }

    /* renamed from: b */
    public final boolean m22348b() {
        return m22351a(this.f30644a.m22355a());
    }

    /* renamed from: a */
    public static synchronized MBridgeDirManager m22352a() {
        MBridgeDirManager mBridgeDirManager;
        synchronized (MBridgeDirManager.class) {
            if (f30643c == null && MBSDKContext.m22865f().m22861j() != null) {
                SameSDCardTool.m22041a(MBSDKContext.m22865f().m22861j());
            }
            if (f30643c == null) {
                Log.e("MBridgeDirManager", "mDirectoryManager == null");
            }
            mBridgeDirManager = f30643c;
        }
        return mBridgeDirManager;
    }

    /* renamed from: a */
    public static File m22349a(MBridgeDir mBridgeDir) {
        try {
            if (m22352a() != null) {
                Iterator<C11319a> it = m22352a().f30645b.iterator();
                while (it.hasNext()) {
                    C11319a next = it.next();
                    if (next.f30646a.equals(mBridgeDir)) {
                        return next.f30647b;
                    }
                }
                return null;
            }
            return null;
        } catch (Throwable th) {
            SameLogTool.m21735b("MBridgeDirManager", th.getMessage(), th);
            return null;
        }
    }

    /* renamed from: a */
    private boolean m22351a(Directory directory) {
        String str;
        Directory m22357c = directory.m22357c();
        if (m22357c == null) {
            str = directory.m22358b();
        } else {
            File m22349a = m22349a(m22357c.m22364a());
            str = m22349a.getAbsolutePath() + File.separator + directory.m22358b();
        }
        File file = new File(str);
        if (!file.exists() ? file.mkdirs() : true) {
            this.f30645b.add(new C11319a(directory.m22364a(), file));
            List<Directory> m22356d = directory.m22356d();
            if (m22356d != null) {
                for (Directory directory2 : m22356d) {
                    if (!m22351a(directory2)) {
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
}
