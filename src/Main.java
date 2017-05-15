import java.util.*;

// This is a project to solve the following problem:
// Having all characters unknown values from 1 to 26 (upper case and symbols don't affect),
// given a string, we have to return the maximum possible value that could have

public class Main {

    public static void main(String[] args) {
        System.out.println(maxValue("ABbCcc"));
    }

    private static Integer maxValue(String string) {
        String s = string.toLowerCase();
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : s.toCharArray()) {
            Integer value;
            if (map.containsKey(c)) {
                value = map.get(c);
            } else {
                value = 0;
            }
            map.put(c, value + 1);
        }
        return translateFrequency(new ArrayList<>(map.values()));
    }

    private static Integer translateFrequency(List<Integer> values) {
        Integer maxValue = 0;
        Collections.sort(values);
        Collections.reverse(values);
        Integer value = 26;
        for (Integer index : values) {
            maxValue += value * index;
            value--;
        }
        return maxValue;
    }
}
