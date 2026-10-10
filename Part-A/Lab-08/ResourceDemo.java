class MyResource implements AutoCloseable {

    public MyResource() {
        System.out.println("Resource opened");
    }

    public void close() {
        System.out.println("Resource closed");
    }

    public void work() throws Exception {
        throw new Exception("Something went wrong");
    }
}

public class ResourceDemo {

    public static void main(String[] args) {

        try (MyResource resource = new MyResource()) {

            resource.work();

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());
        }
    }
}