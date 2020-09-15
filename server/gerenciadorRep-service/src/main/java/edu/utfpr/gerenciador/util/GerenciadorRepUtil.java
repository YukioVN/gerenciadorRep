package edu.utfpr.gerenciador.util;

import java.util.concurrent.atomic.AtomicLong;

public class GerenciadorRepUtil {

    private static final AtomicLong incremento = new AtomicLong();

    public static long novoId(){
        return incremento.incrementAndGet();
    }

}
