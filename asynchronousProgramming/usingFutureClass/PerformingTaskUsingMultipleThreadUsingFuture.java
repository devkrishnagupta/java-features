package asynchronousProgramming.usingFutureClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PerformingTaskUsingMultipleThreadUsingFuture {
    
    public static void main(String[] args) throws MalformedURLException {
        
        //populate the list with URLs to scrape
        List<URL> urlsToScrape = new ArrayList<>();
        urlsToScrape.add(new URL("https://dip-mazumder.medium.com/mastering-concurrency-1"));
        urlsToScrape.add(new URL("https://dip-mazumder.medium.com/mastering-concurrency-2"));
        urlsToScrape.add(new URL("https://dip-mazumder.medium.com/mastering-concurrency-3"));
        urlsToScrape.add(new URL("https://dip-mazumder.medium.com/mastering-concurrency-4"));
        urlsToScrape.add(new URL("https://dip-mazumder.medium.com/mastering-concurrency-5"));

        int numThreads = Runtime.getRuntime().availableProcessors();
        System.out.println("Total available threads: "+numThreads);
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

        List<Future<String>> futureResults = new ArrayList<>();
        for(URL url: urlsToScrape){
            // Future<String> future = executorService.submit(() -> scrapeDataFromUrl(url));// V. V. I.
            Future<String> future = executorService.submit(new Task(url));
            futureResults.add(future);
        }

        List<String> finalScrapedList = new ArrayList<>();
        //process the result
        for(Future<String> futureResult: futureResults){
            try{
                System.out.println("Is Task completed Before Get: "+futureResult.isDone());
                String data = futureResult.get();//Here is block the main thread
                finalScrapedList.add(data);
                //processed the scrape data
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
        System.out.println("Final scraped Urls:");
        finalScrapedList.forEach((key)->{
            System.out.println(key);
        });

        executorService.shutdown();
    }

    // private static String scrapeDataFromUrl(URL url) {
    //     return "Scrape data from "+url.toString() + " By Thread: "+Thread.currentThread().getName();
    // }
}

class Task implements Callable<String>{
    
    private URL url;

    public Task(URL url){
        this.url=url;
    }

    @Override
    public String call() throws Exception {
        return "Scrape data from "+url.toString() + " By Thread: "+Thread.currentThread().getName();
    }
}
