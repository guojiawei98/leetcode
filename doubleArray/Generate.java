package doubleArray;

import java.util.ArrayList;
import java.util.List;
//给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
public class Generate {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> outer = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> inner = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i) {
                    inner.add(1);
                }else {
                    inner.add(outer.get(i - 1).get(j) + outer.get(i - 1).get(j - 1));
                }
            }
            outer.add(inner);
        }
        return outer;
    }
}
