package java8.lambdas;

/**
 * Enables functional programming
 *  -readable and concise code
 *  -easier to use APIs and libraries
 *  -enables support for parallel processing
 */
public class Lambdas {

    public static class HelloWorldPerformance implements Performance {
        @Override
        public void perform(final String who) {
            System.out.println("Hello World! " + who);
        }
    }


    public static void main(String[] args) {
        Performance hello = new HelloWorldPerformance();
        Performance helloLambda = (s) -> System.out.println("Hello Lambda!" + s);

        Performer performer = new Performer();
        performer.perform(hello);
        performer.perform(helloLambda);
        performer.perform((s) -> System.out.println("inline Hello"));
    }
}
