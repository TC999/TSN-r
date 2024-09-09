package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class Chain {
    private static final boolean DEBUG = false;

    Chain() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int i4) {
        int i5;
        int i6;
        ChainHead[] chainHeadArr;
        if (i4 == 0) {
            int i7 = constraintWidgetContainer.mHorizontalChainsSize;
            chainHeadArr = constraintWidgetContainer.mHorizontalChainsArray;
            i6 = i7;
            i5 = 0;
        } else {
            i5 = 2;
            i6 = constraintWidgetContainer.mVerticalChainsSize;
            chainHeadArr = constraintWidgetContainer.mVerticalChainsArray;
        }
        for (int i8 = 0; i8 < i6; i8++) {
            ChainHead chainHead = chainHeadArr[i8];
            chainHead.define();
            applyChainConstraints(constraintWidgetContainer, linearSystem, i4, i5, chainHead);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:
        if (r8 == 2) goto L309;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x003c, code lost:
        if (r8 == 2) goto L309;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003e, code lost:
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0040, code lost:
        r5 = false;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0258 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:154:0x02b1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:213:0x039a  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x03a3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:226:0x03b6  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0485  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x04ba  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x04cd A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:287:0x04e1  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x04e4  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x04ea  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x04ed  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x04f1  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0501  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0507 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:312:0x039b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:323:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void applyChainConstraints(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer r37, androidx.constraintlayout.solver.LinearSystem r38, int r39, int r40, androidx.constraintlayout.solver.widgets.ChainHead r41) {
        /*
            Method dump skipped, instructions count: 1320
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.solver.widgets.Chain.applyChainConstraints(androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer, androidx.constraintlayout.solver.LinearSystem, int, int, androidx.constraintlayout.solver.widgets.ChainHead):void");
    }
}
