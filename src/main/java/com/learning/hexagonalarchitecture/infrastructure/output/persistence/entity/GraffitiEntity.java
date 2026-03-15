package com.learning.hexagonalarchitecture.infrastructure.output.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

@Entity
@Table(name = "graffities")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GraffitiEntity {
    @Id
    private UUID id;

    @Column(nullable = false)
    private String name;
    private String description;
    private String location;
    private Collection<String> painters;
    private Boolean forSale;

    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private Map<String, String> attributes;
}
