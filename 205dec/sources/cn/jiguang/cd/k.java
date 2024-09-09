package cn.jiguang.cd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
final class k {
    /* JADX INFO: Access modifiers changed from: package-private */
    public List<cn.jiguang.ce.e> a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null || stackTraceElementArr.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            if (stackTraceElement != null) {
                String className = stackTraceElement.getClassName();
                cn.jiguang.ce.e eVar = new cn.jiguang.ce.e();
                eVar.a(Boolean.valueOf(a(className)));
                eVar.c(className);
                eVar.b(stackTraceElement.getMethodName());
                eVar.a(stackTraceElement.getFileName());
                if (stackTraceElement.getLineNumber() >= 0) {
                    eVar.a(Integer.valueOf(stackTraceElement.getLineNumber()));
                }
                eVar.b(Boolean.valueOf(stackTraceElement.isNativeMethod()));
                arrayList.add(eVar);
            }
        }
        Collections.reverse(arrayList);
        return arrayList;
    }

    boolean a(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        return str.contains("cn.jiguang") || str.contains("cn.jpush");
    }
}
