package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HomeWorkTest {

    HomeWork homeWork = new HomeWork();

    @Test
    void managerFabric() {

        TicketManager ticketManager = homeWork.managerFabric();

        ticketManager.add(new Ticket("other"));//0
        ticketManager.add(new Ticket("pension"));//1
        ticketManager.add(new Ticket("other"));//2
        ticketManager.add(new Ticket("pension"));//3
        Assertions.assertEquals(ticketManager.next().id, 3);
        Assertions.assertEquals(ticketManager.next().id, 1);
        Assertions.assertEquals(ticketManager.next().id, 2);
        Assertions.assertEquals(ticketManager.next().id, 0);
        Assertions.assertNull(ticketManager.next());

        TicketManager ticketManager2 = homeWork.managerFabric();

        ticketManager2.add(new Ticket("other"));//4
        ticketManager2.add(new Ticket("other"));//5
        ticketManager2.add(new Ticket("other"));//6
        Assertions.assertEquals(ticketManager2.next().id, 6);
        Assertions.assertEquals(ticketManager2.next().id, 5);
        Assertions.assertEquals(ticketManager2.next().id, 4);

        TicketManager ticketManager3 = homeWork.managerFabric();

        ticketManager3.add(new Ticket("pension"));//7
        ticketManager3.add(new Ticket("pension"));//8
        ticketManager3.add(new Ticket("pension"));//9
        Assertions.assertEquals(ticketManager3.next().id, 9);
        Assertions.assertEquals(ticketManager3.next().id, 8);
        Assertions.assertEquals(ticketManager3.next().id, 7);
    }

    @Test
    void check() {
        List<Integer> expectedQueue = generateQueue(1, 4);
        List<String> pairs = generatePairs(expectedQueue);
        assertEquals(expectedQueue, homeWork.check(pairs));
    }

    private List<String> generatePairs(List<Integer> expectedQueue) {
        List<String> pairs = new ArrayList<>();
        Function<Integer, Integer> map = (x) -> (x < 0 || x >= expectedQueue.size()) ? 0 : expectedQueue.get(x);

        for (int i = 0;
             i < expectedQueue.size(); i++) {
            pairs.add(String.format("%d:%d", map.apply(i - 1), map.apply(i + 1)));
        }
        Collections.shuffle(pairs);
        return pairs;
    }

    private List<Integer> generateQueue(int seed, int length) {
        return new Random(seed)
                .ints(1, length * 100)
                .limit(length)
                .boxed()
                .collect(Collectors.toList());
    }

}