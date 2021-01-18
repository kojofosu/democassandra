package com.example.democassandra.config;

import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;

import java.net.InetSocketAddress;

@Configuration
public class FactoryBeanConfig extends AbstractCassandraConfiguration {
    @Value("${spring.data.cassandra.port}")
    private int port;

    @Value("${spring.data.cassandra.contact-points}")
    private String contactpoints;

    @Value("${spring.data.cassandra.keyspace}")
    private String keyspace;



    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    protected int getPort() {
        return port;
    }

    @Override
    protected String getContactPoints() {
        return contactpoints;
    }

    @Override
    protected String getKeyspaceName() {

        return keyspace;
    }

    CqlSession session = CqlSession.builder()
            .addContactPoint(new InetSocketAddress("127.0.0.1", 9042))
            .withLocalDatacenter("datacenter1")
            .withAuthCredentials("cassandra", "")
            .withKeyspace(keyspace)
            .build();
    CassandraOperations template = new CassandraTemplate(session);
}
