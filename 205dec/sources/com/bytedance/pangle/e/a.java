package com.bytedance.pangle.e;

import com.bytedance.pangle.log.ZeusLogger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class a {
    public static boolean a(String[] strArr) {
        if (strArr.length <= 0) {
            return false;
        }
        try {
            Process exec = Runtime.getRuntime().exec(strArr);
            InputStream errorStream = exec.getErrorStream();
            InputStream inputStream = exec.getInputStream();
            a(errorStream);
            a(inputStream);
            if (exec.waitFor() != 0) {
                ZeusLogger.errReport("Zeus/install_pangle", "exec dex2oat failed : " + Arrays.toString(strArr));
                return false;
            }
            return true;
        } catch (IOException e4) {
            e4.printStackTrace();
            return false;
        } catch (InterruptedException e5) {
            e5.printStackTrace();
            return false;
        }
    }

    private static void a(final InputStream inputStream) {
        com.bytedance.pangle.d.e.a(new Runnable() { // from class: com.bytedance.pangle.e.a.1
            @Override // java.lang.Runnable
            public final void run() {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                while (true) {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            return;
                        }
                        ZeusLogger.d("Zeus/install_pangle", "exec cmd info : ".concat(readLine));
                    } catch (IOException e4) {
                        ZeusLogger.errReport("Zeus/install_pangle", "execCmd consumeInputStream failed : ".concat(String.valueOf(e4)));
                        return;
                    } finally {
                        com.bytedance.pangle.util.g.a(bufferedReader);
                    }
                }
            }
        });
    }
}
