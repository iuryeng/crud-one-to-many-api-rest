package com.projeto.crudonetomayapirest.exception;

import java.text.MessageFormat;

public class ColaboradorNotFoundException extends  RuntimeException{
    public ColaboradorNotFoundException(Long id) {
        super(MessageFormat.format("não é possível econtrar o colaborador com o id:", id));
    }
}
