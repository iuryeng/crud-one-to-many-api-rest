package com.projeto.crudonetomayapirest.exception;

import java.text.MessageFormat;

public class ColaboradorNotFoundException extends  RuntimeException{

    public ColaboradorNotFoundException(final Long id) {
        super(MessageFormat.format("não é possível econtrar o colaborador com o id {0}:", id));
    }
}
