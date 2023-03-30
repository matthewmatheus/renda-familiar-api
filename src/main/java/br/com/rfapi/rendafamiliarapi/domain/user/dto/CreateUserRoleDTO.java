package br.com.rfapi.rendafamiliarapi.domain.user.dto;

import lombok.Data;
import java.util.List;


@Data
public class CreateUserRoleDTO {

    private Long idUser;

    private List<Long> idsRoles;



}
