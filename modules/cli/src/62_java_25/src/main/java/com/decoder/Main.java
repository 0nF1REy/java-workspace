//import javax.sql.ConnectionPoolDataSource;
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.DriverManager;

import module java.sql;

import static java.lang.IO.println;


void main() {
    println("Hello, World! Java 25!");

//    Connection conn = DriverManager.getConnection("jdbc:h2:mem:test");
//    System.out.println("Conexão criada (java.sql): " + (conn != null));
//
//    ConnectionPoolDataSource ds = new org.h2.jdbcx.JdbcDataSource();
//    DataSource dataSource = (DataSource) ds;
//    System.out.println("Datasource criado (javax.sql): " + dataSource);

    Object obj1 = 42;
    if (obj1 instanceof int i) {
        println("É um int: " + i);
    }

    Object obj2 = 3.14;
    switch (obj2) {
        case int i     -> println("Inteiro primitivo: " + i);
        case double d  -> println("Double primitivo: " + d);
        case boolean b -> println("Boolean primitivo: " + b);
        default        -> println("Outro tipo");
    }

    switch (getStatus()) {
        case 0 -> println("OK");
        case 1 -> println("Warning");
        case 2 -> println("Error");
        case int i when i >= 10 -> println("Fatal: " + i);
        case int i -> println("Unknown Status: " + i);
    }
}

public int getStatus(){
    return 12;
}
