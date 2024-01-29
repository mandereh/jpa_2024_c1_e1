package org.example.entities.generators;/*
 *
 *Created by phron on 1/28/2024
 *
 */

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.util.UUID;

public class UUIDGenerator implements IdentifierGenerator {
    @Override
    public Object generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) {
        return UUID.randomUUID().toString();
    }
}
