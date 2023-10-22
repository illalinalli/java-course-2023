package edu.hw2;

public final class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    //void tryExecute(String command) {  }
    public void tryExecute(String command) {
        Connection connection = null;
        int attempts = 0;
        while (attempts < maxAttempts) {
            try {
                connection = manager.getConnection();
                connection.execute(command);
                return;
            } catch (ConnectionException e) {
                // повторяем ConnectionException
                attempts++;
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Exception e) {

                    }
                }
            }
        }

    }
}
