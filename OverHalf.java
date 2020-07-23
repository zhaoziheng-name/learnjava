package java_0723;

import java.util.HashMap;
import java.util.Map;

public class OverHalf {
    public int MoreThanHalfNum(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                int count = map.get(array[i]);
                count++;
                map.put(array[i], count);
            } else {
                map.put(array[i], 1);
            }
            if (map.get(array[i]) > array.length / 2) {
                return array[i];
            }
        }
        return 0;
    }
}
