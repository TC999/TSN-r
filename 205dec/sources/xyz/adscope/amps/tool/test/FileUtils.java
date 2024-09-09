package xyz.adscope.amps.tool.test;

import android.content.Context;
import androidx.annotation.RequiresApi;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.common.tool.LogUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class FileUtils {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.io.InputStream] */
    @RequiresApi(api = 19)
    public static String getTestConfig(Context context) throws IOException {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        Throwable th;
        BufferedReader bufferedReader2;
        Exception e4;
        try {
            try {
                context = context.getAssets().open("amps_test_config_json");
                try {
                    inputStreamReader = new InputStreamReader((InputStream) context, StandardCharsets.UTF_8);
                    try {
                        bufferedReader2 = new BufferedReader(inputStreamReader);
                    } catch (Exception e5) {
                        bufferedReader2 = null;
                        e4 = e5;
                    } catch (Throwable th2) {
                        bufferedReader = null;
                        th = th2;
                        if (context != 0) {
                            context.close();
                        }
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                        }
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        throw th;
                    }
                } catch (Exception e6) {
                    bufferedReader2 = null;
                    e4 = e6;
                    inputStreamReader = null;
                } catch (Throwable th3) {
                    bufferedReader = null;
                    th = th3;
                    inputStreamReader = null;
                }
            } catch (Exception e7) {
                inputStreamReader = null;
                bufferedReader2 = null;
                e4 = e7;
                context = 0;
            } catch (Throwable th4) {
                inputStreamReader = null;
                bufferedReader = null;
                th = th4;
                context = 0;
            }
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                }
                String sb2 = sb.toString();
                if (context != 0) {
                    context.close();
                }
                inputStreamReader.close();
                bufferedReader2.close();
                return sb2;
            } catch (Exception e8) {
                e4 = e8;
                LogUtil.e(AMPSConstants.AMPS_LOG_TAG, "getTestConfig error is = " + e4.getMessage());
                if (context != 0) {
                    context.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (bufferedReader2 != null) {
                    bufferedReader2.close();
                    return "";
                }
                return "";
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }
}
