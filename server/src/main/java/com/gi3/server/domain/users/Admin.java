package com.gi3.server.domain.users;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;

/**
 * @author kadarH
 */

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Admin extends Utilisateur {

}
