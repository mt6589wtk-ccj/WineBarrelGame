import java.util.*;

public class WineBarrelGame {
    private boolean[] bucket;
    private boolean[] knifes;
    private int deathPosition;
    private int count;
    private boolean success;

    public WineBarrelGame(int size) {
        bucket = new boolean[size];
        knifes = new boolean[size];
        deathPosition = new Random().nextInt(size);
        bucket[deathPosition] = true;
        count = 0;
        success = true;
    }

    // 取得剩餘可選位置（回傳陣列）
    public int[] getAvailablePositions() {
        List<Integer> available = new ArrayList<>();
        for (int i = 0; i < knifes.length; i++) {
            if (!knifes[i]) available.add(i);
        }
        return available.stream().mapToInt(i -> i).toArray();
    }

    // 判斷輸入是否合法
    public boolean isValid(int input) {
        return input >= 0 && input < bucket.length && !knifes[input];
    }

    // 插入刀子，回傳是否死亡
    public boolean insertKnife(int input) {
        knifes[input] = true;
        boolean isDead = bucket[input];
        success = !isDead;
        count++;
        return isDead;
    }

    public boolean isSuccess() {
        return success;
    }

    public boolean isGameOver() {
        return !success || count >= 5;
    }

    public int getDeathPosition() {
        return deathPosition;
    }
}
