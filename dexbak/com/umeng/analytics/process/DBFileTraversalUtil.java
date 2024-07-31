package com.umeng.analytics.process;

import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DBFileTraversalUtil {

    /* renamed from: a */
    private static ExecutorService f38485a = Executors.newSingleThreadExecutor();

    /* renamed from: b */
    private static FileLockUtil f38486b = new FileLockUtil();

    /* renamed from: com.umeng.analytics.process.DBFileTraversalUtil$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface InterfaceC13180a {
        /* renamed from: a */
        void mo14131a();
    }

    public static void traverseDBFiles(String str, final FileLockCallback fileLockCallback, final InterfaceC13180a interfaceC13180a) {
        final File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            f38485a.execute(new Runnable() { // from class: com.umeng.analytics.process.DBFileTraversalUtil.1
                @Override // java.lang.Runnable
                public void run() {
                    File[] listFiles;
                    try {
                        for (File file2 : file.listFiles()) {
                            if (file2.getName().endsWith(DBConstant.f38508d)) {
                                DBFileTraversalUtil.f38486b.doFileOperateion(file2, fileLockCallback);
                                UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> file: " + file2.getName());
                            }
                        }
                        InterfaceC13180a interfaceC13180a2 = interfaceC13180a;
                        if (interfaceC13180a2 != null) {
                            interfaceC13180a2.mo14131a();
                        }
                    } catch (Throwable unused) {
                    }
                    UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "--->>> end *** ");
                }
            });
        }
    }
}
