package com.lupinemoon.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "sys_authority", schema = "auth")
@Data
@EqualsAndHashCode(callSuper = false)
public class SysAuthority extends AbstractAuditingEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Size(max = 255)
    @Column
    private String name;

    @Size(max = 255)
    @Column
    private String value;
}