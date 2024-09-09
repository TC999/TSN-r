package com.umeng.analytics.process;

import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.utils.FileLockCallback;
import com.umeng.commonsdk.utils.FileLockUtil;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class DBFileTraversalUtil {

    /* renamed from: a  reason: collision with root package name */
    private static ExecutorService f53156a = Executors.newSingleThreadExecutor();

    /* renamed from: b  reason: collision with root package name */
    private static FileLockUtil f53157b = new FileLockUtil();

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface a {
        void a();
    }

    public static void traverseDBFiles(String str, final FileLockCallback fileLockCallback, final a aVar) {
        final File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            f53156a.execute(new Runnable() { // from class: com.umeng.analytics.process.DBFileTraversalUtil.1
                @Override // java.lang.Runnable
                public void run() {
                    File[] listFiles;
                    try {
                        for (File file2 : file.listFiles()) {
                            if (file2.getName().endsWith(".db")) {
                                DBFileTraversalUtil.f53157b.doFileOperateion(file2, fileLockCallback);
                                UMRTLog.i("MobclickRT", "--->>> file: " + file2.getName());
                            }
                        }
                        a aVar2 = aVar;
                        if (aVar2 != null) {
                            aVar2.a();
                        }
                    } catch (Throwable unused) {
                    }
                    UMRTLog.i("MobclickRT", "--->>> end *** ");
                }
            });
        }
    }
}
