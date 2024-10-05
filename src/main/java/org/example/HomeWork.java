package org.example;

import java.util.*;


public class HomeWork {

    /**
     * <h1>Задание 1.</h1>
     * Требуется реализовать интерфейс TicketManager в соответствии с JavaDoc описанием.
     * Реализации очередей из стандартной библиотеки не используем.
     */
    public TicketManager managerFabric() {
        return new TicketManagerImpl();
    }


    /**
     * Задача со звездочкой (опционально)
     * <br/>
     * На вход строки:
     * номер_впереди : номер_сзади
     * Если впереди или сзади никого нет - то 0, для первого и последнего в очереди.
     * На выход нужно восстановить порядок номеров в очереди.
     * <p>
     * В тестах генератор тестовых данных (очереди и пары).
     *
     * @see <a href="https://codeforces.com/problemset/problem/490/B?locale=ru">https://codeforces.com/problemset/problem/490/B?locale=ru</a>
     */


    public List<Integer> check(List<String> records) {
        Integer[] list = new Integer[records.size()];
        for (String record : records) {
            String[] arr = record.split(":");
            var first = Integer.parseInt(arr[0]);
            var second = Integer.parseInt(arr[1]);
            if(first==0){
                list[1] =second;
            }
            else if(second==0){
                list[records.size()-2] = first;
            }
            else{

            }
//если first=0 то second надо ставить list[1]
//если second=0 то first надо ставить  list[size-2]
            //номер_впереди X номер_сзади
            //92 7 31 43 141 21

            //0 X 7 list[1]
            //141 X 0

            //92 X 31
            //43 X 21
            //7 X 43 list[3]
            //31 X 141

            //92
            //7*
            //31
            //43
            //141*
            //21


        }
        return null;
    }

}
