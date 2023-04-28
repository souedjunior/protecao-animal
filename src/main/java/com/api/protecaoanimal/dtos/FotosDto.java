package com.api.protecaoanimal.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FotosDto {


    @NotBlank
    @Size(min = 5 ,message = "Campo imagem não pode ser menor que 5 caracteres")
    @Size(max = 255 ,message = "Campo imagem não pode ser maior que 255 caracteres")
    private String imagem;

    @Max( value = 2, message = "Campo ordem não pode ser maior que 2 caracteres")
    private int ordem;
    
}
