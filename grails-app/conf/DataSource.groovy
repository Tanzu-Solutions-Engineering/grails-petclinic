dataSource {
    pooled = true
    jmxExport = true
    driverClassName = "com.mysql.jdbc.Driver"
    dialect = org.hibernate.dialect.MySQL5InnoDBDialect
    uri = new URI(System.env.DATABASE_URL ?: "mysql://foo:bar@localhost")
    username = uri.userInfo ? uri.userInfo.split(":")[0] : ""
    password = uri.userInfo ? uri.userInfo.split(":")[1] : ""
    url = "jdbc:mysql://" + uri.host + uri.path
    dbCreate = "update"

    properties {
        dbProperties {
            autoReconnect = true
        }
    }
}