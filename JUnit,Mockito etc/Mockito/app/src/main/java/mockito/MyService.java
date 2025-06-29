package mockito;

public class MyService {
    private ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public String fetchData() {
        return api.getData();
    }

    public String fetchWithId(int id) {
        return api.fetchById(id);
    }

    public void logError() {
        api.log("error");
    }

    public void startJob() {
        api.log("Start");
    }

    public void performStepOne() {
        api.log("step1");
    }

    public void performStepTwo() {
        api.log("step2");
    }
}