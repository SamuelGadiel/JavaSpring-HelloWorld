package br.com.samuel.helloworld.infrastructure.persistence;

import br.com.zydon.commons.domain.AggregateRoot;
import br.com.zydon.commons.infrastructure.persistence.AggregateEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.Instant;

import static lombok.AccessLevel.PROTECTED;

@MappedSuperclass
@Getter @Setter @Accessors(chain = true)
@NoArgsConstructor @AllArgsConstructor(access = PROTECTED)
public abstract class AuditableJpaEntity<T extends AggregateRoot> extends AggregateEntity<T> {

    @Column(name = "created_at", nullable = false, columnDefinition = "timestamp with time zone")
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false, columnDefinition = "timestamp with time zone")
    private Instant updatedAt;

}
