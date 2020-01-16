public class AllInOne {
    private String threadLine;
    private int threadsCount = 5;
    private final Object obj = new Object();
    private volatile char threadChar;

    public AllInOne(String threadLine) {
        this.threadLine = threadLine;
        if (threadLine.length() > 0 ){
            threadChar = threadLine.charAt(0);
        }
    }

    public void run(int threadsCount) {
        this.threadsCount = threadsCount;
        run();
    }

    public void run() {
        int charCount = threadLine.length();

        for (int i = 0; i < charCount; i++) {
            int fixCharIndex = i;
            int fixCharNextIndex = (i+1)%charCount;

            new Thread(() -> {
                try {
                    for (int j = 0; j < threadsCount; j++) {
                        synchronized (obj) {
                            while (threadChar != threadLine.charAt(fixCharIndex)) {
                                obj.wait();
                            }
                            System.out.print(threadChar);
                            threadChar = threadLine.charAt(fixCharNextIndex);
                            obj.notifyAll();
                        }
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }).start();
        }
    }
}
