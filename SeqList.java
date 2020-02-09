public class SeqList {
    private int[] datas = new int[100];
    private int size = 0;

    // 获取长度
    public int getSize() {
        return size;
    }

    // 打印顺序表
    public void display() {
        String result = "[";
        for (int i = 0; i < size; i++) {
            result += datas[i];
            if(i < size - 1) {
                result += ",";
            }
        }
        result += "]";
        System.out.println(result);
    }

    // 在pos位置新增元素(下标)
    public void add(int pos, int data) {
        // 判定pos是否有效
        if(pos < 0 || pos > size) {
            return;
        }

        // 扩容
        if(size >= datas.length) {
            int[] newDatas = new int[2 * datas.length];
            for (int i = 0; i < datas.length; i++) {
                newDatas[i] = datas[i];
            }
            datas = newDatas;
        }

        // 1.尾插
        if(pos == size) {
            datas[pos] = data;
            size++;
            return;
        }

        // 2.普通位置插入
        for (int i = size - 1; i >= pos; i--) {
            datas[i + 1] = datas[i];
        }
        datas[pos] = data;
        size++;
    }

    // 判定是否包含某个元素
    public boolean contains(int toFind) {
        // 循环访问每一个元素,和toFind比较
        // 相等就是找到了,返回true,反之没找到返回false
        for (int i = 0; i < size; i++) {
            if (datas[i] == toFind) {
                return true;
            }
        }
        return false;
    }

    // 查找某个元素对应的位置
    public int search(int toFind) {
        for (int i = 0; i < size; i++) {
            if(datas[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    // 获取pos位置的元素
    public int getPos(int pos) {
        return datas[pos];
    }

    // 给pos位置的元素设为value
    public void setPos(int pos, int value) {
        datas[pos] = value;
    }

    // 删除第一次出现的关键字key
    // toRove表示要删除的元素
    public void remove(int toRemove) {
        int pos = search(toRemove);
        // 要删除的元素不存在
        if(pos == -1) {
            return;
        }
        // 要删除的是最后一个
        if (pos == size - 1) {
            size--;
            return;
        }
        // 中间元素
        for (int i = pos; i < size - 1; i++) {
            datas[i] = datas[i + 1];
        }
        size--;
    }

    // 清空顺序表
    public void clear() {
        size = 0;
    }
}