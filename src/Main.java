import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        WineBarrelGame game = new WineBarrelGame(10);
        Scanner scanner = new Scanner(System.in);

        while (!game.isGameOver()) {
            // 顯示剩餘可選位置
            System.out.print("可選位置：");
            int[] available = game.getAvailablePositions();
            for (int i = 0; i < available.length; i++) {
                System.out.print(available[i]);
                if (i < available.length - 1) System.out.print(", ");
            }
            System.out.println();

            // 輸入
            System.out.print("請輸入位置：");
            int input = scanner.nextInt();

            // 檢查是否合法
            if (!game.isValid(input)) {
                System.out.println("錯誤：超出範圍或重複，請重新輸入！");
                continue;
            }

            // 插刀並判斷生死
            boolean isDead = game.insertKnife(input);
            if (isDead) {
                System.out.println("你死了！");
            } else {
                System.out.println("好險，安全！");
            }
        }

        // 結果
        if (game.isSuccess()) {
            System.out.println("過關！");
        } else {
            System.out.println("失敗！");
        }
        System.out.println("本次死亡位置在：" + game.getDeathPosition());
    }
}
