// Object Pool Design Pattern:
// A creational design pattern that manages a pool of reusable objects.
// Instead of creating and destroying objects repeatedly, it reuses existing ones,
// improving performance and resource utilization.
// Clients request an object from the pool and return it after use.


// Object Pool Pattern is used when object creation is expensive (e.g., DB connections).
// It maintains a pool of pre-created objects and hands them out on demand.

import java.util.*;

// Resource - Reusable Object
class DBConnection {

    public DBConnection() {

    }
}

// Object Pool - Singleton Implementation
class DBConnectionPoolManager {

    // Singleton (volatile is IMPORTANT for double-checked locking)
    private static volatile DBConnectionPoolManager dbConnectionPoolManagerInstance = null;

    List<DBConnection> freeConnections = new ArrayList<>();
    List<DBConnection> inUseConnections = new ArrayList<>();
    int INITIAL_POOL_SIZE = 3;
    int MAX_POOL_SIZE = 6;

    // private constructor
    private DBConnectionPoolManager() {
        for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
            freeConnections.add(new DBConnection());
        }
    }

    // Singleton - thread-safe double-checked locking
    public static DBConnectionPoolManager getInstance() {
        if (dbConnectionPoolManagerInstance == null) {
            synchronized (DBConnectionPoolManager.class) {
                if (dbConnectionPoolManagerInstance == null) {
                    dbConnectionPoolManagerInstance = new DBConnectionPoolManager();
                }
            }
        }
        return dbConnectionPoolManagerInstance;
    }

    public synchronized DBConnection getDBConnection() {
        DBConnection dbConnection = null;

        if (freeConnections.isEmpty() && inUseConnections.size() < MAX_POOL_SIZE) {
            freeConnections.add(new DBConnection());
        } 
        else if (freeConnections.isEmpty() && inUseConnections.size() == MAX_POOL_SIZE) {
            System.out.println("Pool is full. Cannot create new DBConnection.");
            return null;
        }

        dbConnection = freeConnections.remove(freeConnections.size() - 1);
        inUseConnections.add(dbConnection);

        return dbConnection;
    }

    public synchronized void releaseDBConnection(DBConnection dbConnection) {
        if (dbConnection != null) {
            inUseConnections.remove(dbConnection);
            freeConnections.add(dbConnection);
        }
    }
}

// Main Class
public class ObjectPoolPattern {
    public static void main(String[] args) {

        DBConnectionPoolManager poolManager = DBConnectionPoolManager.getInstance();

        DBConnection dbConnection1 = poolManager.getDBConnection();
        DBConnection dbConnection2 = poolManager.getDBConnection();
        DBConnection dbConnection3 = poolManager.getDBConnection();
        DBConnection dbConnection4 = poolManager.getDBConnection();
        DBConnection dbConnection5 = poolManager.getDBConnection();
        DBConnection dbConnection6 = poolManager.getDBConnection();

        DBConnection nullDBConnection = poolManager.getDBConnection();
        System.out.println(nullDBConnection == null ? "POOL FULL" : "NOT NULL");

        poolManager.releaseDBConnection(dbConnection6);

        DBConnection dbConnection7 = poolManager.getDBConnection();

        DBConnectionPoolManager poolManager2 = DBConnectionPoolManager.getInstance();
        System.out.println(poolManager == poolManager2 ? "Same instance" : "Different instance");
    }
}