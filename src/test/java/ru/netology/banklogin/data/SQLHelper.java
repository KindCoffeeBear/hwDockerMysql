package ru.netology.banklogin.data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLHelper {
    private SQLHelper() {

    }

    private static final QueryRunner QUERY_RUNNER = new QueryRunner();

    private static Connection getConn() throws SQLException {
        return DriverManager.getConnection(System.getProperty("db.url"), "app", "pass");
    }

    @SneakyThrows
    public static String getVerificationCode() {
        var codeSQL = "SELECT code FROM auth_codes order by created DESC Limit 1";
        var conn = getConn();
        System.out.println("asda");
        var code = QUERY_RUNNER.query(conn, codeSQL, new ScalarHandler<String>());
        return code;
    }

    @SneakyThrows
    public static void cleanDatabase() {
        var conn = getConn();
        QUERY_RUNNER.execute(conn, "DELETE FROM auth_codes");
        QUERY_RUNNER.execute(conn, "DELETE FROM card_transactions");
        QUERY_RUNNER.execute(conn, "DELETE FROM cards");
        QUERY_RUNNER.execute(conn, "DELETE FROM users");
    }

    @SneakyThrows
    public static void cleanAuthCodes() {
        var conn = getConn();
        QUERY_RUNNER.execute(conn, "DELETE FROM auth_codes");
    }
}

