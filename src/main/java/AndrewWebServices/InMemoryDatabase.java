package AndrewWebServices;
import java.util.HashMap;
import java.util.Map;

public class InMemoryDatabase extends Database {
    private Map<String, Integer> userPasswords = new HashMap<>();

    public void addUser(String accountName, int password) {
        userPasswords.put(accountName, password);
    }

    @Override
    public int getPassword(String accountName) {
        return userPasswords.getOrDefault(accountName, -1);
    }
}