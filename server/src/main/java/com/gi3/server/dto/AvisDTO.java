package com.gi3.server.dto;

import lombok.Data;

/**
 * @author kadarH
 */

@Data
public class AvisDTO {
    private String message;
    private String enseignant;
    private String groupe;
    private String niveau;
    private String filiere;
    private byte[] doc;
    private String date;
}
