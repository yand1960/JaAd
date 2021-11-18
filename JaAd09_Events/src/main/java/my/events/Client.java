package my.events;

public class Client {

    public static void main(String[] args) {
        SlowCalcWithEvent calc = new SlowCalcWithEvent();
        calc.addProgressListener(percent -> {
            System.out.print("Done " + percent + "%\r");
        });
        var x = calc.plus(1,2);
        System.out.println(x);
    }

}
