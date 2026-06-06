package com.lucasmanoel.bff_habitos.business.out;

public record HabitosDTORecordResponse(
        String nome,
        String descricao,
        Boolean status,
        String habitosID
) {
}
