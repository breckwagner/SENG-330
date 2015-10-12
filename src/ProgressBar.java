public class ProgressBar {

    private final int width;
    private String barStart = "[";
    private String barEnd = "]";
    private String arrowBody = "=";
    private String arrowEnd = ">";

    public ProgressBar(int width) {
        this.width = width;
    }

    public ProgressBar(int width, String barStart, String barEnd, String arrowBody,
            String arrowEnd) {
        this.barStart = barStart;
        this.barEnd = barEnd;
        this.arrowBody = arrowBody;
        this.arrowEnd = arrowEnd;
        this.width = width;
    }

    public void printProcessBar(int percent) {
        int processWidth = percent * width / 100;
        System.out.print("\r" + barStart);
        for (int i = 0; i < processWidth; i++) {
            System.out.print(arrowBody);
        }
        System.out.print(arrowEnd);
        for (int i = processWidth; i < width; i++) {
            System.out.print(" ");
        }
        System.out.print(barEnd + percent + "%");
    }
//////// MAIN ...... >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    public static void main(String[] args) throws InterruptedException {
        ProgressBar bar = new ProgressBar(50);
        for (int i = 0; i <= 50; i++) {
            Thread.sleep(100);
            bar.printProcessBar(2*i);
        }
        System.out.println();
    }

}