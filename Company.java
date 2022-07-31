package ProducerConsumerCompany;

public class Company {
    int n;
    Boolean box = false;

    synchronized public void produce_item(int n) throws InterruptedException {

        if (box) {
            wait();
        }
        this.n = n;
        System.out.println("Produced item " + this.n);
        box = true;
        notify();

    }

    synchronized public int consume_item() throws InterruptedException {

        if (!box) {
            wait();
        }
        System.out.println("Consumed item " + this.n);
        box = false;
        notify();
        return this.n;
    }
}
