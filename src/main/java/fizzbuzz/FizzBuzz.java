package fizzbuzz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

/**
 * Условия задачи
 * 1. Есть числа [1;100]
 * 2. Если число делится на 3 - вывести Fizz
 * 3. Если число делится на 5 - вывести Buzz
 * 4. Если число делится на 3 и 5 - вывести FizzBuzz
 * 5. В противном случае все равно, что вывести
 * <p>
 * Время написания кода(цикл + if структура) - 2 мин 26 сек
 */

public class FizzBuzz {
    private static HashMap<Integer, String> loadedFromFile = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Привет мир!");
        for (int i = 1; i < 101; i++) {
            if ((i % 3 == 0) && (i % 5 == 0))
                System.out.println(i + ". FizzBuzz");
            else if (i % 3 == 0)
                System.out.println(i + ". Fizz");
            else if (i % 5 == 0)
                System.out.println(i + ". Buzz");
            else
                System.out.println(i + ".");
        }

        System.out.println("=== Проверим себя по своему файлу :-)");
        String pathToFile = "D:\\Projects\\Java\\SimpleSelenideMaven\\src\\main\\java\\fizzbuzz\\check.csv";
        selfCheckerFromFile(pathToFile);
    }

    /**
     * Проверим метод и файл с тем, как я внес результаты
     * @param pathToFile путь к файлу
     */
    private static void selfCheckerFromFile(String pathToFile) {
        boolean result = true;
        try {
            String expectedResult, observedResult;
            // загрузим файл
            if (loadFileToHashMap(pathToFile)) {
                // подопрем что 100 пар
                if (loadedFromFile.size() != 100) {
                    System.out.println("!!! в ожидаемых результатах не 100 значений! А " + loadedFromFile.size());
                    System.exit(1);
                }
                // и пойдем сравним
                for (int i = 1; i < 101; i++) {
                    expectedResult = loadedFromFile.get(i);
                    observedResult = getFizzBuzz(i);
                    if (!observedResult.equalsIgnoreCase("error")) {
                        if (!expectedResult.equalsIgnoreCase(observedResult)) {
                            System.out.println("!!! Несовпадение ожидаемого результата и возвращенного методом!");
                            System.out.println("!!! i = " + i + "; fromFile = " + expectedResult + "; fromMethod = " + observedResult);
                            result = false;
                        }
                    } else {
                        // откуда то ошибка вылезла, можно тормознуться
                        System.exit(1);
                    }
                }
                if (result) {
                    System.out.println("Не промахнулся Акелла :-)");
                } else {
                    System.out.println("Акелла промахнулся, Акелла промахнулся :-(");
                }
            } else {
                System.out.println("!!! Что то пошло не так при загрузке файла");
            }
        } catch (
                Exception e)

        {
            System.out.println("!!! Что то пошло не так в методе selfCheckerFromFile");
            System.out.println(e.toString());
            e.printStackTrace();
        }

    }

    /**
     * Метод возвращения Fizz, Buzz, FizzBuzz или ничего
     *
     * @param i число (int)
     * @return в зависимости от того, делится ли число на 3, 5 или (3 и 5), в противном случае null, error при ошибке
     */
    private static String getFizzBuzz(int i) {
        try {
            if ((i % 3 == 0) && (i % 5 == 0))
                return "FizzBuzz";
            else if (i % 3 == 0)
                return "Fizz";
            else if (i % 5 == 0)
                return "Buzz";
            else
                return "none";
        } catch (Exception e) {
            System.out.println("!!! Что то пошло не так в методе getFizzBuzz");// хотя что может пойти не так...
            System.out.println(e.toString());
            e.printStackTrace();
            return "Error";
        }

    }

    /**
     * Метод загружающий из файла эталонные пары цифра-значение
     *
     * @param pathToFile путь к файлу
     * @return true если загрузили файл в структуру, false при неудаче
     */
    private static boolean loadFileToHashMap(String pathToFile) {
        // TODO надо как то поаккуратней читать и загружать в хешмап, есть много чего в файл понапихать левого
        try {
            BufferedReader br = new BufferedReader(new FileReader(pathToFile));
            String line;
            String str[];
            while ((line = br.readLine()) != null) {
                str = line.split(";");
                loadedFromFile.put(Integer.parseInt(str[0]), str[1]);
            }
            return true;
        } catch (Exception e) {
            System.out.println("!!! Что то пошло не так в методе loadFileToHashMap");
            System.out.println(e.toString());
            e.printStackTrace();
            return false;
        }
    }

}
