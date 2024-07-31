package com.bytedance.pangle.p120e;

import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.p119d.C6083e;
import com.bytedance.pangle.util.C6251g;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/* renamed from: com.bytedance.pangle.e.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6094a {
    /* renamed from: a */
    public static boolean m37200a(String[] strArr) {
        if (strArr.length <= 0) {
            return false;
        }
        try {
            Process exec = Runtime.getRuntime().exec(strArr);
            InputStream errorStream = exec.getErrorStream();
            InputStream inputStream = exec.getInputStream();
            m37201a(errorStream);
            m37201a(inputStream);
            if (exec.waitFor() != 0) {
                ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "exec dex2oat failed : " + Arrays.toString(strArr));
                return false;
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } catch (InterruptedException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    private static void m37201a(final InputStream inputStream) {
        C6083e.m37212a(new Runnable() { // from class: com.bytedance.pangle.e.a.1
            @Override // java.lang.Runnable
            public final void run() {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            return;
                        }
                        ZeusLogger.m37083d(ZeusLogger.TAG_INSTALL, "exec cmd info : ".concat(readLine));
                    } catch (IOException e) {
                        ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "execCmd consumeInputStream failed : ".concat(String.valueOf(e)));
                        return;
                    } finally {
                        C6251g.m36900a(bufferedReader);
                    }
                }
            }
        });
    }
}
