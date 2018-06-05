public class TimeIt {
    public static void code(Runnable block) {
        long start = System.nanoTime();
        try {
            block.run();
        } finally {
            long end = System.nanoTime();
            System.out.printf("Time taken(s): %s\n", convertNanosToFormattedTime((end - start) / 1_000_000));
        }
    }

    private static String convertNanosToFormattedTime(long millis){
        long seconds = (long)(millis / 1000.0) % 60;
        long minutes = (long)(millis / (1000 * 60)) % 60;
        long hours = (long)(millis / (1000 * 60 * 60)) % 24;

        return String.format("%02d:%02d:%02d.%03d", hours, minutes, seconds, millis % 1000);
    }
}
