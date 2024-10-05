package org.example;

import java.time.OffsetDateTime;

/**
 * Можно изменять по своему усмотрению, не нарушая правила приоритезации очереди
 */

public class Ticket {

    /**
     * Автогенерация id
     */
    int id;
    private static int idSeq;

    /**
     * Приоритеты типов:
     * 1) pension
     * 2) любые другие
     */
    String type;

    /**
     * Приоритет для ранней регистрации
     */
    OffsetDateTime registerTime;

    public Ticket(String type) {
        this.type = type;
        this.registerTime = OffsetDateTime.now();
        this.id = idSeq++;
    }
}
