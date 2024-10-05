package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Обработчик талонов
 */
public class TicketManagerImpl implements TicketManager {
    private final List<Ticket> queue = new ArrayList<>();

    /**
     * Регистрация талона в очереди
     *
     * @param ticket
     */
    @Override
    public void add(Ticket ticket) {
        if (queue.isEmpty()) {
            queue.add(ticket);
        } else if (ticket.type.equals("pension")) {
            queue.add(0, ticket);
        } else {
            for (int i = 0; i < queue.size(); i++) {
                if (!queue.get(i).type.equals("pension")) {
                    queue.add(i, ticket);
                    break;
                }
            }

        }
    }

    /**
     * Получение следующего талона или null если очередь пуста
     * В первую очередь идут талоны с Ticket.type = "pension", далее все остальные.
     * Внутри групп ("pension" или остальные) упорядочиваем по времени регистрации Ticket.registerTime по возрастанию (FIFO)
     *
     * @return
     */
    @Override
    public Ticket next() {
        Ticket ticket = null;
        if (!queue.isEmpty()) {
            ticket = queue.get(0);
            queue.remove(0);
        }
        return ticket;
    }

}
