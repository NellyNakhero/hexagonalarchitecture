package com.learning.hexagonalarchitecture.domain.model;

import com.learning.hexagonalarchitecture.domain.exception.InvalidGrafittiException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Map;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Graffiti {
    private UUID id;
    private String name;
    private String description;
    private String location;
    private Collection<String> painters;
    private Boolean forSale;
    private Map<String, String> attributes;

    private Graffiti(String graffitiName,
                     Collection<String> graffitiPainters,
                     String description,
                     String location,
                     Boolean forSale,
                     Map<String, String> attributes
//                     String... graffitiAttributes, @TODO research the ...
                     ) {
        this.id = UUID.randomUUID();
        this.name = graffitiName;
        this.painters = graffitiPainters;
        this.description = description;
        this.location = location;
        this.forSale = forSale;
        this.attributes = attributes;
    }

    public static Graffiti createGraffiti(String name,
                                                   String description,
                                                   String location,
                                                   Collection<String> painters,
                                                   Boolean forSale,
                                                   Map<String, String> attributes) {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidGrafittiException("Graffiti name cannot be empty");
        }
        if (painters.isEmpty()) {
            throw new InvalidGrafittiException("Graffiti painters cannot be null");
        }

        return new Graffiti(name, painters, description, location, forSale, attributes);
    }


    public Graffiti updateGraffiti(String name,
                                                 String description,
                                                 String location,
                                                 Collection<String> painters,
                                                 Boolean forSale,
                                                 Map<String, String> attributes) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
        if (painters != null && !painters.isEmpty()) {
            this.painters = painters;
        }

        if (!attributes.isEmpty()) {
            this.attributes.putAll(attributes);
        }

        return this;
    }


    public Graffiti markForSale() {
        this.forSale = true;
        return this;
    }

    public Graffiti markNotForSale() {
        this.forSale = false;
        return this;
    }
}
