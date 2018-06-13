package com.lupinemoon.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table (name = "sys_role", schema = "auth")
@Data
@EqualsAndHashCode
public class SysRole extends AbstractAuditingEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private Long id;

    @Size(max = 255)
    @Column
    private String name;

    @Size(max = 255)
    @Column
    private String value;

    @JsonIgnore
    @ManyToMany(targetEntity = SysAuthority.class, fetch = FetchType.EAGER)
    @BatchSize(size = 20)
    private Set<SysAuthority> authorities = new HashSet<>();

}
