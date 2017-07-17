package my.test.algorithm.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 6700K on 7/9/2017.
 */
public class CPermutation {

    public List<List<Integer>> calCPermutation(int[] origin, int num) {
        List<List<Integer>> result = new ArrayList();
        for (int start = 0; start < origin.length - num; start++) {
            result.addAll(getC(start, origin, num - 1));
        }
        return result;
    }

    private List<List<Integer>> getC(int start, int[] origin, int num) {
//        int last = origin.length - 2;
        if (num == 1) {
            List<List<Integer>> r = new ArrayList<>();
            for (int j = start + 1; j < origin.length; j++) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(origin[j]);
                tmp.add(origin[start]);
                r.add(tmp);
            }
            return r;
        }
//        if(start == last) {
//            List<Integer> pair = new ArrayList<>();
//            pair.add(origin[last]);
//            pair.add(origin[origin.length -1]);
//            List<List<Integer>> result = new ArrayList();
//            result.add(pair);
//            return result;
//        }
        Integer pre = origin[start];
        List<List<Integer>> subResult = getC(++start, origin, num - 1);
        for (List<Integer> p : subResult) {
            p.add(pre);
        }
        return subResult;
    }

    public static void main(String[] args) {
        CPermutation test = new CPermutation();
        int[] data = new int[]{1, 2, 3, 4, 5, 6, 7};
        test.calCPermutation(data, 3);
    }
}
