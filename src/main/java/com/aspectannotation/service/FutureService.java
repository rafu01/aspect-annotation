package com.aspectannotation.service;

import java.util.concurrent.*;

public class FutureService {
    public void futureMethods() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future futureString = executorService.submit(()->{
            try {
                Thread.sleep(2000); // Simulate long-running operation
                return "Result from asynchronous task";
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        if (futureString.isDone()) {
            var str = futureString.get();
            System.out.println(str);
        }

        executorService.shutdown();
    }

    public void completableFutureMethods() {

        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
                return "Work is done";
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });

        stringCompletableFuture
                .thenApply(String::toLowerCase)
                .whenComplete((result, err)-> {
                    if (err==null) {
                        throw new RuntimeException(err);
                    }
                    System.out.println(result);
                });
    }
}
