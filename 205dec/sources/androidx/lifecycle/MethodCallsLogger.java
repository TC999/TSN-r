package androidx.lifecycle;

import androidx.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class MethodCallsLogger {
    private Map<String, Integer> mCalledMethods = new HashMap();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public boolean approveCall(String str, int i4) {
        Integer num = this.mCalledMethods.get(str);
        int intValue = num != null ? num.intValue() : 0;
        boolean z3 = (intValue & i4) != 0;
        this.mCalledMethods.put(str, Integer.valueOf(i4 | intValue));
        return !z3;
    }
}
