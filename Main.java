import java.util.Date;

public class Main {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("Байт-код DEX успешно скомпилирован и запущен!");
        System.out.println("Виртуальная машина: " + System.getProperty("java.vm.name"));
        System.out.println("Версия среды: " + System.getProperty("java.version"));
        System.out.println("Время запуска: " + new Date());
        System.out.println("========================================");

        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum += i;
        }

        System.out.println("Тестовый цикл (сумма чисел 1-10): " + sum);
        System.out.println("Полный порядок, скрипт отработал без сбоев.");
    }
}
