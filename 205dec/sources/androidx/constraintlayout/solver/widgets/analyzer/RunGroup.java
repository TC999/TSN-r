package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class RunGroup {
    public static final int BASELINE = 2;
    public static final int END = 1;
    public static final int START = 0;
    public static int index;
    int direction;
    WidgetRun firstRun;
    int groupIndex;
    WidgetRun lastRun;
    public int position = 0;
    public boolean dual = false;
    ArrayList<WidgetRun> runs = new ArrayList<>();

    public RunGroup(WidgetRun widgetRun, int i4) {
        this.firstRun = null;
        this.lastRun = null;
        int i5 = index;
        this.groupIndex = i5;
        index = i5 + 1;
        this.firstRun = widgetRun;
        this.lastRun = widgetRun;
        this.direction = i4;
    }

    private boolean defineTerminalWidget(WidgetRun widgetRun, int i4) {
        DependencyNode dependencyNode;
        WidgetRun widgetRun2;
        DependencyNode dependencyNode2;
        WidgetRun widgetRun3;
        if (widgetRun.widget.isTerminalWidget[i4]) {
            for (Dependency dependency : widgetRun.start.dependencies) {
                if ((dependency instanceof DependencyNode) && (widgetRun3 = (dependencyNode2 = (DependencyNode) dependency).run) != widgetRun && dependencyNode2 == widgetRun3.start) {
                    if (widgetRun instanceof ChainRun) {
                        Iterator<WidgetRun> it = ((ChainRun) widgetRun).widgets.iterator();
                        while (it.hasNext()) {
                            defineTerminalWidget(it.next(), i4);
                        }
                    } else if (!(widgetRun instanceof HelperReferences)) {
                        widgetRun.widget.isTerminalWidget[i4] = false;
                    }
                    defineTerminalWidget(dependencyNode2.run, i4);
                }
            }
            for (Dependency dependency2 : widgetRun.end.dependencies) {
                if ((dependency2 instanceof DependencyNode) && (widgetRun2 = (dependencyNode = (DependencyNode) dependency2).run) != widgetRun && dependencyNode == widgetRun2.start) {
                    if (widgetRun instanceof ChainRun) {
                        Iterator<WidgetRun> it2 = ((ChainRun) widgetRun).widgets.iterator();
                        while (it2.hasNext()) {
                            defineTerminalWidget(it2.next(), i4);
                        }
                    } else if (!(widgetRun instanceof HelperReferences)) {
                        widgetRun.widget.isTerminalWidget[i4] = false;
                    }
                    defineTerminalWidget(dependencyNode.run, i4);
                }
            }
            return false;
        }
        return false;
    }

    private long traverseEnd(DependencyNode dependencyNode, long j4) {
        WidgetRun widgetRun = dependencyNode.run;
        if (widgetRun instanceof HelperReferences) {
            return j4;
        }
        int size = dependencyNode.dependencies.size();
        long j5 = j4;
        for (int i4 = 0; i4 < size; i4++) {
            Dependency dependency = dependencyNode.dependencies.get(i4);
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency;
                if (dependencyNode2.run != widgetRun) {
                    j5 = Math.min(j5, traverseEnd(dependencyNode2, dependencyNode2.margin + j4));
                }
            }
        }
        if (dependencyNode == widgetRun.end) {
            long wrapDimension = j4 - widgetRun.getWrapDimension();
            return Math.min(Math.min(j5, traverseEnd(widgetRun.start, wrapDimension)), wrapDimension - widgetRun.start.margin);
        }
        return j5;
    }

    private long traverseStart(DependencyNode dependencyNode, long j4) {
        WidgetRun widgetRun = dependencyNode.run;
        if (widgetRun instanceof HelperReferences) {
            return j4;
        }
        int size = dependencyNode.dependencies.size();
        long j5 = j4;
        for (int i4 = 0; i4 < size; i4++) {
            Dependency dependency = dependencyNode.dependencies.get(i4);
            if (dependency instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) dependency;
                if (dependencyNode2.run != widgetRun) {
                    j5 = Math.max(j5, traverseStart(dependencyNode2, dependencyNode2.margin + j4));
                }
            }
        }
        if (dependencyNode == widgetRun.start) {
            long wrapDimension = j4 + widgetRun.getWrapDimension();
            return Math.max(Math.max(j5, traverseStart(widgetRun.end, wrapDimension)), wrapDimension - widgetRun.end.margin);
        }
        return j5;
    }

    public void add(WidgetRun widgetRun) {
        this.runs.add(widgetRun);
        this.lastRun = widgetRun;
    }

    public long computeWrapSize(ConstraintWidgetContainer constraintWidgetContainer, int i4) {
        long wrapDimension;
        int i5;
        WidgetRun widgetRun = this.firstRun;
        if (widgetRun instanceof ChainRun) {
            if (((ChainRun) widgetRun).orientation != i4) {
                return 0L;
            }
        } else if (i4 == 0) {
            if (!(widgetRun instanceof HorizontalWidgetRun)) {
                return 0L;
            }
        } else if (!(widgetRun instanceof VerticalWidgetRun)) {
            return 0L;
        }
        DependencyNode dependencyNode = (i4 == 0 ? constraintWidgetContainer.horizontalRun : constraintWidgetContainer.verticalRun).start;
        DependencyNode dependencyNode2 = (i4 == 0 ? constraintWidgetContainer.horizontalRun : constraintWidgetContainer.verticalRun).end;
        boolean contains = widgetRun.start.targets.contains(dependencyNode);
        boolean contains2 = this.firstRun.end.targets.contains(dependencyNode2);
        long wrapDimension2 = this.firstRun.getWrapDimension();
        if (contains && contains2) {
            long traverseStart = traverseStart(this.firstRun.start, 0L);
            long traverseEnd = traverseEnd(this.firstRun.end, 0L);
            long j4 = traverseStart - wrapDimension2;
            WidgetRun widgetRun2 = this.firstRun;
            int i6 = widgetRun2.end.margin;
            if (j4 >= (-i6)) {
                j4 += i6;
            }
            int i7 = widgetRun2.start.margin;
            long j5 = ((-traverseEnd) - wrapDimension2) - i7;
            if (j5 >= i7) {
                j5 -= i7;
            }
            float biasPercent = widgetRun2.widget.getBiasPercent(i4);
            float f4 = (float) (biasPercent > 0.0f ? (((float) j5) / biasPercent) + (((float) j4) / (1.0f - biasPercent)) : 0L);
            long j6 = (f4 * biasPercent) + 0.5f + wrapDimension2 + (f4 * (1.0f - biasPercent)) + 0.5f;
            WidgetRun widgetRun3 = this.firstRun;
            wrapDimension = widgetRun3.start.margin + j6;
            i5 = widgetRun3.end.margin;
        } else if (contains) {
            DependencyNode dependencyNode3 = this.firstRun.start;
            return Math.max(traverseStart(dependencyNode3, dependencyNode3.margin), this.firstRun.start.margin + wrapDimension2);
        } else if (contains2) {
            DependencyNode dependencyNode4 = this.firstRun.end;
            return Math.max(-traverseEnd(dependencyNode4, dependencyNode4.margin), (-this.firstRun.end.margin) + wrapDimension2);
        } else {
            WidgetRun widgetRun4 = this.firstRun;
            wrapDimension = widgetRun4.start.margin + widgetRun4.getWrapDimension();
            i5 = this.firstRun.end.margin;
        }
        return wrapDimension - i5;
    }

    public void defineTerminalWidgets(boolean z3, boolean z4) {
        if (z3) {
            WidgetRun widgetRun = this.firstRun;
            if (widgetRun instanceof HorizontalWidgetRun) {
                defineTerminalWidget(widgetRun, 0);
            }
        }
        if (z4) {
            WidgetRun widgetRun2 = this.firstRun;
            if (widgetRun2 instanceof VerticalWidgetRun) {
                defineTerminalWidget(widgetRun2, 1);
            }
        }
    }
}
