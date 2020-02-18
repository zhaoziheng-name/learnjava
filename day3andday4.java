package HomeWork;

public class day3andday4 {
    private float f = 1.0f;
    int m = 12;
    static int n = 1;
    String str = new String("hello");
    char[] ch = {'a', 'b'};
    public static void main(String[] args) {
        day3andday4 t = new day3andday4();
//        System.out.println(isPalindrome(10100));
//        test();
//        String arr1 = "abb";
//        String arr2 = "abcd";
//        System.out.println(canConstruct(arr1, arr2));
//        String s = "abcdefgh.ijk";
//        char result = s.charAt(8);
//        System.out.println(result);
//        String s = "My name is Bruce Lee!!!";
//        System.out.println(lengthOfLastWord(s));
//        int[] arr1 = {1, 2, 3, 0, 0, 0};
//        int[] arr2 = {2, 5, 6,};
//        merge(arr1, 3, arr2, 3);
        day3andday4 ex = new day3andday4();
        ex.change(ex.str, ex.ch);
        System.out.println(ex.str + " and ");
        System.out.println(ex.ch);
    }

    public void change(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'c';
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 用双指针,从前向后
        // 需要一个新的数组来存放nums1中的前m个元素
        int[] nums1_cpy = new int[m];
        System.arraycopy(nums1, 0, nums1_cpy, 0, m);
        // 设置两个指针
        int p1 = 0;
        int p2 = 0;
        // 设置新有序数组的指针
        int p = 0;
        // 比较nums1_cpy和nums2中的元素, 把较小的放入nums1
        while ((p1 < m) && (p2 < n)) {
            nums1[p++] = (nums1_cpy[p1] < nums2[p2]) ? nums1_cpy[p1++] : nums2[p2++];
        }
        if (p1 < m) {
            System.arraycopy(nums1_cpy, p1, nums1, p1 + p2, m + n - p1 - p2);
        }
        if (p2 < n) {
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
        }
    }

    public int lengthOfLastWord(String s) {
        // 排除特殊情况
        if(s == null || s.length() == 0) {
            return 0;
        }
        int num = 0;
        // 遍历 找到最后一个空格
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == ' ') {
                if(num == 0) {
                    continue;
                }
                // 找到空格就跳出循环
                break;
            }
            num++;
        }
        return num;
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }
        int[] box = new int[26];
        for(int i = 0; i < magazine.length(); i++) {
            box[magazine.charAt(i) - 'a']++;
        }
        for(int i = 0; i < ransomNote.length(); i++) {
            if(--box[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public void test() {
        int i = 7;
        int count = 0;
        do {
            System.out.println(--i);
            --i;
            count++;
        } while(i != 0);
        System.out.println(i);
        System.out.println(count);
    }

    public boolean isPalindrome(int x) {
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int i = 0;
        int sum = 0;
        for (i = x; i > 0; i /= 10) {
            sum = sum * 10 + i % 10;
        } if (sum == x) {
            return true;
        } else {
            return false;
        }
    }
}