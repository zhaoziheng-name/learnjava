package java_0329;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class TestStackAndQueue {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        // 1. 先创建一个栈,栈中保存的是字符类型
        Stack<Character> stack = new Stack<>();
        // 2. 循环遍历字符串中的每个字符
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 3. 判定 c 是否是左括号,如果是,就入栈
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue; // 进入下次循环,取出下一个字符
            }
            // 如果发现当前字符不是左括号,并且此时栈为空,也是非法的,直接返回 false
            // 这种情况说明,前面没有合适的左括号和当前括号匹配
            if (stack.empty()) {
                return false;
            }
            // 4. 判定 c 是否是右括号,如果是右括号,就取出栈顶元素来对比
            char top = stack.pop();
            // 1. 合法情况 1
            if (top == '(' && c == ')') {
                continue;
            }
            // 2. 合法情况 2
            if (top == '[' && c == ']') {
                continue;
            }
            // 3. 合法情况3
            if (top == '{' && c == '}') {
                continue;
            }

            // 此处也可以用 map 来实现

//            if (map.get(top) == c) {
//                continue;
//            }
            // 除了上面三种合法情况,其他都是非法的
            return false;
        }
        // 遍历完字符串之后,还要判断是否是空栈
        if (stack.empty()) {
            return true;
        }
        return false;
    }
}
