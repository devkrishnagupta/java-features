## PerformingTaskUsingMultipleThreadUsingFuture

<h2 id="dd37" class="my mz gg be na nb nc nd ne nf ng nh ni ml nj nk nl mp nm nn no mt np nq nr ns bj" data-selectable-paragraph="">Explanation:</h2>
<ol class=""><li id="177a" class="ma mb gg mc b md nt mf mg mh nu mj mk ml nv mn mo mp nw mr ms mt nx mv mw mx op of og bj" data-selectable-paragraph=""><strong class="mc gh">ExecutorService: </strong>An <code class="cw pk pl pm pn b">ExecutorService</code> is created to manage a pool of threads. The number of threads in the pool is determined by <code class="cw pk pl pm pn b">Runtime.getRuntime().availableProcessors()</code>, which typically matches the number of CPU cores available on the system. This allows for <strong class="mc gh">efficient CPU utilization</strong>.</li><li id="4338" class="ma mb gg mc b md oh mf mg mh oi mj mk ml oj mn mo mp ok mr ms mt ol mv mw mx op of og bj" data-selectable-paragraph=""><strong class="mc gh">List of Futures (</strong><code class="cw pk pl pm pn b"><strong class="mc gh">results</strong></code><strong class="mc gh">):</strong> A list of <code class="cw pk pl pm pn b">Future</code> objects is created to hold the results of the scraping tasks. <em class="pw">A </em><code class="cw pk pl pm pn b"><em class="pw">Future</em></code><em class="pw"> represents a result that may not be available yet but will be at some point in the future.</em></li><li id="6d99" class="ma mb gg mc b md oh mf mg mh oi mj mk ml oj mn mo mp ok mr ms mt ol mv mw mx op of og bj" data-selectable-paragraph=""><strong class="mc gh">Submitting Tasks: </strong>For each URL in <code class="cw pk pl pm pn b">urlsToScrape</code>, a scraping task is submitted to the <code class="cw pk pl pm pn b">ExecutorService</code> using <code class="cw pk pl pm pn b">executor.submit()</code>. The scraping task is represented as a lambda expression that calls <code class="cw pk pl pm pn b">scrapeDataFromUrl(url)</code>.</li><li id="c864" class="ma mb gg mc b md oh mf mg mh oi mj mk ml oj mn mo mp ok mr ms mt ol mv mw mx op of og bj" data-selectable-paragraph=""><strong class="mc gh">Processing Results:</strong> After submitting all tasks, we loop through the list of <code class="cw pk pl pm pn b">Future</code> objects in <code class="cw pk pl pm pn b">results</code>. The <code class="cw pk pl pm pn b">result.get()</code> method is used to retrieve the scraped data. This method will block until the result is available. Once the result is obtained, you can process the scraped data.</li><li id="2d1a" class="ma mb gg mc b md oh mf mg mh oi mj mk ml oj mn mo mp ok mr ms mt ol mv mw mx op of og bj" data-selectable-paragraph=""><strong class="mc gh">Executor Shutdown: </strong>Finally, the <code class="cw pk pl pm pn b">executor.shutdown()</code> method is called to shut down the <code class="cw pk pl pm pn b">ExecutorService</code> after all tasks are completed.</li></ol>
<p id="b1e7" class="pw-post-body-paragraph ma mb gg mc b md nt mf mg mh nu mj mk ml nv mn mo mp nw mr ms mt nx mv mw mx fk bj" data-selectable-paragraph=""><code class="cw pk pl pm pn b">Future</code> is used here to represent the result of each scraping task. The key advantages of using <code class="cw pk pl pm pn b">Future</code> in this context are:</p>
<ul class=""><li id="74b0" class="ma mb gg mc b md me mf mg mh mi mj mk ml mm mn mo mp mq mr ms mt mu mv mw mx oe of og bj" data-selectable-paragraph=""><strong class="mc gh">Concurrency Control:</strong> <code class="cw pk pl pm pn b">Future</code> allows you to<strong class="mc gh"> submit tasks concurrently and collect their results in a coordinated manner</strong>. It helps manage the concurrency of multiple tasks.</li><li id="f618" class="ma mb gg mc b md oh mf mg mh oi mj mk ml oj mn mo mp ok mr ms mt ol mv mw mx oe of og bj" data-selectable-paragraph=""><strong class="mc gh">Asynchronous Execution:</strong> By using <code class="cw pk pl pm pn b">Future</code>, you can <strong class="mc gh">submit tasks and continue with other operations without blocking for the results. </strong>Later, when you need the results, you can call <code class="cw pk pl pm pn b">get()</code> to retrieve them, potentially allowing for more efficient use of CPU time.</li><li id="cd89" class="ma mb gg mc b md oh mf mg mh oi mj mk ml oj mn mo mp ok mr ms mt ol mv mw mx oe of og bj" data-selectable-paragraph=""><strong class="mc gh">Exception Handling:</strong> The <code class="cw pk pl pm pn b">Future</code> allows you to handle exceptions that might occur during task execution. When you call <code class="cw pk pl pm pn b">get()</code>, it can throw an exception if the underlying task fails, allowing for proper error handling.</li></ul>