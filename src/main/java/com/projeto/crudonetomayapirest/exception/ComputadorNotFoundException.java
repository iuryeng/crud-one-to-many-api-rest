package com.projeto.crudonetomayapirest.exception;

import java.text.MessageFormat;

public class ComputadorNotFoundException extends  RuntimeException{

    public ComputadorNotFoundException(final Long id) {
        super(MessageFormat.format("não é possível econtrar o computador com o id:", id));
    }
}
