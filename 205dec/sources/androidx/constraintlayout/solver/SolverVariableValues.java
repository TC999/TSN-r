package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.ArrayRow;
import java.io.PrintStream;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class SolverVariableValues implements ArrayRow.ArrayRowVariables {
    private static final boolean DEBUG = false;
    private static final boolean HASH = true;
    private static float epsilon = 0.001f;
    protected final Cache mCache;
    private final ArrayRow mRow;
    private final int NONE = -1;
    private int SIZE = 16;
    private int HASH_SIZE = 16;
    int[] keys = new int[16];
    int[] nextKeys = new int[16];
    int[] variables = new int[16];
    float[] values = new float[16];
    int[] previous = new int[16];
    int[] next = new int[16];
    int mCount = 0;
    int head = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SolverVariableValues(ArrayRow arrayRow, Cache cache) {
        this.mRow = arrayRow;
        this.mCache = cache;
        clear();
    }

    private void addToHashMap(SolverVariable solverVariable, int i4) {
        int[] iArr;
        int i5 = solverVariable.id % this.HASH_SIZE;
        int[] iArr2 = this.keys;
        int i6 = iArr2[i5];
        if (i6 == -1) {
            iArr2[i5] = i4;
        } else {
            while (true) {
                iArr = this.nextKeys;
                if (iArr[i6] == -1) {
                    break;
                }
                i6 = iArr[i6];
            }
            iArr[i6] = i4;
        }
        this.nextKeys[i4] = -1;
    }

    private void addVariable(int i4, SolverVariable solverVariable, float f4) {
        this.variables[i4] = solverVariable.id;
        this.values[i4] = f4;
        this.previous[i4] = -1;
        this.next[i4] = -1;
        solverVariable.addToRow(this.mRow);
        solverVariable.usageInRowCount++;
        this.mCount++;
    }

    private void displayHash() {
        for (int i4 = 0; i4 < this.HASH_SIZE; i4++) {
            if (this.keys[i4] != -1) {
                String str = hashCode() + " hash [" + i4 + "] => ";
                int i5 = this.keys[i4];
                boolean z3 = false;
                while (!z3) {
                    str = str + " " + this.variables[i5];
                    int[] iArr = this.nextKeys;
                    if (iArr[i5] != -1) {
                        i5 = iArr[i5];
                    } else {
                        z3 = true;
                    }
                }
                System.out.println(str);
            }
        }
    }

    private int findEmptySlot() {
        for (int i4 = 0; i4 < this.SIZE; i4++) {
            if (this.variables[i4] == -1) {
                return i4;
            }
        }
        return -1;
    }

    private void increaseSize() {
        int i4 = this.SIZE * 2;
        this.variables = Arrays.copyOf(this.variables, i4);
        this.values = Arrays.copyOf(this.values, i4);
        this.previous = Arrays.copyOf(this.previous, i4);
        this.next = Arrays.copyOf(this.next, i4);
        this.nextKeys = Arrays.copyOf(this.nextKeys, i4);
        for (int i5 = this.SIZE; i5 < i4; i5++) {
            this.variables[i5] = -1;
            this.nextKeys[i5] = -1;
        }
        this.SIZE = i4;
    }

    private void insertVariable(int i4, SolverVariable solverVariable, float f4) {
        int findEmptySlot = findEmptySlot();
        addVariable(findEmptySlot, solverVariable, f4);
        if (i4 != -1) {
            this.previous[findEmptySlot] = i4;
            int[] iArr = this.next;
            iArr[findEmptySlot] = iArr[i4];
            iArr[i4] = findEmptySlot;
        } else {
            this.previous[findEmptySlot] = -1;
            if (this.mCount > 0) {
                this.next[findEmptySlot] = this.head;
                this.head = findEmptySlot;
            } else {
                this.next[findEmptySlot] = -1;
            }
        }
        int[] iArr2 = this.next;
        if (iArr2[findEmptySlot] != -1) {
            this.previous[iArr2[findEmptySlot]] = findEmptySlot;
        }
        addToHashMap(solverVariable, findEmptySlot);
    }

    private void removeFromHashMap(SolverVariable solverVariable) {
        int[] iArr;
        int i4 = solverVariable.id;
        int i5 = i4 % this.HASH_SIZE;
        int[] iArr2 = this.keys;
        int i6 = iArr2[i5];
        if (i6 == -1) {
            return;
        }
        if (this.variables[i6] == i4) {
            int[] iArr3 = this.nextKeys;
            iArr2[i5] = iArr3[i6];
            iArr3[i6] = -1;
            return;
        }
        while (true) {
            iArr = this.nextKeys;
            if (iArr[i6] == -1 || this.variables[iArr[i6]] == i4) {
                break;
            }
            i6 = iArr[i6];
        }
        int i7 = iArr[i6];
        if (i7 == -1 || this.variables[i7] != i4) {
            return;
        }
        iArr[i6] = iArr[i7];
        iArr[i7] = -1;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void add(SolverVariable solverVariable, float f4, boolean z3) {
        float f5 = epsilon;
        if (f4 <= (-f5) || f4 >= f5) {
            int indexOf = indexOf(solverVariable);
            if (indexOf == -1) {
                put(solverVariable, f4);
                return;
            }
            float[] fArr = this.values;
            fArr[indexOf] = fArr[indexOf] + f4;
            float f6 = fArr[indexOf];
            float f7 = epsilon;
            if (f6 <= (-f7) || fArr[indexOf] >= f7) {
                return;
            }
            fArr[indexOf] = 0.0f;
            remove(solverVariable, z3);
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void clear() {
        int i4 = this.mCount;
        for (int i5 = 0; i5 < i4; i5++) {
            SolverVariable variable = getVariable(i5);
            if (variable != null) {
                variable.removeFromRow(this.mRow);
            }
        }
        for (int i6 = 0; i6 < this.SIZE; i6++) {
            this.variables[i6] = -1;
            this.nextKeys[i6] = -1;
        }
        for (int i7 = 0; i7 < this.HASH_SIZE; i7++) {
            this.keys[i7] = -1;
        }
        this.mCount = 0;
        this.head = -1;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public boolean contains(SolverVariable solverVariable) {
        return indexOf(solverVariable) != -1;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void display() {
        int i4 = this.mCount;
        System.out.print("{ ");
        for (int i5 = 0; i5 < i4; i5++) {
            SolverVariable variable = getVariable(i5);
            if (variable != null) {
                PrintStream printStream = System.out;
                printStream.print(variable + " = " + getVariableValue(i5) + " ");
            }
        }
        System.out.println(" }");
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void divideByAmount(float f4) {
        int i4 = this.mCount;
        int i5 = this.head;
        for (int i6 = 0; i6 < i4; i6++) {
            float[] fArr = this.values;
            fArr[i5] = fArr[i5] / f4;
            i5 = this.next[i5];
            if (i5 == -1) {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float get(SolverVariable solverVariable) {
        int indexOf = indexOf(solverVariable);
        if (indexOf != -1) {
            return this.values[indexOf];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int getCurrentSize() {
        return this.mCount;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public SolverVariable getVariable(int i4) {
        int i5 = this.mCount;
        if (i5 == 0) {
            return null;
        }
        int i6 = this.head;
        for (int i7 = 0; i7 < i5; i7++) {
            if (i7 == i4 && i6 != -1) {
                return this.mCache.mIndexedVariables[this.variables[i6]];
            }
            i6 = this.next[i6];
            if (i6 == -1) {
                break;
            }
        }
        return null;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float getVariableValue(int i4) {
        int i5 = this.mCount;
        int i6 = this.head;
        for (int i7 = 0; i7 < i5; i7++) {
            if (i7 == i4) {
                return this.values[i6];
            }
            i6 = this.next[i6];
            if (i6 == -1) {
                return 0.0f;
            }
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int indexOf(SolverVariable solverVariable) {
        int[] iArr;
        if (this.mCount == 0) {
            return -1;
        }
        int i4 = solverVariable.id;
        int i5 = this.keys[i4 % this.HASH_SIZE];
        if (i5 == -1) {
            return -1;
        }
        if (this.variables[i5] == i4) {
            return i5;
        }
        while (true) {
            iArr = this.nextKeys;
            if (iArr[i5] == -1 || this.variables[iArr[i5]] == i4) {
                break;
            }
            i5 = iArr[i5];
        }
        if (iArr[i5] != -1 && this.variables[iArr[i5]] == i4) {
            return iArr[i5];
        }
        return -1;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void invert() {
        int i4 = this.mCount;
        int i5 = this.head;
        for (int i6 = 0; i6 < i4; i6++) {
            float[] fArr = this.values;
            fArr[i5] = fArr[i5] * (-1.0f);
            i5 = this.next[i5];
            if (i5 == -1) {
                return;
            }
        }
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public void put(SolverVariable solverVariable, float f4) {
        float f5 = epsilon;
        if (f4 > (-f5) && f4 < f5) {
            remove(solverVariable, true);
            return;
        }
        if (this.mCount == 0) {
            addVariable(0, solverVariable, f4);
            addToHashMap(solverVariable, 0);
            this.head = 0;
            return;
        }
        int indexOf = indexOf(solverVariable);
        if (indexOf != -1) {
            this.values[indexOf] = f4;
            return;
        }
        if (this.mCount + 1 >= this.SIZE) {
            increaseSize();
        }
        int i4 = this.mCount;
        int i5 = this.head;
        int i6 = -1;
        for (int i7 = 0; i7 < i4; i7++) {
            int[] iArr = this.variables;
            int i8 = iArr[i5];
            int i9 = solverVariable.id;
            if (i8 == i9) {
                this.values[i5] = f4;
                return;
            }
            if (iArr[i5] < i9) {
                i6 = i5;
            }
            i5 = this.next[i5];
            if (i5 == -1) {
                break;
            }
        }
        insertVariable(i6, solverVariable, f4);
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float remove(SolverVariable solverVariable, boolean z3) {
        int indexOf = indexOf(solverVariable);
        if (indexOf == -1) {
            return 0.0f;
        }
        removeFromHashMap(solverVariable);
        float f4 = this.values[indexOf];
        if (this.head == indexOf) {
            this.head = this.next[indexOf];
        }
        this.variables[indexOf] = -1;
        int[] iArr = this.previous;
        if (iArr[indexOf] != -1) {
            int[] iArr2 = this.next;
            iArr2[iArr[indexOf]] = iArr2[indexOf];
        }
        int[] iArr3 = this.next;
        if (iArr3[indexOf] != -1) {
            iArr[iArr3[indexOf]] = iArr[indexOf];
        }
        this.mCount--;
        solverVariable.usageInRowCount--;
        if (z3) {
            solverVariable.removeFromRow(this.mRow);
        }
        return f4;
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public int sizeInBytes() {
        return 0;
    }

    public String toString() {
        String str = hashCode() + " { ";
        int i4 = this.mCount;
        for (int i5 = 0; i5 < i4; i5++) {
            SolverVariable variable = getVariable(i5);
            if (variable != null) {
                String str2 = str + variable + " = " + getVariableValue(i5) + " ";
                int indexOf = indexOf(variable);
                String str3 = str2 + "[p: ";
                String str4 = (this.previous[indexOf] != -1 ? str3 + this.mCache.mIndexedVariables[this.variables[this.previous[indexOf]]] : str3 + "none") + ", n: ";
                str = (this.next[indexOf] != -1 ? str4 + this.mCache.mIndexedVariables[this.variables[this.next[indexOf]]] : str4 + "none") + "]";
            }
        }
        return str + " }";
    }

    @Override // androidx.constraintlayout.solver.ArrayRow.ArrayRowVariables
    public float use(ArrayRow arrayRow, boolean z3) {
        float f4 = get(arrayRow.variable);
        remove(arrayRow.variable, z3);
        SolverVariableValues solverVariableValues = (SolverVariableValues) arrayRow.variables;
        int currentSize = solverVariableValues.getCurrentSize();
        int i4 = 0;
        int i5 = 0;
        while (i4 < currentSize) {
            int[] iArr = solverVariableValues.variables;
            if (iArr[i5] != -1) {
                add(this.mCache.mIndexedVariables[iArr[i5]], solverVariableValues.values[i5] * f4, z3);
                i4++;
            }
            i5++;
        }
        return f4;
    }
}
