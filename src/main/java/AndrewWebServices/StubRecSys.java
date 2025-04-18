package AndrewWebServices;

public class StubRecSys extends RecSys {
    @Override
    public String getRecommendation(String accountName) {
        return "The Matrix";
    }
}
