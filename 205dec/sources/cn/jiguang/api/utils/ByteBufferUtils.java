package cn.jiguang.api.utils;

import cn.jiguang.api.JResponse;
import cn.jiguang.cl.d;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class ByteBufferUtils {
    public static final int ERROR_CODE = 10000;
    private static final String TAG = "ByteBufferUtils";

    private static String generalExtraStr(Throwable th, JResponse jResponse, ByteBuffer byteBuffer) {
        StringBuilder sb = new StringBuilder();
        if (jResponse != null) {
            sb.append(jResponse.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("|bytebuffer:");
            sb2.append(byteBuffer == null ? "byteBuffer is null" : byteBuffer.toString());
            sb.append(sb2.toString());
        }
        d.f(TAG, "byteBuffer info:" + sb.toString());
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            String stringWriter2 = stringWriter.toString();
            d.f(TAG, "parse data error stackTrace:" + stringWriter2);
        } catch (Exception unused) {
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001f  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.Byte get(java.nio.ByteBuffer r1, cn.jiguang.api.JResponse r2) {
        /*
            byte r0 = r1.get()     // Catch: java.lang.Exception -> L9 java.nio.BufferOverflowException -> Lf java.nio.BufferUnderflowException -> L15
            java.lang.Byte r1 = java.lang.Byte.valueOf(r0)     // Catch: java.lang.Exception -> L9 java.nio.BufferOverflowException -> Lf java.nio.BufferUnderflowException -> L15
            return r1
        L9:
            r0 = move-exception
            java.lang.Throwable r0 = r0.fillInStackTrace()
            goto L1a
        Lf:
            r0 = move-exception
            java.lang.Throwable r0 = r0.fillInStackTrace()
            goto L1a
        L15:
            r0 = move-exception
            java.lang.Throwable r0 = r0.fillInStackTrace()
        L1a:
            onException(r0, r2, r1)
            if (r2 == 0) goto L23
            r1 = 10000(0x2710, float:1.4013E-41)
            r2.code = r1
        L23:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.api.utils.ByteBufferUtils.get(java.nio.ByteBuffer, cn.jiguang.api.JResponse):java.lang.Byte");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.nio.ByteBuffer get(java.nio.ByteBuffer r0, byte[] r1, cn.jiguang.api.JResponse r2) {
        /*
            java.nio.ByteBuffer r0 = r0.get(r1)     // Catch: java.lang.Exception -> L5 java.nio.BufferOverflowException -> Lb java.nio.BufferUnderflowException -> L11
            return r0
        L5:
            r1 = move-exception
            java.lang.Throwable r1 = r1.fillInStackTrace()
            goto L16
        Lb:
            r1 = move-exception
            java.lang.Throwable r1 = r1.fillInStackTrace()
            goto L16
        L11:
            r1 = move-exception
            java.lang.Throwable r1 = r1.fillInStackTrace()
        L16:
            onException(r1, r2, r0)
            if (r2 == 0) goto L1f
            r0 = 10000(0x2710, float:1.4013E-41)
            r2.code = r0
        L1f:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.api.utils.ByteBufferUtils.get(java.nio.ByteBuffer, byte[], cn.jiguang.api.JResponse):java.nio.ByteBuffer");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int getInt(java.nio.ByteBuffer r1, cn.jiguang.api.JResponse r2) {
        /*
            int r1 = r1.getInt()     // Catch: java.lang.Exception -> L5 java.nio.BufferOverflowException -> Lb java.nio.BufferUnderflowException -> L11
            return r1
        L5:
            r0 = move-exception
            java.lang.Throwable r0 = r0.fillInStackTrace()
            goto L16
        Lb:
            r0 = move-exception
            java.lang.Throwable r0 = r0.fillInStackTrace()
            goto L16
        L11:
            r0 = move-exception
            java.lang.Throwable r0 = r0.fillInStackTrace()
        L16:
            onException(r0, r2, r1)
            if (r2 == 0) goto L1f
            r1 = 10000(0x2710, float:1.4013E-41)
            r2.code = r1
        L1f:
            r1 = -1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.api.utils.ByteBufferUtils.getInt(java.nio.ByteBuffer, cn.jiguang.api.JResponse):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long getLong(java.nio.ByteBuffer r1, cn.jiguang.api.JResponse r2) {
        /*
            long r1 = r1.getLong()     // Catch: java.lang.Exception -> L5 java.nio.BufferOverflowException -> Lb java.nio.BufferUnderflowException -> L11
            return r1
        L5:
            r0 = move-exception
            java.lang.Throwable r0 = r0.fillInStackTrace()
            goto L16
        Lb:
            r0 = move-exception
            java.lang.Throwable r0 = r0.fillInStackTrace()
            goto L16
        L11:
            r0 = move-exception
            java.lang.Throwable r0 = r0.fillInStackTrace()
        L16:
            onException(r0, r2, r1)
            if (r2 == 0) goto L1f
            r1 = 10000(0x2710, float:1.4013E-41)
            r2.code = r1
        L1f:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.api.utils.ByteBufferUtils.getLong(java.nio.ByteBuffer, cn.jiguang.api.JResponse):long");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static short getShort(java.nio.ByteBuffer r1, cn.jiguang.api.JResponse r2) {
        /*
            short r1 = r1.getShort()     // Catch: java.lang.Exception -> L5 java.nio.BufferOverflowException -> Lb java.nio.BufferUnderflowException -> L11
            return r1
        L5:
            r0 = move-exception
            java.lang.Throwable r0 = r0.fillInStackTrace()
            goto L16
        Lb:
            r0 = move-exception
            java.lang.Throwable r0 = r0.fillInStackTrace()
            goto L16
        L11:
            r0 = move-exception
            java.lang.Throwable r0 = r0.fillInStackTrace()
        L16:
            onException(r0, r2, r1)
            if (r2 == 0) goto L1f
            r1 = 10000(0x2710, float:1.4013E-41)
            r2.code = r1
        L1f:
            r1 = -1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jiguang.api.utils.ByteBufferUtils.getShort(java.nio.ByteBuffer, cn.jiguang.api.JResponse):short");
    }

    private static void onException(Throwable th, JResponse jResponse, ByteBuffer byteBuffer) {
        generalExtraStr(th, jResponse, byteBuffer);
    }
}
