package br.com.rfapi.rendafamiliarapi.model.user.dto;

import lombok.Data;
import java.util.List;
import java.util.UUID;



@Data
public class CreateUserRoleDTO {

    private Long idUser;

    private List<Long> idsRoles;



}
